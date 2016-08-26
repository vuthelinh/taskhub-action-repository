@n-wts
Feature: Check Expected Leave Entitlement based on Year of Service (No) when prorate expected at leave type=Yes Weekly Timesheet (TH6)

  Scenario: Set Module Config
    Given user login the TH6 system
    And user navigates to "Master Setup>System Configuration>Module Config" screen
    When set module config option for TS
      | Tab                                            | Module Configuration                                                                    | Value |
      | Payroll>Timesheet                              | Service Code for Weekly Timesheet                                                       | TS    |
      | Payroll>Timesheet                              | Enable Weekly Timesheet to Capture Project Cost Without Payroll Designation Hourly Rate | Yes   |
      | Project Costing>Project Quotation & Estimation | Enable Insert Project To Ctrl DB                                                        | Yes   |

  Scenario: Create TS Activity
    Given user login the TH6 system
    Given user navigates to "Master Setup>Employee & Approving Officer>Timesheet Activity" screen
    When user create activity
      | Activity Code | Activity Description    | Type                       | Company |
      | NFEATURE      | NOT USE - Feature File  | Project Related            |         |
      | NSCRIPT       | NOT USE - Create Script | Project Related            |         |
      | NTRAINING     | NOT USE - Training      | Project Related (In-House) |         |
      | NTEAMBUILD    | NOT USE - Team Building | Non-Project Related        |         |

  Scenario Outline: Create Designation
    Given user login the TH6 system
    Given user navigates to "Master Setup>Employee & Approving Officer>Designation" screen
    When user create designation as "<Designation Key>"
      | Key | Designation Code | Designation Description | Company |
      | 001 | NJSQA            | NOT USE - Junior SQA    |         |
      | 002 | NSSQA            | NOT USE - Senior SQA    |         |
    And designation is created with local info as "<Designation Key>"
      | Key | Effective Date From | Normal Hourly Rate | OT Hourly Rate |
      | 001 | 01/01/2015          | 10                 | 20             |
      | 001 | 07/01/2015          | 11                 | 21             |
      | 002 | 01/01/2015          | 25                 | 35             |
      | 002 | 07/01/2015          | 26                 | 36             |

    Examples: 
      | Designation Key |
      | 001             |
      | 002             |

  Scenario Outline: Create Employee
    Given user login the TH6 system
    Given user navigates to "Master Setup>Employee & Approving Officer>Employee>[2]" screen
    When user create employee as "<Key Emp>"
      | Key Emp | Employee Code | Employee Name         | Company |
      | 001     | NSQA01        | NOT USE- Jacob Vu     |         |
      | 002     | NSQA02        | NOT USE - Henry Vu    |         |
      | 003     | NSQA03        | NOT USE- Nancy Nguyen |         |
      | 004     | NSQA04        | NOT USE- Vincent Tran |         |
      | 005     | NSQA05        | NOT USE - Levin Le    |         |
    And employees is created with particulars info as "<Key Emp>"
      | Key Emp | Date of Birth |
      | 001     | 06/04/1984    |
      | 002     | 18/05/1990    |
      | 003     | 18/07/1991    |
      | 004     | 09/08/1988    |
      | 005     | 04/02/1990    |
    And employees is created with employment info as "<Key Emp>"
      | Key Emp | Designation Effective Date | Designation |
      | 001     | 01/01/2015                 | NSSQA       |
      | 002     | 01/01/2015                 | NJSQA       |
      | 003     | 01/01/2015                 | NJSQA       |
      | 004     | 01/01/2015                 | NJSQA       |
      | 004     | 07/01/2015                 | NSSQA       |
      | 005     | 01/01/2015                 | NJSQA       |
      | 005     | 07/01/2015                 | NSSQA       |
    And employees is created with employment duration as "<Key Emp>"
      | Key Emp | Join Date  | Company Code |
      | 001     | 01/01/2015 | AUTO1        |
      | 002     | 01/01/2015 | AUTO1        |
      | 003     | 01/01/2015 | AUTO1        |
      | 004     | 01/01/2015 | AUTO1        |
      | 005     | 01/01/2015 | AUTO1        |
    And employee is updated
    And employees is created with local info hr tab as "<Key Emp>"
      | Key Emp | Sat  | Total Working Hours Per Day | Total Working Hours Per Week | AM Time From | AM Time To | PM Time From | PM Time To | Salary Type Effective Date | Salary Type  | Related To Timesheet |
      | 001     | Half | 8                           | 44                           | 08:00        | 12:00      | 13:00        | 17:00      | 01/01/2015                 | Basic OT     | Yes                  |
      | 002     | Half | 8                           | 44                           | 08:00        | 12:00      | 13:00        | 17:00      | 01/01/2015                 | Basic Salary | Yes                  |
      | 003     | Off  | 8                           | 40                           | 08:00        | 12:00      | 13:00        | 17:00      | 01/01/2015                 | Basic Salary | Yes                  |
      | 004     | Off  | 8                           | 40                           | 08:00        | 12:00      | 13:00        | 17:00      | 01/01/2015                 | Basic OT     | Yes                  |
      | 005     | Off  | 8                           | 40                           | 08:00        | 12:00      | 13:00        | 17:00      | 01/01/2015                 | Basic Salary | Yes                  |
    And employee is updated

    Examples: 
      | Key Emp |
      | 001     |
      | 002     |
      | 003     |
      | 004     |
      | 005     |

  Scenario: Create Leave Type
    Given user login the TH6 system
    Given user navigates to "Master Setup>Leave>Leave Type" screen
    When user create leave type
      | Leave type code | Description            | Paid Leave | Company |
      | NPAIDLV         | NOT USE - Paid Leave   | Yes        |         |
      | NUNPDLV         | NOT USE- Un-paid Leave | No         |         |

  # =============================== PROCESSING ===============================
  Scenario Outline: The Entitlements are created by Employee
    Given user login the TH6 system
    And user navigates to "Operations>Leave>Leave Entitlement" screen
    When user create leave entitlement by leave type as "<Key Leave Type>"
      | Key | Voucher Date | Year | Default Adjustment Type | Leave Type | Default No. of Days |
      | 001 |              |      |                         | TPAIDLV    | 5                   |
    And leave entitlement is created by leave type with employee as "<Key Leave Type>"
      | Key | Employee Code | Adjustment Type | No. Of Days |
      | 001 | N_EMP002      |                 |             |
      | 001 | N_EMP003      |                 |             |
      | 001 | N_EMP001      |                 |             |
      | 001 | N_EMP004      |                 |             |
    And user submit leave entitlement

    Examples: 
      | Key Leave Type |
      | 001            |

  Scenario Outline: Create Project
    Given user login the TH6 system
    And user navigates to "Operations>Project>Project Order/Estimation" screen
    When user create project estimation as "<PE KEY>"
      | PE KEY | Customer | Is Session |
      | 001    | CUS03    |            |
      | 002    | CUS02    |            |
      | 003    | CUS01    |            |
    And project estimation is created with header tab as "<PE KEY>"
      | PE KEY | Currency | Sales Tax | Customer PO No | Reference No. | Estimate Date | Customer Contact | Start Date | End Date   | Sales Manager | Project Class | Segment 1 | Segment 2 | Segment 3 | Segment 4 | Payment Term Tenor |
      | 001    | SGD      | GST7      |                |               |               |                  | 01/01/2015 | 01/01/2017 |               | PJCLASS1      | NA        | NA        | NA        | NA        | 11                 |
      | 002    | SGD      | GST7      |                |               |               |                  | 01/01/2015 | 01/01/2017 |               | PJCLASS2      | NA        | NA        | NA        | NA        | 12                 |
      | 002    | SGD      | GST7      |                |               |               |                  | 01/01/2015 | 01/01/2017 |               | PJCLASS3      | NA        | NA        | NA        | NA        | 13                 |
    And project estimation is created with detail tab with phase as "<PE KEY>"
      | PE KEY | Phase No. | Phase Desc     | Qty | UOM | Unit Price | Disc% | Amount | Budgeted Total Cost | Del |
      | 001    | 1         | Phase 1 Desc   | 7   |     | 11000      | 1     | 100    |                     |     |
      | 001    | 2         | Phase 2 Desc   | 4   |     | 12000      | 2     | 200    |                     |     |
      | 001    | 2.1       | Phase 2.1 Desc | 2   |     | 13000      | 3     | 300    |                     |     |
      | 002    | 1         | Phase 1 Desc   | 7   |     | 14000      | 4     | 400    |                     |     |
      | 002    | 1.1       | Phase 1.1 Desc | 4   |     | 15000      | 5     | 500    |                     |     |
      | 002    | 2         | Phase 2 Desc   | 2   |     | 16000      | 6     | 600    |                     |     |
      | 003    | 1         | Phase 1 Desc   | 7   |     | 11000      | 1     | 100    |                     |     |
      | 003    | 1.1       | Phase 1.1 Desc | 7   |     | 11000      | 1     | 100    |                     |     |
      | 003    | 1.2       | Phase 1.2 Desc | 7   |     | 11000      | 1     | 100    |                     |     |
      | 003    | 2         | Phase 2 Desc   | 4   |     | 12000      | 2     | 200    |                     |     |
      | 003    | 2.1       | Phase 2.1 Desc | 2   |     | 13000      | 3     | 300    |                     |     |
    And project estimation is created with detail tab with item as "<PE KEY>"
      | PE KEY | Phase No. | No. | Type | Item Description | Item Remarks | Qty/UOM | Unit Price | Disc% | Amount | Budgeted Unit Cost | Del |
      | 001    | 1         |     | S    | TTS              |              | 10      |            |       |        | 500                |     |
      | 001    | 1         |     | S    | TS               |              | 20      |            |       |        | 500                |     |
      | 001    | 2.1       |     | S    | TS               |              | 30      |            |       |        | 500                |     |
      | 002    | 1.1       |     | S    | TS               |              | 40      |            |       |        | 500                |     |
      | 002    | 2         |     | S    | TTS              |              | 50      |            |       |        | 500                |     |
      | 002    | 2         |     | S    | TS               |              | 60      |            |       |        | 500                |     |
      | 003    | 1.1       |     | S    | TS               |              | 60      |            |       |        | 500                |     |
      | 003    | 1.2       |     | S    | TTS              |              | 70      |            |       |        | 500                |     |
      | 003    | 1.2       |     | S    | TS               |              | 60      |            |       |        | 500                |     |
      | 003    | 2.1       |     | S    | TTS              |              | 60      |            |       |        | 500                |     |
    And project estimation is submitted

    Examples: 
      | PE KEY |
      | 001    |
      | 002    |
      | 003    |

  Scenario Outline: Create Leave Application
    Given user login the TH6 system
    And user navigates to "Operations>Leave>Leave Application" screen
    When user create leave application as "<Key>"
      | Key | Application Date | Applicant | SBU |
      | 001 |                  | N_EMP002  |     |
      | 002 |                  | N_EMP001  |     |
      | 003 |                  | N_EMP003  |     |
      | 004 |                  | N_EMP004  |     |
    And leave application is created with leave type as "<Key>"
      | Key | Leave Type | Date From  | Date To    | Duration Type |
      | 001 | UNPDLV     | 02/01/2016 | 02/01/2016 | AM            |
      | 002 | TUNPDLV    | 02/01/2016 | 02/01/2016 | PM            |
      | 002 | NUNPDLV    | 04/01/2016 | 04/01/2016 | PM            |
      | 003 | NUNPDLV    | 04/01/2016 | 04/01/2016 | AM            |
      | 004 | NUNPDLV    | 04/01/2016 | 04/01/2016 | Full          |
    And leave application is submitted

    Examples: 
      | Key |
      | 001 |
      | 002 |
      | 003 |
      | 004 |

  Scenario Outline: Approval Leave Application
    Given user login the TH6 system
    And user navigates to "Operations>Approval>Approval Summary" screen
    When user approve leave application

  Scenario: Make sure user logged in has Supervisor right to Weekly TS screen
    Given user login the TH6 system
    And user navigates to "Master Setup>Employee & Approving Officer>Employee>[2]" screen
    When employees is updated with System Role info
      | Employee Code | Employee System Role        |
      | NANCY1        | Timesheet Approving Officer |
    And employee is updated

  Scenario Outline: Create Weekly Timesheet
    Given user login the TH6 system
    Given user navigates to "Operations>Payroll>Weekly Timesheet" screen
    When user create weekly timesheet for employee as "<Key>"
      | Key | Year | Week No | Employee Code | Timesheet Date | Approving Officer |
      | 001 | 2016 | 5       | N_EMP001      | 25/01/2016     | NANCY1            |
      | 002 | 2016 | 5       | N_EMP003      | 25/01/2016     | NANCY1            |
    And weekly timesheet is created with data as "<Key>"
      | Key | Timesheet Date | Activity  | Project | Phase Desc/Remarks | Normal Hrs | OT Hrs | Expected Message |
      | 001 | 25/01/2016     | TTRAINING | 1       |                    | 8          | 1      |                  |
      | 001 | 26/01/2016     | TTRAINING | 3       |                    | 4          | 1      |                  |
      | 001 | 26/01/2016     | TSCRIPT   | 1       |                    | 4          | 1      |                  |
      | 001 | 27/01/2016     | DEV       | 2       |                    | 8          | 1      |                  |
      | 001 | 28/01/2016     | TEAMBUILD | 3       |                    | 8          | 1      |                  |
      | 001 | 29/01/2016     | TTRAINING | 1       |                    | 8          | 1      |                  |
      | 001 | 30/01/2016     | TTRAINING | 1       |                    | 4          | 1      |                  |
      | 002 | 25/01/2016     | TFEATURE  | 1       |                    | 8          | 1      |                  |
      | 002 | 26/01/2016     | TFEATURE  | 3       |                    | 4          | 1      |                  |
      | 002 | 26/01/2016     | TSCRIPT   | 1       |                    | 4          | 1      |                  |
      | 002 | 27/01/2016     | DEV       | 2       |                    | 8          | 1      |                  |
      | 002 | 28/01/2016     | TEAMBUILD | 3       |                    | 4          | 1      |                  |
      | 002 | 28/01/2016     | TTRAINING | 1       |                    | 4          | 1      |                  |
      | 002 | 29/01/2016     | TTRAINING | 1       |                    | 8          | 1      |                  |

    Examples: 
      | Key |
      | 001 |
      | 002 |
