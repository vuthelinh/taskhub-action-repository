@integration @Steve
Feature: Create project categories

  Background: 
    Given user login the taskhub system

  Scenario Outline: Create project categories
    And user navigates to "Global Setup>Project>Project Category" screen
    And user creates project category as "<KEY>"
      | KEY | Project Category Code | Description                  | Status |
      | 1   | PJCATEGORY            | Project Category For Testing | Active |
    When user searches for the project category with "<KEY>"
      | KEY | Project Category Code |
      | 1   | PJCATEGORY            |
    Then user should see the project category with "<KEY>" having correct information
    When user deletes the project category with "<KEY>"
      | KEY | Project Category Code |
      | 1   | PJCATEGORY            |
    Then user should not see the project category with "<KEY>"
    
    Examples: 
      | KEY |
      | 1   |
