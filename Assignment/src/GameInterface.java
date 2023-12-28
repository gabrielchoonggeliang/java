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

/**
 * The GameInterface class represents the main user interface for the puzzle game.
 * It extends the Application class from JavaFX and provides methods for initializing
 * the primary stage, setting up the main menu, handling navigation between screens,
 * and creating UI components.
 */
public class GameInterface extends Application {

    /**
     * The primary stage of the application.
     */
    private Stage primaryStage;

    /**
     * The root pane of the user interface.
     */
    private StackPane root;

    /**
     * The main entry point for the application.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Initializes the primary stage of the application.
     *
     * @param primaryStage the primary stage
     */
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        initializePrimaryStage();
    }

    /**
     * Initializes the primary stage with the title and initial screen.
     */
    private void initializePrimaryStage() {
        primaryStage.setTitle("Puzzle game");
        setupInitialScreen();
        primaryStage.show();
        adjustMainMenuSize();
        centerStage(primaryStage);
    }

    /**
     * Centers the given stage on the screen.
     *
     * @param stage the stage to center
     */
    private void centerStage(Stage stage) {
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        double centerX = bounds.getMinX() + (bounds.getWidth() - stage.getWidth()) / 2;
        double centerY = bounds.getMinY() + (bounds.getHeight() - stage.getHeight()) / 2;
        stage.setX(centerX);
        stage.setY(centerY);
    }

    /**
     * Navigates to the main menu screen.
     */
    private void goToMainMenu() {
        setupMainMenu();
    }

    /**
     * Sets up the main menu UI components.
     */
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

    /**
     * Sets up the initial screen with a welcome message and play button.
     */
    private void setupInitialScreen() {
        Text text = createText("Welcome to the puzzle game!", 40, Color.BLUE, TextAlignment.CENTER);
        Button playButton = createButton("Play", 25, 160, 80, 200, this::goToMainMenu);

        root = createRootPane(text, playButton, "file:./assets/Background1.jpg");

        Scene scene = createScene(root, primaryStage.getWidth(), primaryStage.getHeight());
        primaryStage.setScene(scene);
    }

    /**
     * Adjusts the size of the main menu to fit the screen.
     */
    private void adjustMainMenuSize() {
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight() - 27);
    }

    /**
     * Creates a Text component with the specified content, font size, color, and alignment.
     *
     * @param content   the text content
     * @param fontSize  the font size
     * @param color     the text color
     * @param alignment the text alignment
     * @return the created Text component
     */
    private Text createText(String content, double fontSize, Color color, TextAlignment alignment) {
        Text text = new Text(content);
        text.setStyle("-fx-font-size: " + fontSize + ";");
        text.setFill(color);
        text.setFont(new Font(40));
        text.setTextAlignment(alignment);
        return text;
    }

    /**
     * Creates a Button component with the specified text, font size, width, height, translateY, and action.
     *
     * @param text       the button text
     * @param fontSize   the font size
     * @param width      the button width
     * @param height     the button height
     * @param translateY the translation on the y-axis
     * @param action     the action to be performed when the button is clicked
     * @return the created Button component
     */
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

    /**
     * Creates a StackPane as the root pane with the specified Text, Button, and image path.
     *
     * @param text      the Text component
     * @param button    the Button component
     * @param imagePath the path to the background image
     * @return the created StackPane
     */
    private StackPane createRootPane(Text text, Button button, String imagePath) {
        root = new StackPane();
        root.getChildren().addAll(text, button);
        root.setBackground(createBackground(imagePath));
        return root;
    }

    /**
     * Creates a Scene with the specified root pane, width, and height.
     *
     * @param root   the root pane
     * @param width  the scene width
     * @param height the scene height
     * @return the created Scene
     */
    private Scene createScene(StackPane root, double width, double height) {
        return new Scene(root, width, height);
    }

    /**
     * Updates the content of the root pane with the specified text.
     *
     * @param content the new content
     */
    private void updateContent(String content) {
        root.getChildren().clear();
        Text text = new Text(content);
        text.setStyle("-fx-font-size: 24;");
        text.setFont(new Font(40));
        root.getChildren().add(text);
    }

    /**
     * Simulates a delay of 1 second and then runs the specified action on the JavaFX application thread.
     *
     * @param action the action to be performed after the delay
     */
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

    /**
     * Creates a Background with the specified image path.
     *
     * @param imagePath the path to the background image
     * @return the created Background
     */
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

    /**
     * Navigates to the Game 1 screen.
     */
    private void goToGame1() {
        ContinuousJumpingGame game1 = new ContinuousJumpingGame();
        Scene game1Scene = new Scene(game1.getRoot(), primaryStage.getWidth(), primaryStage.getHeight());
        primaryStage.setScene(game1Scene);

        game1Scene.getWindow().setOnCloseRequest(event -> {
            if (event.getEventType() == WindowEvent.WINDOW_CLOSE_REQUEST) {
                goToMainMenu();
            }
        });
    }

    /**
     * Navigates to the Game 2 screen.
     */
    private void goToGame2() {
        SudokuGame game2 = new SudokuGame();
        Scene game2Scene = new Scene(game2.getRoot(), primaryStage.getWidth(), primaryStage.getHeight());
        primaryStage.setScene(game2Scene);

        game2Scene.getWindow().setOnCloseRequest(event -> {
            if (event.getEventType() == WindowEvent.WINDOW_CLOSE_REQUEST) {
                goToMainMenu();
            }
        });
    }
}
