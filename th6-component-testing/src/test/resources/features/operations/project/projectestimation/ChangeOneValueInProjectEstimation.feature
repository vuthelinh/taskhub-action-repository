@integration @Steve @ID100037881
Feature: Changing one value will affect many other values

  Background: 
    Given user login the taskhub system
    And user navigates to "Operations>Project>Project Order" screen
    Given I am in project estimation page

  Scenario Outline: Change a value in a phase, TaskID is 100037881
    And I enter the details of phases as "<KEY>"
      | KEY | Phase No. | Qty   | Unit Price | Disc % | Disc Amt | Budget Cost |
      | 1   | 1         | 24.03 | 120.5000   | 12.50  |          | 2,150.00    |
      | 1   | 2         | 30.00 |            |        |          |             |
      | 1   | 2.1       | 26.08 | 133.6000   | 13.70  |          |             |
      | 1   | 2.2       | 27.08 | 142.6600   | 12.71  |          | 2,016.15    |
      | 2   | 1         | 24.03 | 120.5000   | 12.50  |          | 2,150.00    |
      | 2   | 2         | 30.00 |            |        |          |             |
      | 2   | 2.1       | 26.08 | 133.6000   | 13.70  |          |             |
      | 2   | 2.2       | 27.08 | 142.6600   | 12.71  |          | 2,016.15    |
      | 3   | 1         | 24.03 | 120.5000   | 12.50  |          | 2,150.00    |
      | 3   | 2         | 30.00 |            |        |          |             |
      | 3   | 2.1       | 26.08 | 133.6000   | 13.70  |          |             |
      | 3   | 2.2       | 27.08 | 142.6600   | 12.71  |          | 2,016.15    |
      | 4   | 1         | 24.03 | 120.5000   | 12.50  |          | 2,150.00    |
      | 4   | 2         | 30.00 |            |        |          |             |
      | 4   | 2.1       | 26.08 | 133.6000   | 13.70  |          |             |
      | 4   | 2.2       | 27.08 | 142.6600   |        | 491.02   | 2,016.15    |
      | 5   | 1         | 24.03 | 120.5000   | 12.50  |          | 2,150.00    |
      | 5   | 2         | 30.00 |            |        |          |             |
      | 5   | 2.1       | 26.08 | 133.6000   | 13.70  |          |             |
      | 5   | 2.2       | 27.08 | 142.6600   | 12.71  |          | 2,016.15    |
      | 6   | 1         | 24.03 | 120.5000   | 12.50  |          | 2,150.00    |
      | 6   | 2         | 30.00 |            |        |          |             |
      | 6   | 2.1       | 26.08 | 133.6000   | 13.70  |          |             |
      | 6   | 2.2       | 27.08 | 142.6600   | 12.71  |          | 2,016.15    |
      | 7   | 1         | 24.03 | 120.5000   | 12.50  |          | 2,150.00    |
      | 7   | 2         | 30.00 |            |        |          |             |
      | 7   | 2.1       | 26.08 | 133.6000   | 13.70  |          |             |
      | 7   | 2.2       | 27.08 | 142.6600   | 12.71  |          | 2,016.15    |
      | 8   | 1         | 24.03 | 120.5000   | 12.50  |          | 2,150.00    |
      | 8   | 2         | 30.00 |            |        |          |             |
      | 8   | 2.1       | 26.08 | 133.6000   | 13.70  |          |             |
      | 8   | 2.2       | 27.08 | 142.6600   | 12.71  |          | 2,016.15    |
    And I create costing sheet by phase as "<KEY>"
      | KEY | Phase No. | No | Type | Item Cost Description               | Qty   | Unit Cost | Markup % |
      | 1   | 2.1       | 1  | S    | Steve Service 1                     | 10.15 | 80.00     | 25.00    |
      | 1   | 2.1       | 2  | I    | Steve inventory code for steveitem1 | 12.00 | 80.00     | 25.00    |
      | 2   | 2.1       | 1  | S    | Steve Service 1                     | 10.15 | 80.00     | 25.00    |
      | 2   | 2.1       | 2  | I    | Steve inventory code for steveitem1 | 12.00 | 80.00     | 25.00    |
      | 3   | 2.1       | 1  | S    | Steve Service 1                     | 10.15 | 80.00     | 25.00    |
      | 3   | 2.1       | 2  | I    | Steve inventory code for steveitem1 | 12.00 | 80.00     | 25.00    |
      | 4   | 2.1       | 1  | S    | Steve Service 1                     | 10.15 | 80.00     | 25.00    |
      | 4   | 2.1       | 2  | I    | Steve inventory code for steveitem1 | 12.00 | 80.00     | 25.00    |
      | 5   | 2.1       | 1  | S    | Steve Service 1                     | 10.15 | 80.00     | 25.00    |
      | 5   | 2.1       | 2  | I    | Steve inventory code for steveitem1 | 12.00 | 80.00     | 25.00    |
      | 6   | 2.1       | 1  | S    | Steve Service 1                     | 10.15 | 80.00     | 25.00    |
      | 6   | 2.1       | 2  | I    | Steve inventory code for steveitem1 | 12.00 | 80.00     | 25.00    |
      | 7   | 2.1       | 1  | S    | Steve Service 1                     | 10.15 | 80.00     | 25.00    |
      | 7   | 2.1       | 2  | I    | Steve inventory code for steveitem1 | 12.00 | 80.00     | 25.00    |
      | 8   | 2.1       | 1  | S    | Steve Service 1                     | 10.15 | 80.00     | 25.00    |
      | 8   | 2.1       | 2  | I    | Steve inventory code for steveitem1 | 12.00 | 80.00     | 25.00    |
    And I have a customer using currency with "<KEY>"
      | KEY | Currency | Exchange rate |
      | 1   | MYR      | 4.20          |
      | 2   | MYR      | 4.20          |
      | 3   | MYR      | 4.20          |
      | 4   | MYR      | 4.20          |
      | 5   | MYR      | 4.20          |
      | 6   | MYR      | 4.20          |
      | 7   | MYR      | 4.20          |
      | 8   | MYR      | 4.20          |
    And the sales tax for this customer is with "<KEY>"
      | KEY | Sales Tax |
      | 1   | 7.00      |
      | 2   | 7.00      |
      | 3   | 7.00      |
      | 4   | 7.00      |
      | 5   | 7.00      |
      | 6   | 7.00      |
      | 7   | 7.00      |
      | 8   | 7.00      |
    And I enter the header tab as "<KEY>"
      | KEY | Awarded Date | Downpayment Percent | Progressive Retention | Max Retention Percent |
      | 1   | 25/08/2016   | 10.00               | 10.00                 | 9.00                  |
      | 2   | 25/08/2016   | 10.00               | 10.00                 | 9.00                  |
      | 3   | 25/08/2016   | 10.00               | 10.00                 | 9.00                  |
      | 4   | 25/08/2016   | 10.00               | 10.00                 | 9.00                  |
      | 5   | 25/08/2016   | 10.00               | 10.00                 | 9.00                  |
      | 6   | 25/08/2016   | 10.00               | 10.00                 | 9.00                  |
      | 7   | 25/08/2016   | 10.00               | 10.00                 | 9.00                  |
      | 8   | 25/08/2016   | 10.00               | 10.00                 | 9.00                  |
    When I change the a value as "<KEY>" in a phase
      | KEY | Place          | Phase No. | New Value                              |
      | 1   | Qty            | 1         | 30.00                                  |
      | 2   | Unit Price     | 2.1       | 133.0000                               |
      | 3   | Disc%          | 2.2       | 13.00                                  |
      | 4   | Disc Amt       | 2.2       | 500.00                                 |
      | 5   | Budget Cost    | 2.2       | 2,500.00                               |
      | 6   | Margin %       | 2.1       | 20.00                                  |
      | 7   | Delete a phase | 2.1       |                                        |
      | 8   | Add a phase    | 3         | Qty=10;Unit Price=200;Budget Cost=1000 |
    Then I should see details of that phase after changing as "<KEY>"
      | KEY | Place       | Phase No. | Qty   | Unit Price | Disc% | Disc Amt | Phase Value | Budget Cost | Budget Profit | Margin % |
      | 1   | Qty         | 1         | 30.00 | 120.5000   | 12.50 | 451.88   | 3,163.12    | 2,150.00    | 1,013.12      | 32.03    |
      | 2   | Unit Price  | 2.1       | 26.08 | 133.0000   | 13.70 | 475.20   | 2,993.44    | 2,215.00    | 778.44        | 26.00    |
      | 3   | Disc%       | 2.2       | 27.08 | 142.6600   | 13.00 | 502.22   | 3,361.01    | 2,016.15    | 1,344.86      | 40.01    |
      | 4   | Disc Amt    | 2.2       | 27.08 | 142.6600   | 12.94 | 500.00   | 3,363.23    | 2,016.15    | 1,347.08      | 40.05    |
      | 5   | Budget Cost | 2.2       | 27.08 | 142.6600   | 12.71 | 491.02   | 3,372.21    | 2,500.00    | 872.21        | 25.86    |
      | 6   | Margin %    | 2.1       | 26.08 | 123.0173   | 13.70 | 439.54   | 2,768.75    | 2,215.00    | 553.75        | 20.00    |
      | 8   | Add a phase | 3         | 10.00 | 200.0000   |       |          | 2,000.00    | 1,000.00    | 1,000.00      | 50.00    |
    And the summary values after changing should be as "<KEY>"
      | KEY | Place          | Summary Values          | Nature    | Home      |
      | 1   | Qty            | Project Sum             | 9,542.27  | 40,077.53 |
      | 1   | Qty            | Project Budget Cost     | 6,381.15  | 26,800.83 |
      | 1   | Qty            | Project Budget Profit   | 3,161.12  | 13,276.70 |
      | 1   | Qty            | Project Budget Percent  | 33.13     | 33.13     |
      | 1   | Qty            | Sales Tax Amount        | 667.96    | 2,805.43  |
      | 1   | Qty            | Project Value incl. Tax | 10,210.23 | 42,882.96 |
      | 2   | Unit Price     | Project Sum             | 8,899.32  | 37,377.14 |
      | 2   | Unit Price     | Project Budget Cost     | 6,381.15  | 26,800.83 |
      | 2   | Unit Price     | Project Budget Profit   | 2,518.17  | 10,576.31 |
      | 2   | Unit Price     | Project Budget Percent  | 28.30     | 28.30     |
      | 2   | Unit Price     | Sales Tax Amount        | 622.95    | 2,616.39  |
      | 2   | Unit Price     | Project Value incl. Tax | 9,522.27  | 39,993.53 |
      | 3   | Disc%          | Project Sum             | 8,901.62  | 37,386.80 |
      | 3   | Disc%          | Project Budget Cost     | 6,381.15  | 26,800.83 |
      | 3   | Disc%          | Project Budget Profit   | 2,520.47  | 10,585.97 |
      | 3   | Disc%          | Project Budget Percent  | 28.31     | 28.31     |
      | 3   | Disc%          | Sales Tax Amount        | 623.11    | 2,617.06  |
      | 3   | Disc%          | Project Value incl. Tax | 9,524.73  | 40,003.86 |
      | 4   | Disc Amt       | Project Sum             | 8,903.84  | 37,396.13 |
      | 4   | Disc Amt       | Project Budget Cost     | 6,381.15  | 26,800.83 |
      | 4   | Disc Amt       | Project Budget Profit   | 2,522.69  | 10,595.30 |
      | 4   | Disc Amt       | Project Budget Percent  | 28.33     | 28.33     |
      | 4   | Disc Amt       | Sales Tax Amount        | 623.27    | 2,617.73  |
      | 4   | Disc Amt       | Project Value incl. Tax | 9,527.11  | 40,013.86 |
      | 5   | Budget Cost    | Project Sum             | 8,912.82  | 37,433.84 |
      | 5   | Budget Cost    | Project Budget Cost     | 6,865.00  | 28,833.00 |
      | 5   | Budget Cost    | Project Budget Profit   | 2,047.82  | 8,600.84  |
      | 5   | Budget Cost    | Project Budget Percent  | 22.98     | 22.98     |
      | 5   | Budget Cost    | Sales Tax Amount        | 623.90    | 2,620.38  |
      | 5   | Budget Cost    | Project Value incl. Tax | 9,536.72  | 40,054.22 |
      | 6   | Margin %       | Project Sum             | 8,674.63  | 36,433.44 |
      | 6   | Margin %       | Project Budget Cost     | 6,381.15  | 26,800.83 |
      | 6   | Margin %       | Project Budget Profit   | 2,293.48  | 9,632.62  |
      | 6   | Margin %       | Project Budget Percent  | 26.44     | 26.44     |
      | 6   | Margin %       | Sales Tax Amount        | 607.22    | 2,550.32  |
      | 6   | Margin %       | Project Value incl. Tax | 9,281.85  | 38,983.76 |
      | 7   | Delete a phase | Project Sum             | 5,905.88  | 24,804.69 |
      | 7   | Delete a phase | Project Budget Cost     | 4,166.15  | 17,497.83 |
      | 7   | Delete a phase | Project Budget Profit   | 1,739.73  | 7,306.87  |
      | 7   | Delete a phase | Project Budget Percent  | 29.46     | 29.46     |
      | 7   | Delete a phase | Sales Tax Amount        | 413.41    | 1,736.32  |
      | 7   | Delete a phase | Project Value incl. Tax | 6,319.29  | 26,541.01 |
      | 8   | Add a phase    | Project Sum             | 10,912.82 | 45,833.84 |
      | 8   | Add a phase    | Project Budget Cost     | 7,381.15  | 31,000.83 |
      | 8   | Add a phase    | Project Budget Profit   | 3,531.67  | 14,833.01 |
      | 8   | Add a phase    | Project Budget Percent  | 32.36     | 32.36     |
      | 8   | Add a phase    | Sales Tax Amount        | 763.90    | 3,208.38  |
      | 8   | Add a phase    | Project Value incl. Tax | 11,676.72 | 49,042.22 |
    And the downpayment and retention after changing should be as "<KEY>"
      | KEY | Place          | Downpayment Amount | Downpayment Percent | Progressive Retention | Max Retention Amount | Max Retention Percent |
      | 1   | Qty            | 954.23             | 10.00               | 10.00                 | 858.80               | 9.00                  |
      | 2   | Unit Price     | 889.93             | 10.00               | 10.00                 | 800.94               | 9.00                  |
      | 3   | Disc%          | 890.16             | 10.00               | 10.00                 | 801.15               | 9.00                  |
      | 4   | Disc Amt       | 890.38             | 10.00               | 10.00                 | 801.35               | 9.00                  |
      | 5   | Budget Cost    | 891.28             | 10.00               | 10.00                 | 802.15               | 9.00                  |
      | 6   | Margin %       | 867.46             | 10.00               | 10.00                 | 780.72               | 9.00                  |
      | 7   | Delete a phase | 590.59             | 10.00               | 10.00                 | 531.53               | 9.00                  |
      | 8   | Add a phase    | 1,091.28           | 10.00               | 10.00                 | 982.15               | 9.00                  |

    Examples: Change one of these values
      | KEY |
      | 1   |
      | 2   |
      | 3   |
      | 4   |
      | 5   |
      | 6   |
      | 7   |
      | 8   |
