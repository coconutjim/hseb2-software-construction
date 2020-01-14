import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

// Class to illustrate Test-Driven Development of a generic Abstract Data Type.

/**
 * An implementation of {@link Relation} using a {@link Map} of {@link Set}s.
 *
<!--//# BEGIN TODO Name, group id, and date-->
<p><font color="red"><b>Lev Osipov, 271(1), 06.11.2013</b></font></p>
<!--//# END TODO-->
*/
// -----8<----- cut line -----8<-----
public class RelationMapOfSets<A, B> implements Relation<A, B> {
//# BEGIN TODO Definition of class RelationMapOfSets

    /** Representation of the relation. */
    private Map<A, Set<B>> relation;
    /*
     * Representation invariants
     *
     * NotNull: relation != null
     * ElementsNotNull: (\forall j; relation.has(j); relation.get(j) != null),
     *     where List.has(j) == 0 <= j < List.size()
     * ElementsInExtent: (\forall j; relation.has(j);
     *     relation.get(j) subset of [0 .. relation.size()))
     * Abstraction function: set of (a, b) such that
     *     relation.get(a).contains(b) holds
     */
    public RelationMapOfSets() {
        relation = new HashMap<A, Set<B>>();
    }

    @Override
    public boolean isRepOk() {
        if (relation == null) {
            throw new IllegalStateException("relation == null");
        }
        return true;
    }

    @Override
    public boolean areRelated(A a, B b) {
        return (relation.containsKey(a) && relation.get(a).contains(b));
    }

    @Override
    public void add(A a, B b) {
        if (! relation.containsKey(a)) {
            relation.put(a, new HashSet<B>());
        }
        relation.get(a).add(b);
    }

    @Override
    public void remove(A a, B b) {
        if (relation.containsKey(a)) {
            relation.get(a).remove(b);
            if (relation.get(a).isEmpty()) {
                relation.remove(a);
            }
        }

    }

    public Iterable<B> relatedToFirst(final A a) {
        return new Iterable<B>()
        {
            @Override
            public Iterator<B> iterator()
            {
                if (! relation.containsKey(a)) {
                    relation.put(a, new HashSet<B>());
                }
                return relation.get(a).iterator();
            }
        };
    }

    @Override
    public Iterator<Pair<A, B>> iterator() {
        return new MapOfSetsIterator();
    }

    private class MapOfSetsIterator implements Iterator<Pair<A, B>> {

        private A[] key;
        private B[] value;
        private int index_1;
        private int index_2;
        MapOfSetsIterator() {
            key = (A[])((relation.keySet()).toArray());
            index_2 = 0;
            index_1 = 0;
        }

        public boolean hasNext() {
            while (index_1 < key.length) {
                value = (B[])((relation.get(key[index_1])).toArray());
                if (index_2 <= value.length) {
                    return true;
                }
                index_2 = 0;
                ++ index_1;
            }
            return false;
        }

        public Pair next()
                throws  NoSuchElementException {
            if (index_1 >= key.length) {
                throw new NoSuchElementException("ListOfSetsIterator.next");
            }
            Pair<A, B> temp = new Pair(key[index_1], value[index_2]);
            if (++ index_2 == value.length) {
                ++ index_1;
                index_2 = 0;
            }
            return temp;
        }

        public void remove()
                throws  UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }
    }
//# END TODO
}
