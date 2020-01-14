package com.example.termostat;

import java.text.NumberFormat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class Temperature_activity extends Activity {

    public static double tempDay = 25.0;
    public static double tempNight = 15.0;

    private static double currentTempDay = 25.0;
    private static double currentTempNight = 15.0;

    public short minutes;
    public short hours;
    public short day;
    public String time_of_day;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.style.Invisible);
        setContentView(R.layout.temperature_activity);
        timer = Timer.getInstance();

        // initialization
        Button plus_day = (Button) findViewById(R.id.temperature_activity_plus_day);
        Button minus_day = (Button) findViewById(R.id.temperature_activity_minus_day);
        final SeekBar seekBar_day = (SeekBar) findViewById(R.id.temperature_activity_seekbar_day);
        Button plus_night = (Button) findViewById(R.id.temperature_activity_plus_night);
        Button minus_night = (Button) findViewById(R.id.temperature_activity_minus_night);
        final SeekBar seekBar_night = (SeekBar) findViewById(R.id.temperature_activity_seekbar_night);
        Button buttonOk = (Button) findViewById(R.id.TemperatureActivityOk);
        Button buttonCancel = (Button) findViewById(R.id.TemperatureActivityCancel);

        // listener for buttonOk
        buttonOk.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                tempNight = currentTempNight;
                tempDay = currentTempDay;
                if (Timer.getInstance().gettime_of_day().equals("Day")) {
                    Main_thermo_activity.current_temperature = tempDay;
                } else {
                    Main_thermo_activity.current_temperature = tempNight;
                }
                Intent i = new Intent(getApplicationContext(), Main_thermo_activity.class);
                finish();
                startActivity(i);
            }
        });

        // listener for buttonCancel
        buttonCancel.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                currentTempNight = tempNight;
                currentTempDay = tempDay;
                Intent i = new Intent(getApplicationContext(), Settings_activity.class);
                finish();
                startActivity(i);
            }
        });

        // listener for plus1
        plus_day.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (currentTempDay <= 29.9) {
                    currentTempDay += 0.1;
                    TextView viewCurrentTemp = (TextView) findViewById(R.id.temperature_activity_temper_day);
                    // format
                    NumberFormat formatter = NumberFormat.getNumberInstance();
                    formatter.setMinimumFractionDigits(1);
                    formatter.setMaximumFractionDigits(1);
                    String s = formatter.format(currentTempDay);
                    viewCurrentTemp.setText(String.valueOf(s + "\u2103"));
                    // move seekBar
                    seekBar_day.setProgress(seekBar_day.getProgress() + 1);
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Temperature can not be higher than 30\u2103",
                            Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        // listener for minus1
        minus_day.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (currentTempDay >= 5.1) {
                    currentTempDay -= 0.1;
                    TextView viewCurrentTemp = (TextView) findViewById(R.id.temperature_activity_temper_day);
                    // format
                    NumberFormat formatter = NumberFormat.getNumberInstance();
                    formatter.setMinimumFractionDigits(1);
                    formatter.setMaximumFractionDigits(1);
                    String s = formatter.format(currentTempDay);
                    viewCurrentTemp.setText(String.valueOf(s + "\u2103"));
                    // move seekBar
                    seekBar_day.setProgress(seekBar_day.getProgress() - 1);
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Temperature can not be less than 5\u2103",
                            Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });

        // listener for plus2
        plus_night.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (currentTempNight <= 29.9) {
                    currentTempNight += 0.1;
                    TextView viewCurrentTemp = (TextView) findViewById(R.id.temperature_activity_temper_night);
                    // format
                    NumberFormat formatter = NumberFormat.getNumberInstance();
                    formatter.setMinimumFractionDigits(1);
                    formatter.setMaximumFractionDigits(1);
                    String s = formatter.format(currentTempNight);
                    viewCurrentTemp.setText(String.valueOf(s + "\u2103"));
                    // move seekBar
                    seekBar_night.setProgress(seekBar_night.getProgress() + 1);
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Temperature can not be higher than 30\u2103",
                            Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        // listener for minus2
        minus_night.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (currentTempNight >= 5.1) {
                    currentTempNight -= 0.1;
                    TextView viewCurrentTemp = (TextView) findViewById(R.id.temperature_activity_temper_night);
                    // format
                    NumberFormat formatter = NumberFormat.getNumberInstance();
                    formatter.setMinimumFractionDigits(1);
                    formatter.setMaximumFractionDigits(1);
                    String s = formatter.format(currentTempNight);
                    viewCurrentTemp.setText(String.valueOf(s + "\u2103"));
                    // move seekBar
                    seekBar_night.setProgress(seekBar_night.getProgress() - 1);
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Temperature can not be less than 5\u2103",
                            Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });

        // listener for seekBar1
        seekBar_day.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

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
                TextView viewCurrentTemp = (TextView) findViewById(R.id.temperature_activity_temper_day);
                int intCurrentValue = seekBar_day.getProgress();
                currentTempDay = ((double) intCurrentValue + 50) / 10;

                NumberFormat formatter = NumberFormat.getNumberInstance();
                formatter.setMinimumFractionDigits(1);
                formatter.setMaximumFractionDigits(1);
                String s = formatter.format(currentTempDay);

                viewCurrentTemp.setText(String.valueOf(s + "\u2103"));

            }
        });

        // listener for seekBar2
        seekBar_night.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

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
                TextView viewCurrentTemp = (TextView) findViewById(R.id.temperature_activity_temper_night);
                int intCurrentValue = seekBar_night.getProgress();
                currentTempNight = ((double) intCurrentValue + 50) / 10;

                NumberFormat formatter = NumberFormat.getNumberInstance();
                formatter.setMinimumFractionDigits(1);
                formatter.setMaximumFractionDigits(1);
                String s = formatter.format(currentTempNight);

                viewCurrentTemp.setText(String.valueOf(s + "\u2103"));

            }
        });

        update_time();
    }

    private void update_time() {
        final Handler handler = new Handler();

        final Runnable r = new Runnable() {
            public void run() {
                time_of_day = timer.gettime_of_day();

                if (time_of_day.equals("Day")) {

                    TextView currentMode = (TextView) findViewById(R.id.temperature_activity_current_mode);
                    currentMode.setText(String.valueOf("Day"
                            + " "
                            + Temperature_activity
                            .get_temperature(Main_thermo_activity.current_temperature)));

                }

                if (time_of_day.equals("Night")) {

                    TextView currentMode = (TextView) findViewById(R.id.temperature_activity_current_mode);
                    currentMode.setText(String.valueOf("Night"
                            + " "
                            + Temperature_activity
                            .get_temperature(Main_thermo_activity.current_temperature)));

                }

                TextView currentTime = (TextView) findViewById(R.id.temperature_activity_current_time);

                NumberFormat formatter = NumberFormat.getNumberInstance();
                formatter.setMinimumIntegerDigits(2);
                formatter.setMaximumIntegerDigits(2);
                String minutes = formatter.format(timer.getminutes());
                String HOURS = formatter.format(timer.getHours());

                currentTime.setText(String.valueOf(Days.getDayById(timer.getDay()) + " " + HOURS
                        + ":" + minutes));
                handler.postDelayed(this, 200);
            }
        };
        handler.postDelayed(r, 200);
    }

    @Override
    protected void onStart() {
        super.onStart();
        SeekBar seekBar1 = (SeekBar) findViewById(R.id.temperature_activity_seekbar_day);
        TextView viewCurrentTemp1 = (TextView) findViewById(R.id.temperature_activity_temper_day);
        SeekBar seekBar2 = (SeekBar) findViewById(R.id.temperature_activity_seekbar_night);
        TextView viewCurrentTemp2 = (TextView) findViewById(R.id.temperature_activity_temper_night);
        seekBar1.setProgress((int) (tempDay * 10) - 50);
        seekBar2.setProgress((int) (tempNight * 10) - 50);

        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMinimumFractionDigits(1);
        formatter.setMaximumFractionDigits(1);
        String s1 = formatter.format(tempDay);
        String s2 = formatter.format(tempNight);

        viewCurrentTemp1.setText(String.valueOf(s1 + "\u2103"));
        viewCurrentTemp2.setText(String.valueOf(s2 + "\u2103"));
    }

    public static String get_temperature(double temp) {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMinimumFractionDigits(1);
        formatter.setMaximumFractionDigits(1);
        String s;
        s = formatter.format(temp);
        return String.valueOf(s + "\u2103");
    }
}
