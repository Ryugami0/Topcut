package towerDefense.entities.api;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.LinkedList;

public class RangedEntity extends MovingEntity{

    private Rectangle rangeBox;
    private long lastTime = System.currentTimeMillis();
    private long currentTime;
    private String projectileType;
    private LinkedList<Projectile> projectiles = new LinkedList<Projectile>();
    private boolean started = false;


    public RangedEntity(Point startPoint, int speed, int hp, int damage, String nameEntity, int cost) {
        super(startPoint, speed, hp, damage, nameEntity, cost);
        this.rangeBox = new Rectangle(startPoint);
        this.rangeBox.setSize(400, 80);
        this.currentTime = lastTime + 6000;
        if(nameEntity == "Archer"){
            this.projectileType = "Arrow";
        }else if(nameEntity == "Turret"){
            this.projectileType = "Boulder";
        }
    }

    @Override
    public void draw(Graphics g){
        g.drawImage(super.getSprite(), this.getPosition().x, this.getPosition().y, null);
        //g.setColor(Color.RED);
        //g.drawRect((int)this.getRangeBox().getX(), (int)this.getRangeBox().getY(), (int)this.getRangeBox().getWidth(), (int)this.getRangeBox().getHeight());
        //g.setColor(Color.BLACK);
        //g.drawRect((int)this.getHitbox().getX(), (int)this.getHitbox().getY(), (int)this.getHitbox().getWidth(), (int)this.getHitbox().getHeight());
        for(Projectile arrow : this. projectiles){
            arrow.draw(g);
        }
    }

    @Override
    public void attack(Entity target){
        currentTime = System.currentTimeMillis();
        if(this.projectiles.size() < 5 ){
            Point projPos;
            if(!started){
                if(this.projectileType == "Boulder"){
                    projPos = new Point(this.getPosition().x , this.getPosition().y + 20);
                }else{
                    projPos = new Point(this.getPosition().x +30 , this.getPosition().y + 60);
                }
                Projectile projectile = new Projectile(this.getDamage(), projPos, this.projectileType, target);
                this.projectiles.add(projectile);
                lastTime = System.currentTimeMillis();
                this.started = true;
            }else{
                if((currentTime - lastTime) > 1000){
                    if(this.projectileType == "Boulder"){
                        projPos = new Point(this.getPosition().x , this.getPosition().y + 20);
                    }else{
                        projPos = new Point(this.getPosition().x +30 , this.getPosition().y + 60);
                    }
                    Projectile projectile = new Projectile(this.getDamage(), projPos, this.projectileType, target);
                    this.projectiles.add(projectile);
                    lastTime = System.currentTimeMillis();
                } 
            }
        }
    }

    public void updateRangeBox() {
        this.rangeBox.setLocation((int)this.rangeBox.getX() + super.getSpeed(), (int)this.rangeBox.getY());
        if(lastTime+250<System.currentTimeMillis()){
            lastTime=System.currentTimeMillis();

        }
    }

    public Rectangle getRangeBox(){
        return this.rangeBox;
    }

    public LinkedList<Projectile> getProjectiles(){
        return this.projectiles;
    }

    public void resizeRangebox(int x, int y){
        this.rangeBox.setSize(x, y);
    }

    
}
