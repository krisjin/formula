package org.formula.base.timer;

import java.util.TimerTask;

/**
 * User: krisibm@163.com
 * Date: 2016/10/24
 */
public class TimeoutTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("执行超时逻辑操作...");
    }
}
