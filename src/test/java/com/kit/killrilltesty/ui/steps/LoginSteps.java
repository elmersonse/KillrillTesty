package com.kit.killrilltesty.ui.steps;

import com.kit.killrilltesty.ui.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginSteps {

	private final LoginPage loginPage;
	private WebDriver driver;

	public LoginSteps(WebDriver driver) {
		this.driver = driver;
		this.loginPage = new LoginPage(driver);
	}

	public LoginSteps enterCredentials(String username, String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		return this;
	}

	public LoginSteps clickLoginButton() {
		loginPage.clickLoginButton();
		return this;
	}
}
