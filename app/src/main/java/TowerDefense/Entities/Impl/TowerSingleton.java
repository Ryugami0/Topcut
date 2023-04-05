package TowerDefense.Entities.Impl;

import TowerDefense.Entities.API.Entity;
import TowerDefense.Entities.API.MovingEntity;
import TowerDefense.gameLogic.API.GameLogic;
import TowerDefense.gameLogic.Impl.GameLogicImpl;
import TowerDefense.gameLogic.Impl.WaveManager;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.Queue;


public class TowerSingleton implements Entity{

    private int hp;
    private Point position;
    private Rectangle hitbox;
    private static TowerSingleton instance = null;
    private int damage;
    private int speed;
    private int score;
    private int money;

    private WaveManager wavemanager;
    private LinkedList<MovingEntity> enemies = new LinkedList<MovingEntity>();
	private Queue<MovingEntity> waveQueue = new LinkedList<MovingEntity>();

    private LinkedList<MovingEntity> entities = new LinkedList<MovingEntity>();
	private Queue<MovingEntity> summonQueue = new LinkedList<MovingEntity>();

    private TowerSingleton() {
        this.hp = 1000;
        this.speed = 0;
        this.damage = 0;
        this.score = 0;
        this.money = 0;

    }

    public static TowerSingleton getInstance() {
        if(instance == null) {
            instance = new TowerSingleton(); 
        }
        return instance;
    }

    public void queueCreature(int cost, int type) {
        if(this.summonQueue.size()<5){
            MovingEntity entity = new MovingEntity(new Point(50,500), 1, 20, 10);
            this.summonQueue.add(entity);
            //System.out.println("queued creature\n " + summonQueue.size());
        }
    }

    public void summonEntity() {
		this.entities.add(this.summonQueue.poll());
	}

    public void queueEnemy(){
        if(this.enemies.size()<1){
            MovingEntity enemy = new MovingEntity(new Point(500 ,500), -1 , 10, 10);
            this.waveQueue.add(enemy);
            //System.out.println("queued creature\n " + waveQueue.size());
        }
    }

    public void summonEnemy(){
        this.enemies.add(this.waveQueue.poll());
    }

    public void AI(){
        for(MovingEntity entity: this.entities){
            if(entity.getRowPosition(entities) != 0){
                if(GameLogicImpl.checkCollision(entity, entities.get(entities.indexOf(entity) - 1))){

                }else{
                    entity.updatePosition();
                }
            }else{
                if(enemies.size() != 0){
                    if(GameLogicImpl.checkCollision(entity, entity.getTarget(enemies))){
                        entity.attack(entity.getTarget(enemies));
                    }else{
                        entity.updatePosition();
                    }
                }else{
                    entity.updatePosition();
                }
            }
        }
        for(MovingEntity entity: this.enemies){
            if(entity.getRowPosition(enemies) != 0){
                if(GameLogicImpl.checkCollision(entity, enemies.get(enemies.indexOf(entity) - 1))){

                }else{
                    entity.updatePosition();
                }
            }else{
                if(entities.size() != 0){
                    if(GameLogicImpl.checkCollision(entity, entity.getTarget(entities))){
                        entity.attack(entity.getTarget(entities));
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
    }
    
    public void update(){
        queueEnemy();
        this.AI();
        if(this.summonQueue.size()>0){
            this.summonEntity();
        }
        if(this.waveQueue.size()>0){
            this.summonEnemy();
        }
        for(MovingEntity entity: this.entities){
            entity.removeIfDead(entities);
        }
        for(MovingEntity enemy: this.enemies){
             enemy.removeIfDead(this.enemies);
        }
       // System.out.println("positions updated");
    }

    public Queue<MovingEntity> getSummonQueue(){
        return this.summonQueue;
    }

    public String getSummonQueueSize(){
        String a = Integer.toString(this.summonQueue.size());
        return a;
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
    
}
