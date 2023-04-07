package TowerDefense.gameLogic.Impl;


import TowerDefense.Entities.Impl.TowerSingleton;

public class WaveManager {
    long start;

    public WaveManager() {
        this.start = System.currentTimeMillis();
    }

    public void spawnnWave(){
        long now = System.currentTimeMillis();
        //System.out.println("start =" + start + "now =" + now);
        //System.out.println("diff =" +(start-now));
        if((now - start) >= 20000){
            System.out.println("diff =" + (now-start));
            for(int i = 0; i < 5; i++){
                TowerSingleton.getInstance().queueEnemy();
                start = now;
            }
        }
    }
}
