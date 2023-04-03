package TowerDefense.Game;

import javax.imageio.ImageIO;
import javax.swing.JButton;

import javax.swing.JPanel;
import javax.swing.JTextField;

import TowerDefense.Entities.Impl.TowerSingleton;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class gamePanel extends JPanel {

    TowerSingleton tower;
    BufferedImage background;
     
    public gamePanel() {
        this.tower = new TowerSingleton();
        try{
            this.background = ImageIO.read(new File("/Users/Cesco/Downloads/War-of-Ages-master - Copia/WarOfAges/src/Assets/Backgrounds/Game.jpg"));
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
