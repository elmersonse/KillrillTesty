package com.kit.killrilltesty.tests;

import com.kit.killrilltesty.api.specs.RequestSpec;
import com.kit.killrilltesty.api.specs.ResponseSpec;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseTest {

	@BeforeEach
	void setUp() {
		RestAssured.requestSpecification = RequestSpec.getRequestSpecification();
		RestAssured.responseSpecification = ResponseSpec.getSpecOk();
	}

	@AfterAll
	static void tearDown() {
		RestAssured.reset();
	}
}
