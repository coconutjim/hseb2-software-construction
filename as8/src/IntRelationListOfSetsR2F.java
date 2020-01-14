import java.util.Iterator;

/**
 * Version of {@link IntRelationListOfSets}, that allows iteration
 * over all related integers to a given first integer.
 *
<!--//# BEGIN TODO Name, group id, and date-->
<p><font color="red"><b>Lev Osipov, 271(1), 06.11.2013</b></font></p>
<!--//# END TODO-->
*/
// -----8<----- cut line -----8<-----
public class IntRelationListOfSetsR2F extends IntRelationListOfSets
        implements IntRelationExtra {

    public IntRelationListOfSetsR2F(final int n) {
        super(n);
    }

    @Override
    public Iterable<Integer> relatedToFirst(final int a)
            throws  IllegalArgumentException {
//# BEGIN TODO Robust implementation of relatedToFirst
        if (! isValid(a)) {
            throw new IllegalArgumentException("relatedToFirst(" +
                    a + ") violates precondition");
        }
        // precondition is checked
        return relation.get(a);
//# END TODO
    }

}
