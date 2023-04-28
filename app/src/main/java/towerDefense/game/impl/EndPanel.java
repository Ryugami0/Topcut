package towerDefense.game.impl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JTextField;

import towerDefense.Constants;
import towerDefense.entities.impl.TowerSingleton;
import towerDefense.game.api.Panel;

public class EndPanel extends Panel{

    private static Path saveFile;

    public EndPanel() {

        super.startSound(Constants.gameOverSFX);
        super.startSound(Constants.endPanel);

        JButton Exit = new JButton("Exit");
        Exit.addActionListener((arg) ->System.exit(0));
        this.add(Exit);

        saveFile = Paths.get("").toAbsolutePath().resolve("app/src/main/java/TowerDefense/Assets/SaveFile.txt");
        JButton saveScore = new JButton("Save Score");
        JTextField nameScore = new JTextField("             ");
        TowerSingleton tower = TowerSingleton.getInstance();

        saveScore.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Files.writeString(saveFile, Files.readString(saveFile) + 
                        "\n" + 
                        nameScore.getText() +
                        String.valueOf(tower.getScore()), 
                        StandardCharsets.UTF_8);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                saveScore.setEnabled(false);
            }
            
        });

        this.add(saveScore);
        this.add(nameScore);
    }
    
}
