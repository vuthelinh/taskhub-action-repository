Feature: Supplier Class

  Scenario Outline: Create Supplier Class
    Given user login the taskhub system
    When user navigates to "Global Setup>Party>Supplier>Supplier Class" screen
    And user create supplier class as "<KEY SUP CLASS>"
      | KEY SUP CLASS | Supplier Class Code | Description                               | Payable GLAN | Realized GLAN | Unrealized GLAN | Goods Receipt Clearing GLAN | Purchase Variance GLAN | Additional Cost | Additional Cost Variance | Additional Cost Exchange | Purchase Return Variance | Purchase Variance Exch Diff | Sales Tax Exch Difference | Retention GLAN | Other Income GLAN | Company      |
      | 001           | nsclass01           | Supplier Class  for Synergix Testing ONLY | 41010        | 52000         | 52000           | 52000                       | 52000                  | 44000           | 62010                    | 52000                    | 61010                    | 52000                       | 52000                     | 21030          | 52000             | AUTO4, AUTO1 |
      | 001           | nsclass01           | Supplier Class  for Synergix Testing ONLY | 41010        | 52000         | 52000           | 52000                       | 52000                  | 44000           | 62010                    | 52000                    | 61010                    | 52000                       | 52000                     | 21030          | 52000             | AUTO4, AUTO1 |
      | 001           | nsclass03           | Supplier Class  for Synergix Testing ONLY | 41010        | 52000         | 52000           | 52000                       | 52000                  | 44000           | 62010                    | 52000                    | 61010                    | 52000                       | 52000                     | 21030          | 52000             | AUTO4, AUTO1 |
      | 001           | nsclass04           | Supplier Class  for Synergix Testing ONLY | 41010        | 52000         | 52000           | 52000                       | 52000                  | 44000           | 62010                    | 52000                    | 61010                    | 52000                       | 52000                     | 21030          | 52000             | AUTO4, AUTO1 |

    Examples: 
      | KEY SUP CLASS |
      | 001           |

  Scenario: Delete Supplier Class
    Given user login the taskhub system
    When user navigates to "Global Setup>Party>Supplier>Supplier Class" screen
    And user delete supplier class
      | Supplier Class Code |
      | nsclass01           |
      | nsclass02           |
      | nsclass03           |
      | nsclass04           |

  Scenario: Create Supplier Class
    Given user login the taskhub system
    When user navigates to "Global Setup>Party>Supplier>Supplier Class" screen
    And user create new supplier class
    And user logout
