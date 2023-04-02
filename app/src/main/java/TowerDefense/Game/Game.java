package TowerDefense.Game;

public class Game {
    public gamePanel gamePanel;
    
	public Game() {
        
        this.gamePanel = new gamePanel();
        gameWindow gameWindow = new gameWindow(gamePanel);
        
    }
}
