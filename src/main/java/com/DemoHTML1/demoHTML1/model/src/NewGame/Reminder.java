package com.DemoHTML1.demoHTML1.model.src.NewGame;

import java.util.Timer;
import java.util.TimerTask;

public class Reminder {
    Timer timer;

    public Reminder(int seconds) {
        timer = new Timer();
        timer.schedule(new RemindTask(), seconds*1000);
    }

    class RemindTask extends TimerTask {
        public void run() {
            System.out.println("GAME OVER !");
            timer.cancel();
        }
    }


}