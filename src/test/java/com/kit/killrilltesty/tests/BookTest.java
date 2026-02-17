package com.kit.killrilltesty.tests;

import com.kit.killrilltesty.api.models.Book;
import com.kit.killrilltesty.api.specs.ResponseSpec;
import com.kit.killrilltesty.utils.ModelBuilder;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.text.ParseException;
import java.util.List;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.not;

public class BookTest extends BaseTest {

	@Test
	public void testCreateBook() {
		Book book = ModelBuilder.getBook();

		Assertions.assertEquals(201, book.getId());
		Assertions.assertEquals("Book 201", book.getTitle());

		Book bookResponse = RestAssured.given()
				.body(book)
				.when()
				.post("/books")
				.then()
				.extract()
				.response()
				.as(Book.class);

		Assertions.assertEquals(book, bookResponse);
	}

	@Test
	public void testGetBookById() throws ParseException {
		Book book = ModelBuilder.getBookForTestGet();

		Book bookResponse = RestAssured.given()
				.when()
				.get("/books/1")
				.then()
				.extract()
				.response()
				.as(Book.class);
		Assertions.assertEquals(book, bookResponse);
		// дату пришлось добавить в exclude для equals, потому что апи возвращает типа LocalDateTime.now(), синхронизировать ответ апи с созданием модели по дате не выйдет(
	}

	@Test
	public void testGetAllBooks() {
		RestAssured.given()
				.when()
				.get("/books")
				.then()
				.body("", not(empty()));

		List<Book> resp = RestAssured.given()
				.when()
				.get("/books")
				.then()
				.extract()
				.response()
				.as(new TypeRef<>() {});

		Assertions.assertFalse(resp.isEmpty());
	}

	@Test
	public void testDeleteBook() {
		Book book = ModelBuilder.getBook();

		RestAssured.given()
				.when()
				.body(book)
				.post("/books");

		RestAssured.given()
				.when()
				.get("/books/201");

		RestAssured.given()
				.when()
				.delete("/books/201");

		RestAssured.given()
				.when()
				.get("/books/201")
				.then()
				.statusCode(404);
	}

	@Test
	public void testNegativeGetNonExistingBook() {
		RestAssured.responseSpecification = ResponseSpec.getSpecNotFound();
		RestAssured.given()
				.when()
				.get("/books/999");
	}

	@ParameterizedTest
	@MethodSource("com.kit.killrilltesty.utils.ParametersProviderFactory#getBookStream")
	public void testCreateBookStream(Book book) {
		RestAssured.given()
				.body(book)
				.when()
				.post("/books");
	}

	@Test
	public void testCreateBookValidateSchema() {
		Book book = ModelBuilder.getBook();
		RestAssured.given()
				.body(book)
				.when()
				.post("/books")
				.then()
				.assertThat()
				.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/book_schema.json"));
	}
}
