package TowerDefense.Entities.API;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MovingEntity implements Entity{

    private Point position; //upper left position of the hitbox
    private Rectangle hitbox;
    private int speed;
    private int hp;
    private int damage;
    private BufferedImage sprite;
    private int currentsprite=0;

    public MovingEntity(Point startPoint, int speed, int hp, int damage){
        this.position = new Point(startPoint);
        this.hitbox = new Rectangle(startPoint);
        this.hitbox.setSize(50, 60);
        this.speed = speed;
        this.hp = hp;
        this.damage = damage;
        this.updateSprite();
    }

    public void updatePosition() {
        this.position.setLocation(this.position.getX() + this.speed, this.position.getY());
        this.hitbox.setLocation((int)this.hitbox.getX() + this.speed, (int)this.hitbox.getY());
        this.updateSprite();
    }

    private void updateSprite() {
        try {
            if(currentsprite==1){
                this.sprite= ImageIO.read(new File("/Users/Cesco/Documents/GitHub/OOP22-towerdefense/Assets/Barbarian/Walk/2.png"));
                currentsprite++;
            }else if(currentsprite==2){
                this.sprite= ImageIO.read(new File("/Users/Cesco/Documents/GitHub/OOP22-towerdefense/Assets/Barbarian/Walk/3.png"));
                currentsprite++;
            }else if(currentsprite==3){
                this.sprite= ImageIO.read(new File("/Users/Cesco/Documents/GitHub/OOP22-towerdefense/Assets/Barbarian/Walk/4.png"));
                currentsprite++;
            }else if(currentsprite==4){
                this.sprite= ImageIO.read(new File("/Users/Cesco/Documents/GitHub/OOP22-towerdefense/Assets/Barbarian/Walk/5.png"));
                currentsprite++;
            }else if(currentsprite==5){
                this.sprite= ImageIO.read(new File("/Users/Cesco/Documents/GitHub/OOP22-towerdefense/Assets/Barbarian/Walk/6.png"));
                currentsprite++;
            }else if(currentsprite==6){
                this.sprite= ImageIO.read(new File("/Users/Cesco/Documents/GitHub/OOP22-towerdefense/Assets/Barbarian/Walk/7.png"));
                currentsprite++;
            }else if(currentsprite==7){
                this.sprite= ImageIO.read(new File("/Users/Cesco/Documents/GitHub/OOP22-towerdefense/Assets/Barbarian/Walk/8.png"));
                currentsprite++;
            }else if(currentsprite==8||currentsprite==0){
                this.sprite= ImageIO.read(new File("/Users/Cesco/Documents/GitHub/OOP22-towerdefense/Assets/Barbarian/Walk/1.png"));
                currentsprite=1;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("error loading image " + e.getMessage());
        }
    }

    public void draw(Graphics g){
        g.drawImage(this.sprite, this.getPosition().x, this.getPosition().y, null);
        //System.out.println("MovingEntity drawed");
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
