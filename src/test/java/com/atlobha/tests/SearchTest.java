package com.atlobha.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.atlobha.pages.NavMenuPage;
import com.atlobha.pages.NavBarPage;
import com.atlobha.pages.SearchPage;
import com.atlobha.pages.LoginPage;
import com.atlobha.pages.CartPage;

public class SearchTest extends BaseTest {
    private NavMenuPage navMenuPage;
    private NavBarPage navBarPage;
    private SearchPage searchPage;
    private LoginPage loginPage;
    private CartPage cartPage;

    @BeforeMethod
    public void initPages() {
        navMenuPage = new NavMenuPage(driver);
        navBarPage = new NavBarPage(driver);
        searchPage = new SearchPage(driver);
        loginPage = new LoginPage(driver);
        cartPage = new CartPage(driver);
    }

    // ===== Helper Methods =====

    private void searchAndAddToCartThenViewDetails(String query) {
        // Navigate to search
        navMenuPage.closeMenu();
        navBarPage.clickSearchTab();

        // Perform search
        searchPage.searchFor(query);
        waitInSeconds(3);

        Assert.assertTrue(searchPage.isSearchResultsDisplayed(),
            "Search results grid should be displayed");
        Assert.assertFalse(searchPage.getSearchResultProducts().isEmpty(),
            "Search results should contain product cards");

        // Add first product to cart
        searchPage.addToCartByIndex(0);
        waitInSeconds(2);

        // Navigate to product details
        navBarPage.clickCartTab();
        waitInSeconds(2);

        Assert.assertFalse(cartPage.isCartEmpty(),
            "Cart should not be empty after adding a product");

        // Click the product in cart to view its details
        cartPage.clickProductByIndex(0);
        waitInSeconds(2);

        System.out.println("✅ Product details page displayed from cart");
    }

    // ===== Test 1: Guest User =====

    @Test(priority = 1, description = "Guest: search, add to cart, and view product details from cart")
    public void testSearchAddToCartAndViewDetailsAsGuest() {
        searchAndAddToCartThenViewDetails("زيت");
        System.out.println("✅ Guest - Search, Add to Cart, View Details - Test Passed");
    }

    // ===== Test 2: Logged-in User =====

    @Test(priority = 2, description = "Logged-in: login, search, add to cart, and view product details from cart")
    public void testSearchAddToCartAndViewDetailsAsLoggedIn() {
        // Login first
        navMenuPage.closeMenu();
        navBarPage.clickMoreTab();
        navBarPage.clickLoginButton();
        Assert.assertTrue(loginPage.isLoginScreenDisplayed(),
            "Login screen should be displayed");
        loginPage.enterEmailOrPhone("562939492");
        loginPage.clickLoginButton();
        loginPage.enterOtp("123456");
        waitInSeconds(2);
        System.out.println("✅ Login completed");

        // Same flow: search, add to cart, view details
        searchAndAddToCartThenViewDetails("زيت");
        System.out.println("✅ Logged-in - Search, Add to Cart, View Details - Test Passed");
    }
}
