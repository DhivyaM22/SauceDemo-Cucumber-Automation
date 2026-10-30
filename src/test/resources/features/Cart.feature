
@Cart
Feature: Cart functionality

  Background:
    Given user is logged into the application

  Scenario: Add two products to cart
    When user adds two products to cart
    Then cart badge should display "2"
    And take screenshot

  Scenario: Remove one product from cart
    When user adds two products to cart
    And user removes one product from cart
    Then cart badge should display "1"
    And take screenshot

  Scenario: Verify products in cart
    When user adds two products to cart
    And user opens the cart
    And take screenshot
    Then two products should be displayed in the cart
    And take screenshot

  Scenario: Remove all products from cart
    When user adds two products to cart
    And user opens the cart
    And take screenshot
    And user removes all products from cart
    Then cart should be empty
    And take screenshot
