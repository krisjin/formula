package org.strelitzia.base.timer;

import java.util.Timer;

/**
 * User: krisibm@163.com
 * Date: 2016/10/24
 */
public class TimerTest {

    public static void main(String[] args) {
        Timer timer = new Timer("定时任务");
        System.out.println("开始执行延时定时任务...");
        timer.schedule(new TimeoutTask(), 1);
    }
}
