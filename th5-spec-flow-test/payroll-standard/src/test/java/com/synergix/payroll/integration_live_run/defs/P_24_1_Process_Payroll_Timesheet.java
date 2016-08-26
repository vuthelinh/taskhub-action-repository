package com.synergix.payroll.integration_live_run.defs;

import com.synergix.common.CONST;
import com.synergix.common.actions.DatasetBase;
import com.synergix.common.actions.PageSteps;
import com.synergix.common.constants.MenuID;
import com.synergix.utilities.DateTimeUtil;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

public class P_24_1_Process_Payroll_Timesheet extends DatasetBase
{
    @Steps
    PageSteps pageSteps;
    String runCode;

    @Title("Integration Test for Live Run Steps - Payroll")
    @Given("^Payroll Timesheet flow is created as in\\s+\"([^\"]*)\"$")
    public void testFlow(String dataset)
    {
        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
        setDataset("Dataset");
        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String tsDate = getColumn(1);
            String glPostDate = getColumn(2);
            String defWkrLocation = getColumn(3);
            String salType = getColumn(4);
            String applyLunchBreak = getColumn(5);
            String payByActualWH = getColumn(6);
            String addMoreFromNoRecord = getColumn(7);
            String addMoreFromTSDetail = getColumn(8);
            String empDetailNo = getColumn(9);

            if (empty(tsDate))
                continue;

            pageSteps.goToMenu(MenuID.PROC_PY_PAYROLL_TIMESHEET);
            pageSteps.clickButton("New");
            pageSteps.setText("Timesheet Date", tsDate);
            pageSteps.setText("Default Working Location", defWkrLocation);
            pageSteps.setDropDownOption("Salary Type", salType);
            pageSteps.goToTab("Manual");

            // read data from employee records tab based on salary type
            setDetailData("Timesheet");

            inputDraft(tsDate, empDetailNo, salType, applyLunchBreak, payByActualWH, addMoreFromNoRecord, addMoreFromTSDetail);

            pageSteps.clickButton("Submit");
            pageSteps.confirm("Yes");

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
            pageSteps.confirm("OK");
            // get Consolidate Timesheet number - CTS0000XXX
            String consolTSNo = pageSteps.getTextDesc("Consolidated Timesheet No.");

            // Step 3 - Add more at TS Details BEFORE Generating Consol
            /// ----1---- add more timesheet record before consol submission
            /// ----1.1-- add more at ts details
            if (addMoreFromTSDetail.equalsIgnoreCase("2"))
            {
                pageSteps.goToMenu(MenuID.PROC_PY_TIMESHEET_DETAIL);
                inputDetail(addMoreFromTSDetail, tsDate, empDetailNo, salType, applyLunchBreak, payByActualWH);
            }
            /// ----1.2-- add more at no record
            // Step 4 - Cancel leave - apply leave from No Record from Draft
            pageSteps.goToMenu(MenuID.PROC_PY_PAYROLL_TIMESHEET);
            pageSteps.goToTab("Consolidated Timesheet");
            pageSteps.setTableFilter("Timesheet No.", consolTSNo);
            pageSteps.waitForAjax(3);
            pageSteps.selectFirstRow("Timesheet No.");
            pageSteps.setText("Payroll GL Posting Date", glPostDate);
            pageSteps.goToTab("No Record");
            // Step 4 - End
            // add more record to No Record BEFORE Consol Submission
            if (addMoreFromNoRecord.equalsIgnoreCase("2"))
            {
                //// add records from basic ot tab with time in = time out
                inputNoRecord(tsDate, empDetailNo, salType, applyLunchBreak, payByActualWH, true);
                // end of loop
            }
            // SUBMIT CONSOL
            pageSteps.clickButton("Submit");
            pageSteps.confirm("Yes");
            pageSteps.confirm("Yes");// in case warning for records both exists in Leave/NoRecord
            pageSteps.confirm("OK");

            // check if consol really is submitted, if not, submit again
            String status = getColumnValue("SELECT STATUS FROM py_consol_timesheet WHERE TIMESHEET_DATE = '" + DateTimeUtil.reverseDate(tsDate) + "'",
                                           "STATUS");
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
                inputNoRecord(tsDate, empDetailNo, salType, applyLunchBreak, payByActualWH, false);
            }
        }
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
            String phaseNo = getColumn_Detail(detNo_PhaseNo);
            String actualLoc = getColumn_Detail(detNo_ActualLoc);
            String isNoLunch = getColumn_Detail(detNo_IsNoLunch);
            String isNoDinner = getColumn_Detail(detNo_IsNoDinner);
            String isNoSupper = getColumn_Detail(detNo_IsNoSupper);
            String isTravel = getColumn_Detail(detNo_IsTravel);
            String travelHours = getColumn_Detail(detNo_TravelHours);
            String addMore = getColumn_Detail(detNo_AddMoreRecord);
            String addMoreNrOnly = getColumn_Detail(detNo_AddMoreNROnly);

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
            String phaseNo = getColumn_Detail(detNo_PhaseNo);
            String actualLoc = getColumn_Detail(detNo_ActualLoc);
            String isNoLunch = getColumn_Detail(detNo_IsNoLunch);
            String isNoDinner = getColumn_Detail(detNo_IsNoDinner);
            String isNoSupper = getColumn_Detail(detNo_IsNoSupper);
            String isTravel = getColumn_Detail(detNo_IsTravel);
            String travelHours = getColumn_Detail(detNo_TravelHours);
            String addMore = getColumn_Detail(detNo_AddMoreRecord);
            String addMoreNrOnly = getColumn_Detail(detNo_AddMoreNROnly);

            if (empDetail.equals(detailNo))
            {// not allow adding from TS Details with clock in time after the clock in time in Draft TS

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
                            pageSteps.waitForProgressBar(1);
                            pageSteps.clickButton("Delete"); // clear invalid records
                            pageSteps.confirm("Yes");
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
                    else
                    {
                        if (notEmpty(isNoLunch) || notEmpty(isNoDinner) || notEmpty(isNoSupper))
                            pageSteps.confirm("OK");// check for invalid eating break before adding new record
                        pageSteps.clickButton("Add");
                        addDetail(i, tsDate, dateIn, timeIn, dateOut, timeOut, projectNo, actualLoc, applyLunchBreak, isNoDinner, isNoLunch,
                                  isNoSupper, salType, payByActualWH);
                    }
                }
                if (notEmpty(timeIn) && equals(addMore, "Y") && !equals(addMoreNrOnly, "Y"))
                {
                    pageSteps.clickButton("Add");
                    addDetail(i, tsDate, dateIn, timeIn, dateOut, timeOut, projectNo, actualLoc, applyLunchBreak, isNoDinner, isNoLunch, isNoSupper,
                              salType, payByActualWH);
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
    public void inputNoRecord(String tsDate, String empDetail, String salType, String applyLunchBreak, String payByActualWH, boolean addMoreBF)
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
            String isTravel = getColumn_Detail(detNo_IsTravel);
            String travelHours = getColumn_Detail(detNo_TravelHours);
            String addMore = getColumn_Detail(detNo_AddMoreRecord);
            String addMoreNrOnly = getColumn_Detail(detNo_AddMoreNROnly);

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
                                        applyLunchBreak, isNoDinner, isNoLunch, isNoSupper, salType, payByActualWH);
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
                                    applyLunchBreak, isNoDinner, isNoLunch, isNoSupper, salType, payByActualWH);
                    }
                }
            }
        }
    }

    @Step("Add record {0}")
    public void addNoRecord(int j, String tsDate, String dateIn, String timeIn, String dateOut, String timeOut, boolean addMoreBF, String projectNo,
                            String isTravel, String travelHours, String actualLoc, String applyLunchBreak, String isNoDinner, String isNoLunch,
                            String isNoSupper, String salType, String payByActualWH)
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
        pageSteps.clickButton("Confirm");
        pageSteps.confirm("Yes");
        pageSteps.confirm("OK");
    }

    int detNo               = 1;
    int detNo_Emp           = 2;
    int detNo_TimeIn        = 3;
    int detNo_DateIn        = 4;
    int detNo_TimeOut       = 5;
    int detNo_DateOut       = 6;
    int detNo_ProjectNo     = 7;
    int detNo_PhaseNo       = 8;
    int detNo_ActualLoc     = 9;
    int detNo_IsNoLunch     = 10;
    int detNo_IsNoDinner    = 11;
    int detNo_IsNoSupper    = 12;
    int detNo_IsTravel      = 13;
    int detNo_TravelHours   = 14;
    int detNo_AddMoreRecord = 15;
    int detNo_AddMoreNROnly = 16;
}