@vincent @phoebe @scm_standard @scm_standard_intergration_pr_po_lg_puring
Feature: Intergration Test - PR-PO-LG-Puring

  Scenario: Change Module Config
    Given user login the taskhub system
    When user navigates to "Maintenance Setup>Module Config>Module Config" screen
    Then user changes Module Config
      | Module Section          | Module Name                                              | Config Type | Config Value |
      | Logistic>Incoming       | Enable Auto Purge Purchase Order Upon Submit LG Incoming | Radio       | No           |
      | Purchase>Purchase Order | Enable PO Draft Approval                                 | Radio       | No           |

  Scenario Outline: Intergration Test - PR-PO-LG-Puring
    Given user login the taskhub system
    #Create and check PR
    When user navigates to "Processing>Purchase>Purchase Requisition>Requisition Summary>[2]" screen
    Given user creates new Purchase Requisition in Purchase Requisition Draft as "<Purchase Requisition KEY>"
      | KEY | Requestor       | Requestor Name       | Copy From | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 001 | @LOGINUSERNAME@ | Phoebe Synergix Team |           |           |           |           |           |
    And user inputs data in Shipment tab of Purchase Requisition Draft  as "<Purchase Requisition KEY>"
      | KEY | Shipment Mode | Shipment Term | Ship to Location | No. of Shipment |
      | 001 | A             | FOB           | SG               | 1               |
    And user inputs data in Detail tab of Purchase Requisition Draft as "<Purchase Requisition KEY>"
      | KEY | No. | Type | Item Code | Qty |
      | 001 | 1.0 | I    | FIFO1     | 10  |
      | 001 | 2.0 | I    | WA1       | 5   |
    And user inputs data for Supplier of Line Item Information in Detail tab of Purchase Requisition Draft as "<Purchase Requisition KEY>"
      | KEY | No. | Supplier | Type | Voucher No. | Voucher Date | Ccy | Cost Type | Unit Cost Ref | Unit Cost New | Discount Percent | Discount Amount | Tax | Tax Amt |
      | 001 | 1.0 | BIGC     | N    |             |              | SGD |           |               | 150           |                  |                 |     |         |
      | 001 | 2.0 | BIGC     | N    |             |              | SGD |           |               | 100           |                  |                 |     |         |
    Then user previews Reports in Purchase Requisition Draft as "<Preview Report KEY>"
      | KEY | Report Title | Checksum | Contents                       |
      | 001 |              |          | Purchase Requisition FIFO1 WA1 |
    Then user submits created Purchase Requisition in Purchase Requisition Draft
    Then user opens created Purchase Requisition in Purchase Requisition Cost Confirmation
    Then user previews Reports in Purchase Requisition Cost Confirmation as "<Preview Report KEY>"
      | KEY | Report Title | Checksum | Contents                       |
      | 001 |              |          | Purchase Requisition FIFO1 WA1 |
    Then user submits created Purchase Requisition in Purchase Requisition Cost Confirmation
    When user navigates to "Maintenance Setup>Administration>Employee>Approving Officer" screen
    Then user selects Transaction in Approving Officer as "<Approving Officer KEY>"
      | KEY | Module Code Desc     | Transaction Type Desc      | Approving Method             | Reject Remarks Mandatory |
      | 001 | Purchase Requisition | Purchase Cost Confirmation | By Amount (1 Level by Value) | Yes                      |
    Then user adds Approving Officer as "<Approving Officer KEY>"
      | KEY | Approving Method             | Approval Home Amount Limit (Per Voucher) | Approving Officer | Employee Code | Officer For Single Supplier |
      | 001 | By Amount (1 Level by Value) | 10,000,000.00                            | PHOEBE2           | PHOEBE2       | False                       |
    When user navigates to "Processing>Approval>Approval Summary>[2]" screen
    Then user selects Transaction in Approval Summary as "<Approval Summary KEY>"
      | KEY | Module Code Desc     | Transaction Type Desc      |
      | 001 | Purchase Requisition | Purchase Cost Confirmation |
    Then user submits Approval Action for Purchase Requisition as "<Approval Summary KEY>"
      | KEY | PR No.        | Approved Supplier | Action  |
      | 001 | @CREATEDPRNO@ | BIGC              | Approve |
    When user navigates to "Processing>Purchase>Purchase Requisition>Requisition Summary>[2]" screen
    Then user opens created Purchase Requisition in Purchase Requisition History
    When user navigates to "Processing>Purchase>Purchase Requisition>Combine PR>[2]" screen
    Then user selects No of PR Pending To Generate PO in Combine PR as as "<Combine PR KEY>"
      | KEY | Supplier Code | Supplier Name | Curency |
      | 001 | BIGC          |               | SGD     |
    Then user selects Group PRs to generate PO in Combine PR as "<Combine PR KEY>"
      | KEY | Shipment Mode | Shipment Term | Loading | Discharge | Final Dest | Default ship to Location | SBU |
      | 001 | Air           | FOB           |         |           |            | Singapore                |     |
    Then user selects and submits created Purchase Requisition in Purchase Requisition of Combine PR
    When user navigates to "Processing>Purchase>Purchase Order>Purchase Order" screen
    Then user opens created Purchase Order in Draft state of Purchase Order Summary
    Then user clear list of created Purchase Order
    #Create new PO
    When user navigates to "Processing>Purchase>Purchase Order>Purchase Order" screen
    Given user creates new Purchase Order in Draft stage of Purchase Order Summary as "<Purchase Order KEY>"
      | KEY | Supplier Code | Supplier Name | Copy From Option | Copy From |
      | 001 | BIGC          |               |                  |           |
    Then all default fields in Draft stage in Header tab of Purchase Order Detail will be pulled out as "<Purchase Order KEY>"
      | KEY | Supplier Contact | Sales Tax | Order Currency | Purchaser |
      | 001 | OFF              | GST7      | SGD            | PHOEBE2   |
    And user inputs data in Draft stage in Shipment tab of Purchase Order Detail as "<Purchase Order KEY>"
      | KEY | Shipment Mode | Shipment Term | Ship to Location | No. of Shipment |
      | 001 | A             | FOB           | SG               | 1               |
    And user inputs data in Draft stage in Detail tab of Purchase Order Detail as "<Purchase Order KEY>"
      | KEY | No. | Item Type | Item Code | Qty | Unit Cost |
      | 001 | 1.0 | I         | FIFO1     | 100 | 12        |
      | 001 | 2.0 | I         | WA1       | 50  | 15        |
    And all default fields in Draft stage in Payment Info tab of Purchase Order Detail will be pulled out as "<Purchase Order KEY>"
      | KEY | Payment Option   | Payment Term     | Payment Term Tenor Code | Payment Term Tenor Days | Payment Method | Payment Amount | Payment Party | Payment Address | Payment Contact |
      | 001 | Cash On Delivery | Cash On Delivery |                         | 0                       | Cash           | 2086.50        | BIGC          | ADD             | OFF             |
    Then user previews Reports in Draft stage of Purchase Order Detail as "<Preview Report KEY>"
      | KEY | Report Title | Checksum | Contents                 |
      | 001 |              |          | Purchase Order FIFO1 WA1 |
    Then user submits created Purchase Order in Draft stage of Purchase Order
    Then user opens created Purchase Order in Outstanding state of Purchase Order Summary
    #Copy to new PO
    When user navigates to "Processing>Purchase>Purchase Order>Purchase Order" screen
    Given user creates new Purchase Order in Draft stage of Purchase Order Summary as "<Purchase Order KEY>"
      | KEY | Supplier Code | Supplier Name | Copy From Option      | Copy From                |
      | 001 |               |               | Outstanding/Completed | @Last Purchase Order No@ |
    Then all default fields in Draft stage in Header tab of Purchase Order Detail will be pulled out as "<Purchase Order KEY>"
      | KEY | Supplier Contact | Sales Tax | Order Currency | Purchaser |
      | 001 | OFF              | GST7      | SGD            | PHOEBE2   |
    And user inputs data in Draft stage in Shipment tab of Purchase Order Detail as "<Purchase Order KEY>"
      | KEY | Shipment Mode | Shipment Term | Ship to Location | No. of Shipment |
      | 001 | A             | FOB           | SG               | 1               |
    Then user verifies display data in Detail tab of Draft state of Purchase Order Detail as "<Purchase Order KEY>"
      | KEY | LI No. | Item Type | Item Code | Qty | Unit Cost |
      | 001 | 1.0    | I         | FIFO1     | 100 | 12        |
      | 001 | 2.0    | I         | WA1       | 50  | 15        |
    And all default fields in Draft stage in Payment Info tab of Purchase Order Detail will be pulled out as "<Purchase Order KEY>"
      | KEY | Payment Option   | Payment Term     | Payment Term Tenor Code | Payment Term Tenor Days | Payment Method | Payment Amount | Payment Party | Payment Address | Payment Contact |
      | 001 | Cash On Delivery | Cash On Delivery |                         | 0                       | Cash           | 2086.50        | BIGC          | ADD             | OFF             |
    Then user previews Reports in Draft stage of Purchase Order Detail as "<Preview Report KEY>"
      | KEY | Report Title | Checksum | Contents       |
      | 001 |              |          | Purchase Order |
    Then user submits created Purchase Order in Draft stage of Purchase Order
    Then user opens created Purchase Order in Outstanding state of Purchase Order Summary
    When user navigates to "Processing>Logistics>Active Shipment>Incoming Shipment" screen
    Then user opens created Shipment Voucher No. in Outstanding state of Logistic Incoming Active Shipment Summary by created Purchase Order No.
    Then user inputs data in Header tab of Logistic Active Outstanding Shipment - Incoming Shipment Details as "<Purchase Order KEY>"
      | KEY | Actual Shipment Date | Actual Arrival Date | Goods Receipt Date |
      | 001 | @CurrentDate@        |                     | @CurrentDate@      |
    Then user submits created Shipment Voucher No. in Logistic Active Outstanding Shipment - Incoming Shipment Details
    Then user opens Shipment Voucher No. in History state of Logistic Incoming Active Shipment Summary
    When user navigates to "Processing>Purchase>Purchase Order>Purchase Order Purging" screen
    Given user purger Purchase Order as "<Purchase Order Purging KEY>"
      | KEY | Purchase Order No. From  | Purchase Order No. To    | Order Date From | Order Date To | Supplier Code From | Supplier Code To |
      | 001 | @Last Purchase Order No@ | @Last Purchase Order No@ | @CurrentDate@   | @CurrentDate@ |                    |                  |
    When user navigates to "Processing>Purchase>Purchase Order>Purchase Order" screen
    Then user opens created Purchase Order in Completed state of Purchase Order Summary
    #Submit LG In partially
    When user navigates to "Processing>Logistics>Active Shipment>Incoming Shipment" screen
    Then user opens created Shipment Voucher No. in Outstanding state of Logistic Incoming Active Shipment Summary by 1 before last created Purchase Order No.
    Then user inputs data in Header tab of Logistic Active Outstanding Shipment - Incoming Shipment Details as "<Purchase Order KEY>"
      | KEY | Actual Shipment Date | Actual Arrival Date | Goods Receipt Date |
      | 001 | @CurrentDate@        |                     | @CurrentDate@      |
    Then user updates data of items in Detail tab of Logistic Active Outstanding Shipment - Incoming Shipment Details as "<Purchase Order KEY>"
      | KEY | No. | Qty |
      | 001 | 1.0 | 10  |
      | 001 | 2.0 | 10  |
    Then user submits created Shipment Voucher No. in Logistic Active Outstanding Shipment - Incoming Shipment Details then get Shipment Voucher No
    Then user opens Shipment Voucher No. in History state of Logistic Incoming Active Shipment Summary by 1 before last created Shipment Voucher No.
    Then user switchs through all tab in Logistic Active History Shipment - Incoming Shipment Details
    Then user verifies display data in Detail tab of Logistic Active History Shipment - Incoming Shipment Details as "<Purchase Order KEY>"
      | KEY | LI No. | Item Type | Item Code | Qty   | Qty Req |
      | 001 | 1.0    | I         | FIFO1     | 10.00 | 100.0   |
      | 001 | 2.0    | I         | WA1       | 10.00 | 50.0    |
    When user navigates to "Processing>Logistics>Active Shipment>Incoming Shipment" screen
    Then user opens created Shipment Voucher No. in Outstanding state of Logistic Incoming Active Shipment Summary by created Shipment Voucher No.
    Then user switchs through all tab in Logistic Active Outstanding Shipment - Incoming Shipment Details

    Examples: 
      | Purchase Requisition KEY | Purchase Order KEY | Approving Officer KEY | Approval Summary KEY | Combine PR KEY | Billing Purchase KEY | Purchase Order Purging KEY | Preview Report KEY |
      | 001                      | 001                | 001                   | 001                  | 001            | 001                  | 001                        | 001                |
