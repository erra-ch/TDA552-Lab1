package view;

import lib.*;
import model.Observer;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class InfoView extends JPanel implements Observer {

    private int X;
    private int Y;

    private List<Vehicle> state;

    public InfoView(int x, int y) {
        this.X = x;
        this.Y = y;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.ORANGE);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int temp = 15;
        for (Vehicle v : state) {
            g.drawString(v.getModelName() + " : " + (v.getCurrentSpeed()), 10, temp); //String, int x, int y
            temp += 15;
        }
    }

    public void stateUpdated(List<Vehicle> newState) {
        this.state = newState;
        this.repaint();
    }
}
