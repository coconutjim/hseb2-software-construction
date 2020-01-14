/**
 * Created with IntelliJ IDEA.
 * User: Lev
 * Date: 21.10.13
 * Time: 19:34
 * To change this template use File | Settings | File Templates.
 */
public class asd {

    public void main()
    {
        A a = new B();
        B b = (B)a;
        b.a();
    }
}

class A {
    void a(){}
}
class B extends A {
    void b() {}

}