@vincent @adela @scm @check_pr_combine_to_po_ost
Feature: Check PR combine to PO Ost

  Scenario: Change Module Config
    #Given "vincent" login to "(AUTO5)" company with password is "taskhub"
    Given user login the taskhub system
    When user navigates to "Maintenance Setup>Module Config>Module Config" screen
    Then user changes Module Config
      | Module Section                | Module Name                                  | Config Type | Config Value |
      | Purchase>Purchase Requisition | Enable Combine PR to Generate Outstanding PO | Radio       | Yes          |

  Scenario Outline: Check PR combine to PO Ost
    #Given "vincent" login to "(AUTO5)" company with password is "taskhub"
    Given user login the taskhub system
    When user navigates to "Processing>Project>Costing>Cost Item Enquiry & Request" screen
    Then user opens Project No. in Cost Item Enquiry & Request as "<Project No KEY>"
      | KEY | Project No. | Customer Name | Sales Person |
      | 001 | PJE0000004  |               |              |
    Then user creates blank new request in Cost Item Request Summary of Cost Item Enquiry & Request
    Then user updates data in Qty To Request Break Down By Phase of Cost Item Enquiry in Cost Item Enquiry of Cost Item Enquiry & Request as "<Cost Item Enquiry KEY>"
      | KEY | No. | Type | Item Code | Sel | Phase No. | Qty to Request |
      | 001 | 3   | S    | V_002     | Yes | 1.3       | 100            |
      | 001 | 4   | S    | V_003     | Yes | 1.3       | 60             |
    Then user adds selected items to request in Cost Item Enquiry of Cost Item Enquiry & Request
    Then user submits Cost Item Request Draft in Cost Item Enquiry & Request
    When user navigates to "Processing>Purchase>Purchase Requisition>Requisition Summary>[2]" screen
    Then user opens created Purchase Requisition in Purchase Requisition Draft
    Then user submits created Purchase Requisition in Purchase Requisition Draft
    Then user opens created Purchase Requisition in Purchase Requisition Cost Confirmation
    And user inputs data for Supplier of Line Item Information in Detail tab of Purchase Requisition Cost Confirmation as "<Purchase Requisition KEY>"
      | KEY | No. | Supplier | Type | Voucher No. | Voucher Date | Ccy | Cost Type | Unit Cost Ref | Unit Cost New | Discount Percent | Discount Amount | Tax  | Tax Amt | Pref Sup |
      | 001 | 1.0 | V_002    |      |             |              | SGD |           |               | 60            |                  |                 | GST7 |         | No       |
      | 001 | 2.0 | V_002    |      |             |              | SGD |           |               | 60            |                  |                 | GST7 |         | Yes      |
      | 001 | 2.0 | V_101    |      |             |              | SGD |           |               | 61            |                  |                 | GST7 |         | No       |
    Then user submits created Purchase Requisition in Purchase Requisition Cost Confirmation
    When user navigates to "Processing>Approval>Approval Summary>[2]" screen
    Then user selects Transaction in Approval Summary as "<Approval Summary KEY>"
      | KEY | Module Code Desc     | Transaction Type Desc      |
      | 001 | Purchase Requisition | Purchase Cost Confirmation |
    Then user updates created PR No. for Supplier of Line Item Information in Detail tab of PR Pending Approval Details in Approval Summary as "<Approval Summary KEY>"
      | KEY | No. | Supplier | Approved Supplier |
      | 001 | 1.0 | V_002    | Yes               |
      | 001 | 2.0 | V_101    | Yes               |
    Then user submits Approval Action for Purchase Requisition as "<Approval Summary KEY>"
      | KEY | PR No.        | Approved Supplier | Action  |
      | 001 | @CREATEDPRNO@ |                   | Approve |
    When user navigates to "Processing>Purchase>Purchase Requisition>Combine PR>[2]" screen
    Then user selects No of PR Pending To Generate PO in Combine PR as as "<Combine PR KEY>"
      | KEY | Supplier Code | Supplier Name         | Curency |
      | 001 | V_101         | Vincent Supplier Name | SGD     |
    Then user selects Group PRs to generate PO in Combine PR as "<Combine PR KEY>"
      | KEY | Shipment Mode | Shipment Term                  | Loading | Discharge | Final Dest | Default ship to Location | SBU |
      | 001 | Air           | Vincent Air Shipment Term Code |         |           |            | Singapore                |     |
    Then user selects and submits created Purchase Requisition in Purchase Requisition of Combine PR then verify kind of PO as "<Create Puchase Order KEY>"
      | KEY | Contains                   | Not Contains         |
      | 001 | Outstanding Purchase Order | Draft Purchase Order |
    When user navigates to "Processing>Purchase>Purchase Requisition>Combine PR>[2]" screen
    Then user selects No of PR Pending To Generate PO in Combine PR as as "<Combine PR KEY>"
      | KEY | Supplier Code | Supplier Name    | Curency |
      | 001 | V_002         | Vincent Supplier | SGD     |
    Then user selects Group PRs to generate PO in Combine PR as "<Combine PR KEY>"
      | KEY | Shipment Mode | Shipment Term                  | Loading | Discharge | Final Dest | Default ship to Location | SBU |
      | 001 | Air           | Vincent Air Shipment Term Code |         |           |            | Singapore                |     |
    Then user selects and submits created Purchase Requisition in Purchase Requisition of Combine PR then verify kind of PO as "<Create Puchase Order KEY>"
      | KEY | Contains                   | Not Contains         |
      | 001 | Outstanding Purchase Order | Draft Purchase Order |

    Examples: 
      | Project No KEY | Cost Item Enquiry KEY | Purchase Requisition KEY | Approval Summary KEY | Combine PR KEY | Create Puchase Order KEY |
      | 001            | 001                   | 001                      | 001                  | 001            | 001                      |
