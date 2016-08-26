@TH6_GLB_SUB_COMPANY @GlobalSubCompany @MT @integration @LilyHoang
Feature: Sub Company Management
  I want to manage Sub Company in my company
  The function includes Add new, update, delete  Sub Company
# Create by: Lily Hoang
  Background: 
    Given user login the taskhub system
    And user navigates to "Master Setup>Employee & Approving Officer>Sub Company" screen

  Scenario Outline: Sub Company Intergration Test
		When subcompany   
    #Add New
    When I want to create a new Sub Company
    And The Sub Company has new information as the following with Key as "<KEY>"
      | Key | Sub Company Code | Sub Company Name    | Company Name List |
      |  01 | LILY_SUBCOM_1    | LILY SUB COMPANY 01 | AUTO1             |
    And The Sub Company should be updated as the above information
    Then The Sub Company should be displayed on Sub Company List as the followng with Key as "<KEY>"
      | Key | Sub Company Code | Sub Company Name    | Created By         | Created Date | Last Updated By    | Last Updated Date |
      |  01 | LILY_SUBCOM_1    | LILY SUB COMPANY 01 | Lily Synergix Team |              | Lily Synergix Team |                   |
    #Update
    When I want to update a Sub Company with Key as "<KEY>"
      | Key | Sub Company Code |
      |  01 | LILY_SUBCOM_1    |      
    And Before update, the Sub Company has information as the following with Key as "<KEY>"
      | Key | Sub Company Code | Sub Company Name    | Company Name List |
      |  01 | LILY_SUBCOM_1    | LILY SUB COMPANY 01 | AUTO1             |
    And The Sub Company has new information as the following with Key as "<KEY>"
      | Key | Sub Company Code | Sub Company Name            | Company Name List |
      |  01 | LILY_SUBCOM_1    | LILY SUB COMPANY 01 CHANGED | AUTO2             |
    And The Sub Company should be updated as the above information
    Then The Sub Company should be displayed on Sub Company List as the followng with Key as "<KEY>"
     | Key | Sub Company Code | Sub Company Name    | Created By         | Created Date | Last Updated By    | Last Updated Date |
      |  01 | LILY_SUBCOM_1    | LILY SUB COMPANY 01 CHANGED | Lily Synergix Team |              | Lily Synergix Team |                   |
    #Delete
    When I want to delete a Sub Company as follow with Key as "<KEY>"
      | Key | Sub Company Code |
      |  01 | LILY_SUBCOM_1    |
    And Before delete,I want to make sure I will delete Sub Company
    Then I shouldnt see Sub Company any more with Key as "<KEY>" 
      | Key | Sub Company Code |
      |  01 | LILY_SUBCOM_1    |

    Examples: 
      | KEY |
      |  01 |
