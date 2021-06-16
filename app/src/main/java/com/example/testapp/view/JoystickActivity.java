package com.example.testapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;



import com.example.testapp.R;
import com.example.testapp.databinding.ActivityJoystickBinding;
import com.example.testapp.viewModel.AbstractViewModel;
import com.example.testapp.viewModel.ConcreteViewModel;

public class JoystickActivity extends AppCompatActivity {

    private double throttle;
    private double elevator;
    private double aileron;
    private double rudder;
    private ConcreteViewModel VM;

    @BindingAdapter({"toastMessage"})
    public static void runMe(View view, String message) {
        Log.d("myTag", "runme message");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityJoystickBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_joystick);
        VM = new ConcreteViewModel();
        VM.runModel();
        binding.setViewModel(VM);
        binding.executePendingBindings();

//        setContentView(R.layout.activity_joystick);
//        viewModel = (AbstractViewModel) getIntent().getSerializableExtra("ViewModel");

//        SeekBar th_sk = findViewById(R.id.throttleSeekBar);
//        th_sk.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            double progressChangedValue = 0;
//
//            private double progressToValue(int progress) {
//                return (double)(progress - 100) / 100;
//            }
////
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                progressChangedValue = progressToValue(progress); // progress in [0,200] to value in [-1,1]
//                TextView throttleValue = findViewById(R.id.throttleValue);
//                throttleValue.setText("" + progressChangedValue);
//
//                // Get the thumb bound and get its left value
//                int x = seekBar.getThumb().getBounds().left;
//                // set the left value to textview x value
//                throttleValue.setX(x);
//                VM.setThrottle(progressChangedValue);
//            }
//
//            public void onStartTrackingTouch(SeekBar seekBar) {
//                // TODO Auto-generated method stub
//            }
//
//            public void onStopTrackingTouch(SeekBar seekBar) {
//                // TODO Auto-generated method stub
//            }
//        });


    }

}