import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An implementation of {@code IntRelation} using nested arrays.
 * For relations with a small extent this may work faster.
 * However, relations with a large extent use more memory,
 * even when they are sparse (have few related pairs).
 *
 * <!--//# BEGIN TODO Name, group id, and date-->
 * <p><font color="red"><b>Lev Osipov, 271(1), 30.10.2013</b></font></p>
 * <!--//# END TODO-->
 *
 */
// -----8<----- cut line -----8<-----
public class IntRelationArraysIterable
        extends IntRelation implements Iterable<Pair> {

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

    public IntRelationArraysIterable(final int n) {
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
                    a + ", " + b + ") violates precondition");
        }
        //precondition is checked
        return relation[a][b];
    }

    @Override
    public void add(int a, int b)
            throws IllegalArgumentException {
        if (! (isValidPair(a, b))) {
            throw new IllegalArgumentException("add(" +
                    a + ", " + b + ") violates precondition");
        }
        //precondition is checked
        relation[a][b] = true;
    }

    @Override
    public void remove(int a, int b)
            throws  IllegalArgumentException {
        if (! (isValidPair(a, b))) {
            throw new IllegalArgumentException("remove(" +
                    a + ", " + b + ") violates precondition");
        }
        //precondition checked
        relation[a][b] = false;
    }


    public Iterator<Pair> iterator() {
        return new ArraysIterator();
    }

    /** Inner class for a low-to-high iterator */
    public class ArraysIterator implements Iterator<Pair> {

        /** State of iterator. */
        private int row; // next line (if any)
        private int column;
        private final int sentinel; // element one beyond last

        /** Constructs iterator in initial state. */
        ArraysIterator() {
            row = 0;
            column = 0;
            sentinel = extent();
        }

        public boolean hasNext() {
            while (row < sentinel) {
                while (column < sentinel) {
                    if (areRelated(row, column)) {
                        return  true;
                    }
                    ++ column;
                }
                ++ row;
                column = 0;
            }
            return  false;
        }

        public Pair next() {
            if (row >= sentinel || column >= sentinel) {
                throw new NoSuchElementException("ArraysIterator.next");
            }
            Pair temp = new Pair(row, column);
            if (++ column == sentinel) {
                ++ row;
                column = 0;
            }
            return temp;
        }

        public void remove() {
            A a = new A();
            B b = null;
            C c = null;
            a = (A)c;
            throw new UnsupportedOperationException();


        }
    }
}
class A{}
class B exten{}
class C extends  B{}

