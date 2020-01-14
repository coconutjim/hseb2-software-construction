import java.util.ArrayList;
import java.util.List;

/**
 * Library with static mathematical functions.
 *
<!--//# BEGIN TODO Name, group id, and date-->
<p><font color="red"><b>Lev Osipov, 271(1), 08.10.2013</b></font></p>
<!--//# END TODO-->
*/
// -----8<----- cut line -----8<-----
public abstract class MathStuff {

    /**
     * Returns exponentiation, taking care of overflow.
     *
     * @param a  the base
     * @param b  the exponent
     * @pre {@code 0 &lt;= b}
     * @return {@code a ^ b} if {@code a ^ b &lt;= Integer.MAX_VALUE}
     *      else Long.MAX_VALUE
     * @throws IllegalArgumentException  if {@code b &lt; 0}
     */
    public static long power(int a, int b) {
        if (b < 0) {
            throw new IllegalArgumentException("power: negative exponent");
        }
        // 0 <= b
        long x = a; // see invariant
        int k = b; // see invariant
        long result = 1L; // see invariant

        // invariant: 0 <= k <= b && result * x^k == a^b
        while (k != 0) {
            if (k % 2 == 0) { // even exponent
                if (x <= Integer.MAX_VALUE) {
                    x *= x;
                } else {
                    x = Long.MAX_VALUE;
                }
                k /= 2;
            } else { // odd exponent
                if (result <= Integer.MAX_VALUE && x <= Integer.MAX_VALUE) {
                    result *= x;
                } else {
                    result = Long.MAX_VALUE;
                }
                k -= 1;
            }
            // invariant holds again, k has decreased
        }
        // k == 0, hence result == a^b

        if (result > Integer.MAX_VALUE) {
            return Long.MAX_VALUE;
        }
        return result;
    }

    /**
     * Record containing a base and an exponent.
     *
     * @inv {@code 0 &lt;= base && 0 &lt;= exponent}
     */
    public static class Power {

        /** The base. */
        public int base;

        /** The exponent. */
        public int exponent;

        /**
         * Constructs a Power with given base and exponent.
         *
         * @param base  the base
         * @param exponent  the exponent
         * @pre {@code 0 &lt;= base && 0 &lt;= exponent}
         * @post {@code \result.base == base && \result.exponent == exponent}
         */
        public Power(int base, int exponent) {
            this.base = base;
            this.exponent = exponent;
        }

    }

    /**
     * Returns exponentiation.
     *
     * @param p  the base and exponent
     * @return {@code power(p.base, p.exponent)}
     */
    public static long power(Power p) {
        return power(p.base, p.exponent);
    }

    /**
     * Writes a number as a power with maximal exponent.
     *
     * @param n  the number to 'powerize'
     * @pre {@code 2 &lt;= n}
     * @post {@code n == power(\result) &&
     *     (\forall int b, int e;
     *      2 &lt;= b && 1 &lt;= e && n == b ^ e;
     *      e &lt;= \result.exponent)}
     */
    public static Power powerize(int n) {
//# BEGIN TODO Implementation of powerize
        int exp = 0;
        int base = 0;
        int temp; // variable for temporary values
        for (int i = 30; i >= 1; i --) {
            temp = binarySearch(n, i);
            if (temp != 0) {
                exp = i;
                base = temp;
                break;
            }
        }
        Power result = new Power(base, exp);
        return result;
//# END TODO
    }

//# BEGIN TODO Contracts and implementation of auxiliary functions.
    /**
     * Finds the possible base of given number and exponent
     * (using binary search).
     *
     * @param n  the number
     * @param exp  the exponent
     * @return  the base to number {@code n} and exponent
     *      {@code exp} or {@code0}
     * @pre {@code 2 &lt;= n}
     * @post {@code \result == n ^ exp || \result == 0}
     */
    public static int binarySearch(int n, int exp) {
        int min; // lower bound of search
        min = 1;
        int max; // higher bound of search
        max = n;
        int mid; // current bound of search
        long temp; // variable for temporary values
        while (max >= min) { // binary search
            mid = (max - min) / 2 + min;
            temp = MathStuff.power(mid, exp);
            if (temp > n) {
                max = mid - 1;
            } else if (temp < n) {
                min = mid + 1;
            } else {
                return mid;
            }
        }
        return 0; // if there is no suitable bases
    }
//# END TODO

}
