package towerDefense.entities.api;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import towerDefense.Constants;

public class Projectile {
    private Rectangle hitbox;
    private Point position;
    private int damage;
    private int speed;
    private BufferedImage currentSprite;
    private Point initialPos;
    
    public Projectile(int damage, Point position, String type, Entity target){
        this.damage = damage;
        this.position = position;
        this.initialPos = position;
        if(type == Constants.arrow){
            this.speed = 4;
            this.hitbox = new Rectangle(this.position);
            this.hitbox.setSize(10, 5);
            try{
                this.currentSprite = ImageIO.read(getClass().getResource("../../Assets/Projectile/Arrow.png"));
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(type == Constants.boulder){
            this.speed = 4;
            this.hitbox = new Rectangle(this.position);
            this.hitbox.setSize(15, 15);
            try{
                this.currentSprite = ImageIO.read(getClass().getResource("../../Assets/Projectile/Boulder.png"));
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public void hit(Entity target){
        target.incomeDamage(this.damage);
    }

    public void move(Entity target) {
        this.position.x += this.speed;
        this.position.y += (int)this.getTrajectory(target);
        this.hitbox.setLocation(this.position);
    }

    public boolean checkCollide(Entity enemy) {
        return this.hitbox.intersects(enemy.getHitbox());
    }
    
    public boolean checkDistance(){
        if(this.getPosition().getX() - this.initialPos.getX() > 200){
            return true;
        }
        return false;
    }

    public void draw(Graphics g) {
        g.drawImage(this.currentSprite, this.position.x, this.position.y, null);
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public Point getPosition() {
        return this.position;
    }

    public Point getInitialPos() {
        return this.initialPos;
    }

    public int getDamage() {
        return damage;
    }

    public int getSpeed() {
        return speed;
    }

    public BufferedImage getCurrentSprite() {
        return this.currentSprite;
    }

    public double getTrajectory(Entity target){
        double Dx = target.getPosition().getX() - this.position.x;
        double Dy = 40 + target.getPosition().getY() - this.position.y ;
        return ((double)speed * Dy)/Dx;
    }
}
