/**
 * Consider the following dice game.
 * Five players each roll once per round.
 * Player 1 rolls a (fair) dodecahedron,
 * having 12 faces with the numbers 1 through 12.
 * The other players (2 through 5) roll two fair dice,
 * each having 6 faces with the numbers 1 through 6.
 * The player with the unique highest roll
 * wins the round.  If the highest roll is
 * not unique, then there is no round winner.
 *
 <!--//# BEGIN TODO: Name, id, and date-->
 <p><font color="red"><b>Lev Osipov, 271(1), 10.09.2013</b></font></p>
 <!--//# END TODO-->
 */
// -----8<----- cut line -----8<-----
public class DiceGame {

    /** Number of players, >= 1 */
    final static int NUM_PLAYERS = 5;

    /** Index for frequency of rounds without winner */
    final static int NO_WINNER = 0;

    /**
     * Simulates r >= 0 rounds of the dice game and
     * returns how often each player won.
     * The return value is an array, where
     * index 0 counts the number rounds without winner, and
     * index i > 0 counts the number of rounds won by player i.
     */
    static public int[] simulate(int r) {
        int[] result; // winning frequencies
        result = new int[1 + NUM_PLAYERS]; // initialize to 0
//# BEGIN TODO: Provide your solution
        for (int i = 0; i < r; i++) { // game rounds
            int winner_score; // round winner score
            int winner_id; // round winner number
            winner_score = (int)(Math.random() * 12 + 1);   // first player rolls
            winner_id = 1;
            boolean flag = true; // checking if there is winner
            int temp; //temporary player score
            for (int j = 0; j < NUM_PLAYERS - 1; j++) { // other players roll
                flag = true;
                temp = (int)(Math.random() * 6 + 1) +
                        (int)(Math.random() * 6 + 1); // rolling
                if (temp > winner_score) { // comparing results
                    winner_score = temp;
                    winner_id = j + 2;
                }
                else if (temp == winner_score) { // checking if there is a winner
                    flag = false;
                }
            }
            if (flag) {
                result[winner_id]++;
            }
            else {
                result[0]++;
            }
        }
//# END TODO
        return result;
    }

}