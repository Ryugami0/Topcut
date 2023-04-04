package TowerDefense.Game;

import javax.imageio.ImageIO;
import javax.swing.JButton;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPopupMenu.Separator;

import TowerDefense.Entities.Impl.TowerSingleton;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GamePanel extends JPanel {

    TowerSingleton tower;
    BufferedImage background;
     
    public GamePanel() {
        this.tower = TowerSingleton.getInstance();
        try{
            this.background = ImageIO.read(new File("D:/Downloads/War-of-Ages-master - Copia/WarOfAges/src/Assets/Backgrounds/Game.jpg"));
        }catch(Exception e){
            System.out.println("error loading background " + e.getMessage());
        }
        JButton summon = new JButton("summon");
        JTextField text = new JTextField("0");

        this.add(summon);
        this.add(text);

        summon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                tower.queueCreature(10, 1);
                text.setText(tower.getSummonQueueSize());
                System.out.println("button clicked");
            }
        });

        Path saveFile = Paths.get(".").toAbsolutePath().resolve("./Assets/SaveFile.txt");
        JButton saveScore = new JButton("Save Score");
        JTextField nameScore = new JTextField("             ");

        saveScore.addActionListener(new ActionListener() {

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
            }
            
        });

        this.add(saveScore);
        this.add(nameScore);
        }
    
    public void update(){
        this.tower.update();
    }
        
    public void paintComponent(Graphics g) {
            //System.out.println("paintCompontent");
            super.paintComponent(g);
            g.drawImage(background, 0, 0, null);
            tower.draw(g);
        }


    
}
