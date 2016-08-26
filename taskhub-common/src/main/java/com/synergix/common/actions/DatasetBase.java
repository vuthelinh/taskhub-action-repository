package com.synergix.common.actions;

import com.synergix.common.CONST;
import com.synergix.utilities.*;
import net.serenitybdd.core.Serenity;
import org.apache.poi.hssf.util.HSSFColor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatasetBase
{
    protected static ConnectDatabase db2;
    protected static String excelPath = "";
    protected static Object[][] datasetObjArray;
    protected static Object[][] detailObjArray;
    protected static Object[][] detailObjArray_Child;
    protected static Object[][] detailObjArray_Grandchild;
    public static final String       reportKey     = "FINAL_RESULT_TBL";
    public static final String       summaryKey    = "FINAL_SUMMARY_TBL";
    protected static    List<String> verifyStep    = new ArrayList<String>();
    protected static    int          failedCasesNo = 0;
    protected static    Map          voucherList   = new HashMap();

    public static void setDataset(String sheetName)
    {
        setTableDataset(excelPath, sheetName, false); // only get from column B and row 2 for dataset
    }

    public static void setDetailData(String sheetName)
    {
        setDetailData(excelPath, sheetName, true);
    }

    public static void setDetailData_Child(String sheetName)
    {
        setDetailData_Child(excelPath, sheetName, true);
    }

    public static void setDetailData_Grandchild(String sheetName)
    {
        setDetailData_Grandchild(excelPath, sheetName, true);
    }

    // get data from sheet starting from column A
    private static void setTableDataset(String excelPath, String sheetName, boolean getAllCell)
    {
        try
        {
            if (getAllCell == false)
                datasetObjArray = ExcelUtils.getTableArray(excelPath, sheetName);
            else
                datasetObjArray = ExcelUtils.getTableArray(excelPath, sheetName, true, true); // not getting first row and first column

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    // get data from sheet starting from column A , row B
    public static void setDetailData(String excelPath, String sheetName, boolean getAllCell)
    {
        try
        {
            if (getAllCell == false)
                detailObjArray = ExcelUtils.getTableArray(excelPath, sheetName);
            else
                detailObjArray = ExcelUtils.getTableArray(excelPath, sheetName, true, false); // not getting first row
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void setDetailData_Child(String excelPath, String sheetName, boolean getAllCell)
    {
        try
        {
            if (getAllCell == false)
                detailObjArray_Child = ExcelUtils.getTableArray(excelPath, sheetName);
            else
                detailObjArray_Child = ExcelUtils.getTableArray(excelPath, sheetName, true, false);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void setDetailData_Grandchild(String excelPath, String sheetName, boolean getAllCell)
    {
        try
        {
            if (getAllCell == false)
                detailObjArray_Grandchild = ExcelUtils.getTableArray(excelPath, sheetName);
            else
                detailObjArray_Grandchild = ExcelUtils.getTableArray(excelPath, sheetName, true, false);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void setDetailData(String excelPath, String sheetName, boolean getFirstCol, boolean getFirstRow)
    {
        try
        {
            detailObjArray = ExcelUtils.getTableArray(excelPath, sheetName, getFirstCol, getFirstRow);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    // only for all-cell table object starts with row 1, col A
    public int getColumnIndex_Detail(String columnName)
    {
        if (empty(columnName))
            return -1;
        int index = 0;
        try
        {
            for (int a = 0; a < detailObjArray[0].length; a++)
            {
                if (detailObjArray[0][a].toString().equals(columnName))
                {
                    index = a + 1;
                    return index;
                }
            }
        } catch (Exception e)
        {
        }
        return index;
    }

    protected static int i            = 0;// Row
    protected static int i_detail     = 0;
    protected static int i_child      = 0;
    protected static int i_grandchild = 0;

    public static String getColumn(int j)
    {
        return ExcelUtils.getCell(datasetObjArray, i, j);
    }

    public static String getColumn(int i, int j)
    {
        return ExcelUtils.getCell(datasetObjArray, i, j);
    }

    // for use if setTableData nested inside a table data
    public static String getColumn_Detail(int j)
    {
        return ExcelUtils.getCell(detailObjArray, i_detail, j);
    }

    public static String getColumn_Child(int j)
    {
        return ExcelUtils.getCell(detailObjArray_Child, i_child, j);
    }

    public static String getColumn_Grandchild(int j)
    {
        return ExcelUtils.getCell(detailObjArray_Grandchild, i_grandchild, j);
    }

    public static void connectDB(String propertiesFile)
    {
        String connectionString = ReadBean.getPropValue(propertiesFile, "dbURL");
        String username = ReadBean.getPropValue(propertiesFile, "dbUser");
        String password = ReadBean.getPropValue(propertiesFile, "dbPass");
        db2 = new ConnectDatabase(connectionString, username, password);
    }

    public static void connectSessionDB()
    {
        String dbURL = Serenity.sessionVariableCalled("DB_URL");
        String dbUsername = Serenity.sessionVariableCalled("DB_USERNAME");
        String dbPassword = Serenity.sessionVariableCalled("DB_PASSWORD");

        db2 = new ConnectDatabase(dbURL, dbUsername, dbPassword);
    }

    // get connection from Session Variable
    public static void executeUpdate(String sql)
    {
        connectSessionDB();
        ConnectDatabase.executeUpdate(sql);
    }

    // get connection from Session Variable
    public static ResultSet executeQuery(String sql)
    {
        connectSessionDB();
        return ConnectDatabase.executeQuery(sql);
    }

    public static String getColumnValue(String connectionString, String userName, String password, String query, String columnName)
    {
        connectSessionDB();
        return ConnectDatabase.getColumnValue(connectionString, userName, password, query, columnName);
    }

    // get connection from Session Variable
    public static String getColumnValue(String query, String columnName)
    {
        connectSessionDB();
        return ConnectDatabase.getColumnValue(query, columnName);
    }

    public static void executeUpdateWithExc(String query) throws SQLException
    {
        connectSessionDB();
        ConnectDatabase.executeUpdateWithExc(query);
    }

    public static ResultSet getResultStatement(String query)
    {
        connectSessionDB();
        return ConnectDatabase.getResultStatement(query);
    }

    public static boolean hasRecords(String query)
    {
        connectSessionDB();
        return !ConnectDatabase.empty(ConnectDatabase.executeQuery(query));
    }

    // Utils
    public static boolean empty(String value)
    {
        return ReadBean.empty(value);
    }

    public static boolean notEmpty(String value)
    {
        return ReadBean.notEmpty(value);
    }

    public static String trim(String value)
    {
        return value.trim();
    }

    public static double toDouble(Object value)
    {
        return ReadBean.toDouble(value);
    }

    public static boolean equals(String valueA, String valueB)
    {
        return ReadBean.equalsValue(valueA, valueB);
    }

    public static void sleep(long timeOut)
    {
        try
        {
            Thread.sleep(timeOut);
        } catch (InterruptedException e)
        {
        }
    }

    public static String getPayrollPath(String dataset)
    {
        return System.getProperty("user.dir") + CONST.PAYROLL + dataset;
    }

    public static String getPayrollFeaturePath(String feature)
    {
        return System.getProperty("user.dir") + CONST.FEATURE_PAYROLL + feature;
    }

    public static String getPayrollOutputPath(String dataset)
    {
        return System.getProperty("user.dir") + CONST.PAYROLL_OUTPUT + dataset;
    }

    public static String getPayrollExpectedPath(String dataset)
    {
        return System.getProperty("user.dir") + CONST.PAYROLL_EXPECTED + dataset;
    }

    public static String getDatasetPath(String dataset, String CONST_Path)
    {
        return System.getProperty("user.dir") + CONST_Path + dataset;
    }

    public static String getCurrentCompany()
    {
        return Serenity.sessionVariableCalled("USER_COMPANY");
    }

    public static void sendEmailToPY(String subject, String message, String fileName)
    {
        if (getProp("send.email") != null)
        {
            if (getProp("send.email").equalsIgnoreCase("Y"))
            {
                MailBean.sendEmailToPY(subject, message, fileName);
            }
        }
    }

    public static void sendEmailToPY(String subject, String message, List<String> fileNames)
    {
        if (getProp("send.email") != null)
        {
            if (getProp("send.email").equalsIgnoreCase("Y"))
            {
                MailBean.sendEmailToPY(subject, message, fileNames);
            }
        }
    }

    public static void sendEmailToFIN(String subject, String message, List<String> fileNames)
    {
        if (getProp("send.email") != null)
        {
            if (getProp("send.email").equalsIgnoreCase("Y"))
            {
                MailBean.sendEmailToFIN(subject, message, fileNames);
            }
        }
    }

    public static String getProp(String value)
    {
        return System.getProperty(value);
    }

    public static void setVariable(String variable, String value)
    {
        Serenity.setSessionVariable(variable).to(value);
    }

    public static void setFailSubject(String s)
    {
        setVariable(CONST.FAIL_SUBJECT, s);
    }

    public static void setFailMessage(String s)
    {
        setVariable(CONST.FAIL_MESSAGE, s);
    }

    public static void writeReport(String report)
    {
        ReadBean.writeToFile(CONST.REPORT_FILE, report, true);
    }

    public static String getVoucher(String key, Map voucherList)
    {
        String value = "";
        try
        {
            value = voucherList.get(key).toString();
        } catch (Exception e)
        {
            value = "";
        }
        return value;
    }

    public static String getVoucher(String key)
    {
        String value = "";
        try
        {
            value = voucherList.get(key).toString();
        } catch (Exception e)
        {
            value = "";
        }
        return value;
    }

    /**
     * @param sqlResult_Data  full path of output excel file
     * @param outputSheetName sheet name to output
     * @param sqlCheckFile    full path of excel file contains sql statements to check
     * @param inputSheetName  sheet name in the sqlCheckFile
     * @param dataTable       data table from feature
     * @param voucherList     list containing voucher numbers
     * @Description pull out data from DB to excel file based on a set of sql statements
     * @author Levin
     */
    public static void pullOutData(String sqlResult_Data, String outputSheetName, String sqlCheckFile, String inputSheetName,
                                   List<List<String>> dataTable, Map voucherList)
    {
        ResultSet rs;
        ExcelUtils.createExcelFile(sqlResult_Data, outputSheetName);
        int lastRow = ExcelUtils.getLastRowNum(sqlResult_Data, outputSheetName);
        //sqlCheckFile = getPayrollPath(sqlCheckFile);
        // loop through excel rơws first
        setDetailData(sqlCheckFile, inputSheetName, true);
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            String marker = getColumn_Detail(1);
            String statement = getColumn_Detail(2);
            String type1 = getColumn_Detail(3);
            String replacement = "";
            String finalStt = "";

            if (statement.contains("?"))
            {
                replacement += "IN(";
                // loop through datatable to get voucher keys
                SessionData.addDataTable("pullData", dataTable, false);
                for (int row : SessionData.getDataTbRowsNoHeader("pullData").keySet())
                {
                    String vchNo = SessionData.getDataTbVal("pullData", row, "Voucher No");
                    String code = SessionData.getDataTbVal("pullData", row, "Condition Code");

                    if (notEmpty(vchNo))
                    {
                        String voucherNo = getVoucher(vchNo, voucherList);
                        replacement += "'" + voucherNo + "', ";
                    }
                    if (notEmpty(code))
                    {
                        replacement += "'" + code + "', ";
                    }
                }
                replacement += "'')";
                replacement = replacement.replace(", '')", ")");
                finalStt = statement.replace("?", replacement);
            }
            else
            {
                finalStt = statement;
            }

            rs = getResultStatement(finalStt);
            int records = ConnectDatabase.getNumberofRecords(finalStt);

            lastRow += 1;
            ExcelUtils.writeToExel(sqlResult_Data, outputSheetName, marker, lastRow, 0);
            lastRow += 1;
            ExcelUtils.createExistingColumns(sqlResult_Data, outputSheetName, rs, lastRow);
            lastRow += 0;
            ExcelUtils.createExistingCells(sqlResult_Data, outputSheetName, rs, lastRow);
            lastRow += records + 1;
        }
    }

    /**
     * @param actualFile            full path of output excel file
     * @param expectedFile          full path of expected excel file
     * @param output_ComparedResult full path of compared data excel file
     * @param sheetName             sheet name to compare, also the scenario name
     * @param scenarioDesc          scenario description
     * @return add results row to table data
     * @Description compare 2 sql output data and return result under Session Data format
     * @author Levin
     */
    public static void addCompared_MultipleTableData(String actualFile, String expectedFile, String output_ComparedResult, String sheetName,
                                                     String scenarioDesc)
    {
        List<List<String>> actualTable = new ArrayList<>();
        List<List<String>> expectedTable = new ArrayList<>();
        List<String> columnNamesList = new ArrayList<>();

        try
        {
            ExcelUtils.isSheetExist(expectedFile, sheetName);
        } catch (Exception e)
        {
            return;
        }

        ExcelUtils.createExcelFile(output_ComparedResult, sheetName);

        // get all data in actual file & expected file
        setDetailData(actualFile, sheetName, true);
        setDetailData_Child(expectedFile, sheetName, true);

        // get total number of columns
        int numberOfCols = detailObjArray[0].length;

        boolean startRegion = false;
        boolean endRegion = false;
        boolean startRegion2 = false;
        boolean endRegion2 = false;

        String value_actual = "";
        String value_expected = "";

        String marker_actual = "";
        columnNamesList = new ArrayList<>();

        boolean fullPass = true; // to trigger if a scenario has passed every data

        addRowToTbDataReport("Scenario", "Description", "Marker", "Result", "Comment");
        for (i_detail = 1; i_detail <= detailObjArray.length; i_detail++)
        {
            value_actual = getColumn_Detail(1);
            if (empty(value_actual) && !startRegion)
            {
                startRegion = false;
                endRegion = false;
            }

            // determine the start of the table region
            if (notEmpty(value_actual) && !endRegion)
            {
                startRegion = true;
                // marker have to start with S: eg: S1, S2
                if (value_actual.startsWith("S") && value_actual.contains("-"))
                {
                    marker_actual = value_actual;
                    List<String> mini = new ArrayList<String>();
                    mini.add(value_actual);
                    actualTable.add(mini);
                }
                else
                {
                    List<String> mini = new ArrayList<String>();
                    for (int col = 1; col <= numberOfCols; col++)
                    {
                        String cellValue = getColumn_Detail(col);
                        mini.add(cellValue);
                        // check if cell value is column name, then put to seperate list to access later
                        if (ReadBean.isUpperCase(cellValue) && cellValue.contains("_"))
                            columnNamesList.add(cellValue);
                    }
                    actualTable.add(mini);
                }
            }

            // determine the end of the table region
            // there's a case where cannot determine the end of the region when reach excel's last row
            if ((empty(value_actual) && startRegion) || i_detail == detailObjArray.length)
            {
                endRegion = false;
                // get the table region in actual file done, proceed to get from expected file
                for (i_child = 1; i_child <= detailObjArray_Child.length; i_child++)
                {
                    value_expected = getColumn_Child(1);
                    if (value_expected.equalsIgnoreCase(marker_actual) || (startRegion2 && !endRegion2))
                    {
                        startRegion2 = true;
                        endRegion2 = false;

                        // determine the start of the table region
                        if (notEmpty(value_expected) && !endRegion2)
                        {
                            if (value_expected.startsWith("S") && value_expected.contains("-"))
                            {
                                List<String> mini = new ArrayList<String>();
                                mini.add(value_expected);
                                expectedTable.add(mini);
                            }
                            else
                            {
                                List<String> mini = new ArrayList<String>();
                                for (int col = 1; col <= numberOfCols; col++)
                                {
                                    String cellValue = getColumn_Child(col);
                                    mini.add(cellValue);
                                }
                                expectedTable.add(mini);
                            }
                        }

                        // determine the end of the table region 2 - start writing output to excel
                        if ((empty(value_expected) && startRegion2) || i_child == detailObjArray_Child.length)
                        {
                            endRegion2 = true;
                            // start comparing 2 table regions
                            for (List<String> actualValues : actualTable)
                            {
                                int colIndex = 0; // get column name - colIndex init must be 0 in able to work
                                int lastRow = ExcelUtils.getLastRowNum(output_ComparedResult, sheetName);

                                for (String actualValue : actualValues)
                                {
                                    boolean noMappingCell = false;
                                    String expectedValue = "";
                                    try
                                    {
                                        expectedValue = expectedTable.get(actualTable.indexOf(actualValues)).get(actualValues.indexOf(actualValue));
                                        noMappingCell = false;
                                    } catch (IndexOutOfBoundsException e)
                                    {
                                        expectedFile = "";
                                        noMappingCell = true;
                                    }
                                    ExcelUtils.setCellValue(output_ComparedResult, sheetName, lastRow, colIndex, actualValue);

                                    if (notEmpty(actualValue) && notEmpty(expectedValue))
                                    {
                                        boolean ignored = false;
                                        // ignore checking values if column names belongs to voucher no
                                        String columnName = "";
                                        columnName = columnNamesList.get(colIndex);
                                        if (columnName.contains("VOUCHER_NO") || columnName.contains("_NO"))
                                            ignored = true;
                                        else
                                            ignored = false;

                                        if (!ignored)
                                            if (noMappingCell)
                                            {
                                                // set cell red & comment
                                                ExcelUtils.setCellColor(output_ComparedResult, sheetName, lastRow, colIndex,
                                                                        HSSFColor.LIGHT_YELLOW.index);
                                                ExcelUtils.setCellComment(output_ComparedResult, sheetName, lastRow, colIndex, "Levin",
                                                                          "No mapping value: " + actualValue);
                                            }
                                            else if (actualValue.equalsIgnoreCase(expectedValue))
                                            {
                                                // set cell green
                                                ExcelUtils.setCellColor(output_ComparedResult, sheetName, lastRow, colIndex,
                                                                        HSSFColor.LIGHT_GREEN.index);
                                            }
                                            else
                                            {
                                                // set cell red & comment
                                                ExcelUtils.setCellColor(output_ComparedResult, sheetName, lastRow, colIndex, HSSFColor.RED.index);
                                                ExcelUtils.setCellComment(output_ComparedResult, sheetName, lastRow, colIndex, "Levin",
                                                                          "Expected value: " + expectedValue);

                                                // get column name - colIndex init must be 0 in able to work
                                                //columnName = columnNamesList.get(colIndex);

                                                // sheet name also is the scenario name
                                                String columnName1 = columnNamesList.get(0);
                                                String columnName2 = columnNamesList.get(1);
                                                String columnName3 = columnNamesList.get(2);
                                                String value1 = actualTable.get(actualTable.indexOf(actualValues)).get(0);
                                                String value2 = actualTable.get(actualTable.indexOf(actualValues)).get(1);
                                                String value3 = actualTable.get(actualTable.indexOf(actualValues)).get(2);

                                                String marker = marker_actual + ": " + ", " + columnName1 + ": " + value1 + ", " + columnName2 + ": " + value2 + ", " + columnName3 + ": " + value3;

                                                addRowToTbDataReport(sheetName, scenarioDesc, marker, "Fail",
                                                                     columnName + " - Expected: " + expectedValue + " but return " + actualValue);
                                                fullPass = false;
                                                failedCasesNo += 1;
                                            }
                                    }
                                    colIndex++;
                                }
                            }
                            // write a blank line between the tables
                            int lastRow = ExcelUtils.getLastRowNum(output_ComparedResult, sheetName);
                            ExcelUtils.setCellValue(output_ComparedResult, sheetName, lastRow, 0, "  ");
                        }
                    }
                }
                startRegion = false;
                endRegion = false;

                startRegion2 = false;
                endRegion2 = false;

                actualTable.clear();
                expectedTable.clear();

                columnNamesList.clear();
            }
        }
        // add report if a scenario has passed all cases
        if (fullPass)
            addRowToTbDataReport(sheetName, scenarioDesc, "", "Pass", "");
    }

    public static void addRowToTbDataReport(String header, String desc, String marker, String result, String comment)
    {
        verifyStep = new ArrayList<String>();

        // datatable report
        verifyStep.add(header);
        verifyStep.add(desc);
        verifyStep.add(marker);
        verifyStep.add(result);
        verifyStep.add(comment);
        SessionData.addRowToTbDataReport(reportKey, verifyStep);
    }

    public static String getTableReport(boolean clearTableAfterward)
    {
        String s = "";
        try
        {
            s = SessionData.generateTbDataReport(reportKey);
            if (clearTableAfterward)
                SessionData.clearTbDataReport(reportKey);
        } catch (Exception e)
        {
            return "";
        }
        return s;
    }

    public static String getTableReport(String reportKey, boolean clearTableAfterward)
    {
        String s = "";
        try
        {
            s = SessionData.generateTbDataReport(reportKey);
            if (clearTableAfterward)
                SessionData.clearTbDataReport(reportKey);
        } catch (Exception e)
        {
            return "";
        }
        return s;
    }

    public static String getTableReport_Summary(int failedCasesNo)
    {
        verifyStep = new ArrayList<String>();
        // datatable report
        verifyStep.add("");
        verifyStep.add("Total of failed cases");
        SessionData.addRowToTbDataReport(summaryKey, verifyStep);

        verifyStep = new ArrayList<String>();
        // datatable report
        verifyStep.add("Summary");
        verifyStep.add(failedCasesNo + "");
        SessionData.addRowToTbDataReport(summaryKey, verifyStep);

        return getTableReport(summaryKey, true);
    }
}
