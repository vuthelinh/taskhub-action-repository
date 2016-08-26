@leave_application_full
Feature: Test Leave Application - New Scenarios

  Background: Setup
    Given "emily" login to "(TRG7)" company with password is "taskhub"
    Given user access DB "jdbc:db2://172.18.0.10:50000/GENMAIN7" with id "db2admin" and password "Taskhub1"

  @leave_application_pre_data
  Scenario: Test Leave Application
    Given Payment Cycle is created as in             "LV_APP_PaymentCycle.xls"
    Given Employee Payroll Category is created as in "LV_APP_EPC.xls"
    Given Leave Type is created as in                "LV_APP_LeaveType.xls"
    Given Employee is created as in                  "LV_APP_Employee.xls"
    Given Migrate: Country is set up as in           "LV_APP_Country.xls"
    Given Approving Officer is set up
      | Transaction             | Approving Method                        | Approving Officer |
      | Leave Application (TH5) | By Approving Officer (1 Level by Value) | Emily             |
      |                         |                                         | Rachel            |
      | Leave Cancellation      | By Approving Officer (1 Level by Value) | Emily             |
      |                         |                                         | Rachel            |
    Given LV_EMP_LEAVE_TYPE is updated
      | EMPLOYEE_CODE | LEAVE_TYPE_CODE | YEAR | CARRIED_FORWARD | TOTAL_ENTITLEMENT_DAYS | LEAVE_DAYS_TAKEN | LEAVE_DAYS_TAKEN_NEXT_YEAR | LEAVE_DAYS_TAKEN_LAST_YEAR |
      | ALAN          | ANNUAL          | 2016 | 5               | 18                     |                  |                            |                            |
      | ALAN          | MC              | 2016 |                 | 10                     |                  |                            |                            |
      | MARRY         | ANNUAL          | 2016 | 3               | 13                     |                  |                            |                            |
      | MARRY         | MC              | 2016 |                 | 10                     |                  |                            |                            |
      | MARRY         | MATERNITY       | 2016 |                 | 90                     |                  |                            |                            |
      | MIA           | ANNUAL          | 2016 |                 | 7.5                    |                  |                            |                            |
      | MIA           | MC              | 2016 |                 | 10                     |                  |                            |                            |
      | ALAN          | ANNUAL          | 2017 |                 | 19                     |                  |                            |                            |
      | MARRY         | ANNUAL          | 2017 |                 | 14                     |                  |                            |                            |
      | MIA           | ANNUAL          | 2017 |                 | 9                      |                  |                            |                            |

  @leave_application_scenario
  Scenario: Leave Application Scenarios

    # Scenario 1: Employee takes half, 1, n days over Half, Off, PH and across months
    Given Module Config is set
      | Parent Tab | Child Tab | Module Configuration              | Value                                                        | Type     |
      | Leave      |           | Prorate Earned Leave Entitlement  | By Months                                                    | DROPDOWN |
      | Leave      |           | Rounding of days for leave module | Round to 0.5 if equal to 0.5, round to 1 if greater than 0.5 | DROPDOWN |
    When user creates Leave Application
      | Leave Application No | Applicant | Leave Type | Duration Type | Date From  | Date To    | Submit |
      | LA001                | ALAN      | ANNUAL     | PM            | 03/03/2016 | 03/03/2016 | Y      |
      | LA002                | ALAN      | ANNUAL     | Full          | 04/03/2016 | 04/03/2016 | Y      |
      | LA003                | ALAN      | ANNUAL     | AM            | 05/03/2016 | 05/03/2016 | Y      |
      | LA004                | ALAN      | MC         | AM            | 12/03/2016 | 12/03/2016 | Y      |
      | LA005                | ALAN      | MC         |               | 18/03/2016 | 21/03/2016 | Y      |
      | LA006                | MIA       | ANNUAL     |               | 29/04/2016 | 02/05/2016 | Y      |
      | LA007                | MARRY     | MATERNITY  |               | 29/2/2016  | 02/05/2016 | Y      |
    When user approves Leave Application
      | Leave Application No |
      | LA001                |
      | LA002                |
      | LA003                |
      | LA004                |
      | LA005                |
      | LA006                |
      | LA007                |
    Then user pulls out data for Leave Application as "Scenario 1 - Round to 0.5" follow "LV_APP_SQLCheck.xls" on sheet "Dataset"
      | Voucher No |
      | LA001      |
      | LA002      |
      | LA003      |
      | LA004      |
      | LA005      |
      | LA006      |
      | LA007      |

    Given Module Config is set
      | Parent Tab | Child Tab | Module Configuration              | Value                                                        | Type     |
      | Leave      |           | Prorate Earned Leave Entitlement  | By Months                                                    | DROPDOWN |
      | Leave      |           | Rounding of days for leave module | Round to 0.5 if equal to 0.5, round to 1 if greater than 0.5 | DROPDOWN |
    When user creates Leave Application
      | Leave Application No | Applicant | Leave Type | Duration Type | Date From  | Date To    | Submit |
      | LA001                | ALAN      | ANNUAL     | PM            | 03/03/2016 | 03/03/2016 | Y      |
      | LA002                | ALAN      | ANNUAL     | Full          | 04/03/2016 | 04/03/2016 | Y      |
      | LA003                | ALAN      | ANNUAL     | AM            | 05/03/2016 | 05/03/2016 | Y      |
      | LA004                | ALAN      | MC         | AM            | 12/03/2016 | 12/03/2016 | Y      |
      | LA005                | ALAN      | MC         |               | 18/03/2016 | 21/03/2016 | Y      |
      | LA006                | MIA       | ANNUAL     |               | 29/04/2016 | 02/05/2016 | Y      |
      | LA007                | MARRY     | MATERNITY  |               | 29/2/2016  | 02/05/2016 | Y      |
    Then user pulls out data for Leave Application as "Scenario 1" follow "LV_APP_SQLCheck.xls" on sheet "Dataset"
      | Voucher No |
      | LA001      |
      | LA002      |
      | LA003      |
      | LA004      |
      | LA005      |
      | LA006      |
      | LA007      |

    # Scenario 2: Employee takes leave across CF Validity



    #Set 2
    Given Module Config is set
      | Parent Tab | Child Tab | Module Configuration              | Value                                   | Type     |
      | Leave      |           | Prorate Earned Leave Entitlement  | By Calendar Days                        | DROPDOWN |
      | Leave      |           | Rounding of days for leave module | Round to 1 if equal or greater than 0.5 | DROPDOWN |
