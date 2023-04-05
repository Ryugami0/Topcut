package TowerDefense.Entities.Impl;

import java.awt.Point;
import java.awt.Toolkit;

import TowerDefense.Entities.API.MovingEntity;

public class Goblin extends MovingEntity{

    public Goblin() {
        super(new Point((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/1.3)-50 ,500), -1 , 10, 10,"Goblin");
    }

}
