package TowerDefense.Entities.API;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class MovingEntity implements Entity{

    private Point position; //upper left position of the hitbox
    private Rectangle hitbox;
    private int speed;
    private int hp;
    private int damage;
    private BufferedImage sprite;

    public MovingEntity(Point startPoint, int speed, int hp, int damage){
        this.position = new Point(startPoint);
        this.hitbox = new Rectangle(startPoint);
        this.hitbox.setSize(50, 60);
        this.speed = speed;
        this.hp = hp;
        this.damage = damage;
        try{
            this.sprite = ImageIO.read(new File("/Users/giovanniminoccari/Documents/codes/github/OOP22-towerdefense/Assets/Barbarian/spr_Walk_strip.png"));
        }catch(Exception e){
            System.out.println("error loading image " + e.getMessage());
        }
    }

    public void updatePosition() {
        this.position.setLocation(this.position.getX() + this.speed, this.position.getY());
        this.hitbox.setLocation((int)this.hitbox.getX() + this.speed, (int)this.hitbox.getY());
    }

    public void draw(Graphics g){
        g.drawImage(this.sprite, this.getPosition().x, this.getPosition().y, null);
        System.out.println("MovingEntity drawed");
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
