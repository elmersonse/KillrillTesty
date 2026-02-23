package com.kit.killrilltesty.ui.pages;

import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@RequiredArgsConstructor
public class ItemCardPage {

	private final WebDriver driver;

	private By itemTitle = new By.ByXPath("//div[contains(@data-test, 'name')]");
	private By itemDescription = new By.ByXPath("//div[contains(@data-test, 'desc')]");
	private By itemPrice = new By.ByXPath("//div[contains(@data-test, 'price')]");
	private By itemImage = new By.ByXPath("//img[contains(@class, 'details')]");


	public String getItemTitle() {
		return driver.findElement(itemTitle).getText();
	}

	public String getItemDescription() {
		return driver.findElement(itemDescription).getText();
	}

	public String getItemPrice() {
		return driver.findElement(itemPrice).getText();
	}

	public String getItemImgUrl() {
		return driver.findElement(itemImage).getAttribute("src");
	}

}
