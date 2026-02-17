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
public class User {
	private int id;
	@JsonSetter("userName")
	private String username;
	private String password;
}
