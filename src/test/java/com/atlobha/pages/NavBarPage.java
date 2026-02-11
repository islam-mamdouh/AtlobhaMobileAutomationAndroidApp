package com.atlobha.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class NavBarPage extends BasePage {

    // ===== Bottom Navigation Bar Locators =====
    private final By bottomNavBar = By.id("com.atlobha.atlobha:id/bottom_nav_bar");
    private final By homeTab = By.id("com.atlobha.atlobha:id/navigation_home");
    private final By searchTab = By.id("com.atlobha.atlobha:id/navigation_my_orders");
    private final By menuTab = By.id("com.atlobha.atlobha:id/navigation_menu");
    private final By cartTab = By.id("com.atlobha.atlobha:id/cart");
    private final By moreTab = By.id("com.atlobha.atlobha:id/more");
    private final By loginButton = By.id("com.atlobha.atlobha:id/loginBtn");
    // Constructor
    public NavBarPage(AndroidDriver driver) {
        super(driver);
    }

    // ===== Navigation Actions =====
    public void clickHomeTab() {
        click(homeTab);
    }

    public void clickSearchTab() {
        click(searchTab);
    }

    public void clickMenuTab() {
        click(menuTab);
    }

    public void clickCartTab() {
        click(cartTab);
    }

    public void clickMoreTab() {
        click(moreTab);
    }

    public void clickLoginButton() {
        click(loginButton);
    }

    // ===== Verification Methods =====
    public boolean isBottomNavBarDisplayed() {
        return isElementDisplayed(bottomNavBar);
    }

    public boolean isHomeTabDisplayed() {
        return isElementDisplayed(homeTab);
    }

    public boolean isSearchTabDisplayed() {
        return isElementDisplayed(searchTab);
    }

    public boolean isMenuTabDisplayed() {
        return isElementDisplayed(menuTab);
    }

    public boolean isCartTabDisplayed() {
        return isElementDisplayed(cartTab);
    }

    public boolean isMoreTabDisplayed() {
        return isElementDisplayed(moreTab);
    }
}
