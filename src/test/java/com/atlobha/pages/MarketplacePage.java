package com.atlobha.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MarketplacePage extends BasePage {

    // ===== Swipe to Refresh =====
    private final By swipeToRefresh = By.id("com.atlobha.atlobha:id/swipe_to_refresh");

    // ===== Quick Links =====
    private final By quickLinks = By.id("com.atlobha.atlobha:id/quick_link_iv");

    // ===== Section Titles & Show All =====
    private final By sectionTitles = By.id("com.atlobha.atlobha:id/section_title");
    private final By showAllButtons = By.id("com.atlobha.atlobha:id/showAllTv");

    // ===== Product Categories - تصنيفات اطلبها =====
    private final By categoriesSectionTitle = By.xpath("//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/section_title' and @text='تصنيفات اطلبها']");
    private final By categoryNames = By.id("com.atlobha.atlobha:id/category_name");
    private final By carCareCategory = By.xpath("//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/category_name' and @text='العناية بالسيارة']");
    private final By todayOffersCategory = By.xpath("//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/category_name' and @text='عروض اليوم']");
    private final By sparePartsCategory = By.xpath("//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/category_name' and @text='قطع غيار']");
    private final By oilsCategory = By.xpath("//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/category_name' and @text='زيوت']");
    private final By tiresCategory = By.xpath("//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/category_name' and @text='اطارات']");
    private final By batteriesCategory = By.xpath("//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/category_name' and @text='بطاريات']");
    private final By accessoriesCategory = By.xpath("//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/category_name' and @text='اكسسوارات']");

    // ===== Buy Again - اشتري مره اخري =====
    private final By buyAgainSectionTitle = By.xpath("//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/section_title' and @text='اشتري مره اخري']");

    // ===== Services Categories - اقسام الخدمات =====
    private final By servicesSectionTitle = By.xpath("//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/section_title' and @text='اقسام الخدمات']");
    private final By oilsService = By.xpath("//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/category_name' and @text='الزيوت']");
    private final By carDiagnosticService = By.xpath("//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/category_name' and @text='تشخيص السيارة']");
    private final By tiresService = By.xpath("//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/category_name' and @text='الاطارات']");
    private final By carWashService = By.xpath("//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/category_name' and @text='غسيل السياره']");
    private final By towingService = By.xpath("//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/category_name' and @text='السطحات']");
    private final By accidentEstimateService = By.xpath("//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/category_name' and @text='تقدير الحوداث']");

    // ===== Car Care Products - العنيايه بالسياره =====
    private final By carCareSectionTitle = By.xpath("//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/section_title' and @text='العنيايه بالسياره']");

    // ===== Oils Products - الزيوت =====
    private final By oilsSectionTitle = By.xpath("//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/section_title' and @text='الزيوت']");

    // ===== Test Drive =====
    private final By testDriveCover = By.id("com.atlobha.atlobha:id/testDriveCover");
    private final By testDriveImage = By.id("com.atlobha.atlobha:id/testDriveIv");

    // ===== Discover More - اكتشف اكثر =====
    private final By discoverMoreSectionTitle = By.xpath("//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/section_title' and @text='اكتشف اكثر']");
    private final By featuredProducts = By.id("com.atlobha.atlobha:id/featured_product_iv");

    // ===== Accessories Products - الاكسسوارات =====
    private final By accessoriesSectionTitle = By.xpath("//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/section_title' and @text='الاكسسوارات']");

    // ===== Recently Viewed - شوهد مؤخرا =====
    private final By recentlyViewedSectionTitle = By.xpath("//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/section_title' and @text='شوهد مؤخرا']");

    // ===== Partners - شركاء اطلبها =====
    private final By partnersSectionTitle = By.xpath("//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/section_title' and @text='شركاء اطلبها']");
    private final By partnerImages = By.id("com.atlobha.atlobha:id/manufacture_iv");
    private final By partnerNames = By.id("com.atlobha.atlobha:id/manufacture_name");

    // ===== Sponsored Ad =====
    private final By sponsoredAd = By.id("com.atlobha.atlobha:id/sponsoredAdIv");

    // ===== Product Card Elements (shared across all sections) =====
    private final By productCards = By.id("com.atlobha.atlobha:id/product_card");
    private final By productNames = By.id("com.atlobha.atlobha:id/product_name");
    private final By productPrices = By.id("com.atlobha.atlobha:id/price_tv");
    private final By addToCartIcons = By.id("com.atlobha.atlobha:id/cart_add_iv");
    private final By itemCounts = By.id("com.atlobha.atlobha:id/itemCount");
    private final By plusIcons = By.id("com.atlobha.atlobha:id/plusIcon");
    private final By minusIcons = By.id("com.atlobha.atlobha:id/minusIcon");

    public MarketplacePage(AndroidDriver driver) {
        super(driver);
    }

    // ===== Quick Link Actions =====
    public void clickQuickLinkByIndex(int index) {
        List<WebElement> links = driver.findElements(quickLinks);
        if (index >= 0 && index < links.size()) {
            links.get(index).click();
        } else {
            throw new IndexOutOfBoundsException(
                "Quick link index " + index + " is out of range. Total links: " + links.size());
        }
    }

    public int getQuickLinksCount() {
        return driver.findElements(quickLinks).size();
    }

    // ===== Category Actions =====
    public void clickCarCare() { 
        click(carCareCategory); 
    }
    public void clickTodayOffers() {
         click(todayOffersCategory); 
    }
    public void clickSpareParts() {
         click(sparePartsCategory); 
    }
    public void clickOils() {
         click(oilsCategory);
    }
    public void clickTires() { 
        click(tiresCategory); 
    }
    public void clickBatteries() {
         click(batteriesCategory); 
    }
    public void clickAccessories() {
         click(accessoriesCategory); 
    }

    public int getCategoryCount() {
        return driver.findElements(categoryNames).size();
    }

    // ===== Service Category Actions =====
    public void clickOilsService() {
         click(oilsService); 
    }
    public void clickCarDiagnosticService() {
         click(carDiagnosticService); 
    }
    public void clickTiresService() {
         click(tiresService); 
    }
    public void clickCarWashService() {
         click(carWashService); 
    }
    public void clickTowingService() {
         click(towingService); 
    }
    public void clickAccidentEstimateService() {
         click(accidentEstimateService); 
    }

    // ===== Section "Show All" Actions =====
    public void clickShowAllForSection(String sectionName) {
        By showAll = By.xpath("//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/section_title' and @text='" + sectionName + "']/following-sibling::android.widget.TextView[@resource-id='com.atlobha.atlobha:id/showAllTv']");
        click(showAll);
    }

    // ===== Test Drive Actions =====
    public void clickTestDrive() {
        click(testDriveImage);
    }

    // ===== Discover More Actions =====
    public void clickFeaturedProductByIndex(int index) {
        List<WebElement> featured = driver.findElements(featuredProducts);
        if (index >= 0 && index < featured.size()) {
            featured.get(index).click();
        } else {
            throw new IndexOutOfBoundsException(
                "Featured product index " + index + " is out of range. Total: " + featured.size());
        }
    }

    public int getFeaturedProductCount() {
        return driver.findElements(featuredProducts).size();
    }

    // ===== Partner Actions =====
    public void clickPartnerByIndex(int index) {
        List<WebElement> partners = driver.findElements(partnerImages);
        if (index >= 0 && index < partners.size()) {
            partners.get(index).click();
        } else {
            throw new IndexOutOfBoundsException(
                "Partner index " + index + " is out of range. Total: " + partners.size());
        }
    }

    public void clickPartnerByName(String name) {
        By partner = By.xpath("//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/manufacture_name' and @text='" + name + "']");
        click(partner);
    }

    public String getPartnerNameByIndex(int index) {
        List<WebElement> names = driver.findElements(partnerNames);
        if (index >= 0 && index < names.size()) {
            return names.get(index).getText();
        }
        throw new IndexOutOfBoundsException(
            "Partner index " + index + " is out of range. Total: " + names.size());
    }

    public int getPartnerCount() {
        return driver.findElements(partnerNames).size();
    }

    // ===== Product Actions (across all visible products) =====
    public void clickProductByIndex(int index) {
        List<WebElement> products = driver.findElements(productCards);
        if (index >= 0 && index < products.size()) {
            products.get(index).click();
        } else {
            throw new IndexOutOfBoundsException(
                "Product index " + index + " is out of range. Total products: " + products.size());
        }
    }

    public void addProductToCartByIndex(int index) {
        List<WebElement> addButtons = driver.findElements(addToCartIcons);
        if (index >= 0 && index < addButtons.size()) {
            addButtons.get(index).click();
        } else {
            throw new IndexOutOfBoundsException(
                "Product index " + index + " is out of range.");
        }
    }

    public void increaseProductQuantityByIndex(int index) {
        List<WebElement> plus = driver.findElements(plusIcons);
        if (index >= 0 && index < plus.size()) {
            plus.get(index).click();
        } else {
            throw new IndexOutOfBoundsException(
                "Product index " + index + " is out of range.");
        }
    }

    public void decreaseProductQuantityByIndex(int index) {
        List<WebElement> minus = driver.findElements(minusIcons);
        if (index >= 0 && index < minus.size()) {
            minus.get(index).click();
        } else {
            throw new IndexOutOfBoundsException(
                "Product index " + index + " is out of range.");
        }
    }

    // ===== Product Getters =====
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
        return driver.findElements(productCards).size();
    }

    // ===== Verification Methods =====
    public boolean isCategoriesSectionDisplayed() {
         return isElementDisplayed(categoriesSectionTitle); 
    }
    public boolean isServicesSectionDisplayed() {
         return isElementDisplayed(servicesSectionTitle); 
    }
    public boolean isBuyAgainSectionDisplayed() {
         return isElementDisplayed(buyAgainSectionTitle); 
    }
    public boolean isCarCareSectionDisplayed() {
         return isElementDisplayed(carCareSectionTitle); 
    }
    public boolean isOilsSectionDisplayed() { 
        return isElementDisplayed(oilsSectionTitle); 
    }
    public boolean isTestDriveCoverDisplayed() {
         return isElementDisplayed(testDriveCover); 
    }
    public boolean isDiscoverMoreSectionDisplayed() {
         return isElementDisplayed(discoverMoreSectionTitle); 
    }
    public boolean isAccessoriesSectionDisplayed() {
         return isElementDisplayed(accessoriesSectionTitle); 
    }
    public boolean isRecentlyViewedSectionDisplayed() {
         return isElementDisplayed(recentlyViewedSectionTitle); 
    }
    public boolean isPartnersSectionDisplayed() {
         return isElementDisplayed(partnersSectionTitle); 
    }
    public boolean isSponsoredAdDisplayed() {
         return isElementDisplayed(sponsoredAd); 
    }

    public boolean isSectionDisplayed(String sectionName) {
        By section = By.xpath("//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/section_title' and @text='" + sectionName + "']");
        return isElementDisplayed(section);
    }

    public boolean isCategoryDisplayed(String name) {
        By category = By.xpath("//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/category_name' and @text='" + name + "']");
        return isElementDisplayed(category);
    }

    public boolean isProductDisplayed(String name) {
        By product = By.xpath("//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/product_name' and @text='" + name + "']");
        return isElementDisplayed(product);
    }

    public boolean isPartnerDisplayed(String name) {
        By partner = By.xpath("//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/manufacture_name' and @text='" + name + "']");
        return isElementDisplayed(partner);
    }
}