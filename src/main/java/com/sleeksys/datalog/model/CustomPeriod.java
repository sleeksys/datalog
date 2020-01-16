package com.sleeksys.datalog.model;

import java.util.Calendar;
import java.util.Date;

public enum CustomPeriod {

    HOUR("hour"),
    HALF_DAY("half-day"),
    DAY("day"),
    LAST_24_HOURS("24-hours"),
    WEEK("week"),
    LAST_7_DAYS("7-days"),
    MONTH("month"),
    LAST_31_DAYS("31-days"),
    LAST_6_MONTHS("6-months"),
    YEAR("year");

    private final String value;

    CustomPeriod(String value) {
        this.value = value;
    }

    public static CustomPeriod valueOfLabel(String value) {
        for (CustomPeriod e: values()) {
            if (e.value.equals(value)) {
                return e;
            }
        }
        return null;
    }

    public static Long getStartDate(String value) {
        Calendar calendar = Calendar.getInstance();
        CustomPeriod period = CustomPeriod.valueOfLabel(value);

        switch (period) {
            case HOUR:
                calendar.add(calendar.HOUR, -1);
                break;

            case HALF_DAY:
                calendar.add(calendar.HOUR, -6);
                break;

            case DAY:
                calendar.set(Calendar.HOUR_OF_DAY, 0);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 0);
                break;

            case LAST_24_HOURS:
                calendar.add(calendar.HOUR, -24);
                break;

            case WEEK:
                calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
                break;

            case LAST_7_DAYS:
                calendar.add(calendar.DATE, -7);
                break;

            case MONTH:
                calendar.set(Calendar.DAY_OF_MONTH, 1);
                calendar.set(Calendar.HOUR_OF_DAY, 0);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 0);
                break;

            case LAST_31_DAYS:
                calendar.add(calendar.DATE, -31);
                break;

            case LAST_6_MONTHS:
                calendar.add(calendar.MONTH, -6);
                break;

            case YEAR:
                calendar.set(Calendar.MONTH, 0);
                calendar.set(Calendar.DAY_OF_MONTH, 1);
                calendar.set(Calendar.HOUR_OF_DAY, 0);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 0);
                break;
        }

        Date date = calendar.getTime();
        return date.getTime();
    }

    public static Long getEndDate() {
        return new Date().getTime();
    }
}
