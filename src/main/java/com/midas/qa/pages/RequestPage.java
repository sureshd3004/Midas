package com.midas.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.midas.qa.base.TestBase;
import com.midas.qa.util.TestUtil;

public class RequestPage  extends TestBase{

	public RequestPage(){
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[@id=\"NMQ\"]")
	WebElement nounModifierBox;

	@FindBy(xpath="//li[@class='ApprovedNoun ui-menu-item']")
	WebElement nounModifierResult;

	@FindBy(xpath="//div[@class='m-0']//p[@id='lblNMQDesr']")
	WebElement nounModifierResultDiscription;

	@FindBy(xpath="//*[@id='tblNMQAttributegrid']/tbody/tr")
	List<WebElement> NounModiferAttribute;
	
	@FindBy(xpath="//*[@id='tblNMQAttributegrid']/tbody/tr/td[6]/div/span/input")
	List<WebElement> attributeValueList;

	@FindBy(xpath="//i[@class='fa fa-external-link addNewValue']")
	List<WebElement> ValueOptionList;
	
	@FindBy(xpath="//input[@value='Save To Draft']")
	WebElement saveToDraft;

	@FindBy(xpath="//input[@class=\"ClassToUpper ui-autocomplete-input\" and @id='UOM']")
	WebElement bUOMTextBox;

	@FindBy(xpath="(//*[@class=\"ui-menu-item\"])[1]")
	WebElement UOMResults;

	@FindBy(xpath="//*[text()='No planning ']")
	WebElement MRPTypeResults;

	@FindBy(xpath="//textarea[contains(@class, 'ClassToUpper')]")
	WebElement OriginalDescriptionText;

	@FindBy(xpath="//input[@id='ScanDesc']")
	WebElement scanBtn;

	@FindBy(xpath="//label[@for='CriSpare_Yes']")
	WebElement CriticalSpareYes;

	@FindBy(xpath="//textarea[@id='Critical_Spare_Value']")
	WebElement CriticalSpareTextBox;

	@FindBy(xpath="//label[@for='CriSpare_No']")
	WebElement CriticalSpareNo;

	@FindBy(xpath="//label[@class=\"select-label-no\"])[2]")
	WebElement StocktypeOnDemand;

	@FindBy(xpath="//label[@for='Stock_Yes']")
	WebElement stockTypeStock;

	@FindBy(xpath="//textarea[@id='Stock_NonStock_Value']")
	WebElement stockTypeTextBox;

	@FindBy(xpath="//label[normalize-space()='1000']")
	WebElement materialGroupResults;

	@FindBy(xpath="//input[@clientlabel='Material_Group']")
	WebElement materialGroupTextBox;

	@FindBy(xpath="//input[@id='SupplierPartNumber']")
	List<WebElement> supplierPartNumberTextBox;

	@FindBy(xpath="//*[@id='SupplierPartNumber_listbox']/li[2]")
	WebElement supplierPartNumberResult;

	@FindBy(xpath="//input[@id='Supplier']")
	WebElement SupplierTextBox;

	@FindBy(xpath="//*[@id='ui-id-18']")
	WebElement supplierResult;

	@FindBy(xpath="//input[@id='PrimarySupplierID']")
	WebElement primarySupplierOption;

	@FindBy(xpath="//*[@id='tblNMQAttributegrid']/tbody")
	WebElement attributeList;

	@FindBy(xpath="//div[@class='jconfirm-content']")
	WebElement alertMesg;

	@FindBy(xpath="//button[@class=\"btn btn-default\"]")
	WebElement okBtnForErrer;

	@FindBy(xpath="//input[@id='btnReset']")
	WebElement clearbtn;

	@FindBy(xpath="//input[@id='criticalityMatrixBtn']")
	WebElement criticalMatrixBtn;

	@FindBy(xpath="//tbody[@id='criticaltbody']/tr/td")
	List<WebElement> criticalMatrixOptions;

	@FindBy(xpath="//tbody[@id='probabilityScoreAppend']/tr/td")
	List<WebElement> probabilityScoreOptions;

	@FindBy(xpath="//input[@id='closeCriticality']")
	WebElement criticalClose;

	@FindBy(xpath="//input[@id=\"1251_3_ERP\"]")
	WebElement criticalScoreTxtBox;

	@FindBy(xpath="//input[@id=\"38_3_ERP\"]")
	WebElement ABCIndicatorTxtBox;

	@FindBy(xpath="//div[@class=\"k-content k-window-content k-dialog-content\"]")
	WebElement duplicateWarningMsg;

	@FindBy(xpath="//input[@class='k-textbox']")
	WebElement duplicateWarningTextBox;

	@FindBy(xpath="//button[normalize-space()='OK']")
	WebElement okBtnForDuplicateWarrning;

	@FindBy(xpath="//img[@class=\"rc_img_w rc_img_hide duplicate_flag\"]")
	WebElement duplicateFlag;

	@FindBy(xpath="//input[@id='PartNumber']")
	WebElement manufactPartNumberTxtBox;

    @FindBy(xpath="//li[@class='col-xs-2' ]/div")
    List<WebElement> sapFieldTextBoxes;
    
    @FindBy(xpath="//input[@id='Tagnumber']")
    WebElement tagTextBox;
    
    @FindBy(xpath="//input[@id='btnTabAdd']")
    WebElement addbtnForTagValue;
    
    @FindBy(xpath="//td[@class=\"TagNumberValues\"]")
    WebElement tagNumberResult;
    
    @FindBy(xpath="//tbody/tr[1]/td[2]/i")
    WebElement delTagNumber;
    
    @FindBy(xpath="//*[@id='btnApprove']")
    WebElement sendToApproval;
    
    @FindBy(xpath="//input[@value='Description Preview']")
    WebElement descriptionPreview;
    
    @FindBy(xpath="//input[@id=\"Manufacturer\"]")
    WebElement manufacturarNameTextBox;
    
    @FindBy(xpath="//div[@class='jconfirm-content']")
    WebElement manufactrarNameErrorMesg;

	public String validateRequestPageTitle(){
		try {	Thread.sleep(1200);} catch (InterruptedException e) {}
		return driver.getTitle();
	}

	public String VerifyNounAndModifierSelecting() {
		nounModifierBox.sendKeys("*");
		TestUtil.waitAndClickElement(nounModifierResult);
		return nounModifierResultDiscription.getText();
	}
	public void selectBUOMValue() {
		bUOMTextBox.sendKeys("*");
		UOMResults.click();     
	}
	public void ScanOrginalDescription(String testData) {
		OriginalDescriptionText.sendKeys(testData);
		try {   Thread.sleep(1000);	} catch (InterruptedException e) {}
		TestUtil.waitAndClickElement(scanBtn);		
	}
	public void clickCriticalSpare(String value) {
		driver.findElement(By.xpath("//label[@for='CriSpare_"+value+"']")).click();
	//	CriticalSpareYes.click();
	}
	public void clickStockType(String value) {
		driver.findElement(By.xpath("//label[@for='Stock_"+value+"']")).click();
	//	stockTypeStock.click();
	}
	public void clickSave() {
		TestUtil.scrollAndClick(saveToDraft);
	}
	public void clickSendToApprov() {
		
		TestUtil.scrollAndClick(sendToApproval);
	}
	public void acceptErrorMesg() {
		TestUtil.waitAndClickElement(okBtnForErrer);
	}
	public void selectMaterialGroup() {
		materialGroupTextBox.sendKeys("*");
		TestUtil.waitAndClickElement(materialGroupResults);
	}

	public boolean verifyPrimarySupplier() {
		supplierPartNumberTextBox.get(0).sendKeys("*");
		supplierPartNumberResult.click();
		SupplierTextBox.sendKeys("*");
		supplierResult.click();
		return primarySupplierOption.isEnabled();
	}

	public Boolean verifyBUOM(String testData) {
		bUOMTextBox.sendKeys(testData);
		boolean actResult = UOMResults.getText().contains(testData);
		UOMResults.click();
		return actResult;	
	}
	public String getTextDescription() {
		return	TestUtil.waitAndGetText(nounModifierResultDiscription);
	}
	public String getAttributes() {

		return	TestUtil.waitAndGetText(attributeList);
	}
	public boolean verifyAttributes(String attributes) {

		boolean allMatch = true;

		for (WebElement element : NounModiferAttribute) {
			if (!attributes.contains(element.getText())) {
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public String getWarningMesg() {
		return alertMesg.getText();
	}

	public void sendTextInCriticalSpareBox(String testData) {
		CriticalSpareTextBox.sendKeys(testData);
	}

	public void sendTextStockTypeTextBox(String testData) {
		stockTypeTextBox.sendKeys(testData);

	}

	public void sendtextOrginalDescriptionTextBox(String testData) {
		OriginalDescriptionText.sendKeys(testData);
	}

	public void clickClear() {
		clearbtn.click();
	}

	public void SelectCriticalMatrix() {
		criticalMatrixBtn.click();
		for (WebElement webElement : criticalMatrixOptions) {
			webElement.click();
		}
		for (WebElement webElement : probabilityScoreOptions) {
			webElement.click();
		}
		criticalClose.click();
	}

	public String verifyCriticalScoreTxtBox() {
		return	criticalScoreTxtBox.getAttribute("value");
	}
	public String verifyABCIndicatorTxtBox() {
		return	ABCIndicatorTxtBox.getAttribute("value");
	}

	public void selectManufacturerPartNumber(String testData) {
		manufactPartNumberTxtBox.clear();
		manufactPartNumberTxtBox.sendKeys("*");
		driver.findElement(By.xpath("//li[normalize-space()='"+testData+"']")).click();		
	}

	public String verifyDuplicateWarningmesg() {
		return duplicateWarningMsg.getText();		
	}
	public boolean acceptDuplicateMesg() {
		duplicateWarningTextBox.sendKeys("test");
		okBtnForDuplicateWarrning.click();
		return	duplicateFlag.isDisplayed();
	}

	public boolean verifySAPFields() {
		boolean allMatch = true;
		for (WebElement element : sapFieldTextBoxes) {
			if (!element.isEnabled()) {
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public String verifyTagNumber(String testData) {
		tagTextBox.sendKeys(testData);
		driver.findElement(By.xpath("//label[text()='"+testData+"']")).click();
		addbtnForTagValue.click();
		String expText = tagNumberResult.getText();
		delTagNumber.click();
		return expText;
	}

	public boolean verifyAtributeUnits() {		
		for (WebElement webElement : attributeValueList) {
			webElement.sendKeys("*");			
		}
		return false;
	     
	}

	public String verifyManufactrarValidName(String testData) {
	manufacturarNameTextBox.sendKeys(testData);	
	return manufactrarNameErrorMesg.getText();
	}

	public void sendToApproval() {
		TestUtil.scrolltoElement(sendToApproval);	
		sendToApproval.click();
	}

	public void selectValuationType(String testData) {
		driver.findElement(By.xpath("//span[@class='k-input'][normalize-space()='Select']")).click();
		driver.findElement(By.xpath("//li[text()='"+testData+"']")).click();		
	}

	
	
}
