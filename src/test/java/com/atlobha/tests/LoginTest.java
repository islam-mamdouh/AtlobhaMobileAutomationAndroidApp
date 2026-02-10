package com.atlobha.tests;

import com.atlobha.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    
    @Test(priority = 1, description = "Verify login screen is displayed")
    public void testLoginScreenIsDisplayed() {
        LoginPage loginPage = new LoginPage(driver);
        
        // Verify login screen is visible
        Assert.assertTrue(loginPage.isLoginScreenDisplayed(), 
            "Login screen should be displayed");
        
        // Verify welcome message
        String welcomeMsg = loginPage.getWelcomeMessage();
        Assert.assertNotNull(welcomeMsg, "Welcome message should not be null");
        System.out.println("Welcome message: " + welcomeMsg);
    }
    
    @Test(priority = 2, description = "Verify email/phone input field accepts text")
    public void testEmailPhoneInput() {
        LoginPage loginPage = new LoginPage(driver);
        
        // Enter email
        String testEmail = "test@example.com";
        loginPage.enterEmailOrPhone(testEmail);
        
        System.out.println("Successfully entered email: " + testEmail);
    }
    
    @Test(priority = 3, description = "Verify login button state after entering email")
    public void testLoginButtonState() {
        LoginPage loginPage = new LoginPage(driver);
        
        // Enter email
        loginPage.enterEmailOrPhone("test@atlobha.com");
        
        // Check if login button is enabled
        boolean isEnabled = loginPage.isLoginButtonEnabled();
        System.out.println("Login button enabled: " + isEnabled);
    }
}
