package cp.model;

/**
 * This class provides a non-negative resettable and incrementable counter.
 * 
 * @inv  {@code 0 <= getCount()}
 * 
 * @author Tom Verhoeff (TU/e)
 */
public class Counter {
    
    /** The count */
    private int count;
    
    // Private invariants:
    //   0 <= count
    
    /**
     * Construct a counter initialized at zero.
     */
    public Counter() {
        count = 0;
    }

    /**
     * Gets the current count.
     * 
     * @return current count
     */
    public int getCount() {
        return count;
    }

    /**
     * Resets the count to zero.
     * 
     * @post {@code getCount() == 0}
     */
    public void reset() {
        setCount(0);
    }
    
    /**
     * Increments the count by one.
     * 
     * @post {@code getCount() == \old(getCount() + 1)}
     */
    public void increment() {
        setCount(getCount() + 1);
    }
    
    /**
     * Sets the current count to a given value.
     * This is public to facilitate an Undo operation.
     * 
     * @param count the new count
     * @pre {@code 0 <= count}
     * @post {@code getCount() = count}
     */
    public void setCount(int count) {
        this.count = count;
    }
    
    
}
