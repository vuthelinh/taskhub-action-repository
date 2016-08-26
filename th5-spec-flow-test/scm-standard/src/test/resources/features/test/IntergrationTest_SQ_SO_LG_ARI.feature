@vincent @angela @scm @intergration_sq_so_lg_bs
Feature: Intergration Test - SQ-SO-LG-LGARI

  Scenario Outline: Intergration Test - SQ-SO-LG-LGARI
    Given user login the taskhub system
    When user navigates to "Processing>Sales>Sales Quotation>[2]" screen
    Given user creates new Sales Quotation in Draft stage of Sales Quotation Summary as "<Sales Quotation KEY>"
      | KEY | Customer Code | Customer Name | Copy From Option | Copy From | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 001 | ANGELA        |               |                  |           | NA        | NA        | NA        | NA        |
    And user inputs data in Draft stage in Shipment tab of Sales Quotation as "<Sales Quotation KEY>"
      | KEY | Shipment Mode | Shipment Term | Loading Location | No. of Shipment |
      | 001 |               |               | SG               |                 |
    And user inputs data in Draft stage in Detail tab of Sales Quotation as "<Sales Quotation KEY>"
      | KEY | LI No. | Item Type | Item Code  | Qty | Unit  | Discount Percent | Discount Amount |
      | 001 | 1.0    | I         | INVEN-FIFO | 12  | 5     |                  |                 |
      | 001 | 2.0    | I         | INVEN-LOT  | 13  | 2.5   |                  |                 |
      | 001 | 3.0    | I         | INVEN-WA   | 14  | 56.45 | 10               |                 |
      | 001 | 4.0    | I         | INVEN-SN   | 15  | 65.35 |                  | 5.55            |
      | 001 | 5.0    | S         | S1         | 16  | 23    |                  |                 |
    Then user submits created Sales Quotation in Draft stage of Sales Quotation
    Then user opens created Sales Quotation in Outstanding state of Sales Quotation Summary
    Then user confirm created Sales Quotation in Outstanding state of Sales Quotation Summary
    When user navigates to "Processing>Sales>Sales Order" screen
    Then user opens created Sales Order in Draft state of Sales Order Summary
    Then user submits created Sales Order in Draft stage of Sales Order
    Then user opens Sales Order Variation of created Sales Order in Outstanding state of Sales Order Summary
    Then user updates data in Details tab of Sales Order Variation as "<Sales Order Variation KEY>"
      | KEY | LI No. | Item Type | Item Code | Qty | Unit |
      | 001 | 1.0    |           |           | 0   | 0    |
    And user inputs data in Details tab of Sales Order Variation as "<Sales Order KEY>"
      | KEY | LI No. | Item Type | Item Code  | Qty | Unit |
      | 001 | 6.0    | I         | INVEN-FIFO | 12  | 5    |
    Then user submits created Sales Order Variation
    When user navigates to "Processing>Logistics>Active Shipment>Outgoing Shipment>[2]" screen
    Then user opens created Shipment Voucher No. in Outstanding state of Logistic Outgoing Active Shipment Summary by created Sales Order No.
    Then user updates data in Detail tab of Logistic Active Outstanding Shipment - Outgoing Shipment Details as "<Sales Order KEY>"
      | KEY | No. | Qty | No. Of Packs |
      | 001 | 3.0 | 2   |              |
      | 001 | 4.0 | 3   |              |
      | 001 | 5.0 | 4   |              |
      | 001 | 6.0 | 5   |              |
    Then user picks earliest lot first via Lots Information for item in Detail tab of Logistic Active Outstanding Shipment - Outgoing Shipment Details as "<Sales Order KEY>"
      | KEY | No. | Quantity |
      | 001 | 2.0 | 1.5      |
    Then user adds Serial No via Issuing Serial Number for item in Detail tab of Logistic Active Outstanding Shipment - Outgoing Shipment Details as "<Sales Order KEY>"
      | KEY | Line No. | No. | Serial No | Select Possible Serial |
      | 001 | 4.0      | 1.0 |           | Select                 |
      | 001 | 4.0      | 2.0 |           | Select                 |
      | 001 | 4.0      | 3.0 |           | Select                 |
    Then user submits created Shipment Voucher No. in Outstanding state of Logistic Outgoing Active Shipment Summary
    Then user opens created Shipment Voucher No. in Outstanding state of Logistic Outgoing Active Shipment Summary by created Sales Order No.
    When user navigates to "Processing>Logistics>Billing Planning>Billing Sales" screen
    Then user selects No of Invoice in Logistic Billing Sales Customer Summary as "<Sales Quotation KEY>"
      | KEY | Customer Code | Customer Name |
      | 001 | ANGELA        |               |
    Then user opens and submits created Invoice No. in Logistic Billing Sales Details by 1 before last created Shipment Voucher No
    Then user checks number of records in database
      | SQL Count Statement                                                        | Results | Replacement 1 Data Key | Index 1 | Replacement 2 Data Key | Index 2 |
      | SELECT COUNT(*) FROM GL_LEDGER_SUMMARY WHERE SOURCE_VOUCHER_NO = '@@#1#@@' | 2       | Shipment Voucher No    | -1      |                        |         |
      | SELECT COUNT(*) FROM GL_LEDGER_SUMMARY WHERE SOURCE_VOUCHER_NO = '@@#1#@@' | 6       | Invoice No             |         |                        |         |

    Examples: 
      | Sales Quotation KEY | Approving Officer KEY | Approval Summary KEY | Sales Order KEY | Sales Order Variation KEY |
      | 001                 | 001                   | 001                  | 001             | 001                       |
