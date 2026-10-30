
package com.saucedemo.pages;

import com.saucedemo.utils.Generic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductsPage {

    private WebDriver driver;

    // Locators
    private By productsTitle = By.className("title");
    private By productNames = By.className("inventory_item_name");
    private By productPrices = By.className("inventory_item_price");
    private By sortDropdown = By.className("product_sort_container");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Verify products page
    public boolean isProductsPageDisplayed() {

        Generic.waitForElementVisible(driver, productsTitle, 10);

        return driver.findElement(productsTitle)
                .getText().equals("Products");
    }

    // Get product names
    public List<String> getProductNames() {

        Generic.waitForElementVisible(driver, productNames, 10);

        List<String> names = new ArrayList<>();

        for (WebElement element : driver.findElements(productNames)) {
            names.add(element.getText());
        }

        return names;
    }

    // Get product prices
    public List<Double> getProductPrices() {

        Generic.waitForElementVisible(driver, productPrices, 10);

        List<Double> prices = new ArrayList<>();

        for (WebElement element : driver.findElements(productPrices)) {
            prices.add(Double.parseDouble(
                    element.getText().replace("$", "")));
        }

        return prices;
    }

    // Sort products
    public void sortProducts(String option) {

        Generic.waitForElementVisible(driver, sortDropdown, 10);

        org.openqa.selenium.support.ui.Select select =
                new org.openqa.selenium.support.ui.Select(
                        driver.findElement(sortDropdown));

        select.selectByVisibleText(option);
    }

    // Check alphabetical order
    public boolean isAlphabeticalOrder() {

        List<String> actualNames = getProductNames();

        List<String> expectedNames = new ArrayList<>(actualNames);

        Collections.sort(expectedNames);

        return actualNames.equals(expectedNames);
    }

    // Check reverse alphabetical order
    public boolean isReverseAlphabeticalOrder() {

        List<String> actualNames = getProductNames();

        List<String> expectedNames = new ArrayList<>(actualNames);

        expectedNames.sort(Collections.reverseOrder());

        return actualNames.equals(expectedNames);
    }

    // Check ascending price order
    public boolean isPriceAscending() {

        List<Double> actualPrices = getProductPrices();

        List<Double> expectedPrices = new ArrayList<>(actualPrices);

        Collections.sort(expectedPrices);

        return actualPrices.equals(expectedPrices);
    }

    // Check descending price order
    public boolean isPriceDescending() {

        List<Double> actualPrices = getProductPrices();

        List<Double> expectedPrices = new ArrayList<>(actualPrices);

        expectedPrices.sort(Collections.reverseOrder());

        return actualPrices.equals(expectedPrices);
    }
    public void navigateToProductsPage() {
        driver.get("https://www.saucedemo.com/inventory.html");
    }

}
