package towerDefense.gameLogic.impl;
import java.util.Random;

import towerDefense.entities.impl.TowerSingleton;

public class WaveManagerSingleton {
    long start;
    int waveSize;
    Random random = new Random();
    int counter;
    long timerWaves;
    TowerSingleton tower;
    GameLogicImpl gameLogicImpl = new GameLogicImpl();
    private static WaveManagerSingleton instance = null;
    

    private WaveManagerSingleton() {
        this.tower = TowerSingleton.getInstance();
        this.start = System.currentTimeMillis();
        this.waveSize = random.nextInt(2) + 2;
        for(int i = 0; i < waveSize; i++){
            gameLogicImpl.summonEnemy();
        }
        this.counter = 0;
        this.timerWaves = 10000;
    }

    public static WaveManagerSingleton getInstance() {
        if(instance == null) {
            instance = new WaveManagerSingleton();
        }
        return instance;
    }

    public void spawnWave(){
        long now = System.currentTimeMillis();
        if((now - start) >= timerWaves){
            for(int i = 0; i < waveSize; i++){
                gameLogicImpl.summonEnemy();
                start = now;
            }
            if(counter > 2) {
                this.waveSize++;
                this.timerWaves *= 1.2;
                this.counter = 0;
            } else {
                counter++;
            }
        }
    }
}
