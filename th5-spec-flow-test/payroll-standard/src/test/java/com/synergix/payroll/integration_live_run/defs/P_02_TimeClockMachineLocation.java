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

public class P_02_TimeClockMachineLocation extends DatasetBase
{
    @Steps
    PageSteps pageSteps;

    @Title("Integration Test for Live Run Steps - Payroll")
    @Given("^Time Clock Machine Location is created as in\\s+\"([^\"]*)\"$")
    public void testFlow(String dataset)
    {
        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
        setDataset("Dataset");
        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String locationNo = getColumn(1);
            String desc = getColumn(2);

            if (empty(locationNo))
                continue;

            // set fail subject and message
            setFailSubject("Create Time Clock Machine Location Report - Fail");
            setFailMessage("Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + " / Code: " + locationNo);

            pageSteps.goToMenu(MenuID.GL_PY_TIME_CLOCK_MACHINE_LOCATION);
            pageSteps.clickButton("New");
            pageSteps.setText("Time Clock Machine Location No", locationNo);
            if (pageSteps.checkTextExist("already exists in database", false))
            {
                pageSteps.confirm("OK");
                pageSteps.clickButton("Close");
                continue;
            }
            pageSteps.verifyResult("Verify Time Clock Machine Location No: ", pageSteps.getTextValue("Time Clock Machine Location No"), locationNo);

            pageSteps.setText("Description", desc);
            pageSteps.verifyResult("Verify Description: ", pageSteps.getTextValue("Description"), desc);

            pageSteps.clickButton("Update");
            pageSteps.confirmNoOk("Yes");

            pageSteps.verifyResult("Verify update succesfully: ", pageSteps.checkTextExist("Error", false) == false);
            pageSteps.confirm("OK");

            String report = pageSteps.getTableReport();
            writeReport(report);
            sendEmailToPY("Create Time Clock Machine Location Report - Success",
                          "Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + " / TMS No: " + locationNo + "\n" + report,
                          ElementID.REPORT_FILE);
            pageSteps.verifyStepResult(report);
        }
        pageSteps.verifyFinalResult("Create Time Clock Machine Location Report ");
    }
}
