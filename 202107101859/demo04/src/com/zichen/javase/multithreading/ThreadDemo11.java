package com.zichen.javase.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 第三种实现线程的方式 JDK8新特性
 * @author zc
 * @date 2021-08-02 18:04
 */
public class ThreadDemo11 {

    public static void main(String[] args) {
        FutureTask<Object> futureTask = new FutureTask<>(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                System.out.println(Thread.currentThread().getName() + "---> 执行");
                // 模拟执行
                Thread.sleep(1000 * 3);
                System.out.println(Thread.currentThread().getName() + "---> 结束");
                // 线程执行结束后有返回值
                return 10;
            }
        });
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            // 获取 futureTask(Thread-0) 线程的返回值
            // main 线程要等 Thread-0 线程运行结束 此时 main 线程会阻塞
            Object o = futureTask.get();
            System.out.println("返回值：" + o);
            System.out.println("运行结束!");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

}
