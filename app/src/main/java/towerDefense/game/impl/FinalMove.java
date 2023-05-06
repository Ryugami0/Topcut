package towerDefense.game.impl;

import java.util.Timer;
import java.util.TimerTask;

import towerDefense.entities.impl.TowerSingleton;

public class FinalMove{

    private boolean isActive = false;
    Timer timer = new Timer();

    public boolean isActive() {
        return this.isActive;
    }

    public void trigger() {
        isActive = true;
        TowerSingleton.getInstance().removeMoney(80);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                isActive = false;
            }    
        }, 15000);    
    }
        
}
