package com.atlobha.tests;

import com.atlobha.pages.MarketplacePage;
import com.atlobha.pages.NavMenuPage;
import com.atlobha.pages.NavBarPage;
import com.atlobha.pages.CartPage;
import com.atlobha.pages.LoginPage;
import com.atlobha.pages.MarketplaceCheckoutPage;
import com.atlobha.pages.AddNewAddressBottomSheetPage;
import com.atlobha.pages.OrderConfirmationPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MarketplaceOrderE2ETest extends BaseTest {

    private MarketplacePage marketplacePage;
    private NavMenuPage navMenuPage;
    private NavBarPage navBarPage;
    private CartPage cartPage;
    private MarketplaceCheckoutPage checkoutPage;
    private LoginPage loginPage;
    private AddNewAddressBottomSheetPage addNewAddressPage;
    private OrderConfirmationPage orderConfirmationPage;

    @BeforeMethod
    public void initPages() {
        marketplacePage = new MarketplacePage(driver);
        navMenuPage = new NavMenuPage(driver);
        navBarPage = new NavBarPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new MarketplaceCheckoutPage(driver);
        loginPage = new LoginPage(driver);
        addNewAddressPage = new AddNewAddressBottomSheetPage(driver);
        orderConfirmationPage = new OrderConfirmationPage(driver);
    }

    @Test(description = "E2E: Add products from marketplace sections, manage cart, checkout as guest with cash payment")
    public void testMarketplaceOrderEndToEnd() {

        // ============================================================
        // Step 1: Close the Navigation Menu (bottom sheet popup)
        // ============================================================
        if (navMenuPage.isMenuDisplayed()) {
           navMenuPage.closeMenu();
        }

        // Verify marketplace home screen is displayed
        Assert.assertTrue(marketplacePage.isCategoriesSectionDisplayed(),
            "Marketplace categories section should be visible after closing nav menu");

        // ============================================================
        // Step 2: Add 3 items to cart from different sections
        // ============================================================

        // --- Product 1: From "العنيايه بالسياره" section, index 0, quantity 1 ---
        marketplacePage.scrollToSection("العنيايه بالسياره");
        marketplacePage.addToCartInSection("العنيايه بالسياره", 0);
        String product1Name = marketplacePage.getProductNameByIndex(0);
        System.out.println("Product 1 added: " + product1Name + " | Qty: 1");

        // --- Product 2: From "الزيوت" section, index 1, quantity 2 ---
        marketplacePage.scrollToSection("الزيوت");
        marketplacePage.addToCartInSection("الزيوت", 1);
        // Increase quantity to 2 (added with qty 1, need +1 more)
        marketplacePage.increaseProductQuantityByIndex("الزيوت", 1);

        String product2Name = marketplacePage.getProductNameByIndex(1);
        System.out.println("Product 2 added: " + product2Name + " | Qty: 2");

        // --- Product 3: From "الاكسسوارات" section, index 2, quantity 1 ---
        marketplacePage.scrollToSection("الاكسسوارات");
        marketplacePage.addToCartInSection("الاكسسوارات", 2);
        // Quantity is already 1 after adding (default)

        String product3Name = marketplacePage.getProductNameByIndex(2);
        System.out.println("Product 3 added: " + product3Name + " | Qty: 1");

        // ============================================================
        // Step 3: Navigate to Cart Screen
        // ============================================================
        navBarPage.clickCartTab();

        Assert.assertTrue(cartPage.getProductCount() >= 3,
            "Cart should contain at least 3 products");
        System.out.println("Cart has " + cartPage.getProductCount() + " products");

        // ============================================================
        // Step 4: Increase item quantity (Product 1 → from 1 to 2)
        // ============================================================
        String qtyBefore = cartPage.getProductQuantityByIndex(0);
        cartPage.increaseProductQuantityByIndex(0);
        String qtyAfter = cartPage.getProductQuantityByIndex(0);
        System.out.println("Product 1 quantity: " + qtyBefore + " → " + qtyAfter);

        // ============================================================
        // Step 5: Decrease another item quantity (Product 2 → from 2 to 1)
        // ============================================================
        String qty2Before = cartPage.getProductQuantityByIndex(1);
        cartPage.decreaseProductQuantityByIndex(1);
        String qty2After = cartPage.getProductQuantityByIndex(1);
        System.out.println("Product 2 quantity: " + qty2Before + " → " + qty2After);

        // ============================================================
        // Step 6: Delete item from cart (Product 3 - remove by decreasing to 0)
        // ============================================================
        int countBefore = cartPage.getProductCount();
        cartPage.decreaseProductQuantityByIndex(2);
        int countAfter = cartPage.getProductCount();
        System.out.println("Products in cart: " + countBefore + " → " + countAfter);

        // ============================================================
        // Step 7: Proceed to Checkout as a Guest
        // ============================================================
        cartPage.clickContinueCheckout();

        // ============================================================
        // Step 8: Perform Login (guest → login flow triggered)
        // ============================================================
        Assert.assertTrue(loginPage.isLoginScreenDisplayed(),
            "Login screen should be displayed for guest checkout");

        loginPage.enterEmailOrPhone("562939499");
        loginPage.clickLoginButton();
        loginPage.enterOtp("123456");

        System.out.println("Login completed successfully");

        // Click continue again after login to proceed to checkout
        cartPage.clickContinueCheckout(); 

        // ============================================================
        // Step 9: Add Address
        // ============================================================
        addNewAddressPage.addHomeAddress("LMYR5698");

        // ============================================================
        // Step 10: Confirm Order with Cash Payment Method
        // ============================================================
        checkoutPage.selectCash();
        System.out.println("Cash payment method selected");

        checkoutPage.clickCompleteOrder();
        System.out.println("Order submitted");

        // ============================================================
        // Step 11: Navigate to My Orders Screen
        // ============================================================
        Assert.assertTrue(orderConfirmationPage.isPageDisplayed(),
            "Order confirmation page should be displayed");
        Assert.assertTrue(orderConfirmationPage.isOrderNumberDisplayed(),
            "Order number should be visible");

        String orderNumber = orderConfirmationPage.getOrderNumber();
        System.out.println("✅ ORDER CONFIRMED! Order Number: " + orderNumber);
        Assert.assertFalse(orderNumber.isEmpty(), "Order number should not be empty");

        // Navigate to My Orders page
        orderConfirmationPage.clickOrdersPage();
        System.out.println("Navigated to My Orders screen");
    }
}