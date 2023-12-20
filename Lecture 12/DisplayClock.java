import javafx.animation.KeyFrame;

import javafx.animation.Timeline;

import javafx.application.Application;

import javafx.event.ActionEvent;

import javafx.event.EventHandler;

import javafx.geometry.Pos;

import javafx.scene.Scene;

import javafx.scene.layout.*;

import javafx.scene.paint.Color;

import javafx.scene.shape.Line;

import javafx.stage.Stage;

import javafx.util.Duration;

import javafx.scene.control.Label;





public class DisplayClock extends Application {

	public void start (Stage primaryStage) {

		ClockPane clock = new ClockPane();

		String timeString = clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond();

		Label lblCurrentTime  = new Label(timeString);


		BorderPane pane = new BorderPane();

		pane.setCenter(clock);

		pane.setBottom(lblCurrentTime);

		BorderPane.setAlignment(lblCurrentTime, Pos.TOP_CENTER);

    //Create an Animation

		// Create a handler for animation

    EventHandler<ActionEvent> eventHandler = e -> {

      clock.setCurrentTime(); // Set a new clock time

    };


    // Create an animation for a running clock

    Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler));

    animation.setCycleCount(Timeline.INDEFINITE);

    animation.play(); // Start animation

		Scene scene =  new Scene (pane, 250, 250);

		primaryStage.setTitle("DisplayClock");

		primaryStage.setScene(scene);

		primaryStage.show();

	}


	public static void main(String[] args) {

		Application.launch(args);

	}

}