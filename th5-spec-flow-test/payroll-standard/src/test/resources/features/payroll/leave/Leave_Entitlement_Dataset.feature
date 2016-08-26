@leave_entitlement_dataset @levin @payroll
Feature: Test Leave Entitlement

  Scenario Outline: Create Leave Entitlement
    Given "<User>" login to "<Company>" company with password is "<Password>"
    Given user access DB "<DB>" with id "<ID>" and password "<KEY>"

# Preparation
    Given Global Config is set as in "LV_GlobalConfig.xls"
    Given Module Config is set as in "LV_ModuleConfig.xls"
    Given Employee Payroll Category is created as in "LV_EPC.xls"
    Given Payment Cycle is created as in "LV_PaymentCycle.xls"
    Given Leave Type is created as in "LV_LeaveType.xls"
    Given Employee Grade is created as in "LV_EmployeeGrade.xls"
    Given Employee is created as in "LV_Employee.xls"

# Clear Data
    Given Data is clear as in "LV_ClearData.xls"
    Given Employee employment info is reset as in "<Employee>" on sheet "Employment_2"
    Given Employee Grade is reset as in "<Employee>"

# First entitlement by employee for 2015 - Adding
    When Leave Entitlement By Employee is created as in "<LE_BY_EMPLOYEE>" with sheet suffix "_Add"
    Then Expected Entitlement is calculated correctly follow "<LE_BY_EMPLOYEE>" on sheet "Expected_Add_P1"

# Employee resigns then rejoins, updates Grade at mid year
    Given Employee resigns as in "<Employee>" on sheet "Employment_2"
    Given Employee rejoins as in "<Employee>" on sheet "Employment_3"
    Given Employee updates Grade as in "<Employee>" on sheet "Grade_2"

# Second entitlement by employee at mid year for 2015 - Deducting
    When Leave Entitlement By Employee is created as in "<LE_BY_EMPLOYEE>" with sheet suffix "_Deduct"
    Then Expected Entitlement is calculated correctly follow "<LE_BY_EMPLOYEE>" on sheet "Expected_Deduct_P2"

# Employee updates Grade in new year
    Given Employee updates Grade as in "<Employee>" on sheet "Grade_3"

# First entitlement by Leave Type for 2016 - Adding
    When Leave Entitlement By Leave Type is created as in "<LE_BY_LEAVETYPE>" with sheet suffix "_Add"
    Then Expected Entitlement is calculated correctly follow "<LE_BY_LEAVETYPE>" on sheet "Expected_Add_P3"

# Second entitlement by Leave Type for 2016 - Deducting
    When Leave Entitlement By Leave Type is created as in "<LE_BY_LEAVETYPE>" with sheet suffix "_Deduct"
    Then Expected Entitlement is calculated correctly follow "<LE_BY_LEAVETYPE>" on sheet "Expected_Deduct_P4"

# Send email report
    Then user send email report for Leave Entitlement

    Examples:
      | User  | Company | Password | DB                                    | ID       | KEY      | Employee        | LE_BY_EMPLOYEE                    | LE_BY_LEAVETYPE                    |
      | emily | (TRG7)  | taskhub  | jdbc:db2://172.18.0.10:50000/GENMAIN7 | db2admin | Taskhub1 | LV_Employee.xls | LV_LeaveEntitlementByEmployee.xls | LV_LeaveEntitlementByLeaveType.xls |
