package com.synergix.utilities;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import com.google.common.base.Strings;

public class ConnectDatabase
{
    // JDBC driver name and database URL
    public static String  JDBC_DRIVER      = null;
    public static boolean CHANGE_DB_CONFIG = false;
    // Database credentials
    public static String  DB_NAME          = null;
    public static String  USER_NAME        = null;
    public static String  PASS_WORD        = null;
    public static String  IP_SERVER        = null;
    public static String  SERVER_PORT      = null;

    private static Connection conn = null;
    private static Statement  stmt = null;
    private static ResultSet  rs   = null;

    public static Properties CONFIG = null;

    public static void connect()
    {
        try
        {
            if (!CHANGE_DB_CONFIG)
            {
                CONFIG = LoadObject.loading_config_sys("serenity.properties");

                JDBC_DRIVER = System.getProperty("db.jdbc");
                if (Strings.isNullOrEmpty(JDBC_DRIVER))
                {
                    JDBC_DRIVER = CONFIG.getProperty("db.jdbc");
                    if (Strings.isNullOrEmpty(JDBC_DRIVER))
                        JDBC_DRIVER = "com.ibm.db2.jcc.DB2Driver";
                }

                IP_SERVER = System.getProperty("db.url");
                if (Strings.isNullOrEmpty(IP_SERVER))
                {
                    IP_SERVER = CONFIG.getProperty("db.url");
                    if (Strings.isNullOrEmpty(IP_SERVER))
                        IP_SERVER = "172.18.0.21";
                }

                SERVER_PORT = System.getProperty("db.port");
                if (Strings.isNullOrEmpty(SERVER_PORT))
                {
                    SERVER_PORT = CONFIG.getProperty("db.port");
                    if (Strings.isNullOrEmpty(SERVER_PORT))
                        SERVER_PORT = "50000";
                }

                DB_NAME = System.getProperty("db.name");
                if (Strings.isNullOrEmpty(DB_NAME))
                {
                    DB_NAME = CONFIG.getProperty("db.name");
                    if (Strings.isNullOrEmpty(DB_NAME))
                        DB_NAME = "AUTO5";
                }

                USER_NAME = System.getProperty("db.user");
                if (Strings.isNullOrEmpty(USER_NAME))
                {
                    USER_NAME = CONFIG.getProperty("db.user");
                    if (Strings.isNullOrEmpty(USER_NAME))
                        USER_NAME = "db2admin";
                }

                PASS_WORD = System.getProperty("db.pwd");
                if (Strings.isNullOrEmpty(PASS_WORD))
                {
                    PASS_WORD = CONFIG.getProperty("db.pwd");
                    if (Strings.isNullOrEmpty(PASS_WORD))
                        PASS_WORD = "x";
                }
            }
            LogWork.log_debug(">> debug: | Register JDBC driver");
            Class.forName(JDBC_DRIVER);
            String DB_URL = "jdbc:db2://" + IP_SERVER + ":" + SERVER_PORT + "/" + DB_NAME + "";
            System.out.println(DB_URL);
            System.out.println("DB User : " + USER_NAME + "DB Password: " + PASS_WORD);
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASS_WORD);

        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } catch (SQLException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void connect(String nameDB)
    {
        try
        {
            if (!CHANGE_DB_CONFIG)
            {
                CONFIG = LoadObject.loading_config_sys("serenity.properties");

                DB_NAME = nameDB;

                JDBC_DRIVER = System.getProperty("db.jdbc");
                if (Strings.isNullOrEmpty(JDBC_DRIVER))
                {
                    JDBC_DRIVER = CONFIG.getProperty("db.jdbc");
                    if (Strings.isNullOrEmpty(JDBC_DRIVER))
                        JDBC_DRIVER = "com.ibm.db2.jcc.DB2Driver";
                }

                IP_SERVER = System.getProperty("db.url");
                if (Strings.isNullOrEmpty(IP_SERVER))
                {
                    IP_SERVER = CONFIG.getProperty("db.url");
                    if (Strings.isNullOrEmpty(IP_SERVER))
                        IP_SERVER = "172.18.0.21";
                }

                SERVER_PORT = System.getProperty("db.port");
                if (Strings.isNullOrEmpty(SERVER_PORT))
                {
                    SERVER_PORT = CONFIG.getProperty("db.port");
                    if (Strings.isNullOrEmpty(SERVER_PORT))
                        SERVER_PORT = "50000";
                }

                USER_NAME = System.getProperty("db.user");
                if (Strings.isNullOrEmpty(USER_NAME))
                {
                    USER_NAME = CONFIG.getProperty("db.user");
                    if (Strings.isNullOrEmpty(USER_NAME))
                        USER_NAME = "db2admin";
                }

                PASS_WORD = System.getProperty("db.pwd");
                if (Strings.isNullOrEmpty(PASS_WORD))
                {
                    PASS_WORD = CONFIG.getProperty("db.pwd");
                    if (Strings.isNullOrEmpty(PASS_WORD))
                        PASS_WORD = "x";
                }
            }
            LogWork.log_debug(">> debug: | Register JDBC driver");
            Class.forName(JDBC_DRIVER);

            String DB_URL = "jdbc:db2://" + IP_SERVER + ":" + SERVER_PORT + "/" + DB_NAME + "";
            System.out.println(DB_URL);
            System.out.println("DB User : " + USER_NAME + "DB Password: " + PASS_WORD);
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASS_WORD);

        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } catch (SQLException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public ConnectDatabase()
    {
        connect();
    }

    public ConnectDatabase(String connectionString, String username, String password)
    {
        try
        {
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            conn = DriverManager.getConnection(connectionString, username, password);
        } catch (ClassNotFoundException e)
        {
            // Assert.fail("Database connect classnot found: " +
            // connectionString, e.getCause());
            e.printStackTrace();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    // use for update & delete statement
    public static void executeUpdate(String sql)
    {
        try
        {
            LogWork.log_debug(">> debug: | Execute a query update: " + sql);
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e)
        {
            // Handle errors for JDBC
            e.printStackTrace();
            LogWork.log_debug(">> debug: | SQLException execute a query update: " + sql);
        } catch (Exception e)
        {
            // Handle errors for Class.forName
            LogWork.log_debug(">> debug: | Handle errors for Class.forName");
            e.printStackTrace();
        }
    }

    public static ResultSet executeQuery(String sql)
    {
        try
        {
            LogWork.log_debug(">> debug: | Execute a query: " + sql);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            LogWork.log_debug("Executed: " + sql);
            return rs;
        } catch (SQLException e)
        {
            e.printStackTrace();
        } catch (Exception e)
        {
            LogWork.log_debug(">> debug: | Handle errors for Class.forName");
            e.printStackTrace();
        }
        return null;
    }

    public static void close()
    {
        try
        {
            if (rs != null)
            {
                rs.close();
            }

            if (stmt != null)
            {
                stmt.close();
            }

            if (conn != null)
            {
                conn.close();
            }
        } catch (Exception e)
        {

        }
    }

    public static void sleep(double d)
    {
        try
        {
            Thread.sleep((long) (d * 1000));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    // check 1 sql query
    public static boolean checkSQLResult(String query)
    {
        sleep(5);
        try
        {
            Statement stmt = null;
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            if (rs.next())
            {
                return true;
            }
            else
            {
                // Assert.fail("SQL returns no result");
                return false;
            }
        } catch (SQLException e)
        {
            // Assert.fail("Statement Executed Failed: " + query, e.getCause());
            System.out.println(query);
            e.printStackTrace();
            return false;
        }
    }

    // pass in a list of sql query and check if all of them have records
    public static boolean checkSQLListResult(ArrayList<String> queryList)
    {
        // wait for the DB to update
        sleep(5);
        int result = 0;
        boolean all = false;
        for (String query : queryList)
        {
            if (query != "")
            {
                if (checkSQLResult(query))
                {
                    result += 1;
                }
                else
                {
                    result += 0;
                }
            }
            else
            {
                result += 0;
            }
        }
        // result # queryList size shows that not all conditions are true
        if (result == queryList.size())
        {
            all = true;
        }
        else if (result < queryList.size())
        {
            all = false;
        }
        return all;
    }

    // return a number of records in the result table
    // records = tuples
    public static int getNumberofRecords(String query)
    {
        int rows = 0;
        try
        {
            Statement stmt = null;
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next())
            {
                rows += 1;
            }
        } catch (SQLException e)
        {
            // Assert.fail("Statement Executed Failed: " + query, e.getCause());
            System.out.println(query);
            e.printStackTrace();
        }
        return rows;
    }

    public static boolean checkNumberofRecords(String query, int records)
    {
        int rows = 0;
        rows = getNumberofRecords(query);
        return (rows == records);
    }

    // return value of a column name in the first row in type of Object
    public static Object getColumnValueObject(String query, String columnName)
    {
        // PageActions.sleep(3); // wait for the DB to update
        Object result;
        try
        {
            Statement stmt = null;
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            if (rs.next())
            {
                result = rs.getObject(columnName);
            }
            else
            {
                result = null;
            }
        } catch (SQLException e)
        {
            //// Assert.fail("Statement Executed Failed: " + query,
            //// e.getCause());
            System.out.println(query);
            e.printStackTrace();
            result = null;
        } catch (NullPointerException e)
        {
            e.printStackTrace();
            result = "";
        }
        return result;
    }

    /**
     * Please check the TYPE of the column in database to make sure it is DOUBLE
     *
     * @param query
     * @param columnName
     * @return The value of the column name in the first row in type of Double
     * @author Jack
     */
    public static double getColumnDoubleValue(String query, String columnName)
    {
        double result = 0;
        try
        {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            result = rs.next() ? rs.getDouble(columnName) : (Double) null;
        } catch (SQLException e)
        {
            System.out.println(query);
            e.printStackTrace();
            result = (Double) null;
        } catch (NullPointerException e)
        {
            System.out.println(query);
            e.printStackTrace();
            result = 0;
        }
        return result;
    }

    /**
     * Please check the TYPE of the column in database to make sure it is INT
     *
     * @param query
     * @param columnName
     * @return The value of the column name in the first row in type of Integer
     * @author Jack
     */
    public static int getColumnIntValue(String query, String columnName)
    {
        int result = 0;
        try
        {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            result = rs.next() ? rs.getInt(columnName) : (Integer) null;
        } catch (SQLException e)
        {
            System.out.println(query);
            e.printStackTrace();
            result = (Integer) null;
        } catch (NullPointerException e)
        {
            System.out.println(query);
            e.printStackTrace();
            result = 0;
        }
        return result;
    }

    public static String getColumnValue(String connectionString, String userName, String password, String query, String columnName)
    {
        String result = "";
        try
        {
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            Connection conn2 = DriverManager.getConnection(connectionString, userName, password);
            Statement stmt = null;
            stmt = conn2.createStatement();
            rs = stmt.executeQuery(query);
            if (rs.next())
            {
                result = rs.getObject(columnName).toString();
            }
            else
            {
                result = "";
            }
        } catch (SQLException e)
        {
            // Assert.fail("Statement Executed Failed: " + query, e.getCause());
            System.out.println(query);
            e.printStackTrace();
            result = "";
        } catch (NullPointerException e)
        {
            e.printStackTrace();
            result = "";
        } catch (ClassNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public static String getColumnValue(String query, String columnName)
    {
        String result;
        try
        {
            Statement stmt = null;
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            if (rs.next())
            {
                result = rs.getObject(columnName).toString();
            }
            else
            {
                result = "";
            }
        } catch (SQLException e)
        {
            // Assert.fail("Statement Executed Failed: " + query, e.getCause());
            System.out.println(query);
            e.printStackTrace();
            result = "";
        } catch (NullPointerException e)
        {
            e.printStackTrace();
            result = "";
        }
        return result;
    }

    /**
     * Return an string array list of multi column values
     *
     * @param query      SQL Statement
     * @param columnName column name
     * @author levin
     */
    public static ArrayList<String> getColumnValues(String query, String columnName)
    {
        ArrayList<String> results = new ArrayList<>();
        try
        {
            Statement stmt = null;
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next())
            {
                results.add(rs.getObject(columnName).toString());
            }
        } catch (SQLException e)
        {
            // Assert.fail("Statement Executed Failed: " + query, e.getCause());
            System.out.println(query);
            e.printStackTrace();
            results = null;
        } catch (NullPointerException e)
        {
            e.printStackTrace();
            results = null;
        }
        return results;
    }

    // check column value if it returns the same result as 'value' parameter
    public static boolean checkColumnValue(String query, String columnName, Object value)
    {
        Object columnValue = null;
        try
        {
            columnValue = getColumnValueObject(query, columnName);
        } catch (Exception e)
        {
            columnValue = null;
        }
        if (columnValue != null)
        {
            if (columnValue instanceof String)
            {
                return (columnValue.equals(value.toString()));
            }
            else if (columnValue instanceof Integer)
            {
                return (columnValue.equals(Integer.parseInt(value.toString())));
            }
            else if (columnValue instanceof Double)
            {
                return (columnValue.equals(Double.parseDouble(value.toString())));
            }
            else if (columnValue instanceof Date)
            {
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                columnValue = df.format(columnValue);
                return (columnValue.toString().equals(value.toString()));
            }
            else if (columnValue instanceof Timestamp)
            {
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy H:mm");
                columnValue = df.format(columnValue);
                return (columnValue.toString().equals(value.toString()));
            }
        }
        return false;
    }

    // check column value if it returns the same result as 'value' parameter,
    // filePath for detailed output results
    public static boolean checkColumnValue(String query, String columnName, Object obj, String filePath, boolean printAllResult)
    {
        Object columnValue = null;
        boolean check = false;
        String value;
        if (obj != null)
        {
            if (obj instanceof Double || obj instanceof Integer)
                value = String.valueOf(obj);
            else if (obj instanceof Date)
                value = new SimpleDateFormat("dd/MM/yyyy").format(obj);
            else if (columnValue instanceof Timestamp)
                value = new SimpleDateFormat("dd/MM/yyyy H:mm").format(obj);
            else
                value = (String) obj;
        }
        else
            value = "";
        try
        {
            columnValue = getColumnValueObject(query, columnName);
        } catch (Exception e)
        {
            columnValue = null;
        }
        if (columnValue != null)
        {
            if (columnValue instanceof String)
            {
                check = columnValue.equals(value);
            }
            else if (columnValue instanceof Integer)
            {
                int flag = 0;
                if (!value.equals(""))
                {
                    flag = Integer.parseInt(value);
                }
                check = columnValue.equals(flag);
            }
            else if (columnValue instanceof Double)
            {
                DecimalFormat df = new DecimalFormat("#.##");
                columnValue = Double.valueOf(df.format(columnValue));
                double flag = 0;
                if (!value.equals(""))
                {
                    flag = Double.parseDouble(value);
                }
                check = columnValue.equals(flag);
            }
            else if (columnValue instanceof Date)
            {
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                columnValue = df.format(columnValue);
                check = columnValue.toString().equals(value);
            }
            else if (columnValue instanceof Timestamp)
            {
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy H:mm");
                columnValue = df.format(columnValue);
                check = columnValue.toString().equals(value);
            }
            columnName = ReadBean.addAlignedSpace(columnName, 25);
            value = ReadBean.addAlignedSpace(value, 10);
            columnValue = ReadBean.addAlignedSpace(columnValue, 7);
            if (!printAllResult)
            {
                if (check != true)
                {
                    ReadBean.writeToFile(filePath,
                                         query + "     " + columnName + " Expected result: " + value + " Actual result: " + columnValue + " Fail");
                }
            }
            else
            {
                if (check != true)
                {
                    ReadBean.writeToFile(filePath,
                                         query + " " + columnName + " Expected result: " + value + " Actual result: " + columnValue + " Failed");
                }
                else
                {
                    ReadBean.writeToFile(filePath,
                                         query + " " + columnName + " Expected result: " + value + " Actual result: " + columnValue + " Passed");
                }
            }
            return check;
        }
        else if (columnValue == null && (value.toString().equals("")))
        {
            columnName = ReadBean.addAlignedSpace(columnName, 25);
            value = ReadBean.addAlignedSpace(value, 5);
            ReadBean.writeToFile(filePath, query + " " + columnName + "   Execution passed " + "   Passed");
            return true;
        }
        else
        {
            columnName = ReadBean.addAlignedSpace(columnName, 25);
            value = ReadBean.addAlignedSpace(value, 5);
            ReadBean.writeToFile(filePath, query + " " + columnName + "   Execution failed " + "   Failed");
            return false;
        }
        // return false;
    }

    public static boolean checkColumnValue(String connectionString, String userName, String password, String query, String columnName, Object obj,
                                           String filePath, String sheetName, boolean printAllResult)
    {
        String testResult = "";

        Connection conn2 = null;
        Object columnValue = null;
        Object result = null;
        Statement stmt = null;
        try
        {
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            conn2 = DriverManager.getConnection(connectionString, userName, password);
            stmt = conn2.createStatement();
            rs = stmt.executeQuery(query);
            if (rs.next())
            {
                result = rs.getObject(columnName);
            }
            else
            {
                result = null;
            }
        } catch (ClassNotFoundException e1)
        {
            e1.printStackTrace();
            columnValue = null;
        } catch (SQLException e)
        {
            e.printStackTrace();
            columnValue = null;
        } catch (NullPointerException e)
        {
            e.printStackTrace();
            columnValue = null;
        }
        boolean check = false;
        String value;
        if (obj != null)
        {
            if (obj instanceof Double || obj instanceof Integer)
                value = String.valueOf(obj);
            else if (obj instanceof Date)
                value = new SimpleDateFormat("dd/MM/yyyy").format(obj);
            else if (columnValue instanceof Timestamp)
                value = new SimpleDateFormat("dd/MM/yyyy H:mm").format(obj);
            else
                value = (String) obj;
        }
        else
            value = "";
        try
        {
            stmt = conn2.createStatement();
            rs = stmt.executeQuery(query);
            if (rs.next())
            {
                columnValue = rs.getObject(columnName);
            }
            else
            {
                columnValue = null;
            }
        } catch (Exception e)
        {
            columnValue = null;
        }
        if (columnValue != null)
        {
            if (columnValue instanceof String)
            {
                check = columnValue.equals(value);
            }
            else if (columnValue instanceof Integer)
            {
                int flag = 0;
                if (!value.equals(""))
                {
                    flag = Integer.parseInt(value);
                }
                check = columnValue.equals(flag);
            }
            else if (columnValue instanceof Double)
            {
                DecimalFormat df = new DecimalFormat("#.##");
                columnValue = Double.valueOf(df.format(columnValue));
                double flag = 0;
                if (!value.equals(""))
                {
                    flag = Double.parseDouble(value);
                }
                check = columnValue.equals(flag);
            }
            else if (columnValue instanceof Date)
            {
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                columnValue = df.format(columnValue);
                check = columnValue.toString().equals(value);
            }
            else if (columnValue instanceof Timestamp)
            {
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy H:mm");
                columnValue = df.format(columnValue);
                check = columnValue.toString().equals(value);
            }
            // columnName = ReadBean.addAlignedSpace(columnName, 25);
            // value = ReadBean.addAlignedSpace(value, 10);
            // columnValue = ReadBean.addAlignedSpace(columnValue, 7);
            if (!printAllResult)
            {
                if (check != true)
                {
                    // ReadBean.writeToFile(filePath, connectionString + " " +
                    // query + " " + columnName
                    // + " Expected result: " + value + " Actual result: " +
                    // columnValue + " Fail");
                    testResult = "Failed";
                }
            }
            else
            {
                if (check != true)
                {
                    // ReadBean.writeToFile(filePath, connectionString + " " +
                    // query + " " + columnName
                    // + " Expected result: " + value + " Actual result: " +
                    // columnValue + " Failed");
                    testResult = "Failed";
                }
                else
                {
                    // ReadBean.writeToFile(filePath, connectionString + " " +
                    // query + " " + columnName
                    // + " Expected result: " + value + " Actual result: " +
                    // columnValue + " Passed");
                    testResult = "Passed";
                }
            }
        }
        else if (columnValue == null && ((value.toString().equals("")) || value.equalsIgnoreCase("null")))
        {
            // columnName = ReadBean.addAlignedSpace(columnName, 25);
            // value = ReadBean.addAlignedSpace(value, 5);
            // ReadBean.writeToFile(filePath,
            // connectionString + " " + query + " " + columnName + " Execution
            // passed " + " Passed");
            testResult = "Passed";
            check = true;
        }
        else
        {
            // columnName = ReadBean.addAlignedSpace(columnName, 25);
            // value = ReadBean.addAlignedSpace(value, 5);
            // ReadBean.writeToFile(filePath,
            // connectionString + " " + query + " " + columnName + " Execution
            // failed " + " Failed");

            testResult = "Failed";
            check = false;
        }

        int rowNo = ExcelUtils.getLastRowNum(filePath, sheetName);
        ExcelUtils.writeToExel(filePath, sheetName, connectionString, rowNo, 1);
        ExcelUtils.writeToExel(filePath, sheetName, query, rowNo, 2);
        ExcelUtils.writeToExel(filePath, sheetName, columnName, rowNo, 3);
        ExcelUtils.writeToExel(filePath, sheetName, value, rowNo, 4);
        ExcelUtils.writeToExel(filePath, sheetName, columnValue + "", rowNo, 5);
        ExcelUtils.writeToExel(filePath, sheetName, testResult, rowNo, 6);

        return check;
    }

    public static boolean checkBooleanList(ArrayList<Boolean> list)
    {
        int result = 0;
        for (boolean i : list)
        {
            if (i)
            {
                result += 1;
            }
            else
            {
                result += 0;
            }
        }
        if (result == list.size())
        {// all correct
            return true;
        }
        else if (result < list.size())
        {
            return false;
        }
        return false;
    }

    public static String formatDate(String ddMMyyyy)
    {
        String day = ReadBean.split(ddMMyyyy, "/")[0];
        String month = ReadBean.split(ddMMyyyy, "/")[1];
        String year = ReadBean.split(ddMMyyyy, "/")[2];
        return year + "-" + month + "-" + day;
    }

    public static ResultSet getResultStatement(String query)
    {
        try
        {
            Statement stmt = null;
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            print("Executed : " + query);
        } catch (SQLException e)
        {
            // Assert.fail("Statement Executed Failed:" + query, e.getCause());
            e.printStackTrace();
            rs = null;
        }
        return rs;
    }

    public static boolean empty(ResultSet rs)
    {
        try
        {
            if (rs.next())
                return false;
            else
                return true;
        } catch (Exception e)
        {
            return true;
        }
    }

    public static boolean notEmpty(ResultSet rs)
    {
        return !empty(rs);
    }

    // use for update & delete statement
    public static void executeUpdateWithExc(String query) throws SQLException
    {
        Statement stmt = null;
        stmt = conn.createStatement();
        print("Executed: " + query);
        stmt.executeUpdate(query);
    }

    // ignore this
    public static void test()
    {
        String query = "select LINE_ITEM_NO, DT_TYPE, QTY, NO_OF_PACK, BASE_UNIT_COST, BASE_EXTENDED_AMT, PRE_TAX_EXTENDED_AMT, PRE_TAX_EXTENDED_HOME_AMT, INVOICE_NO, INVENTORY_CODE, SERVICE_CODE, FIXED_ASSET_CODE, SALES_TAX_CODE from AP_INV_HST_DET where INVOICE_NO = 'NAP0028/14'";
        try
        {
            Statement stmt = null;
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            if (rs.next())
            {
                System.out.print(rs.getString(1));
                System.out.print(rs.getString(2));
                System.out.print(rs.getString(3));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Print the string to logging console with logging format
     *
     * @param s The string to print
     */
    public static void print(String s)
    {
        System.out.println(DateTimeUtil.getTimestamp() + " " + s);
    }

    /**
     * Format from Object instance to Double instance
     *
     * @param object Object to be formatted
     * @return Double instance of formatted object<br>
     * 0.0 in case the object is not instance of double value
     * @author Jack
     */
    public static Double castDouble(Object object)
    {
        try
        {
            DecimalFormat df = new DecimalFormat("#.##");
            if (object instanceof Double || object instanceof Long)
            {
                return Double.valueOf(df.format(object));
            }
            else
            {
                return Double.valueOf(df.format(Double.valueOf(object.toString())));
            }
        } catch (NumberFormatException e)
        {
            return 0.0;
            // e.printStackTrace();
        }
    }

    /**
     * Format from Object instance to String Date instance
     *
     * @param object Object to be formatted
     * @return String represent the date instance of formatted object<br>
     * null in case the object is not instance of date time
     * @author Jack
     */
    public static String castDate(Object object)
    {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try
        {
            return df.format(object);
        } catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Format from Object instance to String Time stamp instance
     *
     * @param object Object to be formatted
     * @return String represent the date instance of formatted object<br>
     * null in case the object is not instance of Time stamp
     * @author Jack
     */
    public static String castTimestamp(Object object)
    {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
        try
        {
            return df.format(object);
        } catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Format from Object instance to Integer instance
     *
     * @param object Object to be formatted
     * @return Integer instance of object <br>
     * 0 value in case the object is not instance of integer
     * @author Jack
     */
    public static int castInt(Object object)
    {
        try
        {
            return Integer.parseInt(object.toString());
        } catch (NumberFormatException e)
        {
            e.printStackTrace();
            return 0;
        }
    }

    public static int getSize(ResultSet resultSet)
    {
        int size = 0;
        try
        {
            resultSet.last();
            size = resultSet.getRow();
            resultSet.beforeFirst();
        } catch (Exception ex)
        {
            return 0;
        }
        return size;
    }
}
