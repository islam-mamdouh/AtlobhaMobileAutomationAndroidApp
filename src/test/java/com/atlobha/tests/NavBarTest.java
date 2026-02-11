package com.atlobha.tests;

import com.atlobha.pages.NavBarPage;
import com.atlobha.pages.NavMenuPage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NavBarTest extends BaseTest {

    private NavBarPage navBarPage;
    private NavMenuPage navMenuPage;

    @BeforeMethod
    public void initPage() {
        navBarPage = new NavBarPage(driver);
        navMenuPage = new NavMenuPage(driver);
    }

    @Test(priority = 1, description = "Verify bottom navigation bar is displayed")
    public void verifyBottomNavBarDisplayed() {
        Assert.assertTrue(navBarPage.isBottomNavBarDisplayed(),
                "Bottom navigation bar should be displayed");
        navMenuPage.closeMenu();        
    }

    @Test(priority = 2, description = "Verify all nav bar tabs are displayed")
    public void verifyAllNavTabsDisplayed() {
        Assert.assertTrue(navBarPage.isHomeTabDisplayed(), "Home tab should be displayed");
        Assert.assertTrue(navBarPage.isSearchTabDisplayed(), "Search tab should be displayed");
        Assert.assertTrue(navBarPage.isMenuTabDisplayed(), "Menu tab should be displayed");
        Assert.assertTrue(navBarPage.isCartTabDisplayed(), "Cart tab should be displayed");
        Assert.assertTrue(navBarPage.isMoreTabDisplayed(), "More tab should be displayed");
    }

    @Test(priority = 3, description = "Verify clicking More tab navigates to more options")
    public void verifyMoreTabNavigation() {
        navBarPage.clickMoreTab();
        Assert.assertTrue(navBarPage.isMoreTabDisplayed(), "Should be on More screen");
        navBarPage.clickHomeTab();

    }

    @Test(priority = 4, description = "Verify clicking Cart tab navigates to cart")
    public void verifyCartTabNavigation() {
        navBarPage.clickCartTab();
        Assert.assertTrue(navBarPage.isCartTabDisplayed(), "Should navigate to Cart");
        navBarPage.clickHomeTab(); 
    }

    @Test(priority = 5, description = "Verify clicking Search tab navigates to Search Page")
    public void verifySearchTabNavigation() {
        navBarPage.clickSearchTab();
        Assert.assertTrue(navBarPage.isSearchTabDisplayed(), "Should navigate to Search");
        navBarPage.clickHomeTab();

    }

    @Test(priority = 6, description = "Verify clicking Menu tab opens navigation menu")
    public void verifyMenuTabNavigation() { 
        navBarPage.clickMenuTab();
        Assert.assertTrue(navMenuPage.isMenuDisplayed(), "Navigation menu should be displayed");
        navMenuPage.closeMenu();
    }
}
