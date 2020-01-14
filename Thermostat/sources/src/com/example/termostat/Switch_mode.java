package com.example.termostat;

import java.text.NumberFormat;
import java.util.ArrayList;

public class Switch_mode implements Comparable<Switch_mode> {
    private String mode;
    private int hour;
    private int min;

    public int get_hour() {
        return hour;
    }


    public int get_min() {
        return min;
    }

    public String getMode() {
        return mode;
    }

    public Switch_mode(String mode, int hour, int min) {
        this.mode = mode;
        this.hour = hour;
        this.min = min;
    }

    public String toString() {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMinimumIntegerDigits(2);
        formatter.setMaximumIntegerDigits(2);

        String s1 = formatter.format(hour);
        String s2 = formatter.format(min);

        return "Set to " + mode + " at " + s1 + ":" + s2;
    }

    @Override
    public int compareTo(Switch_mode switch_mode) {
        if (hour > switch_mode.hour) {
            return 1;
        } else if (hour < switch_mode.hour) {
            return -1;
        } else {
            if (min > switch_mode.min)
                return 1;
            else if (min < switch_mode.min)
                return -1;
            else return 0;
        }
    }

    public static boolean can_add(ArrayList<Switch_mode> list, Switch_mode new_switch_mode) {
        int count = 0;
        for (Switch_mode switch_mode : list) {
            if (switch_mode.hour == new_switch_mode.hour && switch_mode.min == new_switch_mode.min) {
                return false;
            }
            if (switch_mode.mode.equals(new_switch_mode.mode)) {
                count++;
            }
        }
        return count != 5;
    }

}
