package TowerDefense.game.impl;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import TowerDefense.game.api.Panel;

public class RulePanel extends Panel{

    private BufferedImage background;

    public RulePanel() {

        try{
            this.background = ImageIO.read(this.getClass().getResource("../../Assets/Backgrounds/Rules.jpg"));
        }catch(Exception e){
            System.out.println("error loading background " + e.getMessage());
        }

        JButton goBack = new JButton("Go Back");
        goBack.addActionListener((arg) -> Game.setGamePanel(new MenuPanel()));

        this.add(goBack);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
    }
    
}
