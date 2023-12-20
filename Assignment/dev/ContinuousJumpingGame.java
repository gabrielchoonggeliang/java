import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ContinuousJumpingGame extends Application {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int PLAYER_SIZE = 40;
    private static final int GROUND_HEIGHT = 20;
    private static final int JUMP_STRENGTH = 15;

    private Pane root;
    private Rectangle player;
    private double velocityY = 0;

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

        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.SPACE) {
                jump();
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

    private void jump() {
        velocityY = -JUMP_STRENGTH;
    }

    private void update() {
        velocityY += 1 ; // Gravity
        player.setY(player.getY() + velocityY);

        if (player.getY() >= HEIGHT - GROUND_HEIGHT - PLAYER_SIZE) {
            player.setY(HEIGHT - GROUND_HEIGHT - PLAYER_SIZE);
        }
    }   
}