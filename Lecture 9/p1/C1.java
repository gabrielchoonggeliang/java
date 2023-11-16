package p1;

public class C1 {
  public int x;
  protected int y;
  int z;
  private int u;

  protected void m() {
    System.out.println("S");
  }

  public static void main(String[] args) {
    C1 o = new C1();
    System.out.println(o.x);
    System.out.println(o.y);
    System.out.println(o.z);
    System.out.println(o.u);
    o.m();
  }
}