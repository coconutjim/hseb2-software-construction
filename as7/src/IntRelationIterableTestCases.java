
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Abstract test cases for IntRelation, to be extended to obtain
 * concrete test cases for an extension of IntRelation.
 *
 * <!--//# BEGIN TODO Name, group id, and date-->
 * <p><font color="red"><b>Lev Osipov, 271(1), 30.10.2013</b></font></p>
 * <!--//# END TODO-->
 *
 */
// -----8<----- cut line -----8<-----
public abstract class IntRelationIterableTestCases {

    /** Test fixture. */
    protected IntRelation instance;

    /**
     * Sets instance to a newly constructed relation of given extent.
     *
     * @param n extent
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
     * @param a first element in pair
     * @param b second element in pair
     * @param expResult expected result
     */
    private void checkAreRelated(int a, int b, boolean expResult) {
        boolean result = instance.areRelated(a, b);
        assertEquals("areRelated(" + a + ", " + b + ")", expResult, result);
        assertTrue("isRepOk()", instance.isRepOk());
    }

    /** Tests for work ability */

    //Test for areRelated

    /** Checks areRelated method. */
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

    //Test for add

    /** Checks add method */
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

    //Test for remove

    /** Checks remove method */
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

    /** Tests for robustness */

    //Test for the constructor

    /** Tests the constructor with negative value */
    @Test
    public void testConstructorE() {
        System.out.println("constructor(-10)");
        Class expected = IllegalArgumentException.class;
        try {
            setInstance(-10);
            fail("should have thrown " + expected);
        } catch (Exception e) {
            assertTrue("type: " + e.getClass().getName()
                    + " should be instance of " + expected,
                    expected.isInstance(e));
            assertNotNull("message should not be null",
                    e.getMessage());
        }
    }

    //Tests for areRelated

    /** Tests areRelated with a < 0 */
    @Test
    public void testAreRelatedE1() {
        System.out.println("areRelated(-10, 0)");
        Class expected = IllegalArgumentException.class;
        try {
            setInstance(2);
            instance.areRelated(-10, 0);
            fail("should have thrown " + expected);
        } catch (Exception e) {
            assertTrue("type: " + e.getClass().getName()
                    + " should be instance of " + expected,
                    expected.isInstance(e));
            assertNotNull("message should not be null",
                    e.getMessage());
        }
    }

    /** Tests areRelated with invalid b */
    @Test
    public void testAreRelatedE2() {
        System.out.println("areRelated(0, 20)");
        Class expected = IllegalArgumentException.class;
        try {
            setInstance(1);
            instance.areRelated(0, 20);
            fail("should have thrown " + expected);
        } catch (Exception e) {
            assertTrue("type: " + e.getClass().getName()
                    + " should be instance of " + expected,
                    expected.isInstance(e));
            assertNotNull("message should not be null",
                    e.getMessage());
        }
    }

    /** Tests areRelated with a < 0  and invalid b */
    @Test
    public void testAreRelatedE3() {
        System.out.println("areRelated(-1, 4)");
        Class expected = IllegalArgumentException.class;
        try {
            setInstance(1);
            instance.areRelated(-1, 4);
            fail("should have thrown " + expected);
        } catch (Exception e) {
            assertTrue("type: " + e.getClass().getName()
                    + " should be instance of " + expected,
                    expected.isInstance(e));
            assertNotNull("message should not be null",
                    e.getMessage());
        }
    }

    /** Tests areRelated with invalid a */
    @Test
    public void testAreRelatedE4() {
        System.out.println("areRelated(4, 1)");
        Class expected = IllegalArgumentException.class;
        try {
            setInstance(1);
            instance.areRelated(4, 1);
            fail("should have thrown " + expected);
        } catch (Exception e) {
            assertTrue("type: " + e.getClass().getName()
                    + " should be instance of " + expected,
                    expected.isInstance(e));
            assertNotNull("message should not be null",
                    e.getMessage());
        }
    }

    //Tests for add

    /** Tests add with a < 0 */
    @Test
    public void testAddE1() {
        System.out.println("add(-1, 1)");
        Class expected = IllegalArgumentException.class;
        try {
            setInstance(2);
            instance.add(0, 1);
            instance.add(1, 0);
            instance.add(-1, 1);
            fail("should have thrown " + expected);
        } catch (Exception e) {
            assertTrue("type: " + e.getClass().getName()
                    + " should be instance of " + expected,
                    expected.isInstance(e));
            assertNotNull("message should not be null",
                    e.getMessage());
        }
    }

    /** Tests add with invalid b */
    @Test
    public void testAddE2() {
        System.out.println("add(1, 50)");
        Class expected = IllegalArgumentException.class;
        try {
            setInstance(2);
            instance.add(0, 1);
            instance.add(1, 1);
            checkAreRelated(0, 1, true);
            checkAreRelated(0, 0, false);
            checkAreRelated(1, 0, false);
            instance.add(1, 50);
            fail("should have thrown " + expected);
        } catch (Exception e) {
            assertTrue("type: " + e.getClass().getName()
                    + " should be instance of " + expected,
                    expected.isInstance(e));
            assertNotNull("message should not be null",
                    e.getMessage());
        }
    }

    /** Tests add with a < 0 and invalid b */
    @Test
    public void testAddE3() {
        System.out.println("add(-6, 23)");
        Class expected = IllegalArgumentException.class;
        try {
            setInstance(2);
            instance.add(0, 1);
            instance.add(1, 0);
            checkAreRelated(0, 1, true);
            checkAreRelated(1, 0, true);
            instance.add(-6, 23);
            fail("should have thrown " + expected);
        } catch (Exception e) {
            assertTrue("type: " + e.getClass().getName()
                    + " should be instance of " + expected,
                    expected.isInstance(e));
            assertNotNull("message should not be null",
                    e.getMessage());
        }
    }

    /** Tests add with invalid a */
    @Test
    public void testAddE4() {
        System.out.println("add(25, 1)");
        Class expected = IllegalArgumentException.class;
        try {
            setInstance(2);
            instance.add(0, 1);
            instance.add(1, 0);
            checkAreRelated(0, 1, true);
            checkAreRelated(1, 0, true);
            instance.add(25, 1);
            fail("should have thrown " + expected);
        } catch (Exception e) {
            assertTrue("type: " + e.getClass().getName()
                    + " should be instance of " + expected,
                    expected.isInstance(e));
            assertNotNull("message should not be null",
                    e.getMessage());
        }
    }

    //Tests for remove

    /** Tests add with invalid b */
    @Test
    public void testRemoveE1() {
        System.out.println("remove(5, 45)");
        Class expected = IllegalArgumentException.class;
        try {
            setInstance(4);
            instance.remove(2, 1);
            instance.remove(5, 45);
            fail("should have thrown " + expected);
        } catch (Exception e) {
            assertTrue("type: " + e.getClass().getName()
                    + " should be instance of " + expected,
                    expected.isInstance(e));
            assertNotNull("message should not be null",
                    e.getMessage());
        }
    }

    /** Tests add with a < 0 */
    @Test
    public void testRemoveE2() {
        System.out.println("remove(-8, 3)");
        Class expected = IllegalArgumentException.class;
        try {
            setInstance(10);
            instance.add(2, 4);
            checkAreRelated(2, 4, true);
            instance.remove(2, 4);
            checkAreRelated(2, 4, false);
            instance.remove(-8, 3);
            fail("should have thrown " + expected);
        } catch (Exception e) {
            assertTrue("type: " + e.getClass().getName()
                    + " should be instance of " + expected,
                    expected.isInstance(e));
            assertNotNull("message should not be null",
                    e.getMessage());
        }
    }

    /** Tests add with invalid b and a < 0 */
    @Test
    public void testRemoveE3() {
        System.out.println("remove(-99, 67)");
        Class expected = IllegalArgumentException.class;
        try {
            setInstance(4);
            instance.remove(2, 3);
            instance.remove(-99, 67);
            fail("should have thrown " + expected);
        } catch (Exception e) {
            assertTrue("type: " + e.getClass().getName()
                    + " should be instance of " + expected,
                    expected.isInstance(e));
            assertNotNull("message should not be null",
                    e.getMessage());
        }
    }

    /** Tests add with invalid a */
    @Test
    public void testRemoveE4() {
        System.out.println("remove(10, 3)");
        Class expected = IllegalArgumentException.class;
        try {
            setInstance(4);
            instance.remove(2, 3);
            instance.remove(10, 3);
            fail("should have thrown " + expected);
        } catch (Exception e) {
            assertTrue("type: " + e.getClass().getName()
                    + " should be instance of " + expected,
                    expected.isInstance(e));
            assertNotNull("message should not be null",
                    e.getMessage());
        }
    }

    //Tests for the iteraror

    /** Test 1 */
    @Test
    public void testIterator1() {
        System.out.println("Iterator(empty)");
        setInstance(3);
        for(Pair pair : instance) {
            checkAreRelated(pair.a, pair.b, false);
        }
    }

    /** Test 2 */
    @Test
    public void testIterator2() {
        System.out.println("iterator(values)");
        setInstance(2);
        instance.add(1,0);
        instance.add(0,1);
        instance.add(1,1);
        int result = 0;
        for(Pair pair : instance) {
            if (instance.areRelated(pair.a, pair.b)) {
                ++ result;
            }
        }
        assertEquals("iterator fails", 3, result);
    }

    /** Test 3 */
    @Test
    public void testIterator3() {
        System.out.println("iterator(values)");
        setInstance(15);
        instance.add(3, 10);
        int a = -1;
        int b = -1;
        boolean result = false;
        for(Pair pair : instance) {
            if (instance.areRelated(pair.a, pair.b)) {
                a = pair.a;
                b = pair.b;
            }
        }
        if (a == 3 && b == 10){
            result = true;
        }
        assertEquals("iterator fails", true, result);
    }

    /** Test 4 */
    @Test
    public void testIterator4() {
        System.out.println("iterator(values)");
        setInstance(13);
        instance.add(3, 4);
        int a = -1;
        int b = -1;
        for(Pair pair : instance) {
            instance.add(pair.a, pair.b);
        }
        for(Pair pair : instance) {
            checkAreRelated(pair.a, pair.b, true);
        }
    }
}