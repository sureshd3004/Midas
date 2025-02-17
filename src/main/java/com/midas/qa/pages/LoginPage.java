package com.midas.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
<<<<<<< HEAD

=======
>>>>>>> 2ba595c (updates)
import com.midas.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Page Factory - OR:
	@FindBy(xpath="//input[@id='UserName']")
<<<<<<< HEAD
	WebElement username;

	
	
=======
	WebElement username;	

>>>>>>> 2ba595c (updates)
	@FindBy(xpath="//input[@id='Password']")
	WebElement password;

	@FindBy(xpath="//input[@id='btnLogin']")
	WebElement loginBtn;

	@FindBy(xpath = "//button[@type='button' and text()='Confirm']")
	WebElement conform;

	@FindBy(xpath="//h2[text()='Cleansing ']")
	WebElement clensing;

	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;

	@FindBy(xpath="//img[@alt='Client Logo']")
	WebElement Logo;

<<<<<<< HEAD
=======
	@FindBy(xpath="//img[@id='btnNew']")
	WebElement requestIcon;

>>>>>>> 2ba595c (updates)
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
<<<<<<< HEAD
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", conform);
		
		clensing.click();   	
		return new HomePage();
	}
=======

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", conform);

		clensing.click();   	
		return new HomePage();
	}

	


>>>>>>> 2ba595c (updates)
}
