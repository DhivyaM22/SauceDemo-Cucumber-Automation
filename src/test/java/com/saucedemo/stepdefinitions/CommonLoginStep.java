package com.saucedemo.stepdefinitions;

import com.saucedemo.factory.DriverFactory;
import com.saucedemo.pages.CommonLoginPage;
import com.saucedemo.utils.ConfigReader;

import io.cucumber.java.en.Given;

public class CommonLoginStep {

    @Given("user is logged into the application")
    public void user_is_logged_into_the_application() {

        DriverFactory.getDriver().get(
                ConfigReader.getProperty("app.url")
        );

        CommonLoginPage loginPage =
                new CommonLoginPage(DriverFactory.getDriver());

        loginPage.enterText(
                ConfigReader.getProperty("username"), "username"
        );

        loginPage.enterText(
                ConfigReader.getProperty("password"), "password"
        );

        loginPage.clickLogin();
    }
}