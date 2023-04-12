package TowerDefense.Entities.Impl;

import java.awt.Point;

import TowerDefense.Entities.API.MovingEntity;

public class Knight extends MovingEntity{

    private static int cost = 60;

    public Knight() {
        super(new Point(50,530), 3, 5500, 10, "Knight", 60);
    }

    public static int getCost() {
        return cost;
    }
}
