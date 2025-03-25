package com.qa.ExtentReportListener;

import java.io.InputStream;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;

public class WebScraperWithChildLinks {
    public static void main(String[] args) {
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--headless"); // Run in headless mode
        WebDriver driver = new ChromeDriver(opt);

        try {
            String url = "https://finance.yahoo.com/topic/stock-market-news/";
            driver.get(url);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            JavascriptExecutor js = (JavascriptExecutor) driver;

            // Scroll for 4 seconds
            long startTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < 4000) {
                js.executeScript("window.scrollBy(0, 1000);");
                Thread.sleep(1000);
            }

            // Extract valid hyperlinks
            List<WebElement> links = driver.findElements(By.tagName("a"));

            System.out.println("\n=== Extracting Article Links ===");
            for (WebElement link : links) {
                String href = link.getAttribute("href");
                String linkText = link.getText().trim();

                // Validate link
                if (href != null && linkText.length() > 20 && href.startsWith("https://finance.yahoo.com")) {
                    System.out.println("Opening article: " + linkText);
                    scrapeChildPage(driver, href);
                }
            }

        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }

    public static void scrapeChildPage(WebDriver driver, String url) {
        try {
            driver.get(url);

            // Wait for content to load
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

            // Extract full page source
            String pageSource = driver.getPageSource();

            // Use Jsoup to extract text
            Document doc = Jsoup.parse(pageSource);
            String extractedText = doc.text();

            // Detect sentences using Apache OpenNLP
            detectSentences(extractedText);

        } catch (Exception e) {
            System.out.println("Error in child page scraping: " + e.getMessage());
        }
    }

    public static void detectSentences(String text) {
        try {
            // Load OpenNLP sentence detection model from resources
            InputStream modelStream = WebScraperWithChildLinks.class
                    .getClassLoader()
                    .getResourceAsStream("opennlp.bin");

            if (modelStream == null) {
                throw new RuntimeException("Sentence model file not found in resources.");
            }

            SentenceModel model = new SentenceModel(modelStream);
            SentenceDetectorME sentenceDetector = new SentenceDetectorME(model);

            // Detect sentences
            String[] sentences = sentenceDetector.sentDetect(text);

            // Print detected sentences
            System.out.println("\n=== Extracted Sentences from Article ===");
            for (String sentence : sentences) {
                System.out.println(sentence);
            }

        } catch (Exception e) {
            System.out.println("Error in sentence detection: " + e.getMessage());
        }
    }
}
