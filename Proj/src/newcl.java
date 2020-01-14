/**
 * Created with IntelliJ IDEA.
 * User: Lev
 * Date: 10.09.13
 * Time: 12:58
 * To change this template use File | Settings | File Templates.
 */
public class newcl {
    public  static  void  main(String[] p)
    {

    }
    /** Index for frequency of rounds without winner */
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
    boolean CR(int[] row1, int[] row2)
    {
        if (row1.length != row2.length) {
            return true;
        }
        boolean flag = false;
        for (int i = 0; i < row1.length; i ++) {
            if (row1[i] > row2[i]) {
                flag = true;
                break;
            }
        }
        return flag;
    }
    boolean CK(int[][] key1, int[][] key2)
    {
        boolean flag = false;
        for (int i = 0; i < key1.length; i ++) {
            flag = CR(key1[i], key1[i]);
            if (!flag) {
                break;
            }
        }
        return flag;
    }
}
