@TH6_POLICY_TYPE @Policy_type @MT @integration @zoe
Feature: Policy Type management

  Scenario: Policy Type integration test
    Given user login the taskhub system
     And user navigates to "Master Setup>Project>Policy Type" screen
    #New
     When user creates new policy type
      | Policy Type Code | Description |
      | ZOE001           | test data   |
    #Update
      And user update the policy type infomation 
     Then user found down the policy type in the list
      | Policy Type Code | Description | Status    |
      | ZOE001           | test data   | Suspended |
    #Delete
      And user delete policy type then policy type is not found in the list
      | Policy Type Code |
      | ZOE001           |
