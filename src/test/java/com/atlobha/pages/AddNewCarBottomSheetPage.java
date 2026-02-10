package com.atlobha.pages;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class AddNewCarBottomSheetPage extends BasePage {
    // ===== Toolbar =====
    private final By closeBtn = By.id("com.atlobha.atlobha:id/close_btn");

    // ===== Brand =====
    private final By brandSpinner = By.id("com.atlobha.atlobha:id/car_brand_spinner");

    // ===== Model =====
    private final By modelSpinner = By.id("com.atlobha.atlobha:id/model_spinner");

    // ===== Year =====
    private final By yearSpinner = By.id("com.atlobha.atlobha:id/year_spinner");

    // ===== Chassis Number =====
    private final By chassisInput = By.id("com.atlobha.atlobha:id/chassis_no");
    private final By defaultCarSwitch = By.id("com.atlobha.atlobha:id/default_car_sw");

    // ===== Submit Button =====
    private final By addCarBtn = By.id("com.atlobha.atlobha:id/action_btn");

    public AddNewCarBottomSheetPage(AndroidDriver driver){
        super(driver);
    }
    
        // ===== Actions =====
    public void selectBrand(String brand) {
        click(brandSpinner);
        By brandOption = By.xpath("//android.widget.TextView[@text='" + brand + "']");
        click(brandOption);
    }

    public void selectModel(String model) {
        click(modelSpinner);
        By modelOption = By.xpath("//android.widget.TextView[@text='" + model + "']");
        click(modelOption);
    }

    public void selectYear(String year) {
        click(yearSpinner);
        By yearOption = By.xpath("//android.widget.TextView[@text='" + year + "']");
        click(yearOption);
    }

    public void enterChassisNumber(String chassisNo) {
        enterText(chassisInput, chassisNo);
    }

    public void toggleDefaultCar() {
        click(defaultCarSwitch);
    }

    public void clickAddCar() {
        click(addCarBtn);
    }

    public void closePage() {
        click(closeBtn);
    }

    // ===== Complete Flow =====
    public void addNewCar(String brand, String model, String year, String chassisNo, boolean setDefault) {
        selectBrand(brand);
        selectModel(model);
        selectYear(year);
        enterChassisNumber(chassisNo);
        if (setDefault) {
            toggleDefaultCar();
        }
        clickAddCar();
    }

    // ===== Verification Methods =====

    public boolean isBrandSpinnerDisplayed() {
        return isElementDisplayed(brandSpinner);
    }

    public boolean isModelSpinnerDisplayed() {
        return isElementDisplayed(modelSpinner);
    }

    public boolean isYearSpinnerDisplayed() {
        return isElementDisplayed(yearSpinner);
    }

    public boolean isChassisInputDisplayed() {
        return isElementDisplayed(chassisInput);
    }

    public boolean isAddCarBtnDisplayed() {
        return isElementDisplayed(addCarBtn);
    }
}
