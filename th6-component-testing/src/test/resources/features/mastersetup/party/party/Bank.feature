Feature: Create Bank

  Scenario Outline: Create Bank Daily
    Given user login the TH6 system
    And user navigates to "Master Setup>Party>Party" screen
    When user create bank as "<KEY BANK>"
      | KEY BANK | Prefix | Party Code | Party Name                | Party Short Name | Party Group Code | Country Of Incorporation | Main Home Page | Tax Agent | GST Registration No | Unique Entity No | Party Contra GLAN | Contra Realized Exch GLAN | Company      |
      | 001      |        | BANK01     | for Synergix Testing ONLY |                  |                  |                          |                |           |                     |                  | 22040             | 22040                     | AUTO4, AUTO1 |
      | 002      |        | BANK02     | for Synergix Testing ONLY |                  |                  |                          |                |           |                     |                  | 22040             | 22040                     | AUTO4, AUTO1 |
    And bank is added relation service group as "<KEY BANK>"
      | KEY BANK | Party Relation        | Service Type             | Allowed |
      | 001      | Financial Institution | Banking Services         | Y       |
      | 001      | Financial Institution | Leasing Services         | Y       |
      | 001      | Financial Institution | Trade Financing Services | Y       |
      | 002      | Financial Institution | Banking Services         | Y       |
      | 002      | Financial Institution | Leasing Services         | Y       |
      | 002      | Financial Institution | Trade Financing Services | Y       |
    And bank is updated
    And bank is added local info own bank detail as "<KEY BANK>"
      | KEY BANK | Account No | Branch Code | Currency Code | Bank GLAN | Last Cheque No | Combine BC in Payment | Combine BC in Receipt | Del |
      | 001      | 12345      |             | USD           | 28010     |                |                       |                       | y   |
      | 001      | 12345      |             | USD           | 28010     |                |                       |                       |     |
      | 001      | 54321      |             | SGD           | 28011     |                |                       |                       |     |
      | 002      | 12345      |             | USD           | 28010     |                |                       |                       |     |
      | 002      | 54321      |             | USD           | 28011     |                |                       |                       | y   |
      | 002      | 54321      |             | SGD           | 28011     |                |                       |                       |     |
    And bank is updated

    Examples: 
      | KEY BANK |
      | 001      |
      | 002      |

  Scenario Outline: Update Bank with feature file
    Given user login the TH6 system
    And user navigates to "Master Setup>Party>Party" screen
    When user update bank as "<KEY BANK>"
      | KEY BANK | Prefix | Party Code | Party Name | Party Short Name | Party Group Code | Country Of Incorporation | Main Home Page | Tax Agent | GST Registration No | Unique Entity No | Party Contra GLAN | Contra Realized Exch GLAN | Company |
      | 001      |        | bank01     |            |                  |                  |                          |                |           |                     |                  | 22040             | 22040                     |         |
      | 002      |        | bank02     |            |                  |                  |                          |                |           |                     |                  | 22040             | 22040                     |         |
    And bank is added local info own bank detail as "<KEY BANK>"
      | KEY BANK | Account No | Branch Code | Currency Code | Bank GLAN | Last Cheque No | Combine BC in Payment | Combine BC in Receipt | Del |
      | 001      | 12345      |             | USD           | 28010     |                |                       |                       |     |
      | 001      | 54321      |             | SGD           | 28011     |                |                       |                       |     |
      | 002      | 12345      |             | USD           | 28010     |                |                       |                       |     |
      | 002      | 54321      |             | SGD           | 28011     |                |                       |                       |     |
    And bank is updated

    Examples: 
      | KEY BANK |
      | 001      |
      | 002      |

  Scenario: Create Bank
    Given user login the TH6 system
    When user navigates to "Master Setup>Party>Party" screen
    And user create new Bank
    And user logout
