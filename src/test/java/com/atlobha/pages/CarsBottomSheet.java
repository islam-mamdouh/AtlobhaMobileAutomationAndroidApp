package com.atlobha.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class CarsBottomSheet extends BasePage {
    // ===== Bottom Sheet Elements =====
    private final By closeBtn = By.id("com.atlobha.atlobha:id/close_btn");
    private final By title = By.id("com.atlobha.atlobha:id/title_tv");

    // ===== Car Item Elements =====
    private final By carContainer = By.id("com.atlobha.atlobha:id/container");
    private final By selectedTick = By.id("com.atlobha.atlobha:id/selected_car_tick");
    private final By carBrandName = By.id("com.atlobha.atlobha:id/car_brand_name");
    private final By carYear = By.id("com.atlobha.atlobha:id/year_tv");
    private final By carModel = By.id("com.atlobha.atlobha:id/car_model_tv");

    // ===== Add New Car Button =====
    private final By addNewCarBtn = By.id("com.atlobha.atlobha:id/add_car_btn");

    public CarsBottomSheet(AndroidDriver driver){
        super(driver);
    }

    // ===== Actions =====
    public void closeCarSheet() {
        click(closeBtn);
    }

    public void clickAddNewCar() {
        click(addNewCarBtn);
    }

    public void selectCarByIndex(int index) {
        List<WebElement> cars = driver.findElements(carContainer);
        if (index >= 0 && index < cars.size()) {
            cars.get(index).click();
        } else {
            throw new IndexOutOfBoundsException(
                "Car index " + index + " is out of range. Total cars: " + cars.size());
        }
    }

    public void selectCarByBrandName(String brand) {
        By carByBrand = By.xpath("//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/car_brand_name' and @text='" + brand + "']");
        click(carByBrand);
    }

    // ===== Getters by Index =====
    public String getCarBrandByIndex(int index) {
        List<WebElement> brands = driver.findElements(carBrandName);
        if (index >= 0 && index < brands.size()) {
            return brands.get(index).getText();
        }
        throw new IndexOutOfBoundsException(
            "Car index " + index + " is out of range. Total cars: " + brands.size());
    }

    public String getCarYearByIndex(int index) {
        List<WebElement> years = driver.findElements(carYear);
        if (index >= 0 && index < years.size()) {
            return years.get(index).getText();
        }
        throw new IndexOutOfBoundsException(
            "Car index " + index + " is out of range. Total cars: " + years.size());
    }

    public String getCarModelByIndex(int index) {
        List<WebElement> models = driver.findElements(carModel);
        if (index >= 0 && index < models.size()) {
            return models.get(index).getText();
        }
        throw new IndexOutOfBoundsException(
            "Car index " + index + " is out of range. Total cars: " + models.size());
    }

    public int getCarCount() {
        List<WebElement> cars = driver.findElements(carContainer);
        return cars.size();
    }

    // ===== Verification Methods =====
    public boolean isCarSheetDisplayed() {
        return isElementDisplayed(title);
    }

    public String getSheetTitle() {
        return getText(title);
    }

    public boolean isCarDisplayed(String brand) {
        By carByBrand = By.xpath("//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/car_brand_name' and @text='" + brand + "']");
        return isElementDisplayed(carByBrand);
    }

    public boolean isAddNewCarBtnDisplayed() {
        return isElementDisplayed(addNewCarBtn);
    }

    public boolean isSelectedTickDisplayed() {
        return isElementDisplayed(selectedTick);
    }
    
}
