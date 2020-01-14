package com.example.termostat;

import java.text.NumberFormat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

public class Settings_day_activity extends Activity {

    public short minutes;
    public short hours;
    public short day;
    public String time_of_day;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_time_day_activity);
        timer = Timer.getInstance();

        // initialization
        final TimePicker timePicker = (TimePicker) findViewById(R.id.SettingsActivityTimePicker);
        timePicker.setIs24HourView(true);
        Button buttonCancel = (Button) findViewById(R.id.setting_time_day_cancel);
        Button buttonOk = (Button) findViewById(R.id.setting_time_day_ok);
        final Spinner spinner = (Spinner) findViewById(R.id.setting_time_day_spinner);
        spinner.setAdapter(new ArrayAdapter<String>(this, R.layout.spinner_item, new String[]{"Monday", "Thursday", "Wednesday", "Thursday", "Friday",
                "Saturday", "Sunday"}));
        // listener for ok
        buttonOk.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                int houR = timePicker.getCurrentHour();
                int minutes = timePicker.getCurrentMinute();
                int daY = spinner.getSelectedItemPosition();

                timer.setminutes((short) minutes);
                timer.setHours((short) houR);
                timer.setDay((short) daY);

                Schedule.getInstance().nextHour = -1;
                Schedule.getInstance().nextId = -1;
                Schedule.getInstance().nextMin = -1;

                Intent intent = new Intent(v.getContext(),
                Main_thermo_activity.class);
                finish();
                startActivity(intent);
            }
        });

        // listener for cancel
        buttonCancel.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(v.getContext(),
                Settings_activity.class);
                startActivity(intent);
            }
        });

        // thread for update time
        update_time();
    }

    private void update_time() {
        final Handler handler = new Handler();

        final Runnable r = new Runnable() {
            public void run() {
                time_of_day = timer.gettime_of_day();

                if (time_of_day.equals("Day")) {
                    if (Main_thermo_activity.enabled) {

                        TextView currentMode = (TextView) findViewById(R.id.SettingsActivityCurrentMode);
                        currentMode.setText(String.valueOf("Day"
                                + " "
                                + Temperature_activity
                                .get_temperature(Main_thermo_activity.current_temperature)));
                    } else {
                        TextView currentMode = (TextView) findViewById(R.id.SettingsActivityCurrentMode);
                        currentMode.setText(String.valueOf(Temperature_activity
                                .get_temperature(Main_thermo_activity.current_temperature)));
                    }
                }

                if (time_of_day.equals("Night")) {
                    if (Main_thermo_activity.enabled) {
                        TextView currentMode = (TextView) findViewById(R.id.SettingsActivityCurrentMode);
                        currentMode.setText(String.valueOf("Night"
                                + " "
                                + Temperature_activity
                                .get_temperature(Main_thermo_activity.current_temperature)));
                    } else {
                        TextView currentMode = (TextView) findViewById(R.id.SettingsActivityCurrentMode);
                        currentMode.setText(String.valueOf(Temperature_activity
                                .get_temperature(Main_thermo_activity.current_temperature)));
                    }

                }

                TextView currentTime = (TextView) findViewById(R.id.SettingsActivityCurrentTime);
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
    protected void onStart() {
        super.onStart();
        Timer timer = Timer.getInstance();
        TimePicker timePicker = (TimePicker) findViewById(R.id.SettingsActivityTimePicker);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item,
                new String[] {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"});
        adapter.setDropDownViewResource(R.layout.spinner_item);
        Spinner spinner = (Spinner) findViewById(R.id.setting_time_day_spinner);
        spinner.setAdapter(adapter);
        spinner.setSelection((int) timer.getDay());
        timePicker.setCurrentHour((int) timer.getHours());
        timePicker.setCurrentMinute((int) timer.getminutes());
    }

}
