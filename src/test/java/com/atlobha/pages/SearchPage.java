package com.atlobha.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import io.appium.java_client.android.AndroidDriver;

public class SearchPage extends BasePage{

    // ===== Search Input =====
    private final By searchField = By.id("com.atlobha.atlobha:id/search_view");
    // ===== Active Car Filter Bar =====
    private final By deleteFilterButton = By.id("com.atlobha.atlobha:id/deleteFilterTv");
    // ===== Search History Section =====
    private final By searchHistoryTitle = By.id("com.atlobha.atlobha:id/searchHistoryTv");
    private final By searchHistoryContainer = By.id("com.atlobha.atlobha:id/searchHistoryFlex");
    // ===== Most Searched Section =====
    private final By mostSearchedTitle = By.id("com.atlobha.atlobha:id/mostSearchedTv");
    private final By mostSearchedContainer = By.id("com.atlobha.atlobha:id/mostSearchedFlex");
    // ===== Tag Items (shared between search history and most searched) =====
    private final By tagItems = By.id("com.atlobha.atlobha:id/tagText");
    // ===== SEARCH SUGGESTIONS (AUTOCOMPLETE) =====
    private final By searchSuggestions = By.id("com.atlobha.atlobha:id/autoCompleteTv");
    // ===== Search Result =====
    private final By backButton = By.id("com.atlobha.atlobha:id/icBack");
    private final By filterButton = By.id("com.atlobha.atlobha:id/filterIv");
    private final By searchResultsGrid = By.id("com.atlobha.atlobha:id/recyclerview");
    private final By productCards = By.id("com.atlobha.atlobha:id/product_card");
    private final By addToCartButton = By.id("com.atlobha.atlobha:id/cart_add_iv");
    private final By navigateToCart = By.id("com.atlobha.atlobha:id/cartContainer");

    public SearchPage(AndroidDriver driver){
        super(driver);
    }

    // ====== SEARCH ACTIONS ======
    public void clickSearchField() {
        click(searchField);
    }

    public void searchFor(String query) {
        enterText(searchField, query);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));


    }
    
    public void clearSearch() {
        WebElement field = findElement(searchField);
        field.clear();
    }

    // ====== SEARCH HISTORY ACTIONS ======
    public boolean isSearchHistoryDisplayed() {
        return isElementDisplayed(searchHistoryTitle);
    }

    public List<WebElement> getSearchHistoryTags() {
        WebElement container = findElement(searchHistoryContainer);
        return container.findElements(tagItems);
    }

    public void clickSearchHistoryTagByIndex(int index) {
        List<WebElement> tags = getSearchHistoryTags();
        if (index >= 0 && index < tags.size()) {
            tags.get(index).click();
        } else {
            throw new IndexOutOfBoundsException(
                "Search history tag index " + index + " is out of range. Total: " + tags.size());
        }
    }

    public String getSearchHistoryTagTextByIndex(int index) {
        List<WebElement> tags = getSearchHistoryTags();
        if (index >= 0 && index < tags.size()) {
            return tags.get(index).getText();
        }
        throw new IndexOutOfBoundsException(
            "Search history tag index " + index + " is out of range. Total: " + tags.size());
    }

    // ====== MOST SEARCHED ACTIONS ======
    public boolean isMostSearchedDisplayed() {
        return isElementDisplayed(mostSearchedTitle);
    }

    public List<WebElement> getMostSearchedTags() {
        WebElement container = findElement(mostSearchedContainer);
        return container.findElements(tagItems);
    }

    public void clickMostSearchedTagByIndex(int index) {
        List<WebElement> tags = getMostSearchedTags();
        if (index >= 0 && index < tags.size()) {
            tags.get(index).click();
        } else {
            throw new IndexOutOfBoundsException(
                "Most searched tag index " + index + " is out of range. Total: " + tags.size());
        }
    }

    public String getMostSearchedTagTextByIndex(int index) {
        List<WebElement> tags = getMostSearchedTags();
        if (index >= 0 && index < tags.size()) {
            return tags.get(index).getText();
        }
        throw new IndexOutOfBoundsException(
            "Most searched tag index " + index + " is out of range. Total: " + tags.size());
    }

    // ===== Verify That Search Page Loaded =====
    public boolean isSearchPageDisplayed() {
        return isElementDisplayed(searchField);
    }

    // ===== Search Suggestion Actions =====
    public List<WebElement> getSearchSuggestions() {
        return findElements(searchSuggestions);
    }

    public void clickSearchSuggestionByIndex(int index) {
        List<WebElement> suggestions = getSearchSuggestions();
        if (index >= 0 && index < suggestions.size()) {
            suggestions.get(index).click();
        } else {
            throw new IndexOutOfBoundsException(
                "Search suggestion index " + index + " is out of range. Total: " + suggestions.size());
        }
    }

    public void clickSearchSuggestionByText(String text) {
        By suggestion = By.xpath(
            "//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/autoCompleteTv' and @text='"
            + text + "']");
        click(suggestion);
    }

    public String getSearchSuggestionTextByIndex(int index) {
        List<WebElement> suggestions = getSearchSuggestions();
        if (index >= 0 && index < suggestions.size()) {
            return suggestions.get(index).getText();
        }
        throw new IndexOutOfBoundsException(
            "Search suggestion index " + index + " is out of range. Total: " + suggestions.size());
    }

    public boolean areSearchSuggestionsDisplayed() {
        return isElementDisplayed(searchSuggestions);
    }

    // ===== Search Result Actions =====
    public void clickBackButton(){
        click(backButton);
    }

    public void clickFilterButton(){
        click(filterButton);
    }

    public void clickDeleteFilterButton(){
        click(deleteFilterButton);
    }

    public List<WebElement> getSearchResultProducts() {
        return findElements(productCards);
    }

    public void clickSearchResultByIndex(int index) {
        List<WebElement> products = getSearchResultProducts();
        if (index >= 0 && index < products.size()) {
            products.get(index).click();
        } else {
            throw new IndexOutOfBoundsException(
                "Search result index " + index + " is out of range. Total: " + products.size());
        }
    }

    public boolean isSearchResultsDisplayed() {
        return isElementDisplayed(searchResultsGrid);
    }

    public void scrollDownResults() {
        scrollDown();
    }

    public void addToCartByIndex(int index) {
        List<WebElement> products = getSearchResultProducts();
        if (index >= 0 && index < products.size()) {
            products.get(index).findElement(addToCartButton).click();
        } else {
            throw new IndexOutOfBoundsException(
                "Search result index " + index + " is out of range. Total: " + products.size());
        }
    }

    public void addToCartByProductName(String name) {
        By product = By.xpath(
            "//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/product_name' and @text='"
            + name + "']/ancestor::android.view.ViewGroup[@resource-id='com.atlobha.atlobha:id/product_card']");
        WebElement card = findElement(product);
        card.findElement(addToCartButton).click();
    }

    public void clickCartView(){
        click(navigateToCart);
    }

}
