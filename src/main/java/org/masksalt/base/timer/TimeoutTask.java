package org.masksalt.base.timer;

import java.util.TimerTask;

/**
 * User: shijingui
 * Date: 2016/10/24
 */
public class TimeoutTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("执行超时逻辑操作...");
    }
}
