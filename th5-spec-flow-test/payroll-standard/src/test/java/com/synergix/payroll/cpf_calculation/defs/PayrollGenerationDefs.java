package com.synergix.payroll.cpf_calculation.defs;

import com.synergix.common.CONST;
import com.synergix.common.actions.DatasetBase;
import com.synergix.common.actions.PageSteps;
import com.synergix.common.constants.ElementID;
import com.synergix.common.constants.MenuID;
import com.synergix.utilities.ConnectDatabase;
import com.synergix.utilities.DateTimeUtil;
import com.synergix.utilities.ExcelUtils;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

import java.sql.ResultSet;

public class PayrollGenerationDefs extends DatasetBase
{
    @Steps
    PageSteps pageSteps;
    String sqlResult;

    @Title("CPF Calculation")
    @Given("^Payslip is generated as in\\s+\"([^\"]*)\" and pull out data to excel with generated date$")
    public void payrollGeneration(String dataset)
    {
        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
        setDataset("Dataset");
        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String glPostingDate = getColumn(1);
            String year = getColumn(2);
            String month = getColumn(3);
            String paymentCycle = getColumn(4);
            String paymentCycleNo = getColumn(5);
            String advancement = getColumn(6);
            String genPayslipBy = getColumn(7);
            String addAllBasicEmp = getColumn(8);
            String epcDetailNo = getColumn(9);

            sqlResult = excelPath.replace(".xls", "_Output_" + DateTimeUtil.getTime("dd_MM_yyyy")) + ".xls";

            pageSteps.goToMenu(MenuID.PROC_PY_PAYROLL_GENERATION);
            pageSteps.clickButton("New");
            pageSteps.setText("Year", year); // must set year before GL posting date
            pageSteps.setText("Month", month);
            pageSteps.setText("Payroll GL Posting Date", glPostingDate);
            pageSteps.setText("Payment Cycle Code", paymentCycle);
            pageSteps.setRadioOption("Payment Cycle No.", paymentCycleNo);

            if (pageSteps.checkTextExist("Generate payslip for advancement ", true))
                pageSteps.setRadioOption("Generate payslip for advancement ", advancement);
            else
            {
                if (advancement.equalsIgnoreCase("N") || advancement.equalsIgnoreCase("No"))
                    pageSteps.setRadioOption("Generate Payslip For", "Main Payslip");
                else
                    pageSteps.setRadioOption("Generate Payslip For", "Advancement");
            }
            pageSteps.setRadioOption("Generate Payslip By", genPayslipBy);

            if (genPayslipBy.trim().contains("Basic Salary") || genPayslipBy.trim().equalsIgnoreCase("EMP"))
            {
                if (addAllBasicEmp.equalsIgnoreCase("Y"))
                {
                    pageSteps.clickButton("Add All Basic Salary Employees");
                    pageSteps.waitForAjax(3);
                }
                else
                {
                    setDetailData("EMP");
                    for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
                    {
                        String detNo = getColumn_Detail(1);
                        if (detNo.equalsIgnoreCase(epcDetailNo))
                        {
                            String empCode = getColumn_Detail(2);
                            pageSteps.clickButton("Add");
                            pageSteps.waitForAjax(1);
                            int rowNo = pageSteps.getRowsCount("Employee Code");
                            if (rowNo == 20)
                                if (pageSteps.checkElementVisible(ElementID.NAVIGATE_LAST_BUTTON))
                                {
                                    pageSteps.clickAtXpathCSS(ElementID.NAVIGATE_LAST_BUTTON);
                                    pageSteps.waitForProgressBar(1);
                                    rowNo = pageSteps.getRowsCount("Employee Code");
                                }
                            pageSteps.setTextAtTableCell("Employee Code", rowNo, empCode);
                        }
                    }
                }
            }

            else if (genPayslipBy.trim().equalsIgnoreCase("Employee Payroll Category") || genPayslipBy.trim().contains("EPC"))
            {
                setDetailData("EPC");
                for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
                {
                    String detNo = getColumn_Detail(1);
                    if (detNo.equalsIgnoreCase(epcDetailNo))
                    {
                        String epcName = getColumn_Detail(2);
                        pageSteps.setCheckBoxAtMultiList("Employee Payroll Category", epcName, "Y", false);
                    }
                }
            }

            pageSteps.clickButton("Generate Payslip");
            pageSteps.confirm("Yes");

            pageSteps.waitForAjax(10); // wait for voucher to really submit before pulling out data
            pageSteps.confirm("OK");

            // check IR8A before submit payslip
            checkIR8(false);

            // submit payslip
            submitPayslip();

            pageSteps.waitForAjax(10); // wait for payslip to really submit before pulling out data
            pageSteps.confirm("OK");

            // check IR8A after submit payslip
            checkIR8(true);
        }
    }

    public void checkIR8(boolean isAfterSubmitPayslip)
    {
        setDetailData("SQL");
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detNo = getColumn_Detail(1);
            if (notEmpty(detNo))
            {
                String tableName = getColumn_Detail(2);
                String twoPhasePullOut = getColumn_Detail(3);
                String statement = getColumn_Detail(4);
                ResultSet rs = null;
                connectSessionDB();

                if (!isAfterSubmitPayslip) // pull out before submit payslip
                {
                    if (twoPhasePullOut.equalsIgnoreCase("Y"))
                        rs = ConnectDatabase.getResultStatement(statement);
                    if (ConnectDatabase.notEmpty(rs)) // only create sheet for data-contained statements
                    {
                        pullOut(sqlResult, tableName.trim() + "_BF", rs);
                    }
                }

                else  // pull out after submit payslip
                {
                    rs = ConnectDatabase.getResultStatement(statement);
                    if (ConnectDatabase.notEmpty(rs)) // only create sheet for data-contained statements
                    {
                        if (!isAfterSubmitPayslip)
                            pullOut(sqlResult, tableName.trim(), rs);
                        else
                            pullOut(sqlResult, tableName.trim() + "_AF", rs);
                    }
                }
            }
        }
    }

    public void pullOut(String sqlResult, String sheetName, ResultSet rs)
    {
        ExcelUtils.createExcelFile(sqlResult, sheetName.trim());
        ExcelUtils.createExistingColumns(sqlResult, sheetName.trim(), rs);
        ExcelUtils.createExistingCells(sqlResult, sheetName.trim(), rs);
    }

    // submit all draft payslip
    public void submitPayslip()
    {
        pageSteps.goToMenu(MenuID.PROC_PY_PAYROLL_GENERATION);
        pageSteps.goToTab("Payslip");
        int rowNo = pageSteps.getRowsCount("Payslip");
        if (rowNo > 0)
        {
            pageSteps.setCheckBoxTableFilter("Sel", "Y");
            pageSteps.waitForAjax(1);
            pageSteps.clickButton("Submit");
            pageSteps.confirm("Yes");
        }
    }
}
