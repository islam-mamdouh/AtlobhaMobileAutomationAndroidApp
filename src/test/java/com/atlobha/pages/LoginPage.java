package com.atlobha.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    
    // Locators
    private final By emailPhoneInput = By.id("com.atlobha.atlobha:id/phoneEmailLoginEt");
    private final By loginButton = By.id("com.atlobha.atlobha:id/loginBtn");
    private final By googleLoginButton = By.id("com.atlobha.atlobha:id/googleAuthContainer");
    private final By closeButton = By.id("com.atlobha.atlobha:id/closeBtn");
    private final By otpInputField = By.id("com.atlobha.atlobha:id/verification_code_et");
    private final By welcomeMessage = By.id("com.atlobha.atlobha:id/authMsgTv");
    
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

    public void enterOtp(String otp){
        enterText(otpInputField, otp);
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
    
    public boolean isLoginButtonDisplayed() {
        return isElementDisplayed(loginButton);
    }
}