import java.util.HashSet;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test cases for Kakuro combination generator.
 *
 * @author Tom Verhoeff (TU/e)
<!--//# BEGIN TODO Name, group id, and date-->
<p><font color="red"><b>Lev Osipov, 271(1), 14.11.2013</b></font></p>
<!--//# END TODO-->
 */
// -----8<----- cut line -----8<-----
public class KakuroCombinationGeneratorTest {

    /** The subject under test. */
    private KakuroCombinationGenerator instance;

    /** The listener. */
    private Checker checker;

    @Before
    public void setUp() {
        instance = new KakuroCombinationGenerator();
        checker = new Checker();
        instance.addListener(checker);
    }

    // Tests of generate method, of class KakuroCombinationGenerator.

    /**
     * Calls {@code KakuroCombinationGenerator.generate(s, n)},
     * and checks the result, expecting {@code t} combinations.
     */
    public void checkGenerator(int s, int n, int t) {
        System.out.println("generate(" + s + ", " + n
            + ") should generate " + t + " combinations");
        checker.set(s, n);
        instance.generate(s, n);
        assertEquals("Number of combinations", t, checker.count);
    }

    /** Boundary case: minimal s that still works. */
    @Test
    public void testGeneratorMinimal0() {
        checkGenerator(0, 0, 1);
    }

    /** Boundary case: minimal s that just does not work. */
    @Test
    public void testGeneratorMinimal1() {
        checkGenerator(0, 1, 0);
    }

//# BEGIN TODO Further test cases
    /** Boundary case: no combinations. */
    @Test
    public void testNoCombinations() {
        checkGenerator(10, 5, 0);
    }

    /** Boundary case: one combination. */
    @Test
    public void testOneCombination() {
        checkGenerator(7, 3, 1);
    }
    
    /** Boundary case: sum equals to one. */
    @Test
    public void testSumOne() {
        checkGenerator(1, 1, 1);
    }
    
    /** Boundary case: combination of all numbers. */
    @Test
    public void testCombAl1l() {
        checkGenerator(45, 9, 1);
    }
    
    /** Boundary case: close to previous. */
    @Test
    public void testCombAll1() {
        checkGenerator(44, 9, 0);
    }

    /** Ordinary case. */
    @Test
    public void testOrdinaryCase1() {
        checkGenerator(10, 2, 4);
    }
    
    /** Ordinary case. */
    @Test
    public void testOrdinaryCase2() {
        checkGenerator(19, 3, 5);
    }
    
    /** Ordinary case. */
    @Test
    public void testOrdinaryCase3() {
        checkGenerator(24, 6, 3);
    }
    
    /** Ordinary case. */
    @Test
    public void testOrdinaryCase4() {
        checkGenerator(21, 4, 11);
    }
    
    /** Ordinary case. */
    @Test
    public void testOrdinaryCase5() {
        checkGenerator(12, 3, 7);
    }

//# END TODO

    // Auxiliary definitions

    /**
     * Listener that checks that each generated combination
     * has indeed the expected sum and length,
     * and that they appear in lexicographic order.
     */
    private class Checker implements GeneratorListener {

        /** Number of reported combinations. */
        public int count;

        /** Expected sum. */
        private int s;

        /** Expected number. */
        private int n;

        /** Preceding generated combination. */
        private Set<Integer> preceding;

        /** Creates a default initialized checker. */
        public Checker() {
            this.count = 0;
            this.preceding = null;
        }

        /**
         * Sets the expected sum and length.
         *
         * @param s  expected sum
         * @param n  expected length
         */
        public void set(int s, int n) {
            this.s = s;
            this.n = n;
        }

        @Override
        public void combinationGenerated(Set<Integer> combination) {
            ++ this.count;
            System.out.println(combination);
            assertTrue("Lexicographic", precedes(preceding, combination));
            assertEquals("Sum", s, sum(combination));
            assertEquals("Number", n, combination.size());
            this.preceding = new HashSet<Integer>(combination); // NEEDS COPY!
        }
    }

    /**
     * Returns sum of given set of integers.
     *
     * @param c  set of integers, not null
     * @return  sum of integers in {@code c}
     */
    private int sum(Set<Integer> c) {
        int result = 0;
        for (int i : c) {
            result += i;
        }
        return result;
    }

    /**
     * Determines whether one integer set lexicographically precedes another.
     * Null precedes every non-null set.
     *
     * @param c  first set of integers
     * @param d  second set of integers
     * @return  whether {@code c} strictly precedes {@code d}
     */
    private boolean precedes(Set<Integer> c, Set<Integer> d) {
        if (c == null | d == null) {
            return c == null && d != null;
        }
        // c != null && d != null
        for (int i = 1; i < instance.getMaxNumber(); ++ i) {
            if (c.contains(i) != d.contains(i)) {
                return c.contains(i);
            }
        }
        return false;
    }

}
