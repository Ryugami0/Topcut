package towerDefense.gameLogic.impl;

import towerDefense.Constants;
import towerDefense.entities.api.Entity;
import towerDefense.entities.api.MovingEntity;
import towerDefense.entities.api.RangedEntity;
import towerDefense.gameLogic.api.GameLogic;

public class GameLogicImpl implements GameLogic {
 
    /**
     * {@inheritDoc}
     */
    @Override
    public <X extends MovingEntity> boolean checkCollision(X a, Entity b){
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
