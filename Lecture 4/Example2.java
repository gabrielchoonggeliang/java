public class Example2 {
  /**
   * This program demonstrates the use of Java statements to declare and manipulate arrays.
   */
  public static void main(String[] args) {
    // declare numArray of 15 elements
    int[] numArray = new int[15];
    numArray[0] = 1;

    int[] alpha = new int[12];
    // output value of tenth element of the array alpha
    System.out.println("The tenth element of the array is " + alpha[9]);

    // set the value of the fifth element of the array alpha to 35
    alpha[4] = 35;

    // set the value of the ninth element of the array alpha to the sum of the sixth and thirteenth elements of the array alpha
    alpha[8] = alpha[5] + alpha[12];
  }  
}
