package com.kit.killrilltesty.api.models;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Author {
	private int id;
	@JsonSetter("idBook")
	private int bookId;
	private String firstname;
	private String lastname;
}
