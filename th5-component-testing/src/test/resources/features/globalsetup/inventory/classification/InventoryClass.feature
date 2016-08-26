@integration @jacob
Feature: Inventory class

  Scenario Outline: Create Inventory Class
    Given user login the taskhub system
    And user navigates to "Global Setup>Financial>Accounting>Chart Of Acc" screen
    When user create chart of account with company ""
      | GL Account Code | Description            | Account Type       | Status | For Sub Ledger Account |
      | 9FHA1           | Plant & Machinery      | Balance Sheet Item | Active | No                     |
      | 9FHA2           | Motor Vehicles         | Balance Sheet Item | Active | No                     |
      | 9FHA3           | Office Equipment       | Balance Sheet Item | Active | No                     |
      | 9FHA4           | IT Hardware & Software | Balance Sheet Item | Active | No                     |
      | 9FHA5           | Inventory Stock        | Balance Sheet Item | Active | Yes                    |
    And user navigates to "Global Setup>Inventory>Classification>Class" screen
    #add
    When user create a new inventory class as "<KEY>"
      | KEY | Inventory Class Code | Description         | Costing Method   | Inventory GLAN | Sales GLAN | Costs of Sales GLAN | Sales Return GLAN | Costs of Sales Return GLAN | Costs of Sales Ret Clearing GLAN | Replacement Holding GLAN | Issue Variance GLAN | Production Variance GLAN | Inventory Expense GLAN | Physical Addition GLAN | Physical Reduction GLAN | Delivery Clearing GLAN | Work in Progress GLAN | Calibration GLAN | Scrap Expense GLAN | Rework Expense GLAN | Cost of Servicing GLAN |
      | 001 | 9FHA1                | Inventory class 001 | Weighted Average | 9FHA1          | 9FHA2      | 9FHA3               | 9FHA4             | 9FHA5                      | 9FHA2                            | 9FHA3                    | 9FHA2               | 9FHA4                    | 9FHA5                  | 9FHA4                  | 9FHA2                   | 9FHA1                  | 9FHA1                 | 9FHA5            | 9FHA4              | 9FHA3               | 9FHA2                  |
    #delete
    And user delete class as "<KEY>"
      | KEY | Inventory Class Code |
      | 001 | 9FHA1                |
  
    Examples: 
      | KEY |
      | 001 |
