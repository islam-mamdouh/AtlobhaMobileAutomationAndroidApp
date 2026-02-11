# Atlobha Mobile Automation - Android App

Automated testing framework for the **Atlobha** Android mobile application using Appium and TestNG with the Page Object Model (POM) design pattern.

## Tech Stack

| Technology | Version | Purpose |
|---|---|---|
| Java | 11 | Programming language |
| Appium Java Client | 8.6.0 | Mobile automation library |
| Selenium | 4.15.0 | WebDriver framework |
| TestNG | 7.8.0 | Test execution and reporting |
| Maven | - | Build and dependency management |
| SLF4J Simple | 2.0.9 | Logging |

## Project Structure

```
src/test/java/com/atlobha/
├── pages/                          # Page Object classes
│   ├── BasePage.java               # Base class with reusable actions (click, scroll, swipe, wait)
│   ├── LoginPage.java              # Login screen interactions
│   ├── NavBarPage.java             # Bottom navigation bar
│   ├── NavMenuPage.java            # Navigation menu / bottom sheet popup
│   ├── HeaderSectionPage.java      # App header section (cars, addresses)
│   ├── ProfilePage.java            # User profile screen
│   ├── MarketplacePage.java        # Marketplace home (categories, products, partners)
│   ├── CartPage.java               # Shopping cart management
│   ├── MarketplaceCheckoutPage.java# Checkout flow (address, delivery, payment)
│   ├── PricingPage.java            # Spare parts pricing flow
│   ├── OrderConfirmationPage.java  # Order confirmation screen
│   ├── AddNewCarBottomSheetPage.java       # Add car form (brand, model, year, chassis)
│   ├── AddNewAddressBottomSheetPage.java   # Add address form (map, national address)
│   ├── CarsBottomSheet.java        # Cars list bottom sheet
│   └── AddresesBottomSheet.java    # Addresses list bottom sheet
│
├── tests/                          # Test classes
│   ├── BaseTest.java               # Test setup/teardown (driver initialization)
│   ├── LoginFlowTest.java          # Login from multiple entry points
│   ├── MarketplaceOrderE2ETest.java# End-to-end marketplace order flow
│   ├── PricingOrderE2ETest.java    # End-to-end pricing order flow
│   ├── NavBarTest.java             # Navigation bar tests
│   ├── AddNewCarTest.java          # Add new car tests
│   ├── AddNewaddressTest.java      # Add new address tests
│   └── SampleTest.java             # Sample/smoke test
│
└── resources/
    └── testng.xml                  # TestNG suite configuration
```

## Design Pattern

**Page Object Model (POM)** with a `BasePage` providing:

- **Explicit waits** (`WebDriverWait`) instead of raw `Thread.sleep` for element interactions
- **Scroll & swipe helpers** using `PointerInput` sequences (scroll up/down, pull-to-refresh, tap by coordinates)
- **Element state checks** (`isElementDisplayed`, `isElementEnabled`)
- **Input validation** (`validateNotEmpty`) for dynamic XPath locators
- **Section-scoped element access** to target products within specific marketplace sections

## Test Coverage

| Test Class | Scenarios |
|---|---|
| `LoginFlowTest` | Login via Profile/More button, Login via Add Car, Login via Add Address |
| `MarketplaceOrderE2ETest` | Full E2E: add products from multiple sections, manage cart quantities, guest checkout with login, add address, cash payment, order confirmation |
| `PricingOrderE2ETest` | Full E2E: navigate to pricing, add spare parts, guest login, add car, add address, promo code, submit order |
| `NavBarTest` | Bottom navigation bar interactions |
| `AddNewCarTest` | Add new car flow (brand, model, year, chassis) |
| `AddNewaddressTest` | Add new address flow (home/work, national address) |

## Prerequisites

- **Java JDK 11+**
- **Maven**
- **Appium Server** running on `http://127.0.0.1:4723`
- **Android Emulator** (`emulator-5554`) or physical device with:
  - Platform: Android 16
  - Atlobha app installed (`com.atlobha.atlobha`)
- **UiAutomator2** driver

## Setup & Running

```bash
# Install dependencies
mvn clean install -DskipTests

# Run all tests
mvn test

# Run specific test class
mvn -Dtest=LoginFlowTest test

# Run specific test method
mvn -Dtest=MarketplaceOrderE2ETest#testMarketplaceOrderEndToEnd test
```

## Configuration

Driver capabilities are configured in `BaseTest.java`:

```java
UiAutomator2Options options = new UiAutomator2Options()
    .setDeviceName("emulator-5554")
    .setPlatformName("Android")
    .setPlatformVersion("16")
    .setAppPackage("com.atlobha.atlobha")
    .setAppActivity("com.otlobha.otlobha.MainActivity")
    .setAutoGrantPermissions(true)
    .setNoReset(true);
```

## Key Features

- **Section-scoped product actions**: Target products within specific marketplace sections using dynamic XPath relative to section titles
- **Reusable helper methods**: `getElementFromList()` for safe index-based element access with descriptive error messages
- **Complete flow methods**: `addNewCar()`, `addHomeAddress()` for common multi-step operations
- **Multiple payment methods**: Cash, Credit Card, Tabby, Tamara, MISpay
- **Cart management**: Increase/decrease quantities, remove items, verify totals
