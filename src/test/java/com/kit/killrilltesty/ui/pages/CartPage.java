package com.kit.killrilltesty.ui.pages;

import com.kit.killrilltesty.ui.utils.TestContext;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
public class CartPage {

	private final WebDriver driver;

	private By removeButton = new By.ByXPath("//button[text()='Remove']");
	private By cartItem = new By.ByXPath("//div[@class='cart_item']");
	private By cartItemTitle = new By.ByXPath("//div[contains(@class, 'name')]");
	private By returnButton = new By.ByXPath("//button[text()='Continue Shopping']");

	public void clickFirstRemoveButton() {
		driver.findElement(removeButton).click();
	}

	public void clickRandomRemoveButton() {
		TestContext context = TestContext.getInstance();
		List<WebElement> items = driver.findElements(removeButton);
		List<WebElement> itemNames = driver.findElements(cartItemTitle);

		Random rand = new Random();
		int next = rand.nextInt(items.size());
		String itemName = itemNames.get(next).getText();
		items.get(next).click();
		context.setRemovedItemTitle(itemName);
	}

	public int getCartItemCount() {
		return driver.findElements(cartItem).size();
	}

	public void clickReturnButton() {
		driver.findElement(returnButton).click();
	}
}
