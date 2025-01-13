package com.midas.qa.pages;

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

public class SearchPage extends TestBase {

	@FindBy(xpath = "//tbody/tr/td[1]/img[@id='btnSearch']")
	WebElement btnSearch;
	
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
	
	// Initializing the Page Objects:
	public SearchPage() {
		PageFactory.initElements(driver, this);
	}
	
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
	}
}
