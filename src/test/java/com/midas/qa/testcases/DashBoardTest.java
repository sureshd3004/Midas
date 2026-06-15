package com.midas.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.midas.qa.base.TestBase;
import com.midas.qa.pages.DashboardPage;
import com.midas.qa.pages.HomePage;
import com.midas.qa.pages.LoginPage;
import com.midas.qa.util.TestUtil;

public class DashBoardTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	DashboardPage dashboardPage;
	
	public DashBoardTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		dashboardPage = new DashboardPage();
	}	
	
	@Test(priority=1,enabled = true,description = "TC001")
	public void verifyDashboardBoxesCount(){
		 dashboardPage.verifyCountOfBoxes();
		
	}
		
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
