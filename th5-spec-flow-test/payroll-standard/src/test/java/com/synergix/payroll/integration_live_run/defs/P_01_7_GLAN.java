package com.synergix.payroll.integration_live_run.defs;

import com.synergix.common.CONST;
import com.synergix.common.actions.DatasetBase;
import com.synergix.common.actions.PageSteps;
import com.synergix.common.constants.ElementID;
import com.synergix.common.constants.MenuID;
import com.synergix.utilities.DateTimeUtil;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

public class P_01_7_GLAN extends DatasetBase
{
    @Steps
    PageSteps pageSteps;

    @Title("Integration Test for Live Run Steps - Payroll")
    @Given("^GLAN is created as in\\s+\"([^\"]*)\"$")
    public void testFlow(String dataset)
    {
        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
        setDataset("Dataset");
        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String glCode = getColumn(1);
            String desc = getColumn(2);
            String accType = getColumn(3);
            String forSubLedger = getColumn(4);

            if (empty(glCode))
                continue;

            // set fail subject and message
            setFailSubject("Create GLAN Report - Fail");
            setFailMessage("Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + " / Code: " + glCode);

            pageSteps.goToMenu(MenuID.GL_CHART_OF_ACC);
            pageSteps.clickButton("New");
            pageSteps.setText("GL Account Code", glCode);
            if (pageSteps.checkTextExist("already exists in database", false))
            {
                pageSteps.confirm("OK");
                pageSteps.clickButton("Close");
                continue;
            }
            pageSteps.verifyResult("Verify GL Account Code: ", pageSteps.getTextValue("GL Account Code"), glCode);

            pageSteps.setText("Description", desc);
            pageSteps.verifyResult("Verify Description: ", pageSteps.getTextValue("Description"), desc);

            pageSteps.setRadioOption("Account Type", accType);
            pageSteps.verifyResult("Verify Account Type: ", pageSteps.isRadioOptionChecked("Account Type", desc));

            pageSteps.setRadioOption("For Sub Ledger Account", forSubLedger);
            pageSteps.verifyResult("Verify For Sub Ledger Account: ", pageSteps.isRadioOptionChecked("For Sub Ledger Account", forSubLedger));

            pageSteps.clickButton("Update");
            pageSteps.confirmNoOk("Yes");

            pageSteps.verifyResult("Verify update succesfully: ", pageSteps.checkTextExist("Error", false) == false);
            pageSteps.confirm("OK");

            String report = pageSteps.getTableReport();
            writeReport(report);
            sendEmailToPY("Create GLAN Report - Success",
                          "Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + " / GLAN Code: " + glCode + "\n" + report,
                          ElementID.REPORT_FILE);
            pageSteps.verifyStepResult(report);
        }
        pageSteps.verifyFinalResult("Create GLAN Report");
    }
}
