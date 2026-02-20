package com.kit.killrilltesty.ui.steps;

import com.kit.killrilltesty.ui.pages.CommonElements;
import com.kit.killrilltesty.ui.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginSteps {

	private final LoginPage loginPage;
	private final CommonElements commonElements;

	public LoginSteps(WebDriver driver) {
		this.loginPage = new LoginPage(driver);
		this.commonElements = CommonElements.getInstance(driver);
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

	public LoginSteps checkLoginSuccess() {
		commonElements.checkCartIcon();
		return this;
	}
}
