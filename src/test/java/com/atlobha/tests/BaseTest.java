package com.atlobha.tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    protected AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName("emulator-5554")
                .setPlatformName("Android")
                .setPlatformVersion("16")
                .setAppPackage("com.atlobha.atlobha")
                .setAppActivity("com.otlobha.otlobha.MainActivity")
                .setAutoGrantPermissions(true)
                .setNoReset(true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Wait helper method
public void waitInSeconds(int seconds) {
    try {
        Thread.sleep(seconds * 1000);
        System.out.println("⏸️  Waiting " + seconds + " seconds...");
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}

    // Helper method to check if an element is displayed
    protected boolean isElementDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Helper method to check if an element is enabled
    protected boolean isElementEnabled(By locator) {
        try {
            return driver.findElement(locator).isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    // Helper method to check if an element is selected
    protected boolean isElementSelected(By locator) {
        try {
            return driver.findElement(locator).isSelected();
        } catch (Exception e) {
            return false;
        }
    }
}