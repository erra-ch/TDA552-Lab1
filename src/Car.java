import java.awt.*;

/**
 * Car class
 */
public abstract class Car extends Vehicle {

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
    }

    /**
     * Speed factor of the car
     *
     * @return the speed factor
     */
    protected abstract double speedFactor();

}
