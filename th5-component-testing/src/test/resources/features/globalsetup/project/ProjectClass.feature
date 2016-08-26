@integration @Steve
Feature: Create Project Class

  Background: 
    Given user login the taskhub system

  Scenario Outline: Create Project Class
    And user navigates to "Global Setup>Financial>Accounting>Chart Of Acc" screen
    And user create chart of account as "<KEY>"
      | KEY | GL Account Code | Description        | Account Type       | Status | For Sub Ledger Account |
      | 1   | PJCLAUTOGLAN    | Project Class Test | Balance Sheet Item | Active | No                     |
    And user navigates to "Global Setup>Project>Project Class" screen
    When user creates a project class as "<KEY>"
      | KEY | Project Class Code | Project Class Description | Unearned Revenue | Work In Progress | Retention    | Project Revenue | Project Cost | Recognition Exch Gain/Loss (TH2) | Cost Accrual | Revenue Accrual | Downpayment Unearned | Attributable Profit | Claim Debtor | Certification Debtor | Other Payable | Retention Clearing | Subcon Claim Payable | Subcon Certification Payable | Material on Site | Retention Material on Site | Liquidated Damage | Subcon Advance Payment |
      | 1   | STPJCLAUTO         | Project Class For Test    | PJCLAUTOGLAN     | PJCLAUTOGLAN     | PJCLAUTOGLAN | PJCLAUTOGLAN    | PJCLAUTOGLAN | PJCLAUTOGLAN                     | PJCLAUTOGLAN | PJCLAUTOGLAN    | PJCLAUTOGLAN         | PJCLAUTOGLAN        | PJCLAUTOGLAN | PJCLAUTOGLAN         | PJCLAUTOGLAN  | PJCLAUTOGLAN       | PJCLAUTOGLAN         | PJCLAUTOGLAN                 | PJCLAUTOGLAN     | PJCLAUTOGLAN               | PJCLAUTOGLAN      | PJCLAUTOGLAN           |
    When user search for the project class with "<KEY>"
      | KEY | Project Class Code |
      | 1   | STPJCLAUTO         |
    Then user should see the project class with "<KEY>" having correct information
    When user deletes the project class with "<KEY>"
      | KEY | Project Class Code |
      | 1   | STPJCLAUTO         |
    Then user should not see the project class with "<KEY>"

    Examples: 
      | KEY |
      | 1   |
