
package com.saucedemo.stepdefinitions;

import com.saucedemo.factory.DriverFactory;
import com.saucedemo.pages.ProductsPage;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductsStep {

    WebDriver driver;
    ProductsPage productsPage;

    @Before(order = 1)
    public void initializePages() {

        driver = DriverFactory.getDriver();

        productsPage = new ProductsPage(driver);
    }

    @Then("user should see the products page")
    public void user_should_see_products_page() {

        Assert.assertTrue(
                productsPage.isProductsPageDisplayed(),
                "Products page is not displayed");
    }

    @Then("user should see the product list")
    public void user_should_see_product_list() {

        Assert.assertFalse(
                productsPage.getProductNames().isEmpty(),
                "Product list is empty");
    }

    @When("user sorts products by {string}")
    public void user_sorts_products(String option) {

        productsPage.sortProducts(option);
    }

    @Then("products should be displayed in alphabetical order")
    public void products_should_be_in_alphabetical_order() {

        Assert.assertTrue(
                productsPage.isAlphabeticalOrder(),
                "Products are not in alphabetical order");
    }

    @Then("products should be displayed in reverse alphabetical order")
    public void products_should_be_in_reverse_alphabetical_order() {

        Assert.assertTrue(
                productsPage.isReverseAlphabeticalOrder(),
                "Products are not in reverse alphabetical order");
    }

    @Then("products should be displayed in ascending price order")
    public void products_should_be_in_ascending_price_order() {

        Assert.assertTrue(
                productsPage.isPriceAscending(),
                "Products are not sorted by price low to high");
    }

    @Then("products should be displayed in descending price order")
    public void products_should_be_in_descending_price_order() {

        Assert.assertTrue(
                productsPage.isPriceDescending(),
                "Products are not sorted by price high to low");
    }
}
