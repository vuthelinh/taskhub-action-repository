@global_employee_daily_th5 @levin @payroll
Feature: Integration Live Run Test Suite by Payroll

  Scenario Outline: Global Employee TH5
    Given "<User>" login to "<Company>" company with password is "<Password>"

# Test Flow
    Given Employee is created as in "<Employee>"

    Examples:
      | User     | Company  | Password | Employee               |
      | synergix | (DEVINT) | taskhub  | Daily_Employee_TH5.xls |