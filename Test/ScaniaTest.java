import Lab1.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test for Lab1.Scania class
 */
public class ScaniaTest {

    /**
     * Test for raising and lowering flatbed
     */
    @Test
    public void flatbedTest() {
        Scania scania = new Scania();
        scania.raiseFlatbed(20);
        scania.lowerFlatbed(10);
        Assert.assertEquals(10, scania.getFlatbedDegree(), 10);
    }

    /**
     * Test move when direction is up
     */
    @Test
    public void TestMoveWhenDirectionIsUp() {
        Scania scania = new Scania();
        scania.startEngine();
        scania.move();
        Assert.assertEquals(-0.1, scania.getY(), -0.1);
        Assert.assertEquals(0, scania.getX(), 0);
    }

    /**
     * Test move when direction is right
     */
    @Test
    public void TestMoveWhenDirectionIsRight() {
        Scania scania = new Scania();
        scania.startEngine();
        scania.turnRight();
        scania.move();
        Assert.assertEquals(0, scania.getY(), 0);
        Assert.assertEquals(0.1, scania.getX(), 0.1);
    }

    /**
     * Test move when direction is down
     */
    @Test
    public void TestMoveWhenDirectionIsDown() {
        Scania scania = new Scania();
        scania.startEngine();
        scania.turnRight();
        scania.turnRight();
        scania.move();
        Assert.assertEquals(0.1, scania.getY(), 0.1);
        Assert.assertEquals(0, scania.getX(), 0);
    }

    /**
     * Test move when direction is left
     */
    @Test
    public void TestMoveWhenDirectionIsLeft() {
        Scania scania = new Scania();
        scania.startEngine();
        scania.turnLeft();
        scania.move();
        Assert.assertEquals(0, scania.getY(), 0);
        Assert.assertEquals(-0.1, scania.getX(), -0.1);
    }

    /**
     * Test for right and left turn
     */
    @Test
    public void TestRightAndLeftTurn() {
        Scania Scania = new Scania();
        Scania.turnRight();
        Scania.turnRight();
        Scania.turnLeft();
        Assert.assertSame(1, Scania.getDirection());
    }

    /**
     * Gas and brake test method
     */
    @Test
    public void TestGasBrake() {
        Scania Scania = new Scania();
        Scania.gas(0.5);
        Scania.gas(0.2);
        Scania.brake(0.3);
        Assert.assertEquals(1.2, Scania.getCurrentSpeed(), 1.2);
    }

    /**
     * Test other cases when using Gas
     */
    @Test
    public void TestGasSanity() {
        Scania Scania = new Scania();
        Scania.gas(2);
        Scania.gas(-1);
        Assert.assertEquals(3, Scania.getCurrentSpeed(), 3 );
    }

    /**
     * Test other cases when using Brake
     */
    @Test
    public void TestBrakeSanity() {
        Scania Scania = new Scania();
        Scania.setCurrentSpeed(1.25);
        Scania.brake(2);
        Scania.brake(-1);
        Assert.assertEquals(0, Scania.getCurrentSpeed(), 0 );
    }

}
