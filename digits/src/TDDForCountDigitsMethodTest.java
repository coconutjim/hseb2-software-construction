import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Test cases for countDigits method, of class TDDForCountDigitsMethod.
 *
<!--//# BEGIN TODO Name, group id, and date-->
<p><font color="red"><b>Lev Osipov, 271(1), 08.10.2013</b></font></p>
<!--//# END TODO -->
 */
// -----8<----- cut line -----8<-----
public class TDDForCountDigitsMethodTest {

    /** Subject Under Test.  Only static members are used. */
    private static final TDDForCountDigitsMethod SUT = null;

    /**
     * Invokes countDigits(n, r) and checks result against expectation.
     *
     * @param n  the number whose digits are counted
     * @param r  the radix
     * @param expResult  the expected result
     */
    private void checkCountDigits(long n, long r, int expResult) {
        System.out.println("countDigits(" + n + ", " + r + ")");
        int result = SUT.countDigits(n, r);
        assertEquals("result", expResult, result);
    }

//# BEGIN TODO Test cases for "good weather" (no exceptions)

    /** The simplest case */
    @Test
    public void testCountDigits1() {
        checkCountDigits(1L, 10L, 1);
    }

    /** Minimal values */
    @Test
    public void testCountDigits2() {
        checkCountDigits(1L, 2L, 1);
    }

    /** General tests for radix 10 */
    @Test
    public void testCountDigits3() {
        long n = 10L;
        for (int i = 0; i < 10; ++ i) {
            checkCountDigits(n - 1, 10L, i + 1);
            checkCountDigits(n, 10L, i + 2);
            n *= 10;
        }
    }

    /** Overflow test */
    @Test
    public void testCountDigits4() {
        checkCountDigits(Long.MAX_VALUE, 10L, 19);
    }

    /** Test for other radix */
    @Test
    public void testCountDigits5() {
        checkCountDigits(16L, 2L, 5);
    }

    /** Another test */
    @Test
    public void testCountDigits6() {
        checkCountDigits(11L, 15L, 1);
    }

    /** Maximal values */
    @Test
    public void testCountDigits7() {
        checkCountDigits(Long.MAX_VALUE, Long.MAX_VALUE, 2);
    }

    /** Another  test */
    @Test
    public void testCountDigits8() {
        checkCountDigits(45687845L, 3798L, 3);
    }

    /** Another  test */
    @Test
    public void testCountDigits9() {
        checkCountDigits(8000L, 7842L, 2);
    }

    /** Another  test */
    @Test
    public void testCountDigits10() {
        checkCountDigits(87563957258575807L, 92215768359823477L, 1);
    }

    /** Another  test */
    @Test
    public void testCountDigits11() {
        checkCountDigits(8756307L, 9L, 8);
    }

//# END TODO

}
