@Steve @integration @Phase_Details
Feature: Create project quotation
  In order to sent a project estimation to project deparment							
  As an estimator							
  I want to create a new project estimation

  Background: 
    Given user login the taskhub system
    And user navigates to "Operations>Project>Project Order" screen
    Given I am in project estimation page

  #And the project has many phases
  #Phase details are related to each other through these formular:
  #Discount Amount = Qty*Unit Price * Discount Percent/100
  #The amount of money customer has to pay = Qty*Unit Price
  #Profit margin = Profit/The amount of money customer has to pay * 100%
  #Phase Value: Amount of money customer has to pay, budget cost is the estimated cost of the phase, disc % is discount percent customer receives
  #Budget Profit: Profit I will receive after finishing a phase
  Scenario Outline: Able to calculate phase details with known unit price and discount percent
    When a phase of the project has details with known unit price and discount percent as the following with "<KEY>":
      | KEY | Qty   | Unit Price | Disc % | Budget Cost |
      | 1   | 24.00 | 120.00     | 12.00  | 2,200.00    |
    Then I should see phase details including discount amount and profit margin as the following with "<KEY>":
      | KEY | Disc Amt | Phase Value | Budget Profit | Margin % |
      | 1   | 345.60   | 2,534.40    | 334.40        | 13.19    |

    Examples: 
      | KEY |
      | 1   |

  Scenario Outline: Able to calculate phase details with known unit price and discount amount
    When a phase of the project has details with known unit price and discount amount as the following with "<KEY>":
      | KEY | Qty   | Unit Price | Disc Amt | Budget Cost |
      | 1   | 24.00 | 120.00     | 345.60   | 2,200.00    |
    Then I should see phase details including discount percent and profit margin as the following with "<KEY>":
      | KEY | Disc % | Phase Value | Budget Profit | Margin % |
      | 1   | 12.00  | 2,534.40    | 334.40        | 13.19    |

    Examples: 
      | KEY |
      | 1   |

  #Given a phase of the project has a phase number as
  #	1
  #When I create 2 subphases for the phase
  #Then phase number of subphases should be
  #	1.1
  #	1.2
  #And the phase levels will be defined as
  #	Phase No.	Phase level
  #	1	1
  #	1.1	2
  #	1.2	2
  #And phase 1 is called parent phase of phases 1.1 and 1.2
  Scenario Outline: Able to calculate parent phase details
    When I enter the details of phases as "<KEY>"
      | KEY | Phase No. | Qty    | Unit Price | Disc % | Budget Cost |
      | 1   | 1         | 100.00 |            |        |             |
      | 1   | 1.1       | 90.00  |            |        |             |
      | 1   | 1.1.1     | 24.03  | 120.50     | 12.50  | 2,150.00    |
      | 1   | 1.1.2     | 26.08  | 133.60     | 13.70  | 2,015.00    |
    #Parent phase quantity = sum of all quantites of all direct child phases
    #The same for phase value, budget cost
    #Unit Price, profit amount, profit margin in percent are calculated with the same formular above
    Then I should see values of parent phases as with "<KEY>":
      | KEY | Phase No. | Phase Value | Budget Cost | Budget Profit | Margin % |
      | 1   | 1         | 5,540.61    | 4,165.00    | 1,375.61      | 24.83    |
      | 1   | 1.1       | 5,540.61    | 4,165.00    | 1,375.61      | 24.83    |

    Examples: 
      | KEY |
      | 1   |

  Scenario Outline: Able to calculate total values
    Given the project estimation has the awarded date as below with "<KEY>"
      | KEY | Awarded Date |
      | 1   |              |
    #| 1   | 23/08/2016   |
    Given I have a customer using currency with "<KEY>"
      | KEY | Currency | Exchange rate |
      | 1   | MYR      | 4.20          |
    And the sales tax for this customer is with "<KEY>"
      | KEY | Sales Tax |
      | 1   | 7.00      |
    #And the currency has the following exchange rates with "<KEY>"
    #| KEY | Effective Date From | Effective Date To | Bank's Sell Rate | Bank's Buy Rate |
    #| 1   | 22/07/2016          | 22/08/2016        | 5                | 3.17            |
    #| 1   | 23/08/2016          | 23/09/2016        | 4                | 4.2             |
    #Then the exchange rate applied to the estimation should be with "<KEY>"
    #| KEY | Exchange Rate |
    #| 1   | 4.2           |
    When parent phases have the values as "<KEY>"
      | KEY | Phase No. | Phase Value | Budget Cost | Budget Profit |
      | 1   | 1         | 1,365.78    | 1,267.83    | 97.95         |
      | 1   | 2         | 950.22      | 923.12      | 27.10         |
    #Project Sum = sum of amount of money customer has to pay for each phase
    #Sales Tax = Sale Tax percent * Project Sum
    # Project sum: Total amount of money customer has to pay for the project
    Then I should see total values as "<KEY>"
      | KEY | Summary Values                | Nature   | Home      |
      | 1   | Project Sum                   | 2,316.00 | 9,727.20  |
      | 1   | Project Budget Cost           | 2,190.95 | 9,201.99  |
      | 1   | Project Budget Profit Amount  | 125.05   | 525.21    |
      | 1   | Project Budget Profit Percent | 5.40     | 5.40      |
      | 1   | Sales Tax                     | 162.12   | 680.90    |
      | 1   | Project Value incl. Tax       | 2,478.12 | 10,408.10 |

    Examples: 
      | KEY |
      | 1   |
