package com.atlobha.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class CartPage extends BasePage{

    // ===== Cart Header =====
    private final By cartContainer = By.id("com.atlobha.atlobha:id/cartContainer");
    private final By cartCount = By.id("com.atlobha.atlobha:id/cartCountTv");
    // ===== Product Items =====
    private final By productNames = By.id("com.atlobha.atlobha:id/product_name");
    private final By productPrices = By.id("com.atlobha.atlobha:id/price_value");
    private final By itemCounts = By.id("com.atlobha.atlobha:id/item_count_tv");
    private final By minusButtons = By.id("com.atlobha.atlobha:id/minus_iv");
    private final By plusButtons = By.id("com.atlobha.atlobha:id/add_iv");
    private final By viewServiceCenters = By.id("com.atlobha.atlobha:id/viewServiceCentersTv");
    // ===== Price Summary =====
    private final By deliveryPrice = By.id("com.atlobha.atlobha:id/deliveryPriceTv");
    private final By totalPrice = By.id("com.atlobha.atlobha:id/totalPriceTv");
    // ===== Checkout Button =====
    private final By continueCheckoutBtn = By.id("com.atlobha.atlobha:id/continueCheckoutBtn");

    public CartPage (AndroidDriver driver){
        super(driver);
    }

        // ===== Product Actions =====
    public void increaseProductQuantityByIndex(int index) {
        List<WebElement> plus = driver.findElements(plusButtons);
        if (index >= 0 && index < plus.size()) {
            plus.get(index).click();
        } else {
            throw new IndexOutOfBoundsException(
                "Product index " + index + " is out of range.");
        }
    }

    public void decreaseProductQuantityByIndex(int index) {
        List<WebElement> minus = driver.findElements(minusButtons);
        if (index >= 0 && index < minus.size()) {
            minus.get(index).click();
        } else {
            throw new IndexOutOfBoundsException(
                "Product index " + index + " is out of range.");
        }
    }

    public void clickProductByIndex(int index) {
        List<WebElement> products = driver.findElements(productNames);
        if (index >= 0 && index < products.size()) {
            products.get(index).click();
        } else {
            throw new IndexOutOfBoundsException(
                "Product index " + index + " is out of range.");
        }
    }

    public void clickContinueCheckout() {
        click(continueCheckoutBtn);
    }

    public void clickViewServiceCenters() {
        click(viewServiceCenters);
    }

        // ===== Getters =====
    public String getCartCount() {
        return getText(cartCount);
    }

    public String getTotalPrice() {
        return getText(totalPrice);
    }

    public String getDeliveryPrice() {
        return getText(deliveryPrice);
    }

    public String getProductNameByIndex(int index) {
        List<WebElement> names = driver.findElements(productNames);
        if (index >= 0 && index < names.size()) {
            return names.get(index).getText();
        }
        throw new IndexOutOfBoundsException(
            "Product index " + index + " is out of range.");
    }

    public String getProductPriceByIndex(int index) {
        List<WebElement> prices = driver.findElements(productPrices);
        if (index >= 0 && index < prices.size()) {
            return prices.get(index).getText();
        }
        throw new IndexOutOfBoundsException(
            "Product index " + index + " is out of range.");
    }

    public String getProductQuantityByIndex(int index) {
        List<WebElement> counts = driver.findElements(itemCounts);
        if (index >= 0 && index < counts.size()) {
            return counts.get(index).getText();
        }
        throw new IndexOutOfBoundsException(
            "Product index " + index + " is out of range.");
    }

    public int getProductCount() {
        return driver.findElements(productNames).size();
    }

    // ===== Verification Methods =====
    public boolean isPageDisplayed() {
        return isElementDisplayed(cartContainer);
    }

    public boolean isProductDisplayed(String name) {
        By product = By.xpath("//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/product_name' and @text='" + name + "']");
        return isElementDisplayed(product);
    }

    public boolean isContinueCheckoutBtnDisplayed() {
        return isElementDisplayed(continueCheckoutBtn);
    }

    public boolean isCartEmpty() {
        return !isElementDisplayed(By.id("com.atlobha.atlobha:id/recyclerview"));
    }
    
}
