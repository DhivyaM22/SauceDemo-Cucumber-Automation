# SauceDemo Cucumber Automation Framework

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