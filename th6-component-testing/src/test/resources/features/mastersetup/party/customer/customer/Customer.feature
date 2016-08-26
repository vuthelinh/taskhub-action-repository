Feature: Customer

  Scenario Outline: Create Customer
    Given user login the TH6 system
    And user navigates to "Master Setup>Customer>Customer" screen
    When user create customer as "<KEY CUSTOMER>"
      | KEY CUSTOMER | Prefix Auto Gen Code | Customer Code | Unique Entity No | Customer Name                            | Customer Class Code | Party Group Code | Industry Code | Acquired By | Country Of Incorporation | Sales Tax Code | Contra Realized Exch GLAN | Statement Delivery Option | Default Tenor | Discount | Due AR Invoice Correspondence Language | Customer Remarks | Status | Main Customer Code | Customer Short Name | Customer Category Code | Customer Group Code | Customer Type | Main Home Page | GST Registration No | Party Contra GLAN | Default Validity | Default Tenor Term Code | Price Markup Percent | Combine Shm to Invoices | IPT Related | Shipping Marks Code | Company      |
      | 001          | ncus                 | Cus01         |                  | Cus01 for Synergix Testing ONLY          | CUSTOMER            |                  |               |             |                          | GST7           | 43010                     |                           |               |          |                                        |                  |        |                    | Auto test 1         |                        |                     |               |                |                     | 22040             |                  |                         |                      |                         |             |                     | AUTO4, AUTO1 |
      | 002          | ncus                 | Cus02         |                  | Cus02 - contra for Synergix Testing ONLY | CUSTOMER            |                  |               |             |                          | GST0           | 43010                     |                           |               |          |                                        |                  |        |                    | Auto test 2         |                        |                     |               |                |                     | 22040             |                  |                         |                      |                         |             |                     | AUTO4, AUTO1 |
      | 003          | ncus                 | Cus03         |                  | Cus03 for Synergix Testing ONLY          | CUSTOMER            |                  |               |             |                          | GST7           | 43010                     |                           |               |          |                                        |                  |        |                    | Auto test 3         |                        |                     |               |                |                     | 22040             |                  |                         |                      |                         |             |                     | AUTO4, AUTO1 |
      | 004          | ncus                 | Cus04         |                  | Cus04 - contra for Synergix Testing ONLY | CUSTOMER            |                  |               |             |                          | GST0           | 43010                     |                           |               |          |                                        |                  |        |                    | Auto test 4         |                        |                     |               |                |                     | 22040             |                  |                         |                      |                         |             |                     | AUTO4, AUTO1 |
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
      | 001          | bank02 |             | 456        | sgd      | y       |     |
      | 001          | V_088  |             | 147        | sgd      | y       | y   |
      | 001          | V_088  |             | 147        | sgd      | y       |     |
      | 002          | bank02 |             | 456        | sgd      | y       |     |
      | 002          | V_088  |             | 147        | sgd      | y       | y   |
      | 002          | V_088  |             | 147        | sgd      | y       |     |
      | 003          | bank02 |             | 456        | sgd      | y       |     |
      | 003          | V_088  |             | 147        | sgd      | y       | y   |
      | 003          | V_088  |             | 147        | sgd      | y       |     |
      | 004          | bank02 |             | 456        | sgd      | y       |     |
      | 004          | V_088  |             | 147        | sgd      | y       | y   |
      | 004          | V_088  |             | 147        | sgd      | y       |     |
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
      | 001          | USD      | y   |
      | 001          | USD      |     |
      | 001          | SGD      |     |
      | 002          | USD      |     |
      | 002          | SGD      |     |
      | 003          | USD      |     |
      | 003          | SGD      |     |
      | 004          | USD      |     |
      | 004          | SGD      |     |
    And customer is added payment as "<KEY CUSTOMER>"
      | KEY CUSTOMER | Operational Currency | Next Credit Review Date |
      | 001          | SGD                  |                         |
      | 002          | SGD                  |                         |
      | 003          | USD                  |                         |
      | 004          | SGD                  |                         |
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
      | 001          | SGD                  | 1                | 5            |
      | 001          | USD                  | 1.5              | 3            |
      | 002          | SGD                  | 1                | 5            |
      | 002          | USD                  | 1.5              | 3            |
      | 003          | SGD                  | 1                | 5            |
      | 003          | USD                  | 1.5              | 3            |
      | 004          | SGD                  | 1                | 5            |
      | 004          | USD                  | 1.5              | 3            |
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
      | 003          |

  Scenario Outline: Update Customer
    Given user login the TH6 system
    And user navigates to "Master Setup>Customer>Customer" screen
    When user update customer as "<KEY CUSTOMER>"
      | KEY CUSTOMER | Prefix Auto Gen Code | Customer Code | Unique Entity No | Customer Name                            | Customer Class Code | Party Group Code | Industry Code | Acquired By | Country Of Incorporation | Sales Tax Code | Contra Realized Exch GLAN | Statement Delivery Option | Default Tenor | Discount | Due AR Invoice Correspondence Language | Customer Remarks | Status | Main Customer Code | Customer Short Name | Customer Category Code | Customer Group Code | Customer Type | Main Home Page | GST Registration No | Party Contra GLAN | Default Validity | Default Tenor Term Code | Price Markup Percent | Combine Shm to Invoices | IPT Related | Shipping Marks Code | Company      |
      | 001          | ncus                 | Cus01         |                  | Cus01 for Synergix Testing ONLY          | CUSTOMER            |                  |               |             |                          | GST7           | 43010                     |                           |               |          |                                        |                  |        |                    | Auto test 1         |                        |                     |               |                |                     | 22040             |                  |                         |                      |                         |             |                     | AUTO4, AUTO1 |
      | 002          | ncus                 | Cus02         |                  | Cus02 - contra for Synergix Testing ONLY | CUSTOMER            |                  |               |             |                          | GST0           | 43010                     |                           |               |          |                                        |                  |        |                    | Auto test 2         |                        |                     |               |                |                     | 22040             |                  |                         |                      |                         |             |                     | AUTO4, AUTO1 |
      | 003          | ncus                 | Cus03         |                  | Cus03 for Synergix Testing ONLY          | CUSTOMER            |                  |               |             |                          | GST7           | 43010                     |                           |               |          |                                        |                  |        |                    | Auto test 3         |                        |                     |               |                |                     | 22040             |                  |                         |                      |                         |             |                     | AUTO4, AUTO1 |
      | 004          | ncus                 | Cus04         |                  | Cus04 - contra for Synergix Testing ONLY | CUSTOMER            |                  |               |             |                          | GST0           | 43010                     |                           |               |          |                                        |                  |        |                    | Auto test 4         |                        |                     |               |                |                     | 22040             |                  |                         |                      |                         |             |                     | AUTO4, AUTO1 |

    Examples: 
      | KEY CUSTOMER |
      | 001          |
      | 002          |
      | 003          |
