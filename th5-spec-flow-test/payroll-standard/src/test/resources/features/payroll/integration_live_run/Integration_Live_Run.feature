@payroll_integration_live_run
Feature: Integration Live Run Test Suite by Payroll

  @payroll_integration_live_run_master_data
  Scenario Outline: Background
    Given "<User>" login to "<Company>" company with password is "<Password>"
    Given user access DB "<DB>" with id "<ID>" and password "<KEY>"

# Clear Data
    Given Data is clear as in "P_00_ClearSQL.xls"

# Test Flow
    # Form Code Access
    Given Global Config is set as in "P_00_GlobalConfig.xls"
    Given Module Config is set as in "P_00_ModuleConfig.xls"
    Given Role Master is set up as in "P_01_0_RoleMaster.xls"

    #Migrate
    Given Migrate: Country is created as in                       "P_01_1_Migrate_Country.xls"
    Given Migrate: CPF Contribution Rate Scheme is created as in  "P_01_2_Migrate_CPFContributionRateScheme.xls"
    Given Migrate: Community Fund Donation is created as in       "P_01_3_Migrate_CommunityFundDonation.xls"
    Given Migrate: SDL is created as in                           "P_01_4_Migrate_SDL.xls"
    Given Migrate: Currency is created as in                      "P_01_5_Migrate_Currency.xls"
    Given UOM is created as in                                    "P_01_6_UOM.xls"
    Given GLAN is created as in                                   "P_01_7_GLAN.xls"

    # Master Data
    Given Time Clock Machine Location is created as in          "P_02_TimeClockMachineLocation.xls"
    Given Working Group is created as in                        "P_03_WorkingGroup.xls"
    Given Commission Group is created as in                     "P_04_CommissionGroup.xls"
    Given Hourly Rate Scheme is created as in                   "P_05_HourlyRateScheme.xls"
    Given Global Basic with OT is created as in                 "P_06_GlobalBasicWithOT.xls"
    Given Working Location is created as in                     "P_07_WorkingLocation.xls"
    Given Working Area is created as in                         "P_08_WorkingArea.xls"
    Given Payroll Reporting Group is created as in              "P_09_ReportingGroup.xls"
    Given Payment Cycle is created as in                        "P_10_PaymentCycle.xls"
    Given Company Info is set up as in                          "P_11_Company.xls"
    Given Leave Type is created as in                           "P_12_LeaveType.xls"
    Given Party Group is created as in                          "P_13_1_PartyGroup.xls"
    Given Bank is created as in                                 "P_13_2_Bank.xls"
    Given Service Code is created as in                         "P_14_ServiceCode.xls"
    Given User is created as in                                 "P_17_CreateUser.xls"
    Given User Role Access is set up as in                      "P_17_CreateUser.xls"
    Given Employee Class is created as in                       "P_15_1_EmployeeClass.xls"
    Given Employee Job Type is created as in                    "P_15_2_EmployeeJobType.xls"
    Given Employee Grade is created as in                       "P_15_3_EmployeeGrade.xls"
    Given Employee Payroll Category is created as in            "P_15_4_EPC.xls"
    Given Salutation is created as in                           "P_15_5_Salutation.xls"
    Given Designation Group is created as in                    "P_15_6_DesignationGroup.xls"
    Given Employee is created as in                             "P_16_Employee.xls"
    Given Hourly Rate Group is created as in                    "P_19_HourlyRateGroup.xls"
    Given Approving Officer is set up as in                     "P_20_ApprovingOfficer.xls"

    And user send mail report for Integration Live Run - Master Data

    Examples:
      | User  | Company | Password | DB                                    | ID       | KEY      |
      | emily | (TRG8)  | taskhub  | jdbc:db2://172.18.0.10:50000/GENMAIN8 | db2admin | Taskhub1 |

  @payroll_integration_live_run_processing
  Scenario Outline: Integration Live Run
    Given "<User>" login to "<Company>" company with password is "<Password>"
    Given user access DB "<DB>" with id "<ID>" and password "<KEY>"

    # Processing Flow
    Given Leave & Approval flow is created as in               "P_21_22_Process_Leave_Approval.xls"
    Given Payroll Timesheet flow is created as in              "P_24_1_Process_Payroll_Timesheet.xls"
    Given Additional Voucher By Item is created as in          "P_24_2_Process_Payroll_Additional_ByItem.xls"
    Given Additional Voucher By Recipient is created as in     "P_24_2_Process_Payroll_Additional_ByRecipient.xls"
    Given Deduction Voucher is created as in                   "P_24_3_Process_Payroll_Deduction.xls"
    Given Payslip is generated as in                           "P_24_4_Process_Payroll_Payslip.xls"
    Given Bank Text File Export for Payslip is generated as in "P_24_5_Process_Payroll_BankTextFileExport.xls"
    Given CPF File Extraction is generated as in               "P_24_6_Process_Payroll_CPFFileExtraction.xls"
    Given Ir8A File Extraction is generated as in              "P_24_7_Process_Payroll_Ir8AFileExtraction.xls"

    And user send mail report for Integration Live Run - Processing

    Examples:
      | User  | Company | Password | DB                                    | ID       | KEY      |
      | emily | (TRG8)  | taskhub  | jdbc:db2://172.18.0.10:50000/GENMAIN8 | db2admin | Taskhub1 |