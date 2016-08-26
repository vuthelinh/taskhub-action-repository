@vincent @angela @scm_standard @scm_standard_sq_so_lg_bs
Feature: Sales Flow SQ - SO - LG out

  Scenario: Change Module Config
    Given user login the taskhub system
    When user navigates to "Maintenance Setup>Module Config>Module Config" screen
    Then user changes Module Config
      | Module Section        | Module Name                                      | Config Type 1 | Config Value 1 | Config Type 2 | Config Value 2 |
      | Logistic>Outgoing     | Logistic Outgoing Stage - Holding Bay            | Radio         | No             |               |                |
      | Sales>Sales Quotation | Enable SQ Approval                               | Radio         | No             |               |                |
      | Sales>Sales Quotation | Enable SQ Margin                                 | Radio         | No             |               |                |
      | Sales>Sales Quotation | Enable Partial Confirmation/Failing of Quotation | Radio         | No             |               |                |
      | Sales>Sales Order     | Enable SO Approval                               | Radio         | Yes            |               |                |

  Scenario Outline: Create Sales Quotation
    Given user login the taskhub system
    When user navigates to "Processing>Sales>Sales Quotation>[2]" screen
    Given user creates new Sales Quotation in Draft stage of Sales Quotation Summary as "<Sales Quotation KEY>"
      | KEY | Customer Code | Customer Name      | Copy From Option | Copy From |
      | 001 | V_001         | Vincent Customer 1 |                  |           |
    Then all default fields in Draft stage in Header tab of Sales Quotation were be pulled out as "<Sales Quotation KEY>"
      | KEY | Customer Address | Customer Contact | Currency | Sales Tax |
      | 001 | V_001            | V_001            | SGD      | V_001     |
    And user inputs data in Draft stage in Shipment tab of Sales Quotation as "<Sales Quotation KEY>"
      | KEY | Shipment Mode | Shipment Term | Loading Location | No. of Shipment |
      | 001 | A             | V_001         | V_001            | 1               |
    And user inputs data in Draft stage in Detail tab of Sales Quotation as "<Sales Quotation KEY>"
      | KEY | LI No. | Item Type | Item Code | Qty | Unit | Discount Percent |
      | 001 | 1.0    | I         | V_001     | 1   | 2.5  | 0.5              |
      | 001 | 2.0    | I         | SERIAL    | 2   | 2.55 | 0.5              |
      | 001 | 3.0    | I         | V_003     | 3   | 1.99 | 0.6              |
      | 001 | 4.0    | S         | CAN001    | 12  | 2.55 | 0                |
    Then user submits created Sales Quotation in Draft stage of Sales Quotation
    Then user opens created Sales Quotation in Outstanding state of Sales Quotation Summary
    Then user confirm created Sales Quotation in Outstanding state of Sales Quotation Summary
    When user navigates to "Maintenance Setup>Administration>Employee>Approving Officer" screen
    Then user selects Transaction in Approving Officer as "<Approving Officer KEY>"
      | KEY | Module Code Desc | Transaction Type Desc | Approving Method             | Reject Remarks Mandatory |
      | 001 | Sales            | Sales Order           | By Amount (1 Level by Value) | Yes                      |
    Then user adds Approving Officer as "<Approving Officer KEY>"
      | KEY | Approving Method             | Approval Home Amount Limit (Per Voucher) | Approving Officer | Employee Code | Officer For Single Supplier |
      | 001 | By Amount (1 Level by Value) | 999,999,999.00                           | VINCENT1          | VINCENT1      |                             |
    When user navigates to "Processing>Sales>Sales Order" screen
    Then user opens created Sales Order in Draft state of Sales Order Summary
    Then user submits created Sales Order in Draft stage of Sales Order
    When user navigates to "Processing>Approval>Approval Summary>[2]" screen
    Then user selects Transaction in Approval Summary as "<Approval Summary KEY>"
      | KEY | Module Code Desc | Transaction Type Desc |
      | 001 | Sales            | Sales Order           |
    Then user submits Approval Action for Sales Order as "<Approval Summary KEY>"
      | KEY | SO No.        | Action  |
      | 001 | @CREATEDSONO@ | Approve |
    When user navigates to "Processing>Logistics>Active Shipment>Outgoing Shipment>[2]" screen
    Then user opens created Shipment Voucher No. in Outstanding state of Logistic Outgoing Active Shipment Summary by created Sales Order No.
    Then user generates DO No. for created Shipment Voucher No. in Outstanding state of Logistic Outgoing Active Shipment Summary
    Then user selects Deliver All Ost Qty for created Shipment Voucher No. in Outstanding state of Logistic Outgoing Active Shipment Summary
    Then user adds Serial No via Issuing Serial Number for item in Detail tab of Logistic Active Outstanding Shipment - Outgoing Shipment Details as "<Sales Order KEY>"
      | KEY | Line No. | No. | Serial No | Select Possible Serial |
      | 001 | 2.0      | 1.0 |           | Select                 |
      | 001 | 2.0      | 2.0 |           | Select                 |
    Then user submits created Shipment Voucher No. in Outstanding state of Logistic Outgoing Active Shipment Summary
    Then user checks number of records in database
      | SQL Count Statement                                                        | Results | Replacement 1 Data Key | Replacement 2 Data Key |
      | SELECT COUNT(*) FROM GL_LEDGER_SUMMARY WHERE SOURCE_VOUCHER_NO = '@@#1#@@' | 2       | Shipment Voucher No    |                        |
      | SELECT COUNT(*) FROM IC_INVENTORY_LEDGER WHERE VOUCHER_NO = '@@#1#@@'      | 3       | Shipment Voucher No    |                        |
    When user navigates to "Processing>Logistics>Billing Planning>Billing Sales" screen
    Then user selects No of Invoice in Logistic Billing Sales Customer Summary as "<Sales Quotation KEY>"
      | KEY | Customer Code | Customer Name |
      | 001 | V_001         |               |
    Then user opens and submits created Invoice No. in Logistic Billing Sales Details
    Then user checks number of records in database
      | SQL Count Statement                                                        | Results | Replacement 1 Data Key | Replacement 2 Data Key |
      | SELECT COUNT(*) FROM GL_LEDGER_SUMMARY WHERE SOURCE_VOUCHER_NO = '@@#1#@@' | 5       | Invoice No             |                        |

    Examples: 
      | Sales Quotation KEY | Approving Officer KEY | Approval Summary KEY |
      | 001                 | 001                   | 001                  |
