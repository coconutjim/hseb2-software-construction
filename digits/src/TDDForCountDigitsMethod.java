/**
 * Illustrates Test-Driven Development of a single method.
 *
<!--//# BEGIN TODO Name, group id, and date-->
<p><font color="red"><b>Lev Osipov, 271(1), 08.10.2013</b></font></p>
<!--//# END TODO -->
*/
// -----8<----- cut line -----8<-----
public class TDDForCountDigitsMethod {

    /**
     * Counts the digits of a number.
     * This concerns a non-negative integer, assumed to be
     * written in positional notation without leading zeroes.
     *
<!--//# BEGIN TODO Contract-->
<p><font color="red"><b>
     * @param n  the number whose digits are counted
     * @param r  the radix
     * @return the number of digits in {@code r}-radix {@code n}
     * @throws IllegalArgumentException  if {@code 0 <= n && 2 <= r}
     * @pre {@code 0 <= n && 2 <= r}
     * @post {@code \result = (\min int k; 1 <= k; n < r ^ k)}
</b></font></p>
<!--//# END TODO-->
     */
    public static int countDigits(long n, long r)
            throws IllegalArgumentException {
//# BEGIN TODO Implementation
        if (! (0 <= n && 2 <= r)) {
            throw new IllegalArgumentException();
        }
        int result = 1;
        while (r <= n) {
            n /= r;
            ++ result;
        }
        return result;
//# END TODO
    }

}
