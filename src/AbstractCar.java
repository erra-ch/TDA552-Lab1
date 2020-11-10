import java.awt.*;

public abstract class AbstractCar {

    private int nrDoors;

    private double enginePower;

    private double currentSpeed;

    private Color color;

    private String modelName;

    /**
     *
     * @param nrDoors       Number of doors on the car.
     * @param enginePower   The power of the engine.
     * @param color         Color of the car.
     * @param modelName     Car model.
     */
    public AbstractCar(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        stopEngine();
    }

    private void incrementSpeed(double amount) {
        this.setCurrentSpeed(Math.min(this.getCurrentSpeed() + this.speedFactor() * amount, this.getEnginePower())); // Math.min to not get above max speed
    }

    private void decrementSpeed(double amount) {
        this.setCurrentSpeed(Math.max(this.getCurrentSpeed() - this.speedFactor() * amount, 0)); // Math.max to not get negative speed
    }

    protected abstract double speedFactor();

    public void gas(double amount) {
        this.incrementSpeed(amount);
    }

    public void brake(double amount) {
        this.decrementSpeed(amount);
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getModelName() {
        return modelName;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }
}
