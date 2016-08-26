@TH6_LIST_PRICE_DISCOUNT @ListPriceDiscountMaintenance @MT @integration @LilyHoang
Feature: List Price Discount
  I want to manage List Price Discount in my company
  The function includes Add new, update, delete  Sub Company

  Background: 
    Given user login the taskhub system
   # Given user navigates to "Master Setup>Customer>Customer Category" screen
  #   And Customer Category is created as in "LILY_MasterData.xls"
  #   Given user navigates to "Master Setup>Inventory>Brand" screen
  #   And Inventory Brand is created as in "LILY_MasterData.xls"
  #   Given user navigates to "Master Setup>Inventory>Inventory" screen
  #   And Inventory Code is created as in "LILY_MasterData.xls"
  #   And user navigates to "Master Setup>Customer>Industry" screen
 #    When Customer Industry is created as in "LILY_MasterData.xls"
    And user navigates to "Master Setup>Price & Cost>List Price Discount" screen

  Scenario Outline: List Price Discount Intergration Test
    # Add New
    When I want to create a new List Price Discount by Customer Category as the following with Key as "<KEY>"
      | Key | Customer Category | Description                         |
      |  01 | V001              | VINCENT AUTO Customer Category Code |
    And The Discount List is listed as the following as the as "<KEY>"
      | Key | Frame Name        | Effective Date From | Effective Date To  | Discount |
      |  01 | Customer Category | Max+2 or today      | (Max+2 or today)+1 |     1.00 |
      |  01 | Customer Category | Max+2 or today      | (Max+2 or today)+1 |     2.00 |
      |  01 | Customer Category | Max+2 or today      | (Max+2 or today)+1 |     3.00 |
    And I want to create a new List Price Discount by Inventory Brand and Customer Category as the following with Key as "<KEY>"
      | Key | Inventory Brand | Customer Category | Description           |
      |  01 | LILY_B15        | V001              | Auto-Only use by Lily |
    And The Discount List is listed as the following as the as "<KEY>"
      | Key | Frame Name                            | Effective Date From | Effective Date To  | Discount |
      |  01 | Inventory Brand and Customer Category | Max+2 or today      | (Max+2 or today)+1 |    10.00 |
      |  01 | Inventory Brand and Customer Category | Max+2 or today      | (Max+2 or today)+1 |    11.00 |
      |  01 | Inventory Brand and Customer Category | Max+2 or today      | (Max+2 or today)+1 |    12.00 |
    And I want to create a new List Price Discount by Inventory and Customer Category as the following with Key as "<KEY>"
      | Key | Inventory Code | Customer Category | Description  |
      |  01 | TR001          | V001              | Trang auto 1 |
    And The Discount List is listed as the following as the as "<KEY>"
      | Key | Frame Name                      | Effective Date From | Effective Date To  | Discount |
      |  01 | Inventory and Customer Category | Max+2 or today      | (Max+2 or today)+1 |    10.00 |
      |  01 | Inventory and Customer Category | Max+2 or today      | (Max+2 or today)+1 |    11.00 |
      |  01 | Inventory and Customer Category | Max+2 or today      | (Max+2 or today)+1 |    12.00 |
    And I want to create a new List Price Discount by Inventory and Customer Industry  as the following with Key as "<KEY>"
      | Key | Inventory Code | Description  | Customer Industry |
      |  01 | TR001          | Trang auto 1 | LILY_IND1         |
    And The Discount List is listed as the following as the as "<KEY>"
      | Key | Frame Name                      | Effective Date From | Effective Date To  | Discount |
      |  01 | Inventory and Customer Industry | Max+2 or today      | (Max+2 or today)+1 |    10.00 |
      |  01 | Inventory and Customer Industry | Max+2 or today      | (Max+2 or today)+1 |    11.00 |
      |  01 | Inventory and Customer Industry | Max+2 or today      | (Max+2 or today)+1 |    12.00 |
    # Delete
    When I want to delete value in Discount table with the key as "<KEY>"
      | Key | Frame Name                            | Description                         | Deleted Value |
      |  01 | Customer Category                     | VINCENT AUTO Customer Category Code | V001          |
      |  01 | Inventory Brand and Customer Category | Auto-Only use by Lily               | LILY_B15      |
      |  01 | Inventory and Customer Category       | Trang auto 1                        | TR001         |
      |  01 | Inventory and Customer Industry       | Trang auto 1                        | TR001         |

    Examples: 
      | KEY |
      |  01 |
