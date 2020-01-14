/**
 * Created with IntelliJ IDEA.
 * User: Lev
 * Date: 22.10.13
 * Time: 10:15
 * To change this template use File | Settings | File Templates.
 */
class qwe {
    public static void main(String[] args) {
        System.out.print(new Object().getClass().getSuperclass().getName());
    }

}
class A {
    public void a(){System.out.print("1");}
}
class B extends A{
    public void a(){System.out.print("2");}
}
class C extends B{
    public void a(){System.out.print("3");}
}