package towerDefense.gameLogic.impl;

import towerDefense.Constants;
import towerDefense.entities.api.Entity;
import towerDefense.entities.api.MovingEntity;
import towerDefense.entities.api.Projectile;
import towerDefense.entities.api.RangedEntity;
import towerDefense.entities.impl.TowerSingleton;
import towerDefense.entities.impl.Turret;

public class AI {

    public void useAI(){
        TowerSingleton tower = TowerSingleton.getInstance();
        MovingEntity entity;
        RangedEntity ranged;
        Entity target;
        MovingEntity ally;
        for(int i = 0; i< tower.getEntitiesNumber(); i++){
            entity = tower.getEntities().get(i);
            if(entity.getNameEntity() != Constants.archer){ 
                if(i != 0){
                    ally = tower.getEntities().get( i - 1);
                    if(!GameLogicImpl.checkCollision(entity, ally)){
                        entity.updatePosition();
                    }else{
                        entity.updateSprite(Constants.walk);
                    }
                }else{
                    if(tower.getEnemies().size() > 0){
                        target = tower.getEnemies().getFirst();
                        if(entity.getPosition().getX() < 800){
                            if(GameLogicImpl.checkCollision(entity, target)){
                                entity.attack(target);
                                entity.updateSprite(Constants.attack);
                            }else{
                                entity.updatePosition();
                            }
                        }else{
                            if(GameLogicImpl.checkCollision(entity, target)){
                                entity.attack(target);
                                entity.updateSprite(Constants.attack);
                            }else{
                                entity.updateSprite(Constants.walk);
                            }
                        }
                    }else{
                        if(entity.getPosition().getX() < 800){
                            entity.updatePosition();
                        }else{
                            entity.updateSprite(Constants.walk);
                        }
                                
                    }
                }
            }else{
                ranged = (RangedEntity)entity;
                if(i != 0){
                    ally = tower.getEntities().get( i - 1);
                    if(tower.getEnemies().size() > 0){
                        target = tower.getEnemies().getFirst();
                        if(GameLogicImpl.checkRange(ranged, target)){
                            ranged.attack(target);
                            ranged.updateSprite(Constants.attack);
                            if(!GameLogicImpl.checkCollision(ranged, ally)){
                                ranged.updatePosition();
                                ranged.updateRangeBox();
                            }
                        }else{
                            if(!GameLogicImpl.checkCollision(ranged, ally)){
                                ranged.updatePosition();
                                ranged.updateRangeBox();
                                ranged.updateSprite(Constants.walk);
                            }else{
                                ranged.updateSprite(Constants.walk);
                            }
                        }
                    }else{
                        if(!GameLogicImpl.checkCollision(ranged, ally)){
                            ranged.updatePosition();
                            ranged.updateRangeBox();
                            ranged.updateSprite(Constants.walk);
                        }else{
                            ranged.updateSprite(Constants.walk);
                        }
                    }
                    
                }else{
                    if(tower.getEnemies().size() > 0){
                        target = tower.getEnemies().getFirst();
                        if(ranged.getPosition().getX() < 800){
                            if(GameLogicImpl.checkRange(ranged, target)){
                                ranged.attack(target);
                                ranged.updateSprite(Constants.attack);
                                if(!GameLogicImpl.checkCollision(ranged, target)){
                                    ranged.updatePosition();
                                    ranged.updateRangeBox();
                                }
                            }else{
                                ranged.updateSprite(Constants.walk);
                                ranged.updatePosition();
                                ranged.updateRangeBox();
                            }
                        }else{
                            if(GameLogicImpl.checkRange(ranged, target)){
                                ranged.attack(target);
                                ranged.updateSprite(Constants.attack);
                            }else{
                                ranged.updateSprite(Constants.walk);
                            }
                        }
                    }else{
                        if(ranged.getPosition().getX() < 800){
                            ranged.updateSprite(Constants.walk);
                            ranged.updatePosition();
                            ranged.updateRangeBox();
                        }else{
                            ranged.updateSprite(Constants.walk);
                        }
                                
                    }
                }
                for(Projectile arrow : ranged.getProjectiles()){
                    if(tower.getEnemies().size()>0){
                        target = tower.getEnemies().getFirst();
                        arrow.move(target);
                        if(arrow.checkCollide(target)){
                            arrow.hit(target);
                            ranged.getProjectiles().remove(arrow);
                        }
                
                        if(arrow.checkDistance()){
                            ranged.getProjectiles().remove(arrow);
                        }
                    }else{
                        ranged.getProjectiles().remove(arrow);
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
                    entity.updateSprite(Constants.walk);
                }
            }else{
                if(tower.getEntitiesNumber() > 0){
                    target = tower.getEntities().getFirst();
                    if(GameLogicImpl.checkCollision(entity, target)){
                        entity.attack(target);
                        entity.updateSprite(Constants.attack);
                        entity.attack(entity.getTarget(tower.getEntities()));
                    }else{
                        entity.updatePosition();
                    }
                }else{
                    if(tower.getTurret() != null){
                        target = tower.getTurret();
                    }else{
                        target = TowerSingleton.getInstance();
                    }
                    if(GameLogicImpl.checkCollision(entity, target)){
                        entity.attack(target);
                        entity.updateSprite(Constants.attack);
                    }else{
                        entity.updatePosition();
                    }
                }
            }
        }


        if(tower.getTurret() != null){
            Turret turret = tower.getTurret();
            if(tower.getEnemies().size() > 0){
                target = tower.getEnemies().getFirst();
                if(GameLogicImpl.checkRange(turret, target)){
                    turret.attack(target);
                    turret.updateSprite(Constants.attack);
                }else{
                    turret.updateSprite(Constants.walk);
                }
            }else{
               turret.updateSprite(Constants.walk);
            }
            for(Projectile arrow : turret.getProjectiles()){
                if(tower.getEnemies().size()>0){
                    target = tower.getEnemies().getFirst();
                    arrow.move(target);
                    if(arrow.checkCollide(target)){
                        arrow.hit(target);
                        turret.getProjectiles().remove(arrow);
                    }
                    if(arrow.checkDistance()){
                        turret.getProjectiles().remove(arrow);
                    }
                }else{
                    turret.getProjectiles().remove(arrow);
                }
            }
        }
    }
}
