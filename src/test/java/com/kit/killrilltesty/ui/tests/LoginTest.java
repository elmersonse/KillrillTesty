package com.kit.killrilltesty.ui.tests;

import com.kit.killrilltesty.ui.utils.DriverType;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class LoginTest extends BaseTest {

	@ParameterizedTest
	@MethodSource("driverParamProvider")
	@Feature("Логин")
	@Description("Проверка входа на разных браузерах")
	public void testLoginBrowsers(DriverType driverType) {
		driverSetUp(driverType);
		loginSteps
				.enterCredentials("standard_user", "secret_sauce")
				.clickLoginButton()
				.waitForCartIcon(10)
				.checkLoginSuccess();
	}

	@Test
	@Feature("Логин")
	@Description("Неудачный вход при неправильных данных")
	public void testFailLogin() {
		driverSetUp(DriverType.CHROME);
		loginSteps
				.enterCredentials("standard_user", "secret_sauce1")
				.clickLoginButton()
				.waitForCartIcon(5)
				.checkLoginSuccess();
	}

	@Test
	@Feature("Логин")
	@Description("Неудачный вход при неправильных данных headless")
	public void testFailLoginHeadless() {
		driverSetUp(DriverType.CHROME_HEADLESS);
		loginSteps
				.enterCredentials("standard_user", "secret_sauce1")
				.clickLoginButton()
				.waitForCartIcon(5)
				.checkLoginSuccess();
	}

	public static Stream<DriverType> driverParamProvider() {
		return Stream.of(DriverType.CHROME, DriverType.FIREFOX, DriverType.EDGE);
	}
}
