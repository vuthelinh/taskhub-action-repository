package com.synergix.payroll.integration_live_run.defs;

import com.synergix.common.CONST;
import com.synergix.common.actions.DatasetBase;
import com.synergix.common.actions.PageSteps;
import com.synergix.common.constants.MenuID;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

public class P_24_4_Process_Payroll_Payslip extends DatasetBase
{
    @Steps
    PageSteps pageSteps;
    String runCode;

    @Title("Integration Test for Live Run Steps - Payroll")
    @Given("^Payslip is generated as in\\s+\"([^\"]*)\"$")
    public void testFlow(String dataset)
    {
        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
        setDataset("Dataset");
        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String glPostDate = getColumn(1);
            String year = getColumn(2);
            String month = getColumn(3);
            String paymentCycle = getColumn(4);
            String paymentCycleNo = getColumn(5);
            String dateOfPayment = getColumn(6);
            String genPayslipFor = getColumn(7);
            String genPayslipBy = getColumn(8);
            String epcDetailNo = getColumn(9);

            if (empty(glPostDate))
                continue;

            pageSteps.goToMenu(MenuID.PROC_PY_PAYROLL_GENERATION);
            pageSteps.clickButton("New");
            String payrollGenVoucherNo = pageSteps.getTextDesc("Payroll Generation Voucher No.");
            pageSteps.setText("Payroll GL Posting Date", glPostDate);
            pageSteps.setText("Year", year);
            pageSteps.setText("Month", month);
            pageSteps.setText("Payment Cycle Code", paymentCycle);
            pageSteps.setRadioOption("Payment Cycle No.", paymentCycleNo);
            pageSteps.setRadioOption("Generate Payslip By", genPayslipBy);

            setDetailData("EPC");
            for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
            {
                String detNo = getColumn(1);
                if (detNo.equalsIgnoreCase(epcDetailNo))
                {
                    String epcCode = getColumn(2);
                    String desc = getColumn(3);

                    if (notEmpty(epcCode))
                    {
                        pageSteps.setTableFilter("Employee Payroll Category", epcCode);
                        pageSteps.setTableFilter("Description", desc);
                        pageSteps.setCheckBoxAtMultiList("Employee Payroll Category", epcCode, "Y", false);
                    }
                }
            }
            pageSteps.clickButton("Generate Payslip");
            pageSteps.confirm("Yes");

            // submit payslip
            pageSteps.goToMenu(MenuID.PROC_PY_PAYROLL_GENERATION);
            pageSteps.goToTab("Payslip");
            for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
            {
                String detNo = getColumn(1);
                if (detNo.equalsIgnoreCase(epcDetailNo))
                {
                    String epcCode = getColumn(2);

                    if (notEmpty(epcCode))
                    {
                        pageSteps.setTableFilter("Employee Payroll Category", epcCode);
                        pageSteps.setTableFilter("Payroll Generation Voucher No.", payrollGenVoucherNo);
                        pageSteps.setCheckBoxTableFilter("Sel", "Y");
                        pageSteps.waitForAjax(3);
                    }
                }
            }
            pageSteps.clickButton("Submit");
            pageSteps.confirm("Yes");
        }
    }
}