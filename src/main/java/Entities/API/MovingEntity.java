package main.java.Entities.API;

import java.awt.Point;
import java.awt.Rectangle;

public abstract class MovingEntity implements Entity{

    private Point position; //upper left position of the hitbox
    private Rectangle hitbox;
    private int speed;
    private int hp;
    private int damage;

    public MovingEntity(Point startPoint, int speed, int hp, int damage){
        this.position = new Point(startPoint);
        this.hitbox = new Rectangle(startPoint);
        this.hitbox.setSize(50, 60);
        this.speed = speed;
        this.hp = hp;
        this.damage = damage;
    }

    public void updatePosition() {
        this.position.setLocation(this.position.getX() + this.speed, this.position.getY());
        this.hitbox.setLocation((int)this.hitbox.getX() + this.speed, (int)this.hitbox.getY());
    }

    @Override
    public Point getPosition() {
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
