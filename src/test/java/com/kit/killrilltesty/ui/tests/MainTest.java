package com.kit.killrilltesty.ui.tests;

import com.kit.killrilltesty.ui.utils.DriverType;
import org.junit.jupiter.api.Test;

public class MainTest extends BaseTest {

	@Test
	public void testOneItemCart() {
		driverSetUp(DriverType.CHROME);
		loginAsStandardUser();

		mainSteps
				.addFirstItemToCart()
				.checkCartCount(1);

		cartSteps.removeFirstItem();

		mainSteps.checkCartCount(0);
	}

	@Test
	public void testRandomItemsCart() {
		driverSetUp(DriverType.CHROME);
		loginAsStandardUser();

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
		loginAsStandardUser();

		mainSteps
				.addRandomItemToCart()
				.addRandomItemToCart()
				.checkCartCount(2)
				.openCartPage();

		cartSteps
				.ckeckout()
				.enterPersonalInfo()
				.finishOrder()
				.backToMainPage();

		mainSteps.checkCartCount(0);
	}

	@Test
	public void testSorting() {
		driverSetUp(DriverType.CHROME);
		loginAsStandardUser();

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
}
