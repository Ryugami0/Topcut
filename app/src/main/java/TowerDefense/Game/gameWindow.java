package TowerDefense.Game;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class gameWindow {

     private JFrame jFrame;

    public gameWindow(gamePanel gamePanel) {
        
        jFrame = new JFrame("Tower Defense");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        double width=Toolkit.getDefaultToolkit().getScreenSize().getWidth()/1.3;
        double height=Toolkit.getDefaultToolkit().getScreenSize().getHeight()/1.3;
        jFrame.setSize((int)width, (int)height);
        jFrame.add(gamePanel);
        jFrame.setVisible(true);
    }
   
    

    
}
