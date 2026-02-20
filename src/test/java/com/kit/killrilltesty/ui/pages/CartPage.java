package com.kit.killrilltesty.ui.pages;

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
	private By returnButton = new By.ByXPath("//button[text()='Continue Shopping']");

	public void clickFirstRemoveButton() {
		driver.findElement(removeButton).click();
	}

	public void clickRandomRemoveButton() {
		List<WebElement> items = driver.findElements(removeButton);

		Random rand = new Random();
		items.get(rand.nextInt(items.size())).click();
	}

	public int getCartItemCount() {
		return driver.findElements(cartItem).size();
	}

	public void clickReturnButton() {
		driver.findElement(returnButton).click();
	}
}
