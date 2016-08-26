@vincent @angela @scm_standard @scm_standard_pr_po_lg_bp
Feature: Purchase Flow PR - PO - LG - BP

  Scenario Outline: Change config
    Given user login the taskhub system
    When user navigates to "Maintenance Setup>Module Config>Module Config" screen
    Then user changes Module Config as "<Module Config KEY>"
      | KEY | Module Section                | Module Name                                  | Config Type 1 | Config Value 1 | Config Type 2 | Config Value 2 |
      | 001 | Purchase>Purchase Requisition | Enable Combine PR to Generate Outstanding PO | Radio         | No             |               |                |

    Examples: 
      | Module Config KEY |
      | 001               |

  Scenario Outline: Create Purchase Requisition
    Given user login the taskhub system
    When user navigates to "Processing>Purchase>Purchase Requisition>Requisition Summary>[2]" screen
    Given user creates new Purchase Requisition in Purchase Requisition Draft as "<Purchase Requisition KEY>"
      | KEY | Requestor | Requestor Name        | Copy From |
      | 001 | VINCENT1  | Vincent Synergix Team |           |
    And user inputs data in Shipment tab of Purchase Requisition Draft  as "<Purchase Requisition KEY>"
      | KEY | Shipment Mode | Shipment Term | Ship to Location | No. of Shipment |
      | 001 | A             | V_001         | V_001            | 1               |
    And user inputs data in Detail tab of Purchase Requisition Draft as "<Purchase Requisition KEY>"
      | KEY | No. | Type | Item Code | Qty | Supplier | Unit Cost New |
      | 001 | 1.0 | I    | V_001     | 10  |          |               |
      | 001 | 2.0 | S    | V_001     | 20  |          |               |
    And user inputs data for Supplier of Line Item Information in Detail tab of Purchase Requisition Draft as "<Purchase Requisition KEY>"
      | KEY | No. | Supplier | Type | Voucher No. | Voucher Date | Ccy | Cost Type | Unit Cost Ref | Unit Cost New | Discount Percent | Discount Amount | Tax   | Tax Amt |
      | 001 | 1.0 | V_101    | N    |             |              | SGD | B         |               | 10            | 10               |                 | V_001 |         |
    And user inputs data for Allocation of Line Item Information in Detail tab of Purchase Requisition Draft as "<Purchase Requisition KEY>"
      | KEY | No. | Allocation No. | Type | Voucher No. | Customer Job No. | Phase No. | Schedule No. | Line Item No. | Alloc Qty |
      | 001 | 2.0 | 1.0            | P    | PJE0000001  |                  | 1         | 0.0          | 1.00          | 20        |
    Then user submits created Purchase Requisition in Purchase Requisition Draft
    Then user opens created Purchase Requisition in Purchase Requisition Cost Confirmation
    And user inputs data for Supplier of Line Item Information in Detail tab of Purchase Requisition Cost Confirmation as "<Purchase Requisition KEY>"
      | KEY | No. | Supplier | Type | Voucher No. | Voucher Date | Ccy | Cost Type | Unit Cost Ref | Unit Cost New | Discount Percent | Discount Amount | Tax   | Tax Amt |
      | 001 | 2.0 | V_101    | N    |             |              | SGD | B         |               | 9             | 10               |                 | V_001 |         |
    And data for Allocation of Line Item Information was entered in Detail tab of Purchase Requisition Cost Confirmation as "<Purchase Requisition KEY>"
      | KEY | No. | Allocation No. | Type | Voucher No. | Customer Job No. | Phase No. | Schedule No. | Line Item No. | Alloc Qty |
      | 001 | 2.0 | 1.0            | P    | PJE0000001  |                  | 1         | 0.0          | 1.00          | 20.00     |
    Then user submits created Purchase Requisition in Purchase Requisition Cost Confirmation
    When user navigates to "Maintenance Setup>Administration>Employee>Approving Officer" screen
    Then user selects Transaction in Approving Officer as "<Approving Officer KEY>"
      | KEY | Module Code Desc     | Transaction Type Desc      | Approving Method             | Reject Remarks Mandatory |
      | 001 | Purchase Requisition | Purchase Cost Confirmation | By Amount (1 Level by Value) | Yes                      |
    Then user adds Approving Officer as "<Approving Officer KEY>"
      | KEY | Approving Method             | Approval Home Amount Limit (Per Voucher) | Approving Officer | Employee Code | Officer For Single Supplier |
      | 001 | By Amount (1 Level by Value) | 999,999,999.00                           | VINCENT1          | VINCENT1      | False                       |
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
      | KEY | Supplier Code | Supplier Name         | Curency |
      | 001 | V_101         | Vincent Supplier Name | SGD     |
    Then user selects Group PRs to generate PO in Combine PR as "<Combine PR KEY>"
      | KEY | Shipment Mode | Shipment Term                  | Loading | Discharge | Final Dest | Default ship to Location | SBU |
      | 001 | Air           | Vincent Air Shipment Term Code |         |           |            | Vincent Location Code    |     |
    Then user selects and submits created Purchase Requisition in Purchase Requisition of Combine PR
    When user navigates to "Processing>Purchase>Purchase Order>Purchase Order" screen
    Then user opens created Purchase Order in Draft state of Purchase Order Summary
    Then user submits created Purchase Order in Draft stage of Purchase Order
    Then user opens created Purchase Order in Outstanding state of Purchase Order Summary
    When user navigates to "Processing>Logistics>Active Shipment>Incoming Shipment" screen
    Then user opens created Shipment Voucher No. in Outstanding state of Logistic Incoming Active Shipment Summary by created Purchase Order No.
    Then user inputs data in Header tab of Logistic Active Outstanding Shipment - Incoming Shipment Details as "<Purchase Order KEY>"
      | KEY | Actual Shipment Date | Actual Arrival Date | Goods Receipt Date |
      | 001 | @CurrentDate@        |                     | @CurrentDate@      |
    Then user click on Receive All Ost Qty button in Detail tab of Active Outstanding Shipment - Incoming Shipment Details
    Then user submits created Shipment Voucher No. in Logistic Active Outstanding Shipment - Incoming Shipment Details
    When user navigates to "Processing>Logistics>Billing Planning>Billing Purchase" screen
    Then user selects No. of Invoice in Logistic Billing Purchase Supplier Summary as "<Billing Purchase KEY>"
      | KEY | Supplier Code | Supplier Name         |
      | 001 | V_101         | Vincent Supplier Name |
    Then user opens created Invoice No. in Logistic Billing Purchase Details
    Then user inputs data for created Invoice No. in Logistic Billing Purchase Details as "<Billing Purchase KEY>"
      | KEY | Supplier Invoice Date |
      | 001 | @CurrentDate@         |
    Then user submits created Invoice No. in Logistic Billing Purchase Details

    Examples: 
      | Purchase Requisition KEY | Purchase Order KEY | Approving Officer KEY | Approval Summary KEY | Combine PR KEY | Billing Purchase KEY |
      | 001                      | 001                | 001                   | 001                  | 001            | 001                  |
