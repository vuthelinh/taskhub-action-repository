@TH6_GLOBAL_MARKETING_CONTACT_GROUP @GlobalMarketingContactGroup @MT @integration
Feature: Global Marketing Contact Group management

  Scenario: create new marketing contact group
    Given user login the taskhub system
      And user navigates to "Master Setup>Customer Relation Management>Marketing Contact Group" screen
    #New
     When user creates new marketing contact group
      | Marketing Contact Group Code | Description |
      | ZOE001                       | test data   |
    #Update
      And user update information
    #Back To Summary
     Then user found down the new marketing contact group in the list
      | Marketing Contact Group Code | Description |
      | ZOE001                       | test data   |
    #Delete
      And user delete a marketing contact group then the marketing contact group not found in the list
      | Marketing Contact Group Code |
      | ZOE001                       |
