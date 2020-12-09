package Lab2;
import Lab1.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        //-------- Task 1:  add saab and scania
        Vehicle saab = new Saab95();
        saab.setY(100);

        Vehicle scania = new Scania();
        scania.setY(200);
        cc.cars.add(saab);
        cc.cars.add(scania);
        cc.cars.add(new Volvo240());

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : cars) {
                if (!isInside(car)) {   //----- Task 1: Inside window
                    car.turnRight();
                    car.turnRight();
                }
                car.move();
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                frame.drawPanel.moveit(car, x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }
    //----- Task 1: Inside window
    boolean isInside(Vehicle car) {
        int nextCarXPos = (int) (car.getX() + car.getCurrentSpeed());
        int nextCarYPos = (int) (car.getY() + car.getCurrentSpeed());

        if (nextCarXPos + 100 > 800 && car.getDirection() == 1 ||   // Right
                (nextCarXPos < 0 && car.getDirection() == 3) ||     // Left
                (nextCarYPos < 0 && car.getDirection() == 0) ||     // Up
                (nextCarYPos + 100 > 600 && car.getDirection() == 2)) { // Down
            return false;
        }
        return true;
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars
                ) {
            car.gas(gas);
        }
    }
    //-------- Task 1: brake
    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.brake(brake);
        }
    }
    //-------- Task 1: add saab and scania
    public void turnOffTurbo() {
        for (Vehicle car : cars ) {
            if (car.getClass().equals(Saab95.class)) {
                ((Saab95) car).setTurboOff();
            }
        }
        System.out.println("Turbo: OFF");
    }

    public void turnOnTurbo() {
        for (Vehicle car : cars ) {
            if (car.getClass().equals(Saab95.class)) {
                ((Saab95) car).setTurboOn();
            }
        }
        System.out.println("Turbo: ON");
    }

    public void raiseBed() {
        for (Vehicle car : cars ) {
            if (car.getClass().equals(Scania.class)) {
                ((Scania) car).raiseFlatbed(70);
            }
        }
        System.out.println("Raised flatbed");
    }

    public void lowerBed() {
        for (Vehicle car : cars ) {
            if (car.getClass().equals(Scania.class)) {
                ((Scania) car).lowerFlatbed(70);
            }
        }
        System.out.println("Lowered flatbed");
    }

    public void startAll() {
        for (Vehicle car : cars) {
            car.startEngine();
        }
        System.out.println("Started all cars");
    }

    public void stopAll() {
        for (Vehicle car : cars) {
            car.stopEngine();
        }
        System.out.println("Stopped all cars");
    }
}
