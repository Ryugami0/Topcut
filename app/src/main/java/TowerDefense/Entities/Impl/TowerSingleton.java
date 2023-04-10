package TowerDefense.Entities.Impl;

import TowerDefense.Entities.API.Entity;
import TowerDefense.Entities.API.MovingEntity;
import TowerDefense.gameLogic.Impl.GameLogicImpl;
import TowerDefense.gameLogic.Impl.WaveManager;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

import javax.imageio.ImageIO;


public class TowerSingleton implements Entity{

    private static int hp;
    private static Point position;
    private static Rectangle hitbox;
    private static TowerSingleton instance = null;
    private static int damage;
    private static int speed;
    private static int score;
    private static int money;
    private static int i = 0;
    private BufferedImage sprite;

    private static WaveManager waveManager;
    private static LinkedList<MovingEntity> enemies = new LinkedList<MovingEntity>();
	private static Queue<MovingEntity> waveQueue = new LinkedList<MovingEntity>();

    private static LinkedList<MovingEntity> entities = new LinkedList<MovingEntity>();
	private static Queue<MovingEntity> summonQueue = new LinkedList<MovingEntity>();

    private TowerSingleton() {
        TowerSingleton.hp = 1000;
        TowerSingleton.speed = 0;
        TowerSingleton.damage = 0;
        TowerSingleton.score = 0;
        TowerSingleton.money = 100;

        try {
            this.sprite= ImageIO.read(getClass().getResource("../../Assets/Tower/1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        TowerSingleton.hitbox = new Rectangle(50, 500, 100, 100);
        TowerSingleton.waveManager = new WaveManager();
    }

    public static TowerSingleton getInstance() {
        if(instance == null) {
            instance = new TowerSingleton(); 
        }
        return instance;
    }

    public void queueCreature(int cost, int type) {
        if(TowerSingleton.summonQueue.size()<5){
            MovingEntity entity;
            if(type==1){
                entity = new Barbarian();
            }else /*if(type==2)*/{
                entity = new Knight();
            }
            if(entity.getCost() <= TowerSingleton.getMoney())  {
                TowerSingleton.summonQueue.add(entity);
                TowerSingleton.money -= entity.getCost();
            } 
        }
            
            //System.out.println("queued creature\n " + summonQueue.size());
    }

    public void summonEntity() {
		TowerSingleton.entities.add(TowerSingleton.summonQueue.poll());
	}

    public void queueEnemy(){
        MovingEntity enemy = new Goblin();
        TowerSingleton.waveQueue.add(enemy);
            //System.out.println("queued creature\n " + waveQueue.size());
    }

    public void summonEnemy(){
        TowerSingleton.enemies.add(TowerSingleton.waveQueue.poll());
    }

    public void removeDeads(){
        for(int i = 0; i < TowerSingleton.entities.size(); i++){
            if(entities.get(i).getHp() <= 0){
                entities.remove(i);
            }
        }
        for(int i = 0; i < TowerSingleton.enemies.size(); i++){
            if(TowerSingleton.enemies.get(i).getHp() <= 0){
                enemies.remove(i);
            }
        }
    }

    public void AI(){
        MovingEntity entity;
        Entity target;
        MovingEntity ally;
        for(int i = 0; i< TowerSingleton.entities.size(); i++){
            entity = TowerSingleton.entities.get(i);
            if(i != 0){
                ally = TowerSingleton.entities.get( i - 1);
                if(!GameLogicImpl.checkCollision(entity, ally)){
                    entity.updatePosition();
                }else{
                    entity.updateSprite("Walk");
                }
            }else{
                if(enemies.size() > 0){
                    target = TowerSingleton.enemies.getFirst();
                    if(entity.getPosition().getX() < 500){
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
                    if(entity.getPosition().getX() < 500){
                        entity.updatePosition();
                    }else{
                        entity.updateSprite("Walk");
                    }
                            
                }
            }
        }
        for(int i = 0; i< TowerSingleton.enemies.size(); i++){
            entity = TowerSingleton.enemies.get(i);
            if(i != 0){
                ally = TowerSingleton.enemies.get( i - 1);
                if(!GameLogicImpl.checkCollision(entity, ally)){
                    entity.updatePosition();
                }
            }else{
                if(entities.size() > 0){
                    target = TowerSingleton.entities.getFirst();
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
        for(MovingEntity entity : TowerSingleton.entities){
            //System.out.println("calling Entity to draw");
            entity.draw(g);
        }
        for(MovingEntity enemy : TowerSingleton.enemies){
            //System.out.println("calling Entity to draw");
            enemy.draw(g);
        }

        g.drawImage(this.sprite, 50, 400, null);
    }
    
    public void update(){
        TowerSingleton.getWaveManager().spawnWave();
        removeDeads();
        this.AI();
        if(TowerSingleton.summonQueue.size()>0){
            this.summonEntity();
        }
  
        if(TowerSingleton.waveQueue.size()>0){
            this.summonEnemy();
        }
        TowerSingleton.updateScoreMoney();

       // System.out.println("positions updated");
    }

    public Queue<MovingEntity> getSummonQueue(){
        return TowerSingleton.summonQueue;
    }

    public String getSummonQueueSize(){
        String a = Integer.toString(TowerSingleton.summonQueue.size());
        return a;
    }

    public int getHp() {
        return TowerSingleton.hp;
    }

    public Point getPosition() {
        return TowerSingleton.position;
    }

    @Override
    public int getSpeed() {
        return TowerSingleton.speed;
    }

    @Override
    public int getDamage() {
       return TowerSingleton.damage;
    }

    @Override
    public void incomeDamage(int value) {
        TowerSingleton.hp -= value;
    }

    public int getScore() {
        return TowerSingleton.score;
    }

    public static int getMoney() {
        return TowerSingleton.money;
    }

    @Override
    public Rectangle getHitbox() {
        return TowerSingleton.hitbox;
    }

    public int getEntitiesNumber(){
        return TowerSingleton.entities.size();
    }

    public static WaveManager getWaveManager(){
        return TowerSingleton.waveManager;
    }

    public static void updateScoreMoney() {
        if(i == 100) {
            TowerSingleton.score += 5;
            TowerSingleton.money += 5;
            i = 0;
        }
        else {
            i++;
        }
        
    }
}
