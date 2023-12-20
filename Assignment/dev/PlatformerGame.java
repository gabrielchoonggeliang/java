import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PlatformerGame extends Application {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int PLAYER_SIZE = 40;
    private static final int GROUND_HEIGHT = 20;
    private static final int JUMP_STRENGTH = 15;
    private static final double PLAYER_SPEED = 5;

    private Pane root;
    private Rectangle player;
    private double velocityY = 0;
    private boolean isJumping = false;

    private Arc money;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Platformer Game");
        root = new Pane();
        Scene scene = new Scene(root, WIDTH, HEIGHT);

        initPlayer();
        initGround();
        initMoney();

        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.SPACE && !isJumping) {
                jump();
            } else if (event.getCode() == KeyCode.LEFT) {
                moveLeft();
            } else if (event.getCode() == KeyCode.RIGHT) {
                moveRight();
            }
        });

        scene.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.LEFT || event.getCode() == KeyCode.RIGHT) {
                stopMoving();
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();

        AnimationTimer gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        };
        gameLoop.start();
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

    private void initMoney() {
        money = new Arc(200, 100, 20, 20, 0, 360);
        money.setFill(Color.YELLOW);
        root.getChildren().add(money);
    }

    private void jump() {
        isJumping = true;
        velocityY = -JUMP_STRENGTH;
    }

    private void moveLeft() {
        player.setX(player.getX() - PLAYER_SPEED);
    }

    private void moveRight() {
        player.setX(player.getX() + PLAYER_SPEED);
    }

    private void stopMoving() {
        // Add any additional logic if needed when stopping horizontal movement
    }

    private void update() {
        if (isJumping) {
            velocityY += 1; // Gravity
            player.setY(player.getY() + velocityY);

            if (player.getY() >= HEIGHT - GROUND_HEIGHT - PLAYER_SIZE) {
                player.setY(HEIGHT - GROUND_HEIGHT - PLAYER_SIZE);
                isJumping = false;
            }
        }

        // Check for player and money collision
        if (player.getBoundsInParent().intersects(money.getBoundsInParent())) {
            // Add logic for collecting money (e.g., increase score)
            System.out.println("Money collected!");
        }
    }
}