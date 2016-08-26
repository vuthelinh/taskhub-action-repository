@timesheet_calculation_hourlyrate_workinghour @levin @payroll
Feature: Timesheet Calculation Test Suite by Payroll - Salary Type: Hourly Rate - Working Hour

  Scenario Outline: Salary Type: Hourly Rate - Working Hour
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
      | emily | (PTRG)  | taskhub  | jdbc:db2://172.18.0.244:50000/PAYROLL | db2admin | Taskhub1 | TSC_HourlyRate_WorkingHour_PAYROLL_Dataset.xls | TSC_HourlyRate_WorkingHour_PAYROLL_Dataset_Output_12_04_2016_C.xls | FHR_WH    |

