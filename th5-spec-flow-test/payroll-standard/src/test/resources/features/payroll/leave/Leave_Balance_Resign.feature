@leave_balance_resign_full
Feature: Test Leave Balance When Staff Resign

  Background:
    Given "emily" login to "(TRG7)" company with password is "taskhub"
    Given user access DB "jdbc:db2://172.18.0.10:50000/GENMAIN7" with id "db2admin" and password "Taskhub1"

  @leave_balance_resign_prepare_data
  Scenario: Test Leave Balance When Staff Resign - Prepare Data
    Given Payment Cycle is created as in             "LV_BalanceResign_PaymentCycle.xls"
    Given Employee Payroll Category is created as in "LV_BalanceResign_EPC.xls"
    Given Leave Type is created as in                "LV_BalanceResign_LeaveType.xls"
    Given Employee is created as in                  "LV_BalanceResign_Employee.xls"
    Given LV_EMP_LEAVE_TYPE is updated
      | EMPLOYEE_CODE | LEAVE_TYPE_CODE | YEAR | CARRIED_FORWARD | TOTAL_ENTITLEMENT_DAYS | LEAVE_DAYS_TAKEN | LEAVE_DAYS_TAKEN_NEXT_YEAR | LEAVE_DAYS_TAKEN_LAST_YEAR | CARRIED_FORWARD_UTILIZATION_LIMIT | ENTITLEMENT_UTILIZATION_LIMIT | TOTAL_UTILIZATION_LIMIT |
      | JOHN_RESN     | RESN_V          | 2016 | 5               | 15                     | 15               |                            |                            | 5                                 | 15                            | 20                      |
      | ALEX_RESN     | RESN_NV         | 2016 | 5               | 15                     |                  |                            |                            | 5                                 | 15                            | 20                      |
      | BEN_RESN      | RESN_V          | 2016 | 5               | 15                     |                  |                            |                            | 5                                 | 15                            | 20                      |
    # clear CF for BEN
    Given user creates Leave Application
      | Leave Application No | Applicant | Leave Type | Duration Type | Date From  | Date To    | Submit |
      | LA007                | BEN_RESN  | RESN_V     | Full          | 04/01/2016 | 08/01/2016 | Y      |
    Given user approves Leave Application
      | Leave Application No |
      | LA007                |
    Given user creates Leave Application
      | Leave Application No | Applicant | Leave Type | Duration Type | Date From  | Date To    | Submit |
      | LA001                | ALEX_RESN | RESN_NV    | Full          | 04/01/2016 | 08/01/2016 | Y      |
      | LA002                | ALEX_RESN | RESN_NV    | Full          | 07/03/2016 | 14/03/2016 | Y      |
      | LA003                | ALEX_RESN | RESN_NV    | Full          | 18/04/2016 | 22/04/2016 | Y      |
      | LA004                | ALEX_RESN | RESN_NV    | Full          | 11/05/2016 | 12/05/2016 | Y      |
      | LA005                | ALEX_RESN | RESN_NV    | Full          | 15/06/2016 | 15/06/2016 | Y      |
      | LA006                | ALEX_RESN | RESN_NV    | Full          | 08/08/2016 | 08/08/2016 | Y      |
      | LA008                | BEN_RESN  | RESN_V     | Full          | 07/03/2016 | 12/03/2016 | Y      |
      | LA009                | BEN_RESN  | RESN_V     | Full          | 18/04/2016 | 22/04/2016 | Y      |
      | LA010                | BEN_RESN  | RESN_V     | Full          | 11/05/2016 | 12/05/2016 | Y      |
      | LA011                | BEN_RESN  | RESN_V     | Full          | 15/06/2016 | 15/06/2016 | Y      |
      | LA012                | BEN_RESN  | RESN_V     | Full          | 14/12/2016 | 14/12/2016 | Y      |
    Given user approves Leave Application
      | Leave Application No |
      | LA001                |
      | LA002                |
      | LA003                |
      | LA004                |
      | LA005                |
      | LA006                |
      | LA008                |
      | LA009                |
      | LA010                |
      | LA011                |
      | LA012                |
    Given user updates Cessation Date for employees
      | Employee Code | Cessation Date |
      | JOHN_RESN     | 16/07/2016     |
      | ALEX_RESN     | 16/07/2016     |
      | BEN_RESN      | 25/11/2016     |

  @leave_balance_resign_scenarios
  Scenario: Test Leave Balance - Scenarios
    Given user runs query
      | SQL                                                                                                               |
      | UPDATE MODULE_CONFIG SET PROPERTY_VALUE = 2016 WHERE PROPERTY_NAME = 'currentYear'         AND MODULE_CODE = 'GL' |
      | UPDATE MODULE_CONFIG SET PROPERTY_VALUE = 7    WHERE PROPERTY_NAME = 'currentPeriod'       AND MODULE_CODE = 'GL' |
      | UPDATE MODULE_CONFIG SET PROPERTY_VALUE = 2016 WHERE PROPERTY_NAME = 'currentCalendarYear' AND MODULE_CODE = 'LV' |
      | UPDATE MODULE_CONFIG SET PROPERTY_VALUE = 99   WHERE PROPERTY_NAME = 'invalidFuturePeriod' AND MODULE_CODE = 'GL' |
      | UPDATE MODULE_CONFIG SET PROPERTY_VALUE = 99   WHERE PROPERTY_NAME = 'invalidPriorPeriod'  AND MODULE_CODE = 'GL' |

    # Set 1
    Given Module Config is set
      | Parent Tab | Child Tab | Module Configuration             | Value     | Type     |
      | Leave      |           | Unpaid Leave Type Calculation    | Pay Run   | DROPDOWN |
      | Leave      |           | Prorate Earned Leave Entitlement | By Months | DROPDOWN |
    Given user runs query
      | SQL                                                                                                                                                                                                                  |
      | DELETE FROM PY_EMPLOYEE_PY_GEN WHERE EMPLOYEE_CODE IN ('JOHN_RESN','ALEX_RESN','BEN_RESN')                                                                                                                           |
      | update PY_PAYSLIP set PAYSLIP_VOUCHER_DATE = '2015-04-30 00:00:00', PAYSLIP_START_DATE = '2015-04-01 00:00:00', PAYSLIP_END_DATE = '2015-04-30 00:00:00' WHERE EMPLOYEE_CODE IN ('JOHN_RESN','ALEX_RESN','BEN_RESN') |
    When user generates payslip
      | Payroll Generation Voucher No | Payroll GL Posting Date | Year | Month | Payment Cycle Code | Payment Cycle No | Generate Payslip By     | Employee Code | Submit |
      | PG001                         | 31/07/2016              | 2016 | 7     | RESIGNMO           | 1st              | Employee (Basic Salary) | JOHN_RESN     |        |
      |                               |                         |      |       |                    |                  |                         | ALEX_RESN     | Y      |
      | PG002                         | 30/11/2016              | 2016 | 11    | RESIGNMOBI         | 1st              | Employee (Basic Salary) | BEN_RESN      | Y      |
      | PG003                         | 30/11/2016              | 2016 | 11    | RESIGNMOBI         | 2nd              | Employee (Basic Salary) | BEN_RESN      | Y      |
    And user pulls out data for Leave Balance Resign as "Set 1 - After Gen" follow "LV_BalanceResign_SQLCheck.xls" on sheet "AfterGen"
      | Voucher No |
      | PG001      |
      | PG002      |
      | PG003      |
    And user submits payslip
      | Voucher No |
      | PG001      |
      | PG002      |
      | PG003      |
    And user pulls out data for Leave Balance Resign as "Set 1 - After Submit" follow "LV_BalanceResign_SQLCheck.xls" on sheet "AfterSubmit"
      | Voucher No |
      | PG001      |
      | PG002      |
      | PG003      |

    # Set 2
    Given Module Config is set
      | Parent Tab | Child Tab | Module Configuration             | Value            | Type     |
      | Leave      |           | Unpaid Leave Type Calculation    | Pay Run          | DROPDOWN |
      | Leave      |           | Prorate Earned Leave Entitlement | By Calendar Days | DROPDOWN |
    Given user runs query
      | SQL                                                                                                                                                                                                                  |
      | DELETE FROM PY_EMPLOYEE_PY_GEN WHERE EMPLOYEE_CODE IN ('JOHN_RESN','ALEX_RESN','BEN_RESN')                                                                                                                           |
      | update PY_PAYSLIP set PAYSLIP_VOUCHER_DATE = '2015-04-30 00:00:00', PAYSLIP_START_DATE = '2015-04-01 00:00:00', PAYSLIP_END_DATE = '2015-04-30 00:00:00' WHERE EMPLOYEE_CODE IN ('JOHN_RESN','ALEX_RESN','BEN_RESN') |
    When user generates payslip
      | Payroll Generation Voucher No | Payroll GL Posting Date | Year | Month | Payment Cycle Code | Payment Cycle No | Generate Payslip By     | Employee Code | Submit |
      | PG001                         | 31/07/2016              | 2016 | 7     | RESIGNMO           | 1st              | Employee (Basic Salary) | JOHN_RESN     |        |
      |                               |                         |      |       |                    |                  |                         | ALEX_RESN     | Y      |
      | PG002                         | 30/11/2016              | 2016 | 11    | RESIGNMOBI         | 1st              | Employee (Basic Salary) | BEN_RESN      | Y      |
      | PG003                         | 30/11/2016              | 2016 | 11    | RESIGNMOBI         | 2nd              | Employee (Basic Salary) | BEN_RESN      | Y      |
    And user pulls out data for Leave Balance Resign as "Set 2 - After Gen" follow "LV_BalanceResign_SQLCheck.xls" on sheet "AfterGen"
      | Voucher No |
      | PG001      |
      | PG002      |
      | PG003      |
    And user submits payslip
      | Voucher No |
      | PG001      |
      | PG002      |
      | PG003      |
    And user pulls out data for Leave Balance Resign as "Set 2 - After Submit" follow "LV_BalanceResign_SQLCheck.xls" on sheet "AfterSubmit"
      | Voucher No |
      | PG001      |
      | PG002      |
      | PG003      |

    # Set 3
    Given Module Config is set
      | Parent Tab | Child Tab | Module Configuration             | Value     | Type     |
      | Leave      |           | Unpaid Leave Type Calculation    | Daily     | DROPDOWN |
      | Leave      |           | Prorate Earned Leave Entitlement | By Months | DROPDOWN |
    Given user runs query
      | SQL                                                                                                                                                                                                                  |
      | DELETE FROM PY_EMPLOYEE_PY_GEN WHERE EMPLOYEE_CODE IN ('JOHN_RESN','ALEX_RESN','BEN_RESN')                                                                                                                           |
      | update PY_PAYSLIP set PAYSLIP_VOUCHER_DATE = '2015-04-30 00:00:00', PAYSLIP_START_DATE = '2015-04-01 00:00:00', PAYSLIP_END_DATE = '2015-04-30 00:00:00' WHERE EMPLOYEE_CODE IN ('JOHN_RESN','ALEX_RESN','BEN_RESN') |
    When user generates payslip
      | Payroll Generation Voucher No | Payroll GL Posting Date | Year | Month | Payment Cycle Code | Payment Cycle No | Generate Payslip By     | Employee Code | Submit |
      | PG001                         | 31/07/2016              | 2016 | 7     | RESIGNMO           | 1st              | Employee (Basic Salary) | JOHN_RESN     |        |
      |                               |                         |      |       |                    |                  |                         | ALEX_RESN     | Y      |
      | PG002                         | 30/11/2016              | 2016 | 11    | RESIGNMOBI         | 1st              | Employee (Basic Salary) | BEN_RESN      | Y      |
      | PG003                         | 30/11/2016              | 2016 | 11    | RESIGNMOBI         | 2nd              | Employee (Basic Salary) | BEN_RESN      | Y      |
    And user pulls out data for Leave Balance Resign as "Set 3 - After Gen" follow "LV_BalanceResign_SQLCheck.xls" on sheet "AfterGen"
      | Voucher No |
      | PG001      |
      | PG002      |
      | PG003      |
    And user submits payslip
      | Voucher No |
      | PG001      |
      | PG002      |
      | PG003      |
    And user pulls out data for Leave Balance Resign as "Set 3 - After Submit" follow "LV_BalanceResign_SQLCheck.xls" on sheet "AfterSubmit"
      | Voucher No |
      | PG001      |
      | PG002      |
      | PG003      |

    # Set 4
    Given Module Config is set
      | Parent Tab | Child Tab | Module Configuration             | Value            | Type     |
      | Leave      |           | Unpaid Leave Type Calculation    | Daily            | DROPDOWN |
      | Leave      |           | Prorate Earned Leave Entitlement | By Calendar Days | DROPDOWN |
    Given user runs query
      | SQL                                                                                                                                                                                                                  |
      | DELETE FROM PY_EMPLOYEE_PY_GEN WHERE EMPLOYEE_CODE IN ('JOHN_RESN','ALEX_RESN','BEN_RESN')                                                                                                                           |
      | update PY_PAYSLIP set PAYSLIP_VOUCHER_DATE = '2015-04-30 00:00:00', PAYSLIP_START_DATE = '2015-04-01 00:00:00', PAYSLIP_END_DATE = '2015-04-30 00:00:00' WHERE EMPLOYEE_CODE IN ('JOHN_RESN','ALEX_RESN','BEN_RESN') |
    When user generates payslip
      | Payroll Generation Voucher No | Payroll GL Posting Date | Year | Month | Payment Cycle Code | Payment Cycle No | Generate Payslip By     | Employee Code | Submit |
      | PG001                         | 31/07/2016              | 2016 | 7     | RESIGNMO           | 1st              | Employee (Basic Salary) | JOHN_RESN     |        |
      |                               |                         |      |       |                    |                  |                         | ALEX_RESN     | Y      |
      | PG002                         | 30/11/2016              | 2016 | 11    | RESIGNMOBI         | 1st              | Employee (Basic Salary) | BEN_RESN      | Y      |
      | PG003                         | 30/11/2016              | 2016 | 11    | RESIGNMOBI         | 2nd              | Employee (Basic Salary) | BEN_RESN      | Y      |
    And user pulls out data for Leave Balance Resign as "Set 4 - After Gen" follow "LV_BalanceResign_SQLCheck.xls" on sheet "AfterGen"
      | Voucher No |
      | PG001      |
      | PG002      |
      | PG003      |
    And user submits payslip
      | Voucher No |
      | PG001      |
      | PG002      |
      | PG003      |
    And user pulls out data for Leave Balance Resign as "Set 4 - After Submit" follow "LV_BalanceResign_SQLCheck.xls" on sheet "AfterSubmit"
      | Voucher No |
      | PG001      |
      | PG002      |
      | PG003      |

    Then user compares data for Leave Balance Resign with
      | Expected File | Sheet | Scenario Description |