package p2;
import p1.C1;

public class C4 extends C1{
  public static void main(String[] args) {
    C4 o = new C4();
    System.out.println(o.x);
    System.out.println(o.y);
    // System.out.println(o.z); cannot access
    // System.out.println(o.u); this is not visible
    o.m();
  }
}
