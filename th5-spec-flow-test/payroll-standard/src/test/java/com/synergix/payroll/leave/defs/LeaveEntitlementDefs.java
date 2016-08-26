package com.synergix.payroll.leave.defs;

import com.synergix.common.actions.DatasetBase;
import com.synergix.common.actions.PageSteps;
import com.synergix.common.constants.MenuID;
import com.synergix.utilities.DateTimeUtil;
import com.synergix.utilities.ExcelUtils;
import com.synergix.utilities.ReadBean;
import com.synergix.utilities.SessionData;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

import java.util.Arrays;
import java.util.List;

/**
 * Created by synergix61 on 23/2/2016.
 */
public class LeaveEntitlementDefs extends DatasetBase
{
    @Steps
    PageSteps pageSteps;

    @When("^Leave Entitlement By Leave Type is created as in\\s+\"([^\"]*)\" with sheet suffix\\s+\"([^\"]*)\"$")
    public void createLeaveEntByLeaveType(String dataset, String sheetSuffix)
    {
        pageSteps.goToMenu(MenuID.PROC_LV_ENTITLEMENT);
        pageSteps.goToTab("By Leave Type");

        excelPath = getPayrollPath(dataset);
        setDataset("Dataset" + sheetSuffix);
        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String voucherDate = getColumn(1);
            String year = getColumn(2);
            String defaultAdjType = getColumn(3);
            String leaveType = getColumn(4);
            String defaultNoofDays = getColumn(5);
            String lvDetailNo = getColumn(6);

            if (notEmpty(voucherDate) && notEmpty(lvDetailNo))
            {
                pageSteps.goToTab("Draft");
                pageSteps.clickButton("New");
                pageSteps.setText("Voucher Date", voucherDate);
                pageSteps.setText("Year", year);
                pageSteps.setDropDownOption("Default Adjustment Type", defaultAdjType);
                pageSteps.setDropDownOption("Leave Type:", leaveType, true);
                pageSteps.setText("Default No. of Days", defaultNoofDays);
                pageSteps.setTableFilterAtPRTimesheet("Leave", "Employee Code", "blank"); // a strange behavior left in the previous voucher

                setDetailData("LE" + sheetSuffix);
                for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
                {
                    String detNo = getColumn_Detail(1);
                    if (detNo.equalsIgnoreCase(lvDetailNo))
                    {
                        String empCode = getColumn_Detail(2);
                        String adjType = getColumn_Detail(3);
                        String noOfDays = getColumn_Detail(4);

                        if (notEmpty(empCode))
                        {
                            pageSteps.clickButton("Add");
                            pageSteps.waitForAjax(1);
                            pageSteps.clickSearchAtTableCellPRTimeSheet("Leave", "Employee Code", 1);
                            pageSteps.setText("Employee Code", empCode);
                            pageSteps.clickButton("Search", 1);
                            pageSteps.waitForAjax(1);
                            pageSteps.selectFirstRow("Employee Code");

                            // after inputting leave type code, table auto rearrange orders
                            pageSteps.setTableFilterAtPRTimesheet("Leave", "Employee Code", empCode);
                            pageSteps.setDropDownOptionAtTableCellPRTimesheet("Leave", "Adjustment Type", 1, adjType);
                            pageSteps.setTextAtTableCellPRTimeSheet("Leave", "No. Of Days", 1, noOfDays);
                            pageSteps.setTableFilterAtPRTimesheet("Leave", "Employee Code", "blank");
                        }
                    }
                }
                pageSteps.clickButton("Submit");
                pageSteps.confirm("Yes");
            }
        }
    }

    @When("^Leave Entitlement By Employee is created as in\\s+\"([^\"]*)\" with sheet suffix\\s+\"([^\"]*)\"$")
    public void createLeaveEntByEmp(String dataset, String sheetSuffix) throws Exception
    {
        pageSteps.goToMenu(MenuID.PROC_LV_ENTITLEMENT);
        pageSteps.goToTab("By Employee");

        excelPath = getPayrollPath(dataset);
        setDataset("Dataset" + sheetSuffix);
        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String voucherDate = getColumn(1);
            String year = getColumn(2);
            String defaultAdjType = getColumn(3);
            String empCode = getColumn(4);
            String lvDetailNo = getColumn(5);

            if (notEmpty(voucherDate) && notEmpty(lvDetailNo))
            {
                pageSteps.goToTab("Draft", 2);
                pageSteps.clickButton("New", 2);
                pageSteps.setText("Voucher Date", voucherDate);
                pageSteps.setText("Year", year);
                pageSteps.setDropDownOption("Default Adjustment Type", defaultAdjType);
                pageSteps.clickSearchButton("Employee Code");
                pageSteps.setText("Employee Code", empCode, 2);
                pageSteps.clickButton("Search", 1);
                pageSteps.waitForAjax(1);
                pageSteps.selectFirstRow("Employee Code");

                setDetailData("LE" + sheetSuffix);
                for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
                {
                    String detNo = getColumn_Detail(1);
                    if (detNo.equalsIgnoreCase(lvDetailNo))
                    {
                        String leaveType = getColumn_Detail(2);
                        String adjType = getColumn_Detail(3);
                        String noOfDays = getColumn_Detail(4);

                        if (notEmpty(empCode))
                        {
                            pageSteps.clickButton("Add");
                            pageSteps.waitForAjax(1);
                            pageSteps.setTextAtTableCellPRTimeSheet("Leave", "Leave Type Code", 1, leaveType);

                            // after inputting leave type code, table auto rearrange orders
                            int rowNo = pageSteps.getRowNumber("Leave Type Code", leaveType);
                            pageSteps.setDropDownOptionAtTableCellPRTimesheet("Leave", "Adjustment Type", rowNo, adjType);
                            pageSteps.setTextAtTableCellPRTimeSheet("Leave", "No. Of Days", rowNo, noOfDays);
                        }
                    }
                }
                pageSteps.clickButton("Submit");
                pageSteps.confirm("Yes");
            }
        }
    }

    @When("^Leave Entitlement by Leave Type is created$")
    public void createLeaveEntByLeaveType_F(List<List<String>> dataTable)
    {
        SessionData.addDataTable("CreateEntByLeaveType", dataTable, false);
        for (int row : SessionData.getDataTbRowsNoHeader("CreateEntByLeaveType").keySet())
        {
            String voucherNo = SessionData.getDataTbVal("CreateEntByLeaveType", row, "Voucher No");
            String voucherType = SessionData.getDataTbVal("CreateEntByLeaveType", row, "Voucher Type");
            String voucherDate = SessionData.getDataTbVal("CreateEntByLeaveType", row, "Voucher Date");
            String year = SessionData.getDataTbVal("CreateEntByLeaveType", row, "Year");
            String leaveType = SessionData.getDataTbVal("CreateEntByLeaveType", row, "Leave Type");
            String defaultAdjType = SessionData.getDataTbVal("CreateEntByLeaveType", row, "Default Adjustment Type");
            String adjType = SessionData.getDataTbVal("CreateEntByLeaveType", row, "Adjustment Type");
            String noOfDays = SessionData.getDataTbVal("CreateEntByLeaveType", row, "No of Days");
            String defaultNoOfDays = SessionData.getDataTbVal("CreateEntByLeaveType", row, "Default No of Days");
            String empCode = SessionData.getDataTbVal("CreateEntByLeaveType", row, "Employee Code");
            String epcCode = SessionData.getDataTbVal("CreateEntByLeaveType", row, "Employee Payroll Category");
            String doSubmit = SessionData.getDataTbVal("CreateEntByLeaveType", row, "Submit");

            if (notEmpty(voucherNo))
            {
                pageSteps.goToMenu(MenuID.PROC_LV_ENTITLEMENT);
                pageSteps.goToTab("By Leave Type");
                pageSteps.goToTab("Draft");
                pageSteps.clickButton("New");
                voucherList.put(voucherNo, pageSteps.getTextDesc("Leave Entitlement Voucher No."));
                pageSteps.setText("Voucher Date", voucherDate);
                pageSteps.setText("Year", year);
                pageSteps.setDropDownOption("Default Adjustment Type", defaultAdjType);
                pageSteps.setDropDownOption("Leave Type:", leaveType, true);
                pageSteps.setText("Default No. of Days", defaultNoOfDays);
                pageSteps.setTableFilterAtPRTimesheet("Leave", "Employee Code", "blank"); // a strange behavior left in the previous voucher
                pageSteps.waitForAjax(1);
            }

            if (notEmpty(empCode) || notEmpty(epcCode))
            {
                if (notEmpty(empCode))
                {
                    pageSteps.clickButton("Add");
                    pageSteps.waitForAjax(1);
                    pageSteps.clickSearchAtTableCellPRTimeSheet("Leave", "Employee Code", 1);
                    pageSteps.setText("Employee Code", empCode);
                    pageSteps.clickButton("Search", 1);
                    pageSteps.waitForAjax(1);
                    pageSteps.selectFirstRow("Employee Code");
                    pageSteps.waitForAjax(1);

                    // after inputting leave type code, table auto rearrange orders
                    pageSteps.setTableFilterAtPRTimesheet("Leave", "Employee Code", empCode);
                    pageSteps.setDropDownOptionAtTableCellPRTimesheet("Leave", "Adjustment Type", 1, adjType);

                    String expLeave = "";
                    // special case: Add No of Days = Expected Leave Entitlement - 2
                    if (noOfDays.contains("Expected Leave"))
                    {
                        expLeave = pageSteps.getTextValueByXpathCss("//tbody[@id='DetailFrmId:EmployeesTblId:tb']/tr[1]/td[5]");
                        if (toDouble(expLeave) <= 0)
                            noOfDays = "1";
                        else
                        {
                            noOfDays = noOfDays.substring(noOfDays.length() - 1);
                            noOfDays = toDouble(expLeave) - toDouble(noOfDays) + "";
                            if (toDouble(noOfDays) <= 0)
                                noOfDays = "1";
                        }

                    }
                    if (adjType.equalsIgnoreCase("Reduce"))
                    {
                        expLeave = pageSteps.getTextValueByXpathCss("//tbody[@id='DetailFrmId:EmployeesTblId:tb']/tr[1]/td[6]");
                        if (toDouble(expLeave) <= 0)
                        {
                            pageSteps.setCheckboxAtXpathCSS(
                                    "//tbody[@id='DetailFrmId:EmployeesTblId:tb']/tr[1]//input[contains(@id,'chkDelLeaveType')]", true);
                            pageSteps.clickButton("Delete");
                            pageSteps.confirm("Yes");
                        }
                        if (toDouble(noOfDays) > toDouble(expLeave))
                            noOfDays = expLeave;
                    }
                    pageSteps.setTextAtTableCellPRTimeSheet("Leave", "No. Of Days", 1, noOfDays);
                    pageSteps.setTableFilterAtPRTimesheet("Leave", "Employee Code", "blank");
                }
                if (notEmpty(epcCode))
                {
                    pageSteps.clickButton("Add Multiple");
                    pageSteps.waitForAjax(1);
                    pageSteps.setText("Employee Payroll Category Code", epcCode);
                    pageSteps.clickButton("Search", 1);
                    pageSteps.waitForAjax(1);
                    pageSteps.selectFirstRow("Employee Payroll Category Code");
                }
            }
            if (doSubmit.equalsIgnoreCase("Y"))
            {
                pageSteps.clickButton("Submit");
                pageSteps.confirm("Yes");
            }
        }
    }

    @When("^Leave Entitlement by Employee is created$")
    public void createLeaveEntByEmp_F(List<List<String>> dataTable)
    {
        SessionData.addDataTable("CreateEntByEmp", dataTable, false);
        for (int row : SessionData.getDataTbRowsNoHeader("CreateEntByEmp").keySet())
        {
            String voucherNo = SessionData.getDataTbVal("CreateEntByEmp", row, "Voucher No");
            String voucherType = SessionData.getDataTbVal("CreateEntByEmp", row, "Voucher Type");
            String voucherDate = SessionData.getDataTbVal("CreateEntByEmp", row, "Voucher Date");
            String year = SessionData.getDataTbVal("CreateEntByEmp", row, "Year");
            String leaveType = SessionData.getDataTbVal("CreateEntByEmp", row, "Leave Type");
            String defaultAdjType = SessionData.getDataTbVal("CreateEntByEmp", row, "Default Adjustment Type");
            String adjType = SessionData.getDataTbVal("CreateEntByEmp", row, "Adjustment Type");
            String noOfDays = SessionData.getDataTbVal("CreateEntByEmp", row, "No of Days");
            String defaultNoOfDays = SessionData.getDataTbVal("CreateEntByEmp", row, "Default No of Days");
            String empCode = SessionData.getDataTbVal("CreateEntByEmp", row, "Employee Code");
            String epcCode = SessionData.getDataTbVal("CreateEntByEmp", row, "Employee Payroll Category");
            String doSubmit = SessionData.getDataTbVal("CreateEntByEmp", row, "Submit");

            if (notEmpty(voucherNo))
            {
                pageSteps.goToMenu(MenuID.PROC_LV_ENTITLEMENT);
                pageSteps.goToTab("By Employee");
                pageSteps.goToTab("Draft", 2);
                pageSteps.clickButton("New", 2);
                voucherList.put(voucherNo, pageSteps.getTextDesc("Leave Entitlement Voucher No."));
                pageSteps.setText("Voucher Date", voucherDate);
                pageSteps.setText("Year", year);
                pageSteps.setDropDownOption("Default Adjustment Type", defaultAdjType);
                pageSteps.clickSearchButton("Employee Code");
                pageSteps.setText("Employee Code", empCode, 2);
                pageSteps.clickButton("Search", 1);
                pageSteps.waitForAjax(1);
                pageSteps.selectFirstRow("Employee Code");
                pageSteps.waitForAjax(1);
            }
            if (notEmpty(leaveType))
            {
                pageSteps.clickButton("Add");
                pageSteps.waitForAjax(1);
                pageSteps.setTextAtTableCellPRTimeSheet("Leave", "Leave Type Code", 1, leaveType);

                // after inputting leave type code, table auto rearrange orders
                int rowNo = pageSteps.getRowNumber("Leave Type Code", leaveType);
                pageSteps.setDropDownOptionAtTableCellPRTimesheet("Leave", "Adjustment Type", rowNo, adjType);

                // special case: Reduce No of Days = All
                if (noOfDays.contains("All"))
                {
                    String expLeave = "";
                    // get Total Entitlement Before to reduce
                    expLeave = pageSteps.getTextValueByXpathCss("//tbody[@id='DetailFrmId:tblLeaveTypes:tb']/tr[" + rowNo + "]/td[5]");
                    if (toDouble(expLeave) == 0)
                    {
                        //pageSteps.setCheckBoxAtTableCellPRTimesheet("Leave", "Del", rowNo, "Y");
                        pageSteps.setCheckboxAtXpathCSS(
                                "//tbody[@id='DetailFrmId:tblLeaveTypes:tb']/tr[" + rowNo + "]//input[contains(@id,'chkDelLeaveType')]", true);
                        pageSteps.clickButton("Delete");
                        pageSteps.confirm("Yes");
                    }
                    else
                    {
                        noOfDays = expLeave;
                    }
                }
                pageSteps.setTextAtTableCellPRTimeSheet("Leave", "No. Of Days", rowNo, noOfDays);
            }
            if (doSubmit.equalsIgnoreCase("Y"))
            {
                pageSteps.clickButton("Submit");
                pageSteps.confirm("Yes");
            }
        }
    }

    String outputPath = "C:\\leave_entitlement_output_" + DateTimeUtil.getTime("dd_MM_yyyy") + ".xls";

    @Then("Expected Entitlement is calculated correctly follow\\s+\"([^\"]*)\" on sheet\\s+\"([^\"]*)\"$")
    public void checkCalculatedEnt(String dataset, String sheetName)
    {
        ExcelUtils.createExcelFile(outputPath, sheetName);
        int rowNo = ExcelUtils.getLastRowNum(outputPath, sheetName);
        ExcelUtils.writeToExel(outputPath, sheetName, "Voucher Date", rowNo, 1);
        ExcelUtils.writeToExel(outputPath, sheetName, "Year", rowNo, 2);
        ExcelUtils.writeToExel(outputPath, sheetName, "Leave Type Code", rowNo, 3);
        ExcelUtils.writeToExel(outputPath, sheetName, "Employee Code", rowNo, 4);
        ExcelUtils.writeToExel(outputPath, sheetName, "No of Days", rowNo, 5);
        ExcelUtils.writeToExel(outputPath, sheetName, "Adjustment Type", rowNo, 6);
        ExcelUtils.writeToExel(outputPath, sheetName, "Actual Leave Entitlement", rowNo, 7);
        ExcelUtils.writeToExel(outputPath, sheetName, "Expected Leave Entitlement", rowNo, 8);
        ExcelUtils.writeToExel(outputPath, sheetName, "Result", rowNo, 9);

        excelPath = getPayrollPath(dataset);
        setDetailData(sheetName);
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String voucherDate = getColumn_Detail(1);
            String year = getColumn_Detail(2);
            String empCode = getColumn_Detail(3);
            String leaveTypeCode = getColumn_Detail(4);
            String noOfDays = getColumn_Detail(5);
            String adjType = getColumn_Detail(6);
            String expectedLvEnt = getColumn_Detail(7);

            if (empty(voucherDate))
                continue;

            voucherDate = DateTimeUtil.reverseDate(voucherDate);
            String sql = "select CALCULATED_LV_ENTITLEMENT from LV_ENTITLEMENT_LV_TYPE_EMP where LEAVE_ENTITLEMENT_NO = (select LEAVE_ENTITLEMENT_NO from LV_ENTITLEMENT where VOUCHER_DATE = '" + voucherDate + "' AND EMPLOYEE_CODE = '" + empCode + "') and leave_type_code = '" + leaveTypeCode + "'";
            String calculated_lv_entitlement = getColumnValue(sql, "CALCULATED_LV_ENTITLEMENT");

            rowNo = ExcelUtils.getLastRowNum(outputPath, sheetName);
            ExcelUtils.writeToExel(outputPath, sheetName, voucherDate, rowNo, 1);
            ExcelUtils.writeToExel(outputPath, sheetName, year, rowNo, 2);
            ExcelUtils.writeToExel(outputPath, sheetName, empCode, rowNo, 3);
            ExcelUtils.writeToExel(outputPath, sheetName, leaveTypeCode, rowNo, 4);
            ExcelUtils.writeToExel(outputPath, sheetName, noOfDays, rowNo, 5);
            ExcelUtils.writeToExel(outputPath, sheetName, adjType, rowNo, 6);
            ExcelUtils.writeToExel(outputPath, sheetName, calculated_lv_entitlement, rowNo, 7);
            ExcelUtils.writeToExel(outputPath, sheetName, expectedLvEnt, rowNo, 8);
            ExcelUtils.writeToExel(outputPath, sheetName, compareLvEnt(expectedLvEnt, calculated_lv_entitlement), rowNo, 9);
        }
    }

    public String compareLvEnt(String a, String b)
    {
        double lv_a = toDouble(a);
        double lv_b = toDouble(b);
        return lv_a == lv_b ? "Pass" : "Failed";
    }

    @Then("user send email report for Leave Entitlement$")
    public void sendMailReport_LeaveEntitlement()
    {
        String outputPath1 = getPayrollPath("LV_LeaveEntitlementByEmployee.xls");
        String outputPath2 = getPayrollPath("LV_LeaveEntitlementByLeaveType.xls");
        String outputPath3 = getPayrollPath("LV_Employee.xls");
        String outputPath4 = getPayrollPath("LV_EmployeeGrade.xls");
        String outputPath5 = getPayrollPath("LV_LeaveType.xls");
        String outputPath6 = getPayrollPath("LV_ClearData.xls");
        String featureFile = getPayrollFeaturePath("leave\\Leave_Entitlement_Dataset.feature");

        List<String> attachments = Arrays.asList(outputPath, outputPath1, outputPath2, outputPath3, outputPath4, outputPath5, outputPath6);
        sendEmailToPY("Leave Entitlement Report",
                      "Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + " / DB: " + Serenity.sessionVariableCalled(
                              "DB_URL") + "\n\n\n" + ReadBean.readFile(featureFile), attachments);
    }

    String sqlResult_Data     = getPayrollOutputPath("Leave_Entitlement_Data_" + DateTimeUtil.getTime("dd_MM_yyyy") + ".xls");
    String sqlResult_Compared = getPayrollOutputPath("Leave_Entitlement_Data_Compared_" + DateTimeUtil.getTime("dd_MM_yyyy") + ".xls");

    @When("^user pulls out data for Leave Entitlement as\\s+\"([^\"]*)\" follow\\s+\"([^\"]*)\" on sheet\\s+\"([^\"]*)\"$")
    public void pulloutData(String outputSheetName, String sqlCheckFile, String inputSheetName, List<List<String>> dataTable)
    {
        sqlCheckFile = getPayrollPath(sqlCheckFile);
        pullOutData(sqlResult_Data, outputSheetName, sqlCheckFile, inputSheetName, dataTable, voucherList);
    }

    @When("^user compares data for Leave Entitlement with$")
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




