package com.zichen.javase.multithreading;

import java.util.ArrayList;

/**
 * wait 线程等待 notify 唤醒线程
 * 生产者和消费者模式
 * wait 和 notify 建立在线程同步的基础之上
 * wait 让当前线程进入等待，释放占有的对象锁
 * notify 唤醒一个等待（对象的）线程并使该线程开始执行，不会释放占有的对象锁
 * @author zc
 * @date 2021-08-02 20:04
 */
public class ThreadDemo12 {

    public static void main(String[] args) {
        final ArrayList<String> arrayList = new ArrayList<>();
        final Produce produce = new Produce(arrayList);
        final Consume consume = new Consume(arrayList);
        produce.start();
        consume.start();
    }

}

/**
 * 生产线程
 */
class Produce extends Thread {
    /**
     * 仓库
     */
    private final ArrayList<String> arrayList;

    public Produce(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public void run() {
        // 生产线程一直生产
        int i = 1;
        while (true) {
            synchronized (arrayList) {
                // 如果仓库产品少于5个就开始生产
                if (arrayList.size() < 5) {
                    arrayList.add((i) + "号产品");
                    System.out.println("生产" + i + "号产品，库存" + arrayList.size() + "件，开始售卖");
                    i++;
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    arrayList.notify();
                } else {
                    System.out.println("开始售卖，" + "库存" + arrayList.size() + "件");
                    try {
                        sleep(1000);
                        arrayList.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

/**
 * 消费线程
 */
class Consume extends Thread {
    /**
     * 仓库
     */
    private final ArrayList<String> arrayList;

    public Consume(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public void run() {
        // 消费线程一直消费
        while (true) {
            synchronized (arrayList) {
                // 仓库中有产品就消费
                if (arrayList.size() > 0) {
                    System.out.println("开始消费1件，库存" + arrayList.size() + "件");
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    arrayList.remove(0);
                    arrayList.notify();
                } else {
                    // 没有产品就等待生产
                    System.out.println("库存0件，暂停售卖");
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        arrayList.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
