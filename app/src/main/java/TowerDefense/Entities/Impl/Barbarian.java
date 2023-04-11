package TowerDefense.Entities.Impl;
import java.awt.Point;

import TowerDefense.Entities.API.MovingEntity;

public class Barbarian extends MovingEntity{

    static int cost = 40;

    public Barbarian() {
        super(new Point(50,500), 1, 8000, 8, "Barbarian", cost);
    }

    public static int getCost() {
        return cost;
    }

}
