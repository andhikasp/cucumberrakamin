Feature: add to cart
  Scenario: user can select and view product on shopping cart
    Given user is logged into the SauceDemo
    When the user click some product
    And user click cart
    Then the user will see information about product selected
