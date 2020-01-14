/**
 * Test cases for class IntRelationArraysIterable.
 *
 * <!--//# BEGIN TODO Name, group id, and date-->
 * <p><font color="red"><b>Lev Osipov, 271(1), 30.10.2013</b></font></p>
 * <!--//# END TODO-->
 *
 */
// -----8<----- cut line -----8<-----
public class IntRelationArraysIterableTest
        extends IntRelationIterableTestCases {

    @Override
    protected void setInstance(final int n) {
        instance = new IntRelationArraysIterable(n);
    }

}