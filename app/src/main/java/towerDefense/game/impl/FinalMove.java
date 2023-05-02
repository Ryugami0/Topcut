package towerDefense.game.impl;

import java.util.Timer;
import java.util.TimerTask;

public class FinalMove{

    private boolean isActive = false;
    Timer timer = new Timer();

    public boolean isActive() {
        return this.isActive;
    }

    public void trigger() {
        isActive = true;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                isActive = false;
            }    
        }, 15000);    
    }
        
}
