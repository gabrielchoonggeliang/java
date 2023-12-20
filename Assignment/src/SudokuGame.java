import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

public class SudokuGame extends Application {
    private int[][] puzzle = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
    };

    private TextField[][] tfCells = new TextField[9][9];

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                tfCells[row][col] = new TextField();
                tfCells[row][col].setPrefSize(50, 50);
                tfCells[row][col].setText(puzzle[row][col] == 0 ? "" : String.valueOf(puzzle[row][col]));
                tfCells[row][col].setStyle("-fx-font-size: 20;");
                grid.add(tfCells[row][col], col, row);
            }
        }

        Button solveButton = new Button("Solve");
        solveButton.setOnAction(e -> solveSudoku());

        Scene scene = new Scene(grid, 500, 500);
        grid.add(solveButton, 0, 9, 9, 1);

        primaryStage.setTitle("Sudoku Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void solveSudoku() {
        int[][] board = new int[9][9];

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                String value = tfCells[row][col].getText();
                board[row][col] = value.isEmpty() ? 0 : Integer.parseInt(value);
            }
        }

        if (solve(board)) {
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    tfCells[row][col].setText(String.valueOf(board[row][col]));
                }
            }
        } else {
            showAlert("Invalid Sudoku", "The given Sudoku puzzle is invalid.");
        }
    }

    private boolean solve(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;
                            if (solve(board)) {
                                return true;
                            }
                            board[row][col] = 0; // backtrack
                        }
                    }
                    return false; // no valid number found
                }
            }
        }
        return true; // all cells are filled
    }

    private boolean isValid(int[][] board, int row, int col, int num) {
        // Check if the number is not in the current row and column
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

        // Check if the number is not in the current 3x3 grid
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + startRow][j + startCol] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public GridPane root;

    public GridPane getRoot() {

        if (root == null) {
            start(new Stage());
            root = new GridPane();
        }
        
        return root;
    }

    public static void main(String[] args) {
        launch(args);
    }
}