package TowerDefense.Entities.Impl;

import TowerDefense.Entities.API.Entity;

import java.awt.Point;
import java.util.List;


public class TowerSingleton implements Entity{

    private int hp;
    private List<Point> position;
    private static TowerSingleton instance = null;
    private int damage;
    private int speed;

    private TowerSingleton() {
    }

    public static TowerSingleton getInstance() {
        if(instance == null) {
            instance = new TowerSingleton(); 
        }
        return instance;
    }

    public int getHp() {
        return this.hp;
    }

    public List<Point> getPosition() {
        return this.position;
    }

    @Override
    public int getSpeed() {
        return this.speed;
    }

    @Override
    public int getDamage() {
       return this.damage;
    }

    @Override
    public void incomeDamage(int value) {
        this.hp -= value;
    }
    
}
