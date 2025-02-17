package com.midas.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
<<<<<<< HEAD
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.midas.qa.base.TestBase;
import com.midas.qa.pages.LoginPage;
import com.midas.qa.util.TestUtil;
=======
import org.testng.annotations.Test;
import com.midas.qa.base.TestBase;
import com.midas.qa.pages.HomePage;
import com.midas.qa.pages.LoginPage;
>>>>>>> 2ba595c (updates)

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
<<<<<<< HEAD
//	HomePage homePage;
=======
	HomePage homePage;
>>>>>>> 2ba595c (updates)
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
	}
	
<<<<<<< HEAD
	@Test(priority=1)
=======
	@Test(priority=1,enabled = false)
>>>>>>> 2ba595c (updates)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "HomePage");
	}
	
	@Test(priority=2,enabled = true)
	public void LogoImageTest(){
		boolean logo = loginPage.validateImage();
		Assert.assertTrue(logo);
		
	}
	
<<<<<<< HEAD
	@Test(priority=3, dataProvider="getTestData")
	public void loginTest(String userid, String password){
		loginPage.login(userid, password);
//		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@DataProvider
	public Object[][] getTestData(){
		String sheetName = "login";
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
=======
	@Test(priority=3)
	public void loginTest(String userid, String password){
		loginPage.login(userid, password);
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}	
		
>>>>>>> 2ba595c (updates)
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
