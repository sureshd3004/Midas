package com.midas.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.midas.qa.base.TestBase;

public class HomePage extends TestBase {


	@FindBy(xpath = "//img[@id='btnSearch']")
	WebElement searchLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath="//b[@id='spnUserName']")
	WebElement userName;
	
	@FindBy(xpath="//img[@id='btnNew']")
	WebElement singleRequestIcon;
	
	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public SearchPage clickOnSearchIcon(){
		searchLink.click();
		return new SearchPage();
	}
	public boolean validateUserName() {
		   return userName.getText().equalsIgnoreCase(prop.getProperty("username"));
		}

	public RequestPreviewPage clickonRequestIcon() {
		singleRequestIcon.click();
		return new RequestPreviewPage();
	}
}
