package com.example.news.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeConversion {
    private static DateFormat outputFormatShortDate = new SimpleDateFormat("MM/dd/yy hh:mm a", Locale.US);

    public static String fullDateToShortDate(Date date) {
        return outputFormatShortDate.format(date);
    }
}
