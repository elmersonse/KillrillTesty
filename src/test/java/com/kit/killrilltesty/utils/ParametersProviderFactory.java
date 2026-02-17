package com.kit.killrilltesty.utils;

import com.kit.killrilltesty.api.models.Book;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class ParametersProviderFactory {

	private static final List<Integer> ids = Arrays.asList(1, 2, 3);
	private static final List<String> titles = Arrays.asList("T1", "T2", "T3");
	private static final List<String> descriptions = Arrays.asList("D1", "D2", "D3");
	private static final List<String> excerptions = Arrays.asList("E1", "E2", "E3");
	private static final List<Integer> pages = Arrays.asList(111, 222, 333);

	public static Stream<Book> getBookStream() {
		return ids.stream()
				.flatMap(id -> titles.stream()
						.flatMap(title -> descriptions.stream()
								.flatMap(desc -> excerptions.stream()
										.flatMap(exc -> pages.stream()
												.map(pages -> Book.builder()
														.id(id)
														.title(title)
														.description(desc)
														.excerpt(exc)
														.pageCount(pages)
														.publishDate(Date.from(Instant.now())).build())))));
	}
}
