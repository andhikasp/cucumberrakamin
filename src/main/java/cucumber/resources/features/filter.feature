Feature: Filter Dashboard
  Scenario: filter name z to a
    Given the user is logged into the SauceDemo
    When the user click filter
    And the user selects name z to a
    Then the user will see the all product title filtered from z to a

  Scenario: filter low to high
    Given the user is logged into the SauceDemo
    When the user click filter
    And the user selects low to high
    Then the user will see the all product title filtered from low to high


  Scenario: filter high to low
    Given the user is logged into the SauceDemo
    When the user click filter
    And the user selects high to low
    Then the user will see the all product title filtered from high to low
