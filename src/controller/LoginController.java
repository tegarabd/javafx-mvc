package controller;

import lib.Action;
import model.User;
import view.LoginPage;

public class LoginController {

	private LoginPage loginPage;

	public LoginController() {
		this.loginPage = new LoginPage();
	}

	public LoginPage getLoginPage() {
		return loginPage;
	}
	
	public void setOnAuthenticated(Action action) {
		loginPage.setOnLoginButtonClicked(e -> {
			String username = loginPage.getUsernameFieldText();
			String password = loginPage.getPasswordFieldText();

			if (User.getUserByUsernameAndPassword(username, password) == null) {
				return;
			}
			
			action.perform();
		});
	}

}
