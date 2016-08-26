@TH6_GLB_PRODUCT_TYPE_OFFICE @GlobalProductType @MT @integration @LilyHoang
Feature: Product Type Management
  I want to manage Product Type in my company
  The function includes Add new, update, delete  Product Type

  # Create by: Lily Hoang
  Background: 
    Given user login the taskhub system
    And user navigates to "Master Setup>Servicing>Product Type" screen

  Scenario Outline: Product Type Intergration Test
    # When ProductType  
    #Add New
    When I want to create a new Product Type
    And The Product Type has new information as the following with Key as "<KEY>"
      | Key | Product Type Code   | Description          | Company Name List | Status | Local Status |
      |  01 | LILY_PRODUCT_TYPE_1 | LILY Product Type 01 | AUTO1,AUTO2       | Draft  |              |
    And The Product Type should be updated as the above information
    Then The Product Type should be displayed on Product Type List as the followng with Key as "<KEY>"
      | Key | Product Type Code   | Description          | Company Name List | Status | Local Status |
      |  01 | LILY_PRODUCT_TYPE_1 | LILY Product Type 01 | AUTO1,AUTO2       | Active |              |
    #Update
    When I want to update a Product Type with Key as "<KEY>"
      | Key | Product Type Code   |
      |  01 | LILY_PRODUCT_TYPE_1 |
    And I search Product Type with Key as "<KEY>"
      | Key | Product Type Code   |
      |  01 | LILY_PRODUCT_TYPE_1 |
    And Before update, the Product Type has information as the following with Key as "<KEY>"
      | Key | Product Type Code   | Description          | Company Name List | Status    | Local Status |
      |  01 | LILY_PRODUCT_TYPE_1 | LILY Product Type 01 | AUTO1,AUTO2       | Active |              |
    And The Product Type has new information as the following with Key as "<KEY>"
      | Key | Product Type Code   | Description                  | Company Name List | Status    | Local Status |
      |  01 | LILY_PRODUCT_TYPE_1 | LILY Product Type 01 CHANGED | AUTO1,AUTO2       | Suspended |              |
    And The Product Type should be updated as the above information
    Then The Product Type should be displayed on Product Type List as the followng with Key as "<KEY>"
      | Key | Product Type Code   | Description                  | Company Name List | Status    | Local Status |
      |  01 | LILY_PRODUCT_TYPE_1 | LILY Product Type 01 CHANGED | AUTO1,AUTO2       | Suspended |              |
    #Update2
    When I want to update a Product Type with Key as "<KEY>"
      | Key | Product Type Code   |
      |  01 | LILY_PRODUCT_TYPE_1 |
    And I search Product Type with Key as "<KEY>"
      | Key | Product Type Code   |
      |  01 | LILY_PRODUCT_TYPE_1 |
    And Before update, the Product Type has information as the following with Key as "<KEY>"
      | Key | Product Type Code   | Description          | Company Name List | Status    | Local Status |
      |  01 | LILY_PRODUCT_TYPE_1 | LILY Product Type 01 | AUTO1,AUTO2       | Suspended |              |
    And The Product Type has new information as the following with Key as "<KEY>"
      | Key | Product Type Code   | Description                  | Company Name List | Status    | Local Status |
      |  01 | LILY_PRODUCT_TYPE_1 | LILY Product Type 01 CHANGED | AUTO1,AUTO2       | Local Info |    Active          |
    And The Product Type should be updated as the above information
    Then The Product Type should be displayed on Product Type List as the followng with Key as "<KEY>"
      | Key | Product Type Code   | Description                  | Company Name List | Status    | Local Status |
      |  01 | LILY_PRODUCT_TYPE_1 | LILY Product Type 01 CHANGED | AUTO1,AUTO2       | Local Info |      Active        |
    #Delete
    When I want to delete a Product Type as follow with Key as "<KEY>"
      | Key | Product Type Code   |
      |  01 | LILY_PRODUCT_TYPE_1 |
    And I search Product Type with Key as "<KEY>"
      | Key | Product Type Code   |
      |  01 | LILY_PRODUCT_TYPE_1 |
    And Before delete,I want to make sure I will delete Product Type
    Then I shouldnt see Product Type any more with Key as "<KEY>"
      | Key | Product Type Code   |
      |  01 | LILY_PRODUCT_TYPE_1 |

    Examples: 
      | KEY |
      |  01 |
