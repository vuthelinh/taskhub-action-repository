package com.synergix.payroll.cpf_calculation.defs;

import com.synergix.common.CONST;
import com.synergix.common.actions.DatasetBase;
import com.synergix.common.actions.PageSteps;
import com.synergix.common.constants.MenuID;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

public class AdditionalPaymentDefs extends DatasetBase
{
    @Steps
    PageSteps pageSteps;

    @Title("CPF Calculation")
    @Given("^Additional Payment By Recipient for CPF is created as in\\s+\"([^\"]*)\"$")
    public void testFlow(String dataset)
    {
        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
        setDataset("Dataset");
        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String voucherDate = getColumn(1);
            String desc        = getColumn(2);
            String recipent    = getColumn(3);
            String payrollDate = getColumn(4);
            String voucherType = getColumn(5);
            String OW          = getColumn(6);
            String AW          = getColumn(7);
            String TW          = getColumn(8);
            String vchDate     = getColumn(9);
            String currency    = getColumn(10);
            String exchRate    = getColumn(11);
            String qty         = getColumn(12);
            String inclTax     = getColumn(13);
            String salesTax    = getColumn(14);

            pageSteps.goToMenu(MenuID.PROC_PY_ADDITIONAL_PAYMENT);
            pageSteps.goToTab("By Recipient");
            pageSteps.clickButton("New", 2);
            pageSteps.setText("Description", desc);
            pageSteps.setText("Voucher Date", voucherDate);
            if (payrollDate.equalsIgnoreCase("C"))
                payrollDate = voucherDate;
            pageSteps.setText("Payroll Date", payrollDate); // must set payroll date first
            pageSteps.setText("Recipients:", recipent);
            //setRadioOption("Voucher Type", voucherType);

            if (notEmpty(OW) || !OW.equals("0"))
                addService("OW", voucherDate, currency, exchRate, qty, OW, inclTax, salesTax);

            if (notEmpty(AW) || !AW.equals("0"))
                addService("AW", voucherDate, currency, exchRate, qty, AW, inclTax, salesTax);

            pageSteps.clickButton("Submit");
            pageSteps.confirm("Yes");
        }
    }

    @Step("Add wage service {0}")
    public void addService(String wageSrv, String voucherDate, String currency, String exchRate, String qty, String unitPrice, String inclTax,
                           String salesTax)
    {
        if (notEmpty(unitPrice) && !unitPrice.equalsIgnoreCase("0"))
        {
            pageSteps.clickButton("Add");
            pageSteps.waitForAjax(1);
            pageSteps.setTextAtTableCellPRTimeSheet("Additional", "Wage Service Description", 1, wageSrv);
            pageSteps.setTextAtTableCellPRTimeSheet("Additional", "Voucher Date", 1, voucherDate);
            pageSteps.setDropDownOptionAtTableCellPRTimesheet("Additional", "Currency", 1, currency);
            pageSteps.waitForAjax(1);
            pageSteps.setTextAtTableCellPRTimeSheet("Additional", "Exchange Rate", 1, exchRate);
            pageSteps.setTextAtTableCellPRTimeSheet("Additional", "Qty", 1, qty);
            pageSteps.setTextAtTableCellPRTimeSheet("Additional", "Unit Price", 1, unitPrice);
            pageSteps.setCheckBoxAtTableCellPRTimesheet("Additional", "Incl. Tax", 1, inclTax);
            pageSteps.waitForAjax(1);
            pageSteps.setTextAtTableCellPRTimeSheet("Additional", "Sales Tax", 1, salesTax);
        }
    }
}
