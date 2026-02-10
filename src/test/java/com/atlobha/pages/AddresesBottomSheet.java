package com.atlobha.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class AddresesBottomSheet extends BasePage{

    // ===== Bottom Sheet Elements =====
    private final By closeBtn = By.id("com.atlobha.atlobha:id/close_btn");
    private final By title = By.id("com.atlobha.atlobha:id/title_tv");
    // ===== Address Item Elements =====
    private final By addressRoot = By.id("com.atlobha.atlobha:id/root");
    private final By selectedTick = By.id("com.atlobha.atlobha:id/selected_address_tick");
    private final By addressName = By.id("com.atlobha.atlobha:id/address_name_tv");
    private final By addressDetails = By.id("com.atlobha.atlobha:id/address_details_tv");
    // ===== Add New Address Button =====
    private final By addNewAddressBtn = By.id("com.atlobha.atlobha:id/add_address_btn");
    public AddresesBottomSheet(AndroidDriver driver){
      super(driver);
    }

        // ===== Actions =====
    public void closeAddressSheet() {
        click(closeBtn);
    }

    public void clickAddNewAddress() {
        click(addNewAddressBtn);
    }

    public void selectAddressByIndex(int index) {
        List<WebElement> addresses = driver.findElements(addressRoot);
        if (index >= 0 && index < addresses.size()) {
            addresses.get(index).click();
        } else {
            throw new IndexOutOfBoundsException(
                "Address index " + index + " is out of range. Total addresses: " + addresses.size());
        }
    }

    public void selectAddressByName(String name) {
        By addressByName = By.xpath("//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/address_name_tv' and @text='" + name + "']");
        click(addressByName);
    }

    // ===== Getters by Index =====
    public String getAddressNameByIndex(int index) {
        List<WebElement> names = driver.findElements(addressName);
        if (index >= 0 && index < names.size()) {
            return names.get(index).getText();
        }
        throw new IndexOutOfBoundsException(
            "Address index " + index + " is out of range. Total addresses: " + names.size());
    }

    public String getAddressDetailsByIndex(int index) {
        List<WebElement> details = driver.findElements(addressDetails);
        if (index >= 0 && index < details.size()) {
            return details.get(index).getText();
        }
        throw new IndexOutOfBoundsException(
            "Address index " + index + " is out of range. Total addresses: " + details.size());
    }

    public int getAddressCount() {
        List<WebElement> addresses = driver.findElements(addressRoot);
        return addresses.size();
    }

    // ===== Verification Methods =====
    public boolean isAddressSheetDisplayed() {
        return isElementDisplayed(title);
    }

    public String getSheetTitle() {
        return getText(title);
    }

    public boolean isAddressDisplayed(String name) {
        By addressByName = By.xpath("//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/address_name_tv' and @text='" + name + "']");
        return isElementDisplayed(addressByName);
    }

    public boolean isAddNewAddressBtnDisplayed() {
        return isElementDisplayed(addNewAddressBtn);
    }

    public boolean isSelectedTickDisplayed() {
        return isElementDisplayed(selectedTick);
    }
}
    
