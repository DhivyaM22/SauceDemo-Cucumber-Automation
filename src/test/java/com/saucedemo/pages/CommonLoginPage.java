
package com.saucedemo.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.saucedemo.utils.Generic;
public class CommonLoginPage {

    private WebDriver driver;

    // XPath locators
    private By usernameField = By.xpath("//input[@id='user-name']");
    private By passwordField = By.xpath("//input[@id='password']");
    private By loginButton = By.xpath("//input[@id='login-button']");

    // Constructor
    public CommonLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterText(String value, String fieldName) {

        if (fieldName.equalsIgnoreCase("username")) {

            Generic.waitForElementVisible(driver, usernameField, 10);
            driver.findElement(usernameField).sendKeys(value);

        } else if (fieldName.equalsIgnoreCase("password")) {

            Generic.waitForElementVisible(driver, passwordField, 10);
            driver.findElement(passwordField).sendKeys(value);

        } else {
            throw new IllegalArgumentException(
                    "Invalid field name: " + fieldName);
        }
    }

    public void clickLogin() {

        Generic.waitForElementVisible(driver, loginButton, 10);
        driver.findElement(loginButton).click();
    }


}
