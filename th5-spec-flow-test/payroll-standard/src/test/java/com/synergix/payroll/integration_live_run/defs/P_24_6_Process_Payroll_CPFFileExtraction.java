package com.synergix.payroll.integration_live_run.defs;

import com.synergix.common.CONST;
import com.synergix.common.actions.DatasetBase;
import com.synergix.common.actions.PageSteps;
import com.synergix.common.constants.MenuID;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

public class P_24_6_Process_Payroll_CPFFileExtraction extends DatasetBase
{
    @Steps
    PageSteps pageSteps;
    String runCode;

    @Title("Integration Test for Live Run Steps - Payroll")
    @Given("^CPF File Extraction is generated as in\\s+\"([^\"]*)\"$")
    public void testFlow(String dataset)
    {
        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
        setDataset("Dataset");
        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String cpfSubNo = getColumn(1);
            String year = getColumn(2);
            String month = getColumn(3);

            if (empty(cpfSubNo))
                continue;

            pageSteps.goToMenu(MenuID.PROC_PY_CPF_FILE_EXTRACTION);
            pageSteps.clickSearchButton("CPF Submission No.");
            pageSteps.setText("CPF Submission No.", cpfSubNo, 2);
            pageSteps.clickButton("Search");
            pageSteps.selectFirstRow("CPF Submission No.");
            pageSteps.setText("Year", year);
            pageSteps.setText("Month", month);
            pageSteps.clickButton("Export");

            // TODO: handle save file
        }
    }
}