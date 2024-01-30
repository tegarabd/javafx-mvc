package view;

import java.util.Vector;

import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import model.User;

public class UserManagementPage extends Page {

	private GridPane mainPane;
	private Label title;
	private UserTableView userTable;
	private Label usernameLabel;
	private TextField usernameField;
	private Label passwordLabel;
	private TextField passwordField;
	private Button addButton;
	private Button logoutButton;

	@Override
	public void initialize() {

		mainPane = new GridPane();
		title = new Label("User Management");
		userTable = new UserTableView();
		usernameLabel = new Label("Username");
		usernameField = new TextField();
		passwordLabel = new Label("Password");
		passwordField = new TextField();
		addButton = new Button("Add");
		logoutButton = new Button("Logout");

		mainPane.setHgap(10);
		mainPane.setVgap(10);
		mainPane.add(title, 0, 0, 4, 1);
		mainPane.add(logoutButton, 4, 0);
		mainPane.add(userTable, 0, 1, 5, 1);
		mainPane.add(usernameLabel, 0, 2);
		mainPane.add(usernameField, 1, 2);
		mainPane.add(passwordLabel, 2, 2);
		mainPane.add(passwordField, 3, 2);
		mainPane.add(addButton, 4, 2);

		mainPane.setAlignment(Pos.CENTER);

		scene = new Scene(mainPane);
	}

	public void setUserTableItems(Vector<User> users) {
		userTable.setItems(FXCollections.observableArrayList(users));
	}

	public void setOnAddButtonClicked(EventHandler<MouseEvent> event) {
		addButton.setOnMouseClicked(event);
	}

	public void setOnLogoutButtonClicked(EventHandler<MouseEvent> event) {
		logoutButton.setOnMouseClicked(event);
	}
	
	public String getUsernameFieldText() {
		return usernameField.getText();
	}

	public String getPasswordFieldText() {
		return passwordField.getText();
	}

}
