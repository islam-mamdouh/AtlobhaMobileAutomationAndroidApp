package com.atlobha.tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
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
                .setDeviceName("Android Emulator")
                .setPlatformName("Android")
                .setAppPackage("com.atlobha.atlobha")
                .setAppActivity("com.otlobha.otlobha.splash.view.SplashActivity")
                .setAutoGrantPermissions(true)
                .setNoReset(true);
        options.setCapability("appium:appWaitActivity", "*");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}