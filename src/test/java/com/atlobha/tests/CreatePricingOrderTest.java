package com.atlobha.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;


import com.atlobha.pages.AddNewAddressBottomSheetPage;
import com.atlobha.pages.AddNewCarBottomSheetPage;
import com.atlobha.pages.LoginPage;
import com.atlobha.pages.NavMenuPage;
import com.atlobha.pages.OrderConfirmationPage;
import com.atlobha.pages.PricingPage;

public class CreatePricingOrderTest extends BaseTest {
    private OrderConfirmationPage orderConfirmationPage;
    private NavMenuPage navMenuPage;
    private PricingPage pricingPage;
    private LoginPage loginPage;
    private AddNewAddressBottomSheetPage addNewAddressPage;
    private AddNewCarBottomSheetPage addNewCarPage;

    @BeforeMethod
    public void initPages() {
        navMenuPage = new NavMenuPage(driver);
        pricingPage = new PricingPage(driver);
        loginPage = new LoginPage(driver);
        addNewAddressPage = new AddNewAddressBottomSheetPage(driver);
        addNewCarPage = new AddNewCarBottomSheetPage(driver);
        orderConfirmationPage = new OrderConfirmationPage(driver);
    }

    @Test(description = "Guest user creates pricing order, logs in, adds address and car, then submits order")
    public void testGuestPricingOrderWithLoginAndSetup() {

        // Step 1: Navigate to Pricing page
        navMenuPage.clickPartsPricing();
        pricingPage.clickStartPricing();
        Assert.assertTrue(pricingPage.isPageDisplayed(), "Pricing page should be displayed");

        // Step 2: Add spare parts
        pricingPage.addPart("فلتر زيت", 2);
        Assert.assertTrue(pricingPage.isPartDisplayed("فلتر زيت"), "Part should be added to the list");

        // Step 4: Click Price Order (triggers login for guest)
        pricingPage.clickPriceOrder();

        // Step 5: Login with phone number
        Assert.assertTrue(loginPage.isLoginScreenDisplayed(), "Login screen should appear for guest user");
        loginPage.enterEmailOrPhone("562939492");
        loginPage.clickLoginButton();
        loginPage.enterOtp("123456");

        // Step 6: Click Price Order Button
        pricingPage.clickPriceOrder();

        // Step 7: Add Car popup appears
        addNewCarPage.addNewCar("تويوتا", "كامري", "2023", "rtunad5198jk78g56", false);

        // Step 8: Click Price Order Button
        pricingPage.clickPriceOrder();

        // Step 9: Add Address popup appears
        addNewAddressPage.addHomeAddress("RSFA1234");

        // Step 10: Add Promocode And Comment
        pricingPage.enterPromoCode("FD5");
        pricingPage.clickActivatePromo();
        pricingPage.enterComment("يرجي الالتزام بالموعد");

        // Step 11: Click Price Order Button
        pricingPage.clickPriceOrder();

        // Step 12: Verify order confirmation
        Assert.assertTrue(orderConfirmationPage.isPageDisplayed(), 
            "Order confirmation page should be displayed");
        Assert.assertTrue(orderConfirmationPage.isOrderNumberDisplayed(), 
            "Order number should be displayed");

        String orderNumber = orderConfirmationPage.getOrderNumber();
        System.out.println("Order created successfully! Order Number: " + orderNumber);
        Assert.assertFalse(orderNumber.isEmpty(), "Order number should not be empty");

        // Step 13: Navigate To My Orders Screen
        orderConfirmationPage.clickDismiss();

    }
    
}
