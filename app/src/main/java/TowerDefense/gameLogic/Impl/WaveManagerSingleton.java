package TowerDefense.gameLogic.impl;
import java.util.Random;

import TowerDefense.entities.impl.TowerSingleton;

public class WaveManagerSingleton {
    long start;
    int waveSize;
    Random random = new Random();
    int counter;
    long timerWaves;
    TowerSingleton tower;
    private static WaveManagerSingleton instance = null;
    

    private WaveManagerSingleton() {
        this.tower = TowerSingleton.getInstance();
        this.start = System.currentTimeMillis();
        for(int i = 0; i < waveSize; i++){
            tower.queueEnemy();
        }
        this.waveSize = random.nextInt(2) + 2;
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
                tower.queueEnemy();
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

    public void reset() {
        instance = null;
    }
}
