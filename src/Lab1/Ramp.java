package Lab1;

/**
 * Lab1.Ramp class
 */
public class Ramp {

    /**
     * Tells the position of the ramp
     */
    private RampPos rampPos;

    /**
     * Constructor for the ramp
     */
    public Ramp() {
        this.rampPos = RampPos.UP;
    }

    /**
     * Sets the ramp-position
     *
     * @param rampPos Position enum
     */
    public void setRampPos(RampPos rampPos) {
        this.rampPos = rampPos;
    }

    /**
     * Returns the position of the ramp
     *
     * @return  Returns position of ramp
     */
    public RampPos getRampPos() {
        return rampPos;
    }
}
