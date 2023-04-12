package TowerDefense.Entities.Impl;

import java.awt.Point;

import TowerDefense.Constants;

import TowerDefense.Entities.API.MovingEntity;

public class Goblin extends MovingEntity{

    public Goblin() {
        super(new Point((int)Constants.width-50 ,430), -2 , 4000, 12,"Goblin", 0);
    }

}
