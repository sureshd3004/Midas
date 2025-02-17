package com.midas.qa.pages;

<<<<<<< HEAD
import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.midas.qa.base.TestBase;
=======
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
>>>>>>> 2ba595c (updates)

public class SearchPage extends TestBase {

	@FindBy(xpath = "//tbody/tr/td[1]/img[@id='btnSearch']")
	WebElement btnSearch;
<<<<<<< HEAD
	
	@FindBy(xpath="//iframe[@id='pageContainer']")
	WebElement SearchFrame;
	
	@FindBy(xpath="//input[@name='UserSearchQuery']")
	WebElement searchox;
	
	@FindBys({
	    @FindBy(xpath = "//table[@class='masterSearchTable table-resizable']") 
	})
	private List<WebElement> searchResult;
		
	@FindBys({
	    @FindBy(xpath = "//th[@data-sortcolumn]") 
	})
	private List<WebElement> columnHeaders;
	
	@FindBy(xpath="//input[@id='btnExportToExcel']")
	WebElement exportExcel;
=======

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
>>>>>>> 2ba595c (updates)
	
	// Initializing the Page Objects:
	public SearchPage() {
		PageFactory.initElements(driver, this);
	}
<<<<<<< HEAD
	
	public String verifySearchTitle() {
		return driver.getTitle();
	}
	
	public boolean searchBoxTest(String string) {
		searchox.sendKeys(string);
		searchox.sendKeys(Keys.ENTER);
		return  searchResult.size()>-1;		
	}
	
	public void clickSearchIcon(){	
		driver.switchTo().frame(0);	
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)); 
        wait.until(ExpectedConditions.elementToBeClickable(btnSearch)).click();     
        btnSearch.click();
	}
	
	public String downloadExport() {
		 String fileName = "File not downloaded";
		 searchox.sendKeys("test");
			searchox.sendKeys(Keys.ENTER);
		 exportExcel.click();
		  File dir = new File(System.getProperty("user.dir") + "/downloads");
	
	        File[] files = dir.listFiles();
	        long initialCount = files != null ? files.length : 0;

	        // Wait until a new file is downloaded
	        while (files == null || files.length == initialCount) {
	            try {
	                TimeUnit.SECONDS.sleep(1); // Wait 1 second before checking again
	                files = dir.listFiles(); // Update the file list
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	        // Once the download is complete, print the list of files
	        if (files != null) {
	            for (File file : files) {
	                 fileName =  file.getName();
	            }
	        }
	        return fileName;
	}

	public int searchResultColoumns() {
		return columnHeaders.size();		
=======

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
>>>>>>> 2ba595c (updates)
	}
}
