package com.example.termostat;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TimePicker;

public class Switch_dialog extends DialogFragment {
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Timer timer = Timer.getInstance();
        View myDialog = getActivity().getLayoutInflater().inflate(
                R.layout.custom_switch_dialog, null);
        final TimePicker switchTimePicker = (TimePicker) myDialog
                .findViewById(R.id.custom_switch_time_pciker);
        switchTimePicker.setCurrentHour((int) timer.getHours());
        switchTimePicker.setCurrentMinute((int) timer.getminutes());
        final Switch modeSwitcher = (Switch) myDialog
                .findViewById(R.id.custom_switch);
        switchTimePicker.setIs24HourView(true);
        return new AlertDialog.Builder(getActivity())
                .setView(myDialog)
                .setTitle("Add a new switch")
                .setPositiveButton("ADD",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                String mode = modeSwitcher.isChecked() ? "Day"
                                        : "Night";
                                Day_activity.addSwitch(new Switch_mode(mode,
                                        switchTimePicker.getCurrentHour(),
                                        switchTimePicker.getCurrentMinute()));
                            }
                        }
                )
                .setNegativeButton("CANCEL",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Switch_dialog.this.getDialog().cancel();
                            }
                        }
                ).create();
    }
}
