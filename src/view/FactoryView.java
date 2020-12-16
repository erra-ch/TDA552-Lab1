package view;

import controller.CarController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FactoryView extends JPanel {

    private JButton newSaabButton = new JButton("New Saab");
    private JButton newVolvoButton = new JButton("New Volvo");
    private JButton newScaniaButton = new JButton("New Scania");
    private JButton removeCarButton = new JButton("Remove car");

    private CarController controller;

    private int x;
    private int y;

    public FactoryView(int x, int y, CarController controller) {
        this.controller = controller;
        this.x = x;
        this.y = y;
        initComponents();
    }

    public void initComponents() {

        this.setLayout(new GridLayout(2,2));
        this.add(newSaabButton, 0);
        this.add(newScaniaButton, 1);
        this.add(newVolvoButton, 2);
        this.add(removeCarButton, 3);

        this.setPreferredSize(new Dimension((x/2), 200));

        this.setBackground(Color.CYAN);


        newSaabButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.addSaab();
            }
        });

        newScaniaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.addScania();
            }
        });

        newVolvoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.addVolvo();
            }
        });

        removeCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.removeCar();
            }
        });
    }
}
