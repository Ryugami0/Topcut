package towerDefense.game.impl;

import towerDefense.game.api.Panel;

public class Game {

    private static Panel currentPanel;
    private static GameWindow gameWindow;
    
	public Game() {   
        currentPanel = new MenuPanel();
        gameWindow = new GameWindow(currentPanel);     
    }

    public Panel getCurrentPanel() {
        return currentPanel;
    }

    public static void setCurrentPanel(Panel panel) {
        currentPanel = panel;
        gameWindow.changeWindow(panel);
    }
}
