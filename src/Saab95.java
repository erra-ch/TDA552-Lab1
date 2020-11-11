import java.awt.*;
//TODO Comments
public class Saab95 extends AbstractCar{

    public boolean turboOn;

    
    public Saab95(){
        super(2, 125, Color.red, "Saab95");
        turboOn = false;
    }


    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }

    protected double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return this.getEnginePower() * 0.01 * turbo;
    }

}
