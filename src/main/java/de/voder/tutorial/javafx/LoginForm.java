package de.voder.tutorial.javafx;

import java.util.logging.Logger;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginForm extends Application {
	
	private static final Logger LOGGER = Logger.getLogger(LoginForm.class.getName());
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("JavaFX Login Form");
		// define GridLayout
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		// define form elements
		Text sceneTitle = new Text("Welcome");
		sceneTitle.setId("welcome-text");
		grid.add(sceneTitle, 0, 0, 2, 1);
		
		Label username = new Label("User Name:");
		grid.add(username, 0, 1);
		
		final TextField userTf = new TextField();
		grid.add(userTf, 1, 1);
		
		Label password = new Label("Password:");
		grid.add(password, 0, 2);
		
		PasswordField pwdTf = new PasswordField();
		grid.add(pwdTf, 1, 2);
		
		HBox btnBox = new HBox(10);
		btnBox.setAlignment(Pos.BOTTOM_RIGHT);
		
		Button cancelBtn = new Button("Cancel");
		btnBox.getChildren().add(cancelBtn);
		
		Button loginBtn = new Button("Login");
		btnBox.getChildren().add(loginBtn);
		
		grid.add(btnBox, 1, 4);
		
		final Text targetText = new Text();
		targetText.setId("target-text");
		grid.add(targetText, 1, 6);
		
		loginBtn.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent ev) {
				LOGGER.fine("Button clicked: " + ev);
				targetText.setText("Login failed!\nUser '" + userTf.getText() + "' not known.");
			}
		});
		cancelBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent ev) {
				LOGGER.fine("Button clicked: " + ev);
				System.exit(0);
			}
		});
		// define scene
		Scene scene = new Scene(grid, 300, 250);
		primaryStage.setScene(scene);
		scene.getStylesheets().add(ClassLoader.getSystemResource("login.css").toExternalForm());
		// show stage
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
