import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * The transporter class
 */
public class Transporter extends Truck implements CarTransportable {

    /**
     * A list that represents the trailer
     */
    private Deque<Car> trailer;

    /**
     * The ramp of the trailer
     */
    private Ramp ramp = new Ramp();

    public Transporter(double enginePower, Color color, String modelName) {
        super(2, enginePower, color, modelName);
        this.trailer = new ArrayDeque<Car>();
    }

    /**
     * Getter for the trailer
     *
     * @return deque (trailer)
     */
    public Deque<Car> getTrailer() { return trailer; }

    /**
     * Raises the ramp
     */
    public void rampUp() {
        ramp.setRampPos(RampPos.UP);
    }

    /**
     * Lowers the ramp
     */
    public void rampDown() {
        if (!this.isMoving())
            ramp.setRampPos(RampPos.DOWN);
    }

    /**
     * Checks if the car is close to the transporter
     *
     * @param car car
     * @return Returns true if the car is close enough to drive onto the transport
     */
    private boolean carIsClose(Car car) {
        if (Math.abs(this.getX() - car.getX()) <= 5 && Math.abs(this.getY() - car.getY()) <= 5) // Math.absolute to not get negative numbers since we're only looking for the difference
            return true;
        return false;
    }

    /**
     * Loads the transporter with car
     *
     * @param car car
     */
    @Override
    public void loadCar(Car car) {
        if (ramp.getRampPos() == RampPos.DOWN && carIsClose(car) && !this.isMoving() && car.isMovable() && car.isTransportable()) {
            car.stopEngine();
            car.setMovableState(false);
            trailer.add(car);
        }
    }

    /**
     * Unoads the last car on the trailer
     */
    @Override
    public void unloadCar() {
        if (ramp.getRampPos() == RampPos.DOWN) {
            Car unloadedCar = trailer.pop();
            unloadedCar.setMovableState(true);
            unloadedCar.setX(this.getX() + 5);
            unloadedCar.setY(this.getY() + 5);
        }
    }

    /**
     * Transporter move method
     */
    @Override
    public void move() {
        if(ramp.getRampPos() == RampPos.UP) {
            super.move();

            for (Car car : trailer) {
                car.setX(this.getX());
                car.setY(this.getY());
            }
        }
    }

    /**
     * Speedfactor for the transporter
     *
     * @return speedfactor
     */
    @Override
    protected double speedFactor() { return getEnginePower() * 0.01; }
}
