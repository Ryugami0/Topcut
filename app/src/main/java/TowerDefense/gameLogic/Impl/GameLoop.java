package TowerDefense.gameLogic.Impl;
import TowerDefense.Game.Game;

public class GameLoop extends Thread{

    private Game game;

    public GameLoop(Game game) {
        this.game = game;
        this.run();
        
    }
    
    @Override
    public void run() {
        
        while (true) {
            //System.out.println("running");
            update();
            game.getGamePanel().repaint();
            //System.out.println("repainted");
        }
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