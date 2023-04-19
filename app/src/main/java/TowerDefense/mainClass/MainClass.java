package TowerDefense.mainClass;

import TowerDefense.game.impl.Game;
import TowerDefense.gameLogic.impl.GameLoop;

public class MainClass {
    public static void main(String[] args) {
        Game game = new Game();
        new GameLoop(game);
    }
}
