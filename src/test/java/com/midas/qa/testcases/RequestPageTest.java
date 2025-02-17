package com.midas.qa.testcases;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.midas.qa.base.TestBase;
import com.midas.qa.pages.HomePage;
import com.midas.qa.pages.LoginPage;
import com.midas.qa.pages.RequestPage;
import com.midas.qa.pages.RequestPreviewPage;
import com.midas.qa.util.TestUtil;

public class RequestPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	RequestPreviewPage requestPreviewPage;
	RequestPage requestPage ;
	SoftAssert softAssert;

	public RequestPageTest(){
		super();
	}

	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));		  	  
		TestUtil.WaitAndSwitchframe(0);
		requestPreviewPage = homePage.clickonRequestIcon();
		requestPage = requestPreviewPage.sudmitNewRequest();
		TestUtil.switchNewWindow();
		softAssert = new SoftAssert();
	}

	@Test(priority=1,enabled = true)
	public void RequestPageTitleTest(){
		String title = requestPage.validateRequestPageTitle();
		Assert.assertEquals(title, "NewRequestCreation");
	}
	@Test(priority=3,enabled = true)
	public void VerifyPrimarySupplier(){
		Assert.assertEquals(requestPage.verifyPrimarySupplier(), true);
	}
	@Test(priority=2,dataProvider = "NounModifier")
	public void VerifyNounAndModifierSelecting(String noun,String discrption){
		Assert.assertEquals(requestPage.VerifyNounAndModifierSelecting(noun), discrption);				 
	}
	@Test(priority=4,dataProvider = "RequestData",groups ="manditary")
	public void VerifyBUOM(String testData){
		Boolean  expResult = requestPage.verifyBUOM(testData);
		Assert.assertTrue(expResult);
	}

	@Test(dataProvider = "NounModifier")
	public void VerifyOriginalDescription(String testData,String discrption){
		requestPage.ScanOrginalDescription(testData);			
		Assert.assertEquals(requestPage.getTextDescription(), discrption);
	}
	@Test(dataProvider = "AttributeTestData")
	public void VerifyNounModifierAttribute(String testData,String attribute){
		requestPage.ScanOrginalDescription(testData);	
		Assert.assertTrue(requestPage.verifyAttributes(attribute));
	}
	@Test()
	public void verifyCriticalScoreTxtBox(){
		requestPage.SelectCriticalMatrix();	
		Assert.assertEquals(requestPage.verifyCriticalScoreTxtBox(),"5");
	}
	@Test()
	public void verifyABCIndicatorTxtBox(){
		requestPage.SelectCriticalMatrix();	
		Assert.assertEquals(requestPage.verifyABCIndicatorTxtBox(),"22");
	}
	@Test()
	public void verifySAPFields(){	
		Assert.assertTrue(requestPage.verifySAPFields());	
	}
	@Test(dataProvider = "RequestData")
	public void verifyTagNumber(String testData){	
		Assert.assertEquals(requestPage.verifyTagNumber(testData),testData);	
	}
	@Test(enabled = false)
	public void verifyAtributeUnits(String testData){	
		Assert.assertTrue(requestPage.verifyAtributeUnits());	
	}
	
	@Test(dataProvider = "RequestData")
	public void verifyDuplicateRequest(String testData){
		requestPage.selectManufacturerPartNumber(testData);
		requestPage.selectBUOMValue();
		requestPage.clickCriticalSpare();
		requestPage.sendTextInCriticalSpareBox("test");
		requestPage.clickStockType();	
		requestPage.sendTextStockTypeTextBox("test");
		requestPage.clickSave();
		softAssert.assertEquals(requestPage.verifyDuplicateWarningmesg(), "Give valid reason to proceed with this Duplicate");
		softAssert.assertTrue(requestPage.acceptDuplicateMesg());
		softAssert.assertAll();  
	}
	@Test(enabled  = false)
	public void VerifyNewRequestCreation(){
		requestPage.clickSave();
		softAssert.assertEquals(requestPage.getWarningMesg(), "Please select the base UOM");
		requestPage.acceptErrorMesg();

		//clear all data 
		requestPage.clickClear();

		// B.UOM
		requestPage.verifyBUOM("EA");
		try {	Thread.sleep(1000);	} catch (InterruptedException e) {}
		requestPage.clickSave();
		softAssert.assertEquals(requestPage.getWarningMesg(), "Please select the critical spare");
		requestPage.acceptErrorMesg();

		//critical spare
		requestPage.clickCriticalSpare();
		requestPage.clickSave();
		softAssert.assertEquals(requestPage.getWarningMesg(), "Please enter the comments in critical spare");
		requestPage.acceptErrorMesg();
		requestPage.sendTextInCriticalSpareBox("test");

		//stocktype
		requestPage.clickStockType();	
		requestPage.clickSave();	
		softAssert.assertEquals(requestPage.getWarningMesg(), "Please enter the comments in stock type");
		requestPage.acceptErrorMesg();
		requestPage.sendTextStockTypeTextBox("test");
		requestPage.clickSave();
		softAssert.assertEquals(requestPage.getWarningMesg(), "Please Fill The Original Description");

		//orginal description
		requestPage.sendtextOrginalDescriptionTextBox("test");
		requestPage.clickSave();
		softAssert.assertEquals(requestPage.getWarningMesg(), "Material Group\n"	
				+ "Material Type");
		requestPage.acceptErrorMesg();
		try {	Thread.sleep(1000);	} catch (InterruptedException e) {}
		//material group 
		requestPage.acceptErrorMesg();
		requestPage.selectMaterialGroup();
		System.err.println("Test1");
		try {	Thread.sleep(1000);	} catch (InterruptedException e) {}
		requestPage.clickSave();
		softAssert.assertEquals(requestPage.getWarningMesg(), "Material Group");
		//	softAssert.assertEquals(requestPage.getWarningMesg(), "Material Type");
		
		//verify invalid manufact name 
		softAssert.assertEquals(requestPage.verifyManufactrarValidName("dummy name"),"Manufacturer is not valid");
		requestPage.acceptErrorMesg();		
		
		requestPage.sendToApproval();
		softAssert.assertAll();            
	}

	@DataProvider(name = "AttributeTestData")
	public Object[][] getAttributeTestData(){
		String sheetName = "AttributeTestData";
		return TestUtil.getTestData(sheetName);
	}
	@DataProvider(name = "NounModifier")
	public Object[][] getTestData(){
		String sheetName = "NounModifier";
		return TestUtil.getTestData(sheetName);
	}
	@DataProvider(name = "RequestData")
	public String[] getTestData(Method method){
		String sheetName = "RequestData";
		String coloumn = method.getName();

		if (coloumn.equals("VerifyBUOM") || coloumn.equals("VerifyNewRequestCreation")) {
			coloumn = coloumn.replace(coloumn, "B.UOM");
		}if (coloumn.equals("verifyDuplicateRequest")) {
			coloumn = coloumn.replace(coloumn, "Duplicate Manufacturer part number");
		}if (coloumn.equals("verifyTagNumber")) {
			coloumn = coloumn.replace(coloumn, "Tag Number");
		}

		Object[] data = TestUtil.readColumnData(sheetName,coloumn);
		String[] stringData = Arrays.copyOf(data, data.length, String[].class);    
		return stringData;	
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
} 
