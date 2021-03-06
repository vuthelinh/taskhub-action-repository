Feature: Unit of Measurement

  Scenario Outline: Create Unit of Measurement with feature
    Given user login the TH6 system
    And user navigates to "Master Setup>Inventory>Unit of Measurement" screen
    When user create unit of measurement as "<KEY>"
      | KEY | UOM Code | Description               | Type               | Company      |
      | 001 | vauto    | for Synergix Testing ONLY | Inventory, Service | AUTO4, AUTO1 |
      | 001 | vbox     | for Synergix Testing ONLY | Inventory, Service | AUTO4, AUTO1 |
      | 001 | vkm      | for Synergix Testing ONLY | Inventory, Service | AUTO4, AUTO1 |
      | 001 | vpiece   | for Synergix Testing ONLY | Inventory, Service | AUTO4, AUTO1 |

    Examples: 
      | KEY |
      | 001 |

  Scenario: Delete Unit of Measurement
    Given user login the TH6 system
    When user navigates to "Master Setup>Inventory>Unit of Measurement" screen
    And user delete unit of measurement
      | KEY UOM | UOM Code |
      | 001     | vauto    |
      | 001     | vbox     |
      | 001     | vkm      |
      | 001     | vpiece   |

  Scenario: Create Unit of Measurement with excel file
    Given user login the TH6 system
    When user navigates to "Master Setup>Inventory>Unit of Measurement" screen
    And user create new unit of measurement
