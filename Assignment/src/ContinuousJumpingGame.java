import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.Random;


public class ContinuousJumpingGame extends Application {
    private static final String[] BACKGROUND_IMAGES = {
        "file:./assets/jump_game.jpg",
        "file:./assets/jump_game2.jpg",
        "file:./assets/jump_game3.jpg"
    };

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int PLAYER_SIZE = 40;
    private static final int GROUND_HEIGHT = 20;
    private static final int JUMP_STRENGTH = 15;
    private static final int GRAVITY = 1;
    private static final int COIN_SIZE = 20;
    private static final int COINY = 100;
    private static final double COIN_SPEED = 2.0;
    private static final int MAX_LEVEL = 10;
    private Circle coin;


    private int score = 0;
    private int level = 1;
    private int FACTOR = 1;

    public Pane root;
    private Rectangle player;
    private double velocityY = 0;

    public Pane getRoot() {

        if (root == null) {
            start(new Stage());
            root = new Pane();
        }
        
        return root;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        
        primaryStage.setTitle("Continuous Jumping Game");
        root = new Pane();
        Scene scene = new Scene(root, WIDTH, HEIGHT);

        
        initPlayer();
        initGround();
        initCoin();
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
                updateLevel();
            }
        };
        gameLoop.start();
        
        
    }
    
    private void moveCoin() {

        // Move the coin towards the left
        coin.setCenterX(coin.getCenterX() - FACTOR * COIN_SPEED);
    
        // Reset coin's position when it goes off-screen
        if (coin.getCenterX() + COIN_SIZE < 0) {
            coin.setCenterX(WIDTH + COIN_SIZE);
        }
    }

    private void initCoin() {
        coin = new Circle(HEIGHT, COINY, COIN_SIZE);
        coin.setFill(Color.YELLOW);
        root.getChildren().add(coin);
    }
   
    private void initPlayer() {
        player = new Rectangle(50, HEIGHT - GROUND_HEIGHT - PLAYER_SIZE, PLAYER_SIZE, PLAYER_SIZE);
        player.setFill(Color.BLUE);
        root.getChildren().add(player);
    }

    private void initGround() {
        Rectangle ground = new Rectangle(0, HEIGHT - GROUND_HEIGHT, WIDTH, GROUND_HEIGHT);
        ground.setFill(Color.GREEN);
        root.getChildren().add(ground);
    }

    private void jump() {
        velocityY = -JUMP_STRENGTH;
    }

    private void update() {
        velocityY += GRAVITY;
        player.setY(player.getY() + velocityY);
    
        if (player.getY() >= HEIGHT - GROUND_HEIGHT - PLAYER_SIZE) {
            player.setY(HEIGHT - GROUND_HEIGHT - PLAYER_SIZE);
        }
    
        if (checkCollision(player, coin)) {
            // Perform actions upon collision
            Random random = new Random();

            coin.setVisible(false); // Hide the coin
            coin.setCenterX(HEIGHT); // Reset coin position off-screen
            coin.setCenterY(random.nextInt(0, (int) (HEIGHT - COIN_SIZE)));
            coin.setVisible(true);   
            score++; // Increment score
    
            // You can add other actions here, like incrementing score or resetting game state
            System.out.println("Collision detected!");
            updateScoreDisplay();
            updateLevelDisplay();
        }
    } 

    private Text scoreText; // Declare scoreText variable at the class level

    private void initScoreDisplay() {
        scoreText = new Text("Score: " + score); // Initialize scoreText variable
        scoreText.setFill(Color.BLACK);
        scoreText.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        scoreText.setLayoutX(20);
        scoreText.setLayoutY(40); // Adjust the position as needed
        root.getChildren().add(scoreText);
    }

    private void updateScoreDisplay() {
        scoreText.setText("Score: " + score);
    }    

    private Text levelText; // Declare scoreText variable at the class level

    private void initLevelDisplay() {
        levelText = new Text("Level: " + level); // Initialize scoreText variable
        levelText.setFill(Color.BLACK);
        levelText.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        levelText.setLayoutX(WIDTH - 120);
        levelText.setLayoutY(40); // Adjust the position as needed
        root.getChildren().add(levelText);
    
    }

    private void updateLevelDisplay() {
        levelText.setText("Level: " + level);
    }

    private void updateLevel() {
        if (score == 5) {
            level++;
            score = 0;
            increaseCoinSpeed();
        }
        if (level == MAX_LEVEL) {
            freezeAllMovement();
            updateScoreDisplay();
            updateLevelDisplay();
            displayVictory();
        }
    }

    private void increaseCoinSpeed() {
        FACTOR++;
    }

    private void displayVictory() {
        Text victoryText = new Text("You win!");
        victoryText.setFill(Color.BLACK);
        victoryText.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        victoryText.setLayoutX(WIDTH / 2 - 50);
        victoryText.setLayoutY(HEIGHT / 2);
        root.getChildren().add(victoryText);

    }

    private void freezeAllMovement() {
        velocityY = 0;
        FACTOR = 0;
        
    }

    private boolean checkCollision(Rectangle player, Circle coin) {
        return player.getBoundsInParent().intersects(coin.getBoundsInParent());
    }

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


    
}