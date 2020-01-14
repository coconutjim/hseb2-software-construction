import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Abstract test cases for IntRelation, to be extended to obtain
 * concrete test cases for an extension of IntRelation.
 *
 * <!--//# BEGIN TODO Name, group id, and date-->
 * <p><font color="red"><b>Lev Osipov, 271(1), 24.10.2013</b></font></p>
 * <!--//# END TODO-->
 *
 */
// -----8<----- cut line -----8<-----
public abstract class IntRelationTestCases {
    
    /** Test fixture. */
    protected IntRelation instance;
    
    /**
     * Sets instance to a newly constructed relation of given extent.
     * 
     * @param n   extent
     */
    protected abstract void setInstance(final int n);
    
    /** Tests the constructor with small values. */
    @Test
    public void testConstructor() {
        System.out.println("constructor(int)");
        for (int n = 0; n <= 3; ++ n) {
            setInstance(n);
            assertTrue("isRepOk()", instance.isRepOk());
        }
    }

    /** Checks the constructor */
    @Test
    public void testConstructorE() {
        System.out.println("constructor(-1) with exception");
        Class expected = IllegalArgumentException.class;
        try {
            setInstance(-1);
            fail("should have thrown " + expected);
        } catch (Exception e) {
            assertTrue("type: " + e.getClass().getName()
                    + " should be instance of " + expected,
                    expected.isInstance(e));
            assertNotNull("message should not be null",
                    e.getMessage());
        }
    }
    
    /** Tests the extent method with small relations. */
    @Test
    public void testExtent() {
        System.out.println("extent");
        for (int n = 0; n <= 3; ++ n) {
            setInstance(n);
            assertEquals("size", n, instance.extent());
            assertTrue("isRepOk()", instance.isRepOk());
        }
    }
    
    /**
     * Invokes areRelated(a, b) and checks the result.
     * 
     * @param a  first element in pair
     * @param b  second element in pair
     * @param expResult  expected result
     */
    private void checkAreRelated(int a, int b, boolean expResult) {
        boolean result = instance.areRelated(a, b);
        assertEquals("areRelated(" + a + ", " + b + ")", expResult, result);
        assertTrue("isRepOk()", instance.isRepOk());
    }

    // Tests for areRelated

    /** Tests the areRelated method on empty relation. */
    @Test
    public void testAreRelated() {
        System.out.println("areRelated");
        setInstance(1);
        checkAreRelated(0, 0, false);
        setInstance(2);
        checkAreRelated(0, 0, false);
        checkAreRelated(0, 1, false);
        checkAreRelated(1, 0, false);
        checkAreRelated(1, 1, false);
    }

    /** Checks the exception if a < 0 */
    @Test
    public void testAreRelatedE1() {
        System.out.println("areRelated(-1, 0) with exception");
        setInstance(3);
        Class expected = IllegalArgumentException.class;
        try {
            instance.areRelated(-1, 0);
            fail("should have thrown " + expected);
        } catch (Exception e) {
            assertTrue("type: " + e.getClass().getName()
                    + " should be instance of " + expected,
                    expected.isInstance(e));
            assertNotNull("message should not be null",
                    e.getMessage());
        }
    }

    /** Checks the exception if b < 0 */
    @Test
    public void testAreRelatedE2() {
        System.out.println("areRelated(0, -1) with exception");
        setInstance(3);
        Class expected = IllegalArgumentException.class;
        try {
            instance.areRelated(0, -1);
            fail("should have thrown " + expected);
        } catch (Exception e) {
            assertTrue("type: " + e.getClass().getName()
                    + " should be instance of " + expected,
                    expected.isInstance(e));
            assertNotNull("message should not be null",
                    e.getMessage());
        }
    }

    /** Checks the exception if b is invalid */
    @Test
    public void testAreRelatedE3() {
        System.out.println("areRelated(0, 10) with exception");
        setInstance(3);
        Class expected = IllegalArgumentException.class;
        try {
            instance.areRelated(0, 10);
            fail("should have thrown " + expected);
        } catch (Exception e) {
            assertTrue("type: " + e.getClass().getName()
                    + " should be instance of " + expected,
                    expected.isInstance(e));
            assertNotNull("message should not be null",
                    e.getMessage());
        }
    }

    // Tests for add

    /** Tests the add method. */
    @Test
    public void testAdd() {
        System.out.println("add");
        setInstance(2);
        instance.add(0, 1); // N.B. not a pair of equals
        assertTrue("isRepOk()", instance.isRepOk());
        checkAreRelated(0, 1, true);
        checkAreRelated(0, 0, false);
        checkAreRelated(1, 0, false);
        checkAreRelated(1, 1, false);
        instance.add(0, 1);
        assertTrue("isRepOk()", instance.isRepOk());
        checkAreRelated(0, 1, true);
        checkAreRelated(0, 0, false);
        checkAreRelated(1, 0, false);
        checkAreRelated(1, 1, false);
    }

    /** Checks the exception if a < 0 */
    @Test
    public void testAddE1() {
        System.out.println("add(-1, 0) with exception");
        setInstance(3);
        Class expected = IllegalArgumentException.class;
        try {
            instance.add(-1, 0);
            fail("should have thrown " + expected);
        } catch (Exception e) {
            assertTrue("type: " + e.getClass().getName()
                    + " should be instance of " + expected,
                    expected.isInstance(e));
            assertNotNull("message should not be null",
                    e.getMessage());
        }
    }

    /** Checks the exception if b < 0 */
    @Test
    public void testAddE2() {
        System.out.println("add(0, -1) with exception");
        setInstance(3);
        Class expected = IllegalArgumentException.class;
        try {
            instance.add(0, -1);
            fail("should have thrown " + expected);
        } catch (Exception e) {
            assertTrue("type: " + e.getClass().getName()
                    + " should be instance of " + expected,
                    expected.isInstance(e));
            assertNotNull("message should not be null",
                    e.getMessage());
        }
    }

    /** Checks the exception if b id invalid */
    @Test
    public void testAddE3() {
        System.out.println("add(0, 10) with exception");
        setInstance(3);
        Class expected = IllegalArgumentException.class;
        try {
            instance.add(0, 10);
            fail("should have thrown " + expected);
        } catch (Exception e) {
            assertTrue("type: " + e.getClass().getName()
                    + " should be instance of " + expected,
                    expected.isInstance(e));
            assertNotNull("message should not be null",
                    e.getMessage());
        }
    }

    // Tests for remove

    /** Tests the remove method. */
    @Test
    public void testRemove() {
        System.out.println("remove");
        setInstance(2);
        instance.remove(0, 1); // N.B. not a pair of equals
        assertTrue("isRepOk()", instance.isRepOk());
        checkAreRelated(0, 0, false);
        checkAreRelated(0, 1, false);
        checkAreRelated(1, 0, false);
        checkAreRelated(1, 1, false);
        instance.add(0, 1);
        assertTrue("isRepOk()", instance.isRepOk());
        checkAreRelated(0, 1, true);
        instance.remove(0, 1);
        assertTrue("isRepOk()", instance.isRepOk());
        checkAreRelated(0, 0, false);
        checkAreRelated(0, 1, false);
        checkAreRelated(1, 0, false);
        checkAreRelated(1, 1, false);
    }

    /** Checks the exception if a < 0 */
    @Test
    public void testRemoveE1() {
        System.out.println("remove(-1, 0) with exception");
        setInstance(3);
        Class expected = IllegalArgumentException.class;
        try {
            instance.remove(-1, 0);
            fail("should have thrown " + expected);
        } catch (Exception e) {
            assertTrue("type: " + e.getClass().getName()
                    + " should be instance of " + expected,
                    expected.isInstance(e));
            assertNotNull("message should not be null",
                    e.getMessage());
        }
    }

    /** Checks the exception if b < 0 */
    @Test
    public void testRemoveE2() {
        System.out.println("remove(0, -1) with exception");
        setInstance(3);
        Class expected = IllegalArgumentException.class;
        try {
            instance.remove(0, -1);
            fail("should have thrown " + expected);
        } catch (Exception e) {
            assertTrue("type: " + e.getClass().getName()
                    + " should be instance of " + expected,
                    expected.isInstance(e));
            assertNotNull("message should not be null",
                    e.getMessage());
        }
    }

    /** Checks the exception if b is invalid */
    @Test
    public void testRemoveE3() {
        System.out.println("remove(0, 10) with exception");
        setInstance(3);
        Class expected = IllegalArgumentException.class;
        try {
            instance.remove(0, 10);
            fail("should have thrown " + expected);
        } catch (Exception e) {
            assertTrue("type: " + e.getClass().getName()
                    + " should be instance of " + expected,
                    expected.isInstance(e));
            assertNotNull("message should not be null",
                    e.getMessage());
        }
    }
    
}
