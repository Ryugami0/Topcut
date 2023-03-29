package main.java.gameLogic.Impl;

import java.util.HashMap;
import java.util.Map;

import javafx.util.Pair;
import main.java.Entities.API.Entity;
import main.java.Entities.Impl.TowerSingleton;
import main.java.gameLogic.API.GameLogic;

public class GameLogicImpl implements GameLogic{
    
    private static Map<Entity, Pair<Integer, Integer>> entityPositions = new HashMap<>();
    
    public static Map<Entity, Pair<Integer, Integer>> getPositions(){
        entityPositions.forEach((entity, pair) -> entity.updatePosition());
        return entityPositions;
    }

    public static boolean isGameEnd() {
        return (TowerSingleton.getInstance().getHp() > 0);
    }
}
