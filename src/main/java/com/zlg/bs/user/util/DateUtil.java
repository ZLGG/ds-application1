package com.zlg.bs.user.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateUtil {
    public static long millionSecondsOfDay = 86400000L;
    public static long millionSecondsOfHour = 3600000L;
    private static final String FORMAT_DATE_STR = "yyyy-MM-dd";

    public DateUtil() {
    }

    public static int getDifferYear(Date date1, Date date2) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(date1);
        c2.setTime(date2);
        return c2.get(1) - c1.get(1);
    }

    public static int getDifferYear(String date1, String date2) {
        Date dateTime1_tmp = parse(date1, "yyyy-MM-dd");
        Date dateTime2_tmp = parse(date2, "yyyy-MM-dd");
        return getDifferYear(dateTime1_tmp, dateTime2_tmp);
    }

    public static int getDifferMonth(Date date1, Date date2) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(date1);
        c2.setTime(date2);
        int year = getDifferYear(date1, date2);
        int months = c2.get(2) - c1.get(2) + year * 12;
        if (c2.get(5) < c1.get(5)) {
            --months;
        }

        return months;
    }

    public static int getDifferMonth(String date1, String date2) {
        Date dateTime1_tmp = parse(date1, "yyyy-MM-dd");
        Date dateTime2_tmp = parse(date2, "yyyy-MM-dd");
        return getDifferMonth(dateTime1_tmp, dateTime2_tmp);
    }

    /** @deprecated */
    private static int getDifferDay(Date date1, Date date2) {
        Long d1 = date1.getTime();
        Long d2 = date2.getTime();
        return (int)((d2 - d1) / millionSecondsOfDay);
    }

    public static int getDifferDay(String date1, String date2) {
        Date dateTime1_tmp = parse(date1, "yyyy-MM-dd");
        Date dateTime2_tmp = parse(date2, "yyyy-MM-dd");
        Long d1 = dateTime1_tmp.getTime();
        Long d2 = dateTime2_tmp.getTime();
        return (int)((d2 - d1) / millionSecondsOfDay);
    }

    public static int[] getDifferHourAndMinute(String date1, String time1, String date2, String time2) {
        Date dateTime1_tmp = parse(date1 + " " + time1, "yyyy-MM-dd HH:mm");
        Date dateTime2_tmp = parse(date2 + " " + time2, "yyyy-MM-dd HH:mm");
        Long d2 = dateTime2_tmp.getTime();
        Long d1 = dateTime1_tmp.getTime();
        int hours = (int)((d2 - d1) / millionSecondsOfHour);
        int mins = (int)((d2 - d1) % millionSecondsOfHour);
        mins /= 60000;
        int[] resultHM = new int[]{hours, mins};
        return resultHM;
    }

    public static int[] getDifferHourAndMinute(Date date1, Date date2) {
        Long d2 = date2.getTime();
        Long d1 = date1.getTime();
        int hours = (int)((d2 - d1) / millionSecondsOfHour);
        int mins = (int)((d2 - d1) % millionSecondsOfHour);
        mins /= 60000;
        int[] resultHM = new int[]{hours, mins};
        return resultHM;
    }

    public static int[] getDifferHourAndMinute(String date1, String date2) {
        Date dateTime1_tmp = parse(date1, "yyyy-MM-dd HH:mm");
        Date dateTime2_tmp = parse(date2, "yyyy-MM-dd HH:mm");
        Long d2 = dateTime2_tmp.getTime();
        Long d1 = dateTime1_tmp.getTime();
        int hours = (int)((d2 - d1) / millionSecondsOfHour);
        int mins = (int)((d2 - d1) % millionSecondsOfHour);
        mins /= 60000;
        int[] resultHM = new int[]{hours, mins};
        return resultHM;
    }

    public static int getDifferHour(Date date1, Date date2) {
        Long d1 = date1.getTime();
        Long d2 = date2.getTime();
        int hours = (int)((d2 - d1) / millionSecondsOfHour);
        return hours;
    }

    public static int getDifferHour(String date1, String date2) {
        Date dateTime1_tmp = parse(date1, "yyyy-MM-dd HH:mm");
        Date dateTime2_tmp = parse(date2, "yyyy-MM-dd HH:mm");
        Long d2 = dateTime2_tmp.getTime();
        Long d1 = dateTime1_tmp.getTime();
        int hours = (int)((d2 - d1) / millionSecondsOfHour);
        return hours;
    }

    public static int getDifferMinute(String date1, String date2) {
        Date dateTime1_tmp = parse(date1, "yyyy-MM-dd HH:mm");
        Date dateTime2_tmp = parse(date2, "yyyy-MM-dd HH:mm");
        return getDifferMinute(dateTime1_tmp, dateTime2_tmp);
    }

    public static int getDifferMinute(Date date1, Date date2) {
        Long d2 = date2.getTime();
        Long d1 = date1.getTime();
        int hours = (int)((d2 - d1) / 60000L);
        return hours;
    }

    public static Date addYear(Date date, int years) {
        Calendar c = new GregorianCalendar();
        c.setTime(date);
        c.add(1, years);
        return c.getTime();
    }

    public static Date addMonth(Date date, int months) {
        Calendar c = new GregorianCalendar();
        c.setTime(date);
        c.add(2, months);
        return c.getTime();
    }

    public static Date addDay(Date date, int days) {
        Calendar c = new GregorianCalendar();
        c.setTime(date);
        c.add(5, days);
        return c.getTime();
    }

    public static Date minusDay(Date date, int days) {
        Calendar c = new GregorianCalendar();
        c.setTime(date);
        c.set(5, c.get(5) - days);
        return c.getTime();
    }

    public static Date addMinutes(Date date, int minutes) {
        Calendar c = new GregorianCalendar();
        c.setTime(date);
        c.add(12, minutes);
        return c.getTime();
    }

    public static Date addHour(Date date, int hour) {
        Calendar c = new GregorianCalendar();
        c.setTime(date);
        c.add(10, hour);
        return c.getTime();
    }

    public static String format(Date date) {
        return format(date, "yyyy-MM-dd");
    }

    public static String format(Date date, String formater) {
        SimpleDateFormat sdf = new SimpleDateFormat(formater);
        return sdf.format(date);
    }

    public static Date parse(String date) {
        return parse(date, "yyyy-MM-dd");
    }

    public static Date parse(String date, String formater) {
        SimpleDateFormat sdf = new SimpleDateFormat(formater);
        Date result = null;

        try {
            result = sdf.parse(date);
        } catch (Exception var5) {
            var5.printStackTrace();
        }

        return result;
    }

    public static int getWeekOfDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(7) - 1 == 0 ? 7 : calendar.get(7) - 1;
    }

    public static String getWeekTextOfDate(Date date) {
        String[] dayNames = new String[]{"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        int t = getWeekOfDate(date);
        if (t == 7) {
            t = 0;
        }

        return dayNames[t];
    }

    public static String getCurrenDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        return sdf.format(d).toString();
    }

    public static String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = new Date();
        return sdf.format(d).toString();
    }

    public static java.sql.Date convertUtilDateToSQLDate(Date date) {
        if (date == null) {
            return null;
        } else {
            Calendar cl = Calendar.getInstance();
            cl.setTime(date);
            java.sql.Date jd = new java.sql.Date(cl.getTimeInMillis());
            return jd;
        }
    }

    public static Date convertSQLDateToUtilDate(java.sql.Date date) {
        if (date == null) {
            return null;
        } else {
            Calendar cl = Calendar.getInstance();
            cl.setTime(date);
            Date jd = new Date(cl.getTimeInMillis());
            return jd;
        }
    }

    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 4 == 0) {
            return year % 100 != 0;
        } else {
            return false;
        }
    }

    public static boolean isToday(Date date) {
        Calendar today = Calendar.getInstance();
        today.setTime(new Date());
        Calendar day = Calendar.getInstance();
        day.setTime(date);
        return today.get(1) == day.get(1) && today.get(2) == day.get(2) && today.get(5) == day.get(5);
    }

    public static Timestamp getSysTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    public static Date getSysDate() {
        Calendar cl = Calendar.getInstance();
        return cl.getTime();
    }

    public static boolean isBetweenDateByClosedInterval(Date date1, Date date2) {
        String nowDate = format(new Date(), "yyyy-MM-dd");
        String sDate1 = format(date1, "yyyy-MM-dd");
        String sDate2 = format(date2, "yyyy-MM-dd");
        if (!java.sql.Date.valueOf(sDate1).before(java.sql.Date.valueOf(sDate2)) && !java.sql.Date.valueOf(sDate1).equals(java.sql.Date.valueOf(sDate2))) {
            return (java.sql.Date.valueOf(nowDate).after(java.sql.Date.valueOf(sDate2)) || java.sql.Date.valueOf(nowDate).equals(java.sql.Date.valueOf(sDate2))) && java.sql.Date.valueOf(nowDate).before(java.sql.Date.valueOf(sDate1)) || java.sql.Date.valueOf(nowDate).equals(java.sql.Date.valueOf(sDate1));
        } else {
            return (java.sql.Date.valueOf(nowDate).after(java.sql.Date.valueOf(sDate1)) || java.sql.Date.valueOf(nowDate).equals(java.sql.Date.valueOf(sDate1))) && (java.sql.Date.valueOf(nowDate).before(java.sql.Date.valueOf(sDate2)) || java.sql.Date.valueOf(nowDate).equals(java.sql.Date.valueOf(sDate2)));
        }
    }

    public static boolean isBetweenDateByOpenInterval(Date date1, Date date2) {
        String nowDate = format(new Date(), "yyyy-MM-dd");
        String sDate1 = format(date1, "yyyy-MM-dd");
        String sDate2 = format(date2, "yyyy-MM-dd");
        if (java.sql.Date.valueOf(sDate1).before(java.sql.Date.valueOf(sDate2))) {
            return java.sql.Date.valueOf(nowDate).after(java.sql.Date.valueOf(sDate1)) && java.sql.Date.valueOf(nowDate).before(java.sql.Date.valueOf(sDate2));
        } else if (java.sql.Date.valueOf(sDate1).after(java.sql.Date.valueOf(sDate2))) {
            return java.sql.Date.valueOf(nowDate).after(java.sql.Date.valueOf(sDate2)) && java.sql.Date.valueOf(nowDate).before(java.sql.Date.valueOf(sDate1));
        } else {
            return false;
        }
    }

    public static boolean DateisBetweenDateByClosedInterval(Date curDate, String sDate1, String date2) {
        String nowDate = format(curDate, "yyyy-MM-dd");
        if (!java.sql.Date.valueOf(sDate1).before(java.sql.Date.valueOf(date2)) && !java.sql.Date.valueOf(sDate1).equals(java.sql.Date.valueOf(date2))) {
            return (java.sql.Date.valueOf(nowDate).after(java.sql.Date.valueOf(date2)) || java.sql.Date.valueOf(nowDate).equals(java.sql.Date.valueOf(date2))) && java.sql.Date.valueOf(nowDate).before(java.sql.Date.valueOf(sDate1)) || java.sql.Date.valueOf(nowDate).equals(java.sql.Date.valueOf(sDate1));
        } else {
            return (java.sql.Date.valueOf(nowDate).after(java.sql.Date.valueOf(sDate1)) || java.sql.Date.valueOf(nowDate).equals(java.sql.Date.valueOf(sDate1))) && (java.sql.Date.valueOf(nowDate).before(java.sql.Date.valueOf(date2)) || java.sql.Date.valueOf(nowDate).equals(java.sql.Date.valueOf(date2)));
        }
    }

    public static boolean DateisBetweenDateByOpenInterval(Date curDate, String sDate1, String date2) {
        String nowDate = format(curDate, "yyyy-MM-dd");
        if (java.sql.Date.valueOf(sDate1).before(java.sql.Date.valueOf(date2))) {
            return java.sql.Date.valueOf(nowDate).after(java.sql.Date.valueOf(sDate1)) && java.sql.Date.valueOf(nowDate).before(java.sql.Date.valueOf(date2));
        } else if (java.sql.Date.valueOf(sDate1).after(java.sql.Date.valueOf(date2))) {
            return java.sql.Date.valueOf(nowDate).after(java.sql.Date.valueOf(date2)) && java.sql.Date.valueOf(nowDate).before(java.sql.Date.valueOf(sDate1));
        } else {
            return false;
        }
    }

    public static boolean isBetweenDateByClosedInterval(String sDate1, String date2) {
        String nowDate = format(new Date(), "yyyy-MM-dd");
        if (!java.sql.Date.valueOf(sDate1).before(java.sql.Date.valueOf(date2)) && !java.sql.Date.valueOf(sDate1).equals(java.sql.Date.valueOf(date2))) {
            return (java.sql.Date.valueOf(nowDate).after(java.sql.Date.valueOf(date2)) || java.sql.Date.valueOf(nowDate).equals(java.sql.Date.valueOf(date2))) && java.sql.Date.valueOf(nowDate).before(java.sql.Date.valueOf(sDate1)) || java.sql.Date.valueOf(nowDate).equals(java.sql.Date.valueOf(sDate1));
        } else {
            return (java.sql.Date.valueOf(nowDate).after(java.sql.Date.valueOf(sDate1)) || java.sql.Date.valueOf(nowDate).equals(java.sql.Date.valueOf(sDate1))) && (java.sql.Date.valueOf(nowDate).before(java.sql.Date.valueOf(date2)) || java.sql.Date.valueOf(nowDate).equals(java.sql.Date.valueOf(date2)));
        }
    }

    public static boolean isBetweenDateByOpenInterval(String sDate1, String date2) {
        String nowDate = format(new Date(), "yyyy-MM-dd");
        if (java.sql.Date.valueOf(sDate1).before(java.sql.Date.valueOf(date2))) {
            return java.sql.Date.valueOf(nowDate).after(java.sql.Date.valueOf(sDate1)) && java.sql.Date.valueOf(nowDate).before(java.sql.Date.valueOf(date2));
        } else if (java.sql.Date.valueOf(sDate1).after(java.sql.Date.valueOf(date2))) {
            return java.sql.Date.valueOf(nowDate).after(java.sql.Date.valueOf(date2)) && java.sql.Date.valueOf(nowDate).before(java.sql.Date.valueOf(sDate1));
        } else {
            return false;
        }
    }

    public static String formatToEng(String date) {
        DateFormat df = new SimpleDateFormat("MMM", Locale.ENGLISH);
        return df.format(parse(date));
    }

    public static String getCurrentTimeNum() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        Date d = new Date();
        return sdf.format(d).toString();
    }

    public static int[] getTimeByCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(1);
        int month = cal.get(2) + 1;
        int day = cal.get(5);
        int hour = cal.get(11);
        int minute = cal.get(12);
        int second = cal.get(13);
        int[] str = new int[]{year, month, day, hour, minute, second};
        System.out.println("现在的时间是：公元" + year + "年" + month + "月" + day + "日      " + hour + "时" + minute + "分" + second + "秒       星期");
        return str;
    }
}