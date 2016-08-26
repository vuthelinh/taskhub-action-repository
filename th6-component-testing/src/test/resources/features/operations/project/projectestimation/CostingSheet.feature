@zoe @integration @project_order
Feature: Costing Sheet in Project Order

  Background: 
    Given user login the taskhub system
      And user navigates to "Operations>Project>Project Order" screen
      And I am in project estimation page

  Scenario Outline: Change a value in costing sheet by phase
    When I create phase for "<KEY>"
      | KEY | Phase No. | Qty | Unit Price |
      |   1 |         1 |   5 |        100 |
      |   2 |         1 |   5 |        100 |
      |   3 |         1 |   5 |        100 |
     And I create costing sheet by phase for "<KEY>"
      | KEY | Phase No. | No | Type | Qty | Unit Cost | Markup |
      |   1 |         1 |  1 | S    |   2 |       100 |     10 |
      |   2 |         1 |  1 | I    |   2 |       100 |     10 |
      |   3 |         1 |  1 | S    |   2 |       100 |     10 |
     And I should see details "<KEY>" as
      | KEY | Phase No. | Qty  | Unit Price | Phase Value | Budget Cost | Budget Profit | Margin |
      |   1 |         1 | 5.00 |   100.0000 |      500.00 |      220.00 |        280.00 |  56.00 |
      |   2 |         1 | 5.00 |   100.0000 |      500.00 |      220.00 |        280.00 |  56.00 |
      |   3 |         1 | 5.00 |   100.0000 |      500.00 |      220.00 |        280.00 |  56.00 |
    When I make a change at "<KEY>" in the costing sheet of a phase
      | KEY | Place     | Phase No. | No | New Value |
      |   1 | Qty       |         1 |  1 |       2.5 |
      |   2 | Unit Cost |         1 |  1 |       200 |
      |   3 | Markup    |         1 |  1 |        15 |
    Then I should see details of that phase when changing that "<KEY>" as
      | KEY | Phase No. | Qty  | Unit Price | Phase Value | Budget Cost | Budget Profit | Margin |
      |   1 |         1 | 5.00 |   100.0000 |      500.00 |      275.00 |        225.00 |  45.00 |
      |   2 |         1 | 5.00 |   100.0000 |      500.00 |      440.00 |         60.00 |  12.00 |
      |   3 |         1 | 5.00 |   100.0000 |      500.00 |      230.00 |        270.00 |  54.00 |
     And the summary values when changing that "<KEY>" should be
      | KEY | Place     | Summary Values          | Nature | Home   |
      |   1 | Qty       | Project Sum             | 500.00 | 500.00 |
      |   1 | Qty       | Project Budget Cost     | 275.00 | 275.00 |
      |   1 | Qty       | Project Budget Profit   | 225.00 | 225.00 |
      |   1 | Qty       | Project Budget Percent  |  45.00 |  45.00 |
      |   1 | Qty       | Sales Tax Amount        |   0.00 |   0.00 |
      |   1 | Qty       | Project Value incl. Tax | 500.00 | 500.00 |
      |   2 | Unit Cost | Project Sum             | 500.00 | 500.00 |
      |   2 | Unit Cost | Project Budget Cost     | 440.00 | 440.00 |
      |   2 | Unit Cost | Project Budget Profit   |  60.00 |  60.00 |
      |   2 | Unit Cost | Project Budget Percent  |  12.00 |  12.00 |
      |   2 | Unit Cost | Sales Tax Amount        |   0.00 |   0.00 |
      |   2 | Unit Cost | Project Value incl. Tax | 500.00 | 500.00 |
      |   3 | Markup    | Project Sum             | 500.00 | 500.00 |
      |   3 | Markup    | Project Budget Cost     | 230.00 | 230.00 |
      |   3 | Markup    | Project Budget Profit   | 270.00 | 270.00 |
      |   3 | Markup    | Project Budget Percent  |  54.00 |  54.00 |
      |   3 | Markup    | Sales Tax Amount        |   0.00 |   0.00 |
      |   3 | Markup    | Project Value incl. Tax | 500.00 | 500.00 |

    Examples: 
      | KEY |
      |   1 |
      |   2 |
      |   3 |
