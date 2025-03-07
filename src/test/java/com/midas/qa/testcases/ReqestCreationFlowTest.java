package com.midas.qa.testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.midas.qa.base.TestBase;
import com.midas.qa.pages.HomePage;
import com.midas.qa.pages.LoginPage;
import com.midas.qa.pages.RequestFlowPage;
import com.midas.qa.pages.RequestPage;
import com.midas.qa.util.TestUtil;

public class ReqestCreationFlowTest extends TestBase {
	LoginPage loginPage;
    RequestFlowPage requestFlowPage;
    HomePage homePage;
    RequestPage requestPage;
    
	public ReqestCreationFlowTest() {
		super();
	}

	@BeforeClass
	public void setUp() {
		initialization();		
		 requestPage = new RequestPage();
		 requestFlowPage = new RequestFlowPage();
	}	

	@Test(dataProvider = "getloginData", priority = 1, invocationCount = 1)
	public void login(String userName, String password){	
		loginPage = new LoginPage();
		homePage = new HomePage();
	
	//	System.err.println("userid and password is ="+ userName + password);
		loginPage.login(userName, password);  	  		
		TestUtil.WaitAndSwitchframe(0);		
		homePage.clickonRequestIcon();
	}

	@Test(dataProvider = "getRequestData", dependsOnMethods = "login")
	public void openNewRequest(String requestType, String plant, String partNumber,String materialType, String NMQType, String RequestModule, String RequestTo, String ValuationType){	
		
		requestFlowPage.openNewRequest(requestType, plant, partNumber, materialType, NMQType, RequestModule, RequestTo);
		do { 		TestUtil.switchNewWindow();
		} while (driver.getCurrentUrl().equalsIgnoreCase("https://ssruat.infoplusmdm.com/Home/MasterLayout"));
		requestPage.selectBUOMValue();
		requestPage.selectMaterialGroup();
		requestPage.sendtextOrginalDescriptionTextBox(plant+"  "+materialType+"  "+NMQType);
		requestPage.clickStockType("No");
		requestPage.clickCriticalSpare("No");
		requestPage.VerifyNounAndModifierSelecting();
		
		if (materialType.contains("ZROT")) {
			requestPage.selectValuationType(ValuationType);			
		}
		requestPage.clickSave();
		try {	Thread.sleep(1234); 	} catch (InterruptedException e) {	}

		requestPage.clickSendToApprov();
		do { 		TestUtil.switchNewWindow();
		} while (driver.getCurrentUrl().equalsIgnoreCase("https://ssruat.infoplusmdm.com/Request/RequestCreation"));
		
		TestUtil.WaitAndSwitchframe(driver.findElement(By.xpath("//iframe[@id='pageContainer']")));
		driver.findElement(By.xpath("//div[@rel='approver-to-do']")).click();
		String requestID = driver.findElement(By.xpath("//td[@data-field='RequestNumber']")).getText();
		TestUtil.sendValueToExcel("RequestNo","New Request Number",requestID);		
		System.err.println("id is = "+requestID);
	}       
	@Test(dataProvider = "getRequestData", dependsOnMethods = "login")
	public void openChangeRequest(String requestType, String plant, String partNumber,String materialType, String NMQType, String RequestModule, String RequestTo, String ValuationType, String materialNumber){	
		
		requestFlowPage.openChangeRequest(requestType, plant, partNumber, materialType, NMQType, RequestModule, RequestTo, materialNumber);
		do { 		TestUtil.switchNewWindow();
		} while (driver.getCurrentUrl().equalsIgnoreCase("https://ssruat.infoplusmdm.com/Home/MasterLayout"));
		
		requestPage.clickSendToApprov();
		
		do { 		TestUtil.switchNewWindow();
		} while (driver.getCurrentUrl().equalsIgnoreCase("https://ssruat.infoplusmdm.com/Request/RequestCreation"));
		
		TestUtil.WaitAndSwitchframe(driver.findElement(By.xpath("//iframe[@id='pageContainer']")));
		driver.findElement(By.xpath("//div[@rel=\"approver-to-do\"]")).click();
		String requestID = driver.findElement(By.xpath("//td[@data-field='RequestNumber']")).getText();
		TestUtil.sendValueToExcel("RequestNo","New Request Number",requestID);		
		System.err.println("id is = "+requestID);
	}   
	@Test(dataProvider = "getRequestData", dependsOnMethods = "login")
	public void ExtendRequest(String requestType, String plant, String partNumber,String materialType, String NMQType, String RequestModule, String RequestTo, String ValuationType, String materialNumber){	
		
		requestFlowPage.ExtendRequest(requestType, plant, partNumber, materialType, NMQType, RequestModule, RequestTo, materialNumber);
		do { 		TestUtil.switchNewWindow();
		} while (driver.getCurrentUrl().equalsIgnoreCase("https://ssruat.infoplusmdm.com/Home/MasterLayout"));
		
		requestPage.clickSendToApprov();
		
		do { 		TestUtil.switchNewWindow();
		} while (driver.getCurrentUrl().equalsIgnoreCase("https://ssruat.infoplusmdm.com/Request/RequestCreation"));
		
		TestUtil.WaitAndSwitchframe(driver.findElement(By.xpath("//iframe[@id='pageContainer']")));
		driver.findElement(By.xpath("//div[@rel=\"approver-to-do\"]")).click();
		String requestID = driver.findElement(By.xpath("//td[@data-field='RequestNumber']")).getText();
		TestUtil.sendValueToExcel("RequestNo","New Request Number",requestID);		
		System.err.println("id is = "+requestID);
	}   
	@DataProvider(name = "getloginData")
	public Object[][] getTestData() throws IOException{
		String sheetName = "login";		
		String role = prop.getProperty("CreatorRole");	
	//	System.out.println("role is = "+role);
		return TestUtil.getTestDataBasedColoumn(sheetName, role);
	}

	@DataProvider(name = "getRequestData")
	public Object[][] getRequestData(Method method) throws IOException {
	    String sheetName = "RequestFlow";
	    String column = method.getName();

	    if (column.contains("New")) {
	        column = "New"; // Fix column selection logic
	    }else if(column.contains("Change")) {
	    	 column = "Change";
		}else if(column.contains("Extend")){
			 column = "Extend";
		}

	    // Fetch row data
	    Object[] data = TestUtil.getRowDataByFirstColumnValue(sheetName, column);

	    // Convert all data to String
	    String[] stringData = Arrays.stream(data)
	            .map(obj -> obj != null ? String.valueOf(obj) : "") // Convert all objects to String
	            .toArray(String[]::new);

	    // Return as Object[][] for TestNG
	    return new Object[][] { stringData }; // Wrap in 2D array 
	}

	@AfterClass
	public void tearDown(){
		driver.quit();
	}

}
