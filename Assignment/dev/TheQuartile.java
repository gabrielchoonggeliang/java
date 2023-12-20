import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;

public class TheQuartile extends Application {

  final String TITLE = "TheQuartile";
  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage primaryStage) {
    GridPane gridPane = new GridPane();
    Scene scene = new Scene(gridPane, 300, 300);
    primaryStage.setTitle(TITLE);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
