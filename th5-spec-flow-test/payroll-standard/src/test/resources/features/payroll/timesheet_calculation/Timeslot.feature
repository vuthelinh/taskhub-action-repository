@timesheet_calculation_timeslot @levin @payroll
Feature: Timesheet Calculation Test Suite by Payroll - Salary Type: Timeslot

  #Cannot run parallelly with Piece Rate
  Scenario Outline: Salary Type: Timeslot
    Given "<User>" login to "<Company>" company with password is "<Password>"
    Given user access DB "<DB>" with id "<ID>" and password "<KEY>"

# Clear Data
    Given Data is clear as in "TSC_ClearSQL.xls"

# Test Flow
    When Data for Timesheet is created as in "<Dataset>"
    And Data is pulled out follows "<Dataset>" using Employee Prefix "<EMPPrefix>" with suffix as generated date
    Then Data is compared with "<Expected>"

    Examples:
      | User  | Company | Password | DB                                    | ID       | KEY      | Dataset                           | Expected                  | EMPPrefix |
      | levin | (TRG4)  | taskhub  | jdbc:db2://172.18.0.10:50000/GENMAIN4 | db2admin | Taskhub1 | TSC_TimeSlot_GENMAIN4_Dataset.xls | TSC_TimeSlot_Output_E.xls | TST       |

