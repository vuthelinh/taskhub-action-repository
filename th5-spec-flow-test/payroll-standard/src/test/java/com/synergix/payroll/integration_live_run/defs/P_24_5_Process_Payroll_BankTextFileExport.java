package com.synergix.payroll.integration_live_run.defs;

import com.synergix.common.CONST;
import com.synergix.common.actions.DatasetBase;
import com.synergix.common.actions.PageSteps;
import com.synergix.common.constants.MenuID;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

public class P_24_5_Process_Payroll_BankTextFileExport extends DatasetBase
{
    @Steps
    PageSteps pageSteps;
    String runCode;

    @Title("Integration Test for Live Run Steps - Payroll")
    @Given("^Bank Text File Export for Payslip is generated as in\\s+\"([^\"]*)\"$")
    public void testFlow(String dataset)
    {
        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
        setDataset("Dataset");
        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String type = getColumn(1);
            String serviceType = getColumn(2);
            String bankCode = getColumn(3);
            String epcFilter = getColumn(4);
            String epcValue = getColumn(5);
            String payslipVoucherDate = getColumn(6);
            String bankValueDate = getColumn(7);

            if (empty(type))
                continue;

            pageSteps.goToMenu(MenuID.PROC_PY_BANK_TEXT_FILE_EXPORT);
            pageSteps.setDropDownOption(type);
            if (type.equalsIgnoreCase("UOB"))
                pageSteps.setDropDownOption("Service Type", serviceType);
            pageSteps.clickSearchButton("Bank Code");
            pageSteps.setText("Bank Party Code", bankCode);
            pageSteps.clickButton("Search", 1);
            pageSteps.selectFirstRow("Bank Party Code");
            pageSteps.setText("Payslip Voucher Date", payslipVoucherDate);
            pageSteps.setText("Bank Value Date", bankValueDate);
            pageSteps.setDropDownOption("Employee Payroll Category", epcFilter);
            pageSteps.setText("Employee Payroll Category", epcValue);
            pageSteps.clickButton("Export");

            // TODO: handle save file
        }
    }
}