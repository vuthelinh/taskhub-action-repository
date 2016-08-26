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

public class P_01_2_Migrate_CPFContributionRateScheme extends DatasetBase
{
    @Steps
    PageSteps pageSteps;

    @Title("Integration Test for Live Run Steps - Payroll")
    @Given("^Migrate: CPF Contribution Rate Scheme is created as in\\s+\"([^\"]*)\"$")
    public void createCPFContribution(String dataset)
    {// set fail subject and message
        setFailSubject("Create CPF Contribution Rate Scheme Report - Fail");
        setFailMessage("Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL());

        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
        setDataset("Dataset");
        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String dateFrom = getColumn(1);
            String dateTo = getColumn(2);
            String owCeiling = getColumn(3);
            String totalCeiling = getColumn(4);

            if (empty(dateFrom))
                continue;

            pageSteps.goToMenu(MenuID.GL_PY_CPF_CONTRIBUTION_RATE_SCHEME);
            pageSteps.clickButton("Add");
            pageSteps.waitForAjax(1);
            pageSteps.setTextAtTableCell("Date From", 1, dateFrom);
            pageSteps.verifyResult("Verify Date From: ", pageSteps.getTextAtTableCell("Date From", 1), dateFrom);

            pageSteps.setTextAtTableCell("Date To", 1, dateTo);
            pageSteps.verifyResult("Verify Date To: ", pageSteps.getTextAtTableCell("Date To", 1), dateTo);

            pageSteps.setTextAtTableCell("Ow Ceiling Amt", 1, owCeiling);
            pageSteps.verifyResult("Verify Ow Ceiling Amt: ", pageSteps.getTextAtTableCell("Ow Ceiling Amt", 1), owCeiling);

            pageSteps.setTextAtTableCell("Total Ceiling Amt", 1, totalCeiling);
            pageSteps.verifyResult("Verify Total Ceiling Amt: ", pageSteps.getTextAtTableCell("Total Ceiling Amt", 1), totalCeiling);
        }
        pageSteps.clickButton("Update");
        pageSteps.confirmNoOk("Yes");

        pageSteps.verifyResult("Verify update succesfully: ", pageSteps.checkTextExist("Error", false) == false);
        pageSteps.confirm("OK");

        String report = pageSteps.getTableReport();
        writeReport(report);
        sendEmailToPY("Create CPF Contribution Rate Scheme Report - Success",
                      "Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + "\n" + report, ElementID.REPORT_FILE);
        pageSteps.verifyFinalResult(report);
    }

//    @Given("^Verify if CPF Contribution Rate Scheme is created as in\\s+\"([^\"]*)\"$")
//    public void verifyCPFContribution_Created(String dataset)
//    {
//        pageSteps.goToMenu(MenuID.GL_PY_CPF_CONTRIBUTION_RATE_SCHEME);
//        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
//        setDataset("Dataset");
//        for (i = 1; i <= datasetObjArray.length; i++)
//        {
//            String dateFrom = getColumn(1);
//            String dateTo = getColumn(2);
//            String owCeiling = getColumn(3);
//            String totalCeiling = getColumn(4);
//
//            if (empty(dateFrom))
//                continue;
//
//            int rowCount = pageSteps.getRowsCount("Date From");
//            boolean foundRecords = false;
//            for (int row = 1; row <= rowCount; row++)
//            {
//                String expDateFrom = pageSteps.getTextAtTableCell("Date From", row);
//                String expdateTo = pageSteps.getTextAtTableCell("Date To", row);
//                String expOwCeiling = pageSteps.getTextAtTableCell("Ow Ceiling Amt", row);
//                String expTotalCeiling = pageSteps.getTextAtTableCell("Total Ceiling Amt", row);
//
//                if (dateFrom.equalsIgnoreCase(expDateFrom) && dateTo.equalsIgnoreCase(expdateTo) && toDouble(owCeiling) == toDouble(
//                        expOwCeiling) && toDouble(totalCeiling) == toDouble(expTotalCeiling))
//                {
//                    pageSteps.verifyResult(
//                            "Check data: " + dateFrom + " = " + expDateFrom + "; " + dateTo + " = " + expdateTo + "; " + owCeiling + " = " + expOwCeiling + "; " + totalCeiling + " = " + expTotalCeiling,
//                            true);
//                    foundRecords = true;
//                    continue;
//                }
//            }
//            if (!foundRecords)
//                pageSteps.verifyResult("Check data: " + dateFrom + "; " + dateTo + "; " + owCeiling + "; " + totalCeiling, false);
//        }
//        pageSteps.verifyFinalResult("CPF Contribution Rate Scheme has been created");
//    }
}
