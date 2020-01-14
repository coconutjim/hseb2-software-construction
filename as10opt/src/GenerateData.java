/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lev
 */
public class GenerateData {
    
    /** Digit sum */
    private int sum;
    
    /** Number of digits */
    private int length;
    
    /** Condition of showing list */
    private boolean list;
    
    /** Condition of showing count */
    private boolean count;
    
    /** Condition of showing inersection */
    private boolean intersection;
    
    /** Condition of showing elimination */
    private boolean elimination;
    
    /**
     * Constructs an object
     */
    public GenerateData(int su, int le, boolean li, boolean co,
            boolean in, boolean el) {
        this.sum = su;
        this.length = le;
        this.list = li;
        this.count = co;
        this.intersection = in;
        this.elimination = el;
        
    }
    
    /**  
     * Returns sum
     * @return {@code sum}
     */
    public int getSum() {
        return sum;
    }
    
    /**  
     * Returns length
     * @return {@code length}
     */
    public int getLength() {
        return length;
    }
    
    /**  
     * Returns list
     * @return {@code list}
     */
    public boolean getList() {
        return list;
    }
    
    /**  
     * Returns count
     * @return {@code count}
     */
    public boolean getCount() {
        return count;
    }
    
    /**  
     * Returns intersection
     * @return {@code intersection}
     */
    public boolean getIntersection() {
        return intersection;
    }
    
    /**  
     * Returns elimination
     * @return {@code elimination}
     */
    public boolean getElimination() {
        return elimination;
    }
    
}
