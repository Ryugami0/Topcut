package towerDefense.gameLogic.impl;

import java.util.HashMap;
import java.util.Map;
import java.awt.Point;
import towerDefense.entities.api.Entity;
import towerDefense.entities.api.MovingEntity;
import towerDefense.entities.api.RangedEntity;

public class GameLogicImpl{
    
    private static Map<MovingEntity, Point> entityPositions = new HashMap<>();
    
    public static boolean checkCollision(MovingEntity a, Entity b){
        return a.getHitbox().intersects(b.getHitbox());
    }

    public static boolean checkRange(RangedEntity a, Entity b){
        return a.getRangeBox().intersects(b.getHitbox());
    }

}
