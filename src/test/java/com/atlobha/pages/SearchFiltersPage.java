package com.atlobha.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class SearchFiltersPage extends BasePage {

    // ===== Car Info Section =====
    private final By brandSpinner = By.id("com.atlobha.atlobha:id/car_brand_spinner");
    private final By modelSpinner = By.id("com.atlobha.atlobha:id/model_spinner");
    private final By yearSpinner = By.id("com.atlobha.atlobha:id/year_spinner");

    // ===== Selection Dialog Elements =====
    private final By brandDialogItems = By.id("com.atlobha.atlobha:id/car_brand_tv");
    private final By modelDialogItems = By.id("com.atlobha.atlobha:id/car_model_tv");
    private final By yearDialogItems = By.id("com.atlobha.atlobha:id/car_year_tv");

    // ===== Categories Section =====
    private final By categoriesContainer = By.id("com.atlobha.atlobha:id/categoriesFlex");

    // ===== Manufacturers Section =====
    private final By manufacturersContainer = By.id("com.atlobha.atlobha:id/manufacturesFlex");

    // ===== Shared Tag Locator =====
    private final By tagItems = By.id("com.atlobha.atlobha:id/tagText");

    // ===== Apply Filter Button =====
    private final By applyFilterButton = By.id("com.atlobha.atlobha:id/filterBtn");

    // ===== Reset Filter =====
    private final By resetFilterButton = By.id("com.atlobha.atlobha:id/resetFilterTv");

    public SearchFiltersPage (AndroidDriver driver){
        super(driver);
    }

    // ================================================================
    // ===== CAR BRAND SELECTION =======================================
    // ================================================================

    public void selectBrand(String brandName) {
        click(brandSpinner);
        waitInSeconds(1);
        By brand = By.xpath(
            "//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/car_brand_tv' and @text='"
            + brandName + "']");
        click(brand);
    }

    public void selectBrandByIndex(int index) {
        click(brandSpinner);
        waitInSeconds(1);
        List<WebElement> brands = findElements(brandDialogItems);
        if (index >= 0 && index < brands.size()) {
            brands.get(index).click();
        } else {
            throw new IndexOutOfBoundsException(
                "Brand index " + index + " is out of range. Total: " + brands.size());
        }
    }

    // ================================================================
    // ===== CAR MODEL SELECTION =======================================
    // ================================================================

    public void selectModel(String modelName) {
        click(modelSpinner);
        waitInSeconds(1);
        By model = By.xpath(
            "//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/car_model_tv' and @text='"
            + modelName + "']");
        click(model);
    }

    public void selectModelByIndex(int index) {
        click(modelSpinner);
        waitInSeconds(1);
        List<WebElement> models = findElements(modelDialogItems);
        if (index >= 0 && index < models.size()) {
            models.get(index).click();
        } else {
            throw new IndexOutOfBoundsException(
                "Model index " + index + " is out of range. Total: " + models.size());
        }
    }

    // ================================================================
    // ===== CAR YEAR SELECTION ========================================
    // ================================================================

    public void selectYear(String year) {
        click(yearSpinner);
        waitInSeconds(1);
        By yearOption = By.xpath(
            "//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/car_year_tv' and @text='"
            + year + "']");
        click(yearOption);
    }

    public void selectYearByIndex(int index) {
        click(yearSpinner);
        waitInSeconds(1);
        List<WebElement> years = findElements(yearDialogItems);
        if (index >= 0 && index < years.size()) {
            years.get(index).click();
        } else {
            throw new IndexOutOfBoundsException(
                "Year index " + index + " is out of range. Total: " + years.size());
        }
    }

    // ================================================================
    // ===== CATEGORY SELECTION ========================================
    // ================================================================

    public void selectCategory(String categoryText) {
        By tag = By.xpath(
            "//android.view.ViewGroup[@resource-id='com.atlobha.atlobha:id/categoriesFlex']"
            + "//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/tagText' and @text='"
            + categoryText + "']");
        click(tag);
    }

    public void selectCategoryByIndex(int index) {
        WebElement container = findElement(categoriesContainer);
        List<WebElement> tags = container.findElements(tagItems);
        if (index >= 0 && index < tags.size()) {
            tags.get(index).click();
        } else {
            throw new IndexOutOfBoundsException(
                "Category index " + index + " is out of range. Total: " + tags.size());
        }
    }

    // ================================================================
    // ===== MANUFACTURER SELECTION ====================================
    // ================================================================

    public void selectManufacturer(String manufacturerText) {
        By tag = By.xpath(
            "//android.view.ViewGroup[@resource-id='com.atlobha.atlobha:id/manufacturesFlex']"
            + "//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/tagText' and @text='"
            + manufacturerText + "']");
        click(tag);
    }

    public void selectManufacturerByIndex(int index) {
        WebElement container = findElement(manufacturersContainer);
        List<WebElement> tags = container.findElements(tagItems);
        if (index >= 0 && index < tags.size()) {
            tags.get(index).click();
        } else {
            throw new IndexOutOfBoundsException(
                "Manufacturer index " + index + " is out of range. Total: " + tags.size());
        }
    }

    // ================================================================
    // ===== APPLY FILTER ========================
    // ================================================================

    public void clickApplyFilter() {
        click(applyFilterButton);
    }

    // ================================================================
    // ===== Reset FILTER ========================
    // ================================================================
    public void clickResetFilter(){
        click(resetFilterButton);
    }
    
}
