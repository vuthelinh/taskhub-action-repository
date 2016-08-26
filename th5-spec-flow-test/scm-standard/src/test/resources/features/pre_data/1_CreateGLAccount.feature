@V001
Feature: Create and maintain GL Account
  In order to store all transactions
  As an accountant
  I want to create a GL Account
	
	@Create
  Scenario: Create Chart Of Account with feature file
    Given user login the taskhub system
    And user navigates to "Global Setup>Financial>Accounting>Chart Of Acc" screen
    When user create chart of account with company ""
      | GL Account Code | Description                      | Account Type | Status | For Sub Ledger Account | Company |
      | 000123          | Inventory GLan                   |              |        |                        |         |
      | 000124          | Sales Glan                       |              |        |                        |         |
      | 000125          | Cost of Sales Glan               |              |        |                        |         |
      | 000126          | Sales Return GLAN                |              |        |                        |         |
      | 000127          | Costs of Sales Return GLAN       |              |        |                        |         |
      | 000128          | Costs of Sales Ret Clearing GLAN |              |        |                        |         |
      | 000129          | Replacement Holding GLAN         |              |        |                        |         |
      | 000130          | Issue Variance GLAN              |              |        |                        |         |
      | 000131          | Inventory Expense GLAN           |              |        |                        |         |
      | 000132          | Physical Addition GLAN           |              |        |                        |         |
      | 000133          | Physical Reduction GLAN          |              |        |                        |         |
      | 000134          | Delivery Clearing GLAN           |              |        |                        |         |
      | 000135          | Work in Progress GLAN            |              |        |                        |         |
      | 000136          | Calibration GLAN                 |              |        |                        |         |
      | 000137          | Scrap Expense GLAN               |              |        |                        |         |
      | 000138          | Rework Expense GLAN              |              |        |                        |         |
      | 000139          | Cost of Servicing GLAN           |              |        |                        |         |
      | 000140          | Payable GLAN                     |              |        |                        |         |
      | 000141          | Realized GLAN                    |              |        |                        |         |
      | 000142          | Unrealized GLAN                  |              |        |                        |         |
      | 000143          | Goods Receipt Clearing GLAN      |              |        |                        |         |
      | 000144          | Purchase Variance GLAN           |              |        |                        |         |
      | 000145          | Additional Cost                  |              |        |                        |         |
      | 000146          | Additional Cost Variance         |              |        |                        |         |
      | 000147          | Additional Cost Exchange         |              |        |                        |         |
      | 000148          | Purchase Return Variance         |              |        |                        |         |
      | 000149          | Purchase Variance Exch Diff      |              |        |                        |         |
      | 000150          | Sales Tax Exch Difference        |              |        |                        |         |
      | 000151          | Retention GLAN                   |              |        |                        |         |
      | 000152          | Other Income GLAN                |              |        |                        |         |
      | 000153          | Receivable GLAN                  |              |        |                        |         |
      | 000154          | Realized GLAN                    |              |        |                        |         |
      | 000155          | Unrealized GLAN                  |              |        |                        |         |
      | 000156          | Corporate Clearing GLAN          |              |        |                        |         |
      | 000157          | Amt Refundable to Customer       |              |        |                        |         |
      | 000158          | Receivable Medisave GLAN         |              |        |                        |         |
      | 000159          | Medisave Clearing GLAN           |              |        |                        |         |
      | 000160          | Amt Billable to Customer         |              |        |                        |         |
      | 000161          | Recognized Accrued Cost          |              |        |                        |         |
      | 000162          | Recognized Accrued Revenue       |              |        |                        |         |
      | 000163          | Rental Revenue GLAN              |              |        |                        |         |
      | 000164          | Sales GLAN                       |              |        |                        |         |
      | 000165          | Costs of Sales GLAN              |              |        |                        |         |
      | 000166          | Sales Return GLAN                |              |        |                        |         |
      | 000167          | Costs of Sales Return GLAN       |              |        |                        |         |
      | 000168          | Costs of Sales Ret Clearing GLAN |              |        |                        |         |
      | 000169          | Delivery Clearing GLAN           |              |        |                        |         |
      | 000170          | Inventory With Customer GLAN     |              |        |                        |         |
      | 000171          | Cost of Servicing GLAN           |              |        |                        |         |
	
	@Maintain
	Scenario: Maintain Chart Of Account with feature file
    Given user login the taskhub system
    And user navigates to "Global Setup>Financial>Accounting>Chart Of Acc" screen
    When user maintain chart of account with company ""
      | GL Account Code | Description                      | Account Type | Status | For Sub Ledger Account | Company |
      | 000123          | Inventory GLan                   |              |        |                        |         |
      | 000124          | Sales Glan                       |              |        |                        |         |
      | 000125          | Cost of Sales Glan               |              |        |                        |         |
      | 000126          | Sales Return GLAN                |              |        |                        |         |
      | 000127          | Costs of Sales Return GLAN       |              |        |                        |         |
      | 000128          | Costs of Sales Ret Clearing GLAN |              |        |                        |         |
      | 000129          | Replacement Holding GLAN         |              |        |                        |         |
      | 000130          | Issue Variance GLAN              |              |        |                        |         |
      | 000131          | Inventory Expense GLAN           |              |        |                        |         |
      | 000132          | Physical Addition GLAN           |              |        |                        |         |
      | 000133          | Physical Reduction GLAN          |              |        |                        |         |
      | 000134          | Delivery Clearing GLAN           |              |        |                        |         |
      | 000135          | Work in Progress GLAN            |              |        |                        |         |
      | 000136          | Calibration GLAN                 |              |        |                        |         |
      | 000137          | Scrap Expense GLAN               |              |        |                        |         |
      | 000138          | Rework Expense GLAN              |              |        |                        |         |
      | 000139          | Cost of Servicing GLAN           |              |        |                        |         |
      | 000140          | Payable GLAN                     |              |        |                        |         |
      | 000141          | Realized GLAN                    |              |        |                        |         |
      | 000142          | Unrealized GLAN                  |              |        |                        |         |
      | 000143          | Goods Receipt Clearing GLAN      |              |        |                        |         |
      | 000144          | Purchase Variance GLAN           |              |        |                        |         |
      | 000145          | Additional Cost                  |              |        |                        |         |
      | 000146          | Additional Cost Variance         |              |        |                        |         |
      | 000147          | Additional Cost Exchange         |              |        |                        |         |
      | 000148          | Purchase Return Variance         |              |        |                        |         |
      | 000149          | Purchase Variance Exch Diff      |              |        |                        |         |
      | 000150          | Sales Tax Exch Difference        |              |        |                        |         |
      | 000151          | Retention GLAN                   |              |        |                        |         |
      | 000152          | Other Income GLAN                |              |        |                        |         |
      | 000153          | Receivable GLAN                  |              |        |                        |         |
      | 000154          | Realized GLAN                    |              |        |                        |         |
      | 000155          | Unrealized GLAN                  |              |        |                        |         |
      | 000156          | Corporate Clearing GLAN          |              |        |                        |         |
      | 000157          | Amt Refundable to Customer       |              |        |                        |         |
      | 000158          | Receivable Medisave GLAN         |              |        |                        |         |
      | 000159          | Medisave Clearing GLAN           |              |        |                        |         |
      | 000160          | Amt Billable to Customer         |              |        |                        |         |
      | 000161          | Recognized Accrued Cost          |              |        |                        |         |
      | 000162          | Recognized Accrued Revenue       |              |        |                        |         |
      | 000163          | Rental Revenue GLAN              |              |        |                        |         |
      | 000164          | Sales GLAN                       |              |        |                        |         |
      | 000165          | Costs of Sales GLAN              |              |        |                        |         |
      | 000166          | Sales Return GLAN                |              |        |                        |         |
      | 000167          | Costs of Sales Return GLAN       |              |        |                        |         |
      | 000168          | Costs of Sales Ret Clearing GLAN |              |        |                        |         |
      | 000169          | Delivery Clearing GLAN           |              |        |                        |         |
      | 000170          | Inventory With Customer GLAN     |              |        |                        |         |
      | 000171          | Cost of Servicing GLAN           |              |        |                        |         |

			