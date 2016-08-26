package com.synergix.payroll.addpayment;

import com.synergix.common.actions.DatasetBase;
import com.synergix.common.actions.PageSteps;
import com.synergix.common.constants.MenuID;
import com.synergix.utilities.SessionData;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by synergix61 on 20160803.
 */
public class AddPaymentByRecipientDefs extends DatasetBase
{
    @Steps
    PageSteps pageSteps;
    private final static String PY_GENERATION_VOUCHER_NO = "PY_GENERATION_VOUCHERNO";

    @When("^user generates payslip for Additional Payment as \"([^\"]*)\"$")
    public void user_generates_payslip_for_Additional_Payment_as(String dataKey, List<List<String>> dataTable) throws Throwable
    {
        SessionData.addDataTable("GEN_PAYSLIP_ADDPAYMENT", dataTable);
        LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
        testData = SessionData.getDataTbRowsByValEqualInCol("GEN_PAYSLIP_ADDPAYMENT", "KEY", dataKey);
        for (int row : testData.keySet())
        {
            String sKey = SessionData.getDataTbVal("GEN_PAYSLIP_ADDPAYMENT", row, "KEY");
            String sPayrollGlPostingDate = SessionData.getDataTbVal("GEN_PAYSLIP_ADDPAYMENT", row, "Payroll GL Posting Date");
            String sYear = SessionData.getDataTbVal("GEN_PAYSLIP_ADDPAYMENT", row, "Year");
            String sMonth = SessionData.getDataTbVal("GEN_PAYSLIP_ADDPAYMENT", row, "Month");
            String sPaymentCycleCode = SessionData.getDataTbVal("GEN_PAYSLIP_ADDPAYMENT", row, "Payment Cycle Code");
            String sPaymentCycleNo = SessionData.getDataTbVal("GEN_PAYSLIP_ADDPAYMENT", row, "Payment Cycle No");
            String sGeneratePayslipForAdvancement = SessionData.getDataTbVal("GEN_PAYSLIP_ADDPAYMENT", row, "Generate Payslip for advancement");
            String sGeneratePayslipBy = SessionData.getDataTbVal("GEN_PAYSLIP_ADDPAYMENT", row, "Generate Payslip By");
            String sEmployeeCode = SessionData.getDataTbVal("GEN_PAYSLIP_ADDPAYMENT", row, "Employee Code");
            String sEpc = SessionData.getDataTbVal("GEN_PAYSLIP_ADDPAYMENT", row, "EPC");
            String sSubmit = SessionData.getDataTbVal("GEN_PAYSLIP_ADDPAYMENT", row, "Submit");
            if (!sKey.isEmpty())
            {
            }
            else
            {
                continue;
            }
            if (!sPayrollGlPostingDate.isEmpty())
            {
                pageSteps.goToMenu(MenuID.PROC_PY_PAYROLL_GENERATION);
                pageSteps.goToTab("Payroll Generation");
                pageSteps.clickButton("New");
                // invoiceList.put(payslipVoucherNo,
                // pageSteps.getTextDesc("Payroll Generation Voucher No."));
                SessionData.addToListString(PY_GENERATION_VOUCHER_NO, pageSteps.getTextDesc("Payroll Generation Voucher No."));
                pageSteps.setText("Year", sYear); // must set year before GL
                // posting date
                pageSteps.setText("Month", sMonth);
                pageSteps.setText("Payroll GL Posting Date", sPayrollGlPostingDate);
                pageSteps.setText("Payment Cycle Code", sPaymentCycleCode);
                pageSteps.setRadioOption("Payment Cycle No.", sPaymentCycleNo);

                if (pageSteps.checkTextExist("Generate payslip for advancement", true))
                    pageSteps.setRadioOption("Generate payslip for advancement", sGeneratePayslipForAdvancement);
                else
                {
                    if (sGeneratePayslipForAdvancement.equalsIgnoreCase("N") || sGeneratePayslipForAdvancement.equalsIgnoreCase("No"))
                        pageSteps.setRadioOption("Generate Payslip For", "Main Payslip");
                    else
                        pageSteps.setRadioOption("Generate Payslip For", "Advancement");
                }
                pageSteps.setRadioOption("Generate Payslip By", sGeneratePayslipBy);
            }

            if (!sEpc.isEmpty())
            {
                pageSteps.setTableFilter("Employee Payroll Category", sEpc);
                pageSteps.setCheckboxAtXpathCSS("//tbody//tr[1]//*[@type='checkbox'][contains(@name, 'EmpPayrollCategoryTblId')]", true);
            }

            if (notEmpty(sEmployeeCode))
            {
                pageSteps.clickButton("Add");
                pageSteps.waitForAjax(1);
                int rowNo = pageSteps.getRowsCount("Employee Code");
                pageSteps.setTextAtTableCell("Employee Code", rowNo, sEmployeeCode);
            }
            if (notEmpty(sEpc))
            {
                pageSteps.setTableFilter("Employee Payroll Category", sEpc);
                pageSteps.setCheckboxAtXpathCSS("//tbody//tr[1]//*[@type='checkbox'][contains(@name, 'EmpPayrollCategoryTblId')]", true);
            }
            if (sSubmit.equalsIgnoreCase("Y"))
            {
                pageSteps.waitForAjax(1);
                pageSteps.clickButton("Generate Payslip");
                pageSteps.confirm("Yes");
                pageSteps.confirm("OK");
            }
        }
    }

    @Then("^user submits payslip for Additional Payment as \"([^\"]*)\"$")
    public void user_submits_payslip_for_Additional_Payment_as(String dataKey, List<List<String>> dataTable) throws Throwable
    {
        SessionData.addDataTable("SUBMIT_PAYSLIP_ADDPAYMENT", dataTable);
        LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();
        testData = SessionData.getDataTbRowsByValEqualInCol("SUBMIT_PAYSLIP_ADDPAYMENT", "KEY", dataKey);
        for (int row : testData.keySet())
        {
            String sKey = SessionData.getDataTbVal("SUBMIT_PAYSLIP_ADDPAYMENT", row, "KEY");
            String sVoucherNo = SessionData.getDataTbVal("SUBMIT_PAYSLIP_ADDPAYMENT", row, "Voucher No");
            if (!sKey.isEmpty())
            {
            }
            else
            {
                continue;
            }
            if (!sVoucherNo.isEmpty())
            {
                if (sVoucherNo.equals("@CreatedGenerateVoucher@"))
                {
                    sVoucherNo = SessionData.getListStringLastValue(PY_GENERATION_VOUCHER_NO);
                }
                pageSteps.goToMenu(MenuID.PROC_PY_PAYROLL_GENERATION);
                pageSteps.goToTab("Payslip");
                // pageSteps.setTableFilter("Payroll Generation",
                // getVoucher(payslipVoucherNo));
                pageSteps.setTextAtXpathCSS("//table[contains(@id, 'payslipDraftSummaryTblId')]/thead/tr[1]/th[2]//input", sVoucherNo);
                pageSteps.waitForAjax(1);
                pageSteps.setCheckBoxTableFilter("Sel", "Y");
                pageSteps.waitForAjax(1);
                pageSteps.clickButton("Submit");
                pageSteps.confirm("Yes");
                pageSteps.confirm("OK");
            }
        }
    }
}
