import java.util.Random;

/**
 * Class for a player that can roll with a specific set of dice.
 * 
<!--//# BEGIN TODO Name, group id, and date-->
<p><font color="red"><b>Lev Osipov, 271(1), 16.10.2013</b></font></p>
<!--//# END TODO-->
 */
// -----8<----- cut line -----8<-----
public class Player {
    
    /** Number of dice */
    private final int nDice;
    
    /** Number of sides per dice */
    private final int nSides;
    
    /** Last roll value */
    private int value;
    
    /** Random generator */
    private final java.util.Random random;
    
    // Representation invariants:
    //   1 <= nDice
    //   1 <= nSides
    //   0 <= value <= nDice * nSides
    //   random != null
    
    // ===== ===== Constructors ===== =====
    
    /**
     * Constructs a player for a given set of dice.
     * 
     * @param nDice  number of dice
     * @param nSides  number of sides per dice
     * @throws IllegalArgumentException if precondition violated
     * @pre {@code 1 <= nDice && 1 <= nSides}
     * @post new Player constructed
     */
    public Player(final int nDice, final int nSides)
            throws IllegalArgumentException {
//# BEGIN TODO constructor implementation
        if (! (1 <= nDice && 1 <= nSides)) {
            throw new IllegalArgumentException("Player.Player(" +
                    nDice + ", " + nSides + "): precondition violated");
        }
        this.nDice = nDice;
        this.nSides = nSides;
        this.value = 0;
        random = new Random();
//# END TODO
    }
    
    // ===== ===== Queries ===== =====
    
    /**
     * Gets last roll value, or 0 if never rolled.
     * 
     * @pre {@code true}
     * @post {@code \result == value of last roll}
     */
    public int getValue() {
//# BEGIN TODO query implementation
        return value;
//# END TODO
    }
    
    // ===== ===== Commands ===== =====
    
    /**
     * Lets player roll with the dice.
     * 
     * @pre {@code true}
     * @modifies {@code this}
     * @post {@code getValue() == total value of roll with player's dice}
     */
    public void rollDice() {
//# BEGIN TODO command implementation
        this.value = 0;
        for (int i = 0; i < nDice; ++ i) {
            this.value += random.nextInt(nSides) + 1;
        }
//# END TODO
    }

}
