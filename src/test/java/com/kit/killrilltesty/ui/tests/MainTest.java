package com.kit.killrilltesty.ui.tests;

import com.kit.killrilltesty.ui.utils.DriverType;
import com.kit.killrilltesty.ui.utils.UserType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

public class MainTest extends BaseTest {

	@Test
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
