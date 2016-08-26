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

public class P_10_PaymentCycle extends DatasetBase
{
    @Steps
    PageSteps pageSteps;

    @Title("Integration Test for Live Run Steps - Payroll")
    @Given("^Payment Cycle is created as in\\s+\"([^\"]*)\"$")
    public void createPaymentCycle(String dataset)
    {
        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
        setDataset("Dataset");
        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String paymentCycle = getColumn(1);
            String desc = getColumn(2);
            String paymentFreq = getColumn(3);
            String enableCapOtHours = getColumn(4);
            String firstCutoffDate = getColumn(5);
            String secondCutoffDate = getColumn(6);
            String timesheetCutoffDate = getColumn(7);
            String unpaidLeaveCutoffDate = getColumn(8);

            if (empty(paymentCycle))
                continue;

            // set fail subject and message
            setFailSubject("Create Payment Cycle Report - Fail");
            setFailMessage("Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + " / Code: " + paymentCycle);

            pageSteps.goToMenu(MenuID.GL_PY_PAYMENT_CYCLE);
            pageSteps.clickButton("New");
            pageSteps.setText("Payment Cycle Code", paymentCycle);
            if (pageSteps.checkTextExist("already exists in database", false))
            {
                pageSteps.confirm("OK");
                pageSteps.clickButton("Close");
                continue;
            }
            pageSteps.verifyResult("Payment Cycle Code: ", pageSteps.getTextValue("Payment Cycle Code"), paymentCycle);

            pageSteps.setText("Description:", desc);
            pageSteps.verifyResult("Description: ", pageSteps.getTextValue("Description:"), desc);

            pageSteps.setRadioOption("Payment Frequency", paymentFreq);
            pageSteps.verifyResult("Payment Frequency: ", pageSteps.getTextValue("Payment Frequency"), paymentFreq);

            pageSteps.setRadioOption("Enable cap OT hours", enableCapOtHours);
            pageSteps.verifyResult("Enable cap OT hours: ", pageSteps.isRadioOptionChecked("Enable cap OT hours", enableCapOtHours));

            pageSteps.setText("First Cut-off Date", firstCutoffDate);
            pageSteps.verifyResult("First Cut-off Date: ", pageSteps.getTextValue("First Cut-off Date"), firstCutoffDate);

            pageSteps.setText("Second Cut-off Date", secondCutoffDate);
            pageSteps.verifyResult("Second Cut-off Date: ", pageSteps.getTextValue("Second Cut-off Date"), secondCutoffDate);

            pageSteps.setText("Timesheet Cut-off Date", timesheetCutoffDate);
            pageSteps.verifyResult("Timesheet Cut-off Date: ", pageSteps.getTextValue("Timesheet Cut-off Date"), timesheetCutoffDate);

            pageSteps.setText("Unpaid Leave Cut-off Date", unpaidLeaveCutoffDate);
            pageSteps.verifyResult("Unpaid Leave Cut-off Date: ", pageSteps.getTextValue("Unpaid Leave Cut-off Date"), unpaidLeaveCutoffDate);

            pageSteps.clickButton("Update");
            pageSteps.confirmNoOk("Yes");

            pageSteps.verifyResult("Verify update succesfully: ", pageSteps.checkTextExist("Error", false) == false);
            pageSteps.confirm("OK");

            String report = pageSteps.getTableReport();
            writeReport(report);
            sendEmailToPY("Create Payment Cycle Report - Success",
                          "Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + " / Payment Cycle Code: " + paymentCycle + "\n" + report,
                          ElementID.REPORT_FILE);
            pageSteps.verifyStepResult(report);
        }
        pageSteps.verifyFinalResult("Create Payment Cycle Report");
    }
}
