package com.midas.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
<<<<<<< HEAD
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
=======
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
>>>>>>> 2ba595c (updates)
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
<<<<<<< HEAD
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
=======
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
>>>>>>> 2ba595c (updates)
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.midas.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 20;
<<<<<<< HEAD
	public static long WAIT = 20;
	 static String currentDir = System.getProperty("user.dir");
	public static String TESTDATA_SHEET_PATH = currentDir+ "/src/main/java/com/midas/qa/testdata/Data.xlsx";
 
	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;
=======
	//	public static long WAIT = 30;
	static String currentDir = System.getProperty("user.dir");
	public static String TESTDATA_SHEET_PATH = currentDir+ "/src/main/java/com/midas/qa/testdata/Data.xlsx";

	static Workbook book;
	static Sheet sheet;
//	static JavascriptExecutor js;
//	public static WebDriverWait wait ;

>>>>>>> 2ba595c (updates)

	public static WebDriver switchNewWindow() {
		String currentwindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for (String windowHandle : windows) {
<<<<<<< HEAD
			if (!windowHandle.equals(currentwindow))  { 
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
=======
			if (!windowHandle.equals(currentwindow)) {
				driver.switchTo().window(windowHandle); // Switch to new window
				break;
			}	}
		return driver;
	}

	public static Object[] readColumnData(String sheetName, String columnName) {


		ArrayList<Object> columnData = new ArrayList<>();
		FileInputStream fis = null;
		XSSFWorkbook workbook = null;

		try {
			// Open the Excel file
			fis = new FileInputStream(TESTDATA_SHEET_PATH);
			workbook = new XSSFWorkbook(fis);

			// Get the sheet by name
			Sheet sheet = workbook.getSheet(sheetName);
			if (sheet == null) {
				System.err.println("Sheet not found: " + sheetName);
				return new Object[0];  // Return empty array if sheet not found
			}

			// Get the header row (assuming the first row contains the column names)
			Row headerRow = sheet.getRow(0);
			int columnIdx = -1;

			// Find the column index by matching the column name
			for (Cell cell : headerRow) {
				if (cell.getStringCellValue().equalsIgnoreCase(columnName)) {
					columnIdx = cell.getColumnIndex();
					break;
				}
			}

			if (columnIdx == -1) {
				System.err.println("Column not found: " + columnName);
				return new Object[0];  // Return empty array if column not found
			}

			// Iterate through the rows and extract the data from the specified column
			Iterator<Row> rowIterator = sheet.iterator();
			// Skip the header row
			rowIterator.next();

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Cell cell = row.getCell(columnIdx);
				if (cell != null) {
					// Determine the type of the cell and add the value to the list accordingly
					switch (cell.getCellType()) {
					case STRING:
						columnData.add(cell.getStringCellValue());
						break;
					case NUMERIC:
						if (DateUtil.isCellDateFormatted(cell)) {
							columnData.add(cell.getDateCellValue());  // Add date if it's a date cell
						} else {
							columnData.add(cell.getNumericCellValue());  // Add numeric value
						}
						break;
					case BOOLEAN:
						columnData.add(cell.getBooleanCellValue());
						break;
					case FORMULA:
						columnData.add(cell.getCellFormula());  // Add formula if it's a formula cell
						break;
					default:
						columnData.add(null);  // Add null if cell type is unsupported
						break;
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (workbook != null) {
					workbook.close();
				}
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// Convert ArrayList to Object[] and return
		return columnData.toArray();
	}
	public static Object[][] readColumn(String sheetName) {
		try (FileInputStream file = new FileInputStream(new File(TESTDATA_SHEET_PATH))) {
			book = WorkbookFactory.create(file);
			sheet = book.getSheet(sheetName);

			int totalRows = sheet.getLastRowNum();
			int totalCols = sheet.getRow(0).getLastCellNum();

			Object[][] data = new Object[totalRows][totalCols];

			for (int i = 0; i < totalRows; i++) {
				Row row = sheet.getRow(i + 1); // Get the row
				for (int k = 0; k < totalCols; k++) {
					Cell cell = (row != null) ? row.getCell(k, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK) : null;
					data[i][k] = (cell != null) ? cell.toString() : "";
				}
			}
			return data;
		} catch (IOException e) {
			e.printStackTrace();
			return new Object[0][0]; // Return empty array on failure
		}
	}           

	public static String[] getTestData1Array(String sheetName) {
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

		// Get the sheet from the workbook
		sheet = book.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum(); // Get the total number of rows
		String[] data = new String[rowCount]; // Create an array to store column A data

		// Iterate through each row and fetch column A data
		for (int i = 0; i < rowCount; i++) {
			data[i] = sheet.getRow(i + 1).getCell(0).toString(); // Read cell data from column A (index 0)
		}
		return data;    
	}          
	public static Object[][] getTestData(String testCaseName) {
		List<Object[]> dataList = new ArrayList<>();

		try (FileInputStream file = new FileInputStream(new File(TESTDATA_SHEET_PATH));
				Workbook workbook = new XSSFWorkbook(file)) {

			Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
			Iterator<Row> rowIterator = sheet.iterator();

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Cell testCaseCell = row.getCell(0);

				if (testCaseCell != null && testCaseCell.getStringCellValue().equalsIgnoreCase(testCaseName)) {
					int totalColumns = row.getLastCellNum(); // Get total columns

					// Convert row data to Object array
					List<Object> rowData = new ArrayList<>();
					for (int i = 1; i < totalColumns; i++) {
						Cell cell = row.getCell(i);
						rowData.add(cell != null ? cell.getStringCellValue() : "");
					}
					dataList.add(rowData.toArray());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dataList.toArray(new Object[0][0]);
	}
	public static Object[][] getTestData2Array(String sheetName) {
>>>>>>> 2ba595c (updates)
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
<<<<<<< HEAD
		
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
=======

		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

>>>>>>> 2ba595c (updates)
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
<<<<<<< HEAD
    
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

=======
	public static void WaitAndSwitchframe(WebElement element) {
	//	wait = new WebDriverWait(driver,Duration.ofSeconds(25));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}
	public static void WaitAndSwitchframe(int n) {
	
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(n));
	}

	public static void waitAndClickElement(WebElement Element) {
		wait.until(ExpectedConditions.visibilityOf(Element));
		wait.until(ExpectedConditions.elementToBeClickable(Element));
		js.executeScript("arguments[0].click();", Element);
	}

	public static void waitforElementToLoad(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static String waitAndGetAttribute(WebElement element,String attribute) {
		return	wait.until(ExpectedConditions.visibilityOf(element)).getAttribute(attribute);
	}

	public static void waitAndClickStaleElement(WebElement Element) {
		wait.until(ExpectedConditions.stalenessOf(Element));
		js.executeScript("arguments[0].click();", Element);
	}

	public static String waitAndGetText(WebElement Element) {
		wait.until(ExpectedConditions.visibilityOf(Element));
		return Element.getText();
	}

	public static void waitToLoadAllElements(List<WebElement> Elements) {		
		wait.until(ExpectedConditions.visibilityOfAllElements(Elements));
	}

	public static void waitForAllStaleElement(List<WebElement> Elements) {
		wait.until(ExpectedConditions.visibilityOfAllElements(Elements));		
	}


	public static WebDriver switchAndWaitNewWindowTitle() {
		String currentwindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for (String windowHandle : windows) {
			if (!windowHandle.equals(currentwindow)) {
				driver.switchTo().window(windowHandle); // Switch to new window
				break;
			}	}
		return driver;

	}
	public static void switchtoDefaultContent() {
		driver.switchTo().defaultContent();
	}
	public static void waitAndSendkeys(WebElement Element, String testData) {
		wait.until(ExpectedConditions.visibilityOf(Element));
		((JavascriptExecutor) driver).executeScript("arguments[0].value='"+testData+"'; arguments[0].dispatchEvent(new Event('input'));", Element);	
	}
	public static void scrollAndClick(WebElement element) {
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
		 js.executeScript("arguments[0].click();", element);
	}
<<<<<<< HEAD
=======

	public static void waitForAllElementVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
>>>>>>> 52f96a3 (updated code)
>>>>>>> 2ba595c (updates)
}
