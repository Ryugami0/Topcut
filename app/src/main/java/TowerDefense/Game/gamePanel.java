package TowerDefense.Game;

import javax.imageio.ImageIO;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import TowerDefense.Entities.Impl.TowerSingleton;

import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GamePanel extends JPanel {

    TowerSingleton tower;
    BufferedImage background;
    JLabel money;

    static AudioInputStream audioStream;
    static Clip music;
     
    public GamePanel() {

        try {
            audioStream = AudioSystem.getAudioInputStream(this.getClass().getResource("../Music/alexander-nakarada-adventure.wav"));
            music = AudioSystem.getClip();
            music.open(audioStream);
        } catch (Exception e) {     
        }
        music.setFramePosition(0);
        music.start();

        this.tower = TowerSingleton.getInstance();
        try{
            this.background = ImageIO.read(this.getClass().getResource("../Assets/Backgrounds/Game.jpg"));
        }catch(Exception e){
            System.out.println("error loading background " + e.getMessage());
        }
        JButton summonBarbarian = new JButton("Summon Barbarian");
        JButton summonKnight=new JButton("Summon Knight");
        JTextField text = new JTextField("0");
        text.setEditable(false);
        
        Timer timer = new Timer(1000, new MyTimerListener(summonBarbarian, summonKnight));
        timer.setRepeats(false);

        this.add(summonBarbarian);
        this.add(summonKnight);
        this.add(text);

        summonBarbarian.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                tower.queueCreature(10, 1);
                text.setText(tower.getSummonQueueSize());

                summonBarbarian.setEnabled(false);
                summonKnight.setEnabled(false);

                //Deelay di tempo in cui il bottone è disabilitato
                timer.start();
            }
        });

        summonKnight.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tower.queueCreature(10, 2);
                text.setText(tower.getSummonQueueSize());

                summonBarbarian.setEnabled(false);
                summonKnight.setEnabled(false);

                //Deelay di tempo in cui il bottone è disabilitato
                timer.start();
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
        this.money = new JLabel();
        money.setText(String.valueOf(TowerSingleton.getInstance().getMoney()));
        this.add(money);
    }

    static class MyTimerListener implements ActionListener {
        JComponent Barbarian;
        JComponent Knight;

        public MyTimerListener(JComponent Barbarian, JComponent Knight) {
            this.Barbarian=Barbarian;
            this.Knight=Knight;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Barbarian.setEnabled(true);
            Knight.setEnabled(true);
        }

    }
    
    public void update(){
        this.tower.update();
        this.money.setText(String.valueOf(TowerSingleton.getInstance().getMoney()));
    }
        
    public void paintComponent(Graphics g) {
            //System.out.println("paintCompontent");
            super.paintComponent(g);
            g.drawImage(background, 0, 0, null);
            tower.draw(g);
        }


    
}
