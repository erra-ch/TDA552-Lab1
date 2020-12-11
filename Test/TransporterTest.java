import lib.Car;
import lib.Saab95;
import lib.Transporter;
import lib.Volvo240;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class TransporterTest {

    @Test
    public void LoadUnloadTest() {

        Transporter truck = new Transporter(500, Color.green, "BigBoy");
        Car car1 = new Volvo240();
        Car car2 = new Saab95();
        truck.rampDown();
        truck.loadCar(car1);
        truck.loadCar(car2);
        truck.unloadCar();

        Assert.assertTrue(truck.getTrailer().size() == 1);
    }

    @Test
    public void RampTest() {
        Transporter truck = new Transporter(500, Color.green, "BigBoy");
        Car car = new Volvo240();

        truck.rampDown();
        truck.rampUp();
        truck.loadCar(car);
        Assert.assertTrue(truck.getTrailer().size() == 0);

    }

    @Test
    public void MoveTest() {
        Transporter truck = new Transporter(500, Color.green, "BigBoy");
        Car car = new Volvo240();
        truck.rampDown();
        truck.loadCar(car);

        truck.startEngine();
        truck.move();   // Can't move because ramp is down
        truck.rampUp();
        truck.gas(1);
        truck.move();   // Moves because ramp is up;

        Assert.assertFalse(truck.getY() == 0 && car.getY() == 0);

    }

    @Test
    public void CarIsCloseSanity() {
        Transporter truck = new Transporter(500, Color.green, "BigBoy");
        Car car1 = new Volvo240();
        Car car2 = new Saab95();
        car2.setY(10);
        truck.rampDown();
        truck.loadCar(car1);
        truck.loadCar(car2);

        Assert.assertTrue(truck.getTrailer().size() == 1);
    }
}
