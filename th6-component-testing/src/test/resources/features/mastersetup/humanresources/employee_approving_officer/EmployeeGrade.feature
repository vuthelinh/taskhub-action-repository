@employeegrade @integration
Feature: Employee Grade

  Scenario Outline: I want to create employee grade in my company to manage their commission entitlement    
    Given user is currently logged in to TaskHub System
    And user navigates to "Master Setup>Employee & Approving Officer>Employee Grade>[2]" screen
    #Add new
    When user want to create a new Employee Grade with Key as "<KEY>"
      | KEY | Grade Code | Description              |
      | 001 | RICK_GC001 | Rick Test Grade Code 001 |
    Then the Employee Grade table should be displayed as the following with Key as "<KEY>"
      | KEY | Grade Code | Description              | Created By         | Created Date | Last Updated By    | Last Updated Date |
      | 001 | RICK_GC001 | Rick Test Grade Code 001 | Rick Synergix Team |              | Rick Synergix Team |                   |
    #Update
    When user want to update an Employee Grade with Key as "<KEY>"
      | KEY | Grade Code | Description                      |
      | 001 | RICK_GC001 | Rick Test Grade Code 001 Changed |
    Then the Employee Grade table should be updated as the following with Key as "<KEY>"
      | KEY | Grade Code | Description                      | Created By         | Created Date | Last Updated By    | Last Updated Date |
      | 001 | RICK_GC001 | Rick Test Grade Code 001 Changed | Rick Synergix Team |              | Rick Synergix Team |                   |
    #Delete
    When user want to delete an Employee Grade with Key as "<KEY>"
      | KEY | Grade Code | Description                      |
      | 001 | RICK_GC001 | Rick Test Grade Code 001 Changed |
    Then user should not see an Employee Grade with Key as "<KEY>"
      | KEY | Grade Code | Description                      |
      | 001 | RICK_GC001 | Rick Test Grade Code 001 Changed |

    Examples: 
      | KEY |
      | 001 |
