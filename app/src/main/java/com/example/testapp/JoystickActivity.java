package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;

public class JoystickActivity extends AppCompatActivity {

    private double throttle;
    private double elevator;
    private double aileron;
    private double rudder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joystick);

        SeekBar th_sk = findViewById(R.id.throttleSeekBar);
        th_sk.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            double progressChangedValue = 0;

            private double progressToValue(int progress) {
                return (double)(progress - 100) / 100;
            }
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progressToValue(progress); // progress in [0,200] to value in [-1,1]

            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
//                Toast.makeText(MainActivity.this, "Seek bar progress is :" + progressChangedValue,
//                        Toast.LENGTH_SHORT).show();
            }
        });


    }

}