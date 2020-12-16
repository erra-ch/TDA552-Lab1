package model;

import lib.Saab95;
import lib.Scania;
import lib.Vehicle;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Logic extends JFrame implements Observable {

    private List<Observer> observers;
    private List<Vehicle> vehicles;

    public Logic(){
        this.observers = new ArrayList<Observer>();
        this.vehicles = new ArrayList<Vehicle>();
    }

    public void update() {
        for ( Vehicle vehicle : vehicles ) {
            if (!isInside(vehicle)) {
                vehicle.turnRight();
                vehicle.turnRight();
            }
            vehicle.move();
        }
        notifyObservers();
    }

    public void notifyObservers() {
        for (Observer obs : observers) {
            obs.stateUpdated(vehicles);
        }
    }

    public void removeObserver(Observer obs) { observers.remove(obs); }

    public void addObserver(Observer obs) {
        observers.add(obs);
    }

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

    public void addVehicle(Vehicle v) {
        //moves the new vehicle 100 pixels down
        if (!vehicles.isEmpty() && vehicles.size() < 10) {
            int lastVehicleYpos = (int) vehicles.get(vehicles.size() - 1).getY();
            v.setY(lastVehicleYpos + 60);
            vehicles.add(v);
        } else if (vehicles.isEmpty()){
            vehicles.add(v);
        } else {
            System.out.println("10 cars is maximum");
        }
    }

    public void removeVehicle() {
        if (!vehicles.isEmpty()) {
            vehicles.remove(vehicles.size() - 1);
        } else {
            System.out.println("There is no cars to remove.");
        }
    }

    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles) {
            vehicle.gas(gas);
        }
    }

    // Calls the brake method for each car once
    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles) {
            vehicle.brake(brake);
        }
    }

    public void turnOffTurbo() {
        for (Vehicle vehicle : vehicles ) {
            if (vehicle.getClass().equals(Saab95.class)) {
                ((Saab95) vehicle).setTurboOff();
            }
        }
        System.out.println("Turbo: OFF");
    }

    public void turnOnTurbo() {
        for (Vehicle vehicle : vehicles ) {
            if (vehicle.getClass().equals(Saab95.class)) {
                ((Saab95) vehicle).setTurboOn();
            }
        }
        System.out.println("Turbo: ON");
    }

    public void raiseBed() {
        for (Vehicle vehicle : vehicles ) {
            if (vehicle.getClass().equals(Scania.class)) {
                ((Scania) vehicle).raiseFlatbed(70);
                System.out.println("Raised flatbed");
            }
        }
    }

    public void lowerBed() {
        for (Vehicle vehicle : vehicles ) {
            if (vehicle.getClass().equals(Scania.class)) {
                ((Scania) vehicle).lowerFlatbed(70);
                System.out.println("Lowered flatbed");
            }
        }
    }

    public void startAll() {
        for (Vehicle vehicle : vehicles) {
            vehicle.startEngine();
        }
        System.out.println("Started all cars");
    }

    public void stopAll() {
        for (Vehicle vehicle : vehicles) {
            vehicle.stopEngine();
        }
        System.out.println("Stopped all cars");
    }
}
