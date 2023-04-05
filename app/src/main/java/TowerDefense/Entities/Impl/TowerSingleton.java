package TowerDefense.Entities.Impl;

import TowerDefense.Entities.API.Entity;
import TowerDefense.Entities.API.MovingEntity;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.Queue;


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

    private LinkedList<MovingEntity> entities = new LinkedList<MovingEntity>();
	private Queue<MovingEntity> summonQueue = new LinkedList<MovingEntity>();

    private TowerSingleton() {
        TowerSingleton.hp = 1000;
        TowerSingleton.speed = 0;
        TowerSingleton.damage = 0;
        TowerSingleton.score = 0;
        TowerSingleton.money = 0;

    }

    public static TowerSingleton getInstance() {
        if(instance == null) {
            instance = new TowerSingleton(); 
        }
        return instance;
    }

    public void queueCreature(int cost, int type) {
        if(this.summonQueue.size()<1){
            MovingEntity entity = new MovingEntity(new Point(50,500), 1, 10, 10);
            this.summonQueue.add(entity);
            //System.out.println("queued creature\n " + summonQueue.size());
        }
    }

    public void summonEntity() {
		this.entities.add(this.summonQueue.poll());
	}

    public void draw(Graphics g){
        for(MovingEntity entity : this.entities){
            //System.out.println("calling Entity to draw");
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
        TowerSingleton.updateScoreMoney();
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

    public int getMoney() {
        return TowerSingleton.money;
    }

    public static void updateScoreMoney() {
        if(i == 100) {
            TowerSingleton.score += 5;
            TowerSingleton.money += 5;
            i = 0;
            System.out.println(TowerSingleton.money);
        }
        else {
            i++;
        }
        
    }

    

    
    
    
}
