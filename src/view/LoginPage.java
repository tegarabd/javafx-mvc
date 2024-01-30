package view;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class LoginPage extends Page {

	private GridPane mainPane;
	private Label usernameLabel;
	private Label passwordLabel;
	private TextField usernameField;
	private PasswordField passwordField;
	private Button loginButton;

	@Override
	public void initialize() {

		mainPane = new GridPane();
		usernameLabel = new Label("Username");
		passwordLabel = new Label("Password");
		usernameField = new TextField();
		passwordField = new PasswordField();
		loginButton = new Button("Login");

		mainPane.setHgap(10);
		mainPane.setVgap(10);
		mainPane.add(usernameLabel, 0, 0);
		mainPane.add(usernameField, 1, 0);
		mainPane.add(passwordLabel, 0, 1);
		mainPane.add(passwordField, 1, 1);
		mainPane.add(loginButton, 1, 2);
		mainPane.setAlignment(Pos.CENTER);

		scene = new Scene(mainPane, 1280, 720);
	}

	public void setOnLoginButtonClicked(EventHandler<MouseEvent> event) {
		loginButton.setOnMouseClicked(event);
	}

	public String getUsernameFieldText() {
		return usernameField.getText();
	}

	public String getPasswordFieldText() {
		return passwordField.getText();
	}

}
