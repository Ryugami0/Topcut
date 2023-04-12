package TowerDefense.gameLogic.impl;
import TowerDefense.entities.impl.TowerSingleton;
import TowerDefense.game.impl.EndPanel;
import TowerDefense.game.impl.Game;
import TowerDefense.game.impl.GamePanel;

public class GameLoop extends Thread{

    private Game game;

    public GameLoop(Game game) {
        this.game = game;
        this.run();
    }
    
    @Override
    public void run() {
        
        while (TowerSingleton.getInstance().getHp() >= 0) {
            //System.out.println("running");
            update();
            game.getGamePanel().repaint();
            //System.out.println("repainted");
        }
        Game.setGamePanel(new EndPanel());
        GamePanel.stopMusic();
    }

    private void update() {
        game.getGamePanel().update();

        try {
            GameLoop.sleep((long)(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}