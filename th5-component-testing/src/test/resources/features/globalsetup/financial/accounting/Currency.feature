@integration @Steve
Feature: Create currency
  In order to specify currency used in transactions
  As an employee
  I want to create a currency

  Background:
	  Given user login the taskhub system
    When user navigates to "Global Setup>Financial>Accounting>Currency" screen

  Scenario Outline: Create and delete a currency
    When I create a currency as the following with "<KEY>":
      | KEY | Currency | Description    | Currency Symbol | Dollar in word | Cent in word | Company |
      |  01 | RUB      | Steve Currency | Rub             | In word        |         2000 | All     |
    And with exchange rate details with "<KEY>"
      | KEY | Minimum Bank Rate | Maximum Bank Rate | Maximum Spread% | Spread % Base | Credit Limit Exchange Rate |
      |  01 |      1.0000000000 |      2.1300000000 |            5.12 | Sell Rate     |               1.5000000000 |
    #When I search for the currency with "<KEY>"
    Then I should see the currency with "<KEY>"
    When I delete the currency  with "<KEY>"
    And I search for the currency with "<KEY>"
    Then I should not see the currency with "<KEY>"

    Examples: 
      | KEY |
      |  01 |