@vincent @phoebee @scm_standard @scm_standard_sq_so_lg
Feature: Sales Flow SQ - SO - LG out

  Scenario: Change Module Config
    Given user login the taskhub system
    When user navigates to "Maintenance Setup>Module Config>Module Config" screen
    Then user changes Module Config
      | Module Section        | Module Name                                           | Config Type 1 | Config Value 1 | Config Type 2 | Config Value 2 |
      | Logistic>Outgoing     | Enable Auto Purge Sales Order Upon Submit LG Outgoing | Radio         | Yes            |               |                |
      | Logistic>Outgoing     | Default Issued Quantity                               | Radio         | Yes            |               |                |
      | Logistic>Outgoing     | Logistic Outgoing Stage - Holding Bay                 | Radio         | No             |               |                |
      | Sales>Sales Quotation | Enable SQ Margin                                      | Radio         | No             |               |                |
      | Sales>Sales Quotation | Enable SQ Approval                                    | Radio         | No             |               |                |
      | Sales>Sales Order     | Enable SO Approval                                    | Radio         | No             |               |                |

  Scenario Outline: Create Sales Quotation
    Given user login the taskhub system
    #Given "vincent" login to "(AUTO5)" company with password is "taskhub"
    When user navigates to "Processing>Sales>Sales Quotation>[2]" screen
    Given user creates new Sales Quotation in Draft stage of Sales Quotation Summary as "<Sales Quotation KEY>"
      | KEY | Customer Code | Customer Name      | Copy From Option | Copy From |
      | 001 | V_001         | Vincent Customer 1 |                  |           |
    Then all default fields in Draft stage in Header tab of Sales Quotation were be pulled out as "<Sales Quotation KEY>"
      | KEY | Customer Address | Customer Contact | Currency | Sales Tax |
      | 001 | V_001            | V_001            | SGD      | V_001     |
    And user inputs data in Draft stage in Shipment tab of Sales Quotation as "<Sales Quotation KEY>"
      | KEY | Shipment Mode | Shipment Term | Loading Location | No. of Shipment |
      | 001 | A             | V_001         | V_001            | 1               |
    And user inputs data in Draft stage in Detail tab of Sales Quotation as "<Sales Quotation KEY>"
      | KEY | LI No. | Item Type | Item Code | Qty | Unit |
      | 001 | 1.0    | I         | V_001     | 10  | 50   |
    Then user generates SQ report in Draft stage of Sales Quotation
      | Report Title                    | Format |
      | Sales Quotation (Airtec)        | PDF    |
      | Business Format Sales Quotation | PDF    |
      | Business Format Sales Quotation | PDF    |
      | Sales Quotation (W2)            | PDF    |
      | Form Of Acceptance (FOA_W2)     | PDF    |
      | New Sales Quotation (W2)        | PDF    |
    Then user submits created Sales Quotation in Draft stage of Sales Quotation
    Then user opens created Sales Quotation in Outstanding state of Sales Quotation Summary
    Then user confirm created Sales Quotation in Outstanding state of Sales Quotation Summary
    Then user opens created Sales Quotation in History state of Sales Quotation Summary
    When user navigates to "Processing>Sales>Sales Order" screen
    Then user opens created Sales Order in Draft state of Sales Order Summary

    Examples: 
      | Sales Quotation KEY |
      | 001                 |

  Scenario Outline: Create Sales Order - Outgoing Shipment
    Given user login the taskhub system
    #Given "vincent" login to "(AUTO5)" company with password is "taskhub"
    When user navigates to "Processing>Sales>Sales Order" screen
    Given user creates new Sales Order in Draft stage of Sales Order Summary as "<Sales Order KEY>"
      | KEY | Customer Code | Customer Name      | Copy From Option | Copy From |
      | 001 | V_001         | Vincent Customer 1 |                  |           |
    Then all default fields in Draft stage in Header tab of Sales Order will be pulled out as "<Sales Order KEY>"
      | KEY | Customer Address | Customer Contact | Order Currency | Sales Tax |
      | 001 | V_001            | V_001            | SGD            | V_001     |
    And user inputs data in Draft stage in Shipment tab of Sales Order as "<Sales Order KEY>"
      | KEY | Shipment Mode | Shipment Term | Loading Location | No. of Shipment |
      | 001 | A             | V_001         | V_001            | 1               |
    And user inputs data in Draft stage in Detail tab of Sales Order as "<Sales Order KEY>"
      | KEY | LI No. | Item Type | Item Code | Qty | Unit |
      | 001 | 1.0    | I         | V_001     | 10  | 1    |
      | 001 | 2.0    | I         | V_001     | 12  | 1    |
    Then user submits created Sales Order in Draft stage of Sales Order
    Then user opens created Sales Order in Outstanding state of Sales Order Summary
    When user navigates to "Processing>Logistics>Active Shipment>Outgoing Shipment>[2]" screen
    Then user opens created Shipment Voucher No. in Outstanding state of Logistic Outgoing Active Shipment Summary by created Sales Order No.
    Then user generates DO No. for created Shipment Voucher No. in Outstanding state of Logistic Outgoing Active Shipment Summary
    Then user submits created Shipment Voucher No. in Outstanding state of Logistic Outgoing Active Shipment Summary
    Then user opens Shipment Voucher No. in History state of Logistic Outgoing Active Shipment Summary
    When user navigates to "Processing>Sales>Sales Order" screen
    Then user opens created Sales Order in Completed state of Sales Order Summary

    Examples: 
      | Sales Order KEY |
      | 001             |
