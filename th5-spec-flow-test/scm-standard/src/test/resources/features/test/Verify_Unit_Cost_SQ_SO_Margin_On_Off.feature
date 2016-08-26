@vincent @angela @scm @verify_unit_cost_of_po_that_generated_from_sq_so_margin_on_off
Feature: Verify Unit Cost of PO that generated from SQ - SO - Margin On Off

  Scenario Outline: Verify Unit Cost of PO that generated from -SQ - SO - Margin On Off
    Given user login the taskhub system
    When user navigates to "Maintenance Setup>Module Config>Module Config" screen
    Then user changes Module Config as "<Module Config KEY>"
      | KEY | Module Section        | Module Name                               | Config Type 1 | Config Value 1        | Config Type 2 | Config Value 2 |
      | 001 | Sales>Sales Quotation | Enable SQ Approval                        | Radio         | No                    |               |                |
      | 001 | Sales>Sales Quotation | Enable SQ Margin                          | Radio         | No                    |               |                |
      | 001 | Sales>Sales Quotation | Default Cost for New PO generated from SO | Select        | Sales unit cost       |               |                |
      | 001 | Sales>Sales Order     | Enable SO Approval                        | Radio         | No                    |               |                |
      | 001 | Sales>Sales Order     | Enable Auto Create PO                     | Radio         | Yes                   |               |                |
      | 001 | Sales>Sales Order     | Allocate PO to SO - Create new PO         | Radio         | Yes                   |               |                |
      | 002 | Sales>Sales Quotation | Default Cost for New PO generated from SO | Select        | Default purchase cost |               |                |
      | 003 | Sales>Sales Quotation | Default Cost for New PO generated from SO | Select        | Sales unit cost       |               |                |
      | 003 | Sales>Sales Quotation | Enable SQ Margin                          | Radio         | Yes                   |               |                |
      | 004 | Sales>Sales Quotation | Default Cost for New PO generated from SO | Select        | Default purchase cost |               |                |
      | 004 | Sales>Sales Quotation | Enable SQ Margin                          | Radio         | Yes                   |               |                |
    When user navigates to "Maintenance Setup>Pricing>Default>Default Purchase Cost>[2]" screen
    Then user input data in Inventory Pricing of Default Purchase Cost as "<Inventory Pricing KEY>"
      | KEY | Priority | Description                                     | New Priority |
      | 001 | 0        | Inventory List Price                            | 0            |
      | 001 | 0        | Supplier Inventory Price List by Inv Model(TH5) | 0            |
      | 001 | 0        | Supplier Inventory Price by Location            | 0            |
      | 001 |          | Supplier Inventory Price From Last Purchase     | 1            |
      | 001 | 0        | Supplier Inventory Price List(TH5)              | 0            |
      | 001 | 0        | Supplier Inventory Price List by Inv Model(TH2) | 0            |
      | 001 | 0        | Supplier Inventory Price List                   | 0            |
    Then user input data in Service Pricing of Default Purchase Cost as "<Service Pricing KEY>"
      | KEY | Priority | Description                               | New Priority |
      | 001 | 0        | Supplier Service Price From Last Purchase | 0            |
    When user navigates to "Processing>Sales>Sales Quotation>[2]" screen
    Given user creates new Sales Quotation in Draft stage of Sales Quotation Summary as "<Sales Quotation KEY>"
      | KEY | Customer Code | Customer Name         | Copy From Option | Copy From |
      | 001 | ANGELA        | Synergix Tech Pte Ltd |                  |           |
      | 002 | ANGELA        | Synergix Tech Pte Ltd |                  |           |
      | 003 | ANGELA        | Synergix Tech Pte Ltd |                  |           |
      | 004 | ANGELA        | Synergix Tech Pte Ltd |                  |           |
    Then all default fields in Draft stage in Header tab of Sales Quotation were be pulled out as "<Sales Quotation KEY>"
      | KEY | Customer Address | Customer Contact | Currency | Sales Tax |
      | 001 | 1                | A                | SGD      | GST7      |
      | 002 | 1                | A                | SGD      | GST7      |
      | 003 | 1                | A                | SGD      | GST7      |
      | 004 | 1                | A                | SGD      | GST7      |
    And user inputs data in Draft stage in Detail tab of Sales Quotation as "<Sales Quotation KEY>"
      | KEY | LI No. | Item Type | Item Code | Qty | Unit | Supplier | Ccy | Unit Cost |
      | 001 | 1.0    | I         | 111       | 100 | 0.5  |          |     |           |
      | 002 | 1.0    | I         | 111       | 100 | 0.5  |          |     |           |
      | 003 | 1.0    | I         | 111       | 100 | 0.5  | ANGELA   | SGD | 0.6       |
      | 004 | 1.0    | I         | 111       | 100 | 0.5  | ANGELA   | USD | 0.33      |
    Then user submits created Sales Quotation in Draft stage of Sales Quotation
    Then user opens created Sales Quotation in Outstanding state of Sales Quotation Summary
    Then user confirm created Sales Quotation in Outstanding state of Sales Quotation Summary
    When user navigates to "Processing>Sales>Sales Order" screen
    Then user opens created Sales Order in Draft state of Sales Order Summary
    And user inputs data in Draft stage in Header tab of Sales Order as "<Sales Order KEY>"
      | KEY | Allocate PO to SO |
      | 001 | Yes               |
      | 002 | Yes               |
      | 003 | Yes               |
      | 004 | Yes               |
    And user updates data in Draft stage in Detail tab of Sales Order as "<Sales Order KEY>"
      | KEY | LI No. | Item Type | Item Code | Qty | Unit | PO  | Supplier | Ccy | PO Qty Allocation | Unit Cost |
      | 001 | 1.0    |           |           |     |      | Yes | ANGELA   | USD | 100               | 0.6       |
      | 002 | 1.0    |           |           |     |      | Yes | ANGELA   | USD | 100               | 0.33      |
      | 003 | 1.0    |           |           |     |      | Yes |          |     | 100               |           |
      | 004 | 1.0    |           |           |     |      | Yes |          |     | 100               |           |
    Then user submits created Sales Order then gets Purchase Order No in Draft stage of Sales Order
    When user navigates to "Processing>Purchase>Purchase Order>Purchase Order" screen
    Then user opens created Purchase Order in Draft state of Purchase Order Summary
    Then user verifies display data in Detail tab of Draft state of Purchase Order Detail as "<Purchase Order KEY>"
      | KEY | LI No. | Item Type | Item Code | Qty | Unit Cost |
      | 001 | 1.0    | I         | 111       | 100 | 0.6       |
      | 002 | 1.0    | I         | 111       | 100 | 0.0       |
      | 003 | 1.0    | I         | 111       | 100 | 0.6       |
      | 004 | 1.0    | I         | 111       | 100 | 0.0       |
    When user navigates to "Processing>Sales>Sales Order" screen
    Then user opens Sales Order Variation of created Sales Order in Outstanding state of Sales Order Summary
    Then user inputs data in Details tab of Sales Order Variation as "<Sales Order Variation KEY>"
      | KEY | LI No. | Item Type | Item Code | Qty | Unit | PO  | Supplier | Ccy | PO Qty Allocation | Unit Cost |
      | 001 | 2.0    | I         | 111       | 200 | 0.5  | Yes | ANGELA   | USD | 100               | 0.7       |
      | 002 | 2.0    | I         | 111       | 200 | 0.5  | Yes | ANGELA   | SGD | 100               | 0.34      |
      | 003 | 2.0    | I         | 111       | 200 | 0.5  | Yes | ANGELA   | USD | 100               | 0.7       |
      | 004 | 2.0    | I         | 111       | 200 | 0.5  | Yes | ANGELA   | USD | 100               | 0.34      |
    Then user submits created Sales Order Variation then gets Purchase Order No
    When user navigates to "Processing>Purchase>Purchase Order>Purchase Order" screen
    Then user opens created Purchase Order in Draft state of Purchase Order Summary
    Then user verifies display data in Detail tab of Draft state of Purchase Order Detail as "<Purchase Order KEY>"
      | KEY | LI No. | Item Type | Item Code | Qty | Unit Cost |
      | 001 | 1.0    | I         | 111       | 100 | 0.7       |
      | 002 | 1.0    | I         | 111       | 100 | 0.0       |
      | 003 | 1.0    | I         | 111       | 100 | 0.7       |
      | 004 | 1.0    | I         | 111       | 100 | 0.0       |

    Examples: 
      | Module Config KEY | Inventory Pricing KEY | Service Pricing KEY | Sales Quotation KEY | Sales Order KEY | Purchase Order KEY | Sales Order Variation KEY |
      | 001               | 001                   | 001                 | 001                 | 001             | 001                | 001                       |
      | 002               |                       |                     | 002                 | 002             | 002                | 002                       |
      | 003               |                       |                     | 003                 | 003             | 003                | 003                       |
      | 004               |                       |                     | 004                 | 004             | 004                | 004                       |
