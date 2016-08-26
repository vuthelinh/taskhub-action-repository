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

public class P_01_3_Migrate_CommunityFundDonation extends DatasetBase
{
    @Steps
    PageSteps pageSteps;

    @Title("Integration Test for Live Run Steps - Payroll")
    @Given("^Migrate: Community Fund Donation is created as in\\s+\"([^\"]*)\"$")
    public void createCommunityFundDonation(String dataset)
    {
        // set fail subject and message
        setFailSubject("Create Community Fund Donation Report - Fail");
        setFailMessage("Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL());

        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
        setDataset("Dataset");
        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String dateFrom = getColumn(1);
            String dateTo = getColumn(2);
            String donationDetNo = getColumn(3);

            if (empty(dateFrom))
                continue;

            pageSteps.goToMenu(MenuID.GL_PY_COMMUNITY_FUND_DONATION);
            pageSteps.clickButton("Add");
            pageSteps.waitForAjax(1);

            int row = pageSteps.getRowsCount("No.");
            pageSteps.setTextAtTableCell("Date From", row, dateFrom);
            pageSteps.verifyResult("Verify Date From: ", pageSteps.getTextAtTableCell("Date From", row), dateFrom);

            pageSteps.setTextAtTableCell("Date To", row, dateTo);
            pageSteps.verifyResult("Verify Date To: ", pageSteps.getTextAtTableCell("Date To", row), dateTo);

            pageSteps.clickGreenArrow("No.", row);
            addDonationDetail(donationDetNo);
        }
        pageSteps.clickButton("Update");
        pageSteps.confirmNoOk("Yes");

        pageSteps.verifyResult("Verify update succesfully: ", pageSteps.checkTextExist("Error", false) == false);
        pageSteps.confirm("OK");

        String report = pageSteps.getTableReport();
        writeReport(report);
        sendEmailToPY("Create Community Fund Donation Report - Success",
                      "Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + "\n" + report, ElementID.REPORT_FILE);
        pageSteps.verifyFinalResult(report);
    }

    String donationCode;
    String donationGLAN;

    @Step("Add donation detail")
    public void addDonationDetail(String detailNo)
    {
        setDetailData("Donation");
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detNo = getColumn_Detail(1);
            if (detNo.equalsIgnoreCase(detailNo))
            {
                String donCode = getColumn_Detail(2);
                String donGLAN = getColumn_Detail(3);
                String totalWageFrom = getColumn_Detail(4);
                String totalWageTo = getColumn_Detail(5);
                String contriAmt = getColumn_Detail(6);
                String allocToMosqueFund = getColumn_Detail(7);
                String allocToMendakiFund = getColumn_Detail(8);

                if (notEmpty(donCode))
                {
                    donationCode = donCode;
                    donationGLAN = donGLAN;
                    int rowNo = pageSteps.getRowNumber("Donation Code", donationCode);
                    pageSteps.setTextAtTableCell("Donation GLAN", rowNo, donationGLAN);
                    pageSteps.verifyResult("Verify Donation GLAN: ", pageSteps.getTextAtTableCell("Donation GLAN", rowNo), donationGLAN);

                    pageSteps.clickGreenArrow("Donation Code", rowNo);
                }

                pageSteps.clickButton("Add", 2);
                pageSteps.setTextAtTableCell("Total Wage From", 1, totalWageFrom);
                pageSteps.verifyResult("Verify Total Wage From: ", pageSteps.getTextAtTableCell("Total Wage From", 1), totalWageFrom);

                pageSteps.setTextAtTableCell("Total Wage To", 1, totalWageTo);
                pageSteps.verifyResult("Verify Total Wage To: ", pageSteps.getTextAtTableCell("Total Wage To", 1), totalWageTo);

                pageSteps.setTextAtTableCell("Contribution Amt", 1, contriAmt);
                pageSteps.verifyResult("Verify Contribution Amt: ", pageSteps.getTextAtTableCell("Contribution Amt", 1), contriAmt);

                pageSteps.setTextAtTableCell(" Mosque Building Fund", 1, allocToMosqueFund);
                pageSteps.verifyResult("Verify Mosque Building Fund: ", pageSteps.getTextAtTableCell(" Mosque Building Fund", 1), allocToMosqueFund);

                pageSteps.setTextAtTableCell(" Mendaki Fund", 1, allocToMendakiFund);
                pageSteps.verifyResult("Verify Mendaki Fund: ", pageSteps.getTextAtTableCell(" Mendaki Fund", 1), allocToMendakiFund);
            }
        }
    }

//    @Given("^Verify if Community Fund Donation is created as in\\s+\"([^\"]*)\"$")
//    public void verifyCommunityFundDonation_Created(String dataset)
//    {
//        pageSteps.goToMenu(MenuID.GL_PY_COMMUNITY_FUND_DONATION);
//        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
//        setDataset("Dataset");
//        for (i = 1; i <= datasetObjArray.length; i++)
//        {
//            String dateFrom = getColumn(1);
//            String dateTo = getColumn(2);
//            String donationDetNo = getColumn(3);
//
//            if (empty(dateFrom))
//                continue;
//
//            pageSteps.clickButton("Add");
//            pageSteps.waitForAjax(1);
//
//            int rowCount = pageSteps.getRowsCount("No.");
//            for (int row = 1; row <= rowCount; i++)
//            {
//                String dateFrom_Exp = pageSteps.getTextAtTableCell("Date From", row);
//                String dateTo_Exp = pageSteps.getTextAtTableCell("Date To", row);
//
//                if (dateFrom.equalsIgnoreCase(dateFrom_Exp) && dateTo.equalsIgnoreCase(dateTo_Exp))
//                {
//                    pageSteps.verifyResult("Verify Date From: " + dateFrom + " = " + dateFrom_Exp, dateFrom.equalsIgnoreCase(dateFrom_Exp));
//                    pageSteps.verifyResult("Verify Date To: " + dateTo + " = " + dateTo_Exp, dateTo.equalsIgnoreCase(dateTo_Exp));
//                    pageSteps.clickGreenArrow("No.", row);
//                    verifyDonationDetail(donationDetNo);
//                    continue;
//                }
//            }
//            pageSteps.verifyFinalResult("Community Fund Donation has been setup");
//        }
//        pageSteps.clickButton("Update");
//        pageSteps.confirm("Yes");
//    }
//
//    @Step("Verify donation detail")
//    public void verifyDonationDetail(String detailNo)
//    {
//        setDetailData("Donation");
//        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
//        {
//            String detNo = getColumn_Detail(1);
//            if (detNo.equalsIgnoreCase(detailNo))
//            {
//                String donCode = getColumn_Detail(2);
//                String donGLAN = getColumn_Detail(3);
//                String totalWageFrom = getColumn_Detail(4);
//                String totalWageTo = getColumn_Detail(5);
//                String contriAmt = getColumn_Detail(6);
//                String allocToMosqueFund = getColumn_Detail(7);
//                String allocToMendakiFund = getColumn_Detail(8);
//
//                if (notEmpty(donCode))
//                {
//                    donationCode = donCode;
//                    donationGLAN = donGLAN;
//                    int rowNo = pageSteps.getRowNumber("Donation Code", donationCode);
//                    String donGLAN_Exp = pageSteps.getTextAtTableCell("Donation GLAN", rowNo);
//                    pageSteps.verifyResult("Verify Donation GLAN: " + donGLAN + " = " + donGLAN_Exp, donGLAN.equalsIgnoreCase(donGLAN_Exp));
//                    pageSteps.clickGreenArrow("Donation Code", rowNo);
//                }
//
//                int rowCount = pageSteps.getRowsCount("Total WWage From");
//                boolean foundRecords = false;
//                for (int row = 1; row <= rowCount; row++)
//                {
//                    String totalWageFrom_Exp = pageSteps.getTextAtTableCell("Total Wage From", row);
//                    String totalWageTo_Exp = pageSteps.getTextAtTableCell("Total Wage To", row);
//                    String contriAmt_Exp = pageSteps.getTextAtTableCell("Contribution Amt", row);
//                    String allocToMosqueFund_Exp = pageSteps.getTextAtTableCell(" Mosque Building Fund", row);
//                    String allocToMendakiFund_Exp = pageSteps.getTextAtTableCell(" Mendaki Fund", row);
//
//                    if (toDouble(totalWageFrom) == toDouble(totalWageFrom_Exp) && toDouble(totalWageTo) == toDouble(totalWageTo_Exp) && toDouble(
//                            contriAmt) == toDouble(contriAmt_Exp) && toDouble(allocToMosqueFund) == toDouble(allocToMosqueFund_Exp) && toDouble(
//                            allocToMendakiFund) == toDouble(allocToMendakiFund_Exp))
//                    {
//                        pageSteps.verifyResult(
//                                "Check data: " + totalWageFrom + " = " + totalWageFrom_Exp + "; " + totalWageTo + " = " + totalWageTo_Exp + "; " + contriAmt + " = " + contriAmt_Exp + "; " + allocToMosqueFund + " = " + allocToMosqueFund_Exp + "; " + allocToMendakiFund + " = " + allocToMendakiFund_Exp,
//                                true);
//                        foundRecords = true;
//                        continue;
//                    }
//                }
//                if (!foundRecords)
//                    pageSteps.verifyResult(
//                            "Check data: " + totalWageFrom + "; " + totalWageTo + "; " + contriAmt + "; " + allocToMosqueFund + "; " + allocToMendakiFund,
//                            false);
//            }
//        }
//        pageSteps.verifyFinalResult("CPF Contribution Rate Scheme has been created");
//    }
}
