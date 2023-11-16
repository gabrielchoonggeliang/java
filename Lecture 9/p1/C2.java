package p1;

public final class C2 {
  public static void main(String[] args) {
    C1 o = new C1();
    System.out.println(o.x);
    System.out.println(o.y);
    System.out.println(o.z);
    // System.out.println(o.u); this is not visible
    o.m();
  }
}