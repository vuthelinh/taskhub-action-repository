
Feature: Create a project estimation with full information

  Background: 
    Given I am in project estimation page

  Scenario Outline: Standard Project Estimation without Cost Item Report is correct
    #Before tab Header
    Given I create a project estimation with information as "<KEY>"
      | KEY | Project name              | Customer  | Project Duration & DLP From | Project Duration & DLP To |
      | 1   | A full project estimation | Steve Job | 16/08/2016                  | 16/08/2017                |
    And I have a customer using currency with "<KEY>":
      | KEY | Currency | Exchange rate |
      | 1   | MYR      | 3.17          |
    And the sales tax for this customer is with "<KEY>"
      | KEY | Sales Tax |
      | 1   | 7.00      |
    And I enter the details of phases as with "<KEY>":
      | KEY | Phase No. | Qty   | Unit Price | Disc % | Budget Cost |
      | 1   | 1         | 24.03 | 120.50     | 12.50  | 2,150.00    |
      | 1   | 2         | 30    |            |        |             |
      | 1   | 2.1       | 26.08 | 133.60     | 13.70  |             |
      | 1   | 2.2       | 27.08 | 142.66     | 12.71  | 2,016.15    |
      | 1   | 3         | 50.00 |            |        |             |
      | 1   | 3.1       | 40.00 |            |        |             |
      | 1   | 3.1.1     | 24.00 | 120.00     | 12.00  |             |
    And I create costing sheet by phase as "<KEY>"
      | KEY | Phase No. | No | Type | Item Cost Description | Qty   | Unit Cost | Markup % |
      | 1   | 2.1       | 1  | S    | Steve Service 1       | 20.15 | 80.00     | 25.00    |
      | 1   | 3.1.1     | 1  | I    | Steve Item 1          | 22.00 | 80.00     | 25.00    |
    And the details of phases have information as "<KEY>"
      | KEY | Phase No. | Qty   | Unit Price | Disc % | Disc Amt | Phase Value | Budget Cost | Budget Profit | Margin % |
      | 1   | 1         | 24.03 | 120.50     | 12.50  | 361.95   | 2533.67     | 2,150.00    | 383.67        | 15.14    |
      | 1   | 2         | 30    | 212.64     |        |          | 6379.15     | 4031.15     | 2348          | 36.81    |
      | 1   | 2.1       | 26.08 | 133.60     | 13.70  | 477.35   | 3006.94     | 2,015.00    | 991.94        | 32.99    |
      | 1   | 2.2       | 27.08 | 142.66     | 12.71  | 491.02   | 3372.21     | 2,016.15    | 1356.06       | 40.21    |
    And the costing sheet by phase has information as "<KEY>"
      | KEY | Phase No. | No | Type | Item Cost Description | Qty   | Unit Cost | Markup % | Budget Cost |
      | 1   | 2.1       | 1  | S    | Steve Service 1       | 20.15 | 80.00     | 25.00    | 2,015.00    |
      | 1   | 3.1.1     | 2  | I    | Steve Item 1          | 22.00 | 80.00     | 25.00    | 2,200.00    |
    And the summary has information as "<KEY>"
      | KEY | Summary Values                | Nature    | Home      |
      | 1   | Project Sum                   | 11,447.22 | 36,287.69 |
      | 1   | Project Budget Cost           | 8,381.15  | 26,568.25 |
      | 1   | Project Budget Profit Amount  | 3,674.34  | 11,647.66 |
      | 1   | Project Budget Profit Percent | 32.10     | 32.10     |
      | 1   | Sales Tax                     | 801.31    | 2,540.14  |
      | 1   | Project Value incl. Tax       | 12,248.53 | 38,827.83 |
    And I enter the header tab as "<KEY>"
      | KEY | Awarded Date | Reference No. | Project Class          | Progressive Retention | Max Retention Amount | Max Retention Percent |
      | 1   | 16/08/2016   | None          | Project Class For Test | 10.00                 |                      | 10.00                 |
    And I enter employees as "<KEY>"
      | KEY | Employee Code       | Role In Project | Main Role     |
      | 1   | Steve Synergix Team | Sales Manager   | Sales Manager |
    And I enter payment information as "<KEY>"
      | KEY | Billing Type    | Billing Party | Payment Option   | Payment Term     | Payment Method |
      | 1   | Bill By Project | Steve Job     | Cash on Delivery | Cash on Delivery | Cash           |

    #When I submit the project estimation
    #And the approval process is turned on
    #And the information inside are correct
    Examples: 
      | KEY |  |
      | 1   |  |
