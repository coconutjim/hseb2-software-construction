package com.example.termostat;

import android.os.Handler;

public class Timer {

    private static short minutes = 40;
    private static short hours = 15;
    private static short day = 0;
    private static String time_of_day = "Day";

    public short getminutes() {
        return minutes;
    }

    public void setminutes(short minutes) {
        Timer.minutes = minutes;
    }

    public short getHours() {
        return hours;
    }

    public void setHours(short hours) {
        Timer.hours = hours;
    }

    public short getDay() {
        return day;
    }

    public void setDay(short day) {
        Timer.day = day;
    }

    public String gettime_of_day() {
        return time_of_day;
    }

    public void settime_of_day(String time_of_day) {
        Timer.time_of_day = time_of_day;
    }

    private static Timer instance;

    private Timer() {
        final Handler handler = new Handler();

        final Runnable r = new Runnable() {
            public void run() {
                minutes += 1;
                if (minutes >= 60) {
                    hours += 1;
                    minutes = (short) (minutes - 60);
                }
                if (hours == 24) {
                    day += 1;
                    hours = 0;
                    time_of_day = "Night";
                    Schedule.getInstance().nextHour = -1;
                    Schedule.getInstance().nextId = -1;
                    Schedule.getInstance().nextMin = -1;

                }
                if (day == 7) {
                    day = 0;
                }
                handler.postDelayed(this, 200);
            }
        };
        handler.postDelayed(r, 1);
    }

    public static Timer getInstance() {
        if (instance == null) {
            synchronized (Timer.class) {
                if (instance == null) {
                    instance = new Timer();
                }

            }
        }
        return instance;
    }

}
