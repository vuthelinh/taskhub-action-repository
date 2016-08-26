Feature: Create Currency

  Scenario Outline: Create new Currency with feature file
    Given user login the taskhub system
    When user navigates to "Global Setup>Financial>Accounting>Currency" screen
    When user create currency as "<KEY CURRENCY>"
      | KEY CURRENCY | Currency | Description      | Currency Symbol | Dollar in word | Cent in word | Minimum Bank Rate | Maximum Bank Rate | Maximum Spread% | Spread % Base | Credit Limit Exchange Rate | Company |
      | 001          | SGD      | Singapore Dollar |                 |                |              | 1                 | 1                 |                 |               |                            |         |
      | 001          | USD      | US Dollar        |                 |                |              | 1                 | 2                 |                 |               |                            |         |
      | 001          | AUD      | Australia Dollar |                 |                |              | 1                 | 3                 |                 |               |                            |         |

    Examples: 
      | KEY CURRENCY |
      | 001          |

  Scenario: Delete Currency with feature file
    Given user login the taskhub system
    When user navigates to "Global Setup>Financial>Accounting>Currency" screen
    When user delete currency
      | KEY CURRENCY | Currency |
      | 001          | SGD      |
      | 001          | USD      |
      | 001          | AUD      |

  Scenario: Set Home Currency
    Given user login the taskhub system
    And user navigates to "Global Setup>Administration>Company>Company" screen
    When user update for company "AUTO1"
    And user navigates to "Maintenance Setup>Administration>Company>Company Configuration>[2]" screen
    When user set home and operation for currency
      | Home Currency | Operation Currency |
      | sgd           | sgd                |

  Scenario: Create new Currency with excel file
    Given user login the taskhub system
    When user navigates to "Global Setup>Financial>Accounting>Global Currency" screen
    Then page header shouble be "Global Currency"
    When user create Global Currency
    And user logout
