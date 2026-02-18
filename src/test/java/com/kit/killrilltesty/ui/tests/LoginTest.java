package com.kit.killrilltesty.ui.tests;

import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {

	@Test
	public void testLogin() {
		loginSteps
				.enterCredentials("standard_user", "secret_sauce")
				.clickLoginButton();
	}

}
