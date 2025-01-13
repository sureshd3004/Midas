package com.midas.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.midas.qa.base.TestBase;
import com.midas.qa.pages.LoginPage;
import com.midas.qa.util.TestUtil;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
//	HomePage homePage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "HomePage");
	}
	
	@Test(priority=2,enabled = true)
	public void LogoImageTest(){
		boolean logo = loginPage.validateImage();
		Assert.assertTrue(logo);
		
	}
	
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
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
