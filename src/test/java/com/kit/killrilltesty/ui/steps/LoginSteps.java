package com.kit.killrilltesty.ui.steps;

import com.kit.killrilltesty.ui.pages.CommonElements;
import com.kit.killrilltesty.ui.pages.LoginPage;
import io.qameta.allure.Step;
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

	@Step("Ввести данные для входа")
	public LoginSteps enterCredentials(String username, String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		return this;
	}

	@Step("Нажать на кнопку логина")
	public LoginSteps clickLoginButton() {
		loginPage.clickLoginButton();
		return this;
	}

	@Step("Проверить успешность входа")
	public LoginSteps checkLoginSuccess() {
		commonElements.checkCartIcon();
		return this;
	}

	@Step("Подождать появления иконки корзины")
	public LoginSteps waitForCartIcon(int seconds) {
		commonElements.waitForCartIcon(seconds);
		return this;
	}
}
