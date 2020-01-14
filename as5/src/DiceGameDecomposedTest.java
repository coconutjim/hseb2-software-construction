import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;

/**
 * Test cases for DiceGame Decomposed,
 * especially for robustness.
 *
 <!--//# BEGIN TODO Name, group id, and date-->
 <p><font color="red"><b>Lev Osipov, 271(1), 12.10.2013</b></font></p>
 <!--//# END TODO-->
 */
// -----8<----- cut line -----8<-----
public class DiceGameDecomposedTest {

    /** Subject Under Test; involves only static methods */
    final static DiceGameDecomposed SUT = null;

    /**
     * Calls SUT.count(0, null) when a NullPointerException is expected,
     * and checks the exception.
     */
    @Ignore("Example")
    @Test
    public void testCountNull() {
        System.out.println("count(0, null)");
        Class expected = NullPointerException.class;
        try {
            SUT.count(0, null);
            fail("should have thrown " + expected);
        } catch (Exception e) {
            assertTrue("type: " + e.getClass().getName()
                    + " should be instance of " + expected,
                    expected.isInstance(e));
            assertNotNull("message should not be null",
                    e.getMessage());
        }
    }

    /**
     * Calls SUT.count(0, empty) when NO Exception is expected,
     * and checks the absence of an exception (implicitly).
     */
    @Ignore("Example")
    @Test
    public void testCountEmpty() {
        System.out.println("count(0, empty)");
        SUT.count(0, new int[] { });
    }

//# BEGIN TODO Test cases to test for robustness (simulate, roll, max, find)

    // Test cases for simulate

    /**
     * Calls SUT.simulate(0, 5) when a IllegalArgumentException is expected,
     * and checks the exception.
     */
    @Test
    public void testSimulateArg1() {
        System.out.println("simulate(0, 5)");
        Class expected = IllegalArgumentException.class;
        try {
            SUT.simulate(0, 5);
            fail("should have thrown " + expected);
        } catch (Exception e) {
            assertTrue("type: " + e.getClass().getName()
                    + " should be instance of " + expected,
                    expected.isInstance(e));
            assertNotNull("message should not be null",
                    e.getMessage());
        }
    }

    /**
     * Calls SUT.simulate(5, -1) when a IllegalArgumentException is expected,
     * and checks the exception.
     */
    @Test
    public void testSimulateArg2() {
        System.out.println("simulate(5, -1)");
        Class expected = IllegalArgumentException.class;
        try {
            SUT.simulate(5, -1);
            fail("should have thrown " + expected);
        } catch (Exception e) {
            assertTrue("type: " + e.getClass().getName()
                    + " should be instance of " + expected,
                    expected.isInstance(e));
            assertNotNull("message should not be null",
                    e.getMessage());
        }
    }

    /**
     * Calls SUT.simulate(-3, -3) when a IllegalArgumentException is expected,
     * and checks the exception.
     */
    @Test
    public void testSimulateArg3() {
        System.out.println("simulate(-3, -3)");
        Class expected = IllegalArgumentException.class;
        try {
            SUT.simulate(-3, -3);
            fail("should have thrown " + expected);
        } catch (Exception e) {
            assertTrue("type: " + e.getClass().getName()
                    + " should be instance of " + expected,
                    expected.isInstance(e));
            assertNotNull("message should not be null",
                    e.getMessage());
        }
    }

    /**
     * Calls SUT.simulate(1, 0) when NO Exception is expected,
     * and checks the absence of an exception (implicitly).
     */
    @Test
    public void testSimulateNorm() {
        System.out.println("simulate(1, 0)");
        SUT.simulate(1, 0);
    }

    // Test cases for roll

    /**
     * Calls SUT.roll(-1) when a IllegalArgumentException is expected,
     * and checks the exception.
     */
    @Test
    public void testRollArg() {
        System.out.println("roll(-1)");
        Class expected = IllegalArgumentException.class;
        try {
            SUT.roll(-1);
            fail("should have thrown " + expected);
        } catch (Exception e) {
            assertTrue("type: " + e.getClass().getName()
                    + " should be instance of " + expected,
                    expected.isInstance(e));
            assertNotNull("message should not be null",
                    e.getMessage());
        }
    }

    /**
     * Calls SUT.roll(1) when NO Exception is expected,
     * and checks the absence of an exception (implicitly).
     */
    @Test
    public void testRollNorm() {
        System.out.println("roll(1)");
        SUT.roll(1);
    }

    // Test cases for max

    /**
     * Calls SUT.max(null) when a NullPointerException is expected,
     * and checks the exception.
     */
    @Test
    public void testMaxNull() {
        System.out.println("max(null)");
        Class expected = NullPointerException.class;
        try {
            SUT.max(null);
            fail("should have thrown " + expected);
        } catch (Exception e) {
            assertTrue("type: " + e.getClass().getName()
                    + " should be instance of " + expected,
                    expected.isInstance(e));
            assertNotNull("message should not be null",
                    e.getMessage());
        }
    }

    /**
     * Calls SUT.max(empty) when a IllegalArgumentException is expected,
     * and checks the exception.
     */
    @Test
    public void testMaxArg1() {
        System.out.println("max(empty)");
        Class expected = IllegalArgumentException.class;
        try {
            SUT.max(new int[] { });
            fail("should have thrown " + expected);
        } catch (Exception e) {
            assertTrue("type: " + e.getClass().getName()
                    + " should be instance of " + expected,
                    expected.isInstance(e));
            assertNotNull("message should not be null",
                    e.getMessage());
        }
    }

    /**
     * Calls SUT.max({-1, 3, 5}) when a IllegalArgumentException is expected,
     * and checks the exception.
     */
    @Test
    public void testMaxArg2() {
        System.out.println("max({-1, 3, 5})");
        Class expected = IllegalArgumentException.class;
        try {
            int[] array = new int[] {-1, 3, 5}; // test array
            SUT.max(array);
            fail("should have thrown " + expected);
        } catch (Exception e) {
            assertTrue("type: " + e.getClass().getName()
                    + " should be instance of " + expected,
                    expected.isInstance(e));
            assertNotNull("message should not be null",
                    e.getMessage());
        }
    }

    /**
     * Calls SUT.max({-1, -1, -3}) when a IllegalArgumentException is expected,
     * and checks the exception.
     */
    @Test
    public void testMaxArg3() {
        System.out.println("max({-1, -1, -3})");
        Class expected = IllegalArgumentException.class;
        try {
            int[] array = new int[] {-1, -1, -3}; // test array
            SUT.max(array);
            fail("should have thrown " + expected);
        } catch (Exception e) {
            assertTrue("type: " + e.getClass().getName()
                    + " should be instance of " + expected,
                    expected.isInstance(e));
            assertNotNull("message should not be null",
                    e.getMessage());
        }
    }

    /**
     * Calls SUT.max({0, 0, 0, 0, -1}) when a IllegalArgumentException is expected,
     * and checks the exception.
     */
    @Test
    public void testMaxArg4() {
        System.out.println("max({0, 0, 0, 0, -1})");
        Class expected = IllegalArgumentException.class;
        try {
            int[] array = new int[] {0, 0, 0, 0, -1}; // test array
            SUT.max(array);
            fail("should have thrown " + expected);
        } catch (Exception e) {
            assertTrue("type: " + e.getClass().getName()
                    + " should be instance of " + expected,
                    expected.isInstance(e));
            assertNotNull("message should not be null",
                    e.getMessage());
        }
    }

    /**
     * Calls SUT.max({0, 1, 3}) when NO Exception is expected,
     * and checks the absence of an exception (implicitly).
     */
    @Test
    public void testMaxNorm() {
        System.out.println("max({0, 1, 3})");
        int[] array = new int[] {0, 1, 3}; // test array
        SUT.max(array);
    }

    // Test cases for find

    /**
     * Calls SUT.find(0, null) when a NullPointerException is expected,
     * and checks the exception.
     */
    @Test
    public void testFindNull() {
        System.out.println("find(0, null)");
        Class expected = NullPointerException.class;
        try {
            SUT.find(0, null);
            fail("should have thrown " + expected);
        } catch (Exception e) {
            assertTrue("type: " + e.getClass().getName()
                    + " should be instance of " + expected,
                    expected.isInstance(e));
            assertNotNull("message should not be null",
                    e.getMessage());
        }
    }

    /**
     * Calls SUT.find(7, {5, 9, 3}) when a IllegalArgumentException is expected,
     * and checks the exception.
     */
    @Test
    public void testFindArg() {
        System.out.println("find(7, {5, 9, 3})");
        Class expected = IllegalArgumentException.class;
        try {
            int[] array = new int[] {5, 9, 3}; // test array
            SUT.find(7, array);
            fail("should have thrown " + expected);
        } catch (Exception e) {
            assertTrue("type: " + e.getClass().getName()
                    + " should be instance of " + expected,
                    expected.isInstance(e));
            assertNotNull("message should not be null",
                    e.getMessage());
        }
    }

    /**
     * Calls SUT.find(5, {11, 5, 9}) when NO Exception is expected,
     * and checks the absence of an exception (implicitly).
     */
    @Test
    public void testFindNorm() {
        System.out.println("find(5, {11, 5, 9})");
        int[] array = new int[] {11, 5, 9}; // test array
        SUT.find(5, array);
    }

//# END TODO
}