package com.midas.qa.testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.midas.qa.base.TestBase;
import com.midas.qa.pages.HODHomePage;
import com.midas.qa.pages.LoginPage;
import com.midas.qa.pages.RequestPage;
import com.midas.qa.pages.RequestPreviewPage;
import com.midas.qa.util.TestUtil;

public class HODHomeTest extends TestBase {
	
	LoginPage loginPage;
	HODHomePage HODhomePage;
	RequestPreviewPage requestPreviewPage;
	RequestPage requestPage ;
	SoftAssert softAssert;
	RequestPageTest requestPageTest;

	public HODHomeTest() {
		super();
	}

	@BeforeClass
	public void setUp() {
		initialization();		
	}	

	@Test(dataProvider = "getloginData", priority = 1)
	public void login(String userName, String password){	
		loginPage = new LoginPage();
		loginPage.login(userName, password);  	  		
		TestUtil.WaitAndSwitchframe(0);		
	}

	@Test(dataProvider = "getTestData", dependsOnMethods = "login")
	public void acceptNewRequest(String testData){	
		HODhomePage = new HODHomePage();
		HODhomePage.acceptNewRequest(testData);		
	}   
	@Test(dataProvider = "getTestData", dependsOnMethods = "login")
	public void acceptExtendRequest(String testData){	
		HODhomePage = new HODHomePage();
		HODhomePage.acceptExtendRequest(testData);		
	}
	@Test(dataProvider = "getTestData", dependsOnMethods = "login")
	public void acceptChangeRequest(String testData){	
		HODhomePage = new HODHomePage();
		HODhomePage.acceptChangeRequest(testData);		
	}
	@DataProvider(name = "getloginData")
	public Object[][] getTestData() throws IOException{
		String sheetName = "login";		
		String role = prop.getProperty("HODrole");		
		return TestUtil.getTestDataBasedColoumn(sheetName, role);
	}

	@DataProvider(name = "getTestData")
	public Object[] getTestData(Method method){
		String sheetName = "RequestNo";
		String coloumn = method.getName();
		if (coloumn.equalsIgnoreCase("acceptNewRequest") || coloumn.equalsIgnoreCase("acceptChangeRequest") || coloumn.equalsIgnoreCase("acceptExtendRequest")) {
			 coloumn = coloumn.replace(coloumn, "New Request Number");
		}
		Object data = TestUtil.readColumnLastData(sheetName,coloumn);
		 return new Object[]{data};
	}
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
}
