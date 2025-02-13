package com.midas.qa.testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.midas.qa.base.TestBase;
import com.midas.qa.pages.HomePage;
import com.midas.qa.pages.LoginPage;
import com.midas.qa.pages.SearchPage;
import com.midas.qa.pages.SearchResultPage;
import com.midas.qa.util.TestUtil;


public class SearchResultPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	SearchPage searchPage;
	SearchResultPage   searchResultPage;

	public SearchResultPageTest(){
		super();			
	}

	@BeforeMethod
	public void setUp() throws InterruptedException, IOException {		
		initialization();
		searchPage = new SearchPage();
		loginPage = new LoginPage();
		searchResultPage = new SearchResultPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		TestUtil.WaitAndSwitchframe(0);
		searchPage = homePage.clickOnSearchIcon();
		TestUtil.switchNewWindow();
		searchPage.searchBoxTest("TEST");
	}

	@Test(priority=1 , description = "TC006")
	public void verifySearchResultPageTitle(){
		Assert.assertEquals(searchResultPage.verifySearchTitle() , "MidasMasterSearch");
	}
	@Test(priority=2 , description = "TC008",enabled = false)
	public void verifySearchResultExport() {		
		Assert.assertEquals(searchResultPage.downloadExport(), "File not downloaded");
	}

	@Test(description = "TC009")
	public void verifyFilterCOloumns() {
		Assert.assertEquals(searchResultPage.searchResultColoumns(), 9);

	}
	@Test(description = "TC009")
	public void filtersClickTest() throws InterruptedException {
		
		Assert.assertEquals(searchResultPage.filtersClickTest(), "done");		
	}
	@Test
	public void additionalSettingsRequestNumber(String testData){

		Assert.assertEquals(searchResultPage.verifyAdditionalSettingsRequestNumberSearchPage( testData), true);
	}
	@Test
	public void additionalSettingsMaterialNumber(String testData){

		Assert.assertEquals(searchResultPage.verifyAdditionalSettingsMaterialNumberSearchPage( testData), true);
	}
	@Test
	public void additionalSettingsManufacturer(String testData){

		Assert.assertEquals(searchResultPage.verifyAdditionalSettingsManufacturerSearchPage( testData), true);
	}
	@Test( dataProvider = "getTestData")
	public void additionalSettingsPartNumber(String testData){

		Assert.assertEquals(searchResultPage.verifyAdditionalSettingsPartNumberSearchPage(testData), true);
	}
	@Test
	public void verifyPaginationButtons() {
		Assert.assertEquals(searchResultPage.verifyPaginationButtons(), true);
	}
	@Test(enabled = true,dataProvider = "getTestData")
	public void verifyERPFieldsIndustrySectorFilter(String testData) {
		Assert.assertEquals(searchResultPage.verifyERPFieldsIndustrySectorFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData")
	public void verifyERPFieldsMaterialGroupFilter(String testData) {
		Assert.assertEquals(searchResultPage.verifyERPFieldsMaterialGroupFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData")
	public void verifyERPFieldsMaterialTypeFilter(String testData) {
		Assert.assertEquals(searchResultPage.verifyERPFieldsMaterialTypeFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData")
	public void verifyERPFieldsValuationTypeFilter(String testData) {
		Assert.assertEquals(searchResultPage.verifyERPFieldsValuationTypeFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData")
	public void verifyERPFieldsCriticalScoreFilter(String testData) {
		Assert.assertEquals(searchResultPage.verifyERPFieldsCriticalScoreFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData")
	public void verifyERPFieldsDemandEstYearlyDemandFilter(String testData) {
		Assert.assertEquals(searchResultPage.verifyERPFieldsDemandEstYearlyDemandFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData")
	public void verifyERPFieldsDemandQtyOrdersFilter(String testData) {
		Assert.assertEquals(searchResultPage.verifyERPFieldsDemandQtyOrdersFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData")
	public void verifyERPFieldsDemandQtyPerOrderFilter(String testData) {
		Assert.assertEquals(searchResultPage.verifyERPFieldsDemandQtyPerOrderFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData")
	public void verifyERPFieldsMaintParamPredBreakdownDaysFilter(String testData) {
		Assert.assertEquals(searchResultPage.verifyERPFieldsMaintParamPredBreakdownDaysFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData")
	public void verifyERPFieldsMaintParamShelfLifeMonthsFilter(String testData) {
		Assert.assertEquals(searchResultPage.verifyERPFieldsMaintParamShelfLifeMonthsFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData")
	public void verifyERPFieldsMaintParamTotQtyInstFilter(String testData) {
		Assert.assertEquals(searchResultPage.verifyERPFieldsMaintParamTotQtyInstFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData")
	public void verifyERPFieldsMaintParamSetSizeFilter(String testData) {
		Assert.assertEquals(searchResultPage.verifyERPFieldsMaintParamSetSizeFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData")
	public void verifyERPFieldsMaintParamMTBFFilter(String testData) {
		Assert.assertEquals(searchResultPage.verifyERPFieldsMaintParamMTBFFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData")
	public void verifyCriticalPartFilter(String testData) {
		Assert.assertEquals(searchResultPage.verifyCriticalPartFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData")
	public void verifyPurchasingGroupFilter(String testData) {
		Assert.assertEquals(searchResultPage.verifyPurchasingGroupFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData")
	public void verifyABCIndicatorFilter(String testData) {                                                       //regex
		Assert.assertEquals(searchResultPage.verifyABCIndicatorFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData") 
	public void verifyLotSizeProcedureFilter(String testData) {                                                       
		Assert.assertEquals(searchResultPage.verifyLotSizeProcedureFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData") 
	public void verifyMaterialStatusCodeFilter(String testData) {                                                       
		Assert.assertEquals(searchResultPage.verifyMaterialStatusCodeFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData") 
	public void verifyMaximumLotSizeFilter(String testData) {                                                       
		Assert.assertEquals(searchResultPage.verifyMaximumLotSizeFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData") 
	public void verifyMRPGroupFilter(String testData) {                                                       
		Assert.assertEquals(searchResultPage.verifyMRPGroupFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData") 
	public void verifyMRPTypeFilter(String testData) {                                                       
		Assert.assertEquals(searchResultPage.verifyMRPTypeFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData") 
	public void verifyReOrderPointFilter(String testData) {                                                       
		Assert.assertEquals(searchResultPage.verifyReOrderPointFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData") 
	public void verifyRoundingProfileFilter(String testData) {                                                       
		Assert.assertEquals(searchResultPage.verifyRoundingProfileFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData") 
	public void verifyStorageLocationFilter(String testData) {                                                       
		Assert.assertEquals(searchResultPage.verifyStorageLocationFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData") 
	public void verifyTaktTimeFilter(String testData) {                                                       
		Assert.assertEquals(searchResultPage.verifyTaktTimeFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData") 
	public void verifyGRProcessingTimeFilter(String testData) {                                                       
		Assert.assertEquals(searchResultPage.verifyGRProcessingTimeFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData") 
	public void verifyPlannedDeliveryTimeFilter(String testData) {                                                       
		Assert.assertEquals(searchResultPage.verifyPlannedDeliveryTimeFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData") 
	public void verifyProcurementTypeFilter(String testData) {                                                       
		Assert.assertEquals(searchResultPage.verifyProcurementTypeFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData") 
	public void verifyProductionStorageLocationFilter(String testData) {                                                       
		Assert.assertEquals(searchResultPage.verifyProductionStorageLocationFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData") 
	public void verifyCCPhysInvFilter(String testData) {                                                       
		Assert.assertEquals(searchResultPage.verifyCCPhysInvFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData") 
	public void verifyExpirationDateFilter(String testData) {                                                       
		Assert.assertEquals(searchResultPage.verifyExpirationDateFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData") 
	public void verifyLabelFormFilter(String testData) {                                                       
		Assert.assertEquals(searchResultPage.verifyLabelFormFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData") 
	public void verifyLabelTypeFilter(String testData) {                                                       
		Assert.assertEquals(searchResultPage.verifyLabelTypeFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData") 
	public void verifyPeriodIndForSledFilter(String testData) {                                                       
		Assert.assertEquals(searchResultPage.verifyPeriodIndForSledFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData") 
	public void verifyStorageBinFilter(String testData) {                                                       
		Assert.assertEquals(searchResultPage.verifyStorageBinFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData") 
	public void verifyProfitCenterFilter(String testData) {                                                       
		Assert.assertEquals(searchResultPage.verifyProfitCenterFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData") 
	public void verifyMovingAveragePriceFilter(String testData) {                                                       
		Assert.assertEquals(searchResultPage.verifyMovingAveragePriceFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData") 
	public void verifyPriceControlIndicatorFilter(String testData) {                                                       
		Assert.assertEquals(searchResultPage.verifyPriceControlIndicatorFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData") 
	public void verifyPriceUnitFilter(String testData) {                                                       
		Assert.assertEquals(searchResultPage.verifyPriceUnitFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData") 
	public void verifyStandardPriceFilter(String testData) {                                                       
		Assert.assertEquals(searchResultPage.verifyStandardPriceFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData") 
	public void verifyValuationCategoryFilter(String testData) {                                                       
		Assert.assertEquals(searchResultPage.verifyValuationCategoryFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData") 
	public void verifyValuationClassFilter(String testData) {                                                       
		Assert.assertEquals(searchResultPage.verifyValuationClassFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData") 
	public void verifySafetyStockFilter(String testData) {                                                       
		Assert.assertEquals(searchResultPage.verifySafetyStockFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData") 
	public void verifyStorageLocationForEPFilter(String testData) {                                                       
		Assert.assertEquals(searchResultPage.verifyStorageLocationForEPFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData") 
	public void verifyAvailabilityCheckFilter(String testData) {                                                       
		Assert.assertEquals(searchResultPage.verifyAvailabilityCheckFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData") 
	public void verifySpecialProcurementFilter(String testData) {                                                       
		Assert.assertEquals(searchResultPage.verifySpecialProcurementFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData") 
	public void verifyStorageCostsCodeFilter(String testData) {                                                       
		Assert.assertEquals(searchResultPage.verifyStorageCostsCodeFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData") 
	public void verifyRoundingValueFilter(String testData) {                                                       
		Assert.assertEquals(searchResultPage.verifyRoundingValueFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData") 
	public void verifyMRPControllerFilter(String testData) {                                                       
		Assert.assertEquals(searchResultPage.verifyMRPControllerFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData") 
	public void verifyMaximumStockLevelFilter(String testData) {                                                       
		Assert.assertEquals(searchResultPage.verifyMaximumStockLevelFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData") 
	public void verifyMinimumLotSizeFilter(String testData) {                                                       
		Assert.assertEquals(searchResultPage.verifyMinimumLotSizeFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData") 
	public void verifyLSIndependentCostsFilter(String testData) {                                                       
		Assert.assertEquals(searchResultPage.verifyLSIndependentCostsFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData") 
	public void verifyFixedLotSizeFilter(String testData) {                                                       
		Assert.assertEquals(searchResultPage.verifyFixedLotSizeFilter(testData), true);
	}
	@Test(enabled = true,dataProvider = "getTestData") 
	public void verifyAssemblyScrapFilter(String testData) {                                                       
		Assert.assertEquals(searchResultPage.verifyAssemblyScrapFilter(testData), true);
	}
	@Test(enabled = true, dataProvider = "getTestData")
	public void verifyPlantFilter(String testData) {
		Assert.assertEquals(searchResultPage.verifyPlantFilter(testData), true);
	}
	@Test( dataProvider = "getTestData")
	public void verifyStatusFilter(String testData) {
		Assert.assertEquals(searchResultPage.verifyStatusFilter(testData), true);
	}
	@Test(enabled = true, dataProvider = "getTestData")
	public void verifyManufactFilter(String testData) {
		Assert.assertEquals(searchResultPage.verifyManufacurFilter(testData), true);
	}
	@Test(dataProvider = "getTestData")
	public void verifyPartNumberFilter(String testData) {
		Assert.assertEquals(searchResultPage.verifyPartNumberFilter(testData), true);
	}
	@Test(enabled = true, dataProvider = "getTestData")
	public void verifyNounModifierFilter(String testData) {
		Assert.assertEquals(searchResultPage.verifyNounModifierFilter(testData), true);
	}
	
	@DataProvider(name = "getTestData")
	public String[] getTestData(Method method){
		String sheetName = "SearchData";
		String coloumn = method.getName();
		Object[] data = TestUtil.readColumnData(sheetName,coloumn);
		// Convert Object[] to String[]
	    String[] stringData = Arrays.copyOf(data, data.length, String[].class);    
	    return stringData;
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
