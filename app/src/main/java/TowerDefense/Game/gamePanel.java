package TowerDefense.Game;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import TowerDefense.Entities.Impl.TowerSingleton;

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

    TowerSingleton tower;
    BufferedImage background;
     
    public GamePanel() {
        this.tower = TowerSingleton.getInstance();
        try{
            this.background = ImageIO.read(this.getClass().getResource("../Assets/Backgrounds/Game.jpg"));
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
        JLabel money = new JLabel();
        money.setText(String.valueOf(TowerSingleton.getInstance().getMoney()));
        this.add(money);
    }

    static class MyTimerListener implements ActionListener {
        JComponent target;

        public MyTimerListener(JComponent target) {
            this.target = target;
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
