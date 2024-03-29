/**
 * Dice Game: ROBUST VERSION.
 * <p>
 * Consider the following dice game.
 * n players (n >= 1) each roll once per round.
 * Player 1 rolls a (fair) dodecahedron,
 * having 12 faces with the numbers 1 through 12.
 * The other players (2 through N) roll two fair dice,
 * each having 6 faces with the numbers 1 through 6.
 * The player with the unique highest roll
 * wins the round.  If the highest roll is
 * not unique, then there is no round winner.
 *
 <!--//# BEGIN TODO Name, group id, and date-->
 <p><font color="red"><b>Lev Osipov, 271(1), 09.10.2013</b></font></p>
 <!--//# END TODO-->
 */
// -----8<----- cut line -----8<-----
public class DiceGameDecomposed {

    /** Index for frequency of rounds without winner */
    final static int NO_WINNER = 0;

    /**
     * Simulates r >= 0 rounds of the dice game and
     * returns how often each of n >= 1 players has won.
     * The return value is an array, where
     * index 0 counts the number of rounds without winner, and
     * index i > 0 counts the number of rounds won by player i.
     *
     * @param n  number of players
     * @param r  number of rounds
     * @return array with winning frequencies
    <!--//# BEGIN TODO Contract for exceptions-->
    <p><font color="red"><b>
     * @throws IllegalArgumentException  if
     *   precondition violated
    </b></font></p>
    <!--//# END TODO-->
     * @pre  {@code 1 <= n && 0 <= r}
     * @post {@code \result.length == NUM_PLAYERS + 1 &&
     *   (\sum i; \result.has(i); \result[i]) == r &&
     *   (\forall i; \result.has(i); 0 <= \result[i])}
     */
    static public int[] simulate(int n, int r)
        throws IllegalArgumentException {
//# BEGIN TODO Robust implementation
        if (! (1 <= n) || ! (0 <= r)) {
            throw new IllegalArgumentException(
                    "DiceGameDecomposed.simulate(" + n + ", " + r + ")" +
                            " violates precondition");
        }
        // @pre satisfied

        int[] result; // winning frequencies
        result = new int[1 + n]; // initialize to 0
        for (int i = 0; i < r; i ++) {
            result[simulate1round(n)]++; // scoring the winner
        }
        return result;
//# END TODO
    }

    /**
     * Simulates one round of the game for n players.
     *
     * @param n  number of players
     * @return Which player won, or NO_WINNER if no winner
     * @throws IllegalArgumentException  if
     *   precondition violated
     * @pre {@code 1 <= n}
     * @post {@code NO_WINNER <= \result <= n}
     */
    static int simulate1round(int n)
            throws IllegalArgumentException {
        if (! (1 <= n)) {
            throw new IllegalArgumentException(
                    "DiceGameDecomposed.simulate1round(" + n + ")" +
                            " violates precondition");
        }
        // @pre satisfied

        return getWinner(getRolls(n));
    }

    /**
     * Returns array with n rolls:
     * the first player rolls a dodecahedron;
     * the other players roll two dice.
     * N.B. The roll of player 1 is returned at index 0.
     *
     * @param n  number of players
     * @return  array with roll values
     * @throws IllegalArgumentException  if
     *   precondition violated
     * @pre {@code 1 <= n}
     * @post {@code \result.length == n}
     */
    static int[] getRolls(int n)
            throws IllegalArgumentException {
        if (! (1 <= n)) {
            throw new IllegalArgumentException(
                    "DiceGameDecomposed.getRolls(" + n + ")" +
                            " violates precondition");
        }
        // @pre satisfied

        int[] result = new int[n];
        result[1 - 1] = roll(12); // roll dodecahedron

        for (int player = 2; player <= n; ++ player) {
            result[player - 1] = roll(6) + roll(6);
        } // for player

        return result;
    }

    /**
     * The random generator, used only by roll()
     */
    final static java.util.Random random = new java.util.Random();

    /**
     * Rolls k-sided fair die with values 1 through k.
     *
     * @param k  number of faces on die.
     * @return roll value
    <!--//# BEGIN TODO Contract for exceptions-->
    <p><font color="red"><b>
     * @throws IllegalArgumentException  if
     *   precondition violated
    </b></font></p>
    <!--//# END TODO-->
     * @pre {@code 1 <= k}
     * @post {@code 1 <= \result <= k}
     */
    static int roll(int k)
        throws IllegalArgumentException {
//# BEGIN TODO Robust implementation
        if (! (1 <= k)) {
            throw new IllegalArgumentException(
                    "DiceGameDecomposed.roll(" + k + ")" +
                            " violates precondition");
        }
        // @pre satisfied

        return random.nextInt(k) + 1;
//# END TODO
    }

    /**
     * Determine round winner, given the round rolls.
     * Returns NO_WINNER, if there is no winner.
     *
     * @param rolls  array with rolls
     * @return Which player won, or NO_WINNER if no winner
     * @throws NullPointerException  if {@code rolls == null}
     * @throws IllegalArgumentException  if {@code rolls.length < 1}
     * @pre {@code 1 <= rolls.length}
     * @post {@code NO_WINNER <= \result <= rolls.length}
     */
    static int getWinner(int[] rolls)
            throws NullPointerException, IllegalArgumentException {
        if (rolls == null) {
            throw new NullPointerException(
                    "DiceGameDecomposed.getWinner(rolls)" +
                            " violates precondition: rolls == null");
        }
        if (! (1 <= rolls.length)) {
            throw new IllegalArgumentException(
                    "DiceGameDecomposed.getWinner(rolls)" +
                            " violates precondition: rolls.length < 1");
        }
        // @pre satisfied

        int max_roll = max(rolls); // the maximum score
        if (count(max_roll, rolls) == 1) { // we have a winner
            return 1 + find(max_roll, rolls);
        } else {
            return NO_WINNER;
        }
    }

    /**
     * Returns maximum of a given integer array of nonnegative values.
     * N.B. The array is not empty.
     *
     * @param a  array to max
     * @return maximum value in {@code a}
    <!--//# BEGIN TODO Contract for exceptions-->
    <p><font color="red"><b>
     * @throws NullPointerException  if {@code a == null}
     * @throws IllegalArgumentException  if
     *   {@code a.length == 0 || (\forall i; a.has(i); 0 <= a[i])}
    </b></font></p>
    <!--//# END TODO-->
     * @pre {@code a != null && a.length != 0}
     *   && (\forall i; a.has(i); 0 <= a[i])}
     * @post {@code \result == (\max i; a.has(i); a[i])}
     */
    static int max(int[] a)
        throws NullPointerException, IllegalArgumentException {
//# BEGIN TODO Robust implementation
        if (a == null) {
            throw new NullPointerException(
                    "DiceGameDecomposed.max(a)" +
                            " violates precondition: a == null");
        }
        if (a.length == 0) {
            throw new IllegalArgumentException(
                    "DiceGameDecomposed.max(a)" +
                            " violates precondition: a.length != 0");
        }
        for (int i = 0; i < a.length; ++ i) {
            if (! (0 <= a[i])) {
                throw new IllegalArgumentException(
                        "DiceGameDecomposed.max(a)" +
                                " violates precondition: (\\forall i; a.has(i); 0 <= a[i])");
            }
        }
        // @pre satisfied

        int result = a[0]; // max value
        for (int i = 1; i < a.length; i ++) {
            if (a[i] > result) {
                result = a[i];
            }
        }
        return result;
//# END TODO
    }

    /**
     * Returns how many times value x occurs in array a.
     *
     * @param x  value to count
     * @param a  array to count in
     * @return How often {@code x} occurs in {@code a}
     * @throws NullPointerException  if {@code a == null}
     * @pre {@code a != null}
     * @post {@code \result == (\num_of i; a.has(i); a[i] == x)}
     */
    static int count(int x, int[] a)
            throws NullPointerException {
        if (a == null) {
            throw new NullPointerException(
                    "DiceGameDecomposed.count(x, a)" +
                            " violates precondition: a == null");
        }
        // @pre satisfied

        int result = 0;
        for (int v : a) {
            if (v == x) {
                ++ result;
            }
        } // for v : a
        return result;
    }

    /**
     * Finds index of a value x in array a, given that it occurs.
     *
     * @param x  value to find
     * @param a  array to search in
     * @return index where {@code x} occurs in {@code a}
    <!--//# BEGIN TODO Contract for exceptions-->
    <p><font color="red"><b>
     * @throws NullPointerException  if {@code a == null}
     * @throws IllegalArgumentException  if
     *   {@code (\exists i; a.has(i); a[i] == x)}
    </b></font></p>
    <!--//# END TODO-->
     * @pre {@code a != null && (\exists i; a.has(i); a[i] == x)}
     * @post {@code a.has(\result) && a[\result] == x}
     */
    static int find(int x, int[] a)
        throws NullPointerException, IllegalArgumentException {
//# BEGIN TODO Robust implementation
        if (a == null) {
            throw new NullPointerException(
                    "DiceGameDecomposed.find(x, a)" +
                            " violates precondition: a == null");
        }
        // first precondition satisfied

        int index = -1; // index of value x
        for (int i = 0; i < a.length; i ++) {
            if (x == a[i]) {
                index = i;
            }
        }

        if (index == -1) {
            throw new IllegalArgumentException(
                    "DiceGameDecomposed.find(x, a)" +
                            " violates precondition: (\\exists i; a.has(i); a[i] == x)");
        }
        // second precondition satisfied

        return index;
//# END TODO
    }

}
