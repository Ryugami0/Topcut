package TowerDefense.Game;
<<<<<<< HEAD
=======

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
>>>>>>> a64da7964edadbfae6ca2e33e4bbf87b4a4af7fd
import javax.swing.JFrame;

public class GameWindow {

     private JFrame jFrame;

    public GameWindow(GamePanel gamePanel) {
        
        jFrame = new JFrame("Tower Defense");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        double width=Toolkit.getDefaultToolkit().getScreenSize().getWidth()/1.3;
        double height=Toolkit.getDefaultToolkit().getScreenSize().getHeight()/1.3;
        jFrame.setSize((int)width, (int)height);
        jFrame.add(gamePanel);
        jFrame.setVisible(true);
    }
   
    

    
}
