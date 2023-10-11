import java.util.Scanner;

/**
 * A class that demonstrates the use of arrays in Java.
 */
public class TestingArray {
  
  /**
   * The main method that runs the program.
   * 
   * @param args The command-line arguments.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int[] arr = new int[5];
    System.out.print("Enter a number: ");
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scanner.nextInt();
    }
    scanner.close();
    System.out.print("User inputs: ");
    for (int num : arr) {
      System.out.print(num+" ");
    }
    int sum = 0;
    // for (int i = 0; i < arr.length; i++) {
    //   sum += arr[i];
    // }
    // System.out.println("\nSum of array: " + sum);
    sum = 0;
    for (int num : arr) {
      sum += num;
    }
    System.out.println("Sum of array: " + sum);
    
    // Find the smallest integer
    int smallest = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] < smallest) {
        smallest = arr[i];
      }
    }
    System.out.println("Smallest integer: " + smallest);
    
    // Find the largest integer
    int largest = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > largest) {
        largest = arr[i];
      }
    }
    System.out.println("Largest integer: " + largest);
  }
}