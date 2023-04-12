package TowerDefense.entities.impl;
import java.awt.Point;

import TowerDefense.entities.api.MovingEntity;

public class Barbarian extends MovingEntity{

    static int cost = 40;

    public Barbarian() {
        super(new Point(50,500), 1, 4500, 15, "Barbarian", cost);
    }

    public static int getCost() {
        return cost;
    }

}
