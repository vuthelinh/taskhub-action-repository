Feature: Customer

  Scenario: Create Customer
    Given user login the taskhub system
    When user navigates to "Global Setup>Party>Customer>Customer" screen
    And user create new customer
    And user logout
