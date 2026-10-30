
Feature: Checkout functionality

  Background:
    Given user is logged into the application
    When user adds two products to cart
    And user opens the cart

  Scenario Outline: Complete checkout with valid details
    When user proceeds to checkout
    And user enters first name "<FirstName>"
    And user enters last name "<Lastname>"
    And user enters postal code "<PostalCode>"
    And user continues checkout
    And take screenshot
    Then checkout overview should be displayed
    And order total should be calculated correctly
    When user finishes the order
    Then order confirmation should be displayed
    And take screenshot
    And cart should be empty

    Examples:
      | FirstName | Lastname | PostalCode |
      | John      | Smith    | 600001     |

  @Checkout
  Scenario Outline: Validate checkout with missing mandatory fields
    When user proceeds to checkout
    And user enters first name "<FirstName>"
    And user enters last name "<LastName>"
    And user enters postal code "<PostalCode>"
    And user continues checkout
    Then checkout error message should be "<ExpectedError>"

    Examples:
      | FirstName | LastName | PostalCode | ExpectedError                  |
      |           | Smith    | 600001     | Error: First Name is required  |
      | John      |          | 600001     | Error: Last Name is required   |
      | John      | Smith    |            | Error: Postal Code is required |

  Scenario: Validate checkout with missing mandatory fields
    When user proceeds to checkout
    And user continues checkout without entering details
    Then checkout error message should be displayed
    And take screenshot

  Scenario: Cancel checkout
    When user proceeds to checkout
    And user cancels checkout
    Then user should return to the cart page
    And take screenshot
