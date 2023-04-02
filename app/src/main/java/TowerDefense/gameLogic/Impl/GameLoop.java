package TowerDefense.gameLogic.Impl;
import java.awt.Point;
import java.lang.System;
import java.util.Map;
import TowerDefense.Entities.API.MovingEntity;
import TowerDefense.Entities.Impl.TowerSingleton;
import TowerDefense.Game.Game;

public class GameLoop extends Thread{

    private double previousTime = System.currentTimeMillis();
    private final double FIXED_TIME = 1/60;

    private Game game;

    public GameLoop(Game game) {
        this.game = game;
        this.run();
        
    }
    
    @Override
    public void run() {
        
        while (true) {
            //System.out.println("running");
            double currentTime = System.currentTimeMillis();
            double timeDifference = currentTime - previousTime;
            update(timeDifference);
            game.gamePanel.repaint();
            //System.out.println("repainted");
            previousTime = currentTime;
        }
    }

    private void update(double timeDifference) {
        game.gamePanel.update();

        try {
            GameLoop.sleep((long)(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}