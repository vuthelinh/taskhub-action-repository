package com.synergix.payroll.integration_live_run.defs;

import com.synergix.common.CONST;
import com.synergix.common.actions.DatasetBase;
import com.synergix.common.actions.PageSteps;
import com.synergix.common.constants.MenuID;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

public class P_24_2_Process_Payroll_Additional_ByItem extends DatasetBase
{
    @Steps
    PageSteps pageSteps;
    String runCode;

    @Title("Integration Test for Live Run Steps - Payroll")
    @Given("^Additional Voucher By Item is created as in\\s+\"([^\"]*)\"$")
    public void testFlow(String dataset)
    {
        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
        setDataset("Dataset");
        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String desc = getColumn(1);
            String voucherDate = getColumn(2);
            String wageService = getColumn(3);
            String payrollDate = getColumn(4);
            String currency = getColumn(5);
            String exchRate = getColumn(6);
            String defUnitPrice = getColumn(7);
            String inclsTax = getColumn(8);
            String salesTax = getColumn(9);
            String addMultipleBy = getColumn(10);
            String recipientDetailNo = getColumn(11);

            if (empty(voucherDate))
                continue;

            pageSteps.goToMenu(MenuID.PROC_PY_ADDITIONAL_PAYMENT);
            pageSteps.clickButton("New");
            pageSteps.setText("Description", desc);
            pageSteps.setText("Voucher Date", voucherDate);
            pageSteps.setText("Wage Service", wageService);
            pageSteps.setText("Payroll Date", payrollDate);
            pageSteps.setDropDownOption("Currency", currency);
            pageSteps.setText("Exchange Rate", exchRate);
            pageSteps.setText("Default Unit Price", defUnitPrice);
            pageSteps.setCheckboxByValue("Inclusive Tax", inclsTax);
            pageSteps.setText("Sales Tax", salesTax);

            addRep(addMultipleBy, recipientDetailNo);

            pageSteps.clickButton("Submit");
            pageSteps.confirm("Yes");
        }
    }

    @Step("Add recipient by {0]")
    public void addRep(String addMultipleBy, String recipientDetailNo)
    {
        // add by employee code
        if (empty(addMultipleBy))
        {
            setDetailData("Employee");
            for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
            {
                String detNo = getColumn_Detail(1);
                if (detNo.equalsIgnoreCase(recipientDetailNo))
                {
                    String empCode = getColumn_Detail(2);
                    String qty = getColumn_Detail(3);
                    String unitPrice = getColumn_Detail(4);
                    String voucherNo = getColumn_Detail(5);
                    String phaseSeqNo = getColumn_Detail(6);
                    String liNo = getColumn_Detail(7);

                    if (notEmpty(empCode))
                    {
                        pageSteps.clickButton("Add");
                        pageSteps.waitForAjax(1);
                        pageSteps.setTextAtTableCell("Employee Code", 1, empCode);
                        pageSteps.setTextAtTableCell("Qty", 1, qty);
                        pageSteps.setTextAtTableCell("Unit Price", 1, unitPrice);
                    }
                }
            }
        }
        // add by EPC, Working Group, Piece Rate Group
        else
        {
            if (addMultipleBy.equalsIgnoreCase("Employee Payroll Category"))
            {
                pageSteps.setDropDownOption("Employee Payroll Category");
                setDetailData("EPC");
                for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
                {
                    String detNo = getColumn_Detail(1);
                    if (detNo.equalsIgnoreCase(recipientDetailNo))
                    {
                        String epcCode = getColumn_Detail(2);

                        if (notEmpty(epcCode))
                        {
                            pageSteps.clickButton("Add Multiple");
                            pageSteps.waitForAjax(1);
                            pageSteps.setText("Employee Payroll Category Code", epcCode);
                            pageSteps.clickButton("Search");
                            pageSteps.selectFirstRow("Employee Payroll Category Code");
                            pageSteps.confirm("OK");
                        }
                    }
                }
            }
            else if (addMultipleBy.equalsIgnoreCase("Working Group"))
            {
                pageSteps.setDropDownOption("Working Group");
                setDetailData("Working Group");
                for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
                {
                    String detNo = getColumn(1);
                    if (detNo.equalsIgnoreCase(recipientDetailNo))
                    {
                        String wkgCode = getColumn(2);

                        if (notEmpty(wkgCode))
                        {
                            pageSteps.clickButton("Add Multiple");
                            pageSteps.waitForAjax(1);
                            pageSteps.setText("Working Group Code", wkgCode);
                            pageSteps.clickButton("Search");
                            pageSteps.selectFirstRow("Working Group Code");
                            pageSteps.confirm("OK");
                        }
                    }
                }
            }
            else if (addMultipleBy.equalsIgnoreCase("Piece Rate Group") || addMultipleBy.contains("Piece Rate"))
            {
                pageSteps.setDropDownOption("Piece Rate Group");
                setDetailData("Piece Rate Group");
                for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
                {
                    String detNo = getColumn(1);
                    if (detNo.equalsIgnoreCase(recipientDetailNo))
                    {
                        String prCode = getColumn(2);

                        if (notEmpty(prCode))
                        {
                            pageSteps.clickButton("Add Multiple");
                            pageSteps.waitForAjax(1);
                            pageSteps.setText("Piece Rate Group", prCode);
                            pageSteps.clickButton("Search");
                            pageSteps.selectFirstRow("Piece Rate Group");
                            pageSteps.confirm("OK");
                        }
                    }
                }
            }
        }
    }
}