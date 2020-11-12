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
        AbstractCar saab95 = new Saab95();
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
        AbstractCar saab95 = new Saab95();
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
        AbstractCar saab95 = new Saab95();
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
        AbstractCar saab95 = new Saab95();
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
        AbstractCar car = new Saab95();
        car.turnRight();
        car.turnRight();
        car.turnLeft();
        Assert.assertSame(1, car.getDirection());
    }
}
