package TowerDefense.gameLogic.Impl;
import java.util.Random;

import TowerDefense.Entities.Impl.TowerSingleton;

public class WaveManager {
    long start;
    int waveSize;
    Random random = new Random();
    int counter;
    long timerWaves;

    public WaveManager() {
        this.start = System.currentTimeMillis();
        for(int i = 0; i < waveSize; i++){
            TowerSingleton.getInstance().queueEnemy();
        }
        this.waveSize = random.nextInt(2) + 2;
        this.counter = 0;
        this.timerWaves = 10000;
    }

    public void spawnWave(){
        long now = System.currentTimeMillis();
        //System.out.println("start =" + start + "now =" + now);
        //System.out.println("diff =" +(start-now));
        if((now - start) >= timerWaves){
            for(int i = 0; i < waveSize; i++){
                TowerSingleton.getInstance().queueEnemy();
                start = now;
            }
            if(counter > 4) {
                this.waveSize++;
                this.timerWaves *= 1.2;
                this.counter = 0;
            } else {
                counter++;
            }
        }
    }
}
