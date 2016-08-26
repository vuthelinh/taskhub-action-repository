@inventory_brand @integration @LilyHoang
Feature: Manage Inventory bands
  I want to manage Inventory brand in my company
  The function includes Add new, update, delete and search Inventory Brand

  Background: 
    Given user login the taskhub system
    And user navigates to "Global Setup>Inventory>Classification>Brand" screen

  Scenario Outline: Inventory Brand Function Test
    When I want to create a new Brand
    And Precisely,The "<BRAND CODE>" Brand has general infomation as the following
      | Inventory Brand Code | Description           |
      | LILY_B16             | Auto-Only use by Lily |
    And The "<BRAND CODE>" brand has the infomation of Forecast as the following
      | Inventory Brand Code | Target Month Supply Qty | Target Value |
      | LILY_B16             |                       1 |        12.00 |
    And The "<BRAND CODE>" brand has the infomation of Service Level as the following
      | Inventory Brand Code | Code      | Description | Service Level Value | Z Value | Del |
      | LILY_B16             | SL_CODE01 | SL_Desc 01  |                2.00 |    1.00 | x   |
      | LILY_B16             | SL_CODE02 | SL_Desc 02  |                3.00 |    2.00 | x   |
    And The "<BRAND CODE>" brand has the infomation of EOQ Calculation as the following
      | Inventory Brand Code | Code  | Description | Value | Del |
      | LILY_B16             | EOQ01 | EOQ01       |  1.00 | x   |
      | LILY_B16             | EOQ02 | EOQ02       |  2.00 | x   |
    And The "<BRAND CODE>" brand has the infomation of Supplier as the following
      | Inventory Brand Code | Supplier Code | Min Order Qty | Lead Time Link | Default | Supplier Del | Lead Time Code | Lead Time Description | Lead Time | Lead Time Del |
      | LILY_B16             | ADELA         |         10.00 |              3 | x       |              | LeadTime01     | LeadTime01            |         1 | x             |
      | LILY_B16             | ADELA         |         10.00 |                |         |              | LeadTime02     | LeadTime02            |         2 |               |
      | LILY_B16             | BANK02        |          5.00 |              3 |         |              | LeadTime01     | LeadTime01            |         1 | x             |
      | LILY_B16             | BANK02        |          5.00 |                |         |              | LeadTime02     | LeadTime02            |         2 |               |
    And The "<BRAND CODE>" brand has the infomation of Company as the following
      | Inventory Brand Code | Company Name | Tag |
      | LILY_B16             | AUTO1        | x   |
    And The "<BRAND CODE>" should be updated as the above infomation
    # Search
    Then I search the "<BRAND CODE>", it should be founded as the following
      | Inventory Brand Code | Inventory Brand Desc  |
      | LILY_B16             | Auto-Only use by Lily |
    # Update
    When I want to update a Inventory Brand
    And Precisely,The "<BRAND CODE>" Brand has general infomation as the following
      | Inventory Brand Code | Description           |
      | LILY_B16             | Auto-Only use by Lily |
    And The "<BRAND CODE>" brand has the infomation of Forecast as the following
      | Inventory Brand Code | Target Month Supply Qty | Target Value |
      | LILY_B16             |                       1 |        12.00 |
    And The "<BRAND CODE>" brand has the infomation of Service Level as the following
      | Inventory Brand Code | Code      | Description | Service Level Value | Z Value | Del |
      | LILY_B16             | SL_CODE01 | SL_Desc 01  |                2.00 |    1.00 | x   |
      | LILY_B16             | SL_CODE02 | SL_Desc 02  |                3.00 |    2.00 | x   |
    And The "<BRAND CODE>" brand has the infomation of EOQ Calculation as the following
      | Inventory Brand Code | Code  | Description | Value | Del |
      | LILY_B16             | EOQ01 | EOQ01       |  1.00 | x   |
      | LILY_B16             | EOQ02 | EOQ02       |  2.00 | x   |
    And The "<BRAND CODE>" brand has the infomation of Supplier as the following
      | Inventory Brand Code | Supplier Code | Min Order Qty | Lead Time Link | Default | Supplier Del | Lead Time Code | Lead Time Description | Lead Time | Lead Time Del |
      | LILY_B16             | ADELA         |         10.00 |           3.00 | x       |              | LeadTime01     | LeadTime01            |         1 | x             |
      | LILY_B16             | ADELA         |         10.00 |                |         |              | LeadTime02     | LeadTime02            |         2 |               |
      | LILY_B16             | BANK02        |          5.00 |           3.00 |         |              | LeadTime01     | LeadTime01            |         1 | x             |
      | LILY_B16             | BANK02        |          5.00 |                |         |              | LeadTime02     | LeadTime02            |         2 |               |
    And The "<BRAND CODE>" brand has the infomation of Company as the following
      | Inventory Brand Code | Company Name | Tag |
      | LILY_B16             | AUTO1        | x   |
    And The "<BRAND CODE>" should be updated as the above infomation
    And I search the "<BRAND CODE>", it should be founded as the following
      | Inventory Brand Code | Inventory Brand Desc  |
      | LILY_B16             | Auto-Only use by Lily |
    # Delete
    When I want to delete a Inventory Brand
    And I search the "<BRAND CODE>", it should be founded as the following
      | Inventory Brand Code | Inventory Brand Desc  |
      | LILY_B16             | Auto-Only use by Lily |
    Then I confirm and delete this brand code certainty

    Examples: 
      | BRAND CODE |
      | LILY_B16   |
