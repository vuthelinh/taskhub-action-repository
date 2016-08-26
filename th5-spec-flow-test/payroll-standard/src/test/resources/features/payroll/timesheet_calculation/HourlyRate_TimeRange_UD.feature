@timesheet_calculation_hourlyrate_timerange_ud @levin @payroll
Feature: Timesheet Calculation Test Suite by Payroll - Salary Type: Hourly Rate - Time Range - User Define

  Scenario Outline: Salary Type: Hourly Rate - Time Range - User Define
    Given "<User>" login to "<Company>" company with password is "<Password>"
    Given user access DB "<DB>" with id "<ID>" and password "<KEY>"

# Clear Data
    Given Data is clear as in "TSC_ClearSQL.xls"

# Test Flow
    When Data for Timesheet is created as in "<Dataset>"
    And Data is pulled out follows "<Dataset>" using Employee Prefix "<EMPPrefix>" with suffix as generated date
    Then Data is compared with "<Expected>"

    Examples:
      | User    | Company | Password | DB                                    | ID       | KEY      | Dataset                                          | Expected                                                             | EMPPrefix |
      | queenie | (PTRG5) | taskhub  | jdbc:db2://172.18.0.10:50000/PAYROLL5 | db2admin | Taskhub1 | TSC_HourlyRate_TimeRange_UD_PAYROLL5_Dataset.xls | TSC_HourlyRate_TimeRange_UD_PAYROLL5_Dataset_Output_11_04_2016_C.xls | FTR_USER  |

