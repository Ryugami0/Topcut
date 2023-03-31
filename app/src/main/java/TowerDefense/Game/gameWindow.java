package TowerDefense.Game;

import javax.swing.JFrame;

public class gameWindow {

     private JFrame jFrame;

    public gameWindow(gamePanel gamePanel) {
        
        jFrame = new JFrame("Tower Defense");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(800, 600);
        jFrame.add(gamePanel);
        jFrame.setVisible(true);
        
        

    }
   
    

    
}
