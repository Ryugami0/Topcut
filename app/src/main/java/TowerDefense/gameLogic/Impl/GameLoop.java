package TowerDefense.gameLogic.Impl;
import java.awt.Point;
import java.lang.System;
import java.util.Map;
import TowerDefense.Entities.API.MovingEntity;
import TowerDefense.Entities.Impl.TowerSingleton;

public class GameLoop extends Thread{

    private double previousTime = System.currentTimeMillis();
    private final double FIXED_TIME = 1/60;

    public GameLoop() {
        this.run();
    }
    
    @Override
    public void run() {
        while (TowerSingleton.getInstance().getHp() > 0) {
            double currentTime = System.currentTimeMillis();
            double timeDifference = currentTime - previousTime;
            update(timeDifference);
            previousTime = currentTime;
        }
    }

    private void update(double timeDifference) {
        Map<MovingEntity, Point> entityPositions = GameLogicImpl.getPositions();
        //Draw.draw(entityPositions);
        try {
            GameLoop.sleep((long)(FIXED_TIME - timeDifference));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}