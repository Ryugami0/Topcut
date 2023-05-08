package towerDefense.gameLogic.impl;

import java.util.HashMap;
import java.util.Map;
import java.awt.Point;

import towerDefense.Constants;
import towerDefense.entities.api.Entity;
import towerDefense.entities.api.MovingEntity;
import towerDefense.entities.api.RangedEntity;

public class GameLogicImpl{
    
    private static Map<MovingEntity, Point> entityPositions = new HashMap<>();
    
    public static Map<MovingEntity, Point> getPositions(){
        entityPositions.forEach((entity, point) -> entity.updatePosition());
        return entityPositions;
    }

    public static <X extends MovingEntity> boolean checkCollision(X a, Entity b){
        if((double)a.getSpeed()/(double)b.getSpeed() < 0){
            if(a.getNameEntity() == Constants.archer ||a.getNameEntity() == Constants.turret){
                return ((RangedEntity)a).getRangeBox().intersects(b.getHitbox());
            }
            return a.getHitbox().intersects(b.getHitbox());
        }else{
            return a.getHitbox().intersects(b.getHitbox());
        }
    }

}
