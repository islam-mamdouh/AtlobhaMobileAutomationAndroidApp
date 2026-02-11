package com.atlobha.pages;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class ProfilePage extends BasePage {

     private By profileContainer = By.id("com.atlobha.atlobha:id/profileContainer");
     private By walletBalanceContainer = By.id("com.atlobha.atlobha:id/balanceContainer");
     private By myOrdersContainer = By.id("com.atlobha.atlobha:id/ordersContainer");
     private By myAddressesContainer = By.id("com.atlobha.atlobha:id/addressContainer");
     private By myCarsContainer = By.id("com.atlobha.atlobha:id/carsContainer");
     private By myCardsContainer = By.id("com.atlobha.atlobha:id/cardsContainer");
     private By giftCardsButton = By.id("com.atlobha.atlobha:id/giftCardsTv");
     private By languagesButton = By.id("com.atlobha.atlobha:id/language_title");
     private By LogOutButton = By.id("com.atlobha.atlobha:id/action_logout");
     private By confirmLogOutButton = By.id("android:id/button1");
     private By cancelLogOutButton = By.id("android:id/button2");

    public ProfilePage(AndroidDriver driver) {
        super(driver);
    }

        // Actions
    public void clickWalletBalanceContainer() {
        click(walletBalanceContainer);
    }

    public void clickMyOrdersContainer() {
        click(myOrdersContainer);
    }

    public void clickMyAddressesContainer() {
        click(myAddressesContainer);
    }

    public void clickMyCarsContainer() {
        click(myCarsContainer);
    }

    public void clickMyCardsContainer() {
        click(myCardsContainer);
    }

    public void clickGiftCardsButton() {
        click(giftCardsButton);
    }

    public void clickLanguagesButton() {
        click(languagesButton);
    }

    public void clickLogOutButton() {
        click(LogOutButton);
    }

    public void clickConfirmLogOut() {
        click(confirmLogOutButton);
    }

    public void clickCancelLogOut() {
        click(cancelLogOutButton);
    }

    // Verification
    public boolean isProfilePageDisplayed() {
        return isElementDisplayed(profileContainer);
    }

    public boolean isWalletBalanceContainerDisplayed() {
        return isElementDisplayed(walletBalanceContainer);
    }

    public boolean isMyOrdersContainerDisplayed() {
        return isElementDisplayed(myOrdersContainer);
    }

    public boolean isMyAddressesContainerDisplayed() {
        return isElementDisplayed(myAddressesContainer);
    }

    public boolean isMyCarsContainerDisplayed() {
        return isElementDisplayed(myCarsContainer);
    }

    public boolean isMyCardsContainerDisplayed() {
        return isElementDisplayed(myCardsContainer);
    }

    public boolean isGiftCardsButtonDisplayed() {
        return isElementDisplayed(giftCardsButton);
    }

    public boolean isLanguagesButtonDisplayed() {
        return isElementDisplayed(languagesButton);
    }

    public boolean isLogOutButtonDisplayed() {
        return isElementDisplayed(LogOutButton);
    }
    
}
