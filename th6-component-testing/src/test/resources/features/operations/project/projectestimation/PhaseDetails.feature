@integration @zoe @Phase_Details
Feature: Project Order
  Enter phase details of the project

  Background: 
    Given user login the taskhub system
      And user navigates to "Operations>Project>Project Order" screen

  Scenario Outline: Budget Profit and Margin are calculated correctly
    When user creates phase with Qty, Unit Price and Budget Cost as "<KEY>"
      | KEY | Phase No. | Qty | Unit Price | Budget Cost |
      | 001 |         1 |   5 |        100 |          40 |
    Then user should see result for "<KEY>" as the following:
      | KEY | Phase No. | Qty  | Unit Price | Budget Cost | Budget Profit | Margin |
      | 001 |         1 | 5.00 |   100.0000 |       40.00 |        460.00 |  92.00 |

    Examples: 
      | KEY |
      | 001 |

  Scenario Outline: Unit Price, Budget Profit are calculated correctly
    When user creates phase with Qty, Budget Cost, Margin as "<KEY>"
      | KEY | Phase No. | Qty | Unit Price | Budget Cost | Margin |
      | 001 |         1 |   5 |        100 |          40 |     50 |
    Then user should see the following result for "<KEY>":
      | KEY | Phase No. | Qty  | Unit Price | Budget Cost | Budget Profit | Margin |
      | 001 |         1 | 5.00 |    16.0000 |       40.00 |         40.00 |  50.00 |

    Examples: 
      | KEY |
      | 001 |

  #Cost Sheeting
  Scenario Outline: Budget Cost in Costing Sheet by Phase are calculated correctly
    When user creates the following details for each phase as "<KEY>"
      | KEY | Phase No. | Qty | Unit Price | Disc Percent | Budget Cost |
      | 001 |         1 |   5 |         80 |              |             |
      | 002 |         1 |   5 |        200 |              |             |
      | 003 |         1 |   5 |        200 |              |             |
      | 004 |         1 |     |            |              |             |
      | 004 |       1.1 |   5 |        200 |              |             |
      | 004 |       1.2 |   5 |        200 |              |             |

     And user creates costing sheet by phase as the following for  "<KEY>":
      | KEY | Phase No. | No | Type | Item Cost Description | Qty | Unit Cost | Markup |
      | 001 |         1 |  1 | S    | AN SERVICE            |   2 |       100 |     10 |
      | 002 |         1 |  1 | I    | ANTEO                 |   5 |       200 |     10 |
      | 003 |         1 |  1 | I    | ANTEO                 |   5 |       200 |     10 |
      | 003 |         1 |  2 | S    | AN SERVICE            |   2 |       100 |     10 |
      | 004 |       1.1 |  1 | S    | AN SERVICE            |   5 |       200 |     10 |
      | 004 |       1.2 |  1 | S    | AN SERVICE            |   5 |       200 |     10 |

    #Back to Phase Details
     And user should see the result of Phase Details  "<KEY>" as the following:
      | KEY | Phase No. | Qty  | Unit Price | Disc Percent | Disc Amount | Phase Value | Budget Cost | Budget Profit | Margin |
      | 001 |         1 | 5.00 |    80.0000 |              |             |      400.00 |      220.00 |        180.00 |  45.00 |
      | 002 |         1 | 5.00 |   200.0000 |              |             | 1,000.00    | 1,100.00    |       -100.00 | -10.00 |
      | 003 |         1 | 5.00 |   200.0000 |              |             | 1,000.00    | 1,320.00    |       -320.00 | -32.00 |
      | 004 |         1 | 0.00 |     0.0000 |              |             | 2,000.00    | 2,200.00    |       -200.00 | -10.00 |

    Examples: 
      | KEY |
      | 001 |
      | 002 |
      | 003 |
      | 004 |

  Scenario Outline: Budget Cost  are calculated correctly
    When user creates the following details as "<KEY>":
      | KEY | Phase No. | Qty | Unit Price | Disc Percent | Budget Cost |
      | 001 |         1 |   5 |         80 |              |             |
     And user creates costing sheet by phase as "<KEY>":
      | KEY | Phase No. | No | Type | Item Cost Description | Qty | Unit Cost | Markup |
      | 001 |         1 |  1 | S    | AN SERVICE            |   2 |       100 |     10 |
      | 001 |         1 |  2 | I    | ANTEO                 |   5 |       200 |     10 |
      | 001 |         1 |  3 | S    | AN SERVICE            |   2 |       100 |     10 |
     And sum of Budget Cost as "<KEY>":
      | KEY | Phase No. | Budget Cost |
      | 001 |         1 | 1,540.00    |
     And user delete one item on costing sheet as "<KEY>":
      | KEY | No |
      | 001 |  1 |
    Then user should see the budget cost result as "<KEY>":
      | KEY | Phase No. | Budget Cost |
      | 001 |         1 | 1,320.00    |
    # Back to Phase Details
     And user should see the phase details as "<KEY>":
      | KEY | Phase No. | Qty  | Unit Price | Disc Percent | Disc Amount | Phase Value | Budget Cost | Budget Profit | Margin  |
      | 001 |         1 | 5.00 |    80.0000 |              |             |      400.00 | 1,320.00    |       -920.00 | -230.00 |

    Examples: 
      | KEY |
      | 001 |
