package com.zichen.javase.multithreading;

/**
 * 线程的优先级
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
    }

}
