package TowerDefense.Game;

public class Game {

    private GamePanel gamePanel;
    
	public Game() {
        
        this.gamePanel = new GamePanel();
        GameWindow gameWindow = new GameWindow(gamePanel);
        
    }

    public GamePanel getGamePanel() {
        return this.gamePanel;
    }
}
