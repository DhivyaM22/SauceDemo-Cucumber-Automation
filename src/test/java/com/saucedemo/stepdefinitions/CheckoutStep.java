
package com.saucedemo.stepdefinitions;

import com.saucedemo.factory.DriverFactory;
import com.saucedemo.pages.CheckoutPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutStep {

    WebDriver driver;
    CheckoutPage checkoutPage;

    @Before(order = 1)
    public void initializePages() {
        driver = DriverFactory.getDriver();
        checkoutPage = new CheckoutPage(driver);
    }

    @When("user proceeds to checkout")
    public void user_proceeds_to_checkout() {
        checkoutPage.clickCheckout();
    }

    @When("user enters first name {string}")
    public void user_enters_first_name(String firstName) {
        checkoutPage.enterFirstName(firstName);
    }

    @When("user enters last name {string}")
    public void user_enters_last_name(String lastName) {
        checkoutPage.enterLastName(lastName);
    }

    @When("user enters postal code {string}")
    public void user_enters_postal_code(String postalCode) {
        checkoutPage.enterPostalCode(postalCode);
    }

    @When("user continues checkout")
    public void user_continues_checkout() {
        checkoutPage.clickContinue();
    }

    @When("user continues checkout without entering details")
    public void user_continues_checkout_without_details() {
        checkoutPage.clickContinue();
    }

    @Then("checkout overview should be displayed")
    public void checkout_overview_should_be_displayed() {
        Assert.assertTrue(
                checkoutPage.isOverviewDisplayed(),
                "Checkout overview is not displayed"
        );
    }

    @Then("order total should be calculated correctly")
    public void order_total_should_be_calculated_correctly() {
        Assert.assertTrue(
                checkoutPage.isOrderTotalCorrect(),
                "Order total calculation is incorrect"
        );
    }

    @When("user finishes the order")
    public void user_finishes_the_order() {
        checkoutPage.finishOrder();
    }

    @Then("order confirmation should be displayed")
    public void order_confirmation_should_be_displayed() {
        Assert.assertTrue(
                checkoutPage.isOrderConfirmationDisplayed(),
                "Order confirmation is not displayed"
        );
    }

    @Then("checkout error message should be displayed")
    public void checkout_error_message_should_be_displayed() {
        String actualMessage = checkoutPage.getErrorMessage();

        Assert.assertTrue(
                actualMessage.contains("First Name is required"),
                "Expected checkout validation error was not displayed"
        );
    }

    @When("user cancels checkout")
    public void user_cancels_checkout() {
        checkoutPage.clickCancel();
    }

    @Then("user should return to the cart page")
    public void user_should_return_to_cart_page() {
        Assert.assertTrue(
                driver.getCurrentUrl().contains("cart.html"),
                "User did not return to the cart page"
        );
    }
    @Then("checkout error message should be {string}")
    public void checkout_error_message_should_be(String expectedError) {

        String actualError = checkoutPage.getCheckoutErrorMessage();

        Assert.assertEquals(
                actualError,
                expectedError,
                "Checkout validation message is incorrect"
        );
    }
}
