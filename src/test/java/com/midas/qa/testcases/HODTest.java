package com.midas.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.midas.qa.base.TestBase;
import com.midas.qa.pages.HomePage;
import com.midas.qa.pages.LoginPage;
import com.midas.qa.pages.RequestPage;
import com.midas.qa.pages.RequestPreviewPage;
import com.midas.qa.util.TestUtil;

public class HODTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	RequestPreviewPage requestPreviewPage;
	RequestPage requestPage ;
	SoftAssert softAssert;
	RequestPageTest requestPageTest;

	public HODTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(TestBase.getUsername("HOD"), TestBase.getPassword("HOD"));
		TestUtil.WaitAndSwitchframe(0);
		requestPreviewPage = homePage.clickonRequestIcon();
		requestPage = requestPreviewPage.sudmitNewRequest();
		TestUtil.switchNewWindow();
		 requestPageTest = new RequestPageTest();
		 requestPageTest.
	}	
	
	@Test(priority=1, enabled = true, description = "TC001")
	public void verifyHomePageTitleTest(){
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "ssruat.infoplusmdm","Home page title not matched");
		
	}
	@Test(priority=2)
	public void verifyuserName(){	
		Assert.assertTrue(homePage.validateUserName());		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
