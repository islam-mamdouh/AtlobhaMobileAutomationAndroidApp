package com.atlobha.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest extends BaseTest {

    @Test(description = "Verify app launches successfully")
    public void testAppLaunch() {
        // Verify driver is initialized
        Assert.assertNotNull(driver, "Driver should be initialized");

        // Verify app package is correct
        String currentPackage = driver.getCurrentPackage();
        System.out.println("Current package: " + currentPackage);
        Assert.assertNotNull(currentPackage, "Current package should not be null");
    }

    @Test(description = "Verify app activity is displayed")
    public void testAppActivity() {
        String currentActivity = driver.currentActivity();
        System.out.println("Current activity: " + currentActivity);
        Assert.assertNotNull(currentActivity, "Current activity should not be null");
    }
}
