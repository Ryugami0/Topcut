package TowerDefense.Entities.API;

import java.awt.Point;
//import java.util.List;

public interface Entity {

    public Point getPosition();
    public int getSpeed();
    public int getHp();
    public int getDamage();
    public void incomeDamage(int value);
    
}
