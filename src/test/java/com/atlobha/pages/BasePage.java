package com.atlobha.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected AndroidDriver driver;
    protected WebDriverWait wait;
    protected WebDriverWait shortWait;

    public BasePage(AndroidDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    this.shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
     }

    // ================================================================
    // ===== CORE ACTION METHODS (with explicit waits) ================
    // ================================================================

    protected void click(By locator) {
    wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected String getText(By locator) {
    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    protected void enterText(By locator, String text) {
    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    element.click();
    element.clear();
    element.sendKeys(text);
    }

    // ================================================================
    // ===== ELEMENT STATE CHECKS =====================================
    // ================================================================

    protected boolean isElementDisplayed(By locator) {
        try {
            shortWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    protected boolean isElementEnabled(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isEnabled();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    protected boolean isElementSelected(By locator) {
        try {
            return driver.findElement(locator).isSelected();
        } catch (Exception e) {
            return false;
        }
    }

    // ================================================================
    // ===== WAIT HELPERS =============================================
    // ================================================================

    protected WebElement waitForElement(By locator, int seconds) {
        WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return customWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForClickable(By locator, int seconds) {
        WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return customWait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected boolean waitForElementToDisappear(By locator, int seconds) {
        try {
            WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            return customWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void waitInSeconds(int seconds) {
       try {
           Thread.sleep(seconds * 1000);
        }  catch (InterruptedException e) {
        e.printStackTrace();
        }
    }

    // ================================================================
    // ===== FIND ELEMENTS WITH WAITS =================================
    // ================================================================

    protected WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected List<WebElement> findElements(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElements(locator);
    }

    protected List<WebElement> findElementsNoWait(By locator) {
        return driver.findElements(locator);
    }

    // ================================================================
    // ===== SWIPE & SCROLL METHODS ===================================
    // ================================================================

    protected void swipe(int startX, int startY, int endX, int endY, int durationMs) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(durationMs), PointerInput.Origin.viewport(), endX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(List.of(swipe));
    }

    protected void scrollDown() {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.7);
        int endY = (int) (size.height * 0.3);
        swipe(startX, startY, startX, endY, 500);
    }

    protected void scrollUp() {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.3);
        int endY = (int) (size.height * 0.7);
        swipe(startX, startY, startX, endY, 500);
    }

    protected void pullToRefresh() {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.2);
        int endY = (int) (size.height * 0.8);
        swipe(startX, startY, startX, endY, 800);
    }

    protected void tapByCoordinates(int x, int y) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(List.of(tap));
    }
}