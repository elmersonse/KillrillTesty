package com.kit.killrilltesty.ui.pages;

import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@RequiredArgsConstructor
public class CommonElements {

	private static CommonElements instance;

	public static synchronized CommonElements getInstance(WebDriver driver) {
		if (instance == null) {
			instance = new CommonElements(driver);
		}
		return instance;
	}


	private final WebDriver driver;

	private final By cart = new By.ByXPath("//a[contains(@class, 'cart')]");
	private final By cartCount = new By.ByXPath("//span/parent::a");

	public void checkCartIcon() {
		driver.findElement(cart);
	}

	public void openCart() {
		driver.findElement(cart).click();
	}

	public int getCartCount() {
		return Integer.parseInt(driver.findElement(cartCount).getText());
	}

	public boolean isCartCountDisplayed() {
		List<WebElement> elements = driver.findElements(cartCount);
		return !elements.isEmpty();
	}

}
