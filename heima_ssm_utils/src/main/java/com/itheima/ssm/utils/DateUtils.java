package com.itheima.ssm.utils;

import org.apache.log4j.helpers.DateTimeDateFormat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: QX
 * @Date: 2019/9/24 12:55
 * @Version 1.0
 */
public class DateUtils {
    public static String dateToString(Date date,String pattern){
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        String dateStr = dateFormat.format(date);
        return dateStr;
    }

    public static Date stringToDate(String dateStr, String pattern) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        Date date = dateFormat.parse(dateStr);
        return date;
    }
}
