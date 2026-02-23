package com.kit.killrilltesty.ui.pages;

import com.kit.killrilltesty.ui.utils.TestContext;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class MainPage {

	private final WebDriver driver;

	private final By addToCartButton = new By.ByXPath("//button[text()='Add to cart']");
	private By itemTitle = new By.ByXPath("//div[contains(@class, 'name')]");
	private By itemPrice = new By.ByXPath("//div[contains(@class, 'item_price')]");
	private By selectSort = new By.ByXPath("//select");
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

	public List<String> getItemTitles() {
		return driver.findElements(itemTitle).stream()
				.map(WebElement::getText)
				.collect(Collectors.toList());
	}

	public List<Float> getItemPrices() {
		return driver.findElements(itemPrice).stream()
				.map(WebElement::getText)
				.map(s -> s.replace("$", ""))
				.map(Float::parseFloat)
				.collect(Collectors.toList());
	}

	public void selectSort(int index) {
		WebElement selectElement = driver.findElement(selectSort);
		Select select = new Select(selectElement);
		select.selectByIndex(index);
	}
}
