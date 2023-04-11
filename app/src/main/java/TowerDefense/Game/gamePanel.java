package TowerDefense.Game;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import TowerDefense.Entities.Impl.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GamePanel extends JPanel {

    private TowerSingleton tower;
    private BufferedImage background;
    private JLabel money;

    private static AudioInputStream audioStream;
    private static Clip music;
     
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
        JButton summonBarbarian = new JButton("Summon Barbarian" + " $" + Barbarian.getCost());
        JButton summonKnight=new JButton("Summon Knight"  + " $" + Knight.getCost());
        
        Timer timer = new Timer(1000, new MyTimerListener(summonBarbarian, summonKnight));
        timer.setRepeats(false);

        this.add(summonBarbarian);
        this.add(summonKnight);

        summonBarbarian.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                tower.queueCreature(Barbarian.getCost(), 1);

                summonBarbarian.setEnabled(false);
                summonKnight.setEnabled(false);

                //Delay di tempo in cui il bottone è disabilitato
                timer.start();
            }
        });

        summonKnight.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tower.queueCreature(Knight.getCost(), 2);

                summonBarbarian.setEnabled(false);
                summonKnight.setEnabled(false);

                //Delay di tempo in cui il bottone è disabilitato
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
        money.setText("$" + String.valueOf(tower.getMoney()));
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
        this.money.setText("$" + String.valueOf(tower.getMoney()));
    }
        
    public void paintComponent(Graphics g) {
            //System.out.println("paintCompontent");
            super.paintComponent(g);
            g.drawImage(background, 0, 0, null);
            tower.draw(g);
            this.drawHealtBar(g);
        }

    private void drawHealtBar(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(50, 600, 100, 20);
        g.setColor(Color.GREEN);
        g.fillRect(50, 600, 100*(tower.getHp()/tower.getMaxHp()), 20);
    } 
}
