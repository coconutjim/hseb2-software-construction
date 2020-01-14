import org.junit.Before;

/**
 * Test cases for functional decomposition in {@code KeyCollectionDecomposed}.
 * 
 * @author Tom Verhoeff (TU/e)
 */
public class KeyCollectionMonolithicTest extends AbstractKeyCollectionTestCases
{
    
    public KeyCollectionMonolithicTest() {
    }
    
    @Before
    public void setUp() {
        instance = new KeyCollectionMonolithic();
    }

}
