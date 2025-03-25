package com.midas.qa.pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.midas.qa.base.TestBase;
import com.midas.qa.util.TestUtil;

public class SearchPage extends TestBase {

	@FindBy(xpath = "//tbody/tr/td[1]/img[@id='btnSearch']")
	WebElement btnSearch;

	@FindBy(xpath="//iframe[@id='pageContainer']")
	WebElement SearchFrame;

	@FindBy(xpath="//input[@name='UserSearchQuery']")
	WebElement searchBox;

	@FindBy(xpath="//textarea[@id='RequestNo']")
	WebElement rquestNumber;

	@FindBy(xpath="//textarea[@id='MaterialNo']")
	WebElement materialNumber;

	@FindBy(xpath="//textarea[@id='Manufacturer']")
	WebElement manufacturer;

	@FindBy(xpath="//textarea[@id='PartNumber']")
	WebElement partNumber;

	@FindBy(xpath="//input[@id='btnAdvancedSearch']")
	WebElement searchbtn;

	@FindBy(xpath="//label[text()='Advance Settings']")
	List<WebElement> advancedSettings;

	@FindBy(xpath="//*[@id='ulSearchResultData']/table/tbody/tr/td[1]")
	WebElement requestNumberResult;

	@FindBy(xpath="//*[@id='ulSearchResultData']/table/tbody/tr/td[2]")
	WebElement materialNumberResult;

	@FindBy(xpath="//*[@id='ulSearchResultData']/table/tbody/tr/td[3]")
	WebElement manufacSearchResult;
	
	@FindBy(xpath="//*[@id='ulSearchResultData']/table/tbody/tr/td[4]")
	WebElement partNumberSearchResult;
	
	
	
	// Initializing the Page Objects:
	public SearchPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifySearchTitle() {
		return driver.getTitle();
	}

	public boolean searchBoxTest(String string) {
		searchBox.sendKeys(string);	 
		searchBox.sendKeys(Keys.ENTER);
		WebElement	searchResult = driver.findElement(By.xpath("//*[contains(text(), '"+string+"')]"));
		return  searchResult.getText().contains(string);	
	}

	public void clickSearchIcon(){	
		driver.switchTo().frame(0);	
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)); 
		wait.until(ExpectedConditions.elementToBeClickable(btnSearch)).click();     
		btnSearch.click();
	}

	public boolean verifyAdditionalSettingsRequestNumberSearchPage(String requestNumber) {				 

		TestUtil.waitAndClickElement(advancedSettings.get(1));	
		rquestNumber.sendKeys(requestNumber);
		TestUtil.waitAndClickElement(searchbtn);
		return	requestNumberResult.getText().contains(requestNumber);   
	}

	public boolean verifyAdditionalSettingsMaterialNumberSearchPage(String property) {

		TestUtil.waitAndClickElement(advancedSettings.get(1));
		materialNumber.sendKeys(property);
		TestUtil.waitAndClickElement(searchbtn);
		return	materialNumberResult.getText().contains(property);

	}

	public boolean verifyAdditionalSettingsManufacturerSearchPage(String property) {

		TestUtil.waitAndClickElement(advancedSettings.get(1));
		manufacturer.sendKeys(property);
		TestUtil.waitAndClickElement(searchbtn);
		return	manufacSearchResult.getText().contains(property);
	}

	public boolean verifyAdditionalSettingsPartNumberSearchPage(String property) {

		TestUtil.waitAndClickElement(advancedSettings.get(1));
		partNumber.sendKeys(property);
		TestUtil.waitAndClickElement(searchbtn);
		TestUtil.waitforElementToLoad(partNumberSearchResult);
		return  partNumberSearchResult.getText().contains(property);
	}
}
