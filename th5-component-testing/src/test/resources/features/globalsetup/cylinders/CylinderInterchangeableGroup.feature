@integration @jacob
Feature: Cylinder Interchangeable Group

  Scenario Outline: Create Cylinder Interchangeable Group
    Given user login the taskhub system
    And user navigates to "Global Setup>Cylinders>Cylinder Interchangeable Group" screen
    When user create cylinder interchangeable group as "<KEY>"
      | KEY | Interchangeable Group Code | Description  | Enable Deposit / Refund / Purchase | Unit Deposit Amount | Unit Refund Amount | Unit Purchase Amount |
      | 001 | AUTO                       | Enable = Yes | Yes                                | 1.0000              | 2.0000             | 3.0000               |
    When user delete cylinder interchangeable group as "<KEY>"
      | KEY |
      | 001 |

    Examples: 
      | KEY | Case                                     |
      | 001 | Enable Deposit / Refund / Purchase = Yes |
