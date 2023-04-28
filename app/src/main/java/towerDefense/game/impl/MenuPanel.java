package towerDefense.game.impl;

import javax.swing.JButton;

import towerDefense.Constants;
import towerDefense.game.api.Panel;

import java.awt.Desktop;
import java.io.IOException;
import java.nio.file.Paths;


public class MenuPanel extends Panel{

    public MenuPanel() {

        super.startSound(Constants.menuPanel);

        JButton startGame = new JButton("Start game");
        startGame.addActionListener((arg) -> {
            stopMusic();
            super.startSound(Constants.buttonSFX);
            Game.setCurrentPanel(new GamePanel());
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
            Game.setCurrentPanel(new RulePanel());
        }); 

        this.add(startGame);
        this.add(bestScores);
        this.add(rules);
    }

    public void stopMusic() {
        super.stopMusic();
    }
    
}
