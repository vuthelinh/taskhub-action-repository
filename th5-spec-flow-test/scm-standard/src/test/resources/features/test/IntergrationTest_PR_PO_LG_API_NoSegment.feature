@vincent @angela @scm @intergration_pr_po_lg_lgapi_no_segment
Feature: Intergration Test - PR-PO-LG-LGAPI

  Scenario Outline: Intergration Test - PR-PO-LG-LGAPI
    Given user login the taskhub system
    When user navigates to "Processing>Purchase>Purchase Requisition>Requisition Summary>[2]" screen
    Given user creates new Purchase Requisition in Purchase Requisition Draft as "<Purchase Requisition KEY>"
      | KEY | Requestor       | Requestor Name | Copy From | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 001 | @LOGINUSERNAME@ |                |           |           |           |           |           |
    And user inputs data in Shipment tab of Purchase Requisition Draft  as "<Purchase Requisition KEY>"
      | KEY | Shipment Mode | Shipment Term | Ship to Location | No. of Shipment |
      | 001 | A             | FOB           | SG               |                 |
    And user inputs data in Detail tab of Purchase Requisition Draft as "<Purchase Requisition KEY>"
      | KEY | No. | Type | Item Code  | Qty |
      | 001 | 1.0 | I    | INVEN-FIFO | 12  |
      | 001 | 2.0 | I    | INVEN-LOT  | 13  |
      | 001 | 3.0 | I    | INVEN-WA   | 14  |
      | 001 | 4.0 | I    | INVEN-SN   | 15  |
      | 001 | 5.0 | S    | S1         | 16  |
    And user inputs data for Supplier of Line Item Information in Detail tab of Purchase Requisition Draft as "<Purchase Requisition KEY>"
      | KEY | No. | Supplier | Type | Voucher No. | Voucher Date | Ccy | Cost Type | Unit Cost Ref | Unit Cost New | Discount Percent | Discount Amount | Tax | Tax Amt |
      | 001 | 1.0 | ANGELA   | N    |             |              | SGD |           |               | 10            |                  |                 |     |         |
      | 001 | 2.0 | ANGELA   | N    |             |              | SGD |           |               | 4             |                  |                 |     |         |
      | 001 | 3.0 | ANGELA   | N    |             |              | SGD |           |               | 1             |                  |                 |     |         |
      | 001 | 4.0 | ANGELA   | N    |             |              | SGD |           |               | 20            |                  |                 |     |         |
      | 001 | 5.0 | ANGELA   | N    |             |              | SGD |           |               | 5.5           |                  |                 |     |         |
    Then user submits created Purchase Requisition in Purchase Requisition Draft
    Then user opens created Purchase Requisition in Purchase Requisition Cost Confirmation
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
      | 001 | @CREATEDPRNO@ | ANGELA            | Approve |
    When user navigates to "Processing>Purchase>Purchase Requisition>Requisition Summary>[2]" screen
    Then user opens created Purchase Requisition in Purchase Requisition History
    When user navigates to "Processing>Purchase>Purchase Requisition>Combine PR>[2]" screen
    Then user selects No of PR Pending To Generate PO in Combine PR as as "<Combine PR KEY>"
      | KEY | Supplier Code | Supplier Name | Curency |
      | 001 | ANGELA        |               | SGD     |
    Then user selects Group PRs to generate PO in Combine PR as "<Combine PR KEY>"
      | KEY | Shipment Mode | Shipment Term | Loading | Discharge | Final Dest | Default ship to Location | SBU  |
      | 001 | Air           | Free On Board |         |           |            | Singapore                | Auto |
    Then user selects and submits created Purchase Requisition in Purchase Requisition of Combine PR
    When user navigates to "Processing>Purchase>Purchase Order>Purchase Order" screen
    Then user opens created Purchase Order in Draft state of Purchase Order Summary
    Then user submits created Purchase Order in Draft stage of Purchase Order
    Then user opens Purchase Order Variation of created Purchase Order in Outstanding state of Purchase Order Summary
    And user inputs data for Allocation of Allocation Details in Detail tab of Purchase Order Variation Detail as "<Purchase Order Variation KEY>"
      | KEY | No. | Allocation No. | Type | Voucher No. | Customer Job No. | Phase No. | Schedule No. | Line Item No. | Alloc Qty |
      | 001 | 5.0 | 1.0            |      | PJE0000006  |                  | 1         |              |               | 10        |
    Then user submits created Purchase Order Variation
    When user navigates to "Processing>Logistics>Active Shipment>Incoming Shipment" screen
    Then user opens created Shipment Voucher No. in Outstanding state of Logistic Incoming Active Shipment Summary by created Purchase Order No.
    Then user inputs data in Header tab of Logistic Active Outstanding Shipment - Incoming Shipment Details as "<Purchase Order KEY>"
      | KEY | Actual Shipment Date | Actual Arrival Date | Goods Receipt Date |
      | 001 | @CurrentDate@        |                     | @CurrentDate@      |
    Then user updates data of items in Detail tab of Logistic Active Outstanding Shipment - Incoming Shipment Details as "<Purchase Order KEY>"
      | KEY | No. | Qty |
      | 001 | 1.0 | 2.5 |
      | 001 | 3.0 | 14  |
      | 001 | 4.0 | 15  |
      | 001 | 5.0 | 11  |
    Then user add new Lots Information for item in Detail tab of Logistic Active Outstanding Shipment - Incoming Shipment Details as "<Purchase Order KEY>"
      | KEY | No. | Ref No. | Expire Date | Country of Origin | Quantity |
      | 001 | 2.0 | #1      |             |                   | 2.5      |
      | 001 | 2.0 | #2      |             |                   | 3.5      |
    Then user generates Serial No Generating in Receving Serial Number in Detail tab of Logistic Active Outstanding Shipment - Incoming Shipment Details as "<Purchase Order KEY>"
      | KEY | No. | Prefix        | Suffix | First No | Last No |
      | 001 | 4.0 | @DATETIMENOW@ |        |          | 15      |
    Then user submits created Shipment Voucher No. in Logistic Active Outstanding Shipment - Incoming Shipment Details then get Shipment Voucher No
    Then user opens created Shipment Voucher No. in Outstanding state of Logistic Incoming Active Shipment Summary by created Shipment Voucher No.
    When user navigates to "Processing>Logistics>Billing Planning>Billing Purchase" screen
    Then user selects No. of Invoice in Logistic Billing Purchase Supplier Summary as "<Billing Purchase KEY>"
      | KEY | Supplier Code | Supplier Name |
      | 001 | ANGELA        |               |
    Then user opens created Invoice No. in Logistic Billing Purchase Details by 1 before last created Shipment Voucher No
    Then user inputs data for created Invoice No. in Logistic Billing Purchase Details as "<Billing Purchase KEY>"
      | KEY | Supplier Invoice Date |
      | 001 | @CurrentDate@         |
    Then user submits created Invoice No. in Logistic Billing Purchase Details
    Given user changes database connection as "<DATABASE KEY>"
      | KEY | JDBC_DRIVER               | IP_SERVER   | SERVER_PORT | DB_NAME | USER_NAME | PASS_WORD      |
      | 001 | com.ibm.db2.jcc.DB2Driver | 172.16.1.10 | 50000       | PEMAIN3 | db2admin  | P@$$.W0rd.2014 |
    Then user checks number of records in database as "<SQL Statement KEY>"
      | KEY | SQL Count Statement                                                        | Results | Replacement 1 Data Key | Index 1 | Replacement 2 Data Key | Index 2 |
      | 001 | select count(*) from gl_ledger_summary where source_voucher_no = '@@#1#@@' | 4       | Shipment Voucher No    | -1      |                        |         |
      | 001 | select count(*) from gl_ledger_summary where source_voucher_no = '@@#1#@@' | 2       | Invoice No             |         |                        |         |

    Examples: 
      | Purchase Requisition KEY | Purchase Order KEY | Approving Officer KEY | Approval Summary KEY | Combine PR KEY | Billing Purchase KEY | SQL Statement KEY | Purchase Order Variation KEY | DATABASE KEY |
      | 001                      | 001                | 001                   | 001                  | 001            | 001                  | 001               | 001                          | 001          |
