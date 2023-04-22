package towerDefense.entities.impl;
import java.awt.Point;

import towerDefense.entities.api.MovingEntity;

public class Barbarian extends MovingEntity{

    static int cost = 40;

    public Barbarian() {
        super(new Point(50,500), 1, 4000, 25, "Barbarian", cost);
    }

    public static int getCost() {
        return cost;
    }

}
