import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Test cases for functional decomposition in {@code KeyCollectionDecomposed}.
 * @author Lev Osipov (HSE)
 * @since 24 Sept 2013
 *
<!--//# BEGIN TODO: Name, id, and date-->
<p><font color="red"><b>Osipov Lev, 271(1), 24.09.2013</b></font></p>
<!--//# END TODO-->
 */
// -----8<----- cut line -----8<-----
public class KeyCollectionDecomposedTest extends AbstractKeyCollectionTestCases
{

    public KeyCollectionDecomposedTest() {
    }

    @Before
    public void setUp() {
        instance = new KeyCollectionDecomposed();
    }

//# BEGIN TODO: Test cases for auxiliary methods
    int[][] key1, key2; //two test keys
    int[] row1, row2; // two test rows

    /**
     * Calls CK(key1, key2) and checks result against expResult.
     *
     * @param msg message
     * @param expResult expected result
     */
    public void checkingKeyConvert(String msg, boolean expResult) {
        boolean result = ((KeyCollectionDecomposed)instance).CK(key1, key2);
        assertEquals(msg, expResult, result);
    }

    /**
     * Calls CR(row1, row2) and checks result against expResult.
     *
     * @param msg message
     * @param expResult expected result
     */
    public void checkingRowConvert(String msg, boolean expResult) {
        boolean result = ((KeyCollectionDecomposed)instance).CR(row1, row2);
        assertEquals(msg, expResult, result);
    }

    // Test methods
    @Test
    public void CK1()
    {
        key1 = new int[][] {
                new int[] {3,3},
                new int[] {6,2,9}
        };

        key2 = new int[][] {
                new int[] {3,5},   // convertable key
                new int[] {6,2,9}
        };

        checkingKeyConvert("Two convertable keys", true);

    }
    @Test
    public void CK2()
    {
        key1 = new int[][] {
                new int[] {4,3},
                new int[] {5,2,9}
        };

        key2 = new int[][] {
                new int[] {3,5}, // non convertable key
                new int[] {6,2,9}
        };

        checkingKeyConvert("Two non convertable keys", false);
    }
    @Test
    public void CR1()
    {
        row1 = new int[] {1, 2, 3};
        row2 = new int[] {1, 3, 5};   // convertable row

        checkingRowConvert("Two convertable rows", true);
    }
    @Test
    public void CR2()
    {
        row1 = new int[] {3, 3, 4};
        row2 = new int[] {1, 6, 7}; // non convertable row

        checkingRowConvert("Two non convertable rows", false);
    }
//# END TODO

}
