package app.View;

import java.awt.Color;
import java.awt.Font;
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
    LinkedList<JTextField> names;
    LinkedList<JTextField> placements;
    LinkedList<Image> pokemons = new LinkedList<>();
    LinkedList<Image> teraTypes = new LinkedList<>();
    LinkedList<Image> itemsHeld = new LinkedList<>();

    public ImageFile(LinkedList<JTextField> names, LinkedList<JTextField> mons, LinkedList<JTextField> teras, LinkedList<JTextField> items) {     

        this.names = names;

        this.setSize(1080, 1080);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new GridLayout(3,8));
        
       for(int j = 0; j < 8; j++) {
            for(int i = 0; i < 6; i++) {
                try {
                pokemons.add(new ImageIcon(this.getClass().getResource("/Sprites/" + mons.get((j*6)+i).getText() + ".png")).getImage());
                } catch (Exception e) {
                System.out.println(mons.get((j*6)+i).getText() + " not found");
                }
            try {
                teraTypes.add(new ImageIcon(this.getClass().getResource("/Tera/" + teras.get((j*6)+i).getText() + ".png")).getImage());
                } catch (Exception e) {
                System.out.println(teras.get((j*6)+i).getText() + " not found");
                }
            try {
                itemsHeld.add(new ImageIcon(this.getClass().getResource("/Items/" + items.get((j*6)+i).getText() + ".png")).getImage());
                } catch (Exception e) {
                System.out.println(items.get((j*6)+i).getText() + " not found");
            }
            }       
        }
        this.setVisible(true);
        download();
        
    }

    public void paint(Graphics g) {

        Graphics2D gr = (Graphics2D) g;
        Graphics2D gg = (Graphics2D) g;
        try {
            gr.drawImage(ImageIO.read(this.getClass().getResource("/Background/TOP8.png")), 0, 0, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        gg.setFont(new Font("SANS_SERIF", Font.LAYOUT_LEFT_TO_RIGHT, 35));
        gg.setColor(Color.white);
        for(int j = 0; j < 1; j++) {
            for(int i = 0; i < 6; i++) {
                gg.drawString(names.get(j).getText(), 64, 190+(j*115)); 
                //gr.drawImage(pokemons.get((j * 6) + i), 480 + i * 100, 135 + (j * 115), 80, 80, null);
                //gr.drawImage(teraTypes.get((j * 6) + i), 465 + i * 100, 130 + (j * 115), 35, 35, null);
                //gr.drawImage(itemsHeld.get((j * 6) + i), 530 + i * 100, 190 + (j * 115), 35, 35, null);
            }
        }
    }
    
    private void download() {    
        
        File outputFile;
        String home = System.getProperty("user.name"); 
            
        BufferedImage screenshotImage = new BufferedImage(
                this.getWidth(), this.getHeight(),
                BufferedImage.TYPE_INT_RGB);
        this.paint(screenshotImage.getGraphics());
    
        if(Window.getDownload()) {
            outputFile = new File(home+"/Downloads/topcut.png");
        }
        else {
            outputFile = new File("topcut.png");
        }
        
        
        try {
            ImageIO.write(screenshotImage, "png", outputFile);
        } catch (IOException ex) {
            System.err.println("Image issues");
        }
    }   
    
}
