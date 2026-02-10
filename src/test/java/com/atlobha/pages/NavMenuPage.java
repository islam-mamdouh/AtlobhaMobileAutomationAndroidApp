package com.atlobha.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class NavMenuPage extends BasePage {

    // ===== Bottom Sheet Container =====
    private final By bottomSheet = By.id("com.atlobha.atlobha:id/design_bottom_sheet");
    private final By closeBtn = By.id("com.atlobha.atlobha:id/close_btn");

    // ===== Main Section - Spare Parts =====
    private final By mainSectionTitle = By.id("com.atlobha.atlobha:id/main_section_title_tv");
    private final By marketPlace = By.xpath("//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/section_name_tv' and @text='متجر قطع الغيار']");
    private final By pricing = By.xpath("//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/section_name_tv' and @text='تسعير قطع الغيار']");
    // ===== Sub Section - More Services =====
    private final By subSectionTitle = By.id("com.atlobha.atlobha:id/sub_section_title_tv");
    private final By carPricing = By.xpath("//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/section_name_tv' and @text='تسعير السيارات']");
    private final By testDrives = By.xpath("//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/section_name_tv' and @text='تجارب القيادة']");
    private final By services = By.xpath("//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/section_name_tv' and @text='الخدمات']");

    // Constructor
    public NavMenuPage(AndroidDriver driver) {
        super(driver);
    }

    // ===== Actions =====
    public void clickPartsStore() {
        click(marketPlace);
    }

    public void clickPartsPricing() {
        click(pricing);
    }

    public void clickCarPricing() {
        click(carPricing);
    }

    public void clickTestDrives() {
        click(testDrives);
    }

    public void clickServices() {
        click(services);
    }

    public void closeMenu() {
        click(closeBtn);
    }

    // ===== Verification Methods =====
    public boolean isMenuDisplayed() {
        return isElementDisplayed(bottomSheet);
    }

    public String getMainSectionTitle() {
        return getText(mainSectionTitle);
    }

    public String getSubSectionTitle() {
        return getText(subSectionTitle);
    }

    public boolean isCarPricingDisplayed() {
        return isElementDisplayed(carPricing);
    }

    public boolean isTestDrivesDisplayed() {
        return isElementDisplayed(testDrives);
    }

    public boolean isServicesDisplayed() {
        return isElementDisplayed(services);
    }
}
