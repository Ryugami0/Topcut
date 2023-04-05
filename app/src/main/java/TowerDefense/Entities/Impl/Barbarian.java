package TowerDefense.Entities.Impl;
import java.awt.Point;
import java.awt.Toolkit;

import TowerDefense.Entities.API.MovingEntity;

public class Barbarian extends MovingEntity{

    public Barbarian() {
        super(new Point(50,500), 1, 20, 10, "Barbarian");
    }

}
