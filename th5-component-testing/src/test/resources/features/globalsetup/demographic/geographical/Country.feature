@integration @jacob
Feature: Country

  Scenario: Create Country
    Given user is currently logged in to TaskHub System
    And user navigates to "Global Setup>Demographic>Geographical>Country>[2]" screen
    When user create new country
      | Country Code | Country Description | Nationality Description | Nationality Code |
      | AT           | Add by auto         | Do not use 01           | 777              |
    When user delete a country then the country not found in the list
      | Country Code |
      | AT           |
