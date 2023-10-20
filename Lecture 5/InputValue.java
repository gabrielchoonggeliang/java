import java.util.Scanner;

public class InputValue {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int[][] matrix = new int[3][3];
    System.out.println("Enter " + matrix.length + " rows and " + matrix[0].length + " columns: ");

    for (int row = 0; row < matrix.length; row++) {
      for (int column = 0; column < matrix[row].length; column++) {
        matrix[row][column] = input.nextInt();
      }
    }

    for (int row = 0; row < matrix.length; row++) {
      for (int column = 0; column < matrix[row].length; column++) {
        System.out.print(matrix[row][column] + " ");
      }
      System.out.println();
    }

    int total = 0;
    int largestRowSum = 0;
    int[] columnSums = new int[matrix[0].length];
    // Sum the values of each row and column and output the result
    for (int row = 0; row < matrix.length; row++) {
      int rowSum = 0;
      for (int column = 0; column < matrix[row].length; column++) {
        rowSum += matrix[row][column];
        columnSums[column] += matrix[row][column];
      }
      total += rowSum;
      System.out.println("Sum of row " + (row + 1) + ": " + rowSum);
      if (rowSum > largestRowSum) {
        largestRowSum = rowSum;
      }
    }
    System.out.println("Total: " + total);
    System.out.println("Largest row sum: " + largestRowSum);
    for (int column = 0; column < columnSums.length; column++) {
      System.out.println("Sum of column " + (column + 1) + ": " + columnSums[column]);
    }
    input.close();
  }
}