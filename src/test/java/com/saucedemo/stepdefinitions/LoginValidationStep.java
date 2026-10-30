
package com.saucedemo.stepdefinitions;

import com.saucedemo.factory.DriverFactory;
import com.saucedemo.pages.LoginValidationPage;
import com.saucedemo.pages.CommonLoginPage;
import com.saucedemo.utils.ConfigReader;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginValidationStep {

    WebDriver driver;
    CommonLoginPage loginPage;
    LoginValidationPage validationPage;

    @Before(order = 1)
    public void initializePages() {

        driver = DriverFactory.getDriver();

        loginPage = new CommonLoginPage(driver);
        validationPage = new LoginValidationPage(driver);
    }
    @Given("user is on the Sauce Demo login page")
    public void user_is_on_login_page() {

        driver.get(ConfigReader.getProperty("app.url"));
    }
    @When("user enters valid username")
    public void user_enters_valid_username() {

        loginPage.enterText(
                ConfigReader.getProperty("username"),
                "username");
    }

    @When("user enters locked username")
    public void user_enters_locked_username() {

        loginPage.enterText(
                ConfigReader.getProperty("locked.username"),
                "username");
    }

    @When("user enters valid password")
    public void user_enters_valid_password() {

        loginPage.enterText(
                ConfigReader.getProperty("password"),
                "password");
    }

    @When("user clicks on the login button")
    public void user_clicks_login_button() {

        loginPage.clickLogin();
    }

    @Then("user should navigate to the products page")
    public void user_should_navigate_to_products_page() {

        Assert.assertTrue(
                validationPage.isProductsPageDisplayed(),
                "Products page is not displayed");
    }

    @Then("locked user error message should be displayed")
    public void locked_user_error_should_be_displayed() {

        String actualMessage = validationPage.getErrorMessage();

        Assert.assertTrue(
                actualMessage.contains("locked out"),
                "Locked user error message is not displayed");
    }
}
