/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author ramos
 *
 */
public class SearchResultPage extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(xpath="//a[normalize-space()='Faded Short Sleeve T-shirts']")
	private WebElement productResult;
	
	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean isProductAvailable() throws Throwable {
		return Action.isDisplayed(getDriver(), productResult);
	}
	
	public AddToCartPage clickOnProduct() throws Throwable {
		Action.click(getDriver(), productResult);
		return new AddToCartPage();
	}
	
}
