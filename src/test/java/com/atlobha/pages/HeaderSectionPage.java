package com.atlobha.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class HeaderSectionPage extends BasePage {
    
    // Locators
    private By addressesView = By.id("com.atlobha.atlobha:id/toolbar_address_name_tv");
    private By carsView = By.id("com.atlobha.atlobha:id/car_container_view");
    private By whatsAppIcon = By.id("com.atlobha.atlobha:id/icWhatsapp");

   // Constructor
   public HeaderSectionPage (AndroidDriver driver){
    super(driver);
   }

   // Actions
   public void clickMyaddressesView(){
    click(addressesView);
   }

   public void clickMyCarsView(){
    click(carsView);
   }

   public void clickWhatsAppIcon(){
    click(whatsAppIcon);
   }
}
