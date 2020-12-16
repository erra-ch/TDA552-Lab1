package controller;


import model.Logic;
import model.VehicleFactory;

import javax.swing.*;

public class CarController extends JPanel {

    private Logic model;

    public CarController(Logic model) {
        this.model = model;
    }

    public void gas(int gasAmount) {
        model.gas(gasAmount);
    }

    public void brake(int gasAmount) {
        model.brake(gasAmount);
    }

    public void turnOffTurbo() {
        model.turnOffTurbo();
    }

    public void turnOnTurbo() {
        model.turnOnTurbo();
    }

    public void raiseBed() {
        model.raiseBed();
    }

    public void lowerBed() {
        model.lowerBed();
    }

    public void startAll() {
        model.startAll();
    }

    public void stopAll() {
        model.stopAll();
    }

    public void addSaab() {
        model.addVehicle(VehicleFactory.createSaab());
    }

    public void addVolvo() {
        model.addVehicle(VehicleFactory.createVolvo());
    }

    public void addScania() {
        model.addVehicle(VehicleFactory.createScania());
    }

    public void removeCar() {
        model.removeVehicle();
    }
}
