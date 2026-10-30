@Products
Feature: Products page functionality

  Background:
    Given user is logged into the application

  Scenario: Verify products are displayed
    Then user should see the products page
    And user should see the product list
    And take screenshot

  Scenario: Sort products by name A to Z
    When user sorts products by "Name (A to Z)"
    Then products should be displayed in alphabetical order
    And take screenshot

  Scenario: Sort products by name Z to A
    When user sorts products by "Name (Z to A)"
    Then products should be displayed in reverse alphabetical order
    And take screenshot

  Scenario: Sort products by price low to high
    When user sorts products by "Price (low to high)"
    Then products should be displayed in ascending price order
    And take screenshot

  Scenario: Sort products by price high to low
    When user sorts products by "Price (high to low)"
    Then products should be displayed in descending price order
    And take screenshot
