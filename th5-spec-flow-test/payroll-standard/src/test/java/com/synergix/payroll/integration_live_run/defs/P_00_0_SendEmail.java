package com.synergix.payroll.integration_live_run.defs;

import com.synergix.common.actions.DatasetBase;
import com.synergix.common.actions.PageSteps;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class P_00_0_SendEmail extends DatasetBase
{
    @Steps
    PageSteps pageSteps;

    @Then("user send mail report for Integration Live Run - Master Data$")
    public void sendMailReport_MasterData()
    {
//        String outputPath1 = getPayrollPath("LV_LeaveEntitlementByEmployee.xls");
//        String outputPath2 = getPayrollPath("LV_LeaveEntitlementByLeaveType.xls");
//        String outputPath3 = getPayrollPath("LV_Employee.xls");
//        String outputPath4 = getPayrollPath("LV_EmployeeGrade.xls");
//        String outputPath5 = getPayrollPath("LV_LeaveType.xls");
//        String outputPath6 = getPayrollPath("LV_ClearData.xls");
//        String featureFile = getPayrollFeaturePath("leave\\Leave_Entitlement_Dataset.feature");
//
//        List<String> attachments = Arrays.asList(outputPath, outputPath1, outputPath2, outputPath3, outputPath4, outputPath5, outputPath6);
//        sendEmailToPY("Leave Entitlement Report",
//                      "Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + " / DB: " + Serenity.sessionVariableCalled(
//                              "DB_URL") + "\n\n\n" + ReadBean.readFile(featureFile), attachments);
    }

    @Then("user send mail report for Integration Live Run - Processing$")
    public void sendMailReport_Processing()
    {

    }
}
