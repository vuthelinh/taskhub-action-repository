package com.synergix.payroll.timesheet_calculation.defs;

import com.synergix.common.CONST;
import com.synergix.common.actions.DatasetBase;
import com.synergix.common.actions.PageSteps;
import com.synergix.utilities.DateTimeUtil;
import com.synergix.utilities.ExcelUtils;
import com.synergix.utilities.ReadBean;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;
import org.apache.poi.hssf.util.HSSFColor;

import java.sql.ResultSet;

public class OutputCheckDefs extends DatasetBase
{
    @Steps
    PageSteps pageSteps;

    @Given("^Data is compared with\\s+\"([^\"]*)\"$") // for timesheet calculation only
    public void compareExcel(String expectedOutputFile)
    {
        expectedOutputFile = getPayrollExpectedPath(expectedOutputFile);

        String actualOutputFile = "";
        if (expectedOutputFile.contains("BasicOT_Flexible") && expectedOutputFile.contains("_NoRound"))
            actualOutputFile = ReadBean.getPropValue("settings.properties", "sql.output.basicot.flexible.noround");
        if (expectedOutputFile.contains("BasicOT_Flexible") && expectedOutputFile.contains("_Round"))
            actualOutputFile = ReadBean.getPropValue("settings.properties", "sql.output.basicot.flexible.round");
        if (expectedOutputFile.contains("BasicOT_FixedRate") && expectedOutputFile.contains("_NoRound"))
            actualOutputFile = ReadBean.getPropValue("settings.properties", "sql.output.basicot.fixedrate.noround");
        if (expectedOutputFile.contains("BasicOT_FixedRate") && expectedOutputFile.contains("_Round"))
            actualOutputFile = ReadBean.getPropValue("settings.properties", "sql.output.basicot.fixedrate.round");
        if (expectedOutputFile.contains("BasicOT_TimeRange"))
            actualOutputFile = ReadBean.getPropValue("settings.properties", "sql.output.basicot.timerange");
        if (expectedOutputFile.contains("BasicOT_WorkingHour"))
            actualOutputFile = ReadBean.getPropValue("settings.properties", "sql.output.basicot.workinghour");
        if (expectedOutputFile.contains("BasicSalary"))
            actualOutputFile = ReadBean.getPropValue("settings.properties", "sql.output.basicsalary");
        if (expectedOutputFile.contains("HourlyRate_TimeRange") && !expectedOutputFile.contains("NWT") && !expectedOutputFile.contains("UD"))
            actualOutputFile = ReadBean.getPropValue("settings.properties", "sql.output.hourlyrate.timerange");
        if (expectedOutputFile.contains("HourlyRate_TimeRange") && expectedOutputFile.contains("NWT") && !expectedOutputFile.contains("UD"))
            actualOutputFile = ReadBean.getPropValue("settings.properties", "sql.output.hourlyrate.timerange.nwt");
        if (expectedOutputFile.contains("HourlyRate_TimeRange_UD"))
            actualOutputFile = ReadBean.getPropValue("settings.properties", "sql.output.hourlyrate.timerange.ud");
        if (expectedOutputFile.contains("HourlyRate_WorkingHour"))
            actualOutputFile = ReadBean.getPropValue("settings.properties", "sql.output.hourlyrate.workinghour");
        if (expectedOutputFile.contains("PieceRate"))
            actualOutputFile = ReadBean.getPropValue("settings.properties", "sql.output.piecerate");
        if (expectedOutputFile.contains("TimeSlot"))
            actualOutputFile = ReadBean.getPropValue("settings.properties", "sql.output.timeslot");

        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + "TSC_OutputCheck_Reference.xls";
        setDataset("Dataset");
        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String sheetToCheck = getColumn(1);
            String flagCol1 = getColumn(2);
            String flagCol2 = getColumn(3);
            String flagCol3 = getColumn(4);

            if (empty(flagCol1) && empty(flagCol2))
                checkSheetReference(expectedOutputFile, actualOutputFile, sheetToCheck, flagCol1, flagCol2, flagCol3, false);
            else
                checkSheetReference(expectedOutputFile, actualOutputFile, sheetToCheck, flagCol1, flagCol2, flagCol3, true);
            sleep(5);
        }
        sendEmailToPY("Timesheet Calculation SQL Data - Compared", "Date: " + DateTimeUtil.getTimeToday(), actualOutputFile);
    }

    @Given("^Data is calculated correctly follows\\s+\"([^\"]*)\"on sheet\\s+\"([^\"]*)\"$") // for cpf calculation
    public void checkData(String dataset, String sheetName)
    {
        //todo: awaiting expected output
    }

    // for timesheet calculation only
    @Given("^Data is pulled out follows\\s+\"([^\"]*)\" using Employee Prefix\\s+\"([^\"]*)\" with suffix as generated date$")
    public void pullOutData(String dataset, String empPrefix)
    {
        String sqlResult = "";
        if (dataset.contains("BasicOT_Flexible") && dataset.contains("_NoRound"))
            sqlResult = ReadBean.getPropValue("settings.properties", "sql.output.basicot.flexible.noround");
        if (dataset.contains("BasicOT_Flexible") && dataset.contains("_Round"))
            sqlResult = ReadBean.getPropValue("settings.properties", "sql.output.basicot.flexible.round");
        if (dataset.contains("BasicOT_FixedRate") && dataset.contains("_NoRound"))
            sqlResult = ReadBean.getPropValue("settings.properties", "sql.output.basicot.fixedrate.noround");
        if (dataset.contains("BasicOT_FixedRate") && dataset.contains("_Round"))
            sqlResult = ReadBean.getPropValue("settings.properties", "sql.output.basicot.fixedrate.round");
        if (dataset.contains("BasicOT_TimeRange"))
            sqlResult = ReadBean.getPropValue("settings.properties", "sql.output.basicot.timerange");
        if (dataset.contains("BasicOT_WorkingHour"))
            sqlResult = ReadBean.getPropValue("settings.properties", "sql.output.basicot.workinghour");
        if (dataset.contains("BasicSalary"))
            sqlResult = ReadBean.getPropValue("settings.properties", "sql.output.basicsalary");
        if (dataset.contains("HourlyRate_TimeRange") && !dataset.contains("NWT") && !dataset.contains("UD"))
            sqlResult = ReadBean.getPropValue("settings.properties", "sql.output.hourlyrate.timerange");
        if (dataset.contains("HourlyRate_TimeRange") && dataset.contains("NWT") && !dataset.contains("UD"))
            sqlResult = ReadBean.getPropValue("settings.properties", "sql.output.hourlyrate.timerange.nwt");
        if (dataset.contains("HourlyRate_TimeRange_UD"))
            sqlResult = ReadBean.getPropValue("settings.properties", "sql.output.hourlyrate.timerange.ud");
        if (dataset.contains("HourlyRate_WorkingHour"))
            sqlResult = ReadBean.getPropValue("settings.properties", "sql.output.hourlyrate.workinghour");
        if (dataset.contains("PieceRate"))
            sqlResult = ReadBean.getPropValue("settings.properties", "sql.output.piecerate");
        if (dataset.contains("TimeSlot"))
            sqlResult = ReadBean.getPropValue("settings.properties", "sql.output.timeslot");

        String[] dates = {"2015-04-20", "2015-04-21", "2015-04-22", "2015-04-23", "2015-04-24", "2015-04-25", "2015-04-26", "2015-04-27", "2015-04-28", "2015-04-29", "2015-04-30", "2015-05-01", "2015-05-02", "2015-05-03", "2015-05-04", "2015-05-05", "2015-05-06", "2015-05-07", "2015-05-08", "2015-05-09", "2015-05-10", "2015-05-31"};
        String[] dates2 = {"2015-05-18", "2015-05-19", "2015-05-20", "2015-05-21", "2015-05-22", "2015-05-23", "2015-05-24", "2015-05-25", "2015-05-26", "2015-05-27", "2015-05-28", "2015-05-29", "2015-05-30", "2015-05-31", "2015-06-01", "2015-06-02", "2015-06-03", "2015-06-04", "2015-06-05", "2015-06-06", "2015-06-07", "2015-06-30"};

        excelPath = System.getProperty("user.dir") + CONST.PAYROLL + "TSC_CheckSQL_Consol.xls";
        setDataset("Dataset");
        for (i = 1; i <= datasetObjArray.length; i++)
        {
            String tableName = getColumn(1);
            String statementEx = getColumn(2);

            String datesIn = "";
            datesIn = "IN (";

            String[] dates_x = null;
            if (dataset.contains("Piece")) // Piece Rate
                dates_x = dates2;
            else
                dates_x = dates;

            for (String date : dates_x)
            {
                datesIn += "'" + date + "', ";
            }
            datesIn += "'')";
            datesIn = datesIn.replace(", '')", ")");

            String statement = statementEx.replace("?date", datesIn);
            statement = statement.replace("?emp", empPrefix);

            ResultSet rs = getResultStatement(statement);
            ExcelUtils.createExcelFile(sqlResult, tableName);
            ExcelUtils.createExistingColumns(sqlResult, tableName, rs);
            ExcelUtils.createExistingCells(sqlResult, tableName, rs);
        }
        sendEmailToPY("Timesheet Calculation SQL Data - Uncompared", "Date: " + DateTimeUtil.getTimeToday(), sqlResult);
    }

    public void checkSheetReference(String expectedOutputFile, String actualOutputFile, String sheetToCheck, String empCode_Col, String timeIn_Col,
                                    String timeOut_Col, boolean referenceMode)
    {
        int flag1;
        int flag2;
        int flag3;
        setDetailData(expectedOutputFile, sheetToCheck, true, true); // must get all cell including row A
        flag1 = getColumnIndex_Detail(empCode_Col);
        flag2 = getColumnIndex_Detail(timeIn_Col);
        flag3 = getColumnIndex_Detail(timeOut_Col);

        int columnCount = ExcelUtils.getColumnCount(expectedOutputFile, sheetToCheck);
        // get the correlative column number
        int correlativeCol = 0;
        if (columnCount % 2 == 0)
            correlativeCol = columnCount / 2;
        else
            correlativeCol = columnCount;// no more - EXPECTED COLUMN

        try
        {
            detailObjArray = ExcelUtils.getTableArray(actualOutputFile, sheetToCheck, 1, correlativeCol);
            detailObjArray_Child = ExcelUtils.getTableArray(expectedOutputFile, sheetToCheck, 1, correlativeCol);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        if (detailObjArray != null && detailObjArray_Child != null)
        {
            if (referenceMode)
            {
                for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
                {
                    int flag = 1; // to check if there's no referenced record on expected output side
                    String empCode = getColumn_Detail(flag1);
                    String timeIn = getColumn_Detail(flag2);
                    String timeOut = "";
                    if (flag3 != -1)
                        timeOut = getColumn_Detail(flag3);

                    for (i_child = 1; i_child <= detailObjArray_Child.length; i_child++)
                    {
                        String empCode_Nested = getColumn_Child(flag1);
                        String timeIn_Nested = getColumn_Child(flag2);
                        String timeOut_Nested = getColumn_Child(flag3);

                        if (empCode.equals(empCode_Nested) && timeIn.equals(timeIn_Nested) && timeOut.equals(timeOut_Nested))
                        {
                            for (int g = 1; g <= correlativeCol; g++)
                            {
                                String actual = getColumn_Detail(g);
                                String expected = getColumn_Child(g);

                                if (!actual.startsWith("CTS") && !expected.startsWith("CTS") && !actual.equalsIgnoreCase(expected))
                                {
                                    // fill cell red
                                    ExcelUtils.setCellColor(actualOutputFile, sheetToCheck, i_detail, g - 1, HSSFColor.RED.index);
                                    ExcelUtils.setCellComment(actualOutputFile, sheetToCheck, i_detail, g - 1, "Levin",
                                                              "Expected value: " + expected);
                                    //ExcelUtils.setCellColor(actualOutputFile, sheetToCheck, i_Nested, g - 1 + correlativeCol);
                                }
                            }
                            break;
                        }
                        flag += 1;
                    }
                    if (flag >= detailObjArray_Child.length) // no referenced record
                    {
                        // set color to the first column in the non-referenced record
                        ExcelUtils.setCellColor(actualOutputFile, sheetToCheck, i_detail, 0, HSSFColor.GOLD.index);
                        ExcelUtils.setCellComment(actualOutputFile, sheetToCheck, i_detail, 0, "Levin", "No corresponding record");
                    }
                }
            }
            else
            {
                for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
                {
                    for (int g = 1; g <= correlativeCol; g++)
                    {
                        i_child = i;
                        String actual = getColumn_Detail(g);
                        String expected = getColumn_Child(g);

                        if (!actual.equalsIgnoreCase(expected))
                        {
                            // fill cell red
                            ExcelUtils.setCellColor(actualOutputFile, sheetToCheck, i_detail, g - 1, HSSFColor.RED.index);
                            ExcelUtils.setCellComment(actualOutputFile, sheetToCheck, i_detail, g - 1, "Levin", "Expected value: " + expected);
                        }
                    }
                }
            }
        }
    }
}
