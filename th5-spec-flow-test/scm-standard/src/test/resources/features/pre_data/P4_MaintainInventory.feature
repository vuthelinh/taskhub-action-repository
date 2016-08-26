@phoebe_pre_data_4
Feature: Create and maintain inventory
  Mode 1: Maintain Inventory																											
  Mode 2: Create new data for Inventory (using external data file)																											
  Current tested for General tab

  @Create @Maintain
  Scenario Outline: Maintain Inventory
    Given user login the taskhub system
    When user navigates to "Global Setup>Inventory>Inventory" screen
    Then page header shouble be "Inventory"
    Then user maintains Global Inventory as "<Inventory KEY>"
      | KEY | Inventory Code | Description    | Copy From Inventory | Short Description | Detailed Description | Base UOM | Auto Break Pack To Base UOM | Inventory Class | Inventory Category | Budget Category Code | Inventory Type | Inventory Brand | Series 1 | Series 2 | Series 3 | Series 4 | Report Grouping Code | Lot No. Tracking | Serial No. Tracking | Warranty Tracking | Country of Origin | Receipt Minimum Shelf Life | Issue Minimum Expiry | Exchange of Expired Lot | Exchange Allowable Within |
      | 1   | FIFO1          | fifo inventory |                     |                   |                      | PCS      |                             | FIFOSCM         |                    |                      |                |                 |          |          |          |          |                      |                  |                     |                   |                   |                            |                      |                         |                           |
      | 2   | WA1            | WA inventory   |                     |                   |                      | KG       |                             | WASCM           |                    |                      |                |                 |          |          |          |          |                      |                  |                     |                   |                   |                            |                      |                         |                           |
    Then user maintains Specification of Global Inventory as "<Inventory KEY>"
      | KEY | Length inch | Breadth inch | Height inch | Length mm | Breadth mm | Height mm | Volume | Outer Diameter inch | Inner Diameter inch | Outer Length inch | Outer Diameter mm | Inner Diameter mm | Outer Length mm | Gross Weight | Nett Weight | Weight UOM | Density | Measure Type |
    Then user maintains Healthcare of Global Inventory as "<Heathcare KEY>"
      | KEY | Drug Name | Trade Name | Strength | Route | Controlled Drug, MOH reporting req | Generate Product Label | Prescription Desc | Qty | UOM | Frequency | Frequency Desc | Duration | Drug Use Code | Additional Info Code |
    Then user maintains Pack Size of Global Inventory as "<Inventory KEY>"
      | KEY | Pack Size Code | Description | Convert from Pack Size | Qty in Other Pack Size | Qty in Base UOM | Enable in Mobile Pre Sales | Enable Base UOM in Mobile Pre Sales |
    Then user maintains Supplier of Global Inventory as "<Inventory KEY>"
      | KEY | Supplier | Party Inventory Code | Default Description | Billing Description | Remarks | Min Order Qty | Lead Time in Days | Std Pack Size | Home Unit Cost | Default |
    Then user maintains Content of Global Inventory as "<Inventory KEY>"
      | KEY | Content Code | Description | Default Percentage | Default Recovery Rate |
    Then user maintains Attachments of Global Inventory as "<Inventory KEY>"
      | KEY | File Name | File Description |
    Then user maintains Company of Global Inventory as "<Inventory KEY>"
      | KEY | Company Name |
    Then user maintains General in Local Info of Global Inventory as "<Local Info KEY>"
      | KEY | Home Base Cost | Procurement Lead Time | Allow Issue More Than Alloc Qty | Inventory Category | Inventory Model |
    Then user maintains Location information in Local Info of Global Inventory as "<Local Info KEY>"
      | KEY | Location Code | Location Name | Min Holding Qty | Max Holding Qty | Remarks |
      | 1   | SG            |               |                 |                 |         |
    Then user maintains Bin Information in Local Info of Global Inventory as "<Local Info KEY>"
      | KEY | Row | Column | Level | Description |
    Then user maintains Customer Information in Local Info of Global Inventory as "<Local Info KEY>"
      | KEY | MOQ In Loose | Customer | Customer Name | Party Inventory Code | Default Description | Billing Description | D-Sales % | O-Sales % | Remarks |
    Then user maintains Customer Doc in Local Info of Global Inventory as "<Local Info KEY>"
      | KEY | Document Code | Description | Document Type | Current Revision | Attachment |
    Then user maintains List Price By Type in Local Info of Global Inventory as "<Local Info KEY>"
      | KEY | Currency Code | List Price Type Code | List Price Type Desc | List Price | Is Default | For Set Price Distribution |

    Examples: 
      | Inventory KEY | Heathcare KEY | Local Info KEY |
      | 1             |               | 1              |
      | 2             |               | 1              |
