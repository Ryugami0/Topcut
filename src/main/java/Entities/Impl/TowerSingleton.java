package main.java.Entities.Impl;

import javafx.util.Pair;

public class TowerSingleton {

    private int hp;
    private Pair<Integer, Integer> position;
    private static TowerSingleton instance = null;

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
    
}
