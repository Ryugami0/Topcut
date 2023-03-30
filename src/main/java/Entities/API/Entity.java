package main.java.Entities.API;

import java.awt.Point;

public interface Entity {

    public Point getPosition();
    public int getSpeed();
    public int getHp();
    public int getDamage();
    public void incomeDamage(int value);
    
}
