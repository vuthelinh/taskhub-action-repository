Feature: Billing A Project
  In order to bill a project
  As a accountant
  I want to bill the project
  
  Background:
	Given "ian" login to "AUTO1" company with password is "taskhub"
  
  @ian @billbyproject @deluge @current
  Scenario:  Amount to Bill and Progressive is calculated correctly when having retention
 	#	  | Total   | Tax | Exch Rate | Retention (%) | Downpayment (%) | Actual downpayment |
	#	  | 2500.55 | 7   | 1.3       | 13.00%        | 15              | 10                 |
	Given There is a bill-by-project project has retention and downpayment
	When I create bill for the downpayent
	#Downpayment Invoice
	  | BILL KEY | Invoice Date | Sales Tax | Exch Rate | Amount To Bill |
	  | INV001   |              | GST0      | 1.47      | 250            |
	And I submit the invoice
	Then Source Journal Report should include
	  | Vourcher No | Kind   | Account              | Nature | Home  |
	  | INV001      | Debit  | Account Receivable   | 250    | 367.5 |
	  |             | Credit | Downpayment Unearned | 250    | 367.5 |
	  |             | Debit  | Total                | 250    | 367.5 |
	  |             | Credit | Total                | 250    | 367.5 |
	When I create bill for the Project Order
	And I bill the project order
	  | BILL KEY | Invoice Date | Progressive Percent | Amount To Bill | Cumulative Billed Amount | Retention Percent | Cumulative Retention | This Cumulative Retention Balance | Less Discount |
	  | INV002   |              | 10.3                |                |                          |                   |                      |                                   |               |
	Then Billing should be as following
	  | BILL KEY | Project Amount | Billed Amount | Progressive Percent | Amount To Bill | Cumulative Billed Amount | Retention Current Cumulative Released | Retention Current Cumulative Balance | Retention Percent | Cumulative Retention | This Cumulative Retention Balance | Downpayment Recoverd | Previous Billed Amount | Discount | Invoice Amount | Sales Tax | Affter Tax | Exch Rate | Invoice Home | Sales Tax Home | After Tax Home |
	  | INV002   | 2500.55        | 0             |                     | 257.56         | 257.56                   | 0                                     | 0                                    | 9                 | 23.18                | 23.18                             | 23.44                |                        |          | 210.94         | 14.77     | 225.71     | 1.3       | 274.22       | 19.2           | 293.42         |
	When I submit the bill
	And I submit the invoice
	Then Source Journal Report should include
	  | Vourcher No | Kind   | Account              | Nature | Home   |
	  | INV002      | Debit  | Account Receivable   | 225.71 | 293.42 |
	  |             | Debit  | Downpayment Unearned | 23.44  | 30.47  |
	  |             | Debit  | Retention            | 23.18  | 30.13  |
	  |             | Credit | Unearned Revenue     | 257.56 | 334.83 |
	  |             | Credit | Sales Tax            | 14.77  | 19.2   |
	  |             | Debit  | Total                | 272.33 | 354.02 |
	  |             | Credit | Total                | 272.33 | 354.03 |
	When I bill the project order
	  | BILL KEY | Invoice Date | Progressive Percent | Amount To Bill | Cumulative Billed Amount | Retention Percent | Cumulative Retention | This Cumulative Retention Balance | Less Discount |
	  | INV003   |              | 17.82               |                |                          |                   |                      |                                   |               |
	Then Billing should be as following
	  | BILL KEY | Project Amount | Billed Amount | Progressive Percent | Amount To Bill | Cumulative Billed Amount | Retention Current Cumulative Released | Retention Current Cumulative Balance | Retention Percent | Cumulative Retention | This Cumulative Retention Balance | Downpayment Recoverd | Previous Billed Amount | Discount | Invoice Amount | Sales Tax | Affter Tax | Exch Rate | Invoice Home | Sales Tax Home | After Tax Home |
	  | INV003   | 2500.55        | 257.56        |                     | 445.6          | 703.16                   | 0                                     | 23.18                                | 12                | 53.47                | 76.65                             | 39.21                | 210.94                 |          | 352.92         | 24.7      | 377.62     | 1.3       | 458.8        | 32.11          | 490.91         |
	When I submit the bill
	And I submit the invoice
	Then Source Journal Report should include
	  | Vourcher No | Kind   | Account              | Nature | Home   |
	  | INV003      | Debit  | Account Receivable   | 377.62 | 490.91 |
	  |             | Debit  | Downpayment Unearned | 39.21  | 50.97  |
	  |             | Debit  | Retention            | 53.47  | 69.51  |
	  |             | Credit | Unearned Revenue     | 445.6  | 579.28 |
	  |             | Credit | Sales Tax            | 24.7   | 32.11  |
	  |             | Debit  | Total                | 470.3  | 611.39 |
	  |             | Credit | Total                | 470.3  | 611.39 |
	When I bill the project order
	  | BILL KEY | Invoice Date | Progressive Percent | Amount To Bill | Cumulative Billed Amount | Retention Percent | Cumulative Retention | This Cumulative Retention Balance | Less Discount |
	  | INV004   |              |                     |                |                          |                   | -40                  |                                   |               |
	Then Billing should be as following
	  | BILL KEY | Project Amount | Billed Amount | Progressive Percent | Amount To Bill | Cumulative Billed Amount | Retention Current Cumulative Released | Retention Current Cumulative Balance | Retention Percent | Cumulative Retention | This Cumulative Retention Balance | Downpayment Recoverd | Previous Billed Amount | Discount | Invoice Amount | Sales Tax | Affter Tax | Exch Rate | Invoice Home | Sales Tax Home | After Tax Home |
	  | INV004   | 2500.55        | 703.16        |                     | 0              | 703.16                   | 0                                     | 76.65                                |                   | -40                  | 36.65                             | 4                    | 563.86                 |          | 36             | 2.52      | 38.52      | 1.3       | 46.8         | 3.28           | 50.08          |
	When I submit the bill
	And I submit the invoice
	Then Source Journal Report should include
	  | Vourcher No | Kind   | Account              | Nature | Home  |
	  | INV004      | Debit  | Account Receivable   | 38.52  | 50.08 |
	  |             | Debit  | Downpayment Unearned | 4      | 5.2   |
	  |             | Credit | Retention            | 40     | 52    |
	  |             | Credit | Sales Tax            | 2.52   | 3.28  |
	  |             | Debit  | Total                | 42.52  | 55.28 |
	  |             | Credit | Total                | 42.52  | 55.28 |
	When I bill the project order
	  | BILL KEY | Invoice Date | Progressive Percent | Amount To Bill | Cumulative Billed Amount | Retention Percent | Cumulative Retention | This Cumulative Retention Balance | Less Discount |
	  | INV005   |              | 71.88               |                |                          |                   |                      | 0                                 |               |
	Then Billing should be as following
	  | BILL KEY | Project Amount | Billed Amount | Progressive Percent | Amount To Bill | Cumulative Billed Amount | Retention Current Cumulative Released | Retention Current Cumulative Balance | Retention Percent | Cumulative Retention | This Cumulative Retention Balance | Downpayment Recoverd | Previous Billed Amount | Discount | Invoice Amount | Sales Tax | Affter Tax | Exch Rate | Invoice Home | Sales Tax Home | After Tax Home |
	  | INV005   | 2500.55        | 703.16        |                     | 1797.39        | 2500.55                  | 40                                    | 36.65                                |                   | -36.65               | 0                                 | 183.35               | 599.86                 |          | 1650.69        | 115.55    | 1766.24    | 1.3       | 2145.9       | 150.22         | 2296.11        |
	When I submit the bill
	And I submit the invoice
	Then Source Journal Report should include
	  | Vourcher No | Kind   | Account              | Nature  | Home    |
	  | INV005      | Debit  | Account Receivable   | 1766.24 | 2296.11 |
	  |             | Debit  | Downpayment Unearned | 183.35  | 238.36  |
	  |             | Debit  | Retention            | -36.65  | -47.65  |
	  |             | Credit | Unearned Revenue     | 1797.39 | 2336.61 |
	  |             | Credit | Sales Tax            | 115.55  | 150.22  |
	  |             | Debit  | Total                | 1912.94 | 2486.82 |
	  |             | Credit | Total                | 1912.94 | 2486.83 |