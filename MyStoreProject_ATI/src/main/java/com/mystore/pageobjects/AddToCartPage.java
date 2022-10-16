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
public class AddToCartPage extends BaseClass {
	
	Action action= new Action();
	
	
	@FindBy(id="quantity_wanted")
	private WebElement quantity;
	
	@FindBy(xpath="//select[@id='group_1']")
	private WebElement size;
	
	@FindBy(xpath="//span[text()='Add to cart']")
	private WebElement addToCartBtn;
	
	@FindBy(xpath="//h2[normalize-space()='Product successfully added to your shopping cart']")
	private WebElement addToCartMessag;
	
	@FindBy(xpath="//span[normalize-space()='Proceed to checkout']")
	private WebElement proceedToCheckOutBtn;
	
	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
		
	}
	
	
	public void enterQuantity(String quantity1) throws Throwable {
		Action.type(quantity, quantity1);
	}
	
	public void selectSize(String size1) throws Throwable {
		Action.selectByVisibleText(size1, size);
	}
	
	public void clickOnAddToCart() throws Throwable {
		Action.click(getDriver(), addToCartBtn);
		Thread.sleep(5000);
		
	}
	

	public boolean validateAddtoCart() throws Throwable {
		return Action.isDisplayed(getDriver(), proceedToCheckOutBtn);
	}
	
	
	public OrderPage clickOnCheckOut() throws Throwable {
		//Action.fluentWait(driver, proceedToCheckOutBtn);
		Action.JSClick(getDriver(), proceedToCheckOutBtn);
		Thread.sleep(5000);
		return new OrderPage();
	}
	
}