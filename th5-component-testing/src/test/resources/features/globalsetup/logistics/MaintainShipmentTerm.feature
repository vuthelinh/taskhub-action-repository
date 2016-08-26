@integration @vincent @maintain_shipment_term @scm
Feature: Maintain Master Data
  Maintain Shipment Term
  Mode 1: Create brand new data for Shipment Term
  Mode 2: Maintain data for Shipment Term (Add new code, update old code, no delete)

  Scenario: Maintain Shipment Term
    Given user login the taskhub system
    When user navigates to "Global Setup>Logistics>Shipment Term" screen
    Then page header shouble be "Shipment Term"
    Then user maintains Shipment Term
      | Shipment Mode | Holding Bay Period | Shipment Term Code | Description                | Company Name |
      | Air           | 0                  | V_001              | Vincent Shipment Term Code | AUTO5        |
      | Air           | 0                  | V_002              | Vincent Shipment Term Code | AUTO5        |
      | Air           |                    | V_002              |                            | AUTO4        |
      | Road          | 0                  | V_001              | Vincent Shipment Term Code | AUTO5        |
      | Rail          | 0                  | V_001              | Vincent Shipment Term Code | AUTO5        |
      | Sea           | 0                  | V_001              | Vincent Shipment Term Code | AUTO5        |
      | Sea           | 0                  | V_002              | Vincent Shipment Term Code | AUTO5        |
