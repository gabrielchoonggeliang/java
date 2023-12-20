import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.image.Image;

public class GameInterface2 extends Application {

    private Stage primaryStage;
    private StackPane root;
    private static final int GRID_SIZE = 3;
    private Button[][] buttons;
    private int[][] board = new int[GRID_SIZE][GRID_SIZE];

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        initializePrimaryStage(); // Call this method to initialize the primaryStage
        init(); // Then call init() method
    }


    private void initializePrimaryStage() {
        primaryStage.setTitle("Puzzle game");
        setupInitialScreen();
        primaryStage.show();
        adjustMainMenuSize();
    }

    private void goToMainMenu() {
        setupMainMenu(); // Reconfigure the main menu UI components
    }
    
    private void setupMainMenu() {
        Text mainMenuLabel = createText("Main Menu", 24, Color.VIOLET, TextAlignment.CENTER);
        Button year1Button = createButton("Year 1", 24, 160, 20, 0, this::goToYear1);
        Button year2Button = createButton("Year 2", 24, 160, 20, 0, this::goToYear2);
        Button year3Button = createButton("Year 3", 24, 160, 20, 0, this::goToYear3);
        Button year4Button = createButton("Year 4", 24, 160, 20, 0, this::goToYear4);
        Button returnButton = createButton("Return", 24, 160, 20, 0, this::goToMainMenu);
        Button exitButton = createButton("Exit", 24, 160, 20, 0, Platform::exit);
    
        VBox menuLayout = new VBox(20);
        menuLayout.setAlignment(Pos.CENTER);
        menuLayout.getChildren().addAll(mainMenuLabel, year1Button, year2Button, year3Button, year4Button, returnButton, exitButton);

        root.getChildren().clear();
        root.getChildren().add(menuLayout);
    }

    private void setupInitialScreen() {
        final Text text = createText("Welcome to the puzzle game!", 40, Color.BLUE, TextAlignment.CENTER);
        Button playButton = createButton("Play", 25, 160, 80, 200, () -> simulateDelay(this::goToMainMenu));
        root = createRootPane(text, playButton, "file:../assets/sample.png" );
        Scene scene = createScene(root, primaryStage.getWidth(), primaryStage.getHeight());
        primaryStage.setScene(scene);
    }

    private void adjustMainMenuSize() {
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());
    }

    private Text createText(String content, double fontSize, Color color, TextAlignment alignment) {
        Text text = new Text(content);
        text.setStyle("-fx-font-size: " + fontSize + ";");
        text.setFill(color);
        text.setFont(new Font(40));
        text.setTextAlignment(alignment);
        return text;
    }

    private Button createButton(String text, int fontSize, int width, int height, int translateY, Runnable action) {
        Button button = new Button(text);
        button.setStyle("-fx-font-size: " + fontSize + ";");
        button.setPrefSize(width, height);
        button.setTranslateY(translateY);
        button.setOnAction(e -> {
            updateContent("Loading...");
            simulateDelay(action);
        });
        return button;
    }

    private StackPane createRootPane(Text text, Button button, String imagePath) {
        root = new StackPane();
        root.getChildren().addAll(text, button);
        root.setBackground(createBackground(imagePath));
        return root;
    }

    private Scene createScene(StackPane root, double width, double height) {
        return new Scene(root, width, height);
    }

    private void updateContent(String content) {
        root.getChildren().clear();
        Text text = new Text(content);
        text.setStyle("-fx-font-size: 24;");
        text.setFont(new Font(40));
        root.getChildren().add(text);
    }

    private void simulateDelay(Runnable action) {
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Platform.runLater(action);
        }).start();
    }

    private Background createBackground(String imagePath) {
        Image image = new Image(imagePath);

        BackgroundImage backgroundImage = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false)
        );

        return new Background(backgroundImage);
    }

    // New methods for navigating to year-specific scenes

    private void goToYear1() {
        BorderPane puzzleGame1 = new BorderPane();
        Scene puzzleGameScene1 = new Scene(puzzleGame1, primaryStage.getWidth(), primaryStage.getHeight());
        init();
        goToEndScreen();
        primaryStage.setScene(puzzleGameScene1);
       
    }

    private void goToYear2() {
        BorderPane puzzleGame2 = new BorderPane();
        Scene puzzleGameScene2 = new Scene(puzzleGame2, primaryStage.getWidth(), primaryStage.getHeight());
        primaryStage.setScene(puzzleGameScene2);
    }

    private void goToYear3() {
        BorderPane puzzleGame3 = new BorderPane();
        Scene puzzleGameScene3 = new Scene(puzzleGame3, primaryStage.getWidth(), primaryStage.getHeight());
        primaryStage.setScene(puzzleGameScene3);
    }

    private void goToYear4() {
        BorderPane puzzleGame4 = new BorderPane();
        Scene puzzleGameScene4 = new Scene(puzzleGame4, primaryStage.getWidth(), primaryStage.getHeight());
        primaryStage.setScene(puzzleGameScene4);
    }
    private void initializeBoard() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 0); // 0 represents the empty space
        Collections.shuffle(numbers);

        int index = 0;
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                board[i][j] = numbers.get(index++);
            }
        }
    }

    private void updateButton(int row, int col) {
        int value = board[row][col];
        buttons[row][col].setText(value == 0 ? "" : String.valueOf(value));
    }

    private void checkWin() {
        int count = 1;
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (board[i][j] != count % (GRID_SIZE * GRID_SIZE)) {
                    return;
                }
                count++;
            }
        }

        System.out.println("Congratulations! You won!");
    }

    private void handleButtonClick(int row, int col) {
        if (isValidMove(row, col)) {
            // Swap the empty space with the clicked button
            int temp = board[row][col];
            board[row][col] = board[emptyRow][emptyCol];
            board[emptyRow][emptyCol] = temp;

            // Update UI
            updateButton(row, col);
            updateButton(emptyRow, emptyCol);

            // Check for a win
            checkWin();
        }
    }

    private boolean isValidMove(int row, int col) {
        return (Math.abs(row - emptyRow) == 1 && col == emptyCol) ||
               (Math.abs(col - emptyCol) == 1 && row == emptyRow);
    }

    private int emptyRow, emptyCol;

    {
        outerLoop:
        for (emptyRow = 0; emptyRow < GRID_SIZE; emptyRow++) {
            for (emptyCol = 0; emptyCol < GRID_SIZE; emptyCol++) {
                if (board[emptyRow][emptyCol] == 0) {
                    break outerLoop;
                }
            }
        }
    }
    @Override
    public void init(){
        //initialize the board
        board = new int[GRID_SIZE][GRID_SIZE];
        //initialize the buttons
        buttons = new Button[GRID_SIZE][GRID_SIZE];
        //initialize the board
        initializeBoard();
        //initialize the gridpane
        GridPane gridPane = new GridPane();
        //initialize the buttons
        for(int i = 0; i < GRID_SIZE; i++){
            for(int j = 0; j < GRID_SIZE; j++){
                buttons[i][j] = new Button();
                buttons[i][j].setMinSize(100, 100);
                buttons[i][j].setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                gridPane.add(buttons[i][j], j, i);
                updateButton(i, j);
            }
        }
        //initialize the scene
        Scene scene = new Scene(gridPane, 300, 300);
        //set the scene
        primaryStage.setScene(scene);
        //show the stage
        primaryStage.show();
    }
    // method to go to the end screen
    private void goToEndScreen() {
        // Create the end screen scene
        StackPane endRoot = new StackPane();
        Scene endScene = new Scene(endRoot, primaryStage.getWidth(), primaryStage.getHeight());
        final String imagepath="file:C:\\Users\\60174\\Downloads\\orange.jpg";
        endRoot.setBackground(createBackground(imagepath));
        // Add end screen components
        //VBox endLayout = new VBox(20); // Vertical spacing of 20 between components
        //endLayout.setAlignment(Pos.CENTER);
        // text for end screen
        final Text endLabel = new Text("Congratulations! You have completed the game!");
        endLabel.setStyle("-fx-font-size: 24;"); // Set font size
        endLabel.setFont(new Font(60));
        endLabel.setTextAlignment(TextAlignment.CENTER); 
        endLabel.setFill(Color.BLUE);
        endRoot.getChildren().add(endLabel);

        // button to return to main menu
        final Button returnButton = new Button("Return to main menu");
        returnButton.setStyle("-fx-font-size: 24;"); // Set font size
        returnButton.setPrefSize(320,20); // Set button size
        //returnButton.setAlignment(Pos.BOTTOM_LEFT);
        returnButton.setTranslateY(100);
        endRoot.getChildren().add(returnButton);
        returnButton.setOnAction(e -> goToMainMenu()); // Set the action for the return button
        
        // method to exit the game
        final Button exitButton = new Button("Exit");
        exitButton.setStyle("-fx-font-size: 24;"); // Set font size
        exitButton.setPrefSize(320,20); // Set button size
        //exitButton.setAlignment(Pos.BOTTOM_RIGHT);
        exitButton.setTranslateY(200);
        endRoot.getChildren().add(exitButton);
        exitButton.setOnAction(e -> Platform.exit()); // Set the action for the exit button

        primaryStage.setScene(endScene);

    }

}
