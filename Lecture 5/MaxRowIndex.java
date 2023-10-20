public class MaxRowIndex {
  public static int findMaxSumRowIndex(int[][] array) {
    int index = 0;
    int max = 0;
    for (int i = 0; i < array.length; i++) {
      int total = 0;
      for (int j = 0; j < array[0].length; j ++) {
        total += array[i][j];
      }
      if (total > max) {
        max = total;
        index = i;
      }
    }

    return index;
  }
}
