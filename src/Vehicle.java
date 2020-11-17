
import java.awt.*;

/**
 * Abstract vehicle class
 */
public abstract class Vehicle implements Movable {
    /**
     * Number of Doors on the vehicle
     */
    private int nrDoors;
    /**
     * Engine power of the vehicle
     */
    private double enginePower;
    /**
     * Current speed of the vehicle
     */
    private double currentSpeed;
    /**
     * Color of the vehicle
     */
    private Color color;
    /**
     * Model of the vehicle
     */
    private String modelName;
    /**
     * X-position
     */
    private double x;
    /**
     * Y-position
     */
    private double y;
    /**
     * The direction the vehicle is heading
     */
    private int direction;  // 0 = UP
                            // 1 = Right
                            // 2 = Down
                            // 3 = Left

    private boolean isMovable;

    /**
     * Constructor for abstract class of vehicle
     *
     * @param nrDoors       Number of doors on the vehicle.
     * @param enginePower   The power of the engine.
     * @param color         Color of the vehicle.
     * @param modelName     vehicle model.
     */
    public Vehicle(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.x = 0;
        this.y = 0;
        this.direction = 0;
        this.isMovable = true;
        stopEngine();
    }

    /**
     * Tells if the vehicle can be moved
     *
     * @return boolean
     */
    public boolean isMovable() {
        return isMovable;
    }

    /**
     * Sets the state of the vehicles ability to move
     * @param state boolean
     */
    public void setMovableState(boolean state) {
        isMovable = state;
    }

    /**
     *  Tells if the vehicle is moving or not
     *
     * @return boolean
     */
    public boolean isMoving() {
        return getCurrentSpeed() != 0;
    }

    /**
     * Abstract method to increment the speed of the vehicle
     *
     * @param amount Amount to increase the speed with
     */
    private void incrementSpeed(double amount) {
        this.setCurrentSpeed(Math.min(this.getCurrentSpeed() + this.speedFactor() * amount, this.getEnginePower())); // Math.min to not get above max speed
    }

    /**
     * Abstract method to decrement the speed
     *
     * @param amount Amount to decrease the speed with
     */
    private void decrementSpeed(double amount) {
        this.setCurrentSpeed(Math.max(this.getCurrentSpeed() - this.speedFactor() * amount, 0)); // Math.max to not get negative speed
    }

    protected abstract double speedFactor();

    /**
     * Increases the speed of the vehicle
     *
     * @param amount Amount of speed
     */
    public void gas(double amount) {
        if (amount > 1) {
            this.incrementSpeed(1);
        } else if (amount <= 0) {
            this.incrementSpeed(0);
        } else {
            this.incrementSpeed(amount);
        }
    }

    /**
     * Decreases the speed of the vehicle
     *
     * @param amount Amount of speed
     */
    public void brake(double amount) {
        if (amount > 1) {
            this.decrementSpeed(1);
        } else if (amount <= 0) {
            this.decrementSpeed(0);
        } else {
            this.decrementSpeed(amount);
        }

    }

    /**
     * Method to move the vehicle in its direction
     */
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

        }
    }

    /**
     * Method to turn the vehicle left
     */
    @Override
    public void turnLeft() {
        this.setDirection((this.getDirection() + 3) % 4);  // Modulo-4 counter
    }

    /**
     * Method to turn the vehicle right
     */
    @Override
    public void turnRight() {
        this.setDirection((this.getDirection() + 1) % 4);
    }

    /**
     * Starts the engine of the vehicle
     */
    public void startEngine() { currentSpeed = 0.1; }

    /**
     * Stops the engine of the vehicle
     */
    public void stopEngine() {
        currentSpeed = 0;
    }

    /**
     * Getter for enginepower
     *
     * @return Returns the enginepower
     */
    public double getEnginePower() {
        return enginePower;
    }


    /**
     * Getter for current speed of the vehicle
     *
     * @return Returns the current speed of the vehicle
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * Sets current speed of the vehicle
     *
     * @param currentSpeed The speed to set the current speed to
     */
    public void setCurrentSpeed(double currentSpeed) { this.currentSpeed = currentSpeed; }

    /**
     * Getter for X-position
     *
     * @return Returns X-position of the vehicle
     */
    public double getX() {
        return x;
    }

    /**
     * Setter for X-position
     *
     * @param x The X-position the vehicle should have
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Getter for Y-position
     *
     * @return Returns Y-position of the vehicle
     */
    public double getY() {
        return y;
    }

    /**
     * Setter for Y-position
     *
     * @param y The Y-position the vehicle should have
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Getter for direction of the vehicle
     *
     * @return Returns the direction of the vehicle with int value
     */
    public int getDirection() {
        return direction;
    }

    /**
     * Setter for direction of the vehicle
     *
     * @param direction Direction int value
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }
}
