package com.kit.killrilltesty.ui.steps;

import com.kit.killrilltesty.ui.pages.CommonElements;
import com.kit.killrilltesty.ui.pages.MainPage;
import com.kit.killrilltesty.ui.utils.ItemCardData;
import com.kit.killrilltesty.ui.utils.TestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainSteps {

	private final MainPage mainPage;
	private final CommonElements commonElements;
	private final WebDriver driver;

	public MainSteps(WebDriver driver) {
		this.driver = driver;
		this.mainPage = new MainPage(driver);
		this.commonElements = new CommonElements(driver);
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

	public MainSteps checkRemovedItemButton() {
		if(!mainPage.checkRemovedItem()) throw new AssertionError("Wrong button :(");
		return this;
	}

	public MainSteps selectSortMethod(int index) {
		mainPage.selectSort(index);
		return this;
	}

	public MainSteps checkSortByNameAZ() {
		List<String> actual = mainPage.getItemTitles();
		List<String> expected = new ArrayList<>(actual);
		expected.sort(String::compareToIgnoreCase);
		if(!actual.equals(expected)) throw new AssertionError("Wrong order");
		return this;
	}

	public MainSteps checkSortByNameZA() {
		List<String> actual = mainPage.getItemTitles();
		List<String> expected = new ArrayList<>(actual);
		expected.sort(Collections.reverseOrder(String::compareToIgnoreCase));
		if(!actual.equals(expected)) throw new AssertionError("Wrong order");
		return this;
	}

	public MainSteps checkSorByPriceAsc() {
		List<Float> actual = mainPage.getItemPrices();
		List<Float> expected = new ArrayList<>(actual);
		expected.sort(Float::compareTo);
		if(!actual.equals(expected)) throw new AssertionError("Wrong order");
		return this;
	}

	public MainSteps checkSorByPriceDesc() {
		List<Float> actual = mainPage.getItemPrices();
		List<Float> expected = new ArrayList<>(actual);
		expected.sort(Collections.reverseOrder(Float::compareTo));
		if(!actual.equals(expected)) throw new AssertionError("Wrong order");
		return this;
	}


	public MainSteps saveMainPageItemData() {
		TestContext context = TestContext.getInstance();
		ItemCardData data = ItemCardData.builder()
				.title(mainPage.getItemTitle())
				.description(mainPage.getItemDescription())
				.imageUrl(mainPage.getItemImgUrl())
				.price(mainPage.getItemPrice())
				.build();
		context.setMainPageItemData(data);
		return this;
	}

	public MainSteps openItemPage() {
		mainPage.openItemCardPage();
		return this;
	}

	public MainSteps waitForPageToLoad(int seconds) {
		mainPage.waitForPageToLoad(seconds);
		return this;
	}
}
