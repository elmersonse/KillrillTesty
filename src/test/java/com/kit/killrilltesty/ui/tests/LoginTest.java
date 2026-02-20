package com.kit.killrilltesty.ui.tests;

import com.kit.killrilltesty.ui.utils.DriverType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class LoginTest extends BaseTest {

	@Test
	public void testLogin() {
		driverSetUp(DriverType.CHROME);
		loginSteps
				.enterCredentials("standard_user", "secret_sauce")
				.clickLoginButton()
				.checkLoginSuccess();
	}

	@ParameterizedTest
	@MethodSource("driverParamProvider")
	public void testLoginBrowsers(DriverType driverType) {
		driverSetUp(driverType);

		loginSteps
				.enterCredentials("standard_user", "secret_sauce")
				.clickLoginButton()
				.checkLoginSuccess();
	}

	public static Stream<DriverType> driverParamProvider() {
		return Stream.of(DriverType.CHROME, DriverType.FIREFOX, DriverType.EDGE);
	}
}
