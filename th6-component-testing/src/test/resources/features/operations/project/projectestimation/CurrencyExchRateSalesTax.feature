@zoe @project_order @integration
Feature: Currency, exchange rate and sales tax in Project Order

  Background: 
    Given user login the taskhub system
      And user navigates to "Operations>Project>Project Order" screen
      And I am in project estimation page

  Scenario Outline: Change Currency, exchange rate and sales tax in Project Order
    When I create phase details for "<KEY>"
      | KEY | Phase No. | Qty | Unit Price | Disc % | Budget Cost |
      |   1 |         1 |   5 |        100 |     10 |          90 |
      |   2 |         1 |   5 |        100 |     10 |          90 |
      |   3 |         1 |   5 |        100 |     10 |          90 |
     And I have a customer using currency with "<KEY>"
      | KEY | Currency | Exchange rate |
      |   1 | MYR      |           4.2 |
      |   2 | MYR      |           4.2 |
      |   3 | MYR      |           4.2 |
     And the sales tax for this customer is with "<KEY>"
      | KEY | Sales Tax |
      |   1 |      7.00 |
      |   2 |      7.00 |
      |   3 |      7.00 |
     And the summary values of "<KEY>" should be
      | KEY | Summary Values          | Nature | Home     |
      |   1 | Project Sum             | 450.00 | 1,890.00 |
      |   1 | Project Budget Cost     |  90.00 |   378.00 |
      |   1 | Project Budget Profit   | 360.00 | 1,512.00 |
      |   1 | Project Budget Percent  |  80.00 |    80.00 |
      |   1 | Sales Tax Amount        |  31.50 |   132.30 |
      |   1 | Project Value incl. Tax | 481.50 | 2,022.30 |
      |   2 | Project Sum             | 450.00 | 1,890.00 |
      |   2 | Project Budget Cost     |  90.00 |   378.00 |
      |   2 | Project Budget Profit   | 360.00 | 1,512.00 |
      |   2 | Project Budget Percent  |  80.00 |    80.00 |
      |   2 | Sales Tax Amount        |  31.50 |   132.30 |
      |   2 | Project Value incl. Tax | 481.50 | 2,022.30 |
      |   3 | Project Sum             | 450.00 | 1,890.00 |
      |   3 | Project Budget Cost     |  90.00 |   378.00 |
      |   3 | Project Budget Profit   | 360.00 | 1,512.00 |
      |   3 | Project Budget Percent  |  80.00 |    80.00 |
      |   3 | Sales Tax Amount        |  31.50 |   132.30 |
      |   3 | Project Value incl. Tax | 481.50 | 2,022.30 |

    When I change values at the "<KEY>"
      | KEY | Place         | New Value |
      |   1 | Currency      | THB       |
      |   2 | Exchange Rate |         5 |
      |   3 | Sales Tax     | GST0      |

    Then the summary values when changing that "<KEY>" should be
      | KEY | Place         | Summary Values          | Nature | Home     |
      |   1 | Currency      | Project Sum             | 450.00 |   450.00 |
      |   1 | Currency      | Project Budget Cost     |  90.00 |    90.00 |
      |   1 | Currency      | Project Budget Profit   | 360.00 |   360.00 |
      |   1 | Currency      | Project Budget Percent  |  80.00 |    80.00 |
      |   1 | Currency      | Sales Tax Amount        |  31.50 |    31.50 |
      |   1 | Currency      | Project Value incl. Tax | 481.50 |   481.50 |
      |   2 | Exchange Rate | Project Sum             | 450.00 | 2,250.00 |
      |   2 | Exchange Rate | Project Budget Cost     |  90.00 |   450.00 |
      |   2 | Exchange Rate | Project Budget Profit   | 360.00 |  1800.00 |
      |   2 | Exchange Rate | Project Budget Percent  |  80.00 |    80.00 |
      |   2 | Exchange Rate | Sales Tax Amount        |  31.50 |   157.50 |
      |   2 | Exchange Rate | Project Value incl. Tax | 481.50 | 2,407.50 |
      |   3 | Sales Tax     | Project Sum             | 450.00 | 1,890.00 |
      |   3 | Sales Tax     | Project Budget Cost     |  90.00 |   378.00 |
      |   3 | Sales Tax     | Project Budget Profit   | 360.00 | 1,512.00 |
      |   3 | Sales Tax     | Project Budget Percent  |  80.00 |    80.00 |
      |   3 | Sales Tax     | Sales Tax Amount        |   0.00 |     0.00 |
      |   3 | Sales Tax     | Project Value incl. Tax | 450.00 | 1,890.00 |

    Examples: 
      | KEY |
      |   1 |
      |   2 |
      |   3 |
