package com.midas.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.ExtentReportListener.ExtentManager;
import com.qa.ExtentReportListener.WebDriverListener;

@Listeners({com.midas.qa.util.ExtentReportListener.class})
public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait ;
	public static JavascriptExecutor js;
	public static ThreadLocal<ExtentTest> test;
	public  static EventFiringWebDriver e_driver;
	public static WebDriverListener eventListener;
	public static ExtentReports extent;
	
	static String role = "requester";
	public TestBase(){
		
		try {
			test = new ThreadLocal<>();
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/midas/qa/config/config.properties");
			prop.load(ip);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getUsername(String role) {
		return prop.getProperty(role + ".username");
	}

	public static String getPassword(String role) {
		return prop.getProperty(role + ".password");
	}

	public static void initialization(){
		String browserName = prop.getProperty("browser");

		if(browserName.equalsIgnoreCase("chrome") && role.equalsIgnoreCase("requester")){
			ChromeOptions options = new ChromeOptions();
			//		options.addArguments("--headless");
			driver = new ChromeDriver(options); 
		} else if(browserName.equalsIgnoreCase("chrome") && role.equalsIgnoreCase("cataloger")){
			ChromeOptions options = new ChromeOptions();
			//		options.addArguments("--headless");
			driver = new ChromeDriver(options); 

		}
		else if(browserName.equalsIgnoreCase("firefox")){			
			driver = new FirefoxDriver(); 
		}	
		else if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		
		    e_driver = new EventFiringWebDriver(driver);
	        eventListener = new WebDriverListener();
	        e_driver.register(eventListener);
	        driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.get(prop.getProperty("url"));
		wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		js = ((JavascriptExecutor) driver);
	
	}
	    @BeforeSuite
	    public void beforeSuite() throws IOException {
	        extent = ExtentManager.getInstance();  // Initialize Extent Report
	    }
	    @AfterSuite
	    public void afterSuite() {
	        extent.flush();  // Flush Extent Reports
	        driver.quit();
	    }

}
