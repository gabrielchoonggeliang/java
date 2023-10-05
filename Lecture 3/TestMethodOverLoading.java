/**
 * This class demonstrates method overloading in Java.
 */
class TestMethodOverLoading {
  
  /**
   * The main method of the class.
   * @param args The command line arguments passed to the program.
   */
  public static void main(String[] args) {
    System.out.println("The maximum of 3 and 4 is "+max(3,4));
    System.out.println("The maximum of 3.0 and 5.4 is "+max(3.0,5.4));
    System.out.println("The maximum of 3.0, 5.4 and 10.14 is "+max(3.0,5.4,10.14));
  }

  /**
   * Returns the maximum of two integers.
   * @param num1 The first integer.
   * @param num2 The second integer.
   * @return The maximum of the two integers.
   */
  public static int max(int num1, int num2) {
    if(num1>num2) return num1;
    else return num2;
  }

  /**
   * Returns the maximum of two doubles.
   * @param num1 The first double.
   * @param num2 The second double.
   * @return The maximum of the two doubles.
   */
  public static double max(double num1, double num2) {
    if(num1>num2) return num1;
    else return num2;
  }

  /**
   * Returns the maximum of three doubles.
   * @param num1 The first double.
   * @param num2 The second double.
   * @param num3 The third double.
   * @return The maximum of the three doubles.
   */
  public static double max(double num1, double num2, double num3) {
    return max(max(num1,num2),num3);
  }
}
