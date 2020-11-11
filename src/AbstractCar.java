import java.awt.*;
//TODO Comments
public abstract class AbstractCar implements Movable {

    private int nrDoors;

    private double enginePower;

    private double currentSpeed;

    private Color color;

    private String modelName;

    private double x;

    private double y;

    private int direction;  // 0 = UP
                            // 1 = Right
                            // 2 = Down
                            // 3 = Left

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
        this.x = 0;
        this.y = 0;
        this.direction = 0;
        stopEngine();
    }

    private void incrementSpeed(double amount) {
        this.setCurrentSpeed(Math.min(this.getCurrentSpeed() + this.speedFactor() * amount, this.getEnginePower())); // Math.min to not get above max speed
    }

    private void decrementSpeed(double amount) {
        this.setCurrentSpeed(Math.max(this.getCurrentSpeed() - this.speedFactor() * amount, 0)); // Math.max to not get negative speed
    }

    protected abstract double speedFactor();

    //TODO Gas and Brake
    public void gas(double amount) {
        this.incrementSpeed(amount);
    }

    public void brake(double amount) {
        this.decrementSpeed(amount);
    }


    @Override
    public void move() {
        switch (this.direction) {
            case 0:
                this.setY(this.getY() - this.getCurrentSpeed());    // Up - negative Y
                break;
            case 1:
                this.setX(this.getX() + this.getCurrentSpeed());    // Right - positive X
                break;
            case 2:
                this.setY(this.getY() + this.getCurrentSpeed());    // Down - positive Y
                break;
            case 3:
                this.setX(this.getX() - this.getCurrentSpeed());    // Left - negative X
                break;
            default:
                throw new IllegalArgumentException("Incorrect direction...");
        }
    }

    @Override
    public void turfLeft() {
        this.setDirection((this.getDirection() + 3) % 4);  // Modulo-4 counter
    }

    @Override
    public void turnRight() {
        this.setDirection((this.getDirection() + 1) % 4);
    }

    public void stopEngine() {
        currentSpeed = 0;
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

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}
