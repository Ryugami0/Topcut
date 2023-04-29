package towerDefense.entities.api;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;

import towerDefense.Constants;
import towerDefense.game.api.Sfx;

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
    private long lastTimeAttack=lastTime;
    private String nameEntity;

    public MovingEntity(Point startPoint, int speed, int hp, int damage, String nameEntity, int cost){
        this.position = new Point(startPoint);
        this.hitbox = new Rectangle(startPoint);
        this.hitbox.setSize(80, 80);
        this.speed = speed;
        this.hp = hp;
        this.damage = damage;
        this.nameEntity=nameEntity;
        this.updateSprite(Constants.walk);
    }

    public void updatePosition() {
        this.position.setLocation(this.position.getX() + this.speed, this.position.getY());
        this.hitbox.setLocation((int)this.hitbox.getX() + this.speed, (int)this.hitbox.getY());
        this.updateSprite(Constants.walk);
        if(lastTime+250<System.currentTimeMillis()){
            lastTime=System.currentTimeMillis();

        }
    }

    public void updateSprite(String activity) {
        int currentSprite=0;

        if(lastTime+125<System.currentTimeMillis()){
            lastTime=System.currentTimeMillis();
            
            try {
                if(activity==Constants.walk){
                    if((this.nameEntity==Constants.barbarian&&currentSpriteWalk==8)||
                            (this.nameEntity==Constants.knight&&currentSpriteWalk==8)||
                                (this.nameEntity==Constants.goblin&&currentSpriteWalk==6)||
                                    (this.nameEntity==Constants.archer&&currentSpriteWalk==8)||
                                        (this.nameEntity==Constants.turret&&currentSpriteWalk==1)||
                                            (this.nameEntity==Constants.wizard&&currentSpriteWalk==6)){
                        currentSpriteWalk=0;
                    }
                    currentSpriteWalk++;
                    currentSprite=this.currentSpriteWalk;
                }else if(activity==Constants.attack){
                    if((this.nameEntity==Constants.barbarian && currentSpriteAttack==30)||
                            (this.nameEntity==Constants.knight&&currentSpriteAttack==9)||
                                    (this.nameEntity==Constants.goblin&&currentSpriteAttack==7)||
                                        (this.nameEntity==Constants.archer&&currentSpriteAttack==17)||
                                            (this.nameEntity == Constants.turret && this.currentSpriteAttack==6)||
                                                (this.nameEntity == Constants.turret && this.currentSpriteAttack==10)){
                        currentSpriteAttack=0;
                    }
                    currentSpriteAttack++;
                    currentSprite=this.currentSpriteAttack;
                }
                this.sprite = ImageIO.read(getClass().getResource("../../Assets/"+nameEntity+"/"+activity+"/"+currentSprite+"/"+currentSprite+".png"));  
            } catch (IOException e) {
                System.out.println("error loading image " + e.getMessage());
            }
        } 
    }

    public void attack(Entity target) {
        this.target = target;
        this.target.incomeDamage(this.damage);

        if(lastTimeAttack+1500<System.currentTimeMillis()){
            lastTimeAttack=System.currentTimeMillis();

            Sfx SFX=new Sfx();
            if(nameEntity==Constants.barbarian || nameEntity==Constants.knight){
                SFX.startSFX("HitSword");
            }else{
                SFX.startSFX("Hit");
            }
            

        }

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

    public BufferedImage getSprite(){
        return this.sprite;
    }

    public String getNameEntity(){
        return this.nameEntity;
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
    
    public void resizeHitbox(int x, int y){
        this.hitbox.setSize(x, y);
    }
}
