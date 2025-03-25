package com.midas.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.midas.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 20;
	static String currentDir = System.getProperty("user.dir");
	public static String TESTDATA_SHEET_PATH = currentDir+ "/src/main/java/com/midas/qa/testdata/Data.xlsx";

	static Workbook book;
	static Sheet sheet;

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

	public static Object[] getRowDataByFirstColumnValue(String sheetName, String firstColumnValue) throws IOException {
		FileInputStream fis = new FileInputStream(TESTDATA_SHEET_PATH);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet(sheetName);

		if (sheet == null) {
			System.err.println("Sheet not found: " + sheetName);
			return new Object[0];  // Return empty array if sheet is missing
		}

		Object[] rowData = null; // To store the row data

		// Iterate through rows to find the matching first column value
		for (Row row : sheet) {
			Cell firstCell = row.getCell(0);  // First column cell

			if (firstCell != null && firstCell.getCellType() == CellType.STRING 
					&& firstCell.getStringCellValue().equalsIgnoreCase(firstColumnValue)) {

				int totalCells = row.getLastCellNum();  // Total number of cells in the row
				rowData = new Object[totalCells];

				for (int i = 0; i < totalCells; i++) {
					Cell cell = row.getCell(i);
					if (cell != null) {

						cell.setCellType(CellType.STRING);
						switch (cell.getCellType()) {
						case STRING:
							rowData[i] = cell.getStringCellValue();
							break;
						case NUMERIC:
							if (DateUtil.isCellDateFormatted(cell)) {
								rowData[i] = cell.getDateCellValue();  // Store date
							} else {
								rowData[i] = cell.getNumericCellValue();  // Store numeric value
							}
							break;
						case BOOLEAN:
							rowData[i] = cell.getBooleanCellValue();
							break;
						case FORMULA:
							rowData[i] = cell.getCellFormula();
							break;
						default:
							rowData[i] = "";  // Store empty string for blank/unsupported cells
							break;
						}
					}
				}
				break;  // Stop after finding the matching row
			}
		}

		workbook.close();
		fis.close();

		return (rowData != null) ? rowData : new Object[0];  // Return found row or empty array
	}


	public static Object readColumnLastData(String sheetName, String columnName) {
		Object lastValue = null;
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
				return null;  // Return null if sheet not found
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
				return null;  // Return null if column not found
			}

			// Iterate through the rows and get the last non-empty value
			Iterator<Row> rowIterator = sheet.iterator();
			rowIterator.next(); // Skip the header row

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Cell cell = row.getCell(columnIdx);
				if (cell != null) {
					// Determine the type of the cell and update lastValue accordingly
					switch (cell.getCellType()) {
					case STRING:
						lastValue = cell.getStringCellValue();
						break;
					case NUMERIC:
						if (DateUtil.isCellDateFormatted(cell)) {
							lastValue = cell.getDateCellValue(); // Add date if it's a date cell
						} else {
							lastValue = cell.getNumericCellValue(); // Add numeric value
						}
						break;
					case BOOLEAN:
						lastValue = cell.getBooleanCellValue();
						break;
					case FORMULA:
						lastValue = cell.getCellFormula(); // Add formula if it's a formula cell
						break;
					default:
						lastValue = null; // Set null if cell type is unsupported
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

		// Return the last value found in the column
		return lastValue;
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

	public static Object[][] getTestDataBasedColoumn(String sheetName, String targetRole) throws IOException {
		FileInputStream file = new FileInputStream(TESTDATA_SHEET_PATH);
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheet(sheetName);
		Iterator<Row> rowIterator = sheet.iterator();

		List<Object[]> filteredData = new ArrayList<>();
		int roleColumnIndex = -1;  // To find the "Role" column dynamically

		// Identify the column index for "Role"
		if (rowIterator.hasNext()) {
			Row headerRow = rowIterator.next();
			for (Cell cell : headerRow) {
				if (cell.getStringCellValue().equalsIgnoreCase("Role")) {
					roleColumnIndex = cell.getColumnIndex();
					break;
				}
			}
		}

		// If "Role" column not found, throw an error
		if (roleColumnIndex == -1) {
			throw new RuntimeException("Role column not found in Excel file");
		}

		// Read and filter rows based on the target role
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			String role = row.getCell(roleColumnIndex).getStringCellValue();
			if (role.equalsIgnoreCase(targetRole)) {
				System.out.println("role col indux = "+ roleColumnIndex);
				String userName = row.getCell(1).getStringCellValue();
				String password = row.getCell(2).getStringCellValue();
				//		System.out.println("ser & pass = "+userName+password);
				filteredData.add(new Object[]{userName, password}); // Removed 'role'
				break;
			}
		}

		workbook.close();
		file.close();

		return filteredData.toArray(new Object[0][]);
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
	public static void scrolltoElement(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static void waitForAllElementVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static String getRandomNumericString(int length) {
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			sb.append(random.nextInt(10)); // Appends a random digit (0-9)
		}return sb.toString();		    
	}

	public static void sendValueToExcel(String sheetName, String columnHeader, String requestID) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		Workbook workbook = null;

		try {
			// Open the Excel file
			File file = new File(TESTDATA_SHEET_PATH);
			fis = new FileInputStream(file);
			workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheet(sheetName);

			if (sheet == null) {
				System.err.println("Sheet not found: " + sheetName);
				return;
			}

			// Find column index based on header
			Row headerRow = sheet.getRow(0);
			int columnIndex = -1;
			for (Cell cell : headerRow) {
				if (cell.getStringCellValue().equalsIgnoreCase(columnHeader)) {
					columnIndex = cell.getColumnIndex();
					break;
				}
			}

			if (columnIndex == -1) {
				System.err.println("Column not found: " + columnHeader);
				return;
			}

			// Find the last row and append data
			int lastRowNum = sheet.getLastRowNum();
			Row newRow = sheet.createRow(lastRowNum + 1);
			Cell newCell = newRow.createCell(columnIndex, CellType.STRING);
			newCell.setCellValue(requestID);

			// Save the updated file
			fis.close(); // Close input stream before writing
			fos = new FileOutputStream(file);
			workbook.write(fos);		      
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (workbook != null) workbook.close();
				if (fos != null) fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}}

	public static void waitStale() {
		wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.tagName("body"))));
	}

	public static void takeResultsToExcel(String testData) throws IOException {
	
			WebElement tableBody = driver.findElement(By.id("plantERPMatchFields"));
			List<WebElement> rows = tableBody.findElements(By.tagName("tr"));

			// Create Excel workbook and sheet
			Workbook workbook = new XSSFWorkbook();
			Sheet sheet = workbook.createSheet(testData);

			// Iterate through rows and extract key-value pairs
			int rowIndex = sheet.getLastRowNum();
			for (WebElement row : rows) {
				List<WebElement> columns = row.findElements(By.tagName("td"));
				if (columns.size() == 2) {
					Row excelRow = sheet.createRow(rowIndex++);
					excelRow.createCell(0).setCellValue(columns.get(0).getText().trim()); // Key
					excelRow.createCell(1).setCellValue(columns.get(1).getText().trim()); // Value
				//	System.out.println(columns.get(0).getText().trim());
				}
			}

			// Write data to Excel file
			
			FileOutputStream fileOut = new FileOutputStream(testData+".xlsx");
			workbook.write(fileOut);
			fileOut.close();
			workbook.close();

			System.out.println("Data successfully written to " + testData+".xlsx");
	
	}}

