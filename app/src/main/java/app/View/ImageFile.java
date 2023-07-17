package app.View;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ImageFile extends JFrame{
    String name;
    String placement;
    LinkedList<Image> pokemons = new LinkedList<>();
    LinkedList<Image> teraTypes = new LinkedList<>();
    LinkedList<Image> itemsHeld = new LinkedList<>();

    public ImageFile(String name, String placement, LinkedList<JTextField> mons, LinkedList<JTextField> teras, LinkedList<JTextField> items) {     

        this.setSize(900, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new GridLayout(3,8));

        this.name = name;
        this.placement = placement;
        
        for(int i = 0; i < mons.size(); i++) {
            try {
                pokemons.add(new ImageIcon(this.getClass().getResource("/Sprites/" + mons.get(i).getText() + ".png")).getImage());
                } catch (Exception e) {
                System.out.println("Pokèmon number " + (i+1) + " not found");
                }
            try {
                teraTypes.add(new ImageIcon(this.getClass().getResource("/Tera/" + teras.get(i).getText() + ".png")).getImage());
                } catch (Exception e) {
                System.out.println("Tera number " + (i+1) + " not found");
                }
            try {
                itemsHeld.add(new ImageIcon(this.getClass().getResource("/Items/" + items.get(i).getText() + ".png")).getImage());
                } catch (Exception e) {
                System.out.println("Item number " + (i+1) + " not found");
            }
        }
        this.setVisible(true);
        download();
        
    }

    public void paint(Graphics g) {
        Graphics2D gr = (Graphics2D) g;

        gr.drawString(name, 50, 150);
        gr.drawString(placement, 150, 150);
        for(int i = 0; i < pokemons.size(); i++) {
            gr.drawImage(pokemons.get(i), 250 + i * 100, 100, 100, 100, null);
            gr.drawImage(teraTypes.get(i), 330 + i * 100, 80, 20, 20, null);
            gr.drawImage(itemsHeld.get(i), 315 + i * 100, 190, 35, 35, null);
        }  
    }
    
    private void download() {                                             
            
            BufferedImage screenshotImage = new BufferedImage(
                    this.getWidth(), this.getHeight(),
                    BufferedImage.TYPE_INT_RGB);
            this.paint(screenshotImage.getGraphics());
            File outputFile = new File("topcut.png");
            try {
                ImageIO.write(screenshotImage, "png", outputFile);
            } catch (IOException ex) {
                System.err.println("ImageIsuues");
            }
        }   
    
}
