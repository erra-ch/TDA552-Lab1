import java.util.ArrayList;
import java.util.List;

public class Workshop< T extends Car > {

    private List<T> carsInGarage = new ArrayList<T>();

    private int garageSize;

    public Workshop(int size) { this.garageSize = size; }

    public void addCar(T car) {
        if (this.carsInGarage.size() < garageSize) {
            car.setMovableState(false);
            carsInGarage.add(car);
        }
    }

    public void removeCar(T car) { carsInGarage.remove(car); }

    public List<T>  getCarsInGarage() { return carsInGarage; }
}
