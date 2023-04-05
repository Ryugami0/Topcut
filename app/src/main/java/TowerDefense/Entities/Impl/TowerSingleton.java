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

    private static int hp;
    private static Point position;
    private static Rectangle hitbox;
    private static TowerSingleton instance = null;
    private static int damage;
    private static int speed;
    private static int score;
    private static int money;
    private static int i = 0;

    private WaveManager wavemanager;
    private LinkedList<MovingEntity> enemies = new LinkedList<MovingEntity>();
	private Queue<MovingEntity> waveQueue = new LinkedList<MovingEntity>();

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
        if(this.summonQueue.size()<5){
            MovingEntity entity = new Barbarian();
            this.summonQueue.add(entity);
            //System.out.println("queued creature\n " + summonQueue.size());
        }
    }

    public void summonEntity() {
		this.entities.add(this.summonQueue.poll());
	}

    public void queueEnemy(){
        if(this.enemies.size()<6){
            MovingEntity enemy = new Goblin();
            this.waveQueue.add(enemy);
            //System.out.println("queued creature\n " + waveQueue.size());
        }
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
            }
        }
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
                        entity.updateSprite("Attack");
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
        removeDeads();
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
