package com.midas.qa.testcases;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.midas.qa.base.TestBase;
import com.midas.qa.pages.DataOfMaterialNo;
import com.midas.qa.pages.HomePage;
import com.midas.qa.pages.LoginPage;
import com.midas.qa.pages.SearchPage;
import com.midas.qa.util.TestUtil;

public class DataOfMaterialNoTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	SearchPage searchPage;
	DataOfMaterialNo DataOfMaterialNoPage;
	
	public DataOfMaterialNoTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		searchPage = new SearchPage();
		loginPage = new LoginPage();
		DataOfMaterialNoPage = new DataOfMaterialNo();
		homePage = loginPage.login("Cataloguer1", "Welcome@123");
		driver.switchTo().newWindow(WindowType.TAB);
	
		driver.navigate().to("https://ssruat.infoplusmdm.com/Search/MidasMasterSearch");
	//	TestUtil.WaitAndSwitchframe(0);
	//	searchPage = homePage.clickOnSearchIcon();
	}	
	
	@Test()
	public void takeDataFromMaterialNo() throws IOException{	
		String testData="1020032";
		searchPage.verifyAdditionalSettingsMaterialNumberSearchPage(testData);
		DataOfMaterialNoPage.getResultsData();
		DataOfMaterialNoPage.getERPData(testData);
					
	}
	
	@Test()
	public void takeDataFromRequestNo() throws IOException{	
		String testData="321";
		searchPage.verifyAdditionalSettingsRequestNumberSearchPage(testData);
		DataOfMaterialNoPage.getResultsData();
		TestUtil.waitAndClickElement(driver.findElement(By.xpath("//span[normalize-space()='ERP Information']")));
		TestUtil.takeResultsToExcel(testData);		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
