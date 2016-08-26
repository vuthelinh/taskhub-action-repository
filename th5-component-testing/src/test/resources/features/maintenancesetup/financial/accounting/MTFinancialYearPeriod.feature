Feature: MT Financial Year Period

  Scenario Outline: Set Financial Year Period with feature file
    Given user login the taskhub system
    When user navigates to "Maintenance Setup>Financial>Accounting>Financial Year/Period>[2]" screen
    And user set financial year period as "<KEY>"
      | KEY | Financial Year | Description  | Begin Date | End Date   | No Of Period |
      | 001 | 2014           | auto testing | 01/05/2014 | 30/04/2015 | 12           |
      | 001 | 2015           | auto testing | 01/05/2015 | 30/04/2016 | 12           |
      | 001 | 2016           | auto testing | 01/05/2016 | 30/04/2017 | 12           |

    Examples: 
      | KEY |
      | 001 |

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

  Scenario: MT Financial Year Period with excel file
    Given user login the taskhub system
    When user navigates to "Maintenance Setup>Financial>Accounting>Financial Year/Period>[2]" screen
    And user create new financial year/period
