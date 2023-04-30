package towerDefense.entities.impl;


import towerDefense.entities.api.*;
import towerDefense.game.api.Sfx;
import towerDefense.gameLogic.impl.*;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

import javax.imageio.ImageIO;
import towerDefense.gameLogic.impl.AI;;


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
	//private Queue<MovingEntity> waveQueue = new LinkedList<MovingEntity>();
    private LinkedList<MovingEntity> entities = new LinkedList<MovingEntity>();
	//private Queue<MovingEntity> summonQueue = new LinkedList<MovingEntity>();
    private Turret turret;
    private AI ai = new AI();
    private long lastTime = System.currentTimeMillis();

    private TowerSingleton() {
        this.hp = 50000;
        this.speed = 0;
        this.damage = 0;
        this.score = 0;
        this.money = 100;
        this.maxHp = hp;
        this.position = new Point(50, 400);

        try {
            this.sprite= ImageIO.read(getClass().getResource("../../Assets/Tower/1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.hitbox = new Rectangle((int)this.position.getX(), (int)this.position.getY(), 100, 200);
    }

    public static TowerSingleton getInstance() {
        if(instance == null) {
            instance = new TowerSingleton(); 
        }
        return instance;
    }

    /*public void queueCreature(int cost, int type) {
        //if(this.summonQueue.size()<5){
            MovingEntity entity;
            if(type==1){
                entity = new Barbarian();
            }else /*if(type==2)*//*{
                entity = new Knight();
            }
            if(cost <= this.getMoney())  {
                this.summonQueue.add(entity);
                this.money -= cost;
            } 
        //}
    }*/

    public void summonEntity(int cost, int type) {
		MovingEntity entity;
            if(type==1){
                entity = new Barbarian();
            }else if(type==2){
                entity = new Knight();
            }else /*if(type == 3) */{
                entity = new Archer();
            }
            if(cost <= this.getMoney())  {
                this.entities.add(entity);
                this.money -= cost;
            } 
	}

    public void summonfreeEntity(int type) {
		MovingEntity entity;
            if(type==1){
                entity = new Barbarian();
            }else if(type==2){
                entity = new Knight();
            }else /*if(type == 3) */{
                entity = new Archer();
            }
            this.entities.add(entity); 
	}

    public void buildTurret(int cost, int type){
        this.turret = new Turret();
    }

    /*public void queueEnemy(){
        MovingEntity enemy = new Goblin();
        this.waveQueue.add(enemy);
    }*/

    public void summonEnemy(){
        Random random = new Random();
        int seed = random.nextInt(100) + 1;
        if(seed < 70) {
            this.enemies.add(new Goblin());
        }
        else {
            this.enemies.add(new Wizard());
        }
        
    }

    public void removeDeads(){
        for(int i = 0; i < this.entities.size(); i++){
            if(entities.get(i).getHp() <= 0){
                entities.remove(i);
            }
        }
        for(int i = 0; i < this.enemies.size(); i++){
            if(this.enemies.get(i).getHp() <= 0){
                this.enemies.remove(i);
                this.addKillMoney();
            }
        }
        if(this.turret != null && this.turret.getHp() <= 0){
            this.turret = null;
        }
    }

    public void draw(Graphics g){
        for(MovingEntity entity : this.entities){
            entity.draw(g);
        }
        for(MovingEntity enemy : this.enemies){
            enemy.draw(g);
        }
        if(this.turret != null){
            this.turret.draw(g);
        }

        g.drawImage(this.sprite, (int)this.getPosition().getX(), (int)this.getPosition().getY(), null);
        //g.drawRect((int)this.getHitbox().getX(), (int)this.getHitbox().getY(), (int)this.getHitbox().getWidth(), (int)this.getHitbox().getHeight());
    }
    
    public void update(){
        this.getWaveManager().spawnWave();
        removeDeads();
        ai.useAI();
        /*if(this.summonQueue.size()>0){
            this.summonEntity();
        }
  
        if(this.waveQueue.size()>0){
            this.summonEnemy();
        }*/
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
        if(lastTime+1500<System.currentTimeMillis()){
            lastTime=System.currentTimeMillis();

            Sfx SFX=new Sfx();
            SFX.startSFX("HitOnTower");

        }
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
        this.money += 20;
    }

    public int getMaxHp() {
        return this.maxHp;
    }

    public LinkedList<MovingEntity> getEntities() {
        return this.entities;
    }

    public LinkedList<MovingEntity> getEnemies() {
        return this.enemies;
    }

    public Turret getTurret(){
        return this.turret;
    }
}


