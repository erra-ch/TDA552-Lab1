import java.awt.*;

public class Volvo240 extends AbstractCar{

    public final static double trimFactor = 1.25;

    
    public Volvo240(){
        super(4, 100, Color.black, "Volvo240");
    }
    


    protected double speedFactor(){
        return this.getEnginePower() * 0.01 * trimFactor;
    }


    public static double getTrimFactor() { return trimFactor;}

}
