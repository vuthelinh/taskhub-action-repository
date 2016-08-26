@timesheet_calculation_hourlyrate_timerange @levin @payroll
Feature: Timesheet Calculation Test Suite by Payroll - Salary Type: Hourly Rate - Time Range

  Scenario Outline: Salary Type: Hourly Rate - Time Range
    Given "<User>" login to "<Company>" company with password is "<Password>"
    Given user access DB "<DB>" with id "<ID>" and password "<KEY>"

# Clear Data
    Given Data is clear as in "TSC_ClearSQL.xls"

# Test Flow
    When Data for Timesheet is created as in "<Dataset>"
    And Data is pulled out follows "<Dataset>" using Employee Prefix "<EMPPrefix>" with suffix as generated date
    Then Data is compared with "<Expected>"

    Examples:
      | User | Company | Password | DB                                    | ID       | KEY      | Dataset                                       | Expected                                                          | EMPPrefix |
      | kim  | (PTRG3) | taskhub  | jdbc:db2://172.18.0.10:50000/PAYROLL3 | db2admin | Taskhub1 | TSC_HourlyRate_TimeRange_PAYROLL3_Dataset.xls | TSC_HourlyRate_TimeRange_PAYROLL3_Dataset_Output_12_04_2016_C.xls | FTR       |

