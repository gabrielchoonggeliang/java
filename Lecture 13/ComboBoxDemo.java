
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class ComboBoxDemo extends Application {
  // Declare an array of Strings for flag titles
  private String[] flagTitles = {"China", "Denmark", 
    "France", "Malaysia"};

  // Declare an ImageView array for the national flags of 9 countries
  private ImageView[] flagImage = {
    new ImageView("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFwAAABcCAMAAADUMSJqAAAAaVBMVEXuHCX//wDtACbuEibyWhz/9wD/+gDvOSPzbhvzdBv4shL+8QDvJyPyYh7uIyT2nRbxUB7wQCH82wj1kBr96QX70Qv5vBD3pRPzahz0ghn4qhPxSh795AfxRR/1iBf2lxX7yw70fBr6xQ1r60ieAAAB8klEQVRoge2W2ZaDIAxAJUFx37dWp9v/f+RgN9ua8VSUp+G+9Kj0HghJwLIM/xVEC0WLetyuB5AXoEVugV1WzN1ATi0eXMZYzVfbMQ0JeSHlrGzWysGfbhx6TsBsL1u9oxDU09XvItgHuNqNHeuncUHEsFq/n9AwFlFTxG59mkPPmD8zR/GDdEJ9AQqZFf3MAFF1EB5iJTkkQ86RcbkP6MujnSwKPz6AfJA38Hzx6Q7lgGCRO+YPWnatlvT+GKUfAxN7+LwoKbF1GEmfvQ8UbXEa7EQRz9itmnIn8DlFBM7O2HpL5DKYu8nky4iILaY5WItrFbr+3V0Lct8EV8lyjP1XdzEJyWOcglsCh9HdbX3swHmUq9XgnLwa5ceNZ45ZMMr/brChUtBhd0vuy/XnrzqBRCjJh+ILWsBiSPkDOXXZbeQVQ+FMCmXfqIbkBi5T/kQJ4i6LnDx1o6X7jednvV+7AbX68NYl7JmeTAOXYLyYyPjvqLhAKzc9Xx6W2H/9D2QNaYhL2SsV0hRnnp5vXdttnVTTldTjAMLVI7+taHM3Zkq99gtSBDidNUWas33NqINpC4ZLHtvTR9N6Ob8WZqJFHsq6dIpu0Y3iW7BJuG8LTdkCIO/nSn38O1BPUB52jW6DwWAwGAwGg8FgMBgMhhd+ATZhECeCuU3BAAAAAElFTkSuQmCC"), 
    new ImageView("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFwAAABcCAMAAADUMSJqAAAAKlBMVEXIEC7////9+frosbbFABPKHzfHBCrNQEvEAA/HACPKMj3EAAv+/P3qub0gJtRTAAAAaUlEQVRoge3VOQ6AMAxFwYR9Cfe/LiUgUiCEK+bVX1PaKd0b+iYfNeNQ2bwODofD4XA4HA6Hw+Ff4N29ab7gy1rZPCq1tcoJL1t18qSUA4PD4f/FQw9X6MkNfRZwOBwOh8PhcDgcDo/Bd3jOFNvqcLHDAAAAAElFTkSuQmCC"), 
    new ImageView("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAANMAAACNCAMAAAAaXb9sAAAAFVBMVEX////OESYAJlQAJFMWJ1LknJ3MABMuxqsFAAAAlUlEQVR4nO3PNwEAMAADoHT6l9yvCnKCAzIL1k7FuaMhTk5OTk5OTk5OTk5OTk5OTk5OTk5OTk5OTk5OTk5OTk5OTk5OTk5OTk5OTk5OTk5OTk5OTk5OTk5OTk5OTk5OTk5OTk5OTk5OTk5OTk5OTk5OTk5OTk5OTk5OTk5OTk5OTk5OTk5OTk5OTk5OTk5OTk5OTt8DAwh61AJklbwAAAAASUVORK5CYII="), 
    new ImageView("data:image/png;base64,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")
    };

  // Declare an array of strings for flag descriptions
  private String[] flagDescription = new String[4];

  // Declare and create a description pane
  private DescriptionPane descriptionPane = new DescriptionPane();

  // Create a combo box for selecting countries
  private ComboBox<String> cbo = new ComboBox<>(); // flagTitles

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Set text description
    flagDescription[0] = "Description for China ... ";
    flagDescription[1] = "Description for Denmark ... ";
    flagDescription[2] = "Description for France ... ";
    flagDescription[3] = "Description for Malaysia ... ";


    // Set the first country (Canada) for display
    setDisplay(0);

    // Add combo box and description pane to the border pane
    BorderPane pane = new BorderPane();
      
    BorderPane paneForComboBox = new BorderPane();
    paneForComboBox.setLeft(new Label("Select a country: "));
    paneForComboBox.setCenter(cbo);
    pane.setTop(paneForComboBox);
    cbo.setPrefWidth(400);
    cbo.setValue("China");
    
    ObservableList<String> items = FXCollections.observableArrayList(flagTitles); // Add the list of string to comboBox
    cbo.getItems().addAll(items); // Add items to combo box
    pane.setCenter(descriptionPane);
    
    // Display the selected country
    cbo.setOnAction(e -> setDisplay(items.indexOf(cbo.getValue())));
    
    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 450, 170);
    primaryStage.setTitle("ComboBoxDemo"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }

  /** Set display information on the description pane */
  public void setDisplay(int index) {
    descriptionPane.setTitle(flagTitles[index]);
    descriptionPane.setImageView(flagImage[index]);
    descriptionPane.setDescription(flagDescription[index]);
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}