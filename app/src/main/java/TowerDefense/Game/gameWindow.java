package TowerDefense.Game;

import javax.swing.JFrame;

import TowerDefense.Constants;

public class GameWindow {

     private JFrame jFrame;

    public GameWindow(GamePanel gamePanel) {
        
        jFrame = new JFrame("Tower Defense");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize((int)Constants.width, (int)Constants.height);
        jFrame.add(gamePanel);
        jFrame.setVisible(true);
    }
   
    

    
}
