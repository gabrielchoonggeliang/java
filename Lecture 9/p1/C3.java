package p1;

public class C3 extends C1 {
  public static void main(String[] args) {
    C3 o = new C3();
    System.out.println(o.x);
    System.out.println(o.y);
    System.out.println(o.z);
    // System.out.println(o.u); this is not visible
    o.m();
  }
}