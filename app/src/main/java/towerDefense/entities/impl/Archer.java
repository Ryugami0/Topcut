package towerDefense.entities.impl;

import java.awt.Point;

import towerDefense.Constants;
import towerDefense.entities.api.RangedEntity;

public class Archer extends RangedEntity{
     
    static int cost = 50;

    public Archer() {
        super(new Point(50, 500), 2, 1500, 500, Constants.archer, cost);
    }

    public static int getCost(){
        return cost;
    }
    
}
