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

public class P_01_5_Migrate_Currency extends DatasetBase
{
    @Steps
    PageSteps pageSteps;

    @Title("Integration Test for Live Run Steps - Payroll")
    @Given("^Migrate: Currency is created as in\\s+\"([^\"]*)\"$")
    public void createCurrency(String dataset)
    {
        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
        setDataset("Dataset");
        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String currency = getColumn(1);
            String desc = getColumn(2);
            String currencySymbol = getColumn(3);
            String dollarInWord = getColumn(4);
            String centInWord = getColumn(5);
            String minBankRate = getColumn(6);
            String maxBankRate = getColumn(7);
            String maxSpreadPercent = getColumn(8);
            String spreadPercentBase = getColumn(9);
            String creditLimitExchangeRate = getColumn(10);

            if (empty(currency))
                continue;

            // set fail subject and message
            setFailSubject("Create Currency Report - Fail");
            setFailMessage("Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + " / Code: " + currency);

            pageSteps.goToMenu(MenuID.GL_CURRENCY);
            pageSteps.clickButton("New");
            pageSteps.setText("Currency", currency);
            if (pageSteps.checkTextExist("already exists in database", false))
            {
                pageSteps.confirm("OK");
                pageSteps.clickButton("Close");
                continue;
            }
            pageSteps.verifyResult("Verify Currency Code: ", pageSteps.getTextValue("Currency"), currency);

            pageSteps.setText("Description", desc);
            pageSteps.verifyResult("Verify Description: ", pageSteps.getTextValue("Description"), desc);

            pageSteps.setText("Currency Symbol", currencySymbol);
            pageSteps.verifyResult("Verify Currency Symbol: ", pageSteps.getTextValue("Currency Symbol"), currencySymbol);

            pageSteps.setText("Dollar in word", dollarInWord);
            pageSteps.verifyResult("Verify Dollar in word: ", pageSteps.getTextValue("Dollar in word"), dollarInWord);

            pageSteps.setText("Cent in word", centInWord);
            pageSteps.verifyResult("Verify Cent in word: ", pageSteps.getTextValue("Cent in word"), centInWord);

            pageSteps.setText("Minimum Bank Rate", minBankRate);
            pageSteps.verifyResult("Verify Minimum Bank Rate: ", pageSteps.getTextValue("Minimum Bank Rate"), minBankRate);

            pageSteps.setText("Maximum Bank Rate", maxBankRate);
            pageSteps.verifyResult("Verify Maximum Bank Rate: ", pageSteps.getTextValue("Maximum Bank Rate"), maxBankRate);

            pageSteps.setText("Maximum Spread%", maxSpreadPercent);
            pageSteps.verifyResult("Verify Maximum Spread%: ", pageSteps.getTextValue("Maximum Spread%"), maxSpreadPercent);

            pageSteps.setRadioOption("Spread % Base", spreadPercentBase);
            pageSteps.verifyResult("Verify Spread % Base: ", pageSteps.isRadioOptionChecked("Spread % Base", spreadPercentBase));

            pageSteps.setText("Credit Limit Exchange Rate", creditLimitExchangeRate);
            pageSteps.verifyResult("Verify Credit Limit Exchange Rate: ", pageSteps.getTextValue("Credit Limit Exchange Rate"),
                                   creditLimitExchangeRate);

            pageSteps.clickButton("Update");
            pageSteps.confirmNoOk("Yes");

            pageSteps.verifyResult("Verify update succesfully: ", pageSteps.checkTextExist("Error", false) == false);
            pageSteps.confirm("OK");

            pageSteps.clickButton("Search");
            pageSteps.setTextPopupPanel("Search Currency", "Currency Code", currency);
            pageSteps.verifyResult("Currency code records found: ", pageSteps.getRowsCount("Currency Code") >= 1);

            String report = pageSteps.getTableReport();
            writeReport(report);
            sendEmailToPY("Create Currency Report - Success",
                          "Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + " / Currency Code: " + currency + "\n" + report,
                          ElementID.REPORT_FILE);
            pageSteps.verifyStepResult(report);
        }
        pageSteps.verifyFinalResult("Create Currency Report");
    }

//    @Given("^Verify if Currency is created as in\\s+\"([^\"]*)\"$")
//    public void verifyCurrency_Created(String dataset)
//    {
//        pageSteps.goToMenu(MenuID.GL_CURRENCY);
//        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
//        setDataset("Dataset");
//        for (i = 1; i <= datasetObjArray.length; i++)
//        {
//            String currency = getColumn(1);
//            String desc = getColumn(2);
//            String currencySymbol = getColumn(3);
//            String dollarInWord = getColumn(4);
//            String centInWord = getColumn(5);
//            String minBankRate = getColumn(6);
//            String maxBankRate = getColumn(7);
//            String maxSpreadPercent = getColumn(8);
//            String spreadPercentBase = getColumn(9);
//            String creditLimitExchangeRate = getColumn(10);
//
//            if (empty(currency))
//                continue;
//
//            pageSteps.clickButton("Search");
//            pageSteps.setTextPopupPanel("Search Currency", "Currency Code", currency);
//            pageSteps.verifyResult("Currency code records found: ", pageSteps.getRowsCount("Currency Code") >= 1);
//            pageSteps.selectFirstRow("Currency Code");
//
//            String desc_E = pageSteps.getTextValue("Description");
//            String currencySymbol_E = pageSteps.getTextValue("Currency Symbol");
//            String dollarInWord_E = pageSteps.getTextValue("Dollar in word");
//            String centInWord_E = pageSteps.getTextValue("Cent in word");
//            String minBankRate_E = pageSteps.getTextValue("Minimum Bank Rate");
//            String maxBankRate_E = pageSteps.getTextValue("Maximum Bank Rate");
//            String maxSpreadPercent_E = pageSteps.getTextValue("Maximum Spread%");
//            boolean spreadPercentBase_E = pageSteps.isRadioOptionChecked("Spread % Base", spreadPercentBase);
//            String creditLimitExchangeRate_E = pageSteps.getTextValue("Credit Limit Exchange Rate");
//
//            pageSteps.verifyResult("Check Description: " + desc + " = " + desc_E, desc.equalsIgnoreCase(desc_E));
//            pageSteps.verifyResult("Check Currency Symbol: " + currencySymbol + " = " + currencySymbol_E,
//                                   currencySymbol.equalsIgnoreCase(currencySymbol_E));
//            pageSteps.verifyResult("Check Dollar in Word: " + dollarInWord + " = " + dollarInWord_E, dollarInWord.equalsIgnoreCase(dollarInWord_E));
//            pageSteps.verifyResult("Check Cent in Word: " + centInWord + " = " + centInWord_E, centInWord.equalsIgnoreCase(centInWord_E));
//
//            pageSteps.verifyResult("Check Minimum Bank Rate: " + minBankRate + " = " + minBankRate_E, minBankRate.equalsIgnoreCase(minBankRate_E));
//            pageSteps.verifyResult("Check Maximum Bank Rate: " + maxBankRate + " = " + maxBankRate_E, maxBankRate.equalsIgnoreCase(maxBankRate_E));
//            pageSteps.verifyResult("Check Maximum Spread%: " + maxSpreadPercent + " = " + maxSpreadPercent_E,
//                                   maxSpreadPercent.equalsIgnoreCase(maxSpreadPercent_E));
//            pageSteps.verifyResult("Check Spread % Base: " + spreadPercentBase + " = " + spreadPercentBase_E,
//                                   (spreadPercentBase.startsWith("Y") && spreadPercentBase_E) || spreadPercentBase.startsWith(
//                                           "N") && !spreadPercentBase_E);
//            pageSteps.verifyResult("Check Credit Limit Exchange Rate: " + creditLimitExchangeRate + " = " + creditLimitExchangeRate_E,
//                                   creditLimitExchangeRate.equalsIgnoreCase(creditLimitExchangeRate_E));
//        }
//        pageSteps.verifyFinalResult("Currency has been created");
//    }
}
