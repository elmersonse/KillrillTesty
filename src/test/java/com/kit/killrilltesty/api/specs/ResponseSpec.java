package com.kit.killrilltesty.api.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.containsString;

public class ResponseSpec {

	public static ResponseSpecification getSpecOk() {
		ResponseSpecBuilder builder = new ResponseSpecBuilder();
		builder.expectStatusCode(200);
		return builder.build();
	}

	public static ResponseSpecification getSpecNotFound() {
		ResponseSpecBuilder builder = new ResponseSpecBuilder();
		builder.expectStatusCode(404);
		return builder.build();
	}
}
