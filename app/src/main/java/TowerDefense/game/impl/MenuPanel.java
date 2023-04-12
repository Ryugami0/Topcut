package TowerDefense.game.impl;

import javax.swing.JButton;
import TowerDefense.game.api.Panel;

public class MenuPanel extends Panel{

    public MenuPanel() {

        JButton startGame = new JButton("Start game");
        startGame.addActionListener((arg) -> {
            Game.setGamePanel(new GamePanel());
        });
        JButton bestScores = new JButton("Best Scores");

        this.add(startGame);
        this.add(bestScores);

    }

    
    
}
