package com.synergix.utilities;

//import org.testng.Assert;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DBUtils
{
    /**
     * Round the provided value to specified place.
     *
     * @param value
     * @param decimalPlace
     * @return
     */
    public static double round(Double value, int decimalPlace)
    {
        try
        {
            if (value == null)
                return 0.0;
            return BigDecimal.valueOf(value).setScale(10, 4).setScale(decimalPlace, 4).doubleValue();
        } catch (Exception e)
        {
            // TODO print failure values
            e.printStackTrace();
            return 0.0;
        }
    }

    /**
     * Get current BUY_RATE exchange rate of the specified currency
     *
     * @param currency
     * @return
     */
    public static final Double getUpdateExchRate(String currency)
    {
        String query = "SELECT BUY_RATE FROM MT_EXCHANGE_RATE WHERE CURRENCY_CODE = '" + currency + "' AND EFFECTIVE_DATE_FROM < CURRENT DATE ORDER BY EFFECTIVE_DATE_FROM DESC FETCH FIRST 1 ROW ONLY";
        return ConnectDatabase.getColumnDoubleValue(query, "BUY_RATE");
    }

    /**
     * Get Financial Year of a String replicated a date
     *
     * @param timeString The date which need to get the financial year, for example: '2015-10-01 00:00:00.0'
     * @return Integer replicating the Financial Year of the provided time
     * @author Jack
     */
    public static final int getFinancialYear(String timeString)
    {
        try
        {
            timeString = timeString.replace("/", "-");
            timeString.trim();
            String           time[]   = timeString.split("-");
            String           reversed = time[2] + "-" + time[1] + "-" + time[0] + " 00:00:00";
            SimpleDateFormat myDate   = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String           sqlTime  = myDate.format(myDate.parse(reversed));
            String           query    = "SELECT FINANCIAL_YEAR FROM MT_FINANCIAL_PERIOD WHERE PERIOD_START_DATE <= DATE('" + sqlTime + "') ORDER BY PERIOD_START_DATE DESC FETCH FIRST 1 ROW ONLY";
            return ConnectDatabase.getColumnIntValue(query, "FINANCIAL_YEAR");
        } catch (ParseException e)
        {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * Get Financial Year of a String replicated a date
     *
     * @param timeString The date which need to get the financial period, for example: '2015-10-01 00:00:00.0'
     * @return Integer replicating the Financial Period of the provided time
     * @author Jack
     */
    public static final int getFinancialPeriod(String timeString)
    {
        try
        {
            timeString = timeString.replace("/", "-");
            timeString.trim();
            String           time[]   = timeString.split("-");
            String           reversed = time[2] + "-" + time[1] + "-" + time[0] + " 00:00:00";
            SimpleDateFormat myDate   = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String           sqlTime  = myDate.format(myDate.parse(reversed));
            String           query    = "SELECT FINANCIAL_PERIOD FROM MT_FINANCIAL_PERIOD WHERE PERIOD_START_DATE <= DATE('" + sqlTime + "') ORDER BY PERIOD_START_DATE DESC FETCH FIRST 1 ROW ONLY";
            return ConnectDatabase.getColumnIntValue(query, "FINANCIAL_PERIOD");
        } catch (ParseException e)
        {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * @param type       C: Customer Class <br>
     *                   S: Supplier Class<br>
     *                   P: Project Class<br>
     *                   U: Employee Class<br>
     *                   E: Service Class<br>
     *                   F: Fixed Asset Class<br>
     *                   I: Inventory Class
     * @param itemClass  The Class code
     * @param glanColumn The specified GLAN column of the class code
     * @return The GLAN
     */
    public static final String getGlan(String type, String itemClass, String glanColumn)
    {
        String table = null, pk = null;
        switch (type)
        {
            case "C":
                table = "MT_PARTY_CLASS";
                pk = "EMPLOYEE_CLASS_CODE";
                break;
            case "S":
                table = "MT_SUPPLIER_CLASS";
                pk = "SUPPLIER_CLASS_CODE";
                break;
            case "P":
                table = "MT_PROJECT_CLASS";
                pk = "PROJECT_CLASS_CODE";
                break;
            case "U":
                table = "MT_EMPLOYEE_CLASS";
                pk = "EMPLOYEE_CLASS_CODE";
                break;
            case "E":
                table = "MT_SERVICE";
                pk = "SERVICE_CODE";
                break;
            case "F":
                table = "MT_FIXED_ASSET_CLASS";
                pk = "FIXED_ASSET_CLASS_CODE";
                break;
            case "I":
                table = "MT_INVENTORY_CLASS";
                pk = "INVENTORY_CLASS_CODE";
                break;

            default:
                break;
        }
        String query = (!pk.isEmpty() && !glanColumn.isEmpty()) ? "SELECT " + glanColumn + " FROM " + table + " WHERE " + pk + " = '" + itemClass + "'" : "";
        return ConnectDatabase.getColumnValue(query, glanColumn);
    }

    /**
     * Compare 2 double values to catch rounding issue
     *
     * @param value1
     * @param value2
     */
    public static Boolean isEqual(double value1, double value2)
    {
        if (Math.abs(value1 - value2) > 0.001)
        {
            System.out.print("Conflicted values: " + value1 + " / " + value2);
            return false;
        }
        else
        {
            return true;
        }
    }
}