package TowerDefense.Game;

public class Game {

    private gamepanel gamePanel;
    
	public Game() {
        
        this.gamePanel = new gamepanel();
        GameWindow gameWindow = new GameWindow(gamePanel); 
        
    }

    public gamepanel getGamePanel() {
        return this.gamePanel;
    }
}
