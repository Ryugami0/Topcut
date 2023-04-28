package towerDefense.entities.impl;

import java.awt.Point;

import towerDefense.entities.api.RangedEntity;

public class Archer extends RangedEntity{
     
    static int cost = 5;

    public Archer() {
        super(new Point(50, 500), 2, 1500, 500, "Archer", cost);
    }

    public static int getCost(){
        return cost;
    }
    
}
