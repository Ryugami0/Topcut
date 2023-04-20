package towerDefense.entities.api;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;

public abstract class MovingEntity implements Entity{

    private Point position; //upper left position of the hitbox
    private Rectangle hitbox;
    private int speed;
    private int hp;
    private int damage;
    private Entity target;
    private BufferedImage sprite;
    private int currentSpriteWalk = 0;
    private int currentSpriteAttack = 0;
    private long lastTime = System.currentTimeMillis();
    private String nameEntity;

    public MovingEntity(Point startPoint, int speed, int hp, int damage, String nameEntity, int cost){
        this.position = new Point(startPoint);
        this.hitbox = new Rectangle(startPoint);
        this.hitbox.setSize(50, 150);
        this.speed = speed;
        this.hp = hp;
        this.damage = damage;
        this.nameEntity=nameEntity;
        this.updateSprite("Walk");
    }

    public void updatePosition() {
        this.position.setLocation(this.position.getX() + this.speed, this.position.getY());
        this.hitbox.setLocation((int)this.hitbox.getX() + this.speed, (int)this.hitbox.getY());
        this.updateSprite("Walk");
        if(lastTime+250<System.currentTimeMillis()){
            lastTime=System.currentTimeMillis();

        }
    }

    public void updateSprite(String activity) {
        int currentSprite=0;

        if(lastTime+125<System.currentTimeMillis()){
            lastTime=System.currentTimeMillis();
            
            try {
                if(activity=="Walk"){
                    if((this.nameEntity=="Barbarian"&&currentSpriteWalk==8)||(this.nameEntity=="Knight"&&currentSpriteWalk==8)||(this.nameEntity=="Goblin"&&currentSpriteWalk==6)){
                        currentSpriteWalk=0;
                    }
                    currentSpriteWalk++;
                    currentSprite=this.currentSpriteWalk;
                }else if(activity=="Attack"){
                    if((this.nameEntity=="Barbarian"&&currentSpriteAttack==30)||(this.nameEntity=="Knight"&&currentSpriteAttack==9)||(this.nameEntity=="Goblin"&&currentSpriteAttack==7)){
                        currentSpriteAttack=0;
                    }
                    currentSpriteAttack++;
                    currentSprite=this.currentSpriteAttack;
                }
                this.sprite= ImageIO.read(getClass().getResource("../../Assets/"+nameEntity+"/"+activity+"/"+currentSprite+".png"));  
            } catch (IOException e) {
                System.out.println("error loading image " + e.getMessage());
            }
        } 
    }

    public void attack(Entity target) {
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