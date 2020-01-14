package com.example.termostat;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;

import android.app.Activity;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Day_activity extends Activity {
    private Button addSwitchButton;
    private static ListView switchesListView;
    private static ArrayList<ArrayList<Switch_mode>> switches;
    private static Day_activity instance;
    public static int selected_index;
    private static int current_position;
    public static short current_day;
    public short minutes;
    public short hours;
    public short day;
    public String time_of_day;
    private Timer timer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day_switches_list_activity);

        Schedule schedule = Schedule.getInstance();
        switches = schedule.getSwitches();

        // initialization
        timer = Timer.getInstance();
        instance = this;
        TextView textView = (TextView) findViewById(R.id.day_activity_text_view);
        textView.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        addSwitchButton = (Button) findViewById(R.id.day_acitivity_add_switch_button);
        switchesListView = (ListView) findViewById(R.id.DayActivityswitchesListView);
        addSwitchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Switch_dialog().show(getFragmentManager(), null);
            }
        });
        switchesListView
                .setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {
                        current_position = position;
                        new Delete_switch_dialog().show(getFragmentManager(),
                                null);
                    }
                });

        // thread for update time
        update_time();
    }

    private void update_time() {
        final Handler handler = new Handler();

        final Runnable r = new Runnable() {
            public void run() {
                minutes = timer.getminutes();
                hours = timer.getHours();
                day = timer.getDay();
                time_of_day = timer.gettime_of_day();

                if (time_of_day.equals("Day")) {

                    TextView currentMode = (TextView) findViewById(R.id.day_activity_current_mode);
                    currentMode.setText(String.valueOf("Day"
                            + " "
                            + Temperature_activity
                            .get_temperature(Main_thermo_activity.current_temperature)));

                }

                if (time_of_day.equals("Night")) {

                    TextView currentMode = (TextView) findViewById(R.id.day_activity_current_mode);
                    currentMode.setText(String.valueOf("Night"
                            + " "
                            + Temperature_activity
                            .get_temperature(Main_thermo_activity.current_temperature)));

                }

                TextView currentTime = (TextView) findViewById(R.id.day_activity_current_time);
                Days currentDay = Days.getDayById(day);

                NumberFormat formatter = NumberFormat.getNumberInstance();
                formatter.setMinimumIntegerDigits(2);
                formatter.setMaximumIntegerDigits(2);
                String minutes = formatter.format(Day_activity.this.minutes);
                String HOURS = formatter.format(hours);

                currentTime.setText(String.valueOf(currentDay + " " + HOURS
                        + ":" + minutes));
                handler.postDelayed(this, 200);
            }
        };
        handler.postDelayed(r, 200);
    }

    public static void addSwitch(Switch_mode newSwitch) {
        if (Switch_mode.can_add(switches.get(current_day), newSwitch)) {
            switches.get(current_day).add(newSwitch);
            Collections.sort(switches.get(current_day));
            ArrayList<String> switchesModes = new ArrayList<String>();
            for (Switch_mode switchMode : switches.get(current_day)) {
                switchesModes.add(switchMode.toString());
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(instance,
                    R.layout.my_list_item, switchesModes);
            switchesListView.setAdapter(adapter);

            Schedule.getInstance().nextHour = -1;
            Schedule.getInstance().nextId = -1;
            Schedule.getInstance().nextMin = -1;
            Timer timer = Timer.getInstance();
            Schedule.getInstance().make_changes(timer.getminutes(),
                    timer.getHours(), timer.getDay());
        } else {
            Toast toast = Toast.makeText(instance.getApplicationContext(),
                    "Can't be more than 5 " + newSwitch.getMode()
                            + " switches or switches with the same time",
                    Toast.LENGTH_SHORT
            );
            toast.show();
        }
    }

    public static void deleteCurrentPosition() {
        switches.get(current_day).remove(current_position);
        ArrayList<String> switchesModes = new ArrayList<String>();
        for (Switch_mode switchMode : switches.get(current_day)) {
            switchesModes.add(switchMode.toString());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(instance,
                R.layout.my_list_item, switchesModes);
        switchesListView.setAdapter(adapter);

        Schedule.getInstance().nextHour = -1;
        Schedule.getInstance().nextId = -1;
        Schedule.getInstance().nextMin = -1;
        Timer timer = Timer.getInstance();
        Schedule.getInstance().make_changes(timer.getminutes(), timer.getHours(),
                timer.getDay());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Schedule schedule = Schedule.getInstance();
        switches = schedule.getSwitches();

        ArrayList<String> switchesModes = new ArrayList<String>();
        for (Switch_mode switchMode : switches.get(current_day)) {
            switchesModes.add(switchMode.toString());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(instance,
                R.layout.my_list_item, switchesModes);
        switchesListView.setAdapter(adapter);

        TextView day = (TextView) findViewById(R.id.day_activity_text_view);
        Days currentDay = Days.getDayById(selected_index);
        day.setText(String.valueOf(currentDay + " switches"));

    }

}
