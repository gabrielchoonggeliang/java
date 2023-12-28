import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

public class GameWithBackgroundMusic extends Application {

    private MediaPlayer mediaPlayer;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //primaryStage.setTitle("Game with Background Music");

        // Load the background music file
        String musicFile = "file:../assets/beat1.mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);

        // Create a "Start Game" button
        Button startButton = new Button("Start Game");
        startButton.setOnAction(e -> startGame(primaryStage));

        StackPane root = new StackPane();
        root.getChildren().add(startButton);
        primaryStage.setScene(new Scene(root, 300, 250));

        primaryStage.show();
    }

    private void startGame(Stage mainMenuStage) {
        // Start playing the background music
        mediaPlayer.play();

        // Rest of your game logic goes here...

        // For demonstration purposes, simply close the main menu stage
        mainMenuStage.close();
    }

    @Override
    public void stop() {
        // Stop playing the background music when the application is closed
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }
}