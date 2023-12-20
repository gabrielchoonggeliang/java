import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Sudoku extends Application {
    private static final int SIZE = 9;
    private static final int EMPTY = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        int[][] sudokuGrid = generateSudoku();

        GridPane gridPane = new GridPane();
        int cellSize = 50;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                TextField textField = new TextField();
                int value = sudokuGrid[i][j];
                if (value != EMPTY) {
                    textField.setText(Integer.toString(value));
                    textField.setEditable(false);
                } else {
                    textField.setStyle("-fx-font-size: 2em; -fx-alignment: center;");

                    textField.setOnKeyTyped(e -> {
                        TextField source = (TextField) e.getSource();
                        String input = e.getCharacter();

                        if (input.matches("[1-9]")) {
                            source.setText(input);
                        } else {
                            e.consume();
                        }
                    });
                }

                textField.setMinSize(cellSize, cellSize);
                gridPane.add(textField, j, i);
            }
        }

        Scene scene = new Scene(gridPane, cellSize * SIZE, cellSize * SIZE);
        primaryStage.setTitle("Sudoku");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private int[][] generateSudoku() {
      int[][] grid = new int[SIZE][SIZE];
      if (fillSudoku(grid)) {
          return grid; // If the grid is successfully filled, return it
      } else {
          return new int[SIZE][SIZE]; // Return an empty grid if unable to fill
      }
  }
  
  private boolean fillSudoku(int[][] grid) {
      for (int row = 0; row < SIZE; row++) {
          for (int col = 0; col < SIZE; col++) {
              if (grid[row][col] == EMPTY) {
                  for (int num = 1; num <= SIZE; num++) {
                      if (isValid(grid, row, col, num)) {
                          grid[row][col] = num;
                          if (fillSudoku(grid)) {
                              return true; // Recursively fill the grid
                          }
                          grid[row][col] = EMPTY; // Backtrack if no valid solution
                      }
                  }
                  return false; // No valid number found for this cell
              }
          }
      }
      return true; // Grid filled successfully
  }
  
  private boolean isValid(int[][] grid, int row, int col, int num) {
      // Check if the number is already present in the row, column, or subgrid
      return !usedInRow(grid, row, num) &&
             !usedInColumn(grid, col, num) &&
             !usedInSubgrid(grid, row - row % 3, col - col % 3, num);
  }
  
  private boolean usedInRow(int[][] grid, int row, int num) {
      for (int col = 0; col < SIZE; col++) {
          if (grid[row][col] == num) {
              return true;
          }
      }
      return false;
  }
  
  private boolean usedInColumn(int[][] grid, int col, int num) {
      for (int row = 0; row < SIZE; row++) {
          if (grid[row][col] == num) {
              return true;
          }
      }
      return false;
  }
  
  private boolean usedInSubgrid(int[][] grid, int startRow, int startCol, int num) {
      for (int row = 0; row < 3; row++) {
          for (int col = 0; col < 3; col++) {
              if (grid[row + startRow][col + startCol] == num) {
                  return true;
              }
          }
      }
      return false;
  }
  
}
