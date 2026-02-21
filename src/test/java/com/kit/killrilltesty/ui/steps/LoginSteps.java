package com.kit.killrilltesty.ui.steps;

import com.kit.killrilltesty.ui.pages.CommonElements;
import com.kit.killrilltesty.ui.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps {

	private final LoginPage loginPage;
	private final CommonElements commonElements;
	private final WebDriver driver;

	public LoginSteps(WebDriver driver) {
		this.driver = driver;
		this.loginPage = new LoginPage(driver);
		this.commonElements = new CommonElements(driver);
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

	public LoginSteps waitForCartIcon(int seconds) {
		commonElements.waitForCartIcon(seconds);
		return this;
	}
}
