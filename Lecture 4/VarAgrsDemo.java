/**
 * The VarAgrsDemo class demonstrates the use of variable length argument list in Java.
 */
public class VarAgrsDemo {
  public static void main(String[] args) {
    printMax(34, 3, 3, 2, 56.5);
    printMax(new double[]{1, 2, 3});
  }

  /**
   * Finds and prints the maximum value from a variable length argument list of doubles.
   * If no argument is passed, prints "No argument passed".
   *
   * @param numbers a variable length argument list of doubles
   */
  public static void printMax(double ... numbers) {
    if (numbers.length == 0) {
      System.out.println("No argument passed");
      return;
    }

    double result = numbers[0];

    for (int i = 1; i < numbers.length; i++) {
      if (numbers[i] > result) {
        result = numbers[i];
      }
    }

    System.out.println("The max value is " + result);
  }
}
