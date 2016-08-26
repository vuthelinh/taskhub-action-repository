@TH6_GLB_REGIONAL_OFFICE @GlobalRegionalOffice @MT @integration  @LilyHoang
Feature: Regional Office Management
  I want to manage Regional Office in my company
  The function includes Add new, update, delete  Regional Office
# Create by: Lily Hoang
  Background: 
    Given user login the taskhub system
    And user navigates to "Master Setup>Employee & Approving Officer>Regional Office" screen

  Scenario Outline: Regional Office Intergration Test
   # When test 
    
    #Add New
    When I want to create a new Regional Office 
    And The Regional Office has new information as the following with Key as "<KEY>"
      | Key | Regional Office Code | Regional Office Name    | Company Name List |
      |  01 | LILY_REGIONAL_1    | LILY Regional Office 01 | AUTO1,AUTO2             |
    And The Regional Office should be updated as the above information
    Then The Regional Office should be displayed on Regional Office List as the followng with Key as "<KEY>"
      | Key | Regional Office Code | Regional Office Name    | Created By         | Created Date | Last Updated By    | Last Updated Date |
      |  01 | LILY_REGIONAL_1    | LILY Regional Office 01 | Lily Synergix Team   |     Today         | Lily Synergix Team |                   |
    #Update
    When I want to update a Regional Office with Key as "<KEY>"
      | Key | Regional Office Code |
      |  01 | LILY_REGIONAL_1    |      
    And Before update, the Regional Office has information as the following with Key as "<KEY>"
      | Key | Regional Office Code | Regional Office Name    | Company Name List |
      |  01 | LILY_REGIONAL_1    | LILY Regional Office 01 | AUTO1             |
    And The Regional Office has new information as the following with Key as "<KEY>"
      | Key | Regional Office Code | Regional Office Name            | Company Name List |
      |  01 | LILY_REGIONAL_1    | LILY Regional Office 01 CHANGED | AUTO2             |
    And The Regional Office should be updated as the above information
    Then The Regional Office should be displayed on Regional Office List as the followng with Key as "<KEY>"
     | Key | Regional Office Code | Regional Office Name    | Created By         | Created Date | Last Updated By    | Last Updated Date |
      |  01 | LILY_REGIONAL_1    | LILY Regional Office 01 CHANGED | Lily Synergix Team |              | Lily Synergix Team |                   |
    #Delete
    When I want to delete a Regional Office as follow with Key as "<KEY>"
      | Key | Regional Office Code |
      |  01 | LILY_REGIONAL_1    |
    And Before delete,I want to make sure I will delete Regional Office
    Then I shouldnt see Regional Office any more with Key as "<KEY>" 
      | Key | Regional Office Code |
      |  01 | LILY_REGIONAL_1    |

    Examples: 
      | KEY |
      |  01 |
