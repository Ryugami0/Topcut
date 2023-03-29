package main.java.Entities.API;
import java.awt.Point;
import java.util.List;

public abstract class MovingEntity implements Entity{

    private List<Point> position;
    private int speed;
    private int hp;
    private int damage;

    @Override
    public List<Point> getPosition() {
        return this.position;
    }

    @Override
    public int getSpeed() {
        return this.speed;
    }

    @Override
    public int getHp() {
       return this.hp;
    }

    @Override
    public int getDamage() {
        return this.damage;
    }

    @Override
    public void incomeDamage(int value) {
        this.hp -= value;
    }
    
}
