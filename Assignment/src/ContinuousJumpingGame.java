import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.util.Random;

/**
 * The ContinuousJumpingGame class represents a JavaFX application for a continuous jumping game.
 * It allows the player to control a character and jump over obstacles to score points and progress through levels.
 */
public class ContinuousJumpingGame extends Application {

    /**
     * The array of background image file paths.
     */
    private static final String[] BACKGROUND_IMAGES = {
        "file:./assets/jump_game.jpg",
        "file:./assets/jump_game2.jpg",
        "file:./assets/jump_game5.jpg"
    };

    /**
     * The width of the game window.
     */
    private static final int WIDTH = 795;

    /**
     * The height of the game window.
     */
    private static final int HEIGHT = 400;

    /**
     * The size of the player character.
     */
    private static final int PLAYER_SIZE = 70;

    /**
     * The height of the ground.
     */
    private static final int GROUND_HEIGHT = 20;

    /**
     * The strength of the player's jump.
     */
    private static int JUMP_STRENGTH = 15;

    /**
     * The gravity applied to the player character.
     */
    private static final int GRAVITY = 1;

    /**
     * The size of the coin.
     */
    private static final int COIN_SIZE = 20;

    /**
     * The y-coordinate of the coin.
     */
    private static final int COINY = 100;

    /**
     * The speed of movement in the game.
     */
    private static double SPEED = 2.0;

    /**
     * The maximum level of the game.
     */
    private static final int MAX_LEVEL = 10;

    /**
     * The coin object in the game.
     */
    private Circle coin;

    /**
     * The current score of the player.
     */
    private int score = 0;

    /**
     * The current level of the game.
     */
    private int level = 1;

    /**
     * The factor used to increase the speed of the missiles.
     */
    private int FACTOR = 1;

    private boolean MUSIC = true;

    /**
     * The image of the missile.
     */
    private Image image = new Image("file:./assets/missile.jpeg", 400, 100, true, true);

    /**
     * The image view of the missile.
     */
    private ImageView missile = new ImageView(image);

    /**
     * The image of the player character.
     */
    private Image image2 = new Image("file:./assets/cow.jpg", PLAYER_SIZE, PLAYER_SIZE, true, true);

    /**
     * The image view of the player character.
     */
    private ImageView player = new ImageView(image2);

    /**
     * The root pane of the game.
     */
    public Pane root;

    /**
     * The vertical velocity of the player character.
     */
    private double velocityY = 0;

    /**
     * The text displaying the current score.
     */
    private Text scoreText;

    /**
     * The text displaying the current level.
     */
    private Text levelText;

    /**
     * Returns the root pane of the game.
     *
     * @return The root pane of the game.
     */
    public Pane getRoot() {
        if (root == null) {
            start(new Stage());
            root = new Pane();
        }
        return root;
    }

    /**
     * The main method that launches the JavaFX application.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Initializes the game window and sets up the game elements.
     *
     * @param primaryStage The primary stage of the JavaFX application.
     */
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Continuous Jumping Game");
        root = new Pane();

        final String musicFile = "assets/soundtrack1.mp3";
        Scene scene = new Scene(root, WIDTH, HEIGHT);

        Media media = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        
        initPlayer();
        initGround();
        initCoin();
        initMissile();
        
        initScoreDisplay();
        initLevelDisplay();
        
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.SPACE) {
                jump();
            }
        });
        
        root.setBackground(setBackground(BACKGROUND_IMAGES[0]));
        
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
        AnimationTimer gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
                moveCoin();
                moveMissile();
                updateLevel();

                if (MUSIC) {
                    mediaPlayer.play();
                }
            }
        };
        gameLoop.start();
    }
    
    // Player methods
    
    /**
     * Initializes the player character.
     */
    private void initPlayer() {
        player.setX(50);
        player.setY(HEIGHT - GROUND_HEIGHT - PLAYER_SIZE);
        player.setPreserveRatio(true);
        Group rootGroup = new Group(player);
        root.getChildren().add(rootGroup);
    }

    /**
     * Makes the player character jump.
     */
    private void jump() {
        velocityY = -JUMP_STRENGTH;
    }

    // Ground methods

    /**
     * Initializes the ground.
     */
    private void initGround() {
        Rectangle ground = new Rectangle(0, HEIGHT - GROUND_HEIGHT, WIDTH, GROUND_HEIGHT);
        ground.setFill(Color.GREEN);
        root.getChildren().add(ground);
    }

    // Coin methods

    /**
     * Initializes the coin.
     */
    private void initCoin() {
        coin = new Circle(HEIGHT, COINY, COIN_SIZE);
        coin.setFill(Color.YELLOW);
        root.getChildren().add(coin);
    }

    /**
     * Moves the coin horizontally.
     */
    private void moveCoin() {
        coin.setCenterX(coin.getCenterX() - FACTOR * SPEED);
        if (coin.getCenterX() + COIN_SIZE < 0) {
            coin.setCenterX(WIDTH + COIN_SIZE);
        }
    }

    // Missile methods

    /**
     * Initializes the missile.
     */
    private void initMissile() {
        missile.setX(100);
        missile.setY(100);
        missile.setPreserveRatio(true);
        Group rootGroup = new Group(missile);
        root.getChildren().add(rootGroup);
    }

    /**
     * Moves the missile horizontally.
     */
    private void moveMissile() {
        missile.setX(missile.getX() - FACTOR * SPEED);
        if (missile.getX() + COIN_SIZE < 0) {
            missile.setX(WIDTH + COIN_SIZE);
        }
    }

    // Score display methods

    /**
     * Initializes the score display.
     */
    private void initScoreDisplay() {
        scoreText = new Text("Score: " + score);
        scoreText.setFill(Color.BLACK);
        scoreText.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        scoreText.setLayoutX(20);
        scoreText.setLayoutY(40);
        root.getChildren().add(scoreText);
    }

    /**
     * Updates the score display.
     */
    private void updateScoreDisplay() {
        scoreText.setText("Score: " + score);
    }

    // Level display methods

    /**
     * Initializes the level display.
     */
    private void initLevelDisplay() {
        levelText = new Text("Level: " + level);
        levelText.setFill(Color.BLACK);
        levelText.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        levelText.setLayoutX(WIDTH - 120);
        levelText.setLayoutY(40);
        root.getChildren().add(levelText);
    }

    /**
     * Updates the level display.
     */
    private void updateLevelDisplay() {
        levelText.setText("Level: " + level);
    }

    // Game logic methods

    /**
     * Updates the game logic.
     */
    private void update() {
        velocityY += GRAVITY;
        player.setY(player.getY() + velocityY);

        if (player.getY() >= HEIGHT - GROUND_HEIGHT - PLAYER_SIZE) {
            player.setY(HEIGHT - GROUND_HEIGHT - PLAYER_SIZE);
        }

        if (checkCollision(player, missile)) {
            Random random = new Random();

            missile.setVisible(false);
            missile.setX(HEIGHT);
            missile.setY(random.nextInt(0, (int) (HEIGHT - COIN_SIZE)));
            missile.setVisible(true);
            score++;
            updateScoreDisplay();
            updateLevelDisplay();
        }

        if (checkCollision(player, coin)) {
            Random random = new Random();
            coin.setVisible(false);
            coin.setCenterX(WIDTH + COIN_SIZE);
            coin.setCenterY(random.nextInt(0, (int) (HEIGHT - COIN_SIZE)));
            coin.setVisible(true);
            score--;
            updateScoreDisplay();
            updateLevelDisplay();
        }
    }

    /**
     * Updates the level of the game.
     */
    private void updateLevel() {
        if (score == 5) {
            level++;
            score = 0;
            increaseMissileSpeed();
        }
        if (level == MAX_LEVEL) {
            freezeAllMovement();
            updateScoreDisplay();
            updateLevelDisplay();
            displayVictory();
        }

        if (level == 4) {
            root.setBackground(updateBackground(BACKGROUND_IMAGES[1]));
        }

        if (level == 7) {
            root.setBackground(updateBackground(BACKGROUND_IMAGES[2]));
        }
    }

    /**
     * Increases the speed of the missiles.
     */
    private void increaseMissileSpeed() {
        FACTOR++;
    }

    /**
     * Displays the victory message.
     */
    private void displayVictory() {
        Text victoryText = new Text("You win!");
        victoryText.setFill(Color.BLACK);
        victoryText.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        victoryText.setLayoutX(WIDTH / 2 - 50);
        victoryText.setLayoutY(HEIGHT / 2);
        root.getChildren().add(victoryText);
    }

    /**
     * Freezes all movement in the game.
     */
    private void freezeAllMovement() {
        MUSIC = false; 
        velocityY = 0;
        SPEED = 0;
        JUMP_STRENGTH = 0; 
        FACTOR = 0;
    }

    /**
     * Checks for collision between the player and the missile.
     *
     * @param player The image view of the player.
     * @param missile The image view of the missile.
     * @return true if there is a collision, false otherwise.
     */
    private boolean checkCollision(ImageView player, ImageView missile) {
        return player.getBoundsInParent().intersects(missile.getBoundsInParent());
    }

    /**
     * Checks for collision between the player and the coin.
     *
     * @param player The image view of the player.
     * @param coin The circle representing the coin.
     * @return true if there is a collision, false otherwise.
     */
    private boolean checkCollision(ImageView player, Circle coin) {
        return player.getBoundsInParent().intersects(coin.getBoundsInParent());
    }

    // Background methods

    /**
     * Sets the background of the game.
     *
     * @param imageUrl The file path of the background image.
     * @return The background with the specified image.
     */
    private Background setBackground(String imageUrl) {
        Image image = new Image(imageUrl);

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
     * Updates the background of the game.
     *
     * @param imageUrl The file path of the updated background image.
     * @return The updated background with the specified image.
     */
    private Background updateBackground(String imageUrl) {
        Image image = new Image(imageUrl);

        BackgroundImage backgroundImage = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false)
        );

        return new Background(backgroundImage);
    }
}