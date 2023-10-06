/**
 * This class contains a method to calculate the sum of integers between two given numbers.
 * The method takes two integer parameters and returns the sum of integers between them (inclusive).
 * The main method demonstrates the usage of the sum method with different input values.
 */

public class Methods {
  public static int sum(int a, int b) {
    int result=0;
    for (int i=a;i<=b;i++) {
      result+=i;
    }
    return result;
  }

  public static void main(String[] args){
    System.out.println(sum(1,10));
    System.out.println(sum(20,37));
    System.out.println(sum(35,49));
  }
}