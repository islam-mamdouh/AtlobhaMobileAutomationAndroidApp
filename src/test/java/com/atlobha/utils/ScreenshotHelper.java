package com.atlobha.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.appium.java_client.android.AndroidDriver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotHelper {

    /**
     * Takes a screenshot and saves it to the Screenshots folder
     * @param driver - the AndroidDriver instance
     * @param screenshotName - name for the screenshot file (usually the test method name)
     */
    public static String takeScreenshot(AndroidDriver driver, String screenshotName) {
        // Add timestamp to avoid overwriting files
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = screenshotName + "_" + timestamp + ".png";
        Path destination = Paths.get("./Screenshots", fileName);

        try {
            // Create the Screenshots directory if it doesn't exist
            Files.createDirectories(destination.getParent());

            // Take the screenshot and write to file
            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            try (FileOutputStream out = new FileOutputStream(destination.toString())) {
                out.write(screenshotBytes);
            }

            System.out.println("📸 Screenshot saved: " + destination);
            return destination.toString();
        } catch (IOException e) {
            System.err.println("❌ Failed to take screenshot: " + e.getMessage());
            return null;
        }
    }
}
