package com.midas.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.midas.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long WAIT = 20;
	 static String currentDir = System.getProperty("user.dir");
	public static String TESTDATA_SHEET_PATH = currentDir+ "/src/main/java/com/midas/qa/testdata/Data.xlsx";
 
	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;

	public static WebDriver switchNewWindow() {
		String currentwindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for (String windowHandle : windows) {
			if (!windowHandle.equals(currentwindow)) {
				 driver.switchTo().window(windowHandle); // Switch to new window
			        break;
			}	}
		return driver;
	}
    public static String[] readColumnA(String sheetName) {
        FileInputStream fileInputStream = null;
        Workbook workbook = null;
        String[] columnData = null;

        try {
            // Open the Excel file
            fileInputStream = new FileInputStream(new File(TESTDATA_SHEET_PATH));
            workbook = new XSSFWorkbook(fileInputStream);

            // Get the sheet by name
            Sheet sheet = workbook.getSheet(sheetName);

            // Initialize the array to hold column data
            int rowCount = sheet.getPhysicalNumberOfRows();
            columnData = new String[rowCount];

            // Iterate through all rows in the sheet
            int index = 1;
            for (Row row : sheet) {
                // Get the first column (column A = index 0)
                Cell cell = row.getCell(0);

                    switch (cell.getCellType()) {
                        case STRING:
                            columnData[index] = cell.getStringCellValue();
                            break;
                        case NUMERIC:                          
                                columnData[index] = String.valueOf(cell.getNumericCellValue());
                                break;
					default:
						break;                
                    }
                index++;
            }
        } catch (IOException e) {
            System.err.println("Error reading Excel file: " + e.getMessage());
        } return columnData;
    }
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();				
			}
		}
		return data;
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
    
	public static void WaitAndSwitchframe(int n) throws IOException {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(WAIT));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(n));
	}
	
	public static void runTimeInfo(String messageType, String message) throws InterruptedException {
		js = (JavascriptExecutor) driver;
		// Check for jQuery on the page, add it if need be
		js.executeScript("if (!window.jQuery) {"
				+ "var jquery = document.createElement('script'); jquery.type = 'text/javascript';"
				+ "jquery.src = 'https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js';"
				+ "document.getElementsByTagName('head')[0].appendChild(jquery);" + "}");
		Thread.sleep(5000);

		// Use jQuery to add jquery-growl to the page
		js.executeScript("$.getScript('https://the-internet.herokuapp.com/js/vendor/jquery.growl.js')");

		// Use jQuery to add jquery-growl styles to the page
		js.executeScript("$('head').append('<link rel=\"stylesheet\" "
				+ "href=\"https://the-internet.herokuapp.com/css/jquery.growl.css\" " + "type=\"text/css\" />');");
		Thread.sleep(5000);

		// jquery-growl w/ no frills
		js.executeScript("$.growl({ title: 'GET', message: '/' });");
//'"+color+"'"
		if (messageType.equals("error")) {
			js.executeScript("$.growl.error({ title: 'ERROR', message: '"+message+"' });");
		}else if(messageType.equals("info")){
			js.executeScript("$.growl.notice({ title: 'Notice', message: 'your notice message goes here' });");
		}else if(messageType.equals("warning")){
			js.executeScript("$.growl.warning({ title: 'Warning!', message: 'your warning message goes here' });");
		}else
			System.out.println("no error message");
		// jquery-growl w/ colorized output
//		js.executeScript("$.growl.error({ title: 'ERROR', message: 'your error message goes here' });");
//		js.executeScript("$.growl.notice({ title: 'Notice', message: 'your notice message goes here' });");
//		js.executeScript("$.growl.warning({ title: 'Warning!', message: 'your warning message goes here' });");
		Thread.sleep(5000);
	}

	public static void switchToIFrame(int i) {
		driver.switchTo().frame(i);		
	}

}
