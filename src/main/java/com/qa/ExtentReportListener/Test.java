package com.qa.ExtentReportListener;

import java.util.concurrent.TimeUnit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test {
    public static void main(String[] args) {
        // Set up ChromeDriver with headless option (remove "--headless" to see the browser)
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--headless"); 
        WebDriver driver = new ChromeDriver(opt);

        try {
            String url = "https://ssruat.infoplusmdm.com/Home/midashomepage";
            driver.get(url);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            JavascriptExecutor js = (JavascriptExecutor) driver;

            // Scroll for 4 seconds
            long startTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < 4000) {
                js.executeScript("window.scrollBy(0, 1000);");
                Thread.sleep(1000);
            }

            // Get the page source after scrolling
            String pageSource = driver.getPageSource();

            // Use Jsoup to parse the page source
            Document doc = Jsoup.parse(pageSource);

            // Extract meaningful text content
            Elements elements = doc.select("h3, p, span, div");

            StringBuilder extractedText = new StringBuilder();
            for (Element element : elements) {
                String text = element.text().trim();
             //   System.out.println(text);
                if (text.length() > 65) { // Filter out short text
                    extractedText.append(text).append("\n\n");
                }
            }

            // Print extracted text
            if (extractedText.length() == 0) {
          //      System.out.println("No relevant text found.");
            } else {
                System.out.println("Extracted Text:\n" + extractedText);
            }

        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        } finally {
            driver.quit(); // Close the browser
        }
    }
}
