@n-del-wts
Feature: Check Expected Leave Entitlement based on Year of Service (No) when prorate expected at leave type=Yes Weekly Timesheet (TH6)

  Scenario: Delete infomation created by Weekly Timesheet flow
    Given user login the TH6 system
    When user delete weekly timesheet
      | DataBase          | Year | Week No | Employee Code |
      | AUTO1>172.18.0.21 | 2016 | 5       | N_EMP001      |
      | AUTO1>172.18.0.21 | 2016 | 5       | N_EMP003      |
    When user delete leave entitlement by leave type
      | Vch No. | Leave Type | Employee Code |
      |         | NPAIDLV    |               |
    When user delete leave application by employee
      | Employee Code |
      | N_EMP002      |
      | N_EMP001      |
      | N_EMP003      |
      | N_EMP004      |
    And user navigates to "Master Setup>Leave>Leave Type" screen
    When user delete leave type
      | Leave type code | Paid Leave |
      | NPAIDLV         | Yes        |
      | NUNPDLV         | No         |
    Given user navigates to "Master Setup>Employee & Approving Officer>Employee>[2]" screen
    When user delete employee
      | Key Emp | Employee Code | Employee Name |
      | 001     | NSQA01        | Jacob Vu      |
      | 002     | NSQA02        | Henry Vu      |
      | 003     | NSQA03        | Nancy Nguyen  |
      | 004     | NSQA04        | Vincent Tran  |
      | 005     | NSQA05        | Levin Le      |
    Given user navigates to "Master Setup>Employee & Approving Officer>Designation" screen
    When user delete designation
      | Key | Designation Code | Designation Description |
      | 001 | NJSQA            | Junior SQA              |
      | 002 | NSSQA            | Senior SQA              |
    Given user navigates to "Master Setup>Employee & Approving Officer>Timesheet Activity" screen
    When user delete timesheet activity
      | Activity Code | Activity Description | Type                       |
      | NFEATURE      | Feature File         | Project Related            |
      | NSCRIPT       | Create Script        | Project Related            |
      | NTRAINING     | Training             | Project Related (In-House) |
      | NTEAMBUILD    | Team Building        | Non-Project Related        |
    Given user navigates to "Master Setup>Service>Service" screen
    When user delete service
      | Service Code |
      | NTS          |
