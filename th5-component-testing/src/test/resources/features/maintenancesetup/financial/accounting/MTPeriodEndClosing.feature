Feature: Period End Closing

  Scenario: Period End Closing with feature file
    Given user login the taskhub system
    When user navigates to "Maintenance Setup>Financial>Accounting>Period End Closing>[2]" screen
    And user submit period end closing
      | Module Code |
      | AP          |
      | AR          |

  Scenario: Period End Closing
    Given user login the taskhub system
    When user navigates to "Maintenance Setup>Financial>Accounting>Period End Closing>[2]" screen
    And user close period
    And user logout
