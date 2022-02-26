import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXTemplate extends Application {

	private Button b1;
	private Button b2;
	private BorderPane rootBP;
	private VBox buttonBox;
	private TextField t1;
	private TextField t2;
	private EventHandler<ActionEvent> Button1Handler;
	private EventHandler<ActionEvent> Button2Handler;

	public static void main(String[] args) {
		launch(args);
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Santiago Fernandez Homework3");

		b1 = new Button("Button 1");
		b2 = new Button("Button 2");
		rootBP = new BorderPane();
		buttonBox = new VBox();
		t1 = new TextField("enter text here then press button 1");
		t2 = new TextField("final string goes here");

		t2.setEditable(false);

		rootBP.setStyle("-fx-font-family: SansSerif;");

		buttonBox.getChildren().addAll(b1,b2);
		buttonBox.setAlignment(Pos.CENTER);

		rootBP.setLeft(buttonBox);
		rootBP.setCenter(t1);
		rootBP.setRight(t2);
		BorderPane.setAlignment(t2, Pos.CENTER);

		primaryStage.setWidth(700);
		primaryStage.setHeight(200);

		Button1Handler = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent bClick) {
				t2.setText(t1.getText() + ": from the center text field!");
				b1.setText("pressed");
				b1.setDisable(true);
			}
		};

		Button2Handler = (ActionEvent bClick) -> {
			t1.clear();
			t2.setText("final string goes here");
			b1.setDisable(false);
			b1.setText("Button 1");
		};

		b1.setOnAction(Button1Handler);
		b2.setOnAction(Button2Handler);

		Scene scene = new Scene(rootBP);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
