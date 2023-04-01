package TowerDefense.Game;

import javax.swing.JPanel;
import java.awt.Graphics;

public class gamePanel extends JPanel {
     
    public gamePanel() {

        }
        
    public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.fillRect(100, 100, 100, 100);
           
        }
}
