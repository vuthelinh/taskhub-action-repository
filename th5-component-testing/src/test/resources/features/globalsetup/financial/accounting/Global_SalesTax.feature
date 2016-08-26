Feature: Sales Tax

  Scenario Outline: Create Sales Tax  with feature file
    Given user login the taskhub system
    When user navigates to "Global Setup>Financial>Accounting>Sales Tax" screen
    When user create sales tax as "<KEY SALES TAX>"
      | KEY SALES TAX | Prefix | Sales Tax Code | Description | Sales Tax | Input Tax GLAN | Output Tax GLAN | IRAS Tax Type of Purchase | IRAS Tax Type of Supply | Company |
      | 001           |        | gst0           |             | 0         | 43110          | 43120           |                           |                         |         |
      | 001           |        | gst7           |             | 7         | 43110          | 43120           |                           |                         |         |
      | 001           |        | gst10          |             | 10        | 43110          | 43120           |                           |                         |         |

    Examples: 
      | KEY SALES TAX |
      | 001           |

  Scenario: Delete Sales Tax  with feature file
    Given user login the taskhub system
    When user navigates to "Global Setup>Financial>Accounting>Sales Tax" screen
    When user delete sales tax
      | Sales Tax Code |
      | gst0           |
      | gst7           |
      | gst10          |

  Scenario: Create Sales Tax
    Given user login the taskhub system
    When user navigates to "Global Setup>Financial>Accounting>Global Sales Tax" screen
    When user create new sales tax
    And user logout
