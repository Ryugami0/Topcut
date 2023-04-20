package towerDefense.mainClass;

import towerDefense.game.impl.Game;
import towerDefense.gameLogic.impl.GameLoop;

public class MainClass {
    public static void main(String[] args) {
        Game game = new Game();
        new GameLoop(game);
    }
}
