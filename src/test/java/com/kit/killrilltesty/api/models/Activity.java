package com.kit.killrilltesty.api.models;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Activity {
	private int id;
	private String title;
	private Date dueDate;
	@JsonSetter("completed")
	private boolean isCompleted;
}
