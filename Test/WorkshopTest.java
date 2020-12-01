import Lab1.*;
import org.junit.Assert;
import org.junit.Test;

public class WorkshopTest {

    @Test
    public void WorkshopAddRemoveTest() {
        Workshop garage = new Workshop(2);
        Car car1 = new Volvo240();
        Car car2 = new Saab95();

        garage.addCar(car1);
        garage.addCar(car2);
        garage.removeCar(car1);

        Assert.assertEquals(1, garage.getCarsInGarage().size());
    }

    @Test
    public void WorkshopTypeTest() {
        Workshop<Volvo240> volvogarage = new Workshop<>(2);
        Car car1 = new Volvo240();
        Car car2 = new Saab95();

        volvogarage.addCar((Volvo240) car1);
        try {
            volvogarage.addCar((Volvo240) car2); }
        catch(ClassCastException e) { System.out.println("Wrong car model"); }
        Assert.assertEquals(1, volvogarage.getCarsInGarage().size());
    }


}
