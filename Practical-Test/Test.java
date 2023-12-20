/**
 * Write a Java method that efficiently finds the second 
 * smallest element in the array without sorting the array.
 */

public class Test {
  public static void main(String[] args) {

    // avoid array not initialised error
    int[] randomArray = new int[20];

    // value mapping
    for (int i = 0; i < 20; i++) {
      randomArray[i] = (int) (Math.random() * 10) + (int) (Math.random());
    }

    System.out.println("Array: " + java.util.Arrays.toString(randomArray));
    System.out.println(SecondSmallestElement(randomArray));
  }

  static int SecondSmallestElement (int[] Array) {

    // implementation => Sequential Search
    int smallest = Array[0];
    int index = 0;

    for (int i = 1; i < Array.length-1; i++) {
     if (Array[i] < smallest) {
      smallest = Array[i];
      index = i;
     }
    }

    smallest = Array[0];
    for (int i = 1; i < Array.length-1; i++) {
      if (i == index) {
        continue;
      }
      if (Array[i] < smallest) {
        smallest = Array[i];
      }
    }

    return smallest;
  }
}
