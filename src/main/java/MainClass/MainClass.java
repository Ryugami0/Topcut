package main.java.MainClass;

import main.java.gameLogic.Impl.GameLoop;

public class MainClass {
    public static void main(String[] args) {
        //new Board(size);
        GameLoop gameLoop = new GameLoop();
        gameLoop.run();
    }
}