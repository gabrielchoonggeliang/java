import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

public class BackgroundMusicPlayer extends Application {

    private MediaPlayer mediaPlayer;

    public static void main(String[] args) {
        launch(args);
    }

    // @Override
    // public void start(Stage primaryStage) {
    //     primaryStage.setTitle("Background Music Player");

    //     // Load the music file
    //     String musicFile = "file:../assets/beat1.mp3"; // Replace this with your music file path
    //     Media sound = new Media(new File(musicFile).toURI().toString());
    //     mediaPlayer = new MediaPlayer(sound);

    //     // Create a "Play" button
    //     Button playButton = new Button("Play Music");
    //     playButton.setOnAction(e -> playMusic());

    //     // Create a "Stop" button
    //     Button stopButton = new Button("Stop Music");
    //     stopButton.setOnAction(e -> stopMusic());

    //     StackPane root = new StackPane();
    //     root.getChildren().addAll(playButton, stopButton);
    //     primaryStage.setScene(new Scene(root, 300, 200));

    //     primaryStage.show();
    // }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");

        String musicFile = "file:../assets/beat1.mp3";     // For example

        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();

        StackPane root = new StackPane();
        primaryStage.setScene(new Scene(root, 800, 450));
        primaryStage.show();
    }

    @Override
    public void stop() {
        // Stop playing the music when the application is closed
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }
}
