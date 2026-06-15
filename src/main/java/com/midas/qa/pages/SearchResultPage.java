package com.midas.qa.pages;

import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.midas.qa.base.TestBase;
import com.midas.qa.util.TestUtil;

public class SearchResultPage extends TestBase {

	@FindBy(xpath="//span[text()='Request Type :']/following-sibling::span")
	WebElement requestType;

	@FindBy(xpath="(//tbody/tr/td[@class=\"cr_td_1 jc_box_1\"])[2]")
	WebElement changeTable;

	@FindBy(xpath="//div[@class=\"jconfirm-content\"]")
	WebElement alertMesg;

	@FindBy(xpath="//img[@id=\"audit_report_page\"]")
	WebElement auditBtn;

	@FindBy(xpath="//input[@id='audit-change-btn']")
	WebElement changeBtn;

	@FindBy(xpath="//div[@class='ms_defult ms_row_1 ms_search_animation']")
	WebElement hearde;

	@FindBy(xpath = "//tbody/tr/td[1]/img[@id='btnSearch']")
	WebElement btnSearch;

	@FindBy(xpath="//input[@id='btnFilterSearch' and @value='Search']")
	List<WebElement> btnFilterSearch;

	@FindBy(xpath="//iframe[@id='pageContainer']")
	WebElement SearchFrame;

	@FindBy(xpath="//input[@name='UserSearchQuery']")
	WebElement searchBox;

	@FindBy(xpath="/html[1]/body[1]/div[4]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/div[1]/div[1]/input[1]")
	WebElement ManufacturerFilterBox;

	@FindBy(xpath = "//th[@data-sortcolumn]") 
	List<WebElement> columnHeaders;

	@FindBy(xpath="//input[@id='btnExportToExcel']")
	WebElement exportExcel;

	@FindBy(xpath="//span[normalize-space()='ERP Information']")
	WebElement viewERPInfo;

	@FindBy(xpath="//span[@class='sm_close']")
	WebElement closeFilter;

	@FindBy(xpath="//i[@class='fa fa-times-circle']")
	WebElement closeERPFilter;

	@FindBy(xpath="//textarea[@id='RequestNo']")
	WebElement rquestNumber;

	@FindBy(xpath="//textarea[@id='MaterialNo']")
	WebElement materialNumber;

	@FindBy(xpath="//textarea[@id='Manufacturer']")
	WebElement manufacturer;

	@FindBy(xpath="//textarea[@id='PartNumber']")
	WebElement partNumber;

	@FindBy(xpath="//input[@id='btnAdvancedSearch']")
	WebElement searchbtn;

	@FindBy(xpath="//label[text()='Advance Settings']")
	WebElement advancedSettings;

	@FindBys({
		@FindBy(xpath="//ul[@id='pagination']/li/a")
	})
	List<WebElement> paginations;

	@FindBy(xpath="/html/body/div[4]/div/table/tbody/tr[7]/td[2]/div/div/input")
	WebElement plantFilterBox;

	@FindBy(xpath="/html[1]/body[1]/div[4]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/div[1]/input[1]")
	WebElement statusFilterBox;

	@FindBy(xpath="/html[1]/body[1]/div[4]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/input[1]")
	WebElement NounModifierSearchBox;

	@FindBy(xpath="//div[@class='owl-stage']/div")
	List<WebElement> erpFieldsFilter;

	@FindBy(xpath="//span[@id='PlantCount']")
	WebElement plantFilter;

	@FindBy(xpath="//*[@id='ulSearchResultData']/table/tbody/tr/td[8]")
	List<WebElement> plantFilterResult;

	@FindBy(xpath="//span[@id='StatusCount']")
	WebElement statusFilter;

	@FindBy(xpath="//span[@id='CleanVendorCount']")
	WebElement ManufacturerFilter;

	@FindBy(xpath="//span[@id='NMQCount']")
	WebElement NounModifierFilter;

	@FindBy(xpath="//*[@id='ulSearchResultData']/table/tbody/tr/td[1]")
	WebElement requestNumberResult;

	@FindBy(xpath="//*[@id='ulSearchResultData']/table/tbody/tr/td[2]")
	WebElement materialNumberResult;

	@FindBy(xpath="//*[@id='ulSearchResultData']/table/tbody/tr/td[3]")
	List<WebElement> manufacSearchResult;

	@FindBy(xpath="//*[@id='ulSearchResultData']/table/tbody/tr/td[4]")
	List<WebElement> partNumberSearchResult;

	@FindBy(xpath="//*[@id='SourceERPFieldsLoad']/tr[3]")
	WebElement industrySectorResult;

	@FindBy(xpath="//*[@id='SourceERPFieldsLoad']/tr[1]/td[2]")
	WebElement materialTypeResult;

	@FindBy(xpath="//*[@id='plantERPMatchFields']/tr[3]")
	WebElement materialGroupResult;

	@FindBy(xpath="//*[@id=\"plantERPMatchFields\"]/tr[2]/td[2]")
	WebElement valuationTypeResult;

	@FindBy(xpath="//*[@id='plantERPMatchFields']/tr[26]/td[2]")
	WebElement criticalScoreResult;

	@FindBy(xpath="//*[@id='plantERPMatchFields']/tr[35]/td[2]")
	WebElement demandEstYearlyDemandResult;

	@FindBy(xpath="//*[@id=\"plantERPMatchFields\"]/tr[34]/td[2]")
	WebElement demandQtyOrdersResult;

	@FindBy(xpath="/html[1]/body[1]/div[4]/div[1]/table[1]/tbody[1]/tr[5]/td[2]/div[1]/div[1]/input")
	WebElement partNumberSearchBox;

	@FindBy(xpath="//input[@aria-describedby='Industry_Sector_taglist']")
	WebElement IndustrySectorFilterBox;

	@FindBy(xpath="//input[@aria-describedby='Material_Group_taglist']")
	WebElement materialGroupFilterBox;

	@FindBy(xpath="//input[@aria-describedby='Material_Type_taglist']")
	WebElement materialTypeFilterBox;

	@FindBy(xpath="//input[@aria-describedby='Valuation_Type_taglist']")
	WebElement valuationTypeFilterBox;

	@FindBy(xpath="//input[@id=\"Demand_Est_Yearly_Demand\"]")
	WebElement demandEstYearlyDemandFilterBox;

	@FindBy(xpath="//input[@aria-describedby='CritScore_taglist']")
	WebElement criticalScoreFilterBox;

	@FindBy(xpath="//input[@id='Demand_Qty_Orders']")
	WebElement demandQtyOrdersFilterBox;

	@FindBy(xpath="//input[@id='Demand_Qty_Per_Order']")
	WebElement demandQtyPerOrderFilterBox;

	@FindBy(xpath="//input[@id='MaintParam_MTBF']")
	WebElement maintParamMTBFFilterBox;

	@FindBy(xpath="//input[@id='MaintParam_Pred_Breakdown_Days']")
	WebElement maintParamPredBreakdownDaysFilterBox;

	@FindBy(xpath="//input[@id=\"MaintParam_Set_Size\"]")
	WebElement maintParamSetSizeFilterBox;

	@FindBy(xpath="//input[@id=\"MaintParam_Shelf_Life_Months\"]")
	WebElement maintParamShelfLifeMonthsFilterBox;

	@FindBy(xpath="//input[@aria-describedby=\"Article_Critical_taglist\"]")
	WebElement criticalPartFilterBox;

	@FindBy(xpath="//input[@aria-describedby=\"Purchasing_Group_taglist\"]")
	WebElement purchasingGroupFilterBox;

	@FindBy(xpath="//input[@aria-describedby=\"Lot_Size_Procedure_taglist\"]")
	WebElement LotSizeProcedureFilterBox;

	@FindBy(xpath="//*[@id=\"plantERPMatchFields\"]/tr[24]/td[2]")
	WebElement LotSizeProcedureResult;

	@FindBy(xpath="//input[@id=\"MaintParam_Tot_Qty_Inst\"]")
	WebElement maintParamTotQtyInstFilterBox;

	@FindBy(xpath="//input[@id='MaintParam_Util_Assets']")
	WebElement maintParamUtilAssetsFilterBox;

	@FindBy(xpath="//input[@id='Assembly_Scrap']")
	WebElement assemblyScrapFilterBox;

	@FindBy(xpath="//input[@id=\"Fixed_Lot_Size\"]")
	WebElement fixedLotSizeFilterBox;

	@FindBy(xpath="//input[@aria-describedby=\"ABC_Indicator_taglist\"]")
	WebElement ABCIndicatorFilterBox;

	@FindBy(xpath="//input[@id='Maximum_Stock_Level']")
	WebElement maximumStockLevelFilterBox;

	@FindBy(xpath="//input[@id=\"LS_Independent_Costs\"]")
	WebElement LSIndependentCostsFilterBox;

	@FindBy(xpath="//input[@aria-describedby=\"Material_Status_Code_taglist\"]")
	WebElement materialStatusCodeFilterBox;

	@FindBy(xpath="//input[@aria-describedby='MRP_Controller_taglist']")
	WebElement MRPControllerFilterBox;

	@FindBy(xpath="//input[@id='Maximum_Lot_Size']")
	WebElement maximumLotSizeFilterBox;

	@FindBy(xpath="//input[@id='Minimum_Lot_Size']")
	WebElement minimumLotSizeFilterBox;

	@FindBy(xpath="//input[@aria-describedby='MRP_Group_taglist']")
	WebElement MRPGroupFilterBox;

	@FindBy(xpath="//span[@id='CleanPartNumberCount']")
	WebElement partNumberFilter;

	@FindBy(xpath="//span[@id='ERPFieldsCount']")
	WebElement ERPFieldsFilter;

	@FindBy(xpath="//i[@class='fa fa-external-link m_edit_btn search_view']")
	List<WebElement> viewMores;

	@FindBy(xpath="//input[@aria-describedby='MRP_Type_taglist']")
	WebElement MRPTypeFilterBox;

	@FindBy(xpath="//input[@id='Reorder_Point']")
	WebElement reOrderPointFilterBox;

	@FindBy(xpath="//input[@id='Rounding_Profile']")
	WebElement roundingProfileFilterBox;

	@FindBy(xpath="//input[@id=\"Rounding_Value\"]")
	WebElement roundingValueFilterBox;

	@FindBy(xpath="//input[@aria-describedby=\"Storage_Location_taglist\"]")
	WebElement storageLocationFilterBox;

	@FindBy(xpath="//input[@id=\"Storage_Costs_Code\"]")
	WebElement storageCostsCodeFilterBox;

	@FindBy(xpath="//input[@id=\"GR_Processing_Time\"]")
	WebElement GRProcessingTimeFilterBox;

	@FindBy(xpath="//input[@id=\"Planned_Delivery_Time_Days\"]")
	WebElement plannedDeliveryTimeFilterBox;

	@FindBy(xpath="//input[@aria-describedby=\"Procurement_Type_taglist\"]")
	WebElement procurementTypeFilterBox;

	@FindBy(xpath="//input[@id=\"Production_Storage_Location\"]")
	WebElement productionStorageLocationFilterBox;

	@FindBy(xpath="//input[@id=\"Safety_Stock\"]")
	WebElement safetyStockFilterBox;

	@FindBy(xpath="//input[@aria-describedby=\"Spl_Procurement_Type_taglist\"]")
	WebElement specialProcurementFilterBox;

	@FindBy(xpath="//input[@id='Storage_Location_For_EP']")
	WebElement storageLocationForEPFilterBox;

	@FindBy(xpath="")
	WebElement GRProcessingTimeResult;

	@FindBy(xpath="")
	WebElement plannedDeliveryTimeResult;

	@FindBy(xpath="")
	WebElement procurementTypeResult;

	@FindBy(xpath="")
	WebElement productionStorageLocationResult;

	@FindBy(xpath="")
	WebElement safetyStockResult;

	@FindBy(xpath="")
	WebElement specialProcurementResult;

	@FindBy(xpath="")
	WebElement storageLocationForEPResult;

	@FindBy(xpath="")
	WebElement availabilityCheckResult;

	@FindBy(xpath="")
	WebElement CCPhysInvFilterBoxResult;

	@FindBy(xpath="//input[@id=\"CC_Phys_Inv\"]")
	WebElement CCPhysInvFilterBox;

	@FindBy(xpath="//input[@aria-describedby=\"Expiration_Date_taglist\"]")
	WebElement expirationDateFilterBox;

	@FindBy(xpath="")
	WebElement expirationDateResult;

	@FindBy(xpath="//input[@id=\"Label_Form\"]")
	WebElement labelFormFilterBox;

	@FindBy(xpath="")
	WebElement labelFormResult;

	@FindBy(xpath="//input[@id=\"Label_Type\"]")
	WebElement labelTypeFilterBox;

	@FindBy(xpath="")
	WebElement labelTypeResult;

	@FindBy(xpath="//input[@id=\"Period_Ind_for_SLED\"]")
	WebElement periodIndForSledFilterBox;

	@FindBy(xpath="")
	WebElement periodIndForSledResult;

	@FindBy(xpath="")
	WebElement storageBinResult;

	@FindBy(xpath="//input[@aria-describedby=\"Storage_Bin_taglist\"]")
	WebElement storageBinFilterBox;

	@FindBy(xpath="//input[@aria-describedby=\"Profit_Center_taglist\"]")
	WebElement profitCenterFilterBox;

	@FindBy(xpath="")
	WebElement profitCenterResult;

	@FindBy(xpath="//input[@]")
	WebElement movingAveragePriceFilterBox;

	@FindBy(xpath="")
	WebElement movingAveragePriceResult;

	@FindBy(xpath="//input[@aria-describedby=\"Price_Control_Indicator_taglist\"]")
	WebElement priceControlIndicatorFilterBox;

	@FindBy(xpath="")
	WebElement priceControlIndicatorResult;

	@FindBy(xpath="//input[@id=\"Price_Unit\"]")
	WebElement priceUnitFilterBox;

	@FindBy(xpath="//input[@]")
	WebElement priceUnitResult;

	@FindBy(xpath="//input[@id=\"Standard_Price\"]")
	WebElement standardPriceFilterBox;

	@FindBy(xpath="")
	WebElement standardPriceResult;

	@FindBy(xpath="//input[@aria-describedby=\"Valuation_Category_taglist\"]")
	WebElement valuationCategoryFilterBox;

	@FindBy(xpath="")
	WebElement valuationCategoryResult;

	@FindBy(xpath="//input[@aria-describedby=\"Valuation_Class_taglist\"]")
	WebElement valuationClassFilterBox;

	@FindBy(xpath="")
	WebElement valuationClassResult;

	@FindBy(xpath="//input[@aria-describedby=\"Availability_check_taglist\"]")
	WebElement availabilityCheckFilterBox;

	@FindBy(xpath="//*[@id=\"plantERPMatchFields\"]/tr[40]/td[2]")
	WebElement taktTimeResult;

	@FindBy(xpath="//input[@id=\"Takt_Time\"]")
	WebElement taktTimeFilterBox;

	@FindBy(xpath="//*[@id=\"plantERPMatchFields\"]/tr[1]/td[2]")
	WebElement storageLocationResult;

	@FindBy(xpath="//*[@id=\"plantERPMatchFields\"]/tr[42]/td[2]")
	WebElement roundingValueResult;

	@FindBy(xpath="//*[@id=\"plantERPMatchFields\"]/tr[41]/td[2]")
	WebElement roundingProfileResult;

	@FindBy(xpath="//*[@id=\"plantERPMatchFields\"]/tr[8]/td[2]")
	WebElement reOrderPointResult;

	@FindBy(xpath="(//*[@class='erp_r1_dt'])[3]")
	WebElement statusResult;

	@FindBy(xpath="//*[@id=\"plantERPMatchFields\"]/tr[38]/td[2]")
	WebElement storageCostsCodeResult;

	@FindBy(xpath="//*[@id=\"plantERPMatchFields\"]/tr[6]/td[2]")
	WebElement MRPTypeResult;

	@FindBy(xpath="//*[@id=\"plantERPMatchFields\"]/tr[15]/td[2]")
	WebElement MRPGroupFilterBoxResult;

	@FindBy(xpath="//*[@id=\"plantERPMatchFields\"]/tr[37]/td[2]")
	WebElement LSIndependentCostsResult;

	@FindBy(xpath="//*[@id=\"SourceERPFieldsLoad\"]/tr[15]/td[2]")
	WebElement materialStatusCodeResult;

	@FindBy(xpath="//*[@id=\"plantERPMatchFields\"]/tr[17]/td[2]")
	WebElement maximumLotSizeResult;

	@FindBy(xpath="//*[@id=\"plantERPMatchFields\"]/tr[36]/td[2]")
	WebElement maximumStockLevelResult;

	@FindBy(xpath="//*[@id=\"plantERPMatchFields\"]/tr[16]/td[2]")
	WebElement minimumLotSizeResult;

	@FindBy(xpath="//*[@id=\"plantERPMatchFields\"]/tr[7]/td[2]")
	WebElement ABCIndicatorFilterResult;


	@FindBy(xpath="//*[@id='plantERPMatchFields']/tr[39]/td[2]")
	WebElement assemblyScrapResult;

	@FindBy(xpath="//*[@id=\"SourceERPFieldsLoad\"]/tr[4]/td[2]")
	WebElement criticalPartResult;

	@FindBy(xpath="//*[@id=\"plantERPMatchFields\"]/tr[4]/td[2]")
	WebElement purchasingGroupResult;

	@FindBy(xpath="//*[@id='plantERPMatchFields']/tr[33]/td[2]")
	WebElement demandQtyPerOrderResult;

	@FindBy(xpath="//*[@id='plantERPMatchFields']/tr[32]/td[2]")
	WebElement maintParamShelfLifeMonthsResult;

	@FindBy(xpath="//*[@id='plantERPMatchFields']/tr[29]/td[2]")
	WebElement maintParamTotQtyInstResult;

	@FindBy(xpath="//*[@id=\"plantERPMatchFields\"]/tr[28]/td[2]")
	WebElement maintParamUtilAssetsResult;

	@FindBy(xpath="//*[@id=\"plantERPMatchFields\"]/tr[9]/td[2]")
	WebElement MRPControllerResult;

	@FindBy(xpath="//*[@id='plantERPMatchFields']/tr[30]/td[2]")
	WebElement maintParamMTBFResult;

	@FindBy(xpath="//*[@id='plantERPMatchFields']/tr[10]/td[2]")
	WebElement fixedLotSizeResult;

	@FindBy(xpath="//input[@id='//*[@id='plantERPMatchFields']/tr[27]/td[2]']")
	WebElement maintParamSetSizeResult;

	@FindBy(xpath="//*[@id='plantERPMatchFields']/tr[31]/td[2]")
	WebElement maintParamPredBreakdownDaysResult;

	@FindBy(xpath="//tr[td/b[text()='Noun'] and td/b[text()='Modifier']]")
	WebElement NounModifierResult;

	@FindBy(xpath="//*[@id='SourceERPFieldsLoad']/tr[3]")
	WebElement IndustrySector;



	// Initializing the Page Objects:
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifySearchTitle() {
		return driver.getTitle();
	}

	public boolean searchBoxTest(String string) {

		WebElement	searchResult = driver.findElement(By.xpath("//*[contains(text(), '"+string+"')]"));
		return  searchResult.getText().contains(string);	
	}

	public void clickSearchIcon(){	
		driver.switchTo().frame(0);	
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)); 
		wait.until(ExpectedConditions.elementToBeClickable(btnSearch)).click();     
		btnSearch.click();
	}

	public String downloadExport() {
		String fileName = "File not downloaded";
		searchBox.sendKeys("test");
		searchBox.sendKeys(Keys.ENTER);
		exportExcel.click();

		File dir = new File(System.getProperty("user.dir") + "/downloads");

		long timeout = 15; // seconds
		long elapsedTime = 0;

		File lastModifiedFile = null;

		// Wait until a new file is downloaded
		while (elapsedTime < timeout) {
			try {
				TimeUnit.SECONDS.sleep(1);
				elapsedTime++;

				// Get the latest file based on last modified time
				File[] files = dir.listFiles();
				if (files != null && files.length > 0) {
					lastModifiedFile = Arrays.stream(files)
							.max(Comparator.comparingLong(File::lastModified))
							.orElse(null);

					if (lastModifiedFile != null && lastModifiedFile.lastModified() > System.currentTimeMillis() - 2000) {
						// Check if the latest file is within the last 2 seconds
						fileName = lastModifiedFile.getName();
						break;
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		if (elapsedTime >= timeout) {
			System.out.println("File download timed out.");
		} else if (lastModifiedFile != null) {
			System.out.println("Downloaded file: " + lastModifiedFile.getName());
		}

		return fileName;
	}

	public int searchResultColoumns() {

		return columnHeaders.size();		
	}

	public String filtersClickTest()  {

		Map<String, String> filters = new HashMap<>();
		filters.put("PlantCount", "PlantDropDownList_taglist");
		filters.put("StatusCount", "StatusDropDownList_taglist");
		filters.put("CleanVendorCount", "CleanVendorDropDownList_taglist");
		filters.put("CleanPartNumberCount", "CleanPartNumberDropDownList_taglist");
		filters.put("NMQCount", "NounDropDownList_taglist");

		// Loop through the filters and interact with them
		for (Map.Entry<String, String> filter : filters.entrySet()) {
			String filterName = filter.getKey();
			String filterValue = filter.getValue();

			// Locate the filter using its name (modify XPath as per your DOM structure)
			WebElement filterElement = driver.findElement(By.xpath("//span[@id='"+filterName+"']"));
			TestUtil.waitAndClickElement(filterElement);
			// Click to open the dropdown

			// Locate the input or dropdown element inside the filter
			WebElement inputElement = driver.findElement(By.xpath("//input[@aria-describedby='"+filterValue+"']"));
			TestUtil.waitAndClickElement(inputElement);
			TestUtil.waitAndClickElement(closeFilter);

		} return "done";
	}

	public boolean verifyAdditionalSettingsRequestNumberSearchPage(String requestNumber) {				 

		TestUtil.waitAndClickElement(advancedSettings);	
		rquestNumber.sendKeys(requestNumber);
		TestUtil.waitAndClickElement(searchbtn);
		return	requestNumberResult.getText().contains(requestNumber);   
	}

	public boolean verifyAdditionalSettingsMaterialNumberSearchPage(String property) {

		TestUtil.waitAndClickElement(advancedSettings);
		materialNumber.sendKeys(property);
		TestUtil.waitAndClickElement(searchbtn);
		return	materialNumberResult.getText().contains(property);

	}

	public boolean verifyAdditionalSettingsManufacturerSearchPage(String property) {

		TestUtil.waitAndClickElement(advancedSettings);
		manufacturer.sendKeys(property);
		TestUtil.waitAndClickElement(searchbtn);
		return	manufacSearchResult.get(0).getText().contains(property);
	}

	public boolean verifyAdditionalSettingsPartNumberSearchPage(String property) {

		TestUtil.waitAndClickElement(advancedSettings);
		partNumber.sendKeys(property);
		TestUtil.waitAndClickElement(searchbtn);
		TestUtil.waitforElementToLoad(partNumberSearchResult.get(0));
		return  partNumberSearchResult.get(0).getText().contains(property);
	}

	public boolean verifyPaginationButtons() {

		for (WebElement webElement : paginations) {
			if (!webElement.isEnabled()) {
				return false; // If any button is not enabled, return false immediately
			}
		}
		return true; // All buttons are enabled, return true
	}

	public boolean verifyERPFieldsIndustrySectorFilter(String testData) {

		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(0).click();
		IndustrySectorFilterBox.sendKeys(testData);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {	}
		IndustrySectorFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;

		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = TestUtil.waitAndGetText(industrySectorResult);
			// statusResult.getText();
			System.err.println(actualTitle);
			System.out.println(testData.replace(" - ", "-"));

			if (!actualTitle.contains(testData.replace(" - ", "-"))) {
				allMatch = false;
				break;
			}      }
		return allMatch;	
	}

	public boolean verifyERPFieldsMaterialGroupFilter(String testData) {

		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(0).click();
		materialGroupFilterBox.sendKeys(testData);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {	}
		materialGroupFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle =materialGroupResult.getText();			
			if (!actualTitle.contains(testData.replace(" - ", "-"))) {
				// If any element doesn't match, set flag to false and break
				allMatch = false;
				break;
			}      }
		return allMatch;	
	}

	public boolean verifyERPFieldsMaterialTypeFilter(String testData) {

		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(0).click();
		materialTypeFilterBox.sendKeys(testData);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {	}
		materialTypeFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle =materialTypeResult.getText();			
			if (!actualTitle.contains(testData.replace(" - ", "-"))) {
				// If any element doesn't match, set flag to false and break
				allMatch = false;
				break;
			}      }
		return allMatch;	

	}

	public boolean verifyERPFieldsValuationTypeFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(0).click();
		valuationTypeFilterBox.sendKeys(testData);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {	}
		valuationTypeFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = valuationTypeResult.getText();	
			if (!actualTitle.contains(testData.replace(" - ", "-"))) {
				// If any element doesn't match, set flag to false and break
				allMatch = false;
				break;
			}      }
		return allMatch;	
	}

	public boolean verifyERPFieldsCriticalScoreFilter(String testData) {

		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(1).click();
		criticalScoreFilterBox.sendKeys(testData);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {	}
		//		TestUtil.waitAndSendKeys(criticalScoreFilterBox,testData);
		criticalScoreFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = criticalScoreResult.getText();	
			if (!actualTitle.contains(testData.replace(" - ", "-"))) {
				// If any element doesn't match, set flag to false and break
				allMatch = false;
				break;
			}      }
		return allMatch;	
	}

	public boolean verifyPlantFilter(String testData) {

		TestUtil.waitAndClickElement(plantFilter);
		TestUtil.waitAndClickElement(plantFilterBox);
		plantFilterBox.sendKeys(testData);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		plantFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(hearde);
		TestUtil.waitAndClickElement(btnFilterSearch.get(1));

		boolean allMatch = true;
		String expectedPlantFilter = testData.replace(" - ", "-")+"\n";
		//	+ "";
		// Loop through the list of WebElements
		for (WebElement element : plantFilterResult) {
			String actualTitle = TestUtil.waitAndGetAttribute(element, "title");
			// Check if the title contains the expected value
			if (!actualTitle.contains(expectedPlantFilter)) {
				// If any element doesn't match, set flag to false and break
				allMatch = false;
				break;
			}}
		return allMatch;
	}

	public boolean verifyStatusFilter(String testData) {

		TestUtil.waitAndClickElement(statusFilter);
		TestUtil.waitAndClickElement(statusFilterBox);

		statusFilterBox.sendKeys(testData);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {	}
		statusFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(hearde);
		TestUtil.waitAndClickElement(btnFilterSearch.get(1));

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			String actualTitle =	TestUtil.waitAndGetText(statusResult);
			// statusResult.getText();
			if (!actualTitle.contains(testData)) {
				// If any element doesn't match, set flag to false and break
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public boolean verifyManufacurFilter(String testData) {

		TestUtil.waitAndClickElement(ManufacturerFilter);
		TestUtil.waitAndClickElement(ManufacturerFilterBox);
		ManufacturerFilterBox.sendKeys(testData);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		ManufacturerFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(hearde);
		TestUtil.waitAndClickElement(btnFilterSearch.get(1));

		boolean allMatch = true;
		for (WebElement element : manufacSearchResult) {
			String actualTitle = element.getText();
			// Check if the title contains the expected value
			if (!actualTitle.contains(testData)) {
				// If any element doesn't match, set flag to false and break
				allMatch = false;
				break;
			}}
		return allMatch;
	}

	public boolean verifyPartNumberFilter(String testData) {
		TestUtil.waitAndClickElement(partNumberFilter);
		TestUtil.waitAndClickElement(partNumberSearchBox);
		partNumberSearchBox.sendKeys(testData);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		partNumberSearchBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(hearde);
		TestUtil.waitAndClickElement(btnFilterSearch.get(1));

		boolean allMatch = true;
		for (WebElement element : partNumberSearchResult) {
			String actualTitle = element.getText();
			// Check if the title contains the expected value
			if (!actualTitle.contains(testData)) {
				// If any element doesn't match, set flag to false and break
				allMatch = false;
				break;
			}}
		return allMatch;
	}

	public boolean verifyNounModifierFilter(String testData) {
		TestUtil.waitAndClickElement(NounModifierFilter);
		TestUtil.waitAndClickElement(NounModifierSearchBox);
		NounModifierSearchBox.sendKeys(testData);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		NounModifierSearchBox.sendKeys(Keys.ENTER);	

		TestUtil.waitAndClickElement(hearde);
		TestUtil.waitAndClickElement(btnFilterSearch.get(1));

		boolean allMatch = true; // Flag to track if all elements match
		String[] expectedParts = testData.split(","); // Split expected value into parts 
		TestUtil.waitToLoadAllElements(viewMores);
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);

			// Get the actual title text after clicking
			String actualTitle = TestUtil.waitAndGetText(NounModifierResult);
			// Check if all expected parts are present in the actual title
			for (String part : expectedParts) {
				if (!actualTitle.contains(part.trim())) {
					allMatch = false;
					System.err.println("Mismatch found! Missing part: " + part + " in Actual: " + actualTitle);
					break; // Break inner loop if any part is missing
				}
			}		    
			// If inner loop sets allMatch to false, exit the outer loop
			if (allMatch==false) {
				break;
			}
		}
		// Return the result of the validation
		return allMatch;
	}

	public boolean verifyERPFieldsDemandEstYearlyDemandFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(1).click();
		demandEstYearlyDemandFilterBox.sendKeys(testData);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {	}
		demandEstYearlyDemandFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = demandEstYearlyDemandResult.getText();	
			if (!actualTitle.contains(testData.replace(" - ", "-"))) {
				// If any element doesn't match, set flag to false and break
				allMatch = false;
				break;
			}      }
		return allMatch;	
	}

	public boolean verifyERPFieldsDemandQtyOrdersFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(1).click();
		demandQtyOrdersFilterBox.sendKeys(testData);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {	}
		demandQtyOrdersFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = demandQtyOrdersResult.getText();	
			if (!actualTitle.contains(testData.replace(" - ", "-"))) {
				// If any element doesn't match, set flag to false and break
				allMatch = false;
				break;
			}      }
		return allMatch;	
	}

	public boolean verifyERPFieldsDemandQtyPerOrderFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(1).click();
		demandQtyPerOrderFilterBox.sendKeys(testData);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {	}
		demandQtyPerOrderFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = demandQtyPerOrderResult.getText();	
			if (!actualTitle.contains(testData.replace(" - ", "-"))) {
				// If any element doesn't match, set flag to false and break
				allMatch = false;
				break;
			}      }
		return allMatch;	
	}

	public boolean verifyERPFieldsMaintParamMTBFFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(1).click();
		maintParamMTBFFilterBox.sendKeys(testData);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {	}
		maintParamMTBFFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = maintParamMTBFResult.getText();	
			if (!actualTitle.contains(testData.replace(" - ", "-"))) {
				// If any element doesn't match, set flag to false and break
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public boolean verifyERPFieldsMaintParamPredBreakdownDaysFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(1).click();
		maintParamPredBreakdownDaysFilterBox.sendKeys(testData);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {	}
		maintParamPredBreakdownDaysFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = maintParamPredBreakdownDaysResult.getText();	
			if (!actualTitle.contains(testData.replace(" - ", "-"))) {
				// If any element doesn't match, set flag to false and break
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public boolean verifyERPFieldsMaintParamSetSizeFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(1).click();
		maintParamSetSizeFilterBox.sendKeys(testData);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {	}
		maintParamSetSizeFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = maintParamSetSizeResult.getText();	
			if (!actualTitle.contains(testData.replace(" - ", "-"))) {
				// If any element doesn't match, set flag to false and break
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public boolean verifyERPFieldsMaintParamShelfLifeMonthsFilter(String testData) {

		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(1).click();
		maintParamShelfLifeMonthsFilterBox.sendKeys(testData);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {	}
		maintParamShelfLifeMonthsFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = maintParamShelfLifeMonthsResult.getText();	
			if (!actualTitle.contains(testData.replace(" - ", "-"))) {
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public boolean verifyERPFieldsMaintParamTotQtyInstFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(1).click();
		maintParamUtilAssetsFilterBox.sendKeys(testData);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {	}
		maintParamUtilAssetsFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = 	maintParamUtilAssetsResult.getText();	
			if (!actualTitle.contains(testData.replace(" - ", "-"))) {
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public boolean verifyCriticalPartFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(2).click();
		criticalPartFilterBox.sendKeys(testData);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {	}
		criticalPartFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = criticalPartResult.getText();	
			if (!actualTitle.contains(testData.replace(" - ", "-"))) {
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public boolean verifyPurchasingGroupFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(2).click();
		purchasingGroupFilterBox.sendKeys(testData);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {	}
		purchasingGroupFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = purchasingGroupResult.getText();	
			if (!actualTitle.contains(testData.replace(" - ", "-"))) {
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public boolean verifyABCIndicatorFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(3).click();
		ABCIndicatorFilterBox.sendKeys(testData);

		try {
			Thread.sleep(1000);   } catch (InterruptedException e) {	}
		ABCIndicatorFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = ABCIndicatorFilterResult.getText().replaceAll("[^a-zA-Z0-9]", "");	
			if (!actualTitle.contains(testData.replaceAll("[^a-zA-Z0-9]", ""))) {
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public boolean verifyLotSizeProcedureFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(3).click();
		LotSizeProcedureFilterBox.sendKeys(testData);

		try {
			Thread.sleep(1000);   } catch (InterruptedException e) {	}
		LotSizeProcedureFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = LotSizeProcedureResult.getText().replaceAll("[^a-zA-Z0-9]", "");	
			if (!actualTitle.contains(testData.replaceAll("[^a-zA-Z0-9]", ""))) {
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public boolean verifyFixedLotSizeFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(3).click();
		fixedLotSizeFilterBox.sendKeys(testData);

		try {
			Thread.sleep(1000);   } catch (InterruptedException e) {	}
		fixedLotSizeFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = fixedLotSizeResult.getText().replaceAll("[^a-zA-Z0-9]", "");	
			if (!actualTitle.contains(testData.replaceAll("[^a-zA-Z0-9]", ""))) {
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public boolean verifyAssemblyScrapFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(3).click();
		assemblyScrapFilterBox.sendKeys(testData);

		try {
			Thread.sleep(1000);   } catch (InterruptedException e) {	}
		assemblyScrapFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = assemblyScrapResult.getText().replaceAll("[^a-zA-Z0-9]", "");	
			if (!actualTitle.contains(testData.replaceAll("[^a-zA-Z0-9]", ""))) {
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public boolean verifyLSIndependentCostsFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(3).click();
		LSIndependentCostsFilterBox.sendKeys(testData);

		try {
			Thread.sleep(1000);   } catch (InterruptedException e) {	}
		LSIndependentCostsFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = LSIndependentCostsResult.getText().replaceAll("[^a-zA-Z0-9]", "");	
			if (!actualTitle.contains(testData.replaceAll("[^a-zA-Z0-9]", ""))) {
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public boolean verifyMaterialStatusCodeFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(3).click();
		materialStatusCodeFilterBox.sendKeys(testData);

		try {
			Thread.sleep(1000);   } catch (InterruptedException e) {	}
		materialStatusCodeFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = materialStatusCodeResult.getText().replaceAll("[^a-zA-Z0-9]", "");	
			if (!actualTitle.contains(testData.replaceAll("[^a-zA-Z0-9]", ""))) {
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public boolean verifyMaximumLotSizeFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(3).click();
		maximumLotSizeFilterBox.sendKeys(testData);

		try {
			Thread.sleep(1000);   } catch (InterruptedException e) {	}
		maximumLotSizeFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = maximumLotSizeResult.getText().replaceAll("[^a-zA-Z0-9]", "");	
			if (!actualTitle.contains(testData.replaceAll("[^a-zA-Z0-9]", ""))) {
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public boolean verifyMaximumStockLevelFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(3).click();
		maximumStockLevelFilterBox.sendKeys(testData);

		try {
			Thread.sleep(1000);   } catch (InterruptedException e) {	}
		maximumStockLevelFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = maximumStockLevelResult.getText().replaceAll("[^a-zA-Z0-9]", "");	
			if (!actualTitle.contains(testData.replaceAll("[^a-zA-Z0-9]", ""))) {
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public boolean verifyMinimumLotSizeFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(3).click();
		minimumLotSizeFilterBox.sendKeys(testData);

		try {
			Thread.sleep(1000);   } catch (InterruptedException e) {	}
		minimumLotSizeFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = minimumLotSizeResult.getText().replaceAll("[^a-zA-Z0-9]", "");	
			if (!actualTitle.contains(testData.replaceAll("[^a-zA-Z0-9]", ""))) {
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public boolean verifyMRPControllerFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(3).click();
		MRPControllerFilterBox.sendKeys(testData);

		try {
			Thread.sleep(1000);   } catch (InterruptedException e) {	}
		MRPControllerFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = MRPControllerResult.getText().replaceAll("[^a-zA-Z0-9]", "");	
			if (!actualTitle.contains(testData.replaceAll("[^a-zA-Z0-9]", ""))) {
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public boolean verifyMRPGroupFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(3).click();
		MRPGroupFilterBox.sendKeys(testData);

		try {
			Thread.sleep(1000);   } catch (InterruptedException e) {	}
		MRPGroupFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = MRPGroupFilterBoxResult.getText().replaceAll("[^a-zA-Z0-9]", "");	
			if (!actualTitle.contains(testData.replaceAll("[^a-zA-Z0-9]", ""))) {
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public boolean verifyMRPTypeFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(3).click();
		MRPTypeFilterBox.sendKeys(testData);

		try {
			Thread.sleep(1000);   } catch (InterruptedException e) {	}
		MRPTypeFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = MRPTypeResult.getText().replaceAll("[^a-zA-Z0-9]", "");	
			if (!actualTitle.contains(testData.replaceAll("[^a-zA-Z0-9]", ""))) {
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public boolean verifyReOrderPointFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(3).click();
		reOrderPointFilterBox.sendKeys(testData);

		try {
			Thread.sleep(1000);   } catch (InterruptedException e) {	}
		reOrderPointFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = reOrderPointResult.getText().replaceAll("[^a-zA-Z0-9]", "");	
			if (!actualTitle.contains(testData.replaceAll("[^a-zA-Z0-9]", ""))) {
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public boolean verifyRoundingProfileFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(3).click();
		roundingProfileFilterBox.sendKeys(testData);

		try {
			Thread.sleep(1000);   } catch (InterruptedException e) {	}
		roundingProfileFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = roundingProfileResult.getText().replaceAll("[^a-zA-Z0-9]", "");	
			if (!actualTitle.contains(testData.replaceAll("[^a-zA-Z0-9]", ""))) {
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public boolean verifyRoundingValueFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(3).click();
		roundingValueFilterBox.sendKeys(testData);

		try {Thread.sleep(1000);   } catch (InterruptedException e) {	}
		roundingValueFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = roundingValueResult.getText().replaceAll("[^a-zA-Z0-9]", "");	
			if (!actualTitle.contains(testData.replaceAll("[^a-zA-Z0-9]", ""))) {
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public boolean verifyStorageCostsCodeFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(3).click();
		storageCostsCodeFilterBox.sendKeys(testData);

		try {Thread.sleep(1000);   } catch (InterruptedException e) {	}
		storageCostsCodeFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = storageCostsCodeResult.getText().replaceAll("[^a-zA-Z0-9]", "");	
			if (!actualTitle.contains(testData.replaceAll("[^a-zA-Z0-9]", ""))) {
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public boolean verifyStorageLocationFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(3).click();
		storageLocationFilterBox.sendKeys(testData);

		try {Thread.sleep(1000);   } catch (InterruptedException e) {	}
		storageLocationFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = storageLocationResult.getText().replaceAll("[^a-zA-Z0-9]", "");	
			if (!actualTitle.contains(testData.replaceAll("[^a-zA-Z0-9]", ""))) {
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public boolean verifyTaktTimeFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(3).click();
		taktTimeFilterBox.sendKeys(testData);

		try {Thread.sleep(1000);   } catch (InterruptedException e) {	}
		taktTimeFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = taktTimeResult.getText().replaceAll("[^a-zA-Z0-9]", "");	
			if (!actualTitle.contains(testData.replaceAll("[^a-zA-Z0-9]", ""))) {
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public boolean verifyGRProcessingTimeFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(4).click();
		GRProcessingTimeFilterBox.sendKeys(testData);

		try {Thread.sleep(1000);   } catch (InterruptedException e) {	}
		GRProcessingTimeFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = GRProcessingTimeResult.getText().replaceAll("[^a-zA-Z0-9]", "");	
			if (!actualTitle.contains(testData.replaceAll("[^a-zA-Z0-9]", ""))) {
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public boolean verifyPlannedDeliveryTimeFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(4).click();
		plannedDeliveryTimeFilterBox.sendKeys(testData);

		try {Thread.sleep(1000);   } catch (InterruptedException e) {	}
		plannedDeliveryTimeFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = plannedDeliveryTimeResult.getText().replaceAll("[^a-zA-Z0-9]", "");	
			if (!actualTitle.contains(testData.replaceAll("[^a-zA-Z0-9]", ""))) {
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public boolean verifyProcurementTypeFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(4).click();
		procurementTypeFilterBox.sendKeys(testData);

		try {Thread.sleep(1000);   } catch (InterruptedException e) {	}
		procurementTypeFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = procurementTypeResult.getText().replaceAll("[^a-zA-Z0-9]", "");	
			if (!actualTitle.contains(testData.replaceAll("[^a-zA-Z0-9]", ""))) {
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public boolean verifyProductionStorageLocationFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(4).click();
		productionStorageLocationFilterBox.sendKeys(testData);

		try {Thread.sleep(1000);   } catch (InterruptedException e) {	}
		productionStorageLocationFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = productionStorageLocationResult.getText().replaceAll("[^a-zA-Z0-9]", "");	
			if (!actualTitle.contains(testData.replaceAll("[^a-zA-Z0-9]", ""))) {
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public boolean verifySafetyStockFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(4).click();
		safetyStockFilterBox.sendKeys(testData);

		try {Thread.sleep(1000);   } catch (InterruptedException e) {	}
		safetyStockFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = safetyStockResult.getText().replaceAll("[^a-zA-Z0-9]", "");	
			if (!actualTitle.contains(testData.replaceAll("[^a-zA-Z0-9]", ""))) {
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public boolean verifySpecialProcurementFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(4).click();
		specialProcurementFilterBox.sendKeys(testData);

		try {Thread.sleep(1000);   } catch (InterruptedException e) {	}
		specialProcurementFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = specialProcurementResult.getText().replaceAll("[^a-zA-Z0-9]", "");	
			if (!actualTitle.contains(testData.replaceAll("[^a-zA-Z0-9]", ""))) {
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public boolean verifyStorageLocationForEPFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(4).click();
		storageLocationForEPFilterBox.sendKeys(testData);

		try {Thread.sleep(1000);   } catch (InterruptedException e) {	}
		storageLocationForEPFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = storageLocationForEPResult.getText().replaceAll("[^a-zA-Z0-9]", "");	
			if (!actualTitle.contains(testData.replaceAll("[^a-zA-Z0-9]", ""))) {
				allMatch = false;
				break;
			}      }
		return allMatch;
	}


	public boolean verifyAvailabilityCheckFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(5).click();
		availabilityCheckFilterBox.sendKeys(testData);

		try {Thread.sleep(1000);   } catch (InterruptedException e) {	}
		availabilityCheckFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = availabilityCheckResult.getText().replaceAll("[^a-zA-Z0-9]", "");	
			if (!actualTitle.contains(testData.replaceAll("[^a-zA-Z0-9]", ""))) {
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public boolean verifyCCPhysInvFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(6).click();
		CCPhysInvFilterBox.sendKeys(testData);

		try {Thread.sleep(1000);   } catch (InterruptedException e) {	}
		CCPhysInvFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = CCPhysInvFilterBoxResult.getText().replaceAll("[^a-zA-Z0-9]", "");	
			if (!actualTitle.contains(testData.replaceAll("[^a-zA-Z0-9]", ""))) {
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public boolean verifyExpirationDateFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(6).click();
		expirationDateFilterBox.sendKeys(testData);

		try {Thread.sleep(1000);   } catch (InterruptedException e) {	}
		expirationDateFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = expirationDateResult.getText().replaceAll("[^a-zA-Z0-9]", "");	
			if (!actualTitle.contains(testData.replaceAll("[^a-zA-Z0-9]", ""))) {
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public boolean verifyLabelFormFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(6).click();
		labelFormFilterBox.sendKeys(testData);

		try {Thread.sleep(1000);   } catch (InterruptedException e) {	}
		labelFormFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = labelFormResult.getText().replaceAll("[^a-zA-Z0-9]", "");	
			if (!actualTitle.contains(testData.replaceAll("[^a-zA-Z0-9]", ""))) {
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public boolean verifyLabelTypeFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(6).click();
		labelTypeFilterBox.sendKeys(testData);

		try {Thread.sleep(1000);   } catch (InterruptedException e) {	}
		labelTypeFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = labelTypeResult.getText().replaceAll("[^a-zA-Z0-9]", "");	
			if (!actualTitle.contains(testData.replaceAll("[^a-zA-Z0-9]", ""))) {
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public boolean verifyPeriodIndForSledFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(6).click();
		periodIndForSledFilterBox.sendKeys(testData);

		try {Thread.sleep(1000);   } catch (InterruptedException e) {	}
		periodIndForSledFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = periodIndForSledResult.getText().replaceAll("[^a-zA-Z0-9]", "");	
			if (!actualTitle.contains(testData.replaceAll("[^a-zA-Z0-9]", ""))) {
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public boolean verifyStorageBinFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(6).click();
		storageBinFilterBox.sendKeys(testData);

		try {Thread.sleep(1000);   } catch (InterruptedException e) {	}
		storageBinFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = storageBinResult.getText().replaceAll("[^a-zA-Z0-9]", "");	
			if (!actualTitle.contains(testData.replaceAll("[^a-zA-Z0-9]", ""))) {
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public boolean verifyProfitCenterFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(6).click();
		profitCenterFilterBox.sendKeys(testData);

		try {Thread.sleep(1000);   } catch (InterruptedException e) {	}
		profitCenterFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = profitCenterResult.getText().replaceAll("[^a-zA-Z0-9]", "");	
			if (!actualTitle.contains(testData.replaceAll("[^a-zA-Z0-9]", ""))) {
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public boolean verifyMovingAveragePriceFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(6).click();
		movingAveragePriceFilterBox.sendKeys(testData);

		try {Thread.sleep(1000);   } catch (InterruptedException e) {	}
		movingAveragePriceFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = movingAveragePriceResult.getText().replaceAll("[^a-zA-Z0-9]", "");	
			if (!actualTitle.contains(testData.replaceAll("[^a-zA-Z0-9]", ""))) {
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public boolean verifyPriceControlIndicatorFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(6).click();
		priceControlIndicatorFilterBox.sendKeys(testData);

		try {Thread.sleep(1000);   } catch (InterruptedException e) {	}
		priceControlIndicatorFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = priceControlIndicatorResult.getText().replaceAll("[^a-zA-Z0-9]", "");	
			if (!actualTitle.contains(testData.replaceAll("[^a-zA-Z0-9]", ""))) {
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public boolean verifyPriceUnitFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(6).click();
		priceUnitFilterBox.sendKeys(testData);

		try {Thread.sleep(1000);   } catch (InterruptedException e) {	}
		priceUnitFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = priceUnitResult.getText().replaceAll("[^a-zA-Z0-9]", "");	
			if (!actualTitle.contains(testData.replaceAll("[^a-zA-Z0-9]", ""))) {
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public boolean verifyStandardPriceFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(6).click();
		standardPriceFilterBox.sendKeys(testData);

		try {Thread.sleep(1000);   } catch (InterruptedException e) {	}
		standardPriceFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = standardPriceResult.getText().replaceAll("[^a-zA-Z0-9]", "");	
			if (!actualTitle.contains(testData.replaceAll("[^a-zA-Z0-9]", ""))) {
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public boolean verifyValuationCategoryFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(6).click();
		valuationCategoryFilterBox.sendKeys(testData);

		try {Thread.sleep(1000);   } catch (InterruptedException e) {	}
		valuationCategoryFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = valuationCategoryResult.getText().replaceAll("[^a-zA-Z0-9]", "");	
			if (!actualTitle.contains(testData.replaceAll("[^a-zA-Z0-9]", ""))) {
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public boolean verifyValuationClassFilter(String testData) {
		TestUtil.waitAndClickElement(ERPFieldsFilter);
		erpFieldsFilter.get(6).click();
		valuationClassFilterBox.sendKeys(testData);

		try {Thread.sleep(1000);   } catch (InterruptedException e) {	}
		valuationClassFilterBox.sendKeys(Keys.ENTER);	
		TestUtil.waitAndClickElement(btnFilterSearch.get(0));
		TestUtil.waitAndClickElement(closeERPFilter);

		boolean allMatch = true;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);
			TestUtil.waitAndClickElement(viewERPInfo);
			String actualTitle = valuationClassResult.getText().replaceAll("[^a-zA-Z0-9]", "");	
			if (!actualTitle.contains(testData.replaceAll("[^a-zA-Z0-9]", ""))) {
				allMatch = false;
				break;
			}      }
		return allMatch;
	}

	public boolean verifyAuditChange() {
		boolean actValue = false;
		for (WebElement element : viewMores) {
			TestUtil.waitAndClickElement(element);

			TestUtil.waitAndClickElement(auditBtn);
			TestUtil.switchNewWindow();
			TestUtil.waitAndClickElement(changeBtn);

			if (requestType.getText()=="New Request") {
				actValue = alertMesg.getText().equalsIgnoreCase("There is no change.");
			}else if(requestType.getText()=="Change"){				
				actValue = changeTable.getText().equalsIgnoreCase("Previous Value");
			}
		}
		return actValue;	
	}

}
