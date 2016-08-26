@integration @Steve
Feature: Create a SBU

  Background: 
    Given user login the taskhub system

  Scenario Outline: Create a SBU 
    And user navigates to "Global Setup>Financial>Accounting>Chart Of Acc" screen
    And user create chart of account as "<KEY>"
      | KEY | GL Account Code | Description | Account Type       | Status | For Sub Ledger Account |
      | 1   | STEVEGLAN1      | SBU Test    | Balance Sheet Item | Active | No                     |
    And user navigates to "Global Setup>Inventory>Classification>Class" screen
    When user create a new inventory class as "<KEY>"
      | KEY | Inventory Class Code | Description           | Costing Method | Inventory GLAN |
      | 1   | STEVEINV             | Steve Inventory Class | FIFO           | STEVEGLAN1     |
    And user navigates to "Global Setup>Administration>Company>Strategic Business Unit" screen
    And user create SBU as "<KEY>"
      | KEY | SBU Code | Description | Detailed Description | CTI Code | Global Status  |
      | 1   | SBUAUTO1 | Steve SBU   | Detailed Description | Code1     | Active        |
    #In Purchase In Charge Tab
    And user enters purchaser in charge as "<KEY>"
      | KEY | Purchaser in Charge |
      | 1   | STEVE1              |
    #In Accessible Inventory Tab
    And user enters inventory class as "<KEY>"
      | KEY | Inventory Class | Description           |
      | 1   | STEVEINV        | Steve Inventory Class |
    When user search for the SBU as "<KEY>"
      | KEY | SBU Code |
      | 1   | SBUAUTO1 |
    Then user should see the SBU as "<KEY>"
    When user deletes the SBU as "<KEY>"
      | KEY | SBU Code |
      | 1   | SBUAUTO1 |
    Then user should not see the SBU with "<KEY>"
      | KEY | SBU Code |
      | 1   | SBUAUTO1 |

    Examples: 
      | KEY |
      | 1   |
