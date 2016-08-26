Feature: Create and maintain customer class

  @Create
  Scenario Outline: Create Customer Class
    Given user login the taskhub system
    When user navigates to "Global Setup>Party>Customer>Customer Class" screen
    And user create customer class as "<KEY CUS CLASS>"
      | KEY CUS CLASS | Customer Class Code | Description | Receivable GLAN | Realized GLAN | Unrealized GLAN | Corporate Clearing GLAN | Amt Refundable to Customer | Receivable Medisave GLAN | Medisave Clearing GLAN | Amt Billable to Customer | Recognized Accrued Cost | Recognized Accrued Revenue | Rental Revenue GLAN | Sales GLAN | Costs of Sales GLAN | Sales Return GLAN | Costs of Sales Return GLAN | Costs of Sales Ret Clearing GLAN | Delivery Clearing GLAN | Inventory With Customer GLAN | Cost of Servicing GLAN | Unearned Revenue GLAN | Work in Progress GLAN | Retention GLAN | Project Revenue GLAN | Project Cost GLAN | Recognition Exch Gain Loss GLAN | Cost Accrual GLAN | Revenue Accrual GLAN | Accrued Income GLAN | Attributable Profit | Claim Debtor | Certification Debtor | Other Payable | Retention Clearing | Material on Site | Retention Material on Site | Downpayment Unearned GLAN | Downpayment Exch Gain Loss GLAN | Company |
      | 1             | CLASS-SCM           | Class1      | 000153          | 000154        | 000155          | 000156                  | 000157                     | 000158                   | 000159                 | 000160                   | 000161                  | 000162                     | 000163              | 000164     | 000165              | 000166            | 000167                     | 000168                           | 000169                 | 000170                       | 000171                 |                       |                       |                |                      |                   |                                 |                   |                      |                     |                     |              |                      |               |                    |                  |                            |                           |                                 |         |

    Examples: 
      | KEY CUS CLASS |
      | 1             |
	
	@Maintain
	 Scenario Outline: Maintain Customer Class
    Given user login the taskhub system
    When user navigates to "Global Setup>Party>Customer>Customer Class" screen
    And user maintains customer class as "<KEY CUS CLASS>"
      | KEY CUS CLASS | Customer Class Code | Description | Receivable GLAN | Realized GLAN | Unrealized GLAN | Corporate Clearing GLAN | Amt Refundable to Customer | Receivable Medisave GLAN | Medisave Clearing GLAN | Amt Billable to Customer | Recognized Accrued Cost | Recognized Accrued Revenue | Rental Revenue GLAN | Sales GLAN | Costs of Sales GLAN | Sales Return GLAN | Costs of Sales Return GLAN | Costs of Sales Ret Clearing GLAN | Delivery Clearing GLAN | Inventory With Customer GLAN | Cost of Servicing GLAN | Unearned Revenue GLAN | Work in Progress GLAN | Retention GLAN | Project Revenue GLAN | Project Cost GLAN | Recognition Exch Gain Loss GLAN | Cost Accrual GLAN | Revenue Accrual GLAN | Accrued Income GLAN | Attributable Profit | Claim Debtor | Certification Debtor | Other Payable | Retention Clearing | Material on Site | Retention Material on Site | Downpayment Unearned GLAN | Downpayment Exch Gain Loss GLAN | Company |
      | 1             | CLASS-SCM           | Class1      | 000153          | 000154        | 000155          | 000156                  | 000157                     | 000158                   | 000159                 | 000160                   | 000161                  | 000162                     | 000163              | 000164     | 000165              | 000166            | 000167                     | 000168                           | 000169                 | 000170                       | 000171                 |                       |                       |                |                      |                   |                                 |                   |                      |                     |                     |              |                      |               |                    |                  |                            |                           |                                 |         |

    Examples: 
      | KEY CUS CLASS |
      | 1             |