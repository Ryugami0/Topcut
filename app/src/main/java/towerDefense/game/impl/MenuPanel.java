package towerDefense.game.impl;

import javax.swing.JButton;

import towerDefense.Constants;
import towerDefense.game.api.Panel;

import java.awt.Desktop;
import java.awt.Graphics;
import java.io.IOException;
import java.nio.file.Paths;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class MenuPanel extends Panel{

    private BufferedImage background;
    private BufferedImage castle;

    public MenuPanel() {

        super.startSound(Constants.menuPanel);

        try {
            this.castle = ImageIO.read(this.getClass().getResource("../../Assets/Backgrounds/castle2.png"));
            this.background = ImageIO.read(this.getClass().getResource("../../Assets/Backgrounds/Menu.png"));
        } catch (IOException e) {
            System.out.println("error loading background " + e.getMessage());
        }

        JButton startGame = new JButton("Start game");
        startGame.addActionListener((arg) -> {
            stopMusic();
            super.startSound(Constants.buttonSFX);
            GameImpl.setCurrentPanel(new GamePanel());
        });

        JButton bestScores = new JButton("Best Scores");
        bestScores.addActionListener((arg) -> {
            try {
                super.startSound(Constants.buttonSFX);
                Desktop.getDesktop().open(Paths.get("").toAbsolutePath().resolve("app/src/main/java/TowerDefense/Assets/SaveFile.txt").toFile());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        JButton rules = new JButton("Rules");
        rules.addActionListener((arg) -> {
            stopMusic();
            super.startSound(Constants.buttonSFX);
            GameImpl.setCurrentPanel(new RulePanel());
        }); 

        this.add(startGame);
        this.add(bestScores);
        this.add(rules);
    }

    public void stopMusic() {
        super.stopMusic();
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
        g.drawImage(castle,(int)(Constants.width-265),295,null);
    }
}
