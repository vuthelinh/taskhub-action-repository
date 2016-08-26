package com.synergix.payroll.integration_live_run.defs;

import com.synergix.common.CONST;
import com.synergix.common.actions.DatasetBase;
import com.synergix.common.actions.PageSteps;
import com.synergix.common.constants.MenuID;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

public class P_24_2_Process_Payroll_Additional_ByRecipient extends DatasetBase
{
    @Steps
    PageSteps pageSteps;
    String runCode;

    @Title("Integration Test for Live Run Steps - Payroll")
    @Given("^Additional Voucher By Recipient is created as in\\s+\"([^\"]*)\"$")
    public void testFlow(String dataset)
    {
        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
        setDataset("Dataset");
        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String desc = getColumn(1);
            String voucherDate = getColumn(2);
            String recipients = getColumn(3);
            String voucherType = getColumn(4);
            String payrollDate = getColumn(5);
            String wageDetailNo = getColumn(6);

            if (empty(voucherDate))
                continue;

            pageSteps.goToMenu(MenuID.PROC_PY_ADDITIONAL_PAYMENT);
            pageSteps.goToTab("By Recipient");
            pageSteps.clickButton("New", 2);
            pageSteps.setText("Description", desc);
            pageSteps.setText("Voucher Date", voucherDate);
            if (payrollDate.equalsIgnoreCase("C"))
                payrollDate = voucherDate;
            pageSteps.setText("Payroll Date", payrollDate); // must set payroll date first
            pageSteps.setText("Recipients:", recipients);
            pageSteps.setRadioOption("Voucher Type", voucherType);

            addService(wageDetailNo);

            pageSteps.clickButton("Submit");
            pageSteps.confirm("Yes");
        }
    }

    @Step("Add wage service {0}")
    public void addService(String wageDetailNo)
    {
        setDetailData("Wage");
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detNo = getColumn_Detail(1);
            if (detNo.equalsIgnoreCase(wageDetailNo))
            {
                String wageService = getColumn_Detail(2);
                String voucherDate = getColumn_Detail(3);
                String currency = getColumn_Detail(4);
                String exchRate = getColumn_Detail(5);
                String qty = getColumn_Detail(6);
                String unitPrice = getColumn_Detail(7);
                String inclTax = getColumn_Detail(8);
                String salesTax = getColumn_Detail(9);

                if (notEmpty(unitPrice) && !unitPrice.equalsIgnoreCase("0"))
                {
                    pageSteps.clickButton("Add");
                    pageSteps.waitForAjax(1);
                    pageSteps.setTextAtTableCellPRTimeSheet("Additional", "Wage Service Description", 1, wageService);
                    pageSteps.setTextAtTableCellPRTimeSheet("Additional", "Voucher Date", 1, voucherDate);
                    pageSteps.setDropDownOptionAtTableCellPRTimesheet("Additional", "Currency", 1, currency);
                    pageSteps.setTextAtTableCellPRTimeSheet("Additional", "Exchange Rate", 1, exchRate);
                    pageSteps.setTextAtTableCellPRTimeSheet("Additional", "Qty", 1, qty);
                    pageSteps.setTextAtTableCellPRTimeSheet("Additional", "Unit Price", 1, unitPrice);
                    pageSteps.setCheckBoxAtTableCellPRTimesheet("Additional", "Incl. Tax", 1, inclTax);
                    pageSteps.setTextAtTableCellPRTimeSheet("Additional", "Sales Tax", 1, salesTax);
                }
            }
        }
    }
}