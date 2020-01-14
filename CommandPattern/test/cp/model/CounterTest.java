package cp.model;

import junit.framework.TestCase;

/**
 * Test cases for class Counter.
 * 
 * @author Tom Verhoeff (TU/e)
 */
public class CounterTest extends TestCase {
    
    public CounterTest(String testName) {
        super(testName);
    }

    /**
     * Test of getCount method, of class Counter.
     */
    public void testGetCount() {
        System.out.println("getCount");
        Counter instance = new Counter();
        int expResult = 0;
        int result = instance.getCount();
        assertEquals("Initial state", expResult, result);
    }

    /**
     * Test of reset method, of class Counter.
     */
    public void testReset() {
        System.out.println("reset");
        Counter instance = new Counter();
        {
            instance.reset();
            int expResult = 0;
            int result = instance.getCount();
            assertEquals("Initial state", expResult, result);
        }
        {
            instance.increment();
            instance.reset();
            int expResult = 0;
            int result = instance.getCount();
            assertEquals("After increment, reset", expResult, result);
        }
    }

    /**
     * Test of inc method, of class Counter.
     */
    public void testIncrement() {
        System.out.println("increment");
        Counter instance = new Counter();
        instance.increment();
        int expResult = 1;
        int result = instance.getCount();
        assertEquals("After increment", expResult, result);
    }
    
    /**
     * Test of setCount method, of class Counter.
     */
    public void testSetCount() {
        System.out.println("setCount");
        final int count = 3;
        Counter instance = new Counter();
        instance.setCount(count);
        int result = instance.getCount();
        assertEquals("After increment", count, result);
    }

}
