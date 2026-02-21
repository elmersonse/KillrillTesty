package com.kit.killrilltesty.ui.pages;

import com.kit.killrilltesty.ui.utils.TestContext;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
public class MainPage {

	private final WebDriver driver;

	private final By addToCartButton = new By.ByXPath("//button[text()='Add to cart']");
	private By removedItemCardButton;

	public void addFirstItemToCart() {
		driver.findElement(addToCartButton).click();
	}

	public void addRandomItemToCart() {
		List<WebElement> items = driver.findElements(addToCartButton);

		Random rand = new Random();
		items.get(rand.nextInt(items.size())).click();
	}

	public boolean checkRemovedItem() {
		TestContext context = TestContext.getInstance();
		removedItemCardButton = new By.ByXPath("//div[text()='"+context.getRemovedItemTitle()+"']//ancestor::div[contains(@class, 'description')]//parent::button");
		String buttonText = driver.findElement(removedItemCardButton).getText();
		return buttonText.equals("Add to cart");
	}
}
