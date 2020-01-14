package com.example.termostat;

import java.text.NumberFormat;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Main_thermo_activity extends Activity {

    public static double current_temperature = Temperature_activity.tempDay;

    public static boolean change = false;
    public static String time_of_day;
    public static boolean enabled = true;
    public short minutes;
    public short hours;
    public short day;

    private Timer timer;


    TextView nextSwitch;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.start, menu);

        // Get widget's instance
        final Switch switcher = (Switch) menu.findItem(R.id.start).getActionView().findViewById(R.id.mode_switch);
        switcher.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (enabled) {
                    enabled = false;
                    TextView currentMode = (TextView) findViewById(R.id.main_current_mode);
                    currentMode.setText(String.valueOf(Temperature_activity
                            .get_temperature(Main_thermo_activity.current_temperature)));
                    TextView nextSwitch = (TextView) findViewById(R.id.main_next_switch);
                    nextSwitch.setText("vacation mode enabled");
                } else {
                    TextView nextSwitch = (TextView) findViewById(R.id.main_next_switch);
                    nextSwitch.setText(Schedule.getInstance().getNextSwitch());
                    nextSwitch.setTextColor(Color.parseColor(("#1f71df")));
                    TextView currentMode = (TextView) findViewById(R.id.main_current_mode);
                    currentMode.setText(String.valueOf(time_of_day
                            + " "
                            + Temperature_activity
                            .get_temperature(Main_thermo_activity.current_temperature)));

                    TextView viewCurrentTemp = (TextView) findViewById(R.id.main_current_temperature_big);
                    // format
                    NumberFormat formatter = NumberFormat.getNumberInstance();
                    formatter.setMinimumFractionDigits(1);
                    formatter.setMaximumFractionDigits(1);

                    if (change) {
                        current_temperature = Temperature_activity.tempNight;
                        change = false;
                    }
                    enabled = true;
                    String s = formatter.format(current_temperature);
                    viewCurrentTemp.setText(String.valueOf(s + "\u2103"));

                    seekBar.setProgress((int) (current_temperature * 10 - 50));
                }
            }
        });

        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        timer = Timer.getInstance();
        set_views();
        update_time();

    }

    private void set_views() {
        // find buttons
        final Button plus = (Button) findViewById(R.id.main_plus);
        final Button minus = (Button) findViewById(R.id.main_minus);
        final SeekBar seekBar = (SeekBar) findViewById(R.id.main_switcher);
        final Button setting = (Button) findViewById(R.id.setting_button);

        plus.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (current_temperature <= 29.9) {
                    current_temperature += 0.1;
                    TextView viewCurrentTemp = (TextView) findViewById(R.id.main_current_temperature_big);
                    // format
                    NumberFormat formatter = NumberFormat.getNumberInstance();
                    formatter.setMinimumFractionDigits(1);
                    formatter.setMaximumFractionDigits(1);
                    String s = formatter.format(current_temperature);
                    viewCurrentTemp.setText(String.valueOf(s + "\u2103"));
                    // move seekBar
                    seekBar.setProgress(seekBar.getProgress() + 1);

                    if (enabled) {
                        TextView currentMode = (TextView) findViewById(R.id.main_current_mode);
                        currentMode.setText(String.valueOf(time_of_day
                                + " "
                                + Temperature_activity
                                .get_temperature(Main_thermo_activity.current_temperature)));
                    } else {
                        TextView currentMode = (TextView) findViewById(R.id.main_current_mode);
                        currentMode.setText(String.valueOf(Temperature_activity
                                .get_temperature(Main_thermo_activity.current_temperature)));
                    }
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Temperature can not be higher than 30\u2103",
                            Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        // listener for minus
        minus.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (current_temperature >= 5.1) {
                    current_temperature -= 0.1;
                    TextView viewCurrentTemp = (TextView) findViewById(R.id.main_current_temperature_big);
                    // format
                    NumberFormat formatter = NumberFormat.getNumberInstance();
                    formatter.setMinimumFractionDigits(1);
                    formatter.setMaximumFractionDigits(1);
                    String s = formatter.format(current_temperature);
                    viewCurrentTemp.setText(String.valueOf(s + "\u2103"));
                    // move seekBar
                    seekBar.setProgress(seekBar.getProgress() - 1);

                    if (enabled) {
                        TextView currentMode = (TextView) findViewById(R.id.main_current_mode);
                        currentMode.setText(String.valueOf(time_of_day
                                + " "
                                + Temperature_activity
                                .get_temperature(Main_thermo_activity.current_temperature)));
                    } else {
                        TextView currentMode = (TextView) findViewById(R.id.main_current_mode);
                        currentMode.setText(String.valueOf(Temperature_activity
                                .get_temperature(Main_thermo_activity.current_temperature)));
                    }
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Temperature can not be less than 5\u2103",
                            Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });

        setting.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), Settings_activity.class);
                startActivity(i);
            }
        });

        // listener for seekBar
        seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // ignore
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // ignore
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {

                int intCurrentValue = seekBar.getProgress();
                current_temperature = (double) ((double) intCurrentValue + 50) / 10;

                TextView viewCurrentTemp = (TextView) findViewById(R.id.main_current_temperature_big);
                NumberFormat formatter = NumberFormat.getNumberInstance();
                formatter.setMinimumFractionDigits(1);
                formatter.setMaximumFractionDigits(1);
                String s = formatter.format(current_temperature);

                viewCurrentTemp.setText(String.valueOf(s + "\u2103"));

                if (enabled) {
                    TextView currentMode = (TextView) findViewById(R.id.main_current_mode);
                    currentMode.setText(String.valueOf(time_of_day
                            + " "
                            + Temperature_activity
                            .get_temperature(Main_thermo_activity.current_temperature)));
                } else {
                    TextView currentMode = (TextView) findViewById(R.id.main_current_mode);
                    currentMode.setText(String.valueOf(Temperature_activity
                            .get_temperature(Main_thermo_activity.current_temperature)));

                }

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        seekBar = (SeekBar) findViewById(R.id.main_switcher);

        // enabled
        if (!enabled) {
            seekBar.setProgress((int) (Main_thermo_activity.current_temperature * 10 - 50));

            TextView currentMode = (TextView) findViewById(R.id.main_current_mode);
            currentMode.setText(String.valueOf(Temperature_activity
                    .get_temperature(Main_thermo_activity.current_temperature)));

            nextSwitch = (TextView) findViewById(R.id.main_next_switch);
            nextSwitch.setText("");

        } else {
            nextSwitch = (TextView) findViewById(R.id.main_next_switch);
            nextSwitch.setText(Schedule.getInstance().getNextSwitch());

            seekBar.setProgress((int) (Main_thermo_activity.current_temperature * 10 - 50));

            TextView viewCurrentTemp = (TextView) findViewById(R.id.main_current_temperature_big);

            NumberFormat formatter = NumberFormat.getNumberInstance();
            formatter.setMinimumFractionDigits(1);
            formatter.setMaximumFractionDigits(1);
            String s = formatter.format(current_temperature);

            viewCurrentTemp.setText(String.valueOf(s + "\u2103"));
            TextView currentMode = (TextView) findViewById(R.id.main_current_mode);
            currentMode.setText(String.valueOf(time_of_day + " "
                    + Temperature_activity.get_temperature(Main_thermo_activity.current_temperature)));
        }

    }

    private void update_time() {
        final Handler handler = new Handler();

        final Runnable r = new Runnable() {
            public void run() {
                minutes = timer.getminutes();
                hours = timer.getHours();
                day = timer.getDay();
                time_of_day = timer.gettime_of_day();

                TextView viewCurrentTemp = (TextView) findViewById(R.id.main_current_temperature_big);
                if(enabled)
                if (Timer.getInstance().gettime_of_day() == "Day") {
                    viewCurrentTemp.setBackgroundResource(R.drawable.sunny_day);
                    viewCurrentTemp.setTextColor(Color.parseColor("#1f71df"));
                } else {
                    viewCurrentTemp.setBackgroundResource(R.drawable.moon);
                    viewCurrentTemp.setTextColor(Color.WHITE);
                } else {
                    viewCurrentTemp.setBackgroundResource(R.drawable.white);
                    viewCurrentTemp.setTextColor(Color.parseColor("#1f71df"));
                }

                if (enabled) {
                    Schedule.getInstance().make_changes(minutes, hours, day);

                    nextSwitch = (TextView) findViewById(R.id.main_next_switch);
                    nextSwitch.setText(Schedule.getInstance().getNextSwitch());

                    seekBar.setProgress((int) (Main_thermo_activity.current_temperature * 10 - 50));

                    TextView currentMode = (TextView) findViewById(R.id.main_current_mode);
                    currentMode.setText(String.valueOf(time_of_day
                            + " "
                            + Temperature_activity
                            .get_temperature(Main_thermo_activity.current_temperature)));
                }
                if (time_of_day.equals("Night") && minutes < 1 && hours == 00) {

                    if (enabled) {
                        current_temperature = Temperature_activity.tempNight;
                        seekBar.setProgress((int) (current_temperature * 10 - 50));

                        TextView current_temperature = (TextView) findViewById(R.id.main_current_temperature_big);
                        NumberFormat formatter = NumberFormat
                                .getNumberInstance();
                        formatter.setMinimumFractionDigits(1);
                        formatter.setMaximumFractionDigits(1);
                        String s = formatter
                                .format(Temperature_activity.tempNight);
                        current_temperature.setText(String.valueOf(s + "\u2103"));

                    } else {
                        change = true;
                    }
                }
                if (time_of_day.equals("Day") && minutes < 1 && hours == 12) {

                    if (enabled) {
                        current_temperature = Temperature_activity.tempNight;
                        seekBar.setProgress((int) (current_temperature * 10 - 50));

                        TextView current_temperature = (TextView) findViewById(R.id.main_current_temperature_big);
                        NumberFormat formatter = NumberFormat
                                .getNumberInstance();
                        formatter.setMinimumFractionDigits(1);
                        formatter.setMaximumFractionDigits(1);
                        String s = formatter
                                .format(Temperature_activity.tempDay);
                        current_temperature.setText(String.valueOf(s + "\u2103"));

                    } else {
                        change = true;
                    }
                }

                TextView current_time = (TextView) findViewById(R.id.main_current_time);

                NumberFormat formatter = NumberFormat.getNumberInstance();
                formatter.setMinimumIntegerDigits(2);
                formatter.setMaximumIntegerDigits(2);


                String HOURS = formatter.format(timer.getHours());
                String minutes = formatter.format(timer.getminutes());
                current_time.setText(String.valueOf(Days.getDayById(timer.getDay()) + " " + HOURS
                        + ":" + minutes));

                handler.postDelayed(this, 200);
            }
        };
        handler.postDelayed(r, 200);
    }

    SeekBar seekBar;
}
