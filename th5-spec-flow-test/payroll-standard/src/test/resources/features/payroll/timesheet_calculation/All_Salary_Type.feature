@timesheet_calculation_all @levin @payroll
Feature: Timesheet Calculation Test Suite by Payroll - Salary Type: All

  #For running sequentially
  Scenario Outline: Salary Type: All
    Given "<User>" login to "<Company>" company with password is "<Password>"
    Given user access DB "<DB>" with id "<ID>" and password "<KEY>"

    # Clear Data
    Given Data is clear as in "TSC_ClearSQL.xls"

    # Test Flow
    When Data for Timesheet is created as in "<Dataset>"
    And Data is pulled out follows "<Dataset>" using Employee Prefix "<EMPPrefix>" with suffix as generated date
    Then Data is compared with "<Expected>"

    Examples:
      | User    | Company | Password | DB                                    | ID       | KEY      | Dataset                                            | Expected                                   | EMPPrefix |
      | queenie | (TRG5)  | taskhub  | jdbc:db2://172.18.0.10:50000/GENMAIN5 | db2admin | Taskhub1 | TSC_BasicOT_FixedRate_GENMAIN5_Dataset_NoRound.xls | TSC_BasicOT_FixedRate_NoRound_Output_E.xls | FXOT      |
      | queenie | (TRG5)  | taskhub  | jdbc:db2://172.18.0.10:50000/GENMAIN5 | db2admin | Taskhub1 | TSC_BasicOT_FixedRate_GENMAIN5_Dataset_Round.xls   | TSC_BasicOT_FixedRate_Round_Output_E.xls   | FXOT      |
      | emily   | (TRG)   | taskhub  | jdbc:db2://172.18.0.245:50000/GENMAIN | db2admin | Taskhub1 | TSC_BasicOT_Flexible_GENMAIN_Dataset_NoRound.xls   | TSC_BasicOT_Flexible_NoRound_Output_E.xls  | AOT       |
      | emily   | (TRG)   | taskhub  | jdbc:db2://172.18.0.245:50000/GENMAIN | db2admin | Taskhub1 | TSC_BasicOT_Flexible_GENMAIN_Dataset_Round.xls     | TSC_BasicOT_Flexible_Round_Output_E.xls    | AOT       |
      | rachel  | (TRG3)  | taskhub  | jdbc:db2://172.18.0.10:50000/GENMAIN3 | db2admin | Taskhub1 | TSC_BasicOT_TimeRange_GENMAIN3_Dataset.xls         | TSC_BasicOT_TimeRange_Output_E.xls         | FOT       |
      | kim     | (TRG2)  | taskhub  | jdbc:db2://172.18.0.10:50000/GENMAIN2 | db2admin | Taskhub1 | TSC_BasicOT_WorkingHour_GENMAIN2_Dataset.xls       | TSC_BasicOT_WorkingHour_Output_E.xls       | FOT       |
      | levin   | (PTRG2) | taskhub  | jdbc:db2://172.18.0.10:50000/PAYROLL2 | db2admin | Taskhub1 | TSC_BasicSalary_PAYROLL2_Dataset.xls               | TSC_BasicSalary_Output_E.xls               | FHR       |
      | kim     | (PTRG3) | taskhub  | jdbc:db2://172.18.0.10:50000/PAYROLL3 | db2admin | Taskhub1 | TSC_HourlyRate_TimeRange_PAYROLL3_Dataset.xls      | TSC_HourlyRate_TimeRange_Output_E.xls      | FTR       |
      | rachel  | (PTRG4) | taskhub  | jdbc:db2://172.18.0.10:50000/PAYROLL4 | db2admin | Taskhub1 | TSC_HourlyRate_TimeRange_NWT_PAYROLL4_Dataset.xls  | TSC_HourlyRate_TimeRange_NWT_Output_E.xls  | FTR_N     |
      | queenie | (PTRG5) | taskhub  | jdbc:db2://172.18.0.10:50000/PAYROLL5 | db2admin | Taskhub1 | TSC_HourlyRate_TimeRange_UD_PAYROLL5_Dataset.xls   | TSC_HourlyRate_TimeRange_UD_Output_E.xls   | FTR_USER  |
      | emily   | (PTRG)  | taskhub  | jdbc:db2://172.18.0.244:50000/PAYROLL | db2admin | Taskhub1 | TSC_HourlyRate_WorkingHour_PAYROLL_Dataset.xls     | TSC_HourlyRate_WorkingHour_Output_E.xls    | FHR_WH    |
      | levin   | (TRG4)  | taskhub  | jdbc:db2://172.18.0.10:50000/GENMAIN4 | db2admin | Taskhub1 | TSC_PieceRate_GENMAIN4_Dataset.xls                 | TSC_PieceRate_Output_E.xls                 | PR        |
      | levin   | (TRG4)  | taskhub  | jdbc:db2://172.18.0.10:50000/GENMAIN4 | db2admin | Taskhub1 | TSC_TimeSlot_GENMAIN4_Dataset.xls                  | TSC_TimeSlot_Output_E.xls                  | TST       |
