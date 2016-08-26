Feature: Period End Closing

  Scenario: Period End Closing with feature file
    Given user login the TH6 system
    When user navigates to "Master Setup>Accounting>Period End Closing" screen
    And user submit period end closing
      | Module Code |
      | AP          |
      | AR          |

  Scenario: Period End Closing
    Given user login the TH6 system
    When user navigates to "Master Setup>Accounting>Period End Closing" screen
    And user close period
    And user logout
