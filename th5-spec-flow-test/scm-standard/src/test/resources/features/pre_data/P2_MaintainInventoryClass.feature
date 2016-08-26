@phoebe_pre_data_2
Feature: Create and maintain inventory class
  Maintain Global Inventory Class																								
  Create data for Global Inventory Class

  @Create @Maintain
  Scenario Outline: Maintain Global Inventory Class
    Given user login the taskhub system
    When user navigates to "Global Setup>Inventory>Classification>Class" screen
    Then page header shouble be "Class"
    Then user maintains Global Inventory Class as "<Inventory Class KEY>"
      | KEY | Inventory Class Code | Company Name | Description             | Costing Method   | Inventory GLAN | Inventory Expense GLAN | Sales GLAN | Physical Addition GLAN | Costs of Sales GLAN | Physical Reduction GLAN | Sales Return GLAN | Delivery Clearing GLAN | Costs of Sales Return GLAN | Work in Progress GLAN | Costs of Sales Ret Clearing GLAN | Calibration GLAN | Replacement Holding GLAN | Scrap Expense GLAN | Issue Variance GLAN | Rework Expense GLAN | Production Variance GLAN | Cost of Servicing GLAN |
      | 1   | FIFOSCM              |              | Fifo method             | FIFO             | 000123         | 000131                 | 000124     | 000132                 | 000125              | 000133                  | 000126            | 000134                 | 000127                     | 000135                | 000128                           | 000136           | 000129                   | 000137             | 000130              | 000138              |                          | 000139                 |
      | 1   | WASCM                |              | Weighted average method | Weighted Average | 000123         | 000131                 | 000124     | 000132                 | 000125              | 000133                  | 000126            | 000134                 | 000127                     | 000135                | 000128                           | 000136           | 000129                   | 000137             | 000130              | 000138              |                          | 000139                 |

    Examples: 
      | Inventory Class KEY |
      | 1                   |
