package com.synergix.utilities;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.testng.Assert;

import java.io.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelUtils
{
    private static XSSFSheet        XExcelWSheet;
    private static XSSFWorkbook     XExcelWBook;
    private static XSSFCell         XCell;
    private static XSSFRow          XRow;
    private static FormulaEvaluator evaluator;

    private static HSSFSheet    HExcelWSheet;
    private static HSSFWorkbook HExcelWBook;
    private static HSSFCell     HCell;
    private static HSSFRow      HRow;

    protected static Object[][] tableObjArray;
    protected static int i = 0;                                                                                                                                                                                                                                                                                                                                                                                                                                                        // Row
    protected static int j = 0;                                                                                                                                                                                                                                                                                                                                                                                                                                                        // Column

    public static boolean isSheetExist(String filePath, String sheetName)
    {
        String[][] tabArray = null;
        String[][] tabArrayOpt = null;

        try
        {
            if (filePath.endsWith("xlsx"))
            {
                // DOMConfigurator.configure("log4j.xml");
                FileInputStream ExcelFile = new FileInputStream(filePath);
                // Access the required test data sheet
                XExcelWBook = new XSSFWorkbook(ExcelFile);
                evaluator = XExcelWBook.getCreationHelper().createFormulaEvaluator();
                XExcelWSheet = XExcelWBook.getSheet(sheetName);
            }

            else if (filePath.endsWith("xls"))
            {
                // DOMConfigurator.configure("log4j.xml");
                FileInputStream ExcelFile = new FileInputStream(filePath);
                // Access the required test data sheet
                HExcelWBook = new HSSFWorkbook(ExcelFile);
                evaluator = HExcelWBook.getCreationHelper().createFormulaEvaluator();
                HExcelWSheet = HExcelWBook.getSheet(sheetName);
            }
        } catch (Exception e)
        {
            return false;
        }
        return true;
    }

    public static Object[][] getTableArray(String filePath, String sheetName) throws Exception
    {
        String[][] tabArray = null;
        String[][] tabArrayOpt = null;
        try
        {
            if (filePath.endsWith("xlsx"))
            {
                // DOMConfigurator.configure("log4j.xml");
                FileInputStream ExcelFile = new FileInputStream(filePath);
                // Access the required test data sheet
                XExcelWBook = new XSSFWorkbook(ExcelFile);
                evaluator = XExcelWBook.getCreationHelper().createFormulaEvaluator();
                XExcelWSheet = XExcelWBook.getSheet(sheetName);
                int startRow = 1;// start from row 2
                int startCol = 1;// start from column B
                int ci, cj;
                int totalRows = XExcelWSheet.getLastRowNum();
                int totalCols = getNumberOfColumns(XExcelWSheet) - startCol;// get
                // columns
                // count
                ci = 0;
                getColumnNames(filePath, sheetName);
                totalRows = getNumberOfNotNullRow(totalRows, startRow, "X"); // excludes rows with no name at first column
                tabArray = new String[totalRows][totalCols];
                for (int i = startRow; i <= totalRows; i++, ci++)
                {
                    cj = 0;
                    for (int j = startCol; j <= totalCols; j++, cj++)
                    {
                        try
                        {
                            tabArray[ci][cj] = getCellData(i, j, "X");
                            System.out.print(tabArray[ci][cj] + "|	");
                        } catch (Exception e)
                        {
                            System.out.print("null");
                            System.out.print("|	");
                        }
                    }
                    System.out.println();
                }
            }

            else if (filePath.endsWith("xls"))
            {
                // DOMConfigurator.configure("log4j.xml");
                FileInputStream ExcelFile = new FileInputStream(filePath);
                // Access the required test data sheet
                HExcelWBook = new HSSFWorkbook(ExcelFile);
                evaluator = HExcelWBook.getCreationHelper().createFormulaEvaluator();
                HExcelWSheet = HExcelWBook.getSheet(sheetName);
                int startRow = 1;// start from row 2
                int startCol = 1;// start from column B
                int ci, cj;
                int totalRows = HExcelWSheet.getLastRowNum();
                int totalCols = getNumberOfColumns(HExcelWSheet) - startCol;// get
                // columns
                // count
                ci = 0;
                getColumnNames(filePath, sheetName);
                totalRows = getNumberOfNotNullRow(totalRows, startRow, "H");
                tabArray = new String[totalRows][totalCols];
                for (int i = startRow; i <= totalRows; i++, ci++)
                {
                    cj = 0;
                    for (int j = startCol; j <= totalCols; j++, cj++)
                    {
                        try
                        {
                            tabArray[ci][cj] = getCellData(i, j, "H");
                            System.out.print(tabArray[ci][cj] + "|	");
                        } catch (Exception e)
                        {
                            System.out.print("null");
                            System.out.print("|	");
                        }
                    }
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e)
        {
            System.out.println("Could not read the Excel sheet: " + sheetName + " in " + filePath);
            Assert.fail("Could not read the Excel sheet: " + sheetName + " in " + filePath, e.getCause());
            e.printStackTrace();
        } catch (IOException e)
        {
            System.out.println("Could not read the Excel sheet: " + sheetName + " in " + filePath);
            Assert.fail("Could not read the Excel sheet: " + sheetName + " in " + filePath, e.getCause());
            e.printStackTrace();
        } catch (NullPointerException e)
        {
            // Return null array
        }
        return (tabArray);
    }

    public static Object[][] getTableArray(String filePath, String sheetName, boolean getFirstCol, boolean getFirstRow) throws Exception
    {
        String[][] tabArray = null;
        String[][] tabArrayOpt = null;
        try
        {
            int firstRow = 0; // start from row 1
            int firstCol = 0; // start from column A

            if (!getFirstCol && !getFirstRow)
                return getTableArray(filePath, sheetName);

            if (!getFirstCol)
                firstCol = 1; // start from row 2
            if (!getFirstRow)
                firstRow = 1; // start from column B

            if (filePath.endsWith("xlsx"))
            {
                // DOMConfigurator.configure("log4j.xml");
                FileInputStream ExcelFile = new FileInputStream(filePath);
                // Access the required test data sheet
                XExcelWBook = new XSSFWorkbook(ExcelFile);
                evaluator = XExcelWBook.getCreationHelper().createFormulaEvaluator();
                XExcelWSheet = XExcelWBook.getSheet(sheetName);
                int startRow = firstRow;
                int startCol = firstCol;
                int ci, cj;
                int totalRows = XExcelWSheet.getLastRowNum() + 1 - firstRow;
                int totalCols = getNumberOfColumns(XExcelWSheet) - firstCol;
                ci = 0;
                // getColumnNames(filePath, sheetName);
                // totalRows = getNumberOfNotNullRow(totalRows, startRow); // no
                // need cuz detail sheet does not need header column
                tabArray = new String[totalRows][totalCols];
                for (int i = startRow; i <= totalRows; i++, ci++)
                {
                    cj = 0;
                    for (int j = startCol; j <= totalCols; j++, cj++)
                    {
                        try
                        {
                            tabArray[ci][cj] = getCellData(i, j, "X");
                            System.out.print(tabArray[ci][cj] + "|	");
                        } catch (Exception e)
                        {
                            System.out.print("null");
                            System.out.print("|	");
                        }
                    }
                    System.out.println();
                }
            }

            else if (filePath.endsWith("xls"))
            {
                // DOMConfigurator.configure("log4j.xml");
                FileInputStream ExcelFile = new FileInputStream(filePath);
                // Access the required test data sheet
                HExcelWBook = new HSSFWorkbook(ExcelFile);
                evaluator = HExcelWBook.getCreationHelper().createFormulaEvaluator();
                HExcelWSheet = HExcelWBook.getSheet(sheetName);
                int startRow = firstRow;
                int startCol = firstCol;
                int ci, cj;
                int totalRows = HExcelWSheet.getLastRowNum() + 1 - firstRow;// to get the
                // last row
                int totalCols = getNumberOfColumns(HExcelWSheet) - firstCol;
                //HExcelWSheet.getRow(5).getLastCellNum() + 1 - firstCol;// get

                // columns
                // count,
                // not
                // ExcelWSheet.getRow(0).getLastCellNum()
                // - 1
                // to
                // get
                // the
                // last
                // column
                ci = 0;
                // getColumnNames(filePath, sheetName);
                // totalRows = getNumberOfNotNullRow(totalRows, startRow); // no
                // need cuz detail sheet does not need header column
                tabArray = new String[totalRows][totalCols];
                for (int i = startRow; i <= totalRows; i++, ci++)
                {
                    cj = 0;
                    for (int j = startCol; j <= totalCols; j++, cj++)
                    {
                        try
                        {
                            tabArray[ci][cj] = getCellData(i, j, "H");
                            System.out.print(tabArray[ci][cj] + "|	");
                        } catch (Exception e)
                        {
                            System.out.print("null");
                            System.out.print("|	");
                        }
                    }
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e)
        {
            System.out.println("Could not read the Excel sheet: " + sheetName + " in " + filePath);
            Assert.fail("Could not read the Excel sheet: " + sheetName + " in " + filePath, e.getCause());
            e.printStackTrace();
        } catch (IOException e)
        {
            System.out.println("Could not read the Excel sheet: " + sheetName + " in " + filePath);
            Assert.fail("Could not read the Excel sheet: " + sheetName + " in " + filePath, e.getCause());
            e.printStackTrace();
        }
        return (tabArray);
    }

    public static Object[][] getColumnNames(String filePath, String sheetName) throws Exception
    {
        String[][] tabArray = null;
        try
        {
            if (filePath.endsWith("xlsx"))
            {
                // DOMConfigurator.configure("log4j.xml");
                FileInputStream ExcelFile = new FileInputStream(filePath);
                // Access the required test data sheet
                XExcelWBook = new XSSFWorkbook(ExcelFile);
                evaluator = XExcelWBook.getCreationHelper().createFormulaEvaluator();
                XExcelWSheet = XExcelWBook.getSheet(sheetName);
                int startRow = 0;// start from row 1
                int startCol = 1;// start from column B
                int ci, cj;
                int totalRows = 1;
                int totalCols = getNumberOfColumns(XExcelWSheet) - startCol;// get
                // columns
                // count
                tabArray = new String[totalRows][totalCols];
                ci = 0;
                for (int i = startRow; i < totalRows; i++, ci++)
                {
                    cj = 0;
                    for (int j = startCol; j <= totalCols; j++, cj++)
                    {
                        try
                        {
                            tabArray[ci][cj] = getCellData(i, j, "X");
                            System.out.print(tabArray[ci][cj] + "|	");
                        } catch (Exception e)
                        {
                            System.out.print("null");
                            System.out.print("|	");
                        }
                    }
                    System.out.println();
                }
            }
            else if (filePath.endsWith("xls"))
            {
                // DOMConfigurator.configure("log4j.xml");
                FileInputStream ExcelFile = new FileInputStream(filePath);
                // Access the required test data sheet
                HExcelWBook = new HSSFWorkbook(ExcelFile);
                evaluator = HExcelWBook.getCreationHelper().createFormulaEvaluator();
                HExcelWSheet = HExcelWBook.getSheet(sheetName);
                int startRow = 0;// start from row 1
                int startCol = 1;// start from column B
                int ci, cj;
                int totalRows = 1;
                int totalCols = getNumberOfColumns(HExcelWSheet) - startCol;// get
                // columns
                // count
                tabArray = new String[totalRows][totalCols];
                ci = 0;
                for (int i = startRow; i < totalRows; i++, ci++)
                {
                    cj = 0;
                    for (int j = startCol; j <= totalCols; j++, cj++)
                    {
                        try
                        {
                            tabArray[ci][cj] = getCellData(i, j, "H");
                            System.out.print(tabArray[ci][cj] + "|	");
                        } catch (Exception e)
                        {
                            System.out.print("null");
                            System.out.print("|	");
                        }
                    }
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e)
        {
            System.out.println("Could not read the Excel sheet: " + sheetName + " in " + filePath);
            Assert.fail("Could not read the Excel sheet: " + sheetName + " in " + filePath, e.getCause());
            e.printStackTrace();
        } catch (IOException e)
        {
            System.out.println("Could not read the Excel sheet: " + sheetName + " in " + filePath);
            Assert.fail("Could not read the Excel sheet: " + sheetName + " in " + filePath, e.getCause());
            e.printStackTrace();
        }
        return (tabArray);
    }

    public static Object[][] getTableArray(String filePath, String sheetName, int startColNo, int endColNo) throws Exception
    {
        String[][] tabArray = null;
        String[][] tabArrayOpt = null;
        try
        {
            if (filePath.endsWith("xlsx"))
            {
                // DOMConfigurator.configure("log4j.xml");
                FileInputStream ExcelFile = new FileInputStream(filePath);
                // Access the required test data sheet
                XExcelWBook = new XSSFWorkbook(ExcelFile);
                evaluator = XExcelWBook.getCreationHelper().createFormulaEvaluator();
                XExcelWSheet = XExcelWBook.getSheet(sheetName);
                int startRow = 1;// start from row 2
                int startCol = startColNo - 1;
                int ci, cj;
                int totalRows = XExcelWSheet.getLastRowNum();
                int totalCols = endColNo - 1;// get
                // columns
                // count
                ci = 0;
                getColumnNames(filePath, sheetName);
                totalRows = getNumberOfNotNullRow(totalRows, startRow, "X");
                tabArray = new String[totalRows][totalCols];
                for (int i = startRow; i <= totalRows; i++, ci++)
                {
                    cj = 0;
                    for (int j = startCol; j <= totalCols; j++, cj++)
                    {
                        try
                        {
                            tabArray[ci][cj] = getCellData(i, j, "X");
                            System.out.print(tabArray[ci][cj] + "|	");
                        } catch (Exception e)
                        {
                            System.out.print("null");
                            System.out.print("|	");
                        }
                    }
                    System.out.println();
                }
            }

            else if (filePath.endsWith("xls"))
            {
                // DOMConfigurator.configure("log4j.xml");
                FileInputStream ExcelFile = new FileInputStream(filePath);
                // Access the required test data sheet
                HExcelWBook = new HSSFWorkbook(ExcelFile);
                evaluator = HExcelWBook.getCreationHelper().createFormulaEvaluator();
                HExcelWSheet = HExcelWBook.getSheet(sheetName);
                int startRow = 1;// start from row 2
                int startCol = startColNo - 1;
                int ci, cj;
                int totalRows = HExcelWSheet.getLastRowNum();
                int totalCols = endColNo - 1;// get
                // columns
                // count
                ci = 0;
                getColumnNames(filePath, sheetName);
                totalRows = getNumberOfNotNullRow(totalRows, startRow, "H");
                tabArray = new String[totalRows][totalCols];
                for (int i = startRow; i <= totalRows; i++, ci++)
                {
                    cj = 0;
                    for (int j = startCol; j <= totalCols; j++, cj++)
                    {
                        try
                        {
                            tabArray[ci][cj] = getCellData(i, j, "H");
                            System.out.print(tabArray[ci][cj] + "|	");
                        } catch (Exception e)
                        {
                            System.out.print("null");
                            System.out.print("|	");
                        }
                    }
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e)
        {
            System.out.println("Could not read the Excel sheet: " + sheetName + " in " + filePath);
            Assert.fail("Could not read the Excel sheet: " + sheetName + " in " + filePath, e.getCause());
            e.printStackTrace();
        } catch (IOException e)
        {
            System.out.println("Could not read the Excel sheet: " + sheetName + " in " + filePath);
            Assert.fail("Could not read the Excel sheet: " + sheetName + " in " + filePath, e.getCause());
            e.printStackTrace();
        } catch (NullPointerException e)
        {
            // Return null array
        }
        return (tabArray);
    }

    private static String getCellData(int rowNum, int colNum, String type) throws Exception
    {
        try
        {
            if (type.equalsIgnoreCase("X"))
            {
                String CellData = "";
                XCell = XExcelWSheet.getRow(rowNum).getCell(colNum);
                int dataType = XCell.getCellType();
                if (dataType == XCell.CELL_TYPE_BLANK)
                {// blank
                    return "";
                }
                else
                {
                    XCell.setCellType(XCell.CELL_TYPE_STRING);// cast all type
                    // to string
                    CellData = XCell.getRichStringCellValue().getString();
                    // if (dataType == Cell.CELL_TYPE_BOOLEAN) {
                    // CellData = Boolean.toString(Cell.getBooleanCellValue());
                    // }
                    //
                    // // Cell value is a number
                    // if (dataType == Cell.CELL_TYPE_NUMERIC) {
                    // if (dataType == Cell.CELL_TYPE_NUMERIC) {
                    // // Cell value is a date time
                    // try {
                    // if (DateUtil.isCellDateFormatted(Cell)) {
                    // CellData =
                    // DateFormatUtils.format(Cell.getDateCellValue(),
                    // "DD/MM/YYYY");
                    // }
                    // else {
                    // CellData = Cell.getNumericCellValue() + "";
                    // }
                    //
                    // } catch (Exception e) {
                    // }
                    // }
                    // }
                    //
                    // // Cell value is a string
                    // if (dataType == Cell.CELL_TYPE_STRING) {
                    // CellData = Cell.getStringCellValue();
                    // }
                    // if (dataType == Cell.CELL_TYPE_ERROR) {
                    // System.out.println(Cell.getErrorCellValue());
                    // }
                    // if (dataType == Cell.CELL_TYPE_FORMULA) {
                    // }
                }
                return CellData;
            }
            else if (type.equalsIgnoreCase("H"))
            {
                String CellData = "";
                HCell = HExcelWSheet.getRow(rowNum).getCell(colNum);
                int dataType = HCell.getCellType();
                if (dataType == HCell.CELL_TYPE_BLANK)
                {// blank
                    return "";
                }
                else
                {
                    HCell.setCellType(HCell.CELL_TYPE_STRING);// cast all type
                    // to string
                    CellData = HCell.getRichStringCellValue().getString();
                }
                return CellData;
            }
        } catch (Exception e)
        {
            return "";
        }
        return "";
    }

    // get the first column in row which has the rowName
    public static String getCellData(String FilePath, String SheetName, String rowName)
    {
        String cellData = "";
        try
        {
            if (FilePath.endsWith("xlsx"))
            {
                FileInputStream ExcelFile = new FileInputStream(FilePath);
                // Access the required test data sheet
                XExcelWBook = new XSSFWorkbook(ExcelFile);
                evaluator = XExcelWBook.getCreationHelper().createFormulaEvaluator();
                XExcelWSheet = XExcelWBook.getSheet(SheetName);
                int startRow = 1;// start from row 2
                int startCol = 0;// start from column A
                int ci, cj;
                int totalRows = XExcelWSheet.getLastRowNum();
                int totalCols = getNumberOfColumns(XExcelWSheet) - 1;// get
                // columns
                // count
                ci = 0;
                for (int i = startRow; i <= totalRows; i++, ci++)
                {
                    cj = 0;
                    try
                    {
                        if (getCellData(i, 0, "X").equals(rowName))
                        {
                            cellData = getCellData(i, 1, "X");
                            System.out.println();
                            System.out.print(getCellData(i, 0, "X") + "|	");
                            System.out.print(getCellData(i, 1, "X") + "|	");
                            return cellData;
                        }
                    } catch (Exception e)
                    {
                        System.out.print(e.getMessage());
                        cellData = "";
                    }
                }
            }

            else if (FilePath.equalsIgnoreCase("xls"))
            {
                FileInputStream ExcelFile = new FileInputStream(FilePath);
                // Access the required test data sheet
                HExcelWBook = new HSSFWorkbook(ExcelFile);
                evaluator = HExcelWBook.getCreationHelper().createFormulaEvaluator();
                HExcelWSheet = HExcelWBook.getSheet(SheetName);
                int startRow = 1;// start from row 2
                int startCol = 0;// start from column A
                int ci, cj;
                int totalRows = HExcelWSheet.getLastRowNum();
                int totalCols = getNumberOfColumns(HExcelWSheet) - 1;// get
                // columns
                // count
                ci = 0;
                for (int i = startRow; i <= totalRows; i++, ci++)
                {
                    cj = 0;
                    try
                    {
                        if (getCellData(i, 0, "H").equals(rowName))
                        {
                            cellData = getCellData(i, 1, "H");
                            System.out.println();
                            System.out.print(getCellData(i, 0, "H") + "|	");
                            System.out.print(getCellData(i, 1, "H") + "|	");
                            return cellData;
                        }
                    } catch (Exception e)
                    {
                        System.out.print(e.getMessage());
                        cellData = "";
                    }
                }
            }
        } catch (FileNotFoundException e)
        {
            System.out.println("Could not read the Excel sheet: " + SheetName + " in " + FilePath);
            Assert.fail("Could not read the Excel sheet: " + SheetName + " in " + FilePath, e.getCause());
            e.printStackTrace();
        } catch (IOException e)
        {
            System.out.println("Could not read the Excel sheet: " + SheetName + " in " + FilePath);
            Assert.fail("Could not read the Excel sheet: " + SheetName + " in " + FilePath, e.getCause());
            e.printStackTrace();
        }
        return (cellData);
    }

    public static int getNumberOfNotNullRow(int totalRows, int startRow, String type)
    {
        int realRow = 0;
        if (startRow == 0)
        {
            realRow += 1;
        }
        for (int i = 1; i <= totalRows; i++)
        {// i = 0 indicates counting from
            // column A
            try
            {
                if (!getCellData(i, 0, type).equals(""))
                {// check the column A
                    // (header) to
                    // determine if a
                    // datarow exists
                    realRow += 1;
                }
            } catch (Exception e)
            {
            }
        }
        return realRow;
    }

    public static String getCell(Object[][] array, int i, int j)
    {
        try
        {
            String cell = array[i - 1][j - 1].toString();
            System.out.println("Cell value: " + cell);
            return cell;
        } catch (Exception e)
        {
            return "";
        }
    }

    /**
     * Get excel column index based on column name
     *
     * @author levin
     */
    public int getColumnIndex(Object[][] tableObjArray, String columnName, boolean allCellTable)
    {
        if (allCellTable)
        {// only for all-cell table object
            int index = 0;
            try
            {
                for (int a = 0; a < tableObjArray[0].length; a++)
                {
                    if (tableObjArray[0][a].toString().equals(columnName))
                    {
                        index = a + 1;
                        System.out.println("Column index: " + (a + 1));
                        return index;
                    }
                }
            } catch (Exception e)
            {
            }
            return index;
        }
        else // for only-data table array (without column A and row 1
        {
            for (int i = 0; i < tableObjArray.length; i++)
            {
                if (tableObjArray[0][i].toString().equals(columnName))
                {
                    System.out.println("Column index: " + i);
                    return i;
                }
            }
            return 0;
        }
    }

    public static void createExcelFile(String filePath, String sheetName)
    {
        try
        {
            if (filePath.endsWith("xlsx"))
            {
                FileInputStream fis = new FileInputStream(new File(filePath));
                XSSFWorkbook wb = new XSSFWorkbook(fis);
                XSSFSheet sheet = wb.getSheet(sheetName);
                if (sheet == null)
                {
                    sheet = wb.createSheet(sheetName);
                }
                FileOutputStream fos = new FileOutputStream(filePath);
                wb.write(fos);
                wb.close();
                fos.close();
                System.out.println(filePath + " already exists");
                System.out.println(sheetName + " created succesfully");
                wb.close();
            }

            else if (filePath.endsWith("xls"))
            {
                FileInputStream fis = new FileInputStream(new File(filePath));
                HSSFWorkbook wb = new HSSFWorkbook(fis);
                HSSFSheet sheet = wb.getSheet(sheetName);
                if (sheet == null)
                {
                    sheet = wb.createSheet(sheetName);
                }
                FileOutputStream fos = new FileOutputStream(filePath);
                wb.write(fos);
                wb.close();
                fos.close();
                System.out.println(filePath + " already exists");
                System.out.println(sheetName + " created succesfully");
                wb.close();
            }
        } catch (FileNotFoundException e)
        {
            if (filePath.endsWith("xlsx"))
            {
                XSSFWorkbook wb = new XSSFWorkbook();
                XSSFSheet sheet = wb.createSheet(sheetName);

                FileOutputStream fos;
                try
                {
                    fos = new FileOutputStream(filePath);
                    wb.write(fos);
                    wb.close();
                    fos.close();
                    System.out.println(filePath + " created succesfully");
                } catch (FileNotFoundException e1)
                {
                    e1.printStackTrace();
                } catch (IOException e1)
                {
                    e1.printStackTrace();
                }
            }

            else if (filePath.endsWith("xls"))
            {
                HSSFWorkbook wb = new HSSFWorkbook();
                HSSFSheet sheet = wb.createSheet(sheetName);

                FileOutputStream fos;
                try
                {
                    fos = new FileOutputStream(filePath);
                    wb.write(fos);
                    wb.close();
                    fos.close();
                    System.out.println(filePath + " created succesfully");
                } catch (FileNotFoundException e1)
                {
                    e1.printStackTrace();
                } catch (IOException e1)
                {
                    e1.printStackTrace();
                }
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void writeToExel(String filePath, String sheetName, String value, int rowIndex, int colIndex)
    {
        try
        {
            if (filePath.endsWith("xlsx"))
            {
                FileInputStream fis = new FileInputStream(new File(filePath));
                XSSFWorkbook wb = new XSSFWorkbook(fis);
                XSSFSheet sheet = wb.getSheet(sheetName);

                XSSFRow row = null;
                try
                {
                    row = sheet.getRow(rowIndex);
                    if (row == null)
                    {
                        row = sheet.createRow(rowIndex);
                    }
                } catch (Exception e)
                {
                    row = sheet.createRow(rowIndex);
                }

                XSSFCell cell = row.createCell(colIndex);

                cell.setCellValue(value);

                FileOutputStream fos = new FileOutputStream(filePath);
                wb.write(fos);
                wb.close();
                fos.close();

                System.out.println("Written to " + filePath + " value " + value + " at cell " + rowIndex + ", " + colIndex);
            }
            else if (filePath.endsWith("xls"))
            {
                FileInputStream fis = new FileInputStream(new File(filePath));
                HSSFWorkbook wb = new HSSFWorkbook(fis);
                HSSFSheet sheet = wb.getSheet(sheetName);

                HSSFRow row = null;
                try
                {
                    row = sheet.getRow(rowIndex);
                    if (row == null)
                    {
                        row = sheet.createRow(rowIndex);
                    }
                } catch (Exception e)
                {
                    row = sheet.createRow(rowIndex);
                }

                HSSFCell cell = row.createCell(colIndex);

                cell.setCellValue(value);

                FileOutputStream fos = new FileOutputStream(filePath);
                wb.write(fos);
                wb.close();
                fos.close();

                System.out.println("Written to " + filePath + " value " + value + " at cell " + rowIndex + ", " + colIndex);
            }
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void writeToExel(String filePath, String sheetName, List<List<String>> dataTable)
    {
        try
        {
            if (filePath.endsWith("xlsx"))
            {
                FileInputStream fis = new FileInputStream(new File(filePath));
                XSSFWorkbook wb = new XSSFWorkbook(fis);
                XSSFSheet sheet = wb.getSheet(sheetName);
                if (sheet == null)
                {
                    sheet = wb.createSheet(sheetName);
                }
                int rowIndex = getLastRowNum(filePath, sheetName);
                int cellNo = 0;
                for (List<String> rows : dataTable)
                {
                    XSSFRow row = sheet.createRow(rowIndex);
                    cellNo = 0;
                    for (String value : rows)
                    {
                        if (ReadBean.isNumber(value))
                            value = ReadBean.round(value, 2);
                        row.createCell(cellNo).setCellValue(value);
                        cellNo++;
                    }
                    rowIndex++;
                }
                FileOutputStream fos = new FileOutputStream(filePath);
                wb.write(fos);
                wb.close();
                fos.close();
                System.out.println("Written to Excel Succesfully: " + sheetName);
            }
            else if (filePath.endsWith("xls"))
            {
                FileInputStream fis = new FileInputStream(new File(filePath));
                HSSFWorkbook wb = new HSSFWorkbook(fis);
                HSSFSheet sheet = wb.getSheet(sheetName);
                if (sheet == null)
                {
                    sheet = wb.createSheet(sheetName);
                }
                int rowIndex = getLastRowNum(filePath, sheetName);
                int cellNo = 0;
                for (List<String> rows : dataTable)
                {
                    HSSFRow row = sheet.createRow(rowIndex);
                    cellNo = 0;
                    for (String value : rows)
                    {
                        if (ReadBean.isNumber(value))
                            value = ReadBean.round(value, 2);
                        row.createCell(cellNo).setCellValue(value);
                        cellNo++;
                    }
                    rowIndex++;
                }
                FileOutputStream fos = new FileOutputStream(filePath);
                wb.write(fos);
                wb.close();
                fos.close();
                System.out.println("Written to Excel Succesfully: " + sheetName);
            }
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void createCells(String sheetName, ResultSet rs, XSSFRow rowhead, XSSFWorkbook wb)
    {
        try
        {
            XSSFSheet sheet = wb.createSheet(sheetName);
            rowhead = sheet.createRow(0);
            ResultSetMetaData rsmd;
            rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            int i = 0;
            for (int j = 1; j < columnCount + 1; j++)
            {
                rowhead.createCell(i).setCellValue(rsmd.getColumnName(j));
                i++;
            }
            for (int j = 1; j < columnCount + 1; j++)
            {
                rowhead.createCell(i).setCellValue(rsmd.getColumnName(j) + " - EXPECTED");
                i++;
            }
            int index = 1;
            int cellNo = 0;
            int columnNo = 1;// for get column in db
            while (rs.next())
            {
                XSSFRow row = sheet.createRow(index);
                columnNo = 1;
                cellNo = 0;
                for (int j = 1; j < columnCount + 1; j++)
                {
                    row.createCell(cellNo).setCellValue(rs.getString(columnNo));
                    cellNo++;
                    columnNo++;
                }
                for (int j = 1; j < columnCount + 1; j++)
                {
                    row.createCell(cellNo).setCellValue("");
                    cellNo++;
                }
                index++;
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void createCells(String sheetName, ResultSet rs, HSSFRow rowhead, HSSFWorkbook wb)
    {
        try
        {
            HSSFSheet sheet = wb.createSheet(sheetName);
            rowhead = sheet.createRow(0);
            ResultSetMetaData rsmd;
            rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            int i = 0;
            for (int j = 1; j < columnCount + 1; j++)
            {
                rowhead.createCell(i).setCellValue(rsmd.getColumnName(j));
                i++;
            }
            for (int j = 1; j < columnCount + 1; j++)
            {
                rowhead.createCell(i).setCellValue(rsmd.getColumnName(j) + " - EXPECTED");
                i++;
            }
            int index = 1;
            int cellNo = 0;
            int columnNo = 1;// for get column in db
            while (rs.next())
            {
                HSSFRow row = sheet.createRow(index);
                columnNo = 1;
                cellNo = 0;
                for (int j = 1; j < columnCount + 1; j++)
                {
                    row.createCell(cellNo).setCellValue(rs.getString(columnNo));
                    cellNo++;
                    columnNo++;
                }
                for (int j = 1; j < columnCount + 1; j++)
                {
                    row.createCell(cellNo).setCellValue("");
                    cellNo++;
                }
                index++;
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void createExistingColumns(String filePath, String sheetName, ResultSet rs)
    {
        createExistingColumns(filePath, sheetName, rs, 0);
    }

    public static void createExistingColumns(String filePath, String sheetName, ResultSet rs, int rowIndex)
    {
        try
        {
            if (filePath.endsWith("xlsx"))
            {
                FileInputStream fis = new FileInputStream(new File(filePath));
                XSSFWorkbook wb = new XSSFWorkbook(fis);
                XSSFSheet sheet = wb.getSheet(sheetName);
                if (sheet == null)
                {
                    sheet = wb.createSheet(sheetName);
                }
                XSSFRow rowhead = sheet.createRow(rowIndex);
                ResultSetMetaData rsmd;
                rsmd = rs.getMetaData();
                int columnCount = rsmd.getColumnCount();
                int i = 0;
                for (int j = 1; j < columnCount + 1; j++)
                {
                    rowhead.createCell(i).setCellValue(rsmd.getColumnName(j));
                    i++;
                }

                // expected columns - no need now
                //				for (int j = 1; j < columnCount + 1; j++)
                //				{
                //					rowhead.createCell(i).setCellValue(rsmd.getColumnName(j) + " - EXPECTED");
                //					i++;
                //				}

                FileOutputStream fos = new FileOutputStream(filePath);
                wb.write(fos);
                wb.close();
                fos.close();
                System.out.println("Written to Excel Succesfully: " + sheetName);
            }
            else if (filePath.endsWith("xls"))
            {
                FileInputStream fis = new FileInputStream(new File(filePath));
                HSSFWorkbook wb = new HSSFWorkbook(fis);
                HSSFSheet sheet = wb.getSheet(sheetName);
                if (sheet == null)
                {
                    sheet = wb.createSheet(sheetName);
                }
                HSSFRow rowhead = sheet.createRow(rowIndex);
                ResultSetMetaData rsmd;
                rsmd = rs.getMetaData();
                int columnCount = rsmd.getColumnCount();
                int i = 0;
                for (int j = 1; j < columnCount + 1; j++)
                {
                    rowhead.createCell(i).setCellValue(rsmd.getColumnName(j));
                    i++;
                }
                // expected columns - no need now
                //				for (int j = 1; j < columnCount + 1; j++)
                //				{
                //					rowhead.createCell(i).setCellValue(rsmd.getColumnName(j) + " - EXPECTED");
                //					i++;
                //				}
                FileOutputStream fos = new FileOutputStream(filePath);
                wb.write(fos);
                wb.close();
                fos.close();
                System.out.println("Written to Excel Succesfully: " + sheetName);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void createExistingCells(String filePath, String sheetName, ResultSet rs)
    {
        int lastRow = getLastRowNum(filePath, sheetName);
        createExistingCells(filePath, sheetName, rs, lastRow);
    }

    public static void createExistingCells(String filePath, String sheetName, ResultSet rs, int rowIndex)
    {
        try
        {
            if (filePath.endsWith("xlsx"))
            {
                FileInputStream fis = new FileInputStream(new File(filePath));
                XSSFWorkbook wb = new XSSFWorkbook(fis);
                XSSFSheet sheet = wb.getSheet(sheetName);
                if (sheet == null)
                {
                    sheet = wb.createSheet(sheetName);
                }
                ResultSetMetaData rsmd;
                rsmd = rs.getMetaData();
                int columnCount = rsmd.getColumnCount();
                rowIndex += 1;
                int cellNo = 0;
                int columnNo = 1;// for get column in db
                while (rs.next())
                {
                    XSSFRow row = sheet.createRow(rowIndex);
                    columnNo = 1;
                    cellNo = 0;
                    for (int j = 1; j < columnCount + 1; j++)
                    {
                        // String cellValue =
                        // ReadBean.decodeBase64(rs.getString(columnNo));
                        String value = rs.getString(columnNo);
                        if (ReadBean.isNumber(value))
                        {
                            value = ReadBean.round(value, 2);
                        }
                        row.createCell(cellNo).setCellValue(value);
                        cellNo++;
                        columnNo++;
                    }
                    rowIndex++;
                }
                FileOutputStream fos = new FileOutputStream(filePath);
                wb.write(fos);
                wb.close();
                fos.close();
                System.out.println("Written to Excel Succesfully: " + sheetName);
            }
            else if (filePath.endsWith("xls"))
            {
                FileInputStream fis = new FileInputStream(new File(filePath));
                HSSFWorkbook wb = new HSSFWorkbook(fis);
                HSSFSheet sheet = wb.getSheet(sheetName);
                if (sheet == null)
                {
                    sheet = wb.createSheet(sheetName);
                }
                ResultSetMetaData rsmd;
                rsmd = rs.getMetaData();
                int columnCount = rsmd.getColumnCount();
                rowIndex += 1;
                int cellNo = 0;
                int columnNo = 1;// for get column in db
                while (rs.next())
                {
                    HSSFRow row = sheet.createRow(rowIndex);
                    columnNo = 1;
                    cellNo = 0;
                    for (int j = 1; j < columnCount + 1; j++)
                    {
                        // String cellValue =
                        // ReadBean.decodeBase64(rs.getString(columnNo));
                        String value = rs.getString(columnNo);
                        if (ReadBean.isNumber(value))
                        {
                            value = ReadBean.round(value, 2);
                        }
                        row.createCell(cellNo).setCellValue(value);
                        cellNo++;
                        columnNo++;
                    }
                    rowIndex++;
                }
                FileOutputStream fos = new FileOutputStream(filePath);
                wb.write(fos);
                wb.close();
                fos.close();
                System.out.println("Written to Excel Succesfully: " + sheetName);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void createExistingCells(String sheetName, ResultSet rs, HSSFWorkbook wb)
    {
        try
        {
            HSSFSheet sheet = wb.getSheet(sheetName);
            if (sheet == null)
            {
                sheet = wb.createSheet(sheetName);
            }
            ResultSetMetaData rsmd;
            rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            int index = sheet.getLastRowNum() + 1;
            int cellNo = 0;
            int columnNo = 1;// for get column in db
            while (rs.next())
            {
                HSSFRow row = sheet.createRow(index);
                columnNo = 1;
                cellNo = 0;
                for (int j = 1; j < columnCount + 1; j++)
                {
                    String value = rs.getString(columnNo);
                    if (ReadBean.isNumber(value))
                    {
                        value = ReadBean.round(value, 2);
                    }
                    row.createCell(cellNo).setCellValue(value);
                    cellNo++;
                    columnNo++;
                }
                index++;
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static int getColumnCount(String filePath, String sheetName)
    {
        try
        {
            if (filePath.endsWith("xlsx"))
            {
                // DOMConfigurator.configure("log4j.xml");
                FileInputStream ExcelFile = new FileInputStream(new File(filePath));
                // Access the required test data sheet
                XExcelWBook = new XSSFWorkbook(ExcelFile);
                evaluator = XExcelWBook.getCreationHelper().createFormulaEvaluator();
                XExcelWSheet = XExcelWBook.getSheet(sheetName);
                int startCol = 0;// start from column B
                int totalRows = XExcelWSheet.getLastRowNum();
                int totalCols = getNumberOfColumns(XExcelWSheet);
                // columns
                // count
                System.out.println("Total columns: " + totalCols);
                return totalCols;
            }
            else if (filePath.endsWith("xls"))
            {
                // DOMConfigurator.configure("log4j.xml");
                FileInputStream ExcelFile = new FileInputStream(new File(filePath));
                // Access the required test data sheet
                HExcelWBook = new HSSFWorkbook(ExcelFile);
                evaluator = HExcelWBook.getCreationHelper().createFormulaEvaluator();
                HExcelWSheet = HExcelWBook.getSheet(sheetName);
                int startCol = 0;// start from column B
                int totalRows = HExcelWSheet.getLastRowNum();
                int totalCols = getNumberOfColumns(HExcelWSheet);
                // columns
                // count
                System.out.println("Total columns: " + totalCols);
                return totalCols;
            }
        } catch (FileNotFoundException e)
        {
            System.out.println("Could not read the Excel sheet: " + sheetName + " in " + filePath);
            Assert.fail("Could not read the Excel sheet: " + sheetName + " in " + filePath, e.getCause());
            e.printStackTrace();
        } catch (IOException e)
        {
            System.out.println("Could not read the Excel sheet: " + sheetName + " in " + filePath);
            Assert.fail("Could not read the Excel sheet: " + sheetName + " in " + filePath, e.getCause());
            e.printStackTrace();
        } catch (NullPointerException e)
        {
            // Return null array
        }
        return 0;
    }

    /**
     * Set color to a cell background
     *
     * @param color  HSSFColor.RED.index
     * @author Levin
     */

// http://stackoverflow.com/questions/10912578/apache-poi-xssfcolor-from-hex-code
    static XSSFCellStyle xStyle = null;
    static HSSFCellStyle hStyle = null;

    public static void setCellColor(String filePath, String sheetName, int rowIndex, int colIndex, short hssfColorIndex)
    {
        try
        {
            if (filePath.endsWith("xlsx"))
            {
                FileInputStream fis = new FileInputStream(new File(filePath));
                XSSFWorkbook wb = new XSSFWorkbook(fis);
                XSSFSheet sheet = wb.getSheet(sheetName);
                XSSFRow row = sheet.getRow(rowIndex);
                XSSFCell cell = row.getCell(colIndex);

                xStyle = wb.createCellStyle();
                xStyle.setFillForegroundColor(hssfColorIndex); // xStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
                xStyle.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);

                cell.setCellStyle(xStyle);

                System.out.println("Set cell style at " + rowIndex + ", " + colIndex + ": " + cell.getStringCellValue());

                // save with the default palette
                FileOutputStream out = new FileOutputStream(filePath);
                wb.write(out);
                out.close();
                wb.close();
            }
            else if (filePath.endsWith("xls"))
            {

                FileInputStream fis = new FileInputStream(new File(filePath));
                HSSFWorkbook wb = new HSSFWorkbook(fis);
                HSSFSheet sheet = wb.getSheet(sheetName);
                HSSFRow row = sheet.getRow(rowIndex);
                HSSFCell cell = row.getCell(colIndex);

                hStyle = wb.createCellStyle();
                hStyle.setFillForegroundColor(hssfColorIndex);
                hStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

                cell.setCellStyle(hStyle);

                HSSFOptimiser.optimiseCellStyles(wb);// to prevent Maximum
                // number of cell styles
                // was exceeded
                // exception
                System.out.println("Set cell style at " + rowIndex + ", " + colIndex + ": " + cell.getStringCellValue());

                // save with the default palette
                FileOutputStream out = new FileOutputStream(filePath);
                wb.write(out);
                out.close();
                wb.close();
            }
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void setCellValue(String filePath, String sheetName, int rowIndex, int colIndex, String value)
    {
        try
        {
            if (filePath.endsWith("xlsx"))
            {
                FileInputStream fis = new FileInputStream(new File(filePath));
                XSSFWorkbook wb = new XSSFWorkbook(fis);
                XSSFSheet sheet = wb.getSheet(sheetName);
                XSSFRow row = sheet.getRow(rowIndex);
                XSSFCell cell;

                if (row == null)
                    row = sheet.createRow(rowIndex);
                cell = row.getCell(colIndex);
                if (cell == null)
                    cell = row.createCell(colIndex);

                cell.setCellValue(value);

                System.out.println("Set cell style at " + rowIndex + ", " + colIndex + ": " + cell.getStringCellValue());

                // save with the default palette
                FileOutputStream out = new FileOutputStream(filePath);
                wb.write(out);
                out.close();
                wb.close();
            }
            else if (filePath.endsWith("xls"))
            {
                FileInputStream fis = new FileInputStream(new File(filePath));
                HSSFWorkbook wb = new HSSFWorkbook(fis);
                HSSFSheet sheet = wb.getSheet(sheetName);
                HSSFRow row = sheet.getRow(rowIndex);
                HSSFCell cell;

                if (row == null)
                    row = sheet.createRow(rowIndex);
                cell = row.getCell(colIndex);
                if (cell == null)
                    cell = row.createCell(colIndex);

                cell.setCellValue(value);

                System.out.println("Set cell style at " + rowIndex + ", " + colIndex + ": " + cell.getStringCellValue());

                // save with the default palette
                FileOutputStream out = new FileOutputStream(filePath);
                wb.write(out);
                out.close();
                wb.close();
            }
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Set comment to a cell
     *
     * @author Levin
     */
//https://poi.apache.org/spreadsheet/quick-guide.html#CellComments
    public static void setCellComment(String filePath, String sheetName, int rowIndex, int colIndex, String author, String comment)
    {
        try
        {
            if (filePath.endsWith("xlsx"))
            {
                FileInputStream fis = new FileInputStream(new File(filePath));
                XSSFWorkbook wb = new XSSFWorkbook(fis);
                XSSFSheet sheet = wb.getSheet(sheetName);
                XSSFRow row = sheet.getRow(rowIndex);
                XSSFCell cell;

                cell = row.getCell(colIndex);
                if (cell == null)
                    cell = row.createCell(colIndex);

                CreationHelper factory = wb.getCreationHelper();
                Drawing drawing = sheet.createDrawingPatriarch();
                ClientAnchor anchor = factory.createClientAnchor();
                anchor.setCol1(colIndex);
                anchor.setCol2(colIndex + 1);
                anchor.setRow1(rowIndex);
                anchor.setRow2(rowIndex + 3);
                Comment cmm = drawing.createCellComment(anchor);
                RichTextString str = factory.createRichTextString(comment);
                cmm.setAuthor(author);
                cmm.setString(str);
                cell.setCellComment(cmm);

                System.out.println("Set cell value at " + rowIndex + ", " + colIndex + ": " + cell.getCellComment());

                // save with the default palette
                FileOutputStream out = new FileOutputStream(filePath);
                wb.write(out);
                out.close();
                wb.close();
            }
            else if (filePath.endsWith("xls"))
            {
                FileInputStream fis = new FileInputStream(new File(filePath));
                HSSFWorkbook wb = new HSSFWorkbook(fis);
                HSSFSheet sheet = wb.getSheet(sheetName);
                HSSFRow row = sheet.getRow(rowIndex);
                HSSFCell cell = row.getCell(colIndex);

                if (cell == null)
                {
                    cell = row.createCell(colIndex);
                }

                CreationHelper factory = wb.getCreationHelper();
                Drawing drawing = sheet.createDrawingPatriarch();
                ClientAnchor anchor = factory.createClientAnchor();
                anchor.setCol1(colIndex);
                anchor.setCol2(colIndex + 1);
                anchor.setRow1(rowIndex);
                anchor.setRow2(rowIndex + 3);
                Comment cmm = drawing.createCellComment(anchor);
                RichTextString str = factory.createRichTextString(comment);
                cmm.setAuthor(author);
                cmm.setString(str);
                cell.setCellComment(cmm);

                System.out.println("Set cell comment at " + rowIndex + ", " + colIndex + ": " + cell.getCellComment());

                // save with the default palette
                FileOutputStream out = new FileOutputStream(filePath);
                wb.write(out);
                out.close();
                wb.close();
            }
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static int getLastRowNum(String filePath, String sheetName)
    {
        if (filePath.endsWith("xlsx"))
        {
            FileInputStream fis = null;
            XSSFWorkbook wb = null;
            XSSFSheet sheet = null;
            int i = 0;
            try
            {
                fis = new FileInputStream(new File(filePath));
                wb = new XSSFWorkbook(fis);
                sheet = wb.getSheet(sheetName);

                i = sheet.getLastRowNum() + 1;
            } catch (FileNotFoundException e)
            {
                i = 0;
                e.printStackTrace();
            } catch (IOException e)
            {
                i = 0;
                e.printStackTrace();
            }
            return i;
        }
        else if (filePath.endsWith("xls"))
        {
            FileInputStream fis = null;
            HSSFWorkbook wb = null;
            HSSFSheet sheet = null;
            int i = 0;
            try
            {
                fis = new FileInputStream(new File(filePath));
                wb = new HSSFWorkbook(fis);
                sheet = wb.getSheet(sheetName);

                i = sheet.getLastRowNum() + 1;
            } catch (FileNotFoundException e)
            {
                i = 0;
                e.printStackTrace();
            } catch (IOException e)
            {
                i = 0;
                e.printStackTrace();
            }
            return i;
        }
        return 0;
    }

    public static int getNumberOfColumns(HSSFSheet HExcelWSheet)
    {
        int rowCount = 0;
        Iterator rowIterator = HExcelWSheet.rowIterator();
        while (rowIterator.hasNext())
        {
            Row headerRow = (Row) rowIterator.next();
            //get the number of cells in the header row
            int numberOfCells = headerRow.getPhysicalNumberOfCells();
            if (numberOfCells > rowCount)
                rowCount = numberOfCells;
        }
        return rowCount;
    }

    public static int getNumberOfColumns(XSSFSheet XExcelWSheet)
    {
        int rowCount = 0;
        Iterator rowIterator = XExcelWSheet.rowIterator();
        while (rowIterator.hasNext())
        {
            Row headerRow = (Row) rowIterator.next();
            //get the number of cells in the header row
            int numberOfCells = headerRow.getPhysicalNumberOfCells();
            if (numberOfCells > rowCount)
                rowCount = numberOfCells;
        }
        return rowCount;
    }
    
    
    /** Start Region Nancy
	 */

	/**
	 * Using to write a DataTable to the Excel file
	 * 
	 * @param filePath
	 *            Link Url, where need save
	 * @param sheetName
	 *            Name of sheet @
	 * @author Nancy
	 * */
	public static boolean writeToExcel(String filePath, String sheetName,
			String tableName, List<List<String>> dataTable, int rowIndex,
			int colIndex) {
		if (filePath.endsWith("xls")) {
			try {
				createExcelFile(filePath, sheetName);

				FileInputStream fis = new FileInputStream(new File(filePath));
				HSSFWorkbook wb = new HSSFWorkbook(fis);
				HSSFSheet sheet = wb.getSheet(sheetName);

				int tempColIndex;
				int tempRowIndex = rowIndex;

				FileOutputStream fos = new FileOutputStream(filePath);

				HSSFRow row = null;
				try {
					row = sheet.getRow(tempRowIndex);
					if (row == null) {
						row = sheet.createRow(tempRowIndex);
					}

				} catch (Exception e) {
					row = sheet.createRow(tempRowIndex);
				}
				HSSFCell cell = row.createCell(colIndex);
				cell.setCellValue(tableName);
				fos = new FileOutputStream(filePath);
				wb.write(fos);

				tempRowIndex = rowIndex + 1;
				for (int i = 0; i < dataTable.size(); i++) {
					tempColIndex = colIndex;

					// Get row in Excel, If not exit, will create new one
					row = null;
					try {
						row = sheet.getRow(tempRowIndex);
						if (row == null) {
							row = sheet.createRow(tempRowIndex);
						}
					} catch (Exception e) {
						row = sheet.createRow(tempRowIndex);
					}

					// Get row in the dataTable. Then split it and insert to
					// Excel
					List<String> dataRow = dataTable.get(i);

					for (int j = 0; j < dataRow.size(); j++) {
						cell = row.createCell(tempColIndex);
						String value;
						try {
							value = dataRow.get(j);
						} catch (Exception ex) {
							value = "";
						}
						cell.setCellValue(value);
						fos = new FileOutputStream(filePath);
						wb.write(fos);
						tempColIndex += 1;
					}
					tempRowIndex += 1;
				}

				wb.close();
				fos.close();
				return true;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return false;
		}
		return false;
	}

	public static boolean writeToExcel(String filePath, String sheetName,
			String tableName, ResultSet rs) {
		int rowIndex;
		try {
			rowIndex = getLastRowNum(filePath, sheetName);			
			if (rowIndex < 1)
				rowIndex = 0;
			else
				rowIndex = rowIndex + 2;
		} catch (Exception ex) {
			rowIndex = 0;
			ex.printStackTrace();
		}
		return writeToExcel(filePath, sheetName, tableName, rs, rowIndex, 0);
	}

	public static boolean writeToExcel(String filePath, String sheetName,
			String tableName, ResultSet rs, int rowIndex, int colIndex) {
		List<List<String>> dataTable = convertResultSetToDataTable(rs);
		return writeToExcel(filePath, sheetName, tableName, dataTable,
				rowIndex, colIndex);
	}

	public static List<List<String>> convertResultSetToDataTable(ResultSet rs) {
		List<List<String>> actualTable = new ArrayList<List<String>>();
		try {
			ResultSetMetaData metaData = rs.getMetaData();
			int countColumn = metaData.getColumnCount(); // number of column

			List<String> columnName = new ArrayList<String>();
			for (int i = 1; i <= countColumn; i++) {
				columnName.add(metaData.getColumnLabel(i));
			}
			actualTable.add(columnName);
			while (rs.next()) {
				List<String> resultRow = new ArrayList<String>();
				for (int i = 1; i <= countColumn; i++) {
					resultRow.add(rs.getString(i));
				}
				actualTable.add(resultRow);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			actualTable = new ArrayList<List<String>>();
		}
		return actualTable;
	}
}