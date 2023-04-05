package TowerDefense.gameLogic.Impl;

import java.util.HashMap;
import java.util.Map;
import java.awt.Point;
import TowerDefense.Entities.API.MovingEntity;
import TowerDefense.gameLogic.API.GameLogic;

public class GameLogicImpl implements GameLogic{
    
    private static Map<MovingEntity, Point> entityPositions = new HashMap<>();
    
    public static Map<MovingEntity, Point> getPositions(){
        entityPositions.forEach((entity, point) -> entity.updatePosition());
        return entityPositions;
    }

    public static boolean checkCollision(MovingEntity a, MovingEntity b){
        return a.getHitbox().intersects(b.getHitbox());
    }

}
