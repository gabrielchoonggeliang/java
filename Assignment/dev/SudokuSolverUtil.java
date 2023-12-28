public class SudokuSolverUtil {

    public static boolean isValidSudoku(int[][] board) {
        // Check rows
        for (int row = 0; row < 9; row++) {
            if (!isValidSet(board[row])) {
                return false;
            }
        }

        // Check columns
        for (int col = 0; col < 9; col++) {
            int[] column = new int[9];
            for (int row = 0; row < 9; row++) {
                column[row] = board[row][col];
            }
            if (!isValidSet(column)) {
                return false;
            }
        }

        // Check 3x3 subgrids
        for (int startRow = 0; startRow < 9; startRow += 3) {
            for (int startCol = 0; startCol < 9; startCol += 3) {
                int[] subgrid = new int[9];
                int index = 0;
                for (int row = startRow; row < startRow + 3; row++) {
                    for (int col = startCol; col < startCol + 3; col++) {
                        subgrid[index++] = board[row][col];
                    }
                }
                if (!isValidSet(subgrid)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isValidSet(int[] set) {
        boolean[] seen = new boolean[10]; // 0 to 9

        for (int num : set) {
            if (num != 0) {
                if (seen[num]) {
                    return false; // Duplicate number found
                }
                seen[num] = true;
            }
        }

        return true;
    }
}