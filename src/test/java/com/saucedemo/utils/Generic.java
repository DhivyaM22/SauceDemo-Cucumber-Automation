
package com.saucedemo.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Generic {

    // Explicit wait
    public static void waitForElementVisible(
            WebDriver driver, By locator, int seconds) {

        org.openqa.selenium.support.ui.WebDriverWait wait =
                new org.openqa.selenium.support.ui.WebDriverWait(
                        driver,
                        java.time.Duration.ofSeconds(seconds));

        wait.until(
                org.openqa.selenium.support.ui.ExpectedConditions
                        .visibilityOfElementLocated(locator));
    }

    // Common screenshot method
    public static void takeScreenshot(WebDriver driver, String screenshotName) {

        System.err.println("STEP 4: Inside Generic screenshot method");

        try {

            if (driver == null) {
                throw new IllegalStateException("WebDriver is null!");
            }

            System.err.println("STEP 5: Driver is not null");

            byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);

            System.err.println("STEP 6: Screenshot captured");

            Path screenshotFolder = Paths.get(
                    System.getProperty("user.dir"), "screenshots");

            Files.createDirectories(screenshotFolder);

            Path screenshotPath = screenshotFolder.resolve(
                    screenshotName + ".png");

            Files.write(screenshotPath, screenshot);

            System.err.println("STEP 7: Screenshot saved");
            System.err.println("Location: " + screenshotPath.toAbsolutePath());

        } catch (Exception e) {

            e.printStackTrace();
            throw new RuntimeException("Unable to capture screenshot", e);
        }
    }
}
