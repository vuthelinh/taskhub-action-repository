@integration @jacob
Feature: Create Cylinder Capacity

  Scenario Outline: Create Cylinder Capacity
    Given user login the taskhub system
    And user navigates to "Global Setup>Cylinders>Cylinder Interchangeable Group" screen
    When user create cylinder interchangeable group as "<KEY>"
      | KEY | Interchangeable Group Code | Description           | Enable Deposit / Refund / Purchase |
      | 001 | CCAUTO                     | For Cylinder Capacity | No                                 |
    And user navigates to "Global Setup>Cylinders>Cylinder Capacity" screen
    When user create cylinder Capacity as "<KEY>"
      | KEY | Cylinder Capacity Code | Description | Cylinder Capacity | Interchangeable Group Code |
      | 001 | AUTO                   | Daily Test  | 211.00            | CCAUTO                     |
    When user delete cylinder Capacity as "<KEY>"
      | KEY |
      | 001 |
    And user navigates to "Global Setup>Cylinders>Cylinder Interchangeable Group" screen
    When user delete cylinder interchangeable group as "<KEY>"
      | KEY |
      | 001 |

    Examples: 
      | KEY |
      | 001 |
