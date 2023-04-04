package TowerDefense.Game;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;
<<<<<<< HEAD
import javax.swing.JPopupMenu.Separator;
=======
import javax.swing.SwingUtilities;
import javax.swing.Timer;
>>>>>>> a64da7964edadbfae6ca2e33e4bbf87b4a4af7fd

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
<<<<<<< HEAD
            this.background = ImageIO.read(new File("D:/Downloads/War-of-Ages-master - Copia/WarOfAges/src/Assets/Backgrounds/Game.jpg"));
=======
            this.background = ImageIO.read(this.getClass().getResource("../Assets/Backgrounds/Game.jpg"));
>>>>>>> a64da7964edadbfae6ca2e33e4bbf87b4a4af7fd
        }catch(Exception e){
            System.out.println("error loading background " + e.getMessage());
        }
        JButton summon = new JButton("summon");
        JTextField text = new JTextField("0");
        text.setEditable(false);
        Timer stopwatch = new Timer(1000, new MyTimerListener(summon));
        stopwatch.setRepeats(false);

        this.add(summon);
        this.add(text);

        summon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                tower.queueCreature(10, 1);
                text.setText(tower.getSummonQueueSize());
                //System.out.println("button clicked");
                summon.setEnabled(false);
                //aggiungere un deelay di tempo in cui il bottone è disabilitato
                stopwatch.start();
            }
        });

<<<<<<< HEAD
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
=======
    }

    static class MyTimerListener implements ActionListener {
        JComponent target;

        public MyTimerListener(JComponent target) {
            this.target = target;
>>>>>>> a64da7964edadbfae6ca2e33e4bbf87b4a4af7fd
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            target.setEnabled(true);
        }

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
