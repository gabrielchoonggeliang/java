/**
 * This class checks if a given square matrix is symmetric or not.
 */
public class CheckArraySymmetry {

  // The matrix to be checked for symmetry
  final int[][] matrix = {
    {1, 2, 3},
    {2, 4, 5},
    {3, 5, 8},
  };

  public static void main(String args[]) {
    
    CheckArraySymmetry checkArraySymmetry = new CheckArraySymmetry();
    Boolean symmetric = checkArraySymmetry.isSymmetric(checkArraySymmetry.matrix);
    if (symmetric) {
      System.out.println("The matrix is symmetric");
    } else {
      System.out.println("The matrix is not symmetric");
    }
  }

  /**
   * This method checks if a given square matrix is symmetric or not.
   * @param matrix The matrix to be checked for symmetry
   * @return true if the matrix is symmetric, false otherwise
   */
  public boolean isSymmetric(int[][] matrix) {

    // assume square matrix
    for (int row = 0; row < matrix.length; row++) {
      for (int column = 0; column < matrix[row].length; column++) {

        // checks if a[i][j] != a[j][i], then the matrix is not symmetric
        // if a[i][j] == a[j][i], then a = a^T and the matrix is symmetric
        if (matrix[row][column] != matrix[column][row]) {
          return false;
        }
      }
    }
    return true;
  }
}