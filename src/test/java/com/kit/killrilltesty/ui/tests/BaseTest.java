package com.kit.killrilltesty.ui.tests;

import com.kit.killrilltesty.ui.steps.CartSteps;
import com.kit.killrilltesty.ui.steps.ItemCardSteps;
import com.kit.killrilltesty.ui.steps.LoginSteps;
import com.kit.killrilltesty.ui.steps.MainSteps;
import com.kit.killrilltesty.ui.utils.DriverType;
import com.kit.killrilltesty.ui.utils.UserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;


public class BaseTest {

	private Path screenshotDir;

	protected WebDriver driver;
	protected LoginSteps loginSteps;
	protected MainSteps mainSteps;
	protected CartSteps cartSteps;
	protected ItemCardSteps itemCardSteps;


	private final String baseUrl = "https://www.saucedemo.com/";

	@RegisterExtension
	TestWatcher testWatcher = new TestWatcher() {
		@Override
		public void testFailed(ExtensionContext context, Throwable cause) {
			try {
				if (driver != null) {
					String testName = context.getDisplayName();
					Path screenshotPath = screenshotDir.resolve(testName + ".png");

					File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(screenshot, new File(screenshotPath.toUri()));

					saveToAllure(screenshot, testName);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Attachment(value = "Скриншот при падении теста {testName}", type = "image/png")
		private byte[] saveToAllure(File screenshot, String testName) throws IOException {
			return Files.readAllBytes(screenshot.toPath());
		}
	};



	@BeforeAll
	public static void setup() {
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		WebDriverManager.edgedriver().setup();
	}

	@BeforeEach
	public void setUp() {
		screenshotDir = Paths.get("screenshots/");
		try {
			Files.createDirectories(screenshotDir);
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}

	/**
	 * Setup driver
	 * @param driverType "edge", "firefox", other will be ChromeDriver.
	 */
	void driverSetUp(DriverType driverType) {
		driver = switch (driverType) {
			case FIREFOX -> new FirefoxDriver();
			case EDGE -> new EdgeDriver();
			case CHROME -> {
				Map<String, Object> chromePrefs = new HashMap<String, Object>();
				chromePrefs.put("profile.password_manager_leak_detection", false);
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", chromePrefs);
				yield new ChromeDriver(options);
			}
			case CHROME_HEADLESS -> {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=new");
				yield new ChromeDriver(options);
			}
		};

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		loginSteps = new LoginSteps(driver);
		mainSteps = new MainSteps(driver);
		cartSteps = new CartSteps(driver);
		itemCardSteps = new ItemCardSteps(driver);
		driver.get(baseUrl);
	}

	@AfterEach
	void tearDown() {
		//driver.quit();
	}

	public void loginAsUser(UserType type) {
		switch (type) {
			case STANDARD -> {
				loginSteps
						.enterCredentials("standard_user", "secret_sauce")
						.clickLoginButton();
			}
			case PERFORMANCE_GLITCH -> {
				loginSteps
						.enterCredentials("performance_glitch_user", "secret_sauce")
						.clickLoginButton();
			}
		}

	}
}
