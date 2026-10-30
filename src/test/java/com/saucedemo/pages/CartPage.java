
package com.saucedemo.pages;

import com.saucedemo.utils.Generic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {

    private WebDriver driver;

    // Product buttons on Products page
    private By addBackpackButton =
            By.id("add-to-cart-sauce-labs-backpack");

    private By addBikeLightButton =
            By.id("add-to-cart-sauce-labs-bike-light");

    // Cart page locators
    private By cartIcon = By.className("shopping_cart_link");
    private By cartBadge = By.className("shopping_cart_badge");
    private By cartItems = By.className("cart_item");
    private By removeBackpackButton =
            By.id("remove-sauce-labs-backpack");
    private By removeBikeLightButton =
            By.id("remove-sauce-labs-bike-light");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Add two products to cart
    public void addTwoProducts() {
        Generic.waitForElementVisible(driver, addBackpackButton, 10);
        driver.findElement(addBackpackButton).click();

        Generic.waitForElementVisible(driver, addBikeLightButton, 10);
        driver.findElement(addBikeLightButton).click();
    }

    // Get cart badge count
    public String getCartBadgeCount() {
        Generic.waitForElementVisible(driver, cartBadge, 10);
        return driver.findElement(cartBadge).getText();
    }

    // Remove one product from Products page
    public void removeOneProduct() {
        Generic.waitForElementVisible(driver, removeBackpackButton, 10);
        driver.findElement(removeBackpackButton).click();
    }

    // Open cart
    public void openCart() {
        Generic.waitForElementVisible(driver, cartIcon, 10);
        driver.findElement(cartIcon).click();
    }

    // Get number of products in cart
    public int getCartItemCount() {
        return driver.findElements(cartItems).size();
    }

    // Remove all products from cart
    public void removeAllProducts() {
        List<WebElement> removeButtons = driver.findElements(
                By.cssSelector(".cart_item button")
        );

        for (WebElement button : removeButtons) {
            button.click();
        }
    }
}
