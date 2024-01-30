package controller;

import lib.Action;
import model.User;
import view.UserManagementPage;

public class UserManagementController {

	private UserManagementPage userManagementPage;

	public UserManagementController() {
		userManagementPage = new UserManagementPage();
		userManagementPage.setOnAddButtonClicked(e -> {
			String username = userManagementPage.getUsernameFieldText();
			String password = userManagementPage.getPasswordFieldText();
			
			if (username == "" || password == "") {
				return;
			}
			
			User user = new User(username, password);
			User.addUser(user);
			refreshUserTable();
		});
		
		refreshUserTable();
	}
	
	public void setOnUnauthenticated(Action action) {
		userManagementPage.setOnLogoutButtonClicked(e -> {
			action.perform();
		});
	}
	
	public void refreshUserTable() {
		userManagementPage.setUserTableItems(User.getUsers());
	}

	public UserManagementPage getUserManagementPage() {
		return userManagementPage;
	}

}
