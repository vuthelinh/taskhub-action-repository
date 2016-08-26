Feature: Supplier

  Scenario: Create Supplier
    Given user login the taskhub system
    When user navigates to "Global Setup>Party>Supplier>Supplier" screen
    And user create new Supplier
    And user logout
