Feature: Logout Page
  Scenario: user can logout
    Given the user is logged into the SauceDemo website
    When the user clicks on the user menu
    And the user selects "Logout"
    Then the user should be logged out and redirected to the login page


