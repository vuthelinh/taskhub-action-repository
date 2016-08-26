Feature: Global Chart Of Acc

  Scenario: Create master data for global chart of account
    Given user login the taskhub system
    When user navigates to "Global Setup>Financial>Accounting>Global Chart Of Acc" screen
    And user create new global chart Of account
    #Nancy
    # And user create new GLAN
    When user logout

  Scenario: Add new, search and delete global chart of account
    Given user login the taskhub system
    When user navigates to "Global Setup>Financial>Accounting>Global Chart Of Acc" screen
    And user create new global chart Of account with code is "JACOB-01"
    Then global chart account is created
    When user search and delete it
    Then user can not search it again
    When user logout

  Scenario: Verify data is updated in DB
    Given dataset of global chart account should be updated to DB

  # Nancy
  Scenario: Create chart of account with excel file
    Given user login the taskhub system
    And user navigates to "Global Setup>Financial>Accounting>Global Chart Of Acc" screen
    When user create new GLAN

  Scenario: Create Chart Of Account with feature file
    Given user login the taskhub system
    And user navigates to "Global Setup>Financial>Accounting>Chart Of Acc" screen
    When user create chart of account with company ""
      | GL Account Code | Description                            | Account Type       | Status | For Sub Ledger Account | Company |
      | 10000           | Plant & Machinery                      | Balance Sheet Item | Active | No                     | all     |
      | 10010           | Motor Vehicles                         | Balance Sheet Item | Active | No                     | all     |
      | 10020           | Office Equipment                       | Balance Sheet Item | Active | No                     | all     |
      | 10030           | Furniture & Fittings                   | Balance Sheet Item | Active | No                     | all     |
      | 10040           | IT Hardware & Software                 | Balance Sheet Item | Active | No                     | all     |
      | 10050           | Renovation                             | Balance Sheet Item | Active | No                     | all     |
      | 11000           | Cumulative Depn-Plant & Mchinery       | Balance Sheet Item | Active | No                     | all     |
      | 11010           | Cumulative Depn-Motor Vehicles         | Balance Sheet Item | Active | No                     | all     |
      | 11020           | Cumulative Depn-Office Equipment       | Balance Sheet Item | Active | No                     | all     |
      | 11040           | Cumulative Depn-IT Hardware & Software | Balance Sheet Item | Active | No                     | all     |
      | 12000           | FA Disposal Clearing                   | Balance Sheet Item | Active | No                     | all     |
      | 20010           | Goods Receipt Clearing                 | Balance Sheet Item | Active | No                     | all     |
      | 20020           | Inventory Stock                        | Balance Sheet Item | Active | Yes                    | all     |
      | 20030           | Delivery Clearing                      | Balance Sheet Item | Active | No                     | all     |
      | 20040           | Inventory Work In Progress             | Balance Sheet Item | Active | No                     | all     |
      | 21010           | Downpayment (Unearned)                 | Balance Sheet Item | Active | No                     | all     |
      | 21020           | Unearned Revenue                       | Balance Sheet Item | Active | No                     | all     |
      | 21030           | Retention (Customer)                   | Balance Sheet Item | Active | Yes                    | all     |
      | 21080           | Work In Progress                       | Balance Sheet Item | Active | Yes                    | all     |
      | 22010           | Receivable - Related Parties           | Balance Sheet Item | Active | Yes                    | all     |
      | 22020           | Receivable - Trade                     | Balance Sheet Item | Active | Yes                    | all     |
      | 22030           | Receivable - InterCo                   | Balance Sheet Item | Active | Yes                    | all     |
      | 22040           | Contra                                 | Balance Sheet Item | Active | No                     | all     |
      | 23010           | Loan-staff & Workers                   | Balance Sheet Item | Active | No                     | all     |
      | 24020           | Tender Deposit                         | Balance Sheet Item | Active | No                     | all     |
      | 24030           | Deposit - Sundry                       | Balance Sheet Item | Active | No                     | all     |
      | 24040           | Staff Advancement                      | Balance Sheet Item | Active | No                     | all     |
      | 27010           | Fixed Deposit                          | Balance Sheet Item | Active | No                     | all     |
      | 28010           | OCBC Bank - USD - Acc1                 | Balance Sheet Item | Active | No                     | all     |
      | 28011           | OCBC Bank - SGD - Acc2                 | Balance Sheet Item | Active | No                     | all     |
      | 28020           | DBS Bank - USD - Acc1                  | Balance Sheet Item | Active | No                     | all     |
      | 28021           | DBS Bank - SGD - Acc2                  | Balance Sheet Item | Active | No                     | all     |
      | 28022           | DBS Bank - EUR - Acc3                  | Balance Sheet Item | Active | No                     | all     |
      | 28090           | Cash on Hand                           | Balance Sheet Item | Active | No                     | all     |
      | 40000           | Share Capital                          | Balance Sheet Item | Active | No                     | all     |
      | 40010           | Retained Earning b/f                   | Balance Sheet Item | Active | No                     | all     |
      | 40020           | Deferred Tax                           | Balance Sheet Item | Active | No                     | all     |
      | 41010           | Payable - Related Parties              | Balance Sheet Item | Active | Yes                    | all     |
      | 41020           | Payable - Trade                        | Balance Sheet Item | Active | Yes                    | all     |
      | 41030           | Payable - Sundry                       | Balance Sheet Item | Active | Yes                    | all     |
      | 41040           | Payable - CPF                          | Balance Sheet Item | Active | No                     | all     |
      | 41050           | Retention (Supplier)                   | Balance Sheet Item | Active | No                     | all     |
      | 43010           | Accrual                                | Balance Sheet Item | Active | No                     | all     |
      | 43020           | Accrual (Project Costs)                | Balance Sheet Item | Active | No                     | all     |
      | 43100           | GST Payment/Refund                     | Balance Sheet Item | Active | No                     | all     |
      | 43110           | Input Tax                              | Balance Sheet Item | Active | No                     | all     |
      | 43120           | Output Tax                             | Balance Sheet Item | Active | No                     | all     |
      | 44000           | Additional Costs (clearing)            | Balance Sheet Item | Active | No                     | all     |
      | 45010           | HP Creditor                            | Balance Sheet Item | Active | No                     | all     |
      | 45020           | HP Interest Suspenses                  | Balance Sheet Item | Active | No                     | all     |
      | 46000           | Tax on Hold - Workers                  | Balance Sheet Item | Active | No                     | all     |
      | 46010           | Salary & OT on Hold - Workers          | Balance Sheet Item | Active | No                     | all     |
      | 51010           | Products Sales                         | Profit & Loss Item | Active | No                     | all     |
      | 51020           | Project Sales                          | Profit & Loss Item | Active | No                     | all     |
      | 51030           | Maintenance Sales                      | Profit & Loss Item | Active | No                     | all     |
      | 51040           | Services Sales                         | Profit & Loss Item | Active | No                     | all     |
      | 52000           | Other Income                           | Profit & Loss Item | Active | No                     | all     |
      | 60000           | Cost of Sales (Products)               | Profit & Loss Item | Active | No                     | all     |
      | 60010           | Costs of Sales (Projects)              | Profit & Loss Item | Active | No                     | all     |
      | 60020           | Costs of Sales (Maintenance)           | Profit & Loss Item | Active | No                     | all     |
      | 60030           | Costs of Sales (Services)              | Profit & Loss Item | Active | No                     | all     |
      | 61000           | Purchase Variance                      | Profit & Loss Item | Active | No                     | all     |
      | 61010           | Purchase Return Variance               | Profit & Loss Item | Active | No                     | all     |
      | 62000           | Freight & Handling Costs               | Profit & Loss Item | Active | No                     | all     |
      | 62010           | Additional Costs Variance              | Profit & Loss Item | Active | No                     | all     |
      | 65000           | Inventory Written Off (Damage \\ Loss) | Profit & Loss Item | Active | No                     | all     |
      | 70000           | Upkeep of Equipments                   | Profit & Loss Item | Active | No                     | all     |
      | 70010           | Workers Wages & OT (TimeSheet)         | Profit & Loss Item | Active | No                     | all     |
      | 80000           | Directors Salary & Bonus               | Profit & Loss Item | Active | No                     | all     |
      | 80010           | Directors CPF & SDL                    | Profit & Loss Item | Active | No                     | all     |
      | 81000           | Staff Salaries & OT, Deduction, etc    | Profit & Loss Item | Active | No                     | all     |
      | 81010           | Staff CPF (Employer)                   | Profit & Loss Item | Active | No                     | all     |
      | 81020           | Staff Bonus                            | Profit & Loss Item | Active | No                     | all     |
      | 81030           | Staff FWL, SDL, etc                    | Profit & Loss Item | Active | No                     | all     |
      | 81040           | Staff Welfare                          | Profit & Loss Item | Active | No                     | all     |
      | 82000           | Medical Fee                            | Profit & Loss Item | Active | No                     | all     |
      | 82010           | Recruitment Fee                        | Profit & Loss Item | Active | No                     | all     |
      | 82030           | Training Fee                           | Profit & Loss Item | Active | No                     | all     |
      | 82040           | Transport (Taxi & Milage claim)        | Profit & Loss Item | Active | No                     | all     |
      | 83000           | Advertisement                          | Profit & Loss Item | Active | No                     | all     |
      | 83010           | Exhibition                             | Profit & Loss Item | Active | No                     | all     |
      | 83020           | Marketing & Promotions                 | Profit & Loss Item | Active | No                     | all     |
      | 83040           | Commission                             | Profit & Loss Item | Active | No                     | all     |
      | 84000           | Audit Fee                              | Profit & Loss Item | Active | No                     | all     |
      | 84010           | Accounting/Tax Fee                     | Profit & Loss Item | Active | No                     | all     |
      | 84020           | Secretarial Fee                        | Profit & Loss Item | Active | No                     | all     |
      | 84030           | Legal Fee                              | Profit & Loss Item | Active | No                     | all     |
      | 84040           | Management Fee                         | Profit & Loss Item | Active | No                     | all     |
      | 84050           | Consultancy Fee                        | Profit & Loss Item | Active | No                     | all     |
      | 84060           | Directors Fee                          | Profit & Loss Item | Active | No                     | all     |
      | 85000           | Rental-Office                          | Profit & Loss Item | Active | No                     | all     |
      | 85010           | Office Maintenance                     | Profit & Loss Item | Active | No                     | all     |
      | 85020           | Water & Eletricity                     | Profit & Loss Item | Active | No                     | all     |
      | 86000           | Bad Debts                              | Profit & Loss Item | Active | No                     | all     |
      | 86010           | Courier Services                       | Profit & Loss Item | Active | No                     | all     |
      | 86020           | Donations                              | Profit & Loss Item | Active | No                     | all     |
      | 86030           | Entertainment                          | Profit & Loss Item | Active | No                     | all     |
      | 86040           | FA Disposal Gain \\ Loss               | Profit & Loss Item | Active | No                     | all     |
      | 86050           | Gain \\ Loss - Realised                | Profit & Loss Item | Active | No                     | all     |
      | 86060           | Gain \\ Loss - Unrealised              | Profit & Loss Item | Active | No                     | all     |
      | 86070           | Insurance-Fire & Public Liabilities    | Profit & Loss Item | Active | No                     | all     |
      | 86080           | Postage                                | Profit & Loss Item | Active | No                     | all     |
      | 86090           | Printing & Stationery                  | Profit & Loss Item | Active | No                     | all     |
      | 86100           | Publication & Periodicals              | Profit & Loss Item | Active | No                     | all     |
      | 86110           | Subscription Fee                       | Profit & Loss Item | Active | No                     | all     |
      | 86120           | Telephone Charges                      | Profit & Loss Item | Active | No                     | all     |
      | 86130           | Travelling Expenses                    | Profit & Loss Item | Active | No                     | all     |
      | 86140           | Upkeep of Fixed Assets                 | Profit & Loss Item | Active | No                     | all     |
      | 87000           | Bank Charges/Commission                | Profit & Loss Item | Active | No                     | all     |
      | 87010           | Bank Overdraft Interest                | Profit & Loss Item | Active | No                     | all     |
      | 87020           | Term Loan Interest                     | Profit & Loss Item | Active | No                     | all     |
      | 87030           | Hire Purchase Interest                 | Profit & Loss Item | Active | No                     | all     |
      | 87040           | Deprn - Plant & Machinery              | Profit & Loss Item | Active | No                     | all     |
      | 87050           | Deprn - Motor Vehicles                 | Profit & Loss Item | Active | No                     | all     |
      | 87060           | Deprn - Office Equipment               | Profit & Loss Item | Active | No                     | all     |
      | 87070           | Deprn - Furniture & Fittings           | Profit & Loss Item | Active | No                     | all     |
      | 87080           | Deprn - IT Hardware & Software         | Profit & Loss Item | Active | No                     | all     |
      | 87090           | Deprn - Renovation                     | Profit & Loss Item | Active | No                     | all     |
      | Z-100           | Fixed Asset Clearing                   | Balance Sheet Item | Active | No                     | all     |
      | Z-200           | Inventory Clearing                     | Balance Sheet Item | Active | No                     | all     |
      | Z-300           | Receivable Clearing                    | Balance Sheet Item | Active | No                     | all     |
      | Z-400           | Payable Clearing                       | Balance Sheet Item | Active | No                     | all     |
      | Z-500           | Bank Clearing                          | Balance Sheet Item | Active | No                     | all     |

  Scenario: Del Chart Of Account
    Given user login the taskhub system
    And user navigates to "Global Setup>Financial>Accounting>Chart Of Acc" screen
    And user delete chart of account
      | GL Account Code | Description       | Account Type       | Status | For Sub Ledger Account | Company |
      | 10000           | Plant & Machinery | Balance Sheet Item | Active | No                     | all     |
      | 10010           | Motor Vehicles    | Balance Sheet Item | Active | No                     | all     |

  Scenario: Create Chart Of Account Daily
    Given user login the taskhub system
    And user navigates to "Global Setup>Financial>Accounting>Chart Of Acc" screen
    And user create chart of account daily with company ""
      | GL Account Code | Description       | Account Type       | Status | For Sub Ledger Account | Company |
      | 10000           | Plant & Machinery | Balance Sheet Item | Active | No                     | all     |
      | 10010           | Motor Vehicles    | Balance Sheet Item | Active | No                     | all     |

  Scenario: Del Chart Of Account Daily
    Given user login the taskhub system
    And user navigates to "Global Setup>Financial>Accounting>Chart Of Acc" screen
    And user delete chart of account daily
      | GL Account Code | Description       | Account Type       | Status | For Sub Ledger Account | Company |
      | 10000           | Plant & Machinery | Balance Sheet Item | Active | No                     | all     |
      | 10010           | Motor Vehicles    | Balance Sheet Item | Active | No                     | all     |
