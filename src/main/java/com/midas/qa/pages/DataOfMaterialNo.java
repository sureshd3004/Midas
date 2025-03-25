package com.midas.qa.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.midas.qa.base.TestBase;
import com.midas.qa.util.TestUtil;

public class DataOfMaterialNo extends TestBase{
	    
	public DataOfMaterialNo(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//i[@class=\"fa fa-external-link m_edit_btn search_view\"]")
	WebElement resultView;

	public void getResultsData() {
	        resultView.click();	
	}
            //method for to take ERP data as a Cataloger	
	public void getERPData(String testData) throws IOException {
		
        TestUtil.waitAndClickElement(driver.findElement(By.xpath("//span[normalize-space()='ERP Information']")));
        List<WebElement> rows = driver.findElements(By.cssSelector("tbody tr.showPlantERPData"));

        // Click each row one by one
        for (WebElement row : rows) {
        	TestUtil.waitAndClickElement(row);
        	
            try {
				Thread.sleep(400);
				String	plantName = TestUtil.waitAndGetText(driver.findElement(By.xpath("//tr[contains(@class,'showPlantERPData')]/td[1]")));
		//	  String	plantName = .getText();
			  System.err.println(plantName);
			 TestUtil.takeResultsToExcel(testData+"of plant"+plantName);
			} catch (InterruptedException e) {   }
           
        }
	}	
}
