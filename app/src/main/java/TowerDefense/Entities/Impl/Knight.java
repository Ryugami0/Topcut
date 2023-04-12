package TowerDefense.entities.impl;

import java.awt.Point;

import TowerDefense.entities.api.MovingEntity;

public class Knight extends MovingEntity{

    private static int cost = 60;

    public Knight() {
        super(new Point(50,530), 3, 5500, 10, "Knight", 60);
    }

    public static int getCost() {
        return cost;
    }
}
