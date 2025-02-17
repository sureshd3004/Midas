package com.midas.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.midas.qa.base.TestBase;
import com.midas.qa.pages.HomePage;
import com.midas.qa.pages.LoginPage;
import com.midas.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;

<<<<<<< HEAD

=======
>>>>>>> 2ba595c (updates)
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
<<<<<<< HEAD
	}
	
=======
	}	
>>>>>>> 2ba595c (updates)
	
	@Test(priority=1,enabled = true,description = "TC001")
	public void verifyHomePageTitleTest(){
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "ssruat.infoplusmdm","Home page title not matched");
<<<<<<< HEAD
	}
=======
		
	}
	@Test(priority=2)
	public void verifyuserName(){	
		Assert.assertTrue(homePage.validateUserName());		
	}
	
>>>>>>> 2ba595c (updates)
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
