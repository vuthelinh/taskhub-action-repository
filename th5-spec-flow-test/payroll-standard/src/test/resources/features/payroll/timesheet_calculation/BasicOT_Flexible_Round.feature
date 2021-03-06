@timesheet_calculation_basicot_flexible_round @levin @payroll
Feature: Timesheet Calculation Test Suite by Payroll - Salary Type: Basic OT - Flexible with Rounding

  #Cannot run parallelly with BasicOT_Flexible_NoRound
  Scenario Outline: Salary Type: Basic OT - Flexible with Rounding
    Given "<User>" login to "<Company>" company with password is "<Password>"
    Given user access DB "<DB>" with id "<ID>" and password "<KEY>"

# Clear Data
    Given Data is clear as in "TSC_ClearSQL.xls"

# Test Flow
    When Data for Timesheet is created as in "<Dataset>"
    And Data is pulled out follows "<Dataset>" using Employee Prefix "<EMPPrefix>" with suffix as generated date
    Then Data is compared with "<Expected>"

    Examples:
      | User  | Company | Password | DB                                    | ID       | KEY      | Dataset                                        | Expected                                                           | EMPPrefix |
      | emily | (TRG)   | taskhub  | jdbc:db2://172.18.0.245:50000/GENMAIN | db2admin | Taskhub1 | TSC_BasicOT_Flexible_GENMAIN_Dataset_Round.xls | TSC_BasicOT_Flexible_GENMAIN_Dataset_Round_Output_13_04_2016_C.xls | AOT       |

