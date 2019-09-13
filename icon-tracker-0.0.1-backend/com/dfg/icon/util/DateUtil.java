// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import java.util.Locale;
import java.util.Date;

public class DateUtil
{
    public static final String getFormattedDateString(final Date date, final String format, final Locale locale, final TimeZone timeZone) {
        final SimpleDateFormat sdf = new SimpleDateFormat(format, locale);
        sdf.setTimeZone(timeZone);
        return sdf.format(date);
    }
    
    public static final String getFormattedDateString(final Date date, final String format) {
        return getFormattedDateString(date, format, Locale.getDefault(), TimeZone.getDefault());
    }
    
    public static final String getFormattedDateStringByNow(final String format) {
        return getFormattedDateString(getNowDate(), format, Locale.getDefault(), TimeZone.getDefault());
    }
    
    public static Date getFormattedDate(final String checkTime, final String format) throws ParseException {
        final SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(checkTime);
    }
    
    public static Date getNowDate() {
        final String pattern = "yyyyMMddHHmmss";
        final String now = getFormattedDateString(new Date(), pattern);
        try {
            return getFormattedDate(now, pattern);
        }
        catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static Calendar getNowCalendar() {
        final Calendar cal = Calendar.getInstance(Locale.getDefault());
        cal.setTime(getNowDate());
        return cal;
    }
    
    public static Date getNextDateWithDateType(final Date date, final int fieldType, final int nextValue) {
        final Calendar cal = getNowCalendar();
        cal.setTime(date);
        cal.set(fieldType, cal.get(fieldType) + nextValue);
        return cal.getTime();
    }
    
    public static int getWeekVal(final Date date) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(3);
    }
    
    public static List<String> getChartDailyList() {
        final List<String> res = new ArrayList<String>();
        final Calendar cal = getNowCalendar();
        cal.add(5, -1);
        for (int i = 0; i < 14; ++i) {
            final String yyyyMMdd = String.format("%s-%02d-%02d", cal.get(1), cal.get(2) + 1, cal.get(5));
            res.add(yyyyMMdd);
            cal.add(5, -1);
        }
        return res;
    }
}
