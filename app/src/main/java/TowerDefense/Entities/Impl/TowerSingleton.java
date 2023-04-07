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

    private static WaveManager waveManager;
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
            MovingEntity entity = new Barbarian();
            this.summonQueue.add(entity);
            //System.out.println("queued creature\n " + summonQueue.size());
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
                    }else{
                        entity.updatePosition();
                    }
                }else{
                    target = TowerSingleton.getInstance();
                    if(GameLogicImpl.checkCollision(entity, target)){
                        entity.attack(target);
                        entity.updateSprite("Attack");
                    }else{
                        entity.updatePosition();
                    }
                }
            }
        }
    }

    public void draw(Graphics g){
        for(int i = 0; i < this.entities.size(); i++){
                entities.get(i).draw(g);;
        }
        for(int i = 0; i < this.enemies.size(); i++){
                enemies.get(i).draw(g);;
        }
    }
    
    public void update(){
        TowerSingleton.getWaveManager().spawnnWave();
        removeDeads();
        this.AI();
        if(this.summonQueue.size() > 0 && this.entities.size() < 10){
            this.summonEntity();
        }
        if(this.waveQueue.size() > 0 && this.enemies.size() < 10){
            System.out.println("summonEnemy()\n");
            this.summonEnemy();
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

    @Override
    public Rectangle getHitbox() {
        return TowerSingleton.hitbox;
    }

    public int getEntitiesNumber(){
        return this.entities.size();
    }

    public static WaveManager getWaveManager(){
        return TowerSingleton.waveManager;
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
