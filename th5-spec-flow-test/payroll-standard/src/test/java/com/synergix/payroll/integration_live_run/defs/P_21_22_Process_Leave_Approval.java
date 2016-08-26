package com.synergix.payroll.integration_live_run.defs;

import com.synergix.common.CONST;
import com.synergix.common.actions.DatasetBase;
import com.synergix.common.actions.PageSteps;
import com.synergix.common.constants.ElementID;
import com.synergix.common.constants.MenuID;
import com.synergix.utilities.DateTimeUtil;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

public class P_21_22_Process_Leave_Approval extends DatasetBase
{
    @Steps
    PageSteps pageSteps;
    String runCode;
    String currentYear;

    @Title("Integration Test for Live Run Steps - Payroll")
    @Given("^Leave & Approval flow is created as in\\s+\"([^\"]*)\"$")
    public void testFlow(String dataset)
    {
        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
        setDataset("Dataset");
        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String flowName = getColumn(1);
            currentYear = getColumn(2);

            if (empty(flowName))
                continue;

            // set fail subject and message
            setFailSubject("Leave & Approval Process Report - Fail");
            setFailMessage("Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + " / Code: " + flowName);

            // update calendar year to current year
            try
            {
                executeUpdateWithExc(
                        "UPDATE MODULE_CONFIG SET PROPERTY_VALUE = '" + currentYear + "' WHERE MODULE_CODE = 'LV' AND PROPERTY_NAME = 'currentCalendarYear'");
            } catch (Exception e)
            {
                // nothing happens if cannot update DB
            }

            pageSteps.goToMenu(MenuID.PROC_LV_ENTITLEMENT);
            createLeaveEntitlement(flowName);

            pageSteps.goToMenu(MenuID.PROC_LV_APPLICATION);
            createLeaveApp(flowName);

            pageSteps.goToMenu(MenuID.PROC_LV_APPLICATION);
            pageSteps.goToTab("History");
            cancelLeaveApp(flowName);

            pageSteps.goToMenu(MenuID.PROC_APPROVAL_SUMMARY);
            approval(flowName);

            String report = pageSteps.getTableReport();
            writeReport(report);
            sendEmailToPY("Leave & Approval Process Report - Success",
                          "Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + " / Code: " + flowName + "\n" + report,
                          ElementID.REPORT_FILE);
            pageSteps.verifyStepResult(report);
        }
        pageSteps.verifyFinalResult("Leave & Approval Process");
    }

    @Step("Approve/Reject leave apps for flow {0}")
    private void approval(String flowName)
    {
        setDetailData("Leave Application");
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detNo = getColumn_Detail(1);
            if (detNo.equalsIgnoreCase(flowName))
            {
                String applicant = getColumn_Detail(2);
                String appDate = getColumn_Detail(3);
                String cancelLeaveApp = getColumn_Detail(4);
                String approve = getColumn_Detail(5);

                if (notEmpty(applicant))
                {
                    pageSteps.selectRowInQueueAtTableApprovalSummary("Leave Application");
                    // approve leave app
                    String voucherNoSql = "select LV_APP_VOUCHER_NO from LV_APPLICATION where APPLICATION_CODE='" + applicant + "' and APPLICATION_DATE='" + DateTimeUtil.reverseDate(
                            appDate) + "'";
                    if (!cancelLeaveApp.equalsIgnoreCase("Y"))
                    {
                        // get leave app voucher no
                        String leaveAppVoucher = getColumnValue(voucherNoSql, "LV_APP_VOUCHER_NO");
                        pageSteps.setTableFilter("Leave Application No.", leaveAppVoucher);
                        if (approve.equalsIgnoreCase("Y"))
                        {
                            pageSteps.setRadioOptionAtTableCell("Action", 1, "Approve");
                            pageSteps.verifyResult("Leave Application Approve", pageSteps.isRadioOptionAtTableCellChecked("Action", 1, "Approve"));
                        }
                        else if (approve.equalsIgnoreCase("N"))
                        {
                            pageSteps.setRadioOptionAtTableCell("Action", 1, "Reject");
                            pageSteps.verifyResult("Leave Application Reject", pageSteps.isRadioOptionAtTableCellChecked("Action", 1, "Reject"));
                        }
                        pageSteps.clickButton("Submit");
                        pageSteps.confirm("Yes");
                    }

                    pageSteps.selectRowInQueueAtTableApprovalSummary("Leave Cancellation");
                    if (cancelLeaveApp.equalsIgnoreCase("Y"))
                    {
                        // get leave app voucher no
                        String leaveAppVoucher = getColumnValue(voucherNoSql, "LV_APP_VOUCHER_NO");
                        pageSteps.setTableFilter("Leave Application No.", leaveAppVoucher);
                        if (approve.equalsIgnoreCase("Y"))
                        {
                            pageSteps.setRadioOptionAtTableCell("Action", 1, "Approve");
                            pageSteps.verifyResult("Leave Cancellation Approve", pageSteps.isRadioOptionAtTableCellChecked("Action", 1, "Approve"));
                        }
                        else if (approve.equalsIgnoreCase("N"))
                        {
                            pageSteps.setRadioOptionAtTableCell("Action", 1, "Reject");
                            pageSteps.verifyResult("Leave Cancellation Reject", pageSteps.isRadioOptionAtTableCellChecked("Action", 1, "Reject"));
                        }
                        pageSteps.clickButton("Submit");
                        pageSteps.confirm("Yes");
                    }
                }
            }
        }
    }

    @Step("Cancel leave apps for flow {0}")
    private void cancelLeaveApp(String flowName)
    {
        setDetailData("Leave Application");
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detNo = getColumn_Detail(1);
            if (detNo.equalsIgnoreCase(flowName))
            {
                String applicant = getColumn_Detail(2);
                String appDate = getColumn_Detail(3);
                String cancelLeaveApp = getColumn_Detail(4);

                if (cancelLeaveApp.equalsIgnoreCase("Y"))
                {
                    // get applicant name
                    applicant = getColumnValue("select employee_name from mt_employee where employee_code = '" + applicant + "'", "EMPLOYEE_NAME");
                    pageSteps.setTableFilter("Applicant Name", applicant);
                    pageSteps.setTableFilter("Application Date", appDate, 1);
                    if (pageSteps.getRowsCount("Applicant Name") == 1)
                    {
                        pageSteps.selectFirstRow(" Application No");
                        if (pageSteps.getRowsCount("Sel") > 0) // application has not been cancelled
                        {
                            pageSteps.setCheckBoxAtTableCell("Sel", 1, "Y");
                            pageSteps.verifyResult("Tick Cancel Leave App Voucher", pageSteps.isCheckBoxAtTableCellChecked("Sel", 1, "Y"));

                            pageSteps.clickButton("Cancel");
                            pageSteps.confirmNoOk("Yes");
                            pageSteps.verifyResult("Cancel Leave App", pageSteps.checkTextExist("Error", false) == false);
                            pageSteps.confirm("OK");

                            pageSteps.clickButton("Back To Summary");
                        }
                    }
                }
            }
        }
    }

    @Step("Create Leave Application for flow {0}")
    private void createLeaveApp(String flowName)
    {
        setDetailData("Leave Application");
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detNo = getColumn_Detail(1);
            if (detNo.equalsIgnoreCase(flowName))
            {
                String applicant = getColumn_Detail(2);
                String appDate = getColumn_Detail(3);
                String laDetailNo = detNo;

                if (notEmpty(applicant))
                {
                    pageSteps.clickButton("New");
                    pageSteps.waitForAjax(1);
                    pageSteps.clickSearchButton();
                    pageSteps.setText("Employee Code", applicant);
                    pageSteps.verifyResult("Employee Code", pageSteps.getTextValue("Employee Code"), applicant);

                    pageSteps.waitForAjax(1);
                    pageSteps.selectFirstRow("Employee Code");
                    pageSteps.waitForAjax(1);
                    pageSteps.setText("Application Date", appDate);
                    pageSteps.verifyResult("Application Date", pageSteps.getTextValue("Application Date"), appDate);

                    addLeaveApp(laDetailNo);
                }
            }
        }
    }

    @Step("Add leave application records")
    public void addLeaveApp(String laDetailNo)
    {
        setDetailData_Child("LA");
        for (i_child = 1; i_child <= detailObjArray_Child.length; i_child++)
        {
            String detNo = getColumn_Child(1);
            if (detNo.equalsIgnoreCase(laDetailNo))
            {
                String leaveType = getColumn_Child(2);
                String durationType = getColumn_Child(3);
                String dateFrom = getColumn_Child(4);
                String dateTo = getColumn_Child(5);

                if (notEmpty(leaveType))
                {
                    pageSteps.clickButton("Add");
                    pageSteps.setTextAtTableCell("Leave Type", 1, leaveType);
                    pageSteps.verifyResult("Leave Type", pageSteps.getTextAtTableCell("Leave Type", 1), leaveType);

                    pageSteps.setDropDownOptionAtTableCell("Duration Type", 1, durationType);
                    pageSteps.verifyResult("Duration Type", pageSteps.getDropDownOptionAtTableCell("Duration Type", 1), durationType);

                    pageSteps.setTextAtTableCell("Date From", 1, dateFrom);
                    pageSteps.verifyResult("Date From", pageSteps.getTextAtTableCell("Date From", 1), dateFrom);

                    if (pageSteps.checkTextExist("Please apply leave application from Consolidate timesheet", false))
                    {
                        pageSteps.confirm("OK");
                        pageSteps.clickButton("Abort");
                        pageSteps.confirmNoOk("Yes");

                        pageSteps.verifyResult("Verify abort succesfully: ", pageSteps.checkTextExist("Error", false) == false);
                        pageSteps.confirm("OK");

                        pageSteps.goToMenu(MenuID.PROC_LV_APPLICATION);
                        pageSteps.confirm("No"); // leftover msg
                        pageSteps.waitForTextToVanish("No", 3);
                    }
                    else
                    {
                        if (pageSteps.checkTextExist("Date From: This period is overlapping with period:", false))
                        {
                            pageSteps.confirm("OK");
                            pageSteps.clickButton("Abort");
                            pageSteps.confirmNoOk("Yes");
                            pageSteps.verifyResult("Verify update succesfully: ", pageSteps.checkTextExist("Error", false) == false);
                            pageSteps.confirm("OK");
                        }
                        else
                        {
                            pageSteps.setTextAtTableCell("Date To", 1, dateTo);
                            pageSteps.clickButton("Submit");
                            pageSteps.confirmNoOk("Yes"); // confirm without click OK to get the error msg
                            if (pageSteps.checkTextExist("There is no need to apply leave", false))
                            {
                                pageSteps.confirm("OK");
                                pageSteps.confirm("No"); // in case there is confirmation for previous submission remains
                                if (pageSteps.checkValueExist("Abort"))
                                {
                                    pageSteps.clickButton("Abort");
                                    pageSteps.confirmNoOk("Yes");
                                    pageSteps.verifyResult("Verify update succesfully: ", pageSteps.checkTextExist("Error", false) == false);
                                    pageSteps.confirm("OK");
                                }
                            }
                            else
                                pageSteps.confirm("Yes"); // in case warning
                        }
                    }
                }
            }
        }
    }

    @Step("Create Leave Entitlement for flow {0}")
    public void createLeaveEntitlement(String flowName)
    {
        setDetailData("Leave Entitlement");
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detNo = getColumn_Detail(1);
            if (detNo.equalsIgnoreCase(flowName))
            {
                String type = getColumn_Detail(2);
                String voucherDate = getColumn_Detail(3);
                String year = getColumn_Detail(4);
                String defaultAdjType = getColumn_Detail(5);
                String leaveType = getColumn_Detail(6);
                String empCode = leaveType;
                String defaultNoOfDays = getColumn_Detail(7);
                String leDetailNo = detNo;

                if (notEmpty(type))
                {
                    if (type.equalsIgnoreCase("By Leave Type"))
                    {
                        pageSteps.goToTab("By Leave Type");
                        pageSteps.clickButton("New");
                        pageSteps.setText("Voucher Date", voucherDate);
                        pageSteps.verifyResult("Voucher Date", pageSteps.getTextValue("Voucher Date"), voucherDate);

                        pageSteps.setText("Year", currentYear);
                        pageSteps.verifyResult("Year", pageSteps.getTextValue("Year"), currentYear);

                        pageSteps.setDropDownOption("Default Adjustment Type", defaultAdjType);
                        pageSteps.verifyResult("Default Adjustment Type", pageSteps.getDropDownOptionValue("Default Adjustment Type"),
                                               defaultAdjType);

                        pageSteps.setDropDownOption("Leave Type:", leaveType);
                        pageSteps.verifyResult("Leave Type", pageSteps.getDropDownOptionValue("Leave Type:"), leaveType);

                        pageSteps.setText("Default No. of Days", defaultNoOfDays);
                        pageSteps.verifyResult("Default No. of Days", pageSteps.getTextValue("Default No. of Days"), defaultNoOfDays);

                        addEmployee(leDetailNo);

                        pageSteps.clickButton("Submit");
                        pageSteps.confirmNoOk("Yes");
                        pageSteps.verifyResult("Verify submit succesfully: ", pageSteps.checkTextExist("Error", false) == false);
                        pageSteps.confirm("OK");
                    }
                    else if (type.equalsIgnoreCase("By Employee"))
                    {
                        pageSteps.goToTab("By Employee");
                        pageSteps.clickButton("New", 2);
                        pageSteps.setText("Voucher Date", voucherDate);
                        pageSteps.verifyResult("Voucher Date", pageSteps.getTextValue("Voucher Date"), voucherDate);

                        pageSteps.setText("Year", currentYear);
                        pageSteps.verifyResult("Year", pageSteps.getTextValue("Year"), year);

                        pageSteps.setDropDownOption("Default Adjustment Type", defaultAdjType);
                        pageSteps.verifyResult("Default Adjustment Type", pageSteps.getDropDownOptionValue("Default Adjustment Type"),
                                               defaultAdjType);

                        pageSteps.clickSearchButton("Employee Code");
                        pageSteps.setText("Employee Code", empCode);
                        pageSteps.clickButton("Search");

                        addLeaveType(leDetailNo);

                        pageSteps.clickButton("Submit");
                        pageSteps.confirmNoOk("Yes");
                        pageSteps.verifyResult("Verify submit succesfully: ", pageSteps.checkTextExist("Error", false) == false);
                        pageSteps.confirm("OK");
                    }
                }
            }
        }
    }

    @Step("Add employee records by leave type")
    private void addEmployee(String leDetailNo)
    {
        setDetailData_Child("LE");
        for (i_child = 1; i_child <= detailObjArray_Child.length; i_child++)
        {
            String detNo = getColumn_Child(1);
            if (detNo.equalsIgnoreCase(leDetailNo))
            {
                String empCode = getColumn_Child(2);
                String adjType = getColumn_Child(3);
                String noOfDays = getColumn_Child(4);

                if (notEmpty(empCode))
                {
                    pageSteps.clickButton("Add");
                    pageSteps.waitForAjax(1);
                    //clickSearchAtTableCell("Employee Code", 1);
                    pageSteps.clickAtXpathCSS("//tbody[@id='DetailFrmId:EmployeesTblId:tb']//tr[1]/td[2]//img[@class='icon']");
                    pageSteps.setText("Employee Code", empCode);
                    pageSteps.clickButton("Search");
                    pageSteps.selectFirstRow("Employee Code");
                    pageSteps.setDropDownOptionAtTableCellPRTimesheet("Leave", "Adjustment Type", 1, adjType);
                    pageSteps.setDropDownOptionAtTableCellPRTimesheet("Leave", "No. Of Days", 1, noOfDays);
                }
            }
        }
    }

    @Step("Add leave type records by employee code")
    private void addLeaveType(String leDetailNo)
    {
        setDetailData_Child("LE");
        for (i_child = 1; i_child <= detailObjArray_Child.length; i_child++)
        {
            String detNo = getColumn_Child(1);
            if (detNo.equalsIgnoreCase(leDetailNo))
            {
                String leaveCode = getColumn_Child(2);
                String adjType = getColumn_Child(3);
                String noOfDays = getColumn_Child(4);

                if (notEmpty(leaveCode))
                {
                    pageSteps.clickButton("Add");
                    pageSteps.waitForAjax(1);
                    pageSteps.setText("Leave Type Code", leaveCode);
                    pageSteps.clickButton("Search");
                    pageSteps.setDropDownOptionAtTableCellPRTimesheet("Leave", "Adjustment Type", 1, adjType);
                    pageSteps.setDropDownOptionAtTableCellPRTimesheet("Leave", "No. Of Days", 1, noOfDays);
                }
            }
        }
    }
}
