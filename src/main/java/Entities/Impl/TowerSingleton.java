package main.java.Entities.Impl;

import javafx.util.Pair;
import main.java.Entities.API.Entity;

public class TowerSingleton implements Entity{

    private int hp;
    private Pair<Integer, Integer> position;
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

    public Pair<Integer, Integer> getPosition() {
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
