
package com.saucedemo.stepdefinitions;

import com.saucedemo.factory.DriverFactory;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.MediaEntityBuilder;

import io.cucumber.java.en.And;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GenericSteps {

    @And("take screenshot")
    public void takeScreenshot() {

        WebDriver driver = DriverFactory.getDriver();

        byte[] screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);

        String base64Screenshot =
                ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.BASE64);

        ExtentCucumberAdapter.getCurrentStep().info(
                "Screenshot",
                MediaEntityBuilder.createScreenCaptureFromBase64String(
                        base64Screenshot
                ).build()
        );

        System.out.println("Screenshot attached to Extent Report!");
    }
}
