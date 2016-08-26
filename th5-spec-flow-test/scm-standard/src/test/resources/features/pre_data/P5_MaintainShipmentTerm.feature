@phoebe_pre_data_5
Feature: Create and maintain shipment term
  Maintain Shipment Term						
  Mode 1: Create brand new data for Shipment Term						
  Mode 2: Maintain data for Shipment Term (Add new code, update old code, no delete)

  @Create @Maintain
  Scenario: Maintain Shipment Term
    Given user login the taskhub system
    When user navigates to "Global Setup>Logistics>Shipment Term" screen
    Then page header shouble be "Shipment Term"
    Then user maintains Shipment Term
      | Shipment Mode | Holding Bay Period | Shipment Term Code | Description | Company Name |
      | Air           |                    | FOB                | FOB         |              |
      | Road          |                    | FOB                | FOB         |              |
      | Rail          |                    | FOB                | FOB         |              |
      | Sea           |                    | FOB                | FOB         |              |
