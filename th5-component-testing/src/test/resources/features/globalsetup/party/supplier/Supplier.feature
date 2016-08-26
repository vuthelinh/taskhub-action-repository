@n-sup
Feature: Supplier

  Scenario Outline: Create Supplier
    Given user login the taskhub system
    When user navigates to "Global Setup>Party>Supplier>Supplier" screen
    And user create supplier as "<KEY SUPPLIER>"
      | KEY SUPPLIER | isContra | Prefix Auto Gen Code | Supplier | Supplier Name                          | Supplier Class Code | Party Group Code | Main Home Page | GST Registration No | Country Of Incorporation | Subcon WIP Glan | Sales Tax Code | Default Tenor Term Code | Default Tenor | IPT Related | Status | Unique Entity No | Main Supplier Code | Supplier Short Name | Supplier Category Code | Supplier Rank Code | Purchasing Zone | Party Contra GLAN | Contra Realized Exch GLAN | Default Discount Percent | Combine Shm to Invoices | Remarks | Company      |
      | 001          | N        |                      | Sup01    | Supplier 01  for Synergix Testing ONLY | Supplier            |                  |                |                     |                          |                 | gst0           |                         |               |             |        |                  |                    |                     |                        |                    |                 | 22040             | 22040                     |                          |                         |         | AUTO4, AUTO1 |
      | 002          | N        |                      | Sup02    | Supplier 02  for Synergix Testing ONLY | Supplier            |                  |                |                     |                          |                 | gst0           |                         |               |             |        |                  |                    |                     |                        |                    |                 | 22040             | 22040                     |                          |                         |         | AUTO4, AUTO1 |
      | 003          | Y        |                      | Cus02    |                                        | Supplier            |                  |                |                     |                          |                 | gst0           |                         |               |             |        |                  |                    |                     |                        |                    |                 | 22040             | 22040                     |                          |                         |         | AUTO4, AUTO1 |
      | 004          | Y        |                      | Cus04    |                                        | Supplier            |                  |                |                     |                          |                 | gst0           |                         |               |             |        |                  |                    |                     |                        |                    |                 | 22040             | 22040                     |                          |                         |         | AUTO4, AUTO1 |
      | 005          | N        |                      | Sup03    | Supplier 03  for Synergix Testing ONLY | Supplier            |                  |                |                     |                          |                 | gst0           |                         |               |             |        |                  |                    |                     |                        |                    |                 | 22040             | 22040                     |                          |                         |         | AUTO4, AUTO1 |
      | 006          | N        |                      | Sup04    | Supplier 04  for Synergix Testing ONLY | Supplier            |                  |                |                     |                          |                 | gst0           |                         |               |             |        |                  |                    |                     |                        |                    |                 | 22040             | 22040                     |                          |                         |         | AUTO4, AUTO1 |
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
      | 001          | USD      | y   |
      | 001          | USD      |     |
      | 001          | SGD      |     |
      | 002          | USD      |     |
      | 002          | SGD      |     |
      | 003          | USD      |     |
      | 003          | SGD      |     |
      | 004          | USD      |     |
      | 004          | SGD      |     |
    # PAYMENT TAB
    And supplier is added payment as "<KEY SUPPLIER>"
      | KEY SUPPLIER | Operational Currency | Overall Credit Limit |
      | 001          | SGD                  | 3                    |
      | 002          | SGD                  | 4                    |
      | 003          | USD                  | 5                    |
      | 004          | SGD                  | 6                    |
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
      | 002          |

  Scenario Outline: Update Supplier with feature file
    Given user login the taskhub system
    When user navigates to "Global Setup>Party>Supplier>Supplier" screen
    And user update supplier as "<KEY SUPPLIER>"
      | KEY SUPPLIER | isContra | Prefix Auto Gen Code | Supplier | Supplier Name                          | Supplier Class Code | Party Group Code | Main Home Page | GST Registration No | Country Of Incorporation | Subcon WIP Glan | Sales Tax Code | Default Tenor Term Code | Default Tenor | IPT Related | Status | Unique Entity No | Main Supplier Code | Supplier Short Name | Supplier Category Code | Supplier Rank Code | Purchasing Zone | Party Contra GLAN | Contra Realized Exch GLAN | Default Discount Percent | Combine Shm to Invoices | Remarks | Company      |
      | 001          | N        |                      | Sup01    | Supplier 01  for Synergix Testing ONLY | Supplier            |                  |                |                     |                          |                 | gst0           |                         |               |             |        |                  |                    |                     |                        |                    |                 | 22040             | 22040                     |                          |                         |         | AUTO4, AUTO1 |
      | 002          | N        |                      | Sup02    | Supplier 02  for Synergix Testing ONLY | Supplier            |                  |                |                     |                          |                 | gst0           |                         |               |             |        |                  |                    |                     |                        |                    |                 | 22040             | 22040                     |                          |                         |         | AUTO4, AUTO1 |
      | 003          | Y        |                      | Cus02    |                                        | Supplier            |                  |                |                     |                          |                 | gst0           |                         |               |             |        |                  |                    |                     |                        |                    |                 | 22040             | 22040                     |                          |                         |         | AUTO4, AUTO1 |
      | 004          | Y        |                      | Cus04    |                                        | Supplier            |                  |                |                     |                          |                 | gst0           |                         |               |             |        |                  |                    |                     |                        |                    |                 | 22040             | 22040                     |                          |                         |         | AUTO4, AUTO1 |
      | 005          | N        |                      | Sup03    | Supplier 03  for Synergix Testing ONLY | Supplier            |                  |                |                     |                          |                 | gst0           |                         |               |             |        |                  |                    |                     |                        |                    |                 | 22040             | 22040                     |                          |                         |         | AUTO4, AUTO1 |
      | 006          | N        |                      | Sup04    | Supplier 04  for Synergix Testing ONLY | Supplier            |                  |                |                     |                          |                 | gst0           |                         |               |             |        |                  |                    |                     |                        |                    |                 | 22040             | 22040                     |                          |                         |         | AUTO4, AUTO1 |
