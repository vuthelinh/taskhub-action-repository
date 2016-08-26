@timesheet_calculation_basicsalary @levin @payroll
Feature: Timesheet Calculation Test Suite by Payroll - Salary Type: Basic Salary

  Scenario Outline: Salary Type: Basic Salary
    Given "<User>" login to "<Company>" company with password is "<Password>"
    Given user access DB "<DB>" with id "<ID>" and password "<KEY>"

# Clear Data
    Given Data is clear as in "TSC_ClearSQL.xls"

# Test Flow
    When Data for Timesheet is created as in "<Dataset>"
    And Data is pulled out follows "<Dataset>" using Employee Prefix "<EMPPrefix>" with suffix as generated date
    Then Data is compared with "<Expected>"

    Examples:
      | User  | Company | Password | DB                                    | ID       | KEY      | Dataset                              | Expected                     | EMPPrefix |
      | levin | (PTRG2) | taskhub  | jdbc:db2://172.18.0.10:50000/PAYROLL2 | db2admin | Taskhub1 | TSC_BasicSalary_PAYROLL2_Dataset.xls | TSC_BasicSalary_Output_E.xls | FHR       |

