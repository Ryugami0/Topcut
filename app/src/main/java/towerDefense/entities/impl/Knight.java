package towerDefense.entities.impl;

import java.awt.Point;

import towerDefense.entities.api.MovingEntity;

public class Knight extends MovingEntity{

    private static int cost = 60;

    public Knight() {
        super(new Point(50,500), 3, 2000, 35, "Knight", 60);
    }

    public static int getCost() {
        return cost;
    }
}
