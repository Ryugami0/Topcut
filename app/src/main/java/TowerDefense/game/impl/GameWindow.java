package TowerDefense.game.impl;

import javax.swing.JFrame;

import TowerDefense.Constants;
import TowerDefense.game.api.Panel;

public class GameWindow {

    private JFrame jFrame;

    public GameWindow(Panel gamePanel) {
        
        jFrame = new JFrame("Tower Defense");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize((int)Constants.width, (int)Constants.height);
        jFrame.add(gamePanel);
        jFrame.setVisible(true);
    }   

    public void changeWindow(Panel gamePanel) {
        jFrame.dispose();
        jFrame.setVisible(false);
        jFrame = new JFrame("Tower Defense");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize((int)Constants.width, (int)Constants.height);
        jFrame.add(gamePanel);
        jFrame.setVisible(true);
    }
}
