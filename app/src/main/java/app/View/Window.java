package app.View;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.LinkedList;

import javax.swing.*;

public class Window extends JFrame{

    public static boolean isDownloadFolder;

    public Window() {

        int width = Toolkit.getDefaultToolkit().getScreenSize().width;

        this.setSize((int)(width*0.8), (int)(width*0.5));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new GridLayout(32,7));

        JLabel nameText = new JLabel("Name");
        this.add(nameText);

        JLabel p1 = new JLabel("Pokemon 1");
        this.add(p1);

        JLabel p2 = new JLabel("Pokemon 2");
        this.add(p2);

        JLabel p3 = new JLabel("Pokemon 3");
        this.add(p3);

        JLabel p4 = new JLabel("Pokemon 4");
        this.add(p4);

        JLabel p5 = new JLabel("Pokemon 5");
        this.add(p5);

        JLabel p6 = new JLabel("Pokemon 6");
        this.add(p6);

        JLabel saveText = new JLabel("Save File");
        this.add(saveText);

        JTextField name = new JTextField();
        this.add(name);

        JTextField pokemon1 = new JTextField();
        this.add(pokemon1);

        JTextField pokemon2 = new JTextField();
        this.add(pokemon2);

        JTextField pokemon3 = new JTextField();
        this.add(pokemon3);

        JTextField pokemon4 = new JTextField();
        this.add(pokemon4);

        JTextField pokemon5 = new JTextField();
        this.add(pokemon5);

        JTextField pokemon6 = new JTextField();
        this.add(pokemon6);

        JButton saveImage = new JButton("Save in download folder");
        this.add(saveImage);

        JLabel filler = new JLabel("Tera Types");
        this.add(filler);

        JTextField tera1 = new JTextField();
        this.add(tera1);

        JTextField tera2 = new JTextField();
        this.add(tera2);

        JTextField tera3 = new JTextField();
        this.add(tera3);

        JTextField tera4 = new JTextField();
        this.add(tera4);

        JTextField tera5 = new JTextField();
        this.add(tera5);

        JTextField tera6 = new JTextField();
        this.add(tera6);

        JButton save2 = new JButton("Save here");
        this.add(save2);

        JLabel filler3 = new JLabel("Items held");
        this.add(filler3);

        JTextField item1 = new JTextField();
        this.add(item1);

        JTextField item2 = new JTextField();
        this.add(item2);

        JTextField item3 = new JTextField();
        this.add(item3);

        JTextField item4 = new JTextField();
        this.add(item4);

        JTextField item5 = new JTextField();
        this.add(item5);

        JTextField item6 = new JTextField();
        this.add(item6);

        JLabel filller2 = new JLabel();
        this.add(filller2);

        JLabel nameText_2 = new JLabel("Name");
        this.add(nameText_2);

        JLabel p1_2 = new JLabel("Pokemon 1");
        this.add(p1_2);

        JLabel p2_2 = new JLabel("Pokemon 2");
        this.add(p2_2);

        JLabel p3_2 = new JLabel("Pokemon 3");
        this.add(p3_2);

        JLabel p4_2 = new JLabel("Pokemon 4");
        this.add(p4_2);

        JLabel p5_2 = new JLabel("Pokemon 5");
        this.add(p5_2);

        JLabel p6_2 = new JLabel("Pokemon 6");
        this.add(p6_2);

        JLabel saveText_2 = new JLabel();
        this.add(saveText_2);

        JTextField name_2 = new JTextField();
        this.add(name_2);

        JTextField pokemon1_2 = new JTextField();
        this.add(pokemon1_2);

        JTextField pokemon2_2 = new JTextField();
        this.add(pokemon2_2);

        JTextField pokemon3_2 = new JTextField();
        this.add(pokemon3_2);

        JTextField pokemon4_2 = new JTextField();
        this.add(pokemon4_2);

        JTextField pokemon5_2 = new JTextField();
        this.add(pokemon5_2);

        JTextField pokemon6_2 = new JTextField();
        this.add(pokemon6_2);

        JLabel saveFiller_2 = new JLabel();
        this.add(saveFiller_2);

        JLabel filler_2 = new JLabel("Tera types");
        this.add(filler_2);

        JTextField tera1_2 = new JTextField();
        this.add(tera1_2);

        JTextField tera2_2 = new JTextField();
        this.add(tera2_2);

        JTextField tera3_2 = new JTextField();
        this.add(tera3_2);

        JTextField tera4_2 = new JTextField();
        this.add(tera4_2);

        JTextField tera5_2 = new JTextField();
        this.add(tera5_2);

        JTextField tera6_2 = new JTextField();
        this.add(tera6_2);

        JLabel filller_2 = new JLabel();
        this.add(filller_2);

        JLabel filler3_2 = new JLabel("Items held");
        this.add(filler3_2);

        JTextField item1_2 = new JTextField();
        this.add(item1_2);

        JTextField item2_2 = new JTextField();
        this.add(item2_2);

        JTextField item3_2 = new JTextField();
        this.add(item3_2);

        JTextField item4_2 = new JTextField();
        this.add(item4_2);

        JTextField item5_2 = new JTextField();
        this.add(item5_2);

        JTextField item6_2 = new JTextField();
        this.add(item6_2);

        JLabel filller2_2 = new JLabel();
        this.add(filller2_2);

        JLabel nameText_3 = new JLabel("Name");
        this.add(nameText_3);

        JLabel p1_3 = new JLabel("Pokemon 1");
        this.add(p1_3);

        JLabel p2_3 = new JLabel("Pokemon 2");
        this.add(p2_3);

        JLabel p3_3 = new JLabel("Pokemon 3");
        this.add(p3_3);

        JLabel p4_3 = new JLabel("Pokemon 4");
        this.add(p4_3);

        JLabel p5_3 = new JLabel("Pokemon 5");
        this.add(p5_3);

        JLabel p6_3 = new JLabel("Pokemon 6");
        this.add(p6_3);

        JLabel saveText_3 = new JLabel();
        this.add(saveText_3);

        JTextField name_3 = new JTextField();
        this.add(name_3);

        JTextField pokemon1_3 = new JTextField();
        this.add(pokemon1_3);

        JTextField pokemon2_3 = new JTextField();
        this.add(pokemon2_3);

        JTextField pokemon3_3 = new JTextField();
        this.add(pokemon3_3);

        JTextField pokemon4_3 = new JTextField();
        this.add(pokemon4_3);

        JTextField pokemon5_3 = new JTextField();
        this.add(pokemon5_3);

        JTextField pokemon6_3 = new JTextField();
        this.add(pokemon6_3);

        JLabel saveFiller_3 = new JLabel();
        this.add(saveFiller_3);

        JLabel filler_3 = new JLabel("Tera types");
        this.add(filler_3);

        JTextField tera1_3 = new JTextField();
        this.add(tera1_3);

        JTextField tera2_3 = new JTextField();
        this.add(tera2_3);

        JTextField tera3_3 = new JTextField();
        this.add(tera3_3);

        JTextField tera4_3 = new JTextField();
        this.add(tera4_3);

        JTextField tera5_3 = new JTextField();
        this.add(tera5_3);

        JTextField tera6_3 = new JTextField();
        this.add(tera6_3);

        JLabel filller_3 = new JLabel();
        this.add(filller_3);

        JLabel filler3_3 = new JLabel("Items held");
        this.add(filler3_3);

        JTextField item1_3 = new JTextField();
        this.add(item1_3);

        JTextField item2_3 = new JTextField();
        this.add(item2_3);

        JTextField item3_3 = new JTextField();
        this.add(item3_3);

        JTextField item4_3 = new JTextField();
        this.add(item4_3);

        JTextField item5_3 = new JTextField();
        this.add(item5_3);

        JTextField item6_3 = new JTextField();
        this.add(item6_3);

        JLabel filller2_3 = new JLabel();
        this.add(filller2_3);

        JLabel nameText_4 = new JLabel("Name");
        this.add(nameText_4);

        JLabel p1_4 = new JLabel("Pokemon 1");
        this.add(p1_4);

        JLabel p2_4 = new JLabel("Pokemon 2");
        this.add(p2_4);

        JLabel p3_4 = new JLabel("Pokemon 3");
        this.add(p3_4);

        JLabel p4_4 = new JLabel("Pokemon 4");
        this.add(p4_4);

        JLabel p5_4 = new JLabel("Pokemon 5");
        this.add(p5_4);

        JLabel p6_4 = new JLabel("Pokemon 6");
        this.add(p6_4);

        JLabel saveText_4 = new JLabel();
        this.add(saveText_4);

        JTextField name_4 = new JTextField();
        this.add(name_4);

        JTextField pokemon1_4 = new JTextField();
        this.add(pokemon1_4);

        JTextField pokemon2_4 = new JTextField();
        this.add(pokemon2_4);

        JTextField pokemon3_4 = new JTextField();
        this.add(pokemon3_4);

        JTextField pokemon4_4 = new JTextField();
        this.add(pokemon4_4);

        JTextField pokemon5_4 = new JTextField();
        this.add(pokemon5_4);

        JTextField pokemon6_4 = new JTextField();
        this.add(pokemon6_4);

        JLabel saveFiller_4 = new JLabel();
        this.add(saveFiller_4);

        JLabel filler_4 = new JLabel("Tera types");
        this.add(filler_4);

        JTextField tera1_4 = new JTextField();
        this.add(tera1_4);

        JTextField tera2_4 = new JTextField();
        this.add(tera2_4);

        JTextField tera3_4 = new JTextField();
        this.add(tera3_4);

        JTextField tera4_4 = new JTextField();
        this.add(tera4_4);

        JTextField tera5_4 = new JTextField();
        this.add(tera5_4);

        JTextField tera6_4 = new JTextField();
        this.add(tera6_4);

        JLabel filller_4 = new JLabel();
        this.add(filller_4);

        JLabel filler3_4 = new JLabel("Items held");
        this.add(filler3_4);

        JTextField item1_4 = new JTextField();
        this.add(item1_4);

        JTextField item2_4 = new JTextField();
        this.add(item2_4);

        JTextField item3_4 = new JTextField();
        this.add(item3_4);

        JTextField item4_4 = new JTextField();
        this.add(item4_4);

        JTextField item5_4 = new JTextField();
        this.add(item5_4);

        JTextField item6_4 = new JTextField();
        this.add(item6_4);

        JLabel filller2_4 = new JLabel();
        this.add(filller2_4);

        JLabel nameText_5 = new JLabel("Name");
        this.add(nameText_5);

        JLabel p1_5 = new JLabel("Pokemon 1");
        this.add(p1_5);

        JLabel p2_5 = new JLabel("Pokemon 2");
        this.add(p2_5);

        JLabel p3_5 = new JLabel("Pokemon 3");
        this.add(p3_5);

        JLabel p4_5 = new JLabel("Pokemon 4");
        this.add(p4_5);

        JLabel p5_5 = new JLabel("Pokemon 5");
        this.add(p5_5);

        JLabel p6_5 = new JLabel("Pokemon 6");
        this.add(p6_5);

        JLabel saveText_5 = new JLabel();
        this.add(saveText_5);

        JTextField name_5 = new JTextField();
        this.add(name_5);

        JTextField pokemon1_5 = new JTextField();
        this.add(pokemon1_5);

        JTextField pokemon2_5 = new JTextField();
        this.add(pokemon2_5);

        JTextField pokemon3_5 = new JTextField();
        this.add(pokemon3_5);

        JTextField pokemon4_5 = new JTextField();
        this.add(pokemon4_5);

        JTextField pokemon5_5 = new JTextField();
        this.add(pokemon5_5);

        JTextField pokemon6_5 = new JTextField();
        this.add(pokemon6_5);

        JLabel saveFiller_5 = new JLabel();
        this.add(saveFiller_5);

        JLabel filler_5 = new JLabel("Tera types");
        this.add(filler_5);

        JTextField tera1_5 = new JTextField();
        this.add(tera1_5);

        JTextField tera2_5 = new JTextField();
        this.add(tera2_5);

        JTextField tera3_5 = new JTextField();
        this.add(tera3_5);

        JTextField tera4_5 = new JTextField();
        this.add(tera4_5);

        JTextField tera5_5 = new JTextField();
        this.add(tera5_5);

        JTextField tera6_5 = new JTextField();
        this.add(tera6_5);

        JLabel filller_5 = new JLabel();
        this.add(filller_5);

        JLabel filler3_5 = new JLabel("Items held");
        this.add(filler3_5);

        JTextField item1_5 = new JTextField();
        this.add(item1_5);

        JTextField item2_5 = new JTextField();
        this.add(item2_5);

        JTextField item3_5 = new JTextField();
        this.add(item3_5);

        JTextField item4_5 = new JTextField();
        this.add(item4_5);

        JTextField item5_5 = new JTextField();
        this.add(item5_5);

        JTextField item6_5 = new JTextField();
        this.add(item6_5);

        JLabel filller2_5 = new JLabel();
        this.add(filller2_5);

        JLabel nameText_6 = new JLabel("Name");
        this.add(nameText_6);

        JLabel p1_6 = new JLabel("Pokemon 1");
        this.add(p1_6);

        JLabel p2_6 = new JLabel("Pokemon 2");
        this.add(p2_6);

        JLabel p3_6 = new JLabel("Pokemon 3");
        this.add(p3_6);

        JLabel p4_6 = new JLabel("Pokemon 4");
        this.add(p4_6);

        JLabel p5_6 = new JLabel("Pokemon 5");
        this.add(p5_6);

        JLabel p6_6 = new JLabel("Pokemon 6");
        this.add(p6_6);

        JLabel saveText_6 = new JLabel();
        this.add(saveText_6);

        JTextField name_6 = new JTextField();
        this.add(name_6);

        JTextField pokemon1_6 = new JTextField();
        this.add(pokemon1_6);

        JTextField pokemon2_6 = new JTextField();
        this.add(pokemon2_6);

        JTextField pokemon3_6 = new JTextField();
        this.add(pokemon3_6);

        JTextField pokemon4_6 = new JTextField();
        this.add(pokemon4_6);

        JTextField pokemon5_6 = new JTextField();
        this.add(pokemon5_6);

        JTextField pokemon6_6 = new JTextField();
        this.add(pokemon6_6);

        JLabel saveFiller_6 = new JLabel();
        this.add(saveFiller_6);

        JLabel filler_6 = new JLabel("Tera types");
        this.add(filler_6);

        JTextField tera1_6 = new JTextField();
        this.add(tera1_6);

        JTextField tera2_6 = new JTextField();
        this.add(tera2_6);

        JTextField tera3_6 = new JTextField();
        this.add(tera3_6);

        JTextField tera4_6 = new JTextField();
        this.add(tera4_6);

        JTextField tera5_6 = new JTextField();
        this.add(tera5_6);

        JTextField tera6_6 = new JTextField();
        this.add(tera6_6);

        JLabel filller_6 = new JLabel();
        this.add(filller_6);

        JLabel filler3_6 = new JLabel("Items held");
        this.add(filler3_6);

        JTextField item1_6 = new JTextField();
        this.add(item1_6);

        JTextField item2_6 = new JTextField();
        this.add(item2_6);

        JTextField item3_6 = new JTextField();
        this.add(item3_6);

        JTextField item4_6 = new JTextField();
        this.add(item4_6);

        JTextField item5_6 = new JTextField();
        this.add(item5_6);

        JTextField item6_6 = new JTextField();
        this.add(item6_6);

        JLabel filller2_6 = new JLabel();
        this.add(filller2_6);

        JLabel nameText_7 = new JLabel("Name");
        this.add(nameText_7);

        JLabel p1_7 = new JLabel("Pokemon 1");
        this.add(p1_7);

        JLabel p2_7 = new JLabel("Pokemon 2");
        this.add(p2_7);

        JLabel p3_7 = new JLabel("Pokemon 3");
        this.add(p3_7);

        JLabel p4_7 = new JLabel("Pokemon 4");
        this.add(p4_7);

        JLabel p5_7 = new JLabel("Pokemon 5");
        this.add(p5_7);

        JLabel p6_7 = new JLabel("Pokemon 6");
        this.add(p6_7);

        JLabel saveText_7 = new JLabel();
        this.add(saveText_7);

        JTextField name_7 = new JTextField();
        this.add(name_7);

        JTextField pokemon1_7 = new JTextField();
        this.add(pokemon1_7);

        JTextField pokemon2_7 = new JTextField();
        this.add(pokemon2_7);

        JTextField pokemon3_7 = new JTextField();
        this.add(pokemon3_7);

        JTextField pokemon4_7 = new JTextField();
        this.add(pokemon4_7);

        JTextField pokemon5_7 = new JTextField();
        this.add(pokemon5_7);

        JTextField pokemon6_7 = new JTextField();
        this.add(pokemon6_7);

        JLabel saveFiller_7 = new JLabel();
        this.add(saveFiller_7);

        JLabel filler_7 = new JLabel("Tera types");
        this.add(filler_7);
        JTextField tera1_7 = new JTextField();
        this.add(tera1_7);

        JTextField tera2_7 = new JTextField();
        this.add(tera2_7);

        JTextField tera3_7 = new JTextField();
        this.add(tera3_7);

        JTextField tera4_7 = new JTextField();
        this.add(tera4_7);

        JTextField tera5_7 = new JTextField();
        this.add(tera5_7);

        JTextField tera6_7 = new JTextField();
        this.add(tera6_7);

        JLabel filller_7 = new JLabel();
        this.add(filller_7);

        JLabel filler3_7 = new JLabel("Items held");
        this.add(filler3_7);

        JTextField item1_7 = new JTextField();
        this.add(item1_7);

        JTextField item2_7 = new JTextField();
        this.add(item2_7);

        JTextField item3_7 = new JTextField();
        this.add(item3_7);

        JTextField item4_7 = new JTextField();
        this.add(item4_7);

        JTextField item5_7 = new JTextField();
        this.add(item5_7);

        JTextField item6_7 = new JTextField();
        this.add(item6_7);

        JLabel filller2_7 = new JLabel();
        this.add(filller2_7);

        JLabel nameText_8 = new JLabel("Name");
        this.add(nameText_8);

        JLabel p1_8 = new JLabel("Pokemon 1");
        this.add(p1_8);

        JLabel p2_8 = new JLabel("Pokemon 2");
        this.add(p2_8);

        JLabel p3_8 = new JLabel("Pokemon 3");
        this.add(p3_8);

        JLabel p4_8 = new JLabel("Pokemon 4");
        this.add(p4_8);

        JLabel p5_8 = new JLabel("Pokemon 5");
        this.add(p5_8);

        JLabel p6_8 = new JLabel("Pokemon 6");
        this.add(p6_8);

        JLabel saveText_8 = new JLabel();
        this.add(saveText_8);

        JTextField name_8 = new JTextField();
        this.add(name_8);

        JTextField pokemon1_8 = new JTextField();
        this.add(pokemon1_8);

        JTextField pokemon2_8 = new JTextField();
        this.add(pokemon2_8);

        JTextField pokemon3_8 = new JTextField();
        this.add(pokemon3_8);

        JTextField pokemon4_8 = new JTextField();
        this.add(pokemon4_8);

        JTextField pokemon5_8 = new JTextField();
        this.add(pokemon5_8);

        JTextField pokemon6_8 = new JTextField();
        this.add(pokemon6_8);

        JLabel saveFiller_8 = new JLabel();
        this.add(saveFiller_8);

        JLabel filler_8 = new JLabel("Tera types");
        this.add(filler_8);

        JTextField tera1_8 = new JTextField();
        this.add(tera1_8);

        JTextField tera2_8 = new JTextField();
        this.add(tera2_8);

        JTextField tera3_8 = new JTextField();
        this.add(tera3_8);

        JTextField tera4_8 = new JTextField();
        this.add(tera4_8);

        JTextField tera5_8 = new JTextField();
        this.add(tera5_8);

        JTextField tera6_8 = new JTextField();
        this.add(tera6_8);

        JLabel filller_8 = new JLabel();
        this.add(filller_8);

        JLabel filler3_8 = new JLabel("Items held");
        this.add(filler3_8);

        JTextField item1_8 = new JTextField();
        this.add(item1_8);

        JTextField item2_8 = new JTextField();
        this.add(item2_8);

        JTextField item3_8 = new JTextField();
        this.add(item3_8);

        JTextField item4_8 = new JTextField();
        this.add(item4_8);

        JTextField item5_8 = new JTextField();
        this.add(item5_8);

        JTextField item6_8 = new JTextField();
        this.add(item6_8);

        JLabel filller2_8 = new JLabel();
        this.add(filller2_8);

        LinkedList<JTextField> names = new LinkedList<>();
        names.add(name);
        names.add(name_2);
        names.add(name_3);
        names.add(name_4);
        names.add(name_5);
        names.add(name_6);
        names.add(name_7);
        names.add(name_8);

        LinkedList<JTextField> mons = new LinkedList<>();
        mons.add(pokemon1);
        mons.add(pokemon2);
        mons.add(pokemon3);
        mons.add(pokemon4);
        mons.add(pokemon5);
        mons.add(pokemon6);
        mons.add(pokemon1_2);
        mons.add(pokemon2_2);
        mons.add(pokemon3_2);
        mons.add(pokemon4_2);
        mons.add(pokemon5_2);
        mons.add(pokemon6_2);
        mons.add(pokemon1_3);
        mons.add(pokemon2_3);
        mons.add(pokemon3_3);
        mons.add(pokemon4_3);
        mons.add(pokemon5_3);
        mons.add(pokemon6_3);
        mons.add(pokemon1_4);
        mons.add(pokemon2_4);
        mons.add(pokemon3_4);
        mons.add(pokemon4_4);
        mons.add(pokemon5_4);
        mons.add(pokemon6_4);
        mons.add(pokemon1_5);
        mons.add(pokemon2_5);
        mons.add(pokemon3_5);
        mons.add(pokemon4_5);
        mons.add(pokemon5_5);
        mons.add(pokemon6_5);
        mons.add(pokemon1_6);
        mons.add(pokemon2_6);
        mons.add(pokemon3_6);
        mons.add(pokemon4_6);
        mons.add(pokemon5_6);
        mons.add(pokemon6_6);
        mons.add(pokemon1_7);
        mons.add(pokemon2_7);
        mons.add(pokemon3_7);
        mons.add(pokemon4_7);
        mons.add(pokemon5_7);
        mons.add(pokemon6_7);
        mons.add(pokemon1_8);
        mons.add(pokemon2_8);
        mons.add(pokemon3_8);
        mons.add(pokemon4_8);
        mons.add(pokemon5_8);
        mons.add(pokemon6_8);

        LinkedList<JTextField> items = new LinkedList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);
        items.add(item1_2);
        items.add(item2_2);
        items.add(item3_2);
        items.add(item4_2);
        items.add(item5_2);
        items.add(item6_2);
        items.add(item1_3);
        items.add(item2_3);
        items.add(item3_3);
        items.add(item4_3);
        items.add(item5_3);
        items.add(item6_3);
        items.add(item1_4);
        items.add(item2_4);
        items.add(item3_4);
        items.add(item4_4);
        items.add(item5_4);
        items.add(item6_4);
        items.add(item1_5);
        items.add(item2_5);
        items.add(item3_5);
        items.add(item4_5);
        items.add(item5_5);
        items.add(item6_5);
        items.add(item1_6);
        items.add(item2_6);
        items.add(item3_6);
        items.add(item4_6);
        items.add(item5_6);
        items.add(item6_6);
        items.add(item1_7);
        items.add(item2_7);
        items.add(item3_7);
        items.add(item4_7);
        items.add(item5_7);
        items.add(item6_7);
        items.add(item1_8);
        items.add(item2_8);
        items.add(item3_8);
        items.add(item4_8);
        items.add(item5_8);
        items.add(item6_8);

        LinkedList<JTextField> teras = new LinkedList<>();
        teras.add(tera1);
        teras.add(tera2);
        teras.add(tera3);
        teras.add(tera4);
        teras.add(tera5);
        teras.add(tera6);
        teras.add(tera1_2);
        teras.add(tera2_2);
        teras.add(tera3_2);
        teras.add(tera4_2);
        teras.add(tera5_2);
        teras.add(tera6_2);
        teras.add(tera1_3);
        teras.add(tera2_3);
        teras.add(tera3_3);
        teras.add(tera4_3);
        teras.add(tera5_3);
        teras.add(tera6_3);
        teras.add(tera1_4);
        teras.add(tera2_4);
        teras.add(tera3_4);
        teras.add(tera4_4);
        teras.add(tera5_4);
        teras.add(tera6_4);
        teras.add(tera1_5);
        teras.add(tera2_5);
        teras.add(tera3_5);
        teras.add(tera4_5);
        teras.add(tera5_5);
        teras.add(tera6_5);
        teras.add(tera1_6);
        teras.add(tera2_6);
        teras.add(tera3_6);
        teras.add(tera4_6);
        teras.add(tera5_6);
        teras.add(tera6_6);
        teras.add(tera1_7);
        teras.add(tera2_7);
        teras.add(tera3_7);
        teras.add(tera4_7);
        teras.add(tera5_7);
        teras.add(tera6_7);
        teras.add(tera1_8);
        teras.add(tera2_8);
        teras.add(tera3_8);
        teras.add(tera4_8);
        teras.add(tera5_8);
        teras.add(tera6_8);





        saveImage.addActionListener((arg) -> {
            isDownloadFolder = true;
            new ImageFile(names, mons, teras, items);
        });

        save2.addActionListener((arg) -> {
            isDownloadFolder = false;
            new ImageFile(names, mons, teras, items);
        });

		this.setVisible(true);
    }

    public static boolean getDownload() {
        return isDownloadFolder;
    }
}
