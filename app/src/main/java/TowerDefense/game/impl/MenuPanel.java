package TowerDefense.game.impl;

import javax.swing.JButton;
import TowerDefense.game.api.Panel;

import java.awt.Desktop;
import java.io.IOException;
import java.nio.file.Paths;


public class MenuPanel extends Panel{

    public MenuPanel() {

        JButton startGame = new JButton("Start game");
        startGame.addActionListener((arg) -> Game.setGamePanel(new GamePanel()));

        JButton bestScores = new JButton("Best Scores");
        bestScores.addActionListener((arg) -> {
            try {
                Desktop.getDesktop().open(Paths.get("").toAbsolutePath().resolve("app/src/main/java/TowerDefense/Assets/SaveFile.txt").toFile());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        JButton rules = new JButton("Rules");
        rules.addActionListener((arg) -> Game.setGamePanel(new RulePanel())); 

        this.add(startGame);
        this.add(bestScores);
        this.add(rules);
    }

    
    
}
