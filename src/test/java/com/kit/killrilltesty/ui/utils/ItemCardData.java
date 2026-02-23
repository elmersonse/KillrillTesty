package com.kit.killrilltesty.ui.utils;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode
public class ItemCardData {
	private String title;
	private String description;
	private String imageUrl;
	private String price;
}
