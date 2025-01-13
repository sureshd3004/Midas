package com.midas.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.midas.qa.base.TestBase;
import com.midas.qa.pages.HomePage;
import com.midas.qa.pages.LoginPage;
import com.midas.qa.pages.SearchPage;
import com.midas.qa.util.TestUtil;

public class SearchPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	SearchPage searchPage;

	String sheetName = "contacts";

	public SearchPageTest(){
		super();			
	}

	@BeforeMethod
	public void setUp() throws InterruptedException, IOException {		
		initialization();
		searchPage = new SearchPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	//	TestUtil.runTimeInfo("error", "login successful");
		TestUtil.WaitAndSwitchframe(0);
		searchPage = homePage.clickOnContactsLink();
		TestUtil.switchNewWindow();
	}

	@Test(priority=2, description = "TC007")
	public void verifySearchBox(){
		Assert.assertEquals(searchPage.searchBoxTest("test"), true);
	}

	@Test(priority=1 , description = "TC006")
	public void verifySearchPageTitle(){
		Assert.assertEquals(searchPage.verifySearchTitle() , "MidasMasterSearch");
	}
	@Test(priority=3 , description = "TC008")
	public void verifySearchResultExport() {		
		Assert.assertEquals(searchPage.downloadExport().contains("REPORT"),true);
	}
	
	@Test(description = "TC009",dataProvider = "getTestData",enabled = false)
	public void searchPageFilter() {
	//	Assert
		searchPage.searchResultColoumns();
	}
	@DataProvider
	public Object[][] getTestData(){
		String sheetName = "login";
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
