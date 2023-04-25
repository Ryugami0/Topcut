package towerDefense.game.impl;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JButton;

import towerDefense.Constants;
import towerDefense.game.api.Panel;

public class RulePanel extends Panel{

    private BufferedImage background;

    public RulePanel() {

        super.startSound(Constants.rulePanel);

        try{
            this.background = ImageIO.read(this.getClass().getResource("../../Assets/Backgrounds/Rules.jpg"));
        }catch(Exception e){
            System.out.println("error loading background " + e.getMessage());
        }

        JButton goBack = new JButton("Go Back");
        goBack.addActionListener((arg) -> {
            stopMusic();
            super.startSound(Constants.buttonSFX);
            Game.setCurrentPanel(new MenuPanel());
        });

        this.add(goBack);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
    }
    
    public void stopMusic() {
        super.stopMusic();
    }

}
