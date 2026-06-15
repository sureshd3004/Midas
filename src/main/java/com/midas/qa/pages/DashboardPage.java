package com.midas.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.midas.qa.base.TestBase;
import com.midas.qa.util.TestUtil;

public class DashboardPage extends TestBase {
	
	@FindBy(xpath="//div[contains(@class,'gray_br_1 gray_bb_1 lbl_cnt')]")
	WebElement dashboardBoxFields;
	
	@FindBy(xpath="//td[@data-field=\"CreatedUserName\"]")
	WebElement resultList;
      
	public DashboardPage(){
		PageFactory.initElements(driver, this);
	}

	public void verifyCountOfBoxes() {
		dashboardBoxFields.click();
		String count = TestUtil.waitAndGetInnerText(dashboardBoxFields);
		Assert.assertEquals(count, resultList.getSize());
	}
	
	
}
