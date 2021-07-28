package com.zichen.javase.multithreading;

/**
 * 线程的睡眠和结束休眠
 * Thread.sleep(long millis) 让当前线程进入休眠
 * 这行代码出现在a线程中，a线程就会休眠
 * @author zc
 * @date 2021-07-28 20:26
 */
public class ThreadDemo04 {

    public static void main(String[] args) {
        Thread myThread2 = new MyThread2();
        myThread2.start();
        try {
            // 类实例访问静态方法 在main线程中调用，休眠的线程是main线程
            /*myThread2.sleep(5000);*/
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 终止线程的休眠 并打印异常信息
        myThread2.interrupt();
        // 强行终止一个线程的执行(已过时) 缺点：容易丢失数据 直接终止
        /*myThread2.stop();*/
        System.out.println(Thread.currentThread().getName());
    }

}

class MyThread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            // 每隔一秒输出一行
            // Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "--->" + i);
        }
        System.out.println(Thread.currentThread().getName() + "---> start");
        try {
            // 线程休眠
            Thread.sleep(1000 * 60 * 60 * 24);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "---> end");
    }
}
