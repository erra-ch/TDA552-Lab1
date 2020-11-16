import org.junit.Assert;
import org.junit.Test;

/**
 * Test for Saab95 class
 */
public class Saab95Test {
    /**
     * Test move when direction is up
     */
    @Test
    public void TestMoveWhenDirectionIsUp() {
        Car saab95 = new Saab95();
        saab95.startEngine();
        saab95.move();
        Assert.assertEquals(-0.1, saab95.getY(), -0.1);
        Assert.assertEquals(0, saab95.getX(), 0);
    }

    /**
     * Test move when direction is right
     */
    @Test
    public void TestMoveWhenDirectionIsRight() {
        Car saab95 = new Saab95();
        saab95.startEngine();
        saab95.turnRight();
        saab95.move();
        Assert.assertEquals(0, saab95.getY(), 0);
        Assert.assertEquals(0.1, saab95.getX(), 0.1);
    }

    /**
     * Test move when direction is down
     */
    @Test
    public void TestMoveWhenDirectionIsDown() {
        Car saab95 = new Saab95();
        saab95.startEngine();
        saab95.turnRight();
        saab95.turnRight();
        saab95.move();
        Assert.assertEquals(0.1, saab95.getY(), 0.1);
        Assert.assertEquals(0, saab95.getX(), 0);
    }

    /**
     * Test move when direction is left
     */
    @Test
    public void TestMoveWhenDirectionIsLeft() {
        Car saab95 = new Saab95();
        saab95.startEngine();
        saab95.turnLeft();
        saab95.move();
        Assert.assertEquals(0, saab95.getY(), 0);
        Assert.assertEquals(-0.1, saab95.getX(), -0.1);
    }

    /**
     * Test for right and left turn
     */
    @Test
    public void TestRightAndLeftTurn() {
        Car car = new Saab95();
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
        Car car = new Saab95();
        car.gas(0.5);
        car.gas(0.2);
        car.brake(0.3);
        Assert.assertEquals(0.5, car.getCurrentSpeed(), 0.5);
    }

    /**
     * Test other cases when using Gas
     */
    @Test
    public void TestGasSanity() {
        Car car = new Saab95();
        car.gas(2);
        car.gas(-1);
        Assert.assertEquals(1.25, car.getCurrentSpeed(), 1.25 );
    }

    /**
     * Test other cases when using Brake
     */
    @Test
    public void TestBrakeSanity() {
        Car car = new Saab95();
        car.setCurrentSpeed(1.25);
        car.brake(2);
        car.brake(-1);
        Assert.assertEquals(0, car.getCurrentSpeed(), 0 );
    }

    /**
     * Test for turning on Turbo
     */
    @Test
    public void TestTurboOn(){
        Car car = new Saab95();
        car.startEngine();  // Speed = 0.1
        ((Saab95) car).setTurboOn();    // Speed factor  = 1.625
        car.gas(1); // Speed = 1.725
        Assert.assertEquals(1.725, car.getCurrentSpeed(), 1.725 );
    }

    /**
     * Test for turning off Turbo
     */
    @Test
    public void TestTurboOff(){
        Car car = new Saab95();
        car.startEngine();  // Speed = 0.1
        ((Saab95) car).setTurboOn();    // Speed factor = 1.625
        ((Saab95) car).setTurboOff();   // Speed factor = 1.25
        car.gas(1);  // Speed = 1.35
        Assert.assertEquals(1.35, car.getCurrentSpeed(), 1.35 );
    }
}
