package com.synergix.payroll.integration_live_run.defs;

import com.synergix.common.CONST;
import com.synergix.common.actions.DatasetBase;
import com.synergix.common.actions.PageSteps;
import com.synergix.common.constants.MenuID;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

public class P_24_3_Process_Payroll_Deduction extends DatasetBase
{
    @Steps
    PageSteps pageSteps;
    String runCode;

    @Title("Integration Test for Live Run Steps - Payroll")
    @Given("^Deduction Voucher is created as in\\s+\"([^\"]*)\"$")
    public void testFlow(String dataset)
    {
        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
        setDataset("Dataset");
        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String desc = getColumn(1);
            String voucherType = getColumn(2);
            String payrollDate = getColumn(3);
            String voucherDate = getColumn(4);
            String wageDetailNo = getColumn(5);

            if (empty(voucherType))
                continue;

            pageSteps.goToMenu(MenuID.PROC_PY_PAYROLL_DEDUCTION);
            pageSteps.clickButton("New");
            pageSteps.setText("Description", desc);
            pageSteps.setRadioOption("Voucher Type", voucherType);
            if (!voucherType.equalsIgnoreCase("Commission Group"))
                pageSteps.setText("Payroll Date", payrollDate);
            pageSteps.setText("Voucher Date", voucherDate);

            addService(voucherType, wageDetailNo);

            pageSteps.clickButton("Submit");
            pageSteps.confirm("Yes");
        }
    }

    @Step("Add wage service {0}")
    public void addService(String voucherType, String wageDetailNo)
    {
        if (voucherType.equalsIgnoreCase("Service"))
        {
            setDetailData("Service");
            for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
            {
                String detNo = getColumn_Detail(1);
                if (detNo.equalsIgnoreCase(wageDetailNo))
                {
                    String subjectType = getColumn_Detail(2);
                    String subjectCode = getColumn_Detail(3);
                    String serviceCode = getColumn_Detail(4);
                    String currency = getColumn_Detail(5);
                    String salesTax = getColumn_Detail(6);
                    String inclTax = getColumn_Detail(7);
                    String qty = getColumn_Detail(8);
                    String unitPrice = getColumn_Detail(9);
                    String deductionPerPayrun = getColumn_Detail(10);

                    if (notEmpty(unitPrice) && !unitPrice.equalsIgnoreCase("0"))
                    {
                        pageSteps.clickButton("Add");
                        pageSteps.waitForAjax(1);
                        pageSteps.setDropDownOptionAtTableCell("Subject Type", 1, subjectType);
                        pageSteps.setTextAtTableCell("Subject Code", 1, subjectCode);
                        pageSteps.setTextAtTableCell("Service Code", 1, serviceCode);
                        pageSteps.setDropDownOptionAtTableCell("Currency", 1, currency);
                        pageSteps.setTextAtTableCell("Sales Tax", 1, salesTax);
                        pageSteps.setCheckBoxAtTableCell("Incl. Tax", 1, inclTax);
                        pageSteps.setTextAtTableCell("Qty", 1, qty);
                        pageSteps.setTextAtTableCell("Unit Price", 1, unitPrice);
                        pageSteps.setTextAtTableCell("Deduction Per Payrun", 1, deductionPerPayrun);
                    }
                }
            }
        }
        else if (voucherType.equalsIgnoreCase("Medical"))
        {
            setDetailData("Medical");
            for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
            {
                String detNo = getColumn_Detail(1);
                if (detNo.equalsIgnoreCase(wageDetailNo))
                {
                    String empCode = getColumn_Detail(2);
                    String consultDate = getColumn_Detail(3);
                    String medicalExpense = getColumn_Detail(4);
                    String currency = getColumn_Detail(5);
                    String salesTax = getColumn_Detail(6);
                    String inclTax = getColumn_Detail(7);
                    String consultFee = getColumn_Detail(8);
                    String medicalFee = getColumn_Detail(9);
                    String oriAmt = getColumn_Detail(10);
                    String mcGranted = getColumn_Detail(11);
                    String deductionPerPayrun = getColumn_Detail(12);

                    if (notEmpty(consultFee) && notEmpty(medicalFee))
                    {
                        pageSteps.clickButton("Add");
                        pageSteps.waitForAjax(1);
                        pageSteps.setTextAtTableCell("Employee Code", 1, empCode);
                        pageSteps.setTextAtTableCell("Consultation Date", 1, consultDate);
                        pageSteps.setTextAtTableCell("Medical Expense", 1, medicalExpense);
                        pageSteps.setDropDownOptionAtTableCell("Currency", 1, currency);
                        pageSteps.setTextAtTableCell("Sales Tax", 1, salesTax);
                        pageSteps.setCheckBoxAtTableCell("Incl. Tax", 1, inclTax);
                        pageSteps.setTextAtTableCell("Medical Fee", 1, medicalFee);
                        if (empty(consultFee) && empty(medicalFee))
                            pageSteps.setTextAtTableCell("Original Amt", 1, oriAmt);
                        pageSteps.setCheckBoxAtTableCell("MC Granted", 1, mcGranted);
                        pageSteps.setTextAtTableCell("Deduction Per Payrun", 1, deductionPerPayrun);
                    }
                }
            }
        }
        else if (voucherType.equalsIgnoreCase("Commission Group"))
        {
            setDetailData("Commission Group");
            for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
            {
                String detNo = getColumn_Detail(1);
                if (detNo.equalsIgnoreCase(wageDetailNo))
                {
                    String comGroupCode = getColumn_Detail(2);
                    String serviceCode = getColumn_Detail(3);
                    String currency = getColumn_Detail(4);
                    String exchRate = getColumn_Detail(5);
                    String qty = getColumn_Detail(6);
                    String unitPrice = getColumn_Detail(7);

                    if (notEmpty(unitPrice) && !unitPrice.equalsIgnoreCase("0"))
                    {
                        pageSteps.clickButton("Add");
                        pageSteps.waitForAjax(1);
                        pageSteps.setTextAtTableCell("Commission Group Code", 1, comGroupCode);
                        pageSteps.setTextAtTableCell("Service Code", 1, serviceCode);
                        pageSteps.setDropDownOptionAtTableCell("Currency", 1, currency);
                        pageSteps.setTextAtTableCell("Exch Rate", 1, exchRate);
                        pageSteps.setTextAtTableCell("Qty", 1, qty);
                        pageSteps.setTextAtTableCell("Unit Price", 1, unitPrice);
                    }
                }
            }
        }
    }
}