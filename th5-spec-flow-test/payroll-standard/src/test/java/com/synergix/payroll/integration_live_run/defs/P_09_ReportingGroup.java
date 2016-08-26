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

public class P_09_ReportingGroup extends DatasetBase
{
    @Steps
    PageSteps pageSteps;

    @Title("Integration Test for Live Run Steps - Payroll")
    @Given("^Payroll Reporting Group is created as in\\s+\"([^\"]*)\"$")
    public void testFlow(String dataset)
    {
        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
        setDataset("Dataset");
        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String groupCode = getColumn(1);
            String desc = getColumn(2);

            if (empty(groupCode))
                continue;

            // set fail subject and message
            setFailSubject("Create Reporting Group Report - Fail");
            setFailMessage("Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + " / Code: " + groupCode);

            pageSteps.goToMenu(MenuID.GL_PY_PAYROLL_REPORTING_GROUP);
            pageSteps.clickButton("New");
            pageSteps.setText("Payroll Reporting Group Code", groupCode);
            pageSteps.verifyResult("Payroll Reporting Group Code: ", pageSteps.getTextValue("Payroll Reporting Group Code"), groupCode);

            pageSteps.setText("Description", desc);
            pageSteps.verifyResult("Description: ", pageSteps.getTextValue("Description"), desc);

            pageSteps.clickButton("Update");
            pageSteps.confirmNoOk("Yes");

            pageSteps.verifyResult("Verify update succesfully: ", pageSteps.checkTextExist("Error", false) == false);
            pageSteps.confirm("OK");

            String report = pageSteps.getTableReport();
            writeReport(report);
            sendEmailToPY("Create Payroll Reporting Group Report - Success",
                          "Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + " / Payroll Reporting Group Code: " + groupCode + "\n" + report,
                          ElementID.REPORT_FILE);
            pageSteps.verifyStepResult(report);
        }
        pageSteps.verifyFinalResult("Create Payroll Reporting Group Report");
    }
}
