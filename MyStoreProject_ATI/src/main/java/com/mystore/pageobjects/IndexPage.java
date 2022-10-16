package com.mystore.pageobjects;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass {

	@FindBy (xpath="//a[@title='Log in to your customer account']")
	WebElement signin_btn;
	
	@FindBy (id ="search_query_top" )
	WebElement searchProductBox;
	
	@FindBy (xpath="//img[@alt='My Store']")
	WebElement logo;
	
	@FindBy (xpath="//button[@name='submit_search']")
	WebElement searchButton;
	@FindBy (xpath="//img[@alt='My Store']")
	WebElement myStoreLogo;
	
	
	public IndexPage() {
		PageFactory.initElements(getDriver(),this);;
		// TODO Auto-generated constructor stub
	}
	//Ahora veamos lo que pasa cuando le damos click en signin
	public LoginPage clickOnSignIn() throws Throwable {
		Action.click(getDriver(), signin_btn);
		return new LoginPage();
	}
	
	public boolean validateLogo() throws Throwable {
		return Action.isDisplayed(getDriver(), myStoreLogo);
	}
	
	public String getMyStoreTitle() {
	String myStoreTitle = getDriver().getTitle();
	return myStoreTitle;
	}
	
	public SearchResultPage searchProduct(String productName) throws Throwable {
		Action.type(searchProductBox, productName);
		//Action.scrollByVisibilityOfElement(driver, searchButton);
		Action.click(getDriver(), searchButton);
		Thread.sleep(3000);
		return new SearchResultPage();
	}
	
	
	

}
