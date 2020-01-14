package com.example.termostat;

/**
 * Enum for days
 * There are 7 days(Monday - Sunday)
 */
public enum Days {
    Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday;

    public static Days getDayById(int value) {
        switch (value) {
            case 0:
                return Monday;
            case 1:
                return Tuesday;
            case 2:
                return Wednesday;
            case 3:
                return Thursday;
            case 4:
                return Friday;
            case 5:
                return Saturday;
            case 6:
                return Sunday;
            default:
                return null;
        }
    }
}
