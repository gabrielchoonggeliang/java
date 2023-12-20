public class Practice {
  public static void main(String[] args) {
    // Different array initialisations
    int[] integerArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int[] unspecifiedIntegerArray = new int[10];

    String[] stringArray = {"Hello", "World"};
    String[] unspecifiedStringArray = new String[2];

    // Array manipulation
    for ( int integers : integerArray ) {
      System.out.print(integers + " ");
    }

    System.out.println();

    for ( int i = 0; i < integerArray.length - 1; i++) {
      unspecifiedIntegerArray[i] = integerArray[i - integerArray.length + 1];
      System.out.print(unspecifiedIntegerArray[i] + " ");
    }

    // Multidimensional array -> the operations on multidimensional arrays are literally the same
    // the only difference being having to loop twice for full access i.e. O n squared
    int[][] multidIntegerArray = {
      {1, 2, 3},
      {3, 4, 5}
    };
  }
}