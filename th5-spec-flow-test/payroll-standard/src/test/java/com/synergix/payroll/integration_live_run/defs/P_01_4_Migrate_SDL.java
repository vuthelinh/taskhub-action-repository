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

public class P_01_4_Migrate_SDL extends DatasetBase
{
    @Steps
    PageSteps pageSteps;

    @Title("Integration Test for Live Run Steps - Payroll")
    @Given("^Migrate: SDL is created as in\\s+\"([^\"]*)\"$")
    public void createSDL(String dataset)
    {
        // set fail subject and message
        setFailSubject("Create SDL Report - Fail");
        setFailMessage("Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL());

        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
        setDataset("Dataset");
        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String dateFrom = getColumn(1);
            String dateTo = getColumn(2);
            String levyRate = getColumn(3);
            String minimumDSL = getColumn(4);
            String wageCeilingAmt = getColumn(5);

            if (empty(dateFrom))
                continue;

            pageSteps.goToMenu(MenuID.GL_PY_SDL_MAINTENANCE);
            pageSteps.clickButton("Add");
            pageSteps.setTextAtTableCell("Date From", 1, dateFrom);
            pageSteps.verifyResult("Verify Date From: ", pageSteps.getTextAtTableCell("Date From", 1), dateFrom);

            pageSteps.setTextAtTableCell("Date To", 1, dateTo);
            pageSteps.verifyResult("Verify Date To: ", pageSteps.getTextAtTableCell("Date To", 1), dateTo);

            pageSteps.setTextAtTableCell("% Levy Rate", 1, levyRate);
            pageSteps.verifyResult("Verify % Levy Rate: ", pageSteps.getTextAtTableCell("% Levy Rate", 1), levyRate);

            pageSteps.setTextAtTableCell("Minimum SDL Amt", 1, minimumDSL);
            pageSteps.verifyResult("Verify Minimum SDL Amt: ", pageSteps.getTextAtTableCell("Minimum SDL Amt", 1), minimumDSL);

            pageSteps.setTextAtTableCell("Wage Ceiling Amt", 1, wageCeilingAmt);
            pageSteps.verifyResult("Verify Wage Ceiling Amt: ", pageSteps.getTextAtTableCell("Wage Ceiling Amt", 1), wageCeilingAmt);
        }
        pageSteps.clickButton("Update");
        pageSteps.confirmNoOk("Yes");

        pageSteps.verifyResult("Verify update succesfully: ", pageSteps.checkTextExist("Error", false) == false);
        pageSteps.confirm("OK");

        String report = pageSteps.getTableReport();
        writeReport(report);
        sendEmailToPY("Create SDL Report - Success", "Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + "\n" + report,
                      ElementID.REPORT_FILE);
        pageSteps.verifyFinalResult(report);
    }

//    @Given("^Verify if SDL is created as in\\s+\"([^\"]*)\"$")
//    public void verifySDL_Created(String dataset)
//    {
//        pageSteps.goToMenu(MenuID.GL_PY_SDL_MAINTENANCE);
//        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
//        setDataset("Dataset");
//        for (i = 1; i <= datasetObjArray.length; i++)
//        {
//            String dateFrom = getColumn(1);
//            String dateTo = getColumn(2);
//            String levyRate = getColumn(3);
//            String minimumDSL = getColumn(4);
//            String wageCeilingAmt = getColumn(5);
//
//            if (empty(dateFrom))
//                continue;
//
//            int rowCount = pageSteps.getRowsCount("Date From");
//            boolean foundRecords = false;
//            for (int row = 1; row <= rowCount; row++)
//            {
//                String dateFrom_Exp = pageSteps.getTextAtTableCell("Date From", row);
//                String dateTo_Exp = pageSteps.getTextAtTableCell("Date To", row);
//                String levyRate_Exp = pageSteps.getTextAtTableCell("% Levy Rate", row);
//                String minimumDSL_Exp = pageSteps.getTextAtTableCell("Minimum SDL Amt", row);
//                String wageCeilingAmt_Exp = pageSteps.getTextAtTableCell("Wage Ceiling Amt", row);
//
//                if (dateFrom.equalsIgnoreCase(dateFrom_Exp) && dateTo.equalsIgnoreCase(dateTo_Exp) && toDouble(levyRate) == toDouble(
//                        levyRate_Exp) && toDouble(minimumDSL) == toDouble(minimumDSL_Exp) && toDouble(wageCeilingAmt) == toDouble(wageCeilingAmt_Exp))
//                {
//                    pageSteps.verifyResult(
//                            "Check data: " + dateFrom + " = " + dateFrom_Exp + "; " + dateTo + " = " + dateTo_Exp + "; " + levyRate + " = " + levyRate_Exp + "; " + minimumDSL + " = " + minimumDSL_Exp + "; " + wageCeilingAmt + " = " + wageCeilingAmt_Exp,
//                            true);
//                    foundRecords = true;
//                    continue;
//                }
//            }
//            if (!foundRecords)
//                pageSteps.verifyResult("Check data: " + dateFrom + "; " + dateTo + "; " + levyRate + "; " + minimumDSL + "; " + wageCeilingAmt,
//                                       false);
//        }
//        pageSteps.verifyFinalResult("SDL has been created");
//    }
}
