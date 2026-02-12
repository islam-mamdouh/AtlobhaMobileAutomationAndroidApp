package com.atlobha.tests;

import com.atlobha.utils.ScreenshotHelper;   // NEW IMPORT
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.openqa.selenium.By;
import org.testng.ITestResult;                 // NEW IMPORT
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import java.io.InputStream;
import java.util.Properties;


public class BaseTest {
    protected AndroidDriver driver;

    protected Properties config;   // Stores loaded configuration

@BeforeMethod
    public void setUp() throws MalformedURLException {
    // STEP 1: Create Properties object
    config = new Properties();
    
    // STEP 2: Load config.properties file
    try (InputStream input = getClass().getClassLoader()
            .getResourceAsStream("config.properties")) {
        
        if (input == null) {
            throw new RuntimeException("❌ config.properties not found in resources folder!");
        }
        
        config.load(input);  // Loads all key-value pairs
        System.out.println("✅ Configuration loaded successfully");
        
    } catch (Exception e) {
        throw new RuntimeException("❌ Failed to load config.properties: " + e.getMessage(), e);
    }

    // STEP 3: Use config values instead of hardcoded strings
    UiAutomator2Options options = new UiAutomator2Options()
            .setDeviceName(config.getProperty("device.name"))           // Reads from config
            .setPlatformName("Android")
            .setPlatformVersion("16")
            .setAppPackage(config.getProperty("app.package"))           // Reads from config
            .setAppActivity(config.getProperty("app.activity"))         // Reads from config
            .setAutoGrantPermissions(true)
            .setNoReset(Boolean.parseBoolean(config.getProperty("no.reset")));  // Converts string to boolean

    // CRITICAL FIX: Handle dynamic activity loading
    options.setCapability("appium:appWaitActivity", "*");

    // STEP 4: Create driver with config URL
    driver = new AndroidDriver(
        new URL(config.getProperty("appium.server.url")),  // Reads from config
        options
    );
    
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    System.out.println("✅ Driver initialized for: " + config.getProperty("device.name"));
}

    @AfterMethod
    public void onTestComplete(ITestResult testResult) {
        // Take screenshot on failure BEFORE quitting the driver
        if (testResult.getStatus() == ITestResult.FAILURE) {
            System.out.println("❌ Test FAILED: " + testResult.getName());
            if (driver != null) {
                ScreenshotHelper.takeScreenshot(driver, testResult.getName());
            }
        }

        // Now quit the driver
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