import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class RocketGame extends Application {

    private double rocketX = 300;
    private double rocketY = 400;
    private double rocketSpeed = 5;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Rocket Game");

        StackPane root = new StackPane();
        Scene scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);

        Canvas canvas = new Canvas(600, 600);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.LEFT) {
                rocketX -= rocketSpeed;
            } else if (event.getCode() == KeyCode.RIGHT) {
                rocketX += rocketSpeed;
            } else if (event.getCode() == KeyCode.UP) {
                rocketY -= rocketSpeed;
            } else if (event.getCode() == KeyCode.DOWN) {
                rocketY += rocketSpeed;
            }
        });

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
                render(gc);
            }
        }.start();

        primaryStage.show();
    }

    private void update() {
        // You can add additional update logic here, e.g., check for collisions, update game state, etc.
    }

    private void render(GraphicsContext gc) {
        // Clear the canvas
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());

        // Draw the rocket
        gc.fillRect(rocketX, rocketY, 20, 40);
    }

    
}