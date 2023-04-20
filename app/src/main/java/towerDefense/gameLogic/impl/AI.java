package towerDefense.gameLogic.impl;

import towerDefense.entities.api.Entity;
import towerDefense.entities.api.MovingEntity;
import towerDefense.entities.impl.TowerSingleton;

public class AI {

    public void useAI(){
        TowerSingleton tower = TowerSingleton.getInstance();
        MovingEntity entity;
        Entity target;
        MovingEntity ally;
        for(int i = 0; i< tower.getEntitiesNumber(); i++){
            entity = tower.getEntities().get(i);
            if(i != 0){
                ally = tower.getEntities().get( i - 1);
                if(!GameLogicImpl.checkCollision(entity, ally)){
                    entity.updatePosition();
                }else{
                    entity.updateSprite("Walk");
                }
            }else{
                if(tower.getEnemies().size() > 0){
                    target = tower.getEnemies().getFirst();
                    if(entity.getPosition().getX() < 800){
                        if(GameLogicImpl.checkCollision(entity, target)){
                            entity.attack(target);
                            entity.updateSprite("Attack");
                        }else{
                            entity.updatePosition();
                        }
                    }else{
                        if(GameLogicImpl.checkCollision(entity, target)){
                            entity.attack(target);
                            entity.updateSprite("Attack");
                        }else{
                            entity.updateSprite("Walk");
                        }
                    }
                }else{
                    if(entity.getPosition().getX() < 800){
                        entity.updatePosition();
                    }else{
                        entity.updateSprite("Walk");
                    }
                            
                }
            }
        }
        for(int i = 0; i< tower.getEnemies().size(); i++){
            entity = tower.getEnemies().get(i);
            if(i != 0){
                ally = tower.getEnemies().get( i - 1);
                if(!GameLogicImpl.checkCollision(entity, ally)){
                    entity.updatePosition();
                }else{
                    entity.updateSprite("Walk");
                }
            }else{
                if(tower.getEntitiesNumber() > 0){
                    target = tower.getEntities().getFirst();
                    if(GameLogicImpl.checkCollision(entity, target)){
                        entity.attack(target);
                        entity.updateSprite("Attack");
                        entity.attack(entity.getTarget(tower.getEntities()));
                    }else{
                        entity.updatePosition();
                    }
                }else{
                    target = TowerSingleton.getInstance();
                    if(GameLogicImpl.checkCollision(entity, target)){
                        entity.attack(target);
                        entity.updateSprite("Attack");
                    }else{
                        entity.updatePosition();
                    }
                }
            }
        }
    }
}
