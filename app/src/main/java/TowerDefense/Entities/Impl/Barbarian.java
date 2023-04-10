package TowerDefense.Entities.Impl;
import java.awt.Point;

import TowerDefense.Entities.API.MovingEntity;

public class Barbarian extends MovingEntity{

    public Barbarian() {
        super(new Point(50,500), 1, 5000, 10, "Barbarian", 40);
    }

}
