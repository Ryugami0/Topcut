package towerDefense.gameLogic.impl;
import towerDefense.entities.impl.TowerSingleton;
import towerDefense.game.impl.EndPanel;
import towerDefense.game.impl.GameImpl;

public class GameLoop extends Thread{

    private GameImpl game;

    public GameLoop(GameImpl game) {
        this.game = game;
        this.run();
    }
    
    @Override
    public void run() {
        
        while (TowerSingleton.getInstance().getHp() >= 0) {
            update();
            game.getCurrentPanel().repaint();
        }
        GameImpl.setCurrentPanel(new EndPanel());
    }

    private void update() {
        game.getCurrentPanel().update();

        try {
            GameLoop.sleep((long)(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}