package TowerDefense.game.impl;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;

import TowerDefense.entities.impl.*;
import TowerDefense.game.api.Panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class GamePanel extends Panel{

    private TowerSingleton tower;
    private BufferedImage background;
    private JLabel money;
    private JLabel score;

    private static AudioInputStream audioStream;
    private static Clip music;
     
    public GamePanel() {

        try {
            audioStream = AudioSystem.getAudioInputStream(this.getClass().getResource("../../music/alexander-nakarada-adventure.wav"));
            music = AudioSystem.getClip();
            music.open(audioStream);
            music.setFramePosition(0);
            music.start();
        } catch (Exception e) { 
            System.out.println(e);    
        }
    
        this.tower = TowerSingleton.getInstance();
        
        try{
            this.background = ImageIO.read(this.getClass().getResource("../../Assets/Backgrounds/Game.jpg"));
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

        JButton surrender = new JButton("Surrender");
        surrender.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Game.setGamePanel(new EndPanel());
                stopMusic();
            }
            
        });
        this.add(surrender);

        this.money = new JLabel();
        money.setText("$" + String.valueOf(tower.getMoney()));
        this.add(money);

        this.score = new JLabel();
        score.setText("SCORE: " + tower.getScore());
        this.add(score);
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
        this.score.setText("SCORE: " + tower.getScore());
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
    
    public static void stopMusic() {
        music.stop();
    }
}
