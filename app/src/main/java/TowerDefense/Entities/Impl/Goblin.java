package TowerDefense.entities.impl;

import java.awt.Point;

import TowerDefense.Constants;
import TowerDefense.entities.api.MovingEntity;

public class Goblin extends MovingEntity{

    public Goblin() {
        super(new Point((int)Constants.width-50 ,430), -2 , 4000, 12,"Goblin", 0);
    }

}
