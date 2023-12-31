import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class RadioButtonDemo extends CheckBoxDemo {
  @Override // Override the getPane() method in the super class
  protected BorderPane getPane() {
    BorderPane pane = super.getPane();
    
    VBox paneForRadioButtons = new VBox(20);
    paneForRadioButtons.setPadding(new Insets(5, 5, 5, 5)); 
    paneForRadioButtons.setStyle
      ("-fx-border-width: 2px; -fx-border-color: green");
    
    RadioButton rbRed = new RadioButton("Red");
    RadioButton rbGreen = new RadioButton("Green");
    RadioButton rbBlue = new RadioButton("Blue");
    paneForRadioButtons.getChildren().addAll(rbRed, rbGreen, rbBlue);
    pane.setLeft(paneForRadioButtons);

    ToggleGroup group = new ToggleGroup();
    rbRed.setToggleGroup(group);
    rbGreen.setToggleGroup(group);
    rbBlue.setToggleGroup(group);
    
    EventHandler<ActionEvent> handler = e -> { 
    if (rbRed.isSelected()) {
        text.setFill(Color.RED);
      }
    else  if (rbGreen.isSelected()) {
        text.setFill(Color.GREEN);
      }
    else  if (rbBlue.isSelected()) {
        text.setFill(Color.BLUE);
      }
    };
    
    rbRed.setOnAction(handler);
    rbGreen.setOnAction(handler);
    rbBlue.setOnAction(handler);
    
    return pane;
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}