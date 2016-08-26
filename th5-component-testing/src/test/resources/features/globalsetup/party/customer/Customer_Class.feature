Feature: Customer Class

  Scenario Outline: Create Customer Class with feature file
    Given user login the taskhub system
    When user navigates to "Global Setup>Party>Customer>Customer Class" screen
    And user create customer class as "<KEY CUS CLASS>"
      | KEY CUS CLASS | Customer Class Code | Description                               | Receivable GLAN | Realized GLAN | Unrealized GLAN | Corporate Clearing GLAN | Amt Refundable to Customer | Receivable Medisave GLAN | Medisave Clearing GLAN | Amt Billable to Customer | Recognized Accrued Cost | Recognized Accrued Revenue | Rental Revenue GLAN | Sales GLAN | Costs of Sales GLAN | Sales Return GLAN | Costs of Sales Return GLAN | Costs of Sales Ret Clearing GLAN | Delivery Clearing GLAN | Inventory With Customer GLAN | Cost of Servicing GLAN | Unearned Revenue GLAN | Work in Progress GLAN | Retention GLAN | Project Revenue GLAN | Project Cost GLAN | Recognition Exch Gain Loss GLAN | Cost Accrual GLAN | Revenue Accrual GLAN | Accrued Income GLAN | Attributable Profit | Claim Debtor | Certification Debtor | Other Payable | Retention Clearing | Material on Site | Retention Material on Site | Downpayment Unearned GLAN | Downpayment Exch Gain Loss GLAN | Company |
      | 001           | customer            | Customer Class  for Synergix Testing ONLY | 22020           | 86050         | 86060           | 22020                   | 22020                      | 22020                    | 22020                  | 22020                    | 22020                   | 22020                      | 85000               | 51010      | 60000               | 52000             | 60020                      | 22020                            | 22020                  | 22020                        | 22020                  | 22020                 | 22020                 | 22020          | 22020                | 22020             | 22020                           | 22020             | 22020                | 22020               | 22020               | 22020        | 22020                | 22020         | 22020              | 22020            | 22020                      | 22020                     | 22020                           |         |
      | 001           | customer01          | Customer Class  for Synergix Testing ONLY | 22020           | 86050         | 86060           | 22020                   | 22020                      | 22020                    | 22020                  | 22020                    | 22020                   | 22020                      | 85000               | 51010      | 60000               | 52000             | 60020                      | 22020                            | 22020                  | 22020                        | 22020                  | 22020                 | 22020                 | 22020          | 22020                | 22020             | 22020                           | 22020             | 22020                | 22020               | 22020               | 22020        | 22020                | 22020         | 22020              | 22020            | 22020                      | 22020                     | 22020                           |         |
      | 001           | customer02          | Customer Class  for Synergix Testing ONLY | 22020           | 86050         | 86060           | 22020                   | 22020                      | 22020                    | 22020                  | 22020                    | 22020                   | 22020                      | 85000               | 51010      | 60000               | 52000             | 60020                      | 22020                            | 22020                  | 22020                        | 22020                  | 22020                 | 22020                 | 22020          | 22020                | 22020             | 22020                           | 22020             | 22020                | 22020               | 22020               | 22020        | 22020                | 22020         | 22020              | 22020            | 22020                      | 22020                     | 22020                           |         |

    Examples: 
      | KEY CUS CLASS |
      | 001           |

  Scenario: Delete Customer Class with feature file
    Given user login the taskhub system
    When user navigates to "Global Setup>Party>Customer>Customer Class" screen
    And user delete customer class
      | Customer Class Code |
      | customer            |
      | customer01          |
      | customer02          |

  Scenario: Create Customer Class
    Given user login the taskhub system
    When user navigates to "Global Setup>Party>Customer>Customer Class" screen
    And user create new customer class
    And user logout
