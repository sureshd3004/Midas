package com.midas.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.midas.qa.base.TestBase;
import com.midas.qa.pages.DataOfMaterialNo;
import com.midas.qa.pages.HomePage;
import com.midas.qa.pages.LoginPage;
import com.midas.qa.pages.SearchPage;
import com.midas.qa.util.TestUtil;

public class InventorySCMFieldsTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	SearchPage searchPage;
	DataOfMaterialNo DataOfMaterialNoPage;
	
	public InventorySCMFieldsTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		searchPage = new SearchPage();
		loginPage = new LoginPage();
		DataOfMaterialNoPage = new DataOfMaterialNo();
		homePage = loginPage.login("Anagold Inventory", "Welcome@123");
		
	}
	
	@Test()
	public void takeDataFromMaterialNo() throws IOException{	
		String testData="1020032";
		String requestType = "New";
		driver.findElement(By.xpath("//label[text()='"+requestType+"']")).click();
		
		for (int i = 1; i < 10000; i++) {				
		String RequestID = driver.findElement(By.xpath("//tbody[@role=\"rowgroup\"]//child::td["+i+"]")).getText();
		
		if (RequestID.contains(testData)) {
			WebElement row = driver.findElements(By.xpath("//b[@class='ERPRequestcls']")).get(i);
			TestUtil.waitAndClickElement(row);	
			break;
		}
	}
					
	}
	
	
}
