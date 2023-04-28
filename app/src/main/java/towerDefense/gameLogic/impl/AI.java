package towerDefense.gameLogic.impl;

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
            if(entity.getNameEntity() != "Archer"){ 
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
            }else{
                ranged = (RangedEntity)entity;
                if(i != 0){
                    ally = tower.getEntities().get( i - 1);
                    if(tower.getEnemies().size() > 0){
                        target = tower.getEnemies().getFirst();
                        if(GameLogicImpl.checkRange(ranged, target)){
                            ranged.attack(target);
                            ranged.updateSprite("Attack");
                            if(!GameLogicImpl.checkCollision(ranged, ally)){
                                ranged.updatePosition();
                                ranged.updateRangeBox();
                            }
                        }else{
                            if(!GameLogicImpl.checkCollision(ranged, ally)){
                                ranged.updatePosition();
                                ranged.updateRangeBox();
                                ranged.updateSprite("Walk");
                            }else{
                                ranged.updateSprite("Walk");
                            }
                        }
                    }else{
                        if(!GameLogicImpl.checkCollision(ranged, ally)){
                            ranged.updatePosition();
                            ranged.updateRangeBox();
                            ranged.updateSprite("Walk");
                        }else{
                            ranged.updateSprite("Walk");
                        }
                    }
                    
                }else{
                    if(tower.getEnemies().size() > 0){
                        target = tower.getEnemies().getFirst();
                        if(ranged.getPosition().getX() < 800){
                            if(GameLogicImpl.checkRange(ranged, target)){
                                ranged.attack(target);
                                ranged.updateSprite("Attack");
                                if(!GameLogicImpl.checkCollision(ranged, target)){
                                    ranged.updatePosition();
                                    ranged.updateRangeBox();
                                }
                            }else{
                                ranged.updateSprite("Walk");
                                ranged.updatePosition();
                                ranged.updateRangeBox();
                            }
                        }else{
                            if(GameLogicImpl.checkRange(ranged, target)){
                                ranged.attack(target);
                                ranged.updateSprite("Attack");
                            }else{
                                ranged.updateSprite("Walk");
                            }
                        }
                    }else{
                        if(ranged.getPosition().getX() < 800){
                            ranged.updateSprite("Walk");
                            ranged.updatePosition();
                            ranged.updateRangeBox();
                        }else{
                            ranged.updateSprite("Walk");
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
                    if(tower.getTurret() != null){
                        target = tower.getTurret();
                    }else{
                        target = TowerSingleton.getInstance();
                    }
                    if(GameLogicImpl.checkCollision(entity, target)){
                        entity.attack(target);
                        entity.updateSprite("Attack");
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
                    turret.updateSprite("Attack");
                }else{
                    turret.updateSprite("Walk");
                }
            }else{
               turret.updateSprite("Walk");
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
