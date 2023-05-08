package towerDefense.entities.impl;

import java.awt.Point;

import towerDefense.Constants;
import towerDefense.entities.api.MovingEntity;

public class Wizard extends MovingEntity{

    public Wizard() {
        super(new Point((int)Constants.width ,510), -2 , 1500, 16,Constants.wizard, 0);
    }

}