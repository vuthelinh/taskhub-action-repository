@phoebe_pre_data_3
Feature: Create and maintain unit of measurement

  Scenario Outline: Create Unit of Measurement
    Given user login the taskhub system
    And user navigates to "Global Setup>Inventory>Unit of Measurement" screen
    When user create unit of measurement as "<KEY UOM>"
      | KEY UOM | UOM Code | Description | Type               | Company |
      | 1       | PCS      | Pieces      | Inventory, Service |         |
      | 1       | KG       | Kilogram    | Inventory          |         |

    Examples: 
      | KEY UOM |
      | 1       |
