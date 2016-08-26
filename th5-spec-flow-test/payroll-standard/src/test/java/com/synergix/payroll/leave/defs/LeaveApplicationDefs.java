package com.synergix.payroll.leave.defs;

import com.synergix.common.CONST;
import com.synergix.common.actions.DatasetBase;
import com.synergix.common.actions.PageSteps;
import com.synergix.common.constants.MenuID;
import com.synergix.utilities.DateTimeUtil;
import com.synergix.utilities.SessionData;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;

/**
 * Created by synergix61 on 23/2/2016.
 */
public class LeaveApplicationDefs extends DatasetBase
{
    @Steps
    PageSteps pageSteps;

    @When("^Leave Application is created as in\\s+\"([^\"]*)\"$")
    public void createLeaveApp(String dataset)
    {
        pageSteps.goToMenu(MenuID.PROC_LV_APPLICATION);

        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
        setDataset("Dataset");

        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String applicant = getColumn(1);
            String appDate = getColumn(2);
            String leaveType = getColumn(3);
            String durationType = getColumn(4);
            String dateFrom = getColumn(5);
            String dateTo = getColumn(6);

            if (notEmpty(applicant) && notEmpty(dateFrom))
            {
                pageSteps.clickButton("New");
                pageSteps.clickSearchButton();
                pageSteps.setText("Employee Code", applicant);
                pageSteps.selectFirstRow("Employee Code");
                pageSteps.waitForAjax(3);
                pageSteps.setText("Application Date", appDate);

                if (dateFrom.equals("C"))
                    dateFrom = appDate;
                if (dateTo.equals("C"))
                    dateTo = appDate;

                pageSteps.setTextAtTableCell("Leave Type", 1, leaveType);
                pageSteps.setDropDownOptionAtTableCell("Duration Type", 1, durationType);
                pageSteps.setTextAtTableCell("Date From", 1, dateFrom);
                pageSteps.setTextAtTableCell("Date To", 1, dateTo);

                pageSteps.clickButton("Submit");
                pageSteps.confirm("Yes");
            }
        }
    }

    @When("^user creates Leave Application$")
    public void createLeaveApp_F(List<List<String>> dataTable)
    {
        SessionData.addDataTable("LeaveApp", dataTable, false);
        for (int row : SessionData.getDataTbRowsNoHeader("LeaveApp").keySet())
        {
            String lvAppNo = SessionData.getDataTbVal("LeaveApp", row, "Leave Application No");
            String applicant = SessionData.getDataTbVal("LeaveApp", row, "Applicant");
            String leaveType = SessionData.getDataTbVal("LeaveApp", row, "Leave Type");
            String durationType = SessionData.getDataTbVal("LeaveApp", row, "Duration Type");
            String dateFrom = SessionData.getDataTbVal("LeaveApp", row, "Date From");
            String dateTo = SessionData.getDataTbVal("LeaveApp", row, "Date To");
            String doSubmit = SessionData.getDataTbVal("LeaveApp", row, "Submit");

            if (notEmpty(applicant))
            {
                pageSteps.goToMenu(MenuID.PROC_LV_APPLICATION);
                pageSteps.clickButton("New");
                voucherList.put(lvAppNo, pageSteps.getTextDesc("Leave Application No."));
                pageSteps.clickSearchButton();
                pageSteps.setText("Employee Code", applicant);
                pageSteps.selectFirstRow("Employee Code");
                pageSteps.waitForAjax(1);
            }
            if (notEmpty(leaveType))
            {
                pageSteps.clickButton("Add");
                pageSteps.setTextAtTableCell("Leave Type", 1, leaveType);
                pageSteps.setDropDownOptionAtTableCell("Duration Type", 1, durationType);
                pageSteps.setTextAtTableCell("Date From", 1, dateFrom);
                pageSteps.setTextAtTableCell("Date To", 1, dateTo);
            }
            if (doSubmit.equalsIgnoreCase("Y"))
            {
                pageSteps.clickButton("Submit");
                pageSteps.confirm("Yes");
            }
        }
    }

    @When("^user approves Leave Application$")
    public void approveLeaveApp_F(List<List<String>> dataTable)
    {
        pageSteps.goToMenu(MenuID.PROC_APPROVAL_SUMMARY);
        pageSteps.selectRowInQueueAtTableApprovalSummary("Leave Application (TH5)");
        SessionData.addDataTable("ApproveLeaveApp", dataTable, false);
        for (int row : SessionData.getDataTbRowsNoHeader("ApproveLeaveApp").keySet())
        {
            String lvAppNo = SessionData.getDataTbVal("ApproveLeaveApp", row, "Leave Application No");
            pageSteps.setTableFilter("Leave Application No.", voucherList.get(lvAppNo).toString());
            pageSteps.setRadioOptionAtTableCell("Action", 1, "Approve");
        }
        pageSteps.clickButton("Submit");
        pageSteps.confirm("Yes");
    }

    @Given("^Approving Officer is set up$")
    public void setupApprOfficer(List<List<String>> dataTable)
    {
        pageSteps.goToMenu(MenuID.MT_APPROVING_OFFICER);

        SessionData.addDataTable("ApprOfficer", dataTable, false);
        for (int row : SessionData.getDataTbRowsNoHeader("ApprOfficer").keySet())
        {
            String transactionType = SessionData.getDataTbVal("ApprOfficer", row, "Transaction");
            String apprMethod = SessionData.getDataTbVal("ApprOfficer", row, "Approving Method");
            String apprOfficer = SessionData.getDataTbVal("ApprOfficer", row, "Approving Officer");

            if (notEmpty(transactionType))
            {
                pageSteps.setTableFilter("Transaction Type Desc", transactionType);
                pageSteps.setDropDownOptionAtTableCell("Approving Method", 1, apprMethod);
                pageSteps.selectRowInQueueAtTableApprovalSummary(transactionType);
            }
            if (notEmpty(apprOfficer))
            {
                pageSteps.clickButton("Add");
                pageSteps.setText("Employee Code", apprOfficer);
                pageSteps.clickButton("Search");
                pageSteps.selectFirstRow("Employee Code");
                pageSteps.confirm("OK");
            }
        }
    }

    String sqlResult_Data     = getPayrollOutputPath("Leave_Application_Data_" + DateTimeUtil.getTime("dd_MM_yyyy") + ".xls");
    String sqlResult_Compared = getPayrollOutputPath("Leave_Application_Data_Compared_" + DateTimeUtil.getTime("dd_MM_yyyy") + ".xls");

    @When("^user pulls out data for Leave Application as\\s+\"([^\"]*)\" follow\\s+\"([^\"]*)\" on sheet\\s+\"([^\"]*)\"$")
    public void pulloutDataLvApp(String outputSheetName, String sqlCheckFile, String inputSheetName, List<List<String>> dataTable)
    {
        sqlCheckFile = getPayrollPath(sqlCheckFile);
        pullOutData(sqlResult_Data, outputSheetName, sqlCheckFile, inputSheetName, dataTable, voucherList);
    }

    @When("^user compares data for Leave Application with$")
    public void compareLeaveEncashmentData(List<List<String>> dataTable)
    {
        SessionData.addDataTable("CompareData", dataTable, false);
        for (int row : SessionData.getDataTbRowsNoHeader("CompareData").keySet())
        {
            String expectedFile = SessionData.getDataTbVal("CompareData", row, "Expected File");
            String sheetName = SessionData.getDataTbVal("CompareData", row, "Sheet");
            String scenarioDesc = SessionData.getDataTbVal("CompareData", row, "Scenario Description");

            if (empty(expectedFile))
                continue;

            expectedFile = getPayrollExpectedPath(expectedFile);
            // add to the result table in Session Data
            addCompared_MultipleTableData(sqlResult_Data, expectedFile, sqlResult_Compared, sheetName, scenarioDesc);
        }
        // get the result table
        String report = getTableReport(true);

        // display the result table in cucumber report
        pageSteps.verifyFinalResult(report);

        // display the result table with total failed cases
        pageSteps.verifyFinalResult(getTableReport_Summary(failedCasesNo), failedCasesNo);
    }
}




