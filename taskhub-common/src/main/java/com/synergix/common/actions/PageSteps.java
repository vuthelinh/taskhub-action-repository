package com.synergix.common.actions;

import com.synergix.utilities.ExcelUtils;
import com.synergix.utilities.SessionData;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.apache.poi.hssf.util.HSSFColor;
import org.assertj.core.api.SoftAssertions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by synergix61 on 24/2/2016.
 */
public class PageSteps extends ScenarioSteps
{
    PageActions action;

    public void init()
    {
        if (action.getActionDriver() == null)
            action.setActionDriver(getDriver());
    }

    public       Map<String, Boolean> verifyList = new HashMap<String, Boolean>();
    public       List<String>         verifyStep = new ArrayList<String>();
    public final String               reportKey  = "FINAL_RESULT_TBL";

    @Step("Verify - {0}: {1} = {2}")
    public boolean verifyResult(String message, double actual, double expected)
    {
        verifyStep = new ArrayList<String>();
        boolean check = actual == expected;
        verifyList.put(message, check);

        // datatable report
        verifyStep.add(message);
        verifyStep.add(actual + "");
        verifyStep.add(expected + "");
        verifyStep.add(check ? "Passed" : "Failed");
        SessionData.addRowToTbDataReport(reportKey, verifyStep);

        return check;
    }

    @Step("Verify - {0}: {1} = {2}")
    public boolean verifyResult(String message, String actual, String expected)
    {
        verifyStep = new ArrayList<String>();
        boolean check = true;
        if (!expected.equals(""))
            if (!actual.equals(""))
            {
                try
                {
                    double expected_D = Double.parseDouble(expected.replace(",", ""));
                    double actual_D = Double.parseDouble(actual.replace(",", ""));

                    check = actual_D == expected_D;
                    verifyList.put(message, check);

                    verifyStep.add(message);
                    verifyStep.add(actual);
                    verifyStep.add(expected);
                    verifyStep.add(check ? "Passed" : "Failed");
                    SessionData.addRowToTbDataReport(reportKey, verifyStep);
                    verifyStep.clear();
                    return check;
                } catch (Exception ex)
                {
                }

                check = actual.equalsIgnoreCase(expected);
                verifyList.put(message, check);

                // datatable report
                verifyStep.add(message);
                verifyStep.add(actual);
                verifyStep.add(expected);
                verifyStep.add(check ? "Passed" : "Failed");
                SessionData.addRowToTbDataReport(reportKey, verifyStep);
            }
        return check;
    }

    @Step("Verify - {0}: {1}")
    public boolean verifyResult(String message, boolean result)
    {
        verifyStep = new ArrayList<String>();
        verifyList.put(message, result);

        // datatable report
        verifyStep.add(message);
        verifyStep.add("");
        verifyStep.add("");
        verifyStep.add(result ? "Passed" : "Failed");
        SessionData.addRowToTbDataReport(reportKey, verifyStep);

        return result;
    }

    @Step("Verify final result: {0}")
    public void verifyFinalResult(String message)
    {
        try
        {
            SoftAssertions softly = new SoftAssertions();
            if (verifyList.size() > 0)
            {
                for (Map.Entry<String, Boolean> result : verifyList.entrySet())
                {
                    if (!result.getValue())
                    {
                        softly.assertThat(true).as(result.getKey()).isFalse();
                    }
                    else
                    {
                        softly.assertThat(true).as(result.getKey()).isTrue();
                    }
                }
                // softly.assertAll(); // will stop the browser if there are failed cases
            }
        } catch (Exception e)
        {

        } finally
        {
            verifyList.clear();
        }
    }

    @Step("Verify final result: {0}")
    public void verifyFinalResult(String tableReport, int failCasesNo)
    {
        try
        {
            SoftAssertions softly = new SoftAssertions();
            if (failCasesNo > 0)
                softly.assertThat(true).as("").isFalse();
            else
                softly.assertThat(true).as("").isTrue();
            softly.assertAll();
        } catch (Exception e)
        {
        }
    }

    @Step("Verify step result: {0}")
    public void verifyStepResult(String message)
    {
        System.out.print(message);
    }

    // for verify steps in feature
    List<Boolean> verifyList_F = new ArrayList<Boolean>();

    @Step("Verify - {0}: {1}")
    public void verifyResult_Feature(String message, boolean result)
    {
        if (result)
            verifyList_F.add(true);
        else
            verifyList_F.add(false);
    }

    @Step("Verify final result: {0}")
    public void verifyFinalResult_Feature(String message)
    {
        init();
        if (verifyList.size() > 0)
        {
            for (boolean check : verifyList_F)
            {
                if (!check)
                {
                    action.customAssert(message);
                    break;
                }
            }
        }
        verifyList.clear();
    }

    public String getTableReport()
    {
        String s = "";
        try
        {
            s = SessionData.generateTbDataReport(reportKey);
            SessionData.clearTbDataReport(reportKey);
        } catch (Exception e)
        {
            return "";
        }
        return s;
    }

    public void writeTableReportToExcel(String reportKey, String filePath, String sheetName)
    {
        ExcelUtils.createExcelFile(filePath, sheetName);
        ExcelUtils.writeToExel(filePath, sheetName, "Verify Point", 0, 0);
        ExcelUtils.writeToExel(filePath, sheetName, "Actual Result", 0, 1);
        ExcelUtils.writeToExel(filePath, sheetName, "Expected Result", 0, 2);
        ExcelUtils.writeToExel(filePath, sheetName, "Result", 0, 3);

        List<List<String>> tbReport = Serenity.sessionVariableCalled(reportKey);
        int failedCases = 0;
        for (List<String> values : tbReport)
        {
            int rowIndex = ExcelUtils.getLastRowNum(filePath, sheetName);
            int colIndex = 0;
            for (String value : values)
            {
                ExcelUtils.writeToExel(filePath, sheetName, value, rowIndex, colIndex);
                if (value.equals("Failed"))
                {
                    ExcelUtils.setCellColor(filePath, sheetName, rowIndex, colIndex, HSSFColor.RED.index);
                    failedCases += 1;
                }
                colIndex += 1;
            }
        }
        int rowIndex = ExcelUtils.getLastRowNum(filePath, sheetName);
        ExcelUtils.writeToExel(filePath, sheetName, "Failed Points", rowIndex, 2);
        ExcelUtils.writeToExel(filePath, sheetName, failedCases + "", rowIndex, 3);
    }

    ////////////////////////////// Action Methods ///////////////////////////////////
    public void switchToTH5Frame()
    {
        init();
        action.switchToFrameID("th5frame");
    }

    public void switchToParentFrame()
    {
        init();
        action.switchToParentFrame();
    }

    @Step("Go to menu: {0}")
    public void goToMenu(String MenuID)
    {
        init();
        action.goToMenu(MenuID);
    }

    @Step("Click {0} button")
    public void clickButton(String buttonName)
    {
        init();
        action.clickButton(buttonName);
    }

    @Step("Click {0} button")
    public void clickButton(String buttonName, int order)
    {
        init();
        action.clickButton(buttonName, order);
    }

    @Step("Go to tab: {0}")
    public void goToTab(String tabName)
    {
        init();
        action.goToTab(tabName);
    }

    @Step("Go to tab: {0}")
    public void goToTab(String tabName, int order)
    {
        init();
        action.goToTab(tabName, order);
    }

    @Step("Input value {0}: {1}")
    public void setText(String labelText, String value)
    {
        init();
        action.setText(labelText, value);
//        verifyResult(labelText, action.getTextValue(labelText), value);
    }

    @Step("Input value {0}: {1}")
    public void setText(String labelText, String value, int order)
    {
        init();
        action.setText(labelText, value, order);
//        verifyResult(labelText, action.getTextValue(labelText, order), value);
    }

    @Step("Choose {0}: {1}")
    public void setDropDownOption(String labelText, String value)
    {
        init();
        action.setDropDownOption(labelText, value, false);
//        verifyResult(labelText, action.getDropDownOptionValue(labelText), value);
    }

    @Step("Choose {0}: {1}")
    public void setDropDownOption(String labelText, String value, boolean exactMatch)
    {
        init();
        action.setDropDownOption(labelText, value, exactMatch);
    }

    public String getDropDownOptionValue(String labelText)
    {
        init();
        return action.getDropDownOptionValue(labelText);
    }

    @Step("Choose option {0}")
    public void setRadioOption(String value)
    {
        init();
        action.setRadioOption(value);
//        verifyResult(value, action.isRadioOptionChecked(value));
    }

    @Step("Choose option {0}: {1}")
    public void setRadioOption(String labelText, String value)
    {
        init();
        action.setRadioOption(labelText, value);
//        if (value.equals(""))
//            verifyResult(value, true);
//        else
//            verifyResult(value, action.isRadioOptionChecked(labelText, value));
    }

    @Step("Choose option {0}: {1}")
    public void setRadioOption(String labelText, String value, int order)
    {
        init();
        action.setRadioOption(labelText, value, order);
//        if (value.equals(""))
//            verifyResult(value, true);
//        else
//            verifyResult(value, action.isRadioOptionChecked(labelText, value, order));
    }

    @Step("Input value {0}: {2} at row {1}")
    public void setTextAtTableCell(String columnName, int rowNumber, String value)
    {
        init();
        action.setTextAtTableCell(columnName, rowNumber, value);
//        verifyResult(columnName, action.getTextAtTableCell(columnName, rowNumber), value);
    }

    @Step("Choose value {0}: {2} at row {1}")
    public void setDropDownOptionAtTableCell(String columnName, int rowNumber, String optionValue)
    {
        init();
        action.setDropDownOptionAtTableCell(columnName, rowNumber, optionValue);
//        verifyResult(columnName, action.getDropDownOptionAtTableCell(columnName, rowNumber), optionValue);
    }

    @Step("Choose {1} = {3} at row {2} in table {0}")
    public void setDropDownOptionAtTableCell(String tableName, String columnName, int rowNumber, String optionValue)
    {
        init();
        action.setDropDownOptionAtTableCell(tableName, columnName, rowNumber, optionValue);
//        verifyResult(columnName, action.getDropDownOptionAtTableCell(tableName, columnName, rowNumber), optionValue);
    }

    @Step("Confirm {0}")
    public void confirm(String yesNoOk)
    {
        init();
        action.confirm(yesNoOk);
    }

    @Step("Click search button")
    public void clickSearchButton()
    {
        init();
        action.clickSearchButton();
    }

    @Step("Click search button for {0}")
    public void clickSearchButton(String labelText)
    {
        init();
        action.clickSearchButton(labelText);
    }

    @Step("Select first row of {0}")
    public void selectFirstRow(String columnName)
    {
        init();
        action.selectFirstRow(columnName);
        action.waitForAjax(1);
    }

    public void waitForAjax(long timeOut)
    {
        init();
        action.waitForProgressBar(timeOut);
    }

    @Step("Input {3} into row {2} of column {1} in tab {0}")
    public void setTextAtTableCellPRTimeSheet(String tabName, String columnName, int rowNumber, String value)
    {
        init();
        action.setTextAtTableCellPRTimeSheet(tabName, columnName, rowNumber, value);
//        verifyResult(columnName, action.getTextAtTableCellPRTimeSheet(tabName, columnName, rowNumber), value);
    }

    @Step("Choose {1} = {3} at row {2} in tab {0}")
    public void setDropDownOptionAtTableCellPRTimesheet(String tabName, String columnName, int rowNumber, String value)
    {
        init();
        action.setDropDownOptionAtTableCellPRTimesheet(tabName, columnName, rowNumber, value);
//        verifyResult(columnName, action.getDropDownOptionAtTableCellPRTimesheet(tabName, columnName, rowNumber), value);
    }

    public String getTextAtTableCellPRTimesheet(String tabName, String columnName, int rowNumber)
    {
        init();
        return action.getTextAtTableCellPRTimesheet(tabName, columnName, rowNumber);
    }

    @Step("Input Lunch Time From = {2}, Time To = {3}, Cutoff Time = {4}, Rate Factor = {5} into Period Type {1} of " + "table {0}")
    public void setTextAtTableCellLunchBreak(String tableName, String periodType, String timeFrom, String timeTo, String cutOffTime,
                                             String rateFactor)
    {
        init();
        action.setTextAtTableCellLunchBreak(tableName, periodType, timeFrom, timeTo, cutOffTime, rateFactor);
    }

    @Step("Input Dinner Time From = {2}, Time To = {3}, Cutoff Time = {4}, Rate Factor = {5} into Period Type {1} of table {0}")
    public void setTextAtTableCellDinnerBreak(String tableName, String periodType, String timeFrom, String timeTo, String cutOffTime,
                                              String rateFactor)
    {
        init();
        action.setTextAtTableCellDinnerBreak(tableName, periodType, timeFrom, timeTo, cutOffTime, rateFactor);
    }

    @Step("Input Supper Time From = {2}, Time To = {3}, Cutoff Time = {4}, Rate Factor = {5} into Period Type {1} of table {0}")
    public void setTextAtTableCellSupperBreak(String tableName, String periodType, String timeFrom, String timeTo, String cutOffTime,
                                              String rateFactor)
    {
        init();
        action.setTextAtTableCellSupperBreak(tableName, periodType, timeFrom, timeTo, cutOffTime, rateFactor);
    }

    @Step("Table {0} row {2}: Input value {3} into {1}")
    public void setTextAtTableCell(String tableName, String columnName, int rowNumber, String value)
    {
        init();
        action.setTextAtTableCell(tableName, columnName, rowNumber, value);
//        verifyResult(columnName, action.getTextAtTableCell(tableName, columnName, rowNumber), value);
    }

    @Step("Table {0} row {2}: Input value {3} into {1}")
    public void setTextAtTableCell(String tableName, String columnName, int rowNumber, String value, int order)
    {
        init();
        action.setTextAtTableCell(tableName, columnName, rowNumber, value, order);
//        verifyResult(columnName, action.getTextAtTableCell(tableName, columnName, rowNumber, order), value);
    }

    @Step("Row {2}: Input value {3} into {0}")
    public void setTextAtTableCell(String columnName, int colCount, int rowNumber, String value)
    {
        init();
        action.setTextAtTableCell(columnName, colCount, rowNumber, value);
//        verifyResult(columnName, action.getTextAtTableCell(columnName, colCount, rowNumber), value);
    }

    @Step("Set checkbox option = {2} in row {1} of column {0}")
    public void setCheckBoxAtTableCell(String columnName, int rowNumber, String checkboxValue)
    {
        init();
        action.setCheckBoxAtTableCell(columnName, rowNumber, checkboxValue);
//        if (checkboxValue.equals(""))
//            verifyResult(columnName, true);
//        else
//        {
//            boolean check = action.isCheckBoxAtTableCellChecked(columnName, rowNumber);
//            if ((check && checkboxValue.startsWith("Y")) || (!check && (checkboxValue.startsWith("N") || checkboxValue.equals(""))))
//                verifyResult(columnName, true);
//            else
//                verifyResult(columnName, false);
//        }
    }

    @Step("Choose all value in {0}: {1}")
    public void setCheckboxOptionAtTableCell_All(String columnName, String checkboxValue)
    {
        init();
        action.setCheckboxOptionAtTableCell_All(columnName, checkboxValue);
//        if (checkboxValue.equals(""))
//            verifyResult(columnName, true);
//        else
//        {
//            boolean check = action.isCheckboxOptionAtTableCell_AllChecked(columnName);
//            if ((check && checkboxValue.startsWith("Y")) || (!check && (checkboxValue.startsWith("N") || checkboxValue.equals(""))))
//                verifyResult(columnName, true);
//            else
//                verifyResult(columnName, false);
//        }
    }

    public boolean checkTextExist(String text, boolean exactMatch)
    {
        init();
        return action.checkTextExist(text, exactMatch);
    }

    public int getRowsCount(String tableColumnName)
    {
        init();
        return action.getRowsCount(tableColumnName);
    }

    public int getElementsCount(String xPathCSS)
    {
        init();
        return action.getElementsCount(xPathCSS);
    }

    public boolean isEnable(String xPathCSS, int timeOut)
    {
        init();
        return action.isEnable(xPathCSS, timeOut);
    }

    @Step("Click green arrow button under {0}, line {1}")
    public void clickGreenArrow(String columnName, int rowNumber)
    {
        init();
        action.clickGreenArrow(columnName, rowNumber);
    }

    @Step("Filter column {0} = {1}")
    public void setTableFilter(String columnName, String value)
    {
        init();
        action.setTableFilter(columnName, value);
    }

    public boolean isCheckboxChecked(String labelText)
    {
        init();
        return action.isCheckboxChecked(labelText);
    }

    @Step("Input value {1} into {0}")
    public void setTextArea(String labelText, String value)
    {
        init();
        action.setTextArea(labelText, value);
//        verifyResult(labelText, action.getTextArea(labelText), value);
    }

    public String getTextArea(String labelText)
    {
        init();
        return action.getTextArea(labelText);
//        verifyResult(labelText, action.getTextArea(labelText), value);
    }

    @Step("Set checkbox of {0} with option = {1}")
    public void setCheckbox(String labelText, String checkboxValue)
    {
        init();
        action.setCheckbox(labelText, checkboxValue);
//        if (checkboxValue.equals(""))
//            verifyResult(labelText, true);
//        else
//        {
//            boolean check = action.isCheckboxChecked(labelText);
//            if ((check && checkboxValue.startsWith("Y")) || (!check && (checkboxValue.startsWith("N") || checkboxValue.equals(""))))
//                verifyResult(labelText, true);
//            else
//                verifyResult(labelText, false);
//        }
    }

    @Step("Set checkbox of {0} with option = {1}")
    public void setCheckbox(String labelText, String checkboxValue, int order)
    {
        init();
        action.setCheckbox(labelText, checkboxValue, order);
//        if (checkboxValue.equals(""))
//            verifyResult(labelText, true);
//        else
//        {
//            boolean check = action.isCheckboxChecked(labelText);
//            if ((check && checkboxValue.startsWith("Y")) || (!check && (checkboxValue.startsWith("N") || checkboxValue.equals(""))))
//                verifyResult(labelText, true);
//            else
//                verifyResult(labelText, false);
//        }
    }

    @Step("Set checkbox of xPath \"{0}\" with option = {1}")
    public void setCheckboxAtXpathCSS(String xPathCSS, boolean checkValue)
    {
        init();
        action.setCheckbox(xPathCSS, checkValue);
    }

    @Step("Open calendar")
    public void openCalendar(String labelText)
    {
        init();
        action.openCalendar(labelText);
    }

    @Step("Set calendar date: {0}")
    public void setCalendarDate(String ddMMyyyy)
    {
        init();
        action.setCalendarDate(ddMMyyyy);
    }

    @Step("Input value {2} into {1} at {0}")
    public void setTextPopupPanel(String divName, String labelText, String value)
    {
        init();
        action.setTextPopupPanel(divName, labelText, value);
        //verifyResult(labelText, action.getTextPopupPanel(divName, labelText), value);
    }

    @Step("Choose {0} = {2} at row {1}")
    public void setRadioOptionAtTableCell(String columnName, int rowNumber, String checkValue)
    {
        init();
        action.setRadioOptionAtTableCell(columnName, rowNumber, checkValue);
        //verifyResult(columnName, action.isRadioOptionAtTableCellChecked(columnName, rowNumber, checkValue));
    }

    public int getRowNumber(String tableColumnName, String value)
    {
        init();
        return action.getRowNumber(tableColumnName, value);
    }

    @Step("Click number icon under {0}, line {1}")
    public void clickNumberIconAtTableCell(String columnName, int rowNumber)
    {
        init();
        action.clickNumberIconAtTableCell(columnName, rowNumber);
    }

    @Step("Click info button under {0}, line {1}")
    public void clickInfoAtTableCell(String columnName, int rowNumber)
    {
        init();
        action.clickInfoAtTableCell(columnName, rowNumber);
    }

    @Step("Click info button in {0} under {1}, line {2}")
    public void clickInfoAtTableCell(String tableName, String columnName, int rowNumber)
    {
        init();
        action.clickInfoAtTableCell(tableName, columnName, rowNumber);
    }

    @Step("Select {0}: {1}")
    public void selectRow(String columnName, String rowValue)
    {
        init();
        action.selectRow(columnName, rowValue);
    }

    @Step("Select result number {1} of {0}")
    public void selectRow(String columnName, int rowNumber)
    {
        init();
        action.selectRow(columnName, rowNumber);
    }

    public void waitForTextToShow(String text, long timeOut)
    {
        init();
        action.waitForTextToShow(text, timeOut);
    }

    @Step("Set checkbox of {0} with option = {1}")
    public void setCheckboxByValue(String labelValue, String checkValue)
    {
        init();
        action.setCheckboxByValue(labelValue, checkValue);
    }

    @Step("Set remark {0} = {2} at row {1}")
    public void setRemarkAtTableCell(String columnName, int rowNumber, String value)
    {
        init();
        action.setRemarkAtTableCell(columnName, rowNumber, value);
    }

    @Step("Set checkbox option = {1} of column {0}")
    public void setCheckBoxTableFilter(String columnName, String value)
    {
        init();
        action.setCheckBoxTableFilter(columnName, value);
        action.waitForAjax(1);
    }

    public void confirmNoOk(String yesNoOk)
    {
        init();
        action.confirmNoOk(yesNoOk);
    }

    public String getInfoPanelText()
    {
        init();
        return action.getInfoPanelText();
    }

    @Step("Logout")
    public void logOut()
    {
        init();
        action.logOut();
    }

    @Step("Login with username: {0} and password: {1} of company: {2}")
    public void login(String username, String password, String company, long timeOut)
    {
        init();
        action.login(username, password, company, timeOut);
    }

    @Step("Enter new credentials")
    public void enterNewUserInfo(String username, String password)
    {
        init();
        action.enterNewUserInfo(username, password);
    }

    public void setTextAtXpathCSS(String xPathCSS, String value)
    {
        init();
        action.setTextAtXpathCSS(xPathCSS, value);
    }

    @Step("Set checkbox option = {3} in row {2} of column {1} in tab {0}")
    public void setCheckBoxAtTableCellPRTimesheet(String tabName, String columnName, int rowNumber, String checkboxValue)
    {
        init();
        action.setCheckBoxAtTableCellPRTimesheet(tabName, columnName, rowNumber, checkboxValue);
        //verifyResult(columnName, action.isCheckBoxAtTableCellPRTimesheetChecked(tabName, columnName, rowNumber, checkboxValue));
    }

    public boolean checkElementVisible(String xPathCSS)
    {
        init();
        return action.checkElementVisible(xPathCSS);
    }

    public void clickAtXpathCSS(String xPathCSS)
    {
        init();
        action.clickAtXpathCSS(xPathCSS);
    }

    public void clickAtXpathCSS(String xPathCSS, int order)
    {
        init();
        action.clickAtXpathCSS(xPathCSS, order);
    }

    public void waitForProgressBar(long timeOut)
    {
        init();
        action.waitForProgressBar(timeOut);
    }

    @Step("Set checkbox option = {2} in record {1} of column {0}")
    public void setCheckBoxAtMultiList(String flagColumnName, String flagValue, String check, boolean reverseSearch)
    {
        init();
        action.setCheckBoxAtMultiList(flagColumnName, flagValue, check, reverseSearch);
    }

    @Step("Select {0} transaction to approve")
    public void selectRowInQueueAtTableApprovalSummary(String transactionTypeDesc)
    {
        init();
        action.selectRowInQueueAtTableApprovalSummary(transactionTypeDesc);
    }

    @Step("Filter column {0} = {1}")
    public void setTableFilter(String columnName, String value, int order)
    {
        init();
        action.setTableFilter(columnName, value, order);
    }

    public boolean checkValueExist(String value)
    {
        init();
        return action.checkValueExist(value);
    }

    public void waitForTextToVanish(String text, long timeOut)
    {
        init();
        action.waitForTextToVanish(text, timeOut);
    }

    public String getTextDesc(String labelText)
    {
        init();
        return action.getText(labelText);
    }

    @Step("Select all {1} = {2} in tab {0}")
    public void setCheckBoxTableFilterAtTableCellPRTimesheet(String tabName, String columnName, String value)
    {
        init();
        action.setCheckBoxTableFilterAtTableCellPRTimesheet(tabName, columnName, value);
    }

    @Step("Filter column {1} = {2} at tab {0}")
    public void setTableFilterAtPRTimesheet(String tabName, String columnName, String value)
    {
        init();
        action.setTableFilterAtPRTimesheet(tabName, columnName, value);
    }

    @Step("Choose {0}")
    public void setDropDownOption(String optionValue)
    {
        init();
        action.setDropDownOption(optionValue);
    }

    @Step("{0} all at Approval Summary")
    public void approveAllAtTableApprovalSummary(String option)
    {
        init();
        action.approveAllAtTableApprovalSummary(option);
    }

    @Step("Click search under {0}, line {1}")
    public void clickSearchAtTableCell(String columnName, int rowNumber)
    {
        init();
        action.clickSearchAtTableCell(columnName, rowNumber);
    }

    @Step("Click search button in {0} under {1}, line {2}")
    public void clickSearchAtTableCell(String tableName, String columnName, int rowNumber)
    {
        init();
        action.clickSearchAtTableCell(tableName, columnName, rowNumber);
    }

    @Step("Click search in row {2} of column {1} in tab {0}")
    public void clickSearchAtTableCellPRTimeSheet(String tabName, String columnName, int rowNumber)
    {
        init();
        action.clickSearchAtTableCellPRTimeSheet(tabName, columnName, rowNumber);
    }

    public String getBaseURL()
    {
        init();
        return action.getBaseURL();
    }

    public String getProp(String value)
    {
        return System.getProperty(value) == null ? "" : System.getProperty(value);
    }

    String doVerify = "verify.Step";

    // ********************* verify methods
    public String getTextAtTableCell(String columnName, int rowNumber)
    {
        if (getProp(doVerify).equals("Y"))
        {
            init();
            return action.getTextAtTableCell(columnName, rowNumber);
        }
        return "";
    }

    public String getTextAtTableCell(String tablename, String columnName, int rowNumber)
    {
        if (getProp(doVerify).equals("Y"))
        {
            init();
            return action.getTextAtTableCell(tablename, columnName, rowNumber);
        }
        return "";
    }

    public String getTextAtTableCell(String columnName, int colCount, int rowNumber)
    {
        if (getProp(doVerify).equals("Y"))
        {
            init();
            return action.getTextAtTableCell(columnName, colCount, rowNumber);
        }
        return "";
    }

    public boolean isCheckboxOptionAtTableCell_AllChecked(String columnName)
    {
        if (getProp(doVerify).equals("Y"))
        {
            init();
            return action.isCheckboxOptionAtTableCell_AllChecked(columnName);
        }
        return true;
    }

    public boolean isCheckBoxAtTableCellChecked(String columnName, int rowNumber, String checkboxValue)
    {
        if (getProp(doVerify).equals("Y"))
        {
            if (checkboxValue.equals(""))
                return true;
            init();
            boolean check = action.isCheckBoxAtTableCellChecked(columnName, rowNumber);
            if ((check && checkboxValue.startsWith("Y")) || (!check && (checkboxValue.startsWith("N") || checkboxValue.equals(""))))
                return true;
            else
                return false;
        }
        return true;
    }

    public boolean isCheckBoxAtTableCellChecked(String tableName, String columnName, int rowNumber, String checkboxValue)
    {
        if (getProp(doVerify).equals("Y"))
        {
            if (checkboxValue.equals(""))
                return true;
            init();
            boolean check = action.isCheckBoxAtTableCellChecked(tableName, columnName, rowNumber);
            if ((check && checkboxValue.startsWith("Y")) || (!check && (checkboxValue.startsWith("N") || checkboxValue.equals(""))))
                return true;
            else
                return false;
        }
        return true;
    }

    public String getTextValue(String labelText)
    {
        if (getProp(doVerify).equals("Y"))
        {
            init();
            return action.getTextValue(labelText);
        }
        return "";
    }

    public String getTextValue(String labelText, int order)
    {
        if (getProp(doVerify).equals("Y"))
        {
            init();
            return action.getTextValue(labelText, order);
        }
        return "";
    }

    public String getTextValueByXpathCss(String xPathCss)
    {
        init();
        return action.getTextValueByXpathCss(xPathCss);
    }

    public boolean isRadioOptionChecked(String labelText, String radioValue)
    {
        if (getProp(doVerify).equals("Y"))
        {
            init();
            return action.isRadioOptionChecked(labelText, radioValue);
        }
        return true;
    }

    public boolean isRadioOptionChecked(String value)
    {
        if (getProp(doVerify).equals("Y"))
        {
            init();
            return action.isRadioOptionChecked(value);
        }
        return true;
    }

    public boolean isCheckboxChecked(String labelText, String checkboxValue)
    {
        if (getProp(doVerify).equals("Y"))
        {
            if (checkboxValue.equals(""))
                return true;
            init();
            boolean check = action.isCheckboxChecked(labelText);
            if ((check && checkboxValue.startsWith("Y")) || (!check && (checkboxValue.startsWith("N"))))
                return true;
            else
                return false;
        }
        return true;
    }

    public boolean isCheckboxChecked(String labelText, int order, String checkboxValue)
    {
        if (getProp(doVerify).equals("Y"))
        {
            init();
            if (checkboxValue.equals(""))
                return true;
            boolean check = action.isCheckboxChecked(labelText, order);
            if ((check && checkboxValue.startsWith("Y")) || (!check && (checkboxValue.startsWith("N"))))
                return true;
            else
                return false;
        }
        return true;
    }

    public boolean isCheckboxByValueChecked(String labelValue, String checkboxValue)
    {
        if (getProp(doVerify).equals("Y"))
        {
            if (checkboxValue.equals(""))
                return true;
            init();
            boolean check = action.isCheckboxByValueChecked(labelValue);
            if ((check && checkboxValue.startsWith("Y")) || (!check && (checkboxValue.startsWith("N"))))
                return true;
            else
                return false;
        }
        return true;
    }

    public String getDropDownOptionAtTableCell(String columnName, int rowNumber)
    {
        if (getProp(doVerify).equals("Y"))
        {
            init();
            return action.getDropDownOptionAtTableCell(columnName, rowNumber);
        }
        return "";
    }

    public boolean isRadioOptionAtTableCellChecked(String columnName, int rowNumber, String checkValue)
    {
        if (getProp(doVerify).equals("Y"))
        {
            init();
            return action.isRadioOptionAtTableCellChecked(columnName, rowNumber, checkValue);
        }
        return true;
    }

    public String getDropDownOptionAtTableCell(String tableName, String columnName, int rowNumber)
    {
        if (getProp(doVerify).equals("Y"))
        {
            init();
            return action.getDropDownOptionAtTableCell(tableName, columnName, rowNumber);
        }
        return "";
    }

    public String getTextPopupPanel(String divName, String labelText)
    {
        if (getProp(doVerify).equals("Y"))
        {
            init();
            return action.getTextPopupPanel(divName, labelText);
        }
        return "";
    }
}