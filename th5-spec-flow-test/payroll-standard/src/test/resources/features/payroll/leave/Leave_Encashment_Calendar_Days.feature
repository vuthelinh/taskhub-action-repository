@leave_encashment_days_full
Feature: Test Leave Encashment on Calendar Days

  Background:
    Given "emily" login to "(TRG7)" company with password is "taskhub"
    Given user access DB "jdbc:db2://172.18.0.10:50000/GENMAIN7" with id "db2admin" and password "Taskhub1"

  @leave_encashment_days_prepare_data
  Scenario: Test Leave Encashment
    Given Payment Cycle is created as in             "LV_Encash_PaymentCycle.xls"
    Given Employee Payroll Category is created as in "LV_Encash_EPC.xls"
    Given Leave Type is created as in                "LV_Encash_LeaveType.xls"
    Given Employee is created as in                  "LV_Encash_Employee.xls"
    Given LV_EMP_LEAVE_TYPE is updated
      | EMPLOYEE_CODE | LEAVE_TYPE_CODE | YEAR | CARRIED_FORWARD | TOTAL_ENTITLEMENT_DAYS | LEAVE_DAYS_TAKEN | LEAVE_DAYS_TAKEN_NEXT_YEAR | LEAVE_DAYS_TAKEN_LAST_YEAR |
      | E001          | ENCASH5         | 2016 | 0               | 16.5                   | 4                | 2                          | 0                          |
      | E002          | ENCASH5         | 2016 | 6               | 12                     | 9                | 2                          | 6                          |
      | E003          | ENCASH0         | 2016 | 6               | 13                     | 2                | 0                          | 2                          |
      | E003          | ENCASH5         | 2016 | 6               | 6                      | 7.5              | 0                          | 5                          |
      | E004          | ENCASHA         | 2016 | 0               | 11                     | 0                | 0                          | 0                          |
      | E004          | ENCASH5         | 2016 | 0               | 7                      | 2.5              | 0                          | 0                          |
      | E005          | NENCASH         | 2016 | 0               | 16                     | 3                | 0                          | 0                          |
      | E005          | ENCASH5         | 2016 | 0               | 17                     | 3                | 0                          | 0                          |
      | E006          | ENCASH5         | 2016 | 0               | 12                     | 0                | 0                          | 0                          |
      | E007          | ENCASH5         | 2016 | 6               | 11                     | 1                | 0                          | 1                          |
      | E007          | ENCASH3         | 2016 | 5               | 5                      | 1                | 0                          | 1                          |
      | E008          | ENCASH5         | 2016 | 6               | 13                     | 0                | 0                          | 0                          |
      | E009          | ENCASHA         | 2016 | 0               | 12                     | 1                | 0                          | 0                          |
      | E009          | ENCASH5         | 2016 | 0               | 17                     | 3                | 0                          | 0                          |
      | E010          | NENCASH         | 2016 | 0               | 10                     | 0                | 0                          | 0                          |
      | E010          | ENCASH5         | 2016 | 0               | 21                     | 4                | 0                          | 0                          |
    Given user creates Leave Application
      | Leave Application No | Applicant | Leave Type | Duration Type | Date From  | Date To    | Submit |
      | LA001                | E001      | ENCASH5    | Full          | 13/05/2016 | 16/05/2016 | Y      |
      | LA002                | E002      | ENCASH5    | Full          | 20/07/2016 | 21/07/2016 | Y      |
    Given user approves Leave Application
      | Leave Application No |
      | LA001                |
      | LA002                |
    Given user updates Cessation Date for employees
      | EMPLOYEE_CODE | Cessaion Date |
      | E001          | 15/05/2016    |
      | E002          | 15/05/2016    |
      | E003          | 15/05/2016    |
      | E004          | 15/05/2016    |
      | E005          | 15/05/2016    |
      | E006          | 15/05/2016    |
      | E007          | 15/05/2016    |
      | E008          | 15/05/2016    |
      | E009          | 15/05/2016    |
      | E010          | 15/05/2016    |

  @leave_encashment_days_scenarios
  Scenario: Test Leave Encashment - Scenarios
    Given user runs query
      | SQL                                                                                                               |
      | UPDATE MODULE_CONFIG SET PROPERTY_VALUE = 2016 WHERE PROPERTY_NAME = 'currentYear' AND MODULE_CODE = 'GL'         |
      | UPDATE MODULE_CONFIG SET PROPERTY_VALUE = 5 WHERE PROPERTY_NAME = 'currentPeriod' AND MODULE_CODE = 'GL'          |
      | UPDATE MODULE_CONFIG SET PROPERTY_VALUE = 2016 WHERE PROPERTY_NAME = 'currentCalendarYear' AND MODULE_CODE = 'LV' |
      | UPDATE MODULE_CONFIG SET PROPERTY_VALUE = 99 WHERE PROPERTY_NAME = 'invalidFuturePeriod' AND MODULE_CODE = 'GL'   |
      | UPDATE MODULE_CONFIG SET PROPERTY_VALUE = 99 WHERE PROPERTY_NAME = 'invalidPriorPeriod' AND MODULE_CODE = 'GL'    |
    #Set 1
    Given Module Config is set
      | Parent Tab | Child Tab | Module Configuration              | Value                                                        | Type     |
      | Leave      |           | Prorate Leave Encashment          | By Months                                                    | DROPDOWN |
      | Leave      |           | Rounding of days for leave module | Round to 0.5 if equal to 0.5, round to 1 if greater than 0.5 | DROPDOWN |
    Given user runs query
      | SQL                                                                                                                                                                                                                                                     |
      | DELETE FROM PY_EMPLOYEE_PY_GEN WHERE EMPLOYEE_CODE IN ('E001','E002','E003','E004','E005','E006','E007','E008','E009','E010')                                                                                                                           |
      | update PY_PAYSLIP set PAYSLIP_VOUCHER_DATE = '2015-04-30 00:00:00', PAYSLIP_START_DATE = '2015-04-01 00:00:00', PAYSLIP_END_DATE = '2015-04-30 00:00:00' WHERE EMPLOYEE_CODE IN ('E001','E002','E003','E004','E005','E006','E007','E008','E009','E010') |
    When user generates payslip
      | Payroll Generation Voucher No | Payroll GL Posting Date | Year | Month | Payment Cycle Code | Payment Cycle No | Generate Payslip for advancement | Generate Payslip By       | EPC        | Submit |
      | PG001                         | 31/05/2016              | 2016 | 5     | EMONTHLY           | 1st              | N                                | Employee Payroll Category | EMONTHLY   | Y      |
      | PG002                         | 31/05/2016              | 2016 | 5     | EBIMONTHLY         | 1st              | N                                | Employee Payroll Category | EBIMONTHLY | Y      |
      | PG003                         | 31/05/2016              | 2016 | 5     | EBIMONTHLY         | 2nd              | N                                | Employee Payroll Category | EBIMONTHLY | Y      |
    And user pulls out data for Leave Encashment as "Set 1 - After Gen" follow "LV_Encash_SQLCheck.xls" on sheet "AfterGen"
      | Voucher No |
      | PG001      |
      | PG002      |
      | PG003      |
    And user submits payslip
      | Voucher No |
      | PG001      |
      | PG002      |
      | PG003      |
    And user pulls out data for Leave Encashment as "Set 1 - After Submit" follow "LV_Encash_SQLCheck.xls" on sheet "AfterSubmit"
      | Voucher No |
      | PG001      |
      | PG002      |
      | PG003      |

    #Set 2
    Given Module Config is set
      | Parent Tab | Child Tab | Module Configuration              | Value                                   | Type     |
      | Leave      |           | Prorate Leave Encashment          | By Months                               | DROPDOWN |
      | Leave      |           | Rounding of days for leave module | Round to 1 if equal or greater than 0.5 | DROPDOWN |
    Given user runs query
      | SQL                                                                                                                                                                                                                                                     |
      | DELETE FROM PY_EMPLOYEE_PY_GEN WHERE EMPLOYEE_CODE IN ('E001','E002','E003','E004','E005','E006','E007','E008','E009','E010')                                                                                                                           |
      | update PY_PAYSLIP set PAYSLIP_VOUCHER_DATE = '2015-04-30 00:00:00', PAYSLIP_START_DATE = '2015-04-01 00:00:00', PAYSLIP_END_DATE = '2015-04-30 00:00:00' WHERE EMPLOYEE_CODE IN ('E001','E002','E003','E004','E005','E006','E007','E008','E009','E010') |
    When user generates payslip
      | Payroll Generation Voucher No | Payroll GL Posting Date | Year | Month | Payment Cycle Code | Payment Cycle No | Generate Payslip for advancement | Generate Payslip By       | EPC        | Submit |
      | PG001                         | 31/05/2016              | 2016 | 5     | EMONTHLY           | 1st              | N                                | Employee Payroll Category | EMONTHLY   | Y      |
      | PG002                         | 31/05/2016              | 2016 | 5     | EBIMONTHLY         | 1st              | N                                | Employee Payroll Category | EBIMONTHLY | Y      |
      | PG003                         | 31/05/2016              | 2016 | 5     | EBIMONTHLY         | 2nd              | N                                | Employee Payroll Category | EBIMONTHLY | Y      |
    And user pulls out data for Leave Encashment as "Set 2 - After Gen" follow "LV_Encash_SQLCheck.xls" on sheet "AfterGen"
      | Voucher No |
      | PG001      |
      | PG002      |
      | PG003      |
    And user submits payslip
      | Voucher No |
      | PG001      |
      | PG002      |
      | PG003      |
    And user pulls out data for Leave Encashment as "Set 2 - After Submit" follow "LV_Encash_SQLCheck.xls" on sheet "AfterSubmit"
      | Voucher No |
      | PG001      |
      | PG002      |
      | PG003      |

    #Set 3
    Given Module Config is set
      | Parent Tab | Child Tab | Module Configuration              | Value                                                        | Type     |
      | Leave      |           | Prorate Leave Encashment          | By Calendar Days                                             | DROPDOWN |
      | Leave      |           | Rounding of days for leave module | Round to 0.5 if equal to 0.5, round to 1 if greater than 0.5 | DROPDOWN |
    Given user runs query
      | SQL                                                                                                                                                                                                                                                     |
      | DELETE FROM PY_EMPLOYEE_PY_GEN WHERE EMPLOYEE_CODE IN ('E001','E002','E003','E004','E005','E006','E007','E008','E009','E010')                                                                                                                           |
      | update PY_PAYSLIP set PAYSLIP_VOUCHER_DATE = '2015-04-30 00:00:00', PAYSLIP_START_DATE = '2015-04-01 00:00:00', PAYSLIP_END_DATE = '2015-04-30 00:00:00' WHERE EMPLOYEE_CODE IN ('E001','E002','E003','E004','E005','E006','E007','E008','E009','E010') |
    When user generates payslip
      | Payroll Generation Voucher No | Payroll GL Posting Date | Year | Month | Payment Cycle Code | Payment Cycle No | Generate Payslip for advancement | Generate Payslip By       | EPC        | Submit |
      | PG001                         | 31/05/2016              | 2016 | 5     | EMONTHLY           | 1st              | N                                | Employee Payroll Category | EMONTHLY   | Y      |
      | PG002                         | 31/05/2016              | 2016 | 5     | EBIMONTHLY         | 1st              | N                                | Employee Payroll Category | EBIMONTHLY | Y      |
      | PG003                         | 31/05/2016              | 2016 | 5     | EBIMONTHLY         | 2nd              | N                                | Employee Payroll Category | EBIMONTHLY | Y      |
    And user pulls out data for Leave Encashment as "Set 3 - After Gen" follow "LV_Encash_SQLCheck.xls" on sheet "AfterGen"
      | Voucher No |
      | PG001      |
      | PG002      |
      | PG003      |
    And user submits payslip
      | Voucher No |
      | PG001      |
      | PG002      |
      | PG003      |
    And user pulls out data for Leave Encashment as "Set 3 - After Submit" follow "LV_Encash_SQLCheck.xls" on sheet "AfterSubmit"
      | Voucher No |
      | PG001      |
      | PG002      |
      | PG003      |

    #Set 4
    Given Module Config is set
      | Parent Tab | Child Tab | Module Configuration              | Value                                   | Type     |
      | Leave      |           | Prorate Leave Encashment          | By Calendar Days                        | DROPDOWN |
      | Leave      |           | Rounding of days for leave module | Round to 1 if equal or greater than 0.5 | DROPDOWN |
    Given user runs query
      | SQL                                                                                                                                                                                                                                                     |
      | DELETE FROM PY_EMPLOYEE_PY_GEN WHERE EMPLOYEE_CODE IN ('E001','E002','E003','E004','E005','E006','E007','E008','E009','E010')                                                                                                                           |
      | update PY_PAYSLIP set PAYSLIP_VOUCHER_DATE = '2015-04-30 00:00:00', PAYSLIP_START_DATE = '2015-04-01 00:00:00', PAYSLIP_END_DATE = '2015-04-30 00:00:00' WHERE EMPLOYEE_CODE IN ('E001','E002','E003','E004','E005','E006','E007','E008','E009','E010') |
    When user generates payslip
      | Payroll Generation Voucher No | Payroll GL Posting Date | Year | Month | Payment Cycle Code | Payment Cycle No | Generate Payslip for advancement | Generate Payslip By       | EPC        | Submit |
      | PG001                         | 31/05/2016              | 2016 | 5     | EMONTHLY           | 1st              | N                                | Employee Payroll Category | EMONTHLY   | Y      |
      | PG002                         | 31/05/2016              | 2016 | 5     | EBIMONTHLY         | 1st              | N                                | Employee Payroll Category | EBIMONTHLY | Y      |
      | PG003                         | 31/05/2016              | 2016 | 5     | EBIMONTHLY         | 2nd              | N                                | Employee Payroll Category | EBIMONTHLY | Y      |
    And user pulls out data for Leave Encashment as "Set 4 - After Gen" follow "LV_Encash_SQLCheck.xls" on sheet "AfterGen"
      | Voucher No |
      | PG001      |
      | PG002      |
      | PG003      |
    And user submits payslip
      | Voucher No |
      | PG001      |
      | PG002      |
      | PG003      |
    And user pulls out data for Leave Encashment as "Set 4 - After Submit" follow "LV_Encash_SQLCheck.xls" on sheet "AfterSubmit"
      | Voucher No |
      | PG001      |
      | PG002      |
      | PG003      |

    #Set 5
    Given Module Config is set
      | Parent Tab | Child Tab | Module Configuration              | Value                                                        | Type     |
      | Leave      |           | Prorate Leave Encashment          | By Working Days                                              | DROPDOWN |
      | Leave      |           | Rounding of days for leave module | Round to 0.5 if equal to 0.5, round to 1 if greater than 0.5 | DROPDOWN |
    Given user runs query
      | SQL                                                                                                                                                                                                                                                     |
      | DELETE FROM PY_EMPLOYEE_PY_GEN WHERE EMPLOYEE_CODE IN ('E001','E002','E003','E004','E005','E006','E007','E008','E009','E010')                                                                                                                           |
      | update PY_PAYSLIP set PAYSLIP_VOUCHER_DATE = '2015-04-30 00:00:00', PAYSLIP_START_DATE = '2015-04-01 00:00:00', PAYSLIP_END_DATE = '2015-04-30 00:00:00' WHERE EMPLOYEE_CODE IN ('E001','E002','E003','E004','E005','E006','E007','E008','E009','E010') |
    When user generates payslip
      | Payroll Generation Voucher No | Payroll GL Posting Date | Year | Month | Payment Cycle Code | Payment Cycle No | Generate Payslip for advancement | Generate Payslip By       | EPC        | Submit |
      | PG001                         | 31/05/2016              | 2016 | 5     | EMONTHLY           | 1st              | N                                | Employee Payroll Category | EMONTHLY   | Y      |
      | PG002                         | 31/05/2016              | 2016 | 5     | EBIMONTHLY         | 1st              | N                                | Employee Payroll Category | EBIMONTHLY | Y      |
      | PG003                         | 31/05/2016              | 2016 | 5     | EBIMONTHLY         | 2nd              | N                                | Employee Payroll Category | EBIMONTHLY | Y      |
    And user pulls out data for Leave Encashment as "Set 5 - After Gen" follow "LV_Encash_SQLCheck.xls" on sheet "AfterGen"
      | Voucher No |
      | PG001      |
      | PG002      |
      | PG003      |
    And user submits payslip
      | Voucher No |
      | PG001      |
      | PG002      |
      | PG003      |
    And user pulls out data for Leave Encashment as "Set 5 - After Submit" follow "LV_Encash_SQLCheck.xls" on sheet "AfterSubmit"
      | Voucher No |
      | PG001      |
      | PG002      |
      | PG003      |

    #Set 6
    Given Module Config is set
      | Parent Tab | Child Tab | Module Configuration              | Value                                   | Type     |
      | Leave      |           | Prorate Leave Encashment          | By Working Days                         | DROPDOWN |
      | Leave      |           | Rounding of days for leave module | Round to 1 if equal or greater than 0.5 | DROPDOWN |
    Given user runs query
      | SQL                                                                                                                                                                                                                                                     |
      | DELETE FROM PY_EMPLOYEE_PY_GEN WHERE EMPLOYEE_CODE IN ('E001','E002','E003','E004','E005','E006','E007','E008','E009','E010')                                                                                                                           |
      | update PY_PAYSLIP set PAYSLIP_VOUCHER_DATE = '2015-04-30 00:00:00', PAYSLIP_START_DATE = '2015-04-01 00:00:00', PAYSLIP_END_DATE = '2015-04-30 00:00:00' WHERE EMPLOYEE_CODE IN ('E001','E002','E003','E004','E005','E006','E007','E008','E009','E010') |
    When user generates payslip
      | Payroll Generation Voucher No | Payroll GL Posting Date | Year | Month | Payment Cycle Code | Payment Cycle No | Generate Payslip for advancement | Generate Payslip By       | EPC        | Submit |
      | PG001                         | 31/05/2016              | 2016 | 5     | EMONTHLY           | 1st              | N                                | Employee Payroll Category | EMONTHLY   | Y      |
      | PG002                         | 31/05/2016              | 2016 | 5     | EBIMONTHLY         | 1st              | N                                | Employee Payroll Category | EBIMONTHLY | Y      |
      | PG003                         | 31/05/2016              | 2016 | 5     | EBIMONTHLY         | 2nd              | N                                | Employee Payroll Category | EBIMONTHLY | Y      |
    And user pulls out data for Leave Encashment as "Set 6 - After Gen" follow "LV_Encash_SQLCheck.xls" on sheet "AfterGen"
      | Voucher No |
      | PG001      |
      | PG002      |
      | PG003      |
    And user submits payslip
      | Voucher No |
      | PG001      |
      | PG002      |
      | PG003      |
    And user pulls out data for Leave Encashment as "Set 6 - After Submit" follow "LV_Encash_SQLCheck.xls" on sheet "AfterSubmit"
      | Voucher No |
      | PG001      |
      | PG002      |
      | PG003      |

    # Compare data
    Then user compares data for Leave Encashment with
      | Expected File                                          | Sheet                | Scenario Description    |
      | Leave_Encashment_Calendar_Days_Data_11_08_2016_EXP.xls | Set 1 - After Gen    | By Months, Round to 0.5 |
      | Leave_Encashment_Calendar_Days_Data_11_08_2016_EXP.xls | Set 1 - After Submit | By Months, Round to 1   |
      | Leave_Encashment_Calendar_Days_Data_11_08_2016_EXP.xls | Set 2 - After Gen    | By Months, Round to 0.5 |
      | Leave_Encashment_Calendar_Days_Data_11_08_2016_EXP.xls | Set 2 - After Submit | By Months, Round to 1   |
      | Leave_Encashment_Calendar_Days_Data_11_08_2016_EXP.xls | Set 3 - After Gen    | By Months, Round to 0.5 |
      | Leave_Encashment_Calendar_Days_Data_11_08_2016_EXP.xls | Set 3 - After Submit | By Months, Round to 1   |
      | Leave_Encashment_Calendar_Days_Data_11_08_2016_EXP.xls | Set 4 - After Gen    | By Months, Round to 0.5 |
      | Leave_Encashment_Calendar_Days_Data_11_08_2016_EXP.xls | Set 4 - After Submit | By Months, Round to 1   |
      | Leave_Encashment_Calendar_Days_Data_11_08_2016_EXP.xls | Set 5 - After Gen    | By Months, Round to 0.5 |
      | Leave_Encashment_Calendar_Days_Data_11_08_2016_EXP.xls | Set 5 - After Submit | By Months, Round to 1   |
      | Leave_Encashment_Calendar_Days_Data_11_08_2016_EXP.xls | Set 6 - After Gen    | By Months, Round to 0.5 |
      | Leave_Encashment_Calendar_Days_Data_11_08_2016_EXP.xls | Set 6 - After Submit | By Months, Round to 1   |