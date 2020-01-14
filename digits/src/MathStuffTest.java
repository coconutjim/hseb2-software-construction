import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test cases for MathStuff.
 *
<!--//# BEGIN TODO Name, group id, and date-->
<p><font color="red"><b>Lev Osipov, 271(1), 08.10.2013</b></font></p>
<!--//# END TODO-->
*/
// -----8<----- cut line -----8<-----
public class MathStuffTest {

    // Test cases for power(int, int).

    /**
     * Invokes power(a, b) and checks for expected result.
     *
     * @param a  the base
     * @param b  the exponent
     * @param expResult  the expected result
     * @pre {@code 0 &lt;= b && expResult = a ^ b}
     */
    private void checkPower(int a, int b, long expResult) {
        System.out.println("power(" + a + ", " + b + ")");
        long result = MathStuff.power(a, b);
        assertEquals("result", expResult, result);
    }

    /** Smallest exponent. */
    @Test
    public void testPower0() {
        checkPower(0, 0, 1);
    }

    /** Exponent 1. */
    @Test
    public void testPower1() {
        checkPower(2, 1, 2);
    }

    /** Exponent 2. */
    @Test
    public void testPower2() {
        checkPower(3, 2, 9);
    }

     /** Largest base and smallest exponent without overflow. */
    @Test(timeout = 100)
    public void testPowerSmallestNoOverflow() {
        int n = Integer.MAX_VALUE;
        checkPower(n, 1, n);
    }

    /** Smallest base &gt; 1 and largest exponent without overflow. */
    @Test(timeout = 100)
    public void testPowerLargestNoOverflow() {
        checkPower(2, 30, Integer.MAX_VALUE / 2 + 1);
    }

   /** Largest base and smallest exponent &gt; 1 with overflow. */
    @Test(timeout = 100)
    public void testPowerSmallestOverflow() {
        checkPower(46341, 2, Long.MAX_VALUE);
    }

    /** Smallest base &gt; 1 and smallest exponent with overflow. */
    @Test(timeout = 100)
    public void testPowerLargestOverflow() {
        checkPower(2, 31, Long.MAX_VALUE);
    }

    // Test cases for power(Power)

    /** Smoke test. */
    @Test
    public void testPowerPower() {
        MathStuff.Power p = new MathStuff.Power(3, 2);
        assertEquals("result", 3 * 3, MathStuff.power(p));
    }

    // Test cases for powerize(int)

    /**
     * Invokes powerize(power(expB, expE)) and checks for expected result.
     *
     * @param expB  expected base
     * @param expE  expected exponent
     * @pre {@code expB} is not a power with exponent greater than one
     */
    private void checkPowerize(int expB, int expE) {
        long n = MathStuff.power(expB, expE);
        System.out.println("powerize(" + n + ")");
        MathStuff.Power result = MathStuff.powerize((int)n);
        assertEquals("power", n, MathStuff.power(result));
        assertEquals("base", expB, result.base);
        assertEquals("exponent", expE, result.exponent);
    }

    /**
     * Invokes binarySearch(n, exp) and checks for expected result.
     *
     * @param n  the number
     * @param exp  the exponent
     * @param n  the expected result
     * @pre {@code 2 &lt;= n}
     */
    private void checkBinarySearch(int n, int exp, int expResult) {
        System.out.println("binarySearch(" + n + ", " + exp + ")");
        int result = MathStuff.binarySearch(n, exp);
        assertEquals("result", expResult, result);
    }

//# BEGIN TODO Implementations of test cases for powerize(int)

    /** First case */
    @Test
    public void checkPowerize1() {
        checkPowerize(2, 29);
    }

    /** Second case */
    @Test
    public void checkPowerize2() {
        checkPowerize(5, 5);
    }

    /** Third case */
    @Test
    public void checkPowerize3() {
        checkPowerize(3, 15);
    }

//# END TODO

//# BEGIN TODO Test cases for auxiliary functions

    /** First case */
    @Test
    public void checkBinarySearch1() {
        checkBinarySearch(64, 3, 4);
    }

    /** Second case */
    @Test
    public void checkBinarySearch2() {
        checkBinarySearch(1, 1, 1);
    }

    /** Third case */
    @Test
    public void checkBinarySearch3() {
        checkBinarySearch(16, 2, 4);
    }

//# END TODO

}
