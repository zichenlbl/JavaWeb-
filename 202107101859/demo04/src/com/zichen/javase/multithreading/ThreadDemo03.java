package com.zichen.javase.multithreading;

/**
 * 获取线程名字和当前线程对象
 * @author zc
 * @date 2021-07-28 18:40
 */
public class ThreadDemo03 {

    public static void main(String[] args) {
        Thread thread = new MyThread1();
        // Thread-0
        System.out.println("线程的名字：" + thread.getName());
        Thread thread1 = new MyThread1();
        // Thread-1
        System.out.println("线程的名字：" + thread1.getName());
        // 设置线程的新名字
        thread.setName("myThread");
        System.out.println("线程新的名字：" + thread.getName());
        // 获取当前线程对象
        Thread currentThread = Thread.currentThread();
        System.out.println("main方法中的当前线程：" + currentThread.getName());
        // 启动线程
        thread.start();
        thread1.start();
    }

}

class MyThread1 extends Thread {
    @Override
    public void run() {
        System.out.println("分支线程...");
        // 获取当前线程对象
        // 当thread执行run(start)方法，那么这个当前线程就是thread
        // 当thread1执行run(start)方法，那么这个当前线程就是thread1
        Thread currentThread = Thread.currentThread();
        System.out.println("run方法中的当前线程：" + currentThread.getName());
    }
}
