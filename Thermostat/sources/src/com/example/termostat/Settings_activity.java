package com.example.termostat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * Created by Alexander on 01.06.2014.
 */
public class Settings_activity extends Activity {
    // listener for plus
    private Button temperature;
    private Button settings;
    private Button week;

    public String time_of_day;
    public short minutes;
    public short hours;
    public short day;
    Timer timer = Timer.getInstance();

    private void update_time() {
        final Handler handler = new Handler();

        final Runnable r = new Runnable() {
            public void run() {
                time_of_day = timer.gettime_of_day();

                if (time_of_day.equals("Day")) {
                    if (Main_thermo_activity.enabled) {

                        TextView currentMode = (TextView) findViewById(R.id.settings_mode);
                        currentMode.setText(String.valueOf("Day"
                                + " "
                                + Temperature_activity
                                .get_temperature(Main_thermo_activity.current_temperature)));
                    } else {
                        TextView currentMode = (TextView) findViewById(R.id.settings_mode);
                        currentMode.setText(String.valueOf(Temperature_activity
                                .get_temperature(Main_thermo_activity.current_temperature)));
                    }
                }

                if (time_of_day.equals("Night")) {
                    if (Main_thermo_activity.enabled) {
                        TextView currentMode = (TextView) findViewById(R.id.settings_mode);
                        currentMode.setText(String.valueOf("Night"
                                + " "
                                + Temperature_activity
                                .get_temperature(Main_thermo_activity.current_temperature)));
                    } else {
                        TextView currentMode = (TextView) findViewById(R.id.settings_mode);
                        currentMode.setText(String.valueOf(Temperature_activity
                                .get_temperature(Main_thermo_activity.current_temperature)));
                    }

                }

                TextView currentTime = (TextView) findViewById(R.id.settings_cur_t);
                Days currentDay = Days.getDayById(day);

                minutes = timer.getminutes();
                hours = timer.getHours();
                day = timer.getDay();

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        temperature = (Button) findViewById(R.id.temperature_button_settings);
        settings = (Button) findViewById(R.id.set_settings);
        week = (Button) findViewById(R.id.week_bt_settings);
        temperature.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),
                        Temperature_activity.class);
                startActivity(intent);
            }
        });

        // listener for setting_time_day_activity
        settings.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),
                        Settings_day_activity.class);
                startActivity(intent);
            }
        });
        // listener for week_overview_activity
        week.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Week_activity.class);
                startActivity(intent);
            }
        });
        update_time();
    }
}
