package com.atlobha.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class PricingPage extends BasePage {
    
    // ===== How Pricing Works =====
    private final By howPricingWorksBanner = By.id("com.atlobha.atlobha:id/how_pricing_works_banner");
    private final By startPricingBtn = By.id("com.atlobha.atlobha:id/action_btn");

    // ===== Add New Part Button =====
    private final By addSparePartBtn = By.id("com.atlobha.atlobha:id/add_spare_part_tv");

    // ===== Add Part Bottom Sheet =====
    private final By closeBtn = By.id("com.atlobha.atlobha:id/close_btn");
    private final By partNameInput = By.id("com.atlobha.atlobha:id/part_name_et");
    private final By sheetMinusBtn = By.xpath("//android.view.ViewGroup[@resource-id='com.atlobha.atlobha:id/item_count_container']//android.widget.ImageView[@resource-id='com.atlobha.atlobha:id/minus_iv']");
    private final By sheetItemCount = By.xpath("//android.view.ViewGroup[@resource-id='com.atlobha.atlobha:id/item_count_container']//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/item_count_tv']");
    private final By sheetPlusBtn = By.xpath("//android.view.ViewGroup[@resource-id='com.atlobha.atlobha:id/item_count_container']//android.widget.ImageView[@resource-id='com.atlobha.atlobha:id/add_iv']");
    private final By partImage = By.id("com.atlobha.atlobha:id/part_iv");
    private final By addPartBtn = By.xpath("//android.widget.FrameLayout[@resource-id='com.atlobha.atlobha:id/add_part_btn']//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/action_btn']");

    // ===== Added Parts List =====
    private final By partNames = By.id("com.atlobha.atlobha:id/part_name_tv");
    private final By listItemCounts = By.xpath("//android.view.ViewGroup[@resource-id='com.atlobha.atlobha:id/counter_view']//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/item_count_tv']");
    private final By listMinusButtons = By.xpath("//android.view.ViewGroup[@resource-id='com.atlobha.atlobha:id/counter_view']//android.widget.ImageView[@resource-id='com.atlobha.atlobha:id/minus_iv']");
    private final By listPlusButtons = By.xpath("//android.view.ViewGroup[@resource-id='com.atlobha.atlobha:id/counter_view']//android.widget.ImageView[@resource-id='com.atlobha.atlobha:id/add_iv']");

    // ===== Promo Code Section =====
    private final By promoCodeInput = By.id("com.atlobha.atlobha:id/promo_code_et");
    private final By activateBtn = By.id("com.atlobha.atlobha:id/activate_tv");

    // ===== Comment Section =====
    private final By commentInput = By.id("com.atlobha.atlobha:id/add_comment_et");

    // ===== Submit Button =====
    private final By priceOrderBtn = By.id("com.atlobha.atlobha:id/complete_order_btn");

    public PricingPage (AndroidDriver driver){
        super(driver);
    }

        // ===== How Pricing Works =====
    public void clickHowPricingWorks() {
        click(howPricingWorksBanner);
    }

    public void clickStartPricing() {
        click(startPricingBtn);
    }

    // ===== Add Part Bottom Sheet Actions =====
    public void clickAddSparePart() {
        click(addSparePartBtn);
    }

    public void enterPartName(String name) {
        enterText(partNameInput, name);
    }

    public void increaseSheetQuantity() {
        click(sheetPlusBtn);
    }

    public void decreaseSheetQuantity() {
        click(sheetMinusBtn);
    }

    public String getSheetQuantity() {
        return getText(sheetItemCount);
    }

    public void clickUploadImage() {
        click(partImage);
    }

    public void clickAddPartToList() {
        click(addPartBtn);
    }

    public void closeBottomSheet() {
        click(closeBtn);
    }

    public void addPart(String name, int quantity) {
        clickAddSparePart();
        enterPartName(name);
        for (int i = 1; i < quantity; i++) {
            increaseSheetQuantity();
        }
        clickAddPartToList();
    }

    // ===== Added Parts List Actions =====
    public String getPartNameByIndex(int index) {
        List<WebElement> names = driver.findElements(partNames);
        if (index >= 0 && index < names.size()) {
            return names.get(index).getText();
        }
        throw new IndexOutOfBoundsException(
            "Part index " + index + " is out of range. Total parts: " + names.size());
    }

    public String getPartQuantityByIndex(int index) {
        List<WebElement> counts = driver.findElements(listItemCounts);
        if (index >= 0 && index < counts.size()) {
            return counts.get(index).getText();
        }
        throw new IndexOutOfBoundsException(
            "Part index " + index + " is out of range.");
    }

    public void increasePartQuantityByIndex(int index) {
        List<WebElement> plus = driver.findElements(listPlusButtons);
        if (index >= 0 && index < plus.size()) {
            plus.get(index).click();
        } else {
            throw new IndexOutOfBoundsException(
                "Part index " + index + " is out of range.");
        }
    }

    public void decreasePartQuantityByIndex(int index) {
        List<WebElement> minus = driver.findElements(listMinusButtons);
        if (index >= 0 && index < minus.size()) {
            minus.get(index).click();
        } else {
            throw new IndexOutOfBoundsException(
                "Part index " + index + " is out of range.");
        }
    }

    public int getAddedPartsCount() {
        return driver.findElements(partNames).size();
    }

    // ===== Promo Code Actions =====
    public void enterPromoCode(String code) {
        enterText(promoCodeInput, code);
    }

    public void clickActivatePromo() {
        click(activateBtn);
    }

    // ===== Comment Actions =====
    public void enterComment(String comment) {
        enterText(commentInput, comment);
    }

    // ===== Submit Actions =====
    public void clickPriceOrder() {
        scrollDown();
        click(priceOrderBtn);
    }

    // ===== Complete Flow =====
    public void submitPricingRequest(String promoCode, String comment) {
        if (promoCode != null && !promoCode.isEmpty()) {
            enterPromoCode(promoCode);
            clickActivatePromo();
        }
        if (comment != null && !comment.isEmpty()) {
            enterComment(comment);
        }
        clickPriceOrder();
    }

    // ===== Verification Methods =====
    public boolean isPageDisplayed() {
        return isElementDisplayed(addSparePartBtn);
    }

    public boolean isBottomSheetDisplayed() {
        return isElementDisplayed(partNameInput);
    }

    public boolean isPartDisplayed(String name) {
        By part = By.xpath("//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/part_name_tv' and @text='" + name + "']");
        return isElementDisplayed(part);
    }

    public boolean isPromoCodeSectionDisplayed() {
        return isElementDisplayed(promoCodeInput);
    }

    public boolean isCommentSectionDisplayed() {
        return isElementDisplayed(commentInput);
    }

    public boolean isPriceOrderBtnDisplayed() {
        return isElementDisplayed(priceOrderBtn);
    }
    
}
