
package com.saucedemo.stepdefinitions;

import com.saucedemo.factory.DriverFactory;
import com.saucedemo.pages.ProductsPage;
import com.saucedemo.pages.LoginValidationPage;
import com.saucedemo.utils.ConfigReader;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LogoutStep {

    WebDriver driver;
    ProductsPage productsPage;
    LoginValidationPage loginValidationPage;

    @Before(order = 1)
    public void initializePages() {
        driver = DriverFactory.getDriver();
        productsPage = new ProductsPage(driver);
        loginValidationPage = new LoginValidationPage(driver);
    }
    @When("user logs out")
    public void user_logs_out() {
        loginValidationPage.logout();
    }

    @When("user navigates directly to the products page")
    public void user_navigates_directly_to_products_page() {
        productsPage.navigateToProductsPage();
    }

    @Then("user should be redirected to the login page")
    public void user_should_be_redirected_to_login_page() {
        Assert.assertTrue(
                loginValidationPage.isLoginPageDisplayed(),
                "User was not redirected to login page"
        );
    }
}
