import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 *
 <!--//# BEGIN TODO Name, group id, and date-->
 <p><font color="red"><b>Lev Osipov, 271(1), 12.10.2013</b></font></p>
 <!--//# END TODO-->
 */
// -----8<----- cut line -----8<-----
public class StatisticsTest {

    /** Subject Under Test. */
    final static Statistics SUT = null;

    /** Desired accuracy. */
    final static double EPSILON = 1.0e-18;

//# BEGIN TODO Test cases to test "good weather" functionality

    // Test cases for getCount

    /** getCount Test 1*/
    @Test
    public void testGetCount1() {
        System.out.println("getCount()");
        SUT.reset();
        SUT.update(1);
        SUT.update(3);
        SUT.update(5);
        SUT.update(7);
        SUT.update(9);
        int result = SUT.getCount();
        assertEquals("count", result, 5);
    }

    /** getCount Test 2*/
    @Test
    public void testGetCount2() {
        System.out.println("getCount()");
        SUT.reset();
        SUT.update(-79);
        SUT.update(-35);
        int result = SUT.getCount();
        assertEquals("count", result, 2);
    }

    /** getCount Test 3*/
    @Test
    public void testGetCount3() {
        System.out.println("getCount()");
        SUT.reset();
        SUT.update(79);
        SUT.update(35);
        SUT.update(-3);
        int result = SUT.getCount();
        assertEquals("count", result, 3);
    }

    // Test cases for getMinimum

    /** getMinimum Test 1*/
    @Test
    public void testGetMinimum1() {
        System.out.println("getMinimum()");
        SUT.reset();
        SUT.update(50);
        SUT.update(-1098);
        SUT.update(87345);
        int result = SUT.getMinimum();
        assertEquals("minimum", result, -1098);
    }

    /** getMinimum Test 2*/
    @Test
    public void testGetMinimum2() {
        System.out.println("getMinimum()");
        SUT.reset();
        SUT.update(4525);
        SUT.update(-10);
        SUT.update(-8);
        int result = SUT.getMinimum();
        assertEquals("minimum", result, -10);
    }

    /** getMinimum Test 3*/
    @Test
    public void testGetMinimum3() {
        System.out.println("getMinimum()");
        SUT.reset();
        SUT.update(56);
        SUT.update(Integer.MIN_VALUE);
        SUT.update(-38);
        int result = SUT.getMinimum();
        assertEquals("minimum", result, Integer.MIN_VALUE);
    }

    // Test cases for getMaximum

    /** getMaximum Test 1*/
    @Test
    public void testGetMaximum1() {
        System.out.println("getMaximum()");
        SUT.reset();
        SUT.update(3);
        SUT.update(182);
        SUT.update(-1);
        int result = SUT.getMaximum();
        assertEquals("maximum", result, 182);
    }

    /** getMaximum Test 2*/
    @Test
    public void testGetMaximum2() {
        System.out.println("getMaximum()");
        SUT.reset();
        SUT.update(-6);
        SUT.update(-1828347834);
        SUT.update(-989889);
        int result = SUT.getMaximum();
        assertEquals("maximum", result, -6);
    }

    /** getMaximum Test 3*/
    @Test
    public void testGetMaximum3() {
        System.out.println("getMaximum()");
        SUT.reset();
        SUT.update(-6);
        SUT.update(Integer.MAX_VALUE);
        SUT.update(3);
        int result = SUT.getMaximum();
        assertEquals("maximum", result, Integer.MAX_VALUE);
    }

    // Test cases for getMean

    /** getMean Test 1*/
    @Test
    public void testGetMean() {
        System.out.println("getMean()");
        SUT.reset();
        SUT.update(48);
        SUT.update(366);
        SUT.update(452);
        SUT.update(4);
        double result = SUT.getMean();
        assertEquals("mean", result, 217.5, EPSILON);
    }

    /** getMean Test 2*/
    @Test
    public void testGetMean2() {
        System.out.println("getMean()");
        SUT.reset();
        SUT.update(-445);
        SUT.update(104);
        SUT.update(-452);
        SUT.update(-4);
        double result = SUT.getMean();
        assertEquals("mean", result, -199.25, EPSILON);
    }

    /** getMean Test 3*/
    @Test
    public void testGetMean3() {
        System.out.println("getMean()");
        SUT.reset();
        SUT.update(-10);
        SUT.update(0);
        SUT.update(10);
        double result = SUT.getMean();
        assertEquals("mean", result, 0.0, EPSILON);
    }

    /** getMean Test 4*/
    @Test
    public void testGetMean4() {
        System.out.println("getMean()");
        SUT.reset();
        SUT.update(-145);
        SUT.update(34);
        double result = SUT.getMean();
        assertEquals("mean", result, -55.5, EPSILON);
    }

    /** getMean Test 5*/
    @Test
    public void testGetMean5() {
        System.out.println("getMean()");
        SUT.reset();
        SUT.update(372);
        SUT.update(-13);
        double result = SUT.getMean();
        assertEquals("mean", result, 179.5, EPSILON);
    }

//# END TODO

//# BEGIN TODO Test cases to test for robustness ("bad weather")

    // Test cases for getMinimum

    /**
     * Calls SUT.getMinimum() when a IllegalStateException is expected,
     * and checks the exception.
     */
    @Test
    public void testGetMinimumE1() {
        SUT.reset();
        System.out.println("getMinimum()");
        Class expected = IllegalStateException.class;
        try {
            SUT.getMinimum();
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
     * Calls SUT.getMinimum() when a IllegalStateException is expected,
     * and checks the exception.
     */
    @Test
    public void testGetMinimumE2() {
        SUT.reset();
        SUT.update(1);
        SUT.update(2);
        SUT.update(3);
        SUT.reset();
        System.out.println("getMinimum()");
        Class expected = IllegalStateException.class;
        try {
            SUT.getMinimum();
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
     * Calls SUT.getMinimum() when NO Exception is expected,
     * and checks the absence of an exception (implicitly).
     */
    @Test
    public void testGetMinimumNorm() {
        SUT.reset();
        SUT.update(1);
        System.out.println("getMinimum()");
        SUT.getMinimum();
    }

    // Test cases for getMaximum

    /**
     * Calls SUT.getMaximum() when a IllegalStateException is expected,
     * and checks the exception.
     */
    @Test
    public void testGetMaximumE1() {
        SUT.reset();
        System.out.println("getMaximum()");
        Class expected = IllegalStateException.class;
        try {
            SUT.getMaximum();
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
     * Calls SUT.getMaximum() when a IllegalStateException is expected,
     * and checks the exception.
     */
    @Test
    public void testGetMaximumE2() {
        SUT.reset();
        SUT.update(452);
        SUT.update(-352);
        SUT.update(34);
        SUT.reset();
        System.out.println("getMaximum()");
        Class expected = IllegalStateException.class;
        try {
            SUT.getMaximum();
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
     * Calls SUT.getMaximum() when NO Exception is expected,
     * and checks the absence of an exception (implicitly).
     */
    @Test
    public void testGetMaximumNorm() {
        SUT.reset();
        SUT.update(3);
        System.out.println("getMaximum()");
        SUT.getMaximum();
    }

    // Test cases for getMean

    /**
     * Calls SUT.getMean() when a IllegalStateException is expected,
     * and checks the exception.
     */
    @Test
    public void testGetMeanE1() {
        SUT.reset();
        System.out.println("getMean()");
        Class expected = IllegalStateException.class;
        try {
            SUT.getMean();
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
     * Calls SUT.getMean() when a IllegalStateException is expected,
     * and checks the exception.
     */
    @Test
    public void testGetMeanE2() {
        SUT.reset();
        SUT.update(4);
        SUT.update(-28748);
        SUT.update(-1);
        SUT.reset();
        System.out.println("getMean()");
        Class expected = IllegalStateException.class;
        try {
            SUT.getMean();
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
     * Calls SUT.getMean() when NO Exception is expected,
     * and checks the absence of an exception (implicitly).
     */
    @Test
    public void testGetMeanNorm() {
        SUT.reset();
        SUT.update(5);
        System.out.println("getMean()");
        SUT.getMean();
    }

//# END TODO
}