package com.saucedemo.stepdefinitions;

import com.saucedemo.factory.DriverFactory;
import com.saucedemo.pages.CartPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartStep {

    WebDriver driver;
    CartPage cartPage;

    @Before(order = 1)
    public void initializePages() {
        driver = DriverFactory.getDriver();
        cartPage = new CartPage(driver);
    }

    @When("user adds two products to cart")
    public void user_adds_two_products_to_cart() {
        cartPage.addTwoProducts();
    }

    @Then("cart badge should display {string}")
    public void cart_badge_should_display(String expectedCount) {
        Assert.assertEquals(
                cartPage.getCartBadgeCount(),
                expectedCount,
                "Cart badge count is incorrect"
        );
    }

    @When("user removes one product from cart")
    public void user_removes_one_product_from_cart() {
        cartPage.removeOneProduct();
    }

    @When("user opens the cart")
    public void user_opens_the_cart() {
        cartPage.openCart();
    }

    @Then("{int} products should be displayed in the cart")
    public void products_should_be_displayed_in_cart(int expectedCount) {
        Assert.assertEquals(
                cartPage.getCartItemCount(),
                expectedCount,
                "Cart item count is incorrect"
        );
    }

    @When("user removes all products from cart")
    public void user_removes_all_products_from_cart() {
        cartPage.removeAllProducts();
    }
    @Then("two products should be displayed in the cart")
    public void two_products_should_be_displayed_in_cart() {

        Assert.assertEquals(
                cartPage.getCartItemCount(),
                2,
                "Two products are not displayed in the cart"
        );
    }

    @Then("cart should be empty")
    public void cart_should_be_empty() {
        Assert.assertEquals(
                cartPage.getCartItemCount(),
                0,
                "Cart is not empty"
        );
    }
}