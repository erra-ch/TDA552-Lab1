package Lab1;

import java.awt.*;

public abstract class Truck extends Vehicle {
    /**
     * Constructor for abstract class of truck.
     *
     * @param nrDoors     Number of doors of the truck.
     * @param enginePower The power of the engine.
     * @param color       Color of the truck.
     * @param modelName   Model of the truck.
     */
    public Truck(int nrDoors, double enginePower, Color color, String modelName) {
        super(nrDoors, enginePower, color, modelName);
    }

    protected abstract double speedFactor();


}
