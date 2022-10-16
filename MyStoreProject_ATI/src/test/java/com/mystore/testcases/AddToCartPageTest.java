/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.utility.Log;

/**
 * @author ramos
 *
 */
public class AddToCartPageTest extends BaseClass {
	IndexPage index;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;

	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void setup(String browser) {
		launchApp(browser);
	}

	@Test
	public void productAvialabilitytest() throws Throwable {
		Log.startTestCase("addToCartTest");
		index = new IndexPage();
		searchResultPage = index.searchProduct("t-shirt");
		boolean result = searchResultPage.isProductAvailable();
		Assert.assertTrue(result);
		Log.endTestCase("addToCartTest");
	}

	@Test(groups = { "Regression", "Sanity" }, dataProvider = "getProduct", dataProviderClass = DataProviders.class)
	public void addToCartTest(String productName, String qty, String size) throws Throwable {
		Log.startTestCase("addToCartTest");
		index = new IndexPage();
		searchResultPage = index.searchProduct(productName);
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity(qty);
		addToCartPage.selectSize(size);
		addToCartPage.clickOnAddToCart();
		Assert.assertTrue(addToCartPage.validateAddtoCart());
		Log.endTestCase("addToCartTest");

	}

	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void tearDown() {
		getDriver().quit();
	}
}
