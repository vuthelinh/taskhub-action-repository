Feature: Exchange Rate

  Scenario Outline: Set Exchange Rate with feature file
    Given user login the TH6 system
    And user navigates to "Master Setup>Currency>Exchange Rate" screen
    When user set exchange rate as "<KEY RATE>"
      | KEY RATE | Currency |
      | 001      | USD      |
      | 002      | SGD      |
      | 003      | AUD      |
    And exchange rate is added date as "<KEY RATE>"
      | KEY RATE | Effective Date From | Effective Date To | Upwards Variance Allowed | Downwards Variance Allowed | Bank Sell Rate | Bank Buy Rate | Revaluation Rate |
      | 001      | 01/01/2014          | 31/12/2014        | 100                      | 100                        | 1.5            | 1.5           |                  |
      | 001      | 01/01/2015          | 31/12/2015        | 100                      | 100                        | 1.5            | 1.5           |                  |
      | 001      | 01/01/2016          | 31/12/2016        | 100                      | 100                        | 1.5            | 1.5           |                  |
      | 002      | 01/01/2014          | 31/12/2014        | 100                      | 100                        | 1              | 1             |                  |
      | 002      | 01/01/2015          | 31/12/2015        | 100                      | 100                        | 1              | 1             |                  |
      | 002      | 01/01/2016          | 31/12/2016        | 100                      | 100                        | 1              | 1             |                  |
      | 003      | 01/01/2014          | 31/12/2014        | 100                      | 100                        | 1.7            | 1.7           |                  |
      | 003      | 01/01/2015          | 31/12/2015        | 100                      | 100                        | 1.7            | 1.7           |                  |
      | 003      | 01/01/2016          | 31/12/2016        | 100                      | 100                        | 1.7            | 1.7           |                  |

    Examples: 
      | KEY RATE |
      | 001      |
      | 002      |
      | 003      |
      | 003      |

  Scenario Outline: Delete Exchange Rate with feature file
    Given user login the TH6 system
    And user navigates to "Master Setup>Currency>Exchange Rate" screen
    When user delete exchange rate as "<KEY RATE>"
      | KEY RATE | Currency |
      | 001      | USD      |
      | 001      | SGD      |
      | 001      | AUD      |

    Examples: 
      | KEY RATE |
      | 001      |

  Scenario: Set Exchange Rate with excel file
    Given user login the TH6 system
    When user navigates to "Master Setup>Currency>Exchange Rate" screen
    And user set exchange rate
    And user logout
