@vincent @angela @scm @vincent_testspeed1
Feature: Purchase Flow PR - PO

  Scenario Outline: Create Purchase Requisition
    Given user login the taskhub system
    When user navigates to "Processing>Purchase>Purchase Requisition>Requisition Summary>[2]" screen
    Given user creates new Purchase Requisition in Purchase Requisition Draft as "<Purchase Requisition KEY>"
      | KEY | Requestor | Requestor Name | Copy From | Purchase Requisition Date |
      | 001 | ANGELA2   |                |           | 01/04/2016                |
    And user inputs data in Shipment tab of Purchase Requisition Draft  as "<Purchase Requisition KEY>"
      | KEY | Shipment Mode | Shipment Term | Ship to Location | No. of Shipment |
      | 001 | R             | FOB           | SG               | 1               |
    And user inputs data in Detail tab of Purchase Requisition Draft as "<Purchase Requisition KEY>"
      | KEY | No.  | Type | Item Code | Qty | Supplier | Unit Cost New |
      | 001 | 1.0  | S    | S1        | 20  |          |               |
      | 001 | 2.0  | S    | S2        | 10  |          |               |
      | 001 | 3.0  | S    | S1        | 1   |          |               |
      | 001 | 4.0  | S    | S2        | 1   |          |               |
      | 001 | 5.0  | S    | S1        | 1   |          |               |
      | 001 | 6.0  | S    | S2        | 1   |          |               |
      | 001 | 7.0  | S    | S1        | 1   |          |               |
      | 001 | 8.0  | S    | S2        | 1   |          |               |
      | 001 | 9.0  | S    | S1        | 1   |          |               |
      | 001 | 10.0 | S    | S2        | 1   |          |               |
    And user inputs data for Supplier of Line Item Information in Detail tab of Purchase Requisition Draft as "<Purchase Requisition KEY>"
      | KEY | No.  | Supplier | Type | Voucher No. | Voucher Date | Ccy | Cost Type | Unit Cost Ref | Unit Cost New | Discount Percent | Discount Amount | Tax | Tax Amt |
      | 001 | 2.0  | S001     | N    |             |              | SGD | B         |               |               |                  |                 |     |         |
      | 001 | 3.0  | S001     | N    |             |              | SGD | B         |               |               |                  |                 |     |         |
      | 001 | 4.0  | S001     | N    |             |              | SGD | B         |               |               |                  |                 |     |         |
      | 001 | 5.0  | S001     | N    |             |              | SGD | B         |               |               |                  |                 |     |         |
      | 001 | 6.0  | S001     | N    |             |              | SGD | B         |               |               |                  |                 |     |         |
      | 001 | 7.0  | S001     | N    |             |              | SGD | B         |               |               |                  |                 |     |         |
      | 001 | 8.0  | S001     | N    |             |              | SGD | B         |               |               |                  |                 |     |         |
      | 001 | 9.0  | S001     | N    |             |              | SGD | B         |               |               |                  |                 |     |         |
      | 001 | 10.0 | S001     | N    |             |              | SGD | B         |               |               |                  |                 |     |         |
    And user inputs data for Allocation of Line Item Information in Detail tab of Purchase Requisition Draft as "<Purchase Requisition KEY>"
      | KEY | No.  | Allocation No. | Type | Voucher No. | Customer Job No. | Phase No. | Schedule No. | Line Item No. | Alloc Qty |
      | 001 | 1.0  | 1.0            | P    | PJE0000001  |                  | 1         |              |               | 1         |
      | 001 | 1.0  | 2.0            | P    | PJE0000001  |                  | 1         |              |               | 2         |
      | 001 | 1.0  | 3.0            | P    | PJE0000001  |                  | 1         |              |               | 3         |
      | 001 | 1.0  | 4.0            | P    | PJE0000001  |                  | 1         |              |               | 4         |
      | 001 | 1.0  | 5.0            | P    | PJE0000001  |                  | 1         |              |               | 5         |
      | 001 | 1.0  | 6.0            | P    | PJE0000001  |                  | 1         |              |               | 5         |
      | 001 | 2.0  | 1.0            | P    | PJE0000001  |                  | 1         |              |               | 4         |
      | 001 | 2.0  | 2.0            | P    | PJE0000001  |                  | 1         |              |               | 2         |
      | 001 | 2.0  | 3.0            | P    | PJE0000001  |                  | 1         |              |               | 2         |
      | 001 | 2.0  | 4.0            | P    | PJE0000001  |                  | 1         |              |               | 2         |
      | 001 | 3.0  | 1.0            | P    | PJE0000001  |                  | 1         |              |               | 1         |
      | 001 | 4.0  | 1.0            | P    | PJE0000001  |                  | 1         |              |               | 1         |
      | 001 | 5.0  | 1.0            | P    | PJE0000001  |                  | 1         |              |               | 1         |
      | 001 | 6.0  | 1.0            | P    | PJE0000001  |                  | 1         |              |               | 1         |
      | 001 | 7.0  | 1.0            | P    | PJE0000001  |                  | 1         |              |               | 1         |
      | 001 | 8.0  | 1.0            | P    | PJE0000001  |                  | 1         |              |               | 1         |
      | 001 | 9.0  | 1.0            | P    | PJE0000001  |                  | 1         |              |               | 1         |
      | 001 | 10.0 | 1.0            | P    | PJE0000001  |                  | 1         |              |               | 1         |
    Then user submits created Purchase Requisition in Purchase Requisition Draft
    Then user opens created Purchase Requisition in Purchase Requisition Cost Confirmation
    And user inputs data for Supplier of Line Item Information in Detail tab of Purchase Requisition Cost Confirmation as "<Purchase Requisition KEY>"
      | KEY | No. | Supplier | Type | Voucher No. | Voucher Date | Ccy | Cost Type | Unit Cost Ref | Unit Cost New | Discount Percent | Discount Amount | Tax | Tax Amt |
      | 001 | 1.0 | S001     | N    |             |              | SGD | B         |               |               |                  |                 |     |         |
    Then user submits created Purchase Requisition in Purchase Requisition Cost Confirmation
    When user navigates to "Processing>Approval>Approval Summary>[2]" screen
    Then user selects Transaction in Approval Summary as "<Approval Summary KEY>"
      | KEY | Module Code Desc     | Transaction Type Desc      |
      | 001 | Purchase Requisition | Purchase Cost Confirmation |
    Then user submits Approval Action for Purchase Requisition as "<Approval Summary KEY>"
      | KEY | PR No.        | Approved Supplier | Action  |
      | 001 | @CREATEDPRNO@ | S001              | Approve |
    When user navigates to "Processing>Purchase>Purchase Requisition>Requisition Summary>[2]" screen
    Then user opens created Purchase Requisition in Purchase Requisition History
    When user navigates to "Processing>Purchase>Purchase Requisition>Combine PR>[2]" screen
    Then user selects No of PR Pending To Generate PO in Combine PR as as "<Combine PR KEY>"
      | KEY | Supplier Code | Supplier Name    | Curency |
      | 001 | S001          | Synergix Pte Ltd | SGD     |
    Then user selects Group PRs to generate PO in Combine PR as "<Combine PR KEY>"
      | KEY | Shipment Mode | Shipment Term | Loading | Discharge | Final Dest | Default ship to Location | SBU |
      | 001 | Road          | Free on Board |         |           |            | Singapore                |     |
    Then user selects and submits created Purchase Requisition in Purchase Requisition of Combine PR
    When user navigates to "Processing>Purchase>Purchase Order>Purchase Order" screen
    Then user opens created Purchase Order in Draft state of Purchase Order Summary
    Then user submits created Purchase Order in Draft stage of Purchase Order
    Then user opens created Purchase Order in Outstanding state of Purchase Order Summary

    Examples: 
      | Purchase Requisition KEY | Purchase Order KEY | Approving Officer KEY | Approval Summary KEY | Combine PR KEY | Billing Purchase KEY |
      | 001                      | 001                | 001                   | 001                  | 001            | 001                  |
      | 001                      | 001                | 001                   | 001                  | 001            | 001                  |
