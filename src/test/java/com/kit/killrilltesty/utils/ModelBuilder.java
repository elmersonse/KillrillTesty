package com.kit.killrilltesty.utils;

import com.kit.killrilltesty.api.models.Book;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;

public class ModelBuilder {

	public static Book getBook() {
		return Book.builder()
				.id(201)
				.title("Book 201")
				.description("Description 201")
				.excerpt("Excerpt 201")
				.pageCount(201)
				.publishDate(Date.from(Instant.now()))
				.build();
	}

	public static Book getBookForTestGet() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Date date = sdf.parse("2026-02-16T12:52:00.981048+00:00");
		return Book.builder()
				.id(1)
				.title("Book 1")
				.description("Lorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem.\n")
				.excerpt("Lorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem.\nLorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem.\nLorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem.\nLorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem.\nLorem lorem lorem. Lorem lorem lorem. Lorem lorem lorem.\n")
				.pageCount(100)
				.publishDate(date)
				.build();
	}
}
