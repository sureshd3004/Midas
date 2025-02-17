package com.midas.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.midas.qa.base.TestBase;
import com.midas.qa.util.TestUtil;

public class RequestPreviewPage extends TestBase{


	@FindBy(xpath="//button[text()=\"Confirm\"]")
	WebElement confirmBtn;

	@FindBy(xpath="/html/body/div[14]/div[1]/div/a")
	WebElement RequestPreviewClose;	

	@FindBy(xpath="//input[@id='btnSubmit']")
	WebElement sudmitBtn;

	@FindBy(xpath="//*[@id=\"pageContainer\"]")
	WebElement IframeOfSingleRequest;

	@FindBy(xpath="//input[@aria-owns=\"MaterialType_listbox\"]")
	WebElement materialTypetextBox;

	@FindBy(xpath="//*[@id=\"MaterialType_listbox\"]/li")
	WebElement materialTypeList;

	@FindBy(xpath="//input[@aria-describedby=\"Plant_taglist\"]")
	WebElement planttextBox;

	@FindBy(xpath="(//span[@class=\"k-icon k-i-arrow-60-down\"])[5]")
	WebElement NMQTypeDropDown;

	@FindBy(xpath="//input[@aria-owns='PartNumber_listbox']")
	WebElement PartNumbertextBox;

	@FindBy(xpath="//*[@id='PartNumber_listbox']/li")
	WebElement partNumberOptions;

	@FindBy(xpath="//input[@id='Manufacturer']")
	WebElement manufacturtextBox;
	
	@FindBy(xpath="//span[@data-tab='Extended_MaterialNumber']")
	WebElement materialNumberErrorMesg;

	public RequestPreviewPage(){
		PageFactory.initElements(driver, this);
	}

	public boolean closeRequestOptionsMenu() {	
		TestUtil.WaitAndSwitchframe(IframeOfSingleRequest);
		TestUtil.waitAndClickElement(RequestPreviewClose);		
		return true;
	}

	public RequestPage sudmitNewRequest() {

		PartNumbertextBox.sendKeys("*");
		TestUtil.waitAndClickElement(partNumberOptions);
		materialTypetextBox.sendKeys("*");
		TestUtil.waitAndClickElement(materialTypeList);
		try {	Thread.sleep(800);} catch (InterruptedException e) {}
		sudmitBtn.click();
		try {	Thread.sleep(800);} catch (InterruptedException e) {}
		return new RequestPage();
	}	
}
