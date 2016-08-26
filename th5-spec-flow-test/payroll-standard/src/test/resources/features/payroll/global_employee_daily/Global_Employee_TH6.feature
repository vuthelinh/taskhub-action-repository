@global_employee_daily_th6 @levin @payroll
Feature: Integration Live Run Test Suite by Payroll

  Scenario Outline: Global Employee TH6
    Given "levin.le" login to "Synergix Technologies Pte" company with password is "taskhub"

# Test Flow
    Given user navigates to "Master Setup>Employee & Approving Officer>Employee>[2]" screen
    When Employee is created as in "<Employee>"

    Examples:
      | Employee               |
      | Daily_Employee_TH6.xls |