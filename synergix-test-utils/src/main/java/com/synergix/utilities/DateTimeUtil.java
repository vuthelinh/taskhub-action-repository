package com.synergix.utilities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateTimeUtil
{

    public static String getNextDate(String string)
    {
        final SimpleDateFormat format   = new SimpleDateFormat("dd/MM/yyyy");
        Calendar               calendar = null;
        Date                   date;
        try
        {
            date = format.parse(string);
            calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_YEAR, 1);
        } catch (ParseException e)
        {
            e.printStackTrace();
        }

        return format.format(calendar.getTime());
    }

    public static String getCurrentDateTime()
    {
        Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());

        Date currentTime  = localCalendar.getTime();
        int  currentDay   = localCalendar.get(Calendar.DATE);
        int  currentMonth = localCalendar.get(Calendar.MONTH) + 1;
        int  currentYear  = localCalendar.get(Calendar.YEAR);

        String datevalue = currentDay + "/" + currentMonth + "/" + currentYear;

        return datevalue;

    }

    public static int getCurrentDay()
    {
        Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());
        int      currentDay    = localCalendar.get(Calendar.DATE);

        return currentDay;
    }

    public static int getCurrentMonth()
    {
        Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());
        int      currentMonth  = localCalendar.get(Calendar.MONTH) + 1;

        return currentMonth;

    }

    public static int getCurrentYear()
    {
        Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());

        int currentYear = localCalendar.get(Calendar.YEAR);

        return currentYear;
    }

    public static String getToday()
    {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar   cal        = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }

    /**
     * Get time based on parameter format
     *
     * @param stringFormat desired string format
     * @author Levin
     */
    public static String getTime(String stringFormat)
    {
        DateFormat dateFormat = new SimpleDateFormat(stringFormat);
        Calendar   cal        = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }

    public static String getTimeNow()
    {
        return getTime("HH:mm:ss");
    }

    public static String getTimestamp()
    {
        return getTime("[yyyy-MM-dd HH:mm:ss.SSS]");
    }

    public static String getTimeToday()
    {
        return getTime("dd/MM/yyyy HH:mm");
    }

    public static String getTimeTodayNoSlash()
    {
        return getTime("dd-MM-yyyy-HH-mm");
    }

    /**
     * Get year/month/day of a source date
     *
     * @param type Calendar.YEAR / Calendar.MONTH / Calendar.DATE
     * @author Levin
     */
    public static int getTimeType(String sourceDate, int type)
    {
        sourceDate = sourceDate.replace("/", "-");
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        Date             myDate = null;
        try
        {
            myDate = format.parse(sourceDate);
        } catch (ParseException e)
        {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(myDate);
        return cal.get(type);
    }

    public static String addDays(String sourceDate, int days)
    {
        return addDays(sourceDate, days, "dd-MM-yyyy").replace("-", "/");
    }

    public static String addDays(String sourceDate, int days, String dateFormat)
    {
        sourceDate = sourceDate.replace("/", "-");
        SimpleDateFormat format = new SimpleDateFormat(dateFormat, Locale.US);
        Date             myDate = null;
        try
        {
            myDate = format.parse(sourceDate);
        } catch (ParseException e)
        {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(myDate);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        sourceDate = format.format(cal.getTime());
        return sourceDate;
    }

    public static String getDiffHourInTime(Date startDate, Date endDate)
    {
        long secs  = (endDate.getTime() - startDate.getTime()) / 1000;
        int  hours = (int) (secs / 3600);
        secs = secs % 3600;
        int mins = (int) (secs / 60);
        secs = secs % 60;

        String time = String.format("%02d", hours) + ":" + String.format("%02d", mins) + ":00";
        return time;
    }

    public static double getDiffHour(Date startDate, Date endDate)
    {
        long secs  = (endDate.getTime() - startDate.getTime()) / 1000;
        int  hours = (int) (secs / 3600);
        secs = secs % 3600;
        int mins = (int) (secs / 60);
        secs = secs % 60;
        double time = hours + (double) mins / 60;
        return time < 0 ? 0 : time;
    }

    public static double getTimeInDouble(String time)
    {
        String hourS = ReadBean.split(time, ":")[0];
        String minS  = ReadBean.split(time, ":")[1];
        int    hour  = Integer.parseInt(hourS);
        int    min   = Integer.parseInt(minS);
        return hour + (double) min / 60;
    }

    public static String removeHourFromSQLDate(Date sourceDate)
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String           myDate = null;
        myDate = format.format(sourceDate);
        return myDate;
    }

    public static Date stringToFullDate(String sourceDate)
    {
        sourceDate = sourceDate.replace("/", "-");
        sourceDate.trim();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date             myDate = null;
        try
        {
            myDate = format.parse(sourceDate);
            //String formattedDate = format.format(myDate);
            //myDate = format.parse(formattedDate);
        } catch (ParseException e)
        {
            e.printStackTrace();
            return null;
        }
        return myDate;
    }

    public static Date addDateToHour(String date, String hour)
    {
        String d = date + " " + hour;
        d.trim();
        Date fullDate = stringToFullDate(d);
        return fullDate;
    }

    /**
     * Process and calculate the date specified in data set in the format that
     * is available to be inputed <br>
     * The example input formats: "currentdate + 365" or "(currentdate)" or
     * "31/12/2015"
     *
     * @param input The date get from data set
     * @return The date in format to input to screen
     * @author Jack
     */
    public static String processDate(String input)
    {
        String date = "";
        input = input.trim();
        if (input.contains("currentdate") && !input.contains("+"))
        {
            date = getToday();
        }
        else if (input.contains("currentdate") && input.contains("+"))
        {
            int i         = input.indexOf("+") + 1;
            int daysToAdd = Integer.parseInt(input.substring(i).trim());
            date = addDays(DateTimeUtil.getToday(), daysToAdd);
        }
        else
        {
            date = input;
        }

        return date;
    }

    // assume currentHour is in format: HHmm

    /**
     * Add number of hour to a hour string
     *
     * @param currentHour hour in string in dataset, eg: 1800
     * @param add         number of hour to add
     * @return new hour after added, eg: 1900
     * @author levin
     */
    public static String addHour(String currentHour, int add)
    {
        String newHour = "";
        String minute  = currentHour.substring(currentHour.length() - 2, currentHour.length());
        currentHour = currentHour.substring(0, currentHour.length() - 2); // remove mm

        int hour = Integer.parseInt(currentHour);
        hour = hour + add;

        newHour = hour + "" + minute;

        return newHour;
    }

    /**
     * Format date to database format
     *
     * @param tsDate date in dd/MM/yyyy format
     * @author levin
     */
    public static String reverseDate(String tsDate)
    {
        String d[] = ReadBean.split(tsDate, "/");
        return d[2] + "-" + d[1] + "-" + d[0];
    }
}
