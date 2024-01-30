package view;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.User;

public class UserTableView extends TableView<User> {

	private TableColumn<User, Integer> idColumn;
	private TableColumn<User, String> usernameColumn;
	private TableColumn<User, String> passwordColumn;

	public UserTableView() {
		idColumn = new TableColumn<User, Integer>("Id");
		usernameColumn = new TableColumn<User, String>("Username");
		passwordColumn = new TableColumn<User, String>("Password");

		idColumn.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
		usernameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
		passwordColumn.setCellValueFactory(new PropertyValueFactory<User, String>("password"));

		idColumn.setPrefWidth(40);
		usernameColumn.setPrefWidth(200);
		passwordColumn.setPrefWidth(200);
		
		this.getColumns().add(idColumn);
		this.getColumns().add(usernameColumn);
		this.getColumns().add(passwordColumn);
	}

}
