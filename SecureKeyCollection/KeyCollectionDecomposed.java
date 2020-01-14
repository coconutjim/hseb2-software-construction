import java.lang.Object;

/**
 * Concrete class for homework assignment 3 in Series 3,
 * where you provide a functional decomposition of {@code isSecure()}.
 * <p>
 * Write your code in this file between the lines marked by
 * //# BEGIN TODO ... and //# END TODO (do NOT remove these markers).
 * <p>
 * @author Lev Osipov (HSE)
 * @since 24 Sept 2013
 * <p>
<!--//# BEGIN TODO: Name, id, and date-->
<p><font color="red"><b>Osipov Lev, 271(1), 24.09.2013</b></font></p>
<!--//# END TODO-->
 */
// -----8<----- cut line -----8<-----
public class KeyCollectionDecomposed extends AbstractKeyCollection {

    @Override
    public  boolean isSecure(int[][][] keys)
    {
        boolean flag = true;
//# BEGIN TODO: Functional decomposition; the top-level method
        for (int i = 0; i < keys.length; i ++) {
            for (int j = 0; j < keys.length; j ++) {
                if (i != j) {
                    flag = CK(keys[i], keys[j]);
                    if (!flag) {
                        break;
                    }
                }
            }
        }
        return flag;
//# END TODO
    }
    
//# BEGIN TODO: Functional decomposition; auxiliary method(s)
    /**
     * Checks if {@code key1} can be converted into {@code key2}
     * (checks all rows in borh keys)
     * @param key1 the first key
     * @param key2 the second key
     * @return {@code true} if {@code key1} CAN NOT be converted into {@code key2} or {@code false} if it can
     * @pre {@code key1.length == && key2.length key1 != null && key2 != null}
     */
    boolean CK(int[][] key1, int[][] key2)
    {
        boolean flag = false;
        for (int i = 0; i < key1.length; i ++) {
            flag = CR(key1[i], key1[i]); // checking rows in keys
            if (!flag) {
                break;
            }
        }
        return flag;
    }

    /**
     * Checks if {@code row1} can be converted into {@code row2}
     * (checks the length of both rows and then numbers in them)
     * @param row1 the first row
     * @param row2 the second row
     * @return {@code true} if {@code row1} CAN NOT be converted into {@code row2} or {@code true} if it can
     * @pre {@code row1 != null && row2 != null}
     */
    boolean CR(int[] row1, int[] row2)
    {
        if (row1.length != row2.length) {
            return true;
        }
        boolean flag = false;
        for (int i = 0; i < row1.length; i ++) {
            if (row1[i] > row2[i]) { // checking if row1 can be converted to row2
                flag = true;
                break;
            }
        }
        return flag;
    }
//# END TODO
        
}
