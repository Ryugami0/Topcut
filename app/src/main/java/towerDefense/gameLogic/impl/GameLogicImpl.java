package towerDefense.gameLogic.impl;

import java.util.HashMap;
import java.util.Map;
import java.awt.Point;

import towerDefense.entities.api.Entity;
import towerDefense.entities.api.MovingEntity;
import towerDefense.gameLogic.api.GameLogic;

public class GameLogicImpl implements GameLogic{
    
    private static Map<MovingEntity, Point> entityPositions = new HashMap<>();
    
    public static Map<MovingEntity, Point> getPositions(){
        entityPositions.forEach((entity, point) -> entity.updatePosition());
        return entityPositions;
    }

    public static boolean checkCollision(MovingEntity a, Entity b){
        return a.getHitbox().intersects(b.getHitbox());
    }

}
