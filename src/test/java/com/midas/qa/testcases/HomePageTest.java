package com.midas.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.midas.qa.base.TestBase;
import com.midas.qa.pages.HomePage;
import com.midas.qa.pages.LoginPage;
import com.midas.qa.util.Log;
import com.midas.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Log.info("Test Starts");
	}	
	
	@Test(priority=1,enabled = true,description = "TC001")
	public void verifyHomePageTitleTest(){		
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "ssruat.infoplusmdm","Home page title not matched");		
	}
	
	@Test()
	public void verifyuserName(){	
		Assert.assertTrue(homePage.validateUserName());		
	}
	
	@AfterMethod
	public void tearDown(){
		Log.info("Test Ends");
		driver.quit();
	}
}
