@TH6_GLOBAL_EMPLOYEE_JOB_TYPE @GlobalEmployeeJobType_TH6 @MT @integration @LilyHoang
Feature: Employee Job Type Management
  I want to manage Employee Job Type in my company
  The function includes Add new, update, delete  Employee Job Type

  Background: 
    Given user login the taskhub system
    And user navigates to "Master Setup>Employee & Approving Officer>Employee Job Type>[2]" screen

  Scenario Outline: Employee Job Type intergration Test
    #Add New
    When I want to create a Employee Job Type
    And The Employee Job Type which has code as "<KEY>" has information as the following
      | Key | Employee Job Type Code | Description             | Update Project Cost based on Markup Rate | Company Name List |
      |  01 | LILY_EJOBTYPE_7        | Auto-Only use by Lily 1 | Yes                                      | AUTO1             |
    And The Employee Job Type should be updated as the above information
    Then The Employee Job Type should be displayed on Employee Job Type List with the "<KEY>"
      | Key | Employee Job Type Code | Description             | Created By         | Created Date | Last Updated By    | Last Updated Date |
      |  01 | LILY_EJOBTYPE_7        | Auto-Only use by Lily 1 | Lily Synergix Team |              | Lily Synergix Team |                   |
    #Update
    When I want to update a Employee Job Type having "<KEY>"
      | Key | Employee Job Type Code |
      |  01 | LILY_EJOBTYPE_7        |
    And The Employee Job Type which has code as "<KEY>" has information as the following
      | Key | Employee Job Type Code | Description             | Update Project Cost based on Markup Rate | Company Name List |
      |  01 | LILY_EJOBTYPE_7        | Auto-Only use by Lily 2 |                                          | AUTO1             |
    And The Employee Job Type should be updated as the above information
    Then The Employee Job Type should be displayed on Employee Job Type List with the "<KEY>"
      | Key | Employee Job Type Code | Description             | Created By         | Created Date | Last Updated By    | Last Updated Date |
      |  01 | LILY_EJOBTYPE_7        | Auto-Only use by Lily 2 | Lily Synergix Team |              | Lily Synergix Team |                   |
    #Delete
    When I want to delete a Employee Job Type having "<KEY>"
      | Key | Employee Job Type Code |
      |  01 | LILY_EJOBTYPE_7        |
    And I confirm and delete this Employee Job Type
    Then I shouldnt see it any more with the "<KEY>"
      | Key | Employee Job Type Code |
      |  01 | LILY_EJOBTYPE_7        |

    Examples: 
      | KEY |
      |  01 |
