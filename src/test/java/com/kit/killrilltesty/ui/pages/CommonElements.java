package com.kit.killrilltesty.ui.pages;

import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

@RequiredArgsConstructor
public class CommonElements {

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

	public void waitForCartIcon(int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(cart));
	}

}
