@vincen@additional_payment_by_recipient_master_data
Feature: Test for Payroll Additional Payment Standard

  Scenario Outline: Test for Payroll Additional Payment Standard
    Given "vincent1" login to "(TRG6)" company with password is "taskhub"
    Given GLAN is created as in                                   "A_01_7_GLAN.xls"
    Given Employee Class is created as in                         "A_15_1_EmployeeClass.xls"
    Given Employee Job Type is created as in                      "A_15_2_EmployeeJobType.xls"
    Given Employee Grade is created as in                         "A_15_3_EmployeeGrade.xls"
    Given Payment Cycle is created as in                          "A_15_3_PaymentCycle.xls"
    Given Employee Payroll Category is created as in              "A_15_4_EPC.xls"
    Given Employee is created as in                                "A_16_Employee.xls"
    Given Service Code is created as in                         "A_14_ServiceCode.xls"
    Given "vincent1" login to "(TRG6)" company with password is "taskhub"
    Given user access DB "jdbc:db2://172.18.0.10:50000/GENMAIN6" with id "db2admin" and password "Taskhub1"
    Given Data is clear as in "AddPayment_ClearSQL.xls"

    Examples: 
      | Test Key | DATABASE KEY |
      | 001      | 001          |
