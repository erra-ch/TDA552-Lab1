package lib;

import java.awt.*;

/**
 * Car model class for Saab 95
 */
public class Saab95 extends Car {

    /**
     * Sets turbo
     */
    public boolean turboOn;

    /**
     * Constructor
     */
    public Saab95(){
        super(2, 125, Color.red, "Saab95");
        turboOn = false;
    }

    /**
     * Method that turns turbo on
     */
    public void setTurboOn(){ turboOn = true; }

    /**
     * Method that turns turbo off
     */
    public void setTurboOff(){
	    turboOn = false;
    }

    /**
     * Returns the speed factor of the car
     *
     * @return Returns speed factor
     */
    protected double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return this.getEnginePower() * 0.01 * turbo;
    }

}
