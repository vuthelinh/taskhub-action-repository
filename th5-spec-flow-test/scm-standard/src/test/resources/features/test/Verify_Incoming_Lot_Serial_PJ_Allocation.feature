@vincent @angela @scm @verify_incoming_shipment_with_lot_serial_pj_allocation
Feature: Verify Incoming Shipment with lot serial pj allocation

  Scenario Outline: Verify incoming with lot serial pj allocation
    Given user login the taskhub system
    When user navigates to "Processing>Purchase>Purchase Order>Purchase Order" screen
    Given user creates new Purchase Order in Draft stage of Purchase Order Summary as "<Purchase Order KEY>"
      | KEY | Supplier Code | Supplier Name         | Copy From Option | Copy From |
      | 001 | ANGELA        | Synergix Tech Pte Ltd |                  |           |
    And user inputs data in Draft stage in Header tab of Purchase Order Detail as "<Purchase Order KEY>"
      | KEY | Supplier Contact | Purchase Order Date | Order Currency | Sales Tax | Purchaser | Purchase Category | Reference No. | Subject | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 001 |                  |                     |                |           |           |                   |               |         | NA        | NA        | NA        | NA        |
    And user inputs data in Draft stage in Shipment tab of Purchase Order Detail as "<Purchase Order KEY>"
      | KEY | Shipment Mode | Shipment Term | Ship to Location | No. of Shipment |
      | 001 |               |               | SG               |                 |
    And user inputs data in Draft stage in Detail tab of Purchase Order Detail as "<Purchase Order KEY>"
      | KEY | No. | Item Type | Item Code | Qty | Unit Cost | Discount Percent | Discount Amount |
      | 001 | 1.0 | I         | INV1      | 100 | 5         | 5                |                 |
      | 001 | 2.0 | I         | INV2      | 200 | 5         | 35               |                 |
      | 001 | 3.0 | I         | INV3      | 300 | 5         |                  |                 |
      | 001 | 4.0 | S         | TTS       | 400 | 5         | 30               |                 |
    And user inputs data for Allocation of Allocation Detail in Detail tab of Purchase Order Detail as "<Purchase Order KEY>"
      | KEY | No. | Allocation No. | Type | Voucher No. | Phase Sequence No. | Schedule No. | Line No. | Alloc Qty |
      | 001 | 4.0 | 1.0            |      | PJE0000001  | 1                  |              |          | 100       |
    Then user submits created Purchase Order in Draft stage of Purchase Order
    When user navigates to "Processing>Logistics>Active Shipment>Incoming Shipment" screen
    Then user opens created Shipment Voucher No. in Outstanding state of Logistic Incoming Active Shipment Summary by created Purchase Order No.
    Then user inputs data in Header tab of Logistic Active Outstanding Shipment - Incoming Shipment Details as "<Purchase Order KEY>"
      | KEY | Actual Shipment Date | Actual Arrival Date | Goods Receipt Date |
      | 001 | @CurrentDate@        |                     | @CurrentDate@      |
    Then user click on Receive All Ost Qty button in Detail tab of Active Outstanding Shipment - Incoming Shipment Details
    Then user add new Lots Information for item in Detail tab of Logistic Active Outstanding Shipment - Incoming Shipment Details as "<Purchase Order KEY>"
      | KEY | No. | Ref No. | Expire Date | Country of Origin | Quantity |
      | 001 | 2.0 | #1      | 01/01/2020  | SG                | 50       |
      | 001 | 2.0 | #2      | 01/01/2019  | SG                | 150      |
    Then user updates data of items in Detail tab of Logistic Active Outstanding Shipment - Incoming Shipment Details as "<Purchase Order KEY>"
      | KEY | No. | Qty |
      | 001 | 3.0 | 300 |
    Then user generates Serial No Generating in Receving Serial Number in Detail tab of Logistic Active Outstanding Shipment - Incoming Shipment Details as "<Purchase Order KEY>"
      | KEY | No. | Prefix        | Suffix | First No | Last No |
      | 001 | 3.0 | @DATETIMENOW@ |        |          | 300     |
    Then user submits created Shipment Voucher No. in Logistic Active Outstanding Shipment - Incoming Shipment Details
    Then user checks number of records in database as "<SQL Statement KEY>"
      | KEY | SQL Count Statement                                                                                                                           | Results | Replacement 1 Data Key | Replacement 2 Data Key |
      | 001 | select count(*) from gl_ledger_summary where source_voucher_no = '@@#1#@@'                                                                    | 4       | Shipment Voucher No    |                        |
      | 001 | select count(*) from ic_inventory_ledger where voucher_no = '@@#1#@@'                                                                         | 3       | Shipment Voucher No    |                        |
      | 001 | select count(*) from lg_in_shm_hst_det where shipment_voucheR_no = '@@#1#@@' and line_item_no = 1 and pre_tax_extended_amt = 475              | 1       | Shipment Voucher No    |                        |
      | 001 | select count(*) from lg_in_shm_hst_det where shipment_voucheR_no = '@@#1#@@' and line_item_no = 2 and pre_tax_extended_amt = 650              | 1       | Shipment Voucher No    |                        |
      | 001 | select count(*) from lg_in_shm_hst_det where shipment_voucheR_no = '@@#1#@@' and line_item_no = 3 and pre_tax_extended_amt = 1500             | 1       | Shipment Voucher No    |                        |
      | 001 | select count(*) from lg_in_shm_hst_det where shipment_voucheR_no = '@@#1#@@' and line_item_no = 4 and pre_tax_extended_amt = 1400             | 1       | Shipment Voucher No    |                        |
      | 001 | select count(*) from ic_inventory_ost_lot where source_voucher_no = '@@#1#@@'                                                                 | 2       | Shipment Voucher No    |                        |
      | 001 | select count(*) from lg_in_shm_hst_det_alloc where shipment_voucher_no = '@@#1#@@' and source_voucher_no is not null and alloc_home_amt = 350 | 1       | Shipment Voucher No    |                        |

    Examples: 
      | Purchase Order KEY | SQL Statement KEY |
      | 001                | 001               |
