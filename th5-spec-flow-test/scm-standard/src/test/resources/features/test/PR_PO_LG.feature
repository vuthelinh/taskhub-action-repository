@vincent @phoebee @scm_standard @scm_standard_pr_po_lg
Feature: Purchase Flow PR - PO - LG

  Scenario: Change Module Config
    Given user login the taskhub system
    When user navigates to "Maintenance Setup>Module Config>Module Config" screen
    Then user changes Module Config
      | Module Section                | Module Name                                              | Config Type 1 | Config Value 1 | Config Type 2 | Config Value 2 |
      | Logistic>Incoming             | Default Received Quantity                                | Radio         | Yes            |               |                |
      | Logistic>Incoming             | Enable Auto Purge Purchase Order Upon Submit LG Incoming | Radio         | Yes            |               |                |
      | Purchase>Purchase Requisition | Enable Combine PR to Generate Outstanding PO             | Radio         | No             |               |                |

  Scenario Outline: Create Purchase Requisition
    Given user login the taskhub system
    When user navigates to "Processing>Purchase>Purchase Requisition>Requisition Summary>[2]" screen
    Given user creates new Purchase Requisition in Purchase Requisition Draft as "<Purchase Requisition KEY>"
      | KEY | Requestor | Requestor Name        | Copy From |
      | 001 | VINCENT1  | Vincent Synergix Team |           |
    And user inputs data in Shipment tab of Purchase Requisition Draft  as "<Purchase Requisition KEY>"
      | KEY | Shipment Mode | Type | Shipment Term | Ship to Location | No. of Shipment |
      | 001 | A             | I    | V_001         | V_001            | 1               |
    And user inputs data in Detail tab of Purchase Requisition Draft as "<Purchase Requisition KEY>"
      | KEY | No. | Item Code | Qty | Supplier | Unit Cost New |
      | 001 | 1.0 | V_001     | 10  | V_101    | 150           |
      | 001 | 2.0 | V_003     | 5   | V_101    | 100           |
    Then user previews Reports in Purchase Requisition Draft as "<Preview Report KEY>"
      | KEY | Report Title | Checksum | Contents                         |
      | 001 |              |          | Purchase Requisition V_001 V_003 |
    Then user submits created Purchase Requisition in Purchase Requisition Draft
    Then user opens created Purchase Requisition in Purchase Requisition Cost Confirmation
    Then user previews Reports in Purchase Requisition Cost Confirmation as "<Preview Report KEY>"
      | KEY | Report Title | Checksum | Contents                         |
      | 001 |              |          | Purchase Requisition V_001 V_003 |
    Then user submits created Purchase Requisition in Purchase Requisition Cost Confirmation
    Then user opens created Purchase Requisition in Purchase Requisition Pending
    When user navigates to "Maintenance Setup>Administration>Employee>Approving Officer" screen
    Then user selects Transaction in Approving Officer as "<Approving Officer KEY>"
      | KEY | Module Code Desc     | Transaction Type Desc      | Approving Method             | Reject Remarks Mandatory |
      | 001 | Purchase Requisition | Purchase Cost Confirmation | By Amount (1 Level by Value) | Yes                      |
    Then user adds Approving Officer as "<Approving Officer KEY>"
      | KEY | Approving Method             | Approval Home Amount Limit (Per Voucher) | Approving Officer | Employee Code | Officer For Single Supplier |
      | 001 | By Amount (1 Level by Value) | 10,000,000.00                            | VINCENT1          | VINCENT1      | False                       |
    When user navigates to "Processing>Approval>Approval Summary>[2]" screen
    Then user selects Transaction in Approval Summary as "<Approval Summary KEY>"
      | KEY | Module Code Desc     | Transaction Type Desc      |
      | 001 | Purchase Requisition | Purchase Cost Confirmation |
    Then user submits Approval Action for Purchase Requisition as "<Approval Summary KEY>"
      | KEY | PR No.        | Approved Supplier | Action  |
      | 001 | @CREATEDPRNO@ | V_101             | Approve |
    When user navigates to "Processing>Purchase>Purchase Requisition>Requisition Summary>[2]" screen
    Then user opens created Purchase Requisition in Purchase Requisition History
    When user navigates to "Processing>Purchase>Purchase Requisition>Combine PR>[2]" screen
    Then user selects No of PR Pending To Generate PO in Combine PR as as "<Combine PR KEY>"
      | KEY | Supplier Code | Supplier Name | Curency |
      | 001 | V_101         |               |         |
    Then user selects Group PRs to generate PO in Combine PR as "<Combine PR KEY>"
      | KEY | Shipment Mode | Shipment Term                  | Loading | Discharge | Final Dest | Default ship to Location | SBU |
      | 001 | Air           | Vincent Air Shipment Term Code |         |           |            | Vincent Location Code    |     |
    Then user selects and submits created Purchase Requisition in Purchase Requisition of Combine PR
    When user navigates to "Processing>Purchase>Purchase Order>Purchase Order" screen
    Then user opens created Purchase Order in Purchase Order Detail Draft

    Examples: 
      | Purchase Requisition KEY | Approving Officer KEY | Approval Summary KEY | Combine PR KEY | Preview Report KEY |
      | 001                      | 001                   | 001                  | 001            | 001                |

  Scenario Outline: Create Purchase Order - Incoming Shipment
    Given user login the taskhub system
    When user navigates to "Processing>Purchase>Purchase Order>Purchase Order" screen
    Given user creates new Purchase Order in Draft stage of Purchase Order Summary as "<Purchase Order KEY>"
      | KEY | Supplier Code | Supplier Name         | Copy From Option | Copy From |
      | 001 | V_101         | Vincent Supplier Name |                  |           |
    Then all default fields in Draft stage in Header tab of Purchase Order Detail will be pulled out as "<Purchase Order KEY>"
      | KEY | Supplier Contact | Sales Tax | Order Currency | Purchaser |
      | 001 | V_001            | V_001     | SGD            | VINCENT1  |
    And user inputs data in Draft stage in Shipment tab of Purchase Order Detail as "<Purchase Order KEY>"
      | KEY | Shipment Mode | Shipment Term | Ship to Location | No. of Shipment |
      | 001 | A             | V_001         | V_001            | 1               |
    And user inputs data in Draft stage in Detail tab of Purchase Order Detail as "<Purchase Order KEY>"
      | KEY | No. | Item Type | Item Code | Qty | Unit Cost |
      | 001 | 1.0 | I         | V_001     | 100 | 12        |
      | 001 | 2.0 | I         | V_001     | 50  | 15        |
    And all default fields in Draft stage in Payment Info tab of Purchase Order Detail will be pulled out as "<Purchase Order KEY>"
      | KEY | Payment Option | Payment Term | Payment Term Tenor Code | Payment Term Tenor Days | Payment Method | Payment Amount | Payment Party | Payment Address | Payment Contact |
      | 001 | Open Account   | Credit Term  | V_001                   | 1                       | Cash           | 1969.50        | V_101         | V_001           | V_001           |
    Then user previews Reports in Draft stage of Purchase Order Detail as "<Preview Report KEY>"
      | KEY | Report Title | Checksum | Contents             |
      | 001 |              |          | Purchase Order V_001 |
    Then user submits created Purchase Order in Draft stage of Purchase Order
    Then user opens created Purchase Order in Outstanding state of Purchase Order Summary
    When user navigates to "Processing>Logistics>Active Shipment>Incoming Shipment" screen
    Then user opens created Shipment Voucher No. in Outstanding state of Logistic Incoming Active Shipment Summary by created Purchase Order No.
    Then user inputs data in Header tab of Logistic Active Outstanding Shipment - Incoming Shipment Details as "<Purchase Order KEY>"
      | KEY | Actual Shipment Date | Actual Arrival Date | Goods Receipt Date |
      | 001 | @CurrentDate@        |                     | @CurrentDate@      |
    Then user submits created Shipment Voucher No. in Logistic Active Outstanding Shipment - Incoming Shipment Details
    Then user opens Shipment Voucher No. in History state of Logistic Incoming Active Shipment Summary
    When user navigates to "Processing>Purchase>Purchase Order>Purchase Order" screen
    Then user opens created Purchase Order in Completed state of Purchase Order Summary
    When user navigates to "Processing>Logistics>Billing Planning>Billing Purchase" screen
    Then user selects No. of Invoice in Logistic Billing Purchase Supplier Summary as "<Billing Purchase KEY>"
      | KEY | Supplier Code | Supplier Name |
      | 001 | V_101         |               |
    Then user opens created Invoice No. in Logistic Billing Purchase Details
    Then user inputs data for created Invoice No. in Logistic Billing Purchase Details as "<Billing Purchase KEY>"
      | KEY | Supplier Invoice Date |
      | 001 | @CurrentDate@         |
    Then user submits created Invoice No. in Logistic Billing Purchase Details

    Examples: 
      | Purchase Order KEY | Billing Purchase KEY | Preview Report KEY |
      | 001                | 001                  | 001                |
