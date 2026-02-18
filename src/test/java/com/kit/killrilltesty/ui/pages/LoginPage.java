package com.kit.killrilltesty.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	private final By usernameField = By.xpath("//*[@id='user-name']");
	private final By passwordField = By.xpath("//*[@id='password']");
	private final By loginButton = By.xpath("//*[@id='login-button']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterUsername(String username) {
		driver.findElement(usernameField).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}

	public void clickLoginButton() {
		driver.findElement(loginButton).click();
	}
}
