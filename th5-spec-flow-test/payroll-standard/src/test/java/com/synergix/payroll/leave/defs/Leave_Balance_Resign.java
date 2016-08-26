package com.synergix.payroll.leave.defs;

import com.synergix.common.actions.DatasetBase;
import com.synergix.common.actions.PageSteps;
import com.synergix.utilities.DateTimeUtil;
import com.synergix.utilities.SessionData;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;

/**
 * Created by synergix61 on 23/2/2016.
 */
public class Leave_Balance_Resign extends DatasetBase
{
    @Steps
    PageSteps pageSteps;

    String sqlResult_Data     = getPayrollOutputPath("Leave_Balance_Resign_Data_" + DateTimeUtil.getTime("dd_MM_yyyy") + ".xls");
    String sqlResult_Compared = getPayrollOutputPath("Leave_Balance_Resign_Data_Compared_" + DateTimeUtil.getTime("dd_MM_yyyy") + ".xls");

    //user pulls out data as "Set 1 - After Submit" follow "LV_Encash_SQLCheck.xls" on sheet "AfterSubmit"
    @When("^user pulls out data for Leave Balance Resign as\\s+\"([^\"]*)\" follow\\s+\"([^\"]*)\" on sheet\\s+\"([^\"]*)\"$")
    public void pulloutData(String outputSheetName, String sqlCheckFile, String inputSheetName, List<List<String>> dataTable)
    {
        sqlCheckFile = getPayrollPath(sqlCheckFile);
        pullOutData(sqlResult_Data, outputSheetName, sqlCheckFile, inputSheetName, dataTable, voucherList);
    }

    @When("^user compares data for Leave Balance Resign with$")
    public void compareLeaveEncashmentData(List<List<String>> dataTable)
    {
        SessionData.addDataTable("CompareData", dataTable, false);
        for (int row : SessionData.getDataTbRowsNoHeader("CompareData").keySet())
        {
            String expectedFile = SessionData.getDataTbVal("CompareData", row, "Expected File");
            String sheetName = SessionData.getDataTbVal("CompareData", row, "Sheet");
            String scenarioDesc = SessionData.getDataTbVal("CompareData", row, "Scenario Description");

            if (empty(expectedFile))
                continue;

            expectedFile = getPayrollExpectedPath(expectedFile);
            // add to the result table in Session Data
            addCompared_MultipleTableData(sqlResult_Data, expectedFile, sqlResult_Compared, sheetName, scenarioDesc);
        }
        // get the result table
        String report = getTableReport(true);

        // display the result table in cucumber report
        pageSteps.verifyFinalResult(report);

        // display the result table with total failed cases
        pageSteps.verifyFinalResult(getTableReport_Summary(failedCasesNo), failedCasesNo);
    }
}




