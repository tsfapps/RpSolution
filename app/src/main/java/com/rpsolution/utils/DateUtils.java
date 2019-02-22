package com.rpsolution.utils;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String timeDiff(String dateStart, String dateStop) {
        String dH = "";
        try {
            @SuppressLint("SimpleDateFormat") SimpleDateFormat format = new SimpleDateFormat(ConstantVal.INPUT_DATE_FORMAT);

            Date d1 = format.parse(dateStart);
            Date d2 = format.parse(dateStop);
            long diff = d2.getTime() - d1.getTime();

            long diffMinutes = diff / (60 * 1000) % 60;
            long diffHours = diff / (60 * 60 * 1000) % 24;
            long diffDays = diff / (24 * 60 * 60 * 1000);
            if (diffDays > 0) {
                dH = String.valueOf(diffDays + " days ");
            } else if (diffHours > 0) {
                dH = String.valueOf((diffHours) + " hr " + (diffMinutes) + " min");
            } else {
                dH = String.valueOf((diffMinutes) + " min");
            }


        } catch (Exception e) {
            CustomLog.e("DateUtil",e.toString());
        }
        return dH;
    }

}
