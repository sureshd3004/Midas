package com.midas.qa.testcases;

import java.lang.reflect.Method;
import java.util.Arrays;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.midas.qa.base.TestBase;
import com.midas.qa.pages.HomePage;
import com.midas.qa.pages.LoginPage;
import com.midas.qa.pages.RequestPreviewPage;
import com.midas.qa.util.TestUtil;

public class RequestPreviewPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	RequestPreviewPage requestPreviewPage;

	public RequestPreviewPageTest(){
		super();
	}

	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));		  	  
		TestUtil.WaitAndSwitchframe(0);
		requestPreviewPage = homePage.clickonRequestIcon();
	}
	@Test(enabled = true)
	public void sudmitNewRequest() { 
		Assert.assertEquals(requestPreviewPage.sudmitNewRequest(), "NewRequestCreation");
	}

	@Test(enabled = false)
	public void closeRequestOptionsMenu() { 
		Assert.assertEquals(requestPreviewPage.closeRequestOptionsMenu(), true);
	}

	@DataProvider(name = "getTestData")
	public String[] getTestData(Method method){
		String sheetName = "SearchData";
		String coloumn = method.getName();
		Object[] data = TestUtil.readColumnData(sheetName,coloumn);
		// Convert Object[] to String[]
		String[] stringData = Arrays.copyOf(data, data.length, String[].class);    
		return stringData;
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
