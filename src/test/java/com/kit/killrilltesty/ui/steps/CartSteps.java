package com.kit.killrilltesty.ui.steps;

import com.kit.killrilltesty.ui.pages.CartPage;
import com.kit.killrilltesty.ui.pages.CommonElements;
import org.openqa.selenium.WebDriver;

public class CartSteps {

	private final CartPage cartPage;
	private final CommonElements commonElements;

	public CartSteps(WebDriver driver) {
		this.cartPage = new CartPage(driver);
		this.commonElements = new CommonElements(driver);
	}

	public CartSteps removeFirstItem() {
		cartPage.clickFirstRemoveButton();
		return this;
	}

	public CartSteps removeRandomItem() {
		cartPage.clickRandomRemoveButton();
		return this;
	}

	public CartSteps checkItemCount(int expected) {
		int actual = cartPage.getCartItemCount();
		if (actual != expected) {
			throw new AssertionError("Expected " + expected + " but got " + actual);
		}
		return this;
	}

	public CartSteps returnToMainPage() {
		cartPage.clickReturnButton();
		return this;
	}
}
