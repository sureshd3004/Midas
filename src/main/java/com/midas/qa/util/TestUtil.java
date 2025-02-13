package com.midas.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.midas.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 20;
	//	public static long WAIT = 30;
	static String currentDir = System.getProperty("user.dir");
	public static String TESTDATA_SHEET_PATH = currentDir+ "/src/main/java/com/midas/qa/testdata/Data.xlsx";

	static Workbook book;
	static Sheet sheet;
//	static JavascriptExecutor js;
//	public static WebDriverWait wait ;


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

	public static void waitForAllElementVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
