import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Version of {@link IntRelationArrays}, that allows iteration
 * over all related integers to a given first integer.
 *
<!--//# BEGIN TODO Name, group id, and date-->
<p><font color="red"><b>Lev Osipov, 271(1), 06.11.2013</b></font></p>
<!--//# END TODO-->
*/
// -----8<----- cut line -----8<-----
public class IntRelationArraysR2F extends IntRelationArrays
        implements IntRelationExtra {


    public IntRelationArraysR2F(final int n) {
        super(n);
    }

    @Override
    public Iterable<Integer> relatedToFirst(final int a)
            throws IllegalArgumentException {
//# BEGIN TODO Robust implementation of relatedToFirst
        if (! isValid(a)) {
            throw new IllegalArgumentException("relatedToFirst(" +
                    a + ") violates precondition");
        }
        // precondition is checked
        return new Iterable<Integer>() {
            @Override
            public Iterator<Integer> iterator() {
                return new RelationIterator(a);
            }
        };
//# END TODO
    }

    private class RelationIterator implements Iterator<Integer> {
//# BEGIN TODO Definition of inner class RelationIterator
        private int number; // relation subject
        private int position; // related numbers
        private int sentinel; // element one beyond last
        public RelationIterator(int num) {
            number = num;
            position = 0;
            sentinel = extent();
        }
        public boolean hasNext() {
            while (position < sentinel) {
                if (areRelated(number, position)) {
                    return true;
                }
                ++ position;
            }
            return false;
        }
        public Integer next()
                throws NoSuchElementException {
            if (position >= sentinel) {
                throw new NoSuchElementException("RelationIterator.next");
            }
            int temp  = position ++; // iterate after returning
            return temp;
        }
        public void remove()
                throws  UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }
//# END TODO
    }

}
