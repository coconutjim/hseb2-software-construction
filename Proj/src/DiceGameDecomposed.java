/**
 * <b>Problem:</b> Considering the following dice game.
 * {@code n} players ({@code n >= 1}) each roll once per round.
 * <p>
 * Player {@code 1} rolls a (fair) dodecahedron,
 * having {@code 12} faces with the numbers {@code 1} through {@code 12}.
 * The other players ({@code 2} through {@code n}) roll two fair dice,
 * each having {@code 6} faces with the numbers {@code 1} through {@code 6}.
 * <p>
 * The player with the unique highest roll
 * wins the round.  If the highest roll is
 * not unique, then there is no round winner.
 * @author Lev Osipov (HSE)
 * @since 24 Sept 2013
 * <p>
 <!--//# BEGIN TODO: Name, group, and date-->
 <p><font color="red"><b>Osipov Lev, 271(1), 24.09.2013</b></font></p>
 <!--//# END TODO-->
 */
// -----8<----- cut line -----8<-----
public class DiceGameDecomposed {

    /** Index for frequency of rounds without winner */
    final static int NO_WINNER = 0;

    /**
     * Simulates {@code r >= 0} rounds of the dice game and
     * returns how often each of {@code n >= 1} players has won.
     * The return value is an array, where
     * index {@code 0} counts the number of rounds without winner, and
     * index {@code i >} 0 counts the number of rounds won by player {@code i}.
     * @param n number of players
     * @param r number of rounds
     * @return an array with numbers of wins of each player
     * @pre {@code r >= 0 && n >= 1}
     * @post {@code (\forall int i; 0 <= i < \result.length; 0 <= \result[i] <= r)}
     */
    static public int[] simulate(int n, int r) {
        int[] result; // winning frequencies
        result = new int[1 + n]; // initialize to 0
        for (int i = 0; i < r; i ++) {
            result[simulate1round(n)]++; // scoring the winner
        }
        return result;
    }

    /**
     * Simulates one round of the game for n players.
     * Returns the winner of the round, or NO_WINNER
     * if there is no winner.
     * @param n number of players
     * @return winner number
     * @pre {@code n >= 1}
     * @post {@code 0 <= \result <= n}
     */
    static int simulate1round(int n) {
        return getWinner(getRolls(n));
    }

    /**
     * Returns array with {@code n} rolls:
     * the first player rolls a dodecahedron;
     * the other players roll two dice.
     * N.B. The roll of player {@code 1} is returned at index {@code 0}.
     * @param n number of players
     * @return an array with rolls of each player
     * @pre {@code n >= 1}
     * @post {@code (\forall int i; 1 <= i < \result.length; 2 <= \result[i] <= 12) && 1 <= /result[0] <= 6}
     */
    static int[] getRolls(int n) {
        int[] result = new int[n]; //array of rolls
        result[0] = roll(12);
        for (int i = 1; i < result.length; i ++) {
            result[i] = roll(6) + roll(6);
        }
        return result;
    }

    /**
     * The random generator, used only by roll()
     */
    final static java.util.Random random = new java.util.Random();

    /**
     * Rolls k-sided fair dice with values {@code 1} through {@code k}.
     * @param k number of dice sides
     * @return result of rolling
     * @pre {@code k => 1}
     * @post {@code 1 <= \result <= k}
     */
    static int roll(int k) {
        return random.nextInt(k) + 1;
    }

    /**
     * Determine round winner, given the round rolls.
     * @param  rolls array of players rolls
     * @return number of winner or {@code NO_WINNER} if there is no winner
     * @post {@code 0 <= \return < rolls.length}
     */
    static int getWinner(int[] rolls) {
        if (count(max(rolls), rolls) > 1) { // checking if the result is unique
            return NO_WINNER;
        }
        else {
            return find(max(rolls), rolls) + 1; // returns player number
        }
    }

    /**
     * Returns maximum of a given integer array of non negative values.
     * N.B. The array is not empty.
     * @param a source array
     * @return maximum of source array
     */
    static int max(int[] a) {
        int result = a[0]; // max value
        for (int i = 1; i < a.length; i ++) {
            if (a[i] > result) {
                result = a[i];
            }
        }
        return result;
    }

    /**
     * Returns how many times value {@code x} occurs in array {@code a}.
     * @param a source array
     * @param x source value
     * @return number of values {@code x} in array {@code a}
     * @post {@code 1 <= \result <= a.length}
     */
    static int count(int x, int[] a) {
        int result = 0; // value number
        for (int i = 0; i < a.length; i ++) {
            if (a[i] == x) {
                result++;
            }
        }
        return result;
    }

    /**
     * Finds a value {@code x} in array {@code a}, given that it occurs.
     * @param a source array
     * @param x source value
     * @return index of value {@code x} in array {@code a}
     * @post {@code 0 <= \result < a.length}
     */
     static int find(int x, int[] a) {
        int index = 0; // index of value x
        for (int i = 0; i < a.length; i ++) {
            if (x == a[i]) {
                index = i;
            }
        }
        return index;
    }

}