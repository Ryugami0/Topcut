package TowerDefense.Entities.Impl;

import TowerDefense.Entities.API.Entity;
import TowerDefense.Entities.API.MovingEntity;

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
        MovingEntity entity = new MovingEntity(new Point(50,500), 1, 10, 10);
        this.summonQueue.add(entity);
        System.out.println("queued creature\n " + summonQueue.size());
    }

    public void summonEntity() {
		this.entities.add(this.summonQueue.poll());
	}

    public void draw(Graphics g){
        for(MovingEntity entity : this.entities){
            System.out.println("calling Entity to draw");
            entity.draw(g);
        }
    }
    
    public void update(){
        for(MovingEntity entity : this.entities){
            entity.updatePosition();
        }
        if(this.summonQueue.size()>0){
            this.summonEntity();
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
