package com.newgen.yctg.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class DateUtil
{
    
    private static String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    
    private static String DATE_FORMAT = "yyyy-MM-dd";
    
    private static String TIME_FORMAT = "HH:mm:ss";
    
    public static final long TIME_ONE_HOUR = 3600L * 1000L;
    
    public static final long TIME_ONE_DAY = 24L * TIME_ONE_HOUR;
    
    /**
     * Get the previous time, from how many days to now.
     * 
     * @param days How many days.
     * @return The new previous time.
     */
    public static long previous(int days)
    {
        return System.currentTimeMillis() - 3600000L * 24L * days;
    }
    
    /**
     * Get the next time, from how many days to now.
     * 
     * @param days How many days.
     * @return The new next time.
     */
    public static long next(int days)
    {
        return System.currentTimeMillis() + 3600000L * 24L * days;
    }
    
    /**
     * Convert date and time to string like "yyyy-MM-dd HH:mm".
     */
    public static String formatDateTime(Date d)
    {
        return new SimpleDateFormat(DATETIME_FORMAT).format(d);
    }
    
    /**
     * Convert time to string like "HH:mm".
     */
    public static String formatTime(Date d)
    {
        return new SimpleDateFormat(TIME_FORMAT).format(d);
    }
    
    /**
     * Convert date and time to string like "yyyy-MM-dd HH:mm".
     */
    public static String formatDateTime(long d)
    {
        return new SimpleDateFormat(DATETIME_FORMAT).format(d);
    }
    
    /**
     * Convert date to String like "yyyy-MM-dd".
     */
    public static String formatDate(Date d)
    {
        return new SimpleDateFormat(DATE_FORMAT).format(d);
    }
    
    /**
     * Parse date like "yyyy-MM-dd".
     */
    public static Date parseDate(String d)
    {
        try
        {
            return new SimpleDateFormat(DATE_FORMAT).parse(d);
        }
        catch (ParseException e)
        {
        }
        return null;
    }
    
    /**
     * Parse date and time like "yyyy-MM-dd hh:mm".
     */
    public static Date parseDateTime(String dt)
    {
        try
        {
            return new SimpleDateFormat(DATETIME_FORMAT).parse(dt);
        }
        catch (Exception e)
        {
        }
        return null;
    }
    
    private static final int[] DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31,
            30, 31 };
    
    /**
     * Return today's year, month(1-12), day(1-31), week(0-6, for SUN, MON, ... SAT).
     */
    public static int[] getToday()
    {
        return getDate(Calendar.getInstance());
    }
    
    /**
     * Return today's time with hour offset.
     */
    public static long getToday(int hourOffset)
    {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis());
        c.set(Calendar.HOUR_OF_DAY, hourOffset);
        c.clear(Calendar.MINUTE);
        c.clear(Calendar.SECOND);
        c.clear(Calendar.MILLISECOND);
        return c.getTimeInMillis();
    }
    
    /**
     * Return day's year, month(1-12), day(1-31), week(0-6, for SUN, MON, ... SAT).
     */
    public static int[] getDate(long t)
    {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(t);
        return getDate(c);
    }
    
    /**
     * Return day's year, month(1-12), day(1-31), week(0-6, for SUN, MON, ... SAT).
     */
    public static int[] getDate(Calendar c)
    {
        int week = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (week == 0)
            week = 7;
        return new int[] { c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1,
                c.get(Calendar.DAY_OF_MONTH), week };
    }
    
    /**
     * Return day's year, month(1-12), day(1-31), week(0-6, for SUN, MON, ... SAT), hour, minute, second.
     */
    public static int[] getTime(long t)
    {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(t);
        return getTime(c);
    }
    
    /**
     * Return day's year, month(1-12), day(1-31), week(0-6, for SUN, MON, ... SAT), hour, minute, second.
     */
    public static int[] getTime(Calendar c)
    {
        int week = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (week == 0)
            week = 7;
        return new int[] { c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1,
                c.get(Calendar.DAY_OF_MONTH), week,
                c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE),
                c.get(Calendar.SECOND) };
    }
    
    /**
     * Get Calendar instance by specified year, month and day.
     * 
     * @param year 4-digit year.
     * @param month Month range is 1-12.
     * @param day Day range is 1-?, end depends on year and month.
     * @return A Calendar instance.
     */
    public static Calendar getCalendar(int year, int month, int day)
    {
        if (year < 2000 || year > 2100)
            throw new IllegalArgumentException();
        if (month < 1 || month > 12)
            throw new IllegalArgumentException();
        if (day < 1)
            throw new IllegalArgumentException();
        if (month == 2 && isLeapYear(year))
        {
            if (day > 29)
                throw new IllegalArgumentException();
        }
        else
        {
            if (day > DAYS[month - 1])
                throw new IllegalArgumentException();
        }
        month--;
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, day);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c;
    }
    
    public static boolean isLeapYear(int year)
    {
        if (year % 100 == 0)
        {
            return year % 400 == 0;
        }
        return year % 4 == 0;
    }
    
    public static String format(int hour, int minute, String format)
    {
        if ("HH-mm".equals(format))
        {
            StringBuilder sb = new StringBuilder(5);
            if (hour < 10)
                sb.append('0');
            sb.append(hour).append(':');
            if (minute < 10)
                sb.append('0');
            return sb.append(minute).toString();
        }
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, hour);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, 0);
        return new SimpleDateFormat(format).format(c.getTime());
    }
    
    public static String format(int year, int month, int day, String format)
    {
        if ("MM-dd".equals(format))
        {
            StringBuilder sb = new StringBuilder(5);
            return sb.append(month).append('-').append(day).toString();
        }
        if ("yyyy-MM-dd".equals(format))
        {
            StringBuilder sb = new StringBuilder(10);
            return sb.append(year)
                    .append('-')
                    .append(month)
                    .append('-')
                    .append(day)
                    .toString();
        }
        Calendar c = getCalendar(year, month, day);
        return new SimpleDateFormat(format).format(c.getTime());
    }
    
    public static int[] getPreviousDay(int year, int month, int day)
    {
        day--;
        if (day < 1)
        {
            month--;
            if (month < 1)
            {
                year--;
                month = 12;
            }
            int lastDay = DAYS[month - 1];
            if (month == 2 && isLeapYear(year))
                lastDay++;
            day = lastDay;
        }
        return new int[] { year, month, day };
    }
    
    public static int[] getNextDay(int year, int month, int day)
    {
        day++;
        int max = DAYS[month - 1];
        if (month == 2 && isLeapYear(year))
            max++;
        if (day > max)
        {
            day = 1;
            month++;
            if (month > 12)
            {
                year++;
                month = 1;
            }
        }
        return new int[] { year, month, day };
    }
}
