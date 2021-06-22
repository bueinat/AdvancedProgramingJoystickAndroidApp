package com.example.testapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import com.example.testapp.R;
import com.example.testapp.databinding.ActivityJoystickBinding;
import com.example.testapp.viewModel.ConcreteViewModel;

public class JoystickActivity extends AppCompatActivity {

    private double throttle;
    private double elevator;
    private double aileron;
    private double rudder;
    private ConcreteViewModel VM;
    private Joystick joystick;

    @BindingAdapter({"toastMessage"})
    public static void runMe(View view, String message) {
        Log.d("myTag", "runme message");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // data binding
        ActivityJoystickBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_joystick);
        VM = new ConcreteViewModel();
        VM.runModel();
        binding.setViewModel(VM);
        binding.executePendingBindings();

        joystick = (Joystick) findViewById(R.id.joystickView);

        joystick.service=(a,e)->{
            VM.setAileron(a);
            VM.setElevator(e);
        };
    }

}