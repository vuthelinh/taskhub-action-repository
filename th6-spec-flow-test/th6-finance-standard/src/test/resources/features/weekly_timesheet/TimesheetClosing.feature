@n-tsc
Feature: Create Project and test with many Databases

  # Tao Project 1, Project 2 tren AUTO 1
  # Switch to AUTO 2, tao project 3 ,project 4, project 5
  Scenario Outline: 1. Create Project Estimation with many Databases
    Given "nancy.nguyen" login to "AUTO1" company with password is "taskhub"
    And user navigates to "Operations>Project>Project Order/Estimation" screen
    When user create project estimation as "<PE KEY>"
      | PE KEY | Customer |
      | 001    | Cus02    |
      | 002    | CUS03    |
    And project estimation is created with header tab as "<PE KEY>"
      | PE KEY | Currency | Sales Tax | Customer PO No | Reference No. | Estimate Date | Customer Contact | Start Date | End Date   | Sales Manager | Project Class | Segment 1 | Segment 2 | Segment 3 | Segment 4 | Payment Term Tenor |
      | 001    | SGD      | GST7      |                |               |               |                  | 01/01/2016 | 01/01/2017 |               | PJCLASS1      | NA        | NA        | NA        | NA        | 10                 |
      | 002    | SGD      | GST7      |                |               |               |                  | 01/01/2016 | 01/01/2017 |               | PJCLASS2      | NA        | NA        | NA        | NA        | 10                 |
    And project estimation is created with detail tab with phase as "<PE KEY>"
      | PE KEY | Phase No. | Phase Desc     | Phase Remarks    | Qty | UOM | Unit Price | Disc% | Amount | Budgeted Total Cost | Del |
      | 001    | 1         | Phase 1 Desc   | Phase 1 Remark   | 7   |     | 1500       |       | 100    |                     |     |
      | 001    | 2         | Phase 2 Desc   | Phase 2 Remark   | 4   |     | 8530       | 4     |        |                     |     |
      | 001    | 2.1       | Phase 2.1 Desc | Phase 2.1 Remark | 2   |     | 6945       | 5     |        |                     |     |
      | 002    | 1         | Phase 1 Desc   | Phase 1 Remark   | 7   |     | 1500       |       | 100    |                     |     |
      | 002    | 1.1       | Phase 1.1 Desc | Phase 1.1 Remark | 4   |     | 8530       | 4     |        |                     |     |
      | 002    | 2         | Phase 2 Desc   | Phase 2 Remark   | 2   |     | 6945       | 5     |        |                     |     |
    And project estimation is created with detail tab with item as "<PE KEY>"
      | PE KEY | Phase No. | No. | Type | Item Description | Item Remarks | Qty/UOM | Unit Price | Disc% | Amount | Budgeted Unit Cost | Del |
      | 001    | 1         |     | S    | TS               |              | 50      |            |       |        | 500                |     |
      | 001    | 1         |     | S    | TTS              |              | 50      |            |       |        | 500                |     |
      | 001    | 2.1       |     | S    | TS               |              | 50      |            |       |        | 500                |     |
      | 002    | 1.1       |     | S    | TS               |              | 50      |            |       |        | 500                |     |
      | 002    | 2         |     | S    | TTS              |              | 50      |            |       |        | 500                |     |
      | 002    | 2         |     | S    | TS               |              | 50      |            |       |        | 500                |     |
    And project estimation is submitted
    And user switch to database "AUTO4"
    And user navigates to "Operations>Project>Project Order/Estimation" screen
    When user create project estimation as "<PE KEY>"
      | PE KEY | Customer |
      | 001    | CUS03    |
      | 002    | CUS02    |
      | 003    | Cus01    |
    And project estimation is created with header tab as "<PE KEY>"
      | PE KEY | Currency | Sales Tax | Customer PO No | Reference No. | Estimate Date | Customer Contact | Start Date | End Date   | Sales Manager | Project Class | Segment 1 | Segment 2 | Segment 3 | Segment 4 | Payment Term Tenor |
      | 001    | SGD      | GST7      |                |               |               |                  | 01/01/2016 | 01/01/2017 |               | PJCLASS1      | NA        | NA        | NA        | NA        | 10                 |
      | 002    | SGD      | GST7      |                |               |               |                  | 01/01/2016 | 01/01/2017 |               | PJCLASS2      | NA        | NA        | NA        | NA        | 10                 |
      | 003    | SGD      | GST7      |                |               |               |                  | 01/01/2016 | 01/01/2017 |               | PJCLASS3      | NA        | NA        | NA        | NA        | 10                 |
    And project estimation is created with detail tab with phase as "<PE KEY>"
      | PE KEY | Phase No. | Phase Desc     | Phase Remarks    | Qty | UOM | Unit Price | Disc% | Amount | Budgeted Total Cost | Del |
      | 001    | 1         | Phase 1 Desc   | Phase 1 Remark   | 7   |     | 1500       |       | 100    |                     |     |
      | 001    | 2         | Phase 2 Desc   | Phase 2 Remark   | 4   |     | 3000       | 4     |        |                     |     |
      | 001    | 2.1       | Phase 2.1 Desc | Phase 2.1 Remark | 2   |     | 1500       | 5     |        |                     |     |
      | 002    | 1         | Phase 1 Desc   | Phase 1 Remark   | 7   |     | 1500       |       | 100    |                     |     |
      | 002    | 1.1       | Phase 1.1 Desc | Phase 1.1 Remark | 4   |     | 3000       | 4     |        |                     |     |
      | 002    | 2         | Phase 2 Desc   | Phase 2 Remark   | 2   |     | 1500       | 5     |        |                     |     |
      | 003    | 1         | Phase 1 Desc   | Phase 1 Remark   | 7   |     | 1500       |       | 100    |                     |     |
      | 003    | 2         | Phase 2 Desc   | Phase 2 Remark   | 4   |     | 3000       | 4     |        |                     |     |
      | 003    | 2.1       | Phase 2.1 Desc | Phase 2.1 Remark | 2   |     | 1500       | 5     |        |                     |     |
    And project estimation is created with detail tab with item as "<PE KEY>"
      | PE KEY | Phase No. | No. | Type | Item Description | Item Remarks | Qty/UOM | Unit Price | Disc% | Amount | Budgeted Unit Cost | Del |
      | 001    | 1         |     | S    | TS               |              | 50      |            |       |        | 500                |     |
      | 001    | 1         |     | S    | TTS              |              | 50      |            |       |        | 500                |     |
      | 001    | 2.1       |     | S    | TS               |              | 50      |            |       |        | 500                |     |
      | 002    | 1.1       |     | S    | TS               |              | 50      |            |       |        | 500                |     |
      | 002    | 2         |     | S    | TTS              |              | 50      |            |       |        | 500                |     |
      | 002    | 2         |     | S    | TS               |              | 50      |            |       |        | 500                |     |
      | 003    | 1         |     | S    | TS               |              | 50      |            |       |        | 500                |     |
      | 003    | 1         |     | S    | TTS              |              | 50      |            |       |        | 500                |     |
      | 003    | 2.1       |     | S    | TS               |              | 50      |            |       |        | 500                |     |
    And project estimation is submitted

    Examples: 
      | PE KEY |
      | 001    |
      | 002    |
      | 003    |

  Scenario: 2. Delete Weekly Timesheet 1
    When user delete weekly timesheet
      | DataBase          | Year | Week No | Employee Code |
      | AUTO1>172.18.0.21 | 2016 | 5       | TSQA01        |
      | AUTO1>172.18.0.21 | 2016 | 5       | TSQA02        |

  Scenario Outline: 3. Enable Search Project In Ctrl Database is YES and Run Weekly Timesheet
    Given "nancy" login to "AUTO1" company with password is "taskhub"
    Given user navigates to "Operations>Payroll>Weekly Timesheet" screen
    When user create weekly timesheet for employee as "<Key>"
      | Key | Year | Week No | Employee Code | Timesheet Date | Approving Officer |
      | 001 | 2016 | 5       | TSQA01        | 25/01/2016     | NANCY1            |
      | 002 | 2016 | 5       | TSQA02        | 25/01/2016     | NANCY1            |
    And weekly timesheet is created with data as "<Key>"
      | Key | Timesheet Date | Activity  | Project | Phase Desc/Remarks | Normal Hrs | OT Hrs | Expected Message |
      | 001 | 25/01/2016     | TTRAINING | 1       |                    | 5          | 1      |                  |
      | 001 | 25/01/2016     | RV        | 2       |                    | 3          | 1      |                  |
      | 001 | 26/01/2016     | TRAINING  | 4       |                    | 4          | 1      |                  |
      | 001 | 26/01/2016     | TTRAINING | 2       |                    | 3.5        | 1      |                  |
      | 001 | 26/01/2016     | RV        | 2       |                    | 0.5        | 1      |                  |
      | 001 | 27/01/2016     | TTRAINING | 5       |                    | 8          | 1      |                  |
      | 001 | 28/01/2016     | TEAMBUILD | 2       |                    | 4          | 1      |                  |
      | 001 | 28/01/2016     | RV        | 2       |                    | 4          | 1      |                  |
      | 001 | 29/01/2016     | RV        | 2       |                    | 8          | 1      |                  |
      | 001 | 30/01/2016     | RV        | 2       |                    | 4          | 1      |                  |
      | 002 | 25/01/2016     | TTRAINING | 1       |                    | 5          | 1      |                  |
      | 002 | 25/01/2016     | DEV       | 2       |                    | 3          | 1      |                  |
      | 002 | 26/01/2016     | TRAINING  | 4       |                    | 4          | 1      |                  |
      | 002 | 26/01/2016     | TTRAINING | 2       |                    | 3.5        | 1      |                  |
      | 002 | 26/01/2016     | RV        | 2       |                    | 0.5        | 1      |                  |
      | 002 | 27/01/2016     | TTRAINING | 3       |                    | 8          | 1      |                  |
      | 002 | 28/01/2016     | TEAMBUILD | 2       |                    | 4          | 1      |                  |
      | 002 | 28/01/2016     | TRAINING  | 2       |                    | 4          | 1      |                  |
      | 002 | 29/01/2016     | RV        | 2       |                    | 8          | 1      |                  |
      | 002 | 30/01/2016     | TRAINING  | 2       |                    | 4          | 1      |                  |

    Examples: 
      | Key |
      | 001 |
      | 002 |

  Scenario: 4. Approval 1
    Given "nancy" login to "AUTO1" company with password is "taskhub"
    Given user navigates to "Operations>Approval>Approval Summary (Timesheet, Staff Claims)" screen
    When user approval summary for payrol

  # Auto 4: Enable Search Project In Ctrl Database is No run data and verify:
  Scenario: 5. Enable Search PrEnable Search Project In Ctrl Database is NO
    Given "nancy" login to "AUTO4" company with password is "taskhub"
    And user navigates to "Master Setup>System Configuration>Module Config" screen
    * user changes Module Config
      | Module Section  | Module Name                            | Config Type | Config Value |
      | Payroll>Payroll | Enable Search Project In Ctrl Database | Radio       | No           |

  Scenario: 6. Delete Weekly Timesheet 2
    When user delete weekly timesheet
      | DataBase          | Year | Week No | Employee Code |
      | AUTO4>172.18.0.21 | 2016 | 5       | TSQA03        |
      | AUTO4>172.18.0.21 | 2016 | 5       | TSQA04        |

  Scenario Outline: 7. Enable Search PrEnable Search Project In Ctrl Database is NO and Run Weekly Timesheet
    Given "nancy" login to "AUTO4" company with password is "taskhub"
    And user navigates to "Operations>Payroll>Weekly Timesheet" screen
    When user create weekly timesheet for employee as "<Key>"
      | Key | Year | Week No | Employee Code | Timesheet Date | Approving Officer |
      | 001 | 2016 | 5       | TSQA03        | 25/01/2016     | NANCY1            |
      | 002 | 2016 | 5       | TSQA04        | 25/01/2016     | NANCY1            |
    And weekly timesheet is created with data as "<Key>"
      | Key | Timesheet Date | Activity  | Project | Phase Desc/Remarks | Normal Hrs | OT Hrs | Expected Message                                           |
      | 001 | 25/01/2016     | TTRAINING | 1       |                    | 5          | 1      | The input is not a valid code.\nPlease enter a valid code. |
      | 001 | 25/01/2016     | TTRAINING | 5       |                    | 5          | 1      |                                                            |
      | 001 | 25/01/2016     | RV        | 2       |                    | 3          | 1      |                                                            |
      | 001 | 26/01/2016     | TRAINING  | 4       |                    | 4          | 1      |                                                            |
      | 001 | 26/01/2016     | TTRAINING | 2       |                    | 3.5        | 1      |                                                            |
      | 001 | 26/01/2016     | RV        | 2       |                    | 0.5        | 1      |                                                            |
      | 001 | 27/01/2016     | TTRAINING | 5       |                    | 8          | 1      |                                                            |
      | 001 | 27/01/2016     | TTRAINING | 3       |                    | 8          | 1      | The input is not a valid code.\nPlease enter a valid code. |
      | 001 | 28/01/2016     | TEAMBUILD | 2       |                    | 4          | 1      |                                                            |
      | 001 | 28/01/2016     | RV        | 2       |                    | 4          | 1      |                                                            |
      | 001 | 29/01/2016     | RV        | 2       |                    | 8          | 1      |                                                            |
      | 002 | 25/01/2016     | TTRAINING | 1       |                    | 5          | 1      | The input is not a valid code.\nPlease enter a valid code. |
      | 002 | 25/01/2016     | TTRAINING | 5       |                    | 5          | 1      |                                                            |
      | 002 | 25/01/2016     | DEV       | 2       |                    | 3          | 1      |                                                            |
      | 002 | 26/01/2016     | TRAINING  | 4       |                    | 4          | 1      |                                                            |
      | 002 | 26/01/2016     | TTRAINING | 2       |                    | 3.5        | 1      |                                                            |
      | 002 | 26/01/2016     | RV        | 2       |                    | 0.5        | 1      |                                                            |
      | 002 | 27/01/2016     | TTRAINING | 5       |                    | 8          | 1      |                                                            |
      | 002 | 27/01/2016     | TTRAINING | 3       |                    | 8          | 1      | The input is not a valid code.\nPlease enter a valid code. |
      | 002 | 28/01/2016     | TEAMBUILD | 2       |                    | 4          | 1      |                                                            |
      | 002 | 28/01/2016     | TRAINING  | 2       |                    | 4          | 1      |                                                            |
      | 002 | 29/01/2016     | RV        | 2       |                    | 8          | 1      |                                                            |

    # then with project 1, 2 of database AUTO 1, display error message "The input is not a valid code.Please enter a valid code."
    # Check when run
    Examples: 
      | Key |
      | 001 |
      | 002 |

  Scenario: 8. Approval 2
    Given "nancy" login to "AUTO4" company with password is "taskhub"
    Given user navigates to "Operations>Approval>Approval Summary (Timesheet, Staff Claims)" screen
    When user approval summary for payrol

  # -------------------------TIMESHEET CLOSING----------------------------------------------
  Scenario: 9. Verify when check send email notification feature
    Given "nancy.nguyen" login to "AUTO1" company with password is "taskhub"
    And user navigates to "Operations>Payroll>Timesheet Closing" screen
    When user fill data then send email for timesheet closing
      | From       | To         | Posting Date | Employee | Expected Message                                                     |
      | 23/01/2016 | 26/01/2016 | 26/05/2016   | TSQA01   | Email has been generated successfully for all underclocked employees |

  Scenario: 10. Verify when check close by employee feature
    Given "nancy.nguyen" login to "AUTO1" company with password is "taskhub"
    And user navigates to "Operations>Payroll>Timesheet Closing" screen
    When user fill data then send email and submit for timesheet closing
      | Key | From       | To         | Posting Date | Employee | Expected Send Email | Expected Submit                                                                               |
      | 001 | 25/01/2016 | 26/01/2016 | 26/05/2016   | TSQA01   |                     | TimeSheet Closing has been done successfully for all employees for dates from <^$1> to <^$2>. |
      | 002 | 25/01/2016 | 26/01/2016 | 26/05/2016   | TSQA02   |                     | TimeSheet Closing has been done successfully for all employees for dates from <^$1> to <^$2>. |
      | 003 | 27/01/2016 | 29/01/2016 | 26/05/2016   | TSQA01   |                     | TimeSheet Closing has been done successfully for all employees for dates from <^$1> to <^$2>. |
      | 004 | 25/01/2016 | 29/01/2016 | 26/05/2016   | TSQA02   |                     | TimeSheet Closing has been done successfully for all employees for dates from <^$1> to <^$2>. |

  Scenario: 11. Verify when check closing timesheet for all employee
    Given "nancy.nguyen" login to "AUTO4" company with password is "taskhub"
    And user navigates to "Operations>Payroll>Timesheet Closing" screen
    When user fill data without employee then submit for timesheet closing
      | From       | To         | Posting Date | Expected Submit                                                                               |
      | 25/01/2016 | 27/01/2016 | 27/05/2016   | TimeSheet Closing has been done successfully for all employees for dates from <^$1> to <^$2>. |
