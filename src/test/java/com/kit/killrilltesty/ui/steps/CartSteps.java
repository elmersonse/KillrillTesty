package com.kit.killrilltesty.ui.steps;

import com.kit.killrilltesty.ui.pages.CartPage;
import com.kit.killrilltesty.ui.pages.CommonElements;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CartSteps {

	private final CartPage cartPage;
	private final CommonElements commonElements;

	public CartSteps(WebDriver driver) {
		this.cartPage = new CartPage(driver);
		this.commonElements = new CommonElements(driver);
	}

	@Step("Удалить из корзины первый товар")
	public CartSteps removeFirstItem() {
		cartPage.clickFirstRemoveButton();
		return this;
	}

	@Step("Удалить из корзины случайный товар")
	public CartSteps removeRandomItem() {
		cartPage.clickRandomRemoveButton();
		return this;
	}

	@Step("Сравнить количество товаров в корзине с ожидаемым: {expected}")
	public CartSteps checkItemCount(int expected) {
		int actual = cartPage.getCartItemCount();
		if (actual != expected) {
			throw new AssertionError("Expected " + expected + " but got " + actual);
		}
		return this;
	}

	@Step("Вернуться на главную страницу из корзины")
	public CartSteps returnToMainPage() {
		cartPage.clickReturnButton();
		return this;
	}

	@Step("Подтвердить комплектацию заказа")
	public CartSteps ckeckout() {
		cartPage.clickCheckoutButton();
		return this;
	}

	@Step("Ввести персональные данные")
	public CartSteps enterPersonalInfo() {
		cartPage.enterFirstname();
		cartPage.enterLastname();
		cartPage.enterPostalCode();
		return this;
	}

	@Step("Подтвердить персональные данные")
	public CartSteps confirmPersonalInfo() {
		cartPage.clickContinueButton();
		return this;
	}

	@Step("Оформить заказ")
	public CartSteps finishOrder() {
		cartPage.clickFinishButton();
		return this;
	}

	@Step("Вернуться на главную страницу после оформления заказа")
	public CartSteps backToMainPage() {
		cartPage.clickBackHomeButton();
		return this;
	}

	@Step("Проверить наличие баннера с ошибкой")
	public CartSteps checkErrorBanner() {
		cartPage.checkErrorBanner();
		return this;
	}
}
