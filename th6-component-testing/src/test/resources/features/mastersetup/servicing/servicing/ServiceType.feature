@TH6_GLB_Service_TYPE_OFFICE @GlobalServiceType @MT @integration @LilyHoang
Feature: Service Type Management
  I want to manage Service Type in my company
  The function includes Add new, update, delete  Service Type

  # Create by: Lily Hoang
  Background: 
    Given user login the taskhub system
    And user navigates to "Master Setup>Servicing>Service Type>[2]" screen

  Scenario Outline: Service Type Intergration Test
    #Add New
    When I want to create a new Service Type
    And The Service Type has new information as the following with Key as "<KEY>"
      | Key | Service Type Code   | Description          | Company Name List | Status | Local Status |
      |  01 | LILY_SERVICE_TYPE_1 | LILY Service Type 01 | AUTO1,AUTO2       | Draft  |              |
    And The Service Type should be updated as the above information
    Then The Service Type should be displayed on Service Type List as the followng with Key as "<KEY>"
      | Key | Service Type Code   | Description          | Company Name List | Status | Local Status |
      |  01 | LILY_SERVICE_TYPE_1 | LILY Service Type 01 | AUTO1,AUTO2       | Active |              |
    #Update
    When I want to update a Service Type with Key as "<KEY>"
      | Key | Service Type Code   |
      |  01 | LILY_SERVICE_TYPE_1 |
    And I search Service Type with Key as "<KEY>"
      | Key | Service Type Code   |
      |  01 | LILY_SERVICE_TYPE_1 |
    And Before update, the Service Type has information as the following with Key as "<KEY>"
      | Key | Service Type Code   | Description          | Company Name List | Status | Local Status |
      |  01 | LILY_SERVICE_TYPE_1 | LILY Service Type 01 | AUTO1,AUTO2       | Active |              |
    And The Service Type has new information as the following with Key as "<KEY>"
      | Key | Service Type Code   | Description                  | Company Name List | Status    | Local Status |
      |  01 | LILY_SERVICE_TYPE_1 | LILY Service Type 01 CHANGED | AUTO1,AUTO2       | Suspended |              |
    And The Service Type should be updated as the above information
    Then The Service Type should be displayed on Service Type List as the followng with Key as "<KEY>"
      | Key | Service Type Code   | Description                  | Company Name List | Status    | Local Status |
      |  01 | LILY_SERVICE_TYPE_1 | LILY Service Type 01 CHANGED | AUTO1,AUTO2       | Suspended |              |
    #Update2
    When I want to update a Service Type with Key as "<KEY>"
      | Key | Service Type Code   |
      |  01 | LILY_SERVICE_TYPE_1 |
    And I search Service Type with Key as "<KEY>"
      | Key | Service Type Code   |
      |  01 | LILY_SERVICE_TYPE_1 |
    And Before update, the Service Type has information as the following with Key as "<KEY>"
      | Key | Service Type Code   | Description          | Company Name List | Status    | Local Status |
      |  01 | LILY_SERVICE_TYPE_1 | LILY Service Type 01 | AUTO1,AUTO2       | Suspended |              |
    And The Service Type has new information as the following with Key as "<KEY>"
      | Key | Service Type Code   | Description                  | Company Name List | Status     | Local Status |
      |  01 | LILY_SERVICE_TYPE_1 | LILY Service Type 01 CHANGED | AUTO1,AUTO2       | Local Info | Active       |
    And The Service Type should be updated as the above information
    Then The Service Type should be displayed on Service Type List as the followng with Key as "<KEY>"
      | Key | Service Type Code   | Description                  | Company Name List | Status     | Local Status |
      |  01 | LILY_SERVICE_TYPE_1 | LILY Service Type 01 CHANGED | AUTO1,AUTO2       | Local Info | Active       |
    #Delete
    When I want to delete a Service Type as follow with Key as "<KEY>"
      | Key | Service Type Code   |
      |  01 | LILY_SERVICE_TYPE_1 |
    And I search Service Type with Key as "<KEY>"
      | Key | Service Type Code   |
      |  01 | LILY_SERVICE_TYPE_1 |
    And Before delete,I want to make sure I will delete Service Type
    Then I shouldnt see Service Type any more with Key as "<KEY>"
      | Key | Service Type Code   |
      |  01 | LILY_SERVICE_TYPE_1 |

    Examples: 
      | KEY |
      |  01 |
