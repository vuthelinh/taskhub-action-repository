@cpf_calculation @levin @payroll
Feature: CPF Calculation Test Suite by Payroll

  Scenario Outline: Create Additional Payment and Payslip Generation
    Given "<User>" login to "<Company>" company with password is "<Password>"
    Given user access DB "<DB>" with id "<ID>" and password "<KEY>"

# Preparation
    Given Employee is created as in "<Employee>"

# Clear Data
    Given Data is clear as in "<Clear>"

# Create Additional Vouchers
    When Additional Payment By Recipient for CPF is created as in "<Additional>"
    And Payslip is generated as in "<Payslip>" and pull out data to excel with generated date
    Then Data is calculated correctly follows "<Payslip>" on sheet "Expected"

    Examples:
      | User  | Company | Password | DB                                    | ID       | KEY      | Employee         | Clear            | Additional                            | Payslip                   |
      | emily | (TRG6)  | taskhub  | jdbc:db2://172.18.0.10:50000/GENMAIN6 | db2admin | Taskhub1 | CPF_Employee.xls | CPF_ClearSQL.xls | CPF_AdditionalPayment_ByRecipient.xls | CPF_PayrollGeneration.xls |