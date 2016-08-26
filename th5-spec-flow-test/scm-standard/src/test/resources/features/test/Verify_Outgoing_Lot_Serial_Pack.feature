@vincent @angela @scm @verify_outgoing_lot_serial_pack
Feature: Verify_Outgoing_Lot_Serial_Pack

  Scenario Outline: Verify_Outgoing_Lot_Serial_Pack
    Given user login the taskhub system
    When user navigates to "Processing>Sales>Sales Order" screen
    Given user creates new Sales Order in Draft stage of Sales Order Summary as "<Sales Order KEY>"
      | KEY | Customer Code | Customer Name         | Copy From Option | Copy From |
      | 001 | ANGELA        | Synergix Tech Pte Ltd |                  |           |
    And user inputs data in Draft stage in Header tab of Sales Order as "<Sales Order KEY>"
      | KEY | Customer Address | Customer Contact | Order Currency | Sales Tax | Sales Person | Approving SBU | Reference No. | Subject | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 001 |                  |                  | SGD            | GST7      |              |               |               |         | NA        | NA        | NA        | NA        |
    And user inputs data in Draft stage in Shipment tab of Sales Order as "<Sales Order KEY>"
      | KEY | Shipment Mode | Shipment Term | Loading Location | No. of Shipment |
      | 001 |               |               | SG               |                 |
    And user inputs data in Draft stage in Detail tab of Sales Order as "<Sales Order KEY>"
      | KEY | LI No. | Item Type | Item Code | Qty | Pack Size    | No. Of Pack | Unit | PO | Supplier | Ccy | PO Qty Allocation | Unit Cost | Discount Percent | Discount Amount |
      | 001 | 1.0    | I         | INV1      | 100 |              |             | 5.55 |    |          |     |                   |           | 5                |                 |
      | 001 | 2.0    | I         | INV2      | 200 |              |             | 5.55 |    |          |     |                   |           |                  | 35              |
      | 001 | 3.0    | I         | INV3      | 300 |              |             | 5.55 |    |          |     |                   |           | 30               |                 |
      | 001 | 4.0    | S         | TTS       | 10  |              |             | 5.55 |    |          |     |                   |           | 10               |                 |
      | 001 | 5.0    | I         | INV1      |     | LARGE (50.0) | 2.5         | 5.55 |    |          |     |                   |           |                  |                 |
    Then user verifies data in Draft stage in Detail tab of Sales Order as "<Sales Order KEY>"
      | KEY | Total Volume | Total Weight | Total Discount Amt | Total Sales Tax Amt | Sub Total After Discount | Total After Tax Amt |
      | 001 |              |              | 567.80             | 198.21              | 2,831.58                 | 3,029.79            |
    Then user submits created Sales Order in Draft stage of Sales Order
    When user navigates to "Processing>Logistics>Active Shipment>Outgoing Shipment>[2]" screen
    Then user opens created Shipment Voucher No. in Outstanding state of Logistic Outgoing Active Shipment Summary by created Sales Order No.
    Then user updates data in Detail tab of Logistic Active Outstanding Shipment - Outgoing Shipment Details as "<Sales Order KEY>"
      | KEY | No. | Qty | No. Of Packs |
      | 001 | 1.0 | 20  |              |
      | 001 | 3.0 | 3   |              |
      | 001 | 4.0 | 2.5 |              |
      | 001 | 5.0 |     | 1.5          |
    Then user picks earliest lot first via Lots Information for item in Detail tab of Logistic Active Outstanding Shipment - Outgoing Shipment Details as "<Sales Order KEY>"
      | KEY | No. | Quantity |
      | 001 | 2.0 | 15       |
    Then user adds Serial No via Issuing Serial Number for item in Detail tab of Logistic Active Outstanding Shipment - Outgoing Shipment Details as "<Sales Order KEY>"
      | KEY | Line No. | No. | Serial No | Select Possible Serial |
      | 001 | 3.0      | 1.0 |           | Select          |
      | 001 | 3.0      | 2.0 |           | Select          |
      | 001 | 3.0      | 3.0 |           | Select          |
    Then user submits created Shipment Voucher No. in Outstanding state of Logistic Outgoing Active Shipment Summary
    Then user checks number of records in database as "<SQL Statement KEY>"
      | KEY | SQL Count Statement                                                        | Results | Replacement 1 Data Key | Replacement 2 Data Key |
      | 001 | select count(*) from gl_ledger_summary where source_voucher_no = '@@#1#@@' | 2       | Shipment Voucher No    |                        |
      | 001 | select count(*) from ic_inventory_ledger where voucher_no = '@@#1#@@'      | 4       | Shipment Voucher No    |                        |

    Examples: 
      | Sales Order KEY | SQL Statement KEY |
      | 001             | 001               |
