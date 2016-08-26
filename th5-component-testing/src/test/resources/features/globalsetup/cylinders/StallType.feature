@integration @jacob
Feature: Stall Type

  Scenario Outline: Create Stall Type
    Given user login the taskhub system
    And user navigates to "Global Setup>Cylinders>Stall Type" screen
    When user create stall type as "<KEY>"
      | KEY | Stall Type Code | Description |
      | 001 | AUTO            | Daily Test  |
    When user delete stall type as "<KEY>"
      | KEY |
      | 001 |

    Examples: 
      | KEY |
      | 001 |
