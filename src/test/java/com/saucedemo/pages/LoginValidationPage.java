
package com.saucedemo.pages;

import com.saucedemo.utils.Generic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginValidationPage {

    private WebDriver driver;

    private By errorMessage = By.cssSelector("[data-test='error']");
    private By productsTitle = By.className("title");
    private By menuButton = By.id("react-burger-menu-btn");
    private By logoutButton = By.id("logout_sidebar_link");

    public LoginValidationPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getErrorMessage() {

        Generic.waitForElementVisible(driver, errorMessage, 10);

        return driver.findElement(errorMessage).getText();
    }

    public boolean isProductsPageDisplayed() {

        Generic.waitForElementVisible(driver, productsTitle, 10);

        return driver.findElement(productsTitle)
                .getText().equals("Products");
    }
    public void logout() {
        Generic.waitForElementVisible(driver, menuButton, 10);
        driver.findElement(menuButton).click();

        Generic.waitForElementVisible(driver, logoutButton, 10);
        driver.findElement(logoutButton).click();
    }
    public boolean isLoginPageDisplayed() {
        return driver.findElement(By.id("login-button")).isDisplayed();
    }
}
