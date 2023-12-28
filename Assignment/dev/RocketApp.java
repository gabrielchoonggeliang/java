import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class RocketApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        // Create a triangle
        Polygon triangle = new Polygon();
        triangle.getPoints().addAll(
                50.0, 50.0,
                100.0, 150.0,
                150.0, 50.0
        );
        triangle.setFill(Color.BLUE);

        // Create a rectangle
        Rectangle rectangle = new Rectangle(100, 150, 100, 50);
        rectangle.setFill(Color.GREEN);

        // Create a connector rectangle
        Rectangle connector = new Rectangle(100, 150, 100, 5);
        connector.setFill(Color.GRAY);

        // Create a group to hold the triangle, rectangle, and connector
        Group shapesGroup = new Group(triangle, rectangle, connector);

        // Add the shapes group to the root group
        root.getChildren().add(shapesGroup);

        // Create a scene and set it on the stage
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);

        // Set the title of the stage
        primaryStage.setTitle("Shapes Connection");

        // Show the stage
        primaryStage.show();
    }
}
