import java.util.ArrayList;

/**
 * A game table with players.
 * 
<!--//# BEGIN TODO Name, group id, and date-->
<p><font color="red"><b>Lev Osipov, 271(1), 16.10.2013</b></font></p>
<!--//# END TODO-->
 */
// -----8<----- cut line -----8<-----
public class GameTable {
    
    /** Virtual player number for rounds without winner */
    public static final int NO_WINNER = 0;
    
    /** The players at the table */
    private final ArrayList<Player> players;
    
    // ===== ===== Constructors ===== =====
    
    /**
     * Constructs a new game table with a given number of players,
     * where the first player rolls a dodecahedron, and
     * the others roll two regular (6-sided) dice.
     * 
     * @param n  number of players
     * @throws IllegalArgumentException if precondition violated
     * @pre {@code 1 <= n}
     * @post new game table constructed
     */
    public GameTable(int n) throws IllegalArgumentException {
//# BEGIN TODO constructor implementation
        if (! (1 <= n)) {
            throw new IllegalArgumentException("GameTable.GameTable(" +
                    n +"): precondition violated");
        }
        players = new ArrayList<Player>();
        players.add(new Player(1, 12));
        for (int i = 1; i < n; ++i) {
            players.add(new Player(2, 6));
        }
//# END TODO
    }
        
    // ===== ===== Queries ===== =====
    
    /**
     * Gets the number of players at the table.
     * 
     * @pre {@code true}
     * @post {@code \result == number of players}
     */
    public int getNumOfPlayers() {
//# BEGIN TODO query implementation
        return players.size();
//# END TODO
    }
    
    /**
     * Determine player number of round winner.
     * Returns NO_WINNER, if there is no winner.
     * 
     * @return player number of round winner, or NO_WINNER if no winner
     * @pre {@code players != null &&} all players have rolled
     * @post {@code NO_WINNER <= \result <= getNumOfPlayers()}
     */
    public int getWinner() {
//# BEGIN TODO query implementation
        int max = 0; // max roll
        int index = 0; // max roll plyaer
        int count = 0; // count of max rolls
        for (int i = 0; i < players.size(); ++ i) {
            if (players.get(i).getValue() > max) {
                max = players.get(i).getValue();
                index = i;
            }
        }
        for (Player player : players) {
            if (player.getValue() == max) {
                ++ count;
            }
        }
        if (count == 1) {
            return index + 1;
        }
        else {
            return NO_WINNER;
        }
//# END TODO
    }
    
    // ===== ===== Commands ===== =====
    
    /**
     * Lets all players roll.
     * 
     * @pre {@code true}
     * @modifies {@code this}
     * @post all players have rolled once
     */
    public void rollAll() {
//# BEGIN TODO command implementation
        for (Player player : players) {
            player.rollDice();
        }
//# END TODO
    }
    
}
