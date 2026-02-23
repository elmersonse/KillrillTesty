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
	private By checkoutButton = new By.ByXPath("//button[text()='Checkout']");
	private By firstnameInput = new By.ByXPath("//input[@name='firstName']");
	private By lastnameInput = new By.ByXPath("//input[@name='lastName']");
	private By postalCodeInput = new By.ByXPath("//input[@name='postalCode']");
	private By continueButton = new By.ByXPath("//input[@value='Continue']");
	private By finishButton = new By.ByXPath("//button[text()='Finish']");
	private By backHomeButton = new By.ByXPath("//button[text()='Back Home']");

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

	public void clickCheckoutButton() {
		driver.findElement(checkoutButton).click();
	}

	public void enterFirstname() {
		driver.findElement(firstnameInput).sendKeys("John");
	}

	public void enterLastname() {
		driver.findElement(lastnameInput).sendKeys("Doe");
	}

	public void enterPostalCode() {
		driver.findElement(postalCodeInput).sendKeys("246000");
	}

	public void clickContinueButton() {
		driver.findElement(continueButton).click();
	}

	public void clickFinishButton() {
		driver.findElement(finishButton).click();
	}

	public void clickBackHomeButton() {
		driver.findElement(backHomeButton).click();
	}
}
