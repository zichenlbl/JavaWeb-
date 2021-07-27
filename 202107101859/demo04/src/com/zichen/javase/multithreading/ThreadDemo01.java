package com.zichen.javase.multithreading;

/**
 * 实现线程的第一种方式
 * @author zc
 * @date 2021-07-27 21:48
 */
public class ThreadDemo01 {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        // 启动线程 瞬间启动完成后继续往下执行
        myThread.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("主线程--->" + i);
        }
    }

}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("分支线程--->" + i);
        }
    }
}
