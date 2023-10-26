public class WrongCode {
  int i = 5;
  static int k = 2;

  public static void main(String[] args) {
    // int j = i; <-- This is wrong because i is not static
    // m1(); <--- This is wrong because m1 is not static
    WrongCode c = new WrongCode();
    c.m1();
    
  }

  public void m1() {
    // int j = i; // <-- This is fine because i is not static
    i = i + k + m2(i, k);
  }

  public static int m2(int i, int j) {
    return (int)(Math.pow(i, j));
  }
}
