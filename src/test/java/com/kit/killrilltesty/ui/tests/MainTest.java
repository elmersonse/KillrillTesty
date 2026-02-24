package com.kit.killrilltesty.ui.tests;

import com.kit.killrilltesty.ui.utils.DriverType;
import com.kit.killrilltesty.ui.utils.UserType;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

public class MainTest extends BaseTest {

	@Test
	@Feature("Корзина")
	@Description("Добавить первый товар в корзину, проверить, что счётчик изменился; убрать товар, проверить счётчик")
	public void testOneItemCart() {
		driverSetUp(DriverType.CHROME);
		loginAsUser(UserType.STANDARD);

		mainSteps
				.addFirstItemToCart()
				.checkCartCount(1);

		cartSteps.removeFirstItem();

		mainSteps.checkCartCount(0);
	}

	@Test
	@Feature("Корзина")
	@Description("Добавить 3 случайных товара в корзину, проверить, что счётчик изменился после каждого; убрать товар, проверить счётчик, проверить кнопку на главной")
	public void testRandomItemsCart() {
		driverSetUp(DriverType.CHROME);
		loginAsUser(UserType.STANDARD);

		mainSteps
				.addRandomItemToCart()
				.checkCartCount(1)
				.addRandomItemToCart()
				.checkCartCount(2)
				.addRandomItemToCart()
				.checkCartCount(3)
				.openCartPage();

		cartSteps
				.checkItemCount(3)
				.removeRandomItem()
				.checkItemCount(2)
				.returnToMainPage();

		mainSteps.checkRemovedItemButton();
	}

	@Test
	@Feature("Заказ")
	@Description("'Happy path' оформления заказа")
	public void testOrderHappyPath() {
		driverSetUp(DriverType.CHROME);
		loginAsUser(UserType.STANDARD);

		mainSteps
				.addRandomItemToCart()
				.addRandomItemToCart()
				.checkCartCount(2)
				.openCartPage();

		cartSteps
				.ckeckout()
				.enterPersonalInfo()
				.confirmPersonalInfo()
				.finishOrder()
				.backToMainPage();

		mainSteps.checkCartCount(0);
	}

	@Test
	@Feature("Главная страница")
	@Description("Проверка методов сортировки на главной")
	public void testSorting() {
		driverSetUp(DriverType.CHROME);
		loginAsUser(UserType.STANDARD);

		mainSteps
				.selectSortMethod(0)
				.checkSortByNameAZ()
				.selectSortMethod(1)
				.checkSortByNameZA()
				.selectSortMethod(2)
				.checkSorByPriceAsc()
				.selectSortMethod(3)
				.checkSorByPriceDesc();

	}

	@Test
	@Feature("Главная страница")
	@Description("Сравнить данные товара на главной и на странице товара")
	public void testItemDataComparison() {
		driverSetUp(DriverType.CHROME);
		loginAsUser(UserType.STANDARD);

		mainSteps
				.saveMainPageItemData()
				.openItemPage();

		itemCardSteps
				.compareItemData();

	}

	@Test
	@Feature("Заказ")
	@Description("Проверить оформление заказа с пустыми персональными данными")
	public void testOrderWithoutPersonalData() {
		driverSetUp(DriverType.CHROME);
		loginAsUser(UserType.STANDARD);

		mainSteps
				.addRandomItemToCart()
				.checkCartCount(1)
				.openCartPage();

		cartSteps
				.ckeckout()
				.confirmPersonalInfo()
				.checkErrorBanner();
	}

	@ParameterizedTest
	@EnumSource(UserType.class)
	@Feature("Бизнес приколы хз")
	@Description("Бизнес-сценарии для standard и performance-glitch юзеров")
	public void testBusinessScenarios(UserType userType) {
		driverSetUp(DriverType.CHROME);
		loginAsUser(userType);
		
		mainSteps
				.waitForPageToLoad(20)
				.addRandomItemToCart()
				.checkCartCount(1)
				.addRandomItemToCart()
				.checkCartCount(2)
				.openCartPage();

		cartSteps
				.ckeckout()
				.enterPersonalInfo()
				.confirmPersonalInfo()
				.finishOrder()
				.backToMainPage();
	}

}
