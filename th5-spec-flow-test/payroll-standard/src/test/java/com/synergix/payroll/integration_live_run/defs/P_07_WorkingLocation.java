package com.synergix.payroll.integration_live_run.defs;

import com.synergix.common.CONST;
import com.synergix.common.actions.DatasetBase;
import com.synergix.common.actions.PageSteps;
import com.synergix.common.constants.ElementID;
import com.synergix.common.constants.MenuID;
import com.synergix.utilities.DateTimeUtil;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

public class P_07_WorkingLocation extends DatasetBase
{
    @Steps
    PageSteps pageSteps;

    @Title("Integration Test for Live Run Steps - Payroll")
    @Given("^Working Location is created as in\\s+\"([^\"]*)\"$")
    public void testFlow(String dataset)
    {
        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
        setDataset("Dataset");
        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String locCode = getColumn(1);
            String desc = getColumn(2);
            String tmsNo = getColumn(3);

            if (empty(locCode))
                continue;

            // set fail subject and message
            setFailSubject("Create Working Location Report - Fail");
            setFailMessage("Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + " / Code: " + locCode);

            pageSteps.goToMenu(MenuID.GL_PY_WORKING_LOCATION);
            pageSteps.clickButton("New");
            pageSteps.setText("Working Location", locCode);
            pageSteps.verifyResult("Working Location: ", pageSteps.getTextValue("Working Location"), locCode);

            pageSteps.setText("Description", desc);
            pageSteps.verifyResult("Description: ", pageSteps.getTextValue("Description"), desc);

            pageSteps.setText("Time Clock Machine Location No", tmsNo);
            pageSteps.verifyResult("Time Clock Machine Location No: ", pageSteps.getTextValue("Time Clock Machine Location No"), tmsNo);

            // Customer
            setCustomer(locCode);

            pageSteps.clickButton("Update");
            pageSteps.confirmNoOk("Yes");

            pageSteps.verifyResult("Verify update succesfully: ", pageSteps.checkTextExist("Error", false) == false);
            pageSteps.confirm("OK");

            String report = pageSteps.getTableReport();
            writeReport(report);
            sendEmailToPY("Create Working Location Report - Success",
                          "Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + " / Working Location Code: " + locCode + "\n" + report,
                          ElementID.REPORT_FILE);
            pageSteps.verifyStepResult(report);
        }
        pageSteps.verifyFinalResult("Create Working Location Report");
    }

    @Step("Set customer info")
    public void setCustomer(String customerDetailNo)
    {
        setDetailData("Customer");
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detNo = getColumn_Detail(1);
            if (detNo.equalsIgnoreCase(customerDetailNo))
            {
                String cusCode = getColumn_Detail(2);
                String cusName = getColumn_Detail(3);

                if (notEmpty(cusCode))
                {
                    pageSteps.clickButton("Add");
                    pageSteps.setTextAtTableCell("Customer Code", 1, cusCode);
                    pageSteps.verifyResult("Customer Code: ", pageSteps.getTextAtTableCell("Customer Code", 1), cusCode);

                    pageSteps.setTextAtTableCell("Customer Name", 1, cusName);
                    pageSteps.verifyResult("Customer Name: ", pageSteps.getTextAtTableCell("Customer Name", 1), cusName);
                }
            }
        }
    }
}
