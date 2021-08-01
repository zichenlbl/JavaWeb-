package com.zichen.javase.multithreading;

/**
 * 守护线程
 * @author zc
 * @date 2021-08-01 20:01
 */
public class ThreadDemo09 {

    public static void main(String[] args) {
        MyThread5 myThread5 = new MyThread5();
        // 将线程 Thread-0 设置为守护线程
        myThread5.setDaemon(true);
        myThread5.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "---> " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class MyThread5 extends Thread {
    @Override
    public void run() {
        int i = 0;
        // 即使是死循环 但由于 Thread-0 是守护线程 当用户线程 main 结束 守护线程自动终止
        while (true) {
            System.out.println(Thread.currentThread().getName() + "---> " + i++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
