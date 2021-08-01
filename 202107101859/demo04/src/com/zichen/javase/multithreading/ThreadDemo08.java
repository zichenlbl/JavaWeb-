package com.zichen.javase.multithreading;

/**
 * 死锁
 * @author zc
 * @date 2021-08-01 12:08
 */
public class ThreadDemo08 {

    public static void main(String[] args) {
        Object object = new Object();
        Object object1 = new Object();
        MyThread3 myThread3 = new MyThread3(object, object1);
        MyThread4 myThread4 = new MyThread4(object, object1);
        myThread3.start();
        myThread4.start();
    }

}

class MyThread3 extends Thread {
    private Object object;
    private Object object1;

    public MyThread3() {
    }

    public MyThread3(Object object, Object object1) {
        this.object = object;
        this.object1 = object1;
    }

    @Override
    public void run() {
        synchronized (object) {
            try {
                sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object1) {
            }
        }
    }
}

class MyThread4 extends Thread {
    private Object object;
    private Object object1;

    public MyThread4() {
    }

    public MyThread4(Object object, Object object1) {
        this.object = object;
        this.object1 = object1;
    }

    @Override
    public void run() {
        synchronized (object1) {
            try {
                sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object) {
            }
        }
    }
}

