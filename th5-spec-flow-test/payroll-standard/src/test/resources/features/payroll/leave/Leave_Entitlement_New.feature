@leave_entitlement_full
Feature: Test Leave Entitlement - New Scenarios

  Background: Setup
    Given "emily" login to "(TRG7)" company with password is "taskhub"
    Given user access DB "jdbc:db2://172.18.0.10:50000/GENMAIN7" with id "db2admin" and password "Taskhub1"

  @leave_entitlement_pre_data
  Scenario: Test Leave Entitlement - Prepare Data
    Given Payment Cycle is created as in             "LV_ENT_PaymentCycle.xls"
    Given Employee Payroll Category is created as in "LV_ENT_EPC.xls"
    Given Leave Type is created as in                "LV_ENT_LeaveType.xls"
    Given Employee Grade is created as in            "LV_ENT_EmployeeGrade.xls"
    Given Employee is created as in                  "LV_ENT_Employee.xls"

  @leave_entitlement_scenario
  Scenario: Test Leave Entitlement - New Scenarios

    # clear leave ent
    Given user runs query
      | SQL                                                                                                                                                                                                                                                        |
      | DELETE FROM LV_EMP_LEAVE_TYPE WHERE EMPLOYEE_CODE IN ('LE_EMP001', 'LE_EMP002', 'LE_EMP003', 'LE_EMP004', 'LE_EMP005', 'LE_EMP001Y', 'LE_EMP002Y', 'LE_EMP003Y', 'LE_EMP004Y', 'LE_EMP005Y')                                                               |
      | DELETE FROM LV_ENTITLEMENT_LV_TYPE_EMP WHERE EMPLOYEE_CODE IN ('LE_EMP001', 'LE_EMP002', 'LE_EMP003', 'LE_EMP004', 'LE_EMP005', 'LE_EMP001Y', 'LE_EMP002Y', 'LE_EMP003Y', 'LE_EMP004Y', 'LE_EMP005Y')                                                      |
      | DELETE FROM LV_ENTITLEMENT WHERE LEAVE_TYPE_CODE IN ('PROENT', 'NPROENT') OR EMPLOYEE_CODE IN ('LE_EMP001', 'LE_EMP002', 'LE_EMP003', 'LE_EMP004', 'LE_EMP005', 'LE_EMP001Y', 'LE_EMP002Y', 'LE_EMP003Y', 'LE_EMP004Y', 'LE_EMP005Y')                      |
      | delete from MT_EMP_HR_EMP_GRADE where GRADE_CODE = 'GRADE2_YOS' and EMPLOYEE_CODE in ('LE_EMP001Y', 'LE_EMP002Y', 'LE_EMP003Y', 'LE_EMP004Y')                                                                                                              |
      | delete from MT_EMP_HR_EMP_GRADE where GRADE_CODE = 'GRADE1_YOS' and EMPLOYEE_CODE in ('LE_EMP005Y')                                                                                                                                                        |
      | delete from MT_EMP_HR_EMP_GRADE where GRADE_CODE = 'GRADE2_AI' and EMPLOYEE_CODE in ('LE_EMP001', 'LE_EMP002', 'LE_EMP003', 'LE_EMP004')                                                                                                                   |
      | delete from MT_EMP_HR_EMP_GRADE where GRADE_CODE = 'GRADE1_AI' and EMPLOYEE_CODE in ('LE_EMP005')                                                                                                                                                          |
      | update MT_EMP_HR_EMP_GRADE set EFFECTIVE_DATE_FROM = '2014-01-01', EFFECTIVE_DATE_TO = NULL WHERE EMPLOYEE_CODE IN ('LE_EMP001', 'LE_EMP002', 'LE_EMP003', 'LE_EMP004', 'LE_EMP005', 'LE_EMP001Y', 'LE_EMP002Y', 'LE_EMP003Y', 'LE_EMP004Y', 'LE_EMP005Y') |

    # Set 1
    Given Module Config is set
      | Parent Tab | Child Tab | Module Configuration               | Value                                   | Type     |
      | Leave      |           | Prorate Expected Leave Entitlement | By Months                               | DROPDOWN |
      | Leave      |           | Rounding of days for leave module  | Round to 1 if equal or greater than 0.5 | DROPDOWN |

#  Annual Increment
#  AI _ Scenario 1: Leave Entitlement by Leave Type, Adjustment Type = Add
    Given Leave Entitlement by Employee is created
      | Voucher No | Voucher Type | Voucher Date | Year | Employee Code | Default Adjustment Type | Leave Type | No of Days | Submit |
      | LE003      | By Employee  | 31/7/2016    | 2016 | LE_EMP001     | Add                     | PROENT     | 4          |        |
      |            |              |              |      |               |                         | NPROENT    | 4          | Y      |
    Given Leave Entitlement by Leave Type is created
      | Voucher No | Voucher Type  | Voucher Date | Year | Leave Type | Default Adjustment Type | Default No of Days | Employee Code | No of Days                     | Submit |
      | LE001      | By Leave Type | 31/7/2016    | 2016 | PROENT     | Add                     | 1                  | LE_EMP001     | Expected Leave Entitlement - 2 |        |
      |            |               |              |      |            |                         |                    | LE_EMP002     | Expected Leave Entitlement - 2 |        |
      |            |               |              |      |            |                         |                    | LE_EMP003     | Expected Leave Entitlement - 2 |        |
      |            |               |              |      |            |                         |                    | LE_EMP004     | Expected Leave Entitlement - 2 |        |
      |            |               |              |      |            |                         |                    | LE_EMP005     | Expected Leave Entitlement - 2 | Y      |
      | LE002      | By Leave Type | 31/7/2016    | 2016 | NPROENT    | Add                     | 1                  | LE_EMP001     | Expected Leave Entitlement - 2 |        |
      |            |               |              |      |            |                         |                    | LE_EMP002     | Expected Leave Entitlement - 2 |        |
      |            |               |              |      |            |                         |                    | LE_EMP003     | Expected Leave Entitlement - 2 |        |
      |            |               |              |      |            |                         |                    | LE_EMP004     | Expected Leave Entitlement - 2 |        |
      |            |               |              |      |            |                         |                    | LE_EMP005     | Expected Leave Entitlement - 2 | Y      |
    Then user pulls out data for Leave Entitlement as "AI-Scenario 1" follow "LV_ENT_SQLCheck.xls" on sheet "LE"
      | Voucher No |
      | LE001      |
      | LE002      |
    Then user pulls out data for Leave Entitlement as "AI-Scenario 1" follow "LV_ENT_SQLCheck.xls" on sheet "EMP"
      | Condition Code |
      | LE_EMP001      |
      | LE_EMP002      |
      | LE_EMP003      |
      | LE_EMP004      |
      | LE_EMP005      |

#  AI _ Scenario 2: Leave Entitlement by Employee, Adjustment Type = Add
    Given Leave Entitlement by Employee is created
      | Voucher No | Voucher Type | Voucher Date | Year | Employee Code | Default Adjustment Type | Leave Type | No of Days | Submit |
      | LE003      | By Employee  | 31/7/2016    | 2016 | LE_EMP001     | Add                     | PROENT     | 4          |        |
      |            |              |              |      |               |                         | NPROENT    | 4          | Y      |
      | LE004      | By Employee  | 31/7/2016    | 2016 | LE_EMP002     | Add                     | PROENT     | 4          |        |
      |            |              |              |      |               |                         | NPROENT    | 4          | Y      |
      | LE005      | By Employee  | 31/7/2016    | 2016 | LE_EMP003     | Add                     | PROENT     | 4          |        |
      |            |              |              |      |               |                         | NPROENT    | 4          | Y      |
      | LE006      | By Employee  | 31/7/2016    | 2016 | LE_EMP004     | Add                     | PROENT     | 4          |        |
      |            |              |              |      |               |                         | NPROENT    | 4          | Y      |
      | LE007      | By Employee  | 31/7/2016    | 2016 | LE_EMP005     | Add                     | PROENT     | 4          |        |
      |            |              |              |      |               |                         | NPROENT    | 4          | Y      |
    Then user pulls out data for Leave Entitlement as "AI-Scenario 2" follow "LV_ENT_SQLCheck.xls" on sheet "LE"
      | Voucher No |
      | LE003      |
      | LE004      |
      | LE005      |
      | LE006      |
      | LE007      |
    Then user pulls out data for Leave Entitlement as "AI-Scenario 2" follow "LV_ENT_SQLCheck.xls" on sheet "EMP"
      | Condition Code |
      | LE_EMP001      |
      | LE_EMP002      |
      | LE_EMP003      |
      | LE_EMP004      |
      | LE_EMP005      |

#  AI _ Scenario 3: Leave Entitlement by Leave Type, Adjustment Type = Reduce
    Given Leave Entitlement by Leave Type is created
      | Voucher No | Voucher Type  | Voucher Date | Year | Leave Type | Default Adjustment Type | Default No of Days | Employee Code | No of Days | Submit |
      | LE008      | By Leave Type | 31/7/2016    | 2016 | PROENT     | Reduce                  | 1                  | LE_EMP001     | 2          |        |
      |            |               |              |      |            |                         |                    | LE_EMP002     | 2          |        |
      |            |               |              |      |            |                         |                    | LE_EMP003     | 2          |        |
      |            |               |              |      |            |                         |                    | LE_EMP004     | 2          |        |
      |            |               |              |      |            |                         |                    | LE_EMP005     | 2          | Y      |
      | LE009      | By Leave Type | 31/7/2016    | 2016 | NPROENT    | Reduce                  | 1                  | LE_EMP001     | 2          |        |
      |            |               |              |      |            |                         |                    | LE_EMP002     | 2          |        |
      |            |               |              |      |            |                         |                    | LE_EMP003     | 2          |        |
      |            |               |              |      |            |                         |                    | LE_EMP004     | 2          |        |
      |            |               |              |      |            |                         |                    | LE_EMP005     | 2          | Y      |
    Then user pulls out data for Leave Entitlement as "AI-Scenario 3" follow "LV_ENT_SQLCheck.xls" on sheet "LE"
      | Voucher No |
      | LE008      |
      | LE009      |
    Then user pulls out data for Leave Entitlement as "AI-Scenario 3" follow "LV_ENT_SQLCheck.xls" on sheet "EMP"
      | Condition Code |
      | LE_EMP001      |
      | LE_EMP002      |
      | LE_EMP003      |
      | LE_EMP004      |
      | LE_EMP005      |

#  AI _ Scenario 4: Leave Entitlement by Employee, Adjustment Type = Reduce
    Given Leave Entitlement by Employee is created
      | Voucher No | Voucher Type | Voucher Date | Year | Employee Code | Default Adjustment Type | Leave Type | No of Days | Submit |
      | LE010      | By Employee  | 31/7/2016    | 2016 | LE_EMP001     | Reduce                  | PROENT     | 2          |        |
      |            |              |              |      |               |                         | NPROENT    | 2          | Y      |
      | LE011      | By Employee  | 31/7/2016    | 2016 | LE_EMP002     | Reduce                  | PROENT     | 2          |        |
      |            |              |              |      |               |                         | NPROENT    | 2          | Y      |
      | LE012      | By Employee  | 31/7/2016    | 2016 | LE_EMP003     | Reduce                  | PROENT     | 2          |        |
      |            |              |              |      |               |                         | NPROENT    | 2          | Y      |
      | LE013      | By Employee  | 31/7/2016    | 2016 | LE_EMP004     | Reduce                  | PROENT     | 2          |        |
      |            |              |              |      |               |                         | NPROENT    | 2          | Y      |
      | LE014      | By Employee  | 31/7/2016    | 2016 | LE_EMP005     | Reduce                  | PROENT     | 2          |        |
      |            |              |              |      |               |                         | NPROENT    | 2          | Y      |
    Then user pulls out data for Leave Entitlement as "AI-Scenario 4" follow "LV_ENT_SQLCheck.xls" on sheet "LE"
      | Voucher No |
      | LE010      |
      | LE011      |
      | LE012      |
      | LE013      |
      | LE014      |
    Then user pulls out data for Leave Entitlement as "AI-Scenario 4" follow "LV_ENT_SQLCheck.xls" on sheet "EMP"
      | Condition Code |
      | LE_EMP001      |
      | LE_EMP002      |
      | LE_EMP003      |
      | LE_EMP004      |
      | LE_EMP005      |

#  AI _ Scenario 5: Leave Entitlement by Leave Type, Adjustment Type = Add, there's a change in employee's Grade at mid-year
    Given user updates Grade
      | Employee Code | Effective Date From | Grade     |
      | LE_EMP001     | 1/8/2016            | GRADE2_AI |
      | LE_EMP002     | 1/8/2016            | GRADE2_AI |
      | LE_EMP003     | 1/8/2016            | GRADE2_AI |
      | LE_EMP004     | 1/8/2016            | GRADE2_AI |
      | LE_EMP005     | 1/8/2016            | GRADE1_AI |
    Given Leave Entitlement by Leave Type is created
      | Voucher No | Voucher Type  | Voucher Date | Year | Leave Type | Default Adjustment Type | Default No of Days | Employee Code | No of Days                     | Submit |
      | LE015      | By Leave Type | 1/8/2016     | 2016 | PROENT     | Add                     | 1                  | LE_EMP001     | Expected Leave Entitlement - 4 |        |
      |            |               |              |      |            |                         |                    | LE_EMP002     | Expected Leave Entitlement - 4 |        |
      |            |               |              |      |            |                         |                    | LE_EMP003     | Expected Leave Entitlement - 4 |        |
      |            |               |              |      |            |                         |                    | LE_EMP004     | Expected Leave Entitlement - 4 |        |
      |            |               |              |      |            |                         |                    | LE_EMP005     | Expected Leave Entitlement - 4 | Y      |
      | LE016      | By Leave Type | 1/8/2016     | 2016 | NPROENT    | Add                     | 1                  | LE_EMP001     | Expected Leave Entitlement - 4 |        |
      |            |               |              |      |            |                         |                    | LE_EMP002     | Expected Leave Entitlement - 4 |        |
      |            |               |              |      |            |                         |                    | LE_EMP003     | Expected Leave Entitlement - 4 |        |
      |            |               |              |      |            |                         |                    | LE_EMP004     | Expected Leave Entitlement - 4 |        |
      |            |               |              |      |            |                         |                    | LE_EMP005     | Expected Leave Entitlement - 4 | Y      |
    Then user pulls out data for Leave Entitlement as "AI-Scenario 5" follow "LV_ENT_SQLCheck.xls" on sheet "LE"
      | Voucher No |
      | LE015      |
      | LE016      |
    Then user pulls out data for Leave Entitlement as "AI-Scenario 5" follow "LV_ENT_SQLCheck.xls" on sheet "EMP"
      | Condition Code |
      | LE_EMP001      |
      | LE_EMP002      |
      | LE_EMP003      |
      | LE_EMP004      |
      | LE_EMP005      |

#  AI _ Scenario 6: Leave Entitlement by Employee, Adjustment Type = Reduce, there's a change in employee's Grade at mid-year
    Given Leave Entitlement by Employee is created
      | Voucher No | Voucher Type | Voucher Date | Year | Employee Code | Default Adjustment Type | Leave Type | No of Days | Submit |
      | LE017      | By Employee  | 1/8/2016     | 2016 | LE_EMP001     | Reduce                  | PROENT     | All        |        |
      |            |              |              |      |               |                         | NPROENT    | All        | Y      |
      | LE018      | By Employee  | 1/8/2016     | 2016 | LE_EMP002     | Reduce                  | PROENT     | All        |        |
      |            |              |              |      |               |                         | NPROENT    | All        | Y      |
      | LE019      | By Employee  | 1/8/2016     | 2016 | LE_EMP003     | Reduce                  | PROENT     | All        |        |
      |            |              |              |      |               |                         | NPROENT    | All        | Y      |
      | LE020      | By Employee  | 1/8/2016     | 2016 | LE_EMP004     | Reduce                  | PROENT     | All        |        |
      |            |              |              |      |               |                         | NPROENT    | All        | Y      |
      | LE021      | By Employee  | 1/8/2016     | 2016 | LE_EMP005     | Reduce                  | PROENT     | All        |        |
      |            |              |              |      |               |                         | NPROENT    | All        | Y      |
    Then user pulls out data for Leave Entitlement as "AI-Scenario 6" follow "LV_ENT_SQLCheck.xls" on sheet "LE"
      | Voucher No |
      | LE017      |
      | LE018      |
      | LE019      |
      | LE020      |
      | LE021      |
    Then user pulls out data for Leave Entitlement as "AI-Scenario 6" follow "LV_ENT_SQLCheck.xls" on sheet "EMP"
      | Condition Code |
      | LE_EMP001      |
      | LE_EMP002      |
      | LE_EMP003      |
      | LE_EMP004      |
      | LE_EMP005      |

#  Year of Service
#  YOS _ Scenario 1: Leave Entitlement by Leave Type, Adjustment Type = Add
    Given Leave Entitlement by Leave Type is created
      | Voucher No | Voucher Type  | Voucher Date | Year | Leave Type | Default Adjustment Type | Default No of Days | Employee Code | No of Days                     | Submit |
      | LE001      | By Leave Type | 31/7/2016    | 2016 | PROENT     | Add                     | 1                  | LE_EMP001Y    | Expected Leave Entitlement - 2 |        |
      |            |               |              |      |            |                         |                    | LE_EMP002Y    | Expected Leave Entitlement - 2 |        |
      |            |               |              |      |            |                         |                    | LE_EMP003Y    | Expected Leave Entitlement - 2 |        |
      |            |               |              |      |            |                         |                    | LE_EMP004Y    | Expected Leave Entitlement - 2 |        |
      |            |               |              |      |            |                         |                    | LE_EMP005Y    | Expected Leave Entitlement - 2 | Y      |
      | LE002      | By Leave Type | 31/7/2016    | 2016 | NPROENT    | Add                     | 1                  | LE_EMP001Y    | Expected Leave Entitlement - 2 |        |
      |            |               |              |      |            |                         |                    | LE_EMP002Y    | Expected Leave Entitlement - 2 |        |
      |            |               |              |      |            |                         |                    | LE_EMP003Y    | Expected Leave Entitlement - 2 |        |
      |            |               |              |      |            |                         |                    | LE_EMP004Y    | Expected Leave Entitlement - 2 |        |
      |            |               |              |      |            |                         |                    | LE_EMP005Y    | Expected Leave Entitlement - 2 | Y      |
    Then user pulls out data for Leave Entitlement as "YOS-Scenario 1" follow "LV_ENT_SQLCheck.xls" on sheet "LE"
      | Voucher No |
      | LE001      |
      | LE002      |
    Then user pulls out data for Leave Entitlement as "YOS-Scenario 1" follow "LV_ENT_SQLCheck.xls" on sheet "EMP"
      | Condition Code |
      | LE_EMP001Y     |
      | LE_EMP002Y     |
      | LE_EMP003Y     |
      | LE_EMP004Y     |
      | LE_EMP005Y     |

#  YOS _ Scenario 2: Leave Entitlement by Employee, Adjustment Type = Add
    Given Leave Entitlement by Employee is created
      | Voucher No | Voucher Type | Voucher Date | Year | Employee Code | Default Adjustment Type | Leave Type | No of Days | Submit |
      | LE003      | By Employee  | 31/7/2016    | 2016 | LE_EMP001Y    | Add                     | PROENT     | 4          |        |
      |            |              |              |      |               |                         | NPROENT    | 4          | Y      |
      | LE004      | By Employee  | 31/7/2016    | 2016 | LE_EMP002Y    | Add                     | PROENT     | 4          |        |
      |            |              |              |      |               |                         | NPROENT    | 4          | Y      |
      | LE005      | By Employee  | 31/7/2016    | 2016 | LE_EMP003Y    | Add                     | PROENT     | 4          |        |
      |            |              |              |      |               |                         | NPROENT    | 4          | Y      |
      | LE006      | By Employee  | 31/7/2016    | 2016 | LE_EMP004Y    | Add                     | PROENT     | 4          |        |
      |            |              |              |      |               |                         | NPROENT    | 4          | Y      |
      | LE007      | By Employee  | 31/7/2016    | 2016 | LE_EMP005Y    | Add                     | PROENT     | 4          |        |
      |            |              |              |      |               |                         | NPROENT    | 4          | Y      |
    Then user pulls out data for Leave Entitlement as "YOS-Scenario 2" follow "LV_ENT_SQLCheck.xls" on sheet "LE"
      | Voucher No |
      | LE003      |
      | LE004      |
      | LE005      |
      | LE006      |
      | LE007      |
    Then user pulls out data for Leave Entitlement as "YOS-Scenario 2" follow "LV_ENT_SQLCheck.xls" on sheet "EMP"
      | Condition Code |
      | LE_EMP001Y     |
      | LE_EMP002Y     |
      | LE_EMP003Y     |
      | LE_EMP004Y     |
      | LE_EMP005Y     |

#  YOS _ Scenario 3: Leave Entitlement by Leave Type, Adjustment Type = Reduce
    Given Leave Entitlement by Leave Type is created
      | Voucher No | Voucher Type  | Voucher Date | Year | Leave Type | Default Adjustment Type | Default No of Days | Employee Code | No of Days | Submit |
      | LE008      | By Leave Type | 31/7/2016    | 2016 | PROENT     | Reduce                  | 1                  | LE_EMP001Y    | 2          |        |
      |            |               |              |      |            |                         |                    | LE_EMP002Y    | 2          |        |
      |            |               |              |      |            |                         |                    | LE_EMP003Y    | 2          |        |
      |            |               |              |      |            |                         |                    | LE_EMP004Y    | 2          |        |
      |            |               |              |      |            |                         |                    | LE_EMP005Y    | 2          | Y      |
      | LE009      | By Leave Type | 31/7/2016    | 2016 | NPROENT    | Reduce                  | 1                  | LE_EMP001Y    | 2          |        |
      |            |               |              |      |            |                         |                    | LE_EMP002Y    | 2          |        |
      |            |               |              |      |            |                         |                    | LE_EMP003Y    | 2          |        |
      |            |               |              |      |            |                         |                    | LE_EMP004Y    | 2          |        |
      |            |               |              |      |            |                         |                    | LE_EMP005Y    | 2          | Y      |
    Then user pulls out data for Leave Entitlement as "YOS-Scenario 3" follow "LV_ENT_SQLCheck.xls" on sheet "LE"
      | Voucher No |
      | LE008      |
      | LE009      |
    Then user pulls out data for Leave Entitlement as "YOS-Scenario 3" follow "LV_ENT_SQLCheck.xls" on sheet "EMP"
      | Condition Code |
      | LE_EMP001Y     |
      | LE_EMP002Y     |
      | LE_EMP003Y     |
      | LE_EMP004Y     |
      | LE_EMP005Y     |

#  YOS _ Scenario 4: Leave Entitlement by Employee, Adjustment Type = Reduce
    Given Leave Entitlement by Employee is created
      | Voucher No | Voucher Type | Voucher Date | Year | Employee Code | Default Adjustment Type | Leave Type | No of Days | Submit |
      | LE010      | By Employee  | 31/7/2016    | 2016 | LE_EMP001Y    | Reduce                  | PROENT     | 2          |        |
      |            |              |              |      |               |                         | NPROENT    | 2          | Y      |
      | LE011      | By Employee  | 31/7/2016    | 2016 | LE_EMP002Y    | Reduce                  | PROENT     | 2          |        |
      |            |              |              |      |               |                         | NPROENT    | 2          | Y      |
      | LE012      | By Employee  | 31/7/2016    | 2016 | LE_EMP003Y    | Reduce                  | PROENT     | 2          |        |
      |            |              |              |      |               |                         | NPROENT    | 2          | Y      |
      | LE013      | By Employee  | 31/7/2016    | 2016 | LE_EMP004Y    | Reduce                  | PROENT     | 2          |        |
      |            |              |              |      |               |                         | NPROENT    | 2          | Y      |
      | LE014      | By Employee  | 31/7/2016    | 2016 | LE_EMP005Y    | Reduce                  | PROENT     | 2          |        |
      |            |              |              |      |               |                         | NPROENT    | 2          | Y      |
    Then user pulls out data for Leave Entitlement as "YOS-Scenario 4" follow "LV_ENT_SQLCheck.xls" on sheet "LE"
      | Voucher No |
      | LE010      |
      | LE011      |
      | LE012      |
      | LE013      |
      | LE014      |
    Then user pulls out data for Leave Entitlement as "YOS-Scenario 4" follow "LV_ENT_SQLCheck.xls" on sheet "EMP"
      | Condition Code |
      | LE_EMP001Y     |
      | LE_EMP002Y     |
      | LE_EMP003Y     |
      | LE_EMP004Y     |
      | LE_EMP005Y     |

#  YOS _ Scenario 5: Leave Entitlement by Leave Type, Adjustment Type = Add, there's a change in employee's Grade at mid-year
    Given user updates Grade
      | Employee Code | Effective Date From | Grade      |
      | LE_EMP001Y    | 1/8/2016            | GRADE2_YOS |
      | LE_EMP002Y    | 1/8/2016            | GRADE2_YOS |
      | LE_EMP003Y    | 1/8/2016            | GRADE2_YOS |
      | LE_EMP004Y    | 1/8/2016            | GRADE2_YOS |
      | LE_EMP005Y    | 1/8/2016            | GRADE1_YOS |
    Given Leave Entitlement by Leave Type is created
      | Voucher No | Voucher Type  | Voucher Date | Year | Leave Type | Default Adjustment Type | Default No of Days | Employee Code | No of Days                     | Submit |
      | LE015      | By Leave Type | 1/8/2016     | 2016 | PROENT     | Add                     | 1                  | LE_EMP001Y    | Expected Leave Entitlement - 4 |        |
      |            |               |              |      |            |                         |                    | LE_EMP002Y    | Expected Leave Entitlement - 4 |        |
      |            |               |              |      |            |                         |                    | LE_EMP003Y    | Expected Leave Entitlement - 4 |        |
      |            |               |              |      |            |                         |                    | LE_EMP004Y    | Expected Leave Entitlement - 4 |        |
      |            |               |              |      |            |                         |                    | LE_EMP005Y    | Expected Leave Entitlement - 4 | Y      |
      | LE016      | By Leave Type | 1/8/2016     | 2016 | NPROENT    | Add                     | 1                  | LE_EMP001Y    | Expected Leave Entitlement - 4 |        |
      |            |               |              |      |            |                         |                    | LE_EMP002Y    | Expected Leave Entitlement - 4 |        |
      |            |               |              |      |            |                         |                    | LE_EMP003Y    | Expected Leave Entitlement - 4 |        |
      |            |               |              |      |            |                         |                    | LE_EMP004Y    | Expected Leave Entitlement - 4 |        |
      |            |               |              |      |            |                         |                    | LE_EMP005Y    | Expected Leave Entitlement - 4 | Y      |
    Then user pulls out data for Leave Entitlement as "YOS-Scenario 5" follow "LV_ENT_SQLCheck.xls" on sheet "LE"
      | Voucher No |
      | LE015      |
      | LE016      |
    Then user pulls out data for Leave Entitlement as "YOS-Scenario 5" follow "LV_ENT_SQLCheck.xls" on sheet "EMP"
      | Condition Code |
      | LE_EMP001Y     |
      | LE_EMP002Y     |
      | LE_EMP003Y     |
      | LE_EMP004Y     |
      | LE_EMP005Y     |

#  YOS _ Scenario 6: Leave Entitlement by Employee, Adjustment Type = Reduce, there's a change in employee's Grade at mid-year
    Given Leave Entitlement by Employee is created
      | Voucher No | Voucher Type | Voucher Date | Year | Employee Code | Default Adjustment Type | Leave Type | No of Days | Submit |
      | LE017      | By Employee  | 1/8/2016     | 2016 | LE_EMP001Y    | Reduce                  | PROENT     | All        |        |
      |            |              |              |      |               |                         | NPROENT    | All        | Y      |
      | LE018      | By Employee  | 1/8/2016     | 2016 | LE_EMP002Y    | Reduce                  | PROENT     | All        |        |
      |            |              |              |      |               |                         | NPROENT    | All        | Y      |
      | LE019      | By Employee  | 1/8/2016     | 2016 | LE_EMP003Y    | Reduce                  | PROENT     | All        |        |
      |            |              |              |      |               |                         | NPROENT    | All        | Y      |
      | LE020      | By Employee  | 1/8/2016     | 2016 | LE_EMP004Y    | Reduce                  | PROENT     | All        |        |
      |            |              |              |      |               |                         | NPROENT    | All        | Y      |
      | LE021      | By Employee  | 1/8/2016     | 2016 | LE_EMP005Y    | Reduce                  | PROENT     | All        |        |
      |            |              |              |      |               |                         | NPROENT    | All        | Y      |
    Then user pulls out data for Leave Entitlement as "YOS-Scenario 6" follow "LV_ENT_SQLCheck.xls" on sheet "LE"
      | Voucher No |
      | LE017      |
      | LE018      |
      | LE019      |
      | LE020      |
      | LE021      |
    Then user pulls out data for Leave Entitlement as "YOS-Scenario 6" follow "LV_ENT_SQLCheck.xls" on sheet "EMP"
      | Condition Code |
      | LE_EMP001Y     |
      | LE_EMP002Y     |
      | LE_EMP003Y     |
      | LE_EMP004Y     |
      | LE_EMP005Y     |

    Then user compares data for Leave Entitlement with
      | Expected File | Sheet          | Scenario Description                                                                                                        |
      |               | AI-Scenario 1  | AI _ Scenario 1: Leave Entitlement by Leave Type, Adjustment Type = Add                                                     |
      |               | AI-Scenario 2  | AI _ Scenario 2: Leave Entitlement by Employee, Adjustment Type = Add                                                       |
      |               | AI-Scenario 3  | AI _ Scenario 3: Leave Entitlement by Leave Type, Adjustment Type = Reduce                                                  |
      |               | AI-Scenario 4  | AI _ Scenario 4: Leave Entitlement by Employee, Adjustment Type = Reduce                                                    |
      |               | AI-Scenario 5  | AI _ Scenario 5: Leave Entitlement by Leave Type, Adjustment Type = Add, there's a change in employee's Grade at mid-year   |
      |               | AI-Scenario 6  | AI _ Scenario 6: Leave Entitlement by Employee, Adjustment Type = Reduce, there's a change in employee's Grade at mid-year  |
      |               | YOS-Scenario 1 | YOS _ Scenario 1: Leave Entitlement by Leave Type, Adjustment Type = Add                                                    |
      |               | YOS-Scenario 2 | YOS _ Scenario 2: Leave Entitlement by Employee, Adjustment Type = Add                                                      |
      |               | YOS-Scenario 3 | YOS _ Scenario 3: Leave Entitlement by Leave Type, Adjustment Type = Reduce                                                 |
      |               | YOS-Scenario 4 | YOS _ Scenario 4: Leave Entitlement by Employee, Adjustment Type = Reduce                                                   |
      |               | YOS-Scenario 5 | YOS _ Scenario 5: Leave Entitlement by Leave Type, Adjustment Type = Add, there's a change in employee's Grade at mid-year  |
      |               | YOS-Scenario 6 | YOS _ Scenario 6: Leave Entitlement by Employee, Adjustment Type = Reduce, there's a change in employee's Grade at mid-year |