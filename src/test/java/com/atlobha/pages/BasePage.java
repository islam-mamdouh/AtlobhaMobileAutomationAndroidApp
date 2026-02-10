package com.atlobha.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected AndroidDriver driver;

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
    }

    // ===== Action Methods (minimal calls, no extra waits) =====
    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    protected void enterText(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.click();
        element.sendKeys(text);
    }

    protected void clearAndEnterText(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    protected boolean isElementDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // ===== Swipe & Scroll Methods =====
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