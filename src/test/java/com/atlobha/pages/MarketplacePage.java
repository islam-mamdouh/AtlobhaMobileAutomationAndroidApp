package com.atlobha.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MarketplacePage extends BasePage {

    // ===== Quick Links =====
    private final By quickLinks = By.id("com.atlobha.atlobha:id/quick_link_iv");

    // ===== Section Titles & Show All =====
    private final By sectionTitles = By.id("com.atlobha.atlobha:id/section_title");
    
    // ===== Product Categories - تصنيفات اطلبها =====
    private final By categoriesSectionTitle = By.xpath(
        "//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/section_title' and @text='تصنيفات اطلبها']");
    private final By categoryNames = By.id("com.atlobha.atlobha:id/category_name");
    private final By carCareCategory = By.xpath(
        "//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/category_name' and @text='العناية بالسيارة']");
    private final By todayOffersCategory = By.xpath(
        "//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/category_name' and @text='عروض اليوم']");
    private final By sparePartsCategory = By.xpath(
        "//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/category_name' and @text='قطع غيار']");
    private final By oilsCategory = By.xpath(
        "//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/category_name' and @text='زيوت']");
    private final By tiresCategory = By.xpath(
        "//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/category_name' and @text='اطارات']");
    private final By batteriesCategory = By.xpath(
        "//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/category_name' and @text='بطاريات']");
    private final By accessoriesCategory = By.xpath(
        "//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/category_name' and @text='اكسسوارات']");

    // ===== Buy Again - اشتري مره اخري =====
    private final By buyAgainSectionTitle = By.xpath(
        "//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/section_title' and @text='اشتري مره اخري']");

    // ===== Services Categories - اقسام الخدمات =====
    private final By servicesSectionTitle = By.xpath(
        "//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/section_title' and @text='اقسام الخدمات']");
    private final By oilsService = By.xpath(
        "//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/category_name' and @text='الزيوت']");
    private final By carDiagnosticService = By.xpath(
        "//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/category_name' and @text='تشخيص السيارة']");
    private final By tiresService = By.xpath(
        "//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/category_name' and @text='الاطارات']");
    private final By carWashService = By.xpath(
        "//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/category_name' and @text='غسيل السياره']");
    private final By towingService = By.xpath(
        "//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/category_name' and @text='السطحات']");
    private final By accidentEstimateService = By.xpath(
        "//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/category_name' and @text='تقدير الحوداث']");

    // ===== Car Care Products - العنيايه بالسياره =====
    private final By carCareSectionTitle = By.xpath(
        "//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/section_title' and @text='العنيايه بالسياره']");

    // ===== Oils Products - الزيوت =====
    private final By oilsSectionTitle = By.xpath(
        "//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/section_title' and @text='الزيوت']");

    // ===== Test Drive =====
    private final By testDriveCover = By.id("com.atlobha.atlobha:id/testDriveCover");
    private final By testDriveImage = By.id("com.atlobha.atlobha:id/testDriveIv");

    // ===== Discover More - اكتشف اكثر =====
    private final By discoverMoreSectionTitle = By.xpath(
        "//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/section_title' and @text='اكتشف اكثر']");
    private final By featuredProducts = By.id("com.atlobha.atlobha:id/featured_product_iv");

    // ===== Accessories Products - الاكسسوارات =====
    private final By accessoriesSectionTitle = By.xpath(
        "//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/section_title' and @text='الاكسسوارات']");

    // ===== Recently Viewed - شوهد مؤخرا =====
    private final By recentlyViewedSectionTitle = By.xpath(
        "//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/section_title' and @text='شوهد مؤخرا']");

    // ===== Partners - شركاء اطلبها =====
    private final By partnersSectionTitle = By.xpath(
        "//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/section_title' and @text='شركاء اطلبها']");
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

    // ================================================================
    // ===== REUSABLE HELPER: Safe element access from a list =========
    // ================================================================

    /**
     * Safely retrieves an element from a list by index with a descriptive error message.
     * Eliminates repeated bounds-checking code across all index-based methods.
     *
     * @param list        the list of WebElements
     * @param index       the target index
     * @param elementType a label for error messages (e.g., "Quick link", "Product")
     * @return the WebElement at the given index
     */
    private WebElement getElementFromList(List<WebElement> list, int index, String elementType) {
        if (index >= 0 && index < list.size()) {
            return list.get(index);
        }
        throw new IndexOutOfBoundsException(
            elementType + " index " + index + " is out of range. Total: " + list.size());
    }

    // ================================================================
    // ===== INPUT VALIDATION HELPER ===================================
    // ================================================================

    /**
     * Validates that a string parameter is not null or empty.
     * Used before building dynamic XPath locators to prevent silent failures.
     *
     * @param value     the string to validate
     * @param fieldName the name of the field (for error messages)
     */
    private void validateNotEmpty(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be null or empty");
        }
    }

    // ================================================================
    // ===== QUICK LINK ACTIONS =======================================
    // ================================================================

    public void clickQuickLinkByIndex(int index) {
        getElementFromList(driver.findElements(quickLinks), index, "Quick link").click();
    }

    public int getQuickLinksCount() {
        return driver.findElements(quickLinks).size();
    }

    // ================================================================
    // ===== CATEGORY ACTIONS =========================================
    // ================================================================

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

    /**
     * Clicks a category by its visible display name.
     * Supports bilingual testing - pass Arabic or English name depending on app language.
     *
     * @param categoryName the visible text of the category (e.g., "زيوت" or "Oils")
     */
    public void clickCategoryByName(String categoryName) {
        validateNotEmpty(categoryName, "Category name");
        By category = By.xpath(
            "//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/category_name' and @text='"
            + categoryName + "']");
        click(category);
    }

    // ================================================================
    // ===== SERVICE CATEGORY ACTIONS ==================================
    // ================================================================

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

    /**
     * Clicks a service category by its visible display name.
     * Supports bilingual testing - pass Arabic or English name depending on app language.
     *
     * @param serviceName the visible text of the service (e.g., "الزيوت" or "Oils")
     */
    public void clickServiceByName(String serviceName) {
        validateNotEmpty(serviceName, "Service name");
        By service = By.xpath(
            "//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/category_name' and @text='"
            + serviceName + "']");
        click(service);
    }

    // ================================================================
    // ===== SECTION "SHOW ALL" ACTIONS ================================
    // ================================================================

    /**
     * Clicks the "Show All" button next to a specific section title.
     * Uses XPath following-sibling to find the button relative to the section header.
     *
     * @param sectionName the exact visible text of the section title
     */
    public void clickShowAllForSection(String sectionName) {
        validateNotEmpty(sectionName, "Section name");
        By showAll = By.xpath(
            "//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/section_title' and @text='"
            + sectionName
            + "']/following-sibling::android.widget.TextView[@resource-id='com.atlobha.atlobha:id/showAllTv']");
        click(showAll);
    }

    /**
     * Returns the total number of visible section titles on the marketplace page.
     */
    public int getSectionCount() {
        return driver.findElements(sectionTitles).size();
    }

    // ================================================================
    // ===== TEST DRIVE ACTIONS ========================================
    // ================================================================

    public void clickTestDrive() {
        click(testDriveImage);
    }

    // ================================================================
    // ===== DISCOVER MORE / FEATURED PRODUCTS =========================
    // ================================================================

    public void clickFeaturedProductByIndex(int index) {
        getElementFromList(driver.findElements(featuredProducts), index, "Featured product").click();
    }

    public int getFeaturedProductCount() {
        return driver.findElements(featuredProducts).size();
    }

    // ================================================================
    // ===== PARTNER ACTIONS ===========================================
    // ================================================================

    public void clickPartnerByIndex(int index) {
        getElementFromList(driver.findElements(partnerImages), index, "Partner").click();
    }

    public void clickPartnerByName(String name) {
        validateNotEmpty(name, "Partner name");
        By partner = By.xpath(
            "//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/manufacture_name' and @text='"
            + name + "']");
        click(partner);
    }

    public String getPartnerNameByIndex(int index) {
        return getElementFromList(driver.findElements(partnerNames), index, "Partner").getText();
    }

    public int getPartnerCount() {
        return driver.findElements(partnerNames).size();
    }

    // ================================================================
    // ===== PRODUCT ACTIONS (all visible products) ====================
    // ================================================================

    public void clickProductByIndex(String sectionName, int index) {
        List<WebElement> products = getProductsInSection(sectionName);
        getElementFromList(products, index, "Product in section '" + sectionName + "'").click();
    }

    public void addProductToCartByIndex(String sectionName, int index) {
        List<WebElement> products = getProductsInSection(sectionName);
        getElementFromList(products, index, "Product in section '" + sectionName + "'").findElement(addToCartIcons).click();
    }

    public void increaseProductQuantityByIndex(String sectionName, int index) {
    List<WebElement> products = getProductsInSection(sectionName);
    WebElement product = getElementFromList(products, index, "Product in section '" + sectionName + "'");
    
    // Check if plus button is already visible, if not expand first
    List<WebElement> plusBtn = product.findElements(plusIcons);
    if (plusBtn.isEmpty()) {
        product.findElement(itemCounts).click();
    }
    
    product.findElement(plusIcons).click();
}

    public void decreaseProductQuantityByIndex(String sectionName, int index) {
    List<WebElement> products = getProductsInSection(sectionName);
    WebElement product = getElementFromList(products, index, "Product in section '" + sectionName + "'");
    
    // Check if minus button is already visible, if not expand first
    List<WebElement> minusBtn = product.findElements(minusIcons);
    if (minusBtn.isEmpty()) {
        product.findElement(itemCounts).click();
    }
    
    product.findElement(minusIcons).click();
}

    // ================================================================
    // ===== SCROLL TO SECTION ========================================
    // ================================================================

    /**
     * Scrolls down the marketplace page until the specified section title is visible.
     * Uses BasePage scrollDown() in a loop until the section appears or max attempts reached.
     *
     * @param sectionName the exact section title text to scroll to
     */
    public void scrollToSection(String sectionName) {
        validateNotEmpty(sectionName, "Section name");
        int maxScrollAttempts = 10;
        int attempts = 0;
        while (!isSectionDisplayed(sectionName) && attempts < maxScrollAttempts) {
            scrollDown();
            attempts++;
        }
        if (!isSectionDisplayed(sectionName)) {
            throw new RuntimeException(
                "Could not find section '" + sectionName + "' after " + maxScrollAttempts + " scroll attempts");
        }
    }

    // ================================================================
    // ===== SECTION-SCOPED PRODUCT ACTIONS ============================
    // ================================================================

    /**
     * Finds product cards within a specific section by locating the section's parent container.
     * Solves the problem of shared locators returning products from all visible sections.
     *
     * @param sectionName the exact section title text (e.g., "العنيايه بالسياره")
     * @return list of product card WebElements within that section only
     */
    private List<WebElement> getProductsInSection(String sectionName) {
        validateNotEmpty(sectionName, "Section name");
        WebElement sectionContainer = driver.findElement(By.xpath(
            "//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/section_title' and @text='"
            + sectionName + "']/ancestor::android.view.ViewGroup[1]"));
        return sectionContainer.findElements(productCards);
    }

    /**
     * Clicks a product card at a given index within a specific section.
     *
     * @param sectionName the section title text
     * @param index       the product index within that section
     */
    public void clickProductInSection(String sectionName, int index) {
        List<WebElement> products = getProductsInSection(sectionName);
        getElementFromList(products, index, "Product in section '" + sectionName + "'").click();
    }

    /**
     * Adds a product to cart within a specific section.
     *
     * @param sectionName the section title text
     * @param index       the product index within that section
     */
    public void addToCartInSection(String sectionName, int index) {
        validateNotEmpty(sectionName, "Section name");
        WebElement sectionContainer = driver.findElement(By.xpath(
            "//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/section_title' and @text='"
            + sectionName + "']/ancestor::android.view.ViewGroup[1]"));
        List<WebElement> addButtons = sectionContainer.findElements(addToCartIcons);
        getElementFromList(addButtons, index, "Add to cart in section '" + sectionName + "'").click();
    }

    /**
     * Returns the number of products visible within a specific section.
     *
     * @param sectionName the section title text
     * @return count of product cards in that section
     */
    public int getProductCountInSection(String sectionName) {
        return getProductsInSection(sectionName).size();
    }

    // ================================================================
    // ===== PRODUCT GETTERS ==========================================
    // ================================================================

    public String getProductNameByIndex(int index) {
        return getElementFromList(driver.findElements(productNames), index, "Product name").getText();
    }

    public String getProductPriceByIndex(int index) {
        return getElementFromList(driver.findElements(productPrices), index, "Product price").getText();
    }

    public String getProductQuantityByIndex(int index) {
        return getElementFromList(driver.findElements(itemCounts), index, "Item count").getText();
    }

    public int getProductCount() {
        return driver.findElements(productCards).size();
    }

    // ================================================================
    // ===== VERIFICATION METHODS =====================================
    // ================================================================

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

    // ===== Dynamic Verification (by name - supports bilingual) =====

    public boolean isSectionDisplayed(String sectionName) {
        validateNotEmpty(sectionName, "Section name");
        By section = By.xpath(
            "//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/section_title' and @text='"
            + sectionName + "']");
        return isElementDisplayed(section);
    }

    public boolean isCategoryDisplayed(String name) {
        validateNotEmpty(name, "Category name");
        By category = By.xpath(
            "//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/category_name' and @text='"
            + name + "']");
        return isElementDisplayed(category);
    }

    public boolean isProductDisplayed(String name) {
        validateNotEmpty(name, "Product name");
        By product = By.xpath(
            "//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/product_name' and @text='"
            + name + "']");
        return isElementDisplayed(product);
    }

    public boolean isPartnerDisplayed(String name) {
        validateNotEmpty(name, "Partner name");
        By partner = By.xpath(
            "//android.widget.TextView[@resource-id='com.atlobha.atlobha:id/manufacture_name' and @text='"
            + name + "']");
        return isElementDisplayed(partner);
    }
}