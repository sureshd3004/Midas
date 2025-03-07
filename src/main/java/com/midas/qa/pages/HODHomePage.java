package com.midas.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.midas.qa.base.TestBase;
import com.midas.qa.util.TestUtil;

public class HODHomePage extends TestBase{

	//Page Factory - OR:
	@FindBy(xpath="//input[@id=\"MultiApproval\"]")
	WebElement approveBtn;	

	@FindBy(xpath="//button[@type=\"button\"]")
	WebElement confirmBtn;

	@FindBy(xpath="//input[@id='MultiReject']")
	WebElement rejectBtn;

	@FindBy(xpath = "//td[@data-field=\"RequestCreationId\"]")
	WebElement viewBtn;

	@FindBy(xpath="//span[@id=\"filter_data\"]")
	WebElement filterBtn;

	@FindBy(xpath="//input[@id=\"MultiApproval\"]")
	WebElement approve;

	@FindBy(xpath="//div[@id=\"NewRequestClick\"]")
	WebElement newBox;
	
	@FindBy(xpath="//div[@id=\"ChangeReqClick\"]")
	WebElement changeBox;
	
	@FindBy(xpath="//button[@class=\"btn btn-default\"]")
	WebElement confirm;
	
	@FindBy(xpath="//div[@id=\"ExtensionReqClick\"]")
    WebElement extandBox;
	//Initializing the Page Objects:
	public HODHomePage(){
		PageFactory.initElements(driver, this);
	}

	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}

	public void clickApproveBtn(){
		approveBtn.click();
	}

	public void acceptNewRequest(String testData) {
		
		TestUtil.waitAndClickElement(newBox);
		for (int i = 1; i < 10000; i++) {				
		String RequestID = driver.findElement(By.xpath("//tbody[@role='rowgroup']/tr["+i+"]/td[6]")).getText();
		
		if (RequestID.contains(testData)) {
			WebElement row = driver.findElement(By.xpath("//tbody[@role='rowgroup']/tr["+i+"]/td[1]/input"));
			TestUtil.waitAndClickElement(row);
			TestUtil.waitAndClickElement(approve);
			TestUtil.waitAndClickElement(confirm);
			break;
		}
	}}
	public void acceptChangeRequest(String testData) {
		
		TestUtil.waitAndClickElement(changeBox);
		for (int i = 1; i < 10000; i++) {				
		String RequestID = driver.findElement(By.xpath("//tbody[@role='rowgroup']/tr["+i+"]/td[6]")).getText();
		
		if (RequestID.contains(testData)) {
			WebElement row = driver.findElement(By.xpath("//tbody[@role='rowgroup']/tr["+i+"]/td[1]/input"));
			TestUtil.waitAndClickElement(row);
			TestUtil.waitAndClickElement(approve);
			TestUtil.waitAndClickElement(confirm);
			break;
		}
	}}

	public void acceptExtendRequest(String testData) {
		TestUtil.waitAndClickElement(extandBox);
		for (int i = 1; i < 10000; i++) {				
		String RequestID = driver.findElement(By.xpath("//tbody[@role='rowgroup']/tr["+i+"]/td[6]")).getText();
		
		if (RequestID.contains(testData)) {
			WebElement row = driver.findElement(By.xpath("//tbody[@role='rowgroup']/tr["+i+"]/td[1]/input"));
			TestUtil.waitAndClickElement(row);
			TestUtil.waitAndClickElement(approve);
			TestUtil.waitAndClickElement(confirm);
			break;
		}
	}
		
	}
	


}
