package com.kit.killrilltesty.ui.steps;

import com.kit.killrilltesty.ui.pages.CommonElements;
import com.kit.killrilltesty.ui.pages.MainPage;
import org.openqa.selenium.WebDriver;

public class MainSteps {

	private final MainPage mainPage;
	private final CommonElements commonElements;

	public MainSteps(WebDriver driver) {
		this.mainPage = new MainPage(driver);
		this.commonElements = CommonElements.getInstance(driver);
	}

	public MainSteps addFirstItemToCart() {
		mainPage.addFirstItemToCart();
		return this;
	}

	public MainSteps addRandomItemToCart() {
		mainPage.addRandomItemToCart();
		return this;
	}

	public MainSteps checkCartCount(int expected) {
		if(expected == 0) {
			if(commonElements.isCartCountDisplayed()) throw new AssertionError("Cart should not be displayed");
			else return this;
		}
		int actual = commonElements.getCartCount();
		if (actual != expected) {
			throw new AssertionError("Expected " + expected + " but got " + actual);
		}
		return this;
	}

	public MainSteps openCartPage() {
		commonElements.openCart();
		return this;
	}
}
