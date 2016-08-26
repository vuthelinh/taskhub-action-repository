@TH6_COST_ITEM_GROUP @CostItemGroup @MT @integration @LilyHoang
Feature: Cost Item Group Management
  I want to manage Cost Item Group in my company
  The function includes Add new, update, delete  Cost Item Group

  # Create by: Lily Hoang
  Background: 
    Given user login the taskhub system
    And user navigates to "Master Setup>Project>Cost Item Group>[2]" screen

  Scenario Outline: Cost Item Group Intergration Test
   #When Test 
   
   
    #Add New
    When I want to create a new Cost Item Group
    And The Cost Item Group has new information as the following with Key as "<KEY>"
      | Key | Cost Item Group Code | Description             | Company Name List | Status | Local Status |
      |  01 | LILY_COST_1          | LILY Cost Item Group 01 | AUTO1,AUTO2       | Draft  |              |
    And The Cost Item Group should be updated as the above information
    Then The Cost Item Group should be displayed on Cost Item Group List as the followng with Key as "<KEY>"
      | Key | Cost Item Group Code | Description             | Company Name List | Status | Local Status |
      |  01 | LILY_COST_1          | LILY Cost Item Group 01 | AUTO1,AUTO2       | Active |              |
    #Update
    When I want to update a Cost Item Group with Key as "<KEY>"
      | Key | Cost Item Group Code |
      |  01 | LILY_COST_1          |
    And I search Cost Item Group with Key as "<KEY>"
      | Key | Cost Item Group Code |
      |  01 | LILY_COST_1          |
    And Before update, the Cost Item Group has information as the following with Key as "<KEY>"
      | Key | Cost Item Group Code | Description             | Company Name List | Status | Local Status |
      |  01 | LILY_COST_1          | LILY Cost Item Group 01 | AUTO1,AUTO2       | Active |              |
    And The Cost Item Group has new information as the following with Key as "<KEY>"
      | Key | Cost Item Group Code | Description                     | Company Name List | Status    | Local Status |
      |  01 | LILY_COST_1          | LILY Cost Item Group 01 CHANGED | AUTO1,AUTO2       | Suspended |              |
    And The Cost Item Group should be updated as the above information
    Then The Cost Item Group should be displayed on Cost Item Group List as the followng with Key as "<KEY>"
      | Key | Cost Item Group Code | Description                     | Company Name List | Status    | Local Status |
      |  01 | LILY_COST_1          | LILY Cost Item Group 01 CHANGED | AUTO1,AUTO2       | Suspended |              |
    #Update2
    When I want to update a Cost Item Group with Key as "<KEY>"
      | Key | Cost Item Group Code |
      |  01 | LILY_COST_1          |
    And I search Cost Item Group with Key as "<KEY>"
      | Key | Cost Item Group Code |
      |  01 | LILY_COST_1          |
    And Before update, the Cost Item Group has information as the following with Key as "<KEY>"
      | Key | Cost Item Group Code | Description             | Company Name List | Status    | Local Status |
      |  01 | LILY_COST_1          | LILY Cost Item Group 01 | AUTO1,AUTO2       | Suspended |              |
    And The Cost Item Group has new information as the following with Key as "<KEY>"
      | Key | Cost Item Group Code | Description                     | Company Name List | Status     | Local Status |
      |  01 | LILY_COST_1          | LILY Cost Item Group 01 CHANGED | AUTO1,AUTO2       | Local Info | Active       |
    And The Cost Item Group should be updated as the above information
    Then The Cost Item Group should be displayed on Cost Item Group List as the followng with Key as "<KEY>"
      | Key | Cost Item Group Code | Description                     | Company Name List | Status     | Local Status |
      |  01 | LILY_COST_1          | LILY Cost Item Group 01 CHANGED | AUTO1,AUTO2       | Local Info | Active       |
    #Delete
    When I want to delete a Cost Item Group as follow with Key as "<KEY>"
      | Key | Cost Item Group Code | 
      |  01 | LILY_COST_1          |
    And I search Cost Item Group with Key as "<KEY>" 
      | Key | Cost Item Group Code |
      |  01 | LILY_COST_1          |
    And Before delete,I want to make sure I will delete Cost Item Group
    Then I shouldnt see Cost Item Group any more with Key as "<KEY>"
      | Key | Cost Item Group Code |
      |  01 | LILY_COST_1          |

    Examples: 
      | KEY |
      |  01 |
