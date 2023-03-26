package main.java.Entities.API;

import javafx.util.Pair;

public interface Entity {

    public Pair<Integer, Integer> getPosition();
    public int getSpeed();
    public int getHp();
    public int getDamage();
    public void incomeDamage(int value);
    
}
