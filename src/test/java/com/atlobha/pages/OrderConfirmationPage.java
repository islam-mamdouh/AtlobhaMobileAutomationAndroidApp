package com.atlobha.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class OrderConfirmationPage extends BasePage {

    // ===== Confirmation Elements =====
    private final By thankYouText = By.id("com.atlobha.atlobha:id/thank_you_tv");
    private final By orderNumberLabel = By.id("com.atlobha.atlobha:id/order_number");
    private final By orderNumberValue = By.id("com.atlobha.atlobha:id/order_number_tv");
    private final By successMessage = By.id("com.atlobha.atlobha:id/success_message");

    // ===== Order Details =====
    private final By addressComponent = By.id("com.atlobha.atlobha:id/address_component");
    private final By deliveryDateComponent = By.id("com.atlobha.atlobha:id/delivery_date_component");
    private final By partTitle = By.id("com.atlobha.atlobha:id/part_title");
    private final By partsRecycler = By.id("com.atlobha.atlobha:id/recyclerview");

    // ===== Buttons =====
    private final By dismissBtn = By.id("com.atlobha.atlobha:id/dismiss_btn");
    private final By ordersPageBtn = By.id("com.atlobha.atlobha:id/action_btn");

    public OrderConfirmationPage(AndroidDriver driver) {
        super(driver);
    }

    // ===== Actions =====
    public void clickOrdersPage() {
        scrollDown();
        click(ordersPageBtn);
    }

    public void clickDismiss() {
        scrollDown();
        click(dismissBtn);
    }

    // ===== Getters =====
    public String getThankYouText() {
        return getText(thankYouText);
    }

    public String getOrderNumber() {
        return getText(orderNumberValue);
    }

    public String getSuccessMessage() {
        return getText(successMessage);
    }

    // ===== Verification Methods =====
    public boolean isPageDisplayed() {
        return isElementDisplayed(thankYouText);
    }

    public boolean isOrderNumberDisplayed() {
        return isElementDisplayed(orderNumberValue);
    }
}
