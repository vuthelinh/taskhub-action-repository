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

public class P_06_GlobalBasicWithOT extends DatasetBase
{
    @Steps
    PageSteps pageSteps;

    String calcOTBy = "";

    @Title("Integration Test for Live Run Steps - Payroll")
    @Given("^Global Basic with OT is created as in\\s+\"([^\"]*)\"$")
    public void testFlow(String dataset)
    {
        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + dataset;
        setDataset("Dataset");
        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String schemeCode = getColumn(1);
            String desc = getColumn(2);
            String type = getColumn(3);
            calcOTBy = type;
            String breakDetailNo = getColumn(4);
            String breakType = getColumn(5);

            if (empty(schemeCode))
                continue;

            // set fail subject and message
            setFailSubject("Create Global Basic with OT Report - Fail");
            setFailMessage("Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + " / Code: " + schemeCode);

            pageSteps.goToMenu(MenuID.MT_MODULE_CONFIG);
            pageSteps.goToTab("Payroll");
            pageSteps.goToTab("Timesheet");
            if (breakType.equalsIgnoreCase("HM")) // Maintain eating break for Basic Salary & Basic OT employee = Hours and Minutes
            {
                executeUpdate("UPDATE MODULE_CONFIG SET PROPERTY_VALUE = 'HM' WHERE PROPERTY_NAME = 'eatingBreak'");
                pageSteps.setDropDownOption("Maintain eating break for Basic Salary & Basic OT employee", "Hours and Minutes");
            }
            else
            {
                executeUpdate("UPDATE MODULE_CONFIG SET PROPERTY_VALUE = 'TR' WHERE PROPERTY_NAME = 'eatingBreak'");
                pageSteps.setDropDownOption("Maintain eating break for Basic Salary & Basic OT employee", "Time Range");
            }
            if (type.contains("Fixed Rate"))
            {
                executeUpdate("UPDATE MODULE_CONFIG SET PROPERTY_VALUE = 'Y' WHERE PROPERTY_NAME = 'enableReadingFromDiffRateIfExceedTiming'");
                pageSteps.setRadioOption("Enable reading from different rate if exceed a certain timing (Basic OT - Fixed Rate Per Hour)", "Y");
            }
            if (type.contains("Hourly"))
            {
                executeUpdate("UPDATE MODULE_CONFIG SET PROPERTY_VALUE = 'Y' WHERE PROPERTY_NAME = 'enableOTRoundingColumn'");
                pageSteps.setRadioOption("Enable \"OT Hours Rounding\" column (Basic with OT scheme)", "Y");
            }

            pageSteps.goToMenu(MenuID.GL_PY_GLOBAL_BASIC_OT_SCHEME);
            pageSteps.clickButton("New");
            pageSteps.setText("Basic with OT Scheme Code", schemeCode);
            pageSteps.setText("Basic with OT Scheme Description", desc);
            pageSteps.setRadioOption("Calculate OT By", type);

            setEatingBreak(breakDetailNo);
            setOTSalaryDetail(schemeCode);

            pageSteps.clickButton("Update");
            pageSteps.confirmNoOk("Yes");

            pageSteps.verifyResult("Verify update succesfully: ", pageSteps.checkTextExist("Error", false) == false);
            pageSteps.confirm("OK");

            String report = pageSteps.getTableReport();
            writeReport(report);
            sendEmailToPY("Create Global Basic with OT Report - Success",
                          "Date: " + DateTimeUtil.getTimeToday() + " / URL: " + pageSteps.getBaseURL() + " / Global Basic with OT Scheme Code: " + schemeCode + "\n" + report,
                          ElementID.REPORT_FILE);
            pageSteps.verifyStepResult(report);
        }
        pageSteps.verifyFinalResult("Create Global Basic with OT Report");
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

                    pageSteps.setTextAtTableCellLunchBreak("Eating Break", periodType, timeFrom_Lunch, timeTo_Lunch, cutOff_Lunch, rateFactor_Lunch);
                    pageSteps.setTextAtTableCellDinnerBreak("Eating Break", periodType, timeFrom_Dinner, timeTo_Dinner, cutOff_Dinner,
                                                            rateFactor_Dinner);
                    pageSteps.setTextAtTableCellSupperBreak("Eating Break", periodType, timeFrom_Supper, timeTo_Supper, cutOff_Supper,
                                                            rateFactor_Supper);
                }
            }
        }
    }

    @Step("Set OT salary detail")
    public void setOTSalaryDetail(String schemeCode)
    {
        setDetailData("OT Salary Detail");
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String detNo = getColumn_Detail(1);
            if (detNo.equalsIgnoreCase(schemeCode))
            {
                String salRangeFrom = getColumn_Detail(2);
                String salRangeTo = getColumn_Detail(3);

                pageSteps.clickButton("Add", 1);
                pageSteps.waitForAjax(3);
                int rowNo = pageSteps.getRowsCount("Salary Range From(>)");
                pageSteps.setTextAtTableCell("OT Salary Detail", "Salary Range From(>)", rowNo, salRangeFrom);
                pageSteps.setTextAtTableCell("OT Salary Detail", "Salary Range To(<=)", rowNo, salRangeTo);
                pageSteps.clickGreenArrow("Salary Range From(>)", rowNo);
                setOTTimeDetail(schemeCode);
            }
        }
    }

    @Step("Set OT time period detail")
    public void setOTTimeDetail(String schemeCode)
    {
        String tableName = "";
        if (pageSteps.checkTextExist("OT Salary Detail", true))
            tableName = "OT Salary Detail";
        else if (pageSteps.checkTextExist("OT Time Period Detail", true))
            tableName = "OT Time Period Detail";

        setDetailData_Child("OT Time Detail");
        for (i_child = 1; i_child <= detailObjArray_Child.length; i_child++)
        {
            String detNo = getColumn_Child(1);
            if (detNo.equalsIgnoreCase(schemeCode))
            {
                String timePeriodType = getColumn_Child(2);
                String type = getColumn_Child(3);
                String normalWH_AMFrom = getColumn_Child(4);
                String normalWH_AMTo = getColumn_Child(5);
                String normalWH_PMFrom = getColumn_Child(6);
                String normalWH_PMTo = getColumn_Child(7);
                String otStartsFrom = getColumn_Child(8);
                String thisDay = getColumn_Child(9);
                String calcWHFrom = getColumn_Child(10);
                String otStartsAfterHours = getColumn_Child(11);
                String otFormula = getColumn_Child(12);
                String otHourRoundingDetailNo = getColumn_Child(13);
                String otRateDetailNo = getColumn_Child(14);
                String detailNoForExceedingCriteria = getColumn_Child(15);

                pageSteps.clickButton("Add", 2);
                pageSteps.waitForAjax(3);
                int rowNo = pageSteps.getRowsCount("Normal Working Hours (AM)");
                pageSteps.setDropDownOptionAtTableCell(tableName, "Time Period Type", rowNo, timePeriodType);
                pageSteps.setDropDownOptionAtTableCell(tableName, "Type", rowNo, type);
                pageSteps.setTextAtTableCell(tableName, "Normal Working Hours (AM)", rowNo, normalWH_AMFrom, 1);
                pageSteps.setTextAtTableCell(tableName, "Normal Working Hours (AM)", rowNo, normalWH_AMTo, 2);
                pageSteps.setTextAtTableCell(tableName, "Normal Working Hours (PM)", rowNo, normalWH_PMFrom, 1);
                pageSteps.setTextAtTableCell(tableName, "Normal Working Hours (PM)", rowNo, normalWH_PMTo, 2);
                pageSteps.setDropDownOptionAtTableCell(tableName, "OT Starts From", rowNo, thisDay);
                pageSteps.setTextAtTableCell(tableName, "OT Starts From", rowNo, otStartsFrom);
                pageSteps.setTextAtTableCell(tableName, "Calculate Working Hours From", rowNo, calcWHFrom);
                pageSteps.setTextAtTableCell(tableName, "OT Starts", rowNo, otStartsAfterHours);
                if ((type.equalsIgnoreCase("Working Hours") || type.equalsIgnoreCase("Flexible Working Hours")) && notEmpty(otHourRoundingDetailNo))
                {
                    pageSteps.clickInfoAtTableCell(tableName, "OT Hours Rounding", rowNo);
                    if (notEmpty(otHourRoundingDetailNo))
                        setOTRounding(otHourRoundingDetailNo);
                }
                if (notEmpty(detailNoForExceedingCriteria))
                    setGroupOfTimePeriod(otRateDetailNo, detailNoForExceedingCriteria);
                if (notEmpty(otRateDetailNo))
                {
                    if (!calcOTBy.contains("Fixed Rate")) // not for fixed rate
                    {
                        pageSteps.clickGreenArrow("Normal Working Hours (AM)", rowNo);
                        pageSteps.waitForAjax(1);
                        if (pageSteps.checkTextExist("OT Formula", true))
                        {
                            pageSteps.setRadioOption(otFormula);
                        }
                        setOTRateDetail(otRateDetailNo);
                    }
                }
            }
        }
    }

    private void setGroupOfTimePeriod(String rate1, String rate2)
    {
        pageSteps.goToTab("Grouping Of Time Period");
        setDetailData_Grandchild("OT Rate Detail");

        // add Rate 1
        pageSteps.clickButton("Add", 2);
        pageSteps.waitForAjax(1);
        pageSteps.clickGreenArrow("Details used for calculation if exceed criteria", 1);
        for (i_grandchild = 1; i_grandchild <= detailObjArray_Grandchild.length; i_grandchild++)
        {
            String detNo = getColumn_Grandchild(1);
            if (detNo.equalsIgnoreCase(rate1))
            {
                String otHoursFrom = getColumn_Grandchild(2);
                String otHoursTo = getColumn_Grandchild(3);
                String rateFactor = getColumn_Grandchild(4);

                pageSteps.clickButton("Add", 3);
                pageSteps.waitForAjax(1);

                int rowNo = pageSteps.getRowsCount("No. of Hours From");
                pageSteps.setTextAtTableCell("No. of Hours From", rowNo, otHoursFrom);
                pageSteps.setTextAtTableCell("No. of Hours To", rowNo, otHoursTo);
                pageSteps.setTextAtTableCell("Rate Per Hour", rowNo, rateFactor);
            }
        }

        // add Rate 2
        pageSteps.clickButton("Add", 2);
        pageSteps.waitForAjax(1);
        pageSteps.clickGreenArrow("Details used for calculation if exceed criteria", 2);
        for (i_grandchild = 1; i_grandchild <= detailObjArray_Grandchild.length; i_grandchild++)
        {
            String detNo = getColumn_Grandchild(1);
            if (detNo.equalsIgnoreCase(rate2))
            {
                String otHoursFrom = getColumn_Grandchild(2);
                String otHoursTo = getColumn_Grandchild(3);
                String rateFactor = getColumn_Grandchild(4);

                pageSteps.clickButton("Add", 3);
                pageSteps.waitForAjax(1);

                int rowNo = pageSteps.getRowsCount("No. of Hours From");
                pageSteps.setTextAtTableCell("No. of Hours From", rowNo, otHoursFrom);
                pageSteps.setTextAtTableCell("No. of Hours To", rowNo, otHoursTo);
                pageSteps.setTextAtTableCell("Rate Per Hour", rowNo, rateFactor);
            }
        }
        pageSteps.setTextAtTableCell("Details used for calculation if exceed criteria", 1, "Details For Rate 2");
        pageSteps.goToTab("Normal Working Hours");
    }

    @Step("Set OT hours rounding")
    public void setOTRounding(String otHourRoundingDetailNo)
    {
        setDetailData_Grandchild("OT Rounding Detail");
        for (i_grandchild = 1; i_grandchild <= detailObjArray_Grandchild.length; i_grandchild++)
        {
            String detNo = getColumn_Grandchild(1);
            if (detNo.equalsIgnoreCase(otHourRoundingDetailNo))
            {
                String noOTHoursFrom = getColumn_Grandchild(2);
                String noOTHoursTo = getColumn_Grandchild(3);
                String noOTHours = getColumn_Grandchild(4);

                pageSteps.clickButton("Add", 999);
                pageSteps.waitForAjax(3);
                int rowNo = pageSteps.getRowsCount("No. of OT Hours From (>=)");
//                pageSteps.setTextAtTableCell("No. of OT Hours From (>=)", rowNo, noOTHoursFrom);
//                pageSteps.setTextAtTableCell("No. of OT Hours To (<)", rowNo, noOTHoursTo);
//                pageSteps.setTextAtTableCell("No. of OT Hours", rowNo, noOTHours);
                pageSteps.setTextAtXpathCSS("//tbody[contains(@id,'tblBasicHoursDetail:tb')]/tr[" + rowNo + "]/td[1]/input", noOTHoursFrom);
                pageSteps.setTextAtXpathCSS("//tbody[contains(@id,'tblBasicHoursDetail:tb')]/tr[" + rowNo + "]/td[2]/input", noOTHoursTo);
                pageSteps.setTextAtXpathCSS("//tbody[contains(@id,'tblBasicHoursDetail:tb')]/tr[" + rowNo + "]/td[3]/input", noOTHours);
            }
        }
        pageSteps.clickButton("Done");
    }

    @Step("Set OT rate detail by Time Range")
    public void setOTRateDetail(String breakDetailNo)
    {
        boolean isTimeRange = false;
        setDetailData_Grandchild("OT Rate Detail");
        if (pageSteps.checkTextExist("OT Rate Detail by Time Range", true))
            isTimeRange = true;
        else if (pageSteps.checkTextExist("OT Rate Detail Working Hours", true))
            isTimeRange = false;
        for (i_grandchild = 1; i_grandchild <= detailObjArray_Grandchild.length; i_grandchild++)
        {
            String detNo = getColumn_Grandchild(1);
            if (detNo.equalsIgnoreCase(breakDetailNo))
            {
                String otHoursFrom = getColumn_Grandchild(2);
                String otHoursTo = getColumn_Grandchild(3);
                String rateFactor = getColumn_Grandchild(4);

                pageSteps.clickButton("Add", 3);
                pageSteps.waitForAjax(3);

                if (isTimeRange)
                {
                    int rowNo = pageSteps.getRowsCount("OT Hours From(>)");
                    pageSteps.setTextAtTableCell("OT Rate Detail by Time Range", "OT Hours From(>)", rowNo, otHoursFrom);
                    pageSteps.setTextAtTableCell("OT Rate Detail by Time Range", "OT Hours To(<=)", rowNo, otHoursTo);
                    pageSteps.setTextAtTableCell("OT Rate Detail by Time Range", "Rate Factor", rowNo, rateFactor);
                }
                else
                {
                    int rowNo = pageSteps.getRowsCount("No. of Hours From");
                    pageSteps.setTextAtTableCell("OT Rate Detail Working Hours", "No. of Hours From", rowNo, otHoursFrom);
                    pageSteps.setTextAtTableCell("OT Rate Detail Working Hours", "No. of Hours To", rowNo, otHoursTo);
                    pageSteps.setTextAtTableCell("OT Rate Detail Working Hours", "Rate Factor", rowNo, rateFactor);
                }
            }
        }
    }
}
