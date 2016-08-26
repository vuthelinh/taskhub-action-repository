package com.synergix.payroll.leave.defs;

import com.synergix.common.actions.DatasetBase;
import com.synergix.common.actions.PageSteps;
import com.synergix.common.constants.MenuID;
import com.synergix.utilities.DateTimeUtil;
import com.synergix.utilities.SessionData;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;

/**
 * Created by synergix61 on 23/2/2016.
 */
public class Leave_Encashment_Days extends DatasetBase
{
    @Steps
    PageSteps pageSteps;

    @When("^LV_EMP_LEAVE_TYPE is updated$")
    public void updateLeaveBalance(List<List<String>> dataTable)
    {
        SessionData.addDataTable("LeaveEncash", dataTable, false);
        for (int row : SessionData.getDataTbRowsNoHeader("LeaveEncash").keySet())
        {
            String empCode = SessionData.getDataTbVal("LeaveEncash", row, "EMPLOYEE_CODE");
            String leaveType = SessionData.getDataTbVal("LeaveEncash", row, "LEAVE_TYPE_CODE");
            String year = SessionData.getDataTbVal("LeaveEncash", row, "YEAR");
            String carriedForward = SessionData.getDataTbVal("LeaveEncash", row, "CARRIED_FORWARD");
            String totalEntDays = SessionData.getDataTbVal("LeaveEncash", row, "TOTAL_ENTITLEMENT_DAYS");
            String leaveDaysTaken = SessionData.getDataTbVal("LeaveEncash", row, "LEAVE_DAYS_TAKEN");
            String leaveDaysTakenNextYr = SessionData.getDataTbVal("LeaveEncash", row, "LEAVE_DAYS_TAKEN_NEXT_YEAR");
            String leaveDaysTakenLastYr = SessionData.getDataTbVal("LeaveEncash", row, "LEAVE_DAYS_TAKEN_LAST_YEAR");
            String cfUltiLimit = SessionData.getDataTbVal("LeaveEncash", row, "CARRIED_FORWARD_UTILIZATION_LIMIT");
            String entitlementUltiLimit = SessionData.getDataTbVal("LeaveEncash", row, "ENTITLEMENT_UTILIZATION_LIMIT");
            String totalUltiLimit = SessionData.getDataTbVal("LeaveEncash", row, "TOTAL_UTILIZATION_LIMIT");

            if (empty(carriedForward))
                carriedForward = "0";
            if (empty(totalEntDays))
                totalEntDays = "0";
            if (empty(leaveDaysTaken))
                leaveDaysTaken = "0";
            if (empty(leaveDaysTakenNextYr))
                leaveDaysTakenNextYr = "0";
            if (empty(leaveDaysTakenLastYr))
                leaveDaysTakenLastYr = "0";
            if (empty(cfUltiLimit))
                cfUltiLimit = "0";
            if (empty(entitlementUltiLimit))
                entitlementUltiLimit = "0";
            if (empty(totalUltiLimit))
                totalUltiLimit = "0";

            if (hasRecords(
                    "SELECT * FROM LV_EMP_LEAVE_TYPE WHERE EMPLOYEE_CODE = '" + empCode + "' AND YEAR = " + year + " AND LEAVE_TYPE_CODE = '" + leaveType + "'"))
                executeUpdate(
                        "UPDATE LV_EMP_LEAVE_TYPE SET CARRIED_FORWARD = " + carriedForward + ", TOTAL_ENTITLEMENT_DAYS = " + totalEntDays + ", LEAVE_DAYS_TAKEN = " + leaveDaysTaken + ", LEAVE_DAYS_TAKEN_NEXT_YEAR = " + leaveDaysTakenNextYr + ", LEAVE_DAYS_TAKEN_LAST_YEAR = " + leaveDaysTakenLastYr + ", CARRIED_FORWARD_UTILIZATION_LIMIT = " + cfUltiLimit + ", ENTITLEMENT_UTILIZATION_LIMIT = " + entitlementUltiLimit + ", TOTAL_UTILIZATION_LIMIT = " + totalUltiLimit + " WHERE EMPLOYEE_CODE = '" + empCode + "' AND LEAVE_TYPE_CODE = '" + leaveType + "' AND YEAR = " + year + "");
            else
                executeUpdate(
                        "INSERT INTO DB2ADMIN.LV_EMP_LEAVE_TYPE (EMPLOYEE_CODE, LEAVE_TYPE_CODE, YEAR, CARRIED_FORWARD, TOTAL_ENTITLEMENT_DAYS, LEAVE_DAYS_TAKEN, LEAVE_DAYS_TAKEN_NEXT_YEAR, LEAVE_DAYS_TAKEN_LAST_YEAR, CREATED_BY, CREATED_DATETIME, LAST_UPDATED_BY, LAST_UPDATED_DATETIME, OBJECT_VERSION, CARRIED_FORWARD_UTILIZATION_LIMIT, ENTITLEMENT_UTILIZATION_LIMIT, TOTAL_UTILIZATION_LIMIT) VALUES('" + empCode + "', '" + leaveType + "', " + year + "," + carriedForward + ", " + totalEntDays + ", " + leaveDaysTaken + ", " + leaveDaysTakenNextYr + ", " + leaveDaysTakenLastYr + ", 'U000000320', TIMESTAMP '2016-06-03 12:56:23.323', 'U000000320', TIMESTAMP '2016-06-13 11:25:08.446', 3, " + cfUltiLimit + ", " + entitlementUltiLimit + ", " + totalUltiLimit + ")");
        }
    }

    @When("^user generates payslip$")
    public void generatePayslip(List<List<String>> dataTable)
    {
        SessionData.addDataTable("GenPayslip", dataTable, false);
        for (int row : SessionData.getDataTbRowsNoHeader("GenPayslip").keySet())
        {
            String payslipVoucherNo = SessionData.getDataTbVal("GenPayslip", row, "Payroll Generation Voucher No");
            String glPostingDate = SessionData.getDataTbVal("GenPayslip", row, "Payroll GL Posting Date");
            String year = SessionData.getDataTbVal("GenPayslip", row, "Year");
            String month = SessionData.getDataTbVal("GenPayslip", row, "Month");
            String paymentCycleCode = SessionData.getDataTbVal("GenPayslip", row, "Payment Cycle Code");
            String paymentCycleNo = SessionData.getDataTbVal("GenPayslip", row, "Payment Cycle No");
            String genPayslipForAdv = SessionData.getDataTbVal("GenPayslip", row, "Generate Payslip for advancement");
            String genPayslipFor = SessionData.getDataTbVal("GenPayslip", row, "Generate Payslip For");
            String genPayslipBy = SessionData.getDataTbVal("GenPayslip", row, "Generate Payslip By");
            String empCode = SessionData.getDataTbVal("GenPayslip", row, "Employee Code");
            String epc = SessionData.getDataTbVal("GenPayslip", row, "EPC");
            String doSubmit = SessionData.getDataTbVal("GenPayslip", row, "Submit");

            if (notEmpty(glPostingDate))
            {
                pageSteps.goToMenu(MenuID.PROC_PY_PAYROLL_GENERATION);
                pageSteps.goToTab("Payroll Generation");
                pageSteps.clickButton("New");
                voucherList.put(payslipVoucherNo, pageSteps.getTextDesc("Payroll Generation Voucher No."));
                pageSteps.setText("Year", year); // must set year before GL posting date
                pageSteps.setText("Month", month);
                pageSteps.setText("Payroll GL Posting Date", glPostingDate);
                pageSteps.setText("Payment Cycle Code", paymentCycleCode);
                pageSteps.setRadioOption("Payment Cycle No.", paymentCycleNo);

                if (notEmpty(genPayslipFor))
                {
                    pageSteps.setRadioOption("Generate Payslip For", genPayslipFor);
                }
                else
                {
                    if (pageSteps.checkTextExist("Generate payslip for advancement", true))
                        pageSteps.setRadioOption("Generate payslip for advancement", genPayslipForAdv);
                    else
                    {
                        if (genPayslipForAdv.equalsIgnoreCase("N") || genPayslipForAdv.equalsIgnoreCase("No"))
                            pageSteps.setRadioOption("Generate Payslip For", "Main Payslip");
                        else if (genPayslipForAdv.equalsIgnoreCase("Y") || genPayslipForAdv.equalsIgnoreCase("Yes"))
                            pageSteps.setRadioOption("Generate Payslip For", "Advancement");
                    }
                }
                if (genPayslipBy.equalsIgnoreCase("Employee"))
                    genPayslipBy = "Employee (Basic Salary)";
                pageSteps.setRadioOption("Generate Payslip By", genPayslipBy);
            }

            if (notEmpty(empCode))
            {
                pageSteps.clickButton("Add");
                pageSteps.waitForAjax(1);
                int rowNo = pageSteps.getRowsCount("Employee Code");
                pageSteps.setTextAtTableCell("Employee Code", rowNo, empCode);
            }
            if (notEmpty(epc))
            {
                pageSteps.setTableFilter("Employee Payroll Category", epc);
                pageSteps.setCheckboxAtXpathCSS("//tbody//tr[1]//*[@type='checkbox'][contains(@name, 'EmpPayrollCategoryTblId')]", true);
            }
            if (doSubmit.equalsIgnoreCase("Y"))
            {
                pageSteps.waitForAjax(1);
                pageSteps.clickButton("Generate Payslip");
                pageSteps.confirm("Yes");
                pageSteps.confirm("OK");
            }
        }
    }

    @When("^user submits payslip$")
    public void submitPayslip(List<List<String>> dataTable)
    {
        SessionData.addDataTable("SubmitPayslip", dataTable, false);
        for (int row : SessionData.getDataTbRowsNoHeader("SubmitPayslip").keySet())
        {
            String payslipVoucherNo = SessionData.getDataTbVal("SubmitPayslip", row, "Voucher No");

            pageSteps.goToMenu(MenuID.PROC_PY_PAYROLL_GENERATION);
            pageSteps.goToTab("Payslip");
            //pageSteps.setTableFilter("Payroll Generation", getVoucher(payslipVoucherNo));
            pageSteps.setTextAtXpathCSS("//table[contains(@id, 'payslipDraftSummaryTblId')]/thead/tr[1]/th[2]//input",
                                        getVoucher(payslipVoucherNo, voucherList));
            pageSteps.waitForAjax(1);
            pageSteps.setCheckBoxTableFilter("Sel", "Y");
            pageSteps.waitForAjax(1);
            pageSteps.clickButton("Submit");
            pageSteps.confirm("Yes");
            pageSteps.confirm("OK");
        }
    }

    String sqlResult_Data     = getPayrollOutputPath("Leave_Encashment_Calendar_Days_Data_" + DateTimeUtil.getTime("dd_MM_yyyy") + ".xls");
    String sqlResult_Compared = getPayrollOutputPath("Leave_Encashment_Calendar_Days_Data_Compared_" + DateTimeUtil.getTime("dd_MM_yyyy") + ".xls");

    //user pulls out data as "Set 1 - After Submit" follow "LV_Encash_SQLCheck.xls" on sheet "AfterSubmit"
    @When("^user pulls out data for Leave Encashment as\\s+\"([^\"]*)\" follow\\s+\"([^\"]*)\" on sheet\\s+\"([^\"]*)\"$")
    public void pulloutData(String outputSheetName, String sqlCheckFile, String inputSheetName, List<List<String>> dataTable)
    {
        sqlCheckFile = getPayrollPath(sqlCheckFile);
        pullOutData(sqlResult_Data, outputSheetName, sqlCheckFile, inputSheetName, dataTable, voucherList);
    }

    @When("^user compares data for Leave Encashment with$")
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




