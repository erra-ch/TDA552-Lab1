package lib;

import java.awt.*;

/**
 * lib.Car class
 */
public abstract class Car extends Vehicle {

    private boolean isTransportable;

    /**
     * Constructor for abstract class of car
     *
     * @param nrDoors     Number of doors of the car
     * @param enginePower The power of the engine.
     * @param color       Color of the car
     * @param modelName   Model of the car
     */
    public Car(int nrDoors, double enginePower, Color color, String modelName) {
        super(nrDoors, enginePower, color, modelName);
        this.isTransportable = true;
    }

    /**
     * Tells if the car is able to be transported.
     *
     * @return boolean
     */
    public boolean isTransportable() {
        return isTransportable;
    }

    /**
     * Move method for cars
     */
    @Override
    public void move() {
        if (this.isMovable())
            super.move();
    }

    /**
     * Speed factor of the car
     *
     * @return the speed factor
     */
    protected abstract double speedFactor();

}
