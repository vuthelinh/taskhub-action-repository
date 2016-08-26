Feature: Integration Test For FIN

  ###############################################################################
  ###############################################################################
  # ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ GLOBAL SETUP ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  Scenario: A1. Create Chart Of Account with feature file
    Given user login the TH6 system
    And user navigates to "Master Setup>Accounting>Chart Of Acc" screen
    When user create chart of account with company ""
      | GL Account Code | Description                            | Account Type       | Status | For Sub Ledger Account | Company |
      |           10000 | Plant & Machinery                      | Balance Sheet Item | Active | No                     | all     |
      |           10010 | Motor Vehicles                         | Balance Sheet Item | Active | No                     | all     |
      |           10020 | Office Equipment                       | Balance Sheet Item | Active | No                     | all     |
      |           10030 | Furniture & Fittings                   | Balance Sheet Item | Active | No                     | all     |
      |           10040 | IT Hardware & Software                 | Balance Sheet Item | Active | No                     | all     |
      |           10050 | Renovation                             | Balance Sheet Item | Active | No                     | all     |
      |           11000 | Cumulative Depn-Plant & Mchinery       | Balance Sheet Item | Active | No                     | all     |
      |           11010 | Cumulative Depn-Motor Vehicles         | Balance Sheet Item | Active | No                     | all     |
      |           11020 | Cumulative Depn-Office Equipment       | Balance Sheet Item | Active | No                     | all     |
      |           11040 | Cumulative Depn-IT Hardware & Software | Balance Sheet Item | Active | No                     | all     |
      |           12000 | FA Disposal Clearing                   | Balance Sheet Item | Active | No                     | all     |
      |           20010 | Goods Receipt Clearing                 | Balance Sheet Item | Active | No                     | all     |
      |           20020 | Inventory Stock                        | Balance Sheet Item | Active | Yes                    | all     |
      |           20030 | Delivery Clearing                      | Balance Sheet Item | Active | No                     | all     |
      |           20040 | Inventory Work In Progress             | Balance Sheet Item | Active | No                     | all     |
      |           21010 | Downpayment (Unearned)                 | Balance Sheet Item | Active | No                     | all     |
      |           21020 | Unearned Revenue                       | Balance Sheet Item | Active | No                     | all     |
      |           21030 | Retention (Customer)                   | Balance Sheet Item | Active | Yes                    | all     |
      |           21080 | Work In Progress                       | Balance Sheet Item | Active | Yes                    | all     |
      |           22010 | Receivable - Related Parties           | Balance Sheet Item | Active | Yes                    | all     |
      |           22020 | Receivable - Trade                     | Balance Sheet Item | Active | Yes                    | all     |
      |           22030 | Receivable - InterCo                   | Balance Sheet Item | Active | Yes                    | all     |
      |           22040 | Party Contra                           | Balance Sheet Item | Active | No                     | all     |
      |           23010 | Loan-staff & Workers                   | Balance Sheet Item | Active | No                     | all     |
      |           24020 | Tender Deposit                         | Balance Sheet Item | Active | No                     | all     |
      |           24030 | Deposit - Sundry                       | Balance Sheet Item | Active | No                     | all     |
      |           24040 | Staff Advancement                      | Balance Sheet Item | Active | No                     | all     |
      |           27010 | Fixed Deposit                          | Balance Sheet Item | Active | No                     | all     |
      |           28010 | OCBC Bank - USD - Acc1                 | Balance Sheet Item | Active | No                     | all     |
      |           28011 | OCBC Bank - SGD - Acc2                 | Balance Sheet Item | Active | No                     | all     |
      |           28020 | DBS Bank - USD - Acc1                  | Balance Sheet Item | Active | No                     | all     |
      |           28021 | DBS Bank - SGD - Acc2                  | Balance Sheet Item | Active | No                     | all     |
      |           28022 | DBS Bank – AUD - Acc3                  | Balance Sheet Item | Active | No                     | all     |
      |           28090 | Cash on Hand                           | Balance Sheet Item | Active | No                     | all     |
      |           40000 | Share Capital                          | Balance Sheet Item | Active | No                     | all     |
      |           40010 | Retained Earning b/f                   | Balance Sheet Item | Active | No                     | all     |
      |           40020 | Deferred Tax                           | Balance Sheet Item | Active | No                     | all     |
      |           41010 | Payable - Related Parties              | Balance Sheet Item | Active | Yes                    | all     |
      |           41020 | Payable - Trade                        | Balance Sheet Item | Active | Yes                    | all     |
      |           41030 | Payable – InterCo                      | Balance Sheet Item | Active | Yes                    | all     |
      |           41040 | Payable - CPF                          | Balance Sheet Item | Active | No                     | all     |
      |           41050 | Retention (Supplier)                   | Balance Sheet Item | Active | No                     | all     |
      |           43000 | Contra Realized Exch GLAN              | Profit & Loss Item | Active | No                     | all     |
      |           43010 | Accrual                                | Balance Sheet Item | Active | No                     | all     |
      |           43020 | Accrual (Project Costs)                | Balance Sheet Item | Active | No                     | all     |
      |           43100 | GST Payment/Refund                     | Balance Sheet Item | Active | No                     | all     |
      |           43110 | Input Tax                              | Balance Sheet Item | Active | No                     | all     |
      |           43120 | Output Tax                             | Balance Sheet Item | Active | No                     | all     |
      |           44000 | Additional Costs (clearing)            | Balance Sheet Item | Active | No                     | all     |
      |           44100 | Additional Cost Exchange               | Balance Sheet Item | Active | No                     | all     |
      |           45010 | HP Creditor                            | Balance Sheet Item | Active | No                     | all     |
      |           45020 | HP Interest Suspenses                  | Balance Sheet Item | Active | No                     | all     |
      |           46000 | Tax on Hold - Workers                  | Balance Sheet Item | Active | No                     | all     |
      |           46010 | Salary & OT on Hold - Workers          | Balance Sheet Item | Active | No                     | all     |
      |           51010 | Products Sales                         | Profit & Loss Item | Active | No                     | all     |
      |           51020 | Project Sales                          | Profit & Loss Item | Active | No                     | all     |
      |           51030 | Maintenance Sales                      | Profit & Loss Item | Active | No                     | all     |
      |           51040 | Production Services Sales              | Profit & Loss Item | Active | No                     | all     |
      |           51041 | Production Services Revenue            | Profit & Loss Item | Active | No                     | all     |
      |           51050 | Other Services Sales                   | Profit & Loss Item | Active | No                     | all     |
      |           51051 | Other Services Revenue                 | Profit & Loss Item | Active | No                     | all     |
      |           51060 | Trade Sales                            | Profit & Loss Item | Active | No                     | all     |
      |           51061 | InterCo Sales                          | Profit & Loss Item | Active | No                     | all     |
      |           52000 | Other Income                           | Profit & Loss Item | Active | No                     | all     |
      |           60000 | Cost of Sales (Products)               | Profit & Loss Item | Active | No                     | all     |
      |           60010 | Costs of Sales (Projects)              | Profit & Loss Item | Active | No                     | all     |
      |           60020 | Costs of Sales (Maintenance)           | Profit & Loss Item | Active | No                     | all     |
      |           60030 | Costs of Sales (Services)              | Profit & Loss Item | Active | No                     | all     |
      |           60040 | Cost of Sales (Trading Customer)       | Profit & Loss Item | Active | No                     | all     |
      |           60041 | Cost of Sales (InterCo Customer)       | Profit & Loss Item | Active | No                     | all     |
      |           61000 | Purchase Variance                      | Profit & Loss Item | Active | No                     | all     |
      |           61010 | Purchase Return Variance               | Profit & Loss Item | Active | No                     | all     |
      |           62000 | Freight & Handling Costs               | Profit & Loss Item | Active | No                     | all     |
      |           62010 | Additional Costs Variance              | Profit & Loss Item | Active | No                     | all     |
      |           65000 | Inventory Written Off (Damage \\ Loss) | Profit & Loss Item | Active | No                     | all     |
      |           70000 | Upkeep of Equipments                   | Profit & Loss Item | Active | No                     | all     |
      |           70010 | Workers Wages & OT (TimeSheet)         | Profit & Loss Item | Active | No                     | all     |
      |           80000 | Directors Salary & Bonus               | Profit & Loss Item | Active | No                     | all     |
      |           80010 | Directors CPF & SDL                    | Profit & Loss Item | Active | No                     | all     |
      |           81000 | Staff Salaries & OT, Deduction, etc    | Profit & Loss Item | Active | No                     | all     |
      |           81010 | Staff CPF (Employer)                   | Profit & Loss Item | Active | No                     | all     |
      |           81020 | Staff Bonus                            | Profit & Loss Item | Active | No                     | all     |
      |           81030 | Staff FWL, SDL, etc                    | Profit & Loss Item | Active | No                     | all     |
      |           81040 | Staff Welfare                          | Profit & Loss Item | Active | No                     | all     |
      |           82000 | Medical Fee                            | Profit & Loss Item | Active | No                     | all     |
      |           82010 | Recruitment Fee                        | Profit & Loss Item | Active | No                     | all     |
      |           82030 | Training Fee                           | Profit & Loss Item | Active | No                     | all     |
      |           82040 | Transport (Taxi & Milage claim)        | Profit & Loss Item | Active | No                     | all     |
      |           83000 | Advertisement                          | Profit & Loss Item | Active | No                     | all     |
      |           83010 | Exhibition                             | Profit & Loss Item | Active | No                     | all     |
      |           83020 | Marketing & Promotions                 | Profit & Loss Item | Active | No                     | all     |
      |           83040 | Commission                             | Profit & Loss Item | Active | No                     | all     |
      |           84000 | Audit Fee                              | Profit & Loss Item | Active | No                     | all     |
      |           84010 | Accounting/Tax Fee                     | Profit & Loss Item | Active | No                     | all     |
      |           84020 | Secretarial Fee                        | Profit & Loss Item | Active | No                     | all     |
      |           84030 | Legal Fee                              | Profit & Loss Item | Active | No                     | all     |
      |           84040 | Management Fee                         | Profit & Loss Item | Active | No                     | all     |
      |           84050 | Consultancy Fee                        | Profit & Loss Item | Active | No                     | all     |
      |           84060 | Directors Fee                          | Profit & Loss Item | Active | No                     | all     |
      |           85000 | Rental-Office                          | Profit & Loss Item | Active | No                     | all     |
      |           85010 | Office Maintenance                     | Profit & Loss Item | Active | No                     | all     |
      |           85020 | Water & Eletricity                     | Profit & Loss Item | Active | No                     | all     |
      |           86000 | Bad Debts                              | Profit & Loss Item | Active | No                     | all     |
      |           86010 | Courier Services                       | Profit & Loss Item | Active | No                     | all     |
      |           86020 | Donations                              | Profit & Loss Item | Active | No                     | all     |
      |           86030 | Entertainment                          | Profit & Loss Item | Active | No                     | all     |
      |           86040 | FA Disposal Gain \\ Loss               | Profit & Loss Item | Active | No                     | all     |
      |           86050 | Gain \\ Loss - Realised                | Profit & Loss Item | Active | No                     | all     |
      |           86060 | Gain \\ Loss - Unrealised              | Profit & Loss Item | Active | No                     | all     |
      |           86070 | Insurance-Fire & Public Liabilities    | Profit & Loss Item | Active | No                     | all     |
      |           86080 | Postage                                | Profit & Loss Item | Active | No                     | all     |
      |           86090 | Printing & Stationery                  | Profit & Loss Item | Active | No                     | all     |
      |           86100 | Publication & Periodicals              | Profit & Loss Item | Active | No                     | all     |
      |           86110 | Subscription Fee                       | Profit & Loss Item | Active | No                     | all     |
      |           86120 | Telephone Charges                      | Profit & Loss Item | Active | No                     | all     |
      |           86130 | Travelling Expenses                    | Profit & Loss Item | Active | No                     | all     |
      |           86140 | Upkeep of Fixed Assets                 | Profit & Loss Item | Active | No                     | all     |
      |           87000 | Bank Charges/Commission                | Profit & Loss Item | Active | No                     | all     |
      |           87010 | Bank Overdraft Interest                | Profit & Loss Item | Active | No                     | all     |
      |           87020 | Term Loan Interest                     | Profit & Loss Item | Active | No                     | all     |
      |           87030 | Hire Purchase Interest                 | Profit & Loss Item | Active | No                     | all     |
      |           87040 | Deprn - Plant & Machinery              | Profit & Loss Item | Active | No                     | all     |
      |           87050 | Deprn - Motor Vehicles                 | Profit & Loss Item | Active | No                     | all     |
      |           87060 | Deprn - Office Equipment               | Profit & Loss Item | Active | No                     | all     |
      |           87070 | Deprn - Furniture & Fittings           | Profit & Loss Item | Active | No                     | all     |
      |           87080 | Deprn - IT Hardware & Software         | Profit & Loss Item | Active | No                     | all     |
      |           87090 | Deprn - Renovation                     | Profit & Loss Item | Active | No                     | all     |
      | Z-100           | Fixed Asset Clearing                   | Balance Sheet Item | Active | No                     | all     |
      | Z-200           | Inventory Clearing                     | Balance Sheet Item | Active | No                     | all     |
      | Z-300           | Receivable Clearing                    | Balance Sheet Item | Active | No                     | all     |
      | Z-400           | Payable Clearing                       | Balance Sheet Item | Active | No                     | all     |
      | Z-500           | Bank Clearing                          | Balance Sheet Item | Active | No                     | all     |
      | Z-600           | Corporate Clearing                     | Balance Sheet Item | Active | No                     | all     |
      | Z-700           | COSR Clearing                          | Balance Sheet Item | Active | No                     | all     |
      | Z-800           | Other Clearing                         | Balance Sheet Item | Active | No                     | all     |

  Scenario Outline: A2. Create Sales Tax  with feature file
    Given user login the TH6 system
    When user navigates to "Master Setup>Accounting>Sales Tax" screen
    When user create sales tax as "<KEY SALES TAX>"
      | KEY SALES TAX | Prefix | Sales Tax Code | Description | Sales Tax | Input Tax GLAN | Output Tax GLAN | IRAS Tax Type of Purchase | IRAS Tax Type of Supply | Company |
      |           001 |        | gst0           | GST 0%      |         0 |          43110 |           43120 | PR0                       | SR0                     | all     |
      |           001 |        | gst7           | GST 7%      |         7 |          43110 |           43120 | PR7                       | SR7                     | all     |
      |           001 |        | gst10          | GST 10%     |        10 |          43110 |           43120 | PR10                      | SR10                    | all     |
      |           001 |        | custom         | Custom Tax  |         0 |          43110 |           43120 |                           |                         | all     |

    Examples: 
      | KEY SALES TAX |
      |           001 |

  Scenario: A3. Config of FIN with feature file
    Given user login the TH6 system
    And user navigates to "Master Setup>System Configuration>Module Config" screen
    And user changes Module Config
      | Module Section                          | Module Name                 | Config Type 1 | Config Value 1        | Config Type 2 | Config Value 2 |
      | Accounts Payable>Accounts Payable       | Invalid Prior Period        | Input         |                    12 |               |                |
      | Accounts Payable>Accounts Payable       | Invalid Future Period       | Input         |                    12 |               |                |
      | Accounts Payable>Accounts Payable       | Custom Tax Code             | Search        | Sales Tax Code>CUSTOM |               |                |
      | Accounts Receivable>Accounts Receivable | Invalid Prior Period        | Input         |                    12 |               |                |
      | Accounts Receivable>Accounts Receivable | Invalid Future Period       | Input         |                    12 |               |                |
      | Bank Book>Bank Book                     | Invalid Prior Period        | Input         |                    12 |               |                |
      | Bank Book>Bank Book                     | Invalid Future Period       | Input         |                    12 |               |                |
      | Fixed Asset>Fixed Asset                 | Default Generate Voucher By | Input         | Class                 |               |                |
      | General Ledger>General Ledger           | Invalid Prior Period        | Input         |                    12 |               |                |
      | General Ledger>General Ledger           | Invalid Future Period       | Input         |                    12 |               |                |
      | General Ledger>General Ledger           | Retained Earning GLAN       | Search        | GL Account Code>40010 |               |                |
      | Opening Balance>Opening Balance         | AP Clearing GLAN            | Search        | GL Account Code>Z-400 |               |                |
      | Opening Balance>Opening Balance         | AR Clearing GLAN            | Search        | GL Account Code>Z-300 |               |                |

  Scenario Outline: A4. Create Currency with feature file
    Given user login the TH6 system
    When user navigates to "Master Setup>Currency>Currency" screen
    When user create currency as "<KEY CURRENCY>"
      | KEY CURRENCY | Currency | Description      | Currency Symbol | Dollar in word | Cent in word | Minimum Bank Rate | Maximum Bank Rate | Maximum Spread% | Spread % Base | Credit Limit Exchange Rate | Company |
      |          001 | SGD      | Singapore Dollar |                 |                |              |                 1 |                 1 |                 |               |                            | all     |
      |          001 | USD      | US Dollar        |                 |                |              |                 1 |                 2 |                 |               |                            | all     |
      |          001 | AUD      | Australia Dollar |                 |                |              |                 1 |                 3 |                 |               |                            | all     |

    Examples: 
      | KEY CURRENCY |
      |          001 |

  Scenario: A5. Set Home Currency with feature file
    Given user login the TH6 system
    And user navigates to "Master Setup>Company>Company" screen
    When user update for company "AUTO1"
    And user navigates to "Maintenance Setup>Administration>Company>Company Configuration>[2]" screen
    When user set home and operation for currency
      | Home Currency | Operation Currency |
      | SGD           | SGD                |

  Scenario Outline: A6. Create Customer Class with feature file
    Given user login the TH6 system
    When user navigates to "Master Setup>Customer>Customer Class" screen
    And user create customer class as "<KEY CUS CLASS>"
      | KEY CUS CLASS | Customer Class Code | Description            | Receivable GLAN | Realized GLAN | Unrealized GLAN | Corporate Clearing GLAN | Amt Refundable to Customer | Receivable Medisave GLAN | Medisave Clearing GLAN | Amt Billable to Customer | Recognized Accrued Cost | Recognized Accrued Revenue | Rental Revenue GLAN | Sales GLAN | Costs of Sales GLAN | Sales Return GLAN | Costs of Sales Return GLAN | Costs of Sales Ret Clearing GLAN | Delivery Clearing GLAN | Inventory With Customer GLAN | Cost of Servicing GLAN | Unearned Revenue GLAN | Work in Progress GLAN | Retention GLAN | Project Revenue GLAN | Project Cost GLAN | Recognition Exch Gain Loss GLAN | Cost Accrual GLAN | Revenue Accrual GLAN | Accrued Income GLAN | Attributable Profit | Claim Debtor | Certification Debtor | Other Payable | Retention Clearing | Material on Site | Retention Material on Site | Downpayment Unearned GLAN | Downpayment Exch Gain Loss GLAN | Company |
      |           001 | TRADE               | Trading Customer Class |           22020 |         86050 |           86060 | Z-600                   |                      22020 |                    22020 | Z-600                  |                    22020 |                   22020 |                      22020 |               85000 |      51060 |               60040 |             51060 |                      60040 | Z-700                            |                  20030 |                        20020 |                  60030 |                 21020 |                 21080 |          21030 |                51020 |             60010 |                           86050 |             43020 |                43010 |               43010 |               43010 |        43010 |                43010 |         43010 | Z-800              | Z-800            | Z-800                      |                     21010 |                           86050 | all     |
      |           001 | INTERCO             | Interco Customer Class |           22030 |         86050 |           86060 | Z-600                   |                      22030 |                    22030 | Z-600                  |                    22030 |                   22030 |                      22030 |               85000 |      51061 |               60041 |             51061 |                      60041 | Z-700                            |                  20030 |                        20020 |                  60030 |                 21020 |                 21080 |          21030 |                51020 |             60010 |                           86050 |             43020 |                43010 |               43010 |               43010 |        43010 |                43010 |         43010 | Z-800              | Z-800            | Z-800                      |                     21010 |                           86050 | all     |

    Examples: 
      | KEY CUS CLASS |
      |           001 |

  Scenario Outline: A7. Create Customer with feature file
    Given user login the TH6 system
    And user navigates to "Master Setup>Customer>Customer" screen
    When user create customer as "<KEY CUSTOMER>"
      | KEY CUSTOMER | Prefix Auto Gen Code | Customer Code | Unique Entity No | Customer Name                            | Customer Class Code | Party Group Code | Industry Code | Acquired By | Country Of Incorporation | Sales Tax Code | Contra Realized Exch GLAN | Statement Delivery Option | Default Tenor | Discount | Due AR Invoice Correspondence Language | Customer Remarks | Status | Main Customer Code | Customer Short Name | Customer Category Code | Customer Group Code | Customer Type | Main Home Page | GST Registration No | Party Contra GLAN | Default Validity | Default Tenor Term Code | Price Markup Percent | Combine Shm to Invoices | IPT Related | Shipping Marks Code | Company |
      |          001 |                      | INTERCO       |                  | Cus01 for Synergix Testing ONLY          | INTERCO             |                  |               |             |                          | GST0           |                     43000 |                           |               |          |                                        |                  |        |                    | Customer 1          |                        |                     |               |                |                     |             22040 |                  |                         |                      |                         |             |                     | all     |
      |          002 |                      | CUS01         |                  | Cus02 - contra for Synergix Testing ONLY | TRADE               |                  |               |             |                          | GST7           |                     43000 |                           |               |          |                                        |                  |        |                    | Customer 2          |                        |                     |               |                |                     |             22040 |                  |                         |                      |                         |             |                     | all     |
      |          003 |                      | CUS02         |                  | Cus03 for Synergix Testing ONLY          | TRADE               |                  |               |             |                          | GST7           |                     43000 |                           |               |          |                                        |                  |        |                    | Customer 3          |                        |                     |               |                |                     |             22040 |                  |                         |                      |                         |             |                     | all     |
      |          004 |                      | CUS03         |                  | Cus04 - contra for Synergix Testing ONLY | TRADE               |                  |               |             |                          | GST7           |                     43000 |                           |               |          |                                        |                  |        |                    | Customer 4          |                        |                     |               |                |                     |             22040 |                  |                         |                      |                         |             |                     | all     |
    #CURRENCY TAB
    And customer is added currency as "<KEY CUSTOMER>"
      | KEY CUSTOMER | Currency | Del |
      |          001 | USD      |     |
      |          001 | SGD      |     |
      |          001 | AUD      |     |
      |          002 | USD      |     |
      |          002 | SGD      |     |
      |          002 | AUD      |     |
      |          003 | USD      |     |
      |          003 | SGD      |     |
      |          003 | AUD      |     |
      |          004 | USD      |     |
      |          004 | SGD      |     |
      |          004 | AUD      |     |
    And customer is added payment as "<KEY CUSTOMER>"
      | KEY CUSTOMER | Operational Currency | Next Credit Review Date |
      |          001 | SGD                  |                         |
      |          002 | SGD                  |                         |
      |          003 | SGD                  |                         |
      |          004 | SGD                  |                         |
    And customer is added payment option as "<KEY CUSTOMER>"
      | KEY CUSTOMER | Description      | Is Active | Default |
      |          001 | Advance Payment  | Y         |         |
      |          001 | Cash on Delivery | Y         | Y       |
      |          002 | Leasing          | Y         | Y       |
      |          003 | Open Account     | Y         | Y       |
      |          004 | Trade Financing  | Y         | Y       |
    And customer is added payment term as "<KEY CUSTOMER>"
      | KEY CUSTOMER | OPTION           | Description      | Is Active | Default |
      |          001 | Advance Payment  | Advance Payment  | Y         | N       |
      |          001 | Cash on Delivery | Cash on Delivery | Y         | Y       |
      |          002 | Leasing          | Credit Term      | Y         | Y       |
      |          003 | Open Account     | Credit Term      | Y         | Y       |
      |          004 | Trade Financing  | DA               | Y         | N       |
      |          004 | Trade Financing  | DP               | Y         | Y       |
      |          004 | Trade Financing  | L/C at Sight     | Y         | N       |
      |          004 | Trade Financing  | L/C              | Y         | N       |
    And customer is added payment method as "<KEY CUSTOMER>"
      | KEY CUSTOMER | OPTION           | TERM             | Description          | Is Active | Default |
      |          001 | Advance Payment  | Advance Payment  | Bank Draft           | Y         | N       |
      |          001 | Advance Payment  | Advance Payment  | Credit Card          | Y         | N       |
      |          001 | Advance Payment  | Advance Payment  | Cheque               | Y         | N       |
      |          001 | Advance Payment  | Advance Payment  | Cash                 | Y         | N       |
      |          001 | Advance Payment  | Advance Payment  | ePayment             | Y         | N       |
      |          001 | Advance Payment  | Advance Payment  | Post Dated Cheque    | Y         | N       |
      |          001 | Advance Payment  | Advance Payment  | Telegraphic Transfer | Y         | N       |
      |          001 | Cash on Delivery | Cash on Delivery | Credit Card          | Y         | N       |
      |          001 | Cash on Delivery | Cash on Delivery | Cheque               | Y         | Y       |
      |          001 | Cash on Delivery | Cash on Delivery | Cash                 | Y         | N       |
      |          001 | Cash on Delivery | Cash on Delivery | Nets                 | Y         | N       |
      |          002 | Leasing          | Credit Term      | Cheque               | Y         | Y       |
      |          002 | Leasing          | Credit Term      | Cash                 | Y         | N       |
      |          003 | Open Account     | Credit Term      | Bank Draft           | Y         | N       |
      |          003 | Open Account     | Credit Term      | Credit Card          | Y         | N       |
      |          003 | Open Account     | Credit Term      | Cheque               | Y         | N       |
      |          003 | Open Account     | Credit Term      | Cash                 | Y         | Y       |
      |          003 | Open Account     | Credit Term      | ePayment             | Y         | N       |
      |          003 | Open Account     | Credit Term      | GIRO                 | Y         | N       |
      |          003 | Open Account     | Credit Term      | Post Dated Cheque    | Y         | N       |
      |          004 | Open Account     | Credit Term      | Telegraphic Transfer | Y         | N       |
      |          004 | Trade Financing  | DA               | DA                   | Y         | Y       |
      |          004 | Trade Financing  | DP               | DP                   | Y         | N       |
      |          004 | Trade Financing  | L/C at Sight     | L/C at Sight         | Y         | N       |
      |          004 | Trade Financing  | L/C              | L/C                  | Y         | N       |
    And customer is updated

    Examples: 
      | KEY CUSTOMER |
      |          001 |
      |          002 |
      |          003 |
      |          004 |

  Scenario Outline: A8. Create Supplier Class with feature file
    Given user login the TH6 system
    When user navigates to "Master Setup>Supplier>Supplier Class" screen
    And user create supplier class as "<KEY SUP CLASS>"
      | KEY SUP CLASS | Supplier Class Code | Description            | Payable GLAN | Realized GLAN | Unrealized GLAN | Goods Receipt Clearing GLAN | Purchase Variance GLAN | Additional Cost | Additional Cost Variance | Additional Cost Exchange | Purchase Return Variance | Purchase Variance Exch Diff | Sales Tax Exch Difference | Retention GLAN | Other Income GLAN | Company |
      |           001 | TRADE               | Trading Supplier Class |        41020 |         86050 |           86060 |                       20010 |                  61000 |           44000 |                    62010 |                    44100 |                    61010 |                       52000 |                     52000 |          21030 |             52000 | all     |
      |           001 | INTERCO             | InterCo Supplier Class |        41030 |         86050 |           86060 |                       20010 |                  61000 |           44000 |                    62010 |                    44100 |                    61010 |                       52000 |                     52000 |          21030 |             52000 | all     |

    Examples: 
      | KEY SUP CLASS |
      |           001 |

  Scenario Outline: A9. Create Supplier with feature file
    Given user login the TH6 system
    When user navigates to "Master Setup>Supplier>Supplier" screen
    And user create supplier as "<KEY SUPPLIER>"
      | KEY SUPPLIER | isContra | Prefix Auto Gen Code | Supplier | Supplier Name               | Supplier Class Code | Party Group Code | Main Home Page | GST Registration No | Country Of Incorporation | Subcon WIP Glan | Sales Tax Code | Default Tenor Term Code | Default Tenor | IPT Related | Status | Unique Entity No | Main Supplier Code | Supplier Short Name | Supplier Category Code | Supplier Rank Code | Purchasing Zone | Party Contra GLAN | Contra Realized Exch GLAN | Default Discount Percent | Combine Shm to Invoices | Remarks | Company |
      |          001 | Y        |                      | INTERCO  |                             | INTERCO             |                  |                |                     |                          |                 | gst0           |                         |               |             |        |                  |                    |                     |                        |                    |                 |             22040 |                     43000 |                          |                         |         | all     |
      |          002 | N        |                      | SUP01    | Supplier 01 for FIN IT Test | TRADE               |                  |                |                     |                          |                 | gst7           |                         |               |             |        |                  |                    |                     |                        |                    |                 |             22040 |                     43000 |                          |                         |         | all     |
      |          003 | N        |                      | SUP02    | Supplier 02 for FIN IT Test | TRADE               |                  |                |                     |                          |                 | gst7           |                         |               |             |        |                  |                    |                     |                        |                    |                 |             22040 |                     43000 |                          |                         |         | all     |
      |          004 | N        |                      | SUP03    | Supplier 03 for FIN IT Test | TRADE               |                  |                |                     |                          |                 | gst7           |                         |               |             |        |                  |                    |                     |                        |                    |                 |             22040 |                     43000 |                          |                         |         | all     |
    #CURRENCY TAB
    And supplier is added currency as "<KEY SUPPLIER>"
      | KEY SUPPLIER | Currency | Del |
      |          001 | USD      |     |
      |          001 | SGD      |     |
      |          001 | AUD      |     |
      |          001 | USD      |     |
      |          002 | SGD      |     |
      |          002 | AUD      |     |
      |          003 | USD      |     |
      |          003 | SGD      |     |
      |          003 | AUD      |     |
      |          004 | USD      |     |
      |          004 | SGD      |     |
      |          004 | AUD      |     |
    # PAYMENT TAB
    And supplier is added payment as "<KEY SUPPLIER>"
      | KEY SUPPLIER | Operational Currency | Overall Credit Limit |
      |          001 | SGD                  |                    3 |
      |          002 | SGD                  |                    4 |
      |          003 | SGD                  |                    5 |
      |          004 | SGD                  |                    6 |
    And supplier is added payment option as "<KEY SUPPLIER>"
      | KEY SUPPLIER | Description      | Is Active | Default |
      |          001 | Advance Payment  | Y         |         |
      |          001 | Cash on Delivery | Y         | Y       |
      |          002 | Leasing          | Y         | Y       |
      |          003 | Open Account     | Y         | Y       |
      |          004 | Trade Financing  | Y         | Y       |
    And supplier is added payment term as "<KEY SUPPLIER>"
      | KEY SUPPLIER | OPTION           | Description      | Is Active | Default |
      |          001 | Advance Payment  | Advance Payment  | Y         | N       |
      |          001 | Cash on Delivery | Cash on Delivery | Y         | Y       |
      |          002 | Leasing          | Credit Term      | Y         | Y       |
      |          003 | Open Account     | Credit Term      | Y         | Y       |
      |          004 | Trade Financing  | DA               | Y         | N       |
      |          004 | Trade Financing  | DP               | Y         | Y       |
      |          004 | Trade Financing  | L/C at Sight     | Y         | N       |
      |          004 | Trade Financing  | L/C              | Y         | N       |
    And supplier is added payment menthod as "<KEY SUPPLIER>"
      | KEY SUPPLIER | OPTION           | TERM             | Description          | Is Active |
      |          001 | Advance Payment  | Advance Payment  | Bank Draft           | Y         |
      |          001 | Advance Payment  | Advance Payment  | Credit Card          | Y         |
      |          001 | Advance Payment  | Advance Payment  | Cheque               | Y         |
      |          001 | Advance Payment  | Advance Payment  | Cash                 | Y         |
      |          001 | Advance Payment  | Advance Payment  | ePayment             | Y         |
      |          001 | Advance Payment  | Advance Payment  | Post Dated Cheque    | Y         |
      |          001 | Advance Payment  | Advance Payment  | Telegraphic Transfer | Y         |
      |          001 | Cash on Delivery | Cash on Delivery | Credit Card          | Y         |
      |          001 | Cash on Delivery | Cash on Delivery | Cheque               | Y         |
      |          001 | Cash on Delivery | Cash on Delivery | Cash                 | Y         |
      |          001 | Cash on Delivery | Cash on Delivery | Nets                 | Y         |
      |          002 | Leasing          | Credit Term      | Cheque               | Y         |
      |          002 | Leasing          | Credit Term      | Cash                 | Y         |
      |          003 | Open Account     | Credit Term      | Bank Draft           | Y         |
      |          003 | Open Account     | Credit Term      | Credit Card          | Y         |
      |          003 | Open Account     | Credit Term      | Cheque               | Y         |
      |          003 | Open Account     | Credit Term      | Cash                 | Y         |
      |          003 | Open Account     | Credit Term      | ePayment             | Y         |
      |          003 | Open Account     | Credit Term      | GIRO                 | Y         |
      |          003 | Open Account     | Credit Term      | Post Dated Cheque    | Y         |
      |          003 | Open Account     | Credit Term      | Telegraphic Transfer | Y         |
      |          004 | Trade Financing  | DA               | DA                   | Y         |
      |          004 | Trade Financing  | DP               | DP                   | Y         |
      |          004 | Trade Financing  | L/C at Sight     | L/C at Sight         | Y         |
      |          004 | Trade Financing  | L/C              | L/C                  | Y         |
    And supplier is updated

    Examples: 
      | KEY SUPPLIER |
      |          001 |
      |          002 |
      |          003 |
      |          004 |

  Scenario Outline: A10. Create Bank with feature file
    Given user login the TH6 system
    And user navigates to "Master Setup>Party>Party" screen
    When user create bank as "<KEY BANK>"
      | KEY BANK | Prefix | Party Code | Party Name | Party Short Name | Party Group Code | Country Of Incorporation | Main Home Page | Tax Agent | GST Registration No | Unique Entity No | Party Contra GLAN | Contra Realized Exch GLAN | Company |
      |      001 |        | OCBC       | OCBC BANK  | OCBC             |                  |                          |                |           |                     |                  |             22040 |                     43000 | all     |
      |      002 |        | DBS        | DBS BANK   | DBS              |                  |                          |                |           |                     |                  |             22040 |                     43000 | all     |
    And bank is added relation service group as "<KEY BANK>"
      | KEY BANK | Party Relation        | Service Type             | Allowed |
      |      001 | Financial Institution | Banking Services         | Y       |
      |      001 | Financial Institution | Leasing Services         | Y       |
      |      001 | Financial Institution | Trade Financing Services | Y       |
      |      002 | Financial Institution | Banking Services         | Y       |
      |      002 | Financial Institution | Leasing Services         | Y       |
      |      002 | Financial Institution | Trade Financing Services | Y       |
    And bank is updated
    And bank is added local info own bank detail as "<KEY BANK>"
      | KEY BANK | Account No | Branch Code | Currency Code | Bank GLAN | Last Cheque No | Combine BC in Payment | Combine BC in Receipt | Del |
      |      001 | OCBCUSD    |             | USD           |     28010 |                |                       |                       |     |
      |      001 | OCBCSGD    |             | SGD           |     28011 |                |                       |                       |     |
      |      002 | DBSUSD     |             | USD           |     28020 |                |                       |                       |     |
      |      002 | DBSSGD     |             | SGD           |     28021 |                |                       |                       |     |
      |      002 | DBSAUD     |             | AUD           |     28022 |                |                       |                       |     |
    And bank is updated

    Examples: 
      | KEY BANK |
      |      001 |
      |      002 |

  Scenario Outline: A11. Create Unit of Measurement with feature
    Given user login the TH6 system
    And user navigates to "Master Setup>Inventory>Unit of Measurement" screen
    When user create unit of measurement as "<KEY UOM>"
      | KEY UOM | UOM Code | Description | Type               | Company |
      |     001 | UNIT     | Unit        | Inventory, Service | all     |
      |     001 | BOX      | Box         | Inventory, Service | all     |
      |     001 | PIECE    | Piece       | Inventory, Service | all     |

    Examples: 
      | KEY UOM |
      |     001 |

  Scenario Outline: A12. Create Service with feature file
    Given user login the TH6 system
    And user navigates to "Master Setup>Service>Service" screen
    When user create service as "<KEY SERVICE>"
      | KEY SERVICE | Service Code | Service Description | Service Category | UOM  | Track Qty in Project | Budget Category Code | Service Type                                     | Revenue Status | Revenue GLAN | Unearned Revenue GLAN | Sales Accrual GLAN | Report Grouping | Default Sales Tax | Intercompany Sales Tax | Expense Status | Expense GLAN | Accrued Cost GLAN | Overhead GLAN | Company |
      |         001 | PRODUCTION   | Production          |                  | UNIT |                      |                      | Expense (Additional Payment),Revenue (Deduction) | Active         |        51040 |                 21020 |                    |                 | gst0              |                        | Active         |        51041 |             43010 |               | all     |
      |         002 | OTHER        | Other               |                  | UNIT |                      |                      | Expense (Additional Payment),Revenue (Deduction) | Active         |        51050 |                 21020 |                    |                 | gst0              |                        | Active         |        51051 |             43010 |               | all     |
      |         003 | BKCHARGE     | Bank Charge         |                  | UNIT |                      |                      | Expense (Additional Payment),Revenue (Deduction) | Active         |        87000 |                       |                    |                 | gst0              |                        |                |        87000 |                   |               | all     |
    And service is added service relation as "<KEY SERVICE>"
      | KEY SERVICE | Party Type Group      | Party Type        | Revenue | Expense |
      |         001 | Customer              | Products/Services | y       | y       |
      |         001 | Customer              | Retailer          | y       | y       |
      |         001 | Service Vendor        | Services          | y       | y       |
      |         001 | Supplier              | Retail            | y       | y       |
      |         001 | Supplier              | Supplier          | y       | y       |
      |         002 | Customer              | Products/Services | y       | y       |
      |         002 | Customer              | Retailer          | y       | y       |
      |         002 | Service Vendor        | Services          | y       | y       |
      |         002 | Supplier              | Retail            | y       | y       |
      |         002 | Supplier              | Supplier          | y       | y       |
      |         003 | Financial Institution | Banking Services  | y       | y       |
    And service is updated

    Examples: 
      | KEY SERVICE |
      |         001 |
      |         002 |
      |         003 |

  Scenario Outline: A13. Create fixed asset class with feature file
    Given user login the TH6 system
    When user navigates to "Master Setup>Fixed Asset>Class" screen
    And user creates fixed asset class as "<KEY FA>"
      | KEY FA | Fixed Asset Class Code | Description       | Fixed Asset GLAN | Depreciation GLAN | Cumulative Depreciation GLAN | Gain Loss Disposal GLAN | Disposal Clearing GLAN | Fixed Asset Clearing GLAN | Project Utilization Glan | Company |
      |    001 | PM                     | Plant & Machinery |            10000 |             87040 |                        11000 |                   86040 |                  12000 | Z-100                     |                          | all     |
      |    001 | MV                     | Motor Vehicles    |            10010 |             87050 |                        11010 |                   86040 |                  12000 | Z-100                     |                          | all     |
      |    001 | OE                     | Office Equipment  |            10020 |             87060 |                        11020 |                   86040 |                  12000 | Z-100                     |                          | all     |

    Examples: 
      | KEY FA |
      |    001 |

  Scenario Outline: A14. Create fixed asset category  with feature file
    Given user login the TH6 system
    When user navigates to "Master Setup>Fixed Asset>Category" screen
    And user creates fixed asset category as "<KEY FA>"
      | KEY FA | Fixed Asset Category Code | Description    | Company |
      |    001 | FA-CATE01                 | FA Category 01 | all     |
      |    001 | FA-CATE02                 | FA Category 02 | all     |
      |    001 | FA-CATE03                 | FA Category 03 | all     |

    Examples: 
      | KEY FA |
      |    001 |

  Scenario Outline: A15. Create fixed asset location with feature file
    Given user login the TH6 system
    When user navigates to "Master Setup>Fixed Asset>Location" screen
    And user creates fixed asset location as "<KEY FA>"
      | Key | Fixed Asset Location Code | Fixed Asset Location Name | Company |
      | 001 | SG                        | Singapore                 | all     |
      | 001 | VN                        | Vietnam                   | all     |
      | 001 | ML                        | Malaysia                  | all     |

    Examples: 
      | KEY FA |
      |    001 |

  Scenario Outline: A16. Create Global Fixed Asset with feature file
    Given user login the TH6 system
    When user navigates to "Master Setup>Fixed Asset>Fixed Asset" screen
    And user creates global fixed asset as "<KEY FA>"
      | KEY FA | Fixed Asset Code | Description        | Detailed Specification  | Fixed Asset Class | Fixed Asset Category | Depreciation Method      | Rate On Declining Balance | Percentage of Straight Line Rate | Useful Life Year | Useful Life Period | Total Useful Life | Global Status | UOM   | Volume | Gross Weight | Location | Local Info Status | Company |
      |    001 | MACHINE          | Machine 6Y         | FA Machine 6YRs         | PM                | FA-CATE01            | Straight Line per Year   |                           |                                  |                6 |                  0 |                   |               | piece |        |              | SG       |                   | all     |
      |    001 | MOTOR            | Motor Vehicles 12P | FA Motor Vehicles 12PRs | MV                | FA-CATE02            | Straight Line per Period |                           |                                  |                1 |                  0 |                   |               | piece |        |              | SG       |                   | all     |
      |    001 | PC               | Computer 18P       | FA Computer 18PRs       | OE                | FA-CATE03            | Straight Line per Period |                           |                                  |                1 |                  6 |                   |               | piece |        |              | SG       |                   | all     |

    Examples: 
      | KEY FA |
      |    001 |

  ###############################################################################
  ###############################################################################
  # ~~~~~~~~~~~~~~~~~~~~~~~~~~ MAINTENANCE SETUP ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  Scenario Outline: B1. Create Segment with feature file
    Given user login the TH6 system
    And user navigates to "Maintenance Setup>Demographic>Sector>Segment>[2]" screen
    When user create segment as "<KEY SGMT>"
      | KEY SGMT | Segment No | Segment Name |
      |      001 |          1 | Country      |
      |      002 |          2 | Region       |
      |      003 |          3 | Department   |
      |      004 |          4 | Employee     |
    And segment is added detail as "<KEY SGMT>"
      | KEY SGMT | Segment Code | Description  | Del |
      |      001 | SG           | Singapore    |     |
      |      001 | VN           | Vietnam      |     |
      |      001 | NA           | Others       |     |
      |      002 | SG           | Singapore    |     |
      |      002 | HN           | Hanoi        |     |
      |      002 | HCM          | Ho Chi Minh  |     |
      |      002 | NA           | Others       |     |
      |      003 | D1           | Department 1 |     |
      |      003 | D2           | Department 2 |     |
      |      003 | D3           | Department 3 |     |
      |      003 | NA           | NA           |     |
      |      004 | RA           | Rachel       |     |
      |      004 | SA           | Sarah        |     |
      |      004 | TR           | Tracy        |     |
      |      004 | LR           | Laura        |     |
      |      004 | NA           | Others       |     |

    Examples: 
      | KEY SGMT |
      |      001 |
      |      002 |
      |      003 |
      |      004 |

  Scenario Outline: B2. Set Financial Year Period with feature file
    Given user login the TH6 system
    When user navigates to "Maintenance Setup>Financial>Accounting>Financial Year/Period>[2]" screen
    And user set financial year period as "<KEY>"
      | KEY | Financial Year | Description         | Begin Date | End Date   | No Of Period |
      | 001 |           2014 | Financial Year 2014 | 1/1/2014   | 31/12/2014 |           12 |
      | 001 |           2015 | Financial Year 2015 | 1/1/2015   | 31/12/2015 |           12 |
      | 001 |           2016 | Financial Year 2016 | 1/1/2016   | 31/12/2016 |           12 |
      | 001 |           2017 | Financial Year 2017 | 1/1/2017   | 31/12/2017 |           12 |

    Examples: 
      | KEY |
      | 001 |

  Scenario: B3. Set Financial Period Opening with feature file
    Given user login the TH6 system
    When user navigates to "Opening Balance>Financial Period Opening" screen
    And user set financial period opening with feature file
      | Module Code | Financial Year | Period |
      | AP          |           2016 |      6 |
      | AR          |           2016 |      6 |
      | GL          |           2016 |      6 |
      | BK          |           2016 |      6 |
      | FA          |           2016 |      6 |

  Scenario Outline: B4. Set Exchange Rate with feature file
    Given user login the TH6 system
    And user navigates to "Maintenance Setup>Financial>Currency>Exchange Rate>[2]" screen
    When user set exchange rate as "<KEY RATE>"
      | KEY RATE | Currency |
      |      001 | USD      |
      |      002 | SGD      |
      |      003 | AUD      |
    And exchange rate is added date as "<KEY RATE>"
      | KEY RATE | Effective Date From | Effective Date To | Upwards Variance Allowed | Downwards Variance Allowed | Bank Sell Rate | Bank Buy Rate | Revaluation Rate |
      |      001 | 1/1/2014            | 31/12/2014        |                      100 |                        100 |            1.5 |           1.4 |                  |
      |      001 | 1/1/2015            | 31/12/2015        |                      100 |                        100 |            1.5 |           1.4 |                  |
      |      001 | 1/1/2016            | 31/12/2020        |                      100 |                        100 |            1.5 |           1.4 |                  |
      |      002 | 1/1/2014            | 31/12/2014        |                      100 |                        100 |              1 |             1 |                  |
      |      002 | 1/1/2015            | 31/12/2015        |                      100 |                        100 |              1 |             1 |                  |
      |      002 | 1/1/2016            | 31/12/2020        |                      100 |                        100 |              1 |             1 |                  |
      |      003 | 1/1/2014            | 31/12/2014        |                      100 |                        100 |            1.7 |           1.6 |                  |
      |      003 | 1/1/2015            | 31/12/2015        |                      100 |                        100 |            1.7 |           1.6 |                  |
      |      003 | 1/1/2016            | 31/12/2020        |                      100 |                        100 |            1.7 |           1.6 |                  |

    Examples: 
      | KEY RATE |
      |      001 |
      |      002 |
      |      003 |

  Scenario Outline: B5. Create MT GL Recurring Voucher with feature file
    Given user login the TH6 system
    And user navigates to "Maintenance Setup>Financial>Accounting>GL Recurring Voucher>[2]" screen
    When user create MT GL Recurring VCH as "<KEY RECURRING>"
      | KEY RECURRING | Recurring Voucher Code | Description                                    | Currency | Exchange Rate Type | Source Document Type | Source Document No | Recurring Day | Recurring Frequency | Recurrence Start Date | Recurrence End Date | Next Recurrence Date | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |           001 | RVC01                  | Paying Office Rental First Day Every Month     | SGD      |                    |                      |                    |             1 |                     |                       |                     |                      | NA        | NA        | NA        | NA        |
      |           002 | RVC02                  | Paying Office Maintenance Last Day Every Month | SGD      |                    |                      |                    |            31 |                     |                       |                     |                      | NA        | NA        | NA        | NA        |
    And MT GL recurring vch is add detail as "<KEY RECURRING>"
      | KEY RECURRING | GL Account Code | Description                      | Nature Debit | Natural Credit | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |           001 |           85000 | Debit Office Rental Account      |         1200 |                | NA        | NA        | NA        | NA        |
      |           001 |           28090 | Credit Cash                      |              |           1200 | NA        | NA        | NA        | NA        |
      |           002 |           85010 | Debit Office Maintenance Account |          100 |                | NA        | NA        | NA        | NA        |
      |           002 |           28090 | Credit Cash                      |              |            100 | NA        | NA        | NA        | NA        |
    And user close MT GL Recurring VCH

    Examples: 
      | KEY RECURRING |
      |           001 |
      |           002 |

  Scenario: B6. Create MT GL Revaluation with feature file
    Given user login the TH6 system
    When user navigates to "Maintenance Setup>Financial>Accounting>GL Revaluation>[2]" screen
    And user create GL revaluation
      | GL Account Code | Description         | Unrealised Gain Loss GLAN |
      |           28010 | OCBC Bank USD – Acc |                     86060 |
      |           28020 | DBS Bank USD – Acc  |                     86060 |

  Scenario Outline: B7. Create Bank Book Recurring Template with feature file
    Given user login the TH6 system
    And user navigates to "Maintenance Setup>Financial>Accounting>Bank Book Recurring Template" screen
    When user create BK recurring template as "<KEY BK>"
      | KEY BK | Bank Template Code | Template Description                    | Bank Voucher Description | Recurring Frequency | Recurring Day | Recurrence Start Date | Recurrence End Date | Last Recurred Date | Transaction Type |
      |    001 | BT01               | Deposit S$15000 Cash on hand to DBS SGD |                          | Monthly             |             1 | 01/06/2016            |                     |                    | Deposit          |
      |    002 | BT02               | Transfer S$5000 from OCBCSGD to DBSUSD  |                          | Monthly             |            15 | 01/06/2016            |                     |                    | Fund Transfer    |
      |    003 | BT03               | Withdraw $10000 of cash from OCBC USD   |                          | Monthly             |            31 | 01/06/2016            |                     |                    | Withdrawal       |
    And BK recurring template is deposit as "<KEY BK>"
      | KEY BK | Mode of Deposit | Deposit bank A/c No | Currency | Deposit Slip No | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |    001 |                 | DBSSGD              | SGD      |                 | NA        | NA        | NA        | NA        |
    And BK deposit is added detail as "<KEY BK>"
      | KEY BK | Received From | Cheque No. | Amount | Sales Tax | Document No | Doc Date | Segment 1 | Segment 2 | Segment 3 | Segment 4 | Del |
      |    001 | OTHER         |          2 |  15000 |           |             |          | NA        | NA        | NA        | NA        |     |
    And BK charge is added detail as "<KEY BK>"
      | KEY BK | Charge To | Bank Charge | Ccy | Charge Amt |
      |    001 |           | BKCHARGE    | SGD |         10 |
    And BK recurring template is fund transfer as "<KEY BK>"
      | KEY BK | Remittance Bank A/c No (Code > No.) | Destination Bank A/c No (Code > No.) | Transfer Amount | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |    002 | OCBC > OCBCSGD                      | DBS > DBSUSD                         |            5000 | NA        | NA        | NA        | NA        |
    And BK charge is added detail as "<KEY BK>"
      | KEY BK | Charge To        | Bank Charge | Ccy | Charge Amt |
      |    002 | Remittance Bank  | BKCHARGE    | SGD |          4 |
      |    002 | Destination Bank | BKCHARGE    | USD |        2.5 |
    And BK recurring template is withdrawal as "<KEY BK>"
      | KEY BK | Mode of Withdrawal | Withdrawal Bank A/C No | Currency | Withdrawal Slip No | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |    003 |                    | OCBCUSD                | USD      |                    | NA        | NA        | NA        | NA        |
    And BK withdrawal is added detail as "<KEY BK>"
      | KEY BK | Paid to | Cheque No. | Amount | Sales Tax | Document No | Doc Date | Segment 1 | Segment 2 | Segment 3 | Segment 4 | Del |
      |    003 | OTHER   |          2 |  10000 |           |             |          | NA        | NA        | NA        | NA        |     |
    And BK charge is added detail as "<KEY BK>"
      | KEY BK | Charge To | Bank Charge | Ccy | Charge Amt |
      |    003 |           | BKCHARGE    | USD |          5 |

    Examples: 
      | KEY BK |
      |    001 |
      |    002 |
      |    003 |

  ###############################################################################
  ###############################################################################
  # ~~~~~~~~~~~~~~~~~~~~~~~~~~~~ OPENING BALANCE ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  Scenario Outline: C1. Create Accounts Payable with feature file
    Given user login the TH6 system
    When user navigates to "Opening Balance>Accounts Payable>[1]" screen
    And user create invoice ap as "<KEY OBAPINV>"
      | KEY OBAPINV | Supplier Code | Supplier Invoice No | Supplier Invoice Date | Posting Date | Due Date | Reference No | Currency | Exchange Rate | Total After Tax Amt | Total After Tax Home Amt | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |         001 | Sup01         |                     |                       |              |          |              | USD      |           1.5 |              150000 |                          | NA        | NA        | NA        | NA        |
    And user create credit note ap as "<KEY OBAPCRN>"
      | KEY OBAPCRN | Supplier Code | Supplier Credit Note No | Supplier Credit Note Date | Posting Date | Reference No | Credit Note Category | Credit Note Justification | Currency | Exchange Rate | Total After Tax Amt | Total After Tax Home Amt | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |         001 | SUP01         |                         |                           |              |              |                      |                           | USD      |           1.5 |              140000 |                          | NA        | na        | na        | na        |

    Examples: 
      | KEY OBAPINV | KEY OBAPCRN |
      |         001 |         001 |

  Scenario Outline: C2. Create Accounts Receivable with feature file
    Given user login the TH6 system
    When user navigates to "Opening Balance>Accounts Receivable>[2]" screen
    And user create invoice ar as "<KEY OBARINV>"
      | KEY OBARINV | Customer Code | Invoice Date | Due Date | Sales Person | Reference No | Currency | Exchange Rate | Total After Tax Amt | Total After Tax Home Amt | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |         001 | CUS01         |              |          |              |              | SGD      |             1 |              100000 |                          | na        | na        | na        | na        |
    And user create credit note ar as "<KEY OBARCRN>"
      | KEY OBARCRN | Customer Code | Credit Note Date | Sales Person | Reference No | Credit Note Category | Credit Note Justification | Currency | Exchange Rate | Total After Tax Amt | Total After Tax Home Amt | Remarks To Customer | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |         001 | cus01         |                  |              |        12345 |                      |                           | SGD      |             1 |              130000 |                          |                     | na        | na        | na        | na        |

    Examples: 
      | KEY OBARINV | KEY OBARCRN |
      |         001 |         001 |

  Scenario Outline: C3. Create Fixed Asset for Opening Balance with feature file
    Given user login the TH6 system
    And user navigates to "Opening Balance>Fixed Asset" screen
    When user create fixed asset for opening balance as "<KEY OBFA>"
      | KEY OBFA | Voucher No. | Fixed Asset Code | Transaction Date | Supplier | Supplier Invoice No | Supplier Invoice Date | Subject | Description | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |      001 |             | SGPLANT          |                  | Sup01    |                     |                       |         | testing     | na        | na        | na        | na        |
      |      002 |             | SGMOTOR          |                  | Sup01    |                     |                       |         | testing     | na        | na        | na        | na        |
    And fixed asset for opening balance is added detail as "<KEY OBFA>"
      | KEY OBFA | Serial No | Location | Asset Cost | Residual Value | Last Depreciation Date | No of Depreciation | Remaining Useful Life | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |      001 | A0001     | SG       |      10000 |                |                        |                  5 |                       | na        | na        | na        | na        |
      |      001 | A0002     | SG       |      20000 |                |                        |                 10 |                       | na        | na        | na        | na        |
      |      001 | A0003     | SG       |      30000 |                |                        |                 15 |                       | na        | na        | na        | na        |
      |      001 | A0004     | SG       |      10000 |                |                        |                 20 |                       | na        | na        | na        | na        |
      |      001 | A0005     | SG       |      20000 |                |                        |                 25 |                       | na        | na        | na        | na        |
      |      001 | A0006     | SG       |      30000 |                |                        |                 30 |                       | na        | na        | na        | na        |
      |      002 | B0001     | SG       |      10000 |                |                        |                  1 |                       | na        | na        | na        | na        |
      |      002 | B0002     | SG       |      20000 |                |                        |                  6 |                       | na        | na        | na        | na        |
      |      002 | B0003     | SG       |      30000 |                |                        |                  5 |                       | na        | na        | na        | na        |
      |      002 | B0004     | SG       |      10000 |                |                        |                  6 |                       | na        | na        | na        | na        |
      |      002 | B0005     | SG       |      20000 |                |                        |                  5 |                       | na        | na        | na        | na        |
      |      002 | B0006     | SG       |      30000 |                |                        |                 12 |                       | na        | na        | na        | na        |
    And fixed asset for opening balance is updated

    Examples: 
      | KEY OBFA |
      |      001 |
      |      002 |

  ###############################################################################
  ###############################################################################
  # ~~~~~~~~~~~~~~~~~~~~~~~~~~~~ PROCESSING ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  #
  #
  ################################### AP #####################################
  Scenario Outline: D1. Create AP Invoice with feature file
    Given user login the TH6 system
    And user navigates to "Operations>Accounts Payable>AP Invoice" screen
    When user create AP invoice as "<KEY AP INV>"
      | KEY AP INV | Voucher No. | Supplier | Currency | Exch Rate | Posting Date | Supplier Invoice No | Disc Date | Supplier DO No. | Bill Of Lading No. | Custom Tax Invoice | Sales Tax | Due Date | Supplier Invoice Date | Default Discount % | Supplier DO Date | Import Permit No | Reference No. | Inventory Location | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |        001 | INV01       | INTERCO  | SGD      |         1 |              |                     |           |                 |                    | No                 | GST0      |          |                       |                    |                  |                  |               |                    | SG        | SG        | D1        | NA        |
      |        002 | INV02       | SUP01    | SGD      |         1 |              |                     |           |                 |                    | No                 | GST7      |          |                       |                    |                  |                  |               |                    | VN        | NA        | NA        | NA        |
      |        003 | INV03       | SUP02    | USD      |       1.5 |              |                     |           |                 |                    | No                 | GST7      |          |                       |                    |                  |                  |               |                    | VN        | NA        | NA        | NA        |
    And AP invoice is added payment information as "<KEY AP INV>"
      | KEY AP INV | Payment Option | Payment Term | Payment Term Tenor | Payment Method | Payment Amount | Payment Party | Payment Address | Payment Contact |
      |        001 |                |              |                  1 |                |                |               |                 |                 |
      |        002 |                |              |                  2 |                |                |               |                 |                 |
      |        003 |                |              |                  3 |                |                |               |                 |                 |
    And AP invoice is added detail header as "<KEY AP INV>"
      | KEY AP INV | Type | Item Code/Remarks | Qty UOM | Pack Size | Cost Type | Discount %/ | Total Amt | Sales Tax | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |        001 | S    | PRODUCTION        |       1 |           |       500 |          10 |           | gst0      | SG        | SG        | D1        | RA        |
      |        001 | S    | OTHER             |       1 |           |        20 |             |           | gst0      | SG        | SG        | D1        | LR        |
      |        001 | S    | OTHER             |       1 |           |        20 |             |           | gst0      | SG        | SG        | D1        | TR        |
      |        001 | S    | OTHER             |       1 |           |        20 |             |           | gst0      | SG        | SG        | D1        | SA        |
      |        001 | S    | OTHER             |       2 |           |        20 |             |           | gst0      | SG        | SG        | D1        | NA        |
      |        002 | F    | MACHINE           |       1 |           |      1000 |             |           | gst0      | VN        | HN        | D1        | NA        |
      |        002 | F    | MOTOR             |       2 |           |       240 |             |           | gst10     | VN        | HN        | D2        | NA        |
      |        002 | S    | OTHER             |       1 |           |        20 |             |           | gst7      | VN        | HCM       | D1        | NA        |
      |        003 | S    | PRODUCTION        |       1 |           |       500 |             |           | gst7      | NA        | NA        | D2        | NA        |
      |        003 | S    | PRODUCTION        |       2 |           |       500 |             |           | gst7      | NA        | NA        | D3        | NA        |
    And AP invoice is submitted
    And user navigates to "Operations>Fixed Asset>Holding" screen
    When user submit FA holding as "<KEY>"
      | KEY | Asset Voucher No | Source Voucher No | Create AP CN |
      | 001 | HOL01            | INV02             | y            |
    And FA Holding is submitted

    Examples: 
      | KEY AP INV |
      |        001 |
      |        002 |
      |        003 |
      |        004 |
      |        005 |

  Scenario Outline: D2. Create AP Credit Note with feature file
    Given user login the TH6 system
    And user navigates to "Operations>Accounts Payable>AP Invoice" screen
    When user create AP invoice as "<KEY AP INV>"
      | KEY AP INV | Voucher No. | Supplier | Currency | Exch Rate | Posting Date | Supplier Invoice No | Disc Date | Supplier DO No. | Bill Of Lading No. | Custom Tax Invoice | Sales Tax | Due Date | Supplier Invoice Date | Default Discount % | Supplier DO Date | Import Permit No | Reference No. | Inventory Location | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |        001 | INV01       | SUP01    | SGD      |         1 |              |                     |           |                 |                    | No                 | GST0      |          |                       |                    |                  |                  |               |                    | NA        | NA        | NA        | NA        |
      |        002 | INV02       | SUP02    | USD      |       1.5 |              |                     |           |                 |                    | No                 | GST0      |          |                       |                    |                  |                  |               |                    | NA        | NA        | NA        | NA        |
    And AP invoice is added payment information as "<KEY AP INV>"
      | KEY AP INV | Payment Option | Payment Term | Payment Term Tenor | Payment Method | Payment Amount | Payment Party | Payment Address | Payment Contact |
      |        001 |                |              |                  1 |                |                |               |                 |                 |
      |        002 |                |              |                  2 |                |                |               |                 |                 |
    And AP invoice is added detail header as "<KEY AP INV>"
      | KEY AP INV | Type | Item Code/Remarks | Qty UOM | Pack Size | Cost Type | Discount %/ | Total Amt | Sales Tax | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |        001 | S    | OTHER             |       1 |           |       500 |             |           | gst0      | NA        | NA        | NA        | NA        |
      |        002 | S    | OTHER             |      10 |           |        20 |             |           | gst0      | NA        | NA        | NA        | NA        |
    And AP invoice is submitted
    And user navigates to "Operations>Accounts Payable>AP Credit Note" screen
    When user create AP credit note as "<KEY AP CRN>"
      | KEY AP CRN | Crn No. | Supplier | Currency | Exch Rate | Posting Date | Supplier Credit Note No | Credit Note Category | Sales Tax | Location | Supplier Credit Note Date | Default Disc % | Reference No. | Credit Note Justification | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |        001 | CRN01   | SUP01    | SGD      |         1 |              |                         |                      | GST7      |          |                           |                |               |                           | VN        | HN        | NA        | NA        |
      |        002 | CRN02   | SUP02    | USD      |      1.51 |              |                         |                      | GST0      |          |                           |                |               |                           | SG        | SG        | D1        | NA        |
    And AP credit note is added detail as "<KEY AP CRN>"
      | KEY AP CRN | LI No. | Type | Item Code  | Remarks Description | Qty UOM | Pack Size No. Of Packs | Cost Type | Unit Cost | Discount % | Amount | Sales tax | Segment 1 | Segment 2 | Segment 3 | Segment 4 | Serial No | Delete | Del |
      |        001 |      1 | S    | PRODUCTION |                     |       5 |                        |           |       100 |            |        | GST7      | VN        | HN        | D1        | RA        |           |        |     |
      |        001 |      2 | S    | OTHER      |                     |       5 |                        |           |        20 |            |        | GST0      | VN        | HN        | D2        | LR        |           |        |     |
      |        002 |      1 | S    | OTHER      |                     |       1 |                        |           |       200 |            |        | GST0      | SG        | SG        | D1        | NA        |           |        |     |
    And AP credit note is applied as "<KEY AP CRN>"
      | KEY AP CRN | Inv No. | Sup Inv No | Inv Date | Due Date | Inv Ccy Ref No. | Apld Crn Amt | Apld Inv Amt | Apld Crn Home Amt | Apld Inv Home Amt | Cross Rate Realized Exch | Apply Full |
      |        002 | INV02   |            |          |          |                 |          200 |          200 |               302 |               300 |                          |            |
    And preview AP credit note
    And submit AP credit note
    And AP credit note is applied in outstanding tab as "<KEY AP CRN>"
      | KEY AP CRN | Crn No. | Application Date |
      |        001 | CRN01   |                  |
    And AP credit note is applied as "<KEY AP CRN>"
      | KEY AP CRN | Inv No. | Sup Inv No | Inv Date | Due Date | Inv Ccy Ref No. | Apld Crn Amt Home Amt | Apld Inv Amt Home Amt | Cross Rate Realized Exch | Apply Full |
      |        001 | INV01   |            |          |          |                 |                   500 |                   500 |                          |            |
    And submit AP credit note

    Examples: 
      | KEY AP CRN |
      |        001 |

  Scenario Outline: D3. Create AP Payment with feature file
    Given user login the TH6 system
    And user navigates to "Operations>Accounts Payable>AP Invoice" screen
    When user create AP invoice as "<KEY AP INV>"
      | KEY AP INV | Voucher No. | Supplier | Currency | Exch Rate | Posting Date | Supplier Invoice No | Disc Date | Supplier DO No. | Bill Of Lading No. | Custom Tax Invoice | Sales Tax | Due Date | Supplier Invoice Date | Default Discount % | Supplier DO Date | Import Permit No | Reference No. | Inventory Location | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |        001 | INV01       | SUP01    | SGD      |         1 |              |                     |           |                 |                    | No                 | GST0      |          |                       |                    |                  |                  |               |                    | NA        | NA        | NA        | NA        |
      |        002 | INV02       | SUP02    | USD      |       1.5 |              |                     |           |                 |                    | No                 | GST0      |          |                       |                    |                  |                  |               |                    | NA        | NA        | NA        | NA        |
    And AP invoice is added payment information as "<KEY AP INV>"
      | KEY AP INV | Payment Option | Payment Term | Payment Term Tenor | Payment Method | Payment Amount | Payment Party | Payment Address | Payment Contact |
      |        001 |                |              |                  1 |                |                |               |                 |                 |
      |        002 |                |              |                  2 |                |                |               |                 |                 |
    And AP invoice is added detail header as "<KEY AP INV>"
      | KEY AP INV | Type | Item Code/Remarks | Qty UOM | Pack Size | Cost Type | Discount %/ | Total Amt | Sales Tax | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |        001 | S    | OTHER             |       1 |           |       500 |             |           | gst0      | NA        | NA        | NA        | NA        |
      |        002 | S    | OTHER             |      10 |           |        20 |             |           | gst0      | NA        | NA        | NA        | NA        |
    And AP invoice is submitted
    And user navigates to "Operations>Accounts Payable>Payment" screen
    When user create AP payment as "<KEY PAYMENT>"
      | KEY PAYMENT | Payment Voucher Number | Supplier | Payment Voucher Date | Bank Party Code | Bank Account No | Cheque Date | Cheque No. | Bank Draft No | Payee Name | Exchange Rate | Cheque Amount | Ref No. | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |         001 | PAY01                  | SUP01    |                      | DBS             | DBSSGD          |             | CQ0001     |               | Rachel     |             1 |          1000 |         | SG        | SG        | D1        | RA        |
      |         002 | PAY02                  | SUP02    |                      | DBS             | DBSUSD          |             | CQ0002     |               | Laura      |          1.49 |           200 |         | VN        | HN        | D1        | LR        |
    And AP payment is applied as "<KEY PAYMENT>"
      | KEY PAYMENT | Inv No. | Sup Inv No | Chq Amt Home Amt | Inv Amt Home Amt | Cross Rate Realized Exch | Apply Full |
      |         001 | INV01   |            |              500 |              500 |                        1 |            |
    And AP payment is previewed with report name "Standard Payment Voucher"
    And AP payment is previewed with report name "Standard Payment Advice"
    And AP payment is submitted
    And AP payment is applied at outstanding tab as "<KEY PAYMENT>"
      | KEY PAYMENT | Pymt Vch No | Application Date |
      |         002 |             |                  |
    And AP payment is applied as "<KEY PAYMENT>"
      | KEY PAYMENT | Inv No. | Sup Inv No | Chq Amt Home Amt | Inv Amt Home Amt | Cross Rate Realized Exch | Apply Full | Amt to Pay in Inv Ccy |
      |         002 | INV02   |            |              200 |              200 |                          |            |                       |
    And AP payment is previewed at history tab with report name "Standard Payment Voucher"
    And AP payment is previewed at history tab with report name "Standard Payment Advice"

    Examples: 
      | KEY PAYMENT |
      |         001 |
      |         002 |

  Scenario Outline: D3.1. Create AP Payment Cancellation with feature file
    Given user login the TH6 system
    And user navigates to "Operations>Accounts Payable>AP Invoice" screen
    When user create AP invoice as "<KEY AP INV>"
      | KEY AP INV | Voucher No. | Supplier | Currency | Exch Rate | Posting Date | Supplier Invoice No | Disc Date | Supplier DO No. | Bill Of Lading No. | Custom Tax Invoice | Sales Tax | Due Date | Supplier Invoice Date | Default Discount % | Supplier DO Date | Import Permit No | Reference No. | Inventory Location | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |        001 | INV01       | SUP01    | SGD      |         1 |              |                     |           |                 |                    | No                 | GST0      |          |                       |                    |                  |                  |               |                    | NA        | NA        | NA        | NA        |
      |        002 | INV02       | SUP01    | SGD      |         1 |              |                     |           |                 |                    | No                 | GST0      |          |                       |                    |                  |                  |               |                    | NA        | NA        | NA        | NA        |
      |        003 | INV03       | SUP02    | USD      |       1.5 |              |                     |           |                 |                    | No                 | GST0      |          |                       |                    |                  |                  |               |                    | NA        | NA        | NA        | NA        |
    And AP invoice is added payment information as "<KEY AP INV>"
      | KEY AP INV | Payment Option | Payment Term | Payment Term Tenor | Payment Method | Payment Amount | Payment Party | Payment Address | Payment Contact |
      |        001 |                |              |                  1 |                |                |               |                 |                 |
      |        002 |                |              |                  2 |                |                |               |                 |                 |
      |        003 |                |              |                  3 |                |                |               |                 |                 |
    And AP invoice is added detail header as "<KEY AP INV>"
      | KEY AP INV | Type | Item Code/Remarks | Qty UOM | Pack Size | Cost Type | Discount %/ | Total Amt | Sales Tax | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |        001 | S    | OTHER             |       1 |           |       500 |             |           | gst0      | NA        | NA        | NA        | NA        |
      |        002 | S    | OTHER             |       1 |           |        20 |             |           | gst0      | NA        | NA        | NA        | NA        |
      |        003 | S    | OTHER             |       1 |           |       200 |             |           | gst0      | NA        | NA        | NA        | NA        |
    And AP invoice is submitted
    And user navigates to "Operations>Accounts Payable>Payment" screen
    When user create AP payment as "<KEY PAYMENT>"
      | KEY PAYMENT | Payment Voucher Number | Supplier | Payment Voucher Date | Bank Party Code | Bank Account No | Cheque Date | Cheque No. | Bank Draft No | Payee Name | Exchange Rate | Cheque Amount | Ref No. | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |         001 | PAY01                  | SUP01    |                      | DBS             | DBSSGD          |             | CQ0001     |               | Rachel     |             1 |          1000 |         | SG        | SG        | D1        | RA        |
      |         002 | PAY02                  | SUP02    |                      | DBS             | DBSUSD          |             | CQ0002     |               | Laura      |          1.49 |           200 |         | VN        | HN        | D1        | LR        |
    And AP payment is applied as "<KEY PAYMENT>"
      | KEY PAYMENT | Inv No. | Sup Inv No | Chq Amt Home Amt | Inv Amt Home Amt | Cross Rate Realized Exch | Apply Full |
      |         001 | INV01   |            |              500 |              500 |                        1 |            |
      |         001 | INV02   |            |               20 |               20 |                          |            |
      |         002 | INV03   |            |              200 |              200 |                          | Y          |
    And AP payment is submitted
    And user navigates to "Operations>Accounts Payable>Payment Cancellation" screen
    When user create AP payment cancellation as "<KEY>"
      | KEY | Payment Voucher Number | Supplier | Payment Voucher No | Cancellation Type |
      | 001 | PYC01                  | SUP01    | PAY01              | Wrong Application |
      | 002 | PYC02                  | SUP02    | PAY02              | Void Cheque       |
    And user keyin AP Payment Application cancellation detail as "<KEY>"
      | KEY | Inv No |
      | 001 | INV01  |
    And AP Payment cancellation is submitted

    Examples: 
      | KEY |
      | 001 |
      | 002 |

  Scenario Outline: D4. Create AP Payment Suggestion with feature file
    Given user login the TH6 system
    And user navigates to "Operations>Accounts Payable>AP Invoice" screen
    When user create AP invoice as "<KEY AP INV>"
      | KEY AP INV | Voucher No. | Supplier | Currency | Exch Rate | Posting Date | Supplier Invoice No | Disc Date | Supplier DO No. | Bill Of Lading No. | Custom Tax Invoice | Sales Tax | Due Date | Supplier Invoice Date | Default Discount % | Supplier DO Date | Import Permit No | Reference No. | Inventory Location | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |        001 | INV01       | SUP01    | SGD      |         1 |              |                     |           |                 |                    | No                 | GST0      |          |                       |                    |                  |                  |               |                    | NA        | NA        | NA        | NA        |
      |        002 | INV02       | SUP02    | USD      |       1.5 |              |                     |           |                 |                    | No                 | GST0      |          |                       |                    |                  |                  |               |                    | NA        | NA        | NA        | NA        |
      |        002 | INV03       | SUP02    | SGD      |         1 |              |                     |           |                 |                    | No                 | GST0      |          |                       |                    |                  |                  |               |                    | NA        | NA        | NA        | NA        |
    And AP invoice is added payment information as "<KEY AP INV>"
      | KEY AP INV | Payment Option | Payment Term | Payment Term Tenor | Payment Method | Payment Amount | Payment Party | Payment Address | Payment Contact |
      |        001 |                |              |                  1 |                |                |               |                 |                 |
      |        002 |                |              |                  2 |                |                |               |                 |                 |
      |        003 |                |              |                  3 |                |                |               |                 |                 |
    And AP invoice is added detail header as "<KEY AP INV>"
      | KEY AP INV | Type | Item Code/Remarks | Qty UOM | Pack Size | Cost Type | Discount %/ | Total Amt | Sales Tax | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |        001 | S    | OTHER             |       1 |           |       500 |             |           | gst0      | NA        | NA        | NA        | NA        |
      |        002 | S    | OTHER             |       1 |           |       200 |             |           | gst0      | NA        | NA        | NA        | NA        |
      |        003 | S    | OTHER             |       1 |           |       500 |             |           | gst0      | NA        | NA        | NA        | NA        |
    And AP invoice is submitted
    And user navigates to "Operations>Accounts Payable>Payment Suggestion" screen
    When user create AP payment suggestion as "<KEY PYT S>"
      | KEY PYT S | Bank Party Code | Bank Account No | Select Supplier | Supplier Class From | Currency From | Invoice Date From | Due Date From | Grace Period | Exch Rate | Include Non Overdue | Supplier Class To | Currency To | Invoice Date To | Due Date To |
      |       001 | DBS             | DBSSGD          |                 |                     |               |                   |               |              |           | Yes                 |                   |             |                 |             |
    And AP payment suggestion is submitted with detail invoice as "<KEY PYT S>"
      | KEY PYT S | Supplier | Supplier Invoice No. | Supplier Invoice Date | Invoice No. | Invoice Date | Due Date | Ccy |
      |       001 | SUP01    |                      |                       | INV01       |              |          | SGD |
      |       001 | SUP02    |                      |                       | INV02       |              |          | USD |
      |       001 | SUP02    |                      |                       | INV03       |              |          | SGD |

    Examples: 
      | KEY PYT S |
      |       001 |

  Scenario Outline: D5. Create AP Payment Matching Custom Tax Invoice with feature file
    And user navigates to "Operations>Accounts Payable>AP Invoice" screen
    When user create AP invoice as "<KEY AP INV>"
      | KEY AP INV | Voucher No. | Supplier | Currency | Exch Rate | Posting Date | Supplier Invoice No | Disc Date | Supplier DO No. | Bill Of Lading No. | Custom Tax Invoice | Sales Tax | Due Date | Supplier Invoice Date | Default Discount % | Supplier DO Date | Import Permit No | Reference No. | Inventory Location | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |        001 | INV01       | SUP01    | SGD      |         1 |              |                     |           |                 | BOL01              | Y                  | CUSTOM    |          |                       |                    |                  |                  |               |                    | NA        | NA        | NA        | NA        |
      |        002 | INV02       | SUP01    | USD      |       1.5 |              |                     |           |                 | BOL01              | Y                  | CUSTOM    |          |                       |                    |                  |                  |               |                    | NA        | NA        | NA        | NA        |
    And AP invoice is added payment information as "<KEY AP INV>"
      | KEY AP INV | Payment Option | Payment Term | Payment Term Tenor | Payment Method | Payment Amount | Payment Party | Payment Address | Payment Contact |
      |        001 |                |              |                  1 |                |                |               |                 |                 |
      |        002 |                |              |                  2 |                |                |               |                 |                 |
    And AP invoice is added detail header as "<KEY AP INV>"
      | KEY AP INV | Type | Item Code/Remarks | Qty UOM | Pack Size | Cost Type | Discount %/ | Total Amt | Sales Tax | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |        001 | S    | OTHER             |       1 |           |         5 |             |           | CUSTOM    | NA        | NA        | NA        | NA        |
      |        002 | S    | OTHER             |       1 |           |        20 |             |           | CUSTOM    | NA        | NA        | NA        | NA        |
    And AP invoice is submitted
    Given user login the TH6 system
    And user navigates to "Operations>Accounts Payable>Matching Custom Tax Invoice" screen
    When user create AP payment matching custom tax invoice as "<KEY>"
      | KEY | Custom Tax Invoice No | Bill Of Lading No. |
      | 001 | INV01                 | BOL01              |
    And AP payment matching custom tax invoice is added all invoice

    Examples: 
      | KEY |
      | 001 |

  # ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  #
  ###################################### AR #####################################
  Scenario Outline: D6. User create AR Invoice with Feature file
    Given user login the TH6 system
    And user navigates to "Operations>Accounts Receivable>AR Invoice" screen
    When user create ar invoice as "<KEY>"
      | KEY | Inv No | Customer | Invoice Date | Due Date | Ref No | Currency | Exchange Rate | Default Sales Tax | Sales Person | Default Disc % | Customer PO No | Location | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 001 | INV01  | CUS01    |              |          |      1 | SGD      |             1 | GST7              |              |                |                | SG       | SG        | SG        | D1        | NA        |
      | 002 | INV02  | CUS02    |              |          |      2 | SGD      |             1 | GST7              |              |                |                | SG       | VN        | NA        | NA        | NA        |
      | 003 | INV03  | INTERCO  |              |          |      3 | USD      |           1.5 | GST0              |              |                |                | SG       | VN        | NA        | NA        | NA        |
    And user add billing AR invoice as "<KEY>"
      | KEY | LI No | Type | Item Code/Remarks Description | Qty UOM | No Of Packs Pack Size | Unit Price Price Type | Disc % | Amount | Total Amt | Sales Tax | Serial No | Segment 1 | Segment 2 | Segment 3 | Segment 4 | Delete | Check Del |
      | 001 |       | s    | PRODUCTION                    |       2 |                       |                  1500 |     10 |        |           | gst7      |           | SG        | SG        | D1        | RA        |        |           |
      | 001 |       | s    | OTHER                         |       1 |                       |                    20 |        |        |           | gst0      |           | SG        | SG        | D1        | LR        |        |           |
      | 001 |       | s    | OTHER                         |       1 |                       |                    20 |        |        |           | gst0      |           | SG        | SG        | D1        | TR        |        |           |
      | 001 |       | s    | OTHER                         |       2 |                       |                    25 |        |        |           | gst10     |           | SG        | SG        | D1        | SA        |        |           |
      | 002 |       | s    | OTHER                         |       1 |                       |                    25 |        |        |           | gst7      |           | VN        | NA        | NA        | NA        |        |           |
      | 003 |       | s    | OTHER                         |       1 |                       |                    16 |        |        |           | gst0      |           | VN        | NA        | NA        | NA        |        |           |
    And user creat payment information ar invoice as "<KEY>"
      | KEY | Payment Option | Payment Term | Payment Term Tenor |
      | 001 |                |              |                  1 |
      | 002 |                |              |                  2 |
      | 003 |                |              |                  3 |
    And ar invoice is previewed with report name as "Standard AR Invoice Format"
    And user submit ar invoice
    And ar invoice is previewed at history tab with report name as "Standard AR Invoice Format"

    Examples: 
      | KEY |
      | 001 |
      | 002 |
      | 003 |

  Scenario Outline: D7. User create AR Credit Note with Feature file
    Given user login the TH6 system
    And user navigates to "Operations>Accounts Receivable>AR Invoice" screen
    When user create ar invoice as "<KEY>"
      | KEY | Inv No | Customer | Invoice Date | Due Date | Ref No | Currency | Exchange Rate | Default Sales Tax | Sales Person | Default Disc % | Customer PO No | Location | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 001 | INV01  | CUS01    |              |          |      1 | SGD      |             1 | GST0              |              |                |                | SG       | NA        | NA        | NA        | NA        |
      | 002 | INV02  | CUS02    |              |          |      2 | USD      |           1.5 | GST0              |              |                |                | SG       | NA        | NA        | NA        | NA        |
    And user add billing AR invoice as "<KEY>"
      | KEY | LI No | Type | Item Code/Remarks Description | Qty UOM | No Of Packs Pack Size | Unit Price Price Type | Disc % | Amount | Total Amt | Sales Tax | Serial No | Segment 1 | Segment 2 | Segment 3 | Segment 4 | Delete | Check Del |
      | 001 |       | s    | PRODUCTION                    |       1 |                       |                  1000 |        |        |           | GST0      |           | NA        | NA        | NA        | NA        |        |           |
      | 001 |       | s    | OTHER                         |       1 |                       |                    20 |        |        |           | GST0      |           | NA        | NA        | NA        | NA        |        |           |
    And user creat payment information ar invoice as "<KEY>"
      | KEY | Payment Option | Payment Term | Payment Term Tenor |
      | 001 |                |              |                  1 |
      | 002 |                |              |                  2 |
    And user submit ar invoice
    And user navigates to "Operations>Accounts Receivable>AR Credit Note" screen
    When user create AR credit note as "<KEY>"
      | KEY | Crn No. | Customer | Billing Party | Credit Note Date | Ref No. | Customer PO No. | Currency | Exchange Rate | Default Sales Tax | Payment Option | Billing Contact | Default Disc % | Location | Sales Person | Billing Address | Credit Note Category | Credit Note Justification | Remarks To Customer | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 001 | CRN01   | CUS01    |               |                  |         |                 | SGD      |             1 | GST7              |                |                 |                |          |              |                 |                      |                           |                     | SG        | SG        | NA        | NA        |
      | 002 | CRN02   | CUS01    |               |                  |         |                 | SGD      |             1 | GST0              |                |                 |                |          |              |                 |                      |                           |                     | SG        | SG        | D1        | NA        |
      | 003 | CRN03   | CUS02    |               |                  |         |                 | USD      |          1.49 | GST7              |                |                 |                |          |              |                 |                      |                           |                     | VN        | NA        | NA        | NA        |
    And AR credit note is added billing detail as "<KEY>"
      | KEY | Type | Item Code  | Remarks Description | Qty UOM | Pack Size No. Of Packs | Price Type | Unit Price | Discount % | Amount | Sales Tax | Segment 1 | Segment 2 | Segment 3 | Segment 4 | Delete |
      | 001 | S    | PRODUCTION |                     |       2 |                        |            |        500 |         10 |        | GST7      | SG        | SG        | D1        | RA        |        |
      | 001 | S    | OTHER      |                     |       1 |                        |            |         25 |            |        | GST0      | SG        | SG        | D2        | LR        |        |
      | 001 | S    | OTHER      |                     |       1 |                        |            |         25 |            |        | GST0      | SG        | SG        | D1        | TR        |        |
      | 002 | S    | OTHER      |                     |       1 |                        |            |        100 |            |        | GST7      | VN        | HN        | NA        | NA        |        |
      | 003 | S    | OTHER      |                     |       1 |                        |            |         25 |            |        | GST0      | VN        | HCM       | NA        | NA        |        |
    And AR credit note is applied as "<KEY>"
      | KEY | Inv No. | Src Inv No | Invoice Date | Due Date | Inv Ccy | Ref No. | d Crn Amt Home Amt | d Inv Amt Home Amt | Apply Full |
      | 001 | INV01   |            |              |          |         |         |                900 |                900 |            |
      | 003 | INV02   |            |              |          |         |         |                 20 |                 20 |            |
    And AR credit note is previewed with report name "Standard AR Credit Note"
    And AR credit note is submitted
    And AR credit note is applied at outstanding tab as "<KEY>"
      | KEY | Crn No. | Application Date |
      | 002 | CRN02   |                  |
    And AR credit note is applied as "<KEY>"
      | KEY | Inv No. | Src Inv No | Invoice Date | Due Date | Inv Ccy | Ref No. | d Crn Amt Home Amt | d Inv Amt Home Amt | Apply Full |
      | 002 | INV01   |            |              |          |         |         |                100 |                    |            |
    And AR credit note is submitted
    And AR credit note is preview at history tab with report name "Standard AR Credit Note"

    Examples: 
      | KEY |
      | 001 |
      | 002 |
      | 003 |

  Scenario Outline: D8. User create AR Receipt with Feature file
    Given user login the TH6 system
    And user navigates to "Operations>Accounts Receivable>AR Invoice" screen
    When user create ar invoice as "<KEY>"
      | KEY | Inv No | Customer | Invoice Date | Due Date | Ref No | Currency | Exchange Rate | Default Sales Tax | Sales Person | Default Disc % | Customer PO No | Location | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 001 | INV01  | CUS01    |              |          |      1 | SGD      |             1 | GST0              |              |                |                | SG       | NA        | NA        | NA        | NA        |
      | 002 | INV02  | CUS02    |              |          |      2 | USD      |           1.5 | GST0              |              |                |                | SG       | NA        | NA        | NA        | NA        |
    And user add billing AR invoice as "<KEY>"
      | KEY | LI No | Type | Item Code/Remarks Description | Qty UOM | No Of Packs Pack Size | Unit Price Price Type | Disc % | Amount | Total Amt | Sales Tax | Serial No | Segment 1 | Segment 2 | Segment 3 | Segment 4 | Delete | Check Del |
      | 001 |       | s    | PRODUCTION                    |       1 |                       |                  1000 |        |        |           | GST0      |           | NA        | NA        | NA        | NA        |        |           |
      | 001 |       | s    | OTHER                         |       1 |                       |                    20 |        |        |           | GST0      |           | NA        | NA        | NA        | NA        |        |           |
    And user creat payment information ar invoice as "<KEY>"
      | KEY | Payment Option | Payment Term | Payment Term Tenor |
      | 001 |                |              |                  1 |
      | 002 |                |              |                  2 |
    And user submit ar invoice
    And user navigates to "Operations>Accounts Receivable>Receipt" screen
    When user create AR receipt as "<KEY>"
      | KEY | Receipt No. | Customer | Receipt Date | Receipt Currency | Exchange Rate | Reference No. | Bank Draft No | Deposit Slip No | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 001 | REC01       | CUS01    |              | SGD              |             1 |           123 |               |                 | na        | na        | na        | na        |
      | 002 | REC02       | CUS02    |              | USD              |          1.49 |           321 |               |                 | na        | na        | na        | na        |
    And AR receipt is added payment detail as "<KEY>"
      | KEY | Bank Party Code | Bank Account No | Pymt Method | Cheque No. | Cheque Date | Customer Bank | Card Type | Instmt Code Instmt Desc | Pymt Amt | Tendered Amt |
      | 001 | OCBC            | OCBCSGD         |             |            |             |               |           |                         |     1000 |              |
      | 002 | OCBC            | OCBCSGD         |             |            |             |               |           |                         |       20 |              |
    And AR receipt is applied as "<KEY>"
      | KEY | Inv No. | Inv Date | Due Date | Inv Ccy | Ref No. | d Rec Amt Home Amt | d Inv Amt Home Amt | Apply Full |
      | 001 | INV01   |          |          |         |         |               1000 |                    |            |
    And AR receipt is previewed with report name ""
    And AR receipt is submitted
    And AR receipt is applied at outstanding tab as "<KEY>"
      | KEY | Receipt No. | Application Date |
      | 002 |             |                  |
    And AR receipt is applied as "<KEY>"
      | KEY | Inv No. | Inv Date | Due Date | Inv Ccy | Ref No. | d Rec Amt Home Amt | d Inv Amt Home Amt | Apply Full |
      | 002 | INV02   |          |          |         |         |                 20 |                    |            |
    And AR receipt is submitted
    And AR receipt is preview at history tab with report name ""

    Examples: 
      | KEY |
      | 001 |
      | 002 |

  Scenario Outline: D9. User create AR Receipt Cancellation with Feature file
    Given user login the TH6 system
    And user navigates to "Operations>Accounts Receivable>AR Invoice" screen
    When user create ar invoice as "<KEY>"
      | KEY | Inv No | Customer | Invoice Date | Due Date | Ref No | Currency | Exchange Rate | Default Sales Tax | Sales Person | Default Disc % | Customer PO No | Location | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 001 | INV01  | CUS01    |              |          |      1 | SGD      |             1 | GST0              |              |                |                | SG       | NA        | NA        | NA        | NA        |
      | 002 | INV02  | CUS02    |              |          |      2 | USD      |           1.5 | GST0              |              |                |                | SG       | NA        | NA        | NA        | NA        |
    And user add billing AR invoice as "<KEY>"
      | KEY | LI No | Type | Item Code/Remarks Description | Qty UOM | No Of Packs Pack Size | Unit Price Price Type | Disc % | Amount | Total Amt | Sales Tax | Serial No | Segment 1 | Segment 2 | Segment 3 | Segment 4 | Delete | Check Del |
      | 001 |       | s    | PRODUCTION                    |       1 |                       |                  1000 |        |        |           | GST0      |           | NA        | NA        | NA        | NA        |        |           |
      | 001 |       | s    | OTHER                         |       1 |                       |                    20 |        |        |           | GST0      |           | NA        | NA        | NA        | NA        |        |           |
    And user creat payment information ar invoice as "<KEY>"
      | KEY | Payment Option | Payment Term | Payment Term Tenor |
      | 001 |                |              |                  1 |
      | 002 |                |              |                  2 |
    And user submit ar invoice
    And user navigates to "Operations>Accounts Receivable>Receipt" screen
    When user create AR receipt as "<KEY>"
      | KEY | Receipt No. | Customer | Receipt Date | Receipt Currency | Exchange Rate | Reference No. | Bank Draft No | Deposit Slip No | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 001 | REC01       | CUS01    |              | SGD              |             1 |           123 |               |                 | na        | na        | na        | na        |
      | 002 | REC02       | CUS02    |              | USD              |          1.49 |           321 |               |                 | na        | na        | na        | na        |
      | 003 | REC03       | INTERCO  |              | SGD              |             1 |           312 |               |                 | na        | na        | na        | na        |
    And AR receipt is added payment detail as "<KEY>"
      | KEY | Bank Party Code | Bank Account No | Pymt Method | Cheque No. | Cheque Date | Customer Bank | Card Type | Instmt Code Instmt Desc | Pymt Amt | Tendered Amt |
      | 001 | OCBC            | OCBCSGD         |             |            |             |               |           |                         |     1000 |              |
      | 002 | OCBC            | OCBCSGD         |             |            |             |               |           |                         |       20 |              |
      | 003 | OCBC            | OCBCSGD         |             |            |             |               |           |                         |      500 |              |
    And AR receipt is applied as "<KEY>"
      | KEY | Inv No. | Inv Date | Due Date | Inv Ccy | Ref No. | d Rec Amt Home Amt | d Inv Amt Home Amt | Apply Full |
      | 001 | INV01   |          |          |         |         |               1000 |                    |            |
    And AR receipt is previewed with report name ""
    And AR receipt is submitted
    And AR receipt is applied at outstanding tab as "<KEY>"
      | KEY | Receipt No. | Application Date |
      | 002 |             |                  |
    And AR receipt is applied as "<KEY>"
      | KEY | Inv No. | Inv Date | Due Date | Inv Ccy | Ref No. | d Rec Amt Home Amt | d Inv Amt Home Amt | Apply Full |
      | 002 | INV02   |          |          |         |         |                 20 |                    |            |
    And AR receipt is submitted
    And user navigates to "Operations>Accounts Receivable>Receipt Cancellation" screen
    When user create AR receipt cancellation as "<KEY>"
      | KEY | Receipt Cancellation No | Receipt Cancellation Date | Customer | Cheque No. | Receipt No | Cancellation Type            |
      | 001 | RCC01                   |                           | CUS01    |            | REC01      | Wrong Application to Invoice |
      | 002 | RCC02                   |                           | CUS02    |            | REC02      | Void Cheque                  |
      | 003 | RCC03                   |                           | INTERCO  |            | REC03      | Wrong Customer               |
    And AR receipt is wrong application to invoice as "<KEY>"
      | KEY | Inv No. |
      | 001 | INV01   |
    And AR receipt is wrong customer as "<KEY>"
      | KEY | New Customer |
      | 003 | Cus01        |
    And AR receipt cancellation is previewed with report name ""
    And AR receipt cancellation is submitted
    And AR receipt cancellation is preview at history tab with report name ""

    Examples: 
      | KEY |
      | 001 |
      | 002 |
      | 003 |

  Scenario Outline: D10. Create AP Payment To Customer with feature file
    Given user login the TH6 system
    And user navigates to "Operations>Accounts Receivable>AR Credit Note" screen
    When user create AR credit note as "<KEY>"
      | KEY | Crn No. | Customer | Billing Party | Credit Note Date | Ref No. | Customer PO No. | Currency | Exchange Rate | Default Sales Tax | Payment Option | Billing Contact | Default Disc % | Location | Sales Person | Billing Address | Credit Note Category | Credit Note Justification | Remarks To Customer | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 001 | CRN01   | CUS01    |               |                  |         |                 | SGD      |             1 | GST7              |                |                 |                |          |              |                 |                      |                           |                     | NA        | NA        | NA        | NA        |
      | 002 | CRN02   | CUS02    |               |                  |         |                 | USD      |           1.5 | GST0              |                |                 |                |          |              |                 |                      |                           |                     | NA        | NA        | NA        | NA        |
    And AR credit note is added billing detail as "<KEY>"
      | KEY | Type | Item Code | Remarks Description | Qty UOM | Pack Size No. Of Packs | Price Type | Unit Price | Discount % | Amount | Sales Tax | Segment 1 | Segment 2 | Segment 3 | Segment 4 | Delete |
      | 001 | S    | OTHER     |                     |       1 |                        |            |        100 |            |        | GST0      | NA        | NA        | NA        | NA        |        |
      | 002 | S    | OTHER     |                     |       1 |                        |            |         50 |            |        | GST0      | NA        | NA        | NA        | NA        |        |
    And AR credit note is submitted
    And user navigates to "Operations>Accounts Receivable>Receipt" screen
    When user create AR receipt as "<KEY>"
      | KEY | Receipt No. | Customer | Receipt Date | Receipt Currency | Exchange Rate | Reference No. | Bank Draft No | Deposit Slip No | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 001 | REC01       | CUS01    |              | SGD              |             1 |           123 |               |                 | NA        | NA        | NA        | NA        |
      | 002 | REC02       | CUS01    |              | USD              |           1.5 |           321 |               |                 | NA        | NA        | NA        | NA        |
    And AR receipt is added payment detail as "<KEY>"
      | KEY | Bank Party Code | Bank Account No | Pymt Method | Cheque No. | Cheque Date | Customer Bank | Card Type | Instmt Code Instmt Desc | Pymt Amt | Tendered Amt |
      | 001 | OCBC            | OCBCSGD         |             |            |             |               |           |                         |     1000 |              |
      | 002 | OCBC            | OCBCUSD         |             |            |             |               |           |                         |       20 |              |
    And AR receipt is submitted
    And user navigates to "Operations>Accounts Payable>Payment to Customer (Refund)" screen
    When user update AP payment to customer as "<KEY>"
      | KEY | Payment Voucher Number | Customer | Payment Voucher Date | Bank Party Code | Bank Account No | Cheque Date | Cheque No. | Bank Draft No | Payee Name | Exchange Rate | Cheque Amount | Ref No. | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 001 | PC01                   | CUS01    |                      | OCBC            | OCBCSGD         |             |            |               |            |             1 |          1200 |         | NA        | NA        | NA        | NA        |
      | 002 | PC02                   | CUS02    |                      | OCBC            | OCBCUSD         |             |            |               |            |          1.49 |            50 |         | NA        | NA        | NA        | NA        |
    And AP payment to customer is applied to receipt as "<KEY>"
      | KEY | Rcpt No | Rcpt Date | CCY | d Pymt Amt Home Amt | d Rec Amt Home Amt | Cross Rate Realized Exch |
      | 001 | REC01   |           |     |                1000 |                    |                          |
      | 001 | REC02   |           |     |                  31 |                    |                          |
    And AP payment to customer is applied to credit note as "<KEY>"
      | KEY | Crn No | Crn Date | Crn Ccy | Applied Chq Amt Home Amt | Applied Crn Amt Home Amt | Cross Rate Realized Exch |
      | 001 | CRN01  |          |         |                      100 |                          |                          |
      | 002 | CRN02  |          |         |                       50 |                          |                          |
    And AP payment to customer is previewed with report name "Standard Payment Voucher Refund"
    And AP payment to customer is submitted

    #And AP payment to customer is previewed at history tab with report name "Standard Payment Voucher Refund"
    Examples: 
      | KEY |
      | 001 |
      | 002 |

  # ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  #
  Scenario Outline: D11. Create AP Contra with feature file
    Given user login the TH6 system
    And user navigates to "Operations>Accounts Receivable>AR Invoice" screen
    When user create ar invoice as "<KEY>"
      | KEY | Inv No  | Customer | Invoice Date | Due Date | Ref No | Currency | Exchange Rate | Default Sales Tax | Sales Person | Default Disc % | Customer PO No | Location | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 001 | ARINV01 | INTERCO  |              |          |      1 | SGD      |             1 | GST0              |              |                |                | SG       | NA        | NA        | NA        | NA        |
      | 002 | ARINV02 | INTERCO  |              |          |      2 | USD      |          1.49 | GST0              |              |                |                | SG       | SG        | NA        | NA        | NA        |
    And user add billing AR invoice as "<KEY>"
      | KEY | LI No | Type | Item Code/Remarks Description | Qty UOM | No Of Packs Pack Size | Unit Price Price Type | Disc % | Amount | Total Amt | Sales Tax | Serial No | Segment 1 | Segment 2 | Segment 3 | Segment 4 | Delete | Check Del |
      | 001 |       | s    | PRODUCTION                    |       1 |                       |                   500 |        |        |           | GST0      |           | NA        | NA        | NA        | NA        |        |           |
      | 001 |       | s    | OTHER                         |       1 |                       |                    20 |        |        |           | GST0      |           | NA        | NA        | NA        | NA        |        |           |
    And user creat payment information ar invoice as "<KEY>"
      | KEY | Payment Option | Payment Term | Payment Term Tenor |
      | 001 |                |              |                  1 |
      | 002 |                |              |                  2 |
    And user submit ar invoice
    And user navigates to "Operations>Accounts Payable>AP Invoice" screen
    When user create AP invoice as "<KEY AP INV>"
      | KEY AP INV | Voucher No. | Supplier | Currency | Exch Rate | Posting Date | Supplier Invoice No | Disc Date | Supplier DO No. | Bill Of Lading No. | Custom Tax Invoice | Sales Tax | Due Date | Supplier Invoice Date | Default Discount % | Supplier DO Date | Import Permit No | Reference No. | Inventory Location | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |        001 | APINV01     | INTERCO  | SGD      |         1 |              |                     |           |                 |                    | No                 | GST0      |          |                       |                    |                  |                  |               |                    | NA        | NA        | NA        | NA        |
      |        002 | APINV02     | INTERCO  | USD      |      1.51 |              |                     |           |                 |                    | No                 | GST0      |          |                       |                    |                  |                  |               |                    | VN        | NA        | NA        | NA        |
    And AP invoice is added payment information as "<KEY AP INV>"
      | KEY AP INV | Payment Option | Payment Term | Payment Term Tenor | Payment Method | Payment Amount | Payment Party | Payment Address | Payment Contact |
      |        001 |                |              |                  1 |                |                |               |                 |                 |
      |        002 |                |              |                  2 |                |                |               |                 |                 |
    And AP invoice is added detail header as "<KEY AP INV>"
      | KEY AP INV | Type | Item Code/Remarks | Qty UOM | Pack Size | Cost Type | Discount %/ | Total Amt | Sales Tax | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |        001 | S    | OTHER             |       1 |           |       500 |             |           | gst0      | NA        | NA        | NA        | NA        |
      |        002 | S    | OTHER             |       1 |           |        20 |             |           | gst0      | NA        | NA        | NA        | NA        |
    And AP invoice is submitted
    And user navigates to "Operations>Accounts Payable>Contra" screen
    When user create AP contra as "<KEY>"
      | KEY | Contra Voucher No. | Party   |
      | 001 | CTR01              | INTERCO |
      | 002 | CTR02              | INTERCO |
    And AP contra is added info at header tab as "<KEY>"
      | KEY | Contra Voucher Date | Currency | Exch Rate - Buy Rate | Exch Rate - Sell Rate | Remarks Code | Remarks | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 001 | CTR01               | SGD      |                      |                       |              |         | NA        | NA        | NA        | NA        |
      | 001 | CTR02               | USD      |                      |                       |              |         | NA        | NA        | NA        | NA        |
    And AP contra is added info at AR invoice tab as "<KEY>"
      | KEY | Invoice No. | Invoice Date | Due Date | Inv Ccy Ref No. | d Inv Amt Home Amt | Apply Full |
      | 001 | ARINV01     |              |          |                 |                500 |            |
      | 002 | ARINV02     |              |          |                 |                 20 |            |
    And AP contra is added info at AP invoice tab as "<KEY>"
      | KEY | Inv No. | Sup Inv No | Age Date | Inv Ccy Ref No. | d Inv Amt Home Amt | Apply Full |
      | 001 | APINV01 |            |          |                 |                500 |            |
      | 002 | APINV02 |            |          |                 |                 20 |            |
    And AP contra is previewed with report name as ""
    And AP contra is submitted
    And AP contra is previewed history with report name as ""

    Examples: 
      | KEY |
      | 001 |
      | 002 |

  Scenario Outline: D12. Create AP Revaluation with Feature file
    Given user login the TH6 system
    And user navigates to "Operations>Accounts Payable>AP Invoice" screen
    When user create AP invoice as "<KEY AP INV>"
      | KEY AP INV | Voucher No. | Supplier | Currency | Exch Rate | Posting Date | Supplier Invoice No | Disc Date | Supplier DO No. | Bill Of Lading No. | Custom Tax Invoice | Sales Tax | Due Date | Supplier Invoice Date | Default Discount % | Supplier DO Date | Import Permit No | Reference No. | Inventory Location | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |        001 | INV01       | SUP01    | AUD      |       1.7 |              |                     |           |                 |                    | No                 | GST0      |          |                       |                    |                  |                  |               |                    | NA        | NA        | NA        | NA        |
      |        002 | INV02       | SUP02    | AUD      |      1.65 |              |                     |           |                 |                    | No                 | GST0      |          |                       |                    |                  |                  |               |                    | NA        | NA        | NA        | NA        |
    And AP invoice is added payment information as "<KEY AP INV>"
      | KEY AP INV | Payment Option | Payment Term | Payment Term Tenor | Payment Method | Payment Amount | Payment Party | Payment Address | Payment Contact |
      |        001 |                |              |                  1 |                |                |               |                 |                 |
      |        002 |                |              |                  2 |                |                |               |                 |                 |
    And AP invoice is added detail header as "<KEY AP INV>"
      | KEY AP INV | Type | Item Code/Remarks | Qty UOM | Pack Size | Cost Type | Discount %/ | Total Amt | Sales Tax | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |        001 | S    | OTHER             |       1 |           |       500 |             |           | GST0      | NA        | NA        | NA        | NA        |
      |        002 | S    | OTHER             |      10 |           |        20 |             |           | GST0      | NA        | NA        | NA        | NA        |
    And AP invoice is submitted
    And user navigates to "Operations>Accounts Payable>AP Credit Note" screen
    When user create AP credit note as "<KEY AP CRN>"
      | KEY AP CRN | Crn No. | Supplier | Currency | Exch Rate | Posting Date | Supplier Credit Note No | Credit Note Category | Sales Tax | Location | Supplier Credit Note Date | Default Disc % | Reference No. | Credit Note Justification | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |        001 | CRN01   | SUP01    | AUD      |      1.75 |              |                         |                      | GST0      |          |                           |                |               |                           | NA        | NA        | NA        | NA        |
      |        002 | CRN02   | SUP02    | AUD      |      1.63 |              |                         |                      | GST0      |          |                           |                |               |                           | NA        | NA        | NA        | NA        |
    And AP credit note is added detail as "<KEY AP CRN>"
      | KEY AP CRN | LI No. | Type | Item Code | Remarks Description | Qty UOM | Pack Size No. Of Packs | Cost Type | Unit Cost | Discount % | Amount | Sales tax | Segment 1 | Segment 2 | Segment 3 | Segment 4 | Serial No | Delete | Del |
      |        001 |        | S    | OTHER     |                     |       5 |                        |           |        20 |            |        | GST0      | NA        | NA        | NA        | NA        |           |        |     |
      |        002 |        | S    | OTHER     |                     |       1 |                        |           |       200 |            |        | GST0      | NA        | NA        | NA        | NA        |           |        |     |
    And submit AP credit note
    And user navigates to "Operations>Accounts Payable>Revaluation" screen
    When user create AP revaluation as "<KEY>"
      | KEY | Revaluation Voucher No. | Revaluation Voucher Date | Description      |
      | 001 | APRVA01                 |                          | First Reval 1.71 |
      | 002 | APRVA02                 |                          | Second Reval 1.7 |
    And AP revalueation is added currency as "<KEY>"
      | KEY | Currency | Exch Rate | Del |
      | 001 | AUD      |      1.71 |     |
      | 002 | AUD      |       1.7 |     |
    And AP revaluation is submitted

    Examples: 
      | KEY |
      | 001 |
      | 002 |

  Scenario Outline: D13. User create AR Revaluation with Feature file
    Given user login the TH6 system
    And user navigates to "Operations>Accounts Receivable>AR Credit Note" screen
    When user create AR credit note as "<KEY>"
      | KEY | Crn No. | Customer | Billing Party | Credit Note Date | Ref No. | Customer PO No. | Currency | Exchange Rate | Default Sales Tax | Payment Option | Billing Contact | Default Disc % | Location | Sales Person | Billing Address | Credit Note Category | Credit Note Justification | Remarks To Customer | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 001 | CRN01   | CUS01    |               |                  |         |                 | AUD      |          1.69 | GST7              |                |                 |                |          |              |                 |                      |                           |                     | NA        | NA        | NA        | NA        |
      | 002 | CRN02   | CUS02    |               |                  |         |                 | AUD      |          1.63 | GST0              |                |                 |                |          |              |                 |                      |                           |                     | NA        | NA        | NA        | NA        |
    And AR credit note is added billing detail as "<KEY>"
      | KEY | Type | Item Code | Remarks Description | Qty UOM | Pack Size No. Of Packs | Price Type | Unit Price | Discount % | Amount | Sales Tax | Segment 1 | Segment 2 | Segment 3 | Segment 4 | Delete |
      | 001 | S    | OTHER     |                     |       1 |                        |            |        100 |            |        | GST0      | NA        | NA        | NA        | NA        |        |
      | 002 | S    | OTHER     |                     |       1 |                        |            |         50 |            |        | GST0      | NA        | NA        | NA        | NA        |        |
    And AR credit note is submitted
    And user navigates to "Operations>Accounts Receivable>Receipt" screen
    When user create AR receipt as "<KEY>"
      | KEY | Receipt No. | Customer | Receipt Date | Receipt Currency | Exchange Rate | Reference No. | Bank Draft No | Deposit Slip No | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 001 | REC01       | CUS01    |              | AUD              |          1.66 |           123 |               |                 | NA        | NA        | NA        | NA        |
      | 002 | REC02       | CUS01    |              | AUD              |          1.63 |           321 |               |                 | NA        | NA        | NA        | NA        |
    And AR receipt is added payment detail as "<KEY>"
      | KEY | Bank Party Code | Bank Account No | Pymt Method | Cheque No. | Cheque Date | Customer Bank | Card Type | Instmt Code Instmt Desc | Pymt Amt | Tendered Amt |
      | 001 | OCBC            | OCBCAUD         |             |            |             |               |           |                         |     1000 |              |
      | 002 | OCBC            | OCBCAUD         |             |            |             |               |           |                         |       20 |              |
    And AR receipt is submitted
    And user navigates to "Operations>Accounts Receivable>AR Invoice" screen
    When user create ar invoice as "<KEY>"
      | KEY | Inv No | Customer | Invoice Date | Due Date | Ref No | Currency | Exchange Rate | Default Sales Tax | Sales Person | Default Disc % | Customer PO No | Location | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 001 | INV01  | CUS01    |              |          |      1 | AUD      |          1.68 | GST0              |              |                |                | SG       | NA        | NA        | NA        | NA        |
      | 002 | INV02  | CUS02    |              |          |      2 | AUD      |          1.65 | GST0              |              |                |                | SG       | NA        | NA        | NA        | NA        |
    And user add billing AR invoice as "<KEY>"
      | KEY | LI No | Type | Item Code/Remarks Description | Qty UOM | No Of Packs Pack Size | Unit Price Price Type | Disc % | Amount | Total Amt | Sales Tax | Serial No | Segment 1 | Segment 2 | Segment 3 | Segment 4 | Delete | Check Del |
      | 001 |       | s    | OTHER                         |       1 |                       |                  1000 |        |        |           | GST0      |           | NA        | NA        | NA        | NA        |        |           |
      | 001 |       | s    | OTHER                         |       1 |                       |                    20 |        |        |           | GST0      |           | NA        | NA        | NA        | NA        |        |           |
    And user create payment information ar invoice as "<KEY>"
      | KEY | Payment Option | Payment Term | Payment Term Tenor |
      | 001 |                |              |                  1 |
      | 002 |                |              |                  2 |
    And user submit ar invoice
    And user navigates to "Operations>Accounts Receivable>Revaluation" screen
    When user create ar revaluation as "<KEY>"
      | KEY | Revaluation Voucher No. | Revaluation Voucher Date | Description       |
      | 001 | ARRVA01                 |                          | First Reval 1.66  |
      | 002 | ARRVA02                 |                          | Second Reval 1.67 |
    And ar revaluation added currency as "<KEY>"
      | KEY | Currency | Exch Rate | Del |
      | 001 | AUD      |      1.66 |     |
      | 002 | AUD      |      1.67 |     |
    And ar revaluation is submitted

    Examples: 
      | KEY |
      | 001 |
      | 002 |

  # ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  #
  ###################################### BK #####################################
  Scenario Outline: D14. Bank Book generate bank Vch by feature file
    Given user login the TH6 system
    And user navigates to "Operations>Bank Book>Generate Recurring Bank Voucher" screen
    When user generate recurring bank voucher as "<KEY>"
      | KEY | Generation Date From | Generation Date To | Recurring Template No From | Recurring Template No To |
      | 001 | 1/8/2016             | 31/08/2016         | BT01                       | BT03                     |
    Then Bank Vouchers are generated
      | Bank Transaction No. |
      | BK01                 |
      | BK02                 |
      | BK03                 |
    And BK transaction is submitted

    Examples: 
      | KEY |
      | 001 |

  Scenario Outline: D17. Bank Book Transaction Vch TH6
    Given user login the TH6 system
    And user navigates to "Operations>Bank Book>Transaction Voucher" screen
    When user create BK transaction voucher as "<KEY BK>"
      | KEY BK | Bank Voucher No | Bank Voucher Description                         | Received From/Payee Name | Transaction Type |
      |    001 | BK01            | Manually Deposit S$15000 Cash on hand to DBS SGD | Rachel                   | Deposit          |
      |    002 | BK02            | Manually Transfer S$5000 from OCBCSGD to DBSUSD  |                          | Fund Transfer    |
      |    003 | BK03            | Manually Withdraw $10000 of cash from OCBC USD   | Laura                    | Withdrawal       |
    And BK transaction voucher is deposit as "<KEY BK>"
      | KEY BK | Mode of Deposit | Bank Vch Date | Deposit Slip Date | Bank Party Code | Bank Account No | Currency | Cross Rate | SBU Code | Value Date | Cheque No. | Deposit Slip No | Deposit Bank Exch Rate | Exch Rate | Default Sales Tax | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |    001 |                 |               |                   | DBS             | DBSSGD          | SGD      |            |          |            |            |                 |                      1 |         1 |                   | na        | na        | na        | na        |
    And BK deposit transaction voucher is add detail as "<KEY BK>"
      | KEY BK | Line Items | Credit/Debit | Received From | Amount | Sales Tax | Document No | Doc Date | Segment 1 | Segment 2 | Segment 3 | Segment 4 | Expected Message |
      |    001 |            |              | OTHER         |  15000 |           |             |          | na        | na        | na        | na        |                  |
    And BK charge is added detail as "<KEY BK>"
      | KEY BK | Charge To | Bank Charge | Ccy | Charge Amt |
      |    001 |           | BKCHARGE    | SGD |         10 |
    And BK transaction voucher is fund transfer as "<KEY BK>"
      | KEY BK | Mode of Transfer | Bank Vch Date | Transfer Advice Date | Remittance Bank A/C Name | Remittance Bank A/C No | Destination Bank A/C Name | Destination Bank A/C No | Transfer Amount | Cross Rate | Value Date | Transfer Advice No | Remittance Bank Exch Rate | Destination Bank Exch Rate | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |    002 |                  |               |                      | OCBC                     | OCBCSGD                | DBS                       | DBSUSD                  |            5000 |            |            |                123 |                         1 |                       1.47 | na        | na        | na        | na        |
    And BK charge is added detail as "<KEY BK>"
      | KEY BK | Charge To        | Bank Charge | Ccy | Charge Amt |
      |    002 | Remittance Bank  | BKCHARGE    | SGD |          4 |
      |    002 | Destination Bank | BKCHARGE    | USD |        2.5 |
    And BK transaction voucher is withdrawal as "<KEY BK>"
      | KEY BK | Mode of Withdrawal | Bank Vch Date | Withdrawal Slip Date | Bank Party Code | Bank Account No | Currency | SBU Code | Value Date | Cheque No. | Withdrawal Slip No | Withdrawal Bank Exch Rate | Exch Rate | Default Sales Tax | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |    003 |                    |               |                      | OCBC            | OCBCUSD         | USD      |          |            |            |                    |                      1.51 |      1.51 |                   | na        | na        | na        | na        |
    And BK withdrawal transaction voucher is add detail as "<KEY BK>"
      | KEY BK | Line Items | Credit/Debit | Paid to | Cheque No. | Amount | Sales Tax | Document No | Doc Date | Segment 1 | Segment 2 | Segment 3 | Segment 4 | Expected Message |
      |    003 |            |              | OTHER   |            |  10000 |           |             |          | na        | na        | na        | na        |                  |
    And BK charge is added detail as "<KEY BK>"
      | KEY BK | Charge To | Bank Charge | Ccy | Charge Amt |
      |    003 |           | BKCHARGE    | USD |          5 |
    And BK transaction preview report "Standard Bank Voucher"
    And BK transaction is submitted
    And BK transaction preview at history tab with report name "Standard Bank Voucher"

    Examples: 
      | KEY BK |
      |    001 |
      |    002 |
      |    003 |

  Scenario Outline: D15. Bank Book Revaluation by Feature
    Given user login the TH6 system
    And user navigates to "Operations>Bank Book>Transaction Voucher" screen
    When user create BK transaction voucher as "<KEY BK>"
      | KEY BK | Bank Voucher No | Bank Voucher Description                         | Received From/Payee Name | Transaction Type |
      |    001 | BK01            | Manually Deposit S$15000 Cash on hand to DBS AUD | Rachel                   | Deposit          |
    And BK transaction voucher is deposit as "<KEY BK>"
      | KEY BK | Mode of Deposit | Bank Vch Date | Deposit Slip Date | Bank Party Code | Bank Account No | Currency | Cross Rate | SBU Code | Value Date | Cheque No. | Deposit Slip No | Deposit Bank Exch Rate | Exch Rate | Default Sales Tax | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |    001 |                 |               |                   | DBS             | DBSAUD          | SGD      |            |          |            |            |                 |                   1.73 |         1 |                   | na        | na        | na        | na        |
    And BK deposit transaction voucher is add detail as "<KEY BK>"
      | KEY BK | Line Items | Credit/Debit | Received From | Amount | Sales Tax | Document No | Doc Date | Segment 1 | Segment 2 | Segment 3 | Segment 4 | Expected Message |
      |    001 |            |              | OTHER         |  15000 |           |             |          | na        | na        | na        | na        |                  |
    And BK charge is added detail as "<KEY BK>"
      | KEY BK | Charge To | Bank Charge | Ccy | Charge Amt |
      |    001 |           | BKCHARGE    | AUD |        7.5 |
    And BK transaction is submitted
    And user navigates to "Operations>Bank Book>Revaluation" screen
    When user create BK revaluation as "<KEY>"
      | KEY | Revaluation Voucher No. | Revaluation Voucher Date | Currency | Exchange Rate | Description   |
      | 001 | BKRVA01                 |                          | AUD      |          1.71 | BK Reval 1.71 |
      | 002 | BKRVA02                 |                          | AUD      |          1.72 | BK Reval 1.72 |
    And BK revaluation is add detail as "<KEY>"
      | KEY | GL Account Code |
      | 001 |           28022 |
      | 002 |           28022 |
    And BK revaluation is submitted
    And user navigates to "Operations>Bank Book>Transaction Voucher" screen
    When user create BK transaction voucher as "<KEY BK>"
      | KEY BK | Bank Voucher No | Bank Voucher Description                                                        | Received From/Payee Name | Transaction Type |
      |    002 | BK02            | Manually Withdraw AUD8655.52 Cash from DBS AUD to clear off this Bank's Balance | Rachel                   | Withdrawal       |
    And BK transaction voucher is withdrawal as "<KEY BK>"
      | KEY BK | Mode of Withdrawal | Bank Vch Date | Withdrawal Slip Date | Bank Party Code | Bank Account No | Currency | SBU Code | Value Date | Cheque No. | Withdrawal Slip No | Withdrawal Bank Exch Rate | Exch Rate | Default Sales Tax | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |    002 |                    |               |                      | DBS             | DBSAUD          | AUD      |          |            |            |                    |                      1.73 |      1.73 |                   | na        | na        | na        | na        |
    And BK withdrawal transaction voucher is add detail as "<KEY BK>"
      | KEY BK | Line Items | Credit/Debit | Paid to | Cheque No. | Amount  | Sales Tax | Document No | Doc Date | Segment 1 | Segment 2 | Segment 3 | Segment 4 | Expected Message |
      |    002 |            |              | OTHER   |            | 8655.52 |           |             |          | na        | na        | na        | na        |                  |
    And BK charge is added detail as "<KEY BK>"
      | KEY BK | Charge To | Bank Charge | Ccy | Charge Amt |
      |    002 |           | BKCHARGE    | AUD |        7.5 |
    And BK transaction is submitted

    Examples: 
      | KEY |
      | 001 |
      | 002 |

  Scenario Outline: D16. Bank Book Reconciliation Voucher by feature TH6
    Given user login the taskhub system
    And user navigates to "Operations>Bank Book>Transaction Voucher" screen
    When user create BK transaction voucher as "<KEY BK>"
      | KEY BK | Bank Voucher No | Bank Voucher Description                                                        | Received From/Payee Name | Transaction Type |
      |    001 | BK01            | Manually Deposit S$15000 Cash on hand to DBS AUD                                | Rachel +                 | Deposit          |
      |    002 | BK02            | Manually Withdraw AUD8655.52 Cash from DBS AUD to clear off this Bank's Balance | Rachel -                 | Withdrawal       |
      |    003 | BK03            | Manually Transfer AUD5000 from DBSAUD to DBSUSD                                 | Laura -                  | Fund Transfer    |
      |    004 | BK04            | Manually Transfer S$8561.97 from OCBCSGD to BDSAUD to clear off BDSAUD          | Laura +                  | Fund Transfer    |
    And BK transaction voucher is deposit as "<KEY BK>"
      | KEY BK | Mode of Deposit | Bank Vch Date | Deposit Slip Date | Bank Party Code | Bank Account No | Currency | Cross Rate | SBU Code | Value Date | Cheque No. | Deposit Slip No | Deposit Bank Exch Rate | Exch Rate | Default Sales Tax | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |    001 |                 |               |                   | DBS             | DBSAUD          | SGD      |            |          |            |            |                 |                   1.73 |         1 |                   | na        | na        | na        | na        |
    And BK deposit transaction voucher is add detail as "<KEY BK>"
      | KEY BK | Line Items | Credit/Debit | Received From | Amount | Sales Tax | Document No | Doc Date | Segment 1 | Segment 2 | Segment 3 | Segment 4 | Expected Message |
      |    001 |            |              | OTHER         |  15000 |           |             |          | na        | na        | na        | na        |                  |
    And BK charge is added detail as "<KEY BK>"
      | KEY BK | Charge To | Bank Charge | Ccy | Charge Amt |
      |    001 |           | BKCHARGE    | AUD |        7.5 |
    And BK transaction voucher is withdrawal as "<KEY BK>"
      | KEY BK | Mode of Withdrawal | Bank Vch Date | Withdrawal Slip Date | Bank Party Code | Bank Account No | Currency | SBU Code | Value Date | Cheque No. | Withdrawal Slip No | Withdrawal Bank Exch Rate | Exch Rate | Default Sales Tax | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |    002 |                    |               |                      | DBS             | DBSAUD          | AUD      |          |            |            |                    |                      1.73 |      1.73 |                   | na        | na        | na        | na        |
    And BK withdrawal transaction voucher is add detail as "<KEY BK>"
      | KEY BK | Line Items | Credit/Debit | Paid to | Cheque No. | Amount  | Sales Tax | Document No | Doc Date | Segment 1 | Segment 2 | Segment 3 | Segment 4 | Expected Message |
      |    002 |            |              | OTHER   |            | 8655.52 |           |             |          | na        | na        | na        | na        |                  |
    And BK charge is added detail as "<KEY BK>"
      | KEY BK | Charge To | Bank Charge | Ccy | Charge Amt |
      |    002 |           | BKCHARGE    | AUD |        7.5 |
    And BK transaction voucher is fund transfer as "<KEY BK>"
      | KEY BK | Mode of Transfer | Bank Vch Date | Transfer Advice Date | Remittance Bank A/C Name | Remittance Bank A/C No | Destination Bank A/C Name | Destination Bank A/C No | Transfer Amount | Cross Rate | Value Date | Transfer Advice No | Remittance Bank Exch Rate | Destination Bank Exch Rate | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |    003 |                  |               |                      | DBS                      | DBSAUD                 | DBS                       | DBSUSD                  |            5000 |            |            |                123 |                      1.72 |                       1.47 | na        | na        | na        | na        |
    And BK charge is added detail as "<KEY BK>"
      | KEY BK | Charge To        | Bank Charge | Ccy | Charge Amt |
      |    003 | Remittance Bank  | BKCHARGE    | AUD |          3 |
      |    003 | Destination Bank | BKCHARGE    | USD |        2.5 |
    And BK transaction voucher is fund transfer as "<KEY BK>"
      | KEY BK | Mode of Transfer | Bank Vch Date | Transfer Advice Date | Remittance Bank A/C Name | Remittance Bank A/C No | Destination Bank A/C Name | Destination Bank A/C No | Transfer Amount | Cross Rate | Value Date | Transfer Advice No | Remittance Bank Exch Rate | Destination Bank Exch Rate | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |    004 |                  |               |                      | OCBC                     | OCBCSGD                | DBS                       | DBSAUD                  |         8561.97 |            |            |                123 |                         1 |                       1.71 | na        | na        | na        | na        |
    And BK charge is added detail as "<KEY BK>"
      | KEY BK | Charge To        | Bank Charge | Ccy | Charge Amt |
      |    004 | Remittance Bank  | BKCHARGE    | SGD |         10 |
      |    004 | Destination Bank | BKCHARGE    | AUD |          4 |
    And BK transaction is submitted
    And user navigates to "Operations>Accounts Receivable>Receipt" screen
    When user create AR receipt as "<KEY>"
      | KEY | Receipt No. | Customer | Receipt Date | Receipt Currency | Exchange Rate | Reference No. | Bank Draft No | Deposit Slip No | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 001 | REC01       | CUS01    |              | SGD              |             1 |           123 |               |                 | NA        | NA        | NA        | NA        |
    And AR receipt is added payment detail as "<KEY>"
      | KEY | Bank Party Code | Bank Account No | Pymt Method | Cheque No. | Cheque Date | Customer Bank | Card Type | Instmt Code Instmt Desc | Pymt Amt | Tendered Amt |
      | 001 | DBS             | DBSAUD          |             |            |             |               |           |                         |     1000 |              |
    And BK charge is added detail as "<KEY>"
      | KEY | Bank Charge | Ccy | Exch Rate | Charge Amt |
      | 001 | BKCHARGE    | AUD |      1.71 |          3 |
    And AR receipt is submitted
    And user navigates to "Operations>Accounts Receivable>Receipt Cancellation" screen
    When user create AR receipt cancellation as "<KEY>"
      | KEY | Receipt Cancellation No | Receipt Cancellation Date | Customer | Cheque No. | Receipt No | Cancellation Type |
      | 001 | RCC01                   |                           | CUS01    |            | REC01      | Void Cheque       |
    And AR receipt cancellation is submitted
    And user navigates to "Operations>Accounts Payable>Payment" screen
    When user create AP payment as "<KEY PAYMENT>"
      | KEY PAYMENT | Payment Voucher Number | Supplier | Payment Voucher Date | Bank Party Code | Bank Account No | Cheque Date | Cheque No. | Bank Draft No | Payee Name | Exchange Rate | Cheque Amount | Ref No. | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |         001 | PAY01                  | SUP01    |                      | DBS             | DBSAUD          |             | CQ00010    |               | Rachel     |             1 |          1000 |         | NA        | NA        | NA        | NA        |
    And BK charge is added detail as "<KEY>"
      | KEY | Bank Charge | Ccy | Exch Rate | Charge Amt |
      | 001 | BKCHARGE    | AUD |      1.71 |          2 |
    And AP payment is submitted
    And user navigates to "Operations>Accounts Payable>Payment Cancellation" screen
    When user create AP payment cancellation as "<KEY>"
      | KEY | Payment Cancellation No | Payment Cancellation Date | Supplier | Cheque No. | Payment Voucher No | Cancellation Type |
      | 001 | PYC01                   |                           | SUP01    |            | PAY01              | Void Cheque       |
    And AP Payment cancellation is submitted
    And user navigates to "Operations>Bank Book>Reconciliation Voucher" screen
    When user create reconciliation voucher as "<KEY>"
      | KEY | Reconciliation Vch. No. | Reconciliation Voucher Date | Bank Account Name | Bank Account No | Bank Statement No | Bank Statement Amount | Bank Statement Date |
      | 001 | BRC01                   |                             | DBS               | DBSAUD          |               321 |                 10000 | 12/8/2016           |
    And BK reconciliation is selected source voucher no as "<KEY>"
      | KEY | Source Voucher No. | Type | Cheque No. | Source Voucher Doc No. |
      | 001 | BK01               | TRN  |            |                        |
      | 001 | BK01               | BCG  |            |                        |
      | 001 | BK02               | TRN  |            |                        |
      | 001 | BK02               | BCG  |            |                        |
      | 001 | BK03               | TRN  |            |                        |
      | 001 | BK03               | BCG  |            |                        |
      | 001 | BK04               | TRN  |            |                        |
      | 001 | BK04               | BCG  |            |                        |
      | 001 | REC01              | REC  |            |                        |
      | 001 | REC01              | BCR  |            |                        |
      | 001 | RCC01              | RCC  |            |                        |
      | 001 | RCC01              | BCC  |            |                        |
      | 001 | PAY01              | PAY  |            |                        |
      | 001 | PAY01              | BCG  |            |                        |
      | 001 | PYC01              | PYC  |            |                        |
      | 001 | PYC01              | BCC  |            |                        |
    # And BK reconciliation is selected all source voucher no
    And BK reconciliation is submitted

    Examples: 
      | KEY |
      | 001 |

  # ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  #
  ###################################### FA #####################################
  Scenario Outline: D18. Fixed Asset Holding by feature TH6
    Given user login the TH6 system
    And user navigates to "Operations>Accounts Payable>AP Invoice" screen
    When user create AP invoice as "<KEY AP INV>"
      | KEY AP INV | Voucher No. | Supplier | Currency | Exch Rate | Posting Date | Supplier Invoice No | Disc Date | Supplier DO No. | Bill Of Lading No. | Custom Tax Invoice | Sales Tax | Due Date | Supplier Invoice Date | Default Discount % | Supplier DO Date | Import Permit No | Reference No. | Inventory Location | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |        001 | INV01       | SUP01    | SGD      |         1 |              |                     |           |                 |                    | No                 | GST0      |          |                       |                    |                  |                  |               |                    | SG        | SG        | D1        | NA        |
    And AP invoice is added payment information as "<KEY AP INV>"
      | KEY AP INV | Payment Option | Payment Term | Payment Term Tenor | Payment Method | Payment Amount | Payment Party | Payment Address | Payment Contact |
      |        001 |                |              |                  1 |                |                |               |                 |                 |
    And AP invoice is added detail header as "<KEY AP INV>"
      | KEY AP INV | Type | Item Code/Remarks | Qty UOM | Pack Size | Cost Type | Discount %/ | Total Amt | Sales Tax | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |        001 | F    | MACHINE           |       1 |           |      1000 |             |           | gst10     | VN        | HN        | NA        | RA        |
      |        001 | F    | MOTOR             |       1 |           |       560 |             |           | gst10     | VN        | HN        | NA        | LR        |
      |        001 | F    | PC                |       2 |           |       240 |             |           | GST0      | VN        | HN        | NA        | TR        |
    And AP invoice is submitted
    And user navigates to "Operations>Fixed Asset>Holding" screen
    When user submit FA holding as "<KEY>"
      | KEY | Asset Voucher No | Source Voucher No. |
      | 001 | HOL01            | INV01              |
    And FA holding is added asset details as "<KEY>"
      | KEY | LI No. | Asset Serial No | Location |
      | 001 |      1 | MACHINE01       | VN       |
      | 001 |      2 | MOTOR01         | VN       |
      | 001 |      3 | PC01            | SG       |
      | 001 |      3 | PC02            | SG       |
    And FA Holding is submitted
    And user navigates to "Opening Balance>Fixed Asset" screen
    When user create fixed asset for opening balance as "<KEY OBFA>"
      | KEY OBFA | Voucher No. | Fixed Asset Code | Transaction Date | Supplier | Supplier Invoice No | Supplier Invoice Date | Subject | Description               | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |      001 | FAOB01      | MACHINE          |                  | Sup01    |                     |                       |         | Opening Balance – Machine | na        | na        | na        | na        |
      |      002 | FAOB02      | MOTOR            |                  | Sup01    |                     |                       |         | Opening Balance – Motor   | na        | na        | na        | na        |
      |      003 | FAOB03      | PC               |                  | SUP01    |                     |                       |         | Opening Balance – PC      | na        | na        | na        | na        |
    And fixed asset for opening balance is added detail as "<KEY OBFA>"
      | KEY OBFA | Serial No | Location | Asset Cost | Residual Value | Last Depreciation Date | No of Depreciation | Remaining Useful Life | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |      001 | MACHINE02 | SG       |       6500 |            500 |                        |                 35 |                       | na        | na        | na        | na        |
      |      001 | MACHINE03 | SG       |       5000 |              0 |                        |                 71 |                       | na        | na        | na        | na        |
      |      002 | MOTOR02   | SG       |        520 |             20 |                        |                 11 |                       | na        | na        | na        | na        |
      |      002 | MOTOR03   | SG       |        600 |             20 |                        |                 12 |                       | na        | na        | na        | na        |
      |      003 | PC03      | SG       |        400 |              0 |                        |                 17 |                       | na        | na        | na        | na        |
    And fixed asset for opening balance is updated
    And user navigates to "Operations>Fixed Asset>Generate Depreciation Voucher" screen
    When user generate depreciation voucher as "<KEY>"
      | KEY | Fixed Asset Class From | Fixed Asset Class To |
      | 001 | MV                     | PM                   |
    And user navigates to "Operations>Fixed Asset>Depreciation Voucher" screen
    When user submit all depreciation voucher
      | Voucher No. | Fixed Asset Code |
      | DEP01       | MACHINE          |
      | DEP02       | MOTOR            |
      | DEP03       | PC               |
    And user navigates to "Operations>Fixed Asset>Change Location" screen
    When user create FA change location as "<KEY>"
      | KEY | Voucher No. | Fixed Asset Code | Transaction Date | Subject |
      | 001 | FACL01      | PC               |                  |         |
    And FA change location is add details as "<KEY>"
      | KEY | Serial No | Remarks Description | New Location | Del |
      | 001 | PC01      |                     | VN           |     |
      | 001 | PC02      |                     | VN           |     |
    And FA change location is submitted
    And user navigates to "Operations>Fixed Asset>Disposal Voucher" screen
    When user create FA disposal voucher as "<KEY>"
      | KEY | Voucher No. | Fixed Asset Code | Disposal Date | Subject              | Description |
      | 001 | DISP01      | MACHINE          |               | Dispose all Machines |             |
      | 002 | DISP02      | MOTOR            |               | Dispose all Motors   |             |
      | 003 | DISP03      | PC               |               | Dispose all PCs      |             |
    And FA disposal voucher is add details as "<KEY>"
      | KEY | Serial No | Remarks Description | Disposal Amt | Del |
      | 001 | MACHINE01 | Dep. No = 1         |            0 |     |
      | 001 | MACHINE02 | Dep. No = 36        |          500 |     |
      | 001 | MACHINE03 | Dep. No = 72        |           20 |     |
      | 002 | MOTOR01   | Dep. No = 1         |            0 |     |
      | 002 | MOTOR02   | Dep. No = 12        |            0 |     |
      | 002 | MOTOR03   | Dep. No = 12        |           10 |     |
      | 003 | PC01      | Dep. No = 1         |            0 |     |
      | 003 | PC02      | Dep. No = 1         |            0 |     |
      | 003 | PC03      | Dep. No = 18        |            0 |     |
    And FA disposal voucher is submitted

    Examples: 
      | KEY |
      | 001 |
      | 002 |
      | 003 |

  # ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  #
  ###################################### BL #####################################
  Scenario Outline: D23. GL Generate Recurring Voucher by feature file in TH6
    Given user login the TH6 system
    And user navigates to "Operations>General Ledger>Generate Recurring Voucher" screen
    When user generate GL recurring voucher as "<KEY>"
      | KEY | Generation Date From | Generation Date To | Recurring Vch Code From | Recurring Vch Code To |
      | 001 | 1/1/2016             | 31/12/2016         | RVC01                   | RVC02                 |
    Then GL Vouchers are generated
      | GL Voucher No. |
      | GL01           |
      | GL02           |
    And GL transaction is submitted

    Examples: 
      | KEY |
      | 001 |

  Scenario Outline: D24. GL Journal Voucher by feature file in TH6
    Given user login the taskhub system
    And user navigates to "Operations>General Ledger>Journal Voucher" screen
    When user create GL journal voucher as "<KEY>"
      | KEY | Type | Voucher No. | Description                        | Voucher Date | Currency | Document Type | Exchange Rate Type | Exchange Rate | Document No | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 001 | All  |             | Reallocate to different segments   |              | SGD      |               |                    |               |             | na        | na        | na        | na        |
      | 002 | All  |             | Transfer from 1 account to another |              | USD      |               |                    |          1.51 |             | na        | na        | na        | na        |
    And GL journal voucher is added details as "<KEY>"
      | KEY | GL Account No. | Remark | Nature Debit | Home Debit | Nature Credit | Home Credit | Segment 1 | Segment 2 | Segment 3 | Segment 4 | Delete |
      | 001 |          85000 |        |         3000 |            |               |             | VN        | HN        | NA        | RA        |        |
      | 001 |          85000 |        |              |            |          1000 |             | VN        | HN        | NA        | LR        |        |
      | 001 |          85000 |        |              |            |          1000 |             | VN        | HN        | NA        | SR        |        |
      | 001 |          85000 |        |              |            |          1000 |             | VN        | HN        | NA        | TR        |        |
      | 002 |          85000 |        |         1.01 |            |               |             | SG        | SG        | NA        | NA        |        |
      | 002 |          85010 |        |              |            |          1.01 |             | SG        | SG        | NA        | NA        |        |
    And GL journal voucher is previewed with report name ""
    And GL journal voucher is submitted
    And GL journal voucher is previewed at history tab with report name ""

    Examples: 
      | KEY |
      | 001 |
      | 002 |
