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

public class P_05_HourlyRateScheme extends DatasetBase
{
    @Steps
    PageSteps pageSteps;

    @Title("Integration Test for Live Run Steps - Payroll")
    @Given("^Hourly Rate Scheme is created as in\\s+\"([^\"]*)\"$")
    public void testFlow(String dataset)
    {
        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
        setDataset("Dataset");
        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String schemeCode = getColumn(1);
            String desc = getColumn(2);
            String type = getColumn(3);
            String hourlyRate = getColumn(4);
            String minWorkingTime = getColumn(5);
            String startTime = getColumn(6);
            String endTime = getColumn(7);
            String maxNoofHourWKD = getColumn(8);
            String maxNoofHourSAT = getColumn(9);
            String maxNoofHourSUN = getColumn(10);
            String breakDetailNo = getColumn(11);
            String wkdTimeFrom = getColumn(12);
            String wkdTimeTo = getColumn(13);
            String satTimeFrom = getColumn(14);
            String satTimeTo = getColumn(15);
            String sunTimeFrom = getColumn(16);
            String sunTimeTo = getColumn(17);
            String phdTimeFrom = getColumn(18);
            String phdTimeTo = getColumn(19);

            if (empty(schemeCode))
                continue;

            // set fail subject and message
            setFailSubject("Create Hourly Rate Scheme Report - Fail");
            setFailMessage("Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + " / Code: " + schemeCode);

            if (type.equalsIgnoreCase("Time Range"))
                if (notEmpty(wkdTimeFrom)) // Normal Working Time = Y in module config
                {
                    executeUpdate("UPDATE MODULE_CONFIG SET PROPERTY_VALUE = 'Y' WHERE PROPERTY_NAME = 'enableNormalWorkingTime'");
                    pageSteps.goToMenu(MenuID.MT_MODULE_CONFIG);
                    pageSteps.goToTab("Payroll");
                    pageSteps.goToTab("Timesheet");
                    pageSteps.setRadioOption("Enable \"Normal Working Time\" at hourly rate scheme (time range)", "Y");
                }

            pageSteps.goToMenu(MenuID.GL_PY_HOURLY_RATE_SCHEME);
            pageSteps.clickButton("New");
            pageSteps.setText("Hourly Rate Scheme Code", schemeCode);
            pageSteps.verifyResult("Verify Hourly Rate Scheme Code: ", pageSteps.getTextValue("Hourly Rate Scheme Code"), schemeCode);

            pageSteps.setText("Description", desc);
            pageSteps.verifyResult("Verify Description: ", pageSteps.getTextValue("Description"), desc);

            pageSteps.setRadioOption("Type", type);
            pageSteps.verifyResult("Verify Type: ", pageSteps.isRadioOptionChecked("Type", type));

            pageSteps.setText("Hourly Rate", hourlyRate);
            pageSteps.verifyResult("Verify Hourly Rate: ", pageSteps.getTextValue("Hourly Rate"), hourlyRate);

            if (type.equalsIgnoreCase("Time Range"))
            {
                pageSteps.setText("Minimum Working Time (mins)", minWorkingTime);
                if (notEmpty(wkdTimeFrom)) // Normal Working Time = Y in module config
                {
                    pageSteps.setText("Week Day Time From", wkdTimeFrom);
                    pageSteps.verifyResult("Verify Week Day Time From: ", pageSteps.getTextValue("Week Day Time From"), wkdTimeFrom);

                    pageSteps.setText("Week Day Time To", wkdTimeTo);
                    pageSteps.verifyResult("Verify Week Day Time To: ", pageSteps.getTextValue("Week Day Time To"), wkdTimeTo);

                    pageSteps.setText("Saturday Time From", satTimeFrom);
                    pageSteps.verifyResult("Verify Saturday Time From: ", pageSteps.getTextValue("Saturday Time From"), satTimeFrom);

                    pageSteps.setText("Saturday Time To", satTimeTo);
                    pageSteps.verifyResult("Verify Saturday Time To: ", pageSteps.getTextValue("Saturday Time To"), satTimeTo);

                    pageSteps.setText("Sunday Time From", sunTimeFrom);
                    pageSteps.verifyResult("Verify Sunday Time From: ", pageSteps.getTextValue("Sunday Time From"), sunTimeFrom);

                    pageSteps.setText("Sunday Time To", sunTimeTo);
                    pageSteps.verifyResult("Verify Sunday Time To: ", pageSteps.getTextValue("Sunday Time To"), sunTimeTo);

                    pageSteps.setText("Public Holiday Time From", phdTimeFrom);
                    pageSteps.verifyResult("Verify Public Holiday Time From: ", pageSteps.getTextValue("Public Holiday Time From"), phdTimeFrom);

                    pageSteps.setText("Public Holiday Time To", phdTimeTo);
                    pageSteps.verifyResult("Verify Public Holiday Time To: ", pageSteps.getTextValue("Public Holiday Time To"), phdTimeTo);
                }
            }

            if (type.equalsIgnoreCase("Working Hours"))
            {
                pageSteps.setText("Start Time", startTime);
                pageSteps.verifyResult("Verify Start Time: ", pageSteps.getTextValue("Start Time"), startTime);

                pageSteps.setText("End Time", endTime);
                pageSteps.verifyResult("Verify End Time: ", pageSteps.getTextValue("End Time"), endTime);

                pageSteps.setTextAtTableCell("Max. No. of Hours paid if employee is on paid leave", "Normal Working Hours", 1, maxNoofHourWKD);
                pageSteps.verifyResult("Verify Normal Working Hours: ",
                                       pageSteps.getTextAtTableCell("Max. No. of Hours paid if employee is on paid leave", "Normal Working Hours", 1),
                                       maxNoofHourWKD);

                pageSteps.setTextAtTableCell("Max. No. of Hours paid if employee is on paid leave", "Normal Working Hours", 2, maxNoofHourSAT);
                pageSteps.verifyResult("Verify Max. No. of Hours paid if employee is on paid leave: ",
                                       pageSteps.getTextAtTableCell("Max. No. of Hours paid if employee is on paid leave", "Normal Working Hours", 2),
                                       maxNoofHourSAT);

                pageSteps.setTextAtTableCell("Max. No. of Hours paid if employee is on paid leave", "Normal Working Hours", 3, maxNoofHourSUN);
                pageSteps.verifyResult("Verify Max. No. of Hours paid if employee is on paid leave: ",
                                       pageSteps.getTextAtTableCell("Max. No. of Hours paid if employee is on paid leave", "Normal Working Hours", 3),
                                       maxNoofHourSUN);
            }

            setEatingBreak(breakDetailNo);

            if (type.equalsIgnoreCase("Time Range") || type.equalsIgnoreCase("Working Hours"))
                setHourlyRateDetail(breakDetailNo, type);
            else
                setOTRoundingDetails(breakDetailNo);

            pageSteps.clickButton("Update");
            pageSteps.confirmNoOk("Yes");

            pageSteps.verifyResult("Verify update succesfully: ", pageSteps.checkTextExist("Error", false) == false);
            pageSteps.confirm("OK");

            String report = pageSteps.getTableReport();
            writeReport(report);
            sendEmailToPY("Create Hourly Rate Scheme Report - Success",
                          "Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + " / Hourly Rate Scheme Code: " + schemeCode + "\n" + report,
                          ElementID.REPORT_FILE);
            pageSteps.verifyStepResult(report);
        }
        pageSteps.verifyFinalResult("Create Hourly Rate Scheme Report");
    }

    @Step("Set hourly rate detail for eating break")
    public void setEatingBreak(String breakDetailNo)
    {
        setDetailData("Break");
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detNo = getColumn_Detail(1);
            if (detNo.equalsIgnoreCase(breakDetailNo))
            {
                String periodType = getColumn_Detail(2);

                if (periodType.equalsIgnoreCase("Weekday") || periodType.equalsIgnoreCase("Saturday") || periodType.equalsIgnoreCase(
                        "Sunday") || periodType.equalsIgnoreCase("Public Holiday"))
                {
                    String timeFrom_Lunch = getColumn_Detail(3);
                    String timeTo_Lunch = getColumn_Detail(4);
                    String cutOff_Lunch = getColumn_Detail(5);
                    String rateFactor_Lunch = getColumn_Detail(6);

                    String timeFrom_Dinner = getColumn_Detail(7);
                    String timeTo_Dinner = getColumn_Detail(8);
                    String cutOff_Dinner = getColumn_Detail(9);
                    String rateFactor_Dinner = getColumn_Detail(10);

                    String timeFrom_Supper = getColumn_Detail(11);
                    String timeTo_Supper = getColumn_Detail(12);
                    String cutOff_Supper = getColumn_Detail(13);
                    String rateFactor_Supper = getColumn_Detail(14);

                    pageSteps.setTextAtTableCellLunchBreak("Hourly Rate Detail For Eating Break", periodType, timeFrom_Lunch, timeTo_Lunch,
                                                           cutOff_Lunch, rateFactor_Lunch);
                    pageSteps.setTextAtTableCellDinnerBreak("Hourly Rate Detail For Eating Break", periodType, timeFrom_Dinner, timeTo_Dinner,
                                                            cutOff_Dinner, rateFactor_Dinner);
                    pageSteps.setTextAtTableCellSupperBreak("Hourly Rate Detail For Eating Break", periodType, timeFrom_Supper, timeTo_Supper,
                                                            cutOff_Supper, rateFactor_Supper);
                }
            }
        }
    }

    String periodType;

    @Step("Set hourly rate detail for working")
    public void setHourlyRateDetail(String breakDetailNo, String type)
    {
        setDetailData("Hourly Detail");
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detNo = getColumn_Detail(1);
            if (detNo.equalsIgnoreCase(breakDetailNo))
            {
                String pType = getColumn_Detail(2);

                if (notEmpty(pType))
                    periodType = pType;

                String workHourFrom = getColumn_Detail(3);
                String workHourTo = getColumn_Detail(4);
                String rateFactor = getColumn_Detail(5);

                pageSteps.clickButton("Add");
                pageSteps.waitForAjax(1);
                pageSteps.setDropDownOptionAtTableCell("Hourly Rate Detail For Working", "Time Period Type", 1, periodType);

                if (type.equalsIgnoreCase("Time Range"))
                {
                    pageSteps.setTextAtTableCell("Hourly Rate Detail For Working", "Time From", 1, workHourFrom);
                    pageSteps.verifyResult("Verify Time From: ", pageSteps.getTextAtTableCell("Hourly Rate Detail For Working", "Time From", 1),
                                           workHourFrom);

                    pageSteps.setTextAtTableCell("Hourly Rate Detail For Working", "Time To", 1, workHourTo);
                    pageSteps.verifyResult("Verify Time To: ", pageSteps.getTextAtTableCell("Hourly Rate Detail For Working", "Time To", 1),
                                           workHourTo);

                    pageSteps.setTextAtTableCell("Hourly Rate Detail For Working", "Rate Factor", 1, rateFactor);
                    pageSteps.verifyResult("Verify Rate Factor: ", pageSteps.getTextAtTableCell("Hourly Rate Detail For Working", "Rate Factor", 1),
                                           rateFactor);
                }
                else if (type.equalsIgnoreCase("Working Hours"))
                {
                    pageSteps.setTextAtTableCell("Hourly Rate Detail For Working", "Working Hour From (>)", 1, workHourFrom);
                    pageSteps.verifyResult("Verify Working Hour From (>): ",
                                           pageSteps.getTextAtTableCell("Hourly Rate Detail For Working", "Working Hour From (>)", 1), workHourFrom);

                    pageSteps.setTextAtTableCell("Hourly Rate Detail For Working", "Working Hour To (<=)", 1, workHourTo);
                    pageSteps.verifyResult("Verify Working Hour To (<=): ",
                                           pageSteps.getTextAtTableCell("Hourly Rate Detail For Working", "Working Hour To (<=)", 1), workHourFrom);

                    pageSteps.setTextAtTableCell("Hourly Rate Detail For Working", "Rate Factor", 1, rateFactor);
                    pageSteps.verifyResult("Verify Time From: ", pageSteps.getTextAtTableCell("Hourly Rate Detail For Working", "Rate Factor", 1),
                                           workHourFrom);
                }
            }
        }
    }

    int    orderAdd = 1;
    String tableID  = "";
    String txtID    = "";

    @Step("Set ot rounding details")
    public void setOTRoundingDetails(String breakDetailNo)
    {
        setDetailData("Rounding Detail");
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detNo = getColumn_Detail(1);
            if (detNo.equalsIgnoreCase(breakDetailNo))
            {
                String pType = getColumn_Detail(2);
                if (notEmpty(pType))
                {
                    String normalWorkHour = getColumn_Detail(3);

                    periodType = pType;
                    pageSteps.goToTab(periodType);
                    pageSteps.waitForAjax(1);
                    switch (periodType)
                    {
                        case "Weekday":
                            orderAdd = 1;
                            tableID = "frmHourlyRateScheme:rounding_table_WKD";
                            txtID = "frmHourlyRateScheme:normal_hour_WKD";
                            break;
                        case "Saturday":
                            orderAdd = 2;
                            tableID = "frmHourlyRateScheme:rounding_table_SAT";
                            txtID = "frmHourlyRateScheme:normal_hour_SAT";
                            break;
                        case "Sunday":
                            orderAdd = 3;
                            tableID = "frmHourlyRateScheme:rounding_table_SUN";
                            txtID = "frmHourlyRateScheme:normal_hour_SUN";
                            break;
                        case "Public holiday":
                            orderAdd = 4;
                            tableID = "frmHourlyRateScheme:rounding_table_PHD";
                            txtID = "frmHourlyRateScheme:normal_hour_PHD";
                            break;
                    }
                    pageSteps.setTextAtXpathCSS("//input[@id='" + txtID + "']", normalWorkHour);
                }

                String otHoursFrom = getColumn_Detail(4);
                String otHoursTo = getColumn_Detail(5);
                String otHours = getColumn_Detail(6);

                pageSteps.clickButton("Add", orderAdd);
                pageSteps.waitForAjax(3);
                if (pageSteps.isEnable("//table[contains(@id,'" + tableID + "')]" + ElementID.NAVIGATE_NEXT_BUTTON, 0))
                {
                    pageSteps.clickAtXpathCSS("//table[contains(@id,'" + tableID + "')]" + ElementID.NAVIGATE_NEXT_BUTTON);
                    pageSteps.waitForAjax(1);
                }

//                int rowNo = pageSteps.getRowsCount("No. of OT Hours From (>=)");
//                pageSteps.setTextAtTableCell("No. of OT Hours From (>=)", rowNo, otHoursFrom);
//                pageSteps.setTextAtTableCell("No. of OT Hours To (<)", rowNo, otHoursTo);
//                pageSteps.setTextAtTableCell("No. of OT Hours", rowNo, otHours);

                int rowNo = pageSteps.getElementsCount("//tbody[contains(@id,'" + tableID + "')]/tr");
                pageSteps.setTextAtXpathCSS("//tbody[contains(@id,'" + tableID + "')]/tr[" + rowNo + "]/td[1]/input", otHoursFrom);
                pageSteps.setTextAtXpathCSS("//tbody[contains(@id,'" + tableID + "')]/tr[" + rowNo + "]/td[2]/input", otHoursTo);
                pageSteps.setTextAtXpathCSS("//tbody[contains(@id,'" + tableID + "')]/tr[" + rowNo + "]/td[3]/input", otHours);
            }
        }
    }
}
