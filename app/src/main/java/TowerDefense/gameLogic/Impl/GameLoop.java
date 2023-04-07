package TowerDefense.gameLogic.Impl;
import TowerDefense.Entities.Impl.TowerSingleton;
import TowerDefense.Game.Game;

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
        System.out.print("end game");
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