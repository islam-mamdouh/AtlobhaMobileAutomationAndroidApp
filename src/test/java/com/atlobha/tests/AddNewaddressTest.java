package com.atlobha.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.atlobha.pages.NavMenuPage;
import com.atlobha.pages.NavBarPage;
import com.atlobha.pages.ProfilePage;
import com.atlobha.pages.LoginPage;
import com.atlobha.pages.HeaderSectionPage;
import com.atlobha.pages.AddresesBottomSheet;
import com.atlobha.pages.AddNewAddressBottomSheetPage;

public class AddNewaddressTest extends BaseTest {
    private NavMenuPage navMenuPage;
    private NavBarPage navBarPage;
    private ProfilePage profilePage;
    private LoginPage loginPage;
    private HeaderSectionPage headerSectionPage;
    private AddresesBottomSheet addressesBottomSheet;
    private AddNewAddressBottomSheetPage addNewAddressPage;

    @BeforeMethod
    public void initPages() {
        navMenuPage = new NavMenuPage(driver);
        navBarPage = new NavBarPage(driver);
        profilePage = new ProfilePage(driver);
        loginPage = new LoginPage(driver);
        headerSectionPage = new HeaderSectionPage(driver);
        addressesBottomSheet = new AddresesBottomSheet(driver);
        addNewAddressPage = new AddNewAddressBottomSheetPage(driver);
    }

    @Test(priority = 1, description = "Add a new Home address via header section")
    public void testAddNewHomeAddress() {

        // Step 1: Close nav menu
        navMenuPage.closeMenu();

        // Step 2: Click on My Addresses (triggers login for guest)
        headerSectionPage.clickMyaddressesView();

        // Step 3: Perform login
        Assert.assertTrue(loginPage.isLoginScreenDisplayed(), "Login screen should appear for guest user");
        loginPage.enterEmailOrPhone("562939492");
        loginPage.clickLoginButton();
        loginPage.enterOtp("123456");

        // Step 4: Navigate to My Addresses again after login
        headerSectionPage.clickMyaddressesView();

        // Step 5: Verify address bottom sheet is displayed
        Assert.assertTrue(addressesBottomSheet.isAddressSheetDisplayed(), "Address bottom sheet should be displayed");
        Assert.assertTrue(addressesBottomSheet.isAddNewAddressBtnDisplayed(), "Add New Address button should be visible");
        int initialCount = addressesBottomSheet.getAddressCount();
        System.out.println("Current address count: " + initialCount);

        // Step 6: Click Add New Address
        addressesBottomSheet.clickAddNewAddress();

        // Step 7: Verify add address page is displayed
        Assert.assertTrue(addNewAddressPage.isPageDisplayed(), "Add New Address page should be displayed");
        Assert.assertTrue(addNewAddressPage.isMapDisplayed(), "Map should be displayed on add address page");

        // Step 8: Add a Home address with national address
        addNewAddressPage.addHomeAddress("LMYR5698");
        System.out.println("Home address added with national address: LMYR5698");

        // Step 9: Verify address was added successfully
        Assert.assertTrue(addressesBottomSheet.isAddressSheetDisplayed(), "Address bottom sheet should reappear after adding address");
        int newCount = addressesBottomSheet.getAddressCount();
        System.out.println("New address count: " + newCount);
        Assert.assertTrue(newCount > initialCount, "Address count should increase after adding a new address");

        // Step 10: Close address sheet and logout
        addressesBottomSheet.closeAddressSheet();
        navBarPage.clickMoreTab();
        Assert.assertTrue(profilePage.isLogOutButtonDisplayed(), "Logout button should be visible after login");
        profilePage.clickLogOutButton();
        profilePage.clickConfirmLogOut();

        System.out.println("✅ Add New Home Address - Test Passed");
        waitInSeconds(2);
    }

    @Test(priority = 2, description = "Add a new Work address via header section")
    public void testAddNewWorkAddress() {

        // Step 1: Close nav menu
        navMenuPage.closeMenu();

        // Step 2: Click on My Addresses (triggers login for guest)
        headerSectionPage.clickMyaddressesView();

        // Step 3: Perform login
        Assert.assertTrue(loginPage.isLoginScreenDisplayed(), "Login screen should appear for guest user");
        loginPage.enterEmailOrPhone("562939492");
        loginPage.clickLoginButton();
        loginPage.enterOtp("123456");

        // Step 4: Navigate to My Addresses again after login
        headerSectionPage.clickMyaddressesView();

        // Step 5: Verify address bottom sheet is displayed
        Assert.assertTrue(addressesBottomSheet.isAddressSheetDisplayed(), "Address bottom sheet should be displayed");
        int initialCount = addressesBottomSheet.getAddressCount();
        System.out.println("Current address count: " + initialCount);

        // Step 6: Click Add New Address
        addressesBottomSheet.clickAddNewAddress();

        // Step 7: Verify add address page is displayed
        Assert.assertTrue(addNewAddressPage.isPageDisplayed(), "Add New Address page should be displayed");
        Assert.assertTrue(addNewAddressPage.isMapDisplayed(), "Map should be displayed on add address page");

        // Step 8: Add a Work address with national address
        addNewAddressPage.clickAddaddressDetailsButton();
        addNewAddressPage.selectWork();
        addNewAddressPage.enterNationalAddress("RKAH4521");
        addNewAddressPage.clickAddAddress();
        System.out.println("Work address added with national address: RKAH4521");

        // Step 9: Verify address was added successfully
        Assert.assertTrue(addressesBottomSheet.isAddressSheetDisplayed(), "Address bottom sheet should reappear after adding address");
        int newCount = addressesBottomSheet.getAddressCount();
        System.out.println("New address count: " + newCount);
        Assert.assertTrue(newCount > initialCount, "Address count should increase after adding a new address");

        // Step 10: Close address sheet and logout
        addressesBottomSheet.closeAddressSheet();
        navBarPage.clickMoreTab();
        Assert.assertTrue(profilePage.isLogOutButtonDisplayed(), "Logout button should be visible after login");
        profilePage.clickLogOutButton();
        profilePage.clickConfirmLogOut();

        System.out.println("✅ Add New Work Address - Test Passed");
    }
}
