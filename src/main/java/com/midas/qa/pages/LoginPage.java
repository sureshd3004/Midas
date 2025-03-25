package com.midas.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.midas.qa.base.TestBase;
import com.midas.qa.util.TestUtil;

public class LoginPage extends TestBase{

	//Page Factory - OR:
	@FindBy(xpath="//input[@id='UserName']")
	WebElement username;	

	@FindBy(xpath="//input[@id='Password']")
	WebElement password;

	@FindBy(xpath="//input[@id='btnLogin']")
	WebElement loginBtn;

	@FindBy(xpath = "//button[@type='button' and text()='Confirm']")
	WebElement Confirm;

	@FindBy(xpath="//h2[text()='Cleansing ']")
	WebElement clensing;

	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;

	@FindBy(xpath="//img[@alt='Client Logo']")
	WebElement Logo;

	@FindBy(xpath="//img[@id='btnNew']")
	WebElement requestIcon;

	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}

	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}

	public boolean validateImage(){
		return Logo.isDisplayed();
	}

	public HomePage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();

		TestUtil.waitAndClickElement(Confirm);
		TestUtil.waitAndClickElement(clensing);	
		return new HomePage();
	}




}
