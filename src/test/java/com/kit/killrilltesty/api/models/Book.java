package com.kit.killrilltesty.api.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Book {
	private int id;
	private String title;
	private String description;
	private int pageCount;
	private String excerpt;
	@EqualsAndHashCode.Exclude
	private Date publishDate;
}
