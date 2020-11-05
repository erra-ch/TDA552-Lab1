import java.awt.*;

public class Volvo240 extends AbstractCar{

    public final static double trimFactor = 1.25;

    
    public Volvo240(){
        super(4, 100, Color.black, "Volvo240");
    }
    

    //TODO
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

    public void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }


    public void gas(double amount){
        incrementSpeed(amount);
    }


    public void brake(double amount){
        decrementSpeed(amount);
    }
}
