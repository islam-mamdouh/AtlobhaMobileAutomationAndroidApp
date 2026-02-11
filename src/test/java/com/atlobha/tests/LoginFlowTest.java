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

    @Test(priority = 1, description = "Login via Profile - More Button Flow")
    public void testLoginViaMoreButton() {

        // Step 2: Close nav menu
        navMenuPage.closeMenu();
        
        // Step 3: Click More/Profile button
        navBarPage.clickMoreTab();
        navBarPage.clickLoginButton();      
        
        // Step 5: Perform login
        Assert.assertTrue(loginPage.isLoginScreenDisplayed(), "Login screen should be displayed");
        loginPage.enterEmailOrPhone("562939492");
        loginPage.clickLoginButton();
        loginPage.enterOtp("123456");
        
        // Step 6: Verify login success and logout
        navBarPage.clickMoreTab();
        Assert.assertTrue(profilePage.isLogOutButtonDisplayed(), "Logout button should be visible after login");
        profilePage.clickLogOutButton();
        profilePage.clickConfirmLogOut();
        
        System.out.println("✅ Login via More Button - Test Passed");
        waitInSeconds(2); // Small wait to ensure logout process completes before next test
    }
    
    @Test(priority = 2, description = "Login via Add Car Flow")
    public void testLoginViaAddCar() {
        // Step 1: Close nav menu
        navMenuPage.closeMenu();
        
        // Step 2: Click on Add Car (triggers login for guest)
        headerSectionPage.clickMyCarsView();
        
        // Step 3: Perform login
        Assert.assertTrue(loginPage.isLoginScreenDisplayed(), "Login screen should appear for guest user");
        loginPage.enterEmailOrPhone("562939492");
        loginPage.clickLoginButton();
        loginPage.enterOtp("123456");
        
        // Step 4: Verify login success and logout
        navBarPage.clickMoreTab();
        Assert.assertTrue(profilePage.isLogOutButtonDisplayed(), "Logout button should be visible after login");
        profilePage.clickLogOutButton();
        profilePage.clickConfirmLogOut();
        
        System.out.println("✅ Login via Add Car - Test Passed");
         waitInSeconds(2); // Small wait to ensure logout process completes before next test

    }
    
    @Test(priority = 3, description = "Login via Add Address Flow")
    public void testLoginViaAddAddress() {
        // Step 1: Close nav menu
        navMenuPage.closeMenu();
        
        // Step 2: Click on Add Address (triggers login for guest)
        headerSectionPage.clickMyaddressesView();
        
        // Step 3: Perform login
        Assert.assertTrue(loginPage.isLoginScreenDisplayed(), "Login screen should appear for guest user");
        loginPage.enterEmailOrPhone("562939492");
        loginPage.clickLoginButton();
        loginPage.enterOtp("123456");
        
        // Step 4: Verify login success and logout
        navBarPage.clickMoreTab();
        Assert.assertTrue(profilePage.isLogOutButtonDisplayed(), "Logout button should be visible after login");
        profilePage.clickLogOutButton();
        profilePage.clickConfirmLogOut();
        
        System.out.println("✅ Login via Add Address - Test Passed");
    }
}