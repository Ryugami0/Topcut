package main.java.Entities.Impl;

import javafx.util.Pair;
import main.java.Entities.API.Entity;

public class Barbarian implements Entity{

    private Pair<Integer, Integer> position;
    private int speed;
    private int hp;
    private int damage;

    @Override
    public int getSpeed() {
        return this.speed;
    }

    @Override
    public Pair<Integer, Integer> getPosition() {
        return this.position;
    }

    @Override
    public int getHp() {
        return this.hp;
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
