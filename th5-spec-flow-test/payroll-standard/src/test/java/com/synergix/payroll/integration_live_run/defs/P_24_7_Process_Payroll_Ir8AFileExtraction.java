package com.synergix.payroll.integration_live_run.defs;

import com.synergix.common.CONST;
import com.synergix.common.actions.DatasetBase;
import com.synergix.common.actions.PageSteps;
import com.synergix.common.constants.MenuID;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

public class P_24_7_Process_Payroll_Ir8AFileExtraction extends DatasetBase
{
    @Steps
    PageSteps pageSteps;
    String runCode;

    @Title("Integration Test for Live Run Steps - Payroll")
    @Given("^Ir8A File Extraction is generated as in\\s+\"([^\"]*)\"$")
    public void testFlow(String dataset)
    {
        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
        setDataset("Dataset");
        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String year           = getColumn(1);
            String companyCode    = getColumn(2);
            String cpfSubNo       = getColumn(3);
            String empFilter      = getColumn(4);
            String empFilterValue = getColumn(5);

            pageSteps.goToMenu(MenuID.PROC_PY_IR8A_FILE_EXTRACTION);
            pageSteps.setText("Year", year);
            pageSteps.setText("Company Code", companyCode);
            pageSteps.clickSearchButton("CPF Submission No.");
            pageSteps.setText("CPF Submission No.", cpfSubNo, 2);
            pageSteps.clickButton("Search");
            pageSteps.selectFirstRow("CPF Submission No.");
            pageSteps.setDropDownOption("Employee", empFilter);
            pageSteps.setText("Employee", empFilterValue);
            pageSteps.clickButton("Export");

            // TODO: handle save file window dialog
        }
    }
}