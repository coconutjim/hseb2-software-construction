package com.example.termostat;

import java.text.NumberFormat;
import java.util.ArrayList;

public class Schedule {

    private static Schedule instance;
    private static ArrayList<ArrayList<Switch_mode>> switches;
    public int nextHour = -1;
    public int nextMin = -1;
    public int nextId = -1;

    public ArrayList<ArrayList<Switch_mode>> getSwitches() {
        return switches;
    }

    private Schedule() {
        switches = new ArrayList<ArrayList<Switch_mode>>(7);
        for (int i = 0; i < 7; i++) {
            ArrayList<Switch_mode> list = new ArrayList<Switch_mode>();
            switches.add(list);
        }
    }

    public static Schedule getInstance() {
        if (instance == null) {
            synchronized (Timer.class) {
                if (instance == null) {
                    instance = new Schedule();
                }

            }
        }
        return instance;
    }

    public void make_changes(short minute, short hour, short day) {
        ArrayList<Switch_mode> list = switches.get(day);
        if (hour > nextHour || (hour == nextHour && minute >= nextMin)) {
            if (nextId > -1) {
                if (list.get(nextId).getMode().equals("Day")) {
                    Timer.getInstance().settime_of_day("Day");
                    Main_thermo_activity.time_of_day = "Day";
                    Main_thermo_activity.current_temperature = Temperature_activity.tempDay;
                } else {
                    Timer.getInstance().settime_of_day("Night");
                    Main_thermo_activity.time_of_day = "Night";
                    Main_thermo_activity.current_temperature = Temperature_activity.tempNight;
                }
            }
            for (int i = 0; i < list.size(); i++) {
                if (hour < list.get(i).get_hour()
                        || (hour == list.get(i).get_hour() && minute <= list
                        .get(i).get_min())) {
                    nextId = i;
                    nextMin = list.get(i).get_min();
                    nextHour = list.get(i).get_hour();
                    return;
                }
            }
            nextId = -1;
        }

    }

    public String getNextSwitch() {
        if (nextId == -1) {
            return "switch to Night at 00:00";
        } else {
                ArrayList<Switch_mode> list = switches.get(Timer.getInstance()
                        .getDay());

                Switch_mode switchMode = list.get(nextId);
                NumberFormat formatter = NumberFormat.getNumberInstance();
                formatter.setMinimumIntegerDigits(2);
                formatter.setMaximumIntegerDigits(2);
                String minutes = formatter.format(switchMode.get_min());
                String HOURS = formatter.format(switchMode.get_hour());

                return String.valueOf("switch to " + switchMode.getMode() + " at "
                        + HOURS + ":" + minutes);
            }
        }
    }
