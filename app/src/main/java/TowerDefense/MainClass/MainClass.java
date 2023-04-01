package TowerDefense.MainClass;

import TowerDefense.Game.Game;
import TowerDefense.gameLogic.Impl.GameLoop;

public class MainClass {
    public static void main(String[] args) {
        new GameLoop();
        new Game();
    }
}