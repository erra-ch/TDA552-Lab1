package Lab1;

import java.util.ArrayList;
import java.util.List;

/**
 * A mechanical workshop for cars
 *
 * @param <T> Has to be subtype of Lab1.Car-class
 */
public class Workshop< T extends Car > {

    /**
     * List of current cars in the garage
     */
    private List<T> carsInGarage = new ArrayList<T>();

    /**
     * Max amount of cars in the garage
     */
    private int garageSize;

    /**
     * Constructor for the workshop
     * @param size max-amount
     */
    public Workshop(int size) { this.garageSize = size; }

    /**
     * Add car to the workshop
     * @param car The car to add
     */
    public void addCar(T car) {
        if (this.carsInGarage.size() < garageSize) {
            car.setMovableState(false);
            carsInGarage.add(car);
        }
    }

    /**
     * Remove a car from the garage
     * @param car The car to remove
     */
    public void removeCar(T car) { carsInGarage.remove(car); }

    /**
     * Getter for current car in the garage
     *
     * @return the current garage
     */
    public List<T>  getCarsInGarage() { return carsInGarage; }
}
