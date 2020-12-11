package view;

import lib.*;
import model.Observer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

public class GameView extends JPanel implements Observer {

    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;

    private List<Vehicle> state;

    public GameView(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.darkGray);
        try {
            volvoImage = ImageIO.read(GameView.class.getResourceAsStream("pics/Volvo240.jpg"));
            saabImage = ImageIO.read(GameView.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(GameView.class.getResourceAsStream("pics/Scania.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Vehicle v : state) {
            if (v.getClass().equals(Volvo240.class)){
                g.drawImage(volvoImage, (int) v.getX(), (int) v.getY(), null);
            } else if (v.getClass().equals(Saab95.class)) {
                g.drawImage(saabImage, (int) v.getX(), (int) v.getY(), null);
            } else if (v.getClass().equals(Scania.class)) {
                g.drawImage(scaniaImage, (int) v.getX(), (int) v.getY(), null);
            }
        }
    }

    @Override
    public void stateUpdated(List<Vehicle> newState) {
        this.state = newState;
        this.repaint();
    }
}
