@integration @jacob
Feature: Cylinder
  """
  Global Setup >> Cylinders >> Cylinder
  1. Cylinder:
  
  Global Setup >> Cylinders >> Cylinder Brand
  1.1 Cylinder Brand Code (1)
  
  Global Setup >> Cylinders >> Cylinder Capacity
  1.2 Cylinder Capacity Code (2)
  Global Setup >> Cylinders >> Cylinder Interchangeable Group
  1.2.1 Interchangeable Group Code (1)
  
  Global Setup >> Inventory >> Inventory
  1.3 Inventory Code (Fill - Empty)
  Global Setup >> Inventory >> Unit of Measurement
  1.3.1 Base UOM (1)
  Global Setup >> Inventory >> Classification >> Class
  1.3.2 Inventory Class (2)
  Global Setup >> Financial >> Accounting >> Global Chart of Acc
  1.3.2.1 Chart Of Acc (1)
  """

  Background: 
    Given user login the taskhub system

  Scenario Outline: Create Cylinder
    Given user navigates to "Global Setup>Financial>Accounting>Chart Of Acc" screen
    And user create chart of account as "<KEY>"
      | KEY | GL Account Code | Description   | Account Type       | Status | For Sub Ledger Account |
      | 001 | COB01           | Cylinder test | Balance Sheet Item | Active | No                     |
    And user navigates to "Global Setup>Inventory>Unit of Measurement" screen
    And user create unit of measurement as "<KEY>"
      | KEY | UOM Code | Description     | Type               |
      | 001 | COB01    | Fill Cylinder   | Inventory, Service |
      | 001 | COB02    | Empty  Cylinder | Inventory, Service |
    And user navigates to "Global Setup>Cylinders>Cylinder Brand" screen
    And user create cylinder brand as "<KEY>"
      | KEY | Cylinder Brand Code | Description   |
      | 001 | COB01               | Cylinder test |
    And user navigates to "Global Setup>Cylinders>Cylinder Interchangeable Group" screen
    And user create cylinder interchangeable group as "<KEY>"
      | KEY | Interchangeable Group Code | Description   | Enable Deposit / Refund / Purchase | Unit Deposit Amount | Unit Refund Amount | Unit Purchase Amount |
      | 001 | COB01                      | Cylinder test | Yes                                | 100.0000            | 25.0000            | 75.0000              |
    And user navigates to "Global Setup>Cylinders>Cylinder Capacity" screen
    And user create cylinder Capacity as "<KEY>"
      | KEY | Cylinder Capacity Code | Description   | Cylinder Capacity | Interchangeable Group Code |
      | 001 | COB01                  | Cylinder test | 20.00             | COB01                      |
    And user navigates to "Global Setup>Inventory>Classification>Class" screen
    And user create a new inventory class as "<KEY>"
      | KEY | Inventory Class Code | Description   | Costing Method   | Inventory GLAN |
      | 001 | COB01                | Cylinder test | Weighted Average | COB01          |
    And user navigates to "Global Setup>Inventory>Inventory" screen
    And user creates inventory that is used for Cylinder as "<KEY>"
      | KEY | Inventory Code | Description    | Base UOM | Inventory Class |
      | 001 | COB01          | Cylinder Fill  | COB01    | COB01           |
      | 001 | COB02          | Cylinder Empty | COB02    | COB01           |
    When user navigates to "Global Setup>Cylinders>Cylinder" screen
    And user create cylinder as "<KEY>"
      | KEY | Cylinder Code | Description | Cylinder Brand Code | Cylinder Capacity Code | Filled Inventory Code | Empty Inventory Code | Serial No. Tracking | For Production / Sales | Production Category No | Order Sequence |
      | 001 | COB01         | Cylinder    | COB01               | COB01                  | COB01                 | COB02                | Yes                 | Yes                    | 124                    | 4412           |
    # Delete
    When user delete cylinder as "<KEY>"
      | KEY | Cylinder Code |
      | 001 | COB01         |
    Examples: 
      | KEY |
      | 001 |
