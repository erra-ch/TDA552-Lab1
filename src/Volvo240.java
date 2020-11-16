
import java.awt.*;

/**
 * Car model class for Volvo 240
 */
public class Volvo240 extends Car {

    /**
     * Trim factor for the car
     */
    public final static double trimFactor = 1.25;

    /**
     * Constructor
     */
    public Volvo240(){
        super(4, 100, Color.black, "Volvo240");
    }

    /**
     * Returns the speed factor of the car
     *
     * @return Returns speed factor
     */
    protected double speedFactor(){
        return this.getEnginePower() * 0.01 * trimFactor;
    }

    /**
     * Getter for the trim factor
     *
     * @return Returns trim factor
     */
    public static double getTrimFactor() { return trimFactor;}

}
