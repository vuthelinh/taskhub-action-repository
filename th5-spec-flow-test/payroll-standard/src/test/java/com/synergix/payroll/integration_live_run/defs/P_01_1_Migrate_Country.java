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

public class P_01_1_Migrate_Country extends DatasetBase
{
    @Steps
    PageSteps pageSteps;

    @Title("Integration Test for Live Run Steps - Payroll")
    @Given("^Migrate: Country is created as in\\s+\"([^\"]*)\"$")
    public void createCountryCode(String dataset)
    {
        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
        setDataset("Dataset");
        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String countryCode = getColumn(1);
            String countryDesc = getColumn(2);
            String nationalDesc = getColumn(3);
            String empIncomeCode = getColumn(4);
            String phdCode = getColumn(5);

            if (empty(countryCode))
                continue;

            // set fail subject and message
            setFailSubject("Create Country Report - Fail");
            setFailMessage("Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + " / Code: " + countryCode);

            pageSteps.goToMenu(MenuID.GL_COUNTRY);
            pageSteps.clickButton("New");

            pageSteps.setText("Country Code:", countryCode);
            pageSteps.verifyResult("Verify Country Code: ", pageSteps.getTextValue("Country Code:"), countryCode);

            pageSteps.setText("Country Description:", countryDesc);
            pageSteps.verifyResult("Verify Country Description: ", pageSteps.getTextValue("Country Description:"), countryDesc);

            pageSteps.setText("Nationality Description:", nationalDesc);
            pageSteps.verifyResult("Verify Nationality Description: ",
                                   pageSteps.getTextValue("Nationality Description:").equalsIgnoreCase(nationalDesc));

            pageSteps.setText("Employment Income File Country/Nationality Code:", empIncomeCode);
            pageSteps.verifyResult("Verify Employment Income File Country/Nationality Code: ",
                                   pageSteps.getTextValue("Employment Income File Country/Nationality Code:"), empIncomeCode);

            // Publid Holiday
            addPHD(phdCode);

            // TAB - Company Declared Holiday
            addCompPHD(phdCode);

            pageSteps.clickButton("Update");
            pageSteps.confirmNoOk("Yes");

            pageSteps.verifyResult("Verify update succesfully: ", pageSteps.checkTextExist("Error", false) == false);
            pageSteps.confirm("OK");

            pageSteps.clickButton("Search");
            pageSteps.setTextPopupPanel("Search Country (Global)", "Country Code", countryCode);
            pageSteps.verifyResult("Country code records found: ", pageSteps.getRowsCount("Country Code") >= 1);

            String report = pageSteps.getTableReport();
            writeReport(report);
            sendEmailToPY("Create Country Report - Success",
                          "Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + " / Country Code: " + countryCode + "\n" + report,
                          ElementID.REPORT_FILE);
            pageSteps.verifyStepResult(report);
        }
        pageSteps.verifyFinalResult("Create Country Report");
    }

    @Step("Add public holiday")
    public void addPHD(String phdCode)
    {
        pageSteps.goToTab("Local Info");
        setDetailData("PHD");
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String pCode = getColumn_Detail(1);
            if (pCode.equalsIgnoreCase(phdCode))
            {
                String date = getColumn_Detail(2);
                String desc = getColumn_Detail(3);

                pageSteps.clickButton("Add");
                pageSteps.waitForAjax(1);
                int rowNo = pageSteps.getRowsCount("Date");
                pageSteps.setTextAtTableCell("Date", rowNo, date);
                pageSteps.setTextAtTableCell("Description", rowNo, desc);

                pageSteps.verifyResult("Verify Date: ", pageSteps.getTextAtTableCell("Date", rowNo), date);
                pageSteps.verifyResult("Verify Description: ", pageSteps.getTextAtTableCell("Description", rowNo), desc);
            }
        }
    }

    @Step("Add company declared public holiday")
    public void addCompPHD(String phdCode)
    {
        pageSteps.goToTab("Company Declared Holiday");
        setDetailData("PHD_Company");
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String pCode = getColumn_Detail(1);
            if (pCode.equalsIgnoreCase(phdCode))
            {
                String date = getColumn_Detail(2);
                String desc = getColumn_Detail(3);
                String duration = getColumn_Detail(4);
                String religion = getColumn_Detail(5);

                pageSteps.clickButton("Add");
                pageSteps.setTextAtTableCell("Date", 1, date);
                pageSteps.setTextAtTableCell("Description", 1, desc);
                pageSteps.setDropDownOptionAtTableCell("Duration", 1, duration);

                pageSteps.verifyResult("Verify Date: ", pageSteps.getTextAtTableCell("Date", 1), date);
                pageSteps.verifyResult("Verify Description: ", pageSteps.getTextAtTableCell("Description", 1), desc);
                pageSteps.verifyResult("Verify Duration: ", pageSteps.getTextAtTableCell("Duration", 1), duration);

                pageSteps.clickGreenArrow("Date", 1);

                if (religion.equalsIgnoreCase("All"))
                {
                    pageSteps.setCheckboxOptionAtTableCell_All("Select", "Y");
                    pageSteps.verifyResult("Verify All Regilion: ", pageSteps.isCheckboxOptionAtTableCell_AllChecked("Select"));

                }
                else
                {
                    int row = pageSteps.getRowNumber("Religion", religion);
                    pageSteps.setCheckBoxAtTableCell("Select", row, "Y");
                    pageSteps.verifyResult("Verify Regilion: ", pageSteps.isCheckBoxAtTableCellChecked("Select", row, "Y"));
                }
            }
        }
    }

//    @Given("^Verify if Country is created as in\\s+\"([^\"]*)\"$")
//    public void verifyCountry_Created(String dataset)
//    {
//        pageSteps.goToMenu(MenuID.GL_COUNTRY);
//        pageSteps.clickButton("Search");
//        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
//        setDataset("Dataset");
//        for (i = 1; i <= datasetObjArray.length; i++)
//        {
//            String countryCode = getColumn(1);
//
//            if (empty(countryCode))
//                continue;
//
//            pageSteps.setTextPopupPanel("Search Country (Global)", "Country Code", countryCode);
//            pageSteps.verifyResult("Country code records found: ", pageSteps.getRowsCount("Country Code") >= 1);
//        }
//        pageSteps.verifyFinalResult("Country code has been created");
//    }
}
