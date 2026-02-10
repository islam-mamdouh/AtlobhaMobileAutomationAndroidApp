package com.atlobha.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    
    protected AndroidDriver driver;
    protected WebDriverWait wait;
    
    // Constructor
    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    // Common wait methods
    protected void waitForElementVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    protected void waitForElementClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    
    protected void waitForElementInvisible(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
    
    // Common action methods
    protected void click(By locator) {
        waitForElementClickable(locator);
        driver.findElement(locator).click();
    }
    
    protected void enterText(By locator, String text) {
        waitForElementVisible(locator);
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }
    
    protected String getText(By locator) {
        waitForElementVisible(locator);
        return driver.findElement(locator).getText();
    }
    
    protected boolean isElementDisplayed(By locator) {
        try {
            waitForElementVisible(locator);
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    protected boolean isElementEnabled(By locator) {
        try {
            return driver.findElement(locator).isEnabled();
        } catch (Exception e) {
            return false;
        }
    }
    
    // Scroll methods
    protected void scrollDown() {
        // TODO: Implement scroll down using touch actions
    }
    
    protected void scrollUp() {
        // TODO: Implement scroll up using touch actions
    }
}
