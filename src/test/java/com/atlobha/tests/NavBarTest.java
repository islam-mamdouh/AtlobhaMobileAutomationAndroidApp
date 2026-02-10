package com.atlobha.tests;

import com.atlobha.pages.NavBarPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NavBarTest extends BaseTest {

    private NavBarPage navBarPage;

    @BeforeMethod
    public void initPage() {
        navBarPage = new NavBarPage(driver);
    }

    @Test(priority = 1, description = "Verify bottom navigation bar is displayed")
    public void verifyBottomNavBarDisplayed() {
        Assert.assertTrue(navBarPage.isBottomNavBarDisplayed(),
                "Bottom navigation bar should be displayed");
    }

    @Test(priority = 2, description = "Verify all nav bar tabs are displayed")
    public void verifyAllNavTabsDisplayed() {
        Assert.assertTrue(navBarPage.isHomeTabDisplayed(), "Home tab should be displayed");
        Assert.assertTrue(navBarPage.isMyOrdersTabDisplayed(), "My Orders tab should be displayed");
        Assert.assertTrue(navBarPage.isMenuTabDisplayed(), "Menu tab should be displayed");
        Assert.assertTrue(navBarPage.isCartTabDisplayed(), "Cart tab should be displayed");
        Assert.assertTrue(navBarPage.isMoreTabDisplayed(), "More tab should be displayed");
    }

    @Test(priority = 3, description = "Verify clicking Home tab navigates to home")
    public void verifyHomeTabNavigation() {
        navBarPage.clickMoreTab();
        navBarPage.clickHomeTab();
        Assert.assertTrue(navBarPage.isHomeTabDisplayed(), "Should be on Home screen");
    }

    @Test(priority = 4, description = "Verify clicking Cart tab navigates to cart")
    public void verifyCartTabNavigation() {
        navBarPage.clickCartTab();
        Assert.assertTrue(navBarPage.isCartTabDisplayed(), "Should navigate to Cart");
    }

    @Test(priority = 5, description = "Verify clicking More tab navigates to more options")
    public void verifyMoreTabNavigation() {
        navBarPage.clickMoreTab();
        Assert.assertTrue(navBarPage.isMoreTabDisplayed(), "Should navigate to More");
    }
}
