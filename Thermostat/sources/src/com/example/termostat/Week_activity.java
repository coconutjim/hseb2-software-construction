package com.example.termostat;

import java.text.NumberFormat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Week_activity extends Activity {
    public short minutes;
    public short hours;
    public short day;
    public String time_of_day;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week_overview_activity);

        timer = Timer.getInstance();

        set_buttons();
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

                    TextView currentMode = (TextView) findViewById(R.id.Current_mode);
                    currentMode.setText(String.valueOf("Day"
                            + " "
                            + Temperature_activity
                            .get_temperature(Main_thermo_activity.current_temperature)));

                }

                if (time_of_day.equals("Night")) {

                    TextView currentMode = (TextView) findViewById(R.id.Current_mode);
                    currentMode.setText(String.valueOf("Night"
                            + " "
                            + Temperature_activity
                            .get_temperature(Main_thermo_activity.current_temperature)));

                }

                TextView currentTime = (TextView) findViewById(R.id.Current_time);
                Days currentDay = Days.getDayById(day);

                NumberFormat formatter = NumberFormat.getNumberInstance();
                formatter.setMinimumIntegerDigits(2);
                formatter.setMaximumIntegerDigits(2);
                String MINUTES = formatter.format(minutes);
                String HOURS = formatter.format(hours);

                currentTime.setText(String.valueOf(currentDay + " " + HOURS
                        + ":" + MINUTES));
                handler.postDelayed(this, 200);
            }
        };
        handler.postDelayed(r, 200);
    }

    private void set_buttons() {
        Button MondayButton = (Button) findViewById(R.id.Monday_button);
        Button TuesdayButton = (Button) findViewById(R.id.Tuesday_button);
        Button WednesdayButton = (Button) findViewById(R.id.Wednesday_button);
        Button ThursdayButton = (Button) findViewById(R.id.Thursday_button);
        Button FridayButton = (Button) findViewById(R.id.Friday_button);
        Button SaturdayButton = (Button) findViewById(R.id.Saturday_button);
        Button SundayButton = (Button) findViewById(R.id.Sunday_button);

        // listener for MondayButton
        MondayButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Day_activity.current_day = 0;
                Day_activity.selected_index = 0;
                Intent intent = new Intent(v.getContext(), Day_activity.class);
                startActivity(intent);
            }
        });

        // listener for TuesdayButton
        TuesdayButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Day_activity.current_day = 1;
                Day_activity.selected_index = 1;
                Intent intent = new Intent(v.getContext(), Day_activity.class);
                startActivity(intent);
            }
        });

        // listener for WednesdayButton
        WednesdayButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Day_activity.current_day = 2;
                Day_activity.selected_index = 2;
                Intent intent = new Intent(v.getContext(), Day_activity.class);
                startActivity(intent);
            }
        });

        // listener for ThursdayButton
        ThursdayButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Day_activity.current_day = 3;
                Day_activity.selected_index = 3;
                Intent intent = new Intent(v.getContext(), Day_activity.class);
                startActivity(intent);
            }
        });

        // listener for FridayButton
        FridayButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Day_activity.current_day = 4;
                Day_activity.selected_index = 4;
                Intent intent = new Intent(v.getContext(), Day_activity.class);
                startActivity(intent);
            }
        });

        // listener for SaturdayButton
        SaturdayButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Day_activity.current_day = 5;
                Day_activity.selected_index = 5;
                Intent intent = new Intent(v.getContext(), Day_activity.class);
                startActivity(intent);
            }
        });

        // listener for SundayButton
        SundayButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Day_activity.current_day = 6;
                Day_activity.selected_index = 6;
                Intent intent = new Intent(v.getContext(), Day_activity.class);
                startActivity(intent);
            }
        });
    }

}
