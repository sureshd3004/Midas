package com.midas.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import com.midas.qa.util.WebEventListener;

@Listeners(com.qa.ExtentReportListener.ExtentReporter.class)
public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static WebDriverWait wait ;
	public static JavascriptExecutor js;
	static String role = "requester";
	public TestBase(){
		try {
	//		wait = new WebDriverWait(driver,Duration.ofSeconds(25));
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/midas/qa/config/config.properties");
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.get(prop.getProperty("url"));
		wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		js = ((JavascriptExecutor) driver);
	}

	@AfterTest
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}
