@vincent @angela @scm @verify_smc_modi_lot_content
Feature: Verify_SMC_MODI_Lot_Content

  Scenario Outline: Verify_SMC_MODI_Lot_Content
    Given user login the taskhub system
    When user navigates to "Maintenance Setup>Module Config>Module Config" screen
    Then user changes Module Config as "<Module Config KEY>"
      | KEY | Module Section        | Module Name                                             | Config Type 1 | Config Value 1 | Config Type 2 | Config Value 2 |
      | 001 | Company Configuration | Enable Inventory Contents                               | Radio         | Yes            |               |                |
      | 001 | Inventory Control     | Enable Auto-Computation of Lot Qty Based on Nett Weight | Radio         | Yes            |               |                |
      | 001 | Logistic>Incoming     | Enable Separate Costing Stage in LG incoming            | Radio         | Yes            |               |                |
      | 001 | Logistic>Incoming     | Allow Received Variance                                 | Radio         | Yes            |               |                |
      | 001 | Logistic>Incoming     | Received Variance Percent                               | Input         | 50             |               |                |
      | 001 | Logistic>Incoming     | Allow Service Item for Cost Variance                    | Radio         | Yes            |               |                |
      | 001 | Logistic>Incoming     | Allow Receiving as Different Inventories                | Radio         | Yes            |               |                |
    When user navigates to "Processing>Purchase>Purchase Order>Purchase Order" screen
    Given user creates new Purchase Order in Draft stage of Purchase Order Summary as "<Purchase Order KEY>"
      | KEY | Supplier Code | Supplier Name         | Copy From Option | Copy From |
      | 001 | ANGELA        | Synergix Tech Pte Ltd |                  |           |
    And user inputs data in Draft stage in Header tab of Purchase Order Detail as "<Purchase Order KEY>"
      | KEY | Supplier Contact | Purchase Order Date | Order Currency | Sales Tax | Purchaser | Purchase Category | Reference No. | Subject | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 001 |                  |                     | USD            |           |           |                   |               |         | NA        | NA        | NA        | NA        |
    And user inputs data in Draft stage in Shipment tab of Purchase Order Detail as "<Purchase Order KEY>"
      | KEY | Shipment Mode | Shipment Term | Ship to Location | No. of Shipment |
      | 001 |               |               | SG               |                 |
    And user inputs data in Draft stage in Detail tab of Purchase Order Detail as "<Purchase Order KEY>"
      | KEY | No. | Item Type | Item Code | Qty   | Unit Cost | Discount Percent | Discount Amount |
      | 001 | 1.0 | I         | SMC1      | 100   |           |                  |                 |
      | 001 | 2.0 | I         | SMC2      | 1,000 |           | 2.5              |                 |
    Then users updates Contents of item in Draft stage in Detail tab of Purchase Order Detail as "<Purchase Order KEY>"
      | KEY | No. | Content Code | Description | Percentage (%) | Recovery Rate (%) | Content Unit Cost |
      | 001 | 1.0 | FE           |             |                |                   | 102.5             |
      | 001 | 1.0 | AG           |             |                |                   | 5.5               |
    Then user adds new Contents of item in Draft stage in Detail tab of Purchase Order Detail as "<Purchase Order KEY>"
      | KEY | No. | Content Code | Description | Percentage (%) | Recovery Rate (%) | Content Unit Cost |
      | 001 | 2.0 | FE           |             | 55             | 55                | 5.5               |
    Then user verifies display data in Detail tab of Draft state of Purchase Order Detail as "<Purchase Order KEY>"
      | KEY | LI No. | Item Type | Item Code | Qty   | Unit Cost | Discount Amount | Total Cost |
      | 001 | 1.0    | I         | SMC1      | 100   | 12.3213   | 41.6            | 1,232.13   |
      | 001 | 2.0    | I         | SMC2      | 1,000 | 1.6638    | 41.6            | 1,622.20   |
    Then user submits created Purchase Order in Draft stage of Purchase Order
    When user navigates to "Processing>Logistics>Active Shipment>Incoming Shipment" screen
    Then user opens created Shipment Voucher No. in Outstanding state of Logistic Incoming Active Shipment Summary by created Purchase Order No.
    Then user inputs data in Header tab of Logistic Active Outstanding Shipment - Incoming Shipment Details as "<Purchase Order KEY>"
      | KEY | Actual Shipment Date | Actual Arrival Date | Goods Receipt Date |
      | 001 | @CurrentDate@        |                     | @CurrentDate@      |
    Then user adds new items in Detail tab of Logistic Active Outstanding Shipment - Incoming Shipment Details as "<Purchase Order KEY>"
      | KEY | No. | Item Code | Source PO Line Item No. |
      | 001 | 3.0 | SMC1      | 1                       |
    Then user add new Lots Information for item in Detail tab of Logistic Active Outstanding Shipment - Incoming Shipment Details as "<Purchase Order KEY>"
      | KEY | No. | Ref No. | Expire Date | Country of Origin | Quantity | Gross Weight |
      | 001 | 1.0 |         |             |                   |          | 25.55        |
      | 001 | 1.0 |         |             |                   |          | 85           |
      | 001 | 2.0 |         |             |                   |          | 500          |
      | 001 | 3.0 |         |             |                   |          | 5            |
    Then user submits created Shipment Voucher No. in Logistic Active Outstanding Shipment - Incoming Shipment Details
    Then user opens created Shipment Voucher No. in Costing state of Logistic Incoming Active Shipment Summary by created Purchase Order No.
    Then user adds new item in Detail tab of Logistic Costing Shipment - Incoming Shipment Details as "<Purchase Order KEY>"
      | KEY | No. | Item Code | Qty  | Unit Cost | Cost Variance | Source PO Line Item No. |
      | 001 | 4.0 | TS        | 0.01 | 4         | Reduce        | 2                       |
    Then user submits error created Shipment Voucher No. in Logistic Active Outstanding Shipment - Incoming Shipment Details
    Then user verifies Error Message display as "<Error Message KEY>"
      | KEY | Contents                                            |
      | 001 | Line Item 3: Unit Cost cannot be zero for new Items |
    Then user updates data in Detail tab of Logistic Costing Shipment - Incoming Shipment Details as "<Purchase Order KEY>"
      | KEY | No. | Item Type | Item Code | Qty | Unit Cost | Discount Percent | Discount Amount |
      | 001 | 3.0 | I         |           |     | 1         |                  |                 |
    Then user submits created Shipment Voucher No. in Logistic Costing Shipment - Incoming Shipment Details
    Then user checks number of records in database as "<SQL Statement KEY>"
      | KEY | SQL Count Statement                                                           | Results | Replacement 1 Data Key | Replacement 2 Data Key |
      | 001 | select count(*) from lg_in_shm_ost_hdr where source_voucher_no = '@@#1#@@'    | 1       | Purchase Order No      |                        |
      | 001 | select count(*) from gl_ledger_summary where source_voucher_no = '@@#1#@@'    | 2       | Shipment Voucher No    |                        |
      | 001 | select count(*) from ic_inventory_ost_lot where source_voucher_no = '@@#1#@@' | 4       | Shipment Voucher No    |                        |

    Examples: 
      | Module Config KEY | Purchase Order KEY | Error Message KEY | SQL Statement KEY |
      | 001               | 001                | 001               | 001               |

  Scenario Outline: Revert config
    Given user login the taskhub system
    When user navigates to "Maintenance Setup>Module Config>Module Config" screen
    Then user changes Module Config as "<Module Config KEY>"
      | KEY | Module Section        | Module Name                                             | Config Type 1 | Config Value 1 | Config Type 2 | Config Value 2 |
      | 001 | Company Configuration | Enable Inventory Contents                               | Radio         | No             |               |                |
      | 001 | Inventory Control     | Enable Auto-Computation of Lot Qty Based on Nett Weight | Radio         | No             |               |                |
      | 001 | Logistic>Incoming     | Enable Separate Costing Stage in LG incoming            | Radio         | No             |               |                |
      | 001 | Logistic>Incoming     | Allow Service Item for Cost Variance                    | Radio         | No             |               |                |
      | 001 | Logistic>Incoming     | Allow Receiving as Different Inventories                | Radio         | No             |               |                |
      | 001 | Logistic>Incoming     | Received Variance Percent                               | Input         | 0              |               |                |
      | 001 | Logistic>Incoming     | Allow Received Variance                                 | Radio         | No             |               |                |

    Examples: 
      | Module Config KEY |
      | 001               |
