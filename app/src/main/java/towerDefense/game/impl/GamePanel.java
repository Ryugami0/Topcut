package towerDefense.game.impl;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.event.AncestorListener;

import towerDefense.Constants;
import towerDefense.entities.impl.*;
import towerDefense.game.api.Panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.EventListener;

public class GamePanel extends Panel{

    private TowerSingleton tower = TowerSingleton.getInstance();;
    private BufferedImage background;
    private JLabel money;
    private JLabel score;
     
    public GamePanel() {

        super.startSound(Constants.gamePanel);
        
        try{
            this.background = ImageIO.read(this.getClass().getResource("../../Assets/Backgrounds/Game.jpg"));
        }catch(Exception e){
            System.out.println("error loading background " + e.getMessage());
        }
        JButton summonBarbarian = new JButton("Summon Barbarian" + " $" + Barbarian.getCost());
        JButton summonKnight=new JButton("Summon Knight"  + " $" + Knight.getCost());
        JButton summonArcher = new JButton("Summon Archer" + " $" + Archer.getCost());
        JButton buildTurret = new JButton("Build Turret" + " $" + Archer.getCost());
        
        Timer timer = new Timer(1000, new MyTimerListener(summonBarbarian, summonKnight, summonArcher, buildTurret));
        timer.setRepeats(false);

        this.add(summonBarbarian);
        this.add(summonKnight);
        this.add(summonArcher);
        this.add(buildTurret);

        summonBarbarian.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                tower.summonEntity(Barbarian.getCost(), 1);
                summonBarbarian.setEnabled(false);
                summonKnight.setEnabled(false);
                summonArcher.setEnabled(false);
                buildTurret.setEnabled(false);

                //Delay di tempo in cui il bottone è disabilitato
                timer.start();
            }
        });

        summonKnight.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tower.summonEntity(Knight.getCost(), 2);

                summonBarbarian.setEnabled(false);
                summonKnight.setEnabled(false);
                summonArcher.setEnabled(false);
                buildTurret.setEnabled(false);

                //Delay di tempo in cui il bottone è disabilitato
                timer.start();
            }           
        });

        summonArcher.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tower.summonEntity(Archer.getCost(), 3);

                summonBarbarian.setEnabled(false);
                summonKnight.setEnabled(false);
                summonArcher.setEnabled(false);
                buildTurret.setEnabled(false);

                //Delay di tempo in cui il bottone è disabilitato
                timer.start();
            }           
        });

        

        buildTurret.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tower.buildTurret(Turret.getCost(), 4);
                
                summonBarbarian.setEnabled(false);
                summonKnight.setEnabled(false);
                summonArcher.setEnabled(false);
                buildTurret.setEnabled(false);
                buildTurret.setVisible(false);
                
                //Delay di tempo in cui il bottone è disabilitato
                timer.start();
            }           
        });

        JButton surrender = new JButton("Surrender");
        surrender.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                stopMusic();
                Game.setCurrentPanel(new EndPanel());
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
        JComponent barbarian;
        JComponent knight;
        JComponent archer;
        JComponent turret;

        public MyTimerListener(JComponent barbarian, JComponent knight, JComponent archer, JComponent turret) {
            this.barbarian=barbarian;
            this.knight=knight;
            this.archer=archer;
            this.turret=turret;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            barbarian.setEnabled(true);
            knight.setEnabled(true);
            archer.setEnabled(true);
            turret.setEnabled(true);
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
        g.fillRect(50, 600, (int)(100*((float)tower.getHp()/(float)tower.getMaxHp())), 20);
    } 
    
    public void stopMusic() {
        super.stopMusic();
    }
}
