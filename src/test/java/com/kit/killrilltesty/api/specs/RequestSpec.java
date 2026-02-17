package com.kit.killrilltesty.api.specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {

	private static final String baseUri = "https://fakerestapi.azurewebsites.net/api/v1";

	public static RequestSpecification getRequestSpecification() {
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setBaseUri(baseUri)
				.setAccept(ContentType.JSON)
				.setContentType(ContentType.JSON)
				.log(LogDetail.ALL);
		return builder.build();
	}

}
