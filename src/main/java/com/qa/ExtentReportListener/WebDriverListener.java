package com.qa.ExtentReportListener;

import org.openqa.selenium.*;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import com.midas.qa.util.Log;

public class WebDriverListener extends AbstractWebDriverEventListener {

    @Override
    public void beforeAlertAccept(WebDriver driver) {
        Log.info("Before accepting alert.");
    }

    @Override
    public void afterAlertAccept(WebDriver driver) {
        Log.info("After accepting alert.");
    }

    @Override
    public void beforeAlertDismiss(WebDriver driver) {
        Log.info("Before dismissing alert.");
    }

    @Override
    public void afterAlertDismiss(WebDriver driver) {
        Log.info("After dismissing alert.");
    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
  //      Log.info("Navigating to: " + url);
    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
  //      Log.info("Navigated to: " + url);
    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {
        Log.info("Navigating back.");
    }

    @Override
    public void afterNavigateBack(WebDriver driver) {
        Log.info("Navigated back.");
    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {
        Log.info("Navigating forward.");
    }

    @Override
    public void afterNavigateForward(WebDriver driver) {
        Log.info("Navigated forward.");
    }

    @Override
    public void beforeNavigateRefresh(WebDriver driver) {
        Log.info("Refreshing page.");
    }

    @Override
    public void afterNavigateRefresh(WebDriver driver) {
        Log.info("Page refreshed.");
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        Log.info("Finding element: " + by.toString());
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        Log.info("Element found: " + by.toString());
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        Log.info("Clicking on element: " + element.toString());
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        Log.info("Clicked on element: " + element.toString());
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        Log.info("Before changing value of element: " + element.toString());
    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        Log.info("After changing value of element: " + element.toString());
    }

    @Override
    public void beforeScript(String script, WebDriver driver) {
        Log.info("Executing script: " + script);
    }

    @Override
    public void afterScript(String script, WebDriver driver) {
        Log.info("Executed script: " + script);
    }

    @Override
    public void beforeSwitchToWindow(String windowName, WebDriver driver) {
        Log.info("Switching to window: " + windowName);
    }

    @Override
    public void afterSwitchToWindow(String windowName, WebDriver driver) {
        Log.info("Switched to window: " + windowName);
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        Log.info("Exception occurred: " + throwable.getMessage());
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> target) {
        Log.info("Taking screenshot.");
    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
        Log.info("Screenshot captured.");
    }

    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {
        Log.info("Getting text from element: " + element.toString());
    }

    @Override
    public void afterGetText(WebElement element, WebDriver driver, String text) {
        Log.info("Text retrieved: " + text);
    }
}