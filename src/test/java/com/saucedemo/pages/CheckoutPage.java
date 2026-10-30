
package com.saucedemo.pages;

import com.saucedemo.utils.Generic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckoutPage {

    private WebDriver driver;

    // Cart page
    private By checkoutButton = By.id("checkout");

    // Checkout information page
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodeField = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By cancelButton = By.id("cancel");
    private By errorMessage = By.cssSelector("[data-test='error']");

    // Checkout overview page
    private By overviewTitle = By.className("title");
    private By itemTotal = By.className("summary_subtotal_label");
    private By tax = By.className("summary_tax_label");
    private By total = By.className("summary_total_label");
    private By finishButton = By.id("finish");

    // Order confirmation page
    private By confirmationMessage =
            By.className("complete-header");

    // Cart page
    private By cartIcon = By.className("shopping_cart_link");
    private By cartItems = By.className("cart_item");


    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCheckout() {
        Generic.waitForElementVisible(driver, checkoutButton, 10);
        driver.findElement(checkoutButton).click();
    }

    public void enterFirstName(String firstName) {
        Generic.waitForElementVisible(driver, firstNameField, 10);
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterPostalCode(String postalCode) {
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public void clickCancel() {
        driver.findElement(cancelButton).click();
    }

    public String getErrorMessage() {
        Generic.waitForElementVisible(driver, errorMessage, 10);
        return driver.findElement(errorMessage).getText();
    }

    public boolean isOverviewDisplayed() {

        Generic.waitForElementVisible(driver, overviewTitle, 10);

        String actualTitle = driver.findElement(overviewTitle).getText();

        System.out.println("Actual checkout page title: " + actualTitle);
        System.out.println("Current URL: " + driver.getCurrentUrl());

        return actualTitle.equals("Checkout: Overview");
    }

    public double getItemTotal() {
        String text = driver.findElement(itemTotal).getText();
        return extractAmount(text);
    }

    public double getTax() {
        String text = driver.findElement(tax).getText();
        return extractAmount(text);
    }

    public double getTotal() {
        String text = driver.findElement(total).getText();
        return extractAmount(text);
    }

    private double extractAmount(String text) {
        return Double.parseDouble(
                text.replaceAll("[^0-9.]", "")
        );
    }

    public boolean isOrderTotalCorrect() {
        return Math.abs(
                getTotal() - (getItemTotal() + getTax())
        ) < 0.001;
    }

    public void finishOrder() {
        Generic.waitForElementVisible(driver, finishButton, 10);
        driver.findElement(finishButton).click();
    }


    public boolean isOrderConfirmationDisplayed() {

        org.openqa.selenium.support.ui.WebDriverWait wait =
                new org.openqa.selenium.support.ui.WebDriverWait(
                        driver,
                        java.time.Duration.ofSeconds(15)
                );

        wait.until(
                org.openqa.selenium.support.ui.ExpectedConditions
                        .urlContains("checkout-complete.html")
        );

        Generic.waitForElementVisible(driver, confirmationMessage, 10);

        return driver.findElement(confirmationMessage)
                .getText()
                .equals("Thank you for your order!");
    }


    public int getCartItemCount() {
        driver.findElement(cartIcon).click();
        return driver.findElements(cartItems).size();
    }
    public String getCheckoutErrorMessage() {
        Generic.waitForElementVisible(driver, errorMessage, 10);
        return driver.findElement(errorMessage).getText();
    }
}