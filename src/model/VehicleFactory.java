package model;

import lib.Saab95;
import lib.Scania;
import lib.Volvo240;

public abstract class VehicleFactory {

    public static Saab95 createSaab() {
        return new Saab95();
    }

    public static Scania createScania() {
        return new Scania();
    }

    public static Volvo240 createVolvo() {
        return new Volvo240();
    }

}