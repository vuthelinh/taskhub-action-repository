Feature: MT GL Revaluation

  Scenario: Create MT GL Revaluation with feature file
    Given user login the TH6 system
    When user navigates to "Master Setup>Accounting>GL Revaluation" screen
    And user create GL revaluation
      | GL Account Code | Description | Unrealised Gain Loss GLAN |
      | 41010           |             | 86060                     |

  Scenario: Delete MT GL Revaluation with feature file
    Given user login the TH6 system
    When user navigates to "Master Setup>Accounting>GL Revaluation" screen
    And user delete GL revaluation
      | GL Account Code |
      | 11020           |
      | 10040           |
      | 11000           |
      | 10050           |

  Scenario: Set MT GL Revaluation
    Given user login the TH6 system
    When user navigates to "Master Setup>Accounting>GL Revaluation" screen
    And user set GL revaluation
    And user logout
