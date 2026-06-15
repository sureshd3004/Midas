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

	public SearchPageTest(){
		super();			
	}

	@BeforeMethod
	public void setUp() throws InterruptedException, IOException {		
		initialization();
		searchPage = new SearchPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		TestUtil.WaitAndSwitchframe(0);
		searchPage = homePage.clickOnSearchIcon();
		TestUtil.switchNewWindow();
	}

	@Test(priority=2, description = "TC007", dataProvider = "getTestData")
	public void verifySearchBox(String testData){
		Assert.assertEquals(searchPage.searchBoxTest(testData), true);
	}

	@Test(priority=1 , description = "TC006")
	public void verifySearchPageTitle(){
		Assert.assertEquals(searchPage.verifySearchTitle() , "MidasMasterSearch");
	}
	@Test
	public void additionalSettingsRequestNumber(){
		Assert.assertEquals(searchPage.verifyAdditionalSettingsRequestNumberSearchPage(prop.getProperty("RequestNumber")), true);
	}
	@Test
	public void additionalSettingsMaterialNumber(){
		Assert.assertEquals(searchPage.verifyAdditionalSettingsMaterialNumberSearchPage(prop.getProperty("MaterialNumber")), true);
	}
	@Test
	public void additionalSettingsManufacturer(){
		Assert.assertEquals(searchPage.verifyAdditionalSettingsManufacturerSearchPage(prop.getProperty("Manufacturer")), true);
	}
	@Test
	public void additionalSettingsPartNumber(){
		Assert.assertEquals( searchPage.verifyAdditionalSettingsPartNumberSearchPage(prop.getProperty("PartNumber")), true);
	}
	@DataProvider
	public String[] getTestData(){
		String sheetName = "TestData";
		String[] data = TestUtil.getTestData1Array(sheetName);
		return data;
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
