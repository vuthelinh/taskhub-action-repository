@vincent @angela @scm @OneTimeRequest20160729
Feature: One time request create PO same service , same allocate for PO

  Scenario Outline: One time request create PO same service , same allocate for PO
    Given user login the taskhub system
    When user navigates to "Processing>Purchase>Purchase Order>Purchase Order" screen
    Given user creates new Purchase Order in Draft stage of Purchase Order Summary as "<Purchase Order KEY>"
      | KEY | Supplier Code | Supplier Name | Copy From Option | Copy From |
      | 001 | ANGELA        |               |                  |           |
    And user inputs data in Draft stage in Header tab of Purchase Order Detail as "<Purchase Order KEY>"
      | KEY | Supplier Contact | Purchase Order Date | Order Currency | Sales Tax | Purchaser | Purchase Category | Reference No. | Subject | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |     |                  |                     |                |           |           |                   |               |         |           |           |           |           |
    And user inputs data in Draft stage in Shipment tab of Purchase Order Detail as "<Purchase Order KEY>"
      | KEY | Shipment Mode | Shipment Term | Ship to Location | No. of Shipment |
      | 001 |               |               | SG               |                 |
    And user inputs data in Draft stage in Detail tab of Purchase Order Detail as "<Purchase Order KEY>"
      | KEY | No.  | Item Type | Item Code | Qty | Unit Cost | Discount Percent | Discount Amount |
      | 001 | 1.0  | S         | V_001     | 50  | 5         |                  |                 |
      | 001 | 2.0  | S         | V_001     | 50  | 5         |                  |                 |
      | 001 | 3.0  | S         | V_001     | 50  | 5         |                  |                 |
      | 001 | 4.0  | S         | V_001     | 50  | 5         |                  |                 |
      | 001 | 5.0  | S         | V_001     | 50  | 5         |                  |                 |
      | 001 | 6.0  | S         | V_001     | 50  | 5         |                  |                 |
      | 001 | 7.0  | S         | V_001     | 50  | 5         |                  |                 |
      | 001 | 8.0  | S         | V_001     | 50  | 5         |                  |                 |
      | 001 | 9.0  | S         | V_001     | 50  | 5         |                  |                 |
      | 001 | 10.0 | S         | V_001     | 50  | 5         |                  |                 |
    And user inputs data for Allocation of Allocation Detail in Detail tab of Purchase Order Detail as "<Purchase Order KEY>"
      | KEY | No.  | Allocation No. | Type | Voucher No. | Phase Sequence No. | Schedule No. | Line No. | Alloc Qty |
      | 001 | 1.0  | 1.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 1.0  | 2.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 1.0  | 3.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 1.0  | 4.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 1.0  | 5.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 1.0  | 6.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 1.0  | 7.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 1.0  | 8.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 1.0  | 9.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 1.0  | 10.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 1.0  | 11.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 1.0  | 12.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 1.0  | 13.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 1.0  | 14.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 1.0  | 15.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 1.0  | 16.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 1.0  | 17.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 1.0  | 18.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 1.0  | 19.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 1.0  | 20.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 1.0  | 21.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 1.0  | 22.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 1.0  | 23.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 1.0  | 24.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 1.0  | 25.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 2.0  | 1.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 2.0  | 2.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 2.0  | 3.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 2.0  | 4.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 2.0  | 5.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 2.0  | 6.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 2.0  | 7.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 2.0  | 8.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 2.0  | 9.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 2.0  | 10.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 2.0  | 11.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 2.0  | 12.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 2.0  | 13.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 2.0  | 14.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 2.0  | 15.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 2.0  | 16.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 2.0  | 17.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 2.0  | 18.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 2.0  | 19.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 2.0  | 20.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 2.0  | 21.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 2.0  | 22.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 2.0  | 23.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 2.0  | 24.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 2.0  | 25.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 3.0  | 1.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 3.0  | 2.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 3.0  | 3.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 3.0  | 4.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 3.0  | 5.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 3.0  | 6.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 3.0  | 7.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 3.0  | 8.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 3.0  | 9.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 3.0  | 10.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 3.0  | 11.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 3.0  | 12.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 3.0  | 13.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 3.0  | 14.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 3.0  | 15.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 3.0  | 16.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 3.0  | 17.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 3.0  | 18.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 3.0  | 19.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 3.0  | 20.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 3.0  | 21.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 3.0  | 22.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 3.0  | 23.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 3.0  | 24.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 3.0  | 25.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 4.0  | 1.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 4.0  | 2.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 4.0  | 3.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 4.0  | 4.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 4.0  | 5.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 4.0  | 6.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 4.0  | 7.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 4.0  | 8.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 4.0  | 9.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 4.0  | 10.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 4.0  | 11.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 4.0  | 12.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 4.0  | 13.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 4.0  | 14.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 4.0  | 15.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 4.0  | 16.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 4.0  | 17.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 4.0  | 18.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 4.0  | 19.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 4.0  | 20.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 4.0  | 21.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 4.0  | 22.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 4.0  | 23.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 4.0  | 24.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 4.0  | 25.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 5.0  | 1.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 5.0  | 2.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 5.0  | 3.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 5.0  | 4.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 5.0  | 5.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 5.0  | 6.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 5.0  | 7.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 5.0  | 8.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 5.0  | 9.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 5.0  | 10.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 5.0  | 11.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 5.0  | 12.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 5.0  | 13.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 5.0  | 14.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 5.0  | 15.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 5.0  | 16.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 5.0  | 17.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 5.0  | 18.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 5.0  | 19.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 5.0  | 20.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 5.0  | 21.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 5.0  | 22.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 5.0  | 23.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 5.0  | 24.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 5.0  | 25.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 6.0  | 1.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 6.0  | 2.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 6.0  | 3.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 6.0  | 4.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 6.0  | 5.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 6.0  | 6.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 6.0  | 7.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 6.0  | 8.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 6.0  | 9.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 6.0  | 10.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 6.0  | 11.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 6.0  | 12.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 6.0  | 13.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 6.0  | 14.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 6.0  | 15.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 6.0  | 16.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 6.0  | 17.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 6.0  | 18.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 6.0  | 19.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 6.0  | 20.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 6.0  | 21.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 6.0  | 22.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 6.0  | 23.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 6.0  | 24.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 6.0  | 25.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 7.0  | 1.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 7.0  | 2.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 7.0  | 3.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 7.0  | 4.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 7.0  | 5.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 7.0  | 6.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 7.0  | 7.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 7.0  | 8.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 7.0  | 9.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 7.0  | 10.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 7.0  | 11.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 7.0  | 12.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 7.0  | 13.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 7.0  | 14.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 7.0  | 15.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 7.0  | 16.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 7.0  | 17.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 7.0  | 18.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 7.0  | 19.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 7.0  | 20.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 7.0  | 21.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 7.0  | 22.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 7.0  | 23.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 7.0  | 24.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 7.0  | 25.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 8.0  | 1.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 8.0  | 2.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 8.0  | 3.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 8.0  | 4.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 8.0  | 5.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 8.0  | 6.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 8.0  | 7.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 8.0  | 8.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 8.0  | 9.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 8.0  | 10.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 8.0  | 11.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 8.0  | 12.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 8.0  | 13.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 8.0  | 14.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 8.0  | 15.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 8.0  | 16.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 8.0  | 17.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 8.0  | 18.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 8.0  | 19.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 8.0  | 20.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 8.0  | 21.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 8.0  | 22.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 8.0  | 23.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 8.0  | 24.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 8.0  | 25.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 9.0  | 1.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 9.0  | 2.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 9.0  | 3.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 9.0  | 4.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 9.0  | 5.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 9.0  | 6.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 9.0  | 7.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 9.0  | 8.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 9.0  | 9.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 9.0  | 10.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 9.0  | 11.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 9.0  | 12.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 9.0  | 13.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 9.0  | 14.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 9.0  | 15.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 9.0  | 16.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 9.0  | 17.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 9.0  | 18.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 9.0  | 19.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 9.0  | 20.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 9.0  | 21.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 9.0  | 22.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 9.0  | 23.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 9.0  | 24.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 9.0  | 25.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 10.0 | 1.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 10.0 | 2.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 10.0 | 3.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 10.0 | 4.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 10.0 | 5.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 10.0 | 6.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 10.0 | 7.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 10.0 | 8.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 10.0 | 9.0            |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 10.0 | 10.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 10.0 | 11.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 10.0 | 12.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 10.0 | 13.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 10.0 | 14.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 10.0 | 15.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 10.0 | 16.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 10.0 | 17.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 10.0 | 18.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 10.0 | 19.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 10.0 | 20.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 10.0 | 21.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 10.0 | 22.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 10.0 | 23.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 10.0 | 24.0           |      | PJE0000001  | 1                  |              |          | 2         |
      | 001 | 10.0 | 25.0           |      | PJE0000001  | 1                  |              |          | 2         |

    Examples: 
      | Purchase Order KEY |
      | 001                |
