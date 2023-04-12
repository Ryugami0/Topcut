package TowerDefense.entities.api;

import java.awt.Point;
import java.awt.Rectangle;

public interface Entity {

    public Point getPosition();
    public int getSpeed();
    public int getHp();
    public int getDamage();
    public void incomeDamage(int value);
    public Rectangle getHitbox();
}
