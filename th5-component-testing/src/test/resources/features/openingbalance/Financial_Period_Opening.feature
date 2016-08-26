Feature: Financial Period Opening

  Scenario: Set Financial Period Opening with feature file
    Given user login the taskhub system
    When user navigates to "Opening Balance>Financial Period Opening" screen
    And user set financial period opening with feature file
      | Module Code | Financial Year | Period |
      | AP          | 2016           | 6      |
      | AR          | 2016           | 6      |
      | GL          | 2016           | 6      |
      | BK          | 2016           | 6      |
      | FA          | 2016           | 6      |

  Scenario: Set Financial Period Opening with excel file
    Given user login the taskhub system
    When user navigates to "Opening Balance>Financial Period Opening" screen
    And user set financial period opening
