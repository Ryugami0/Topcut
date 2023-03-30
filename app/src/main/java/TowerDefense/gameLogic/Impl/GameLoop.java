package TowerDefense.gameLogic.Impl;
import java.time.Clock;
import java.util.Map;
import javafx.util.Pair;
import TowerDefense.Entities.API.Entity;

public class GameLoop implements Runnable{

    private Clock clock;
    private double previousTime = clock.millis();
    private final double FIXED_TIME = 1/60;
    
    @Override
    public void run() {
        while (!GameLogicImpl.isGameEnd()) {
            double currentTime = clock.millis();
            double timeDifference = currentTime - previousTime;
            update(timeDifference);
            previousTime = currentTime;
        }
    }

    private void update(double timeDifference) {
        Map<Entity, Pair<Integer, Integer>> entityPositions = GameLogicImpl.getPositions();
        //Draw.draw(entityPositions);
        try {
            this.wait((long)(FIXED_TIME - timeDifference));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}