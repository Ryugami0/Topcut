package TowerDefense.Entities.Impl;

import TowerDefense.Entities.API.*;
import TowerDefense.gameLogic.Impl.*;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import javax.imageio.ImageIO;


public class TowerSingleton implements Entity{

    private int hp;
    private Point position;
    private Rectangle hitbox;
    private static TowerSingleton instance = null;
    private int damage;
    private int speed;
    private int score;
    private int money;
    private int i = 0;
    private BufferedImage sprite;
    private int maxHp;
    private LinkedList<MovingEntity> enemies = new LinkedList<MovingEntity>();
	private Queue<MovingEntity> waveQueue = new LinkedList<MovingEntity>();
    private LinkedList<MovingEntity> entities = new LinkedList<MovingEntity>();
	private Queue<MovingEntity> summonQueue = new LinkedList<MovingEntity>();

    private TowerSingleton() {
        this.hp = 1000;
        this.speed = 0;
        this.damage = 0;
        this.score = 0;
        this.money = 100;
        this.maxHp = hp;

        try {
            this.sprite= ImageIO.read(getClass().getResource("../../Assets/Tower/1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.hitbox = new Rectangle(50, 500, 100, 100);
    }

    public static TowerSingleton getInstance() {
        if(instance == null) {
            instance = new TowerSingleton(); 
        }
        return instance;
    }

    public void queueCreature(int cost, int type) {
        if(this.summonQueue.size()<5){
            MovingEntity entity;
            if(type==1){
                entity = new Barbarian();
            }else /*if(type==2)*/{
                entity = new Knight();
            }
            if(cost <= this.getMoney())  {
                this.summonQueue.add(entity);
                this.money -= cost;
            } 
        }
            
            System.out.println("queued creature\n " + summonQueue.size());
    }

    public void summonEntity() {
		this.entities.add(this.summonQueue.poll());
	}

    public void queueEnemy(){
        MovingEntity enemy = new Goblin();
        this.waveQueue.add(enemy);
            //System.out.println("queued creature\n " + waveQueue.size());
    }

    public void summonEnemy(){
        this.enemies.add(this.waveQueue.poll());
    }

    public void removeDeads(){
        for(int i = 0; i < this.entities.size(); i++){
            if(entities.get(i).getHp() <= 0){
                entities.remove(i);
            }
        }
        for(int i = 0; i < this.enemies.size(); i++){
            if(this.enemies.get(i).getHp() <= 0){
                enemies.remove(i);
                this.addKillMoney();
            }
        }
    }

    public void AI(){
        MovingEntity entity;
        Entity target;
        MovingEntity ally;
        for(int i = 0; i< this.entities.size(); i++){
            entity = this.entities.get(i);
            if(i != 0){
                ally = this.entities.get( i - 1);
                if(!GameLogicImpl.checkCollision(entity, ally)){
                    entity.updatePosition();
                }else{
                    entity.updateSprite("Walk");
                }
            }else{
                if(enemies.size() > 0){
                    target = this.enemies.getFirst();
                    if(entity.getPosition().getX() < 800){
                        if(GameLogicImpl.checkCollision(entity, target)){
                            entity.attack(target);
                            entity.updateSprite("Attack");
                        }else{
                            entity.updatePosition();
                        }
                    }else{
                        if(GameLogicImpl.checkCollision(entity, target)){
                            entity.attack(target);
                            entity.updateSprite("Attack");
                        }else{
                            entity.updateSprite("Walk");
                        }
                    }
                }else{
                    if(entity.getPosition().getX() < 800){
                        entity.updatePosition();
                    }else{
                        entity.updateSprite("Walk");
                    }
                            
                }
            }
        }
        for(int i = 0; i< this.enemies.size(); i++){
            entity = this.enemies.get(i);
            if(i != 0){
                ally = this.enemies.get( i - 1);
                if(!GameLogicImpl.checkCollision(entity, ally)){
                    entity.updatePosition();
                }
            }else{
                if(entities.size() > 0){
                    target = this.entities.getFirst();
                    if(GameLogicImpl.checkCollision(entity, target)){
                        entity.attack(target);
                        entity.updateSprite("Attack");
                        entity.attack(entity.getTarget(enemies));
                    }else{
                        entity.updatePosition();
                    }
                }else{
                    entity.updatePosition();
                }
            }
        }
}

    public void draw(Graphics g){
        for(MovingEntity entity : this.entities){
            //System.out.println("calling Entity to draw");
            entity.draw(g);
        }
        for(MovingEntity enemy : this.enemies){
            //System.out.println("calling Entity to draw");
            enemy.draw(g);
        }

        g.drawImage(this.sprite, 50, 400, null);
    }
    
    public void update(){
        this.getWaveManager().spawnWave();
        removeDeads();
        this.AI();
        if(this.summonQueue.size()>0){
            this.summonEntity();
        }
  
        if(this.waveQueue.size()>0){
            this.summonEnemy();
        }
        this.updateScoreMoney();
    }

    public int getHp() {
        return this.hp;
    }

    public Point getPosition() {
        return this.position;
    }

    @Override
    public int getSpeed() {
        return this.speed;
    }

    @Override
    public int getDamage() {
       return this.damage;
    }

    @Override
    public void incomeDamage(int value) {
        this.hp -= value;
    }

    public int getScore() {
        return this.score;
    }

    public int getMoney() {
        return this.money;
    }

    @Override
    public Rectangle getHitbox() {
        return this.hitbox;
    }

    public int getEntitiesNumber(){
        return this.entities.size();
    }

    public WaveManagerSingleton getWaveManager(){
        return WaveManagerSingleton.getInstance();
    }

    public void updateScoreMoney() {
        if(i == 100) {
            this.score += 5;
            this.money += 5;
            i = 0;
        }
        else {
            i++;
        }
        
    }

    private void addKillMoney() {
        this.money += 10;
    }

    public int getMaxHp() {
        return this.maxHp;
    }
}


