package com.qa.ExtentReportListener;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test {

	public static void main(String[] args) {

		ChromeOptions opt = new ChromeOptions();
	//	opt.addArguments("--headless");
		WebDriver driver = new ChromeDriver(opt);
		
		String[]	urls = {"https://abc.com" };
		for (String url : urls) {
			driver.get(url);
			driver.manage().timeouts().pageLoadTimeout(4, TimeUnit.SECONDS);
			try {
				String data =  driver.findElement(By.tagName("body")).getText();
				System.out.println(data);
			} catch (Exception e) { System.out.println("Exception at taking the text"); }
		}   }

}
