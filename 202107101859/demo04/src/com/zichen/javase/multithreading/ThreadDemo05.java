package com.zichen.javase.multithreading;

/**
 * 合理终止线程的方法
 * @author zc
 * @date 2021-07-28 22:37
 */
public class ThreadDemo05 {

    public static void main(String[] args) {
        MyRunnable1 myRunnable1 = new MyRunnable1();
        Thread thread = new Thread(myRunnable1);
        thread.start();
        // main 线程休眠5秒后，结束 myRunnable1 线程
        sleep(5000);
        // 修改 结束线程
        myRunnable1.flag = false;
        System.out.println(Thread.currentThread().getName());
    }

    /**
     * 线程休眠
     * @param millis 休眠毫秒数
     */
    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class MyRunnable1 implements Runnable {

    /**
     * 终止线程的标记
     */
    boolean flag = true;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "---> start");
        for (int i = 0; i < 1000; i++) {
            if (flag) {
                try {
                    // 线程休眠
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "---> " + i);
            } else {
                // 保存数据并结束线程……
                return;
            }
        }
        System.out.println(Thread.currentThread().getName() + "---> end");
    }

}
