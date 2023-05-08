package towerDefense.entities.impl;


import towerDefense.entities.api.*;
import towerDefense.game.impl.Sfx;
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
    private LinkedList<MovingEntity> entities = new LinkedList<MovingEntity>();
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

    /**
     * 
     * @return an instance of the class, obtainable only by this method
     */
    public static TowerSingleton getInstance() {
        if(instance == null) {
            instance = new TowerSingleton(); 
        }
        return instance;
    }

    /**
     * Adds to the entities list the type of unit requested and then subtracts its cost to the total money
     * @param cost
     *          the cost of the summoned unit
     * @param type
     *          the type of the summoned unit
     */
    public void summonEntity(final int cost, final int type) {
		final MovingEntity entity;
            if(type==1){
                entity = new Barbarian();
            }else if(type==2){
                entity = new Knight();
            }else {
                entity = new Archer();
            }
            if(cost <= this.getMoney())  {
                this.entities.add(entity);
                this.money -= cost;
            } 
	}

    /**
     * Summons a unit with zero cost
     * @param type
     *          the type of the summoned unit
     */
    public void summonfreeEntity(final int type) {
		summonEntity(0, type); 
	}

    /**
     * Builds a new Turret and then subtracts the cost from the total money
     * @param cost
     *          the cost of the turret
     */
    public boolean buildTurret(final int cost){
        if(cost <= this.getMoney())  {
            this.turret = new Turret();
            this.money -= cost;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Summons an enemy with a random chance of being different ones
     */
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

    /**
     * Removes all dead entities from the entities lists
     */
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

    /**
     * Calls for the graphic methods to draw them on screen
     * @param g
     *        graphic object used to draw all components
     */
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
    }
    
    /**
     * Updates the state of the game
     */
    public void update(){
        this.getWaveManager().spawnWave();
        removeDeads();
        ai.useAI();
        this.updateScoreMoney();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getHp() {
        return this.hp;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Point getPosition() {
        return this.position;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getSpeed() {
        return this.speed;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getDamage() {
       return this.damage;
    }

    /**
     * If an hit occurred subtracts the amount of damage to the tower current hp
     * @param value 
     *          amount of incoming damage
     */
    public void incomeDamage(final int value) {
        if(lastTime+1500<System.currentTimeMillis()){
            lastTime=System.currentTimeMillis();

            Sfx SFX=new Sfx();
            SFX.startSFX("HitOnTower");

        }
        this.hp -= value;
    }

    /**
     * @return
     *      the total score obtained
     */
    public int getScore() {
        return this.score;
    }

    /**
     * @return 
     *      the current amount of money
     */
    public int getMoney() {
        return this.money;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Rectangle getHitbox() {
        return this.hitbox;
    }

    /**
     * @return 
     *      the current number of entities
     */
    public int getEntitiesNumber(){
        return this.entities.size();
    }

    /**
     * @return an instance of WaveManager
     */
    public WaveManagerSingleton getWaveManager(){
        return WaveManagerSingleton.getInstance();
    }

    /**
     * Updates the score and money values
     */
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

    /**
     * @return
     *      the max HP value of the Tower
     */
    public int getMaxHp() {
        return this.maxHp;
    }

    /**
     * @return 
     *      a list of all the entities
     */
    public LinkedList<MovingEntity> getEntities() {
        return this.entities;
    }

    /**
     * @return
     *      a list of all the enemies
     */
    public LinkedList<MovingEntity> getEnemies() {
        return this.enemies;
    }

    /**
     * @return
     *       the turret associated with this tower
     */
    public Turret getTurret(){
        return this.turret;
    }

    /**
     * Removes money from the current total
     * @param amount
     *          amount of money to subtract
     */
    public void removeMoney(int amount) {
        this.money -= amount;
    }
}


