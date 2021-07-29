package com.zichen.javase.multithreading;

/**
 * 线程的优先级
 * 设置线程的优先级
 * 线程让位
 * @author zc
 * @date 2021-07-29 23:50
 */
public class ThreadDemo06 {

    public static void main(String[] args) {
        // 10
        System.out.println("线程的最高优先级：" + Thread.MAX_PRIORITY);
        // 5
        System.out.println("线程的默认优先级：" + Thread.NORM_PRIORITY);
        // 1
        System.out.println("线程的最低优先级：" + Thread.MIN_PRIORITY);
        // 获取当前线程
        Thread currentThread = Thread.currentThread();
        // 获取线程的优先级 5
        int priority = currentThread.getPriority();
        System.out.println(currentThread.getName() + "线程的默认优先级是：" + priority);
        // 设置 main 线程的优先级为 1
        currentThread.setPriority(1);
        // 创建新线程
        MyRunnable2 myRunnable2 = new MyRunnable2();
        Thread thread = new Thread(myRunnable2);
        // 设置 Thread-0 线程的优先级为 10
        // thread.setPriority(10);
        // 启动线程
        thread.start();
        // 线程优先级高的 只是抢到的 CPU 时间片多一些 处于运行状态的时间多一些
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + "---> " + i);
        }
    }

}

class MyRunnable2 implements Runnable {
    @Override
    public void run() {
        // 获取线程优先级 5
        System.out.println(Thread.currentThread().getName() + "线程当前的优先级是：" + Thread.currentThread().getPriority());
        for (int i = 0; i < 1000; i++) {
            // Thread-0 线程每输出到 ?99 时让给其它线程运行 但也会去抢 CPU 执行权
            if (i % 100 == 0) {
                // 线程让位 当前线程转为就绪状态(暂停一下) 让给其他线程
                Thread.yield();
            }
            System.out.println(Thread.currentThread().getName() + "---> " + i);
        }
    }
}
