@integration @jacob
Feature: Cylinder Brand

  Scenario Outline: Create Cylinder Brand
    Given user login the taskhub system
    And user navigates to "Global Setup>Cylinders>Cylinder Brand" screen
    When user create cylinder brand as "<KEY>"
      | KEY | Cylinder Brand Code | Description   |
      | 001 | AUTO                | Daily Testing |
    When user delete cylinder brand as "<KEY>"
      | KEY | 
      | 001 | 

    Examples: 
      | KEY |
      | 001 |
