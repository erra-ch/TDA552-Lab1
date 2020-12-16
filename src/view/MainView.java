package view;

import javax.swing.*;
import java.awt.*;


public class MainView extends JFrame {

    private static final int x = 800;
    private static final int y = 900;


    public MainView(String title, int windowX, int windowY) {
        initMainView(title);
    }

    private void initMainView(String title) {

        this.setTitle(title);
        this.pack();
        this.setSize(new Dimension(x,y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
