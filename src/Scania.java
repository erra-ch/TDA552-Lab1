import java.awt.*;

public class Scania extends Truck implements IFlatbed {
    /**
     * Degree the flatbed is raised on the truck
     */
    private int flatbedDegree;

    /**
     * Constructor for abstract class Vehicle
     *
     */
    public Scania(){ super (2, 300, Color.white, "Scania114G"); }

    /**
     * Move method for Scania trucks with flatbed
     */
    @Override
    public void move() {
        if (this.getFlatbedDegree() == 0) {
            super.move();
        }
    }

    /**
     * Raises the flatbed
     *
     * @param amount amount to raise the flatbed with
     */
    @Override
    public void raiseFlatbed(double amount) {
        if (!this.isMoving() && this.getFlatbedDegree() + amount <= 70)
            flatbedDegree += amount;
    }

    /**
     * Lowers the flatbed
     *
     * @param amount amount to lower the flatbed with
     */
    @Override
    public void lowerFlatbed(double amount) {
        if (!this.isMoving() && this.getFlatbedDegree() - amount >= 0)
            flatbedDegree -= amount;
    }

    /**
     * Returns the speedfactor of the truck
     *
     * @return speedfactor
     */
    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }

    /**
     * Getter for flatbed degree
     *
     * @return Flatbed degree
     */
    public int getFlatbedDegree() { return flatbedDegree; }
}
