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
    public void GasBrakeTest() {
        AbstractCar car = new Volvo240();
        car.gas(0.5);
        car.gas(0.2);
        car.brake(0.3);
        Assert.assertEquals(0.5, car.getCurrentSpeed(), 0.5);
    }
}
