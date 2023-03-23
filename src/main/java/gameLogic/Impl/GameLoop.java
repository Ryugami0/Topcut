package main.java.gameLogic.Impl;
import java.time.Clock;
import java.util.List;
import java.util.Map;
import javax.swing.tree.FixedHeightLayoutCache;
import javafx.util.Pair;
import main.java.Entities.API.Entity;
import main.java.gameLogic.API.GameLogic;

public class GameLoop implements Runnable{

    private Clock clock;
    private double previousTime = clock.millis();
    private final double FIXED_TIME = 1/60;
    
    @Override
    public void run() {
        while (true /*!GameLogic.isGameEnd()*/) {
            double currentTime = clock.millis();
            double timeDifference = currentTime - previousTime;
            //inputs
            update(timeDifference);
            //output
            previousTime = currentTime;
        }
    }

    private void update(double timeDifference) {
        Map<Entity, Pair<Integer, Integer>> entityPositions = GameLogicImpl.getNewPositions();
        //Draw.draw(entityPositions);
        try {
            this.wait((long)(FIXED_TIME - timeDifference));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}