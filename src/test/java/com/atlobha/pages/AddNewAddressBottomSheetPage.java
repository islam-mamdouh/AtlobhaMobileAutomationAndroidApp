package com.atlobha.pages;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class AddNewAddressBottomSheetPage extends BasePage{
    // ===== Toolbar =====
    private final By toolbarTitle = By.id("com.atlobha.atlobha:id/toolbar_title");
    private final By closeBtn = By.id("com.atlobha.atlobha:id/close_btn");

    // ===== Map =====
    private final By mapLayout = By.id("com.atlobha.atlobha:id/mapFL");

    // ===== Address Info =====
    private final By addressTitle = By.id("com.atlobha.atlobha:id/address_title");
    private final By addressDetailsText = By.id("com.atlobha.atlobha:id/address_details_tv");

    // ===== Location Name Options =====
    private final By homeOption = By.xpath("//android.widget.TextView[@text='المنزل']");
    private final By workOption = By.xpath("//android.widget.TextView[@text='العمل']");

    // ===== National Address =====
    private final By nationalAddressInput = By.xpath("//android.widget.EditText[contains(@text,'العنوان الوطني') or contains(@text,'RSFA')]");

    // ===== Submit Button =====
    private final By addAddressBtn = By.id("com.atlobha.atlobha:id/action_btn");
    public AddNewAddressBottomSheetPage(AndroidDriver driver){
        super(driver);
    }

        // ===== Actions =====
    public void closePage() {
        click(closeBtn);
    }

    public void selectHome() {
        click(homeOption);
    }

    public void selectWork() {
        click(workOption);
    }

    public void enterNationalAddress(String nationalAddress) {
        enterText(nationalAddressInput, nationalAddress);
    }

    public void clickAddAddress() {
        click(addAddressBtn);
    }

    // ===== Complete Flow =====
    public void addHomeAddress(String nationalAddress) {
        selectHome();
        enterNationalAddress(nationalAddress);
        clickAddAddress();
    }

    public void addWorkAddress(String nationalAddress) {
        selectWork();
        enterNationalAddress(nationalAddress);
        clickAddAddress();
    }

    // ===== Verification Methods =====
    public boolean isPageDisplayed() {
        return isElementDisplayed(toolbarTitle);
    }

    public String getPageTitle() {
        return getText(toolbarTitle);
    }

    public String getAddressTitle() {
        return getText(addressTitle);
    }

    public String getAddressDetails() {
        return getText(addressDetailsText);
    }

    public boolean isMapDisplayed() {
        return isElementDisplayed(mapLayout);
    }

    public boolean isAddAddressBtnDisplayed() {
        return isElementDisplayed(addAddressBtn);
    }
}