package towerDefense.game.impl;

import javax.imageio.ImageIO;
import javax.swing.*;
import towerDefense.Constants;
import towerDefense.entities.impl.*;
import towerDefense.game.api.Panel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class GamePanel extends Panel{

    private TowerSingleton tower = TowerSingleton.getInstance();;
    private BufferedImage background;
    private JLabel money;
    private JLabel score;
    private JButton summonBarbarian;
    private JButton summonKnight;
    private JButton summonArcher;
    private JButton buildTurret;
    private FinalMove fMove = new FinalMove();
    private ActionListener finalMoveListener;
    private final int finalMoveCost = 80;
     
    public GamePanel() {

        super.startSound(Constants.gamePanel);
        
        try{
            this.background = ImageIO.read(this.getClass().getResource("../../Assets/Backgrounds/Game.jpg"));
        }catch(Exception e){
            System.out.println("error loading background " + e.getMessage());
        }
        JButton summonBarbarian = new JButton("Summon Barbarian $" + Barbarian.getCost());
        JButton summonKnight=new JButton("Summon Knight $" + Knight.getCost());
        JButton summonArcher = new JButton("Summon Archer $" + Archer.getCost());
        JButton buildTurret = new JButton("Build Turret $" + Archer.getCost());
        JButton finalMove = new JButton("Double allies $" + finalMoveCost);
        
        Timer timer = new Timer(1000, new MyTimerListener(summonBarbarian, summonKnight, summonArcher, buildTurret));
        timer.setRepeats(false);

        Timer timer2 = new Timer(20000, finalMoveListener);
        timer2.setRepeats(false);

        this.add(summonBarbarian);
        this.add(summonKnight);
        this.add(summonArcher);
        this.add(buildTurret);

        summonBarbarian.addActionListener((arg) -> {
            tower.summonEntity(Barbarian.getCost(), 1);
                if(fMove.isActive()) {
                    tower.summonfreeEntity(1);
                }
                disableButtons();
                timer.start();
        }); 

        summonKnight.addActionListener((arg) -> {
            tower.summonEntity(Knight.getCost(), 2);
                if(fMove.isActive()) {
                    tower.summonfreeEntity(2);
                }
                disableButtons();
                timer.start();
        });

        summonArcher.addActionListener((arg) ->  {
            tower.summonEntity(Archer.getCost(), 3);
                if(fMove.isActive()) {
                    tower.summonfreeEntity(3);
                }
                disableButtons();
                timer.start();
            });
        
        buildTurret.addActionListener((arg) -> {
            tower.buildTurret(Turret.getCost(), 4);
            disableButtons();
            buildTurret.setVisible(false);
            timer.start();
        });

        this.add(finalMove);
        ActionListener finalMoveListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tower.getMoney() >= finalMoveCost) {
                    fMove.trigger();
                    finalMove.setEnabled(false);
                    timer2.start();
                }
            }
        };
        this.finalMoveListener = finalMoveListener;
        finalMove.addActionListener(finalMoveListener);

        JButton surrender = new JButton("Surrender");
        surrender.addActionListener((arg) -> {
            stopMusic();
            Game.setCurrentPanel(new EndPanel());
        });
        this.add(surrender);

        this.money = new JLabel();
        money.setText("$" + String.valueOf(tower.getMoney()));
        this.add(money);

        this.score = new JLabel();
        score.setText("SCORE: " + tower.getScore());
        this.add(score);

        this.summonBarbarian = summonBarbarian;
        this.summonKnight = summonKnight;
        this.summonArcher = summonArcher;
        this.buildTurret = buildTurret;
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
    
    private void disableButtons() {
        summonBarbarian.setEnabled(false);
        summonKnight.setEnabled(false);
        summonArcher.setEnabled(false);
        buildTurret.setEnabled(false);
    }

}
