package com.midas.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.midas.qa.base.TestBase;
import com.midas.qa.util.TestUtil;

public class RequestFlowPage extends TestBase{


	@FindBy(xpath="//button[text()=\"Confirm\"]")
	WebElement confirmBtn;

	@FindBy(xpath="/html/body/div[14]/div[1]/div/a")
	WebElement RequestPreviewClose;	

	@FindBy(xpath="//input[@id='btnSubmit']")
	WebElement sudmitBtn;

	@FindBy(xpath="//*[@id='pageContainer']")
	WebElement IframeOfSingleRequest;

	@FindBy(xpath="//input[@aria-owns='MaterialType_listbox']")
	WebElement materialTypetextBox;

	@FindBy(xpath="//*[@id=\"MaterialType_listbox\"]/li")
	WebElement materialTypeList;

	@FindBy(xpath="//input[@aria-describedby=\"Plant_taglist\"]")
	WebElement planttextBox;

	@FindBy(xpath="(//span[@class=\"k-icon k-i-arrow-60-down\"])[4]")
	WebElement NMQTypeDropDown;

	@FindBy(xpath="//input[@aria-owns='PartNumber_listbox']")
	WebElement PartNumbertextBox;

	@FindBy(xpath="//*[@id='PartNumber_listbox']/li")
	WebElement partNumberOptions;

	@FindBy(xpath="//input[@id='Manufacturer']")
	WebElement manufacturtextBox;

	@FindBy(xpath="//span[contains(text(),'Modify Request')]")
	WebElement changeRequest;

	@FindBy(xpath="//span[contains(text(),'New Request')]")
	WebElement newrequest;

	@FindBy(xpath="//span[@aria-label='open']")
	WebElement PlantNumber;

	@FindBy(xpath="//input[@role='listbox']")
	WebElement plantTextBox;

	@FindBy(xpath="//input[@id='Modify_MaterialNumber']")
	WebElement ChangeaterialNumber;
	
	@FindBy(xpath="//span[text()='Extend Plant']")
	WebElement extendRequest;
	
	@FindBy(xpath="//input[@id=\"Extended_MaterialNumber\"]")
	WebElement exteandmatNo;

	public RequestFlowPage(){
		PageFactory.initElements(driver, this);
	}

	public boolean closeRequestOptionsMenu() {	
		TestUtil.WaitAndSwitchframe(IframeOfSingleRequest);
		TestUtil.waitAndClickElement(RequestPreviewClose);		
		return true;
	}

	public void openNewRequest(String requestType, String plant, String partNumber,String materialType, String NMQType, String RequestModule, String RequestTo) {
		TestUtil.waitAndClickElement(newrequest);
		TestUtil.waitAndClickElement(NMQTypeDropDown);
	
		TestUtil.waitAndClickElement(driver.findElement(By.xpath("//li[normalize-space()='"+NMQType+"']")));
		if (NMQType.equalsIgnoreCase("oem")) {
			driver.findElement(By.xpath("//input[@id=\"Manufacturer\"]")).sendKeys("*");
			driver.findElement(By.xpath("//li[@class=\"ApprovedFlag ui-menu-item\"]")).click();
		}else if (!NMQType.equalsIgnoreCase("Generic")) {

			PartNumbertextBox.sendKeys(TestUtil.getRandomNumericString(8));
			PartNumbertextBox.sendKeys(Keys.ENTER);
		} else if (NMQType.equalsIgnoreCase("Fabricated")) {

		}
		materialTypetextBox.sendKeys(materialType);
		TestUtil.waitAndClickElement(materialTypeList);
		PartNumbertextBox.sendKeys(TestUtil.getRandomNumericString(8));
		PartNumbertextBox.sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//span[text()='New Request']"));
		TestUtil.waitAndClickElement(driver.findElement(By.xpath("//label[text()='"+RequestModule+"']")));
		TestUtil.waitAndClickElement(driver.findElement(By.xpath("//label[text()='"+RequestTo+"']")));		

		PlantNumber.click();
		plantTextBox.sendKeys(plant);
		TestUtil.waitAndClickElement(driver.findElement(By.xpath("//li[contains(text(),'"+plant+"')]")));

		sudmitBtn.click();
		try {	Thread.sleep(800);} catch (InterruptedException e) {}
		TestUtil.switchNewWindow();
	}

	public void openChangeRequest(String requestType, String plant, String partNumber, String materialType, String NMQType, String requestModule, String requestTo, String materialNumber) {
		TestUtil.waitAndClickElement(changeRequest);

		ChangeaterialNumber.sendKeys(materialNumber);
		TestUtil.waitAndClickElement(driver.findElement(By.xpath("//li[contains(text(),'"+materialNumber+"')]")));
		TestUtil.waitAndClickElement(sudmitBtn);

		try {	Thread.sleep(800);} catch (InterruptedException e) {}
		TestUtil.switchNewWindow();
	}

	public void ExtendRequest(String requestType, String plant, String partNumber, String materialType, String nMQType,
			String requestModule, String requestTo, String materialNumber) {
	
		TestUtil.waitAndClickElement(extendRequest);

		exteandmatNo.sendKeys(materialNumber);
		TestUtil.waitAndClickElement(driver.findElement(By.xpath("//li[contains(text(),'"+materialNumber+"')]")));
		
		plantTextBox.sendKeys(plant);
		TestUtil.waitAndClickElement(driver.findElement(By.xpath("//li[contains(text(),'"+plant+"')]")));
		TestUtil.waitAndClickElement(sudmitBtn);

		try {	Thread.sleep(800);} catch (InterruptedException e) {}
		TestUtil.switchNewWindow();
	}
	
}

