package TowerDefense.gameLogic.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.Point;
import TowerDefense.Entities.API.Entity;
import TowerDefense.Entities.Impl.TowerSingleton;
import TowerDefense.gameLogic.API.GameLogic;

public class GameLogicImpl implements GameLogic{
    
    private static Map<Entity, List<Point>> entityPositions = new HashMap<>();
    
    public static Map<Entity, List<Point>> getPositions(){
        entityPositions.forEach((entity, pair) -> entity.updatePosition());
        return entityPositions;
    }

    public static boolean isGameEnd() {
        return (TowerSingleton.getInstance().getHp() > 0);
    }
}
