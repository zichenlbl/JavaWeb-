package com.zichen.javase.multithreading;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 使用定时器指定定时任务 并把定时任务线程作为守护线程
 * @author zc
 * @date 2021-08-01 20:28
 */
public class ThreadDemo10 {

    public static void main(String[] args) {
        // 创建定时器对象
        // Timer timer = new Timer();
        // 设置成守护线程
        Timer timer = new Timer(true);
        // 创建定时器任务 指定定时任务 第一次执行时间 间隔时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            // 第一次执行时间
            Date parse = simpleDateFormat.parse("2021-08-01 20:30:00");
            timer.schedule(new MyTimerTask(), parse, 1000 * 10);
            // main 线程睡眠60秒后结束 守护线程定时器任务也随之结束
            Thread.sleep(1000 * 60);
        } catch (ParseException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class MyTimerTask extends TimerTask {
    @Override
    public void run() {
        // 编写需要执行的任务
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(new Date());
        System.out.println(format + "成功完成了定时任务");
    }
}
