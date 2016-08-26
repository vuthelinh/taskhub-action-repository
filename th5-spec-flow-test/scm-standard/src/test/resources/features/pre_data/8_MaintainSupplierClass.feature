Feature: Create and maintain supplier class

	@Create
  Scenario Outline: Create Supplier Class
    Given user login the taskhub system
    When user navigates to "Global Setup>Party>Supplier>Supplier Class" screen
    And user create supplier class as "<KEY SUP CLASS>"
      | KEY SUP CLASS | Supplier Class Code | Description    | Payable GLAN | Realized GLAN | Unrealized GLAN | Goods Receipt Clearing GLAN | Purchase Variance GLAN | Additional Cost | Additional Cost Variance | Additional Cost Exchange | Purchase Return Variance | Purchase Variance Exch Diff | Sales Tax Exch Difference | Retention GLAN | Other Income GLAN | Company |
      |          1    | CLASS2-SCM          | Supplier class | 000140       | 000141        | 000142          | 000143                      | 000144                 | 000145          | 000146                   | 000147                   | 000148                   | 000149                      | 000150                    | 000151         | 000152            |         |

    Examples: 
      | KEY SUP CLASS |
      | 1             |
  
  @Maintain    
  Scenario Outline: Create Supplier Class
    Given user login the taskhub system
    When user navigates to "Global Setup>Party>Supplier>Supplier Class" screen
    And user maintains supplier class as "<KEY SUP CLASS>"
      | KEY SUP CLASS | Supplier Class Code | Description    | Payable GLAN | Realized GLAN | Unrealized GLAN | Goods Receipt Clearing GLAN | Purchase Variance GLAN | Additional Cost | Additional Cost Variance | Additional Cost Exchange | Purchase Return Variance | Purchase Variance Exch Diff | Sales Tax Exch Difference | Retention GLAN | Other Income GLAN | Company |
      |          1    | CLASS2-SCM          | Supplier class | 000140       | 000141        | 000142          | 000143                      | 000144                 | 000145          | 000146                   | 000147                   | 000148                   | 000149                      | 000150                    | 000151         | 000152            |         |

    Examples: 
      | KEY SUP CLASS |
      | 1             |