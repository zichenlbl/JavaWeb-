package com.zichen.javase.multithreading;

/**
 * 线程合并
 * @author zc
 * @date 2021-07-30 22:43
 */
public class ThreadDemo07 {

    public static void main(String[] args) {
        System.out.println("main start");
        Thread thread = new Thread(new MyRunnable3());
        thread.start();
        try {
            // 合并线程 Thread-0 线程合并到 main 线程中，main 线程受阻塞，Thread-0 线程执行直到结束
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + "---> " + i);
        }
        System.out.println("main end");
    }

}

class MyRunnable3 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + "---> " + i);
        }
    }

}
