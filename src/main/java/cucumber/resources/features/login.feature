Feature: Login Page
  Scenario: user can login using valid credential
    Given halaman login saucedemo
    When user input username
    And user input password
    And user tap login button
    Then user direct to dashboard page

  Scenario: user cant login using invalid credential
    Given halaman login saucedemo
    When user input username
    And user invaliid input password
    And user tap login button
    Then user get error message

