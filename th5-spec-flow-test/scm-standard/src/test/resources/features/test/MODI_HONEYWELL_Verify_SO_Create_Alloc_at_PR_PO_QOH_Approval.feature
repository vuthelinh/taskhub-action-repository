@vincent @adela @scm @modi_honey_well_verify_so_create_alloc_at_pr_po_qoh_approval
Feature: Verify_HONEYWELL_MODI_SO_Create_Alloc_at_PR_PO_QOH

  Scenario Outline: Verify_HONEYWELL_MODI_SO_Create_Alloc_at_PR_PO_QOH
    Given user login the taskhub system
    When user navigates to "Maintenance Setup>Module Config>Module Config" screen
    Then user changes Module Config as "<Module Config KEY>"
      | KEY | Module Section                      | Module Name                                               | Config Type 1 | Config Value 1 | Config Type 2 | Config Value 2 |
      | 001 | Sales>Quote and Order               | Enable Line Item Location                                 | Radio         | Yes            |               |                |
      | 001 | Sales>Sales Order                   | Enable Qty On Hand Allocation in SO                       | Radio         | Yes            |               |                |
      | 001 | Sales>Sales Order                   | Enable Auto Create PO                                     | Radio         | Yes            |               |                |
      | 001 | Sales>Sales Order                   | Enable Auto Create PR                                     | Radio         | Yes            |               |                |
      | 001 | Sales>Sales Order                   | Allocate PO to SO - Allocate Outstanding PO               | Radio         | Yes            |               |                |
      | 001 | Sales>Sales Order                   | Display "Unit Price" at SO Detail                         | Radio         | Yes            |               |                |
      | 001 | Sales>Sales Order                   | Display "Supplier/CCY" at SO Detail                       | Radio         | Yes            |               |                |
      | 001 | Sales>Sales Order                   | Display "Supplier Exchange Rate" at SO Detail             | Radio         | Yes            |               |                |
      | 001 | Sales>Sales Order                   | Allocate PO to SO - Allocate Draft PO                     | Radio         | No             |               |                |
      | 001 | Sales>Sales Order                   | Allocate PO to SO - Create new PO                         | Radio         | No             |               |                |
      | 001 | Sales>Sales Order                   | Enable SO Approval                                        | Radio         | Yes            |               |                |
      | 001 | Logistic>Outgoing                   | Logistic Outgoing Stage - Holding Bay                     | Radio         | Yes            |               |                |
      | 001 | Logistic>Outgoing                   | Enable Qty Reservation                                    | Radio         | No             |               |                |
      | 001 | Inventory Control>Inventory Control | Default Option of View by Total in Inventory Enquiry      | Radio         | Yes            |               |                |
      | 001 | Manufacturing>Manufacturing         | Enable allocation of Finished Goods to source Sales Order | Radio         | No             |               |                |
    When user navigates to "Processing>Purchase>Purchase Order>Purchase Order" screen
    Given user creates new Purchase Order in Draft stage of Purchase Order Summary as "<Purchase Order KEY>"
      | KEY | Supplier Code | Supplier Name         | Copy From Option | Copy From |
      | 001 | ADELA         | Adela's Test Customer |                  |           |
    And user inputs data in Draft stage in Shipment tab of Purchase Order Detail as "<Purchase Order KEY>"
      | KEY | Shipment Mode | Shipment Term | Ship to Location | No. of Shipment |
      | 001 | A             | V_001         | SG               | 1               |
    And user inputs data in Draft stage in Detail tab of Purchase Order Detail as "<Purchase Order KEY>"
      | KEY | No. | Item Type | Item Code | Pack Size       | No. of Pack | Qty | Cost Type | Unit Cost |
      | 001 | 1.0 | I         | A3        | PK2000 (2000.0) | 16          |     | P         | 1,500     |
      | 001 | 2.0 | I         | A1        | Loose           |             | 250 | B         | 20        |
    Then user submits created Purchase Order in Draft stage of Purchase Order
    Then user gets "#1" before values and sets expected values will be changed in database as "<DB Change KEY>"
      | KEY | VERIFY KEY | Expected Condition | Expected Value 1 | Expected Value 2 | SQL Select Statement                                                                                                                                                                 | Replacement 1 Data Key | Replacement 2 Data Key |
      | 001 | 1          | Not Change         |                  |                  | select QTY_ON_HAND , QTY_ON_HAND_WITHOUT_PACK, QTY_RESERVED, QTY_ON_ORDER, QTY_ON_ORDER_WITHOUT_PACK from MT_INVENTORY_LOCATION where INVENTORY_CODE = 'A1' and LOCATION_CODE = 'SG' |                        |                        |
      | 001 | 2          | Increase By        | 4                |                  | select QTY_ON_HAND_ALLOCATED, QTY_ON_HAND_WO_PCK_ALLOCATED, QTY_ON_HAND_ALLOCATED_TO_SO from MT_INVENTORY_LOCATION where INVENTORY_CODE = 'A1' and LOCATION_CODE = 'SG'              |                        |                        |
      | 001 | 3          | Increase By        | 6                |                  | select QTY_ON_ORDER_ALLOCATED, QTY_ON_ORDER_WO_PCK_ALLOCATE, QTY_ON_ORDER_ALLOCATED_TO_SO from MT_INVENTORY_LOCATION where INVENTORY_CODE = 'A1' and LOCATION_CODE = 'SG'            |                        |                        |
      | 001 | 4          | Not Change         |                  |                  | select PR_QTY_ALLOCATED_TO_SO, PR_QTY_ALLOCATED_TO_SO_WITHOUT_PACK from MT_INVENTORY_LOCATION where INVENTORY_CODE = 'A1' and LOCATION_CODE = 'SG'                                   |                        |                        |
      | 001 | 5          | Increase By        | 10               |                  | select QTY_BACK_ORDER, QTY_BACK_ORDER_WITHOUT_PACK from MT_INVENTORY_LOCATION where INVENTORY_CODE = 'A1' and LOCATION_CODE = 'SG'                                                   |                        |                        |
      | 001 | 6          | Not Change         |                  |                  | select QTY_ON_HAND , QTY_ON_HAND_WITHOUT_PACK, QTY_RESERVED, QTY_ON_ORDER, QTY_ON_ORDER_WITHOUT_PACK from MT_INVENTORY_LOCATION where INVENTORY_CODE = 'A3' and LOCATION_CODE = 'SG' |                        |                        |
      | 001 | 7          | Increase By        | 28               |                  | select QTY_ON_HAND_ALLOCATED, QTY_ON_HAND_WO_PCK_ALLOCATED, QTY_ON_HAND_ALLOCATED_TO_SO from MT_INVENTORY_LOCATION where INVENTORY_CODE = 'A3' and LOCATION_CODE = 'SG'              |                        |                        |
      | 001 | 8          | Not Change         |                  |                  | select QTY_ON_ORDER_ALLOCATED, QTY_ON_ORDER_WO_PCK_ALLOCATE, QTY_ON_ORDER_ALLOCATED_TO_SO from MT_INVENTORY_LOCATION where INVENTORY_CODE = 'A3' and LOCATION_CODE = 'SG'            |                        |                        |
      | 001 | 9          | Increase By        | 52               |                  | select PR_QTY_ALLOCATED_TO_SO, PR_QTY_ALLOCATED_TO_SO_WITHOUT_PACK from MT_INVENTORY_LOCATION where INVENTORY_CODE = 'A3' and LOCATION_CODE = 'SG'                                   |                        |                        |
      | 001 | 10         | Increase By        | 80               |                  | select QTY_BACK_ORDER, QTY_BACK_ORDER_WITHOUT_PACK from MT_INVENTORY_LOCATION where INVENTORY_CODE = 'A3' and LOCATION_CODE = 'SG'                                                   |                        |                        |
    When user navigates to "Processing>Sales>Sales Order" screen
    Given user creates new Sales Order in Draft stage of Sales Order Summary as "<Sales Order KEY>"
      | KEY | Customer Code | Customer Name         | Copy From Option | Copy From |
      | 001 | ADELA         | Adela's Test Customer |                  |           |
    And user inputs data in Draft stage in Header tab of Sales Order as "<Sales Order KEY>"
      | KEY | Allocate PR to SO | Allocate PO to SO | Customer Address | Customer Contact | Order Currency | Sales Tax | Sales Person | Approving SBU | Reference No. | Subject | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 001 | Yes               | Yes               |                  |                  |                |           |              |               |               |         |           |           |           |           |
    And user inputs data in Draft stage in Detail tab of Sales Order as "<Sales Order KEY>"
      | KEY | LI No. | Item Type | Loading Location | Item Code | Qty | Pack Size | No. Of Pack | Unit | PR  | PO  | Draft/Ost PO No     | Draft/Ost Line Item No | Supplier | Ccy | PO Qty Allocation | QOH Allocation | Unit Cost | Discount Percent | Discount Amount |
      | 001 | 1.0    | I         | SG               | A1        | 10  | Loose     |             | 10   | No  | Yes | @Purchase Order No@ | 2.0                    | ADELA    | SGD | 6                 | 4              |           |                  |                 |
      | 001 | 2.0    | I         | SG               | A3        | 80  | PK4 (4.0) | 20          | 40   | Yes | No  |                     |                        |          |     |                   | 7              |           |                  |                 |
    Then user submits created Sales Order in Draft stage of Sales Order
    When user navigates to "Processing>Approval>Approval Summary>[2]" screen
    Then user selects Transaction in Approval Summary as "<Approval Summary KEY>"
      | KEY | Module Code Desc | Transaction Type Desc |
      | 001 | Sales            | Sales Order           |
    Then user submits Approval Action for Sales Order as "<Approval Summary KEY>"
      | KEY | SO No.        | Action  |
      | 001 | @CREATEDSONO@ | Approve |
    When user navigates to "Processing>Sales>Sales Order" screen
    Then user opens created Sales Order in Outstanding state of Sales Order Summary
    When user navigates to "Processing>Purchase>Purchase Order>Purchase Order" screen
    Then user opens created Purchase Order in Outstanding state of Purchase Order Summary by Alloc Voucher No
    When user navigates to "Processing>Purchase>Purchase Requisition>Requisition Summary>[2]" screen
    Then user opens created Purchase Requisition in Purchase Requisition Draft by Source Voucher No
    Then user checks number of records in database as "<SQL Statement KEY>"
      | KEY | SQL Count Statement                                                                                                                                                                                                                                            | Results | Replacement 1 Data Key | Replacement 2 Data Key |
      | 001 | select COUNT(*) from PO_ORDER_OST_DET_ALLOC where PURCHASE_ORDER_NO = '@@#1#@@' and LINE_ITEM_NO = 2 and ALLOCATION_NO = 2 and SOURCE_ALLOCATION_TYPE = 'S' and SOURCE_VOUCHER_NO = '@@#2#@@' and SOURCE_LINE_ITEM_NO = 1 and ALLOC_QTY = 6                    | 1       | Purchase Order No      | Sales Order No         |
      | 001 | select COUNT(*) from PO_ORDER_OST_SHM_DET_ALLOC where PURCHASE_ORDER_NO = '@@#1#@@' and SHIPMENT_NO = 1 and LINE_ITEM_NO = 2 and ALLOCATION_NO = 2 and ALLOC_SHM_QTY = 6 and ALLOC_SHM_QTY_RECVED = 0 and ALLOC_SHM_QTY_TRANSF = 0 and ALLOC_SHM_QTY_CANCL = 0 | 1       | Purchase Order No      |                        |
    Then user checks number of records in database as "<SQL Statement KEY>"
      | KEY | SQL Count Statement                                                                                                                                                                                           | Results | Replacement 1 Data Key  | Replacement 2 Data Key |
      | 001 | select COUNT(*) from PR_REQ_NEW_DET_ALLOC where PURCHASE_REQUISITION_NO = '@@#1#@@' and LINE_ITEM_NO = 1 and ALLOCATION_NO = 1 and ALLOCATION_TYPE = 'S' and SOURCE_VOUCHER_NO = '@@#2#@@' and ALLOC_QTY = 52 | 1       | Purchase Requisition No | Sales Order No         |
      | 001 | select COUNT(*) from PR_REQ_NEW_SHM_DET_ALLOC where PURCHASE_REQUISITION_NO = '@@#1#@@' and SHIPMENT_NO = 1 and LINE_ITEM_NO = 1 and ALLOCATION_NO = 1 and ALLOC_SHM_QTY = 52                                 | 1       | Purchase Requisition No |                        |
    Then user verifies "#1" change of value in database as "<DB Change KEY>"
      #Expected Condition will be overwrite if set
      | KEY | VERIFY KEY | Expected Condition | Expected Value 1 | Expected Value 2 | SQL Select Statement | Replacement 1 Data Key | Replacement 2 Data Key |
      | 001 | 1          |                    |                  |                  |                      |                        |                        |
      | 001 | 2          |                    |                  |                  |                      |                        |                        |
      | 001 | 3          |                    |                  |                  |                      |                        |                        |
      | 001 | 4          |                    |                  |                  |                      |                        |                        |
      | 001 | 5          |                    |                  |                  |                      |                        |                        |
      | 001 | 6          |                    |                  |                  |                      |                        |                        |
      | 001 | 7          |                    |                  |                  |                      |                        |                        |
      | 001 | 8          |                    |                  |                  |                      |                        |                        |
      | 001 | 9          |                    |                  |                  |                      |                        |                        |
      | 001 | 10         |                    |                  |                  |                      |                        |                        |
    Then user checks number of records in database as "<SQL Statement KEY>"
      | KEY | SQL Count Statement                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 | Results | Replacement 1 Data Key | Replacement 2 Data Key |
      | 001 | select COUNT(*) from (SELECT H.*,ROW_NUMBER() OVER(ORDER BY ALLOC_VOUCHER_NO DESC) AS RN  from IC_STK_ALLOC_VCH H) where RN = 2 and ALLOC_TYPE = 'S' and STATUS = 'A' and ALLOC_QTY = 4 and REMAIN_ALLOC_QTY = 4 and DEALLOCATION_QTY = 0 and ISSUED_ALLOC_QTY = 0 and CANCELLED_ALLOC_QTY = 0 and INVENTORY_CODE = 'A1' and LOCATION_CODE = 'SG' and ALLOC_TO_VOUCHER_NO = '@@#1#@@' and LINE_ITEM_NO = 1 and MODULE_CODE = 'SO' and TRANSACTION_TYPE_CODE = 'SO' and ALLOCATED_BY_SCREEN = 'SO'   | 1       | Sales Order No         |                        |
      | 001 | select COUNT(*) from (SELECT H.*,ROW_NUMBER() OVER(ORDER BY ALLOC_VOUCHER_NO DESC) AS RN  from IC_STK_ALLOC_VCH H) where RN = 1 and ALLOC_TYPE = 'S' and STATUS = 'A' and ALLOC_QTY = 28 and REMAIN_ALLOC_QTY = 28 and DEALLOCATION_QTY = 0 and ISSUED_ALLOC_QTY = 0 and CANCELLED_ALLOC_QTY = 0 and INVENTORY_CODE = 'A3' and LOCATION_CODE = 'SG' and ALLOC_TO_VOUCHER_NO = '@@#1#@@' and LINE_ITEM_NO = 2 and MODULE_CODE = 'SO' and TRANSACTION_TYPE_CODE = 'SO' and ALLOCATED_BY_SCREEN = 'SO' | 1       | Sales Order No         |                        |
    Then user gets "#2" before values and sets expected values will be changed in database as "<DB Change KEY>"
      | KEY | VERIFY KEY | Expected Condition | Expected Value 1 | Expected Value 2 | SQL Select Statement                                                                                                                                                                 | Replacement 1 Data Key | Replacement 2 Data Key |
      | 001 | 1          | Not Change         |                  |                  | select QTY_ON_HAND , QTY_ON_HAND_WITHOUT_PACK, QTY_RESERVED, QTY_ON_ORDER, QTY_ON_ORDER_WITHOUT_PACK from MT_INVENTORY_LOCATION where INVENTORY_CODE = 'A1' and LOCATION_CODE = 'SG' |                        |                        |
      | 001 | 2          | Increase By        | 1                |                  | select QTY_ON_HAND_ALLOCATED, QTY_ON_HAND_WO_PCK_ALLOCATED, QTY_ON_HAND_ALLOCATED_TO_SO from MT_INVENTORY_LOCATION where INVENTORY_CODE = 'A1' and LOCATION_CODE = 'SG'              |                        |                        |
      | 001 | 3          | Not Change         |                  |                  | select QTY_ON_ORDER_ALLOCATED, QTY_ON_ORDER_WO_PCK_ALLOCATE, QTY_ON_ORDER_ALLOCATED_TO_SO from MT_INVENTORY_LOCATION where INVENTORY_CODE = 'A1' and LOCATION_CODE = 'SG'            |                        |                        |
      | 001 | 4          | Increase By        | 3                |                  | select PR_QTY_ALLOCATED_TO_SO, PR_QTY_ALLOCATED_TO_SO_WITHOUT_PACK from MT_INVENTORY_LOCATION where INVENTORY_CODE = 'A1' and LOCATION_CODE = 'SG'                                   |                        |                        |
      | 001 | 5          | Increase By        | 4                |                  | select QTY_BACK_ORDER, QTY_BACK_ORDER_WITHOUT_PACK from MT_INVENTORY_LOCATION where INVENTORY_CODE = 'A1' and LOCATION_CODE = 'SG'                                                   |                        |                        |
      | 001 | 6          | Not Change         |                  |                  | select QTY_ON_HAND , QTY_ON_HAND_WITHOUT_PACK, QTY_RESERVED, QTY_ON_ORDER, QTY_ON_ORDER_WITHOUT_PACK from MT_INVENTORY_LOCATION where INVENTORY_CODE = 'A3' and LOCATION_CODE = 'SG' |                        |                        |
      | 001 | 7          | Increase By        | 12               |                  | select QTY_ON_HAND_ALLOCATED, QTY_ON_HAND_WO_PCK_ALLOCATED, QTY_ON_HAND_ALLOCATED_TO_SO from MT_INVENTORY_LOCATION where INVENTORY_CODE = 'A3' and LOCATION_CODE = 'SG'              |                        |                        |
      | 001 | 8          | Increase By        | 8                |                  | select QTY_ON_ORDER_ALLOCATED, QTY_ON_ORDER_WO_PCK_ALLOCATE, QTY_ON_ORDER_ALLOCATED_TO_SO from MT_INVENTORY_LOCATION where INVENTORY_CODE = 'A3' and LOCATION_CODE = 'SG'            |                        |                        |
      | 001 | 9          | Not Change         |                  |                  | select PR_QTY_ALLOCATED_TO_SO, PR_QTY_ALLOCATED_TO_SO_WITHOUT_PACK from MT_INVENTORY_LOCATION where INVENTORY_CODE = 'A3' and LOCATION_CODE = 'SG'                                   |                        |                        |
      | 001 | 10         | Increase By        | 20               |                  | select QTY_BACK_ORDER, QTY_BACK_ORDER_WITHOUT_PACK from MT_INVENTORY_LOCATION where INVENTORY_CODE = 'A3' and LOCATION_CODE = 'SG'                                                   |                        |                        |
    When user navigates to "Processing>Sales>Sales Order" screen
    Then user opens Sales Order Variation of created Sales Order in Outstanding state of Sales Order Summary
    Then user inputs data in Details tab of Sales Order Variation as "<Sales Order Variation KEY>"
      | KEY | LI No. | Item Type | Loading Location | Item Code | Qty | Pack Size | No. Of Pack | Unit | PR  | PO  | Draft/Ost PO No     | Draft/Ost Line Item No | Supplier | Ccy | PO Qty Allocation | QOH Allocation | Unit Cost | Discount Percent | Discount Amount |
      | 001 | 3.0    | I         | SG               | A3        | 20  | PK4 (4.0) | 5           | 10   | No  | Yes | @Purchase Order No@ | 1.0                    | ADELA    | SGD | 2                 | 3              |           |                  |                 |
      | 001 | 4.0    | I         | SG               | A1        | 4   | Loose     |             |      | Yes | No  |                     |                        |          |     |                   | 1              |           |                  |                 |
    Then user submits created Sales Order Variation
    When user navigates to "Processing>Purchase>Purchase Requisition>Requisition Summary>[2]" screen
    Then user opens created Purchase Requisition in Purchase Requisition Draft by Source Voucher No
    Then user checks number of records in database as "<SQL Statement KEY>"
      | KEY | SQL Count Statement                                                                                                                                                                                                                                            | Results | Replacement 1 Data Key | Replacement 2 Data Key |
      | 001 | select COUNT(*) from PO_ORDER_OST_DET_ALLOC where PURCHASE_ORDER_NO = '@@#1#@@' and LINE_ITEM_NO = 1 and ALLOCATION_NO = 2 and SOURCE_ALLOCATION_TYPE = 'S' and SOURCE_VOUCHER_NO = '@@#2#@@' and SOURCE_LINE_ITEM_NO = 3 and ALLOC_QTY = 8                    | 1       | Purchase Order No      | Sales Order No         |
      | 001 | select COUNT(*) from PO_ORDER_OST_SHM_DET_ALLOC where PURCHASE_ORDER_NO = '@@#1#@@' and SHIPMENT_NO = 1 and LINE_ITEM_NO = 1 and ALLOCATION_NO = 2 and ALLOC_SHM_QTY = 8 and ALLOC_SHM_QTY_RECVED = 0 and ALLOC_SHM_QTY_TRANSF = 0 and ALLOC_SHM_QTY_CANCL = 0 | 1       | Purchase Order No      |                        |
    Then user checks number of records in database as "<SQL Statement KEY>"
      | KEY | SQL Count Statement                                                                                                                                                                                                                      | Results | Replacement 1 Data Key  | Replacement 2 Data Key |
      | 001 | select COUNT(*) from PR_REQ_NEW_DET_ALLOC where PURCHASE_REQUISITION_NO = '@@#1#@@' and LINE_ITEM_NO = 1 and ALLOCATION_NO = 1 and ALLOCATION_TYPE = 'S' and SOURCE_VOUCHER_NO = '@@#2#@@' and SOURCE_LINE_ITEM_NO = 4 and ALLOC_QTY = 3 | 1       | Purchase Requisition No | Sales Order No         |
      | 001 | select COUNT(*) from PR_REQ_NEW_SHM_DET_ALLOC where PURCHASE_REQUISITION_NO = '@@#1#@@' and SHIPMENT_NO = 1 and LINE_ITEM_NO = 1 and ALLOCATION_NO = 1 and ALLOC_SHM_QTY = 3                                                             | 1       | Purchase Requisition No |                        |
    Then user verifies "#2" change of value in database as "<DB Change KEY>"
      #Expected Condition will be overwrite if set
      | KEY | VERIFY KEY | Expected Condition | Expected Value 1 | Expected Value 2 | SQL Select Statement | Replacement 1 Data Key | Replacement 2 Data Key |
      | 001 | 1          |                    |                  |                  |                      |                        |                        |
      | 001 | 2          |                    |                  |                  |                      |                        |                        |
      | 001 | 3          |                    |                  |                  |                      |                        |                        |
      | 001 | 4          |                    |                  |                  |                      |                        |                        |
      | 001 | 5          |                    |                  |                  |                      |                        |                        |
      | 001 | 6          |                    |                  |                  |                      |                        |                        |
      | 001 | 7          |                    |                  |                  |                      |                        |                        |
      | 001 | 8          |                    |                  |                  |                      |                        |                        |
      | 001 | 9          |                    |                  |                  |                      |                        |                        |
      | 001 | 10         |                    |                  |                  |                      |                        |                        |
    Then user checks number of records in database as "<SQL Statement KEY>"
      | KEY | SQL Count Statement                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 | Results | Replacement 1 Data Key | Replacement 2 Data Key |
      | 001 | select COUNT(*) from (SELECT H.*,ROW_NUMBER() OVER(ORDER BY ALLOC_VOUCHER_NO DESC) AS RN  from IC_STK_ALLOC_VCH H) where RN = 2 and ALLOC_TYPE = 'S' and STATUS = 'A' and ALLOC_QTY = 12 and REMAIN_ALLOC_QTY = 12 and DEALLOCATION_QTY = 0 and ISSUED_ALLOC_QTY = 0 and CANCELLED_ALLOC_QTY = 0 and INVENTORY_CODE = 'A3' and LOCATION_CODE = 'SG' and ALLOC_TO_VOUCHER_NO = '@@#1#@@' and LINE_ITEM_NO = 3 and MODULE_CODE = 'SO' and TRANSACTION_TYPE_CODE = 'SO' and ALLOCATED_BY_SCREEN = 'SO' | 1       | Sales Order No         |                        |
      | 001 | select COUNT(*) from (SELECT H.*,ROW_NUMBER() OVER(ORDER BY ALLOC_VOUCHER_NO DESC) AS RN  from IC_STK_ALLOC_VCH H) where RN = 1 and ALLOC_TYPE = 'S' and STATUS = 'A' and ALLOC_QTY = 1 and REMAIN_ALLOC_QTY = 1 and DEALLOCATION_QTY = 0 and ISSUED_ALLOC_QTY = 0 and CANCELLED_ALLOC_QTY = 0 and INVENTORY_CODE = 'A1' and LOCATION_CODE = 'SG' and ALLOC_TO_VOUCHER_NO = '@@#1#@@' and LINE_ITEM_NO = 4 and MODULE_CODE = 'SO' and TRANSACTION_TYPE_CODE = 'SO' and ALLOCATED_BY_SCREEN = 'SO'   | 1       | Sales Order No         |                        |

    Examples: 
      | Module Config KEY | DB Change KEY | Purchase Order KEY | Sales Order KEY | SQL Statement KEY | Sales Order Variation KEY | Approval Summary KEY |
      | 001               | 001           | 001                | 001             | 001               | 001                       | 001                  |

  Scenario Outline: Revert config
    Given user login the taskhub system
    When user navigates to "Maintenance Setup>Module Config>Module Config" screen
    Then user changes Module Config as "<Module Config KEY>"
      | KEY | Module Section                      | Module Name                                               | Config Type 1 | Config Value 1 | Config Type 2 | Config Value 2 |
      | 001 | Sales>Quote and Order               | Enable Line Item Location                                 | Radio         | No             |               |                |
      | 001 | Sales>Sales Order                   | Enable Qty On Hand Allocation in SO                       | Radio         | No             |               |                |
      | 001 | Sales>Sales Order                   | Enable Auto Create PO                                     | Radio         | Yes            |               |                |
      | 001 | Sales>Sales Order                   | Enable Auto Create PR                                     | Radio         | Yes            |               |                |
      | 001 | Sales>Sales Order                   | Allocate PO to SO - Allocate Outstanding PO               | Radio         | No             |               |                |
      | 001 | Sales>Sales Order                   | Display "Unit Price" at SO Detail                         | Radio         | Yes            |               |                |
      | 001 | Sales>Sales Order                   | Display "Supplier/CCY" at SO Detail                       | Radio         | Yes            |               |                |
      | 001 | Sales>Sales Order                   | Display "Supplier Exchange Rate" at SO Detail             | Radio         | Yes            |               |                |
      | 001 | Sales>Sales Order                   | Allocate PO to SO - Allocate Draft PO                     | Radio         | No             |               |                |
      | 001 | Sales>Sales Order                   | Allocate PO to SO - Create new PO                         | Radio         | No             |               |                |
      | 001 | Logistic>Outgoing                   | Enable Qty Reservation                                    | Radio         | Yes            |               |                |
      | 001 | Logistic>Outgoing                   | Logistic Outgoing Stage - Holding Bay                     | Radio         | No             |               |                |
      | 001 | Inventory Control>Inventory Control | Default Option of View by Total in Inventory Enquiry      | Radio         | No             |               |                |
      | 001 | Manufacturing>Manufacturing         | Enable allocation of Finished Goods to source Sales Order | Radio         | No             |               |                |

    Examples: 
      | Module Config KEY |
      | 001               |
