import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;

public class Minesweeper extends Application {
    private static final int GRID_SIZE = 10;
    private static final int NUM_MINES = 15;
    private Button[][] grid;
    private boolean[][] minesGrid;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        grid = new Button[GRID_SIZE][GRID_SIZE];
        minesGrid = new boolean[GRID_SIZE][GRID_SIZE];

        generateGrid(primaryStage);
        placeMines();

        Scene scene = new Scene(new GridPane(), 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Minesweeper");
        primaryStage.show();
    }

    private void generateGrid(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                Button button = new Button();
                button.setMinSize(40, 40);
                gridPane.add(button, j, i);
                grid[i][j] = button;

                int row = i;
                int col = j;
                button.setOnMouseClicked(e -> handleCellClick(row, col));
            }
        }

        ((GridPane) primaryStage.getScene().getRoot()).getChildren().add(gridPane);
    }

    private void placeMines() {
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < GRID_SIZE * GRID_SIZE; i++) {
            positions.add(i);
        }
        Collections.shuffle(positions);

        for (int i = 0; i < NUM_MINES; i++) {
            int pos = positions.get(i);
            int row = pos / GRID_SIZE;
            int col = pos % GRID_SIZE;
            minesGrid[row][col] = true;
        }
    }

    private void handleCellClick(int row, int col) {
        Button clickedButton = grid[row][col];
        if (minesGrid[row][col]) {
            showAlert("Game Over", "You clicked on a mine!");
            // Implement game over logic here
        } else {
            int adjacentMines = countAdjacentMines(row, col);
            if (adjacentMines == 0) {
                revealEmptyCells(row, col);
            } else {
                clickedButton.setText(String.valueOf(adjacentMines));
            }
        }
    }

    private void revealEmptyCells(int row, int col) {
        if (row >= 0 && row < GRID_SIZE && col >= 0 && col < GRID_SIZE && !minesGrid[row][col] && grid[row][col].getText().isEmpty()) {
            int adjacentMines = countAdjacentMines(row, col);
            if (adjacentMines == 0) {
                grid[row][col].setText("0"); // Indicates it's visited
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        revealEmptyCells(row + i, col + j);
                    }
                }
            } else {
                grid[row][col].setText(String.valueOf(adjacentMines));
            }
        }
    }

    private int countAdjacentMines(int row, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int r = row + i;
                int c = col + j;
                if (r >= 0 && r < GRID_SIZE && c >= 0 && c < GRID_SIZE && minesGrid[r][c]) {
                    count++;
                }
            }
        }
        return count;
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
