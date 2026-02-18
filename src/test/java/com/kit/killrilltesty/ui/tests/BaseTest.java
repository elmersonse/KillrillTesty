package com.kit.killrilltesty.ui.tests;

import com.kit.killrilltesty.ui.steps.LoginSteps;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseTest {

	protected WebDriver driver;
	protected LoginSteps loginSteps;

	private final String baseUrl = "https://www.saucedemo.com/";

	@BeforeEach
	void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		loginSteps = new LoginSteps(driver);
		driver.get(baseUrl);
	}

	@AfterEach
	void tearDown() {
		driver.quit();
	}
}
