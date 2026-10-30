@Login
Feature: Sauce Demo Login

  Scenario: Login with valid credentials
    Given user is on the Sauce Demo login page
    When user enters valid username
    And user enters valid password
    And take screenshot
    And user clicks on the login button
    Then user should navigate to the products page
    And take screenshot

  Scenario: Login with locked out user
    Given user is on the Sauce Demo login page
    When user enters locked username
    And user enters valid password
    And user clicks on the login button
    Then locked user error message should be displayed
    And take screenshot

  @Logout
  Scenario: Verify user cannot access products page after logout
    Given user is logged into the application
    When user logs out
    And user navigates directly to the products page
    And take screenshot
    Then user should be redirected to the login page
