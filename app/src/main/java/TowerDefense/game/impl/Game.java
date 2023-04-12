package TowerDefense.game.impl;

import TowerDefense.game.api.Panel;

public class Game {

    private static Panel panel;
    private static GameWindow gameWindow;
    
	public Game() {
        
        panel = new MenuPanel();
        gameWindow = new GameWindow(panel); 
        
    }

    public Panel getGamePanel() {
        return panel;
    }

    public static void setGamePanel(Panel panel1) {
        panel = panel1;
        gameWindow.changeWindow(panel1);
    }
}
