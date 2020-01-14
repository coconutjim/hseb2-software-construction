// Class to illustrate Test-Driven Development of an Abstract Data Type.

/**
 * An implementation of {@code IntRelation} using nested arrays.
 * For relations with a small extent this may work faster.
 * However, relations with a large extent use more memory,
 * even when they are sparse (have few related pairs).
 *
 * <!--//# BEGIN TODO Name, group id, and date-->
 * <p><font color="red"><b>Lev Osipov, 271(1), 24.10.2013</b></font></p>
 * <!--//# END TODO-->
 *
 */
// -----8<----- cut line -----8<-----
public class IntRelationArrays extends IntRelation {

    /** Representation of the relation. */
    private boolean[][] relation;
    // could be declared final

    /*
     * Representation invariants
     * 
     * NotNull: relation != null
     * Extent: relation.length == extent()
     * ElementsNotNull: (\forall i; relation.has(i); relation[i] != null)
     * ElementsSameSize: (\forall i; relation.has(i);
     *     relation[i].length == relation.length)
     *
     * Abstraction function: set of (a, b) such that relation[a][b] holds
     */

    public IntRelationArrays(final int n) {
        super(n);
        relation = new boolean[n][n];
    }

    @Override
    public boolean isRepOk() {
        if (relation == null) {
            throw new IllegalStateException("relation == null");
        }
        for (int i = 0; i != relation.length; ++ i) {
            if (relation[i] == null) {
                throw new IllegalStateException(
                        "relation[" + i + "] == null");
            }
            if (relation[i].length != relation.length) {
                throw new IllegalStateException(
                        "relation[" + i + "].length != relation.length");
            }
        }
        return true;
    }
    
    @Override
    public int extent() {
        return relation.length;
    }
    
    @Override
    public boolean areRelated(int a, int b)
            throws  IllegalArgumentException {
        if (! (isValidPair(a, b))) {
            throw new IllegalArgumentException("areRelated(" +
                    a + "," + b + ") violates precondition");
        }
        //precondition is checked
        return relation[a][b];
    }

    @Override
    public void add(int a, int b)
            throws IllegalArgumentException {
        if (! (isValidPair(a, b))) {
            throw new IllegalArgumentException("add(" +
                    a + "," + b + ") violates precondition");
        }
        //precondition is checked
        relation[a][b] = true;
    }

    @Override
    public void remove(int a, int b)
            throws  IllegalArgumentException {
        if (! (isValidPair(a, b))) {
            throw new IllegalArgumentException("remove(" +
                    a + "," + b + ") violates precondition");
        }
        //precondition checked
        relation[a][b] = false;
    }

}
