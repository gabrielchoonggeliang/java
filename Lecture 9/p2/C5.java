package p2;
import p1.C1;

public class C5 {
  public static void main(String[] args) {
    C1 o = new C1();
    System.out.println(o.x);
    // System.out.println(o.y); this is not visible
    // System.out.println(o.z); this is not visible
    // System.out.println(o.u); this is not visible
    // o.m(); this is not visible
  }
}
