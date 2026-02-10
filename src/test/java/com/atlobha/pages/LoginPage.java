package com.atlobha.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    
    // Locators
    private By emailPhoneInput = By.id("com.atlobha.atlobha:id/phoneEmailLoginEt");
    private By loginButton = By.id("com.atlobha.atlobha:id/loginBtn");
    private By googleLoginButton = By.id("com.atlobha.atlobha:id/googleAuthContainer");
    private By closeButton = By.id("com.atlobha.atlobha:id/closeBtn");
    private By welcomeMessage = By.id("com.atlobha.atlobha:id/authMsgTv");
    
    // Constructor
    public LoginPage(AndroidDriver driver) {
        super(driver);
    }
    
    // Actions
    public void enterEmailOrPhone(String emailOrPhone) {
        enterText(emailPhoneInput, emailOrPhone);
    }
    
    public void clickLoginButton() {
        click(loginButton);
    }
    
    public void clickGoogleLogin() {
        click(googleLoginButton);
    }
    
    public void clickCloseButton() {
        click(closeButton);
    }
    
    // Verification Methods
    public boolean isLoginScreenDisplayed() {
        return isElementDisplayed(welcomeMessage);
    }
    
    public String getWelcomeMessage() {
        return getText(welcomeMessage);
    }
    
    public boolean isLoginButtonEnabled() {
        return isElementEnabled(loginButton);
    }
}