import java.util.*;

// Class to illustrate Test-Driven Development of an Abstract Data Type.

/**
 * An implementation of {@code IntRelation} using a Map of Sets.
 * For sparse relations with a large extent, this reduces memory usage.
 * However, there is a bit of performance overhead.
 *
 * <!--//# BEGIN TODO Name, group id, and date-->
 * <p><font color="red"><b>Lev Osipov, 271(1), 24.10.2013</b></font></p>
 * <!--//# END TODO-->
 *
 */
// -----8<----- cut line -----8<-----
public class IntRelationMapOfSets extends IntRelation {

    /** Representation of the relation. */
    private Map<Integer, Set<Integer>> relation;
    // could be declared final

    /*
     * Representation invariants
     *
     * NotNull: relation != null
     * ElementsNotNull: (\forall i; relation.has(i); relation.get(i) != null),
     *     where Map.has(i) == 0 <= i < Map.size()
     * ElementsInExtent: (\forall i; relation.has(i);
     *     relation.get(i) subset of [0 .. relation.size()))
     *
     * Abstraction function: set of (a, b) such that
     *     relation.get(a).contains(b) holds
     */

    public IntRelationMapOfSets(final int n) {
        super(n);
        relation = new HashMap<Integer, Set<Integer>>();
        /* Java 7, but this upsets Checkstyle
        relation = new ArrayList<>();
        */
        for (int i = 0; i != n; ++ i) {
            relation.put(i, new HashSet<Integer>());
        }
    }

    /* Why is it harder to get the following intialization to work?
     * It is probably better to exclude this through a rep invariant.
           relation = new HashMap<Set<Integer>>();
           final Set empty = new HashSet<Integer>();
           for (int i = 0; i != n; ++ i) {
               relation.put(empty);
           }
     */
    @Override
    public boolean isRepOk() {
        if (relation == null) {
            throw new IllegalStateException("relation == null");
        }
        for (int i = 0; i != relation.size(); ++ i) {
            final Set<Integer> set = relation.get(i);
            if (set == null) {
                throw new IllegalStateException(
                        "relation.get(" + i + ") == null");
            }
            for (int a : set) {
                if (! (0 <= a && a < relation.size())) {
                    throw new IllegalStateException(
                            "relation.get(" + i + ") contains " + a);
                }
            }
        }
        return true;
    }

    @Override
    public int extent() {
        return relation.size();
    }

    @Override
    public boolean areRelated(int a, int b)
            throws IllegalArgumentException {
        if (! (isValidPair(a, b))) {
            throw new IllegalArgumentException("areRelated(" +
                    a + "," + b + ") violates precondition");
        }
        //precondition is checked
        return relation.containsKey(a) && relation.get(a).contains(b);
    }

    @Override
    public void add(int a, int b)
            throws IllegalArgumentException {
        if (! (isValidPair(a, b))) {
            throw new IllegalArgumentException("add(" +
                    a + "," + b + ") violates precondition");
        }
        //precondition is checked
        relation.get(a).add(b);
    }

    @Override
    public void remove(int a, int b)
            throws IllegalArgumentException {
        if (! (isValidPair(a, b))) {
            throw new IllegalArgumentException("remove(" +
                    a + "," + b + ") violates precondition");
        }
        //precondition is checked
        relation.get(a).remove(b);
    }

}
