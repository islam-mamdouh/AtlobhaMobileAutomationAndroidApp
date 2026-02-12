package com.atlobha.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.atlobha.pages.NavMenuPage;
import com.atlobha.pages.NavBarPage;
import com.atlobha.pages.ProfilePage;
import com.atlobha.pages.LoginPage;
import com.atlobha.pages.HeaderSectionPage;

public class LoginFlowTest extends BaseTest {
    private NavMenuPage navMenuPage;
    private NavBarPage navBarPage;
    private ProfilePage profilePage;
    private LoginPage loginPage;
    private HeaderSectionPage headerSectionPage;

    @BeforeMethod
    public void initPages() {
        navMenuPage = new NavMenuPage(driver);
        navBarPage = new NavBarPage(driver);
        profilePage = new ProfilePage(driver);
        loginPage = new LoginPage(driver);
        headerSectionPage = new HeaderSectionPage(driver);
    }

    // ✅ HELPER METHOD: Perform login with OTP
    private void performLogin(String phoneNumber, String otp) {
        Assert.assertTrue(loginPage.isLoginScreenDisplayed(), 
            "Login screen should be displayed");
        loginPage.enterEmailOrPhone(phoneNumber);
        loginPage.clickLoginButton();
        loginPage.enterOtp(otp);
        System.out.println("✅ Login completed with: " + phoneNumber);
    }

    // ✅ HELPER METHOD: Verify and perform logout
    private void verifyAndLogout() {
        navBarPage.clickMoreTab();
        Assert.assertTrue(profilePage.isLogOutButtonDisplayed(), 
            "Logout button should be visible after login");
        profilePage.clickLogOutButton();
        profilePage.clickConfirmLogOut();
        System.out.println("✅ Logout completed");
        waitInSeconds(2); // Wait for logout to complete
    }

    @Test(priority = 1, description = "Login via Profile - More Button Flow")
    public void testLoginViaMoreButton() {
        navMenuPage.closeMenu();
        navBarPage.clickMoreTab();
        navBarPage.clickLoginButton(); 
        performLogin("562939492", "123456"); 
        verifyAndLogout();                     
        
        System.out.println("✅ Login via More Button - Test Passed");
    }
    
    @Test(priority = 2, description = "Login via Add Car Flow")
    public void testLoginViaAddCar() {
        navMenuPage.closeMenu();
        headerSectionPage.clickMyCarsView();
        performLogin("562939492", "123456");  
        verifyAndLogout();                     
        
        System.out.println("✅ Login via Add Car - Test Passed");
    }
    
    @Test(priority = 3, description = "Login via Add Address Flow")
    public void testLoginViaAddAddress() {
        navMenuPage.closeMenu();
        headerSectionPage.clickMyaddressesView();      
        performLogin("562939492", "123456");  
        verifyAndLogout();                     
        
        System.out.println("✅ Login via Add Address - Test Passed");
    }
}