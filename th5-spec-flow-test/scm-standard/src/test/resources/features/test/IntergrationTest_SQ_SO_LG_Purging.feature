@vincent @phoebe @scm_standard @scm_standard_intergration_sq_so_lg_purging
Feature: Intergration Test - SQ-SO-LG-LG - Purging

  Scenario: Change Module Config
    Given user login the taskhub system
    When user navigates to "Maintenance Setup>Module Config>Module Config" screen
    Then user changes Module Config
      | Module Section        | Module Name                                           | Config Type | Config Value |
      | Logistic>Outgoing     | Enable Auto Purge Sales Order Upon Submit LG Outgoing | Radio       | No           |
      | Logistic>Outgoing     | Enable DO Numbering                                   | Radio       | Yes          |
      | Sales>Sales Quotation | Enable SQ Approval                                    | Radio       | No           |
      | Sales>Sales Order     | Enable SO Approval                                    | Radio       | No           |

  Scenario Outline: Intergration Test - SQ-SO-LG-LG - Purging
    Given user login the taskhub system
    # Create and check Sales Quotation
    When user navigates to "Processing>Sales>Sales Quotation>[2]" screen
    Given user creates new Sales Quotation in Draft stage of Sales Quotation Summary as "<Sales Quotation KEY>"
      | KEY | Customer Code | Customer Name       | Copy From Option | Copy From | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 001 | SYNERGIX      | Synergix Technology |                  |           |           |           |           |           |
    Then all default fields in Draft stage in Header tab of Sales Quotation were be pulled out as "<Sales Quotation KEY>"
      | KEY | Customer Address | Customer Contact | Currency | Sales Tax | Sales Person |
      | 001 | ADD1             | CONTACT1         | SGD      | GST0      | PHOEBE2      |
    And user inputs data in Draft stage in Shipment tab of Sales Quotation as "<Sales Quotation KEY>"
      | KEY | Shipment Mode | Shipment Term | Loading Location | No. of Shipment |
      | 001 | A             | FOB           | SG               | 1               |
    And user inputs data in Draft stage in Detail tab of Sales Quotation as "<Sales Quotation KEY>"
      | KEY | LI No. | Item Type | Item Code | Qty | Unit | Discount Percent | Discount Amount |
      | 001 | 1.0    | I         | FIFO1     | 10  | 50   |                  |                 |
    Then user previews Reports in Sales Quotation as "<Preview Report KEY>"
      | KEY | Report Title | Checksum | Contents              |
      | 001 |              |          | Sales Quotation FIFO1 |
    Then user submits created Sales Quotation in Draft stage of Sales Quotation
    Then user opens created Sales Quotation in Outstanding state of Sales Quotation Summary
    Then user previews Reports in Sales Quotation as "<Preview Report KEY>"
      | KEY | Report Title | Checksum | Contents              |
      | 001 |              |          | Sales Quotation FIFO1 |
    Then user confirm created Sales Quotation in Outstanding state of Sales Quotation Summary
    When user navigates to "Processing>Sales>Sales Order" screen
    Then user opens created Sales Order in Draft state of Sales Order Summary
    # Create and check Sales Order
    When user navigates to "Processing>Sales>Sales Order" screen
    Given user creates new Sales Order in Draft stage of Sales Order Summary as "<Sales Order KEY>"
      | KEY | Customer Code | Customer Name       | Copy From Option | Copy From |
      | 001 | SYNERGIX      | Synergix Technology |                  |           |
    Then all default fields in Draft stage in Header tab of Sales Order will be pulled out as "<Sales Order KEY>"
      | KEY | Customer Address | Customer Contact | Order Currency | Sales Tax | Sales Person |
      | 001 | ADD1             | CONTACT1         | SGD            | GST0      | PHOEBE2      |
    And user inputs data in Draft stage in Shipment tab of Sales Order as "<Sales Order KEY>"
      | KEY | Shipment Mode | Shipment Term | Loading Location | No. of Shipment |
      | 001 |               |               | SG               | 1               |
    And user inputs data in Draft stage in Detail tab of Sales Order as "<Sales Order KEY>"
      | KEY | LI No. | Item Type | Item Code | Qty | Unit |
      | 001 | 1.0    | I         | FIFO1     | 10  | 50   |
      | 001 | 2.0    | I         | WA1       | 10  | 50   |
    Then user previews Reports in Sales Order as "<Preview Report KEY>"
      | KEY | Report Title | Checksum | Contents              |
      | 001 |              |          | Sales Order FIFO1 WA1 |
    Then user submits created Sales Order in Draft stage of Sales Order
    Then user opens created Sales Order in Outstanding state of Sales Order Summary
    # Copy another Sales Order
    When user navigates to "Processing>Sales>Sales Order" screen
    Given user creates new Sales Order in Draft stage of Sales Order Summary as "<Sales Order KEY>"
      | KEY | Customer Code | Customer Name | Copy From Option      | Copy From             |
      | 001 |               |               | Outstanding/Completed | @Last Sales Order No@ |
    Then all default fields in Draft stage in Header tab of Sales Order will be pulled out as "<Sales Order KEY>"
      | KEY | Customer Address | Customer Contact | Order Currency | Sales Tax | Sales Person |
      | 001 | ADD1             | CONTACT1         | SGD            | GST0      | PHOEBE2      |
    Then user verifies data in Draft stage in Detail tab of Sales Order as "<Sales Order KEY>"
      | KEY | Total Volume | Total Weight | Total Discount Amt | Total Sales Tax Amt | Sub Total After Discount | Total After Tax Amt |
      | 001 | 0.00         | 0.00         | 0.00               | 0.00                | 1,000.00                 | 1,000.00            |
    Then user previews Reports in Sales Order as "<Preview Report KEY>"
      | KEY | Report Title | Checksum | Contents              |
      | 001 |              |          | Sales Order FIFO1 WA1 |
    Then user submits created Sales Order in Draft stage of Sales Order
    Then user opens created Sales Order in Outstanding state of Sales Order Summary
    #LG Out-Fully shipment
    When user navigates to "Processing>Logistics>Active Shipment>Outgoing Shipment>[2]" screen
    Then user opens created Shipment Voucher No. in Outstanding state of Logistic Outgoing Active Shipment Summary by created Sales Order No.
    Then user generates DO No. for created Shipment Voucher No. in Outstanding state of Logistic Outgoing Active Shipment Summary
    Then user previews Reports in Outgoing Shipment as "<Preview Report KEY>"
      | KEY | Report Title | Checksum | Contents                 |
      | 001 |              |          | Delivery Order FIFO1 WA1 |
    Then user submits created Shipment Voucher No. in Outstanding state of Logistic Outgoing Active Shipment Summary
    When user navigates to "Processing>Sales>Sales Order Purging" screen
    Given user purger Sales Order as "<Purchase Order Purging KEY>"
      | KEY | Sales Order No From   | Sales Order No To     | Order Date From | Order Date To | Customer Code From | Customer Code To |
      | 001 | @Last Sales Order No@ | @Last Sales Order No@ | @CurrentDate@   | @CurrentDate@ |                    |                  |
    When user navigates to "Processing>Logistics>Active Shipment>Outgoing Shipment>[2]" screen
    Then user opens Shipment Voucher No. in History state of Logistic Outgoing Active Shipment Summary
    When user navigates to "Processing>Sales>Sales Order" screen
    Then user opens created Sales Order in Completed state of Sales Order Summary
    #LG Out- Partial shipment
    When user navigates to "Processing>Logistics>Active Shipment>Outgoing Shipment>[2]" screen
    Then user opens created Shipment Voucher No. in Outstanding state of Logistic Outgoing Active Shipment Summary by 1 before last created Sales Order No.
    Then user updates data in Detail tab of Logistic Active Outstanding Shipment - Outgoing Shipment Details as "<Sales Order KEY>"
      | KEY | No. | Qty | No. Of Packs |
      | 001 | 1.0 | 5   |              |
      | 001 | 2.0 | 5   |              |
    Then user generates DO No. for created Shipment Voucher No. in Outstanding state of Logistic Outgoing Active Shipment Summary
    Then user previews Reports in Outgoing Shipment as "<Preview Report KEY>"
      | KEY | Report Title | Checksum | Contents                 |
      | 001 |              |          | Delivery Order FIFO1 WA1 |
    Then user submits created Shipment Voucher No. in Outstanding state of Logistic Outgoing Active Shipment Summary
    Then user opens Shipment Voucher No. in History state of Logistic Outgoing Active Shipment Summary
    Then user verifies display data in Detail tab of Logistic Active History Shipment - Outgoing Shipment Details as "<Sales Order KEY>"
      | KEY | No. | Type | Item Code | Qty  | Qty Req |
      | 001 | 1.0 | I    | FIFO1     | 5.00 | 10.00   |
      | 001 | 2.0 | I    | WA1       | 5.00 | 10.00   |
    Then user switchs through all tab in Logistic Active History Shipment - Outgoing Shipment Details
    When user navigates to "Processing>Logistics>Active Shipment>Outgoing Shipment>[2]" screen
    Then user opens created Shipment Voucher No. in Outstanding state of Logistic Outgoing Active Shipment Summary by 1 before last created Sales Order No.
    Then user switchs through all tab in Logistic Active Outstanding Shipment - Outgoing Shipment Details

    Examples: 
      | Sales Quotation KEY | Sales Order KEY | Preview Report KEY | Purchase Order Purging KEY |
      | 001                 | 001             | 001                | 001                        |
