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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.image.Image;

public class GameInterface extends Application {

    private Stage primaryStage;
    private StackPane root;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        initializePrimaryStage();
    }

    private void initializePrimaryStage() {
        primaryStage.setTitle("Puzzle game");
        setupInitialScreen();
        primaryStage.show();
        adjustMainMenuSize();
        centerStage(primaryStage); // Center the stage on the screen
    }
    
    private void centerStage(Stage stage) {
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        double centerX = bounds.getMinX() + (bounds.getWidth() - stage.getWidth()) / 2;
        double centerY = bounds.getMinY() + (bounds.getHeight() - stage.getHeight()) / 2;
        stage.setX(centerX);
        stage.setY(centerY);
    }

    private void goToMainMenu() {
        setupMainMenu(); // Reconfigure the main menu UI components
    }
    
    private void setupMainMenu() {
        Text mainMenuLabel = createText("Main Menu", 24, Color.VIOLET, TextAlignment.CENTER);
        Button game1Button = createButton("Game 1", 24, 160, 20, 0, this::goToGame1);
        Button game2Button = createButton("Game 2", 24, 160, 20, 0, this::goToGame2);
        Button returnButton = createButton("Return", 24, 160, 20, 0, this::initializePrimaryStage);
        Button exitButton = createButton("Exit", 24, 160, 20, 0, Platform::exit);
    
        VBox menuLayout = new VBox(20);
        menuLayout.setAlignment(Pos.CENTER);
        menuLayout.getChildren().addAll(mainMenuLabel, game1Button, game2Button, returnButton, exitButton);

        root.getChildren().clear();
        root.getChildren().add(menuLayout);
    }

    private void setupInitialScreen() {
        Text text = createText("Welcome to the puzzle game!", 40, Color.BLUE, TextAlignment.CENTER);
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

    private void goToGame1() {
        ContinuousJumpingGame game1 = new ContinuousJumpingGame();
        Scene game1Scene = new Scene(game1.getRoot(), primaryStage.getWidth(), primaryStage.getHeight());
        primaryStage.setScene(game1Scene);

        game1Scene.getWindow().setOnCloseRequest(event -> {
            // Check if the window was closed by the user
            if (event.getEventType() == WindowEvent.WINDOW_CLOSE_REQUEST) {
                goToMainMenu(); // Return to the main menu
            }
        });
    }
    
    private void goToGame2() {
        SudokuGame game2 = new SudokuGame();
        Scene game2Scene = new Scene(game2.getRoot(), primaryStage.getWidth(), primaryStage.getHeight());
        primaryStage.setScene(game2Scene);

        game2Scene.getWindow().setOnCloseRequest(event -> {
            // Check if the window was closed by the user
            if (event.getEventType() == WindowEvent.WINDOW_CLOSE_REQUEST) {
                goToMainMenu(); // Return to the main menu
            }
        });
    }
    

}
