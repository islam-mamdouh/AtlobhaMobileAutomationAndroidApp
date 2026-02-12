package com.atlobha.pages;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class MarketplaceCheckoutPage extends BasePage{
    // ===== Header =====
    private final By backBtn = By.id("com.atlobha.atlobha:id/icon_back");
    private final By toolbarTitle = By.id("com.atlobha.atlobha:id/toolbar_title");
    private final By cartBtn = By.id("com.atlobha.atlobha:id/cartBtn");
    // ===== Address Section =====
    private final By addressContainer = By.id("com.atlobha.atlobha:id/addressClickableContainer");
    private final By addressValue = By.id("com.atlobha.atlobha:id/addressValueTv");
    // ===== Service Center =====
    private final By centerName = By.id("com.atlobha.atlobha:id/centerNameTv");
    private final By centerNavigation = By.id("com.atlobha.atlobha:id/addressNavigationTv");
    private final By contactCenter = By.id("com.atlobha.atlobha:id/contactTv");
    // ===== Delivery Date =====
    private final By deliveryDateValue = By.id("com.atlobha.atlobha:id/deliveryDateTv");
    // ===== Delivery Type =====
    private final By standardDelivery = By.id("com.atlobha.atlobha:id/standardDeliveryContainer");
    private final By expressDelivery = By.id("com.atlobha.atlobha:id/expressDeliveryContainer");
    // ===== Payment Methods =====
    private final By cashPayment = By.xpath("//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/payment_text_tv' and @text='نقداً']/ancestor::android.view.ViewGroup[1]/preceding-sibling::android.widget.ImageView[@resource-id='com.atlobha.atlobha:id/checkbox']");
    private final By creditCardPayment = By.xpath("//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/payment_text_tv' and @text='بطاقة الائتمان']/ancestor::android.view.ViewGroup[1]/preceding-sibling::android.widget.ImageView[@resource-id='com.atlobha.atlobha:id/checkbox']");
    private final By tabbyPayment = By.xpath("//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/payment_text_tv' and @text='تابي']/ancestor::android.view.ViewGroup[1]/preceding-sibling::android.widget.ImageView[@resource-id='com.atlobha.atlobha:id/checkbox']");
    private final By tamaraPayment = By.xpath("//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/payment_text_tv' and @text='تمارا']/ancestor::android.view.ViewGroup[1]/preceding-sibling::android.widget.ImageView[@resource-id='com.atlobha.atlobha:id/checkbox']");
    private final By mispayPayment = By.xpath("//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/payment_text_tv' and @text='MISpay']/ancestor::android.view.ViewGroup[1]/preceding-sibling::android.widget.ImageView[@resource-id='com.atlobha.atlobha:id/checkbox']");
    // ===== Discount & Voucher =====
    private final By discountCouponBtn = By.id("com.atlobha.atlobha:id/discountCouponBtn");
    private final By closeDiscountViewBtn = By.id("com.atlobha.atlobha:id/close_btn");
    private final By discountInputField = By.id("com.atlobha.atlobha:id/voucher_container");
    private final By addDiscountBtn = By.id("com.atlobha.atlobha:id/ok_btn");
    private final By voucherCouponBtn = By.id("com.atlobha.atlobha:id/voucherCouponBtn");
    private final By closeVoucherViewBtn = By.id("com.atlobha.atlobha:id/close_btn");
    private final By voucherInputField = By.id("com.atlobha.atlobha:id/voucher_container");
    private final By addVoucherBtn = By.id("com.atlobha.atlobha:id/ok_btn");

    // ===== Order Summary =====
    private final By productsPrice = By.id("com.atlobha.atlobha:id/productsPriceTv");
    private final By deliveryFee = By.id("com.atlobha.atlobha:id/deliveryFeeTv");
    private final By totalAmountPrice = By.id("com.atlobha.atlobha:id/totalAmountPriceTv");
    private final By vatHint = By.id("com.atlobha.atlobha:id/vatHintTv");
    private final By totalPrice = By.id("com.atlobha.atlobha:id/totalPriceTv");
    // ===== Complete Order Button =====
    private final By completeOrderBtn = By.id("com.atlobha.atlobha:id/completeOrderBtn");

    public MarketplaceCheckoutPage(AndroidDriver driver){
        super(driver);
    }


    // ===== Navigation =====
    public void clickBack() {
        click(backBtn);
    }

    public void clickCart() {
        click(cartBtn);
    }

    // ===== Address Actions =====
    public void clickChangeAddress() {
        click(addressContainer);
    }

    // ===== Service Center Actions =====
    public void clickCenterNavigation() {
        click(centerNavigation);
    }

    public void clickContactCenter() {
        click(contactCenter);
    }

    // ===== Delivery Type Actions =====
    public void selectStandardDelivery() {
        click(standardDelivery);
    }

    public void selectExpressDelivery() {
        click(expressDelivery);
    }

    // ===== Payment Method Actions =====
    public void selectCash() {
        scrollDown();
        click(cashPayment);
    }

    public void selectCreditCard() {
        scrollDown();
        click(creditCardPayment);
    }

    public void selectTabby() {
        scrollDown();
        click(tabbyPayment);
    }

    public void selectTamara() {
        scrollDown();
        click(tamaraPayment);
    }

    public void selectMISpay() {
        scrollDown();
        click(mispayPayment);
    }

    // ===== Discount & Voucher =====
    public void clickAddDiscountCode() {
        click(discountCouponBtn);
    }

    public void clickCloseDiscountView(){
        click(closeDiscountViewBtn);
    }

    public void enterDiscountCode(String code){
        enterText(discountInputField, code);
    }

    public void clickAddDiscountBtn(){
        click(addDiscountBtn);
    }

    public void clickAddVoucher() {
        click(voucherCouponBtn);
    }

    public void clickCloseVoucherView(){
        click(closeVoucherViewBtn);
    }

    public void enterVoucherCode(String code){
        enterText(voucherInputField, code);
    }

    public void clickAddVoucherBtn(){
        click(addVoucherBtn);
    }

    // ===== Complete Order =====
    public void clickCompleteOrder() {
        scrollDown();
        click(completeOrderBtn);
    }

    // ===== Getters =====
    public String getAddressValue() {
        return getText(addressValue);
    }

    public String getCenterName() {
        return getText(centerName);
    }

    public String getDeliveryDate() {
        return getText(deliveryDateValue);
    }

    public String getProductsPrice() {
        return getText(productsPrice);
    }

    public String getDeliveryFee() {
        return getText(deliveryFee);
    }

    public String getTotalAmountPrice() {
        return getText(totalAmountPrice);
    }

    public String getTotalPrice() {
        return getText(totalPrice);
    }

    public String getVatHint() {
        return getText(vatHint);
    }

    // ===== Verification Methods =====
    public boolean isPageDisplayed() {
        return isElementDisplayed(toolbarTitle);
    }

    public boolean isAddressDisplayed() {
        return isElementDisplayed(addressValue);
    }

    public boolean isCompleteOrderBtnDisplayed() {
        return isElementDisplayed(completeOrderBtn);
    }
    
}
