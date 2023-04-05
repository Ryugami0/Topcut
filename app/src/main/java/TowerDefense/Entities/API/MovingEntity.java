package TowerDefense.Entities.API;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;

public class MovingEntity implements Entity{

    private Point position; //upper left position of the hitbox
    private Rectangle hitbox;
    private int speed;
    private int hp;
    private int damage;
    private MovingEntity target;
    private BufferedImage sprite;
    private int currentsprite=0;
    private long lastTime=System.currentTimeMillis();
    private String nameEntity;

    public MovingEntity(Point startPoint, int speed, int hp, int damage, String nameEntity){
        this.position = new Point(startPoint);
        this.hitbox = new Rectangle(startPoint);
        this.hitbox.setSize(50, 60);
        this.speed = speed;
        this.hp = hp;
        this.damage = damage;
        this.nameEntity=nameEntity;
        this.updateSprite();
    }

    public void updatePosition() {
        this.position.setLocation(this.position.getX() + this.speed, this.position.getY());
        this.hitbox.setLocation((int)this.hitbox.getX() + this.speed, (int)this.hitbox.getY());
        if(lastTime+250<System.currentTimeMillis()){
            lastTime=System.currentTimeMillis();
            this.updateSprite();
        }
    }

    private void updateSprite() {
        try {
            currentsprite++;
            this.sprite= ImageIO.read(getClass().getResource("../../Assets/"+nameEntity+"/Walk/"+currentsprite+".png"));
            if(currentsprite==8){
                currentsprite=0;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("error loading image " + e.getMessage());
        }
    }

    public void attack(MovingEntity target){
        //loop sprite
        this.target = target;
        this.target.incomeDamage(this.damage);
    }

    public MovingEntity getTarget(LinkedList<MovingEntity> enemies){
            return enemies.getFirst();
    }

    public int getRowPosition(LinkedList<MovingEntity> entities){
        return entities.indexOf(this);
    }

    public void draw(Graphics g){
        g.drawImage(this.sprite, this.getPosition().x, this.getPosition().y, null);
        //System.out.println("MovingEntity drawed");
    }

    public Rectangle getHitbox(){
        return this.hitbox;
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
