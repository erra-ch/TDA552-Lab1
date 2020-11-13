import org.junit.Assert;
import org.junit.Test;

public class Volvo240Test {
    /**
     * Test move when direction is up
     */
    @Test
    public void TestMoveWhenDirectionIsUp() {
        AbstractCar volvo240 = new Volvo240();
        volvo240.startEngine();
        volvo240.move();
        Assert.assertEquals(-0.1, volvo240.getY(), -0.1);
        Assert.assertEquals(0, volvo240.getX(), 0);
    }

    /**
     * Test move when direction is right
     */
    @Test
    public void TestMoveWhenDirectionIsRight() {
        AbstractCar volvo240 = new Volvo240();
        volvo240.startEngine();
        volvo240.turnRight();
        volvo240.move();
        Assert.assertEquals(0, volvo240.getY(), 0);
        Assert.assertEquals(0.1, volvo240.getX(), 0.1);
    }

    /**
     * Test move when direction is down
     */
    @Test
    public void TestMoveWhenDirectionIsDown() {
        AbstractCar volvo240 = new Volvo240();
        volvo240.startEngine();
        volvo240.turnRight();
        volvo240.turnRight();
        volvo240.move();
        Assert.assertEquals(0.1, volvo240.getY(), 0.1);
        Assert.assertEquals(0, volvo240.getX(), 0);
    }

    /**
     * Test move when direction is left
     */
    @Test
    public void TestMoveWhenDirectionIsLeft() {
        AbstractCar volvo240 = new Volvo240();
        volvo240.startEngine();
        volvo240.turnLeft();
        volvo240.move();
        Assert.assertEquals(0, volvo240.getY(), 0);
        Assert.assertEquals(-0.1, volvo240.getX(), -0.1);
    }

    /**
     * Test for right and left turn
     */
    @Test
    public void TestRightAndLeftTurn() {
        AbstractCar car = new Volvo240();
        car.turnRight();
        car.turnRight();
        car.turnLeft();
        Assert.assertSame(1, car.getDirection());
    }

    /**
     * Gas and brake test method
     */
    @Test
    public void TestGasBrake() {
        AbstractCar car = new Volvo240();
        car.gas(0.5);
        car.gas(0.2);
        car.brake(0.3);
        Assert.assertEquals(0.5, car.getCurrentSpeed(), 0.5);
    }

    /**
     * Test other cases when using Gas and Brake
     */
    @Test
    public void TestGasBrakeSanity() {
        AbstractCar car = new Volvo240();
        car.gas(2);
        car.gas(-1);
        Assert.assertEquals(1.25, car.getCurrentSpeed(), 1.25 );
    }

    /**
     * Test get Trim Factor
     */
    @Test
    public void TestTrimFactor() {
        AbstractCar car = new Volvo240();
        Assert.assertEquals(1.25, ((Volvo240) car).getTrimFactor(), 1.25);
    }

    /**
     * Test Stop Engine
     */
    @Test
    public void TestStopEngine() {
        AbstractCar car = new Volvo240();
        car.startEngine();
        car.stopEngine();
        Assert.assertEquals(0, car.getCurrentSpeed(), 0);
    }
}
