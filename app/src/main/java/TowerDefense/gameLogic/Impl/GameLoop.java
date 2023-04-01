package TowerDefense.gameLogic.Impl;
import java.awt.Point;
import java.time.Clock;
import java.util.Map;
import TowerDefense.Entities.API.MovingEntity;
import TowerDefense.Entities.Impl.TowerSingleton;

public class GameLoop implements Runnable{

    private Clock clock;
    private double previousTime = clock.millis();
    private final double FIXED_TIME = 1/60;
    
    @Override
    public void run() {
        while (TowerSingleton.getInstance().getHp() > 0) {
            double currentTime = clock.millis();
            double timeDifference = currentTime - previousTime;
            update(timeDifference);
            previousTime = currentTime;
        }
    }

    private void update(double timeDifference) {
        Map<MovingEntity, Point> entityPositions = GameLogicImpl.getPositions();
        //Draw.draw(entityPositions);
        try {
            this.wait((long)(FIXED_TIME - timeDifference));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}