Feature: Input data for Quotation Testing

  Background:
    Given user is currently logged in to TaskHub System

    @DataForQuotationTesting
  Scenario:
    And user create Project Category
      | Project Category Code | Description |
      | An Project            |             |
    And user create Strategic Business Unit
      | SBU Code | Description |
      | KD1      |             |
      | KD2      |             |
    And user create Party
      | Party Code  | Party Name  |
      | BONDS PARTY | Bonds party |
    And user create Supplier
      | Supplier | Supplier Name | Supplier Class Code | Currency |
      | BIGC     | BigC          | A1                  | USD      |
      | METRO    | Metro         | A1                  | USD      |
      | LOTTE    | Lotte         | A1                  | USD      |
      | COOPMART | CoopMart      | A1                  | USD      |
      |          |               |                     | VND      |
      | ADAYROI1 | Adayroi       | A1                  | USD      |
    And user create Brand
      | Inventory Brand Code | Description     |
      | SS                   | Seah Steel      |
      | VC                   | Vina Coperation |
      | HP                   | Hoa Phat        |
      | PM                   | Pomina          |
      | TL                   | Teletek         |
      | SC                   | Secom           |
      | MR                   | Mircom          |
    And user create new Inventory Item
      | Inventory Code | Description             | Base UOM | Inventory Class | Inventory Brand |
      | SS-VALVE       | Valve                   | piece    | WA              | SS              |
      | VC-VALVE       | Valve                   | piece    | WA              | VC              |
      | SS-FITTING     | Fitting                 | piece    | WA              | SS              |
      | HP-FITTING     | Fitting                 | piece    | WA              | HP              |
      | PM-FITTING     | Fitting                 | piece    | WA              | PM              |
      | SS-PIPE        | Pipe                    | piece    | WA              | SS              |
      | VC-PIPE        | Pipe                    | piece    | WA              | VC              |
      | HP-PIPE        | Pipe                    | piece    | WA              | HP              |
      | PM-PIPE        | Pipe                    | piece    | WA              | PM              |
      | TL-LP          | Lift Panel              | piece    | WA              | TL              |
      | TL-ASD         | Automatic Sliding Doors | piece    | WA              | Tl              |
      | SC-ASD         | Automatic Sliding Doors | piece    | WA              | SC              |
      | MR-ASD         | Automatic Sliding Doors | piece    | WA              | MR              |
      | SC-SD          | Security Door           | piece    | WA              | SC              |
      | MR-SD          | Security Door           | piece    | WA              | MR              |
      | TL-FRS         | Fire Roller Shutter     | piece    | WA              | TL              |
      | SC-FRS         | Fire Roller Shutter     | piece    | WA              | SC              |
      | MR-FRS         | Fire Roller Shutter     | piece    | WA              | MR              |

    And user create Service
      | Service Code | Description | Expense GLAN |
      | An Service   |             | 86130        |
    And user create Policy Type
      | Policy Type Code | Description |
      | AN POLICY TYPE   |             |
    And user create Cost Item Group
      | Cost Item Group Code | Description            |
      | HRS                  | Hose Reel System       |
      | FPS                  | Fire Protection System |

    And user create Drawing Object
      | Drawing Object Code     | Description             | Cost Item Group | Brand | Inventory  | Date From  | Date To    | Qty | UOM   |
      | VALVE                   | Valve                   | HRS             | SS    | SS-VALVE   |            |            |     |       |
      |                         |                         |                 | VC    | VC-VALVE   |            |            |     |       |
      |                         |                         |                 |       |            | 02/08/2016 | 02/09/2016 | 12  | PIECE |
      |                         |                         |                 |       |            | 03/09/2016 | 30/11/2016 | 6   | BOX   |
      | FITTING                 | Fitting                 | HRS             | SS    | SS-FITTING |            |            |     |       |
      |                         |                         |                 | HP    | HP-FITTING |            |            |     |       |
      |                         |                         |                 | PM    | PM-FITTING |            |            |     |       |
      | PIPE                    | Pipe                    | HRS             | SS    | SS-PIPE    |            |            |     |       |
      |                         |                         |                 | VC    | VC-PIPE    |            |            |     |       |
      |                         |                         |                 | HP    | HP-PIPE    |            |            |     |       |
      |                         |                         |                 | PM    | PM-PIPE    |            |            |     |       |
      | LIFT PANEL              | Lift Panel              | HRS             | TL    | TL-LP      |            |            |     |       |
      | AUTOMATIC SLIDING DOORS | Automatic Sliding Doors | FPS             | TL    | TL-ASD     |            |            |     |       |
      |                         |                         |                 | SC    | SC-ASD     |            |            |     |       |
      |                         |                         |                 | MR    | MR-ASD     |            |            |     |       |
      | SECURITY DOOR           | Security Door           | FPS             | SC    | SC-SD      |            |            |     |       |
      |                         |                         |                 | MR    | MR-SD      |            |            |     |       |
      | FIRE ROLLER SHUTTER     | Fire Roller Shutter     | FPS             | TL    | TL-FRS     |            |            |     |       |
      |                         |                         |                 | SC    | SC-FRS     |            |            |     |       |
      |                         |                         |                 | MR    | MR-FRS     |            |            |     |       |

    And user maintain Supplier Inventory Price List
      | Supplier | Currency | Effective Date From | Effective Date To | Inventory Code | Unit Price | Price By Quantity Range | Qty From | Qty To (<) |
      | BigC     | USD      | 02/08/16            | 30/09/2016        | SS-Valve       | 78         |                         |          |            |
      |          |          |                     |                   | VC-Valve       | 85         |                         |          |            |
      |          |          |                     |                   | TL-LP          | 100        |                         |          |            |
      |          |          |                     |                   | TL-ASD         | 350        |                         |          |            |
      | Metro    | USD      | 02/08/16            | 30/09/2016        | SS-Fitting     | 31         |                         |          |            |
      |          |          |                     |                   | SS-Pipe        | 11         |                         |          |            |
      |          |          |                     |                   | PM-Pipe        | 9          |                         |          |            |
      |          |          |                     |                   | TL-LP          | 120        |                         |          |            |
      |          |          |                     |                   | TL-FRS         | 600        |                         |          |            |
      |          |          |                     |                   | MR-ASD         | 335        |                         |          |            |
      |          |          | 01/10/16            | 25/10/2016        | PM-Pipe        | 8          |                         |          |            |
      |          |          |                     |                   | SS-Fitting     | 25         |                         |          |            |
      | Lotte    | USD      | 02/08/16            |                   | SS-Valve       | 90         |                         |          |            |
      |          |          |                     |                   | HP-Fitting     | 27         |                         |          |            |
      |          |          |                     |                   | SS-Pipe        | 11         |                         |          |            |
      |          |          |                     |                   | PM-Pipe        | 9          |                         |          |            |
      |          |          |                     |                   | MR-SD          | 512        |                         |          |            |
      | CoopMart | USD      | 02/08/16            | 30/09/2016        | PM-Fitting     | 41         |                         |          |            |
      |          |          |                     |                   | SC-ASD         | 320        |                         |          |            |
      | CoopMart | VND      | 02/08/16            | 30/09/2016        | PM-Fitting     | 861000     |                         |          |            |
      | Adayroi  | USD      | 02/08/16            | 30/09/2016        | PM-Fitting     | 40         | 1                       | 0        | 15         |
      |          |          |                     |                   |                | 35         |                         | 15       | 80         |
      |          |          |                     |                   | MR-ASD         | 330        |                         |          |            |
      |          |          |                     |                   | MR-SD          | 500        |                         |          |            |
      |          |          |                     |                   | MR-FRS         | 678        |                         |          |            |
    And user is tagged in Processing Numbering
      | Module Code | Transaction Type Code | Numbering Scheme Code | User ID    | Length of Code | Prefix |
      | PJ          | SQ                    | ANQ                   | U000000419 | 10             | ANQ    |
      | PJ          | EST                   | ANEST                 | U000000419 | 10             | ANEST  |



    And user add Approving Officer
      | Module Code Desc | Transaction Type Desc | Approving Method             | Employee Code | Approval Home Amount Limit (Per Voucher) |
      | Project Costing  | Quotation             | By Amount (1 Level by Value) | IAN1          | 100000000                                |
      | Project Costing  | Order/Estimation      | By Amount (1 Level by Value) | IAN1          | 100000000                                |