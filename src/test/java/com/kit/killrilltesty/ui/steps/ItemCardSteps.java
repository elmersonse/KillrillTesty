package com.kit.killrilltesty.ui.steps;

import com.kit.killrilltesty.ui.pages.ItemCardPage;
import com.kit.killrilltesty.ui.utils.ItemCardData;
import com.kit.killrilltesty.ui.utils.TestContext;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ItemCardSteps {

	private final ItemCardPage itemCardPage;

	public ItemCardSteps(WebDriver driver) {
		itemCardPage = new ItemCardPage(driver);
	}

	@Step("Сравнить данные на странице с сохранёнными данными из контекста")
	public ItemCardSteps compareItemData() {
		TestContext context = TestContext.getInstance();
		ItemCardData data = ItemCardData.builder()
				.title(itemCardPage.getItemTitle())
				.description(itemCardPage.getItemDescription())
				.imageUrl(itemCardPage.getItemImgUrl())
				.price(itemCardPage.getItemPrice())
				.build();

		if(!data.equals(context.getMainPageItemData())) throw new AssertionError("Item data does not match");

		return this;
	}
}
