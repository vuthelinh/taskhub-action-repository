
Feature: Nancy run TH6 Master data daily for FIN

  ###############################################################################
  ###############################################################################
  # ***************** GLOBAL SETUP ********************
  Scenario: 1. Run Chart Of Account Daily
    Given user login the TH6 system
    And user navigates to "Master Setup>Accounting>Chart Of Acc" screen
    When user create chart of account daily with company ""
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
      | Z-100           | Fixed Asset Clearing                   | Balance Sheet Item | Active | No                     | all     |
      | Z-200           | Inventory Clearing                     | Balance Sheet Item | Active | No                     | all     |
      | Z-300           | Receivable Clearing                    | Balance Sheet Item | Active | No                     | all     |
      | Z-400           | Payable Clearing                       | Balance Sheet Item | Active | No                     | all     |
      | Z-500           | Bank Clearing                          | Balance Sheet Item | Active | No                     | all     |

  Scenario Outline: 2. Create Sales Tax  with feature file
    Given user login the TH6 system
    When user navigates to "Master Setup>Accounting>Sales Tax" screen
    When user create sales tax as "<KEY SALES TAX>"
      | KEY SALES TAX | Prefix | Sales Tax Code | Description | Sales Tax | Input Tax GLAN | Output Tax GLAN | IRAS Tax Type of Purchase                        | IRAS Tax Type of Supply | Company      |
      | 001           | n      |                | NOT USE     | 0         | 43110          | 43120           | ZP (Zero-Rated)                                  | DS (Deemed)             | AUTO4, AUTO1 |
      | 001           | n      |                | NOT USE     | 7         | 43110          | 43120           | BL (Disallowed Expenses)                         | ZR (Zero-Rated)         | AUTO4, AUTO1 |
      | 001           | n      |                | NOT USE     | 10        | 43110          | 43120           | NR (Purchases from Non-GST Registered Suppliers) | SR (Standard-Rated)     | AUTO4, AUTO1 |

    Examples: 
      | KEY SALES TAX |
      | 001           |

  Scenario Outline: 3. Create new Currency with feature file
    Given user login the TH6 system
    When user navigates to "Master Setup>Currency>Currency" screen
    When user create currency as "<KEY CURRENCY>"
      | KEY CURRENCY | Currency | Description       | Currency Symbol | Dollar in word | Cent in word | Minimum Bank Rate | Maximum Bank Rate | Maximum Spread% | Spread % Base | Credit Limit Exchange Rate | Company      |
      | 001          | n04      | NOT USE Singapore | auto            | auto           | auto         | 1                 | 1                 | 1.1             | Buy Rate      | 1.1                        | AUTO4, AUTO1 |
      | 001          | n05      | NOT USE US        | auto            | auto           | auto         | 1                 | 2                 | 1.2             | Sell Rate     | 1.2                        | AUTO4, AUTO1 |
      | 001          | n06      | NOT USE Australia | auto            | auto           | auto         | 1                 | 3                 | 1.3             | Buy Rate      | 1.3                        | AUTO4, AUTO1 |

    Examples: 
      | KEY CURRENCY |
      | 001          |

  Scenario Outline: 4. Create Supplier Class
    Given user login the TH6 system
    When user navigates to "Master Setup>Supplier>Supplier Class" screen
    And user create supplier class as "<KEY SUP CLASS>"
      | KEY SUP CLASS | Supplier Class Code | Description | Payable GLAN | Realized GLAN | Unrealized GLAN | Goods Receipt Clearing GLAN | Purchase Variance GLAN | Additional Cost | Additional Cost Variance | Additional Cost Exchange | Purchase Return Variance | Purchase Variance Exch Diff | Sales Tax Exch Difference | Retention GLAN | Other Income GLAN | Company      |
      | 001           | nsupcl03            | NOT USE     | 41010        | 52000         | 52000           | 52000                       | 52000                  | 44000           | 62010                    | 52000                    | 61010                    | 52000                       | 52000                     | 21030          | 52000             | AUTO4, AUTO1 |
      | 001           | nsupcl01            | NOT USE     | 41010        | 52000         | 52000           | 52000                       | 52000                  | 44000           | 62010                    | 52000                    | 61010                    | 52000                       | 52000                     | 21030          | 52000             | AUTO4, AUTO1 |
      | 001           | nsupcl02            | NOT USE     | 41010        | 52000         | 52000           | 52000                       | 52000                  | 44000           | 62010                    | 52000                    | 61010                    | 52000                       | 52000                     | 21030          | 52000             | AUTO4, AUTO1 |
      | 001           | nsupcl04            | NOT USE     | 41010        | 52000         | 52000           | 52000                       | 52000                  | 44000           | 62010                    | 52000                    | 61010                    | 52000                       | 52000                     | 21030          | 52000             | AUTO4, AUTO1 |

    Examples: 
      | KEY SUP CLASS |
      | 001           |

  Scenario Outline: 5. Create Customer Class
    Given user login the TH6 system
    When user navigates to "Master Setup>Customer>Customer Class" screen
    And user create customer class as "<KEY CUS CLASS>"
      | KEY CUS CLASS | Customer Class Code | Description | Receivable GLAN | Realized GLAN | Unrealized GLAN | Corporate Clearing GLAN | Amt Refundable to Customer | Receivable Medisave GLAN | Medisave Clearing GLAN | Amt Billable to Customer | Recognized Accrued Cost | Recognized Accrued Revenue | Rental Revenue GLAN | Sales GLAN | Costs of Sales GLAN | Sales Return GLAN | Costs of Sales Return GLAN | Costs of Sales Ret Clearing GLAN | Delivery Clearing GLAN | Inventory With Customer GLAN | Cost of Servicing GLAN | Unearned Revenue GLAN | Work in Progress GLAN | Retention GLAN | Project Revenue GLAN | Project Cost GLAN | Recognition Exch Gain Loss GLAN | Cost Accrual GLAN | Revenue Accrual GLAN | Accrued Income GLAN | Attributable Profit | Claim Debtor | Certification Debtor | Other Payable | Retention Clearing | Material on Site | Retention Material on Site | Downpayment Unearned GLAN | Downpayment Exch Gain Loss GLAN | Company      |
      | 001           | ncuscl01            | NOT USE     | 22020           | 86050         | 86060           | 22020                   | 22020                      | 22020                    | 22020                  | 22020                    | 22020                   | 22020                      | 85000               | 51010      | 60000               | 52000             | 60020                      | 22020                            | 22020                  | 22020                        | 22020                  | 22020                 | 22020                 | 22020          | 22020                | 22020             | 22020                           | 22020             | 22020                | 22020               | 22020               | 22020        | 22020                | 22020         | 22020              | 22020            | 22020                      | 22020                     | 22020                           | AUTO4, AUTO1 |
      | 001           | ncuscl02            | NOT USE     | 22020           | 86050         | 86060           | 22020                   | 22020                      | 22020                    | 22020                  | 22020                    | 22020                   | 22020                      | 85000               | 51010      | 60000               | 52000             | 60020                      | 22020                            | 22020                  | 22020                        | 22020                  | 22020                 | 22020                 | 22020          | 22020                | 22020             | 22020                           | 22020             | 22020                | 22020               | 22020               | 22020        | 22020                | 22020         | 22020              | 22020            | 22020                      | 22020                     | 22020                           | AUTO4, AUTO1 |
      | 001           | ncuscl03            | NOT USE     | 22020           | 86050         | 86060           | 22020                   | 22020                      | 22020                    | 22020                  | 22020                    | 22020                   | 22020                      | 85000               | 51010      | 60000               | 52000             | 60020                      | 22020                            | 22020                  | 22020                        | 22020                  | 22020                 | 22020                 | 22020          | 22020                | 22020             | 22020                           | 22020             | 22020                | 22020               | 22020               | 22020        | 22020                | 22020         | 22020              | 22020            | 22020                      | 22020                     | 22020                           | AUTO4, AUTO1 |
      | 001           | ncuscl04            | NOT USE     | 22020           | 86050         | 86060           | 22020                   | 22020                      | 22020                    | 22020                  | 22020                    | 22020                   | 22020                      | 85000               | 51010      | 60000               | 52000             | 60020                      | 22020                            | 22020                  | 22020                        | 22020                  | 22020                 | 22020                 | 22020          | 22020                | 22020             | 22020                           | 22020             | 22020                | 22020               | 22020               | 22020        | 22020                | 22020         | 22020              | 22020            | 22020                      | 22020                     | 22020                           | AUTO4, AUTO1 |
      | 001           | ncuscl05            | NOT USE     | 22020           | 86050         | 86060           | 22020                   | 22020                      | 22020                    | 22020                  | 22020                    | 22020                   | 22020                      | 85000               | 51010      | 60000               | 52000             | 60020                      | 22020                            | 22020                  | 22020                        | 22020                  | 22020                 | 22020                 | 22020          | 22020                | 22020             | 22020                           | 22020             | 22020                | 22020               | 22020               | 22020        | 22020                | 22020         | 22020              | 22020            | 22020                      | 22020                     | 22020                           | AUTO4, AUTO1 |

    Examples: 
      | KEY CUS CLASS |
      | 001           |

  Scenario Outline: 6. Create Daily Customer
    Given user login the TH6 system
    And user navigates to "Master Setup>Customer>Customer" screen
    When user create customer as "<KEY CUSTOMER>"
      | KEY CUSTOMER | Prefix Auto Gen Code | Customer Code | Unique Entity No | Customer Name | Customer Class Code | Party Group Code | Industry Code | Acquired By | Country Of Incorporation | Sales Tax Code | Contra Realized Exch GLAN | Statement Delivery Option | Default Tenor | Discount | Due AR Invoice Correspondence Language | Customer Remarks | Status | Main Customer Code | Customer Short Name | Customer Category Code | Customer Group Code | Customer Type | Main Home Page | GST Registration No | Party Contra GLAN | Default Validity | Default Tenor Term Code | Price Markup Percent | Combine Shm to Invoices | IPT Related | Shipping Marks Code | Company      |
      | 001          | ncus                 | Cus01         |                  | NOT USE Cus01 | CUSTOMER            |                  |               |             |                          | gst7           | 43010                     |                           |               |          |                                        |                  |        |                    | Auto test 1         |                        |                     |               |                |                     | 22040             |                  |                         |                      |                         |             |                     | AUTO4, AUTO1 |
      | 002          | ncus                 | Cus02         |                  | NOT USE Cus02 | CUSTOMER            |                  |               |             |                          | GST0           | 43010                     |                           |               |          |                                        |                  |        |                    | Auto test 2         |                        |                     |               |                |                     | 22040             |                  |                         |                      |                         |             |                     | AUTO4, AUTO1 |
      | 003          | ncus                 | Cus03         |                  | NOT USE Cus03 | CUSTOMER            |                  |               |             |                          | GST7           | 43010                     |                           |               |          |                                        |                  |        |                    | Auto test 3         |                        |                     |               |                |                     | 22040             |                  |                         |                      |                         |             |                     | AUTO4, AUTO1 |
      | 004          | ncus                 | Cus04         |                  | NOT USE Cus04 | CUSTOMER            |                  |               |             |                          | GST0           | 43010                     |                           |               |          |                                        |                  |        |                    | Auto test 4         |                        |                     |               |                |                     | 22040             |                  |                         |                      |                         |             |                     | AUTO4, AUTO1 |
    # ADDRESS TAB
    And customer is added address as "<KEY CUSTOMER>"
      | KEY CUSTOMER | Address Code | Description    | Address      | Country Code | State Province | City Town | Postal Code | Inc Type                                     | Default                     | LRA | Del |
      | 001          | add01        | auto testing 1 | auto testing | SG           |                |           | 11          | Sales, Bank, Ship to                         | Bank, Ship to               | y   |     |
      | 001          | add02        | auto testing 2 | auto testing | US           |                |           | 12          | Payment to Supplier                          | Payment to Supplier         |     | y   |
      | 001          | add02        | auto testing 2 | auto testing | US           |                |           | 12          | Purchase,  	Customer Billing, Service Centre | Customer Billing,  Purchase | y   |     |
      | 002          | add01        | auto testing 1 | auto testing | SG           |                |           | 11          | Sales, Bank, Ship to                         | Bank, Ship to               | y   |     |
      | 002          | add02        | auto testing 2 | auto testing | US           |                |           | 12          | Purchase,  	Customer Billing, Service Centre | Customer Billing,  Purchase | y   |     |
      | 003          | add01        | auto testing 1 | auto testing | SG           |                |           | 11          | Sales, Bank, Ship to                         | Bank, Ship to               | y   |     |
      | 003          | add02        | auto testing 2 | auto testing | US           |                |           | 12          | Purchase,  	Customer Billing, Service Centre | Customer Billing,  Purchase | y   | y   |
      | 003          | add02        | auto testing 2 | auto testing | US           |                |           | 12          | Purchase,  	Customer Billing, Service Centre | Customer Billing,  Purchase | y   |     |
      | 004          | add01        | auto testing 1 | auto testing | SG           |                |           | 11          | Sales, Bank, Ship to                         | Bank, Ship to               | y   |     |
      | 004          | add02        | auto testing 2 | auto testing | US           |                |           | 12          | Purchase,  	Customer Billing, Service Centre | Customer Billing,  Purchase | y   |     |
    And customer is added address contact type as "<KEY CUSTOMER>"
      | KEY CUSTOMER | Address Code | Contact Type | Contact Information | Default | Del |
      | 001          | add01        | Telephone    | Auto test           | y       | y   |
      | 001          | add01        | Telephone    | Auto test           | y       |     |
      | 001          | add01        | Fax          | Auto test           | y       |     |
      | 001          | add02        | Fax          | Auto test           | y       |     |
      | 002          | add01        | Telephone    | Auto test           | y       |     |
      | 002          | add01        | Fax          | Auto test           | y       |     |
      | 002          | add02        | Fax          | Auto test           | y       |     |
      | 003          | add01        | Telephone    | Auto test           | y       |     |
      | 003          | add01        | Fax          | Auto test           | y       |     |
      | 003          | add02        | Fax          | Auto test           | y       | y   |
      | 003          | add02        | Fax          | Auto test           | y       |     |
      | 004          | add01        | Telephone    | Auto test           | y       |     |
      | 004          | add01        | Fax          | Auto test           | y       |     |
      | 004          | add02        | Fax          | Auto test           | y       |     |
    #CONTACT TAB
    And customer is added contact as "<KEY CUSTOMER>"
      | KEY CUSTOMER | Party Contact Code | Salutation | First Name | Middle Name | Last Name | Name      | Address Code | Designation  | Designation Group | Department   | Inc Type             | Default             | Del |
      | 001          | Auto01             | Mrs.       | First      | Middle      | Last      | Auto test | add01        | Auto testing | SELE01            | Auto testing | Sales, Bank, Ship to | Bank, Ship to       | y   |
      | 001          | Auto01             | Mrs.       | First      | Middle      | Last      | Auto test | add01        | Auto testing | SELE01            | Auto testing | Sales, Bank, Ship to | Bank, Ship to       |     |
      | 001          | Auto02             | Mr.        | First      | Middle      | Last      | Auto test | add02        | Auto testing | SELE01            | Auto testing | Payment to Supplier  | Payment to Supplier |     |
      | 002          | Auto01             | Mrs.       | First      | Middle      | Last      | Auto test | add01        | Auto testing | SELE01            | Auto testing | Sales, Bank, Ship to | Bank, Ship to       |     |
      | 002          | Auto02             | Mr.        | First      | Middle      | Last      | Auto test | add02        | Auto testing | SELE01            | Auto testing | Payment to Supplier  | Payment to Supplier |     |
      | 003          | Auto01             | Mrs.       | First      | Middle      | Last      | Auto test | add01        | Auto testing | SELE01            | Auto testing | Sales, Bank, Ship to | Bank, Ship to       | y   |
      | 003          | Auto01             | Mrs.       | First      | Middle      | Last      | Auto test | add01        | Auto testing | SELE01            | Auto testing | Sales, Bank, Ship to | Bank, Ship to       |     |
      | 003          | Auto02             | Mr.        | First      | Middle      | Last      | Auto test | add02        | Auto testing | SELE01            | Auto testing | Payment to Supplier  | Payment to Supplier |     |
      | 004          | Auto01             | Mrs.       | First      | Middle      | Last      | Auto test | add01        | Auto testing | SELE01            | Auto testing | Sales, Bank, Ship to | Bank, Ship to       |     |
      | 004          | Auto02             | Mr.        | First      | Middle      | Last      | Auto test | add02        | Auto testing | SELE01            | Auto testing | Payment to Supplier  | Payment to Supplier |     |
    And customer is added contact type as "<KEY CUSTOMER>"
      | KEY CUSTOMER | Party Contact Code | Contact Type       | Contact Information | Default | Del |
      | 001          | Auto01             | Pager              | Auto testing        | y       | y   |
      | 001          | Auto01             | Pager              | Auto testing        | y       |     |
      | 001          | Auto01             | Primary Email      | Auto testing        | y       |     |
      | 001          | Auto01             | Home Tel           | Auto testing        | y       |     |
      | 001          | Auto02             | Confidential Email | Auto testing        |         | y   |
      | 001          | Auto02             | Fax No.            | Auto testing        | y       |     |
      | 002          | Auto01             | Pager              | Auto testing        | y       | y   |
      | 002          | Auto01             | Pager              | Auto testing        | y       |     |
      | 002          | Auto01             | Primary Email      | Auto testing        | y       |     |
      | 002          | Auto01             | Home Tel           | Auto testing        | y       |     |
      | 002          | Auto02             | Confidential Email | Auto testing        |         | y   |
      | 002          | Auto02             | Fax No.            | Auto testing        | y       |     |
      | 003          | Auto01             | Pager              | Auto testing        | y       | y   |
      | 003          | Auto01             | Pager              | Auto testing        | y       |     |
      | 003          | Auto01             | Primary Email      | Auto testing        | y       |     |
      | 003          | Auto01             | Home Tel           | Auto testing        | y       |     |
      | 003          | Auto02             | Confidential Email | Auto testing        |         | y   |
      | 003          | Auto02             | Fax No.            | Auto testing        | y       |     |
      | 004          | Auto01             | Pager              | Auto testing        | y       | y   |
      | 004          | Auto01             | Pager              | Auto testing        | y       |     |
      | 004          | Auto01             | Primary Email      | Auto testing        | y       |     |
      | 004          | Auto01             | Home Tel           | Auto testing        | y       |     |
      | 004          | Auto02             | Confidential Email | Auto testing        |         | y   |
      | 004          | Auto02             | Fax No.            | Auto testing        | y       |     |
    # BANK DETAIL TAB
    And customer is added bank detail as "<KEY CUSTOMER>"
      | KEY CUSTOMER | Bank   | Description | Account No | Currency | Default | Del |
      | 001          | bank02 |             | 456        | SGD      | y       |     |
      | 001          | V_088  |             | 147        | SGD      | y       | y   |
      | 001          | V_088  |             | 147        | SGD      | y       |     |
      | 002          | bank02 |             | 456        | SGD      | y       |     |
      | 002          | V_088  |             | 147        | SGD      | y       | y   |
      | 002          | V_088  |             | 147        | SGD      | y       |     |
      | 003          | bank02 |             | 456        | SGD      | y       |     |
      | 003          | V_088  |             | 147        | SGD      | y       | y   |
      | 003          | V_088  |             | 147        | SGD      | y       |     |
      | 004          | bank02 |             | 456        | SGD      | y       |     |
      | 004          | V_088  |             | 147        | SGD      | y       | y   |
      | 004          | V_088  |             | 147        | SGD      | y       |     |
    # SBU TAB
    And customer is added SBU as "<KEY CUSTOMER>"
      | KEY CUSTOMER | SBU   | Description | Del |
      | 001          | V_001 |             | y   |
      | 001          | V_001 |             |     |
      | 003          | V_001 |             | y   |
      | 003          | V_001 |             |     |
      | 002          | V_001 |             | y   |
      | 002          | V_001 |             |     |
      | 004          | V_001 |             | y   |
      | 004          | V_001 |             |     |
    #SALES PERSON TAB
    And customer is added sale person as "<KEY CUSTOMER>"
      | KEY CUSTOMER | Sales Person | Name | Default | D Sales | Del |
      | 001          | NANCY1       |      | y       | y       | y   |
      | 001          | NANCY1       |      | y       | y       |     |
      | 001          | HENRY1       |      | y       | y       |     |
      | 002          | NANCY1       |      | y       | y       | y   |
      | 002          | NANCY1       |      | y       | y       |     |
      | 002          | HENRY1       |      | y       | y       |     |
      | 003          | NANCY1       |      | y       | y       | y   |
      | 003          | NANCY1       |      | y       | y       |     |
      | 003          | HENRY1       |      | y       | y       |     |
      | 004          | NANCY1       |      | y       | y       | y   |
      | 004          | NANCY1       |      | y       | y       |     |
      | 004          | HENRY1       |      | y       | y       |     |
    #CURRENCY TAB
    And customer is added currency as "<KEY CUSTOMER>"
      | KEY CUSTOMER | Currency | Del |
      | 001          | SGD      | y   |
      | 001          | SGD      |     |
      | 001          | USD      |     |
      | 002          | SGD      |     |
      | 002          | USD      |     |
      | 003          | SGD      |     |
      | 003          | USD      |     |
      | 004          | SGD      |     |
      | 004          | USD      |     |
    And customer is added payment as "<KEY CUSTOMER>"
      | KEY CUSTOMER | Operational Currency | Next Credit Review Date |
      | 001          | USD                  |                         |
      | 002          | USD                  |                         |
      | 003          | SGD                  |                         |
      | 004          | USD                  |                         |
    And customer is added payment option as "<KEY CUSTOMER>"
      | KEY CUSTOMER | Description      | Is Active | Default |
      | 001          | Advance Payment  |           | Y       |
      | 001          | Cash on Delivery | Y         |         |
      | 002          | Leasing          | Y         |         |
      | 003          | Open Account     | Y         |         |
      | 004          | Trade Financing  |           | Y       |
    And customer is added payment term as "<KEY CUSTOMER>"
      | KEY CUSTOMER | OPTION           | Description      | Is Active | Default |
      | 001          | Advance Payment  | Advance Payment  | Y         | N       |
      | 001          | Cash on Delivery | Cash on Delivery | Y         | N       |
      | 002          | Leasing          | Credit Term      | Y         | N       |
      | 003          | Open Account     | Credit Term      | Y         | N       |
      | 004          | Trade Financing  | DA               | Y         | N       |
      | 004          | Trade Financing  | DP               | Y         | Y       |
      | 004          | Trade Financing  | L/C at Sight     | Y         | N       |
      | 004          | Trade Financing  | L/C              | Y         | N       |
    And customer is added payment menthod as "<KEY CUSTOMER>"
      | KEY CUSTOMER | OPTION           | TERM             | Description          | Is Active | Default |
      | 001          | Advance Payment  | Advance Payment  | Bank Draft           | Y         | N       |
      | 001          | Advance Payment  | Advance Payment  | Credit Card          | Y         | Y       |
      | 001          | Advance Payment  | Advance Payment  | Cheque               | Y         | N       |
      | 001          | Advance Payment  | Advance Payment  | Cash                 | Y         | N       |
      | 001          | Advance Payment  | Advance Payment  | ePayment             | Y         | N       |
      | 001          | Advance Payment  | Advance Payment  | Post Dated Cheque    | Y         | N       |
      | 001          | Advance Payment  | Advance Payment  | Telegraphic Transfer | Y         | N       |
      | 001          | Cash on Delivery | Cash on Delivery | Credit Card          | Y         | N       |
      | 001          | Cash on Delivery | Cash on Delivery | Cheque               | Y         | Y       |
      | 001          | Cash on Delivery | Cash on Delivery | Cash                 | Y         | N       |
      | 001          | Cash on Delivery | Cash on Delivery | Nets                 | Y         | N       |
      | 002          | Leasing          | Credit Term      | Cheque               | Y         | N       |
      | 002          | Leasing          | Credit Term      | Cash                 | Y         | N       |
      | 003          | Open Account     | Credit Term      | Bank Draft           | Y         | N       |
      | 003          | Open Account     | Credit Term      | Credit Card          | Y         | N       |
      | 003          | Open Account     | Credit Term      | Cheque               | Y         | N       |
      | 003          | Open Account     | Credit Term      | Cash                 | Y         | Y       |
      | 003          | Open Account     | Credit Term      | ePayment             | Y         | N       |
      | 003          | Open Account     | Credit Term      | GIRO                 | Y         | N       |
      | 003          | Open Account     | Credit Term      | Post Dated Cheque    | Y         | N       |
      | 003          | Open Account     | Credit Term      | Telegraphic Transfer | Y         | N       |
      | 004          | Trade Financing  | DA               | DA                   | Y         | N       |
      | 004          | Trade Financing  | DP               | DP                   | Y         | N       |
      | 004          | Trade Financing  | L/C at Sight     | L/C at Sight         | Y         | N       |
      | 004          | Trade Financing  | L/C              | L/C                  | Y         | N       |
    And customer is updated
    # LOCAL INFO GET DATA FROM BUNCHA SERVER
    # LOCAL - PRICING TAB
    When customer is added local pricing as "<KEY CUSTOMER>"
      | KEY CUSTOMER | Currency Code | Inventory Price List Code | Service Price List Code |
      |              |               |                           |                         |
    When customer is added local pricing list as "<KEY CUSTOMER>"
      | KEY CUSTOMER | Currency Code | Working Area Code | Inventory Price List Code | Service Price List Code | Del |
      |              |               |                   |                           |                         |     |
    # LOCAL - CREDIT/LIMIT TERM TAB
    When customer is added local credit limit term as "<KEY CUSTOMER>"
      | KEY CUSTOMER | Operational Currency | Credit Limit Amt | Grace Period |
      | 001          | USD                  | 1                | 5            |
      | 001          | SGD                  | 1.5              | 3            |
      | 002          | USD                  | 1                | 5            |
      | 002          | SGD                  | 1.5              | 3            |
      | 003          | USD                  | 1                | 5            |
      | 003          | SGD                  | 1.5              | 3            |
      | 004          | USD                  | 1                | 5            |
      | 004          | SGD                  | 1.5              | 3            |
    # LOCAL - SHIPMENT TERM INFO TAB
    When customer is added local shipment term as "<KEY CUSTOMER>"
      | KEY CUSTOMER | Inc | Shipping Term | Air | Sea | Road | Rail | Default |
      | 001          |     | N01           |     | y   | y    |      | y       |
      | 001          | y   | V_002         | y   | y   | y    | y    |         |
      | 001          |     | V_001         | y   |     |      |      | y       |
      | 002          |     | N01           |     | y   | y    |      | y       |
      | 002          | y   | V_002         | y   | y   | y    | y    |         |
      | 002          |     | V_001         | y   |     |      |      | y       |
      | 003          |     | N01           |     | y   | y    |      | y       |
      | 003          | y   | V_002         | y   | y   | y    | y    |         |
      | 003          |     | V_001         | y   |     |      |      | y       |
      | 004          |     | N01           |     | y   | y    |      | y       |
      | 004          | y   | V_002         | y   | y   | y    | y    |         |
      | 004          |     | V_001         | y   |     |      |      | y       |
    # LOCAL - SHIPMENT PORT INFO TAB
    When customer is added local shipment port as "<KEY CUSTOMER>"
      | KEY CUSTOMER | Country | Loading | Discharge | Final Dest | Del |
      | 001          | sg      | y       | y         | y          |     |
      | 001          | us      |         | y         | y          | y   |
      | 001          | VN      |         |           | y          |     |
      | 002          | sg      | y       | y         | y          |     |
      | 002          | us      |         | y         | y          | y   |
      | 002          | VN      |         |           | y          |     |
      | 003          | sg      | y       | y         | y          |     |
      | 003          | us      |         | y         | y          | y   |
      | 003          | VN      |         |           | y          |     |
      | 004          | sg      | y       | y         | y          |     |
      | 004          | us      |         | y         | y          | y   |
      | 004          | VN      |         |           | y          |     |
    When customer is added local detail port as "<KEY CUSTOMER>"
      | KEY CUSTOMER | Country | Port           | Loading | Discharge | Final Dest |
      | 001          | sg      | SG01-testing 1 | y       |           | y          |
      | 001          | vn      | VN03-          |         |           | y          |
      | 001          | sg      | SG02-testing 2 |         | y         | y          |
      | 002          | sg      | SG01-testing 1 | y       |           | y          |
      | 002          | vn      | VN03-          |         |           | y          |
      | 002          | sg      | SG02-testing 2 |         | y         | y          |
      | 003          | sg      | SG01-testing 1 | y       |           | y          |
      | 003          | vn      | VN03-          |         |           | y          |
      | 003          | sg      | SG02-testing 2 |         | y         | y          |
      | 004          | sg      | SG01-testing 1 | y       |           | y          |
      | 004          | vn      | VN03-          |         |           | y          |
      | 004          | sg      | SG02-testing 2 |         | y         | y          |
    # LOCAL - INVENTORY TAB
    When customer is added local customer inverntory as "<KEY CUSTOMER>"
      | KEY CUSTOMER | Inventory Brand | Discount Code | Discount | Del |
      |              |                 |               |          |     |
    And customer is updated

    Examples: 
      | KEY CUSTOMER |
      | 001          |
      | 002          |

  Scenario Outline: 7. Create Daily Supplier
    Given user login the TH6 system
    When user navigates to "Master Setup>Supplier>Supplier" screen
    And user create supplier as "<KEY SUPPLIER>"
      | KEY SUPPLIER | isContra | Prefix Auto Gen Code | Supplier | Supplier Name  | Supplier Class Code | Party Group Code | Main Home Page | GST Registration No | Country Of Incorporation | Subcon WIP Glan | Sales Tax Code | Default Tenor Term Code | Default Tenor | IPT Related | Status | Unique Entity No | Main Supplier Code | Supplier Short Name | Supplier Category Code | Supplier Rank Code | Purchasing Zone | Party Contra GLAN | Contra Realized Exch GLAN | Default Discount Percent | Combine Shm to Invoices | Remarks | Company      |
      | 001          | N        | nsup                 | Sup01    | Sup01  NOT USE | Supplier            |                  |                |                     |                          |                 | gst0           |                         |               |             |        |                  |                    |                     |                        |                    |                 | 22040             | 22040                     |                          |                         |         | AUTO4, AUTO1 |
      | 002          | N        | nsup                 | Sup02    | Sup02  NOT USE | Supplier            |                  |                |                     |                          |                 | gst0           |                         |               |             |        |                  |                    |                     |                        |                    |                 | 22040             | 22040                     |                          |                         |         | AUTO4, AUTO1 |
      | 003          | Y        | nsup                 | Cus02    |                | Supplier            |                  |                |                     |                          |                 | gst0           |                         |               |             |        |                  |                    |                     |                        |                    |                 | 22040             | 22040                     |                          |                         |         | AUTO4, AUTO1 |
      | 004          | Y        | nsup                 | Cus04    |                | Supplier            |                  |                |                     |                          |                 | gst0           |                         |               |             |        |                  |                    |                     |                        |                    |                 | 22040             | 22040                     |                          |                         |         | AUTO4, AUTO1 |
      | 005          | N        | nsup                 | Sup03    | Sup03 NOT USE  | Supplier            |                  |                |                     |                          |                 | gst0           |                         |               |             |        |                  |                    |                     |                        |                    |                 | 22040             | 22040                     |                          |                         |         | AUTO4, AUTO1 |
      | 006          | N        | nsup                 | Sup04    | Sup04 NOT USE  | Supplier            |                  |                |                     |                          |                 | gst0           |                         |               |             |        |                  |                    |                     |                        |                    |                 | 22040             | 22040                     |                          |                         |         | AUTO4, AUTO1 |
    # ADDRESS TAB
    And supplier is added address as "<KEY SUPPLIER>"
      | KEY SUPPLIER | Address Code | Description    | Address      | Country Code | State Province | City Town | Postal Code | Inc Type                                    | Default                    | LRA | Del |
      | 001          | add01        | auto testing 1 | auto testing | SG           |                |           | 11          | Sales, Bank, Ship to                        | Bank, Ship to              | y   |     |
      | 001          | add02        | auto testing 2 | auto testing | US           |                |           | 12          | Payment to Supplier                         | Payment to Supplier        |     | y   |
      | 001          | add02        | auto testing 2 | auto testing | US           |                |           | 12          | Purchase,  Customer Billing, Service Centre | Customer Billing, Purchase | y   |     |
      | 002          | add01        | auto testing 1 | auto testing | SG           |                |           | 11          | Sales, Bank, Ship to                        | Bank, Ship to              | y   |     |
      | 002          | add02        | auto testing 2 | auto testing | US           |                |           | 12          | Purchase, Customer Billing, Service Centre  | Customer Billing, Purchase | y   |     |
      | 003          | add01        | auto testing 1 | auto testing | SG           |                |           | 11          | Sales, Bank, Ship to                        | Bank, Ship to              | y   |     |
      | 003          | add02        | auto testing 2 | auto testing | US           |                |           | 12          | Purchase,  Customer Billing, Service Centre | Customer Billing, Purchase | y   | y   |
      | 003          | add02        | auto testing 2 | auto testing | US           |                |           | 12          | Purchase,  Customer Billing, Service Centre | Customer Billing, Purchase | y   |     |
      | 004          | add01        | auto testing 1 | auto testing | SG           |                |           | 11          | Sales, Bank, Ship to                        | Bank, Ship to              | y   |     |
      | 004          | add02        | auto testing 2 | auto testing | US           |                |           | 12          | Purchase,  Customer Billing, Service Centre | Customer Billing, Purchase | y   |     |
    And supplier is added address contact type as "<KEY SUPPLIER>"
      | KEY SUPPLIER | Address Code | Contact Type | Contact Information | Default | Del |
      | 001          | add01        | Telephone    | Auto test           | y       | y   |
      | 001          | add01        | Telephone    | Auto test           | y       |     |
      | 001          | add01        | Fax          | Auto test           | y       |     |
      | 001          | add02        | Fax          | Auto test           | y       |     |
      | 002          | add01        | Telephone    | Auto test           | y       |     |
      | 002          | add01        | Fax          | Auto test           | y       |     |
      | 002          | add02        | Fax          | Auto test           | y       |     |
      | 003          | add01        | Telephone    | Auto test           | y       |     |
      | 003          | add01        | Fax          | Auto test           | y       |     |
      | 003          | add02        | Fax          | Auto test           | y       | y   |
      | 003          | add02        | Fax          | Auto test           | y       |     |
      | 004          | add01        | Telephone    | Auto test           | y       |     |
      | 004          | add01        | Fax          | Auto test           | y       |     |
      | 004          | add02        | Fax          | Auto test           | y       |     |
    #CONTACT TAB
    And supplier is added contact as "<KEY SUPPLIER>"
      | KEY SUPPLIER | Party Contact Code | Salutation | First Name | Middle Name | Last Name | Name      | Address Code | Designation  | Designation Group | Department   | Inc Type             | Default             | Del |
      | 001          | Auto01             | Mrs.       | First      | Middle      | Last      | Auto test | add01        | Auto testing | SELE01            | Auto testing | Sales, Bank, Ship to | Bank, Ship to       | y   |
      | 001          | Auto01             | Mrs.       | First      | Middle      | Last      | Auto test | add01        | Auto testing | SELE01            | Auto testing | Sales, Bank, Ship to | Bank, Ship to       |     |
      | 001          | Auto02             | Mr.        | First      | Middle      | Last      | Auto test | add02        | Auto testing | SELE01            | Auto testing | Payment to Supplier  | Payment to Supplier |     |
      | 002          | Auto01             | Mrs.       | First      | Middle      | Last      | Auto test | add01        | Auto testing | SELE01            | Auto testing | Sales, Bank, Ship to | Bank, Ship to       |     |
      | 002          | Auto02             | Mr.        | First      | Middle      | Last      | Auto test | add02        | Auto testing | SELE01            | Auto testing | Payment to Supplier  | Payment to Supplier |     |
      | 003          | Auto01             | Mrs.       | First      | Middle      | Last      | Auto test | add01        | Auto testing | SELE01            | Auto testing | Sales, Bank, Ship to | Bank, Ship to       | y   |
      | 003          | Auto01             | Mrs.       | First      | Middle      | Last      | Auto test | add01        | Auto testing | SELE01            | Auto testing | Sales, Bank, Ship to | Bank, Ship to       |     |
      | 003          | Auto02             | Mr.        | First      | Middle      | Last      | Auto test | add02        | Auto testing | SELE01            | Auto testing | Payment to Supplier  | Payment to Supplier |     |
      | 004          | Auto01             | Mrs.       | First      | Middle      | Last      | Auto test | add01        | Auto testing | SELE01            | Auto testing | Sales, Bank, Ship to | Bank, Ship to       |     |
      | 004          | Auto02             | Mr.        | First      | Middle      | Last      | Auto test | add02        | Auto testing | SELE01            | Auto testing | Payment to Supplier  | Payment to Supplier |     |
    And supplier is added contact type as "<KEY SUPPLIER>"
      | KEY SUPPLIER | Party Contact Code | Contact Type       | Contact Information | Default | Del |
      | 001          | Auto01             | Pager              | Auto testing        | y       | y   |
      | 001          | Auto01             | Pager              | Auto testing        | y       |     |
      | 001          | Auto01             | Primary Email      | Auto testing        | y       |     |
      | 001          | Auto01             | Home Tel           | Auto testing        | y       |     |
      | 001          | Auto02             | Confidential Email | Auto testing        |         | y   |
      | 001          | Auto02             | Fax No.            | Auto testing        | y       |     |
      | 002          | Auto01             | Pager              | Auto testing        | y       | y   |
      | 002          | Auto01             | Pager              | Auto testing        | y       |     |
      | 002          | Auto01             | Primary Email      | Auto testing        | y       |     |
      | 002          | Auto01             | Home Tel           | Auto testing        | y       |     |
      | 002          | Auto02             | Confidential Email | Auto testing        |         | y   |
      | 002          | Auto02             | Fax No.            | Auto testing        | y       |     |
      | 003          | Auto01             | Pager              | Auto testing        | y       | y   |
      | 003          | Auto01             | Pager              | Auto testing        | y       |     |
      | 003          | Auto01             | Primary Email      | Auto testing        | y       |     |
      | 003          | Auto01             | Home Tel           | Auto testing        | y       |     |
      | 003          | Auto02             | Confidential Email | Auto testing        |         | y   |
      | 003          | Auto02             | Fax No.            | Auto testing        | y       |     |
      | 004          | Auto01             | Pager              | Auto testing        | y       | y   |
      | 004          | Auto01             | Pager              | Auto testing        | y       |     |
      | 004          | Auto01             | Primary Email      | Auto testing        | y       |     |
      | 004          | Auto01             | Home Tel           | Auto testing        | y       |     |
      | 004          | Auto02             | Confidential Email | Auto testing        |         | y   |
      | 004          | Auto02             | Fax No.            | Auto testing        | y       |     |
    # BANK DETAIL TAB
    And supplier is added bank detail as "<KEY SUPPLIER>"
      | KEY SUPPLIER | Bank   | Description | Account No | Currency | Default | Del |
      | 001          | bank02 |             | 456        | USD      | y       |     |
      | 001          | V_088  |             | 147        | USD      | y       | y   |
      | 001          | V_088  |             | 147        | USD      | y       |     |
      | 002          | bank02 |             | 456        | USD      | y       |     |
      | 002          | V_088  |             | 147        | USD      | y       | y   |
      | 002          | V_088  |             | 147        | USD      | y       |     |
      | 003          | bank02 |             | 456        | USD      | y       |     |
      | 003          | V_088  |             | 147        | USD      | y       | y   |
      | 003          | V_088  |             | 147        | USD      | y       |     |
      | 004          | bank02 |             | 456        | USD      | y       |     |
      | 004          | V_088  |             | 147        | USD      | y       | y   |
      | 004          | V_088  |             | 147        | USD      | y       |     |
    # SBU TAB
    And supplier is added SBU as "<KEY SUPPLIER>"
      | KEY SUPPLIER | SBU   | Description | Del |
      | 001          | V_001 |             | y   |
      | 001          | V_001 |             |     |
      | 003          | V_001 |             | y   |
      | 003          | V_001 |             |     |
      | 002          | V_001 |             | y   |
      | 002          | V_001 |             |     |
      | 004          | V_001 |             | y   |
      | 004          | V_001 |             |     |
    #CURRENCY TAB
    And supplier is added currency as "<KEY SUPPLIER>"
      | KEY SUPPLIER | Currency | Del |
      | 001          | SGD      | y   |
      | 001          | SGD      |     |
      | 001          | USD      |     |
      | 002          | SGD      |     |
      | 002          | USD      |     |
      | 003          | SGD      |     |
      | 003          | USD      |     |
      | 004          | SGD      |     |
      | 004          | USD      |     |
    # PAYMENT TAB
    And supplier is added payment as "<KEY SUPPLIER>"
      | KEY SUPPLIER | Operational Currency | Overall Credit Limit |
      | 001          | USD                  | 3                    |
      | 002          | USD                  | 4                    |
      | 003          | SGD                  | 5                    |
      | 004          | USD                  | 6                    |
    And supplier is added payment option as "<KEY SUPPLIER>"
      | KEY SUPPLIER | Description      | Is Active | Default |
      | 001          | Advance Payment  |           | Y       |
      | 001          | Cash on Delivery | Y         |         |
      | 002          | Leasing          | Y         |         |
      | 003          | Open Account     | Y         |         |
      | 004          | Trade Financing  |           | Y       |
    And supplier is added payment term as "<KEY SUPPLIER>"
      | KEY SUPPLIER | OPTION           | Description      | Is Active | Default |
      | 001          | Advance Payment  | Advance Payment  | Y         | N       |
      | 001          | Cash on Delivery | Cash on Delivery | Y         | N       |
      | 002          | Leasing          | Credit Term      | Y         | N       |
      | 003          | Open Account     | Credit Term      | Y         | N       |
      | 004          | Trade Financing  | DA               | Y         | N       |
      | 004          | Trade Financing  | DP               | Y         | Y       |
      | 004          | Trade Financing  | L/C at Sight     | Y         | N       |
      | 004          | Trade Financing  | L/C              | Y         | N       |
    And supplier is added payment menthod as "<KEY SUPPLIER>"
      | KEY SUPPLIER | OPTION           | TERM             | Description          | Is Active | Default |
      | 001          | Advance Payment  | Advance Payment  | Bank Draft           | Y         | N       |
      | 001          | Advance Payment  | Advance Payment  | Credit Card          | Y         | Y       |
      | 001          | Advance Payment  | Advance Payment  | Cheque               | Y         | N       |
      | 001          | Advance Payment  | Advance Payment  | Cash                 | Y         | N       |
      | 001          | Advance Payment  | Advance Payment  | ePayment             | Y         | N       |
      | 001          | Advance Payment  | Advance Payment  | Post Dated Cheque    | Y         | N       |
      | 001          | Advance Payment  | Advance Payment  | Telegraphic Transfer | Y         | N       |
      | 001          | Cash on Delivery | Cash on Delivery | Credit Card          | Y         | N       |
      | 001          | Cash on Delivery | Cash on Delivery | Cheque               | Y         | Y       |
      | 001          | Cash on Delivery | Cash on Delivery | Cash                 | Y         | N       |
      | 001          | Cash on Delivery | Cash on Delivery | Nets                 | Y         | N       |
      | 002          | Leasing          | Credit Term      | Cheque               | Y         | N       |
      | 002          | Leasing          | Credit Term      | Cash                 | Y         | N       |
      | 003          | Open Account     | Credit Term      | Bank Draft           | Y         | N       |
      | 003          | Open Account     | Credit Term      | Credit Card          | Y         | N       |
      | 003          | Open Account     | Credit Term      | Cheque               | Y         | N       |
      | 003          | Open Account     | Credit Term      | Cash                 | Y         | Y       |
      | 003          | Open Account     | Credit Term      | ePayment             | Y         | N       |
      | 003          | Open Account     | Credit Term      | GIRO                 | Y         | N       |
      | 003          | Open Account     | Credit Term      | Post Dated Cheque    | Y         | N       |
      | 003          | Open Account     | Credit Term      | Telegraphic Transfer | Y         | N       |
      | 004          | Trade Financing  | DA               | DA                   | Y         | N       |
      | 004          | Trade Financing  | DP               | DP                   | Y         | N       |
      | 004          | Trade Financing  | L/C at Sight     | L/C at Sight         | Y         | N       |
      | 004          | Trade Financing  | L/C              | L/C                  | Y         | N       |
    And supplier is updated
    # LOCAL INFO TAB
    And supplier is added local shipment term as "<KEY SUPPLIER>"
      | KEY SUPPLIER | Inc | Shipping Term | Air | Sea | Road | Rail | Default |
      | 001          |     | N01           |     | y   | y    |      | y       |
      | 001          | y   | V_002         | y   | y   | y    | y    |         |
      | 001          |     | V_001         | y   |     |      |      | y       |
      | 002          |     | N01           |     | y   | y    |      | y       |
      | 002          | y   | V_002         | y   | y   | y    | y    |         |
      | 002          |     | V_001         | y   |     |      |      | y       |
      | 003          |     | N01           |     | y   | y    |      | y       |
      | 003          | y   | V_002         | y   | y   | y    | y    |         |
      | 003          |     | V_001         | y   |     |      |      | y       |
      | 004          |     | N01           |     | y   | y    |      | y       |
      | 004          | y   | V_002         | y   | y   | y    | y    |         |
      | 004          |     | V_001         | y   |     |      |      | y       |
    And supplier is added local shipment country as "<KEY SUPPLIER>"
      | KEY SUPPLIER | Country | Loading | Discharge | Final Dest | Del |
      | 001          | sg      | y       | y         | y          |     |
      | 001          | us      |         | y         | y          | y   |
      | 001          | VN      |         |           | y          |     |
      | 002          | sg      | y       | y         | y          |     |
      | 002          | us      |         | y         | y          | y   |
      | 002          | VN      |         |           | y          |     |
      | 003          | sg      | y       | y         | y          |     |
      | 003          | us      |         | y         | y          | y   |
      | 003          | VN      |         |           | y          |     |
      | 004          | sg      | y       | y         | y          |     |
      | 004          | us      |         | y         | y          | y   |
      | 004          | VN      |         |           | y          |     |
    And supplier is added local shipment port as "<KEY SUPPLIER>"
      | KEY SUPPLIER | Country | Port           | Loading | Dischange | Final Dest |
      | 001          | sg      | SG01-testing 1 | y       |           | y          |
      | 001          | vn      | VN03-          |         |           | y          |
      | 001          | sg      | SG02-testing 2 |         | y         | y          |
      | 002          | sg      | SG01-testing 1 | y       |           | y          |
      | 002          | vn      | VN03-          |         |           | y          |
      | 002          | sg      | SG02-testing 2 |         | y         | y          |
      | 003          | sg      | SG01-testing 1 | y       |           | y          |
      | 003          | vn      | VN03-          |         |           | y          |
      | 003          | sg      | SG02-testing 2 |         | y         | y          |
      | 004          | sg      | SG01-testing 1 | y       |           | y          |
      | 004          | vn      | VN03-          |         |           | y          |
      | 004          | sg      | SG02-testing 2 |         | y         | y          |
    And supplier is added local default setting as "<KEY SUPPLIER>"
      | KEY SUPPLIER | Deduct Charge Flag | Delivery To For nonCC | Delivery Mode   |
      | 001          | Beneficiary Party  | Beneficiary Party     | Registered Mail |
      | 002          | Beneficiary Party  | Beneficiary Party     | Registered Mail |
      | 003          | Beneficiary Party  | Beneficiary Party     | Registered Mail |
      | 004          | Beneficiary Party  | Beneficiary Party     | Registered Mail |
    And supplier is updated

    Examples: 
      | KEY SUPPLIER |
      | 001          |
      | 003          |

  Scenario Outline: 7b. Run Bank Daily
    Given user login the taskhub system
    And user navigates to "Master Setup>Party>Party" screen
    When user create bank as "<KEY BANK>"
      | KEY BANK | Prefix | Party Code       | Party Name      | Party Short Name | Party Group Code | Country Of Incorporation | Main Home Page | Tax Agent | GST Registration No | Unique Entity No | Party Contra GLAN | Contra Realized Exch GLAN | Company      |
      | 001      | nbank  | NBANK15061616220 | NOT USE- BANK01 |                  |                  |                          |                |           |                     |                  | 22040             | 22040                     | AUTO4, AUTO1 |
      | 002      | nbank  | NBANK15061616222 | NOT USE- BANK02 |                  |                  |                          |                |           |                     |                  | 22040             | 22040                     | AUTO4, AUTO1 |
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
      | 002      | 54321      |             | SGD           | 28011     |                |                       |                       | y   |
      | 002      | 54321      |             | SGD           | 28011     |                |                       |                       |     |
    And bank is updated

    Examples: 
      | KEY BANK |
      | 001      |
      | 002      |

  Scenario Outline: 8. Create Unit of Measurement with feature
    Given user login the TH6 system
    And user navigates to "Master Setup>Inventory>Unit of Measurement" screen
    When user create unit of measurement as "<KEY UOM>"
      | KEY UOM | UOM Code | Description | Type               | Company      |
      | 001     | nauto    | NOT USE     | Inventory, Service | AUTO4, AUTO1 |
      | 001     | nbox     | NOT USE     | Inventory, Service | AUTO4, AUTO1 |
      | 001     | nkm      | NOT USE     | Inventory, Service | AUTO4, AUTO1 |
      | 001     | npiece   | NOT USE     | Inventory, Service | AUTO4, AUTO1 |

    Examples: 
      | KEY UOM |
      | 001     |

  Scenario Outline: 9. Create Service with feature file
    Given user login the TH6 system
    And user navigates to "Master Setup>Service>Service" screen
    When user create service as "<KEY SERVICE>"
      | KEY SERVICE | Service Code | Service Description | Service Category | UOM    | Track Qty in Project | Budget Category Code | Service Type                                     | Revenue Status | Revenue GLAN | Unearned Revenue GLAN | Sales Accrual GLAN | Report Grouping | Default Sales Tax | Intercompany Sales Tax | Expense Status | Expense GLAN | Accrued Cost GLAN | Overhead GLAN | Company      |
      | 001         | NS1          | NOT USE             |                  | vpiece |                      |                      | Expense (Additional Payment),Revenue (Deduction) | Active         | 51040        | 21020                 |                    |                 | ngst0             |                        | Active         | 60030        | 43010             |               | AUTO4, AUTO1 |
      | 002         | NS2          | NOT USE             |                  | vpiece |                      |                      | Expense (Additional Payment),Revenue (Deduction) | Active         | 51040        | 21020                 |                    |                 | ngst0             |                        | Active         | 60030        | 43010             |               | AUTO4, AUTO1 |
    And service is added service relation as "<KEY SERVICE>"
      | KEY SERVICE | Party Type Group | Party Type        | Revenue | Expense |
      | 001         | Customer         | Products/Services | y       | y       |
      | 001         | Customer         | Retailer          | y       | y       |
      | 001         | Service Vendor   | Services          | y       | y       |
      | 001         | Supplier         | Retail            | y       | y       |
      | 001         | Supplier         | Supplier          | y       | y       |
      | 002         | Customer         | Products/Services | y       | y       |
      | 002         | Customer         | Retailer          | y       | y       |
      | 002         | Service Vendor   | Services          | y       | y       |
      | 002         | Supplier         | Retail            | y       | y       |
      | 002         | Supplier         | Supplier          | y       | y       |
    And service is updated

    Examples: 
      | KEY SERVICE |
      | 001         |
      | 002         |

  Scenario Outline: 10. Create new fixed asset class
    Given user login the TH6 system
    When user navigates to "Master Setup>Fixed Asset>Class" screen
    And user creates fixed asset class as "<KEY FA>"
      | KEY FA | Fixed Asset Class Code | Description | Fixed Asset GLAN | Depreciation GLAN | Cumulative Depreciation GLAN | Gain Loss Disposal GLAN | Disposal Clearing GLAN | Fixed Asset Clearing GLAN | Project Utilization Glan | Company |
      | 001    | NFA1                   | NOT USE     | 11000            | 87040             | 11000                        | 86040                   | 12000                  | Z-100                     |                          |         |
      | 001    | NFA2                   | NOT USE     | 11020            | 87070             | 11000                        | 86040                   | 12000                  | Z-100                     |                          |         |
      | 001    | NFA3                   | NOT USE     | 11020            | 87070             | 11000                        | 86040                   | 12000                  | Z-100                     |                          |         |

    Examples: 
      | KEY FA |
      | 001    |

  Scenario Outline: 11. Create new fixed asset category
    Given user login the TH6 system
    When user navigates to "Master Setup>Fixed Asset>Category" screen
    And user creates fixed asset category as "<KEY FA>"
      | KEY FA | Fixed Asset Category Code | Description | Company      |
      | 001    | NFA-CATE01                | NOT USE     | AUTO1, AUTO4 |
      | 001    | NFA-CATE02                | NOT USE     | AUTO1, AUTO4 |
      | 001    | NFA-CATE03                | NOT USE     | AUTO1, AUTO4 |

    Examples: 
      | KEY FA |
      | 001    |

  Scenario Outline: 12. Create new fixed asset location
    Given user login the TH6 system
    When user navigates to "Master Setup>Fixed Asset>Location" screen
    And user creates fixed asset location as "<KEY FA>"
      | KEY FA | Fixed Asset Location Code | Fixed Asset Location Name | Company |
      | 001    | NSG                       | NOT USE                   |         |
      | 001    | NVN                       | NOT USE                   |         |
      | 001    | NML                       | NOT USE                   |         |

    Examples: 
      | KEY FA |
      | 001    |
@n-fin-daily
  Scenario Outline: 13. Create new Global Fixed Asset
    Given user login the TH6 system
    When user navigates to "Master Setup>Fixed Asset>Fixed Asset>[1]" screen
    And user creates global fixed asset as "<KEY FA>"
      | KEY FA | Fixed Asset Code | Description | Detailed Specification | Fixed Asset Class | Fixed Asset Category | Depreciation Method      | Rate On Declining Balance | Percentage of Straight Line Rate | Useful Life Year | Useful Life Period | Total Useful Life | Global Status | UOM    | Volume | Gross Weight | Location | Local Info Status | Company |
      | 001    | NFA1             | NOT USE     |                        | nFA1              |                      | Straight Line per Period |                           |                                  | 1                | 0                  |                   |               | npiece |        |              |          |                   |         |

    Examples: 
      | KEY FA |
      | 001    |

  ###############################################################################
  ###############################################################################
  # *************************** MAINTENANCE SETUP *******************************

  Scenario Outline: 14. Set Exchange Rate with feature file
    Given user login the TH6 system
    And user navigates to "Master Setup>Currency>Exchange Rate" screen
    When user set exchange rate as "<KEY RATE>"
      | KEY RATE | Currency |
      | 001      | n04      |
      | 002      | n05      |
      | 003      | n06      |
    And exchange rate is added date as "<KEY RATE>"
      | KEY RATE | Effective Date From | Effective Date To | Upwards Variance Allowed | Downwards Variance Allowed | Bank Sell Rate | Bank Buy Rate | Revaluation Rate |
      | 001      | 01/01/2014          | 31/12/2014        | 100                      | 100                        | 1.5            | 1.5           |                  |
      | 001      | 01/01/2015          | 31/12/2015        | 100                      | 100                        | 1.5            | 1.5           |                  |
      | 001      | 01/01/2016          | 31/12/2016        | 100                      | 100                        | 1.5            | 1.5           |                  |
      | 002      | 01/01/2014          | 31/12/2014        | 100                      | 100                        | 1              | 1             |                  |
      | 002      | 01/01/2015          | 31/12/2015        | 100                      | 100                        | 1              | 1             |                  |
      | 002      | 01/01/2016          | 31/12/2016        | 100                      | 100                        | 1              | 1             |                  |
      | 003      | 01/01/2014          | 31/12/2014        | 100                      | 100                        | 1.7            | 1.7           |                  |
      | 003      | 01/01/2015          | 31/12/2015        | 100                      | 100                        | 1.7            | 1.7           |                  |
      | 003      | 01/01/2016          | 31/12/2016        | 100                      | 100                        | 1.7            | 1.7           |                  |

    Examples: 
      | KEY RATE |
      | 001      |
      | 002      |
      | 003      |

  Scenario Outline: 15. Create Segment with feature file
    Given user login the TH6 system
    And user navigates to "Master Setup>Segment>Segment" screen
    When user create segment as "<KEY SGMT>"
      | KEY SGMT | Segment No | Segment Name |
      | 001      | 1          | Seg 1        |
      | 002      | 2          | Seg 2        |
      | 003      | 3          | Seg 3        |
      | 004      | 4          | Seg 4        |
    And segment is added detail as "<KEY SGMT>"
      | KEY SGMT | Segment Code | Description | Del |
      | 001      | NSeg1        | NOT USE     |     |
      | 002      | NSeg2        | NOT USE     |     |
      | 003      | NSeg3        | NOT USE     |     |
      | 004      | NSeg4        | NOT USE     |     |
      | 001      | NNA          | NOT USE     |     |
      | 002      | NNA          | NOT USE     |     |
      | 003      | NNA          | NOT USE     |     |
      | 004      | NNA          | NOT USE     |     |

    Examples: 
      | KEY SGMT |
      | 001      |
      | 002      |
      | 003      |
      | 004      |

  Scenario Outline: 16. Create Bank Book Recurring Template with feature file
    Given user login the TH6 system
    And user navigates to "Master Setup>Financial>Accounting>Bank Book Recurring Template" screen
    When user create BK recurring template as "<KEY BK>"
      | KEY BK | Bank Template Code | Template Description | Bank Voucher Description | Recurring Frequency | Recurring Day | Recurrence Start Date | Recurrence End Date | Last Recurred Date | Transaction Type |
      | 001    | NBT01              | NOT USE              |                          |                     | 3             |                       |                     |                    | Deposit          |
      | 002    | NBT02              | NOT USE              |                          |                     | 3             |                       |                     |                    | Fund Transfer    |
      | 003    | NBT03              | NOT USE              |                          |                     | 3             |                       |                     |                    | Withdrawal       |
    And BK recurring template is deposit as "<KEY BK>"
      | KEY BK | Mode of Deposit | Deposit bankk A/c No | Currency | Deposit Slip No | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 001    |                 | bank01               | n02      |                 | NNA       | NNA       | NNA       | NNA       |
    And BK deposit is added detail as "<KEY BK>"
      | KEY BK | Received From | Cheque No. | Amount | Sales Tax | Document No | Doc Date | Segment 1 | Segment 2 | Segment 3 | Segment 4 | Del |
      | 001    | ns1           | 2          | 10000  |           |             |          | NNA       | NNA       | NNA       | NNA       |     |
    And BK recurring template is fund transfer as "<KEY BK>"
      | KEY BK | Remittance Bank A/c No (Code > No.) | Destination Bank A/c No (Code > No.) | Transfer Amount | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 002    | bank01 > 12345                      | bank01 > 54321                       | 10000           | NNA       | NNA       | NNA       | NNA       |
    And BK recurring template is withdrawal as "<KEY BK>"
      | KEY BK | Mode of Withdrawal | Withdrawal Bank A/C No | Currency | Withdrawal Slip No | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 003    |                    | bank01                 | n01      |                    | NNA       | NNA       | NNA       | NNA       |
    And BK withdrawal is added detail as "<KEY BK>"
      | KEY BK | Paid to | Cheque No. | Amount | Sales Tax | Document No | Doc Date | Segment 1 | Segment 2 | Segment 3 | Segment 4 | Del |
      | 003    | ns1     | 2          | 1000   |           |             |          | NNA       | NNA       | NNA       | NNA       |     |

    Examples: 
      | KEY BK |
      | 001    |
      | 002    |
      | 003    |

  Scenario Outline: 17. Create MT GL Recurring Voucher with feature file
    Given user login the TH6 system
    And user navigates to "Master Setup>Financial>Accounting>GL Recurring Voucher" screen
    When user create MT GL Recurring VCH as "<KEY RECURRING>"
      | KEY RECURRING | Recurring Voucher Code | Description | Currency | Exchange Rate Type | Source Document Type | Source Document No | Recurring Day | Recurring Frequency | Recurrence Start Date | Recurrence End Date | Next Recurrence Date | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 001           | NRVC01                 | NOT USE     | n01      |                    |                      |                    |               |                     |                       |                     |                      | NNA       | NNA       | NNA       | NNA       |
      | 002           | NRVC02                 | NOT USE     | n01      |                    |                      |                    |               |                     |                       |                     |                      | NNA       | NNA       | NNA       | NNA       |
    And MT GL recurring vch is add detail as "<KEY RECURRING>"
      | KEY RECURRING | GL Account Code | Description  | Nature Debit | Natural Credit | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 001           | 22010           | auto testing | 10000        |                | NNA       | NNA       | NNA       | NNA       |
      | 001           | 22020           | auto testing |              | 10000          | NNA       | NNA       | NNA       | NNA       |
      | 002           | 22010           | auto testing | 10000        |                | NNA       | NNA       | NNA       | NNA       |
      | 002           | 22020           | auto testing |              | 10000          | NNA       | NNA       | NNA       | NNA       |
    And user close MT GL Recurring VCH

    Examples: 
      | KEY RECURRING |
      | 001           |
      | 002           |

  Scenario: 18. Create MT GL Revaluation with feature file
    Given user login the TH6 system
    When user navigates to "Master Setup>Financial>Accounting>GL Revaluation" screen
    And user create GL revaluation
      | GL Account Code | Description | Unrealised Gain Loss GLAN |
      | n11020          | NOT USE     | 86060                     |
      | n10040          | NOT USE     | 86060                     |
      | nZ-400          | NOT USE     | 86060                     |
      | nZ-500          | NOT USE     | 86060                     |
