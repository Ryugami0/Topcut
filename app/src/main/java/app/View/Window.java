package app.View;

import java.awt.FlowLayout;

import javax.swing.*;

public class Window extends JFrame{

    public Window() {

        this.setSize(500, 100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new FlowLayout());

        JTextField name = new JTextField("Name");
        this.add(name);

        JTextField placement = new JTextField("placement");
        this.add(placement);

        JTextField pokemon1 = new JTextField("pokemon1");
        this.add(pokemon1);

        JTextField pokemon2 = new JTextField("pokemon2");
        this.add(pokemon2);

        JTextField pokemon3 = new JTextField("pokemon3");
        this.add(pokemon3);

        JTextField pokemon4 = new JTextField("pokemon4");
        this.add(pokemon4);

        JTextField pokemon5 = new JTextField("pokemon5");
        this.add(pokemon5);

        JTextField pokemon6 = new JTextField("pokemon6");
        this.add(pokemon6);

        JButton saveImage = new JButton("Save Image");
        this.add(saveImage);

		this.setVisible(true);

    }
    
}
