package com.synergix.payroll.timesheet_calculation.defs;

import com.synergix.common.actions.DatasetBase;
import com.synergix.common.actions.PageSteps;
import com.synergix.common.constants.MenuID;
import com.synergix.utilities.DateTimeUtil;
import com.synergix.utilities.ExcelUtils;
import com.synergix.utilities.ReadBean;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

import java.sql.ResultSet;
import java.util.ArrayList;

public class TimesheetCalculationDefs extends DatasetBase
{
    @Steps
    PageSteps pageSteps;
    String sqlResult;

    @Title("Payroll Timesheet Calculation")
    @Given("Data for Timesheet is created as in\\s+\"([^\"]*)\"$")
    public void timesheetCalculation(String dataset)
    {
        excelPath = getPayrollPath(dataset);
        sqlResult = getPayrollOutputPath(dataset.replace(".xls", "_Output_" + DateTimeUtil.getTime("dd_MM_yyyy")) + ".xls");

        // clear any output file before to prevent corrupted file
        ReadBean.deleteFile(sqlResult);

        setDataset("Dataset");
        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String tsDate = getColumn(1);
            String enableOTRound = getColumn(2);
            String glPostDate = getColumn(3);
            String defWkrLocation = getColumn(4);
            String salType = getColumn(5);
            String applyLunchBreak = getColumn(6);
            String payByActualWH = getColumn(7);
            String genDraftConsol = getColumn(8);
            String submitDraftConsol = getColumn(9);
            String latenessDeduction = getColumn(10);
            String leaveEarlyDeduction = getColumn(11);
            String createLeaveAppPeriod = getColumn(12);
            String cancelLeaveAppPeriod = getColumn(13);
            String applyLeaveBFSubmit = getColumn(14);
            String leaveType = getColumn(15);
            String allocatePJToLeave = getColumn(16);
            String addMoreFromNoRecord = getColumn(17);
            String addMoreFromTSDetail = getColumn(18);
            String generatePayslipFor = getColumn(19);
            String paymentCycle = getColumn(20);
            String epcCode = getColumn(21);
            String confirmAllorOne = getColumn(22);
            String empDetailNo = getColumn(23);

            // enable OT Round for Basic OT Scheme
            enableOTRound(enableOTRound);

            // Enable reading from different rate if exceed a certain timing (Only for Basic OT Fixed Rate with Rounding)
            if (getCurrentCompany().contains("TRG5"))
                enableRateIfExceedTiming(enableOTRound);

            // set leaving early deduction
            setDeduction(salType, latenessDeduction, leaveEarlyDeduction);

            pageSteps.goToMenu(MenuID.PROC_PY_PAYROLL_TIMESHEET);
            // Step 1 - Create Timesheet After created leave application
            // clickAtXpathCSS("//a[text()='TS00000163']");
            pageSteps.clickButton("New");
            pageSteps.setText("Timesheet Date", tsDate);
            pageSteps.setText("Default Working Location", defWkrLocation);
            pageSteps.setDropDownOption("Salary Type", salType);
            pageSteps.goToTab("Manual");

            // read data from employee records tab based on salary type
            setTable(salType);

            inputDraft(tsDate, empDetailNo, salType, applyLunchBreak, payByActualWH, addMoreFromNoRecord, addMoreFromTSDetail);

            pageSteps.clickButton("Submit");
            pageSteps.confirm("Yes");

            // create leave app before consol generation (option = 1)
            if (createLeaveAppPeriod.equalsIgnoreCase("1"))
                createLeaveApp(tsDate, salType, leaveType, empDetailNo);

            // cancel leave app before consol generation (option = 1)
            if (cancelLeaveAppPeriod.equalsIgnoreCase("1"))
                cancelLeaveApp(tsDate, salType, empDetailNo);

            /// -- add more record at TS Details BEFORE TIMESHEET GENERATION
            // must delete other records in advance (only for this case)
            if (addMoreFromTSDetail.equalsIgnoreCase("1"))
            {
                pageSteps.goToMenu(MenuID.PROC_PY_TIMESHEET_DETAIL);
                inputDetail(addMoreFromTSDetail, tsDate, empDetailNo, salType, applyLunchBreak, payByActualWH);
            }

            pageSteps.goToMenu(MenuID.PROC_PY_TIMESHEET_GENERATION);
            pageSteps.setText("Timesheet Date", tsDate);
            pageSteps.clickButton("Generate Consolidated");
            pageSteps.waitForAjax(3);
            pageSteps.confirm("OK");
            // get Consolidate Timesheet number - CTS0000XXX
            consolTSNo = pageSteps.getTextDesc("Consolidated Timesheet No.");
            // create leave app after consol generation (option = 2)
            if (createLeaveAppPeriod.equalsIgnoreCase("2"))
                createLeaveApp(tsDate, salType, leaveType, empDetailNo);

            // cancel leave app after consol generation (option = 2)
            if (cancelLeaveAppPeriod.equalsIgnoreCase("2"))
                cancelLeaveApp(tsDate, salType, empDetailNo);

            // Step 3 - Add more at TS Details BEFORE Generating Consol
            /// ----1---- add more timesheet record before consol submission
            /// ----1.1-- add more at ts details
            if (addMoreFromTSDetail.equalsIgnoreCase("2"))
            {
                pageSteps.goToMenu(MenuID.PROC_PY_TIMESHEET_DETAIL);
                inputDetail(addMoreFromTSDetail, tsDate, empDetailNo, salType, applyLunchBreak, payByActualWH);
            }
            /// ----1.2-- add more at no record
            if (genDraftConsol.equalsIgnoreCase("Y"))
            {
                // Step 4 - Cancel leave - apply leave from No Record from Draft
                if (submitDraftConsol.equalsIgnoreCase("Y"))
                {
                    pageSteps.goToMenu(MenuID.PROC_PY_PAYROLL_TIMESHEET);
                    pageSteps.goToTab("Consolidated Timesheet");
                    pageSteps.setTableFilter("Timesheet No.", consolTSNo);
                    pageSteps.waitForAjax(3);
                    pageSteps.selectFirstRow("Timesheet No.");
                    pageSteps.setText("Payroll GL Posting Date", glPostDate);
                    pageSteps.goToTab("No Record");
                    // apply leave from no record before submit
                    if (applyLeaveBFSubmit.equalsIgnoreCase("Y"))
                    {
                        // Step 4.1 - Apply Leave from No Record at Draft Consol
                        // BEFORE Submission
                        applyLeaveNR(empDetailNo, leaveType, allocatePJToLeave);
                    }
                    // Step 4 - End
                    // add more record to No Record BEFORE Consol Submission
                    if (addMoreFromNoRecord.equalsIgnoreCase("2"))
                    {
                        //// add records from basic ot tab with time in = time out
                        inputNoRecord(tsDate, empDetailNo, salType, applyLunchBreak, payByActualWH, confirmAllorOne, true);
                        if (confirmAllorOne.equalsIgnoreCase("A"))
                        {
                            pageSteps.waitForAjax(3);
                            pageSteps.clickButton("Confirm");
                            pageSteps.confirm("Yes");
                            pageSteps.confirm("OK");
                        }
                        // end of loop
                    }
                    // pull out data before submit
                    pullOutData(dataset, tsDate);

                    // SUBMIT CONSOL
                    pageSteps.clickButton("Submit");
                    pageSteps.confirm("Yes");
                    pageSteps.confirm("Yes");// in case warning for records both exists in Leave/NoRecord
                    pageSteps.confirm("OK");

                    // check if consol really is submitted, if not, submit again
                    String status = getColumnValue(
                            "SELECT STATUS FROM py_consol_timesheet WHERE TIMESHEET_DATE = '" + DateTimeUtil.reverseDate(tsDate) + "'", "STATUS");
                    if (!status.equalsIgnoreCase("O")) // O means timesheet has already been in Outstanding
                    {
                        pageSteps.goToMenu(MenuID.PROC_PY_PAYROLL_TIMESHEET);
                        pageSteps.goToTab("Consolidated Timesheet");
                        pageSteps.setTableFilter("Timesheet Date", tsDate, 1);
                        pageSteps.selectFirstRow("Timesheet No.");
                        pageSteps.clickButton("Submit");
                        pageSteps.confirm("Yes");
                        pageSteps.confirm("Yes");
                        pageSteps.confirm("OK");
                    }
                }
            }

            // create leave app after consol submission (option = 3)
            if (createLeaveAppPeriod.equalsIgnoreCase("3"))
                createLeaveApp(tsDate, salType, leaveType, empDetailNo);

            // cancel leave app after consol submission (option = 3)
            if (cancelLeaveAppPeriod.equalsIgnoreCase("3"))
                cancelLeaveApp(tsDate, salType, empDetailNo);

            // get details table data again after pulling out sql
            setTable(salType);
            // apply leave from No Record after submit
            if (applyLeaveBFSubmit.equalsIgnoreCase("N"))
            {
                pageSteps.goToMenu(MenuID.PROC_PY_PAYROLL_TIMESHEET);
                pageSteps.goToTab("Consolidated Timesheet");
                pageSteps.goToTab("Outstanding");
                pageSteps.waitForAjax(1);
                pageSteps.setTableFilter("Timesheet No.", consolTSNo);
                pageSteps.selectFirstRow("Timesheet No.");
                pageSteps.goToTab("No Record");
                applyLeaveNR(empDetailNo, leaveType, allocatePJToLeave);
            }
            /// ----2---- add more timesheet record after consol submission
            /// ----2.1-- add more record at TS Details
            if (addMoreFromTSDetail.equalsIgnoreCase("3"))
            {
                pageSteps.goToMenu(MenuID.PROC_PY_TIMESHEET_DETAIL);
                inputDetail(addMoreFromTSDetail, tsDate, empDetailNo, salType, applyLunchBreak, payByActualWH);
            }
            /// ----2.1-- add more record at No Record
            if (addMoreFromNoRecord.equalsIgnoreCase("3"))
            {
                pageSteps.goToMenu(MenuID.PROC_PY_PAYROLL_TIMESHEET);
                pageSteps.goToTab("Consolidated Timesheet");
                pageSteps.goToTab("Outstanding");
                pageSteps.setTableFilter("Timesheet No.", consolTSNo);
                pageSteps.selectFirstRow("Timesheet No.");
                pageSteps.goToTab("No Record");
                inputNoRecord(tsDate, empDetailNo, salType, applyLunchBreak, payByActualWH, confirmAllorOne, false);
            }
            // generate payslip for the last date for 1 emp
            if (notEmpty(generatePayslipFor))
            {
                // check if all payslip has been submitted
                pageSteps.goToMenu(MenuID.PROC_PY_PAYROLL_TIMESHEET);
                pageSteps.goToTab("Consolidated Timesheet");
                pageSteps.goToTab("Draft");
                int rowCount = pageSteps.getRowsCount("Timesheet No.");
                if (rowCount > 0)
                    while (true)
                    {
                        pageSteps.selectFirstRow("Timesheet No.");
                        pageSteps.clickButton("Submit");
                        pageSteps.confirm("Yes");
                        pageSteps.confirm("Yes");
                        pageSteps.confirm("OK");
                        rowCount = pageSteps.getRowsCount("Timesheet No.");
                        if (rowCount == 0)
                            break;
                    }
                genPayslipFor(glPostDate, tsDate, paymentCycle, epcCode, salType, generatePayslipFor);
            }
        }
    }

    public void setTable(String salType)
    {
        if (salType.equals("Basic"))
            setDetailData("Basic");
        if (salType.equals("Basic OT"))
            setDetailData("Basic OT");
        else if (salType.equals("Hourly Rate"))
            setDetailData("Hourly Rate");
        else if (salType.equals("Piece Rate"))
            setDetailData("Piece Rate");
        else if (salType.equals("Timeslot"))
            setDetailData("Timeslot");
    }

    @Step("Enable reading from different rate if exceed a certain timing = {0}")
    private void enableRateIfExceedTiming(String enableOTRound)
    {
        if (notEmpty(enableOTRound))
            executeUpdate(
                    "UPDATE MODULE_CONFIG SET PROPERTY_VALUE = '" + enableOTRound + "' WHERE MODULE_CODE = 'PY' AND PROPERTY_NAME = 'enableReadingFromDiffRateIfExceedTiming'");
        if (enableOTRound.equalsIgnoreCase("Y"))
            executeUpdate(
                    "UPDATE MODULE_CONFIG SET PROPERTY_VALUE = '00:00' WHERE MODULE_CODE = 'PY' AND PROPERTY_NAME = 'calculateUsingDiffRateIfExceed'");
    }

    @Step("Enable OT Rounding = {0}")
    public void enableOTRound(String enableOTRound)
    {
        if (notEmpty(enableOTRound))
            executeUpdate(
                    "UPDATE MODULE_CONFIG SET PROPERTY_VALUE = '" + enableOTRound + "' WHERE MODULE_CODE = 'PY' AND PROPERTY_NAME = 'enableOTRoundingColumn'");
    }

    @Step("Input records at Draft Timesheet with Apply Meal Break = {3}")
    public void inputDraft(String tsDate, String empDetail, String salType, String applyLunchBreak, String payByActualWH, String addMoreFromNoRecord,
                           String addMoreFromTSDetail)
    {
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detailNo = getColumn_Detail(detNo);
            String empC = getColumn_Detail(detNo_Emp);
            String timeIn = getColumn_Detail(detNo_TimeIn);
            String dateIn = getColumn_Detail(detNo_DateIn);
            String timeOut = getColumn_Detail(detNo_TimeOut);
            String dateOut = getColumn_Detail(detNo_DateOut);
            String projectNo = getColumn_Detail(detNo_ProjectNo);
            //String phaseNo = getColumn_Detail(detNo_PhaseNo);
            //String actualLoc = getColumn_Detail(detNo_ActualLoc);
            String isNoLunch = getColumn_Detail(detNo_IsNoLunch);
            String isNoDinner = getColumn_Detail(detNo_IsNoDinner);
            String isNoSupper = getColumn_Detail(detNo_IsNoSupper);
            String noAddingAtTSDetail = getColumn_Detail(detNo_NoAddingAtTSDetails);

            String isTravel = "";
            String travelHours = "";
            String addMore = "";
            String addMoreNrOnly = "";

            if (salType.equalsIgnoreCase("Timeslot"))
            {
                isTravel = getColumn_Detail(detNo_TimeSlot_IsTravel);
                travelHours = getColumn_Detail(detNo_TimeSlot_TravelHours);
                addMore = getColumn_Detail(detNo_TimeSlot_AddMoreRecord);
                addMoreNrOnly = getColumn_Detail(detNo_TimeSlot_AddMoreNROnly);
                noAddingAtTSDetail = getColumn_Detail(detNo_TimeSlot_NoAddingAtTSDetails);
            }
            else
            {
                addMore = getColumn_Detail(detNo_AddMoreRecord);
                addMoreNrOnly = getColumn_Detail(detNo_AddMoreNROnly);
            }

            if (empDetail.equals(detailNo))
            {
                if (empty(addMoreFromNoRecord) && empty(addMoreFromTSDetail))
                {
                    if (notEmpty(timeIn))
                    {
                        if (notEmpty(isNoLunch) || notEmpty(isNoDinner) || notEmpty(isNoSupper))
                            pageSteps.confirm("OK");// check for invalid eating break before adding new record
                        pageSteps.clickButton("Add");
                        addDraft(i, tsDate, empC, timeIn, dateIn, timeOut, dateOut, projectNo, isTravel, travelHours, applyLunchBreak, isNoLunch,
                                 isNoDinner, isNoSupper, payByActualWH);
                    }
                }
                else
                {
                    if (notEmpty(timeIn) && !addMore.equalsIgnoreCase("Y"))
                    {
                        if (notEmpty(isNoLunch) || notEmpty(isNoDinner) || notEmpty(isNoSupper))
                            pageSteps.confirm("OK");// check for invalid eating break before adding new record
                        pageSteps.clickButton("Add");
                        addDraft(i, tsDate, empC, timeIn, dateIn, timeOut, dateOut, projectNo, isTravel, travelHours, applyLunchBreak, isNoLunch,
                                 isNoDinner, isNoSupper, payByActualWH);
                    }
                }
            }
        }
    }

    @Step("Add record {0}")
    public void addDraft(int j, String tsDate, String empC, String timeIn, String dateIn, String timeOut, String dateOut, String projectNo,
                         String isTravel, String travelHours, String applyLunchBreak, String isNoLunch, String isNoDinner, String isNoSupper,
                         String payByActualWH)
    {
        pageSteps.setTextAtTableCellPRTimeSheet("Manual", "Employee Code", 1, empC);
        // waitForTextValueToShow("//table[@id='frmDraftTS:tblManDet']/tbody/tr[1]/td[3]",
        // 10);

        String dateInS = "";
        String dateOutS = "";
        if (dateIn.equals("C"))
            dateInS = tsDate;
        else if (dateIn.equals("N")) // next day
            dateInS = DateTimeUtil.addDays(tsDate, 1);
        if (dateOut.equals("C"))
            dateOutS = tsDate;
        else if (dateOut.equals("N"))
            dateOutS = DateTimeUtil.addDays(tsDate, 1);

        pageSteps.setTextAtTableCellPRTimeSheet("Manual", "Time In", 1, timeIn);
        if (dateIn.equals("N"))
            pageSteps.setTextAtTableCellPRTimeSheet("Manual", "Date In", 1, dateInS);
        pageSteps.setTextAtTableCellPRTimeSheet("Manual", "Time Out", 1, timeOut);
        if (dateOut.equals("N"))
        {
            pageSteps.setTextAtTableCellPRTimeSheet("Manual", "Date Out", 1, dateOutS);
            pageSteps.setTextAtTableCellPRTimeSheet("Manual", "Time Out", 1, timeOut);
        }
        pageSteps.setTextAtTableCellPRTimeSheet("Manual", "Time In", 1, timeIn);

        if (notEmpty(projectNo))
        {
            pageSteps.setTextAtTableCellPRTimeSheet("Manual", "Project No.", 1, projectNo);
            // setTextAtTableCellPRTimeSheet("Manual", "Phase
            // Sequence No.", 1, phaseNo);
        }

        if (notEmpty(isTravel))
        {
            pageSteps.setCheckBoxAtTableCellPRTimesheet("Manual", "Travel", 1, isTravel);
            pageSteps.setTextAtTableCellPRTimeSheet("Manual", "Travel Hours", 1, travelHours);
        }
        // no need because default working location has been set
        // setTextAtTableCellPRTimeSheet("Manual", "Actual
        // Working Location", 1, getColumn(9));
        if (applyLunchBreak.equalsIgnoreCase("Y"))
        {
            pageSteps.setCheckBoxAtTableCellPRTimesheet("Manual", "No Lunch", 1, isNoLunch);
            if (notEmpty(isNoLunch))
                pageSteps.confirm("OK");
            pageSteps.setCheckBoxAtTableCellPRTimesheet("Manual", "No Dinner", 1, isNoDinner);
            if (notEmpty(isNoDinner))
                pageSteps.confirm("OK");
            pageSteps.setCheckBoxAtTableCellPRTimesheet("Manual", "No Supper", 1, isNoSupper);
            if (notEmpty(isNoSupper))
                pageSteps.confirm("OK");
        }

        if (notEmpty(payByActualWH) && (notEmpty(isNoLunch) || notEmpty(isNoDinner) || notEmpty(isNoSupper)))
            pageSteps.confirm("OK"); // if not valid lunch time, confirm before proceed
        pageSteps.setCheckBoxAtTableCellPRTimesheet("Manual", "Pay Emp Based On Actual Clock In Time", 1, payByActualWH);
    }

    @Step("Input records at Timesheet Details with Apply Meal Break = {4}")
    public void inputDetail(String addMoreFromTSDetail, String tsDate, String empDetail, String salType, String applyLunchBreak, String payByActualWH)
    {
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detailNo = getColumn_Detail(detNo);
            String empC = getColumn_Detail(detNo_Emp);
            String timeIn = getColumn_Detail(detNo_TimeIn);
            String dateIn = getColumn_Detail(detNo_DateIn);
            String timeOut = getColumn_Detail(detNo_TimeOut);
            String dateOut = getColumn_Detail(detNo_DateOut);
            String projectNo = getColumn_Detail(detNo_ProjectNo);
            // String phaseNo = getColumn_Detail(detNo_PhaseNo);
            String actualLoc = getColumn_Detail(detNo_ActualLoc);
            String isNoLunch = getColumn_Detail(detNo_IsNoLunch);
            String isNoDinner = getColumn_Detail(detNo_IsNoDinner);
            String isNoSupper = getColumn_Detail(detNo_IsNoSupper);
            String noAddingAtTSDetail = getColumn_Detail(detNo_NoAddingAtTSDetails);

            String isTravel = "";
            String travelHours = "";
            String addMore = "";
            String addMoreNrOnly = "";
            if (salType.equalsIgnoreCase("Timeslot"))
            {
                isTravel = getColumn_Detail(detNo_TimeSlot_IsTravel);
                travelHours = getColumn_Detail(detNo_TimeSlot_TravelHours);
                addMore = getColumn_Detail(detNo_TimeSlot_AddMoreRecord);
                addMoreNrOnly = getColumn_Detail(detNo_TimeSlot_AddMoreNROnly);
                noAddingAtTSDetail = getColumn_Detail(detNo_TimeSlot_NoAddingAtTSDetails);
            }
            else
            {
                addMore = getColumn_Detail(detNo_AddMoreRecord);
                addMoreNrOnly = getColumn_Detail(detNo_AddMoreNROnly);
            }

            if (empDetail.equals(detailNo))
            {// not allow adding from TS Details with clock in time after the clock in time in Draft TS
                if (!noAddingAtTSDetail.equalsIgnoreCase("Y"))
                {
                    if (equals(addMoreNrOnly, "Y") || (notEmpty(timeIn) && equals(addMore, "Y") && !equals(addMoreNrOnly, "Y")))
                    {
                        pageSteps.setText("Employee Code", empC);
                        pageSteps.confirm("Yes");// confirm reload if there are records
                        pageSteps.setText("Date From", tsDate);
                        pageSteps.setText("Date To", DateTimeUtil.addDays(tsDate, 1));

                        if (addMoreFromTSDetail.equalsIgnoreCase("1"))
                        {
                            /// -- add more record at TS Details BEFORE TIMESHEET GENERATION
                            // must delete other records in advance (only for this case)
                            if (pageSteps.getRowsCount("Time In") > 0)
                            {
                                pageSteps.setCheckBoxTableFilterAtTableCellPRTimesheet("Details", "Del", "Y");
                                pageSteps.waitForAjax(1);
                                pageSteps.clickButton("Delete"); // clear invalid records
                                pageSteps.confirm("Yes");
                                pageSteps.waitForAjax(1);
                                pageSteps.clickButton("Add"); // add 1 to prevent error
                            }
                        }
                    }
                    if (equals(addMoreNrOnly, "Y"))
                    {
                        if (pageSteps.getRowsCount("Time In") > 0)
                        {
                            pageSteps.waitForAjax(3);
                            addDetail(i, tsDate, dateIn, timeIn, dateOut, timeOut, projectNo, actualLoc, applyLunchBreak, isNoDinner, isNoLunch,
                                      isNoSupper, salType, payByActualWH);
                        }
                        else if (pageSteps.getRowsCount("Time In") == 0)
                        {
                            if (notEmpty(isNoLunch) || notEmpty(isNoDinner) || notEmpty(isNoSupper))
                                pageSteps.confirm("OK");// check for invalid eating break before adding new record
                            pageSteps.clickButton("Add");
                            addDetail(i, tsDate, dateIn, timeIn, dateOut, timeOut, projectNo, actualLoc, applyLunchBreak, isNoDinner, isNoLunch,
                                      isNoSupper, salType, payByActualWH);
                        }
                    }
                    else if (notEmpty(timeIn) && equals(addMore, "Y") && !equals(addMoreNrOnly, "Y"))
                    {
                        if (pageSteps.getRowsCount("Time In") > 0)
                        {
                            pageSteps.setCheckBoxTableFilterAtTableCellPRTimesheet("Details", "Del", "Y");
                            pageSteps.waitForAjax(1);
                            pageSteps.clickButton("Delete"); // clear invalid records
                            pageSteps.confirm("Yes");
                            pageSteps.waitForAjax(1);
                        }
                        pageSteps.clickButton("Add");
                        if (pageSteps.getRowsCount("Time In") > 0)
                            addDetail(i, tsDate, dateIn, timeIn, dateOut, timeOut, projectNo, actualLoc, applyLunchBreak, isNoDinner, isNoLunch,
                                      isNoSupper, salType, payByActualWH);
                    }
                }
            }
        }
    }

    @Step("Add record {0}")
    public void addDetail(int j, String tsDate, String dateIn, String timeIn, String dateOut, String timeOut, String projectNo, String actualLoc,
                          String applyLunchBreak, String isNoDinner, String isNoLunch, String isNoSupper, String salType, String payByActualWH)
    {
        if (dateIn.equals("C"))
            dateIn = tsDate;
        else if (dateIn.equals("N")) // next day
            dateIn = DateTimeUtil.addDays(tsDate, 1);
        if (dateOut.equals("C"))
            dateOut = tsDate;
        else if (dateOut.equals("N"))
            dateOut = DateTimeUtil.addDays(tsDate, 1);

        pageSteps.setTextAtTableCellPRTimeSheet("Details", "Timesheet Date", 1, tsDate);
        pageSteps.setTextAtTableCellPRTimeSheet("Details", "Date In", 1, dateIn);
        pageSteps.setTextAtTableCellPRTimeSheet("Details", "Time In", 1, timeIn);
        pageSteps.setTextAtTableCellPRTimeSheet("Details", "Date Out", 1, dateOut);
        pageSteps.setTextAtTableCellPRTimeSheet("Details", "Time Out", 1, timeOut);
        pageSteps.setTextAtTableCellPRTimeSheet("Details", "Time In", 1, timeIn);

        if (notEmpty(projectNo))
        {
            pageSteps.setTextAtTableCellPRTimeSheet("Details", "Project No.", 1, projectNo);
            // setTextAtTableCellPRTimeSheet("Details", "Phase
            // Sequence No.", 1, phaseNo);
        }

        //						if (notEmpty(isTravel))
        //						{
        //							setCheckBoxAtTableCellPRTimesheet("Details", "Travel", 1, isTravel);
        //							setTextAtTableCellPRTimeSheet("Details", "Travel Hours", 1, travelHours);
        //						}

        pageSteps.setTextAtTableCellPRTimeSheet("Details", "Actual Working Location", 1, actualLoc);
        if (applyLunchBreak.equalsIgnoreCase("Y"))
        {
            pageSteps.setCheckBoxAtTableCellPRTimesheet("Details", "No Dinner", 1, isNoDinner);
            if (notEmpty(isNoLunch))
                pageSteps.confirm("OK");
            pageSteps.setCheckBoxAtTableCellPRTimesheet("Details", "No Lunch", 1, isNoLunch);
            if (notEmpty(isNoDinner))
                pageSteps.confirm("OK");
            pageSteps.setCheckBoxAtTableCellPRTimesheet("Details", "No Supper", 1, isNoSupper);
            if (notEmpty(isNoSupper))
                pageSteps.confirm("OK");
        }
        if (notEmpty(payByActualWH) && (notEmpty(isNoLunch) || notEmpty(isNoDinner) || notEmpty(isNoSupper)))
            pageSteps.confirm("OK"); // if not valid lunch time, confirm before proceed
        if (salType.equals("Basic OT"))
            pageSteps.setCheckBoxAtTableCellPRTimesheet("Details", "Pay Emp Based On Actual Clock In Time", 1, payByActualWH);
        pageSteps.clickButton("Submit");
        pageSteps.confirm("Yes");
        pageSteps.confirm("OK"); // to accept additional voucher
    }

    @Step("Input records at No Recods tab with Apply Meal Break = {3}")
    public void inputNoRecord(String tsDate, String empDetail, String salType, String applyLunchBreak, String payByActualWH, String confirmAllorOne,
                              boolean addMoreBF)
    {
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detailNo = getColumn_Detail(detNo);
            String empC = getColumn_Detail(detNo_Emp);
            String timeIn = getColumn_Detail(detNo_TimeIn);
            String dateIn = getColumn_Detail(detNo_DateIn);
            String timeOut = getColumn_Detail(detNo_TimeOut);
            String dateOut = getColumn_Detail(detNo_DateOut);
            String projectNo = getColumn_Detail(detNo_ProjectNo);
            String phaseNo = getColumn_Detail(detNo_PhaseNo);
            String actualLoc = getColumn_Detail(detNo_ActualLoc);
            String isNoLunch = getColumn_Detail(detNo_IsNoLunch);
            String isNoDinner = getColumn_Detail(detNo_IsNoDinner);
            String isNoSupper = getColumn_Detail(detNo_IsNoSupper);
            String noAddingAtTSDetail = getColumn_Detail(detNo_NoAddingAtTSDetails);

            String isTravel = "";
            String travelHours = "";
            String addMore = "";
            String addMoreNrOnly = "";
            if (salType.equalsIgnoreCase("Timeslot"))
            {
                isTravel = getColumn_Detail(detNo_TimeSlot_IsTravel);
                travelHours = getColumn_Detail(detNo_TimeSlot_TravelHours);
                addMore = getColumn_Detail(detNo_TimeSlot_AddMoreRecord);
                addMoreNrOnly = getColumn_Detail(detNo_TimeSlot_AddMoreNROnly);
                noAddingAtTSDetail = getColumn_Detail(detNo_TimeSlot_NoAddingAtTSDetails);
            }
            else
            {
                addMore = getColumn_Detail(detNo_AddMoreRecord);
                addMoreNrOnly = getColumn_Detail(detNo_AddMoreNROnly);
            }

            if (empDetail.equals(detailNo))
            {
                if (!(!addMoreBF && dateIn.equals("N"))) // cannot add records with Date In = N at NR after submit
                {
                    if (equals(addMoreNrOnly, "Y"))
                    {
                        pageSteps.setTableFilterAtPRTimesheet("No Record", "Employee Code", empC);
                        if (pageSteps.getRowsCount("Time In") > 0)
                        {
                            addNoRecord(i, tsDate, dateIn, timeIn, dateOut, timeOut, addMoreBF, projectNo, isTravel, travelHours, actualLoc,
                                        applyLunchBreak, isNoDinner, isNoLunch, isNoSupper, salType, payByActualWH, confirmAllorOne);
                        }

                    }
                    if (notEmpty(timeIn) && equals(addMore, "Y") && !equals(addMoreNrOnly, "Y"))
                    {
                        if (notEmpty(isNoLunch) || notEmpty(isNoDinner) || notEmpty(isNoSupper))
                            pageSteps.confirm("OK");// check for invalid eating break before adding new record
                        pageSteps.clickButton("Add");
                        pageSteps.setTextAtTableCellPRTimeSheet("No Record", "Employee Code", 1, empC);
                        // waitForTextValueToShow("//table[@id='frmDraftTS:tblManDet']/tbody/tr[1]/td[2]",
                        // 10);
                        addNoRecord(i, tsDate, dateIn, timeIn, dateOut, timeOut, addMoreBF, projectNo, isTravel, travelHours, actualLoc,
                                    applyLunchBreak, isNoDinner, isNoLunch, isNoSupper, salType, payByActualWH, confirmAllorOne);
                    }
                }
            }
        }
        if (confirmAllorOne.equalsIgnoreCase("A"))
        {// confirm after all
            // record
            pageSteps.waitForAjax(3);
            pageSteps.clickButton("Confirm");
            pageSteps.confirm("Yes");
            pageSteps.confirm("OK");
        }
    }

    @Step("Add record {0}")
    public void addNoRecord(int j, String tsDate, String dateIn, String timeIn, String dateOut, String timeOut, boolean addMoreBF, String projectNo,
                            String isTravel, String travelHours, String actualLoc, String applyLunchBreak, String isNoDinner, String isNoLunch,
                            String isNoSupper, String salType, String payByActualWH, String confirmAllorOne)
    {
        pageSteps.setTextAtTableCellPRTimeSheet("No Record", "Time In", 1, timeIn);
        if (dateIn.equals("C"))
            dateIn = tsDate;
        else if (dateIn.equals("N")) // next day
            dateIn = DateTimeUtil.addDays(tsDate, 1);
        if (dateOut.equals("C"))
            dateOut = tsDate;
        else if (dateOut.equals("N"))
            dateOut = DateTimeUtil.addDays(tsDate, 1);

        if (addMoreBF)
        {
            pageSteps.setTextAtTableCellPRTimeSheet("No Record", "Date In", 1, dateIn);
            pageSteps.setTextAtTableCellPRTimeSheet("No Record", "Time Out", 1, timeOut);
            pageSteps.setTextAtTableCellPRTimeSheet("No Record", "Date Out", 1, dateOut);
        }

        pageSteps.setTextAtTableCellPRTimeSheet("No Record", "Time Out", 1, timeOut);

        if (notEmpty(projectNo))
        {
            pageSteps.setTextAtTableCellPRTimeSheet("No Record", "Project No.", 1, projectNo);
            // setTextAtTableCellPRTimeSheet("No Record", "Phase
            // Sequence No.", 1, phaseNo);
        }

        if (notEmpty(isTravel))
        {
            pageSteps.setCheckBoxAtTableCellPRTimesheet("No Record", "Travel", 1, isTravel);
            pageSteps.setTextAtTableCellPRTimeSheet("No Record", "Travel Hours", 1, travelHours);
        }

        pageSteps.setTextAtTableCellPRTimeSheet("No Record", "Actual Working Location", 1, actualLoc);
        if (applyLunchBreak.equalsIgnoreCase("Y"))
        {
            pageSteps.setCheckBoxAtTableCellPRTimesheet("No Record", "No Dinner", 1, isNoDinner);
            if (notEmpty(isNoLunch))
                pageSteps.confirm("OK");
            pageSteps.setCheckBoxAtTableCellPRTimesheet("No Record", "No Lunch", 1, isNoLunch);
            if (notEmpty(isNoDinner))
                pageSteps.confirm("OK");
            pageSteps.setCheckBoxAtTableCellPRTimesheet("No Record", "No Supper", 1, isNoSupper);
            if (notEmpty(isNoSupper))
                pageSteps.confirm("OK");
        }
        if (notEmpty(payByActualWH) && (notEmpty(isNoLunch) || notEmpty(isNoDinner) || notEmpty(isNoSupper)))
            pageSteps.confirm("OK"); // if not valid lunch time, confirm before proceed
        if (salType.equals("Basic OT"))
            pageSteps.setCheckBoxAtTableCellPRTimesheet("No Record", "Pay Emp Based On Actual Clock In Time", 1, payByActualWH);

        pageSteps.setCheckBoxAtTableCellPRTimesheet("No Record", "Sel", 1, "Y");
        if (confirmAllorOne.equalsIgnoreCase("O"))
        {
            pageSteps.waitForAjax(3);
            pageSteps.clickButton("Confirm");
            pageSteps.confirm("Yes");
            pageSteps.confirm("OK");
        }
    }

    public ArrayList<String> getEmpPrefix(String salType)
    {
        // get emmpPrefix in excel
        ArrayList<String> empPrefixes = new ArrayList<>();
        setTable(salType);
        for (i_detail = 2; i_detail <= detailObjArray.length; i_detail++) // i = 2: no getting the header
        {
            String empCode = getColumn_Detail(detNo_Emp);
            empPrefixes.add(empCode);
        }
        return empPrefixes;
    }

    @Step("Set Leaving Earyly Deduction = {2}, Lateness Deduction = {1}")
    public void setDeduction(String salType, String latenessDeduction, String leaveEarlyDeduction)
    {
        if (latenessDeduction.trim().equalsIgnoreCase("N"))
            latenessDeduction = "N";
        else if (latenessDeduction.trim().equalsIgnoreCase("Y"))
            latenessDeduction = "Y";

        if (leaveEarlyDeduction.trim().equalsIgnoreCase("N"))
            leaveEarlyDeduction = "N";
        else if (leaveEarlyDeduction.trim().equalsIgnoreCase("Y"))
            leaveEarlyDeduction = "Y";

        // get emmpPrefix in excel
        ArrayList<String> empPrefixes = getEmpPrefix(salType);

        if (empPrefixes.size() > 0)
        {
            String emps = "";
            emps = "(";
            for (String emp : empPrefixes)
                emps += "'" + emp + "', ";
            emps += "'')";

            String sqlUpdateLeaveEarly = "update mt_employee set LATENESS_DEDUCTION='" + latenessDeduction + "',  " +
                    "LEAVING_EARLY_DEDUCTION = '" + leaveEarlyDeduction + "' WHERE EMPLOYEE_CODE IN " + emps;
            executeUpdate(sqlUpdateLeaveEarly);
        }
    }

    @Step("Cancel leave application of timesheet date {2}")
    public void cancelLeaveApp(String tsDate, String salType, String empDetailNo)
    {
        ArrayList<String> cancelledList = new ArrayList<>();
        cancelledList.clear();

        pageSteps.goToMenu(MenuID.PROC_LV_APPLICATION);
        pageSteps.goToTab("History");

        setTable(salType);
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detailNo = getColumn_Detail(detNo);
            if (detailNo.equals(empDetailNo))
            {
                String cancelLeave = getColumn_Detail(detNo_CancelLeave);
                if (notEmpty(cancelLeave) && equals(cancelLeave, "Y"))
                {
                    String empC = getColumn_Detail(detNo_Emp);
                    // get employee name
                    String applicant = getColumnValue("select employee_name from mt_employee where employee_code = '" + empC + "'", "EMPLOYEE_NAME");
                    pageSteps.setTableFilter("Applicant Name", applicant);
                    pageSteps.setTableFilter("Application Date", tsDate, 1);
                    if (pageSteps.getRowsCount("Applicant Name") == 1)
                    {
                        pageSteps.selectFirstRow(" Application No");
                        if (pageSteps.getRowsCount("Sel") > 0) // application has not been cancelled
                        {
                            pageSteps.setCheckBoxAtTableCell("Sel", 1, "Y");
                            pageSteps.clickButton("Cancel");
                            pageSteps.confirm("Yes");
                            pageSteps.clickButton("Back To Summary");
                            cancelledList.add("1");
                        }
                    }
                }
            }
        }

        if (cancelledList.size() > 0) // only approve if there are cancelled leave apps
        {
            // approve all cancelled leave apps
            pageSteps.goToMenu(MenuID.PROC_APPROVAL_SUMMARY);
            pageSteps.selectRowInQueueAtTableApprovalSummary("Leave Cancellation");
            //setRadioApprovalAtMultiList("Leave Application No.", "Approve");
            if (pageSteps.getRowsCount("Leave Application No.") > 0)
            {
                pageSteps.approveAllAtTableApprovalSummary("Approve");
            }
        }

    }

    @Step("Create leave application")
    public void createLeaveApp(String tsDate, String salType, String leaveType, String empDetailNo)
    {
        ArrayList<String> createdList = new ArrayList<>();
        createdList.clear();

        pageSteps.goToMenu(MenuID.PROC_LV_APPLICATION);
        setTable(salType);
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detailNo = getColumn_Detail(detNo);
            if (detailNo.equalsIgnoreCase(empDetailNo))
            {
                String applyLeaveFromLA = getColumn_Detail(detNo_ApplyLeaveFromLA);
                if (applyLeaveFromLA.equalsIgnoreCase("Y")) // create leave app for these records
                {
                    String empC = getColumn_Detail(detNo_Emp); // create leave app for these employees
                    String leaveDuration = getColumn_Detail(detNo_LeaveDuration);

                    addLeaveRecord(tsDate, empC, leaveType, leaveDuration);
                    createdList.add("1");
                }
            }
        }

        if (createdList.size() > 0) // only approve if there are created leave apps
        {
            // approve all after created leave apps
            pageSteps.goToMenu(MenuID.PROC_APPROVAL_SUMMARY);
            pageSteps.selectRowInQueueAtTableApprovalSummary("Leave Application (TH5)");

            if (pageSteps.getRowsCount("Leave Application No.") > 0)
                pageSteps.approveAllAtTableApprovalSummary("Approve");
        }
    }

    @Step("Add leave for employee {1} on {0} with leave type {2}, duration = {3}")
    public void addLeaveRecord(String tsDate, String empC, String leaveType, String leaveDuration)
    {
        pageSteps.clickButton("New");
        pageSteps.clickSearchButton();
        pageSteps.setText("Employee Code", empC);
        pageSteps.selectFirstRow("Employee Code");
        pageSteps.setText("Application Date", tsDate);
        String lvAppVoucherNo = pageSteps.getTextDesc("Leave Application No."); // get leave app voucher no
        pageSteps.clickButton("Add");
        pageSteps.setTextAtTableCell("Leave Type", 1, leaveType);
        pageSteps.setDropDownOptionAtTableCell("Duration Type", 1, leaveDuration);
        pageSteps.setTextAtTableCell("Date From", 1, tsDate);

        if (pageSteps.checkTextExist("Please apply leave application from Consolidate timesheet", false))
        {
            //			confirm("OK");
            //			clickButton("Abort");
            //			confirm("Yes");

            // delete leave app by sql
            deleteLeaveApp(lvAppVoucherNo);
            // back to Leave App after delete the leave
            pageSteps.goToMenu(MenuID.PROC_LV_APPLICATION);
            pageSteps.confirm("No"); // leftover msg
            pageSteps.waitForTextToVanish("No", 3);
        }
        else
        {
            if (pageSteps.checkTextExist("Date From: This period is overlapping with period:", false))
            {
                //				confirm("OK");
                //				clickButton("Abort");
                //				confirm("Yes");

                // delete leave app by sql
                deleteLeaveApp(lvAppVoucherNo);
                // back to Leave App after delete the leave
                pageSteps.goToMenu(MenuID.PROC_LV_APPLICATION);
                pageSteps.confirm("No"); // leftover msg
                pageSteps.waitForTextToVanish("No", 3);
            }
            else
            {
                // setTextAtTableCell("Date To", 1, tsDate); // no need
                pageSteps.clickButton("Submit");
                pageSteps.confirmNoOk("Yes"); // confirm without click OK to get the error msg
                if (pageSteps.checkTextExist("There is no need to apply leave", false))
                {
                    //					confirm("OK");
                    //					confirm("No"); // in case there is confirmation for previous submission remains
                    //					if (checkValueExist("Abort"))
                    //					{
                    //						clickButton("Abort");
                    //						confirm("Yes");
                    //					}

                    // delete leave app by sql
                    deleteLeaveApp(lvAppVoucherNo);
                    // back to Leave App after delete the leave
                    pageSteps.goToMenu(MenuID.PROC_LV_APPLICATION);
                    pageSteps.confirm("No"); // leftover msg
                    pageSteps.waitForTextToVanish("No", 3);
                }
                else
                    pageSteps.confirm("Yes"); // in case warning
            }
        }
    }

    public void deleteLeaveApp(String lvAppVoucherNo)
    {
        executeUpdate("DELETE FROM LV_APPLICATION_LV_TYPE WHERE LV_APP_VOUCHER_NO = '" + lvAppVoucherNo + "'");
        executeUpdate("DELETE FROM LV_APPLICATION WHERE LV_APP_VOUCHER_NO = '" + lvAppVoucherNo + "'");
    }

    @Step("Apply leave from No Record with Leave Type = {1}, Leave Session = {2}, Allocate PJ = {3}")
    public void applyLeaveNR(String empDetail, String leaveType, String allocatePJToLeave)
    {
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detailNo = getColumn_Detail(detNo);
            String empC = getColumn_Detail(detNo_Emp);
            String leaveDuration = getColumn_Detail(detNo_LeaveDuration);
            String applyLeaveFromNR = getColumn_Detail(detNo_ApplyLeaveFromNR);
            if (empDetail.equals(detailNo))
            {
                if (notEmpty(applyLeaveFromNR) && equals(applyLeaveFromNR, "Y"))
                {// generate
                    // leave
                    // app
                    pageSteps.setTableFilterAtPRTimesheet("No Record", "Employee Code", empC);
                    if (pageSteps.getRowsCount("Time In") > 0)
                    {
                        if (allocatePJToLeave.equalsIgnoreCase("Y"))
                        {
                            String allocPJ = getColumn_Detail(18);
                            pageSteps.setTextAtTableCellPRTimeSheet("No Record", "Project No.", 1, allocPJ);
                        }
                        pageSteps.setTextAtTableCellPRTimeSheet("No Record", "Leave Type", 1, leaveType);
                        pageSteps.setDropDownOptionAtTableCellPRTimesheet("No Record", "Leave Type", 1, leaveDuration);
                        pageSteps.setCheckBoxAtTableCellPRTimesheet("No Record", "Sel", 1, "Y");
                        pageSteps.waitForAjax(3);
                        pageSteps.clickButton("Generate Leave Application");
                        pageSteps.waitForAjax(3);
                        pageSteps.confirm("OK");
                    }
                }
            }
        }
    }

    @Step("Generate payslip for employee {5}")
    public void genPayslipFor(String glPostDate, String tsDate, String paymentCycle, String epcCode, String salType, String generatePayslipFor)
    {
//        goToMenu(MenuID.PROC_PY_PAYROLL_GENERATION);
//        clickButton("New");
//        setText("Payroll GL Posting Date", glPostDate);
//        setText("Year", DateTimeUtil.getTimeType(tsDate, Calendar.YEAR) + "");
//        setText("Month", DateTimeUtil.getTimeType(tsDate, Calendar.MONTH) + "");
//        setText("Payment Cycle Code", paymentCycle); // hard code
//        // setRadioOption("Payment Cycle No.", "1st"); // hard code
//        // setRadioOption("Generate payslip for advancement", "No"); // hard code
//        setRadioOption("Generate Payslip By", "Employee Payroll Category");
//        // hard code
//        // setCheckBoxAtMultiList("Employee Payroll Category",epcCode, "Y", false); // select EPC
//        // levin workaround
//        int rowNo = getRowNumber("Employee Payroll Category", epcCode);
//        try
//        {
//            clickAtXpathCSS("//tbody[@id='allGeneration:EmpPayrollCategoryTblId:tb']/tr[1]/td[1]//input");
//        } catch (Exception e)
//        {
//            customAssert("Cannot generate");
//        }
//        waitForAjax(1);
//        clickButton("Generate Payslip");
//        confirm("Yes");
//        confirm("Yes");//levin check
//        // Levin note: goto payslip tab, remove unneed payslip
//        goToMenu(MenuID.PROC_PY_PAYROLL_GENERATION);
//        goToTab("Payslip");
//        ArrayList<String> empPrefixes = getEmpPrefix(salType);
//        if (empPrefixes.size() > 0)
//        {
//            for (String empCode : empPrefixes)
//            {
//                if (!empCode.equalsIgnoreCase(generatePayslipFor))
//                {
//                    setTableFilter("Voucher Date", glPostDate);
//                    setTableFilter("Employee Code", empCode);
//                    selectFirstRow("Payslip Voucher No");
//                    clickButton("Delete");
//                    confirm("Yes");
//                }
//            }
//        }
    }

    @Step("Pulling out data of timesheet date {1} from backend")
    public void pullOutData(String dataset, String tsDate)
    {
        setDetailData_Child("SQL");
        for (i_child = 1; i_child <= detailObjArray_Child.length; i_child++)
        {
            if (notEmpty(getColumn_Child(1)))
            {
                String tableName = getColumn_Child(2);
                String statement = getColumn_Child(3);
                String replacedTsDate = DateTimeUtil.reverseDate(tsDate);
                statement = statement.replace("?", replacedTsDate);
                ResultSet rs = getResultStatement(statement);

                ExcelUtils.createExcelFile(sqlResult, tableName);
                ExcelUtils.createExistingColumns(sqlResult, tableName, rs);
                ExcelUtils.createExistingCells(sqlResult, tableName, rs);
            }
        }

        // update properties file for the CheckSQL_Consol script to write SQL to
        String outputSQL = "";
        if (dataset.contains("BasicOT_Flexible") && dataset.contains("_NoRound"))
            outputSQL = "sql.output.basicot.flexible.noround";
        if (dataset.contains("BasicOT_Flexible") && dataset.contains("_Round"))
            outputSQL = "sql.output.basicot.flexible.round";
        if (dataset.contains("BasicOT_FixedRate") && dataset.contains("_NoRound"))
            outputSQL = "sql.output.basicot.fixedrate.noround";
        if (dataset.contains("BasicOT_FixedRate") && dataset.contains("_Round"))
            outputSQL = "sql.output.basicot.fixedrate.round";
        if (dataset.contains("BasicOT_TimeRange"))
            outputSQL = "sql.output.basicot.timerange";
        if (dataset.contains("BasicOT_WorkingHour"))
            outputSQL = "sql.output.basicot.workinghour";
        if (dataset.contains("BasicSalary"))
            outputSQL = "sql.output.basicsalary";
        if (dataset.contains("HourlyRate_TimeRange") && !dataset.contains("NWT") && !dataset.contains("UD"))
            outputSQL = "sql.output.hourlyrate.timerange";
        if (dataset.contains("HourlyRate_TimeRange") && dataset.contains("NWT") && !dataset.contains("UD"))
            outputSQL = "sql.output.hourlyrate.timerange.nwt";
        if (dataset.contains("HourlyRate_TimeRange_UD"))
            outputSQL = "sql.output.hourlyrate.timerange.ud";
        if (dataset.contains("HourlyRate_WorkingHour"))
            outputSQL = "sql.output.hourlyrate.workinghour";
        if (dataset.contains("PieceRate"))
            outputSQL = "sql.output.piecerate";
        if (dataset.contains("TimeSlot"))
            outputSQL = "sql.output.timeslot";

        ReadBean.updateProp("settings.properties", outputSQL, sqlResult, "Timesheet Config");
    }

    String consolTSNo = "";

    int detNo                      = 1;
    int detNo_Emp                  = 2;
    int detNo_TimeIn               = 3;
    int detNo_DateIn               = 4;
    int detNo_TimeOut              = 5;
    int detNo_DateOut              = 6;
    int detNo_ProjectNo            = 7;
    int detNo_PhaseNo              = 8;
    int detNo_ActualLoc            = 9;
    int detNo_IsNoLunch            = 10;
    int detNo_IsNoDinner           = 11;
    int detNo_IsNoSupper           = 12;
    int detNo_LeaveDuration        = 13;
    int detNo_ApplyLeaveFromLA     = 14;
    int detNo_CancelLeave          = 15;
    int detNo_ApplyLeaveFromNR     = 16;
    int detNo_AddMoreRecord        = 17;
    int detNo_AddMoreNROnly        = 18;
    int detNo_AllocProjToLeaveAtNR = 19;
    int detNo_NoAddingAtTSDetails  = 20;

    int detNo_TimeSlot_IsTravel             = 13;
    int detNo_TimeSlot_TravelHours          = 14;
    int detNo_TimeSlot_LeaveDuration        = 15;
    int detNo_TimeSlot_ApplyLeaveFromLA     = 16;
    int detNo_TimeSlot_CancelLeave          = 17;
    int detNo_TimeSlot_ApplyLeaveFromNR     = 18;
    int detNo_TimeSlot_AddMoreRecord        = 19;
    int detNo_TimeSlot_AddMoreNROnly        = 20;
    int detNo_TimeSlot_AllocProjToLeaveAtNR = 21;
    int detNo_TimeSlot_NoAddingAtTSDetails  = 22;
}