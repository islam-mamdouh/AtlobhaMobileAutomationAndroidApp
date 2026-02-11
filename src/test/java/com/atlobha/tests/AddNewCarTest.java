package com.atlobha.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.atlobha.pages.NavMenuPage;
import com.atlobha.pages.NavBarPage;
import com.atlobha.pages.ProfilePage;
import com.atlobha.pages.LoginPage;
import com.atlobha.pages.HeaderSectionPage;
import com.atlobha.pages.CarsBottomSheet;
import com.atlobha.pages.AddNewCarBottomSheetPage;

public class AddNewCarTest extends BaseTest {
    private NavMenuPage navMenuPage;
    private NavBarPage navBarPage;
    private ProfilePage profilePage;
    private LoginPage loginPage;
    private HeaderSectionPage headerSectionPage;
    private CarsBottomSheet carsBottomSheet;
    private AddNewCarBottomSheetPage addNewCarPage;

    @BeforeMethod
    public void initPages() {
        navMenuPage = new NavMenuPage(driver);
        navBarPage = new NavBarPage(driver);
        profilePage = new ProfilePage(driver);
        loginPage = new LoginPage(driver);
        headerSectionPage = new HeaderSectionPage(driver);
        carsBottomSheet = new CarsBottomSheet(driver);
        addNewCarPage = new AddNewCarBottomSheetPage(driver);
    }

    @Test(priority = 1, description = "Add a new car via header section")
    public void testAddNewCar() {

        // Step 1: Close nav menu
        navMenuPage.closeMenu();

        // Step 2: Click on My Cars (triggers login for guest)
        headerSectionPage.clickMyCarsView();

        // Step 3: Perform login
        Assert.assertTrue(loginPage.isLoginScreenDisplayed(), "Login screen should appear for guest user");
        loginPage.enterEmailOrPhone("562939492");
        loginPage.clickLoginButton();
        loginPage.enterOtp("123456");

        // Step 4: Navigate to My Cars again after login
        headerSectionPage.clickMyCarsView();

        // Step 5: Verify cars bottom sheet is displayed
        Assert.assertTrue(carsBottomSheet.isCarSheetDisplayed(), "Cars bottom sheet should be displayed");
        Assert.assertTrue(carsBottomSheet.isAddNewCarBtnDisplayed(), "Add New Car button should be visible");
        int initialCount = carsBottomSheet.getCarCount();
        System.out.println("Current car count: " + initialCount);

        // Step 6: Click Add New Car
        carsBottomSheet.clickAddNewCar();

        // Step 7: Verify add car page is displayed
        Assert.assertTrue(addNewCarPage.isBrandSpinnerDisplayed(), "Brand spinner should be displayed");
        Assert.assertTrue(addNewCarPage.isAddCarBtnDisplayed(), "Add Car button should be displayed");

        // Step 8: Add a new car with details
        addNewCarPage.addNewCar("Toyota", "Camry", "2024", "JTDKN3DU5A0123456", false);
        System.out.println("New car added: Toyota Camry 2024");

        // Step 9: Verify car was added successfully
        Assert.assertTrue(carsBottomSheet.isCarSheetDisplayed(), "Cars bottom sheet should reappear after adding car");
        int newCount = carsBottomSheet.getCarCount();
        System.out.println("New car count: " + newCount);
        Assert.assertTrue(newCount > initialCount, "Car count should increase after adding a new car");
        Assert.assertTrue(carsBottomSheet.isCarDisplayed("Toyota"), "Newly added Toyota car should be displayed in the list");

        // Step 10: Close cars sheet and logout
        carsBottomSheet.closeCarSheet();
        navBarPage.clickMoreTab();
        Assert.assertTrue(profilePage.isLogOutButtonDisplayed(), "Logout button should be visible after login");
        profilePage.clickLogOutButton();
        profilePage.clickConfirmLogOut();

        System.out.println("✅ Add New Car - Test Passed");
        waitInSeconds(2);
    }

    @Test(priority = 2, description = "Add a new car and set it as default via header section")
    public void testAddNewCarAsDefault() {

        // Step 1: Close nav menu
        navMenuPage.closeMenu();

        // Step 2: Click on My Cars (triggers login for guest)
        headerSectionPage.clickMyCarsView();

        // Step 3: Perform login
        Assert.assertTrue(loginPage.isLoginScreenDisplayed(), "Login screen should appear for guest user");
        loginPage.enterEmailOrPhone("562939492");
        loginPage.clickLoginButton();
        loginPage.enterOtp("123456");

        // Step 4: Navigate to My Cars again after login
        headerSectionPage.clickMyCarsView();

        // Step 5: Verify cars bottom sheet is displayed
        Assert.assertTrue(carsBottomSheet.isCarSheetDisplayed(), "Cars bottom sheet should be displayed");
        int initialCount = carsBottomSheet.getCarCount();
        System.out.println("Current car count: " + initialCount);

        // Step 6: Click Add New Car
        carsBottomSheet.clickAddNewCar();

        // Step 7: Verify add car page is displayed
        Assert.assertTrue(addNewCarPage.isBrandSpinnerDisplayed(), "Brand spinner should be displayed");
        Assert.assertTrue(addNewCarPage.isModelSpinnerDisplayed(), "Model spinner should be displayed");
        Assert.assertTrue(addNewCarPage.isYearSpinnerDisplayed(), "Year spinner should be displayed");

        // Step 8: Add a new car with details and set as default
        addNewCarPage.addNewCar("Hyundai", "Sonata", "2023", "KMHD84LF5NU123456", true);
        System.out.println("New default car added: Hyundai Sonata 2023");

        // Step 9: Verify car was added successfully
        Assert.assertTrue(carsBottomSheet.isCarSheetDisplayed(), "Cars bottom sheet should reappear after adding car");
        int newCount = carsBottomSheet.getCarCount();
        System.out.println("New car count: " + newCount);
        Assert.assertTrue(newCount > initialCount, "Car count should increase after adding a new car");
        Assert.assertTrue(carsBottomSheet.isCarDisplayed("Hyundai"), "Newly added Hyundai car should be displayed in the list");

        // Step 10: Close cars sheet and logout
        carsBottomSheet.closeCarSheet();
        navBarPage.clickMoreTab();
        Assert.assertTrue(profilePage.isLogOutButtonDisplayed(), "Logout button should be visible after login");
        profilePage.clickLogOutButton();
        profilePage.clickConfirmLogOut();

        System.out.println("✅ Add New Car As Default - Test Passed");
    }
}
