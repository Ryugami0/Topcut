package towerDefense.game.impl;

import java.util.Timer;
import java.util.TimerTask;

public class FinalMove {

    private boolean isActive = false;
    private Timer timer = new Timer();
    private final int DELAY = 15000;

    /**
     * @return  the current state of the class, whether if it's active or not
     */
    public boolean isActive() {
        return this.isActive;
    }

    /**
     * On call switches isActive state to true for {@value}DELAY milliseconds
     */
    public void trigger() {
        isActive = true;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                isActive = false;
            }    
        }, DELAY);    
    }
        
}
