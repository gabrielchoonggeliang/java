import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TicTacToeFX extends Application {

    private char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    private char currentPlayer = 'X';

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button button = createButton(i, j);
                gridPane.add(button, j, i);
            }
        }

        Scene scene = new Scene(gridPane, 300, 300);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Button createButton(int row, int col) {
        Button button = new Button();
        button.setMinSize(100, 100);
        button.setOnAction(e -> handleButtonClick(button, row, col));
        return button;
    }

    private void handleButtonClick(Button button, int row, int col) {
        // ... (existing code)
    
        if (isValidMove(row, col)) {
            makeMove(row, col);
            button.setText(Character.toString(currentPlayer));
            if (checkWin()) {
                showResult(currentPlayer + " won! The game will be reset.");
                resetGame((GridPane) button.getParent());
            } else if (isBoardFull()) {
                showResult("Draw! The game will be reset.");
                resetGame((GridPane) button.getParent());
            } else {
                switchPlayer();
            }
        } else {
            showAlert("Invalid move! Please try again.");
        }
    }
    private boolean isValidMove(int row, int col) {
        return board[row][col] == ' ';
    }

    private void makeMove(int row, int col) {
        board[row][col] = currentPlayer;
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private boolean checkWin() {
        return (checkRows() || checkColumns() || checkDiagonals());
    }

    private boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals() {
        return (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
               (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    private void showResult(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Invalid Move");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void resetGame(GridPane gridPane) {
        board = new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        currentPlayer = 'X';
    
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button button = (Button) gridPane.getChildren().get(i * 3 + j);
                button.setText("");
            }
        }
    }
}
