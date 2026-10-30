# SauceDemo Cucumber Automation Framework

## A1. Requirement Clarification Questions and Assumptions

Before preparing the manual test cases, I identified the following questions to clarify the requirements with the Product Owner (PO).

| ID | Clarification Question | Assumption |
|---|---|---|
| Q01 | Are there any specific validation rules for the username, such as allowing only alphanumeric characters, minimum and maximum length, or special characters? What error message should be displayed when the username does not meet these rules? | Test alphanumeric usernames, usernames containing special characters, minimum and maximum lengths, and empty usernames. Verify the application's actual error message without assuming a specific validation rule. |
| Q02 | Should the application allow only valid and unlocked users to log in? | Only valid, unlocked users can log in. |
| Q03 | Can a customer add the same product multiple times to the cart? | Follow the application's current behaviour until the quantity rule is confirmed. |
| Q04 | Should the cart retain products when the user navigates between Products and Cart pages? | Cart items should remain until removed or an order is completed. |
| Q05 | After adding a product to the cart and proceeding to checkout, if the user clicks the added product name, the application displays the product details page. When the user navigates back, the application returns to the cart page instead of the previous checkout step. Is this the expected behaviour, or should the user be redirected to the same checkout step where they left off? | The application should maintain the user's checkout progress when navigating back from the product details page, so the user does not have to repeat the checkout process. |
| Q06 | Should the cart retain products after the user logs out and logs in again? | Cart persistence across sessions is not guaranteed. |
| Q07 | Should the postal code accept only numbers, or can it contain letters and special characters? | Test mandatory-field validation. Do not assume a numeric-only restriction. |
| Q08 | What should happen if the user clicks Cancel during checkout? | Return to the products page without placing an order, retaining cart items. |
| Q09 | Should the selected product sorting option remain unchanged after navigating back from the cart? | Sorting persistence is not required unless specified. |
| Q10 | Should users be able to access the Products or Cart page directly through a URL after logging out? | Unauthenticated users must be redirected to the login page. |
| Q11 | Which browsers and screen sizes must the application support? | Chrome desktop is the baseline. Additional supported browsers and screen sizes need confirmation. |

### Conclusion

These clarification questions and assumptions helped identify unclear requirements before test case preparation. Where requirements were not confirmed, I used reasonable assumptions and proceeded with test design.

## Manual Test Cases

The following table contains 31 manual test cases covering Login, Menu, Products, Cart, Checkout, Usability, Compatibility, and Accessibility.

| TC ID | Area | Type | Test Case | Expected Result | Priority | Automation |
|---|---|---|---|---|---|---|
| TC01 | Login | Positive | Login with standard user | User should successfully log in and products page should be displayed. | P1 | Yes |
| TC02 | Login | Negative | Login with locked-out user | User should not be able to log in and an appropriate error should be displayed. | P1 | Yes |
| TC03 | Login | Negative | Login with invalid password | User should not be able to log in and an error message should be displayed. | P1 | Yes |
| TC04 | Login | Boundary | Login with empty username and password | Appropriate validation error should be displayed. | P2 | Yes |
| TC05 | Security | Security | Access products page directly after logout | User should be redirected to login page. | P1 | Yes |
| TC06 | Menu | Positive | Verify hamburger menu opens | Menu should display All Items, About, Logout, and Reset App State. | P2 | Yes |
| TC07 | Menu | Positive | Verify All Items navigation | User should navigate to the products page. | P2 | Yes |
| TC08 | Menu | Positive | Verify About navigation | User should navigate to the Sauce Labs About page. | P3 | No |
| TC09 | Menu | Positive | Verify Logout functionality | User should be logged out and redirected to login page. | P1 | Yes |
| TC10 | Menu | Positive | Verify Reset App State functionality | Cart should be reset, badge should disappear, and Add to Cart buttons should be restored. | P2 | Yes |
| TC11 | Menu | Usability | Verify menu closes using close icon | Menu sidebar should close. | P2 | Yes |
| TC12 | Menu | Usability | Verify menu navigation is keyboard accessible | Menu should be operable using the keyboard with visible focus. | P2 | No |
| TC13 | Products | Positive | Sort products by name A to Z | Products should be sorted alphabetically in ascending order. | P2 | Yes |
| TC14 | Products | Positive | Sort products by name Z to A | Products should be sorted alphabetically in descending order. | P2 | Yes |
| TC15 | Products | Positive | Sort products by price low to high | All product prices should be arranged in ascending order. | P1 | Yes |
| TC16 | Products | Positive | Sort products by price high to low | All product prices should be arranged in descending order. | P2 | Yes |
| TC17 | Cart | Positive | Add two products to cart | Cart badge should display 2. | P1 | Yes |
| TC18 | Cart | Positive | Remove product from products page | Selected product should be removed and cart badge should display 1. | P1 | Yes |
| TC19 | Cart | Positive | Remove product from cart page | Selected product should be removed and only the remaining product should be displayed. | P1 | Yes |
| TC20 | Cart | Boundary | Verify checkout behaviour with empty cart | User should not be able to complete an order without products, subject to confirmed business rules. | P2 | No |
| TC21 | Cart | Positive | Continue shopping from cart | User should return to products page and existing cart items should be retained. | P2 | Yes |
| TC22 | Cart | Boundary | Add the same product multiple times | Verify behaviour against confirmed product quantity rules. | P2 | No |
| TC23 | Checkout | Negative | Checkout without first name | First name validation error should be displayed. | P1 | Yes |
| TC24 | Checkout | Negative | Checkout without last name | Last name validation error should be displayed. | P1 | Yes |
| TC25 | Checkout | Negative | Checkout without postal code | Postal code validation error should be displayed. | P1 | Yes |
| TC26 | Checkout | Positive | Verify checkout order total | Final total should equal item subtotal plus tax. | P1 | Yes |
| TC27 | Checkout | Positive | Complete order successfully | Order confirmation should be displayed and cart should be empty. | P1 | Yes |
| TC28 | Checkout | Negative | Cancel checkout from overview page | User should return to products page without placing an order. | P2 | Yes |
| TC29 | Usability | Usability | Verify cart badge visibility | Cart badge should be clearly visible and display the correct item count. | P2 | No |
| TC30 | Compatibility | Browser/Screen Size | Verify application layout on different screen sizes | Important content and controls should remain accessible and usable. | P2 | No |
| TC31 | Accessibility | Accessibility | Verify keyboard navigation | Interactive controls should be keyboard accessible and focus should be visible. | P2 | No |

**Note:** Automation status indicates the planned or implemented automation coverage. Update it based on the actual feature files and successful test execution.

## Project Overview

This project is a UI automation testing framework developed for the SauceDemo application using Java, Selenium WebDriver, Cucumber BDD, TestNG, and Maven.

The framework follows the Page Object Model (POM) design pattern to improve code reusability, maintainability, and readability.

**Application Under Test:** https://www.saucedemo.com/

## Technologies Used

- Java 17
- Selenium WebDriver 4.35.0
- Cucumber 7.27.2
- TestNG 7.11.0
- Maven
- IntelliJ IDEA
- Extent Reports

## Framework Structure

```text
src/test/java/com/saucedemo/
    factory/
        DriverFactory.java
    hooks/
        Hooks.java
    pages/
        CartPage.java
        CheckoutPage.java
        CommonLoginPage.java
        LoginValidationPage.java
        ProductsPage.java
    runners/
        TestRunner.java
    stepdefinitions/
        CartStep.java
        CheckoutStep.java
        CommonLoginStep.java
        GenericSteps.java
        LoginValidationStep.java
        LogoutStep.java
        ProductsStep.java
    utils/
        ConfigReader.java
        Generic.java

src/test/resources/
    features/
        Login.feature
        Products.feature
        Cart.feature
        Checkout.feature
    config.properties
    extent.properties

pom.xml
```

## Test Scenarios Covered

### Login
- Login with valid credentials.
- Login with locked-out user.
- Verify login validation messages.

### Products
- Verify products are displayed.
- Sort products by name (A to Z).
- Sort products by name (Z to A).
- Sort products by price (low to high).
- Sort products by price (high to low).

### Cart
- Add two products to cart.
- Remove one product from cart.
- Verify cart item count.
- Remove all products from cart.

### Checkout
- Complete checkout with valid details.
- Verify order total calculation.
- Validate mandatory checkout fields.
- Cancel checkout.
- Verify order confirmation and empty cart.

## Design Pattern

The framework follows Page Object Model (POM).

- Page classes contain web elements and application actions.
- Step definition classes connect Gherkin steps with page methods.
- Hooks manage browser setup and teardown.
- DriverFactory manages WebDriver initialization.
- Generic utility class provides reusable Selenium methods.
- ConfigReader reads application configuration.

## Prerequisites

- Java JDK 17
- IntelliJ IDEA
- Maven
- Google Chrome
- Git

## How to Run the Project

1. Clone this repository.
2. Open the project in IntelliJ IDEA.
3. Ensure Java 17 is configured.
4. Check the configuration file under `src/test/resources/config.properties`.
5. Reload Maven dependencies.
6. Execute the TestRunner.java class or run the Maven test lifecycle.

## Reports

The framework uses Extent Reports to generate HTML execution reports.

Report location:

```text
test-output/SparkReport/ExtentReport.html
```

## Future Enhancements

- Implement automatic screenshot capture on test failure.
- Add cross-browser testing.
- Integrate with Jenkins for CI/CD execution.
- Expand test coverage with additional scenarios.
- Support parallel execution for faster test runs.

## Author

Dhivya M