package controller;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainController extends Application {

	private Stage stage;

	private LoginController loginController;
	private UserManagementController userManagementController;

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;

		loginController = new LoginController();
		userManagementController = new UserManagementController();

		loginController.setOnAuthenticated(() -> {
			stage.setScene(userManagementController.getUserManagementPage().getScene());
		});

		userManagementController.setOnUnauthenticated(() -> {
			stage.setScene(loginController.getLoginPage().getScene());
		});

		stage.setWidth(1280);
		stage.setHeight(720);
		stage.setScene(loginController.getLoginPage().getScene());
		stage.show();
	}

}
